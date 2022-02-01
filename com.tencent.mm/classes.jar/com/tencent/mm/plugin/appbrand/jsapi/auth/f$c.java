package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.foh;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16})
public final class f$c
{
  public static Context a(j paramj)
  {
    AppMethodBeat.i(169558);
    p.k(paramj, "$this$notNullContext");
    Context localContext2 = paramj.getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null)
    {
      paramj = ((kotlin.g.a.a)new c(paramj)).invoke();
      p.j(paramj, "{\n            this.runtime.appContext\n        }()");
      localContext1 = (Context)paramj;
    }
    AppMethodBeat.o(169558);
    return localContext1;
  }
  
  public static foh a(foh paramfoh, j paramj)
  {
    int j = 0;
    AppMethodBeat.i(169563);
    p.k(paramfoh, "$this$fill");
    p.k(paramj, "service");
    AppBrandRuntime localAppBrandRuntime = paramj.getRuntime();
    Object localObject = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof com.tencent.luggage.sdk.e.d)) {
      localObject = null;
    }
    localObject = (com.tencent.luggage.sdk.e.d)localObject;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.sdk.e.d)localObject).Qu();
      if (localObject != null)
      {
        i = ((AppBrandStatObject)localObject).scene;
        paramfoh.scene = i;
        if (!(paramj instanceof v)) {
          break label103;
        }
        i = 1;
      }
    }
    for (;;)
    {
      paramfoh.UMw = i;
      AppMethodBeat.o(169563);
      return paramfoh;
      i = 0;
      break;
      label103:
      i = j;
      if ((paramj instanceof ad)) {
        i = 2;
      }
    }
  }
  
  public static <R extends dyy> com.tencent.mm.vending.g.c<R> a(j paramj, String paramString, com.tencent.mm.cd.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169560);
    p.k(paramj, "$this$runCgi");
    p.k(paramString, "url");
    p.k(parama, "request");
    p.k(paramClass, "clazz");
    Object localObject = paramj.K(com.tencent.mm.plugin.appbrand.networking.c.class);
    if (localObject == null) {
      p.iCn();
    }
    localObject = (com.tencent.mm.plugin.appbrand.networking.c)localObject;
    paramj.getAppId();
    paramj = ((com.tencent.mm.plugin.appbrand.networking.c)localObject).a(paramString, parama, paramClass);
    p.j(paramj, "this.customize(ICgiServi…is.appId, request, clazz)");
    AppMethodBeat.o(169560);
    return paramj;
  }
  
  public static void a(final Context paramContext, final Bitmap paramBitmap, String paramString1, final String paramString2, final com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(235401);
    p.k(paramContext, "context");
    p.k(paramb, "dialog");
    MMHandlerThread.postToMainThread((Runnable)new d(paramString1, paramContext, paramString2, paramBitmap, paramb));
    AppMethodBeat.o(235401);
  }
  
  public static <_Var> void a(com.tencent.mm.vending.g.b paramb, com.tencent.mm.vending.g.c<_Var> paramc)
  {
    AppMethodBeat.i(169561);
    p.k(paramb, "$this$bridge");
    p.k(paramc, "pipeable");
    paramc.a((d.b)new a(paramb)).a((d.a)new b(paramb));
    AppMethodBeat.o(169561);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "_Var", "it", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Object;)V"})
  static final class a<T>
    implements d.b<_Var>
  {
    a(com.tencent.mm.vending.g.b paramb) {}
    
    public final void bz(_Var param_Var)
    {
      AppMethodBeat.i(169564);
      g.a(this.nKo, new Object[] { param_Var });
      AppMethodBeat.o(169564);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "_Var", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
  static final class b<T>
    implements d.a<Object>
  {
    b(com.tencent.mm.vending.g.b paramb) {}
    
    public final void cm(Object paramObject)
    {
      AppMethodBeat.i(169565);
      this.nKo.eo(paramObject);
      AppMethodBeat.o(169565);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/content/Context;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Context>
  {
    c(j paramj)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString1, Context paramContext, String paramString2, Bitmap paramBitmap, com.tencent.mm.plugin.appbrand.permission.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(169567);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new h.a(this.oBb, paramContext.getResources().getString(a.g.appbrand_authorize_item_decs_personal_information), paramString2, paramBitmap));
      paramb.setSelectListItem((List)localArrayList);
      AppMethodBeat.o(169567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f.c
 * JD-Core Version:    0.7.0.1
 */