package com.tencent.luggage.bridge;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r
{
  private n eiO;
  
  r(n paramn)
  {
    this.eiO = paramn;
  }
  
  @JavascriptInterface
  public final String send(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(140346);
    paramString = this.eiO.j(paramString, paramBoolean);
    AppMethodBeat.o(140346);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.r
 * JD-Core Version:    0.7.0.1
 */