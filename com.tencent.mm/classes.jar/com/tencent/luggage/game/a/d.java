package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.af;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.f.a;
import com.tencent.magicbrush.f.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.m.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"})
public class d
{
  public volatile com.tencent.magicbrush.d bXV;
  private final e bXW;
  public final d.a bXX;
  private final Context bXY;
  protected final i bXZ;
  
  public d(Context paramContext, i parami)
  {
    AppMethodBeat.i(130750);
    this.bXY = paramContext;
    this.bXZ = parami;
    this.bXW = new e();
    this.bXX = new d.a((d.g.a.a)new b(this));
    AppMethodBeat.o(130750);
  }
  
  public final com.tencent.magicbrush.d AW()
  {
    int i = 0;
    AppMethodBeat.i(130747);
    long l = bs.Gn();
    a(this.bXW);
    Object localObject1 = this.bXW;
    Object localObject2 = com.tencent.magicbrush.d.cmm;
    k.h(localObject1, "builder");
    if (!com.tencent.magicbrush.internal.a.c((e)localObject1)) {}
    com.tencent.magicbrush.d locald;
    for (localObject1 = null;; locald = new com.tencent.magicbrush.d(locale, (byte)0))
    {
      if (localObject1 == null) {
        k.fOy();
      }
      try
      {
        if (this.bXV == null) {
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
    this.bXV = locald;
    localObject2 = y.KTp;
    a(locald, bs.aO(l));
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
    parame.context = this.bXY;
    parame.ab(g.bxg());
    parame.cmu = ((d.g.a.a)new c((v)this.bXZ.P(v.class)));
    Object localObject = (q)this.bXZ.P(q.class);
    if (localObject == null)
    {
      parame = (Throwable)new IllegalStateException("JsRuntime don't support JsThread addon".toString());
      AppMethodBeat.o(130744);
      throw parame;
    }
    parame.cmt = ((com.tencent.magicbrush.handler.a)new a((q)localObject));
    localObject = (d.g.a.b)d.bYc;
    k.h(localObject, "dls");
    ((d.g.a.b)localObject).ay(parame.cmA);
    localObject = com.tencent.mm.loader.j.b.aph();
    k.g(localObject, "CConstants.DATAROOT_SDCARD_PATH()");
    k.h(localObject, "<set-?>");
    parame.cmT.a(f.$$delegatedProperties[20], localObject);
    AppMethodBeat.o(130744);
  }
  
  protected void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130746);
    k.h(paramAppBrandRuntime, "runtime");
    com.tencent.luggage.game.b.b.bYj.a((MBRuntime)this.bXV, paramAppBrandRuntime, true);
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
    ac.i("MicroMsg.MagicBrush", "destroy");
    ((m)this.bXZ.P(m.class)).a((m.a)this.bXX);
    AppMethodBeat.o(130749);
  }
  
  public final com.tencent.magicbrush.d getMagicBrush()
  {
    AppMethodBeat.i(130743);
    com.tencent.magicbrush.d locald = this.bXV;
    if (locald == null) {
      k.fOy();
    }
    AppMethodBeat.o(130743);
    return locald;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/magicbrush/V8RawPointer;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<af>
  {
    c(v paramv)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<f.b, y>
  {
    public static final d bYc;
    
    static
    {
      AppMethodBeat.i(130742);
      bYc = new d();
      AppMethodBeat.o(130742);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.a.d
 * JD-Core Version:    0.7.0.1
 */