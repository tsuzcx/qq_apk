package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.y;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bb;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.bh.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;
import com.tencent.mm.plugin.appbrand.widget.n;
import com.tencent.mm.plugin.appbrand.widget.o;
import com.tencent.mm.protocal.protobuf.bdn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dtq;
import com.tencent.mm.protocal.protobuf.dwu;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
{
  private static String M(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121473);
    paramString = paramString + "#" + paramInt1 + "#" + paramInt2;
    AppMethodBeat.o(121473);
    return paramString;
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
    ((d)localObject).jnU = ((DebuggerInfo)paramString2.getParcelable("debuggerInfo"));
    paramString1 = paramString2.getByteArray("jsApiInfo");
    if (paramString1 != null) {
      ((d)localObject).jnY = new uw();
    }
    try
    {
      ((d)localObject).jnY.parseFrom(paramString1);
      paramString1 = paramString2.getByteArray("launchAction");
      if (paramString1 != null) {
        ((d)localObject).jnX = new dto();
      }
    }
    catch (IOException paramString1)
    {
      try
      {
        ((d)localObject).jnX.parseFrom(paramString1);
        paramString1 = paramString2.getByteArray("versionInfo");
        ((d)localObject).jnZ = new dtq();
        if (paramString1 == null) {}
      }
      catch (IOException paramString1)
      {
        try
        {
          for (;;)
          {
            ((d)localObject).jnZ.parseFrom(paramString1);
            ((d)localObject).jnV = ((WidgetSysConfig)paramString2.getParcelable("sysConfig"));
            ((d)localObject).jnW = ((WidgetRuntimeConfig)paramString2.getParcelable("runtimeConfig"));
            if (((d)localObject).jnW == null) {
              ((d)localObject).jnW = new WidgetRuntimeConfig();
            }
            AppMethodBeat.o(121472);
            return localObject;
            paramString1 = paramString1;
            ad.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
          paramString1 = paramString1;
          ad.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            ad.v("MicroMsg.DynamicPkgUpdater", "parseFrom bytes failed : %s", new Object[] { paramString1 });
          }
        }
      }
    }
  }
  
  public static WxaPkgWrappingInfo b(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(121470);
    paramString1 = b(paramString1, paramString2, paramString3, paramInt, 0, null);
    AppMethodBeat.o(121470);
    return paramString1;
  }
  
  public static WxaPkgWrappingInfo b(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
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
      paramString1 = com.tencent.mm.plugin.appbrand.dynamic.b.e.Hd(M(paramString2, paramInt1, paramInt2));
      if (paramString1 != null)
      {
        u.i("MicroMsg.DynamicPkgUpdater", "get wxaPkgInfo from cache", new Object[0]);
        AppMethodBeat.o(121471);
        return paramString1;
      }
    }
    paramString1 = (WxaPkgWrappingInfo)h.a("com.tencent.mm", localBundle, a.class);
    if (paramString1 != null) {
      com.tencent.mm.plugin.appbrand.dynamic.b.e.a(M(paramString2, paramInt1, paramInt2), paramString1);
    }
    AppMethodBeat.o(121471);
    return paramString1;
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.k<Bundle, WxaPkgWrappingInfo>
  {
    private static WxaPkgWrappingInfo A(Bundle paramBundle)
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
        localObject3 = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().a(str, j, new String[] { "downloadURL", "version" });
        if (localObject3 != null)
        {
          paramBundle = ((bb)localObject3).field_downloadURL;
          i = ((bb)localObject3).field_version;
        }
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.jnk, paramBundle).aVF();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          int k;
          ad.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
        }
      }
      paramBundle = "";
      try
      {
        bb localbb = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().a(str, j, new String[] { "downloadURL", "version" });
        if (localbb != null)
        {
          paramBundle = localbb.field_downloadURL;
          i = localbb.field_version;
        }
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.jnl, paramBundle, (String)localObject3).aVF();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        ad.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
      }
      do
      {
        AppMethodBeat.o(121463);
        return null;
      } while (new com.tencent.mm.plugin.appbrand.dynamic.launching.c(str, "", "", (byte)0).aVG() != com.tencent.mm.plugin.appbrand.dynamic.launching.c.a.jns.ordinal());
      paramBundle = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().a(str, j, new String[] { "downloadURL" });
      if (paramBundle == null)
      {
        ad.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[] { str, Integer.valueOf(j) });
        AppMethodBeat.o(121463);
        return null;
      }
      try
      {
        paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.jnk, paramBundle.field_downloadURL).aVF();
        AppMethodBeat.o(121463);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        ad.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[] { str, Integer.valueOf(j), paramBundle });
        AppMethodBeat.o(121463);
        return null;
      }
      paramBundle = (WxaPkgWrappingInfo)WxaPkgIntegrityChecker.C(str, j, i).second;
      AppMethodBeat.o(121463);
      return paramBundle;
      paramBundle = ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().a(str, j, new String[] { "downloadURL" });
      g.afz();
      k = com.tencent.mm.kernel.a.getUin();
      localObject1 = new b.a();
      localObject2 = new bdn();
      ((bdn)localObject2).dlB = str;
      ((bdn)localObject2).DAJ = k;
      localObject3 = new dtn();
      switch (j)
      {
      default: 
        ((dtn)localObject3).CLK = 0;
        ((dtn)localObject3).EIk = 0;
        if (paramBundle != null)
        {
          ((dtn)localObject3).md5 = paramBundle.field_versionMd5;
          label605:
          ((bdn)localObject2).DAK = new LinkedList();
          ((bdn)localObject2).DAK.add(localObject3);
          ((b.a)localObject1).gUU = ((com.tencent.mm.bx.a)localObject2);
          ((b.a)localObject1).gUV = new bdo();
          ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
          ((b.a)localObject1).funcId = 1186;
          paramBundle = y.e(((b.a)localObject1).atI());
          if ((paramBundle.errType != 0) || (paramBundle.errCode != 0)) {
            break label910;
          }
          paramBundle = (bdo)paramBundle.gUK;
          if ((paramBundle != null) && (paramBundle.DAK != null) && (paramBundle.DAK.size() > 0))
          {
            paramBundle = (dtn)paramBundle.DAK.getFirst();
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
        paramBundle = (WxaPkgWrappingInfo)WxaPkgIntegrityChecker.C(str, j, i).second;
        AppMethodBeat.o(121463);
        return paramBundle;
        ((dtn)localObject3).CLK = 1;
        ((dtn)localObject3).EIk = 1;
        break;
        ((dtn)localObject3).CLK = 2;
        ((dtn)localObject3).EIk = 1;
        break;
        ((dtn)localObject3).md5 = "";
        break label605;
        ((com.tencent.mm.plugin.appbrand.a.e)g.ab(com.tencent.mm.plugin.appbrand.a.e.class)).aOk().a(str, j, paramBundle.url, paramBundle.md5, 0L, 0L);
        continue;
        label910:
        ad.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
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
    private static Bundle B(Bundle paramBundle)
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
        localObject4 = new com.tencent.mm.plugin.appbrand.dynamic.launching.a((String)localObject1, i, j, k, m, (String)localObject2).aVE();
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
        ((WidgetRuntimeConfig)localObject2).jnh = m;
        localObject4 = ((com.tencent.mm.plugin.appbrand.widget.k)localObject4).field_widgetSetting;
        if (localObject4 != null)
        {
          ((WidgetRuntimeConfig)localObject2).jnz = ((dwu)localObject4).EKH;
          ((WidgetRuntimeConfig)localObject2).jnB = ((dwu)localObject4).EKJ;
          ((WidgetRuntimeConfig)localObject2).jnA = ((dwu)localObject4).EKI;
        }
        paramBundle.putParcelable("runtimeConfig", (Parcelable)localObject2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.w("MicroMsg.DynamicPkgUpdater", "check widget launch info error : %s", new Object[] { localException });
        }
        localObject3 = localException.aOG().NA((String)localObject1);
        localObject1 = com.tencent.mm.plugin.appbrand.dynamic.debugger.b.He((String)localObject1);
        localObject4 = new DebuggerInfo();
        if (localObject3 == null) {
          break label452;
        }
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.widget.a.a)com.tencent.mm.plugin.appbrand.dynamic.k.a.aw(com.tencent.mm.plugin.appbrand.widget.a.a.class);
      if (localObject2 == null)
      {
        AppMethodBeat.o(121466);
        return paramBundle;
      }
      Object localObject3;
      if (((n)localObject3).field_openDebug)
      {
        bool1 = true;
        ((DebuggerInfo)localObject4).jlG = bool1;
        if ((!j.a.nz(i)) && ((localObject1 == null) || (!((DebuggerInfo)localObject1).jlF))) {
          break label458;
        }
        bool1 = true;
        label354:
        ((DebuggerInfo)localObject4).jlF = bool1;
        if ((localObject1 == null) || (!((DebuggerInfo)localObject1).jlH)) {
          break label464;
        }
      }
      label452:
      label458:
      label464:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        ((DebuggerInfo)localObject4).jlH = bool1;
        paramBundle.putParcelable("debuggerInfo", (Parcelable)localObject4);
        localObject1 = AppBrandGlobalSystemConfig.aTv();
        localObject3 = new WidgetSysConfig();
        ((WidgetSysConfig)localObject3).jcx = ((AppBrandGlobalSystemConfig)localObject1).jcx;
        ((WidgetSysConfig)localObject3).jcy = ((AppBrandGlobalSystemConfig)localObject1).jcy;
        ((WidgetSysConfig)localObject3).jcz = ((AppBrandGlobalSystemConfig)localObject1).jcz;
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
    public abstract void ak(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a
 * JD-Core Version:    0.7.0.1
 */