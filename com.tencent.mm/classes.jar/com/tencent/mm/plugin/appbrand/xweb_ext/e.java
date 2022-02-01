package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.xweb.s.a;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL;", "Lcom/tencent/xweb/UpdateListener$IXWebUpdatListener;", "()V", "TAG", "", "onMainCfgUpdated", "", "onPluginCfgUpdated", "onUpdateFinished", "errorCode", "", "onUpdateProgressed", "percent", "onUpdateStart", "plugin-appbrand-integration_release"})
public final class e
  implements s.a
{
  public static final e nrn;
  
  static
  {
    AppMethodBeat.i(189750);
    nrn = new e();
    AppMethodBeat.o(189750);
  }
  
  public final void bGk() {}
  
  public final void bGl() {}
  
  public final void bGm() {}
  
  public final void xc(int paramInt)
  {
    AppMethodBeat.i(189749);
    if (paramInt == 0)
    {
      if ((com.tencent.mm.plugin.appbrand.a.aVz() == 0) && (i.isEmpty())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = aj.fkO();
        ad.i("MicroMsg.AppBrand.XWebUpdateBroadcastListener", "onUpdateFinished canReboot:" + bool1 + ", mmProcessAlive:" + bool2);
        ad.fkv();
        if (!bool1) {
          break label180;
        }
        if (!bool2) {
          break;
        }
        AppBrandProcessSuicideLogic.aYF();
        AppMethodBeat.o(189749);
        return;
      }
      Object localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
      localObject1 = (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
      AppMethodBeat.o(189749);
      throw ((Throwable)localObject1);
    }
    label180:
    AppMethodBeat.o(189749);
  }
  
  public final void xd(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.e
 * JD-Core Version:    0.7.0.1
 */