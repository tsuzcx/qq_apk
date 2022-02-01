package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatNFCSwitcher;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/IHostNFCSwitcher;", "()V", "disableHostNFC", "", "enableHostNFC", "isNFCUsing", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "toggleWeChatNFCLogicUI", "enable", "plugin-appbrand-integration_release"})
public final class aj
  implements com.tencent.mm.plugin.appbrand.jsapi.nfc.c
{
  public static final aj ohH;
  
  static
  {
    AppMethodBeat.i(229608);
    ohH = new aj();
    AppMethodBeat.o(229608);
  }
  
  private static void iW(boolean paramBoolean)
  {
    AppMethodBeat.i(229607);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "toggleWeChatNFCLogicUI, enable: ".concat(String.valueOf(paramBoolean)));
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getPackageManager();
    ComponentName localComponentName = new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ((PackageManager)localObject).setComponentEnabledSetting(localComponentName, i, 1);
      AppMethodBeat.o(229607);
      return;
    }
  }
  
  public final void bHK()
  {
    AppMethodBeat.i(229605);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "enableHostNFC");
    h.a(MainProcessIPCService.dkO, null, ae.class, (d)a.ohI);
    AppMethodBeat.o(229605);
  }
  
  public final void bHL()
  {
    AppMethodBeat.i(229606);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "disableHostNFC");
    iW(false);
    AppMethodBeat.o(229606);
  }
  
  public final boolean u(f paramf)
  {
    AppMethodBeat.i(229604);
    p.h(paramf, "component");
    c.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.c.miO;
    boolean bool = c.a.u(paramf);
    AppMethodBeat.o(229604);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "enabled", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    public static final a ohI;
    
    static
    {
      AppMethodBeat.i(229603);
      ohI = new a();
      AppMethodBeat.o(229603);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.aj
 * JD-Core Version:    0.7.0.1
 */