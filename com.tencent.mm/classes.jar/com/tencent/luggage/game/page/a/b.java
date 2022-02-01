package com.tencent.luggage.game.page.a;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.d.c.b;

public final class b
  implements com.tencent.mm.plugin.appbrand.page.b.b, h
{
  private final a cbc;
  private final aa cbd;
  
  public b(aa paramaa)
  {
    AppMethodBeat.i(130682);
    this.cbc = new a(paramaa);
    this.cbd = paramaa;
    AppMethodBeat.o(130682);
  }
  
  public final void Cl()
  {
    AppMethodBeat.i(130684);
    this.cbd.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130680);
        b.a(b.this).Cl();
        AppMethodBeat.o(130680);
      }
    });
    AppMethodBeat.o(130684);
  }
  
  public final void Cm()
  {
    AppMethodBeat.i(130685);
    this.cbd.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130681);
        b.a(b.this).Cm();
        AppMethodBeat.o(130681);
      }
    });
    AppMethodBeat.o(130685);
  }
  
  public final boolean Co()
  {
    AppMethodBeat.i(130686);
    if (this.cbc.Cn() == c.b.lGQ)
    {
      AppMethodBeat.o(130686);
      return true;
    }
    AppMethodBeat.o(130686);
    return false;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(130683);
    this.cbc.BW();
    AppMethodBeat.o(130683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.b
 * JD-Core Version:    0.7.0.1
 */