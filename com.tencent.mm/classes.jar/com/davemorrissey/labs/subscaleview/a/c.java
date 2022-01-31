package com.davemorrissey.labs.subscaleview.a;

public final class c
{
  public String aox;
  public int errCode;
  
  public c(int paramInt, String paramString)
  {
    this.errCode = paramInt;
    this.aox = paramString;
  }
  
  public final String toString()
  {
    return String.format("ImageDecodeResult{errCode: %d, errMsg: %s}", new Object[] { Integer.valueOf(this.errCode), this.aox });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.c
 * JD-Core Version:    0.7.0.1
 */