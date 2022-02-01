package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.y;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c.a;
import com.tencent.mm.plugin.appbrand.widget.n;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.protocal.protobuf.bmg;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.eki;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static String N(String paramString, int paramInt1, int paramInt2)
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
      paramString1 = com.tencent.mm.plugin.appbrand.dynamic.b.e.Pj(N(paramString2, paramInt1, paramInt2));
      if (paramString1 != null)
      {
        u.i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
        AppMethodBeat.o(121471);
        return paramString1;
      }
    }
    paramString1 = (WxaPkgWrappingInfo)h.a("com.tencent.mm", localBundle, a.class);
    if (paramString1 != null) {
      com.tencent.mm.plugin.appbrand.dynamic.b.e.b(N(paramString2, paramInt1, paramInt2), paramString1);
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
    paramString2 = (Bundle)h.a("com.tencent.mm", (Parcelable)localObject, c.class);
    if (paramString2 == null)
    {
      AppMethodBeat.o(121472);
      return null;
    }
    localObject = new d();
    ((d)localObject).appId = paramString1;
    ((d)localObject).klH = ((DebuggerInfo)paramString2.getParcelable("debuggerInfo"));
    paramString1 = paramString2.getByteArray("jsApiInfo");
    if (paramString1 != null) {
      ((d)localObject).klL = new xi();
    }
    try
    {
      ((d)localObject).klL.parseFrom(paramString1);
      paramString1 = paramString2.getByteArray("launchAction");
      if (paramString1 != null) {
        ((d)localObject).klK = new egy();
      }
    }
    catch (IOException paramString1)
    {
      try
      {
        ((d)localObject).klK.parseFrom(paramString1);
        paramString1 = paramString2.getByteArray("versionInfo");
        ((d)localObject).klM = new eha();
        if (paramString1 == null) {}
      }
      catch (IOException paramString1)
      {
        try
        {
          for (;;)
          {
            ((d)localObject).klM.parseFrom(paramString1);
            ((d)localObject).klI = ((WidgetSysConfig)paramString2.getParcelable("sysConfig"));
            ((d)localObject).klJ = ((WidgetRuntimeConfig)paramString2.getParcelable("runtimeConfig"));
            if (((d)localObject).klJ == null) {
              ((d)localObject).klJ = new WidgetRuntimeConfig();
            }
            AppMethodBeat.o(121472);
            return localObject;
            paramString1 = paramString1;
            ae.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
          paramString1 = paramString1;
          ae.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            ae.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
        }
      }
    }
  }
  
  public static WxaPkgWrappingInfo b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(121470);
    paramString1 = a(paramString1, paramString2, paramString3, paramInt, 0, null);
    AppMethodBeat.o(121470);
    return paramString1;
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.k<Bundle, WxaPkgWrappingInfo>
  {
    private static WxaPkgWrappingInfo C(Bundle paramBundle)
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
        localObject3 = ((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().a(str, j, new String[] { "downloadURL", "version" });
        if (localObject3 != null)
        {
          paramBundle = ((bd)localObject3).field_downloadURL;
          i = ((bd)localObject3).field_version;
        }
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.kkX, paramBundle).bgP();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          int k;
          ae.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
        }
      }
      paramBundle = "";
      try
      {
        bd localbd = ((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().a(str, j, new String[] { "downloadURL", "version" });
        if (localbd != null)
        {
          paramBundle = localbd.field_downloadURL;
          i = localbd.field_version;
        }
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.kkY, paramBundle, (String)localObject3).bgP();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        ae.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
      }
      do
      {
        AppMethodBeat.o(121463);
        return null;
      } while (new com.tencent.mm.plugin.appbrand.dynamic.launching.c(str, "", "", (byte)0).bgQ() != c.a.klf.ordinal());
      paramBundle = ((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().a(str, j, new String[] { "downloadURL" });
      if (paramBundle == null)
      {
        ae.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[] { str, Integer.valueOf(j) });
        AppMethodBeat.o(121463);
        return null;
      }
      try
      {
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.kkX, paramBundle.field_downloadURL).bgP();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        ae.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[] { str, Integer.valueOf(j), paramBundle });
        AppMethodBeat.o(121463);
        return null;
      }
      paramBundle = (WxaPkgWrappingInfo)WxaPkgIntegrityChecker.D(str, j, i).second;
      AppMethodBeat.o(121463);
      return paramBundle;
      paramBundle = ((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().a(str, j, new String[] { "downloadURL" });
      g.ajP();
      k = com.tencent.mm.kernel.a.getUin();
      localObject1 = new b.a();
      localObject2 = new bmf();
      ((bmf)localObject2).dwb = str;
      ((bmf)localObject2).GZe = k;
      localObject3 = new egx();
      switch (j)
      {
      default: 
        ((egx)localObject3).Gdl = 0;
        ((egx)localObject3).IkJ = 0;
        if (paramBundle != null)
        {
          ((egx)localObject3).md5 = paramBundle.field_versionMd5;
          label605:
          ((bmf)localObject2).GZf = new LinkedList();
          ((bmf)localObject2).GZf.add(localObject3);
          ((b.a)localObject1).hQF = ((com.tencent.mm.bw.a)localObject2);
          ((b.a)localObject1).hQG = new bmg();
          ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
          ((b.a)localObject1).funcId = 1186;
          paramBundle = y.e(((b.a)localObject1).aDS());
          if ((paramBundle.errType != 0) || (paramBundle.errCode != 0)) {
            break label910;
          }
          paramBundle = (bmg)paramBundle.hQv;
          if ((paramBundle != null) && (paramBundle.GZf != null) && (paramBundle.GZf.size() > 0))
          {
            paramBundle = (egx)paramBundle.GZf.getFirst();
            u.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", new Object[] { Integer.valueOf(j), paramBundle.md5, paramBundle.url });
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
        paramBundle = (WxaPkgWrappingInfo)WxaPkgIntegrityChecker.D(str, j, i).second;
        AppMethodBeat.o(121463);
        return paramBundle;
        ((egx)localObject3).Gdl = 1;
        ((egx)localObject3).IkJ = 1;
        break;
        ((egx)localObject3).Gdl = 2;
        ((egx)localObject3).IkJ = 1;
        break;
        ((egx)localObject3).md5 = "";
        break label605;
        ((com.tencent.mm.plugin.appbrand.api.e)g.ab(com.tencent.mm.plugin.appbrand.api.e.class)).aYP().a(str, j, paramBundle.url, paramBundle.md5, 0L, 0L);
        continue;
        label910:
        ae.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
        u.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
      }
    }
  }
  
  static class b
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  static class c
    implements com.tencent.mm.ipcinvoker.k<Bundle, Bundle>
  {
    private static Bundle D(Bundle paramBundle)
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
        localObject4 = new com.tencent.mm.plugin.appbrand.dynamic.launching.a((String)localObject1, i, j, k, m, (String)localObject2).bgO();
        if (localObject4 == null)
        {
          AppMethodBeat.o(121466);
          return paramBundle;
        }
        if (((com.tencent.mm.plugin.appbrand.widget.k)localObject4).field_jsApiInfo != null) {
          paramBundle.putByteArray("jsApiInfo", ((com.tencent.mm.plugin.appbrand.widget.k)localObject4).field_jsApiInfo.toByteArray());
        }
        if (((com.tencent.mm.plugin.appbrand.widget.k)localObject4).field_launchAction != null) {
          paramBundle.putByteArray("launchAction", ((com.tencent.mm.plugin.appbrand.widget.k)localObject4).field_launchAction.toByteArray());
        }
        if (((com.tencent.mm.plugin.appbrand.widget.k)localObject4).field_versionInfo != null) {
          paramBundle.putByteArray("versionInfo", ((com.tencent.mm.plugin.appbrand.widget.k)localObject4).field_versionInfo.toByteArray());
        }
        localObject2 = new WidgetRuntimeConfig();
        ((WidgetRuntimeConfig)localObject2).appId = ((String)localObject1);
        ((WidgetRuntimeConfig)localObject2).kkV = m;
        localObject4 = ((com.tencent.mm.plugin.appbrand.widget.k)localObject4).field_widgetSetting;
        if (localObject4 != null)
        {
          ((WidgetRuntimeConfig)localObject2).klm = ((eki)localObject4).Ino;
          ((WidgetRuntimeConfig)localObject2).klo = ((eki)localObject4).Inq;
          ((WidgetRuntimeConfig)localObject2).kln = ((eki)localObject4).Inp;
        }
        paramBundle.putParcelable("runtimeConfig", (Parcelable)localObject2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[] { localException });
        }
        localObject3 = localException.aZq().VZ((String)localObject1);
        localObject1 = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.Pk((String)localObject1);
        localObject4 = new DebuggerInfo();
        if (localObject3 == null) {
          break label452;
        }
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.widget.a.b)com.tencent.mm.plugin.appbrand.dynamic.k.a.aw(com.tencent.mm.plugin.appbrand.widget.a.b.class);
      if (localObject2 == null)
      {
        AppMethodBeat.o(121466);
        return paramBundle;
      }
      Object localObject3;
      if (((n)localObject3).field_openDebug)
      {
        bool1 = true;
        ((DebuggerInfo)localObject4).kju = bool1;
        if ((!j.a.oQ(i)) && ((localObject1 == null) || (!((DebuggerInfo)localObject1).kjt))) {
          break label458;
        }
        bool1 = true;
        label354:
        ((DebuggerInfo)localObject4).kjt = bool1;
        if ((localObject1 == null) || (!((DebuggerInfo)localObject1).kjv)) {
          break label464;
        }
      }
      label452:
      label458:
      label464:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((DebuggerInfo)localObject4).kjv = bool1;
        paramBundle.putParcelable("debuggerInfo", (Parcelable)localObject4);
        localObject1 = AppBrandGlobalSystemConfig.bez();
        localObject3 = new WidgetSysConfig();
        ((WidgetSysConfig)localObject3).jZV = ((AppBrandGlobalSystemConfig)localObject1).jZV;
        ((WidgetSysConfig)localObject3).jZW = ((AppBrandGlobalSystemConfig)localObject1).jZW;
        ((WidgetSysConfig)localObject3).jZX = ((AppBrandGlobalSystemConfig)localObject1).jZX;
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
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
  
  public static abstract interface e
  {
    public abstract void am(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a
 * JD-Core Version:    0.7.0.1
 */