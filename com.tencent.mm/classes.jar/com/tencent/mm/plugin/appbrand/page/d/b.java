package com.tencent.mm.plugin.appbrand.page.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.s.a.a.o;
import com.tencent.mm.plugin.appbrand.ui.r;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final aa cec;
  protected final AtomicReference<c.b> lgV;
  
  b(aa paramaa)
  {
    AppMethodBeat.i(135314);
    this.lgV = new AtomicReference();
    this.lgV.set(c.b.lgW);
    this.cec = paramaa;
    AppMethodBeat.o(135314);
  }
  
  public void CH() {}
  
  public void CI() {}
  
  public final c.b CJ()
  {
    AppMethodBeat.i(135315);
    c.b localb = (c.b)this.lgV.get();
    AppMethodBeat.o(135315);
    return localb;
  }
  
  public void Cs()
  {
    AppMethodBeat.i(135316);
    if ((this.cec.iGU instanceof o))
    {
      Activity localActivity = com.tencent.mm.sdk.f.a.iV(((o)this.cec.iGU).mContext);
      if (localActivity == null)
      {
        AppMethodBeat.o(135316);
        return;
      }
      if (((com.tencent.luggage.sdk.config.a)this.cec.ar(com.tencent.luggage.sdk.config.a.class)).ceW)
      {
        r.s(localActivity, true);
        AppMethodBeat.o(135316);
        return;
      }
      r.s(localActivity, false);
    }
    AppMethodBeat.o(135316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.b
 * JD-Core Version:    0.7.0.1
 */