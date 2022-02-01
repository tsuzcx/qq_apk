package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandStarOperationReporter;", "", "()V", "TAG", "", "value", "pullDownOpenSceneId", "getPullDownOpenSceneId", "()Ljava/lang/String;", "setPullDownOpenSceneId", "(Ljava/lang/String;)V", "generateSceneId", "report", "", "info", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "eventId", "", "scene", "sceneId", "appId", "appVersion", "appState", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public static final m tOh;
  private static String tOi;
  
  static
  {
    AppMethodBeat.i(51012);
    tOh = new m();
    AppMethodBeat.o(51012);
  }
  
  public static final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(51010);
    if (paramLocalUsageInfo != null)
    {
      String str = paramLocalUsageInfo.appId;
      int i = paramLocalUsageInfo.appVersion;
      int j = paramLocalUsageInfo.euz + 1;
      if (str != null)
      {
        int k = j.afN(str);
        Log.d("MicroMsg.AppBrandStarOperationReporter", "report, appId: " + str + ", appVersion: " + i + ", appState: : " + j + ", eventId: " + paramInt1 + ",scene: " + paramInt2 + ", sceneId: " + paramString + ", serviceType: " + k);
        com.tencent.mm.plugin.report.service.h.OAn.b(13801, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(Util.nowSecond()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(k) });
      }
    }
    AppMethodBeat.o(51010);
  }
  
  public static final void afQ(String paramString)
  {
    tOi = paramString;
  }
  
  public static final String cIA()
  {
    return tOi;
  }
  
  public static final String cIz()
  {
    AppMethodBeat.i(51011);
    Object localObject = new StringBuilder("SceneId@").append(tOh.hashCode()).append('#');
    com.tencent.mm.kernel.h.baC();
    localObject = p.getString(b.getUin()) + '#' + Util.nowMilliSecond();
    AppMethodBeat.o(51011);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.m
 * JD-Core Version:    0.7.0.1
 */