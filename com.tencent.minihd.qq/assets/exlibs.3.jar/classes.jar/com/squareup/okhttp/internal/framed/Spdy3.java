package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Okio;

public final class Spdy3
  implements Variant
{
  static final byte[] DICTIONARY;
  static final int FLAG_FIN = 1;
  static final int FLAG_UNIDIRECTIONAL = 2;
  static final int TYPE_DATA = 0;
  static final int TYPE_GOAWAY = 7;
  static final int TYPE_HEADERS = 8;
  static final int TYPE_PING = 6;
  static final int TYPE_RST_STREAM = 3;
  static final int TYPE_SETTINGS = 4;
  static final int TYPE_SYN_REPLY = 2;
  static final int TYPE_SYN_STREAM = 1;
  static final int TYPE_WINDOW_UPDATE = 9;
  static final int VERSION = 3;
  
  static
  {
    try
    {
      DICTIONARY = "".getBytes(Util.UTF_8.name());
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError();
    }
  }
  
  public Protocol getProtocol()
  {
    return Protocol.SPDY_3;
  }
  
  public FrameReader newReader(BufferedSource paramBufferedSource, boolean paramBoolean)
  {
    return new Reader(paramBufferedSource, paramBoolean);
  }
  
  public FrameWriter newWriter(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    return new Writer(paramBufferedSink, paramBoolean);
  }
  
  static final class Reader
    implements FrameReader
  {
    private final boolean client;
    private final NameValueBlockReader headerBlockReader;
    private final BufferedSource source;
    
    Reader(BufferedSource paramBufferedSource, boolean paramBoolean)
    {
      this.source = paramBufferedSource;
      this.headerBlockReader = new NameValueBlockReader(this.source);
      this.client = paramBoolean;
    }
    
    private static IOException ioException(String paramString, Object... paramVarArgs)
      throws IOException
    {
      throw new IOException(String.format(paramString, paramVarArgs));
    }
    
    private void readGoAway(FrameReader.Handler paramHandler, int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt2 != 8) {
        throw ioException("TYPE_GOAWAY length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramInt1 = this.source.readInt();
      paramInt2 = this.source.readInt();
      ErrorCode localErrorCode = ErrorCode.fromSpdyGoAway(paramInt2);
      if (localErrorCode == null) {
        throw ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramHandler.goAway(paramInt1 & 0x7FFFFFFF, localErrorCode, ByteString.EMPTY);
    }
    
    private void readHeaders(FrameReader.Handler paramHandler, int paramInt1, int paramInt2)
      throws IOException
    {
      paramHandler.headers(false, false, this.source.readInt() & 0x7FFFFFFF, -1, this.headerBlockReader.readNameValueBlock(paramInt2 - 4), HeadersMode.SPDY_HEADERS);
    }
    
    private void readPing(FrameReader.Handler paramHandler, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool2 = true;
      if (paramInt2 != 4) {
        throw ioException("TYPE_PING length: %d != 4", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramInt1 = this.source.readInt();
      boolean bool3 = this.client;
      if ((paramInt1 & 0x1) == 1)
      {
        bool1 = true;
        if (bool3 != bool1) {
          break label79;
        }
      }
      label79:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramHandler.ping(bool1, paramInt1, 0);
        return;
        bool1 = false;
        break;
      }
    }
    
    private void readRstStream(FrameReader.Handler paramHandler, int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt2 != 8) {
        throw ioException("TYPE_RST_STREAM length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramInt1 = this.source.readInt();
      paramInt2 = this.source.readInt();
      ErrorCode localErrorCode = ErrorCode.fromSpdy3Rst(paramInt2);
      if (localErrorCode == null) {
        throw ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramHandler.rstStream(paramInt1 & 0x7FFFFFFF, localErrorCode);
    }
    
    private void readSettings(FrameReader.Handler paramHandler, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool = true;
      int i = this.source.readInt();
      if (paramInt2 != i * 8 + 4) {
        throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(i) });
      }
      Settings localSettings = new Settings();
      paramInt2 = 0;
      while (paramInt2 < i)
      {
        int j = this.source.readInt();
        localSettings.set(j & 0xFFFFFF, (0xFF000000 & j) >>> 24, this.source.readInt());
        paramInt2 += 1;
      }
      if ((paramInt1 & 0x1) != 0) {}
      for (;;)
      {
        paramHandler.settings(bool, localSettings);
        return;
        bool = false;
      }
    }
    
    private void readSynReply(FrameReader.Handler paramHandler, int paramInt1, int paramInt2)
      throws IOException
    {
      int i = this.source.readInt();
      List localList = this.headerBlockReader.readNameValueBlock(paramInt2 - 4);
      if ((paramInt1 & 0x1) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramHandler.headers(false, bool, i & 0x7FFFFFFF, -1, localList, HeadersMode.SPDY_REPLY);
        return;
      }
    }
    
    private void readSynStream(FrameReader.Handler paramHandler, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool2 = true;
      int i = this.source.readInt();
      int j = this.source.readInt();
      this.source.readShort();
      List localList = this.headerBlockReader.readNameValueBlock(paramInt2 - 10);
      boolean bool1;
      if ((paramInt1 & 0x1) != 0)
      {
        bool1 = true;
        if ((paramInt1 & 0x2) == 0) {
          break label95;
        }
      }
      for (;;)
      {
        paramHandler.headers(bool2, bool1, i & 0x7FFFFFFF, j & 0x7FFFFFFF, localList, HeadersMode.SPDY_SYN_STREAM);
        return;
        bool1 = false;
        break;
        label95:
        bool2 = false;
      }
    }
    
    private void readWindowUpdate(FrameReader.Handler paramHandler, int paramInt1, int paramInt2)
      throws IOException
    {
      if (paramInt2 != 8) {
        throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] { Integer.valueOf(paramInt2) });
      }
      paramInt1 = this.source.readInt();
      long l = this.source.readInt() & 0x7FFFFFFF;
      if (l == 0L) {
        throw ioException("windowSizeIncrement was 0", new Object[] { Long.valueOf(l) });
      }
      paramHandler.windowUpdate(paramInt1 & 0x7FFFFFFF, l);
    }
    
    public void close()
      throws IOException
    {
      this.headerBlockReader.close();
    }
    
    public boolean nextFrame(FrameReader.Handler paramHandler)
      throws IOException
    {
      boolean bool = false;
      int j;
      int k;
      int m;
      for (;;)
      {
        try
        {
          j = this.source.readInt();
          k = this.source.readInt();
          if ((0x80000000 & j) != 0)
          {
            i = 1;
            m = (0xFF000000 & k) >>> 24;
            k &= 0xFFFFFF;
            if (i == 0) {
              break label258;
            }
            i = (0x7FFF0000 & j) >>> 16;
            if (i == 3) {
              break;
            }
            throw new ProtocolException("version != 3: " + i);
          }
        }
        catch (IOException paramHandler)
        {
          return false;
        }
        int i = 0;
      }
      switch (j & 0xFFFF)
      {
      case 5: 
      default: 
        this.source.skip(k);
        return true;
      case 1: 
        readSynStream(paramHandler, m, k);
        return true;
      case 2: 
        readSynReply(paramHandler, m, k);
        return true;
      case 3: 
        readRstStream(paramHandler, m, k);
        return true;
      case 4: 
        readSettings(paramHandler, m, k);
        return true;
      case 6: 
        readPing(paramHandler, m, k);
        return true;
      case 7: 
        readGoAway(paramHandler, m, k);
        return true;
      case 8: 
        readHeaders(paramHandler, m, k);
        return true;
      }
      readWindowUpdate(paramHandler, m, k);
      return true;
      label258:
      if ((m & 0x1) != 0) {
        bool = true;
      }
      paramHandler.data(bool, j & 0x7FFFFFFF, this.source, k);
      return true;
    }
    
    public void readConnectionPreface() {}
  }
  
  static final class Writer
    implements FrameWriter
  {
    private final boolean client;
    private boolean closed;
    private final Buffer headerBlockBuffer;
    private final BufferedSink headerBlockOut;
    private final BufferedSink sink;
    
    Writer(BufferedSink paramBufferedSink, boolean paramBoolean)
    {
      this.sink = paramBufferedSink;
      this.client = paramBoolean;
      paramBufferedSink = new Deflater();
      paramBufferedSink.setDictionary(Spdy3.DICTIONARY);
      this.headerBlockBuffer = new Buffer();
      this.headerBlockOut = Okio.buffer(new DeflaterSink(this.headerBlockBuffer, paramBufferedSink));
    }
    
    private void writeNameValueBlockToBuffer(List<Header> paramList)
      throws IOException
    {
      this.headerBlockOut.writeInt(paramList.size());
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        ByteString localByteString = ((Header)paramList.get(i)).name;
        this.headerBlockOut.writeInt(localByteString.size());
        this.headerBlockOut.write(localByteString);
        localByteString = ((Header)paramList.get(i)).value;
        this.headerBlockOut.writeInt(localByteString.size());
        this.headerBlockOut.write(localByteString);
        i += 1;
      }
      this.headerBlockOut.flush();
    }
    
    public void ackSettings(Settings paramSettings) {}
    
    public void close()
      throws IOException
    {
      try
      {
        this.closed = true;
        Util.closeAll(this.sink, this.headerBlockOut);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void connectionPreface() {}
    
    public void data(boolean paramBoolean, int paramInt1, Buffer paramBuffer, int paramInt2)
      throws IOException
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0) {
        try
        {
          sendDataFrame(paramInt1, i, paramBuffer, paramInt2);
          return;
        }
        finally {}
      }
    }
    
    public void flush()
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      this.sink.flush();
    }
    
    public void goAway(int paramInt, ErrorCode paramErrorCode, byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramErrorCode.spdyGoAwayCode == -1) {
        throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
      }
      this.sink.writeInt(-2147287033);
      this.sink.writeInt(8);
      this.sink.writeInt(paramInt);
      this.sink.writeInt(paramErrorCode.spdyGoAwayCode);
      this.sink.flush();
    }
    
    public void headers(int paramInt, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      writeNameValueBlockToBuffer(paramList);
      int i = (int)(this.headerBlockBuffer.size() + 4L);
      this.sink.writeInt(-2147287032);
      this.sink.writeInt(0xFFFFFF & i | 0x0);
      this.sink.writeInt(0x7FFFFFFF & paramInt);
      this.sink.writeAll(this.headerBlockBuffer);
    }
    
    public int maxDataLength()
    {
      return 16383;
    }
    
    public void ping(boolean paramBoolean, int paramInt1, int paramInt2)
      throws IOException
    {
      boolean bool2 = true;
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      boolean bool3 = this.client;
      boolean bool1;
      if ((paramInt1 & 0x1) == 1) {
        bool1 = true;
      }
      for (;;)
      {
        if (paramBoolean != bool1) {
          throw new IllegalArgumentException("payload != reply");
        }
        this.sink.writeInt(-2147287034);
        this.sink.writeInt(4);
        this.sink.writeInt(paramInt1);
        this.sink.flush();
        return;
        for (;;)
        {
          if (bool3 == bool1) {
            break label130;
          }
          bool1 = bool2;
          break;
          bool1 = false;
        }
        label130:
        bool1 = false;
      }
    }
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {}
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if (paramErrorCode.spdyRstCode == -1) {
        throw new IllegalArgumentException();
      }
      this.sink.writeInt(-2147287037);
      this.sink.writeInt(8);
      this.sink.writeInt(0x7FFFFFFF & paramInt);
      this.sink.writeInt(paramErrorCode.spdyRstCode);
      this.sink.flush();
    }
    
    void sendDataFrame(int paramInt1, int paramInt2, Buffer paramBuffer, int paramInt3)
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      if (paramInt3 > 16777215L) {
        throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + paramInt3);
      }
      this.sink.writeInt(0x7FFFFFFF & paramInt1);
      this.sink.writeInt((paramInt2 & 0xFF) << 24 | 0xFFFFFF & paramInt3);
      if (paramInt3 > 0) {
        this.sink.write(paramBuffer, paramInt3);
      }
    }
    
    public void settings(Settings paramSettings)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      int i = paramSettings.size();
      this.sink.writeInt(-2147287036);
      this.sink.writeInt(i * 8 + 4 & 0xFFFFFF | 0x0);
      this.sink.writeInt(i);
      i = 0;
      for (;;)
      {
        if (i <= 10)
        {
          if (paramSettings.isSet(i))
          {
            int j = paramSettings.flags(i);
            this.sink.writeInt((j & 0xFF) << 24 | i & 0xFFFFFF);
            this.sink.writeInt(paramSettings.get(i));
          }
        }
        else
        {
          this.sink.flush();
          return;
        }
        i += 1;
      }
    }
    
    public void synReply(boolean paramBoolean, int paramInt, List<Header> paramList)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      writeNameValueBlockToBuffer(paramList);
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        int j = (int)(this.headerBlockBuffer.size() + 4L);
        this.sink.writeInt(-2147287038);
        this.sink.writeInt((i & 0xFF) << 24 | 0xFFFFFF & j);
        this.sink.writeInt(0x7FFFFFFF & paramInt);
        this.sink.writeAll(this.headerBlockBuffer);
        this.sink.flush();
        return;
      }
    }
    
    public void synStream(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, List<Header> paramList)
      throws IOException
    {
      int j = 0;
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      writeNameValueBlockToBuffer(paramList);
      int k = (int)(10L + this.headerBlockBuffer.size());
      int i;
      if (paramBoolean1) {
        i = 1;
      }
      for (;;)
      {
        this.sink.writeInt(-2147287039);
        this.sink.writeInt(((i | j) & 0xFF) << 24 | 0xFFFFFF & k);
        this.sink.writeInt(paramInt1 & 0x7FFFFFFF);
        this.sink.writeInt(paramInt2 & 0x7FFFFFFF);
        this.sink.writeShort(0);
        this.sink.writeAll(this.headerBlockBuffer);
        this.sink.flush();
        return;
        i = 0;
        if (paramBoolean2) {
          j = 2;
        }
      }
    }
    
    public void windowUpdate(int paramInt, long paramLong)
      throws IOException
    {
      try
      {
        if (this.closed) {
          throw new IOException("closed");
        }
      }
      finally {}
      if ((paramLong == 0L) || (paramLong > 2147483647L)) {
        throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + paramLong);
      }
      this.sink.writeInt(-2147287031);
      this.sink.writeInt(8);
      this.sink.writeInt(paramInt);
      this.sink.writeInt((int)paramLong);
      this.sink.flush();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.Spdy3
 * JD-Core Version:    0.7.0.1
 */