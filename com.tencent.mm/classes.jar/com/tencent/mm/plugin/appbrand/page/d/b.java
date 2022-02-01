package com.tencent.mm.plugin.appbrand.page.d;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.a.o;
import com.tencent.mm.plugin.appbrand.ui.s;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final aa clq;
  protected final AtomicReference<c.b> mgB;
  
  b(aa paramaa)
  {
    AppMethodBeat.i(135314);
    this.mgB = new AtomicReference();
    this.mgB.set(c.b.mgC);
    this.clq = paramaa;
    AppMethodBeat.o(135314);
  }
  
  public void DK() {}
  
  public void DL() {}
  
  public final c.b DM()
  {
    AppMethodBeat.i(135315);
    c.b localb = (c.b)this.mgB.get();
    AppMethodBeat.o(135315);
    return localb;
  }
  
  public void Dv()
  {
    AppMethodBeat.i(135316);
    if ((this.clq.jzX instanceof o))
    {
      Activity localActivity = com.tencent.mm.sdk.f.a.jq(((o)this.clq.jzX).mContext);
      if (localActivity == null)
      {
        AppMethodBeat.o(135316);
        return;
      }
      if (((com.tencent.luggage.sdk.config.a)this.clq.ar(com.tencent.luggage.sdk.config.a.class)).cmk)
      {
        s.u(localActivity, true);
        AppMethodBeat.o(135316);
        return;
      }
      s.u(localActivity, false);
    }
    AppMethodBeat.o(135316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.d.b
 * JD-Core Version:    0.7.0.1
 */