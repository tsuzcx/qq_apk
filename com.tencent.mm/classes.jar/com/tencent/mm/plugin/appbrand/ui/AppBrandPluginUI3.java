package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI3;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI;", "()V", "plugin-appbrand-integration_release"})
public final class AppBrandPluginUI3
  extends AppBrandPluginUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI3
 * JD-Core Version:    0.7.0.1
 */