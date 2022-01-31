package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  private static String gXE;
  public static final e gXF = new e();
  
  public static final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2, String paramString)
  {
    if (paramLocalUsageInfo != null)
    {
      String str = paramLocalUsageInfo.appId;
      int i = paramLocalUsageInfo.cau;
      int j = paramLocalUsageInfo.fJy + 1;
      if (str != null)
      {
        int k = c.vY(str);
        y.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str + ", appVersion: " + i + ", appState: : " + j + ", eventId: " + paramInt1 + ',' + "scene: " + paramInt2 + ", sceneId: " + paramString + ", serviceType: " + k);
        h.nFQ.f(13801, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bk.UX()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(k) });
      }
    }
  }
  
  public static final String aoa()
  {
    StringBuilder localStringBuilder = new StringBuilder("SceneId@").append(gXF.hashCode()).append('#');
    a.d.b.g.j(com.tencent.mm.kernel.g.DN(), "MMKernel.account()");
    return o.getString(a.CK()) + '#' + bk.UY();
  }
  
  public static final String aob()
  {
    return gXE;
  }
  
  public static final void wa(String paramString)
  {
    gXE = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.e
 * JD-Core Version:    0.7.0.1
 */