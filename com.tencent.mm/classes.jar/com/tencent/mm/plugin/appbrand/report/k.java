package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"})
public final class k
{
  private static String mwt;
  public static final k mwu;
  
  static
  {
    AppMethodBeat.i(51012);
    mwu = new k();
    AppMethodBeat.o(51012);
  }
  
  public static final void UV(String paramString)
  {
    mwt = paramString;
  }
  
  public static final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(51010);
    if (paramLocalUsageInfo != null)
    {
      String str = paramLocalUsageInfo.appId;
      int i = paramLocalUsageInfo.aDD;
      int j = paramLocalUsageInfo.hSZ + 1;
      if (str != null)
      {
        int k = h.US(str);
        ae.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str + ", appVersion: " + i + ", appState: : " + j + ", eventId: " + paramInt1 + ',' + "scene: " + paramInt2 + ", sceneId: " + paramString + ", serviceType: " + k);
        com.tencent.mm.plugin.report.service.g.yxI.f(13801, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bu.aRi()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(k) });
      }
    }
    AppMethodBeat.o(51010);
  }
  
  public static final String bye()
  {
    AppMethodBeat.i(51011);
    Object localObject = new StringBuilder("SceneId@").append(mwu.hashCode()).append('#');
    d.g.b.p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
    localObject = com.tencent.mm.b.p.getString(a.getUin()) + '#' + bu.fpO();
    AppMethodBeat.o(51011);
    return localObject;
  }
  
  public static final String byf()
  {
    return mwt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.k
 * JD-Core Version:    0.7.0.1
 */