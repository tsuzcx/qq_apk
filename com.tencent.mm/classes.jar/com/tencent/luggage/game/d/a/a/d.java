package com.tencent.luggage.game.d.a.a;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.sdk.platformtools.ae;

public class d
  extends com.tencent.luggage.sdk.b.a.c.a<c>
  implements com.tencent.luggage.game.d.a.a
{
  private boolean ckv = false;
  
  public d(c paramc, t paramt)
  {
    super(paramc, paramt);
  }
  
  public final g Dm()
  {
    AppMethodBeat.i(130603);
    g localg = super.Dm();
    if ((localg == null) || (this.ckv)) {}
    for (;;)
    {
      try
      {
        v localv = (v)localg.P(v.class);
        b localb = (b)((c)Ey()).Q(b.class);
        if (localb == null) {
          continue;
        }
        localb.getMagicBrush().d((d.g.a.a)new d.f(localv.getIsolatePtr(), localv.Nz(), localv.getUVLoopPtr()));
        bool = true;
      }
      catch (NullPointerException localNullPointerException)
      {
        ae.e("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", new Object[] { localNullPointerException });
        bool = false;
        continue;
      }
      ae.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", new Object[] { Boolean.valueOf(this.ckv), Boolean.valueOf(bool) });
      AppMethodBeat.o(130603);
      return localg;
      ae.w("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
      continue;
      boolean bool = true;
    }
  }
  
  public final void Dn()
  {
    AppMethodBeat.i(130604);
    super.Dn();
    ae.i("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
    AppMethodBeat.o(130604);
  }
  
  public final String Do()
  {
    return "WAGameSubContext.js";
  }
  
  @JavascriptInterface
  public int allocNativeGlobal()
  {
    AppMethodBeat.i(130602);
    this.ckv = true;
    int i = super.alloc();
    ae.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", new Object[] { Boolean.valueOf(this.ckv), Integer.valueOf(i) });
    this.ckv = false;
    AppMethodBeat.o(130602);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.d
 * JD-Core Version:    0.7.0.1
 */