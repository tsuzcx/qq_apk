package com.tencent.mm.plugin.appbrand.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.c;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.logic.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/WeChatNFCSwitcher;", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/IHostNFCSwitcher;", "()V", "disableHostNFC", "", "enableHostNFC", "isNFCUsing", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "toggleWeChatNFCLogicUI", "enable", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ar
  implements c
{
  public static final ar urP;
  
  static
  {
    AppMethodBeat.i(317372);
    urP = new ar();
    AppMethodBeat.o(317372);
  }
  
  private static void lg(boolean paramBoolean)
  {
    AppMethodBeat.i(317367);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", s.X("toggleWeChatNFCLogicUI, enable: ", Boolean.valueOf(paramBoolean)));
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
    ComponentName localComponentName = new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcDispatchLogicUI");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localPackageManager.setComponentEnabledSetting(localComponentName, i, 1);
      AppMethodBeat.o(317367);
      return;
    }
  }
  
  public final void cty()
  {
    AppMethodBeat.i(317382);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "enableHostNFC");
    lg(true);
    AppMethodBeat.o(317382);
  }
  
  public final void ctz()
  {
    AppMethodBeat.i(317386);
    Log.d("MicroMsg.AppBrand.WeChatNFCLogic", "disableHostNFC");
    lg(false);
    AppMethodBeat.o(317386);
  }
  
  public final boolean z(f paramf)
  {
    AppMethodBeat.i(317380);
    s.u(paramf, "component");
    g.a locala = g.smq;
    boolean bool = g.a.z(paramf);
    AppMethodBeat.o(317380);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ar
 * JD-Core Version:    0.7.0.1
 */