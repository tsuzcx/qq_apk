package com.tencent.luggage.game.page.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.a.a;
import com.tencent.mm.plugin.appbrand.page.c.c;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.ui.t;

final class a
  implements c
{
  private final z cls;
  private c.b clt = null;
  
  public a(z paramz)
  {
    this.cls = paramz;
  }
  
  private void br(boolean paramBoolean)
  {
    AppMethodBeat.i(130679);
    Object localObject = com.tencent.mm.sdk.f.a.jw(this.cls.getContext());
    if (localObject == null)
    {
      AppMethodBeat.o(130679);
      return;
    }
    localObject = ((Activity)localObject).getWindow();
    if (paramBoolean)
    {
      t.a((Window)localObject, true, true);
      AppMethodBeat.o(130679);
      return;
    }
    t.a((Window)localObject, false, false);
    AppMethodBeat.o(130679);
  }
  
  public final void DN()
  {
    AppMethodBeat.i(130676);
    this.clt = c.b.mlB;
    br(false);
    if ((Build.VERSION.SDK_INT >= 21) && ((this.cls.getContext() instanceof Activity)))
    {
      Window localWindow = ((Activity)this.cls.getContext()).getWindow();
      if (localWindow != null)
      {
        localWindow.addFlags(-2147483648);
        localWindow.setStatusBarColor(0);
      }
    }
    AppMethodBeat.o(130676);
  }
  
  public final void DO()
  {
    AppMethodBeat.i(130677);
    this.clt = c.b.mlC;
    br(true);
    AppMethodBeat.o(130677);
  }
  
  public final c.b DP()
  {
    return this.clt;
  }
  
  public final void Dy()
  {
    AppMethodBeat.i(130678);
    if (this.clt == null) {
      if (!this.cls.getRuntime().getAppConfig().jYN.jZb) {
        break label78;
      }
    }
    label78:
    for (c.b localb = c.b.mlB;; localb = c.b.mlC)
    {
      this.clt = localb;
      switch (1.clu[this.clt.ordinal()])
      {
      default: 
        AppMethodBeat.o(130678);
        return;
      }
    }
    DN();
    AppMethodBeat.o(130678);
    return;
    DO();
    AppMethodBeat.o(130678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.a
 * JD-Core Version:    0.7.0.1
 */