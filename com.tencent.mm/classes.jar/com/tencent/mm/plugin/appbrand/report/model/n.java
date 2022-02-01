package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.atomic.AtomicBoolean;

public final class n
{
  public int aDD;
  public String appId;
  public int dkg;
  public String lEv;
  public String msV;
  public long mtA;
  public long mtB;
  public long mtC;
  public volatile long mtw;
  public volatile boolean mtx = false;
  public int mty;
  public int mtz;
  public int scene;
  public String sessionId;
  public String username;
  
  public final void bxD()
  {
    AppMethodBeat.i(221309);
    this.mtw = bt.HI();
    AppMethodBeat.o(221309);
  }
  
  public final void f(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    int j = 1;
    AppMethodBeat.i(48158);
    this.sessionId = paramAppBrandInitConfigWC.Ec();
    com.tencent.mm.plugin.appbrand.n localn = com.tencent.mm.plugin.appbrand.n.KE(paramAppBrandInitConfigWC.appId);
    this.msV = h.getNetworkType(aj.getContext());
    this.appId = paramAppBrandInitConfigWC.appId;
    this.aDD = paramAppBrandInitConfigWC.aDD;
    this.dkg = paramAppBrandInitConfigWC.dPf;
    this.scene = paramAppBrandStatObject.scene;
    if (this.mtx)
    {
      i = 1;
      this.mty = i;
      if (!localn.jyV.get()) {
        break label160;
      }
    }
    label160:
    for (int i = j;; i = 0)
    {
      this.mtz = i;
      this.mtA = bt.aO(this.mtw);
      this.mtB = bt.flT();
      this.username = paramAppBrandInitConfigWC.username;
      this.mtC = paramAppBrandInitConfigWC.jXD.apptype;
      this.lEv = paramAppBrandInitConfigWC.jXD.lEv;
      AppMethodBeat.o(48158);
      return;
      i = 0;
      break;
    }
  }
  
  public final void report()
  {
    AppMethodBeat.i(48159);
    try
    {
      ad.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + toString());
      e.ygI.f(14576, new Object[] { this.msV, this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dkg), Integer.valueOf(this.scene), this.sessionId, Integer.valueOf(this.mty), Integer.valueOf(this.mtz), Long.valueOf(this.mtA), Long.valueOf(this.mtB), this.username, Long.valueOf(this.mtC), this.lEv });
      AppMethodBeat.o(48159);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", new Object[] { localException });
      AppMethodBeat.o(48159);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48157);
    String str = "kv_14576{, networkType='" + this.msV + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aDD + ", appState=" + this.dkg + ", scene=" + this.scene + ", sessionId='" + this.sessionId + '\'' + ", is_download_code=" + this.mty + ", is_load_x5=" + this.mtz + ", cost_time=" + this.mtA + ", event_time=" + this.mtB + ", load_time=" + this.mtw + ", real_time=" + bt.HI() + ", username=" + this.username + ", appType=" + this.mtC + ", instanceId=" + this.lEv + '}';
    AppMethodBeat.o(48157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n
 * JD-Core Version:    0.7.0.1
 */