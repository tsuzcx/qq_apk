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
  private e kQk;
  private boolean kQl;
  private CharsetDecoder kQm;
  private final ByteBuffer kQn;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(194211);
    this.kQl = false;
    this.kQn = ByteBuffer.allocate(8192);
    this.kQk = parame;
    try
    {
      this.kQm = Charset.forName(paramString).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      this.kQn.limit(0);
      AppMethodBeat.o(194211);
      return;
    }
    catch (IllegalArgumentException parame)
    {
      parame = (UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(parame);
      AppMethodBeat.o(194211);
      throw parame;
    }
  }
  
  private boolean isOpen()
  {
    return this.kQk != null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(194212);
    synchronized (this.lock)
    {
      if (this.kQm != null) {
        this.kQm.reset();
      }
      this.kQm = null;
      if (this.kQk != null)
      {
        this.kQk.close();
        this.kQk = null;
      }
      AppMethodBeat.o(194212);
      return;
    }
  }
  
  public final int read()
  {
    int i = -1;
    AppMethodBeat.i(194213);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        IOException localIOException = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(194213);
        throw localIOException;
      }
    }
    char[] arrayOfChar = new char[1];
    if (read(arrayOfChar, 0, 1) != -1) {
      i = arrayOfChar[0];
    }
    AppMethodBeat.o(194213);
    return i;
  }
  
  public final int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194214);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        paramArrayOfChar = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(194214);
        throw paramArrayOfChar;
      }
    }
    int i = paramArrayOfChar.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
    {
      paramArrayOfChar = new ArrayIndexOutOfBoundsException("arrayLength=" + i + ",offset=" + paramInt1 + ",count=" + paramInt2);
      AppMethodBeat.o(194214);
      throw paramArrayOfChar;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(194214);
      return 0;
    }
    CharBuffer localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = CoderResult.UNDERFLOW;
    if (!this.kQn.hasRemaining()) {
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
          if (this.kQk.available() != 0L) {
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
            if (this.kQl)
            {
              localObject1 = this.kQm.decode(this.kQn, localCharBuffer, true);
              this.kQm.flush(localCharBuffer);
              this.kQm.reset();
            }
          }
          if ((((CoderResult)localObject1).isMalformed()) || (((CoderResult)localObject1).isUnmappable())) {
            ((CoderResult)localObject1).throwException();
          }
          if (localCharBuffer.position() - paramInt1 != 0) {
            break label490;
          }
          paramInt1 = -1;
          AppMethodBeat.o(194214);
          return paramInt1;
        }
        catch (Exception localException) {}
        paramInt2 = 0;
        break;
        if (!this.kQl)
        {
          paramInt2 = this.kQn.capacity();
          i = this.kQn.limit();
          int j = this.kQn.arrayOffset();
          int k = this.kQn.limit();
          paramInt2 = this.kQk.read(this.kQn.array(), j + k, paramInt2 - i);
          if (paramInt2 == -1)
          {
            this.kQl = true;
          }
          else if (paramInt2 != 0)
          {
            this.kQn.limit(paramInt2 + this.kQn.limit());
            localCoderResult = this.kQm.decode(this.kQn, localCharBuffer, false);
            paramArrayOfChar = localCoderResult;
            if (localCoderResult.isUnderflow())
            {
              if (this.kQn.limit() != this.kQn.capacity()) {
                break label509;
              }
              this.kQn.compact();
              this.kQn.limit(this.kQn.position());
              this.kQn.position(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.f
 * JD-Core Version:    0.7.0.1
 */