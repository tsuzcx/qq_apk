package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ab;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.api.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgIntegrityChecker;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.dynamic.launching.c;
import com.tencent.mm.protocal.protobuf.cgq;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.fmg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

class a$a
  implements m<Bundle, WxaPkgWrappingInfo>
{
  private static WxaPkgWrappingInfo O(Bundle paramBundle)
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
      localObject3 = ((e)h.ae(e.class)).bFb().c(str, j, new String[] { "downloadURL", "version" });
      if (localObject3 != null)
      {
        paramBundle = ((bh)localObject3).field_downloadURL;
        i = ((bh)localObject3).field_version;
      }
      paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.ojs, paramBundle).bNE();
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
      bh localbh = ((e)h.ae(e.class)).bFb().c(str, j, new String[] { "downloadURL", "version" });
      if (localbh != null)
      {
        paramBundle = localbh.field_downloadURL;
        i = localbh.field_version;
      }
      paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.ojt, paramBundle, (String)localObject3).bNE();
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
    } while (new c(str, "", "", (byte)0).bNF() != com.tencent.mm.plugin.appbrand.dynamic.launching.c.a.ojA.ordinal());
    paramBundle = ((e)h.ae(e.class)).bFb().c(str, j, new String[] { "downloadURL" });
    if (paramBundle == null)
    {
      Log.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[] { str, Integer.valueOf(j) });
      AppMethodBeat.o(121463);
      return null;
    }
    try
    {
      paramBundle = new com.tencent.mm.plugin.appbrand.dynamic.launching.b((String)localObject1, str, (String)localObject2, j, i, com.tencent.mm.plugin.appbrand.dynamic.launching.b.ojs, paramBundle.field_downloadURL).bNE();
      AppMethodBeat.o(121463);
      return paramBundle;
    }
    catch (Exception paramBundle)
    {
      Log.e("MicroMsg.DynamicPkgUpdater", "getWxaPkgInfo(%s, %d) error : %s", new Object[] { str, Integer.valueOf(j), paramBundle });
      AppMethodBeat.o(121463);
      return null;
    }
    paramBundle = (WxaPkgWrappingInfo)WxaPkgIntegrityChecker.D(str, j, i).second;
    AppMethodBeat.o(121463);
    return paramBundle;
    paramBundle = ((e)h.ae(e.class)).bFb().c(str, j, new String[] { "downloadURL" });
    h.aHE();
    k = com.tencent.mm.kernel.b.getUin();
    localObject1 = new d.a();
    localObject2 = new cgq();
    ((cgq)localObject2).appid = str;
    ((cgq)localObject2).TnD = k;
    localObject3 = new fmg();
    switch (j)
    {
    default: 
      ((fmg)localObject3).RYL = 0;
      ((fmg)localObject3).ULb = 0;
      if (paramBundle != null)
      {
        ((fmg)localObject3).md5 = paramBundle.field_versionMd5;
        label605:
        ((cgq)localObject2).TnE = new LinkedList();
        ((cgq)localObject2).TnE.add(localObject3);
        ((d.a)localObject1).lBU = ((a)localObject2);
        ((d.a)localObject1).lBV = new cgr();
        ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/wxaapp/getwidgetinfo";
        ((d.a)localObject1).funcId = 1186;
        paramBundle = ab.e(((d.a)localObject1).bgN());
        if ((paramBundle.errType != 0) || (paramBundle.errCode != 0)) {
          break label910;
        }
        paramBundle = (cgr)paramBundle.lBJ;
        if ((paramBundle != null) && (paramBundle.TnE != null) && (paramBundle.TnE.size() > 0))
        {
          paramBundle = (fmg)paramBundle.TnE.getFirst();
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
      ((fmg)localObject3).RYL = 1;
      ((fmg)localObject3).ULb = 1;
      break;
      ((fmg)localObject3).RYL = 2;
      ((fmg)localObject3).ULb = 1;
      break;
      ((fmg)localObject3).md5 = "";
      break label605;
      ((e)h.ae(e.class)).bFb().a(str, j, paramBundle.url, paramBundle.md5, 0L, 0L);
      continue;
      label910:
      Log.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
      u.i("MicroMsg.DynamicPkgUpdater", "cgi fail errType %d, errCode %d,errMsg %s, appid %s , pkgType %d", new Object[] { Integer.valueOf(paramBundle.errType), Integer.valueOf(paramBundle.errCode), paramBundle.errMsg, str, Integer.valueOf(j) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.a.a
 * JD-Core Version:    0.7.0.1
 */