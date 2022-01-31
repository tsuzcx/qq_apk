package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.l;
import com.tencent.mm.sdk.platformtools.bo;

final class c$1
  implements Runnable
{
  c$1(c paramc, r paramr, v paramv, String paramString1, String paramString2, String paramString3, int paramInt1, Boolean paramBoolean, String paramString4, int paramInt2, int paramInt3) {}
  
  public final void run()
  {
    AppMethodBeat.i(74792);
    if (!this.bAW.isRunning())
    {
      AppMethodBeat.o(74792);
      return;
    }
    this.hxy.ixn.a(an.iyW);
    b localb = new b(this.bAW.getContext());
    if (!bo.isNullOrNil(this.cbK))
    {
      if (!bo.isNullOrNil(this.fOX)) {
        break label201;
      }
      localb.setMessage(this.cbK);
    }
    for (;;)
    {
      if (!bo.isNullOrNil(this.fOX)) {
        localb.setMessage(this.fOX);
      }
      localb.a(this.hXx, true, new c.1.1(this));
      if (this.hXy.booleanValue()) {
        localb.b(this.hXz, false, new c.1.2(this));
      }
      localb.setOnCancelListener(new c.1.3(this));
      localb.QZ(this.hXA);
      if (this.hXy.booleanValue()) {
        localb.Ra(this.hXB);
      }
      this.bAW.getRuntime().gPE.b(localb);
      AppMethodBeat.o(74792);
      return;
      label201:
      localb.setTitle(this.cbK);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c.1
 * JD-Core Version:    0.7.0.1
 */