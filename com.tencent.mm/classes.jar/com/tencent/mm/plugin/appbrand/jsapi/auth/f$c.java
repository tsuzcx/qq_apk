package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import com.tencent.mm.protocal.protobuf.cwj;
import com.tencent.mm.protocal.protobuf.eio;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16})
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
  
  public static eio a(eio parameio, h paramh)
  {
    int j = 0;
    AppMethodBeat.i(169563);
    p.h(parameio, "$this$fill");
    p.h(paramh, "service");
    AppBrandRuntime localAppBrandRuntime = paramh.getRuntime();
    Object localObject = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof com.tencent.luggage.sdk.d.d)) {
      localObject = null;
    }
    localObject = (com.tencent.luggage.sdk.d.d)localObject;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.sdk.d.d)localObject).Ed();
      if (localObject != null)
      {
        i = ((AppBrandStatObject)localObject).scene;
        parameio.scene = i;
        if (!(paramh instanceof r)) {
          break label103;
        }
        i = 1;
      }
    }
    for (;;)
    {
      parameio.IlP = i;
      AppMethodBeat.o(169563);
      return parameio;
      i = 0;
      break;
      label103:
      i = j;
      if ((paramh instanceof z)) {
        i = 2;
      }
    }
  }
  
  public static <R extends cwj> com.tencent.mm.vending.g.c<R> a(h paramh, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169560);
    p.h(paramh, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    paramh = paramh.K(com.tencent.mm.plugin.appbrand.networking.c.class);
    if (paramh == null) {
      p.gkB();
    }
    paramh = ((com.tencent.mm.plugin.appbrand.networking.c)paramh).a(paramString, parama, paramClass);
    p.g(paramh, "this.customize(ICgiServi…is.appId, request, clazz)");
    AppMethodBeat.o(169560);
    return paramh;
  }
  
  public static void a(final Context paramContext, final Bitmap paramBitmap, String paramString1, final String paramString2, final com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(220947);
    p.h(paramContext, "context");
    p.h(paramb, "dialog");
    ar.f((Runnable)new d(paramString1, paramContext, paramString2, paramBitmap, paramb));
    AppMethodBeat.o(220947);
  }
  
  public static <_Var> void a(com.tencent.mm.vending.g.b paramb, com.tencent.mm.vending.g.c<_Var> paramc)
  {
    AppMethodBeat.i(169561);
    p.h(paramb, "$this$bridge");
    p.h(paramc, "pipeable");
    paramc.a((d.b)new f.c.a(paramb)).a((d.a)new f.c.b(paramb));
    AppMethodBeat.o(169561);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/content/Context;", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<Context>
  {
    c(h paramh)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(String paramString1, Context paramContext, String paramString2, Bitmap paramBitmap, com.tencent.mm.plugin.appbrand.permission.a.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(169567);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new o.a(this.kBj, paramContext.getResources().getString(2131755946), paramString2, paramBitmap));
      paramb.setSelectListItem((List)localArrayList);
      AppMethodBeat.o(169567);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f.c
 * JD-Core Version:    0.7.0.1
 */