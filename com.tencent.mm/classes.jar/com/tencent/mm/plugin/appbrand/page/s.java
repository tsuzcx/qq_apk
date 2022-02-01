package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.b;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;

public final class s
  extends r
{
  public s(ad paramad, List<com.tencent.mm.plugin.appbrand.menu.r> paramList)
  {
    super(paramad, paramList);
  }
  
  protected final void a(e parame)
  {
    AppMethodBeat.i(47798);
    super.a(parame);
    Object localObject = (ad)this.ckP;
    boolean bool;
    label74:
    label80:
    int m;
    label135:
    int j;
    label150:
    int k;
    if (((ad)localObject).getRuntime().Ee()) {
      if ((((ad)localObject).isFullScreen()) || (((ad)localObject).bvy()))
      {
        bool = true;
        parame.lEe = bool;
        if ((!((ad)localObject).isFullScreen()) && (!((ad)localObject).bvy())) {
          break label272;
        }
        bool = true;
        parame.lEf = bool;
        parame.KtV = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(47796);
            h.a(this.meB.getAppId(), this.meB.kxv, 38, "", bu.aRi(), 1, 0);
            AppMethodBeat.o(47796);
          }
        };
        parame.LsV = new e.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(47797);
            h.a(this.meB.getAppId(), this.meB.kxv, 37, "", bu.aRi(), 1, 0);
            AppMethodBeat.o(47797);
          }
        };
        parame = (ad)this.ckP;
        localObject = a.a.ag(parame.getRuntime());
        if (!n.f(parame)) {
          break label299;
        }
        m = 1;
        if (!parame.getRuntime().aXx().Ee()) {
          break label305;
        }
        j = 2;
        if (((a)localObject).bwn() != a.b.mkt.ordinal()) {
          break label322;
        }
        k = 1;
      }
    }
    for (;;)
    {
      label169:
      int n;
      label179:
      int i;
      if (o.f(parame))
      {
        n = 1;
        if (com.tencent.mm.plugin.appbrand.menu.p.dK(parame.getContext())) {
          break label350;
        }
        i = 1;
      }
      for (;;)
      {
        localObject = String.format("%d_%d_%d_%d_%d", new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(i) });
        h.a(parame.getAppId(), parame.kxv, 28, (String)localObject, bu.aRi(), 1, 0);
        AppMethodBeat.o(47798);
        return;
        bool = false;
        break;
        label272:
        bool = false;
        break label74;
        parame.lEe = ((ad)localObject).isFullScreen();
        parame.lEf = ((ad)localObject).isFullScreen();
        break label80;
        label299:
        m = 0;
        break label135;
        label305:
        if (b.f(parame))
        {
          j = 1;
          break label150;
        }
        j = 0;
        break label150;
        label322:
        if (((a)localObject).bwn() != a.b.mku.ordinal()) {
          break label402;
        }
        k = 2;
        break label169;
        n = 0;
        break label179;
        label350:
        localObject = parame.getRuntime().aXw();
        if (localObject == null) {
          i = 1;
        } else if ((((AppBrandSysConfigWC)localObject).kbD == null) || (((AppBrandSysConfigWC)localObject).kbD.length <= 0)) {
          i = 0;
        } else {
          i = localObject.kbD[0];
        }
      }
      label402:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s
 * JD-Core Version:    0.7.0.1
 */