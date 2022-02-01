package com.tencent.mm.plugin.appbrand.game;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.b.a;
import com.tencent.mm.protocal.protobuf.dvi;
import com.tencent.mm.sdk.platformtools.ad;

final class a$3
  implements b.a
{
  a$3(a parama, AppBrandRuntime paramAppBrandRuntime) {}
  
  public final void dJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(45050);
    if (this.iFn == null)
    {
      ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: can not get runtime!");
      AppMethodBeat.o(45050);
      return;
    }
    if ((this.iFn.isDestroyed()) || (this.iFn.PR))
    {
      ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: runtime finished. abort");
      AppMethodBeat.o(45050);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject = this.iFn.mAppId;
      com.tencent.mm.plugin.appbrand.report.b localb = a.b(this.jpO);
      this.iFn.Ef();
      com.tencent.mm.plugin.appbrand.report.quality.a.a((String)localObject, localb);
      localObject = ((com.tencent.mm.plugin.appbrand.service.c)this.jpO.Dj()).aMZ();
      if (localObject == null)
      {
        ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: no game renderer!");
        AppMethodBeat.o(45050);
        return;
      }
      localObject = (com.tencent.mm.plugin.appbrand.game.f.a)((aa)localObject).Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
      if (localObject != null) {
        ((com.tencent.mm.plugin.appbrand.game.f.a)localObject).a(a.b(this.jpO));
      }
      for (;;)
      {
        localObject = a.b(this.jpO).loB;
        if ((localObject == null) || (((dvi)localObject).EJt == 0) || (((dvi)localObject).EJu == 0) || (((dvi)localObject).EJv == 0) || (((dvi)localObject).EJs == 0)) {
          break;
        }
        this.jpO.ccM.getMagicBrush().cem.a(((dvi)localObject).EJt, ((dvi)localObject).EJu, ((dvi)localObject).EJv, ((dvi)localObject).EJs);
        AppMethodBeat.o(45050);
        return;
        ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: not game renderer!");
      }
      if (DebuggerShell.aTY()) {
        this.jpO.ccM.getMagicBrush().cem.a(5, 10, 10.0F, 60);
      }
      AppMethodBeat.o(45050);
      return;
    }
    ad.w("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: get sampling failed!");
    AppMethodBeat.o(45050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.3
 * JD-Core Version:    0.7.0.1
 */