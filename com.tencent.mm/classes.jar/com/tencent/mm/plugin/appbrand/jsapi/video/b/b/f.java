package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public final class f
  extends Reader
{
  private e lrk;
  private boolean lrl;
  private CharsetDecoder lrm;
  private final ByteBuffer lrn;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(211050);
    this.lrl = false;
    this.lrn = ByteBuffer.allocate(8192);
    this.lrk = parame;
    try
    {
      this.lrm = Charset.forName(paramString).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      this.lrn.limit(0);
      AppMethodBeat.o(211050);
      return;
    }
    catch (IllegalArgumentException parame)
    {
      parame = (UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(parame);
      AppMethodBeat.o(211050);
      throw parame;
    }
  }
  
  private boolean isOpen()
  {
    return this.lrk != null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(211051);
    synchronized (this.lock)
    {
      if (this.lrm != null) {
        this.lrm.reset();
      }
      this.lrm = null;
      if (this.lrk != null)
      {
        this.lrk.close();
        this.lrk = null;
      }
      AppMethodBeat.o(211051);
      return;
    }
  }
  
  public final int read()
  {
    int i = -1;
    AppMethodBeat.i(211052);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        IOException localIOException = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(211052);
        throw localIOException;
      }
    }
    char[] arrayOfChar = new char[1];
    if (read(arrayOfChar, 0, 1) != -1) {
      i = arrayOfChar[0];
    }
    AppMethodBeat.o(211052);
    return i;
  }
  
  public final int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211053);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        paramArrayOfChar = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(211053);
        throw paramArrayOfChar;
      }
    }
    int i = paramArrayOfChar.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
    {
      paramArrayOfChar = new ArrayIndexOutOfBoundsException("arrayLength=" + i + ",offset=" + paramInt1 + ",count=" + paramInt2);
      AppMethodBeat.o(211053);
      throw paramArrayOfChar;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(211053);
      return 0;
    }
    CharBuffer localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = CoderResult.UNDERFLOW;
    if (!this.lrn.hasRemaining()) {
      paramInt2 = 1;
    }
    for (;;)
    {
      boolean bool = localCharBuffer.hasRemaining();
      if (bool) {
        if (paramInt2 == 0) {}
      }
      label309:
      CoderResult localCoderResult;
      for (;;)
      {
        try
        {
          if (this.lrk.available() != 0L) {
            break label309;
          }
          paramInt2 = localCharBuffer.position();
          if (paramInt2 <= paramInt1) {
            break label309;
          }
          Object localObject1 = paramArrayOfChar;
          if (paramArrayOfChar == CoderResult.UNDERFLOW)
          {
            localObject1 = paramArrayOfChar;
            if (this.lrl)
            {
              localObject1 = this.lrm.decode(this.lrn, localCharBuffer, true);
              this.lrm.flush(localCharBuffer);
              this.lrm.reset();
            }
          }
          if ((((CoderResult)localObject1).isMalformed()) || (((CoderResult)localObject1).isUnmappable())) {
            ((CoderResult)localObject1).throwException();
          }
          if (localCharBuffer.position() - paramInt1 != 0) {
            break label490;
          }
          paramInt1 = -1;
          AppMethodBeat.o(211053);
          return paramInt1;
        }
        catch (Exception localException) {}
        paramInt2 = 0;
        break;
        if (!this.lrl)
        {
          paramInt2 = this.lrn.capacity();
          i = this.lrn.limit();
          int j = this.lrn.arrayOffset();
          int k = this.lrn.limit();
          paramInt2 = this.lrk.read(this.lrn.array(), j + k, paramInt2 - i);
          if (paramInt2 == -1)
          {
            this.lrl = true;
          }
          else if (paramInt2 != 0)
          {
            this.lrn.limit(paramInt2 + this.lrn.limit());
            localCoderResult = this.lrm.decode(this.lrn, localCharBuffer, false);
            paramArrayOfChar = localCoderResult;
            if (localCoderResult.isUnderflow())
            {
              if (this.lrn.limit() != this.lrn.capacity()) {
                break label509;
              }
              this.lrn.compact();
              this.lrn.limit(this.lrn.position());
              this.lrn.position(0);
              break label509;
              label490:
              paramInt2 = localCharBuffer.position();
              paramInt1 = paramInt2 - paramInt1;
            }
          }
        }
      }
      continue;
      label509:
      paramInt2 = 1;
      paramArrayOfChar = localCoderResult;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.f
 * JD-Core Version:    0.7.0.1
 */