package com.tencent.mm.plugin.appbrand.report;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"})
public final class h
{
  private static String iFV;
  public static final h iFW;
  
  static
  {
    AppMethodBeat.i(134940);
    iFW = new h();
    AppMethodBeat.o(134940);
  }
  
  public static final void EF(String paramString)
  {
    iFV = paramString;
  }
  
  public static final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(134938);
    if (paramLocalUsageInfo != null)
    {
      String str = paramLocalUsageInfo.appId;
      int i = paramLocalUsageInfo.bDc;
      int j = paramLocalUsageInfo.hcr + 1;
      if (str != null)
      {
        int k = e.ED(str);
        ab.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str + ", appVersion: " + i + ", appState: : " + j + ", eventId: " + paramInt1 + ',' + "scene: " + paramInt2 + ", sceneId: " + paramString + ", serviceType: " + k);
        com.tencent.mm.plugin.report.service.h.qsU.e(13801, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bo.aox()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(k) });
      }
    }
    AppMethodBeat.o(134938);
  }
  
  public static final String aKY()
  {
    AppMethodBeat.i(134939);
    Object localObject = new StringBuilder("SceneId@").append(iFW.hashCode()).append('#');
    j.p(g.RJ(), "MMKernel.account()");
    localObject = p.getString(a.getUin()) + '#' + bo.aoy();
    AppMethodBeat.o(134939);
    return localObject;
  }
  
  public static final String aKZ()
  {
    return iFV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.h
 * JD-Core Version:    0.7.0.1
 */