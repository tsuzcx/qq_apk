package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ba
  extends MutableContextWrapper
{
  public ba(Context paramContext)
  {
    super(paramContext);
  }
  
  @JavascriptInterface
  public float getPixelRatio()
  {
    AppMethodBeat.i(147442);
    float f = getResources().getDisplayMetrics().density;
    AppMethodBeat.o(147442);
    return f;
  }
  
  @JavascriptInterface
  public float getWidth()
  {
    AppMethodBeat.i(147443);
    float f = (float)Math.ceil(getResources().getDisplayMetrics().widthPixels / getPixelRatio());
    AppMethodBeat.o(147443);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ba
 * JD-Core Version:    0.7.0.1
 */