package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.menu.b;
import com.tencent.mm.plugin.appbrand.menu.m;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.List;

public final class s
  extends r
{
  public s(ae paramae, List<p> paramList)
  {
    super(paramae, paramList);
  }
  
  protected final void a(e parame)
  {
    AppMethodBeat.i(47798);
    super.a(parame);
    Object localObject = (ae)this.cdz;
    boolean bool;
    label74:
    label80:
    int k;
    label126:
    int i;
    label141:
    int j;
    if (((ae)localObject).getRuntime().CZ()) {
      if ((((ae)localObject).isFullScreen()) || (((ae)localObject).bjV()))
      {
        bool = true;
        parame.kBo = bool;
        if ((!((ae)localObject).isFullScreen()) && (!((ae)localObject).bjV())) {
          break label221;
        }
        bool = true;
        parame.kBp = bool;
        parame.GHn = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(47796);
            h.a(this.kYZ.getAppId(), this.kYZ.jzm, 38, "", bt.aGK(), 1, 0);
            AppMethodBeat.o(47796);
          }
        };
        parame.HES = new e.a()
        {
          public final void onClick()
          {
            AppMethodBeat.i(47797);
            h.a(this.kYZ.getAppId(), this.kYZ.jzm, 37, "", bt.aGK(), 1, 0);
            AppMethodBeat.o(47797);
          }
        };
        parame = (ae)this.cdz;
        if (!m.f(parame)) {
          break label248;
        }
        k = 1;
        if (!parame.getRuntime().aNc().CZ()) {
          break label254;
        }
        i = 2;
        if (parame.lba != b.a.kXC.ordinal()) {
          break label271;
        }
        j = 1;
      }
    }
    for (;;)
    {
      localObject = String.format("%d_%d_%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(j) });
      h.a(parame.getAppId(), parame.jzm, 28, (String)localObject, bt.aGK(), 1, 0);
      AppMethodBeat.o(47798);
      return;
      bool = false;
      break;
      label221:
      bool = false;
      break label74;
      parame.kBo = ((ae)localObject).isFullScreen();
      parame.kBp = ((ae)localObject).isFullScreen();
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
      if (parame.lba == b.a.kXD.ordinal()) {
        j = 2;
      } else {
        j = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.s
 * JD-Core Version:    0.7.0.1
 */