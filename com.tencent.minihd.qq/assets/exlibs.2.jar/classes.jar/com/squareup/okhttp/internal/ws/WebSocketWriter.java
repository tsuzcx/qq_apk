package com.squareup.okhttp.internal.ws;

import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Timeout;

public final class WebSocketWriter
{
  private boolean activeWriter;
  private final Buffer buffer = new Buffer();
  private final FrameSink frameSink = new FrameSink(null);
  private final boolean isClient;
  private final byte[] maskBuffer;
  private final byte[] maskKey;
  private final Random random;
  private final BufferedSink sink;
  private boolean writerClosed;
  
  static
  {
    if (!WebSocketWriter.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public WebSocketWriter(boolean paramBoolean, BufferedSink paramBufferedSink, Random paramRandom)
  {
    if (paramBufferedSink == null) {
      throw new NullPointerException("sink == null");
    }
    if (paramRandom == null) {
      throw new NullPointerException("random == null");
    }
    this.isClient = paramBoolean;
    this.sink = paramBufferedSink;
    this.random = paramRandom;
    if (paramBoolean) {}
    for (paramBufferedSink = new byte[4];; paramBufferedSink = null)
    {
      this.maskKey = paramBufferedSink;
      paramBufferedSink = localObject;
      if (paramBoolean) {
        paramBufferedSink = new byte[2048];
      }
      this.maskBuffer = paramBufferedSink;
      return;
    }
  }
  
  private void writeControlFrameSynchronized(int paramInt, Buffer paramBuffer)
    throws IOException
  {
    assert (Thread.holdsLock(this));
    if (this.writerClosed) {
      throw new IOException("closed");
    }
    int i = 0;
    if (paramBuffer != null)
    {
      int j = (int)paramBuffer.size();
      i = j;
      if (j > 125L) {
        throw new IllegalArgumentException("Payload size must be less than or equal to 125");
      }
    }
    this.sink.writeByte(paramInt | 0x80);
    if (this.isClient)
    {
      this.sink.writeByte(i | 0x80);
      this.random.nextBytes(this.maskKey);
      this.sink.write(this.maskKey);
      if (paramBuffer != null) {
        writeMaskedSynchronized(paramBuffer, i);
      }
    }
    for (;;)
    {
      this.sink.emit();
      return;
      this.sink.writeByte(i);
      if (paramBuffer != null) {
        this.sink.writeAll(paramBuffer);
      }
    }
  }
  
  private void writeMaskedSynchronized(BufferedSource paramBufferedSource, long paramLong)
    throws IOException
  {
    assert (Thread.holdsLock(this));
    int i;
    for (long l = 0L; l < paramLong; l += i)
    {
      i = (int)Math.min(paramLong, this.maskBuffer.length);
      i = paramBufferedSource.read(this.maskBuffer, 0, i);
      if (i == -1) {
        throw new AssertionError();
      }
      WebSocketProtocol.toggleMask(this.maskBuffer, i, this.maskKey, l);
      this.sink.write(this.maskBuffer, 0, i);
    }
  }
  
  private void writeMessageFrameSynchronized(int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    assert (Thread.holdsLock(this));
    if (this.writerClosed) {
      throw new IOException("closed");
    }
    if (paramBoolean1)
    {
      int i = paramInt;
      if (paramBoolean2) {
        i = paramInt | 0x80;
      }
      this.sink.writeByte(i);
      paramInt = 0;
      if (this.isClient)
      {
        paramInt = 0x0 | 0x80;
        this.random.nextBytes(this.maskKey);
      }
      if (paramLong > 125L) {
        break label168;
      }
      i = (int)paramLong;
      this.sink.writeByte(paramInt | i);
      label122:
      if (!this.isClient) {
        break label233;
      }
      this.sink.write(this.maskKey);
      writeMaskedSynchronized(this.buffer, paramLong);
    }
    for (;;)
    {
      this.sink.emit();
      return;
      paramInt = 0;
      break;
      label168:
      if (paramLong <= 65535L)
      {
        this.sink.writeByte(paramInt | 0x7E);
        this.sink.writeShort((int)paramLong);
        break label122;
      }
      this.sink.writeByte(paramInt | 0x7F);
      this.sink.writeLong(paramLong);
      break label122;
      label233:
      this.sink.write(this.buffer, paramLong);
    }
  }
  
  public Sink newMessageSink(int paramInt)
  {
    if (this.activeWriter) {
      throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }
    this.activeWriter = true;
    FrameSink.access$102(this.frameSink, paramInt);
    FrameSink.access$202(this.frameSink, true);
    FrameSink.access$302(this.frameSink, false);
    return this.frameSink;
  }
  
  public void writeClose(int paramInt, String paramString)
    throws IOException
  {
    Object localObject = null;
    if ((paramInt != 0) || (paramString != null))
    {
      if ((paramInt != 0) && ((paramInt < 1000) || (paramInt >= 5000))) {
        throw new IllegalArgumentException("Code must be in range [1000,5000).");
      }
      Buffer localBuffer = new Buffer();
      localBuffer.writeShort(paramInt);
      localObject = localBuffer;
      if (paramString != null)
      {
        localBuffer.writeUtf8(paramString);
        localObject = localBuffer;
      }
    }
    try
    {
      writeControlFrameSynchronized(8, localObject);
      this.writerClosed = true;
      return;
    }
    finally {}
  }
  
  public void writePing(Buffer paramBuffer)
    throws IOException
  {
    try
    {
      writeControlFrameSynchronized(9, paramBuffer);
      return;
    }
    finally {}
  }
  
  public void writePong(Buffer paramBuffer)
    throws IOException
  {
    try
    {
      writeControlFrameSynchronized(10, paramBuffer);
      return;
    }
    finally {}
  }
  
  private final class FrameSink
    implements Sink
  {
    private boolean closed;
    private int formatOpcode;
    private boolean isFirstFrame;
    
    private FrameSink() {}
    
    public void close()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      synchronized (WebSocketWriter.this)
      {
        WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, true);
        this.closed = true;
        WebSocketWriter.access$702(WebSocketWriter.this, false);
        return;
      }
    }
    
    public void flush()
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      synchronized (WebSocketWriter.this)
      {
        WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, WebSocketWriter.this.buffer.size(), this.isFirstFrame, false);
        this.isFirstFrame = false;
        return;
      }
    }
    
    public Timeout timeout()
    {
      return WebSocketWriter.this.sink.timeout();
    }
    
    public void write(Buffer arg1, long paramLong)
      throws IOException
    {
      if (this.closed) {
        throw new IOException("closed");
      }
      WebSocketWriter.this.buffer.write(???, paramLong);
      paramLong = WebSocketWriter.this.buffer.completeSegmentByteCount();
      if (paramLong > 0L) {}
      synchronized (WebSocketWriter.this)
      {
        WebSocketWriter.this.writeMessageFrameSynchronized(this.formatOpcode, paramLong, this.isFirstFrame, false);
        this.isFirstFrame = false;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.internal.ws.WebSocketWriter
 * JD-Core Version:    0.7.0.1
 */