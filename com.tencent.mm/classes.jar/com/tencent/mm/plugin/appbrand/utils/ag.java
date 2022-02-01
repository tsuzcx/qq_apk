package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatNFCSwitcher;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/IHostNFCSwitcher;", "()V", "disableHostNFC", "", "enableHostNFC", "isNFCUsing", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "toggleWeChatNFCLogicUI", "enable", "plugin-appbrand-integration_release"})
public final class ag
  implements com.tencent.mm.plugin.appbrand.jsapi.nfc.c
{
  public static final ag mPx;
  
  static
  {
    AppMethodBeat.i(189678);
    mPx = new ag();
    AppMethodBeat.o(189678);
  }
  
  private static void hR(boolean paramBoolean)
  {
    AppMethodBeat.i(189677);
    ad.d("MicroMsg.AppBrand.WeChatNFCLogic", "toggleWeChatNFCLogicUI, enable: ".concat(String.valueOf(paramBoolean)));
    Object localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getPackageManager();
    ComponentName localComponentName = new ComponentName(aj.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ((PackageManager)localObject).setComponentEnabledSetting(localComponentName, i, 1);
      AppMethodBeat.o(189677);
      return;
    }
  }
  
  public final void blC()
  {
    AppMethodBeat.i(189675);
    ad.d("MicroMsg.AppBrand.WeChatNFCLogic", "enableHostNFC");
    h.a("com.tencent.mm", null, ab.class, (d)a.mPy);
    AppMethodBeat.o(189675);
  }
  
  public final void blD()
  {
    AppMethodBeat.i(189676);
    ad.d("MicroMsg.AppBrand.WeChatNFCLogic", "disableHostNFC");
    hR(false);
    AppMethodBeat.o(189676);
  }
  
  public final boolean u(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(189674);
    p.h(paramc, "component");
    c.a locala = com.tencent.mm.plugin.appbrand.jsapi.nfc.a.a.c.kZM;
    boolean bool = c.a.u(paramc);
    AppMethodBeat.o(189674);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "enabled", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class a<T>
    implements d<ResultType>
  {
    public static final a mPy;
    
    static
    {
      AppMethodBeat.i(189673);
      mPy = new a();
      AppMethodBeat.o(189673);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ag
 * JD-Core Version:    0.7.0.1
 */