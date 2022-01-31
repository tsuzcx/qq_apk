package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.ui.widget.MMWebView;

final class f$4
  implements f.b
{
  f$4(f paramf, a parama) {}
  
  public final void onBackground()
  {
    AppMethodBeat.i(131672);
    this.ihu.getWebView().onPause();
    AppMethodBeat.o(131672);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.f.4
 * JD-Core Version:    0.7.0.1
 */