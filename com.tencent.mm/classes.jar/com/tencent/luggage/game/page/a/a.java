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
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.sdk.system.AndroidContextUtil;

final class a
  implements c
{
  private final ad enT;
  private c.b enU = null;
  
  public a(ad paramad)
  {
    this.enT = paramad;
  }
  
  private void cJ(boolean paramBoolean)
  {
    AppMethodBeat.i(130679);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.enT.getContext());
    if (localObject == null)
    {
      AppMethodBeat.o(130679);
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    if (paramBoolean)
    {
      ae.a((Window)localObject, true, true);
      AppMethodBeat.o(130679);
      return;
    }
    ae.a((Window)localObject, false, false);
    AppMethodBeat.o(130679);
  }
  
  public final void apW()
  {
    AppMethodBeat.i(130678);
    if (this.enU == null) {
      if (!this.enT.getRuntime().getAppConfig().qVI.qVX) {
        break label78;
      }
    }
    label78:
    for (c.b localb = c.b.tDb;; localb = c.b.tDc)
    {
      this.enU = localb;
      switch (1.enV[this.enU.ordinal()])
      {
      default: 
        AppMethodBeat.o(130678);
        return;
      }
    }
    aql();
    AppMethodBeat.o(130678);
    return;
    aqm();
    AppMethodBeat.o(130678);
  }
  
  public final void aql()
  {
    AppMethodBeat.i(130676);
    this.enU = c.b.tDb;
    cJ(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.enT.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.enT.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
    AppMethodBeat.o(130676);
  }
  
  public final void aqm()
  {
    AppMethodBeat.i(130677);
    this.enU = c.b.tDc;
    cJ(true);
    AppMethodBeat.o(130677);
  }
  
  public final c.b aqn()
  {
    return this.enU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */