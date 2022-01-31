package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.sdk.platformtools.al;

final class a$2
  implements f.c
{
  a$2(a parama, e parame, int paramInt, v.b paramb) {}
  
  public final void onDestroy()
  {
    AppMethodBeat.i(91045);
    this.hEL.b(this);
    al.d(new a.2.1(this));
    this.hEL.vC().pj(this.hEO);
    this.hBX.recycle();
    System.gc();
    AppMethodBeat.o(91045);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a.2
 * JD-Core Version:    0.7.0.1
 */