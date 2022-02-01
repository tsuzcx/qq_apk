package com.tencent.luggage.game.page.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.d.c;
import com.tencent.mm.plugin.appbrand.page.d.c.b;
import com.tencent.mm.plugin.appbrand.ui.r;

final class a
  implements c
{
  private final aa caZ;
  private c.b cba = null;
  
  public a(aa paramaa)
  {
    this.caZ = paramaa;
  }
  
  private void bq(boolean paramBoolean)
  {
    AppMethodBeat.i(130679);
    Object localObject = com.tencent.mm.sdk.f.a.jg(this.caZ.getContext());
    if (localObject == null)
    {
      AppMethodBeat.o(130679);
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    if (paramBoolean)
    {
      r.a((Window)localObject, true, true);
      AppMethodBeat.o(130679);
      return;
    }
    r.a((Window)localObject, false, false);
    AppMethodBeat.o(130679);
  }
  
  public final void BW()
  {
    AppMethodBeat.i(130678);
    if (this.cba == null) {
      if (!this.caZ.getRuntime().getAppConfig().jBB.jBQ) {
        break label78;
      }
    }
    label78:
    for (c.b localb = c.b.lGP;; localb = c.b.lGQ)
    {
      this.cba = localb;
      switch (1.cbb[this.cba.ordinal()])
      {
      default: 
        AppMethodBeat.o(130678);
        return;
      }
    }
    Cl();
    AppMethodBeat.o(130678);
    return;
    Cm();
    AppMethodBeat.o(130678);
  }
  
  public final void Cl()
  {
    AppMethodBeat.i(130676);
    this.cba = c.b.lGP;
    bq(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.caZ.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.caZ.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
    AppMethodBeat.o(130676);
  }
  
  public final void Cm()
  {
    AppMethodBeat.i(130677);
    this.cba = c.b.lGQ;
    bq(true);
    AppMethodBeat.o(130677);
  }
  
  public final c.b Cn()
  {
    return this.cba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */