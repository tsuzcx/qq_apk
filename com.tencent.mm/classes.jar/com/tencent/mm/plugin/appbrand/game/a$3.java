package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.b.a;
import com.tencent.mm.protocal.protobuf.ehd;
import com.tencent.mm.sdk.platformtools.ad;

final class a$3
  implements b.a
{
  a$3(a parama, AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void dL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45050);
    if (this.jyv == null)
    {
      ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
      AppMethodBeat.o(45050);
      return;
    }
    if ((this.jyv.isDestroyed()) || (this.jyv.SB))
    {
      ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
      AppMethodBeat.o(45050);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = this.jyv.mAppId;
      com.tencent.mm.plugin.appbrand.report.b localb = a.b(this.kkp);
      this.jyv.Fh();
      com.tencent.mm.plugin.appbrand.report.quality.a.a((String)localObject, localb);
      localObject = ((com.tencent.mm.plugin.appbrand.service.c)this.kkp.El()).aWZ();
      if (localObject == null)
      {
        ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: no game renderer!");
        AppMethodBeat.o(45050);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.game.f.a)((aa)localObject).Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.game.f.a)localObject).a(a.b(this.kkp));
      }
      for (;;)
      {
        localObject = a.b(this.kkp).mqr;
        if ((localObject == null) || (((ehd)localObject).HRQ == 0) || (((ehd)localObject).HRS == 0) || (((ehd)localObject).HRT == 0) || (((ehd)localObject).HRU == 0) || (((ehd)localObject).HRR == 0)) {
          break;
        }
        this.kkp.ckb.getMagicBrush().clA.a(((ehd)localObject).HRS, ((ehd)localObject).HRT, ((ehd)localObject).HRU, ((ehd)localObject).HRR, false);
        AppMethodBeat.o(45050);
        return;
        ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: not game renderer!");
      }
      if (DebuggerShell.bew()) {
        this.kkp.ckb.getMagicBrush().clA.a(5, 10, 10.0F, 60, true);
      }
      AppMethodBeat.o(45050);
      return;
    }
    ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: get sampling failed!");
    AppMethodBeat.o(45050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.3
 * JD-Core Version:    0.7.0.1
 */