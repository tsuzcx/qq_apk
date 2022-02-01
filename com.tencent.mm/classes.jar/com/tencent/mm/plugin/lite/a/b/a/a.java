package com.tencent.mm.plugin.lite.a.b.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppAppBrandComponentImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "mAppBrandConfig", "Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppAppBrandConfig;", "mAppBrandJsRuntime", "Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppAppBrandJsRuntime;", "mHandler", "Landroid/os/Handler;", "attachConfig", "", "config", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "configs", "", "attachEnvContext", "", "context", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "callback", "callbackId", "", "data", "", "checkIsActivatedForEval", "api", "JsRt", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonExecutable;", "cleanup", "customize", "T", "Lcom/tencent/luggage/base/ICustomize;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/luggage/base/ICustomize;", "dispatch", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "src", "getAppId", "getAppState", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "getAsyncHandler", "getComponentId", "getConfig", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandConfig;", "getContext", "Landroid/content/Context;", "getDialogContainer", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "getEnvContext", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandEnvContext;", "getFileSystem", "Lcom/tencent/mm/plugin/appbrand/appstorage/IFileSystem;", "getInterceptor", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent$Interceptor;", "getJsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "invokeJsApi", "appId", "Lorg/json/JSONObject;", "isFromView", "isRunning", "publish", "dst", "", "scheduleToUiThread", "runnable", "Ljava/lang/Runnable;", "scheduleToUiThreadDelayed", "delayMs", "", "setEvalInterceptor", "handler", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent$EvalInterceptor;", "setInterceptor", "interceptor", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements f
{
  public static final a JZK;
  private c JZL;
  private b JZM;
  private Handler mHandler;
  
  static
  {
    AppMethodBeat.i(271577);
    JZK = new a((byte)0);
    AppMethodBeat.o(271577);
  }
  
  public a()
  {
    AppMethodBeat.i(271573);
    this.mHandler = new Handler(Looper.getMainLooper());
    this.JZL = new c();
    this.JZM = new b();
    AppMethodBeat.o(271573);
  }
  
  public final <T extends com.tencent.luggage.a.b> T T(Class<T> paramClass)
  {
    AppMethodBeat.i(271665);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "customize");
    AppMethodBeat.o(271665);
    return null;
  }
  
  public final void V(Runnable paramRunnable)
  {
    AppMethodBeat.i(271660);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "scheduleToUiThread");
    AppMethodBeat.o(271660);
  }
  
  public final void a(bc parambc)
  {
    AppMethodBeat.i(271586);
    if (parambc == null) {}
    for (parambc = null;; parambc = parambc.getName())
    {
      Log.i("WxaLiteApp.LiteAppAppBrandComponent", "dispatch event:%s", new Object[] { parambc });
      AppMethodBeat.o(271586);
      return;
    }
  }
  
  public final void a(bc parambc, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(271608);
    if (parambc == null) {}
    for (parambc = null;; parambc = parambc.getName())
    {
      Log.i("WxaLiteApp.LiteAppAppBrandComponent", "publish event:%s dst:%s", new Object[] { parambc, String.valueOf(paramArrayOfInt) });
      AppMethodBeat.o(271608);
      return;
    }
  }
  
  public final boolean a(n paramn)
  {
    AppMethodBeat.i(271650);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "attachEnvContext");
    AppMethodBeat.o(271650);
    return true;
  }
  
  public final boolean a(String paramString, o paramo)
  {
    AppMethodBeat.i(271582);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "checkIsActivatedForEval %s", new Object[] { paramString });
    AppMethodBeat.o(271582);
    return true;
  }
  
  public final <T extends m> T aN(Class<T> paramClass)
  {
    AppMethodBeat.i(271646);
    if (paramClass == null) {}
    for (Object localObject = null;; localObject = paramClass.getName())
    {
      Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getConfig clazz name:%s", new Object[] { localObject });
      m localm = (m)this.JZM;
      localObject = localm;
      if (localm == null) {
        localObject = localm;
      }
      try
      {
        localm = (m)org.a.a.cQ(paramClass).kJE().object;
        localObject = localm;
        if (localm != null)
        {
          localObject = localm;
          Log.i("WxaLiteApp.LiteAppAppBrandComponent", "attachConfig");
          localObject = localm;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          s.checkNotNull(paramClass);
          Log.e("WxaLiteApp.LiteAppAppBrandComponent", "Make sure %s has default constructor", new Object[] { paramClass.getName() });
        }
      }
      AppMethodBeat.o(271646);
      return localObject;
    }
  }
  
  public final <T extends n> T aO(Class<T> paramClass)
  {
    AppMethodBeat.i(271648);
    s.u(paramClass, "clazz");
    paramClass = (Throwable)new q("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(271648);
    throw paramClass;
  }
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(271600);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "publish event:%s data:%s dst:%d", new Object[] { paramString1, paramString2, paramArrayOfInt });
    AppMethodBeat.o(271600);
  }
  
  public final void cJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271589);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "dispatch event:%s data:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(271589);
  }
  
  public final void callback(int paramInt, String paramString)
  {
    AppMethodBeat.i(271612);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "callback callbackId:%s dst:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    g localg = g.fTY();
    if (localg.JZV.containsKey(Integer.valueOf(paramInt)))
    {
      com.tencent.liteapp.jsapi.b localb = (com.tencent.liteapp.jsapi.b)localg.JZV.get(Integer.valueOf(paramInt));
      com.tencent.mm.plugin.lite.c.jsApiCallback(localb.mAppId, localb.efW, localb.efX, paramInt, paramString, false, true);
      localg.JZV.remove(Integer.valueOf(paramInt));
    }
    AppMethodBeat.o(271612);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(271594);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "dispatch event:%s data:%s src:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    AppMethodBeat.o(271594);
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(271628);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getAppId");
    AppMethodBeat.o(271628);
    return "AppId";
  }
  
  public final com.tencent.mm.plugin.appbrand.b.b getAppState()
  {
    AppMethodBeat.i(271642);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getAppState");
    com.tencent.mm.plugin.appbrand.b.b localb = com.tencent.mm.plugin.appbrand.b.b.qKw;
    AppMethodBeat.o(271642);
    return localb;
  }
  
  public final Handler getAsyncHandler()
  {
    AppMethodBeat.i(271651);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getAsyncHandler");
    Handler localHandler = this.mHandler;
    AppMethodBeat.o(271651);
    return localHandler;
  }
  
  public final int getComponentId()
  {
    AppMethodBeat.i(271624);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getComponentId");
    AppMethodBeat.o(271624);
    return 0;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(271632);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getContext");
    Context localContext = MMApplicationContext.getContext();
    s.s(localContext, "getContext()");
    AppMethodBeat.o(271632);
    return localContext;
  }
  
  public final r getDialogContainer()
  {
    AppMethodBeat.i(271657);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getDialogContainer");
    AppMethodBeat.o(271657);
    return null;
  }
  
  public final w getFileSystem()
  {
    AppMethodBeat.i(271654);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getFileSystem");
    AppMethodBeat.o(271654);
    return null;
  }
  
  public final f.c getInterceptor()
  {
    AppMethodBeat.i(271619);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getInterceptor");
    AppMethodBeat.o(271619);
    return null;
  }
  
  public final i getJsRuntime()
  {
    AppMethodBeat.i(271640);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "getJsRuntime");
    i locali = (i)this.JZL;
    AppMethodBeat.o(271640);
    return locali;
  }
  
  public final void i(Runnable paramRunnable, long paramLong)
  {
    AppMethodBeat.i(271662);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "scheduleToUiThreadDelayed");
    AppMethodBeat.o(271662);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(271636);
    Log.i("WxaLiteApp.LiteAppAppBrandComponent", "isRunning");
    AppMethodBeat.o(271636);
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/jsapi/bridge/appbrand/LiteAppAppBrandComponentImpl$Companion;", "", "()V", "TAG", "", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */