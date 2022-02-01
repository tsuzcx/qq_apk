package com.tencent.luggage.game.page.a;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.plugin.appbrand.page.z;

public final class b
  implements com.tencent.mm.plugin.appbrand.page.a.b, h
{
  private final a clv;
  private final z clw;
  
  public b(z paramz)
  {
    AppMethodBeat.i(130682);
    this.clv = new a(paramz);
    this.clw = paramz;
    AppMethodBeat.o(130682);
  }
  
  public final void DN()
  {
    AppMethodBeat.i(130684);
    this.clw.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130680);
        b.a(b.this).DN();
        AppMethodBeat.o(130680);
      }
    });
    AppMethodBeat.o(130684);
  }
  
  public final void DO()
  {
    AppMethodBeat.i(130685);
    this.clw.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(130681);
        b.a(b.this).DO();
        AppMethodBeat.o(130681);
      }
    });
    AppMethodBeat.o(130685);
  }
  
  public final boolean DQ()
  {
    AppMethodBeat.i(130686);
    if (this.clv.DP() == c.b.mlC)
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
    this.clv.Dy();
    AppMethodBeat.o(130683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.b
 * JD-Core Version:    0.7.0.1
 */