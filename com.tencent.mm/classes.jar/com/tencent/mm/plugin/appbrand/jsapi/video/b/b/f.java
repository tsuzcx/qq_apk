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
  private e mxQ;
  private boolean mxR;
  private CharsetDecoder mxS;
  private final ByteBuffer mxT;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(234719);
    this.mxR = false;
    this.mxT = ByteBuffer.allocate(8192);
    this.mxQ = parame;
    try
    {
      this.mxS = Charset.forName(paramString).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      this.mxT.limit(0);
      AppMethodBeat.o(234719);
      return;
    }
    catch (IllegalArgumentException parame)
    {
      parame = (UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(parame);
      AppMethodBeat.o(234719);
      throw parame;
    }
  }
  
  private boolean isOpen()
  {
    return this.mxQ != null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(234720);
    synchronized (this.lock)
    {
      if (this.mxS != null) {
        this.mxS.reset();
      }
      this.mxS = null;
      if (this.mxQ != null)
      {
        this.mxQ.close();
        this.mxQ = null;
      }
      AppMethodBeat.o(234720);
      return;
    }
  }
  
  public final int read()
  {
    int i = -1;
    AppMethodBeat.i(234721);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        IOException localIOException = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(234721);
        throw localIOException;
      }
    }
    char[] arrayOfChar = new char[1];
    if (read(arrayOfChar, 0, 1) != -1) {
      i = arrayOfChar[0];
    }
    AppMethodBeat.o(234721);
    return i;
  }
  
  public final int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234722);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        paramArrayOfChar = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(234722);
        throw paramArrayOfChar;
      }
    }
    int i = paramArrayOfChar.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
    {
      paramArrayOfChar = new ArrayIndexOutOfBoundsException("arrayLength=" + i + ",offset=" + paramInt1 + ",count=" + paramInt2);
      AppMethodBeat.o(234722);
      throw paramArrayOfChar;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(234722);
      return 0;
    }
    CharBuffer localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = CoderResult.UNDERFLOW;
    if (!this.mxT.hasRemaining()) {
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
          if (this.mxQ.available() != 0L) {
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
            if (this.mxR)
            {
              localObject1 = this.mxS.decode(this.mxT, localCharBuffer, true);
              this.mxS.flush(localCharBuffer);
              this.mxS.reset();
            }
          }
          if ((((CoderResult)localObject1).isMalformed()) || (((CoderResult)localObject1).isUnmappable())) {
            ((CoderResult)localObject1).throwException();
          }
          if (localCharBuffer.position() - paramInt1 != 0) {
            break label490;
          }
          paramInt1 = -1;
          AppMethodBeat.o(234722);
          return paramInt1;
        }
        catch (Exception localException) {}
        paramInt2 = 0;
        break;
        if (!this.mxR)
        {
          paramInt2 = this.mxT.capacity();
          i = this.mxT.limit();
          int j = this.mxT.arrayOffset();
          int k = this.mxT.limit();
          paramInt2 = this.mxQ.read(this.mxT.array(), j + k, paramInt2 - i);
          if (paramInt2 == -1)
          {
            this.mxR = true;
          }
          else if (paramInt2 != 0)
          {
            this.mxT.limit(paramInt2 + this.mxT.limit());
            localCoderResult = this.mxS.decode(this.mxT, localCharBuffer, false);
            paramArrayOfChar = localCoderResult;
            if (localCoderResult.isUnderflow())
            {
              if (this.mxT.limit() != this.mxT.capacity()) {
                break label509;
              }
              this.mxT.compact();
              this.mxT.limit(this.mxT.position());
              this.mxT.position(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.f
 * JD-Core Version:    0.7.0.1
 */