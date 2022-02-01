package com.tencent.mm.plugin.lite.logic;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService.a;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.plugin.expansions.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver;
import com.tencent.mm.plugin.lite.api.a;
import com.tencent.mm.plugin.lite.api.b;
import com.tencent.mm.plugin.lite.storage.LiteAppContentProvider;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.List;

public class d
{
  public static d KaX;
  public HashMap<String, m> KaY;
  
  private d()
  {
    AppMethodBeat.i(271378);
    this.KaY = new HashMap();
    AppMethodBeat.o(271378);
  }
  
  public static void a(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(271447);
    if (paramWxaLiteAppInfo == null)
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "app is empty.");
      AppMethodBeat.o(271447);
      return;
    }
    if (Util.isNullOrNil(paramWxaLiteAppInfo.path))
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "app path is empty.");
      AppMethodBeat.o(271447);
      return;
    }
    if (!new u(paramWxaLiteAppInfo.path).jKS())
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "app file isn't exist.");
      AppMethodBeat.o(271447);
      return;
    }
    Object localObject = f.aD(paramWxaLiteAppInfo.appId, paramWxaLiteAppInfo.egJ, paramWxaLiteAppInfo.md5);
    if (!((String)localObject).equalsIgnoreCase(paramWxaLiteAppInfo.path))
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "rename app folder from %s to %s", new Object[] { paramWxaLiteAppInfo.path, localObject });
      y.qp(paramWxaLiteAppInfo.path, (String)localObject);
      paramWxaLiteAppInfo.path = ((String)localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("LiteApp", paramWxaLiteAppInfo);
    try
    {
      MMApplicationContext.getContext().getContentResolver().call(getUri(), "insertLiteAppInfo", paramWxaLiteAppInfo.appId, (Bundle)localObject);
      AppMethodBeat.o(271447);
      return;
    }
    catch (Exception paramWxaLiteAppInfo)
    {
      Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", paramWxaLiteAppInfo, "", new Object[0]);
      AppMethodBeat.o(271447);
    }
  }
  
  private void a(final a parama)
  {
    AppMethodBeat.i(271473);
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteAppBaselib");
    fUi();
    final WxaLiteAppBaselibInfo localWxaLiteAppBaselibInfo = fUj();
    if (c(localWxaLiteAppBaselibInfo)) {
      if ((localWxaLiteAppBaselibInfo == null) || (localWxaLiteAppBaselibInfo.egJ == null) || (localWxaLiteAppBaselibInfo.egJ.isEmpty())) {
        break label114;
      }
    }
    label114:
    for (String str = localWxaLiteAppBaselibInfo.egJ;; str = "")
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "begin to checkLiteAppBaselib");
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.boots.a.c.class)).a("wxalitebaselibrary", "wxalitebaselibrary", str, new com.tencent.mm.plugin.boots.a.f()
      {
        public final void a(g paramAnonymousg)
        {
          AppMethodBeat.i(271390);
          if (!Util.isNullOrNil(paramAnonymousg.mOI))
          {
            Log.i("MicroMsg.LiteApp.LiteAppLogic", "start to download liteapp baselib: url:" + paramAnonymousg.mOI);
            c.KaN.a(paramAnonymousg, "release", parama);
            AppMethodBeat.o(271390);
            return;
          }
          Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteAppBaselib, url is null");
          if (parama != null)
          {
            if (localWxaLiteAppBaselibInfo != null)
            {
              parama.a(localWxaLiteAppBaselibInfo);
              AppMethodBeat.o(271390);
              return;
            }
            parama.csy();
          }
          AppMethodBeat.o(271390);
        }
      });
      AppMethodBeat.o(271473);
      return;
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "no need download, local pkg is debug");
      parama.a(localWxaLiteAppBaselibInfo);
      AppMethodBeat.o(271473);
      return;
    }
  }
  
  public static String aC(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(271516);
    Bundle localBundle = new Bundle();
    localBundle.putString("appId", paramString1);
    localBundle.putString("path", paramString2);
    localBundle.putString("signatureKey", paramString3);
    paramString1 = LiteAppIPCService.mzL;
    paramString1 = (Bundle)j.a(LiteAppIPCService.aYL(), localBundle, c.class);
    if ((paramString1 != null) && (!Util.isNullOrNil(paramString1.getString("minMajorVersion"))))
    {
      paramString1 = paramString1.getString("minMajorVersion");
      AppMethodBeat.o(271516);
      return paramString1;
    }
    AppMethodBeat.o(271516);
    return "";
  }
  
  public static boolean aJT(String paramString)
  {
    AppMethodBeat.i(271504);
    Object localObject = String.format("clicfg_liteapp_%s_enable", new Object[] { paramString });
    String str = String.format("clicfg_liteapp_%s_max_crash", new Object[] { paramString });
    if ((MMApplicationContext.isMainProcess()) && (fTT()))
    {
      boolean bool = com.tencent.mm.plugin.expt.e.d.dNI().hx((String)localObject, "0").equalsIgnoreCase("1");
      int i = Util.getInt(com.tencent.mm.plugin.expt.e.d.dNI().hx(str, "10"), 10);
      localObject = et(paramString);
      if (localObject == null) {}
      for (localObject = "";; localObject = ((WxaLiteAppInfo)localObject).egJ)
      {
        int j = MultiProcessMMKV.getMultiDefault().getInt(String.format("liteapp_%s_%s", new Object[] { paramString, localObject }), 0);
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "isLiteAppOpen appId%s version%s enable:%b, crashCount:%d", new Object[] { paramString, localObject, Boolean.valueOf(bool), Integer.valueOf(j) });
        if (!bool) {
          break label217;
        }
        if (j >= i) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 100L, 1L);
        AppMethodBeat.o(271504);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 101L, 1L);
      for (;;)
      {
        AppMethodBeat.o(271504);
        return false;
        label217:
        com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 102L, 1L);
      }
    }
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "can no get 'isLiteAppOpen' value when is no mm process.");
    AppMethodBeat.o(271504);
    return false;
  }
  
  public static boolean aJU(String paramString)
  {
    AppMethodBeat.i(271498);
    if (MMApplicationContext.isMainProcess())
    {
      boolean bool = com.tencent.mm.plugin.expt.e.d.dNI().hx("clicfg_liteapp_share_android", "1").equalsIgnoreCase("1");
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "isSharedLiteAppOpen appId%s enable:%b", new Object[] { paramString, Boolean.valueOf(bool) });
      AppMethodBeat.o(271498);
      return bool;
    }
    AppMethodBeat.o(271498);
    return false;
  }
  
  public static com.tencent.mm.plugin.lite.storage.d aJY(String paramString)
  {
    AppMethodBeat.i(271453);
    try
    {
      paramString = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppAuthInfo", paramString, null);
      if (paramString == null)
      {
        AppMethodBeat.o(271453);
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
      com.tencent.mm.plugin.lite.storage.d locald = new com.tencent.mm.plugin.lite.storage.d();
      locald.field_host = paramString.getString("host");
      locald.field_param = paramString.getString("param");
      locald.field_paramMap = paramString.getString("paramMap");
      locald.field_headerMap = paramString.getString("headerMap");
      locald.field_updateTime = paramString.getLong("updateTime");
      AppMethodBeat.o(271453);
      return locald;
    }
  }
  
  public static void b(WxaLiteAppBaselibInfo paramWxaLiteAppBaselibInfo)
  {
    AppMethodBeat.i(271421);
    if (Util.isNullOrNil(paramWxaLiteAppBaselibInfo.path))
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "baselib path is empty.");
      AppMethodBeat.o(271421);
      return;
    }
    if (!new u(paramWxaLiteAppBaselibInfo.path).jKS())
    {
      Log.e("MicroMsg.LiteApp.LiteAppLogic", "baselib file isn't exist.");
      AppMethodBeat.o(271421);
      return;
    }
    Object localObject = f.aE(paramWxaLiteAppBaselibInfo.egH, paramWxaLiteAppBaselibInfo.egJ, paramWxaLiteAppBaselibInfo.md5);
    if (!((String)localObject).equalsIgnoreCase(paramWxaLiteAppBaselibInfo.path))
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "rename app folder from %s to %s", new Object[] { paramWxaLiteAppBaselibInfo.path, localObject });
      y.qp(paramWxaLiteAppBaselibInfo.path, (String)localObject);
      paramWxaLiteAppBaselibInfo.path = ((String)localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).setClassLoader(WxaLiteAppBaselibInfo.class.getClassLoader());
    ((Bundle)localObject).putParcelable("LiteAppBaselib", paramWxaLiteAppBaselibInfo);
    try
    {
      MMApplicationContext.getContext().getContentResolver().call(getUri(), "insertLiteAppBaselibInfo", paramWxaLiteAppBaselibInfo.egH, (Bundle)localObject);
      AppMethodBeat.o(271421);
      return;
    }
    catch (Exception paramWxaLiteAppBaselibInfo)
    {
      Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", paramWxaLiteAppBaselibInfo, "", new Object[0]);
      AppMethodBeat.o(271421);
    }
  }
  
  public static void c(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(271460);
    if (paramWxaLiteAppInfo.appId.equalsIgnoreCase("wxalitecce81f5fba338df4dd5f74df8229c600"))
    {
      MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMultiDefault();
      localMultiProcessMMKV.putString("wxa_lite_app_game_center_version", paramWxaLiteAppInfo.egJ);
      localMultiProcessMMKV.commit();
    }
    AppMethodBeat.o(271460);
  }
  
  private static boolean c(WxaLiteAppBaselibInfo paramWxaLiteAppBaselibInfo)
  {
    AppMethodBeat.i(271479);
    if (paramWxaLiteAppBaselibInfo == null)
    {
      AppMethodBeat.o(271479);
      return true;
    }
    if (paramWxaLiteAppBaselibInfo.anH())
    {
      AppMethodBeat.o(271479);
      return false;
    }
    AppMethodBeat.o(271479);
    return true;
  }
  
  private static boolean d(WxaLiteAppInfo paramWxaLiteAppInfo)
  {
    AppMethodBeat.i(271485);
    if (paramWxaLiteAppInfo == null)
    {
      AppMethodBeat.o(271485);
      return true;
    }
    if (paramWxaLiteAppInfo.anH())
    {
      AppMethodBeat.o(271485);
      return false;
    }
    AppMethodBeat.o(271485);
    return true;
  }
  
  public static WxaLiteAppInfo et(String paramString)
  {
    AppMethodBeat.i(271435);
    try
    {
      Bundle localBundle = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppInfo", paramString, null);
      if (localBundle == null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "null == bundle, appId:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(271435);
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
      AppMethodBeat.o(271435);
    }
    return paramString;
  }
  
  public static boolean fTT()
  {
    AppMethodBeat.i(271491);
    if (!e.aQh())
    {
      AppMethodBeat.o(271491);
      return false;
    }
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zhq, 1) == 1)
    {
      AppMethodBeat.o(271491);
      return true;
    }
    AppMethodBeat.o(271491);
    return false;
  }
  
  public static d fUi()
  {
    AppMethodBeat.i(271388);
    if (KaX == null) {}
    try
    {
      KaX = new d();
      d locald = KaX;
      AppMethodBeat.o(271388);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(271388);
    }
  }
  
  public static WxaLiteAppBaselibInfo fUj()
  {
    AppMethodBeat.i(271412);
    try
    {
      Bundle localBundle = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLatestLiteAppBaselibInfo", null, null);
      if (localBundle == null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "null == bundle");
        AppMethodBeat.o(271412);
        return null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LiteApp.LiteAppLogic", localException, "", new Object[0]);
        localWxaLiteAppBaselibInfo = null;
      }
      localWxaLiteAppBaselibInfo.setClassLoader(WxaLiteAppBaselibInfo.class.getClassLoader());
      WxaLiteAppBaselibInfo localWxaLiteAppBaselibInfo = (WxaLiteAppBaselibInfo)localWxaLiteAppBaselibInfo.getParcelable("LiteAppBaselib");
      AppMethodBeat.o(271412);
      return localWxaLiteAppBaselibInfo;
    }
  }
  
  public static List<WxaLiteAppInfo> fUk()
  {
    AppMethodBeat.i(271429);
    Object localObject = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppList", null, null);
    if (localObject == null)
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "getLiteAppList bundle is null.");
      AppMethodBeat.o(271429);
      return null;
    }
    ((Bundle)localObject).setClassLoader(WxaLiteAppInfo.class.getClassLoader());
    if (((Bundle)localObject).containsKey("LiteAppList"))
    {
      localObject = ((Bundle)localObject).getParcelableArrayList("LiteAppList");
      AppMethodBeat.o(271429);
      return localObject;
    }
    AppMethodBeat.o(271429);
    return null;
  }
  
  public static WxaLiteAppBaselibInfo fUl()
  {
    AppMethodBeat.i(271465);
    fUi();
    WxaLiteAppBaselibInfo localWxaLiteAppBaselibInfo = fUj();
    AppMethodBeat.o(271465);
    return localWxaLiteAppBaselibInfo;
  }
  
  public static String fUn()
  {
    AppMethodBeat.i(271510);
    Object localObject = new Bundle();
    LiteAppIPCService.a locala = LiteAppIPCService.mzL;
    localObject = (Bundle)j.a(LiteAppIPCService.aYL(), (Parcelable)localObject, b.class);
    if ((localObject != null) && (!Util.isNullOrNil(((Bundle)localObject).getString("majorVersion"))))
    {
      localObject = ((Bundle)localObject).getString("majorVersion");
      AppMethodBeat.o(271510);
      return localObject;
    }
    AppMethodBeat.o(271510);
    return "";
  }
  
  public static String getBaseLibMajorVersionByPath(String paramString)
  {
    AppMethodBeat.i(271526);
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    paramString = LiteAppIPCService.mzL;
    paramString = (Bundle)j.a(LiteAppIPCService.aYL(), localBundle, a.class);
    if ((paramString != null) && (!Util.isNullOrNil(paramString.getString("majorVersion"))))
    {
      paramString = paramString.getString("majorVersion");
      AppMethodBeat.o(271526);
      return paramString;
    }
    AppMethodBeat.o(271526);
    return "";
  }
  
  public static WxaLiteAppBaselibInfo getLiteAppBaselibInfo(String paramString)
  {
    AppMethodBeat.i(271403);
    try
    {
      Bundle localBundle = MMApplicationContext.getContext().getContentResolver().call(getUri(), "getLiteAppBaselibInfo", paramString, null);
      if (localBundle == null)
      {
        Log.i("MicroMsg.LiteApp.LiteAppLogic", "null == bundle, majorVersion:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(271403);
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
      localObject.setClassLoader(WxaLiteAppBaselibInfo.class.getClassLoader());
      paramString = (WxaLiteAppBaselibInfo)localObject.getParcelable("LiteAppBaselib");
      AppMethodBeat.o(271403);
    }
    return paramString;
  }
  
  public static Uri getUri()
  {
    AppMethodBeat.i(271396);
    Uri localUri = Uri.parse("content://" + LiteAppContentProvider.AUTHORITY + "/");
    AppMethodBeat.o(271396);
    return localUri;
  }
  
  public final void a(final String paramString, final b paramb)
  {
    AppMethodBeat.i(271534);
    Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteApp appId:%s", new Object[] { paramString });
    final WxaLiteAppInfo localWxaLiteAppInfo = et(paramString);
    if (d(localWxaLiteAppInfo)) {
      if ((localWxaLiteAppInfo == null) || (localWxaLiteAppInfo.egJ == null) || (localWxaLiteAppInfo.egJ.isEmpty())) {
        break label147;
      }
    }
    label147:
    for (String str = localWxaLiteAppInfo.egJ;; str = "")
    {
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "begin to checkLiteApp:%s patchId:%s", new Object[] { paramString, str });
      ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.boots.a.c.class)).a(paramString, paramString, str, new com.tencent.mm.plugin.boots.a.f()
      {
        public final void a(g paramAnonymousg)
        {
          AppMethodBeat.i(271383);
          if (!Util.isNullOrNil(paramAnonymousg.mOI))
          {
            Log.i("MicroMsg.LiteApp.LiteAppLogic", "start to download liteapp:" + paramString + ", url:" + paramAnonymousg.mOI);
            c.KaN.a(paramAnonymousg, "release", paramb);
            AppMethodBeat.o(271383);
            return;
          }
          Log.i("MicroMsg.LiteApp.LiteAppLogic", "checkLiteApp, url is null, appId:" + paramString);
          if (paramb != null)
          {
            if (localWxaLiteAppInfo != null)
            {
              paramb.b(localWxaLiteAppInfo);
              AppMethodBeat.o(271383);
              return;
            }
            paramb.csy();
          }
          AppMethodBeat.o(271383);
        }
      });
      AppMethodBeat.o(271534);
      return;
      Log.i("MicroMsg.LiteApp.LiteAppLogic", "no need download, local pkg is debug");
      if (paramb != null) {
        paramb.b(localWxaLiteAppInfo);
      }
      AppMethodBeat.o(271534);
      return;
    }
  }
  
  public final void fUm()
  {
    AppMethodBeat.i(271531);
    fUi();
    final WxaLiteAppBaselibInfo localWxaLiteAppBaselibInfo = fUj();
    fUi().a(new a()
    {
      public final void a(WxaLiteAppBaselibInfo paramAnonymousWxaLiteAppBaselibInfo)
      {
        AppMethodBeat.i(271393);
        if (paramAnonymousWxaLiteAppBaselibInfo == null)
        {
          AppMethodBeat.o(271393);
          return;
        }
        if (localWxaLiteAppBaselibInfo != null)
        {
          if (!localWxaLiteAppBaselibInfo.path.equals(paramAnonymousWxaLiteAppBaselibInfo.path))
          {
            d.fUi();
            if (!d.aJT("wxalitebaselibrary")) {}
          }
        }
        else
        {
          Intent localIntent = new Intent();
          localIntent.setClass(MMApplicationContext.getContext(), LiteAppTaskPreloadReceiver.class);
          localIntent.addFlags(268435456);
          localIntent.putExtra("task", "updateBaseLibPath");
          localIntent.putExtra("path", paramAnonymousWxaLiteAppBaselibInfo.path);
          MMApplicationContext.getContext().sendBroadcast(localIntent);
        }
        AppMethodBeat.o(271393);
      }
      
      public final void csy() {}
    });
    AppMethodBeat.o(271531);
  }
  
  static class a
    implements m<Bundle, Bundle>
  {}
  
  static class b
    implements m<Bundle, Bundle>
  {}
  
  static class c
    implements m<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.logic.d
 * JD-Core Version:    0.7.0.1
 */