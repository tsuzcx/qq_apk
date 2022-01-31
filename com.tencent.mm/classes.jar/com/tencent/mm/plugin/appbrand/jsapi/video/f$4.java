package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;

final class f$4
  implements f.c
{
  f$4(f paramf, AppBrandVideoView paramAppBrandVideoView, e parame, f.d paramd, f.b paramb) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(126552);
    this.idM.aEM();
    this.hEL.b(this.hNG);
    this.hEL.b(this.hNF);
    this.hEL.b(this);
    AppMethodBeat.o(126552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.f.4
 * JD-Core Version:    0.7.0.1
 */