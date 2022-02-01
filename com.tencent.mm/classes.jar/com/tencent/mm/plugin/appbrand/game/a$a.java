package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.game.a.h;
import com.tencent.mm.plugin.appbrand.game.a.j;
import com.tencent.mm.plugin.appbrand.game.a.k;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.game.a.q;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.game.a.s;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;

final class a$a
  extends com.tencent.luggage.game.a.b
{
  public a$a(a parama, Context paramContext, i parami, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    super(paramContext, parami, paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
  }
  
  public final void a(com.tencent.magicbrush.d paramd, long paramLong)
  {
    AppMethodBeat.i(45052);
    com.tencent.mm.plugin.appbrand.report.quality.a.bxN();
    com.tencent.mm.plugin.appbrand.report.quality.b.a(((com.tencent.mm.plugin.appbrand.service.c)this.kkp.El()).aXu(), ((com.tencent.mm.plugin.appbrand.service.c)this.kkp.El()).getAppId(), paramLong);
    AppMethodBeat.o(45052);
  }
  
  public final void a(com.tencent.magicbrush.e parame)
  {
    AppMethodBeat.i(45051);
    super.a(parame);
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwb, false);
    parame.cxg.a(f.cwV[6], Boolean.valueOf(bool1));
    parame.ae(com.tencent.mm.plugin.appbrand.game.a.d.kkB.dm(((com.tencent.mm.plugin.appbrand.service.c)this.kkp.El()).getContext()));
    parame.bP(s.bhh());
    bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.b.kku.ate()).booleanValue();
    parame.cxh.a(f.cwV[7], Boolean.valueOf(bool1));
    bool1 = ((Boolean)q.kkV.ate()).booleanValue();
    String str1;
    label194:
    String str2;
    label202:
    String str3;
    if ((a.bha()) && (((Boolean)r.kkW.ate()).booleanValue()))
    {
      parame.b(a.b.czP);
      boolean bool2 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.e.kkF.ate()).booleanValue();
      bool1 = ((Boolean)n.kkS.ate()).booleanValue();
      boolean bool3 = ((Boolean)o.kkT.ate()).booleanValue();
      if (!bool2) {
        break label457;
      }
      str1 = "yes";
      if (!bool1) {
        break label465;
      }
      str2 = "yes";
      if (!bool3) {
        break label473;
      }
      str3 = "yes";
      label211:
      ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
      if ((!bool2) || (!bool1)) {
        break label481;
      }
      bool1 = true;
      label247:
      parame.bU(bool1);
      if ((!bool2) || (!bool3)) {
        break label486;
      }
    }
    label457:
    label465:
    label473:
    label481:
    label486:
    for (bool1 = true;; bool1 = false)
    {
      parame.bT(bool1);
      ad.i("MicroMsg.AppBrandGameServiceLogicImpWC", "hy: use animation handler: %s", new Object[] { parame.Hs().toString() });
      bool1 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.c.kkv.ate()).booleanValue();
      parame.cxv.a(f.cwV[19], Boolean.valueOf(bool1));
      parame.bR(((Boolean)h.kkI.ate()).booleanValue());
      parame.bS(((Boolean)l.kkQ.ate()).booleanValue());
      bool1 = ((Boolean)k.kkP.ate()).booleanValue();
      parame.cxz.a(f.cwV[23], Boolean.valueOf(bool1));
      bool1 = ((Boolean)j.kkO.ate()).booleanValue();
      parame.cxA.a(f.cwV[24], Boolean.valueOf(bool1));
      AppMethodBeat.o(45051);
      return;
      if (!bool1)
      {
        parame.b(a.b.czN);
        break;
      }
      if (a.bha())
      {
        parame.b(a.b.czM);
        break;
      }
      parame.b(a.b.czL);
      break;
      str1 = "no";
      break label194;
      str2 = "no";
      break label202;
      str3 = "no";
      break label211;
      bool1 = false;
      break label247;
    }
  }
  
  public final void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(45053);
    super.a(paramAppBrandRuntime);
    com.tencent.mm.plugin.appbrand.game.c.a.kle.a(getMagicBrush(), paramAppBrandRuntime);
    a.c(this.kkp);
    AppMethodBeat.o(45053);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.a
 * JD-Core Version:    0.7.0.1
 */