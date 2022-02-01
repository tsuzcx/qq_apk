package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.magicbrush.ui.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.a.h;
import com.tencent.mm.plugin.appbrand.game.a.l;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.game.a.r;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.x;
import com.tencent.mm.plugin.appbrand.report.quality.a;
import com.tencent.mm.sdk.platformtools.ad;

final class b$3
  extends com.tencent.luggage.game.a.c
{
  b$3(b paramb, Context paramContext, i parami)
  {
    super(paramContext, parami);
  }
  
  public final void a(com.tencent.magicbrush.d paramd, long paramLong)
  {
    AppMethodBeat.i(188746);
    a.bxN();
    com.tencent.mm.plugin.appbrand.report.quality.b.a(((c)this.mwl.El()).aXu(), ((c)this.mwl.El()).getAppId(), paramLong);
    AppMethodBeat.o(188746);
  }
  
  public final void a(com.tencent.magicbrush.e parame)
  {
    boolean bool2 = true;
    AppMethodBeat.i(188745);
    super.a(parame);
    parame.ae(com.tencent.mm.plugin.appbrand.game.a.d.kkB.dm(((c)this.mwl.El()).getContext()));
    parame.bP(false);
    parame.bR(((Boolean)h.kkI.ate()).booleanValue());
    parame.bS(((Boolean)l.kkQ.ate()).booleanValue());
    if (((this.cir instanceof x)) && (((Boolean)r.kkW.ate()).booleanValue())) {
      parame.b(a.b.czP);
    }
    boolean bool3 = ((Boolean)com.tencent.mm.plugin.appbrand.game.a.e.kkF.ate()).booleanValue();
    boolean bool1 = ((Boolean)n.kkS.ate()).booleanValue();
    boolean bool4 = ((Boolean)o.kkT.ate()).booleanValue();
    String str1;
    String str2;
    label162:
    String str3;
    if (bool3)
    {
      str1 = "yes";
      if (!bool1) {
        break label243;
      }
      str2 = "yes";
      if (!bool4) {
        break label250;
      }
      str3 = "yes";
      label171:
      ad.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", new Object[] { str1, str2, str3 });
      if ((!bool3) || (!bool1)) {
        break label257;
      }
      bool1 = true;
      label208:
      parame.bU(bool1);
      if ((!bool3) || (!bool4)) {
        break label262;
      }
    }
    label257:
    label262:
    for (bool1 = bool2;; bool1 = false)
    {
      parame.bT(bool1);
      AppMethodBeat.o(188745);
      return;
      str1 = "no";
      break;
      label243:
      str2 = "no";
      break label162;
      label250:
      str3 = "no";
      break label171;
      bool1 = false;
      break label208;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.b.3
 * JD-Core Version:    0.7.0.1
 */