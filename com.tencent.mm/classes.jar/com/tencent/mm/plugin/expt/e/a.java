package com.tencent.mm.plugin.expt.e;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.vp;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.ui.KvInfoUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import java.util.HashMap;
import java.util.List;

public final class a
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.a
{
  private static a rad;
  private com.tencent.mm.sdk.b.c nEU;
  public String rae;
  private com.tencent.mm.sdk.b.c<kw> raf;
  public boolean rag;
  public HashMap<String, List<b>> rah;
  
  public a()
  {
    AppMethodBeat.i(210505);
    this.nEU = new com.tencent.mm.sdk.b.c() {};
    this.raf = new a.2(this);
    this.rag = false;
    this.rah = new HashMap();
    AppMethodBeat.o(210505);
  }
  
  public static a cqU()
  {
    AppMethodBeat.i(210506);
    if (rad == null) {
      rad = new a();
    }
    a locala = rad;
    AppMethodBeat.o(210506);
    return locala;
  }
  
  private void cqW()
  {
    AppMethodBeat.i(210512);
    ad.i("MicroMsg.ExptReportService", "%d sendStopMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), this.rae });
    if ((aj.cnC()) && (!bt.isNullOrNil(this.rae)))
    {
      c localc = new c();
      localc.content = this.rae;
      localc.type = 10000;
      localc.key = 2;
      g.aiU().a(localc, 0);
    }
    this.rae = null;
    AppMethodBeat.o(210512);
  }
  
  public final void add(String paramString)
  {
    AppMethodBeat.i(210513);
    long l = bt.HI();
    if (((i.DEBUG) || (i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE) || (bu.flY())) && (!bt.isNullOrNil(paramString)) && (paramString.startsWith(":exptdebug/")))
    {
      paramString = paramString.substring(11);
      ad.i("MicroMsg.ExptReportService", "%d sendStartMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
      this.rae = paramString;
      if (aj.cnC())
      {
        localObject = new c();
        ((c)localObject).content = paramString;
        ((c)localObject).type = 10000;
        ((c)localObject).key = 1;
        g.aiU().a((n)localObject, 0);
      }
      Object localObject = new vp();
      ((vp)localObject).dKd.dKe = paramString;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
      this.rag = true;
    }
    ad.i("MicroMsg.ExptReportService", "start expt Debug tools cost time [%d]", new Object[] { Long.valueOf(bt.aO(l)) });
    AppMethodBeat.o(210513);
  }
  
  public final void cnb()
  {
    AppMethodBeat.i(210514);
    cqW();
    vp localvp = new vp();
    localvp.dKd.dKe = "";
    com.tencent.mm.sdk.b.a.IbL.l(localvp);
    AppMethodBeat.o(210514);
  }
  
  public final boolean cqV()
  {
    AppMethodBeat.i(210507);
    if (!bt.isNullOrNil(this.rae))
    {
      AppMethodBeat.o(210507);
      return true;
    }
    AppMethodBeat.o(210507);
    return false;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(210508);
    if (aj.cmR())
    {
      com.tencent.mm.sdk.b.a.IbL.b(this.raf);
      com.tencent.mm.sdk.b.a.IbL.b(this.nEU);
    }
    AppMethodBeat.o(210508);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(210509);
    cnb();
    com.tencent.mm.sdk.b.a.IbL.d(this.raf);
    com.tencent.mm.sdk.b.a.IbL.d(this.nEU);
    if (this.rah != null) {
      this.rah.clear();
    }
    this.rag = false;
    AppMethodBeat.o(210509);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(210511);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((aj.cnC()) && (cqV()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 2;
      g.aiU().a(localc, 0);
    }
    AppMethodBeat.o(210511);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(210510);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((aj.cnC()) && (cqV()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 1;
      g.aiU().a(localc, 0);
    }
    AppMethodBeat.o(210510);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void r(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(210515);
    paramIntent.setClass(paramContext, KvInfoUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.ahp(), "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(210515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.a
 * JD-Core Version:    0.7.0.1
 */