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
  private e pwk;
  private boolean pwl;
  private CharsetDecoder pwm;
  private final ByteBuffer pwn;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(229171);
    this.pwl = false;
    this.pwn = ByteBuffer.allocate(8192);
    this.pwk = parame;
    try
    {
      this.pwm = Charset.forName(paramString).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      this.pwn.limit(0);
      AppMethodBeat.o(229171);
      return;
    }
    catch (IllegalArgumentException parame)
    {
      parame = (UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(parame);
      AppMethodBeat.o(229171);
      throw parame;
    }
  }
  
  private boolean isOpen()
  {
    return this.pwk != null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(229179);
    synchronized (this.lock)
    {
      if (this.pwm != null) {
        this.pwm.reset();
      }
      this.pwm = null;
      if (this.pwk != null)
      {
        this.pwk.close();
        this.pwk = null;
      }
      AppMethodBeat.o(229179);
      return;
    }
  }
  
  public final int read()
  {
    int i = -1;
    AppMethodBeat.i(229187);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        IOException localIOException = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(229187);
        throw localIOException;
      }
    }
    char[] arrayOfChar = new char[1];
    if (read(arrayOfChar, 0, 1) != -1) {
      i = arrayOfChar[0];
    }
    AppMethodBeat.o(229187);
    return i;
  }
  
  public final int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229215);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        paramArrayOfChar = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(229215);
        throw paramArrayOfChar;
      }
    }
    int i = paramArrayOfChar.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
    {
      paramArrayOfChar = new ArrayIndexOutOfBoundsException("arrayLength=" + i + ",offset=" + paramInt1 + ",count=" + paramInt2);
      AppMethodBeat.o(229215);
      throw paramArrayOfChar;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(229215);
      return 0;
    }
    CharBuffer localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = CoderResult.UNDERFLOW;
    if (!this.pwn.hasRemaining()) {
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
          if (this.pwk.available() != 0L) {
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
            if (this.pwl)
            {
              localObject1 = this.pwm.decode(this.pwn, localCharBuffer, true);
              this.pwm.flush(localCharBuffer);
              this.pwm.reset();
            }
          }
          if ((((CoderResult)localObject1).isMalformed()) || (((CoderResult)localObject1).isUnmappable())) {
            ((CoderResult)localObject1).throwException();
          }
          if (localCharBuffer.position() - paramInt1 != 0) {
            break label490;
          }
          paramInt1 = -1;
          AppMethodBeat.o(229215);
          return paramInt1;
        }
        catch (Exception localException) {}
        paramInt2 = 0;
        break;
        if (!this.pwl)
        {
          paramInt2 = this.pwn.capacity();
          i = this.pwn.limit();
          int j = this.pwn.arrayOffset();
          int k = this.pwn.limit();
          paramInt2 = this.pwk.read(this.pwn.array(), j + k, paramInt2 - i);
          if (paramInt2 == -1)
          {
            this.pwl = true;
          }
          else if (paramInt2 != 0)
          {
            this.pwn.limit(paramInt2 + this.pwn.limit());
            localCoderResult = this.pwm.decode(this.pwn, localCharBuffer, false);
            paramArrayOfChar = localCoderResult;
            if (localCoderResult.isUnderflow())
            {
              if (this.pwn.limit() != this.pwn.capacity()) {
                break label509;
              }
              this.pwn.compact();
              this.pwn.limit(this.pwn.position());
              this.pwn.position(0);
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