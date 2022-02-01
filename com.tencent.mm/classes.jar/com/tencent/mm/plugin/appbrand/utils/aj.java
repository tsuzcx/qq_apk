package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatNFCSwitcher;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/IHostNFCSwitcher;", "()V", "disableHostNFC", "", "enableHostNFC", "isNFCUsing", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "toggleWeChatNFCLogicUI", "enable", "plugin-appbrand-integration_release"})
public final class aj
  implements com.tencent.mm.plugin.appbrand.jsapi.nfc.c
{
  public static final aj mUH;
  
  static
  {
    AppMethodBeat.i(223950);
    mUH = new aj();
    AppMethodBeat.o(223950);
  }
  
  private static void hR(boolean paramBoolean)
  {
    AppMethodBeat.i(223949);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrand.WeChatNFCLogic", "toggleWeChatNFCLogicUI, enable: ".concat(String.valueOf(paramBoolean)));
    Object localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getPackageManager();
    ComponentName localComponentName = new ComponentName(ak.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ((PackageManager)localObject).setComponentEnabledSetting(localComponentName, i, 1);
      AppMethodBeat.o(223949);
      return;
    }
  }
  
  public final void bml()
  {
    AppMethodBeat.i(223947);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrand.WeChatNFCLogic", "enableHostNFC");
    h.a("com.tencent.mm", null, ae.class, (d)a.mUI);
    AppMethodBeat.o(223947);
  }
  
  public final void bmm()
  {
    AppMethodBeat.i(223948);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.AppBrand.WeChatNFCLogic", "disableHostNFC");
    hR(false);
    AppMethodBeat.o(223948);
  }
  
  public final boolean u(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(223946);
    p.h(paramc, "component");
    c.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.ldv;
    boolean bool = c.a.u(paramc);
    AppMethodBeat.o(223946);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "enabled", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    public static final a mUI;
    
    static
    {
      AppMethodBeat.i(223945);
      mUI = new a();
      AppMethodBeat.o(223945);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.aj
 * JD-Core Version:    0.7.0.1
 */