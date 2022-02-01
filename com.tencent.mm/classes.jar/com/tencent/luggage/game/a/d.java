package com.tencent.luggage.game.a;

import android.content.Context;
import com.tencent.luggage.game.b.c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.g.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.n.m;
import com.tencent.mm.plugin.appbrand.n.m.a;
import com.tencent.mm.plugin.appbrand.n.q;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/game/boot/MagicBrushSimple;", "", "androidContext", "Landroid/content/Context;", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;)V", "builder", "Lcom/tencent/magicbrush/MagicBrushBuilder;", "destroyTask", "Lcom/tencent/luggage/game/boot/MagicBrushSimple$DestroyTask;", "getJsRuntime", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "appbrandRuntimeReady", "", "runtime", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "awaitDestroyDone", "create", "destroy", "getJsThreadHandler", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "getMagicBrush", "getMagicBrushNullable", "getRawPointerOfJsRuntime", "Lkotlin/Function0;", "Lcom/tencent/magicbrush/V8RawPointer;", "onAppBrandRuntimeReady", "onConfig", "onCreate", "costMs", "", "DestroyTask", "luggage-wxa-game-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d
{
  private final Context eki;
  public final com.tencent.mm.plugin.appbrand.n.i ekj;
  volatile e ekk;
  private final f ekl;
  public final d.a ekm;
  
  public d(Context paramContext, com.tencent.mm.plugin.appbrand.n.i parami)
  {
    AppMethodBeat.i(130750);
    this.eki = paramContext;
    this.ekj = parami;
    this.ekl = new f();
    this.ekm = new d.a((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(130750);
  }
  
  protected void a(e parame, long paramLong)
  {
    AppMethodBeat.i(130745);
    s.u(parame, "magicbrush");
    AppMethodBeat.o(130745);
  }
  
  protected void a(f paramf)
  {
    AppMethodBeat.i(130744);
    s.u(paramf, "builder");
    paramf.context = this.eki;
    paramf.bf(com.tencent.mm.plugin.appbrand.af.i.mn());
    paramf.eHO = ((kotlin.g.a.a)new d.c((v)this.ekj.Z(v.class)));
    Object localObject = (q)this.ekj.Z(q.class);
    if (localObject == null)
    {
      paramf = (Throwable)new IllegalStateException("JsRuntime don't support JsThread addon".toString());
      AppMethodBeat.o(130744);
      throw paramf;
    }
    paramf.eHN = ((com.tencent.magicbrush.handler.a)new a((q)localObject));
    paramf.q((kotlin.g.a.b)d.ekp);
    localObject = com.tencent.mm.loader.i.b.bmz();
    s.s(localObject, "DATAROOT_SDCARD_PATH()");
    paramf.fW((String)localObject);
    AppMethodBeat.o(130744);
  }
  
  protected void a(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130746);
    s.u(paramAppBrandRuntime, "runtime");
    c.ekG.a((MBRuntime)this.ekk, paramAppBrandRuntime, true);
    AppMethodBeat.o(130746);
  }
  
  public final e aoP()
  {
    AppMethodBeat.i(130747);
    long l = Util.currentTicks();
    a(this.ekl);
    Object localObject = this.ekl.avz();
    s.checkNotNull(localObject);
    for (;;)
    {
      try
      {
        if (this.ekk == null)
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
    this.ekk = locale;
    ah localah = ah.aiuX;
    a(locale, Util.ticksToNow(l));
    AppMethodBeat.o(130747);
    return locale;
  }
  
  public final void b(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(130748);
    s.u(paramAppBrandRuntime, "runtime");
    a(paramAppBrandRuntime);
    AppMethodBeat.o(130748);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(130749);
    Log.i("MicroMsg.MagicBrush", "destroy");
    ((m)this.ekj.Z(m.class)).a((m.a)this.ekm);
    AppMethodBeat.o(130749);
  }
  
  public final e getMagicBrush()
  {
    AppMethodBeat.i(130743);
    e locale = this.ekk;
    s.checkNotNull(locale);
    AppMethodBeat.o(130743);
    return locale;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/magicbrush/MagicBrushConfig$ImageHandlerConfig;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<g.b, ah>
  {
    public static final d ekp;
    
    static
    {
      AppMethodBeat.i(130742);
      ekp = new d();
      AppMethodBeat.o(130742);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.a.d
 * JD-Core Version:    0.7.0.1
 */