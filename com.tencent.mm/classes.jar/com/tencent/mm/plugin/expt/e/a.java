package com.tencent.mm.plugin.expt.e;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.wt;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.ui.KvInfoUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.List;

public final class a
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.a
{
  private static a sJN;
  private IListener<ln> kvQ;
  private IListener oVk;
  public String sJO;
  public boolean sJP;
  public HashMap<String, List<b>> sJQ;
  
  public a()
  {
    AppMethodBeat.i(220605);
    this.oVk = new IListener() {};
    this.kvQ = new a.2(this);
    this.sJP = false;
    this.sJQ = new HashMap();
    AppMethodBeat.o(220605);
  }
  
  public static a cRf()
  {
    AppMethodBeat.i(220606);
    if (sJN == null) {
      sJN = new a();
    }
    a locala = sJN;
    AppMethodBeat.o(220606);
    return locala;
  }
  
  private void cRh()
  {
    AppMethodBeat.i(220612);
    Log.i("MicroMsg.ExptReportService", "%d sendStopMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), this.sJO });
    if ((MMApplicationContext.isMMProcess()) && (!Util.isNullOrNil(this.sJO)))
    {
      c localc = new c();
      localc.content = this.sJO;
      localc.type = 10000;
      localc.key = 2;
      g.azz().a(localc, 0);
    }
    this.sJO = null;
    AppMethodBeat.o(220612);
  }
  
  public final void aod(String paramString)
  {
    AppMethodBeat.i(220613);
    long l = Util.currentTicks();
    if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger())) && (!Util.isNullOrNil(paramString)) && (paramString.startsWith(":exptdebug/")))
    {
      paramString = paramString.substring(11);
      Log.i("MicroMsg.ExptReportService", "%d sendStartMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
      this.sJO = paramString;
      if (MMApplicationContext.isMMProcess())
      {
        localObject = new c();
        ((c)localObject).content = paramString;
        ((c)localObject).type = 10000;
        ((c)localObject).key = 1;
        g.azz().a((q)localObject, 0);
      }
      Object localObject = new wt();
      ((wt)localObject).edh.edi = paramString;
      EventCenter.instance.publish((IEvent)localObject);
      this.sJP = true;
    }
    Log.i("MicroMsg.ExptReportService", "start expt Debug tools cost time [%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(220613);
  }
  
  public final void cMC()
  {
    AppMethodBeat.i(220614);
    cRh();
    wt localwt = new wt();
    localwt.edh.edi = "";
    EventCenter.instance.publish(localwt);
    AppMethodBeat.o(220614);
  }
  
  public final boolean cRg()
  {
    AppMethodBeat.i(220607);
    if (!Util.isNullOrNil(this.sJO))
    {
      AppMethodBeat.o(220607);
      return true;
    }
    AppMethodBeat.o(220607);
    return false;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(220608);
    if (MMApplicationContext.isMainProcess())
    {
      EventCenter.instance.add(this.kvQ);
      EventCenter.instance.add(this.oVk);
    }
    AppMethodBeat.o(220608);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(220609);
    cMC();
    EventCenter.instance.removeListener(this.kvQ);
    EventCenter.instance.removeListener(this.oVk);
    if (this.sJQ != null) {
      this.sJQ.clear();
    }
    this.sJP = false;
    AppMethodBeat.o(220609);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(220611);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((MMApplicationContext.isMMProcess()) && (cRg()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 2;
      g.azz().a(localc, 0);
    }
    AppMethodBeat.o(220611);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(220610);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((MMApplicationContext.isMMProcess()) && (cRg()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 1;
      g.azz().a(localc, 0);
    }
    AppMethodBeat.o(220610);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void r(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(220615);
    paramIntent.setClass(paramContext, KvInfoUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramIntent.axQ(), "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(220615);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.a
 * JD-Core Version:    0.7.0.1
 */