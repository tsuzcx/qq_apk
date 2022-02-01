package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI2;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "()V", "plugin-appbrand-integration_release"})
public final class AppBrandPreLoadingUI2
  extends AppBrandPreLoadingUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI2
 * JD-Core Version:    0.7.0.1
 */