package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"})
public final class k
{
  private static String lpJ;
  public static final k lpK;
  
  static
  {
    AppMethodBeat.i(51012);
    lpK = new k();
    AppMethodBeat.o(51012);
  }
  
  public static final void Mv(String paramString)
  {
    lpJ = paramString;
  }
  
  public static final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(51010);
    if (paramLocalUsageInfo != null)
    {
      String str = paramLocalUsageInfo.appId;
      int i = paramLocalUsageInfo.aAS;
      int j = paramLocalUsageInfo.gXn + 1;
      if (str != null)
      {
        int k = h.Mt(str);
        ad.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str + ", appVersion: " + i + ", appState: : " + j + ", eventId: " + paramInt1 + ',' + "scene: " + paramInt2 + ", sceneId: " + paramString + ", serviceType: " + k);
        com.tencent.mm.plugin.report.service.h.vKh.f(13801, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bt.aGK()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(k) });
      }
    }
    AppMethodBeat.o(51010);
  }
  
  public static final String bmk()
  {
    AppMethodBeat.i(51011);
    Object localObject = new StringBuilder("SceneId@").append(lpK.hashCode()).append('#');
    d.g.b.k.g(g.afz(), "MMKernel.account()");
    localObject = p.getString(a.getUin()) + '#' + bt.eGO();
    AppMethodBeat.o(51011);
    return localObject;
  }
  
  public static final String bml()
  {
    return lpJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.k
 * JD-Core Version:    0.7.0.1
 */