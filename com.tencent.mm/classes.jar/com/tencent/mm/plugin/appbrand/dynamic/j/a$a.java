package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.x;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.dynamic.launching.b;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c.a;
import com.tencent.mm.protocal.protobuf.asq;
import com.tencent.mm.protocal.protobuf.asr;
import com.tencent.mm.protocal.protobuf.cyz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

class a$a
  implements i<Bundle, WxaPkgWrappingInfo>
{
  private static WxaPkgWrappingInfo w(Bundle paramBundle)
  {
    AppMethodBeat.i(10982);
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
      localObject3 = ((d)g.E(d.class)).we().a(str, j, new String[] { "downloadURL", "version" });
      if (localObject3 != null)
      {
        paramBundle = ((at)localObject3).field_downloadURL;
        i = ((at)localObject3).field_version;
      }
      paramBundle = new b((String)localObject1, str, (String)localObject2, j, i, b.hqb, paramBundle).azY();
      AppMethodBeat.o(10982);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        int k;
        ab.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
      }
    }
    paramBundle = "";
    try
    {
      at localat = ((d)g.E(d.class)).we().a(str, j, new String[] { "downloadURL", "version" });
      if (localat != null)
      {
        paramBundle = localat.field_downloadURL;
        i = localat.field_version;
      }
      paramBundle = new b((String)localObject1, str, (String)localObject2, j, i, b.hqc, paramBundle, (String)localObject3).azY();
      AppMethodBeat.o(10982);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      ab.e("MicroMsg.DynamicPkgUpdater", "CheckWidgetPkg error : %s", new Object[] { paramBundle });
    }
    do
    {
      AppMethodBeat.o(10982);
      return null;
    } while (new c(str, "", "", (byte)0).azZ() != c.a.hqj.ordinal());
    paramBundle = ((d)g.E(d.class)).we().a(str, j, new String[] { "downloadURL" });
    if (paramBundle == null)
    {
      ab.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[] { str, Integer.valueOf(j) });
      AppMethodBeat.o(10982);
      return null;
    }
    try
    {
      paramBundle = new b((String)localObject1, str, (String)localObject2, j, i, b.hqb, paramBundle.field_downloadURL).azY();
      AppMethodBeat.o(10982);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      ab.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[] { str, Integer.valueOf(j), paramBundle });
      AppMethodBeat.o(10982);
      return null;
    }
    paramBundle = (WxaPkgWrappingInfo)as.F(str, j, i).second;
    AppMethodBeat.o(10982);
    return paramBundle;
    paramBundle = ((d)g.E(d.class)).we().a(str, j, new String[] { "downloadURL" });
    g.RJ();
    k = com.tencent.mm.kernel.a.getUin();
    localObject1 = new b.a();
    localObject2 = new asq();
    ((asq)localObject2).cwc = str;
    ((asq)localObject2).xhF = k;
    localObject3 = new cyz();
    switch (j)
    {
    default: 
      ((cyz)localObject3).wAx = 0;
      ((cyz)localObject3).yfY = 0;
      if (paramBundle != null)
      {
        ((cyz)localObject3).cqq = paramBundle.field_versionMd5;
        label617:
        ((asq)localObject2).xhG = new LinkedList();
        ((asq)localObject2).xhG.add(localObject3);
        ((b.a)localObject1).fsX = ((com.tencent.mm.bv.a)localObject2);
        ((b.a)localObject1).fsY = new asr();
        ((b.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
        ((b.a)localObject1).funcId = 1186;
        paramBundle = x.c(((b.a)localObject1).ado());
        if ((paramBundle.errType != 0) || (paramBundle.errCode != 0)) {
          break label923;
        }
        paramBundle = (asr)paramBundle.fsN;
        if ((paramBundle != null) && (paramBundle.xhG != null) && (paramBundle.xhG.size() > 0))
        {
          paramBundle = (cyz)paramBundle.xhG.getFirst();
          u.i("MicroMsg.DynamicPkgUpdater", "getWidgetInfo debugType %d, md5 %s, url %s", new Object[] { Integer.valueOf(j), paramBundle.cqq, paramBundle.url });
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
      paramBundle = (WxaPkgWrappingInfo)as.F(str, j, i).second;
      AppMethodBeat.o(10982);
      return paramBundle;
      ((cyz)localObject3).wAx = 1;
      ((cyz)localObject3).yfY = 1;
      break;
      ((cyz)localObject3).wAx = 2;
      ((cyz)localObject3).yfY = 1;
      break;
      ((cyz)localObject3).cqq = "";
      break label617;
      ((d)g.E(d.class)).we().a(str, j, paramBundle.url, paramBundle.cqq, 0L, 0L);
      continue;
      label923:
      ab.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
      u.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a.a
 * JD-Core Version:    0.7.0.1
 */