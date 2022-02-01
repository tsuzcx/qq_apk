package com.tencent.mm.plugin.appbrand.page.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.ui.r;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final aa caZ;
  protected final AtomicReference<c.b> lGO;
  
  b(aa paramaa)
  {
    AppMethodBeat.i(135314);
    this.lGO = new AtomicReference();
    this.lGO.set(c.b.lGP);
    this.caZ = paramaa;
    AppMethodBeat.o(135314);
  }
  
  public void BW()
  {
    AppMethodBeat.i(135316);
    if ((this.caZ.jgX instanceof o))
    {
      Activity localActivity = com.tencent.mm.sdk.f.a.jg(((o)this.caZ.jgX).mContext);
      if (localActivity == null)
      {
        AppMethodBeat.o(135316);
        return;
      }
      if (((com.tencent.luggage.sdk.config.a)this.caZ.ar(com.tencent.luggage.sdk.config.a.class)).cbT)
      {
        r.s(localActivity, true);
        AppMethodBeat.o(135316);
        return;
      }
      r.s(localActivity, false);
    }
    AppMethodBeat.o(135316);
  }
  
  public void Cl() {}
  
  public void Cm() {}
  
  public final c.b Cn()
  {
    AppMethodBeat.i(135315);
    c.b localb = (c.b)this.lGO.get();
    AppMethodBeat.o(135315);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.b
 * JD-Core Version:    0.7.0.1
 */