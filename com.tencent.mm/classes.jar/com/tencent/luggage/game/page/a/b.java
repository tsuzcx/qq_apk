package com.tencent.luggage.game.page.a;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.b.h;
import com.tencent.mm.plugin.appbrand.page.d.c.b;

public final class b
  implements com.tencent.mm.plugin.appbrand.page.b.b, h
{
  private final a clt;
  private final aa clu;
  
  public b(aa paramaa)
  {
    AppMethodBeat.i(130682);
    this.clt = new a(paramaa);
    this.clu = paramaa;
    AppMethodBeat.o(130682);
  }
  
  public final void DK()
  {
    AppMethodBeat.i(130684);
    this.clu.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130680);
        b.a(b.this).DK();
        AppMethodBeat.o(130680);
      }
    });
    AppMethodBeat.o(130684);
  }
  
  public final void DL()
  {
    AppMethodBeat.i(130685);
    this.clu.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130681);
        b.a(b.this).DL();
        AppMethodBeat.o(130681);
      }
    });
    AppMethodBeat.o(130685);
  }
  
  public final boolean DN()
  {
    AppMethodBeat.i(130686);
    if (this.clt.DM() == c.b.mgD)
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
    this.clt.Dv();
    AppMethodBeat.o(130683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.b
 * JD-Core Version:    0.7.0.1
 */