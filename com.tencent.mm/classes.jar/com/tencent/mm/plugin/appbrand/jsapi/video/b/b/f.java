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
  private e lmK;
  private boolean lmL;
  private CharsetDecoder lmM;
  private final ByteBuffer lmN;
  
  public f(e parame, String paramString)
  {
    super(parame);
    AppMethodBeat.i(206023);
    this.lmL = false;
    this.lmN = ByteBuffer.allocate(8192);
    this.lmK = parame;
    try
    {
      this.lmM = Charset.forName(paramString).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
      this.lmN.limit(0);
      AppMethodBeat.o(206023);
      return;
    }
    catch (IllegalArgumentException parame)
    {
      parame = (UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(parame);
      AppMethodBeat.o(206023);
      throw parame;
    }
  }
  
  private boolean isOpen()
  {
    return this.lmK != null;
  }
  
  public final void close()
  {
    AppMethodBeat.i(206024);
    synchronized (this.lock)
    {
      if (this.lmM != null) {
        this.lmM.reset();
      }
      this.lmM = null;
      if (this.lmK != null)
      {
        this.lmK.close();
        this.lmK = null;
      }
      AppMethodBeat.o(206024);
      return;
    }
  }
  
  public final int read()
  {
    int i = -1;
    AppMethodBeat.i(206025);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        IOException localIOException = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(206025);
        throw localIOException;
      }
    }
    char[] arrayOfChar = new char[1];
    if (read(arrayOfChar, 0, 1) != -1) {
      i = arrayOfChar[0];
    }
    AppMethodBeat.o(206025);
    return i;
  }
  
  public final int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206026);
    synchronized (this.lock)
    {
      if (!isOpen())
      {
        paramArrayOfChar = new IOException("DataSourceReader is closed");
        AppMethodBeat.o(206026);
        throw paramArrayOfChar;
      }
    }
    int i = paramArrayOfChar.length;
    if (((paramInt1 | paramInt2) < 0) || (paramInt1 > i) || (i - paramInt1 < paramInt2))
    {
      paramArrayOfChar = new ArrayIndexOutOfBoundsException("arrayLength=" + i + ",offset=" + paramInt1 + ",count=" + paramInt2);
      AppMethodBeat.o(206026);
      throw paramArrayOfChar;
    }
    if (paramInt2 == 0)
    {
      AppMethodBeat.o(206026);
      return 0;
    }
    CharBuffer localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = CoderResult.UNDERFLOW;
    if (!this.lmN.hasRemaining()) {
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
          if (this.lmK.available() != 0L) {
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
            if (this.lmL)
            {
              localObject1 = this.lmM.decode(this.lmN, localCharBuffer, true);
              this.lmM.flush(localCharBuffer);
              this.lmM.reset();
            }
          }
          if ((((CoderResult)localObject1).isMalformed()) || (((CoderResult)localObject1).isUnmappable())) {
            ((CoderResult)localObject1).throwException();
          }
          if (localCharBuffer.position() - paramInt1 != 0) {
            break label490;
          }
          paramInt1 = -1;
          AppMethodBeat.o(206026);
          return paramInt1;
        }
        catch (Exception localException) {}
        paramInt2 = 0;
        break;
        if (!this.lmL)
        {
          paramInt2 = this.lmN.capacity();
          i = this.lmN.limit();
          int j = this.lmN.arrayOffset();
          int k = this.lmN.limit();
          paramInt2 = this.lmK.read(this.lmN.array(), j + k, paramInt2 - i);
          if (paramInt2 == -1)
          {
            this.lmL = true;
          }
          else if (paramInt2 != 0)
          {
            this.lmN.limit(paramInt2 + this.lmN.limit());
            localCoderResult = this.lmM.decode(this.lmN, localCharBuffer, false);
            paramArrayOfChar = localCoderResult;
            if (localCoderResult.isUnderflow())
            {
              if (this.lmN.limit() != this.lmN.capacity()) {
                break label509;
              }
              this.lmN.compact();
              this.lmN.limit(this.lmN.position());
              this.lmN.position(0);
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