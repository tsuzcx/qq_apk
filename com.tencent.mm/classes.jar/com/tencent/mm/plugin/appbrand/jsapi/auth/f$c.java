package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16})
public final class f$c
{
  public static Context a(h paramh)
  {
    AppMethodBeat.i(169558);
    p.h(paramh, "$this$notNullContext");
    Context localContext2 = paramh.getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null)
    {
      paramh = ((d.g.a.a)new c(paramh)).invoke();
      p.g(paramh, "{\n            this.runtime.appContext\n        }()");
      localContext1 = (Context)paramh;
    }
    AppMethodBeat.o(169558);
    return localContext1;
  }
  
  public static egx a(egx paramegx, h paramh)
  {
    int j = 0;
    AppMethodBeat.i(169563);
    p.h(paramegx, "$this$fill");
    p.h(paramh, "service");
    AppBrandRuntime localAppBrandRuntime = paramh.getRuntime();
    Object localObject = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof com.tencent.luggage.sdk.d.c)) {
      localObject = null;
    }
    localObject = (com.tencent.luggage.sdk.d.c)localObject;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.sdk.d.c)localObject).Ea();
      if (localObject != null)
      {
        i = ((AppBrandStatObject)localObject).scene;
        paramegx.scene = i;
        if (!(paramh instanceof com.tencent.mm.plugin.appbrand.q)) {
          break label103;
        }
        i = 1;
      }
    }
    for (;;)
    {
      paramegx.HRI = i;
      AppMethodBeat.o(169563);
      return paramegx;
      i = 0;
      break;
      label103:
      i = j;
      if ((paramh instanceof aa)) {
        i = 2;
      }
    }
  }
  
  public static <R extends cvp> com.tencent.mm.vending.g.c<R> a(h paramh, String paramString, com.tencent.mm.bx.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169560);
    p.h(paramh, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    paramh = paramh.K(com.tencent.mm.plugin.appbrand.networking.b.class);
    if (paramh == null) {
      p.gfZ();
    }
    paramh = ((com.tencent.mm.plugin.appbrand.networking.b)paramh).a(paramString, parama, paramClass);
    p.g(paramh, "this.customize(ICgiServi…is.appId, request, clazz)");
    AppMethodBeat.o(169560);
    return paramh;
  }
  
  public static void a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(192346);
    p.h(paramContext, "context");
    p.h(paramb, "dialog");
    aq.f((Runnable)new f.c.d(paramString1, paramContext, paramString2, paramBitmap, paramb));
    AppMethodBeat.o(192346);
  }
  
  public static <_Var> void a(com.tencent.mm.vending.g.b paramb, com.tencent.mm.vending.g.c<_Var> paramc)
  {
    AppMethodBeat.i(169561);
    p.h(paramb, "$this$bridge");
    p.h(paramc, "pipeable");
    paramc.a((d.b)new a(paramb)).a((d.a)new b(paramb));
    AppMethodBeat.o(169561);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "_Var", "it", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Object;)V"})
  static final class a<T>
    implements d.b<_Var>
  {
    a(com.tencent.mm.vending.g.b paramb) {}
    
    public final void bq(_Var param_Var)
    {
      AppMethodBeat.i(169564);
      g.a(this.kxS, new Object[] { param_Var });
      AppMethodBeat.o(169564);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "_Var", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements d.a<Object>
  {
    b(com.tencent.mm.vending.g.b paramb) {}
    
    public final void ce(Object paramObject)
    {
      AppMethodBeat.i(169565);
      this.kxS.ee(paramObject);
      AppMethodBeat.o(169565);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/content/Context;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<Context>
  {
    c(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f.c
 * JD-Core Version:    0.7.0.1
 */