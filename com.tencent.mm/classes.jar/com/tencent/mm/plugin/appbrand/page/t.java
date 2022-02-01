package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.b;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;

public final class t
  extends s
{
  public t(ae paramae, List<q> paramList)
  {
    super(paramae, paramList);
  }
  
  protected final void a(e parame)
  {
    AppMethodBeat.i(47798);
    super.a(parame);
    Object localObject = (ae)this.ckN;
    boolean bool;
    label74:
    label80:
    int m;
    label126:
    int j;
    label141:
    int k;
    if (((ae)localObject).getRuntime().Eb()) {
      if ((((ae)localObject).isFullScreen()) || (((ae)localObject).buM()))
      {
        bool = true;
        parame.lzG = bool;
        if ((!((ae)localObject).isFullScreen()) && (!((ae)localObject).buM())) {
          break label260;
        }
        bool = true;
        parame.lzH = bool;
        parame.JXC = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(47796);
            h.a(this.mai.getAppId(), this.mai.kuf, 38, "", bt.aQJ(), 1, 0);
            AppMethodBeat.o(47796);
          }
        };
        parame.KWx = new e.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(47797);
            h.a(this.mai.getAppId(), this.mai.kuf, 37, "", bt.aQJ(), 1, 0);
            AppMethodBeat.o(47797);
          }
        };
        parame = (ae)this.ckN;
        if (!m.f(parame)) {
          break label287;
        }
        m = 1;
        if (!parame.getRuntime().aXc().Eb()) {
          break label293;
        }
        j = 2;
        if (parame.mca != b.a.lYK.ordinal()) {
          break label310;
        }
        k = 1;
      }
    }
    for (;;)
    {
      label157:
      int n;
      label167:
      int i;
      if (n.f(parame))
      {
        n = 1;
        if (com.tencent.mm.plugin.appbrand.menu.o.dG(parame.getContext())) {
          break label335;
        }
        i = 1;
      }
      for (;;)
      {
        localObject = String.format("%d_%d_%d_%d_%d", new Object[] { Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(i) });
        h.a(parame.getAppId(), parame.kuf, 28, (String)localObject, bt.aQJ(), 1, 0);
        AppMethodBeat.o(47798);
        return;
        bool = false;
        break;
        label260:
        bool = false;
        break label74;
        parame.lzG = ((ae)localObject).isFullScreen();
        parame.lzH = ((ae)localObject).isFullScreen();
        break label80;
        label287:
        m = 0;
        break label126;
        label293:
        if (b.f(parame))
        {
          j = 1;
          break label141;
        }
        j = 0;
        break label141;
        label310:
        if (parame.mca != b.a.lYL.ordinal()) {
          break label387;
        }
        k = 2;
        break label157;
        n = 0;
        break label167;
        label335:
        localObject = parame.getRuntime().aXb();
        if (localObject == null) {
          i = 1;
        } else if ((((AppBrandSysConfigWC)localObject).jYo == null) || (((AppBrandSysConfigWC)localObject).jYo.length <= 0)) {
          i = 0;
        } else {
          i = localObject.jYo[0];
        }
      }
      label387:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t
 * JD-Core Version:    0.7.0.1
 */