package com.tencent.luggage.game.d.a.a;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.magicbrush.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.utils.u.a;
import com.tencent.mm.sdk.platformtools.Log;

public class e
  extends com.tencent.luggage.sdk.b.a.c.b<d>
  implements com.tencent.luggage.game.d.a.a
{
  private boolean cuL = false;
  
  public e(d paramd, t paramt)
  {
    super(paramd, paramt);
  }
  
  public final g PA()
  {
    AppMethodBeat.i(130603);
    g localg = super.PA();
    if ((localg == null) || (this.cuL)) {}
    for (;;)
    {
      try
      {
        v localv = (v)localg.Q(v.class);
        b localb = (b)((d)QW()).R(b.class);
        if (localb == null) {
          continue;
        }
        localb.getMagicBrush().d((kotlin.g.a.a)new e.g(localv.getIsolatePtr(), localv.acn(), localv.getUVLoopPtr()));
        bool = true;
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.e("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", new Object[] { localNullPointerException });
        bool = false;
        continue;
      }
      Log.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", new Object[] { Boolean.valueOf(this.cuL), Boolean.valueOf(bool) });
      AppMethodBeat.o(130603);
      return localg;
      Log.w("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
      continue;
      boolean bool = true;
    }
  }
  
  public final void PB()
  {
    AppMethodBeat.i(130604);
    super.PB();
    Log.i("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
    AppMethodBeat.o(130604);
  }
  
  public final String PC()
  {
    return "WAGameSubContext.js";
  }
  
  @JavascriptInterface
  public int allocNativeGlobal()
  {
    AppMethodBeat.i(130602);
    this.cuL = true;
    int i = super.alloc();
    Log.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", new Object[] { Boolean.valueOf(this.cuL), Integer.valueOf(i) });
    this.cuL = false;
    AppMethodBeat.o(130602);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */