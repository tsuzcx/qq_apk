package com.tencent.luggage.game.page.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.b.a;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.c.c;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.sdk.system.AndroidContextUtil;

final class a
  implements c
{
  private final ad cvV;
  private c.b cvW = null;
  
  public a(ad paramad)
  {
    this.cvV = paramad;
  }
  
  private void cd(boolean paramBoolean)
  {
    AppMethodBeat.i(130679);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.cvV.getContext());
    if (localObject == null)
    {
      AppMethodBeat.o(130679);
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    if (paramBoolean)
    {
      x.a((Window)localObject, true, true);
      AppMethodBeat.o(130679);
      return;
    }
    x.a((Window)localObject, false, false);
    AppMethodBeat.o(130679);
  }
  
  public final void PN()
  {
    AppMethodBeat.i(130678);
    if (this.cvW == null) {
      if (!this.cvV.getRuntime().getAppConfig().nVY.nWm) {
        break label78;
      }
    }
    label78:
    for (c.b localb = c.b.qyb;; localb = c.b.qyc)
    {
      this.cvW = localb;
      switch (1.cvX[this.cvW.ordinal()])
      {
      default: 
        AppMethodBeat.o(130678);
        return;
      }
    }
    Qb();
    AppMethodBeat.o(130678);
    return;
    Qc();
    AppMethodBeat.o(130678);
  }
  
  public final void Qb()
  {
    AppMethodBeat.i(130676);
    this.cvW = c.b.qyb;
    cd(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.cvV.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.cvV.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
    AppMethodBeat.o(130676);
  }
  
  public final void Qc()
  {
    AppMethodBeat.i(130677);
    this.cvW = c.b.qyc;
    cd(true);
    AppMethodBeat.o(130677);
  }
  
  public final c.b Qd()
  {
    return this.cvW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */