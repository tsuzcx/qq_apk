package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$viewActiveStateEmitter$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "onBackground", "", "onForeground", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$h
  implements i.b, i.d
{
  f$h(f paramf) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(327502);
    f.e(this.sMY).onPause();
    this.sMY.getController().onBackground();
    AppMethodBeat.o(327502);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(327509);
    f.e(this.sMY).onResume();
    this.sMY.getController().onForeground();
    AppMethodBeat.o(327509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.f.h
 * JD-Core Version:    0.7.0.1
 */