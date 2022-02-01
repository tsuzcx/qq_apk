package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"})
public final class j
{
  private static String lRF;
  public static final j lRG;
  
  static
  {
    AppMethodBeat.i(51012);
    lRG = new j();
    AppMethodBeat.o(51012);
  }
  
  public static final void QE(String paramString)
  {
    lRF = paramString;
  }
  
  public static final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(51010);
    if (paramLocalUsageInfo != null)
    {
      String str = paramLocalUsageInfo.appId;
      int i = paramLocalUsageInfo.aBM;
      int j = paramLocalUsageInfo.hxM + 1;
      if (str != null)
      {
        int k = g.QC(str);
        ac.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str + ", appVersion: " + i + ", appState: : " + j + ", eventId: " + paramInt1 + ',' + "scene: " + paramInt2 + ", sceneId: " + paramString + ", serviceType: " + k);
        h.wUl.f(13801, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(bs.aNx()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(k) });
      }
    }
    AppMethodBeat.o(51010);
  }
  
  public static final String btg()
  {
    AppMethodBeat.i(51011);
    Object localObject = new StringBuilder("SceneId@").append(lRG.hashCode()).append('#');
    k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
    localObject = p.getString(a.getUin()) + '#' + bs.eWj();
    AppMethodBeat.o(51011);
    return localObject;
  }
  
  public static final String bth()
  {
    return lRF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.j
 * JD-Core Version:    0.7.0.1
 */