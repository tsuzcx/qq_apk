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
  private final aa cec;
  private c.b ced = null;
  
  public a(aa paramaa)
  {
    this.cec = paramaa;
  }
  
  private void br(boolean paramBoolean)
  {
    AppMethodBeat.i(130679);
    Object localObject = com.tencent.mm.sdk.f.a.iV(this.cec.getContext());
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
  
  public final void CH()
  {
    AppMethodBeat.i(130676);
    this.ced = c.b.lgW;
    br(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.cec.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.cec.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
    AppMethodBeat.o(130676);
  }
  
  public final void CI()
  {
    AppMethodBeat.i(130677);
    this.ced = c.b.lgX;
    br(true);
    AppMethodBeat.o(130677);
  }
  
  public final c.b CJ()
  {
    return this.ced;
  }
  
  public final void Cs()
  {
    AppMethodBeat.i(130678);
    if (this.ced == null) {
      if (!this.cec.getRuntime().getAppConfig().jbo.jbD) {
        break label78;
      }
    }
    label78:
    for (c.b localb = c.b.lgW;; localb = c.b.lgX)
    {
      this.ced = localb;
      switch (1.cee[this.ced.ordinal()])
      {
      default: 
        AppMethodBeat.o(130678);
        return;
      }
    }
    CH();
    AppMethodBeat.o(130678);
    return;
    CI();
    AppMethodBeat.o(130678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */