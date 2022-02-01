package com.tencent.mm.plugin.expt.e;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.al;
import com.tencent.mm.f.a.me;
import com.tencent.mm.f.a.xz;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
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
  private static a wpL;
  private IListener<me> noa;
  private IListener rXj;
  public String wpM;
  public boolean wpN;
  public HashMap<String, List<b>> wpO;
  
  public a()
  {
    AppMethodBeat.i(251401);
    this.rXj = new IListener() {};
    this.noa = new IListener() {};
    this.wpN = false;
    this.wpO = new HashMap();
    AppMethodBeat.o(251401);
  }
  
  public static a dga()
  {
    AppMethodBeat.i(251402);
    if (wpL == null) {
      wpL = new a();
    }
    a locala = wpL;
    AppMethodBeat.o(251402);
    return locala;
  }
  
  private void dgc()
  {
    AppMethodBeat.i(251414);
    Log.i("MicroMsg.ExptReportService", "%d sendStopMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), this.wpM });
    if ((MMApplicationContext.isMMProcess()) && (!Util.isNullOrNil(this.wpM)))
    {
      c localc = new c();
      localc.content = this.wpM;
      localc.type = 10000;
      localc.key = 2;
      h.aGY().a(localc, 0);
    }
    this.wpM = null;
    AppMethodBeat.o(251414);
  }
  
  public final void awb(String paramString)
  {
    AppMethodBeat.i(251415);
    long l = Util.currentTicks();
    if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger())) && (!Util.isNullOrNil(paramString)) && (paramString.startsWith(":exptdebug/")))
    {
      paramString = paramString.substring(11);
      Log.i("MicroMsg.ExptReportService", "%d sendStartMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
      this.wpM = paramString;
      if (MMApplicationContext.isMMProcess())
      {
        localObject = new c();
        ((c)localObject).content = paramString;
        ((c)localObject).type = 10000;
        ((c)localObject).key = 1;
        h.aGY().a((q)localObject, 0);
      }
      Object localObject = new xz();
      ((xz)localObject).fXn.fXo = paramString;
      EventCenter.instance.publish((IEvent)localObject);
      this.wpN = true;
    }
    Log.i("MicroMsg.ExptReportService", "start expt Debug tools cost time [%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(251415);
  }
  
  public final void dbq()
  {
    AppMethodBeat.i(251417);
    dgc();
    xz localxz = new xz();
    localxz.fXn.fXo = "";
    EventCenter.instance.publish(localxz);
    AppMethodBeat.o(251417);
  }
  
  public final boolean dgb()
  {
    AppMethodBeat.i(251403);
    if (!Util.isNullOrNil(this.wpM))
    {
      AppMethodBeat.o(251403);
      return true;
    }
    AppMethodBeat.o(251403);
    return false;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(251404);
    if (MMApplicationContext.isMainProcess())
    {
      EventCenter.instance.add(this.noa);
      EventCenter.instance.add(this.rXj);
    }
    AppMethodBeat.o(251404);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(251407);
    dbq();
    EventCenter.instance.removeListener(this.noa);
    EventCenter.instance.removeListener(this.rXj);
    if (this.wpO != null) {
      this.wpO.clear();
    }
    this.wpN = false;
    AppMethodBeat.o(251407);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(251410);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((MMApplicationContext.isMMProcess()) && (dgb()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 2;
      h.aGY().a(localc, 0);
    }
    AppMethodBeat.o(251410);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(251409);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((MMApplicationContext.isMMProcess()) && (dgb()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 1;
      h.aGY().a(localc, 0);
    }
    AppMethodBeat.o(251409);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void q(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(251418);
    paramIntent.setClass(paramContext, KvInfoUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(251418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.a
 * JD-Core Version:    0.7.0.1
 */