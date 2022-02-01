package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.protocal.protobuf.dpc;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16})
public final class f$c
{
  public static Context a(k paramk)
  {
    AppMethodBeat.i(169558);
    p.h(paramk, "$this$notNullContext");
    Context localContext2 = paramk.getContext();
    Context localContext1 = localContext2;
    if (localContext2 == null)
    {
      paramk = ((kotlin.g.a.a)new f.c.c(paramk)).invoke();
      p.g(paramk, "{\n            this.runtime.appContext\n        }()");
      localContext1 = (Context)paramk;
    }
    AppMethodBeat.o(169558);
    return localContext1;
  }
  
  public static fdg a(fdg paramfdg, k paramk)
  {
    int j = 0;
    AppMethodBeat.i(169563);
    p.h(paramfdg, "$this$fill");
    p.h(paramk, "service");
    AppBrandRuntime localAppBrandRuntime = paramk.getRuntime();
    Object localObject = localAppBrandRuntime;
    if (!(localAppBrandRuntime instanceof com.tencent.luggage.sdk.d.d)) {
      localObject = null;
    }
    localObject = (com.tencent.luggage.sdk.d.d)localObject;
    int i;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.sdk.d.d)localObject).Nz();
      if (localObject != null)
      {
        i = ((AppBrandStatObject)localObject).scene;
        paramfdg.scene = i;
        if (!(paramk instanceof s)) {
          break label103;
        }
        i = 1;
      }
    }
    for (;;)
    {
      paramfdg.NyS = i;
      AppMethodBeat.o(169563);
      return paramfdg;
      i = 0;
      break;
      label103:
      i = j;
      if ((paramk instanceof ac)) {
        i = 2;
      }
    }
  }
  
  public static <R extends dpc> com.tencent.mm.vending.g.c<R> a(k paramk, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169560);
    p.h(paramk, "$this$runCgi");
    p.h(paramString, "url");
    p.h(parama, "request");
    p.h(paramClass, "clazz");
    Object localObject = paramk.M(com.tencent.mm.plugin.appbrand.networking.c.class);
    if (localObject == null) {
      p.hyc();
    }
    localObject = (com.tencent.mm.plugin.appbrand.networking.c)localObject;
    paramk.getAppId();
    paramk = ((com.tencent.mm.plugin.appbrand.networking.c)localObject).a(paramString, parama, paramClass);
    p.g(paramk, "this.customize(ICgiServi…is.appId, request, clazz)");
    AppMethodBeat.o(169560);
    return paramk;
  }
  
  public static void a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(230070);
    p.h(paramContext, "context");
    p.h(paramb, "dialog");
    MMHandlerThread.postToMainThread((Runnable)new f.c.d(paramString1, paramContext, paramString2, paramBitmap, paramb));
    AppMethodBeat.o(230070);
  }
  
  public static <_Var> void a(com.tencent.mm.vending.g.b paramb, com.tencent.mm.vending.g.c<_Var> paramc)
  {
    AppMethodBeat.i(169561);
    p.h(paramb, "$this$bridge");
    p.h(paramc, "pipeable");
    paramc.a((d.b)new f.c.a(paramb)).a((d.a)new f.c.b(paramb));
    AppMethodBeat.o(169561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f.c
 * JD-Core Version:    0.7.0.1
 */