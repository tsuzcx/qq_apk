package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.luggage.game.b.c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.al;
import com.tencent.magicbrush.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.m;
import com.tencent.mm.plugin.appbrand.m.m.a;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"})
public class d
{
  volatile com.tencent.magicbrush.e csn;
  private final com.tencent.magicbrush.f cso;
  public final a csp;
  private final Context csq;
  private final i csr;
  
  public d(Context paramContext, i parami)
  {
    AppMethodBeat.i(130750);
    this.csq = paramContext;
    this.csr = parami;
    this.cso = new com.tencent.magicbrush.f();
    this.csp = new a((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(130750);
  }
  
  public final com.tencent.magicbrush.e OH()
  {
    AppMethodBeat.i(130747);
    long l = Util.currentTicks();
    a(this.cso);
    Object localObject = this.cso.UW();
    if (localObject == null) {
      p.iCn();
    }
    for (;;)
    {
      try
      {
        if (this.csn == null)
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
    this.csn = locale;
    x localx = x.aazN;
    a(locale, Util.ticksToNow(l));
    AppMethodBeat.o(130747);
    return locale;
  }
  
  protected void a(com.tencent.magicbrush.e parame, long paramLong)
  {
    AppMethodBeat.i(130745);
    p.k(parame, "magicbrush");
    AppMethodBeat.o(130745);
  }
  
  protected void a(com.tencent.magicbrush.f paramf)
  {
    AppMethodBeat.i(130744);
    p.k(paramf, "builder");
    paramf.context = this.csq;
    paramf.ad(g.clS());
    paramf.cMv = ((kotlin.g.a.a)new c((v)this.csr.Q(v.class)));
    Object localObject = (com.tencent.mm.plugin.appbrand.m.q)this.csr.Q(com.tencent.mm.plugin.appbrand.m.q.class);
    if (localObject == null)
    {
      paramf = (Throwable)new IllegalStateException("JsRuntime don't support JsThread addon".toString());
      AppMethodBeat.o(130744);
      throw paramf;
    }
    paramf.cMu = ((com.tencent.magicbrush.handler.a)new a((com.tencent.mm.plugin.appbrand.m.q)localObject));
    paramf.a((kotlin.g.a.b)d.csu);
    localObject = com.tencent.mm.loader.j.b.aSL();
    p.j(localObject, "CConstants.DATAROOT_SDCARD_PATH()");
    paramf.ez((String)localObject);
    AppMethodBeat.o(130744);
  }
  
  protected void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130746);
    p.k(paramAppBrandRuntime, "runtime");
    c.csM.a((MBRuntime)this.csn, paramAppBrandRuntime, true);
    AppMethodBeat.o(130746);
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130748);
    p.k(paramAppBrandRuntime, "runtime");
    a(paramAppBrandRuntime);
    AppMethodBeat.o(130748);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(130749);
    Log.i("MicroMsg.MagicBrush", "destroy");
    ((m)this.csr.Q(m.class)).a((m.a)this.csp);
    AppMethodBeat.o(130749);
  }
  
  public final i getJsRuntime()
  {
    return this.csr;
  }
  
  public final com.tencent.magicbrush.e getMagicBrush()
  {
    AppMethodBeat.i(130743);
    com.tencent.magicbrush.e locale = this.csn;
    if (locale == null) {
      p.iCn();
    }
    AppMethodBeat.o(130743);
    return locale;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "Lcom/tencent/magicbrush/utils/SyncTask;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonDestroyListener$OnDestroyListener;", "fn", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onDestroy", "luggage-wxa-game-ext_release"})
  public static final class a
    extends com.tencent.magicbrush.utils.f
    implements m.a
  {
    public a(kotlin.g.a.a<x> parama)
    {
      super();
      AppMethodBeat.i(130738);
      AppMethodBeat.o(130738);
    }
    
    public final void onDestroy()
    {
      AppMethodBeat.i(130737);
      run();
      AppMethodBeat.o(130737);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<al>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<g.b, x>
  {
    public static final d csu;
    
    static
    {
      AppMethodBeat.i(130742);
      csu = new d();
      AppMethodBeat.o(130742);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.game.a.d
 * JD-Core Version:    0.7.0.1
 */