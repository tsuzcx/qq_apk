package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.appbrand.task.i.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandMixExportLogicServiceAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/service/IAppBrandMixExportLogicService;", "()V", "TAG", "", "appbrandGameOnStartReportCanvasDataEvent", "", "appid", "buildLowVersionUrl", "appId", "cleanupAppBrandFileLogic", "getAppBrandJsApi", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "ctrlIndex", "", "getInfoByQRCodeResult", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "Landroid/util/Pair;", "codeResultStr", "codeType", "codeVersion", "getTipNameByDebugType", "type", "keyStepToggleSwitch", "processName", "keepOpenTime", "", "notifyIpcEventToAppBrand", "T", "Landroid/os/Parcelable;", "data", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "onAppBrandFindMoreEntranceExposed", "openWeappFunctionalPageByDeepLink", "context", "Landroid/content/Context;", "sdkReq", "Lcom/tencent/mm/opensdk/modelbiz/WXLaunchWxaRedirectingPage$Req;", "appPackageName", "deepLinkUri", "transferBuffer", "preloadEnvForMiniGame", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "preloadEnvForMiniProgram", "preloadEnvForPluginApp", "requestOpenDocumentInAppBrandProcess", "filePath", "fileExt", "showMenu", "", "triggerAppBrandCleanupLogic", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements g
{
  public static final c qBk;
  
  static
  {
    AppMethodBeat.i(317817);
    qBk = new c();
    AppMethodBeat.o(317817);
  }
  
  private static final void a(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(317805);
    try
    {
      Object localObject = i.tWq;
      localObject = i.a.cJV();
      LuggageServiceType localLuggageServiceType = LuggageServiceType.euv;
      paramIPCString = paramIPCString.value;
      s.s(paramIPCString, "data.value");
      ((i)localObject).a(localLuggageServiceType, ab.valueOf(paramIPCString));
      if (paramf != null)
      {
        a.b(paramf);
        AppMethodBeat.o(317805);
        return;
      }
    }
    catch (Exception paramIPCString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMixExportLogicServiceAnyProcess", (Throwable)paramIPCString, "preloadEnvForPluginApp", new Object[0]);
      AppMethodBeat.o(317805);
    }
  }
  
  private static final void b(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(317811);
    try
    {
      Object localObject = i.tWq;
      localObject = i.a.cJV();
      LuggageServiceType localLuggageServiceType = LuggageServiceType.euv;
      paramIPCString = paramIPCString.value;
      s.s(paramIPCString, "data.value");
      ((i)localObject).a(localLuggageServiceType, ab.valueOf(paramIPCString));
      if (paramf != null)
      {
        a.b(paramf);
        AppMethodBeat.o(317811);
        return;
      }
    }
    catch (Exception paramIPCString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMixExportLogicServiceAnyProcess", (Throwable)paramIPCString, "preloadEnvForMiniProgram", new Object[0]);
      AppMethodBeat.o(317811);
    }
  }
  
  private static final void c(IPCString paramIPCString, f paramf)
  {
    AppMethodBeat.i(317814);
    try
    {
      Object localObject = i.tWq;
      localObject = i.a.cJV();
      LuggageServiceType localLuggageServiceType = LuggageServiceType.euw;
      paramIPCString = paramIPCString.value;
      s.s(paramIPCString, "data.value");
      ((i)localObject).a(localLuggageServiceType, ab.valueOf(paramIPCString));
      if (paramf != null)
      {
        a.b(paramf);
        AppMethodBeat.o(317814);
        return;
      }
    }
    catch (Exception paramIPCString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandMixExportLogicServiceAnyProcess", (Throwable)paramIPCString, "preloadEnvForMiniGame", new Object[0]);
      AppMethodBeat.o(317814);
    }
  }
  
  public final String UC(String paramString)
  {
    AppMethodBeat.i(317871);
    paramString = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(317871);
    throw paramString;
  }
  
  public final Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(317895);
    paramContext = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(317895);
    throw paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(317866);
    paramContext = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(317866);
    throw paramContext;
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(317837);
    s.u(paramab, "scene");
    a.a(new IPCString(paramab.name()), (d)c..ExternalSyntheticLambda0.INSTANCE, null);
    AppMethodBeat.o(317837);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(317859);
    paramString = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(317859);
    throw paramString;
  }
  
  public final void b(ab paramab)
  {
    AppMethodBeat.i(317842);
    s.u(paramab, "scene");
    a.a(new IPCString(paramab.name()), (d)c..ExternalSyntheticLambda1.INSTANCE, null);
    AppMethodBeat.o(317842);
  }
  
  public final void c(ab paramab)
  {
    AppMethodBeat.i(317849);
    s.u(paramab, "scene");
    a.a(new IPCString(paramab.name()), (d)c..ExternalSyntheticLambda2.INSTANCE, null);
    AppMethodBeat.o(317849);
  }
  
  public final void cew()
  {
    AppMethodBeat.i(317854);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(317854);
    throw localThrowable;
  }
  
  public final void cex()
  {
    AppMethodBeat.i(317880);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(317880);
    throw localThrowable;
  }
  
  public final void cey()
  {
    AppMethodBeat.i(317884);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(317884);
    throw localThrowable;
  }
  
  public final p zk(int paramInt)
  {
    AppMethodBeat.i(317887);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(317887);
    throw localThrowable;
  }
  
  public final Pair<String, Integer> zl(int paramInt)
  {
    AppMethodBeat.i(317877);
    Pair localPair = new Pair(e.zm(paramInt), Integer.valueOf(ba.e.app_brand_recents_item_type_tag));
    AppMethodBeat.o(317877);
    return localPair;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c
 * JD-Core Version:    0.7.0.1
 */