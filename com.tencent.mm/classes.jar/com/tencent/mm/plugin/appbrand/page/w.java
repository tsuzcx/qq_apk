package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.b;
import com.tencent.mm.plugin.appbrand.menu.h;
import com.tencent.mm.plugin.appbrand.menu.h.a;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.menu.s;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;

public final class w
  extends v
{
  public w(ah paramah, List<com.tencent.mm.plugin.appbrand.menu.v> paramList)
  {
    super(paramah, paramList);
  }
  
  protected final void a(e parame)
  {
    AppMethodBeat.i(47798);
    super.a(parame);
    Object localObject = (ah)getPageView();
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
    if (((ah)localObject).getRuntime().Qv()) {
      if ((((ah)localObject).QT()) || (((ah)localObject).bEN()))
      {
        bool = true;
        parame.pMF = bool;
        if ((!((ah)localObject).QT()) && (!((ah)localObject).bEN())) {
          break label346;
        }
        bool = true;
        parame.pMG = bool;
        parame.XbB = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(47796);
            j.a(this.qqH.getAppId(), this.qqH.oxe, 38, "", Util.nowSecond(), 1, 0);
            AppMethodBeat.o(47796);
          }
        };
        parame.YmE = new e.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(47797);
            j.a(this.qqH.getAppId(), this.qqH.oxe, 37, "", Util.nowSecond(), 1, 0);
            AppMethodBeat.o(47797);
          }
        };
        parame = (ah)getPageView();
        localObject = a.a.ah(parame.getRuntime());
        if (!q.h(parame)) {
          break label373;
        }
        n = 1;
        if (!parame.getRuntime().bDy().Qv()) {
          break label379;
        }
        j = 2;
        switch (3.qeX[com.tencent.mm.plugin.appbrand.menu.e.g(parame).ordinal()])
        {
        default: 
          i = 1;
          if (((com.tencent.mm.plugin.appbrand.page.capsulebar.a)localObject).cfu() == a.b.qwL.ordinal()) {
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
      int i2;
      label234:
      int m;
      if (r.h(parame))
      {
        i1 = 1;
        localObject = h.qfd;
        if (!h.a.h(parame)) {
          break label439;
        }
        i2 = 1;
        if (s.ee(parame.getContext())) {
          break label445;
        }
        m = 1;
      }
      for (;;)
      {
        localObject = String.format("%d_%d_%d_%d_%d_%d_%d", new Object[] { Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i1), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(i2) });
        j.a(parame.getAppId(), parame.oxe, 28, (String)localObject, Util.nowSecond(), 1, 0);
        AppMethodBeat.o(47798);
        return;
        bool = false;
        break;
        label346:
        bool = false;
        break label74;
        parame.pMF = ((ah)localObject).QT();
        parame.pMG = ((ah)localObject).QT();
        break label80;
        label373:
        n = 0;
        break label135;
        label379:
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
        if (((com.tencent.mm.plugin.appbrand.page.capsulebar.a)localObject).cfu() != a.b.qwM.ordinal()) {
          break label478;
        }
        k = 2;
        break label209;
        i1 = 0;
        break label219;
        label439:
        i2 = 2;
        break label234;
        label445:
        localObject = parame.getRuntime().bDx();
        if (localObject == null) {
          m = 1;
        } else {
          m = com.tencent.mm.plugin.appbrand.config.a.nVL.a((AppBrandSysConfigWC)localObject);
        }
      }
      label478:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.w
 * JD-Core Version:    0.7.0.1
 */