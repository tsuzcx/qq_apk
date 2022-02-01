package com.tencent.mm.plugin.expt.kvdebug;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.nk;
import com.tencent.mm.autogen.a.zs;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.ui.KvInfoUI;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.HashMap;
import java.util.List;

public final class a
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.b.b
{
  private static Boolean zLN = null;
  private static a zLO;
  private IListener<nk> qlh;
  private IListener viA;
  public String zLP;
  public boolean zLQ;
  public HashMap<String, List<b>> zLR;
  
  public a()
  {
    AppMethodBeat.i(299461);
    this.viA = new ExptReportService.1(this, f.hfK);
    this.qlh = new ExptReportService.2(this, f.hfK);
    this.zLQ = false;
    this.zLR = new HashMap();
    AppMethodBeat.o(299461);
  }
  
  public static a dMK()
  {
    AppMethodBeat.i(299466);
    if (zLO == null) {
      zLO = new a();
    }
    a locala = zLO;
    AppMethodBeat.o(299466);
    return locala;
  }
  
  private void dMM()
  {
    AppMethodBeat.i(299471);
    Log.i("MicroMsg.ExptReportService", "%d sendStopMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), this.zLP });
    if ((MMApplicationContext.isMMProcess()) && (!Util.isNullOrNil(this.zLP)))
    {
      c localc = new c();
      localc.content = this.zLP;
      localc.type = 10000;
      localc.key = 2;
      h.aZW().a(localc, 0);
    }
    this.zLP = null;
    AppMethodBeat.o(299471);
  }
  
  public final void J(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(299583);
    paramIntent.setClass(paramContext, KvInfoUI.class);
    paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramIntent.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/expt/kvdebug/ExptReportService", "showKvDebugUI", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(299583);
  }
  
  public final void aqa(String paramString)
  {
    AppMethodBeat.i(299569);
    long l = Util.currentTicks();
    if (((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (WeChatEnvironment.hasDebugger())) && (!Util.isNullOrNil(paramString)) && (paramString.startsWith(":exptdebug/")))
    {
      paramString = paramString.substring(11);
      Log.i("MicroMsg.ExptReportService", "%d sendStartMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
      this.zLP = paramString;
      if (MMApplicationContext.isMMProcess())
      {
        localObject = new c();
        ((c)localObject).content = paramString;
        ((c)localObject).type = 10000;
        ((c)localObject).key = 1;
        h.aZW().a((p)localObject, 0);
      }
      Object localObject = new zs();
      ((zs)localObject).idn.ido = paramString;
      ((zs)localObject).publish();
      this.zLQ = true;
    }
    Log.i("MicroMsg.ExptReportService", "start expt Debug tools cost time [%d]", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(299569);
  }
  
  public final void dHM()
  {
    AppMethodBeat.i(299577);
    dMM();
    zs localzs = new zs();
    localzs.idn.ido = "";
    localzs.publish();
    AppMethodBeat.o(299577);
  }
  
  public final boolean dML()
  {
    AppMethodBeat.i(299493);
    if (!Util.isNullOrNil(this.zLP))
    {
      AppMethodBeat.o(299493);
      return true;
    }
    AppMethodBeat.o(299493);
    return false;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(299499);
    if (MMApplicationContext.isMainProcess())
    {
      this.qlh.alive();
      this.viA.alive();
    }
    AppMethodBeat.o(299499);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(299506);
    dHM();
    this.qlh.dead();
    this.viA.dead();
    if (this.zLR != null) {
      this.zLR.clear();
    }
    this.zLQ = false;
    AppMethodBeat.o(299506);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(299538);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((MMApplicationContext.isMMProcess()) && (dML()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 2;
      h.aZW().a(localc, 0);
    }
    AppMethodBeat.o(299538);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(299529);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((MMApplicationContext.isMMProcess()) && (dML()))
    {
      c localc = new c();
      localc.content = paramActivity;
      localc.type = 10002;
      localc.key = 1;
      h.aZW().a(localc, 0);
    }
    AppMethodBeat.o(299529);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.kvdebug.a
 * JD-Core Version:    0.7.0.1
 */