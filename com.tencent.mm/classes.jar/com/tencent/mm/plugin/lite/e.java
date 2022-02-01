package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.lite.logic.c;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppListUI;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class e
  implements com.tencent.mm.plugin.lite.a.a
{
  private static long vjY = 0L;
  
  private static void a(Context paramContext, Bundle paramBundle, com.tencent.mm.plugin.lite.d.e parame)
  {
    AppMethodBeat.i(217766);
    ae.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp appid:" + parame.field_appId + ", patchid:" + parame.field_patchId + ", updatetime:" + parame.field_updateTime);
    g.yxI.n(1293L, 0L, 1L);
    WxaLiteAppLaunchInfo localWxaLiteAppLaunchInfo = new WxaLiteAppLaunchInfo();
    localWxaLiteAppLaunchInfo.setAppId(parame.field_appId);
    localWxaLiteAppLaunchInfo.apz(parame.field_pkgPath);
    localWxaLiteAppLaunchInfo.nZO = parame.field_signatureKey;
    localWxaLiteAppLaunchInfo.startTime = System.currentTimeMillis();
    if (paramBundle.containsKey("path")) {
      localWxaLiteAppLaunchInfo.setPath(paramBundle.getString("path"));
    }
    if (paramBundle.containsKey("query")) {
      localWxaLiteAppLaunchInfo.apA(paramBundle.getString("query"));
    }
    parame = new Intent();
    parame.addFlags(268435456);
    parame.setClass(ak.getContext(), WxaLiteAppProxyUI.class);
    parame.putExtra("WxaLiteAppLaunchInfo", localWxaLiteAppLaunchInfo);
    parame.putExtra("bundle", paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bc(parame);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.ahE(), "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/mm/plugin/lite/storage/LiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(217766);
  }
  
  private void a(final Context paramContext, final Bundle paramBundle, final String paramString, final a.a parama)
  {
    AppMethodBeat.i(217765);
    c.diz().a(paramString, new com.tencent.mm.plugin.lite.logic.a()
    {
      public final void a(com.tencent.mm.plugin.lite.d.e paramAnonymouse)
      {
        AppMethodBeat.i(217762);
        if (parama != null) {
          parama.cZN();
        }
        e.b(paramContext, paramBundle, paramAnonymouse);
        AppMethodBeat.o(217762);
      }
      
      public final void cZO()
      {
        AppMethodBeat.i(217763);
        if (parama != null) {
          parama.cZO();
        }
        ae.w("MicroMsg.LiteApp.LiteAppService", "checkLiteApp fail:" + paramString);
        AppMethodBeat.o(217763);
      }
    });
    AppMethodBeat.o(217765);
  }
  
  public final void a(Context paramContext, Bundle paramBundle, boolean paramBoolean, a.a parama)
  {
    AppMethodBeat.i(217764);
    if (!paramBundle.containsKey("appId"))
    {
      ae.e("MicroMsg.LiteApp.LiteAppService", "appId is required");
      AppMethodBeat.o(217764);
      return;
    }
    ae.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp:".concat(String.valueOf(paramBundle.getString("appId"))));
    long l = System.currentTimeMillis();
    if ((l > vjY) && (l - vjY <= 500L))
    {
      ae.w("MicroMsg.LiteApp.LiteAppService", "reduplicate request, lasttime:%d, now:%d", new Object[] { Long.valueOf(vjY), Long.valueOf(l) });
      g.yxI.n(1293L, 105L, 1L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle.getString("appId")).append(",").append(vjY).append(",").append(l);
      g.yxI.kvStat(21018, ((StringBuilder)localObject).toString());
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(217764);
      return;
      vjY = l;
    }
    g.yxI.n(1293L, 90L, 1L);
    Object localObject = paramBundle.getString("appId");
    if (paramBoolean)
    {
      g.yxI.n(1293L, 91L, 1L);
      a(paramContext, paramBundle, (String)localObject, parama);
      AppMethodBeat.o(217764);
      return;
    }
    c.diz();
    com.tencent.mm.plugin.lite.d.e locale = c.apC((String)localObject);
    if (locale != null)
    {
      if (parama != null) {
        parama.cZN();
      }
      a(paramContext, paramBundle, locale);
      AppMethodBeat.o(217764);
      return;
    }
    ae.w("MicroMsg.LiteApp.LiteAppService", "get info return null, appid:".concat(String.valueOf(localObject)));
    g.yxI.n(1293L, 92L, 1L);
    g.yxI.kvStat(20979, (String)localObject);
    a(paramContext, paramBundle, (String)localObject, parama);
    AppMethodBeat.o(217764);
  }
  
  public final boolean diw()
  {
    AppMethodBeat.i(217767);
    c.diz();
    boolean bool = c.diw();
    AppMethodBeat.o(217767);
    return bool;
  }
  
  public final void fL(Context paramContext)
  {
    AppMethodBeat.i(217768);
    Object localObject = new Intent(paramContext, WxaLiteAppListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppList", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(217768);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.e
 * JD-Core Version:    0.7.0.1
 */