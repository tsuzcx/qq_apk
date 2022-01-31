package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

class am
  extends MutableContextWrapper
{
  public am(Context paramContext)
  {
    super(paramContext);
  }
  
  @JavascriptInterface
  public float getPixelRatio()
  {
    AppMethodBeat.i(140871);
    float f = getResources().getDisplayMetrics().density;
    AppMethodBeat.o(140871);
    return f;
  }
  
  @JavascriptInterface
  public float getWidth()
  {
    AppMethodBeat.i(140872);
    float f = (int)Math.ceil(getResources().getDisplayMetrics().widthPixels / getPixelRatio());
    AppMethodBeat.o(140872);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am
 * JD-Core Version:    0.7.0.1
 */