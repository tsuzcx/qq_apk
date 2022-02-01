package com.tencent.mm.plugin.appbrand.ui.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/splash/screenshot/SplashScreenshotInfoStorage$Companion;", "", "()V", "KEYS", "", "", "[Ljava/lang/String;", "SCREENSHOT_ROOT", "()Ljava/lang/String;", "SWITCH_ON", "", "()Z", "TABLE_CREATE", "kotlin.jvm.PlatformType", "TAG", "uin", "getUin", "generateDir", "appId", "generateFilePath", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  public static String agr(String paramString)
  {
    AppMethodBeat.i(322589);
    paramString = cNi() + '/' + paramString;
    AppMethodBeat.o(322589);
    return paramString;
  }
  
  public static boolean cNh()
  {
    AppMethodBeat.i(322606);
    c localc = (c)com.tencent.mm.kernel.h.ax(c.class);
    c.a locala = c.a.yPn;
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {}
    for (boolean bool = true;; bool = false)
    {
      bool = localc.a(locala, bool);
      AppMethodBeat.o(322606);
      return bool;
    }
  }
  
  private static String cNi()
  {
    AppMethodBeat.i(322596);
    String str = com.tencent.mm.loader.i.b.bmr() + "appbrand/runtime_snapshots/" + getUin();
    y.bDX(str);
    AppMethodBeat.o(322596);
    return str;
  }
  
  private static String getUin()
  {
    AppMethodBeat.i(322600);
    if (((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bbA()) {
      com.tencent.mm.kernel.h.baC();
    }
    for (int i = com.tencent.mm.kernel.b.getUin();; i = com.tencent.mm.kernel.b.aZt())
    {
      String str = new p(i).toString();
      s.s(str, "if (MMKernel.process().c…(it).toString()\n        }");
      AppMethodBeat.o(322600);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */