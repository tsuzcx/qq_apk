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
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ConstantsAppBrandJsApiMsg;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "Lcom/tencent/mm/wxaprotocol/ConstantsWxaProtocol;", "windowAndroid", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "getWindowAndroid", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;)Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "setUserInfoListData", "", "context", "Landroid/content/Context;", "bitmap", "Landroid/graphics/Bitmap;", "userNickName", "", "scope", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog;", "bridge", "_Var", "Lcom/tencent/mm/vending/pipeline/Mario;", "pipeable", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "fill", "Lcom/tencent/mm/protocal/protobuf/WxaExternalInfo;", "service", "notNullContext", "runCgi", "R", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "url", "request", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "clazz", "Ljava/lang/Class;", "toByteString", "Lcom/tencent/mm/protobuf/ByteString;", "ApiInvokeInterruptCallbackException", "ComponentInterruptedException", "luggage-wechat-full-sdk_release"})
public abstract interface f
{
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper$ApiInvokeInterruptCallbackException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "luggage-wechat-full-sdk_release"})
  public static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper$ComponentInterruptedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "luggage-wechat-full-sdk_release"})
  public static final class b
    extends Exception
  {
    public static final b kdq;
    
    static
    {
      AppMethodBeat.i(169557);
      kdq = new b();
      AppMethodBeat.o(169557);
    }
  }
  
  @d.l(fNY={1, 1, 16})
  public static final class c
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
    
    public static eat a(eat parameat, h paramh)
    {
      int j = 0;
      AppMethodBeat.i(169563);
      k.h(parameat, "$this$fill");
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
        localObject = ((com.tencent.luggage.sdk.d.c)localObject).CB();
        if (localObject != null)
        {
          i = ((AppBrandStatObject)localObject).scene;
          parameat.scene = i;
          if (!(paramh instanceof q)) {
            break label103;
          }
          i = 1;
        }
      }
      for (;;)
      {
        parameat.Ggv = i;
        AppMethodBeat.o(169563);
        return parameat;
        i = 0;
        break;
        label103:
        i = j;
        if ((paramh instanceof aa)) {
          i = 2;
        }
      }
    }
    
    public static <R extends cqk> com.tencent.mm.vending.g.c<R> a(h paramh, String paramString, com.tencent.mm.bw.a parama, Class<R> paramClass)
    {
      AppMethodBeat.i(169560);
      k.h(paramh, "$this$runCgi");
      k.h(paramString, "url");
      k.h(parama, "request");
      k.h(paramClass, "clazz");
      paramh = paramh.K(com.tencent.mm.plugin.appbrand.networking.a.class);
      if (paramh == null) {
        k.fOy();
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
      ap.f((Runnable)new d(paramString1, paramContext, paramString2, paramBitmap, parami));
      AppMethodBeat.o(169562);
    }
    
    public static <_Var> void a(b paramb, com.tencent.mm.vending.g.c<_Var> paramc)
    {
      AppMethodBeat.i(169561);
      k.h(paramb, "$this$bridge");
      k.h(paramc, "pipeable");
      paramc.a((d.b)new a(paramb)).a((d.a)new b(paramb));
      AppMethodBeat.o(169561);
    }
    
    public static com.tencent.mm.plugin.appbrand.r.a.c b(h paramh)
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
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "_Var", "it", "kotlin.jvm.PlatformType", "onTerminate", "(Ljava/lang/Object;)V"})
    static final class a<T>
      implements d.b<_Var>
    {
      a(b paramb) {}
      
      public final void bo(_Var param_Var)
      {
        AppMethodBeat.i(169564);
        g.a(this.kdr, new Object[] { param_Var });
        AppMethodBeat.o(169564);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "_Var", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"})
    static final class b<T>
      implements d.a<Object>
    {
      b(b paramb) {}
      
      public final void cc(Object paramObject)
      {
        AppMethodBeat.i(169565);
        this.kdr.eb(paramObject);
        AppMethodBeat.o(169565);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/content/Context;", "invoke"})
    static final class c
      extends d.g.b.l
      implements d.g.a.a<Context>
    {
      c(h paramh)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class d
      implements Runnable
    {
      d(String paramString1, Context paramContext, String paramString2, Bitmap paramBitmap, i parami) {}
      
      public final void run()
      {
        AppMethodBeat.i(169567);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new o.a(this.kdt, paramContext.getResources().getString(2131755946), paramString2, paramBitmap));
        parami.bG((List)localArrayList);
        AppMethodBeat.o(169567);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f
 * JD-Core Version:    0.7.0.1
 */