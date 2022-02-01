package com.tencent.mm.plugin.appbrand.page.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.ui.t;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final z cls;
  protected final AtomicReference<c.b> mlA;
  
  b(z paramz)
  {
    AppMethodBeat.i(135314);
    this.mlA = new AtomicReference();
    this.mlA.set(c.b.mlB);
    this.cls = paramz;
    AppMethodBeat.o(135314);
  }
  
  public void DN() {}
  
  public void DO() {}
  
  public final c.b DP()
  {
    AppMethodBeat.i(135315);
    c.b localb = (c.b)this.mlA.get();
    AppMethodBeat.o(135315);
    return localb;
  }
  
  public void Dy()
  {
    AppMethodBeat.i(135316);
    if ((this.cls.jDa instanceof o))
    {
      Activity localActivity = com.tencent.mm.sdk.f.a.jw(((o)this.cls.jDa).mContext);
      if (localActivity == null)
      {
        AppMethodBeat.o(135316);
        return;
      }
      if (((com.tencent.luggage.sdk.config.a)this.cls.ar(com.tencent.luggage.sdk.config.a.class)).cmm)
      {
        t.u(localActivity, true);
        AppMethodBeat.o(135316);
        return;
      }
      t.u(localActivity, false);
    }
    AppMethodBeat.o(135316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.b
 * JD-Core Version:    0.7.0.1
 */