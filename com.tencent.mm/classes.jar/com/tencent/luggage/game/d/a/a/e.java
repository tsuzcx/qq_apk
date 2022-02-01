package com.tencent.luggage.game.d.a.a;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.e.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.utils.s.a;
import com.tencent.mm.sdk.platformtools.Log;

public class e
  extends com.tencent.luggage.sdk.b.a.c.b<d>
  implements com.tencent.luggage.game.d.a.a
{
  private boolean cwq = false;
  
  public e(d paramd, t paramt)
  {
    super(paramd, paramt);
  }
  
  public final g MI()
  {
    AppMethodBeat.i(130603);
    g localg = super.MI();
    if ((localg == null) || (this.cwq)) {}
    for (;;)
    {
      try
      {
        v localv = (v)localg.R(v.class);
        b localb = (b)((d)NY()).S(b.class);
        if (localb == null) {
          continue;
        }
        localb.getMagicBrush().d((kotlin.g.a.a)new e.f(localv.getIsolatePtr(), localv.XK(), localv.getUVLoopPtr()));
        bool = true;
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.e("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", new Object[] { localNullPointerException });
        bool = false;
        continue;
      }
      Log.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", new Object[] { Boolean.valueOf(this.cwq), Boolean.valueOf(bool) });
      AppMethodBeat.o(130603);
      return localg;
      Log.w("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
      continue;
      boolean bool = true;
    }
  }
  
  public final void MJ()
  {
    AppMethodBeat.i(130604);
    super.MJ();
    Log.i("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
    AppMethodBeat.o(130604);
  }
  
  public final String MK()
  {
    return "WAGameSubContext.js";
  }
  
  @JavascriptInterface
  public int allocNativeGlobal()
  {
    AppMethodBeat.i(130602);
    this.cwq = true;
    int i = super.alloc();
    Log.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", new Object[] { Boolean.valueOf(this.cwq), Integer.valueOf(i) });
    this.cwq = false;
    AppMethodBeat.o(130602);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */