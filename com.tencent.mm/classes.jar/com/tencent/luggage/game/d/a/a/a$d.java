package com.tencent.luggage.game.d.a.a;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.ui.MagicBrushView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.Log;

final class a$d
  implements MagicBrushView.c
{
  private boolean firstTime = true;
  
  private a$d(a parama) {}
  
  private void Pz()
  {
    AppMethodBeat.i(177433);
    d locald = (d)this.cuB.QK();
    if (locald != null)
    {
      Log.i("Luggage.AppBrandGameServiceLogicImp", "hy: on resizeWindow");
      locald.a(new t());
    }
    AppMethodBeat.o(177433);
  }
  
  public final void a(Object paramObject, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(178032);
    if (this.firstTime)
    {
      this.firstTime = false;
      c.b(this.cuB.getAppId(), KSProcessWeAppLaunch.stepSurfaceAvailable);
      AppMethodBeat.o(178032);
      return;
    }
    Pz();
    AppMethodBeat.o(178032);
  }
  
  public final void b(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130556);
    Pz();
    AppMethodBeat.o(130556);
  }
  
  public final void b(Object paramObject, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */