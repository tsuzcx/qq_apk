package com.tencent.luggage.bridge;

import android.webkit.JavascriptInterface;

final class r
{
  private n bhT;
  
  r(n paramn)
  {
    this.bhT = paramn;
  }
  
  @JavascriptInterface
  public final String send(String paramString, boolean paramBoolean)
  {
    return this.bhT.g(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.bridge.r
 * JD-Core Version:    0.7.0.1
 */