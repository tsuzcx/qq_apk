package com.tencent.luggage.game.page.a;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.c.c.b;

public final class b
  implements com.tencent.mm.plugin.appbrand.page.a.b, h
{
  private final a enW;
  private final ad enX;
  
  public b(ad paramad)
  {
    AppMethodBeat.i(130682);
    this.enW = new a(paramad);
    this.enX = paramad;
    AppMethodBeat.o(130682);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb) {}
  
  public final void aql()
  {
    AppMethodBeat.i(130684);
    this.enX.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130680);
        b.a(b.this).aql();
        AppMethodBeat.o(130680);
      }
    });
    AppMethodBeat.o(130684);
  }
  
  public final void aqm()
  {
    AppMethodBeat.i(130685);
    this.enX.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130681);
        b.a(b.this).aqm();
        AppMethodBeat.o(130681);
      }
    });
    AppMethodBeat.o(130685);
  }
  
  public final boolean aqo()
  {
    AppMethodBeat.i(130686);
    if (this.enW.aqn() == c.b.tDc)
    {
      AppMethodBeat.o(130686);
      return true;
    }
    AppMethodBeat.o(130686);
    return false;
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(130683);
    this.enW.apW();
    AppMethodBeat.o(130683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.b
 * JD-Core Version:    0.7.0.1
 */