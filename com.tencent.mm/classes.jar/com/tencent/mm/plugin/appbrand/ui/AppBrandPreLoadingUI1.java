package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI1;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "()V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandPreLoadingUI1
  extends AppBrandPreLoadingUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI1
 * JD-Core Version:    0.7.0.1
 */