package com.tencent.luggage.game.page.a;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.b.f;
import com.tencent.mm.plugin.appbrand.page.c.c.b;
import com.tencent.mm.plugin.appbrand.page.v;

public final class b
  implements com.tencent.mm.plugin.appbrand.page.b.a, f
{
  private final a bCj;
  private final v bCk;
  
  public b(v paramv)
  {
    AppMethodBeat.i(140533);
    this.bCj = new a(paramv);
    this.bCk = paramv;
    AppMethodBeat.o(140533);
  }
  
  public final void onBackground() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDestroy() {}
  
  public final void onForeground()
  {
    AppMethodBeat.i(140534);
    this.bCj.vu();
    AppMethodBeat.o(140534);
  }
  
  public final void vJ()
  {
    AppMethodBeat.i(140535);
    this.bCk.runOnUiThread(new b.1(this));
    AppMethodBeat.o(140535);
  }
  
  public final void vK()
  {
    AppMethodBeat.i(140536);
    this.bCk.runOnUiThread(new b.2(this));
    AppMethodBeat.o(140536);
  }
  
  public final boolean vM()
  {
    AppMethodBeat.i(140537);
    if (this.bCj.vL() == c.b.iAB)
    {
      AppMethodBeat.o(140537);
      return true;
    }
    AppMethodBeat.o(140537);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.a.b
 * JD-Core Version:    0.7.0.1
 */