package com.tencent.mm.plugin.expt.b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.kn;
import com.tencent.mm.g.a.uw;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;

public final class a
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.a.a
{
  private static a qqP;
  private com.tencent.mm.sdk.b.c ney;
  public String qqQ;
  private com.tencent.mm.sdk.b.c<kn> qqR;
  
  public a()
  {
    AppMethodBeat.i(195301);
    this.ney = new com.tencent.mm.sdk.b.c() {};
    this.qqR = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(195301);
  }
  
  private void clB()
  {
    AppMethodBeat.i(195308);
    ac.i("MicroMsg.ExptReportService", "%d sendStopMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), this.qqQ });
    if ((com.tencent.mm.sdk.platformtools.ai.ciE()) && (!bs.isNullOrNil(this.qqQ)))
    {
      b localb = new b();
      localb.content = this.qqQ;
      localb.type = 10000;
      localb.key = 2;
      g.agi().a(localb, 0);
    }
    this.qqQ = null;
    AppMethodBeat.o(195308);
  }
  
  public static a clz()
  {
    AppMethodBeat.i(195302);
    if (qqP == null) {
      qqP = new a();
    }
    a locala = qqP;
    AppMethodBeat.o(195302);
    return locala;
  }
  
  public final void Zx(String paramString)
  {
    AppMethodBeat.i(195309);
    long l = bs.Gn();
    if (((h.DEBUG) || (h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (bt.eWo())) && (!bs.isNullOrNil(paramString)) && (paramString.startsWith(":exptdebug/")))
    {
      paramString = paramString.substring(11);
      k.dyU().pR(true);
      ac.i("MicroMsg.ExptReportService", "%d sendStartMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
      this.qqQ = paramString;
      if (com.tencent.mm.sdk.platformtools.ai.ciE())
      {
        localObject = new b();
        ((b)localObject).content = paramString;
        ((b)localObject).type = 10000;
        ((b)localObject).key = 1;
        g.agi().a((n)localObject, 0);
      }
      Object localObject = new uw();
      ((uw)localObject).dxQ.dxR = paramString;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    }
    ac.i("MicroMsg.ExptReportService", "start expt Debug tools cost time [%d]", new Object[] { Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(195309);
  }
  
  public final void cis()
  {
    AppMethodBeat.i(195310);
    k.dyU().pR(false);
    clB();
    uw localuw = new uw();
    localuw.dxQ.dxR = "";
    com.tencent.mm.sdk.b.a.GpY.l(localuw);
    AppMethodBeat.o(195310);
  }
  
  public final boolean clA()
  {
    AppMethodBeat.i(195303);
    if (!bs.isNullOrNil(this.qqQ))
    {
      AppMethodBeat.o(195303);
      return true;
    }
    AppMethodBeat.o(195303);
    return false;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(195304);
    com.tencent.mm.sdk.b.a.GpY.b(this.qqR);
    com.tencent.mm.sdk.b.a.GpY.b(this.ney);
    AppMethodBeat.o(195304);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(195305);
    cis();
    com.tencent.mm.sdk.b.a.GpY.d(this.qqR);
    com.tencent.mm.sdk.b.a.GpY.d(this.ney);
    AppMethodBeat.o(195305);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(195307);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((com.tencent.mm.sdk.platformtools.ai.ciE()) && (clA()))
    {
      b localb = new b();
      localb.content = paramActivity;
      localb.type = 10002;
      localb.key = 2;
      g.agi().a(localb, 0);
    }
    AppMethodBeat.o(195307);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(195306);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((com.tencent.mm.sdk.platformtools.ai.ciE()) && (clA()))
    {
      b localb = new b();
      localb.content = paramActivity;
      localb.type = 10002;
      localb.key = 1;
      g.agi().a(localb, 0);
    }
    AppMethodBeat.o(195306);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.a
 * JD-Core Version:    0.7.0.1
 */