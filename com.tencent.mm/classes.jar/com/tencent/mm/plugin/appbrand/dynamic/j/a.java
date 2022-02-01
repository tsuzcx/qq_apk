package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.aa;
import com.tencent.mm.am.b.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.bq.a;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c;
import com.tencent.mm.plugin.appbrand.widget.p;
import com.tencent.mm.plugin.appbrand.widget.t;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.protocal.protobuf.cws;
import com.tencent.mm.protocal.protobuf.giy;
import com.tencent.mm.protocal.protobuf.giz;
import com.tencent.mm.protocal.protobuf.gjb;
import com.tencent.mm.protocal.protobuf.gnl;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static String U(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121473);
    paramString = paramString + "#" + paramInt1 + "#" + paramInt2;
    AppMethodBeat.o(121473);
    return paramString;
  }
  
  public static WxaPkgWrappingInfo a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    AppMethodBeat.i(121471);
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString1);
    localBundle.putString("appId", paramString2);
    localBundle.putInt("pkgType", paramInt1);
    localBundle.putInt("pkgVersion", paramInt2);
    localBundle.putString("searchId", paramString3);
    localBundle.putString("preload_download_data", paramString4);
    if (paramInt1 == 10102)
    {
      paramString1 = com.tencent.mm.plugin.appbrand.dynamic.b.e.Ze(U(paramString2, paramInt1, paramInt2));
      if (paramString1 != null)
      {
        com.tencent.mm.modelappbrand.u.i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
        AppMethodBeat.o(121471);
        return paramString1;
      }
    }
    paramString1 = (WxaPkgWrappingInfo)j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class);
    if (paramString1 != null) {
      com.tencent.mm.plugin.appbrand.dynamic.b.e.b(U(paramString2, paramInt1, paramInt2), paramString1);
    }
    AppMethodBeat.o(121471);
    return paramString1;
  }
  
  public static d a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    AppMethodBeat.i(121472);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("appId", paramString1);
    ((Bundle)localObject).putInt("pkgType", paramInt1);
    ((Bundle)localObject).putInt("pkgVersion", paramInt2);
    ((Bundle)localObject).putInt("widgetType", paramInt3);
    ((Bundle)localObject).putInt("scene", paramInt4);
    ((Bundle)localObject).putString("preloadLaunchData", paramString2);
    paramString2 = (Bundle)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject, c.class);
    if (paramString2 == null)
    {
      AppMethodBeat.o(121472);
      return null;
    }
    localObject = new d();
    ((d)localObject).appId = paramString1;
    ((d)localObject).rnE = ((DebuggerInfo)paramString2.getParcelable("debuggerInfo"));
    paramString1 = paramString2.getByteArray("jsApiInfo");
    if (paramString1 != null) {
      ((d)localObject).rnI = new aat();
    }
    try
    {
      ((d)localObject).rnI.parseFrom(paramString1);
      paramString1 = paramString2.getByteArray("launchAction");
      if (paramString1 != null) {
        ((d)localObject).rnH = new giz();
      }
    }
    catch (IOException paramString1)
    {
      try
      {
        ((d)localObject).rnH.parseFrom(paramString1);
        paramString1 = paramString2.getByteArray("versionInfo");
        ((d)localObject).rnJ = new gjb();
        if (paramString1 == null) {}
      }
      catch (IOException paramString1)
      {
        try
        {
          for (;;)
          {
            ((d)localObject).rnJ.parseFrom(paramString1);
            ((d)localObject).rnF = ((WidgetSysConfig)paramString2.getParcelable("sysConfig"));
            ((d)localObject).rnG = ((WidgetRuntimeConfig)paramString2.getParcelable("runtimeConfig"));
            if (((d)localObject).rnG == null) {
              ((d)localObject).rnG = new WidgetRuntimeConfig();
            }
            AppMethodBeat.o(121472);
            return localObject;
            paramString1 = paramString1;
            Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
          paramString1 = paramString1;
          Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            Log.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
        }
      }
    }
  }
  
  public static WxaPkgWrappingInfo c(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(121470);
    paramString1 = a(paramString1, paramString2, paramString3, paramInt, 0, null);
    AppMethodBeat.o(121470);
    return paramString1;
  }
  
  static class a
    implements m<Bundle, WxaPkgWrappingInfo>
  {
    private static WxaPkgWrappingInfo Y(Bundle paramBundle)
    {
      AppMethodBeat.i(121463);
      Object localObject1 = paramBundle.getString("id");
      String str = paramBundle.getString("appId");
      int j = paramBundle.getInt("pkgType");
      int i = paramBundle.getInt("pkgVersion");
      paramBundle.getInt("scene");
      Object localObject2 = paramBundle.getString("searchId");
      Object localObject3 = paramBundle.getString("preload_download_data");
      switch (j)
      {
      default: 
        paramBundle = "";
      }
      try
      {
        localObject3 = ((com.tencent.mm.plugin.appbrand.api.e)h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().c(str, j, new String[] { "downloadURL", "version" });
        if (localObject3 != null)
        {
          paramBundle = ((bh)localObject3).field_downloadURL;
          i = ((bh)localObject3).field_version;
        }
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.rmU, paramBundle).cnT();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          int k;
          Log.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
        }
      }
      paramBundle = "";
      try
      {
        bh localbh = ((com.tencent.mm.plugin.appbrand.api.e)h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().c(str, j, new String[] { "downloadURL", "version" });
        if (localbh != null)
        {
          paramBundle = localbh.field_downloadURL;
          i = localbh.field_version;
        }
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.rmV, paramBundle, (String)localObject3).cnT();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        Log.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
      }
      do
      {
        AppMethodBeat.o(121463);
        return null;
      } while (new c(str, "", "", (byte)0).cnU() != com.tencent.mm.plugin.appbrand.dynamic.launching.c.a.rnc.ordinal());
      paramBundle = ((com.tencent.mm.plugin.appbrand.api.e)h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().c(str, j, new String[] { "downloadURL" });
      if (paramBundle == null)
      {
        Log.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[] { str, Integer.valueOf(j) });
        AppMethodBeat.o(121463);
        return null;
      }
      try
      {
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.rmU, paramBundle.field_downloadURL).cnT();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        Log.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[] { str, Integer.valueOf(j), paramBundle });
        AppMethodBeat.o(121463);
        return null;
      }
      paramBundle = (WxaPkgWrappingInfo)WxaPkgIntegrityChecker.H(str, j, i).second;
      AppMethodBeat.o(121463);
      return paramBundle;
      paramBundle = ((com.tencent.mm.plugin.appbrand.api.e)h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().c(str, j, new String[] { "downloadURL" });
      h.baC();
      k = com.tencent.mm.kernel.b.getUin();
      localObject1 = new com.tencent.mm.am.c.a();
      localObject2 = new cwr();
      ((cwr)localObject2).appid = str;
      ((cwr)localObject2).aaBM = k;
      localObject3 = new giy();
      switch (j)
      {
      default: 
        ((giy)localObject3).Tqb = 0;
        ((giy)localObject3).acfo = 0;
        if (paramBundle != null)
        {
          ((giy)localObject3).md5 = paramBundle.field_versionMd5;
          label605:
          ((cwr)localObject2).aaBN = new LinkedList();
          ((cwr)localObject2).aaBN.add(localObject3);
          ((com.tencent.mm.am.c.a)localObject1).otE = ((com.tencent.mm.bx.a)localObject2);
          ((com.tencent.mm.am.c.a)localObject1).otF = new cws();
          ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
          ((com.tencent.mm.am.c.a)localObject1).funcId = 1186;
          paramBundle = aa.a(((com.tencent.mm.am.c.a)localObject1).bEF(), 20000L);
          if ((paramBundle.errType != 0) || (paramBundle.errCode != 0)) {
            break label914;
          }
          paramBundle = (cws)paramBundle.ott;
          if ((paramBundle != null) && (paramBundle.aaBN != null) && (paramBundle.aaBN.size() > 0))
          {
            paramBundle = (giy)paramBundle.aaBN.getFirst();
            com.tencent.mm.modelappbrand.u.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", new Object[] { Integer.valueOf(j), paramBundle.md5, paramBundle.url });
            if ((paramBundle.url != null) && (paramBundle.url.length() > 0)) {
              switch (j)
              {
              }
            }
          }
        }
        break;
      }
      for (;;)
      {
        paramBundle = (WxaPkgWrappingInfo)WxaPkgIntegrityChecker.H(str, j, i).second;
        AppMethodBeat.o(121463);
        return paramBundle;
        ((giy)localObject3).Tqb = 1;
        ((giy)localObject3).acfo = 1;
        break;
        ((giy)localObject3).Tqb = 2;
        ((giy)localObject3).acfo = 1;
        break;
        ((giy)localObject3).md5 = "";
        break label605;
        ((com.tencent.mm.plugin.appbrand.api.e)h.ax(com.tencent.mm.plugin.appbrand.api.e.class)).ceo().a(str, j, paramBundle.url, paramBundle.md5, 0L, 0L);
        continue;
        label914:
        Log.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
        com.tencent.mm.modelappbrand.u.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
      }
    }
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  static class c
    implements m<Bundle, Bundle>
  {
    private static Bundle Z(Bundle paramBundle)
    {
      boolean bool2 = true;
      AppMethodBeat.i(121466);
      Object localObject1 = paramBundle.getString("appId");
      int i = paramBundle.getInt("pkgType");
      int j = paramBundle.getInt("pkgVersion");
      int k = paramBundle.getInt("scene");
      int m = paramBundle.getInt("widgetType");
      Object localObject2 = paramBundle.getString("preloadLaunchData", "");
      paramBundle = new Bundle();
      Object localObject4;
      try
      {
        localObject4 = new com.tencent.mm.plugin.appbrand.dynamic.launching.a((String)localObject1, i, j, k, m, (String)localObject2).cnS();
        if (localObject4 == null)
        {
          AppMethodBeat.o(121466);
          return paramBundle;
        }
        if (((p)localObject4).field_jsApiInfo != null) {
          paramBundle.putByteArray("jsApiInfo", ((p)localObject4).field_jsApiInfo.toByteArray());
        }
        if (((p)localObject4).field_launchAction != null) {
          paramBundle.putByteArray("launchAction", ((p)localObject4).field_launchAction.toByteArray());
        }
        if (((p)localObject4).field_versionInfo != null) {
          paramBundle.putByteArray("versionInfo", ((p)localObject4).field_versionInfo.toByteArray());
        }
        localObject2 = new WidgetRuntimeConfig();
        ((WidgetRuntimeConfig)localObject2).appId = ((String)localObject1);
        ((WidgetRuntimeConfig)localObject2).rmS = m;
        localObject4 = ((p)localObject4).field_widgetSetting;
        if (localObject4 != null)
        {
          ((WidgetRuntimeConfig)localObject2).rnj = ((gnl)localObject4).aciu;
          ((WidgetRuntimeConfig)localObject2).rnl = ((gnl)localObject4).aciw;
          ((WidgetRuntimeConfig)localObject2).rnk = ((gnl)localObject4).aciv;
        }
        paramBundle.putParcelable("runtimeConfig", (Parcelable)localObject2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[] { localException });
        }
        localObject3 = localException.cfi().agX((String)localObject1);
        localObject1 = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.Zf((String)localObject1);
        localObject4 = new DebuggerInfo();
        if (localObject3 == null) {
          break label452;
        }
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.widget.b.b)com.tencent.mm.plugin.appbrand.dynamic.k.a.aS(com.tencent.mm.plugin.appbrand.widget.b.b.class);
      if (localObject2 == null)
      {
        AppMethodBeat.o(121466);
        return paramBundle;
      }
      Object localObject3;
      if (((t)localObject3).field_openDebug)
      {
        bool1 = true;
        ((DebuggerInfo)localObject4).rlq = bool1;
        if ((!k.a.vK(i)) && ((localObject1 == null) || (!((DebuggerInfo)localObject1).rlp))) {
          break label458;
        }
        bool1 = true;
        label354:
        ((DebuggerInfo)localObject4).rlp = bool1;
        if ((localObject1 == null) || (!((DebuggerInfo)localObject1).rlr)) {
          break label464;
        }
      }
      label452:
      label458:
      label464:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((DebuggerInfo)localObject4).rlr = bool1;
        paramBundle.putParcelable("debuggerInfo", (Parcelable)localObject4);
        localObject1 = AppBrandGlobalSystemConfig.ckD();
        localObject3 = new WidgetSysConfig();
        ((WidgetSysConfig)localObject3).qWX = ((AppBrandGlobalSystemConfig)localObject1).qWX;
        ((WidgetSysConfig)localObject3).qWY = ((AppBrandGlobalSystemConfig)localObject1).qWY;
        ((WidgetSysConfig)localObject3).qWZ = ((AppBrandGlobalSystemConfig)localObject1).qWZ;
        paramBundle.putParcelable("sysConfig", (Parcelable)localObject3);
        AppMethodBeat.o(121466);
        return paramBundle;
        bool1 = false;
        break;
        bool1 = false;
        break label354;
      }
    }
  }
  
  public static class d
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
  
  public static abstract interface e
  {
    public abstract void az(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a
 * JD-Core Version:    0.7.0.1
 */