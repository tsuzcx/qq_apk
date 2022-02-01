package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.s.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL;", "Lcom/tencent/xweb/UpdateListener$IXWebUpdatListener;", "()V", "TAG", "", "onMainCfgUpdated", "", "onPluginCfgUpdated", "onUpdateFinished", "errorCode", "", "onUpdateProgressed", "percent", "onUpdateStart", "plugin-appbrand-integration_release"})
public final class e
  implements s.a
{
  public static final e oGK;
  
  static
  {
    AppMethodBeat.i(229708);
    oGK = new e();
    AppMethodBeat.o(229708);
  }
  
  public final void AN(int paramInt)
  {
    AppMethodBeat.i(229707);
    if (paramInt == 0)
    {
      if ((com.tencent.mm.plugin.appbrand.a.bqV() == 0) && (k.isEmpty())) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        boolean bool2 = MMApplicationContext.isMMProcessExist();
        Log.i("MicroMsg.AppBrand.XWebUpdateBroadcastListener", "onUpdateFinished canReboot:" + bool1 + ", mmProcessAlive:" + bool2);
        Log.appenderFlushSync();
        if (!bool1) {
          break label180;
        }
        if (!bool2) {
          break;
        }
        AppBrandProcessSuicideLogic.buq();
        AppMethodBeat.o(229707);
        return;
      }
      Object localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject2, "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
      localObject1 = (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
      AppMethodBeat.o(229707);
      throw ((Throwable)localObject1);
    }
    label180:
    AppMethodBeat.o(229707);
  }
  
  public final void AO(int paramInt) {}
  
  public final void cdG() {}
  
  public final void cdH() {}
  
  public final void cdI() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.e
 * JD-Core Version:    0.7.0.1
 */