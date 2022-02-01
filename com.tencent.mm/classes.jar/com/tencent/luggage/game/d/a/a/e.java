package com.tencent.luggage.game.d.a.a;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d.d;
import com.tencent.magicbrush.e.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.appbrand.n.t;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.sdk.platformtools.Log;

public class e
  extends com.tencent.luggage.sdk.b.a.d.b<d>
  implements com.tencent.luggage.game.d.a.a
{
  private boolean emD = false;
  
  public e(d paramd, t paramt)
  {
    super(paramd, paramt);
  }
  
  @JavascriptInterface
  public int allocNativeGlobal()
  {
    AppMethodBeat.i(130602);
    this.emD = true;
    int i = super.alloc();
    Log.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", new Object[] { Boolean.valueOf(this.emD), Integer.valueOf(i) });
    this.emD = false;
    AppMethodBeat.o(130602);
    return i;
  }
  
  public final g apI()
  {
    AppMethodBeat.i(130603);
    g localg = super.apI();
    if ((localg == null) || (this.emD)) {}
    for (;;)
    {
      try
      {
        v localv = (v)localg.Z(v.class);
        b localb = (b)((d)ari()).aa(b.class);
        if (localb == null) {
          continue;
        }
        localb.getMagicBrush().v((kotlin.g.a.a)new e.g(localv.getIsolatePtr(), localv.aEn(), localv.getUVLoopPtr()));
        bool = true;
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.e("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", new Object[] { localNullPointerException });
        bool = false;
        continue;
      }
      Log.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", new Object[] { Boolean.valueOf(this.emD), Boolean.valueOf(bool) });
      AppMethodBeat.o(130603);
      return localg;
      Log.w("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
      continue;
      boolean bool = true;
    }
  }
  
  public final void apJ()
  {
    AppMethodBeat.i(130604);
    super.apJ();
    Log.i("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
    AppMethodBeat.o(130604);
  }
  
  public final String apK()
  {
    return "WAGameSubContext.js";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */