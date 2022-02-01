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
import com.tencent.mm.plugin.appbrand.ui.s;

final class a
  implements c
{
  private final aa clq;
  private c.b clr = null;
  
  public a(aa paramaa)
  {
    this.clq = paramaa;
  }
  
  private void br(boolean paramBoolean)
  {
    AppMethodBeat.i(130679);
    Object localObject = com.tencent.mm.sdk.f.a.jq(this.clq.getContext());
    if (localObject == null)
    {
      AppMethodBeat.o(130679);
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    if (paramBoolean)
    {
      s.a((Window)localObject, true, true);
      AppMethodBeat.o(130679);
      return;
    }
    s.a((Window)localObject, false, false);
    AppMethodBeat.o(130679);
  }
  
  public final void DK()
  {
    AppMethodBeat.i(130676);
    this.clr = c.b.mgC;
    br(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.clq.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.clq.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
    AppMethodBeat.o(130676);
  }
  
  public final void DL()
  {
    AppMethodBeat.i(130677);
    this.clr = c.b.mgD;
    br(true);
    AppMethodBeat.o(130677);
  }
  
  public final c.b DM()
  {
    return this.clr;
  }
  
  public final void Dv()
  {
    AppMethodBeat.i(130678);
    if (this.clr == null) {
      if (!this.clq.getRuntime().getAppConfig().jVw.jVM) {
        break label78;
      }
    }
    label78:
    for (c.b localb = c.b.mgC;; localb = c.b.mgD)
    {
      this.clr = localb;
      switch (1.cls[this.clr.ordinal()])
      {
      default: 
        AppMethodBeat.o(130678);
        return;
      }
    }
    DK();
    AppMethodBeat.o(130678);
    return;
    DL();
    AppMethodBeat.o(130678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */