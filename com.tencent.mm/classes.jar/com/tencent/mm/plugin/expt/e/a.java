package com.tencent.mm.plugin.expt.e;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.ui.KvInfoUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import java.util.HashMap;
import java.util.List;

public final class a
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.a
{
  private static a rij;
  private com.tencent.mm.sdk.b.c nKp;
  public String rik;
  private com.tencent.mm.sdk.b.c<kx> ril;
  public boolean rim;
  public HashMap<String, List<b>> rin;
  
  public a()
  {
    AppMethodBeat.i(196172);
    this.nKp = new com.tencent.mm.sdk.b.c() {};
    this.ril = new a.2(this);
    this.rim = false;
    this.rin = new HashMap();
    AppMethodBeat.o(196172);
  }
  
  public static a csw()
  {
    AppMethodBeat.i(196173);
    if (rij == null) {
      rij = new a();
    }
    a locala = rij;
    AppMethodBeat.o(196173);
    return locala;
  }
  
  private void csy()
  {
    AppMethodBeat.i(196179);
    ae.i("MicroMsg.ExptReportService", "%d sendStopMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), this.rik });
    if ((ak.cpe()) && (!bu.isNullOrNil(this.rik)))
    {
      c localc = new c();
      localc.content = this.rik;
      localc.type = 10000;
      localc.key = 2;
      g.ajj().a(localc, 0);
    }
    this.rik = null;
    AppMethodBeat.o(196179);
  }
  
  public final void adU(String paramString)
  {
    AppMethodBeat.i(196180);
    long l = bu.HQ();
    if (((j.DEBUG) || (j.IS_FLAVOR_RED) || (j.IS_FLAVOR_PURPLE) || (bv.fpT())) && (!bu.isNullOrNil(paramString)) && (paramString.startsWith(":exptdebug/")))
    {
      paramString = paramString.substring(11);
      ae.i("MicroMsg.ExptReportService", "%d sendStartMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
      this.rik = paramString;
      if (ak.cpe())
      {
        localObject = new c();
        ((c)localObject).content = paramString;
        ((c)localObject).type = 10000;
        ((c)localObject).key = 1;
        g.ajj().a((n)localObject, 0);
      }
      Object localObject = new vt();
      ((vt)localObject).dLs.dLt = paramString;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      this.rim = true;
    }
    ae.i("MicroMsg.ExptReportService", "start expt Debug tools cost time [%d]", new Object[] { Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(196180);
  }
  
  public final void cor()
  {
    AppMethodBeat.i(196181);
    csy();
    vt localvt = new vt();
    localvt.dLs.dLt = "";
    com.tencent.mm.sdk.b.a.IvT.l(localvt);
    AppMethodBeat.o(196181);
  }
  
  public final boolean csx()
  {
    AppMethodBeat.i(196174);
    if (!bu.isNullOrNil(this.rik))
    {
      AppMethodBeat.o(196174);
      return true;
    }
    AppMethodBeat.o(196174);
    return false;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(196175);
    if (ak.coh())
    {
      com.tencent.mm.sdk.b.a.IvT.b(this.ril);
      com.tencent.mm.sdk.b.a.IvT.b(this.nKp);
    }
    AppMethodBeat.o(196175);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(196176);
    cor();
    com.tencent.mm.sdk.b.a.IvT.d(this.ril);
    com.tencent.mm.sdk.b.a.IvT.d(this.nKp);
    if (this.rin != null) {
      this.rin.clear();
    }
    this.rim = false;
    AppMethodBeat.o(196176);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(196178);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((ak.cpe()) && (csx()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 2;
      g.ajj().a(localc, 0);
    }
    AppMethodBeat.o(196178);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(196177);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((ak.cpe()) && (csx()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 1;
      g.ajj().a(localc, 0);
    }
    AppMethodBeat.o(196177);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void r(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(196182);
    paramIntent.setClass(paramContext, KvInfoUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahE(), "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(196182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.a
 * JD-Core Version:    0.7.0.1
 */