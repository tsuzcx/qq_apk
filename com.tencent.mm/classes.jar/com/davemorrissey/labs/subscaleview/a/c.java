package com.davemorrissey.labs.subscaleview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public int errCode;
  public String errMsg;
  
  public c(int paramInt, String paramString)
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
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.c
 * JD-Core Version:    0.7.0.1
 */