package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$a
  extends am
{
  public a$a(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  @JavascriptInterface
  public final float getWidth()
  {
    AppMethodBeat.i(140866);
    float f1 = super.getWidth();
    float f2 = this.iuH.iux.getWidth() / super.getPixelRatio();
    if ((f2 > 0.0F) && (f2 != f1)) {
      d.e("Luggage.AbstractMPPageViewRenderer", "__deviceInfo.getWidth(), resources[%f] != view[%f]", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
    }
    AppMethodBeat.o(140866);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.a
 * JD-Core Version:    0.7.0.1
 */