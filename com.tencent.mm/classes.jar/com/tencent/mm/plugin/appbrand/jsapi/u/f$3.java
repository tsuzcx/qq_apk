package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.ui.widget.MMWebView;

final class f$3
  implements f.d
{
  f$3(f paramf, a parama) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(131671);
    this.ihu.getWebView().onResume();
    AppMethodBeat.o(131671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.f.3
 * JD-Core Version:    0.7.0.1
 */