package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.xweb.s.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL;", "Lcom/tencent/xweb/UpdateListener$IXWebUpdatListener;", "()V", "TAG", "", "onMainCfgUpdated", "", "onPluginCfgUpdated", "onUpdateFinished", "errorCode", "", "onUpdateProgressed", "percent", "onUpdateStart", "plugin-appbrand-integration_release"})
public final class e
  implements s.a
{
  public static final e mQN;
  
  static
  {
    AppMethodBeat.i(187518);
    mQN = new e();
    AppMethodBeat.o(187518);
  }
  
  public final void bCg() {}
  
  public final void bCh() {}
  
  public final void wx(int paramInt)
  {
    AppMethodBeat.i(187517);
    if (paramInt == 0)
    {
      if ((a.aSn() == 0) && (i.isEmpty())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = ai.eVi();
        ac.i("MicroMsg.AppBrand.XWebUpdateBroadcastListener", "onUpdateFinished canReboot:" + bool1 + ", mmProcessAlive:" + bool2);
        ac.eUR();
        if (!bool1) {
          break label108;
        }
        if (!bool2) {
          break;
        }
        AppBrandProcessSuicideLogic.aVk();
        AppMethodBeat.o(187517);
        return;
      }
      System.exit(0);
      Throwable localThrowable = (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
      AppMethodBeat.o(187517);
      throw localThrowable;
    }
    label108:
    AppMethodBeat.o(187517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.e
 * JD-Core Version:    0.7.0.1
 */