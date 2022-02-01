package com.tencent.mm.plugin.appbrand.xweb_ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.appbrand.app.AppBrandProcessSuicideLogic;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.u.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL;", "Lcom/tencent/xweb/UpdateListener$IXWebFullUpdateListener;", "()V", "TAG", "", "onMainCfgUpdated", "", "onPluginCfgUpdated", "onUpdateFinished", "errorCode", "", "onUpdateProgressed", "percent", "onUpdateStart", "schedulerType", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements u.a
{
  public static final g uTP;
  
  static
  {
    AppMethodBeat.i(317040);
    uTP = new g();
    AppMethodBeat.o(317040);
  }
  
  public final void ET(int paramInt) {}
  
  public final void EU(int paramInt)
  {
    AppMethodBeat.i(317049);
    if (paramInt == 0)
    {
      if ((d.cbh() == 0) && (n.isEmpty())) {}
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
        AppBrandProcessSuicideLogic.ceF();
        AppMethodBeat.o(317049);
        return;
      }
      Object localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      Object localObject2 = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
      System.exit(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/appbrand/xweb_ext/XWebUpdateListenerIMPL", "onUpdateFinished", "(I)V", "java/lang/System_EXEC_", "exit", "(I)V");
      localObject1 = (Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
      AppMethodBeat.o(317049);
      throw ((Throwable)localObject1);
    }
    label180:
    AppMethodBeat.o(317049);
  }
  
  public final void EV(int paramInt) {}
  
  public final void cTB() {}
  
  public final void cTC() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.xweb_ext.g
 * JD-Core Version:    0.7.0.1
 */