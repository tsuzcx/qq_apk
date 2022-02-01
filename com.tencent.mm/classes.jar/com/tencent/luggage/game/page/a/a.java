package com.tencent.luggage.game.page.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.b;
import com.tencent.mm.plugin.appbrand.config.b.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.c.c;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.sdk.system.AndroidContextUtil;

final class a
  implements c
{
  private final ac cxn;
  private c.b cxo = null;
  
  public a(ac paramac)
  {
    this.cxn = paramac;
  }
  
  private void bT(boolean paramBoolean)
  {
    AppMethodBeat.i(130679);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.cxn.getContext());
    if (localObject == null)
    {
      AppMethodBeat.o(130679);
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    if (paramBoolean)
    {
      y.a((Window)localObject, true, true);
      AppMethodBeat.o(130679);
      return;
    }
    y.a((Window)localObject, false, false);
    AppMethodBeat.o(130679);
  }
  
  public final void MV()
  {
    AppMethodBeat.i(130678);
    if (this.cxo == null) {
      if (!this.cxn.getRuntime().getAppConfig().lbP.lcd) {
        break label78;
      }
    }
    label78:
    for (c.b localb = c.b.nvZ;; localb = c.b.nwa)
    {
      this.cxo = localb;
      switch (1.cxp[this.cxo.ordinal()])
      {
      default: 
        AppMethodBeat.o(130678);
        return;
      }
    }
    Nj();
    AppMethodBeat.o(130678);
    return;
    Nk();
    AppMethodBeat.o(130678);
  }
  
  public final void Nj()
  {
    AppMethodBeat.i(130676);
    this.cxo = c.b.nvZ;
    bT(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.cxn.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.cxn.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
    AppMethodBeat.o(130676);
  }
  
  public final void Nk()
  {
    AppMethodBeat.i(130677);
    this.cxo = c.b.nwa;
    bT(true);
    AppMethodBeat.o(130677);
  }
  
  public final c.b Nl()
  {
    return this.cxo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */