package com.tencent.mm.plugin.appbrand.page.c;

import android.app.Activity;
import com.tencent.luggage.sdk.config.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.concurrent.atomic.AtomicReference;

public class b
  implements c
{
  protected final ad enT;
  protected final AtomicReference<c.b> tDa;
  
  b(ad paramad)
  {
    AppMethodBeat.i(135314);
    this.tDa = new AtomicReference();
    this.tDa.set(c.b.tDb);
    this.enT = paramad;
    AppMethodBeat.o(135314);
  }
  
  public void apW()
  {
    AppMethodBeat.i(135316);
    if ((this.enT.qwF instanceof o))
    {
      Activity localActivity = AndroidContextUtil.castActivityOrNull(((o)this.enT.qwF).mContext);
      if (localActivity == null)
      {
        AppMethodBeat.o(135316);
        return;
      }
      if (((a)this.enT.aN(a.class)).eoK)
      {
        ae.C(localActivity, true);
        AppMethodBeat.o(135316);
        return;
      }
      ae.C(localActivity, false);
    }
    AppMethodBeat.o(135316);
  }
  
  public void aql() {}
  
  public void aqm() {}
  
  public final c.b aqn()
  {
    AppMethodBeat.i(135315);
    c.b localb = (c.b)this.tDa.get();
    AppMethodBeat.o(135315);
    return localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c.b
 * JD-Core Version:    0.7.0.1
 */