package com.tencent.luggage.game.page.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.a.a;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.c.c;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.ui.o;

final class a
  implements c
{
  private final v bCg;
  private c.b bCh = null;
  
  public a(v paramv)
  {
    this.bCg = paramv;
  }
  
  private void ba(boolean paramBoolean)
  {
    AppMethodBeat.i(140530);
    if (!(this.bCg.getContext() instanceof Activity))
    {
      AppMethodBeat.o(140530);
      return;
    }
    Window localWindow = ((Activity)this.bCg.getContext()).getWindow();
    if (paramBoolean)
    {
      o.c(localWindow, true);
      AppMethodBeat.o(140530);
      return;
    }
    o.c(localWindow, false);
    AppMethodBeat.o(140530);
  }
  
  public final void vJ()
  {
    AppMethodBeat.i(140527);
    this.bCh = c.b.iAA;
    ba(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.bCg.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.bCg.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
    AppMethodBeat.o(140527);
  }
  
  public final void vK()
  {
    AppMethodBeat.i(140528);
    this.bCh = c.b.iAB;
    ba(true);
    AppMethodBeat.o(140528);
  }
  
  public final c.b vL()
  {
    return this.bCh;
  }
  
  public final void vu()
  {
    AppMethodBeat.i(140529);
    if (this.bCh == null) {
      if (!this.bCg.getRuntime().getAppConfig().hgQ.hhb) {
        break label78;
      }
    }
    label78:
    for (c.b localb = c.b.iAA;; localb = c.b.iAB)
    {
      this.bCh = localb;
      switch (a.1.bCi[this.bCh.ordinal()])
      {
      default: 
        AppMethodBeat.o(140529);
        return;
      }
    }
    vJ();
    AppMethodBeat.o(140529);
    return;
    vK();
    AppMethodBeat.o(140529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */