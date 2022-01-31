package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandUI$3
  implements ViewTreeObserver.OnPreDrawListener
{
  AppBrandUI$3(AppBrandUI paramAppBrandUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(133120);
    try
    {
      AppBrandUI.c(this.iPh).getViewTreeObserver().removeOnPreDrawListener(this);
      this.iPh.onEnterAnimationComplete();
      AppMethodBeat.o(133120);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.w("MicroMsg.AppBrandUI", "first onPreDraw after onResume, remove listener failed, e=%s", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandUI.3
 * JD-Core Version:    0.7.0.1
 */