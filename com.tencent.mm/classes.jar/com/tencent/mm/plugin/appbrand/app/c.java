package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.au.e;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.z;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandMixExportLogicServiceAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/service/IAppBrandMixExportLogicService;", "()V", "TAG", "", "appbrandGameOnStartReportCanvasDataEvent", "", "appid", "buildLowVersionUrl", "appId", "cleanupAppBrandFileLogic", "getInfoByQRCodeResult", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "Landroid/util/Pair;", "codeResultStr", "codeType", "", "codeVersion", "getTipNameByDebugType", "type", "keyStepToggleSwitch", "processName", "keepOpenTime", "", "notifyIpcEventToAppBrand", "T", "Landroid/os/Parcelable;", "data", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "onAppBrandFindMoreEntranceExposed", "openWeappFunctionalPageByDeepLink", "context", "Landroid/content/Context;", "sdkReq", "Lcom/tencent/mm/opensdk/modelbiz/WXLaunchWxaRedirectingPage$Req;", "appPackageName", "deepLinkUri", "transferBuffer", "preloadEnvForMiniGame", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "preloadEnvForMiniProgram", "preloadEnvForPluginApp", "requestOpenDocumentInAppBrandProcess", "filePath", "fileExt", "showMenu", "", "triggerAppBrandCleanupLogic", "plugin-appbrand-integration_release"})
public final class c
  implements f
{
  public static final c nBS;
  
  static
  {
    AppMethodBeat.i(265281);
    nBS = new c();
    AppMethodBeat.o(265281);
  }
  
  public final Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(265279);
    paramContext = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(265279);
    throw paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(265274);
    paramContext = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(265274);
    throw paramContext;
  }
  
  public final void a(z paramz)
  {
    AppMethodBeat.i(265269);
    p.k(paramz, "scene");
    a.a(new IPCString(paramz.name()), (d)c.nBV, null);
    AppMethodBeat.o(265269);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(265273);
    paramString = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(265273);
    throw paramString;
  }
  
  public final String aca(String paramString)
  {
    AppMethodBeat.i(265275);
    paramString = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(265275);
    throw paramString;
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(265270);
    p.k(paramz, "scene");
    a.a(new IPCString(paramz.name()), (d)b.nBU, null);
    AppMethodBeat.o(265270);
  }
  
  public final void bFi()
  {
    AppMethodBeat.i(265272);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(265272);
    throw localThrowable;
  }
  
  public final void bFj()
  {
    AppMethodBeat.i(265277);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(265277);
    throw localThrowable;
  }
  
  public final void bFk()
  {
    AppMethodBeat.i(265278);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(265278);
    throw localThrowable;
  }
  
  public final void c(z paramz)
  {
    AppMethodBeat.i(265271);
    p.k(paramz, "scene");
    a.a(new IPCString(paramz.name()), (d)a.nBT, null);
    AppMethodBeat.o(265271);
  }
  
  public final Pair<String, Integer> yY(int paramInt)
  {
    AppMethodBeat.i(265276);
    Pair localPair = new Pair(e.yZ(paramInt), Integer.valueOf(au.e.app_brand_recents_item_type_tag));
    AppMethodBeat.o(265276);
    return localPair;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements d<IPCString, IPCVoid>
  {
    public static final a nBT;
    
    static
    {
      AppMethodBeat.i(275257);
      nBT = new a();
      AppMethodBeat.o(275257);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements d<IPCString, IPCVoid>
  {
    public static final b nBU;
    
    static
    {
      AppMethodBeat.i(284371);
      nBU = new b();
      AppMethodBeat.o(284371);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements d<IPCString, IPCVoid>
  {
    public static final c nBV;
    
    static
    {
      AppMethodBeat.i(266408);
      nBV = new c();
      AppMethodBeat.o(266408);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c
 * JD-Core Version:    0.7.0.1
 */