package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;

final class a$2
  implements i.d
{
  a$2(a parama, AppBrandVideoView paramAppBrandVideoView) {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(328190);
    this.sEq.onUIResume();
    AppMethodBeat.o(328190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.2
 * JD-Core Version:    0.7.0.1
 */