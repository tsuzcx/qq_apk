package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.x;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.am;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.dynamic.launching.b;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c.a;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.clj;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

class a$a
  implements i<Bundle, WxaPkgWrappingInfo>
{
  private static WxaPkgWrappingInfo n(Bundle paramBundle)
  {
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
      localObject3 = ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaG().a(str, j, new String[] { "downloadURL", "version" });
      if (localObject3 != null)
      {
        paramBundle = ((an)localObject3).field_downloadURL;
        i = ((an)localObject3).field_version;
      }
      paramBundle = new b((String)localObject1, str, (String)localObject2, j, i, b.fWB, paramBundle).aft();
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        int k;
        y.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
      }
    }
    paramBundle = "";
    try
    {
      an localan = ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaG().a(str, j, new String[] { "downloadURL", "version" });
      if (localan != null)
      {
        paramBundle = localan.field_downloadURL;
        i = localan.field_version;
      }
      paramBundle = new b((String)localObject1, str, (String)localObject2, j, i, b.fWC, paramBundle, (String)localObject3).aft();
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
    }
    do
    {
      return null;
    } while (new com.tencent.mm.plugin.appbrand.dynamic.launching.c(str, "", "", (byte)0).afv() != c.a.fWJ.ordinal());
    paramBundle = ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaG().a(str, j, new String[] { "downloadURL" });
    if (paramBundle == null)
    {
      y.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[] { str, Integer.valueOf(j) });
      return null;
    }
    try
    {
      paramBundle = new b((String)localObject1, str, (String)localObject2, j, i, b.fWB, paramBundle.field_downloadURL).aft();
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      y.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[] { str, Integer.valueOf(j), paramBundle });
      return null;
    }
    return (WxaPkgWrappingInfo)am.t(str, j, i).second;
    paramBundle = ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaG().a(str, j, new String[] { "downloadURL" });
    g.DN();
    k = com.tencent.mm.kernel.a.CK();
    localObject1 = new b.a();
    localObject2 = new anb();
    ((anb)localObject2).bOL = str;
    ((anb)localObject2).tiT = k;
    localObject3 = new clj();
    switch (j)
    {
    default: 
      ((clj)localObject3).sEr = 0;
      ((clj)localObject3).tYF = 0;
      if (paramBundle != null)
      {
        ((clj)localObject3).bIW = paramBundle.field_versionMd5;
        label565:
        ((anb)localObject2).tiU = new LinkedList();
        ((anb)localObject2).tiU.add(localObject3);
        ((b.a)localObject1).ecH = ((com.tencent.mm.bv.a)localObject2);
        ((b.a)localObject1).ecI = new anc();
        ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
        ((b.a)localObject1).ecG = 1186;
        paramBundle = x.c(((b.a)localObject1).Kt());
        if ((paramBundle.errType != 0) || (paramBundle.errCode != 0)) {
          break label863;
        }
        paramBundle = (anc)paramBundle.ecw;
        if ((paramBundle != null) && (paramBundle.tiU != null) && (paramBundle.tiU.size() > 0))
        {
          paramBundle = (clj)paramBundle.tiU.getFirst();
          u.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", new Object[] { Integer.valueOf(j), paramBundle.bIW, paramBundle.url });
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
      return (WxaPkgWrappingInfo)am.t(str, j, i).second;
      ((clj)localObject3).sEr = 1;
      ((clj)localObject3).tYF = 1;
      break;
      ((clj)localObject3).sEr = 2;
      ((clj)localObject3).tYF = 1;
      break;
      ((clj)localObject3).bIW = "";
      break label565;
      ((com.tencent.mm.plugin.appbrand.a.c)g.r(com.tencent.mm.plugin.appbrand.a.c.class)).aaG().a(str, j, paramBundle.url, paramBundle.bIW, 0L, 0L);
      continue;
      label863:
      y.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.aox, str, Integer.valueOf(j) });
      u.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.aox, str, Integer.valueOf(j) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a.a
 * JD-Core Version:    0.7.0.1
 */