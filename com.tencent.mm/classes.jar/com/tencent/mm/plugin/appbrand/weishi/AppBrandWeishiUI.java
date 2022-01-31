package com.tencent.mm.plugin.appbrand.weishi;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.sdk.platformtools.ab;

public class AppBrandWeishiUI
  extends AppBrandPluginUI
{
  public final void e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(133638);
    ab.i("MicroMsg.AppBrandWeishiUI", "initAppBrandUIOpenAnimation, weishi animation");
    e.b(this, paramAppBrandInitConfigWC);
    AppMethodBeat.o(133638);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(133639);
    super.onDetachedFromWindow();
    AppMethodBeat.o(133639);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(133637);
    super.onResume();
    ab.i("MicroMsg.AppBrandWeishiUI", "onResume");
    o.c(getWindow(), true);
    AppMethodBeat.o(133637);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.weishi.AppBrandWeishiUI
 * JD-Core Version:    0.7.0.1
 */