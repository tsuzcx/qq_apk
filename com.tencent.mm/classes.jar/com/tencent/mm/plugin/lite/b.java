package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
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
  private static long EfD = 0L;
  
  private static void a(Context paramContext, Bundle paramBundle, WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(234040);
    Log.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp appid:" + paramWxaLiteAppInfo.appId + ", patchid:" + paramWxaLiteAppInfo.coY + ", updatetime:" + paramWxaLiteAppInfo.coZ);
    h.IzE.p(1293L, 0L, 1L);
    WxaLiteAppLaunchInfo localWxaLiteAppLaunchInfo = new WxaLiteAppLaunchInfo();
    localWxaLiteAppLaunchInfo.setAppId(paramWxaLiteAppInfo.appId);
    localWxaLiteAppLaunchInfo.pkgPath = paramWxaLiteAppInfo.path;
    localWxaLiteAppLaunchInfo.coX = paramWxaLiteAppInfo.coX;
    localWxaLiteAppLaunchInfo.startTime = System.currentTimeMillis();
    if (paramBundle.containsKey("path")) {
      localWxaLiteAppLaunchInfo.path = paramBundle.getString("path");
    }
    if (paramBundle.containsKey("query")) {
      localWxaLiteAppLaunchInfo.query = paramBundle.getString("query");
    }
    if (paramBundle.containsKey("qr_url_query_string")) {
      localWxaLiteAppLaunchInfo.Egl = paramBundle.getString("qr_url_query_string");
    }
    paramWxaLiteAppInfo = new Intent();
    paramWxaLiteAppInfo.addFlags(268435456);
    paramWxaLiteAppInfo.setClass(MMApplicationContext.getContext(), WxaLiteAppProxyUI.class);
    paramWxaLiteAppInfo.putExtra("WxaLiteAppLaunchInfo", localWxaLiteAppLaunchInfo);
    paramWxaLiteAppInfo.putExtra("bundle", paramBundle);
    paramBundle = new com.tencent.mm.hellhoundlib.b.a().bm(paramWxaLiteAppInfo);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramBundle.aFh(), "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramBundle.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "openLiteApp", "(Landroid/content/Context;Landroid/os/Bundle;Lcom/tencent/liteapp/storage/WxaLiteAppInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(234040);
  }
  
  private void a(final Context paramContext, final Bundle paramBundle, final String paramString, final a.a parama)
  {
    AppMethodBeat.i(234036);
    f.eLH().a(paramString, new com.tencent.mm.plugin.lite.launch.a()
    {
      public final void a(WxaLiteAppInfo paramAnonymousWxaLiteAppInfo)
      {
        AppMethodBeat.i(233868);
        if (parama != null) {
          parama.ewC();
        }
        b.b(paramContext, paramBundle, paramAnonymousWxaLiteAppInfo);
        AppMethodBeat.o(233868);
      }
      
      public final void ewD()
      {
        AppMethodBeat.i(233871);
        if (parama != null) {
          parama.ewD();
        }
        Log.w("MicroMsg.LiteApp.LiteAppService", "checkLiteApp fail:" + paramString);
        AppMethodBeat.o(233871);
      }
    });
    AppMethodBeat.o(234036);
  }
  
  public final void a(Context paramContext, Bundle paramBundle, boolean paramBoolean, a.a parama)
  {
    AppMethodBeat.i(234033);
    if (!paramBundle.containsKey("appId"))
    {
      Log.e("MicroMsg.LiteApp.LiteAppService", "appId is required");
      AppMethodBeat.o(234033);
      return;
    }
    Log.i("MicroMsg.LiteApp.LiteAppService", "startLiteApp:".concat(String.valueOf(paramBundle.getString("appId"))));
    long l = System.currentTimeMillis();
    if ((l > EfD) && (l - EfD <= 500L))
    {
      Log.w("MicroMsg.LiteApp.LiteAppService", "reduplicate request, lasttime:%d, now:%d", new Object[] { Long.valueOf(EfD), Long.valueOf(l) });
      h.IzE.p(1293L, 105L, 1L);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramBundle.getString("appId")).append(",").append(EfD).append(",").append(l);
      h.IzE.kvStat(21018, ((StringBuilder)localObject).toString());
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(234033);
      return;
      EfD = l;
    }
    h.IzE.p(1293L, 90L, 1L);
    Object localObject = paramBundle.getString("appId");
    if (paramBoolean)
    {
      h.IzE.p(1293L, 91L, 1L);
      a(paramContext, paramBundle, (String)localObject, parama);
      AppMethodBeat.o(234033);
      return;
    }
    f.eLH();
    WxaLiteAppInfo localWxaLiteAppInfo = f.cY((String)localObject);
    if (localWxaLiteAppInfo != null)
    {
      if (parama != null) {
        parama.ewC();
      }
      a(paramContext, paramBundle, localWxaLiteAppInfo);
      AppMethodBeat.o(234033);
      return;
    }
    Log.w("MicroMsg.LiteApp.LiteAppService", "get info return null, appid:".concat(String.valueOf(localObject)));
    h.IzE.p(1293L, 92L, 1L);
    h.IzE.kvStat(20979, (String)localObject);
    a(paramContext, paramBundle, (String)localObject, parama);
    AppMethodBeat.o(234033);
  }
  
  public final boolean aMY(String paramString)
  {
    AppMethodBeat.i(234044);
    f.eLH();
    boolean bool = f.aMY(paramString);
    AppMethodBeat.o(234044);
    return bool;
  }
  
  public final boolean aMZ(String paramString)
  {
    AppMethodBeat.i(234046);
    f.eLH();
    boolean bool = f.aMZ(paramString);
    AppMethodBeat.o(234046);
    return bool;
  }
  
  public final boolean eLA()
  {
    AppMethodBeat.i(234042);
    f.eLH();
    boolean bool = f.eLA();
    AppMethodBeat.o(234042);
    return bool;
  }
  
  public final void hp(Context paramContext)
  {
    AppMethodBeat.i(234048);
    Object localObject = new Intent(paramContext, WxaLiteAppListUI.class);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppListUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/lite/LiteAppService", "startLiteAppListUI", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(234048);
  }
  
  public final void iI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(234049);
    f localf = f.eLH();
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "cpan offline registerOfflineResourceCallback clazzName:%s processName:%s", new Object[] { paramString2, paramString1 });
    if (Util.isNullOrNil(paramString2))
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "get clazzName null.");
      AppMethodBeat.o(234049);
      return;
    }
    try
    {
      paramString2 = (m)Class.forName(paramString2).newInstance();
      if (paramString2 != null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "cpan offline registerOfflineResourceCallback success.");
        localf.EgC.put(paramString1, paramString2);
      }
      AppMethodBeat.o(234049);
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