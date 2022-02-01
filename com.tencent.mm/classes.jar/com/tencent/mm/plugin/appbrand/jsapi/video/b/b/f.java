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
  private e sBq;
  private boolean sBr;
  private CharsetDecoder sBs;
  private final ByteBuffer sBt;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(328506);
    this.sBr = false;
    this.sBt = ByteBuffer.allocate(8192);
    this.sBq = parame;
    try
    {
      this.sBs = Charset.forName(paramString).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      this.sBt.limit(0);
      AppMethodBeat.o(328506);
      return;
    }
    catch (IllegalArgumentException parame)
    {
      parame = (UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(parame);
      AppMethodBeat.o(328506);
      throw parame;
    }
  }
  
  private boolean isOpen()
  {
    return this.sBq != null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(328522);
    synchronized (this.lock)
    {
      if (this.sBs != null) {
        this.sBs.reset();
      }
      this.sBs = null;
      if (this.sBq != null)
      {
        this.sBq.close();
        this.sBq = null;
      }
      AppMethodBeat.o(328522);
      return;
    }
  }
  
  public final int read()
  {
    int i = -1;
    AppMethodBeat.i(328531);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        IOException localIOException = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(328531);
        throw localIOException;
      }
    }
    char[] arrayOfChar = new char[1];
    if (read(arrayOfChar, 0, 1) != -1) {
      i = arrayOfChar[0];
    }
    AppMethodBeat.o(328531);
    return i;
  }
  
  public final int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328546);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        paramArrayOfChar = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(328546);
        throw paramArrayOfChar;
      }
    }
    int i = paramArrayOfChar.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
    {
      paramArrayOfChar = new ArrayIndexOutOfBoundsException("arrayLength=" + i + ",offset=" + paramInt1 + ",count=" + paramInt2);
      AppMethodBeat.o(328546);
      throw paramArrayOfChar;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(328546);
      return 0;
    }
    CharBuffer localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = CoderResult.UNDERFLOW;
    if (!this.sBt.hasRemaining()) {
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
          if (this.sBq.available() != 0L) {
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
            if (this.sBr)
            {
              localObject1 = this.sBs.decode(this.sBt, localCharBuffer, true);
              this.sBs.flush(localCharBuffer);
              this.sBs.reset();
            }
          }
          if ((((CoderResult)localObject1).isMalformed()) || (((CoderResult)localObject1).isUnmappable())) {
            ((CoderResult)localObject1).throwException();
          }
          if (localCharBuffer.position() - paramInt1 != 0) {
            break label490;
          }
          paramInt1 = -1;
          AppMethodBeat.o(328546);
          return paramInt1;
        }
        catch (Exception localException) {}
        paramInt2 = 0;
        break;
        if (!this.sBr)
        {
          paramInt2 = this.sBt.capacity();
          i = this.sBt.limit();
          int j = this.sBt.arrayOffset();
          int k = this.sBt.limit();
          paramInt2 = this.sBq.read(this.sBt.array(), j + k, paramInt2 - i);
          if (paramInt2 == -1)
          {
            this.sBr = true;
          }
          else if (paramInt2 != 0)
          {
            this.sBt.limit(paramInt2 + this.sBt.limit());
            localCoderResult = this.sBs.decode(this.sBt, localCharBuffer, false);
            paramArrayOfChar = localCoderResult;
            if (localCoderResult.isUnderflow())
            {
              if (this.sBt.limit() != this.sBt.capacity()) {
                break label509;
              }
              this.sBt.compact();
              this.sBt.limit(this.sBt.position());
              this.sBt.position(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.f
 * JD-Core Version:    0.7.0.1
 */