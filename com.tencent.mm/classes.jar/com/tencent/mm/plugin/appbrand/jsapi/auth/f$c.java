package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.dvc;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

@d.l(fvt={1, 1, 16})
public final class f$c
{
  public static Context a(h paramh)
  {
    AppMethodBeat.i(169558);
    k.h(paramh, "$this$notNullContext");
    Context localContext2 = paramh.getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null)
    {
      paramh = ((d.g.a.a)new c(paramh)).invoke();
      k.g(paramh, "{\n            this.runtime.appContext\n        }()");
      localContext1 = (Context)paramh;
    }
    AppMethodBeat.o(169558);
    return localContext1;
  }
  
  public static dvc a(dvc paramdvc, h paramh)
  {
    int j = 0;
    AppMethodBeat.i(169563);
    k.h(paramdvc, "$this$fill");
    k.h(paramh, "service");
    AppBrandRuntime localAppBrandRuntime = paramh.getRuntime();
    Object localObject = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof com.tencent.luggage.sdk.d.c)) {
      localObject = null;
    }
    localObject = (com.tencent.luggage.sdk.d.c)localObject;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.sdk.d.c)localObject).CY();
      if (localObject != null)
      {
        i = ((AppBrandStatObject)localObject).scene;
        paramdvc.scene = i;
        if (!(paramh instanceof q)) {
          break label103;
        }
        i = 1;
      }
    }
    for (;;)
    {
      paramdvc.EJj = i;
      AppMethodBeat.o(169563);
      return paramdvc;
      i = 0;
      break;
      label103:
      i = j;
      if ((paramh instanceof aa)) {
        i = 2;
      }
    }
  }
  
  public static <R extends cld> com.tencent.mm.vending.g.c<R> a(h paramh, String paramString, com.tencent.mm.bx.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169560);
    k.h(paramh, "$this$runCgi");
    k.h(paramString, "url");
    k.h(parama, "request");
    k.h(paramClass, "clazz");
    paramh = paramh.K(com.tencent.mm.plugin.appbrand.networking.a.class);
    if (paramh == null) {
      k.fvU();
    }
    paramh = ((com.tencent.mm.plugin.appbrand.networking.a)paramh).a(paramString, parama, paramClass);
    k.g(paramh, "this.customize(ICgiServi…is.appId, request, clazz)");
    AppMethodBeat.o(169560);
    return paramh;
  }
  
  public static void a(final Context paramContext, final Bitmap paramBitmap, String paramString1, final String paramString2, final i parami)
  {
    AppMethodBeat.i(169562);
    k.h(paramContext, "context");
    k.h(parami, "dialog");
    aq.f((Runnable)new d(paramString1, paramContext, paramString2, paramBitmap, parami));
    AppMethodBeat.o(169562);
  }
  
  public static <_Var> void a(b paramb, com.tencent.mm.vending.g.c<_Var> paramc)
  {
    AppMethodBeat.i(169561);
    k.h(paramb, "$this$bridge");
    k.h(paramc, "pipeable");
    paramc.a((d.b)new f.c.a(paramb)).a((d.a)new f.c.b(paramb));
    AppMethodBeat.o(169561);
  }
  
  public static com.tencent.mm.plugin.appbrand.s.a.c b(h paramh)
  {
    AppMethodBeat.i(169559);
    k.h(paramh, "$this$windowAndroid");
    if (!(paramh instanceof com.tencent.mm.plugin.appbrand.d)) {
      paramh = null;
    }
    for (;;)
    {
      paramh = (com.tencent.mm.plugin.appbrand.d)paramh;
      if (paramh != null)
      {
        paramh = paramh.getWindowAndroid();
        AppMethodBeat.o(169559);
        return paramh;
      }
      AppMethodBeat.o(169559);
      return null;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/content/Context;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Context>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString1, Context paramContext, String paramString2, Bitmap paramBitmap, i parami) {}
    
    public final void run()
    {
      AppMethodBeat.i(169567);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new o.a(this.jCX, paramContext.getResources().getString(2131755946), paramString2, paramBitmap));
      parami.dA((List)localArrayList);
      AppMethodBeat.o(169567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f.c
 * JD-Core Version:    0.7.0.1
 */