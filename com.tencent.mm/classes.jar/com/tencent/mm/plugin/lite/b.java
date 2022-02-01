package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.liteapp.report.WxaLiteAppStartReport;
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.plugin.lite.api.c.a;
import com.tencent.mm.plugin.lite.launch.WxaLiteAppLaunchInfo;
import com.tencent.mm.plugin.lite.logic.d;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppListUI;
import com.tencent.mm.plugin.lite.ui.WxaLiteAppProxyUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class b
  implements com.tencent.mm.plugin.lite.api.c
{
  private static long JYU = 0L;
  
  private static void a(Context paramContext, Bundle paramBundle, WxaLiteAppStartReport paramWxaLiteAppStartReport, WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(271368);
    Log.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp appid:" + paramWxaLiteAppInfo.appId + ", patchid:" + paramWxaLiteAppInfo.egJ + ", updatetime:" + paramWxaLiteAppInfo.egK);
    h.OAn.p(1293L, 0L, 1L);
    WxaLiteAppLaunchInfo localWxaLiteAppLaunchInfo = new WxaLiteAppLaunchInfo();
    localWxaLiteAppLaunchInfo.setAppId(paramWxaLiteAppInfo.appId);
    localWxaLiteAppLaunchInfo.pkgPath = paramWxaLiteAppInfo.path;
    localWxaLiteAppLaunchInfo.egI = paramWxaLiteAppInfo.egI;
    localWxaLiteAppLaunchInfo.startTime = System.currentTimeMillis();
    if (paramBundle.containsKey("path")) {
      localWxaLiteAppLaunchInfo.path = paramBundle.getString("path");
    }
    if (paramBundle.containsKey("query")) {
      localWxaLiteAppLaunchInfo.query = paramBundle.getString("query");
    }
    if (paramBundle.containsKey("qr_url_query_string")) {
      localWxaLiteAppLaunchInfo.KaF = paramBundle.getString("qr_url_query_string");
    }
    int i;
    if (paramBundle.containsKey("requestCode"))
    {
      i = paramBundle.getInt("requestCode");
      if ((i <= 0) || (!(paramContext instanceof FragmentActivity))) {
        paramBundle.remove("requestCode");
      }
    }
    else
    {
      i = 0;
    }
    paramWxaLiteAppInfo = new Intent();
    if (i == 0) {
      paramWxaLiteAppInfo.addFlags(268435456);
    }
    paramWxaLiteAppInfo.setClass(MMApplicationContext.getContext(), WxaLiteAppProxyUI.class);
    paramWxaLiteAppInfo.putExtra("WxaLiteAppLaunchInfo", localWxaLiteAppLaunchInfo);
    paramWxaLiteAppInfo.putExtra("report", paramWxaLiteAppStartReport);
    paramWxaLiteAppInfo.putExtra("bundle", paramBundle);
    if (i > 0)
    {
      ((FragmentActivity)paramContext).startActivityForResult(paramWxaLiteAppInfo, i);
      AppMethodBeat.o(271368);
      return;
    }
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().cG(paramWxaLiteAppInfo);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramBundle.aYi(), "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/liteapp/report/WxaLiteAppStartReport;Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/liteapp/report/WxaLiteAppStartReport;Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271368);
  }
  
  private void a(final Context paramContext, final Bundle paramBundle, final String paramString, final WxaLiteAppStartReport paramWxaLiteAppStartReport, final c.a parama)
  {
    AppMethodBeat.i(271354);
    paramWxaLiteAppStartReport.egn = System.currentTimeMillis();
    d.fUi().a(paramString, new com.tencent.mm.plugin.lite.api.b()
    {
      public final void b(WxaLiteAppInfo paramAnonymousWxaLiteAppInfo)
      {
        AppMethodBeat.i(271281);
        if (parama != null) {
          parama.csx();
        }
        paramWxaLiteAppStartReport.egp = true;
        paramWxaLiteAppStartReport.ego = (System.currentTimeMillis() - paramWxaLiteAppStartReport.egn);
        b.b(paramContext, paramBundle, paramWxaLiteAppStartReport, paramAnonymousWxaLiteAppInfo);
        AppMethodBeat.o(271281);
      }
      
      public final void csy()
      {
        AppMethodBeat.i(271283);
        if (parama != null) {
          parama.csy();
        }
        Log.w("MicroMsg.LiteApp.LiteAppService", "checkLiteApp fail:" + paramString);
        paramWxaLiteAppStartReport.egp = false;
        paramWxaLiteAppStartReport.ego = (System.currentTimeMillis() - paramWxaLiteAppStartReport.egn);
        AppMethodBeat.o(271283);
      }
    });
    AppMethodBeat.o(271354);
  }
  
  public final void a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2, c.a parama)
  {
    AppMethodBeat.i(271407);
    if (!paramBundle.containsKey("appId"))
    {
      Log.e("MicroMsg.LiteApp.LiteAppService", "appId is required");
      AppMethodBeat.o(271407);
      return;
    }
    Object localObject = paramBundle.getString("appId");
    WxaLiteAppStartReport localWxaLiteAppStartReport = new WxaLiteAppStartReport();
    localWxaLiteAppStartReport.appId = ((String)localObject);
    localWxaLiteAppStartReport.startTime = System.currentTimeMillis();
    Log.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp:".concat(String.valueOf(localObject)));
    long l = System.currentTimeMillis();
    if ((l > JYU) && (l - JYU <= 500L))
    {
      Log.w("MicroMsg.LiteApp.LiteAppService", "reduplicate request, lasttime:%d, now:%d", new Object[] { Long.valueOf(JYU), Long.valueOf(l) });
      h.OAn.p(1293L, 105L, 1L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle.getString("appId")).append(",").append(JYU).append(",").append(l);
      h.OAn.kvStat(21018, ((StringBuilder)localObject).toString());
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(271407);
      return;
      JYU = l;
    }
    h.OAn.p(1293L, 90L, 1L);
    localObject = paramBundle.getString("appId");
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        h.OAn.p(1293L, 91L, 1L);
        localWxaLiteAppStartReport.egm = true;
        a(paramContext, paramBundle, (String)localObject, localWxaLiteAppStartReport, parama);
        AppMethodBeat.o(271407);
        return;
      }
      d.fUi().a((String)localObject, null);
    }
    d.fUi();
    WxaLiteAppInfo localWxaLiteAppInfo = d.et((String)localObject);
    if (localWxaLiteAppInfo != null)
    {
      if (parama != null) {
        parama.csx();
      }
      localWxaLiteAppStartReport.egm = false;
      a(paramContext, paramBundle, localWxaLiteAppStartReport, localWxaLiteAppInfo);
      AppMethodBeat.o(271407);
      return;
    }
    Log.w("MicroMsg.LiteApp.LiteAppService", "get info return null, appid:".concat(String.valueOf(localObject)));
    h.OAn.p(1293L, 92L, 1L);
    h.OAn.kvStat(20979, (String)localObject);
    localWxaLiteAppStartReport.egm = true;
    a(paramContext, paramBundle, (String)localObject, localWxaLiteAppStartReport, parama);
    AppMethodBeat.o(271407);
  }
  
  public final void a(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(271482);
    d.fUi();
    d.a(paramWxaLiteAppInfo);
    AppMethodBeat.o(271482);
  }
  
  public final void a(String paramString, com.tencent.mm.plugin.lite.api.b paramb)
  {
    AppMethodBeat.i(271424);
    d.fUi().a(paramString, paramb);
    AppMethodBeat.o(271424);
  }
  
  public final void aB(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(271395);
    Log.i("MicroMsg.LiteApp.LiteAppService", "preloadLiteApp appId:%s path:%s task:%s", new Object[] { paramString1, paramString2, paramString3 });
    Intent localIntent = new Intent();
    localIntent.setClass(MMApplicationContext.getContext(), LiteAppTaskPreloadReceiver.class);
    localIntent.addFlags(268435456);
    localIntent.putExtra("task", paramString3);
    localIntent.putExtra("appId", paramString1);
    localIntent.putExtra("path", paramString2);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(271395);
  }
  
  public final void aJS(String paramString)
  {
    AppMethodBeat.i(271418);
    d.fUi().a(paramString, null);
    AppMethodBeat.o(271418);
  }
  
  public final boolean aJT(String paramString)
  {
    AppMethodBeat.i(271436);
    d.fUi();
    boolean bool = d.aJT(paramString);
    AppMethodBeat.o(271436);
    return bool;
  }
  
  public final boolean aJU(String paramString)
  {
    AppMethodBeat.i(271443);
    d.fUi();
    boolean bool = d.aJU(paramString);
    AppMethodBeat.o(271443);
    return bool;
  }
  
  public final int bo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(271486);
    int i = com.tencent.mm.plugin.lite.b.b.bo(paramJSONObject);
    AppMethodBeat.o(271486);
    return i;
  }
  
  public final int bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(271492);
    int i = com.tencent.mm.plugin.lite.b.b.bp(paramJSONObject);
    AppMethodBeat.o(271492);
    return i;
  }
  
  public final WxaLiteAppInfo et(String paramString)
  {
    AppMethodBeat.i(271476);
    d.fUi();
    paramString = d.et(paramString);
    AppMethodBeat.o(271476);
    return paramString;
  }
  
  public final void fTS()
  {
    AppMethodBeat.i(271413);
    d.fUi().fUm();
    AppMethodBeat.o(271413);
  }
  
  public final boolean fTT()
  {
    AppMethodBeat.i(271430);
    d.fUi();
    boolean bool = d.fTT();
    AppMethodBeat.o(271430);
    return bool;
  }
  
  public final WxaLiteAppBaselibInfo fTU()
  {
    AppMethodBeat.i(271470);
    d.fUi();
    WxaLiteAppBaselibInfo localWxaLiteAppBaselibInfo = d.fUl();
    AppMethodBeat.o(271470);
    return localWxaLiteAppBaselibInfo;
  }
  
  public final void iK(Context paramContext)
  {
    AppMethodBeat.i(271451);
    Object localObject = new Intent(paramContext, WxaLiteAppListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppListUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppListUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271451);
  }
  
  public final boolean isInitialized()
  {
    AppMethodBeat.i(271385);
    boolean bool = c.isInitialized();
    AppMethodBeat.o(271385);
    return bool;
  }
  
  public final void jS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271459);
    d locald = d.fUi();
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "cpan offline registerOfflineResourceCallback clazzName:%s processName:%s", new Object[] { paramString2, paramString1 });
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "get clazzName null.");
      AppMethodBeat.o(271459);
      return;
    }
    try
    {
      paramString2 = (m)Class.forName(paramString2).newInstance();
      if (paramString2 != null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "cpan offline registerOfflineResourceCallback success.");
        locald.KaY.put(paramString1, paramString2);
      }
      AppMethodBeat.o(271459);
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
  
  public final void jT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271464);
    com.tencent.mm.plugin.lite.logic.c.jT(paramString1, paramString2);
    AppMethodBeat.o(271464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b
 * JD-Core Version:    0.7.0.1
 */