package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"})
public class d
{
  public volatile com.tencent.magicbrush.d caY;
  private final e caZ;
  public final d.a cba;
  private final Context cbb;
  private final i cbc;
  
  public d(Context paramContext, i parami)
  {
    AppMethodBeat.i(130750);
    this.cbb = paramContext;
    this.cbc = parami;
    this.caZ = new e();
    this.cba = new d.a((d.g.a.a)new b(this));
    AppMethodBeat.o(130750);
  }
  
  public final com.tencent.magicbrush.d Bs()
  {
    int i = 0;
    AppMethodBeat.i(130747);
    long l = bt.GC();
    a(this.caZ);
    Object localObject1 = this.caZ;
    Object localObject2 = com.tencent.magicbrush.d.cph;
    k.h(localObject1, "builder");
    if (!com.tencent.magicbrush.internal.a.c((e)localObject1)) {}
    com.tencent.magicbrush.d locald;
    for (localObject1 = null;; locald = new com.tencent.magicbrush.d(locale, (byte)0))
    {
      if (localObject1 == null) {
        k.fvU();
      }
      try
      {
        if (this.caY == null) {
          i = 1;
        }
        if (i != 0) {
          break;
        }
        localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
        AppMethodBeat.o(130747);
        throw ((Throwable)localObject1);
      }
      finally
      {
        AppMethodBeat.o(130747);
      }
    }
    this.caY = locald;
    localObject2 = y.JfV;
    a(locald, bt.aS(l));
    AppMethodBeat.o(130747);
    return locald;
  }
  
  protected void a(com.tencent.magicbrush.d paramd, long paramLong)
  {
    AppMethodBeat.i(130745);
    k.h(paramd, "magicbrush");
    AppMethodBeat.o(130745);
  }
  
  protected void a(e parame)
  {
    AppMethodBeat.i(130744);
    k.h(parame, "builder");
    parame.context = this.cbb;
    parame.X(g.bqj());
    parame.cpp = ((d.g.a.a)new c((v)this.cbc.P(v.class)));
    Object localObject = (q)this.cbc.P(q.class);
    if (localObject == null)
    {
      parame = (Throwable)new IllegalStateException("JsRuntime don't support JsThread addon".toString());
      AppMethodBeat.o(130744);
      throw parame;
    }
    parame.cpo = ((com.tencent.magicbrush.handler.a)new a((q)localObject));
    localObject = (d.g.a.b)d.cbf;
    k.h(localObject, "dls");
    ((d.g.a.b)localObject).aA(parame.cpv);
    localObject = com.tencent.mm.loader.j.b.aib();
    k.g(localObject, "CConstants.SDCARD_ROOT()");
    k.h(localObject, "<set-?>");
    parame.cpO.a(f.$$delegatedProperties[20], localObject);
    AppMethodBeat.o(130744);
  }
  
  protected void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130746);
    k.h(paramAppBrandRuntime, "runtime");
    com.tencent.luggage.game.b.b.cbm.a((MBRuntime)this.caY, paramAppBrandRuntime, true);
    AppMethodBeat.o(130746);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130748);
    k.h(paramAppBrandRuntime, "runtime");
    a(paramAppBrandRuntime);
    AppMethodBeat.o(130748);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(130749);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MagicBrush", "destroy");
    ((m)this.cbc.P(m.class)).a((m.a)this.cba);
    AppMethodBeat.o(130749);
  }
  
  public final com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(130743);
    com.tencent.magicbrush.d locald = this.caY;
    if (locald == null) {
      k.fvU();
    }
    AppMethodBeat.o(130743);
    return locald;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<com.tencent.magicbrush.ad>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<f.b, y>
  {
    public static final d cbf;
    
    static
    {
      AppMethodBeat.i(130742);
      cbf = new d();
      AppMethodBeat.o(130742);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.a.d
 * JD-Core Version:    0.7.0.1
 */