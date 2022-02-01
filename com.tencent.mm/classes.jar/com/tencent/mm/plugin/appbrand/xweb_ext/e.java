package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.xweb.r.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL;", "Lcom/tencent/xweb/UpdateListener$IXWebUpdatListener;", "()V", "TAG", "", "onMainCfgUpdated", "", "onPluginCfgUpdated", "onUpdateFinished", "errorCode", "", "onUpdateProgressed", "percent", "onUpdateStart", "plugin-appbrand-integration_release"})
public final class e
  implements r.a
{
  public static final e moM;
  
  static
  {
    AppMethodBeat.i(196557);
    moM = new e();
    AppMethodBeat.o(196557);
  }
  
  public final void bvj() {}
  
  public final void bvk() {}
  
  public final void vG(int paramInt)
  {
    AppMethodBeat.i(196556);
    if (paramInt == 0)
    {
      if ((a.aLw() == 0) && (i.isEmpty())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = aj.eFN();
        ad.i("MicroMsg.AppBrand.XWebUpdateBroadcastListener", "onUpdateFinished canReboot:" + bool1 + ", mmProcessAlive:" + bool2);
        ad.eFx();
        if (!bool1) {
          break label108;
        }
        if (!bool2) {
          break;
        }
        AppBrandProcessSuicideLogic.aOs();
        AppMethodBeat.o(196556);
        return;
      }
      System.exit(0);
      Throwable localThrowable = (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
      AppMethodBeat.o(196556);
      throw localThrowable;
    }
    label108:
    AppMethodBeat.o(196556);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.e
 * JD-Core Version:    0.7.0.1
 */