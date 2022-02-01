package com.tencent.mm.plugin.lite.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.lite.storage.LiteAppContentProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.List;

public class f
{
  public static f EgB;
  public HashMap<String, m> EgC;
  
  private f()
  {
    AppMethodBeat.i(234093);
    this.EgC = new HashMap();
    AppMethodBeat.o(234093);
  }
  
  public static boolean aMY(String paramString)
  {
    AppMethodBeat.i(234119);
    Object localObject = String.format("clicfg_liteapp_%s_enable", new Object[] { paramString });
    String str = String.format("clicfg_liteapp_%s_max_crash", new Object[] { paramString });
    if ((MMApplicationContext.isMainProcess()) && (eLA()))
    {
      boolean bool = d.dgX().gO((String)localObject, "0").equalsIgnoreCase("1");
      int i = Util.getInt(d.dgX().gO(str, "10"), 10);
      localObject = cY(paramString);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((WxaLiteAppInfo)localObject).coY)
      {
        int j = MultiProcessMMKV.getMultiDefault().getInt(String.format("liteapp_%s_%s", new Object[] { paramString, localObject }), 0);
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "isLiteAppOpen appId%s version%s enable:%b, crashCount:%d", new Object[] { paramString, localObject, Boolean.valueOf(bool), Integer.valueOf(j) });
        if (!bool) {
          break label213;
        }
        if (j >= i) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 100L, 1L);
        AppMethodBeat.o(234119);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 101L, 1L);
      for (;;)
      {
        AppMethodBeat.o(234119);
        return false;
        label213:
        com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 102L, 1L);
      }
    }
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "can no get 'isLiteAppOpen' value when is no mm process.");
    AppMethodBeat.o(234119);
    return false;
  }
  
  public static boolean aMZ(String paramString)
  {
    AppMethodBeat.i(234116);
    if (MMApplicationContext.isMainProcess())
    {
      boolean bool = d.dgX().gO("clicfg_liteapp_share_android", "1").equalsIgnoreCase("1");
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "isSharedLiteAppOpen appId%s enable:%b", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(234116);
      return bool;
    }
    AppMethodBeat.o(234116);
    return false;
  }
  
  public static com.tencent.mm.plugin.lite.storage.c aNb(String paramString)
  {
    AppMethodBeat.i(234104);
    try
    {
      paramString = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppAuthInfo", paramString, null);
      if (paramString == null)
      {
        AppMethodBeat.o(234104);
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
      AppMethodBeat.o(234104);
      return localc;
    }
  }
  
  public static void b(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(234105);
    if (Util.isNullOrNil(paramWxaLiteAppInfo.path))
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "app path is empty.");
      AppMethodBeat.o(234105);
      return;
    }
    if (!new q(paramWxaLiteAppInfo.path).ifE())
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "app file isn't exist.");
      AppMethodBeat.o(234105);
      return;
    }
    Object localObject = h.aq(paramWxaLiteAppInfo.appId, paramWxaLiteAppInfo.coY, paramWxaLiteAppInfo.md5);
    if (!((String)localObject).equalsIgnoreCase(paramWxaLiteAppInfo.path))
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "rename app folder from %s to %s", new Object[] { paramWxaLiteAppInfo.path, localObject });
      u.or(paramWxaLiteAppInfo.path, (String)localObject);
      paramWxaLiteAppInfo.path = ((String)localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("LiteApp", paramWxaLiteAppInfo);
    try
    {
      MMApplicationContext.getContext().getContentResolver().call(getUri(), "insertLiteAppInfo", paramWxaLiteAppInfo.appId, (Bundle)localObject);
      AppMethodBeat.o(234105);
      return;
    }
    catch (Exception paramWxaLiteAppInfo)
    {
      Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", paramWxaLiteAppInfo, "", new Object[0]);
      AppMethodBeat.o(234105);
    }
  }
  
  public static void c(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(234106);
    if (paramWxaLiteAppInfo.appId.equalsIgnoreCase("wxalitecce81f5fba338df4dd5f74df8229c600"))
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMultiDefault();
      localMultiProcessMMKV.putString("wxa_lite_app_game_center_version", paramWxaLiteAppInfo.coY);
      localMultiProcessMMKV.commit();
    }
    AppMethodBeat.o(234106);
  }
  
  public static WxaLiteAppInfo cY(String paramString)
  {
    AppMethodBeat.i(234101);
    try
    {
      Bundle localBundle = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppInfo", paramString, null);
      if (localBundle == null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "null == bundle, appId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(234101);
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
      AppMethodBeat.o(234101);
    }
    return paramString;
  }
  
  private static boolean d(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(234113);
    if (paramWxaLiteAppInfo == null)
    {
      AppMethodBeat.o(234113);
      return true;
    }
    if (paramWxaLiteAppInfo.No())
    {
      AppMethodBeat.o(234113);
      return false;
    }
    AppMethodBeat.o(234113);
    return true;
  }
  
  public static boolean eLA()
  {
    AppMethodBeat.i(234115);
    com.tencent.mm.plugin.expansions.a.dbf();
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vOO, 1) == 1)
    {
      AppMethodBeat.o(234115);
      return true;
    }
    AppMethodBeat.o(234115);
    return false;
  }
  
  public static f eLH()
  {
    AppMethodBeat.i(234095);
    if (EgB == null) {}
    try
    {
      EgB = new f();
      f localf = EgB;
      AppMethodBeat.o(234095);
      return localf;
    }
    finally
    {
      AppMethodBeat.o(234095);
    }
  }
  
  public static List<WxaLiteAppInfo> eLI()
  {
    AppMethodBeat.i(234098);
    Object localObject = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppList", null, null);
    if (localObject == null)
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "getLiteAppList bundle is null.");
      AppMethodBeat.o(234098);
      return null;
    }
    ((Bundle)localObject).setClassLoader(WxaLiteAppInfo.class.getClassLoader());
    if (((Bundle)localObject).containsKey("LiteAppList"))
    {
      localObject = ((Bundle)localObject).getParcelableArrayList("LiteAppList");
      AppMethodBeat.o(234098);
      return localObject;
    }
    AppMethodBeat.o(234098);
    return null;
  }
  
  public static WxaLiteAppInfo eLJ()
  {
    AppMethodBeat.i(234107);
    eLH();
    WxaLiteAppInfo localWxaLiteAppInfo = cY("wxalitebaselibrary");
    AppMethodBeat.o(234107);
    return localWxaLiteAppInfo;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(234096);
    Uri localUri = Uri.parse("content://" + LiteAppContentProvider.AUTHORITY + "/");
    AppMethodBeat.o(234096);
    return localUri;
  }
  
  public final void a(final String paramString, final com.tencent.mm.plugin.lite.launch.a parama)
  {
    AppMethodBeat.i(234111);
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteApp appId:%s", new Object[] { paramString });
    final WxaLiteAppInfo localWxaLiteAppInfo = cY(paramString);
    if (d(localWxaLiteAppInfo)) {
      if ((localWxaLiteAppInfo == null) || (localWxaLiteAppInfo.coY == null) || (localWxaLiteAppInfo.coY.isEmpty())) {
        break label149;
      }
    }
    label149:
    for (String str = localWxaLiteAppInfo.coY;; str = "")
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "begin to checkLiteApp:%s patchId:%s", new Object[] { paramString, str });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.boots.a.c.class)).a(paramString, paramString, str, new com.tencent.mm.plugin.boots.a.f()
      {
        public final void a(g paramAnonymousg)
        {
          AppMethodBeat.i(233582);
          if (!Util.isNullOrNil(paramAnonymousg.smT))
          {
            Log.i("MicroMsg.LiteApp.LiteAppLogic", "start to download liteapp:" + paramString + ", url:" + paramAnonymousg.smT);
            e.Egt.a(paramAnonymousg, "release", parama);
            AppMethodBeat.o(233582);
            return;
          }
          Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteApp, url is null, appId:" + paramString);
          if (parama != null)
          {
            if (localWxaLiteAppInfo != null)
            {
              parama.a(localWxaLiteAppInfo);
              AppMethodBeat.o(233582);
              return;
            }
            parama.ewD();
          }
          AppMethodBeat.o(233582);
        }
      });
      AppMethodBeat.o(234111);
      return;
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "no need download, local pkg is debug");
      if (parama != null) {
        parama.a(localWxaLiteAppInfo);
      }
      AppMethodBeat.o(234111);
      return;
    }
  }
  
  public final void eLK()
  {
    AppMethodBeat.i(234108);
    final WxaLiteAppInfo localWxaLiteAppInfo = eLJ();
    eLH().a("wxalitebaselibrary", new com.tencent.mm.plugin.lite.launch.a()
    {
      public final void a(WxaLiteAppInfo paramAnonymousWxaLiteAppInfo)
      {
        AppMethodBeat.i(233972);
        if (paramAnonymousWxaLiteAppInfo == null)
        {
          AppMethodBeat.o(233972);
          return;
        }
        if (localWxaLiteAppInfo != null)
        {
          if (!localWxaLiteAppInfo.path.equals(paramAnonymousWxaLiteAppInfo.path))
          {
            f.eLH();
            if (!f.aMY("wxalitebaselibrary")) {}
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
        AppMethodBeat.o(233972);
      }
      
      public final void ewD() {}
    });
    AppMethodBeat.o(234108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.f
 * JD-Core Version:    0.7.0.1
 */