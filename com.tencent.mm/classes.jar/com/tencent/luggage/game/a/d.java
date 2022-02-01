package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"})
public class d
{
  public volatile com.tencent.magicbrush.d cin;
  private final e cio;
  public final d.a cip;
  private final Context ciq;
  protected final i cir;
  
  public d(Context paramContext, i parami)
  {
    AppMethodBeat.i(130750);
    this.ciq = paramContext;
    this.cir = parami;
    this.cio = new e();
    this.cip = new d.a((d.g.a.a)new b(this));
    AppMethodBeat.o(130750);
  }
  
  public final com.tencent.magicbrush.d Cv()
  {
    AppMethodBeat.i(130747);
    long l = bt.HI();
    a(this.cio);
    Object localObject = this.cio.Ho();
    if (localObject == null) {
      p.gfZ();
    }
    for (;;)
    {
      try
      {
        if (this.cin == null)
        {
          i = 1;
          if (i != 0) {
            break;
          }
          localObject = (Throwable)new IllegalStateException("Check failed.".toString());
          AppMethodBeat.o(130747);
          throw ((Throwable)localObject);
        }
      }
      finally
      {
        AppMethodBeat.o(130747);
      }
      int i = 0;
    }
    this.cin = locald;
    z localz = z.MKo;
    a(locald, bt.aO(l));
    AppMethodBeat.o(130747);
    return locald;
  }
  
  protected void a(com.tencent.magicbrush.d paramd, long paramLong)
  {
    AppMethodBeat.i(130745);
    p.h(paramd, "magicbrush");
    AppMethodBeat.o(130745);
  }
  
  protected void a(e parame)
  {
    AppMethodBeat.i(130744);
    p.h(parame, "builder");
    parame.context = this.ciq;
    parame.ad(g.bBm());
    parame.cwX = ((d.g.a.a)new d.c((v)this.cir.P(v.class)));
    Object localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)this.cir.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
    if (localObject == null)
    {
      parame = (Throwable)new IllegalStateException("JsRuntime don't support JsThread addon".toString());
      AppMethodBeat.o(130744);
      throw parame;
    }
    parame.cwW = ((com.tencent.magicbrush.handler.a)new a((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject));
    parame.a((d.g.a.b)d.ciu);
    localObject = com.tencent.mm.loader.j.b.arU();
    p.g(localObject, "CConstants.DATAROOT_SDCARD_PATH()");
    parame.dB((String)localObject);
    AppMethodBeat.o(130744);
  }
  
  protected void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130746);
    p.h(paramAppBrandRuntime, "runtime");
    com.tencent.luggage.game.b.b.ciB.a((MBRuntime)this.cin, paramAppBrandRuntime, true);
    AppMethodBeat.o(130746);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130748);
    p.h(paramAppBrandRuntime, "runtime");
    a(paramAppBrandRuntime);
    AppMethodBeat.o(130748);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(130749);
    ad.i("MicroMsg.MagicBrush", "destroy");
    ((m)this.cir.P(m.class)).a((m.a)this.cip);
    AppMethodBeat.o(130749);
  }
  
  public final com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(130743);
    com.tencent.magicbrush.d locald = this.cin;
    if (locald == null) {
      p.gfZ();
    }
    AppMethodBeat.o(130743);
    return locald;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<f.b, z>
  {
    public static final d ciu;
    
    static
    {
      AppMethodBeat.i(130742);
      ciu = new d();
      AppMethodBeat.o(130742);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.a.d
 * JD-Core Version:    0.7.0.1
 */