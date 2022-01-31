package com.tencent.luggage.bridge;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r
{
  private n byt;
  
  r(n paramn)
  {
    this.byt = paramn;
  }
  
  @JavascriptInterface
  public final String send(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90746);
    paramString = this.byt.i(paramString, paramBoolean);
    AppMethodBeat.o(90746);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.bridge.r
 * JD-Core Version:    0.7.0.1
 */