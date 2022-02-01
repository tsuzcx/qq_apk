package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"})
public final class l
{
  private static String nHr;
  public static final l nHs;
  
  static
  {
    AppMethodBeat.i(51012);
    nHs = new l();
    AppMethodBeat.o(51012);
  }
  
  public static final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(51010);
    if (paramLocalUsageInfo != null)
    {
      String str = paramLocalUsageInfo.appId;
      int i = paramLocalUsageInfo.appVersion;
      int j = paramLocalUsageInfo.iOo + 1;
      if (str != null)
      {
        int k = i.aeH(str);
        Log.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str + ", appVersion: " + i + ", appState: : " + j + ", eventId: " + paramInt1 + ',' + "scene: " + paramInt2 + ", sceneId: " + paramString + ", serviceType: " + k);
        h.CyF.a(13801, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Util.nowSecond()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(k) });
      }
    }
    AppMethodBeat.o(51010);
  }
  
  public static final void aeK(String paramString)
  {
    nHr = paramString;
  }
  
  public static final String bUv()
  {
    AppMethodBeat.i(51011);
    Object localObject = new StringBuilder("SceneId@").append(nHs.hashCode()).append('#');
    kotlin.g.b.p.g(g.aAf(), "MMKernel.account()");
    localObject = com.tencent.mm.b.p.getString(a.getUin()) + '#' + Util.nowMilliSecond();
    AppMethodBeat.o(51011);
    return localObject;
  }
  
  public static final String bUw()
  {
    return nHr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.l
 * JD-Core Version:    0.7.0.1
 */