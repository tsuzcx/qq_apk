package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatNFCSwitcher;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/IHostNFCSwitcher;", "()V", "disableHostNFC", "", "enableHostNFC", "isNFCUsing", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "toggleWeChatNFCLogicUI", "enable", "plugin-appbrand-integration_release"})
public final class al
  implements com.tencent.mm.plugin.appbrand.jsapi.nfc.c
{
  public static final al rjv;
  
  static
  {
    AppMethodBeat.i(274979);
    rjv = new al();
    AppMethodBeat.o(274979);
  }
  
  private static void jW(boolean paramBoolean)
  {
    AppMethodBeat.i(274977);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "toggleWeChatNFCLogicUI, enable: ".concat(String.valueOf(paramBoolean)));
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getPackageManager();
    ComponentName localComponentName = new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ((PackageManager)localObject).setComponentEnabledSetting(localComponentName, i, 1);
      AppMethodBeat.o(274977);
      return;
    }
  }
  
  public final void bTt()
  {
    AppMethodBeat.i(274975);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "enableHostNFC");
    j.a(MainProcessIPCService.PROCESS_NAME, null, ag.class, (f)a.rjw);
    AppMethodBeat.o(274975);
  }
  
  public final void bTu()
  {
    AppMethodBeat.i(274976);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "disableHostNFC");
    jW(false);
    AppMethodBeat.o(274976);
  }
  
  public final boolean x(e parame)
  {
    AppMethodBeat.i(274974);
    p.k(parame, "component");
    c.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.pgQ;
    boolean bool = c.a.x(parame);
    AppMethodBeat.o(274974);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "enabled", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements f<ResultType>
  {
    public static final a rjw;
    
    static
    {
      AppMethodBeat.i(273423);
      rjw = new a();
      AppMethodBeat.o(273423);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.al
 * JD-Core Version:    0.7.0.1
 */