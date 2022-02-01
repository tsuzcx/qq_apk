package com.tencent.mm.plugin.appbrand.page.c;

import android.app.Activity;
import com.tencent.luggage.sdk.config.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final ad cvV;
  protected final AtomicReference<c.b> qya;
  
  b(ad paramad)
  {
    AppMethodBeat.i(135314);
    this.qya = new AtomicReference();
    this.qya.set(c.b.qyb);
    this.cvV = paramad;
    AppMethodBeat.o(135314);
  }
  
  public void PN()
  {
    AppMethodBeat.i(135316);
    if ((this.cvV.nxr instanceof o))
    {
      Activity localActivity = AndroidContextUtil.castActivityOrNull(((o)this.cvV.nxr).mContext);
      if (localActivity == null)
      {
        AppMethodBeat.o(135316);
        return;
      }
      if (((a)this.cvV.au(a.class)).cwK)
      {
        x.A(localActivity, true);
        AppMethodBeat.o(135316);
        return;
      }
      x.A(localActivity, false);
    }
    AppMethodBeat.o(135316);
  }
  
  public void Qb() {}
  
  public void Qc() {}
  
  public final c.b Qd()
  {
    AppMethodBeat.i(135315);
    c.b localb = (c.b)this.qya.get();
    AppMethodBeat.o(135315);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.b
 * JD-Core Version:    0.7.0.1
 */