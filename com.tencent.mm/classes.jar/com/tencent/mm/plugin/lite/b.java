package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppListUI;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class b
  implements com.tencent.mm.plugin.lite.a.a
{
  private static long yDQ = 0L;
  
  private static void a(Context paramContext, Bundle paramBundle, WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(198786);
    Log.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp appid:" + paramWxaLiteAppInfo.appId + ", patchid:" + paramWxaLiteAppInfo.cri + ", updatetime:" + paramWxaLiteAppInfo.crj);
    h.CyF.n(1293L, 0L, 1L);
    WxaLiteAppLaunchInfo localWxaLiteAppLaunchInfo = new WxaLiteAppLaunchInfo();
    localWxaLiteAppLaunchInfo.setAppId(paramWxaLiteAppInfo.appId);
    localWxaLiteAppLaunchInfo.pkgPath = paramWxaLiteAppInfo.path;
    localWxaLiteAppLaunchInfo.crh = paramWxaLiteAppInfo.crh;
    localWxaLiteAppLaunchInfo.startTime = System.currentTimeMillis();
    if (paramBundle.containsKey("path")) {
      localWxaLiteAppLaunchInfo.path = paramBundle.getString("path");
    }
    if (paramBundle.containsKey("query")) {
      localWxaLiteAppLaunchInfo.query = paramBundle.getString("query");
    }
    if (paramBundle.containsKey("qr_url_query_string")) {
      localWxaLiteAppLaunchInfo.yEx = paramBundle.getString("qr_url_query_string");
    }
    paramWxaLiteAppInfo = new Intent();
    paramWxaLiteAppInfo.addFlags(268435456);
    paramWxaLiteAppInfo.setClass(MMApplicationContext.getContext(), WxaLiteAppProxyUI.class);
    paramWxaLiteAppInfo.putExtra("WxaLiteAppLaunchInfo", localWxaLiteAppLaunchInfo);
    paramWxaLiteAppInfo.putExtra("bundle", paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bl(paramWxaLiteAppInfo);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBundle.axQ(), "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(198786);
  }
  
  private void a(final Context paramContext, final Bundle paramBundle, final String paramString, final a.a parama)
  {
    AppMethodBeat.i(198785);
    f.ecC().a(paramString, new com.tencent.mm.plugin.lite.launch.a()
    {
      public final void a(WxaLiteAppInfo paramAnonymousWxaLiteAppInfo)
      {
        AppMethodBeat.i(198782);
        if (parama != null) {
          parama.dTt();
        }
        b.b(paramContext, paramBundle, paramAnonymousWxaLiteAppInfo);
        AppMethodBeat.o(198782);
      }
      
      public final void dTu()
      {
        AppMethodBeat.i(198783);
        if (parama != null) {
          parama.dTu();
        }
        Log.w("MicroMsg.LiteApp.LiteAppService", "checkLiteApp fail:" + paramString);
        AppMethodBeat.o(198783);
      }
    });
    AppMethodBeat.o(198785);
  }
  
  public final void a(Context paramContext, Bundle paramBundle, boolean paramBoolean, a.a parama)
  {
    AppMethodBeat.i(198784);
    if (!paramBundle.containsKey("appId"))
    {
      Log.e("MicroMsg.LiteApp.LiteAppService", "appId is required");
      AppMethodBeat.o(198784);
      return;
    }
    Log.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp:".concat(String.valueOf(paramBundle.getString("appId"))));
    long l = System.currentTimeMillis();
    if ((l > yDQ) && (l - yDQ <= 500L))
    {
      Log.w("MicroMsg.LiteApp.LiteAppService", "reduplicate request, lasttime:%d, now:%d", new Object[] { Long.valueOf(yDQ), Long.valueOf(l) });
      h.CyF.n(1293L, 105L, 1L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle.getString("appId")).append(",").append(yDQ).append(",").append(l);
      h.CyF.kvStat(21018, ((StringBuilder)localObject).toString());
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(198784);
      return;
      yDQ = l;
    }
    h.CyF.n(1293L, 90L, 1L);
    Object localObject = paramBundle.getString("appId");
    if (paramBoolean)
    {
      h.CyF.n(1293L, 91L, 1L);
      a(paramContext, paramBundle, (String)localObject, parama);
      AppMethodBeat.o(198784);
      return;
    }
    f.ecC();
    WxaLiteAppInfo localWxaLiteAppInfo = f.aCT((String)localObject);
    if (localWxaLiteAppInfo != null)
    {
      if (parama != null) {
        parama.dTt();
      }
      a(paramContext, paramBundle, localWxaLiteAppInfo);
      AppMethodBeat.o(198784);
      return;
    }
    Log.w("MicroMsg.LiteApp.LiteAppService", "get info return null, appid:".concat(String.valueOf(localObject)));
    h.CyF.n(1293L, 92L, 1L);
    h.CyF.kvStat(20979, (String)localObject);
    a(paramContext, paramBundle, (String)localObject, parama);
    AppMethodBeat.o(198784);
  }
  
  public final boolean aCR(String paramString)
  {
    AppMethodBeat.i(198788);
    f.ecC();
    boolean bool = f.aCR(paramString);
    AppMethodBeat.o(198788);
    return bool;
  }
  
  public final boolean ecx()
  {
    AppMethodBeat.i(198787);
    f.ecC();
    boolean bool = f.ecx();
    AppMethodBeat.o(198787);
    return bool;
  }
  
  public final void gr(Context paramContext)
  {
    AppMethodBeat.i(198789);
    Object localObject = new Intent(paramContext, WxaLiteAppListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppListUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppListUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(198789);
  }
  
  public final void iw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198790);
    f localf = f.ecC();
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "cpan offline registerOfflineResourceCallback clazzName:%s processName:%s", new Object[] { paramString2, paramString1 });
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "get clazzName null.");
      AppMethodBeat.o(198790);
      return;
    }
    try
    {
      paramString2 = (k)Class.forName(paramString2).newInstance();
      if (paramString2 != null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "cpan offline registerOfflineResourceCallback success.");
        localf.yEN.put(paramString1, paramString2);
      }
      AppMethodBeat.o(198790);
      return;
    }
    catch (ClassNotFoundException paramString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.LiteApp.LiteAppLogic", "registerOfflineResourceCallback fail. %s", new Object[] { paramString2.toString() });
        paramString2 = null;
      }
    }
    catch (IllegalAccessException paramString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.LiteApp.LiteAppLogic", "registerOfflineResourceCallback fail. %s", new Object[] { paramString2.toString() });
        paramString2 = null;
      }
    }
    catch (InstantiationException paramString2)
    {
      for (;;)
      {
        Log.e("MicroMsg.LiteApp.LiteAppLogic", "registerOfflineResourceCallback fail. %s", new Object[] { paramString2.toString() });
        paramString2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b
 * JD-Core Version:    0.7.0.1
 */