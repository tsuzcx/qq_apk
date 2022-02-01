package com.tencent.mm.plugin.appbrand.app;

import android.content.Context;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage.Req;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandMixExportLogicServiceAnyProcess;", "Lcom/tencent/mm/plugin/appbrand/service/IAppBrandMixExportLogicService;", "()V", "TAG", "", "appbrandGameOnStartReportCanvasDataEvent", "", "appid", "buildLowVersionUrl", "appId", "cleanupAppBrandFileLogic", "getInfoByQRCodeResult", "Lcom/tencent/mm/vending/pipeline/Pipeline;", "Landroid/util/Pair;", "codeResultStr", "codeType", "", "codeVersion", "getTipNameByDebugType", "type", "keyStepToggleSwitch", "processName", "keepOpenTime", "", "notifyIpcEventToAppBrand", "T", "Landroid/os/Parcelable;", "data", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "onAppBrandFindMoreEntranceExposed", "openWeappFunctionalPageByDeepLink", "context", "Landroid/content/Context;", "sdkReq", "Lcom/tencent/mm/opensdk/modelbiz/WXLaunchWxaRedirectingPage$Req;", "appPackageName", "deepLinkUri", "transferBuffer", "preloadEnvForMiniGame", "scene", "Lcom/tencent/mm/plugin/appbrand/service/PRELOAD_SCENE;", "preloadEnvForMiniProgram", "preloadEnvForPluginApp", "requestOpenDocumentInAppBrandProcess", "filePath", "fileExt", "showMenu", "", "triggerAppBrandCleanupLogic", "plugin-appbrand-integration_release"})
public final class c
  implements f
{
  public static final c kIc;
  
  static
  {
    AppMethodBeat.i(227972);
    kIc = new c();
    AppMethodBeat.o(227972);
  }
  
  public final String Ur(String paramString)
  {
    AppMethodBeat.i(227967);
    paramString = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(227967);
    throw paramString;
  }
  
  public final Pair<Integer, String> a(Context paramContext, WXLaunchWxaRedirectingPage.Req paramReq, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(227971);
    paramContext = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(227971);
    throw paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    AppMethodBeat.i(227966);
    paramContext = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(227966);
    throw paramContext;
  }
  
  public final void a(z paramz)
  {
    AppMethodBeat.i(227961);
    p.h(paramz, "scene");
    a.a(new IPCString(paramz.name()), (b)c.kIf, null);
    AppMethodBeat.o(227961);
  }
  
  public final <T extends Parcelable> void a(String paramString, T paramT)
  {
    AppMethodBeat.i(227965);
    paramString = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(227965);
    throw paramString;
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(227962);
    p.h(paramz, "scene");
    a.a(new IPCString(paramz.name()), (b)b.kIe, null);
    AppMethodBeat.o(227962);
  }
  
  public final void bui()
  {
    AppMethodBeat.i(227964);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(227964);
    throw localThrowable;
  }
  
  public final void buj()
  {
    AppMethodBeat.i(227969);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(227969);
    throw localThrowable;
  }
  
  public final void buk()
  {
    AppMethodBeat.i(227970);
    Throwable localThrowable = (Throwable)new IllegalStateException("Not support".toString());
    AppMethodBeat.o(227970);
    throw localThrowable;
  }
  
  public final void c(z paramz)
  {
    AppMethodBeat.i(227963);
    p.h(paramz, "scene");
    a.a(new IPCString(paramz.name()), (b)a.kId, null);
    AppMethodBeat.o(227963);
  }
  
  public final Pair<String, Integer> vN(int paramInt)
  {
    AppMethodBeat.i(227968);
    Pair localPair = new Pair(e.vO(paramInt), Integer.valueOf(2131231041));
    AppMethodBeat.o(227968);
    return localPair;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class a<InputType, ResultType>
    implements b<IPCString, IPCVoid>
  {
    public static final a kId;
    
    static
    {
      AppMethodBeat.i(227956);
      kId = new a();
      AppMethodBeat.o(227956);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class b<InputType, ResultType>
    implements b<IPCString, IPCVoid>
  {
    public static final b kIe;
    
    static
    {
      AppMethodBeat.i(227958);
      kIe = new b();
      AppMethodBeat.o(227958);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "kotlin.jvm.PlatformType", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "invoke"})
  static final class c<InputType, ResultType>
    implements b<IPCString, IPCVoid>
  {
    public static final c kIf;
    
    static
    {
      AppMethodBeat.i(227960);
      kIf = new c();
      AppMethodBeat.o(227960);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.c
 * JD-Core Version:    0.7.0.1
 */