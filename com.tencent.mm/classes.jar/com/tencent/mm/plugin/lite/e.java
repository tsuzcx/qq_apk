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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class e
  implements com.tencent.mm.plugin.lite.a.a
{
  private static void a(Context paramContext, Bundle paramBundle, b paramb)
  {
    AppMethodBeat.i(205679);
    ac.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp ");
    h.wUl.n(1293L, 0L, 1L);
    WxaLiteAppLaunchInfo localWxaLiteAppLaunchInfo = new WxaLiteAppLaunchInfo();
    localWxaLiteAppLaunchInfo.setAppId(paramb.field_appId);
    localWxaLiteAppLaunchInfo.ajJ(paramb.field_pkgPath);
    localWxaLiteAppLaunchInfo.ntm = paramb.field_signatureKey;
    localWxaLiteAppLaunchInfo.startTime = System.currentTimeMillis();
    paramb = new Intent();
    paramb.addFlags(268435456);
    paramb.setClass(ai.getContext(), WxaLiteAppProxyUI.class);
    paramb.putExtra("WxaLiteAppLaunchInfo", localWxaLiteAppLaunchInfo);
    if (paramBundle.containsKey("data")) {
      paramb.putExtra("data", paramBundle.getString("data"));
    }
    paramb.putExtra("bundle", paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().ba(paramb);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.aeD(), "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(205679);
  }
  
  public final void a(final Context paramContext, final Bundle paramBundle, final a.a parama)
  {
    AppMethodBeat.i(205678);
    ac.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp:".concat(String.valueOf(paramBundle.getString("appId"))));
    h.wUl.n(1293L, 90L, 1L);
    final String str = paramBundle.getString("appId");
    c.cWu();
    b localb = c.ajL(str);
    if (localb != null)
    {
      if (parama != null) {
        parama.cOF();
      }
      a(paramContext, paramBundle, localb);
      AppMethodBeat.o(205678);
      return;
    }
    ac.w("MicroMsg.LiteApp.LiteAppService", "get info return null, appid:".concat(String.valueOf(str)));
    h.wUl.n(1293L, 92L, 1L);
    c.cWu().a(str, new com.tencent.mm.plugin.lite.logic.a()
    {
      public final void a(b paramAnonymousb)
      {
        AppMethodBeat.i(205676);
        if (parama != null) {
          parama.cOF();
        }
        e.b(paramContext, paramBundle, paramAnonymousb);
        AppMethodBeat.o(205676);
      }
      
      public final void cOG()
      {
        AppMethodBeat.i(205677);
        if (parama != null) {
          parama.cOG();
        }
        ac.w("MicroMsg.LiteApp.LiteAppService", "checkLiteApp fail:" + str);
        AppMethodBeat.o(205677);
      }
    });
    AppMethodBeat.o(205678);
  }
  
  public final boolean dzy()
  {
    AppMethodBeat.i(210480);
    c.cWu();
    boolean bool = c.dzy();
    AppMethodBeat.o(210480);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e
 * JD-Core Version:    0.7.0.1
 */