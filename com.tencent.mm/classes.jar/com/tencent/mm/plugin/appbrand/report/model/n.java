package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.g;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.concurrent.atomic.AtomicBoolean;

public final class n
{
  public int aBM;
  public String appId;
  public int cYO;
  public volatile long lTH;
  public volatile boolean lTI = false;
  public int lTJ;
  public int lTK;
  public long lTL;
  public long lTM;
  public long lTN;
  public String lTf;
  public String lht;
  public int scene;
  public String sessionId;
  public String username;
  
  public final void bty()
  {
    AppMethodBeat.i(210159);
    this.lTH = bs.Gn();
    AppMethodBeat.o(210159);
  }
  
  public final void e(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    int j = 1;
    AppMethodBeat.i(48158);
    this.sessionId = paramAppBrandInitConfigWC.CD();
    com.tencent.mm.plugin.appbrand.n localn = com.tencent.mm.plugin.appbrand.n.Hr(paramAppBrandInitConfigWC.appId);
    this.lTf = g.getNetworkType(ai.getContext());
    this.appId = paramAppBrandInitConfigWC.appId;
    this.aBM = paramAppBrandInitConfigWC.aBM;
    this.cYO = paramAppBrandInitConfigWC.joY;
    this.scene = paramAppBrandStatObject.scene;
    if (this.lTI)
    {
      i = 1;
      this.lTJ = i;
      if (!localn.jfP.get()) {
        break label160;
      }
    }
    label160:
    for (int i = j;; i = 0)
    {
      this.lTK = i;
      this.lTL = bs.aO(this.lTH);
      this.lTM = bs.eWj();
      this.username = paramAppBrandInitConfigWC.username;
      this.lTN = paramAppBrandInitConfigWC.jDH.apptype;
      this.lht = paramAppBrandInitConfigWC.jDH.lht;
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
      ac.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + toString());
      e.wTc.f(14576, new Object[] { this.lTf, this.appId, Integer.valueOf(this.aBM), Integer.valueOf(this.cYO), Integer.valueOf(this.scene), this.sessionId, Integer.valueOf(this.lTJ), Integer.valueOf(this.lTK), Long.valueOf(this.lTL), Long.valueOf(this.lTM), this.username, Long.valueOf(this.lTN), this.lht });
      AppMethodBeat.o(48159);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", new Object[] { localException });
      AppMethodBeat.o(48159);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48157);
    String str = "kv_14576{, networkType='" + this.lTf + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aBM + ", appState=" + this.cYO + ", scene=" + this.scene + ", sessionId='" + this.sessionId + '\'' + ", is_download_code=" + this.lTJ + ", is_load_x5=" + this.lTK + ", cost_time=" + this.lTL + ", event_time=" + this.lTM + ", load_time=" + this.lTH + ", real_time=" + bs.Gn() + ", username=" + this.username + ", appType=" + this.lTN + ", instanceId=" + this.lht + '}';
    AppMethodBeat.o(48157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n
 * JD-Core Version:    0.7.0.1
 */