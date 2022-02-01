package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.b;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;

public final class v
  extends u
{
  public v(ag paramag, List<t> paramList)
  {
    super(paramag, paramList);
  }
  
  protected final void a(e parame)
  {
    AppMethodBeat.i(47798);
    super.a(parame);
    Object localObject = (ag)this.cwK;
    boolean bool;
    label74:
    label80:
    int n;
    label135:
    int j;
    label150:
    int i;
    label190:
    int k;
    if (((ag)localObject).getRuntime().NA()) {
      if ((((ag)localObject).isFullScreen()) || (((ag)localObject).btO()))
      {
        bool = true;
        parame.mLN = bool;
        if ((!((ag)localObject).isFullScreen()) && (!((ag)localObject).btO())) {
          break label322;
        }
        bool = true;
        parame.mLO = bool;
        parame.PGl = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(47796);
            i.a(this.noV.getAppId(), this.noV.lBI, 38, "", Util.nowSecond(), 1, 0);
            AppMethodBeat.o(47796);
          }
        };
        parame.QNO = new e.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(47797);
            i.a(this.noV.getAppId(), this.noV.lBI, 37, "", Util.nowSecond(), 1, 0);
            AppMethodBeat.o(47797);
          }
        };
        parame = (ag)this.cwK;
        localObject = a.a.ah(parame.getRuntime());
        if (!o.g(parame)) {
          break label349;
        }
        n = 1;
        if (!parame.getRuntime().bsC().NA()) {
          break label355;
        }
        j = 2;
        switch (3.neE[com.tencent.mm.plugin.appbrand.menu.e.f(parame).ordinal()])
        {
        default: 
          i = 1;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.a)localObject).bSu() == a.b.nuQ.ordinal()) {
            k = 1;
          }
          break;
        }
      }
    }
    for (;;)
    {
      label209:
      int i1;
      label219:
      int m;
      if (p.g(parame))
      {
        i1 = 1;
        if (com.tencent.mm.plugin.appbrand.menu.q.ef(parame.getContext())) {
          break label415;
        }
        m = 1;
      }
      for (;;)
      {
        localObject = String.format("%d_%d_%d_%d_%d_%d", new Object[] { Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(i) });
        i.a(parame.getAppId(), parame.lBI, 28, (String)localObject, Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47798);
        return;
        bool = false;
        break;
        label322:
        bool = false;
        break label74;
        parame.mLN = ((ag)localObject).isFullScreen();
        parame.mLO = ((ag)localObject).isFullScreen();
        break label80;
        label349:
        n = 0;
        break label135;
        label355:
        if (b.g(parame))
        {
          j = 1;
          break label150;
        }
        j = 0;
        break label150;
        i = 1;
        break label190;
        i = 2;
        break label190;
        i = 0;
        break label190;
        if (((com.tencent.mm.plugin.appbrand.page.capsulebar.a)localObject).bSu() != a.b.nuR.ordinal()) {
          break label448;
        }
        k = 2;
        break label209;
        i1 = 0;
        break label219;
        label415:
        localObject = parame.getRuntime().bsB();
        if (localObject == null) {
          m = 1;
        } else {
          m = com.tencent.mm.plugin.appbrand.config.a.lbD.a((AppBrandSysConfigWC)localObject);
        }
      }
      label448:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.v
 * JD-Core Version:    0.7.0.1
 */