package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$keyboardListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener$OnKeyboardStateChangedListener;", "keyboardHeight", "", "getHeight", "onKeyboardStateChanged", "", "shown", "", "refreshHeight", "height", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$e
  implements u.c
{
  private int sNb;
  
  f$e(f paramf) {}
  
  public final void cK(boolean paramBoolean)
  {
    AppMethodBeat.i(327497);
    this.sMY.getController().t(paramBoolean, this.sNb);
    AppMethodBeat.o(327497);
  }
  
  public final int getHeight()
  {
    return this.sNb;
  }
  
  public final void mo(int paramInt)
  {
    this.sNb = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.f.e
 * JD-Core Version:    0.7.0.1
 */