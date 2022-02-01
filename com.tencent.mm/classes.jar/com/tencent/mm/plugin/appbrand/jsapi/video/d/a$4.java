package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;

final class a$4
  implements f.c
{
  a$4(a parama, AppBrandVideoView paramAppBrandVideoView, e parame, f.d paramd, f.b paramb) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206220);
    this.lpQ.onUIDestroy();
    this.kCd.b(this.kPe);
    this.kCd.b(this.kPd);
    this.kCd.b(this);
    AppMethodBeat.o(206220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.4
 * JD-Core Version:    0.7.0.1
 */