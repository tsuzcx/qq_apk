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
  public int aAS;
  public String appId;
  public int dbs;
  public String kGa;
  public volatile long lrM;
  public volatile boolean lrN = false;
  public int lrO;
  public int lrP;
  public long lrQ;
  public long lrR;
  public long lrS;
  public String lrk;
  public int scene;
  public String sessionId;
  public String username;
  
  public final void bmC()
  {
    AppMethodBeat.i(205044);
    this.lrM = bt.GC();
    AppMethodBeat.o(205044);
  }
  
  public final void e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    int j = 1;
    AppMethodBeat.i(48158);
    this.sessionId = paramAppBrandInitConfigWC.Da();
    com.tencent.mm.plugin.appbrand.n localn = com.tencent.mm.plugin.appbrand.n.Do(paramAppBrandInitConfigWC.appId);
    this.lrk = h.getNetworkType(aj.getContext());
    this.appId = paramAppBrandInitConfigWC.appId;
    this.aAS = paramAppBrandInitConfigWC.aAS;
    this.dbs = paramAppBrandInitConfigWC.iOP;
    this.scene = paramAppBrandStatObject.scene;
    if (this.lrN)
    {
      i = 1;
      this.lrO = i;
      if (!localn.iFN.get()) {
        break label160;
      }
    }
    label160:
    for (int i = j;; i = 0)
    {
      this.lrP = i;
      this.lrQ = bt.aS(this.lrM);
      this.lrR = bt.eGO();
      this.username = paramAppBrandInitConfigWC.username;
      this.lrS = paramAppBrandInitConfigWC.jdu.apptype;
      this.kGa = paramAppBrandInitConfigWC.jdu.kGa;
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
      e.vIY.f(14576, new Object[] { this.lrk, this.appId, Integer.valueOf(this.aAS), Integer.valueOf(this.dbs), Integer.valueOf(this.scene), this.sessionId, Integer.valueOf(this.lrO), Integer.valueOf(this.lrP), Long.valueOf(this.lrQ), Long.valueOf(this.lrR), this.username, Long.valueOf(this.lrS), this.kGa });
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
    String str = "kv_14576{, networkType='" + this.lrk + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aAS + ", appState=" + this.dbs + ", scene=" + this.scene + ", sessionId='" + this.sessionId + '\'' + ", is_download_code=" + this.lrO + ", is_load_x5=" + this.lrP + ", cost_time=" + this.lrQ + ", event_time=" + this.lrR + ", load_time=" + this.lrM + ", real_time=" + bt.GC() + ", username=" + this.username + ", appType=" + this.lrS + ", instanceId=" + this.kGa + '}';
    AppMethodBeat.o(48157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n
 * JD-Core Version:    0.7.0.1
 */