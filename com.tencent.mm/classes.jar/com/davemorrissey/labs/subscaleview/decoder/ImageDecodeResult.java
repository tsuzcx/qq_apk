package com.davemorrissey.labs.subscaleview.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ImageDecodeResult
{
  public int errCode;
  public String errMsg;
  
  public ImageDecodeResult(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.errMsg = paramString;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(157342);
    String str = String.format("ImageDecodeResult{errCode: %d, errMsg: %s}", new Object[] { Integer.valueOf(this.errCode), this.errMsg });
    AppMethodBeat.o(157342);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult
 * JD-Core Version:    0.7.0.1
 */