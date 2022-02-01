package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;

final class a$4
  implements i.c
{
  a$4(a parama, AppBrandVideoView paramAppBrandVideoView, h paramh, i.d paramd, i.b paramb) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(328198);
    this.sEq.onUIDestroy();
    this.rJh.b(this.sbb);
    this.rJh.b(this.sba);
    this.rJh.b(this);
    AppMethodBeat.o(328198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.a.4
 * JD-Core Version:    0.7.0.1
 */