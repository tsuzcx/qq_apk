package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.compatible.util.q;
import com.tencent.mm.h.a.n;
import com.tencent.mm.h.a.n.a;
import com.tencent.mm.plugin.appbrand.appusage.s;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;

final class e$21
  extends com.tencent.mm.sdk.b.c<n>
{
  e$21(e parame)
  {
    this.udX = n.class.getName().hashCode();
  }
  
  private static boolean a(n paramn)
  {
    String str3 = paramn.bFt.bFn;
    String str4 = paramn.bFt.appId;
    int j = paramn.bFt.bFu;
    int k = paramn.bFt.scene;
    String str6 = paramn.bFt.bFv;
    String str2 = paramn.bFt.bFw;
    int m = paramn.bFt.action;
    String str5 = paramn.bFt.bFx;
    long l = paramn.bFt.bFy;
    int n = paramn.bFt.bFz;
    int i1 = paramn.bFt.bFA;
    i = 3;
    String str1;
    if (!bk.bl(str3))
    {
      str1 = "";
      paramn = str1;
      if (!bk.bl(str2))
      {
        paramn = str1;
        if (str2.contains(".html")) {
          paramn = str2.substring(0, str2.lastIndexOf(".html") + 5);
        }
      }
      str1 = "";
    }
    try
    {
      str2 = q.encode(bk.pm(paramn), "UTF-8");
      str1 = str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        int i2;
        boolean bool;
        y.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
        y.printErrStackTrace("MicroMsg.AppBrandReporterManager", localUnsupportedEncodingException, "", new Object[0]);
        continue;
        if (bool) {
          i = 2;
        } else {
          i = 3;
        }
      }
    }
    str2 = bk.pm(str6);
    str5 = bk.pm(str5);
    str6 = bk.pm(str4);
    i2 = com.tencent.mm.plugin.appbrand.report.c.vY(str4);
    if (j > 0)
    {
      i = j - 1;
      bool = e.aaZ().aw(str3, i);
      if (e.aba().at(str3, i)) {
        i = 1;
      }
    }
    else
    {
      y.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d", new Object[] { Integer.valueOf(13540), Integer.valueOf(k), str2, str6, Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i), paramn, Integer.valueOf(m), str5, Long.valueOf(l), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2) });
      h.nFQ.f(13540, new Object[] { Integer.valueOf(k), str2, str6, Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(i), str1, Integer.valueOf(m), str5, Long.valueOf(l), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2) });
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.e.21
 * JD-Core Version:    0.7.0.1
 */