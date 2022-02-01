package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.xweb.s.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL;", "Lcom/tencent/xweb/UpdateListener$IXWebUpdatListener;", "()V", "TAG", "", "onMainCfgUpdated", "", "onPluginCfgUpdated", "onUpdateFinished", "errorCode", "", "onUpdateProgressed", "percent", "onUpdateStart", "plugin-appbrand-integration_release"})
public final class e
  implements s.a
{
  public static final e nwG;
  
  static
  {
    AppMethodBeat.i(224039);
    nwG = new e();
    AppMethodBeat.o(224039);
  }
  
  public final void bHg() {}
  
  public final void bHh() {}
  
  public final void bHi() {}
  
  public final void xh(int paramInt)
  {
    AppMethodBeat.i(224038);
    if (paramInt == 0)
    {
      if ((com.tencent.mm.plugin.appbrand.a.aVY() == 0) && (j.isEmpty())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = ak.foJ();
        ae.i("MicroMsg.AppBrand.XWebUpdateBroadcastListener", "onUpdateFinished canReboot:" + bool1 + ", mmProcessAlive:" + bool2);
        ae.fop();
        if (!bool1) {
          break label180;
        }
        if (!bool2) {
          break;
        }
        AppBrandProcessSuicideLogic.aZb();
        AppMethodBeat.o(224038);
        return;
      }
      Object localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
      localObject1 = (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
      AppMethodBeat.o(224038);
      throw ((Throwable)localObject1);
    }
    label180:
    AppMethodBeat.o(224038);
  }
  
  public final void xi(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.e
 * JD-Core Version:    0.7.0.1
 */