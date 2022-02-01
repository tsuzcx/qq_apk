package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.menu.b;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;

public final class t
  extends s
{
  public t(ae paramae, List<p> paramList)
  {
    super(paramae, paramList);
  }
  
  protected final void a(e parame)
  {
    AppMethodBeat.i(47798);
    super.a(parame);
    Object localObject = (ae)this.caw;
    boolean bool;
    label74:
    label80:
    int k;
    label126:
    int i;
    label141:
    int j;
    if (((ae)localObject).getRuntime().CC()) {
      if ((((ae)localObject).isFullScreen()) || (((ae)localObject).bqM()))
      {
        bool = true;
        parame.lcG = bool;
        if ((!((ae)localObject).isFullScreen()) && (!((ae)localObject).bqM())) {
          break label221;
        }
        bool = true;
        parame.lcH = bool;
        parame.Ihj = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(47796);
            g.a(this.lAJ.getAppId(), this.lAJ.jZJ, 38, "", bs.aNx(), 1, 0);
            AppMethodBeat.o(47796);
          }
        };
        parame.Jfm = new e.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(47797);
            g.a(this.lAJ.getAppId(), this.lAJ.jZJ, 37, "", bs.aNx(), 1, 0);
            AppMethodBeat.o(47797);
          }
        };
        parame = (ae)this.caw;
        if (!m.f(parame)) {
          break label248;
        }
        k = 1;
        if (!parame.getRuntime().aTS().CC()) {
          break label254;
        }
        i = 2;
        if (parame.lCz != b.a.lzm.ordinal()) {
          break label271;
        }
        j = 1;
      }
    }
    for (;;)
    {
      localObject = String.format("%d_%d_%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      g.a(parame.getAppId(), parame.jZJ, 28, (String)localObject, bs.aNx(), 1, 0);
      AppMethodBeat.o(47798);
      return;
      bool = false;
      break;
      label221:
      bool = false;
      break label74;
      parame.lcG = ((ae)localObject).isFullScreen();
      parame.lcH = ((ae)localObject).isFullScreen();
      break label80;
      label248:
      k = 0;
      break label126;
      label254:
      if (b.f(parame))
      {
        i = 1;
        break label141;
      }
      i = 0;
      break label141;
      label271:
      if (parame.lCz == b.a.lzn.ordinal()) {
        j = 2;
      } else {
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.t
 * JD-Core Version:    0.7.0.1
 */