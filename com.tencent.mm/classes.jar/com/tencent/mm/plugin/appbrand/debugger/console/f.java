package com.tencent.mm.plugin.appbrand.debugger.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog;
import com.tencent.mm.pluginsdk.permission.RequestFloatWindowPermissionDialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Log.LogImp;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsolePrinterAccessible;", "", "()V", "MMKV_KEY_CONSOLE_PRINTER_PRINT_LEVEL", "", "PRINT_LEVEL_NONE", "", "TAG", "consoleLogImpl", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl;", "getConsoleLogImpl", "()Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl;", "consoleLogImpl$delegate", "Lkotlin/Lazy;", "isAppBrandProcess", "", "()Z", "isAppBrandProcess$delegate", "isMainProcess", "isMainProcess$delegate", "newValue", "printLevel", "getPrintLevel", "()I", "setPrintLevel", "(I)V", "simpleProcessName", "getSimpleProcessName", "()Ljava/lang/String;", "simpleProcessName$delegate", "disable", "", "enable", "onPrintLevelChange", "oldLevel", "newLevel", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f rfJ;
  public static int rfK;
  private static final j rfL;
  private static final j rfM;
  private static final j rfN;
  private static final j rfO;
  
  static
  {
    int i = 2147483647;
    AppMethodBeat.i(319839);
    rfJ = new f();
    Object localObject = com.tencent.mm.plugin.appbrand.app.f.qBv;
    localObject = com.tencent.mm.plugin.appbrand.app.f.aBP();
    if (localObject == null) {}
    for (;;)
    {
      rfK = i;
      rfL = k.cm((kotlin.g.a.a)f.d.rfR);
      rfM = k.cm((kotlin.g.a.a)f.c.rfQ);
      rfN = k.cm((kotlin.g.a.a)f.e.rfS);
      rfO = k.cm((kotlin.g.a.a)a.rfP);
      AppMethodBeat.o(319839);
      return;
      i = ((MultiProcessMMKV)localObject).getInt("ConsolePrinterPrintLevel", 2147483647);
    }
  }
  
  public static int cmf()
  {
    return rfK;
  }
  
  public static ConsoleDebugLogImpl cmg()
  {
    AppMethodBeat.i(319813);
    ConsoleDebugLogImpl localConsoleDebugLogImpl = (ConsoleDebugLogImpl)rfO.getValue();
    AppMethodBeat.o(319813);
    return localConsoleDebugLogImpl;
  }
  
  public static void enable()
  {
    int j = 0;
    AppMethodBeat.i(319827);
    Log.i("MicroMsg.AppBrand.ConsolePrinterAccessible", "enable");
    Object localObject = t.raH;
    if (t.bnM())
    {
      int k = rfK;
      int i = j;
      if (2 <= k)
      {
        i = j;
        if (k < 6) {
          i = 1;
        }
      }
      if (i != 0) {}
    }
    else
    {
      Log.i("MicroMsg.AppBrand.ConsolePrinterAccessible", "enable, not need");
      AppMethodBeat.o(319827);
      return;
    }
    if (!b.dh(MMApplicationContext.getContext()))
    {
      if (!isMainProcess())
      {
        AppMethodBeat.o(319827);
        return;
      }
      RequestFloatWindowPermissionDialog.a(MMApplicationContext.getContext(), "你的手机没有授权微信获得浮窗权限，无法打开console输出面板", (RequestFloatWindowPermissionDialog.a)new b(), com.tencent.mm.bq.a.aQB());
      AppMethodBeat.o(319827);
      return;
    }
    if (isMainProcess())
    {
      localObject = g.rfT;
      g.enable();
    }
    if ((isMainProcess()) || (isAppBrandProcess()))
    {
      localObject = cmg();
      ((ConsoleDebugLogImpl)localObject).logLevel = rfK;
      m.a((Log.LogImp)localObject);
    }
    AppMethodBeat.o(319827);
  }
  
  public static boolean isAppBrandProcess()
  {
    AppMethodBeat.i(319803);
    boolean bool = ((Boolean)rfM.getValue()).booleanValue();
    AppMethodBeat.o(319803);
    return bool;
  }
  
  public static boolean isMainProcess()
  {
    AppMethodBeat.i(319796);
    boolean bool = ((Boolean)rfL.getValue()).booleanValue();
    AppMethodBeat.o(319796);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ConsoleDebugLogImpl>
  {
    public static final a rfP;
    
    static
    {
      AppMethodBeat.i(319768);
      rfP = new a();
      AppMethodBeat.o(319768);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/debugger/console/ConsolePrinterAccessible$enable$1", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog$OverlayPermissionResultCallBack;", "onResultAllow", "", "dialog", "Lcom/tencent/mm/pluginsdk/permission/RequestFloatWindowPermissionDialog;", "onResultCancel", "onResultRefuse", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements RequestFloatWindowPermissionDialog.a
  {
    public final void a(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(319759);
      Log.i("MicroMsg.AppBrand.ConsolePrinterAccessible", "onResultAllow");
      if (paramRequestFloatWindowPermissionDialog != null) {
        paramRequestFloatWindowPermissionDialog.finish();
      }
      paramRequestFloatWindowPermissionDialog = f.rfJ;
      f.enable();
      AppMethodBeat.o(319759);
    }
    
    public final void b(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(319766);
      Log.i("MicroMsg.AppBrand.ConsolePrinterAccessible", "onResultRefuse");
      if (paramRequestFloatWindowPermissionDialog != null) {
        paramRequestFloatWindowPermissionDialog.finish();
      }
      AppMethodBeat.o(319766);
    }
    
    public final void c(RequestFloatWindowPermissionDialog paramRequestFloatWindowPermissionDialog)
    {
      AppMethodBeat.i(319771);
      Log.i("MicroMsg.AppBrand.ConsolePrinterAccessible", "onResultCancel");
      if (paramRequestFloatWindowPermissionDialog != null) {
        paramRequestFloatWindowPermissionDialog.finish();
      }
      AppMethodBeat.o(319771);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.f
 * JD-Core Version:    0.7.0.1
 */