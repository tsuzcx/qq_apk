package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.aj;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"})
public class d
{
  volatile e cui;
  private final f cuj;
  public final d.a cuk;
  private final Context cul;
  protected final i cum;
  
  public d(Context paramContext, i parami)
  {
    AppMethodBeat.i(130750);
    this.cul = paramContext;
    this.cum = parami;
    this.cuj = new f();
    this.cuk = new d.a((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(130750);
  }
  
  public final e LQ()
  {
    AppMethodBeat.i(130747);
    long l = Util.currentTicks();
    a(this.cuj);
    Object localObject = this.cuj.Rm();
    if (localObject == null) {
      p.hyc();
    }
    for (;;)
    {
      try
      {
        if (this.cui == null)
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
    this.cui = locale;
    x localx = x.SXb;
    a(locale, Util.ticksToNow(l));
    AppMethodBeat.o(130747);
    return locale;
  }
  
  protected void a(e parame, long paramLong)
  {
    AppMethodBeat.i(130745);
    p.h(parame, "magicbrush");
    AppMethodBeat.o(130745);
  }
  
  protected void a(f paramf)
  {
    AppMethodBeat.i(130744);
    p.h(paramf, "builder");
    paramf.context = this.cul;
    paramf.ae(g.bZk());
    paramf.cLK = ((kotlin.g.a.a)new c((v)this.cum.R(v.class)));
    Object localObject = (com.tencent.mm.plugin.appbrand.m.q)this.cum.R(com.tencent.mm.plugin.appbrand.m.q.class);
    if (localObject == null)
    {
      paramf = (Throwable)new IllegalStateException("JsRuntime don't support JsThread addon".toString());
      AppMethodBeat.o(130744);
      throw paramf;
    }
    paramf.cLJ = ((com.tencent.magicbrush.handler.a)new a((com.tencent.mm.plugin.appbrand.m.q)localObject));
    paramf.a((kotlin.g.a.b)d.cup);
    localObject = com.tencent.mm.loader.j.b.aKJ();
    p.g(localObject, "CConstants.DATAROOT_SDCARD_PATH()");
    paramf.dY((String)localObject);
    AppMethodBeat.o(130744);
  }
  
  protected void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130746);
    p.h(paramAppBrandRuntime, "runtime");
    com.tencent.luggage.game.b.b.cux.a((MBRuntime)this.cui, paramAppBrandRuntime, true);
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
    Log.i("MicroMsg.MagicBrush", "destroy");
    ((m)this.cum.R(m.class)).a((m.a)this.cuk);
    AppMethodBeat.o(130749);
  }
  
  public final e getMagicBrush()
  {
    AppMethodBeat.i(130743);
    e locale = this.cui;
    if (locale == null) {
      p.hyc();
    }
    AppMethodBeat.o(130743);
    return locale;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<aj>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<g.b, x>
  {
    public static final d cup;
    
    static
    {
      AppMethodBeat.i(130742);
      cup = new d();
      AppMethodBeat.o(130742);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.game.a.d
 * JD-Core Version:    0.7.0.1
 */