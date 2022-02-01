package com.tencent.mm.plugin.expt.b;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.kf;
import com.tencent.mm.g.a.um;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;

public final class a
  implements Application.ActivityLifecycleCallbacks, com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.expt.a.a
{
  private static a pIi;
  private com.tencent.mm.sdk.b.c mCw;
  public String pIj;
  private com.tencent.mm.sdk.b.c<kf> pIk;
  
  public a()
  {
    AppMethodBeat.i(190904);
    this.mCw = new com.tencent.mm.sdk.b.c() {};
    this.pIk = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(190904);
  }
  
  public static a cdS()
  {
    AppMethodBeat.i(190905);
    if (pIi == null) {
      pIi = new a();
    }
    a locala = pIi;
    AppMethodBeat.o(190905);
    return locala;
  }
  
  private void cdU()
  {
    AppMethodBeat.i(190911);
    ad.i("MicroMsg.ExptReportService", "%d sendStopMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), this.pIj });
    if ((aj.cbv()) && (!bt.isNullOrNil(this.pIj)))
    {
      b localb = new b();
      localb.content = this.pIj;
      localb.type = 10000;
      localb.key = 2;
      g.aeS().a(localb, 0);
    }
    this.pIj = null;
    AppMethodBeat.o(190911);
  }
  
  public final void Vl(String paramString)
  {
    AppMethodBeat.i(190912);
    long l = bt.GC();
    if (((h.DEBUG) || (h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (bu.eGT())) && (!bt.isNullOrNil(paramString)) && (paramString.startsWith(":exptdebug/")))
    {
      paramString = paramString.substring(11);
      k.dkR().oT(true);
      ad.i("MicroMsg.ExptReportService", "%d sendStartMonitor [%s]", new Object[] { Integer.valueOf(hashCode()), paramString });
      this.pIj = paramString;
      if (aj.cbv())
      {
        localObject = new b();
        ((b)localObject).content = paramString;
        ((b)localObject).type = 10000;
        ((b)localObject).key = 1;
        g.aeS().a((n)localObject, 0);
      }
      Object localObject = new um();
      ((um)localObject).dAe.dAf = paramString;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    ad.i("MicroMsg.ExptReportService", "start expt Debug tools cost time [%d]", new Object[] { Long.valueOf(bt.aS(l)) });
    AppMethodBeat.o(190912);
  }
  
  public final void cbj()
  {
    AppMethodBeat.i(190913);
    k.dkR().oT(false);
    cdU();
    um localum = new um();
    localum.dAe.dAf = "";
    com.tencent.mm.sdk.b.a.ESL.l(localum);
    AppMethodBeat.o(190913);
  }
  
  public final boolean cdT()
  {
    AppMethodBeat.i(190906);
    if (!bt.isNullOrNil(this.pIj))
    {
      AppMethodBeat.o(190906);
      return true;
    }
    AppMethodBeat.o(190906);
    return false;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(190907);
    com.tencent.mm.sdk.b.a.ESL.b(this.pIk);
    com.tencent.mm.sdk.b.a.ESL.b(this.mCw);
    AppMethodBeat.o(190907);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(190908);
    cbj();
    com.tencent.mm.sdk.b.a.ESL.d(this.pIk);
    com.tencent.mm.sdk.b.a.ESL.d(this.mCw);
    AppMethodBeat.o(190908);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(190910);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((aj.cbv()) && (cdT()))
    {
      b localb = new b();
      localb.content = paramActivity;
      localb.type = 10002;
      localb.key = 2;
      g.aeS().a(localb, 0);
    }
    AppMethodBeat.o(190910);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(190909);
    paramActivity = paramActivity.getComponentName().getClassName();
    if ((aj.cbv()) && (cdT()))
    {
      b localb = new b();
      localb.content = paramActivity;
      localb.type = 10002;
      localb.key = 1;
      g.aeS().a(localb, 0);
    }
    AppMethodBeat.o(190909);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.b.a
 * JD-Core Version:    0.7.0.1
 */