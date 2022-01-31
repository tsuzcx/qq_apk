package com.tencent.luggage.game.e.a.a;

import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.plugin.appbrand.i.s;
import com.tencent.mm.sdk.platformtools.ab;

public class d
  extends com.tencent.luggage.sdk.b.a.c.a<c>
  implements com.tencent.luggage.game.e.a.a
{
  private boolean bBq = false;
  boolean bBr = false;
  
  public d(c paramc, q paramq)
  {
    super(paramc, paramq);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  @JavascriptInterface
  public int allocNativeGlobal()
  {
    AppMethodBeat.i(140464);
    this.bBq = true;
    int i = super.alloc();
    ab.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", new Object[] { Boolean.valueOf(this.bBq), Integer.valueOf(i) });
    this.bBq = false;
    AppMethodBeat.o(140464);
    return i;
  }
  
  public final g vk()
  {
    AppMethodBeat.i(140465);
    g localg = super.vk();
    if ((localg == null) || (this.bBq)) {}
    for (;;)
    {
      try
      {
        s locals = (s)localg.v(s.class);
        b localb = (b)((c)this.bEw).x(b.class);
        if (localb == null) {
          continue;
        }
        localb.getMBRuntime().bindTo(locals.getIsolatePtr(), locals.aGD());
        bool = true;
      }
      catch (NullPointerException localNullPointerException)
      {
        ab.e("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", new Object[] { localNullPointerException });
        bool = false;
        continue;
      }
      ab.i("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", new Object[] { Boolean.valueOf(this.bBq), Boolean.valueOf(bool) });
      AppMethodBeat.o(140465);
      return localg;
      ab.w("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
      continue;
      boolean bool = true;
    }
  }
  
  public final void vl()
  {
    AppMethodBeat.i(140466);
    super.vl();
    ab.i("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
    AppMethodBeat.o(140466);
  }
  
  public final String vm()
  {
    return "WAGameSubContext.js";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.e.a.a.d
 * JD-Core Version:    0.7.0.1
 */