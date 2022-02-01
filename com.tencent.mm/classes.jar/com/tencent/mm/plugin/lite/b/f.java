package com.tencent.mm.plugin.lite.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.lite.storage.LiteAppContentProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.List;

public class f
{
  public static f yEM;
  public HashMap<String, k> yEN;
  
  private f()
  {
    AppMethodBeat.i(198872);
    this.yEN = new HashMap();
    AppMethodBeat.o(198872);
  }
  
  public static boolean aCR(String paramString)
  {
    AppMethodBeat.i(198885);
    Object localObject = String.format("clicfg_liteapp_%s_enable", new Object[] { paramString });
    String str = String.format("clicfg_liteapp_%s_max_crash", new Object[] { paramString });
    if ((MMApplicationContext.isMainProcess()) && (ecx()))
    {
      boolean bool = d.cRY().gA((String)localObject, "0").equalsIgnoreCase("1");
      int i = Util.getInt(d.cRY().gA(str, "10"), 10);
      localObject = aCT(paramString);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((WxaLiteAppInfo)localObject).cri)
      {
        int j = MultiProcessMMKV.getMultiDefault().getInt(String.format("liteapp_%s_%s", new Object[] { paramString, localObject }), 0);
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "isLiteAppOpen appId%s version%s enable:%b, crashCount:%d", new Object[] { paramString, localObject, Boolean.valueOf(bool), Integer.valueOf(j) });
        if (!bool) {
          break label213;
        }
        if (j >= i) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.CyF.n(1293L, 100L, 1L);
        AppMethodBeat.o(198885);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.CyF.n(1293L, 101L, 1L);
      for (;;)
      {
        AppMethodBeat.o(198885);
        return false;
        label213:
        com.tencent.mm.plugin.report.service.h.CyF.n(1293L, 102L, 1L);
      }
    }
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "can no get 'isLiteAppOpen' value when is no mm process.");
    AppMethodBeat.o(198885);
    return false;
  }
  
  public static WxaLiteAppInfo aCT(String paramString)
  {
    AppMethodBeat.i(198876);
    try
    {
      Bundle localBundle = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppInfo", paramString, null);
      if (localBundle == null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "null == bundle, appId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(198876);
        return null;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", localException, "", new Object[0]);
        localObject = null;
      }
      localObject.setClassLoader(WxaLiteAppInfo.class.getClassLoader());
      paramString = (WxaLiteAppInfo)localObject.getParcelable("LiteApp");
      AppMethodBeat.o(198876);
    }
    return paramString;
  }
  
  public static com.tencent.mm.plugin.lite.storage.c aCU(String paramString)
  {
    AppMethodBeat.i(198877);
    try
    {
      paramString = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppAuthInfo", paramString, null);
      if (paramString == null)
      {
        AppMethodBeat.o(198877);
        return null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", paramString, "", new Object[0]);
        paramString = null;
      }
      com.tencent.mm.plugin.lite.storage.c localc = new com.tencent.mm.plugin.lite.storage.c();
      localc.field_host = paramString.getString("host");
      localc.field_param = paramString.getString("param");
      localc.field_paramMap = paramString.getString("paramMap");
      localc.field_headerMap = paramString.getString("headerMap");
      localc.field_updateTime = paramString.getLong("updateTime");
      AppMethodBeat.o(198877);
      return localc;
    }
  }
  
  public static void b(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(198878);
    if (Util.isNullOrNil(paramWxaLiteAppInfo.path))
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "app path is empty.");
      AppMethodBeat.o(198878);
      return;
    }
    if (!new o(paramWxaLiteAppInfo.path).exists())
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "app file isn't exist.");
      AppMethodBeat.o(198878);
      return;
    }
    Object localObject = h.aw(paramWxaLiteAppInfo.appId, paramWxaLiteAppInfo.cri, paramWxaLiteAppInfo.md5);
    if (!((String)localObject).equalsIgnoreCase(paramWxaLiteAppInfo.path))
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "rename app folder from %s to %s", new Object[] { paramWxaLiteAppInfo.path, localObject });
      s.cL(paramWxaLiteAppInfo.path, (String)localObject);
      paramWxaLiteAppInfo.path = ((String)localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("LiteApp", paramWxaLiteAppInfo);
    try
    {
      MMApplicationContext.getContext().getContentResolver().call(getUri(), "insertLiteAppInfo", paramWxaLiteAppInfo.appId, (Bundle)localObject);
      AppMethodBeat.o(198878);
      return;
    }
    catch (Exception paramWxaLiteAppInfo)
    {
      Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", paramWxaLiteAppInfo, "", new Object[0]);
      AppMethodBeat.o(198878);
    }
  }
  
  public static void c(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(198879);
    if (paramWxaLiteAppInfo.appId.equalsIgnoreCase("wxalitecce81f5fba338df4dd5f74df8229c600"))
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMultiDefault();
      localMultiProcessMMKV.putString("wxa_lite_app_game_center_version", paramWxaLiteAppInfo.cri);
      localMultiProcessMMKV.commit();
    }
    AppMethodBeat.o(198879);
  }
  
  private static boolean d(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(198883);
    if (paramWxaLiteAppInfo == null)
    {
      AppMethodBeat.o(198883);
      return true;
    }
    if (paramWxaLiteAppInfo.KB())
    {
      AppMethodBeat.o(198883);
      return false;
    }
    AppMethodBeat.o(198883);
    return true;
  }
  
  public static f ecC()
  {
    AppMethodBeat.i(198873);
    if (yEM == null) {}
    try
    {
      yEM = new f();
      f localf = yEM;
      AppMethodBeat.o(198873);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(198873);
    }
  }
  
  public static List<WxaLiteAppInfo> ecD()
  {
    AppMethodBeat.i(198875);
    Object localObject = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppList", null, null);
    if ((localObject != null) && (((Bundle)localObject).containsKey("LiteAppList")))
    {
      localObject = ((Bundle)localObject).getParcelableArrayList("LiteAppList");
      AppMethodBeat.o(198875);
      return localObject;
    }
    AppMethodBeat.o(198875);
    return null;
  }
  
  public static WxaLiteAppInfo ecE()
  {
    AppMethodBeat.i(198880);
    ecC();
    WxaLiteAppInfo localWxaLiteAppInfo = aCT("wxalitebaselibrary");
    AppMethodBeat.o(198880);
    return localWxaLiteAppInfo;
  }
  
  public static boolean ecx()
  {
    AppMethodBeat.i(198884);
    com.tencent.mm.plugin.expansions.a.cMr();
    if (((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.sfe, 1) == 1)
    {
      AppMethodBeat.o(198884);
      return true;
    }
    AppMethodBeat.o(198884);
    return false;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(198874);
    Uri localUri = Uri.parse("content://" + LiteAppContentProvider.AUTHORITY + "/");
    AppMethodBeat.o(198874);
    return localUri;
  }
  
  public final void a(final String paramString, final com.tencent.mm.plugin.lite.launch.a parama)
  {
    AppMethodBeat.i(198882);
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteApp appId:%s", new Object[] { paramString });
    final WxaLiteAppInfo localWxaLiteAppInfo = aCT(paramString);
    if (d(localWxaLiteAppInfo)) {
      if ((localWxaLiteAppInfo == null) || (localWxaLiteAppInfo.cri == null) || (localWxaLiteAppInfo.cri.isEmpty())) {
        break label149;
      }
    }
    label149:
    for (String str = localWxaLiteAppInfo.cri;; str = "")
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "begin to checkLiteApp:%s patchId:%s", new Object[] { paramString, str });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.boots.a.c.class)).a(paramString, paramString, str, new com.tencent.mm.plugin.boots.a.f()
      {
        public final void a(com.tencent.mm.plugin.boots.a.g paramAnonymousg)
        {
          AppMethodBeat.i(198871);
          if (!Util.isNullOrNil(paramAnonymousg.pkK))
          {
            Log.i("MicroMsg.LiteApp.LiteAppLogic", "start to download liteapp:" + paramString + ", url:" + paramAnonymousg.pkK);
            e.yEE.a(paramAnonymousg, "release", parama);
            AppMethodBeat.o(198871);
            return;
          }
          Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteApp, url is null, appId:" + paramString);
          if (parama != null)
          {
            if (localWxaLiteAppInfo != null)
            {
              parama.a(localWxaLiteAppInfo);
              AppMethodBeat.o(198871);
              return;
            }
            parama.dTu();
          }
          AppMethodBeat.o(198871);
        }
      });
      AppMethodBeat.o(198882);
      return;
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "no need download, local pkg is debug");
      if (parama != null) {
        parama.a(localWxaLiteAppInfo);
      }
      AppMethodBeat.o(198882);
      return;
    }
  }
  
  public final void ecF()
  {
    AppMethodBeat.i(198881);
    final WxaLiteAppInfo localWxaLiteAppInfo = ecE();
    ecC().a("wxalitebaselibrary", new com.tencent.mm.plugin.lite.launch.a()
    {
      public final void a(WxaLiteAppInfo paramAnonymousWxaLiteAppInfo)
      {
        AppMethodBeat.i(198870);
        if (paramAnonymousWxaLiteAppInfo == null)
        {
          AppMethodBeat.o(198870);
          return;
        }
        if (localWxaLiteAppInfo != null)
        {
          if (!localWxaLiteAppInfo.path.equals(paramAnonymousWxaLiteAppInfo.path))
          {
            f.ecC();
            if (!f.aCR("wxalitebaselibrary")) {}
          }
        }
        else
        {
          Intent localIntent = new Intent();
          localIntent.setClass(MMApplicationContext.getContext(), LiteAppTaskPreloadReceiver.class);
          localIntent.addFlags(268435456);
          localIntent.putExtra("task", "updateBaseLibPath");
          localIntent.putExtra("path", paramAnonymousWxaLiteAppInfo.path);
          MMApplicationContext.getContext().sendBroadcast(localIntent);
        }
        AppMethodBeat.o(198870);
      }
      
      public final void dTu() {}
    });
    AppMethodBeat.o(198881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.f
 * JD-Core Version:    0.7.0.1
 */