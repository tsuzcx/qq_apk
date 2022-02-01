package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI4;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "()V", "plugin-appbrand-integration_release"})
public final class AppBrandPreLoadingUI4
  extends AppBrandPreLoadingUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI4
 * JD-Core Version:    0.7.0.1
 */