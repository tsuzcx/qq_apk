package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ai;
import com.tencent.magicbrush.d;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"})
public class f
{
  public volatile d cip;
  private final e ciq;
  public final f.a cir;
  private final Context cis;
  protected final i cit;
  
  public f(Context paramContext, i parami)
  {
    AppMethodBeat.i(130750);
    this.cis = paramContext;
    this.cit = parami;
    this.ciq = new e();
    this.cir = new f.a((d.g.a.a)new b(this));
    AppMethodBeat.o(130750);
  }
  
  public final d Cy()
  {
    AppMethodBeat.i(130747);
    long l = bu.HQ();
    a(this.ciq);
    Object localObject = this.ciq.Hu();
    if (localObject == null) {
      p.gkB();
    }
    for (;;)
    {
      try
      {
        if (this.cip == null)
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
    this.cip = locald;
    z localz = z.Nhr;
    a(locald, bu.aO(l));
    AppMethodBeat.o(130747);
    return locald;
  }
  
  protected void a(d paramd, long paramLong)
  {
    AppMethodBeat.i(130745);
    p.h(paramd, "magicbrush");
    AppMethodBeat.o(130745);
  }
  
  protected void a(e parame)
  {
    AppMethodBeat.i(130744);
    p.h(parame, "builder");
    parame.context = this.cis;
    parame.ad(g.bCg());
    parame.cxC = ((d.g.a.a)new c((v)this.cit.P(v.class)));
    Object localObject = (com.tencent.mm.plugin.appbrand.jsruntime.q)this.cit.P(com.tencent.mm.plugin.appbrand.jsruntime.q.class);
    if (localObject == null)
    {
      parame = (Throwable)new IllegalStateException("JsRuntime don't support JsThread addon".toString());
      AppMethodBeat.o(130744);
      throw parame;
    }
    parame.cxB = ((com.tencent.magicbrush.handler.a)new c((com.tencent.mm.plugin.appbrand.jsruntime.q)localObject));
    parame.a((d.g.a.b)d.ciw);
    localObject = com.tencent.mm.loader.j.b.asj();
    p.g(localObject, "CConstants.DATAROOT_SDCARD_PATH()");
    parame.dE((String)localObject);
    AppMethodBeat.o(130744);
  }
  
  protected void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130746);
    p.h(paramAppBrandRuntime, "runtime");
    com.tencent.luggage.game.b.b.ciD.a((MBRuntime)this.cip, paramAppBrandRuntime, true);
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
    ae.i("MicroMsg.MagicBrush", "destroy");
    ((m)this.cit.P(m.class)).a((m.a)this.cir);
    AppMethodBeat.o(130749);
  }
  
  public final d getMagicBrush()
  {
    AppMethodBeat.i(130743);
    d locald = this.cip;
    if (locald == null) {
      p.gkB();
    }
    AppMethodBeat.o(130743);
    return locald;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<ai>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<com.tencent.magicbrush.f.b, z>
  {
    public static final d ciw;
    
    static
    {
      AppMethodBeat.i(130742);
      ciw = new d();
      AppMethodBeat.o(130742);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.f
 * JD-Core Version:    0.7.0.1
 */