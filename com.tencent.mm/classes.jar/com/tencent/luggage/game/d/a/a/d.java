package com.tencent.luggage.game.d.a.a;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.sdk.platformtools.ac;

public class d
  extends com.tencent.luggage.sdk.b.a.c.a<c>
  implements com.tencent.luggage.game.d.a.a
{
  private boolean cac = false;
  
  public d(c paramc, t paramt)
  {
    super(paramc, paramt);
  }
  
  public final g BK()
  {
    AppMethodBeat.i(130603);
    g localg = super.BK();
    if ((localg == null) || (this.cac)) {}
    for (;;)
    {
      try
      {
        v localv = (v)localg.P(v.class);
        b localb = (b)((c)CX()).Q(b.class);
        if (localb == null) {
          continue;
        }
        localb.getMagicBrush().c((d.g.a.a)new d.f(localv.getIsolatePtr(), localv.LS(), localv.getUVLoopPtr()));
        bool = true;
      }
      catch (NullPointerException localNullPointerException)
      {
        ac.e("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", new Object[] { localNullPointerException });
        bool = false;
        continue;
      }
      ac.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", new Object[] { Boolean.valueOf(this.cac), Boolean.valueOf(bool) });
      AppMethodBeat.o(130603);
      return localg;
      ac.w("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
      continue;
      boolean bool = true;
    }
  }
  
  public final void BL()
  {
    AppMethodBeat.i(130604);
    super.BL();
    ac.i("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
    AppMethodBeat.o(130604);
  }
  
  public final String BM()
  {
    return "WAGameSubContext.js";
  }
  
  @JavascriptInterface
  public int allocNativeGlobal()
  {
    AppMethodBeat.i(130602);
    this.cac = true;
    int i = super.alloc();
    ac.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", new Object[] { Boolean.valueOf(this.cac), Integer.valueOf(i) });
    this.cac = false;
    AppMethodBeat.o(130602);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */