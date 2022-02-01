package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI3;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "()V", "plugin-appbrand-integration_release"})
public final class AppBrandPreLoadingUI3
  extends AppBrandPreLoadingUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI3
 * JD-Core Version:    0.7.0.1
 */