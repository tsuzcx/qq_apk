package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.lite.d.b;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class e
  implements com.tencent.mm.plugin.lite.a.a
{
  private static void a(Context paramContext, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(217156);
    ad.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp appid:" + paramb.field_appId + ", patchid:" + paramb.field_patchId + ", updatetime:" + paramb.field_updateTime);
    g.yhR.n(1293L, 0L, 1L);
    WxaLiteAppLaunchInfo localWxaLiteAppLaunchInfo = new WxaLiteAppLaunchInfo();
    localWxaLiteAppLaunchInfo.setAppId(paramb.field_appId);
    localWxaLiteAppLaunchInfo.aow(paramb.field_pkgPath);
    localWxaLiteAppLaunchInfo.nUi = paramb.field_signatureKey;
    localWxaLiteAppLaunchInfo.startTime = System.currentTimeMillis();
    paramb = new Intent();
    paramb.addFlags(268435456);
    paramb.setClass(aj.getContext(), WxaLiteAppProxyUI.class);
    paramb.putExtra("WxaLiteAppLaunchInfo", localWxaLiteAppLaunchInfo);
    if (paramBundle.containsKey("data")) {
      paramb.putExtra("data", paramBundle.getString("data"));
    }
    paramb.putExtra("bundle", paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(paramb);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.ahp(), "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(217156);
  }
  
  public final void a(final Context paramContext, final Bundle paramBundle, final a.a parama)
  {
    AppMethodBeat.i(217155);
    ad.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp:".concat(String.valueOf(paramBundle.getString("appId"))));
    g.yhR.n(1293L, 90L, 1L);
    final String str = paramBundle.getString("appId");
    c.dfF();
    b localb = c.aoy(str);
    if (localb != null)
    {
      if (parama != null) {
        parama.cXe();
      }
      a(paramContext, paramBundle, localb);
      AppMethodBeat.o(217155);
      return;
    }
    ad.w("MicroMsg.LiteApp.LiteAppService", "get info return null, appid:".concat(String.valueOf(str)));
    g.yhR.n(1293L, 92L, 1L);
    c.dfF().a(str, new com.tencent.mm.plugin.lite.logic.a()
    {
      public final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(217153);
        if (parama != null) {
          parama.cXe();
        }
        e.b(paramContext, paramBundle, paramAnonymousb);
        AppMethodBeat.o(217153);
      }
      
      public final void cXf()
      {
        AppMethodBeat.i(217154);
        if (parama != null) {
          parama.cXf();
        }
        ad.w("MicroMsg.LiteApp.LiteAppService", "checkLiteApp fail:" + str);
        AppMethodBeat.o(217154);
      }
    });
    AppMethodBeat.o(217155);
  }
  
  public final boolean dfC()
  {
    AppMethodBeat.i(217157);
    c.dfF();
    boolean bool = c.dfC();
    AppMethodBeat.o(217157);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e
 * JD-Core Version:    0.7.0.1
 */