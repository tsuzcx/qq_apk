package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;

public final class n
{
  public String appId;
  public int appVersion;
  public String cBH;
  public int fvc;
  public long nMB;
  public String networkType;
  public volatile long qLH;
  public volatile boolean qLI = false;
  public int qLJ;
  public int qLK;
  public long qLL;
  public long qLM;
  public int scene;
  public String sessionId;
  public String username;
  
  public final void chZ()
  {
    AppMethodBeat.i(293185);
    this.qLH = Util.currentTicks();
    AppMethodBeat.o(293185);
  }
  
  public final void f(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    int j = 1;
    AppMethodBeat.i(48158);
    this.sessionId = paramAppBrandInitConfigWC.cwP;
    s.abV(paramAppBrandInitConfigWC.appId);
    this.networkType = j.getNetworkType(MMApplicationContext.getContext());
    this.appId = paramAppBrandInitConfigWC.appId;
    this.appVersion = paramAppBrandInitConfigWC.appVersion;
    this.fvc = paramAppBrandInitConfigWC.cBI;
    this.scene = paramAppBrandStatObject.scene;
    if (this.qLI)
    {
      i = 1;
      this.qLJ = i;
      if (!WebView.isX5()) {
        break label154;
      }
    }
    label154:
    for (int i = j;; i = 0)
    {
      this.qLK = i;
      this.qLL = Util.ticksToNow(this.qLH);
      this.qLM = Util.nowMilliSecond();
      this.username = paramAppBrandInitConfigWC.username;
      this.nMB = paramAppBrandInitConfigWC.nYk.apptype;
      this.cBH = paramAppBrandInitConfigWC.nYk.cBH;
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
      Log.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + toString());
      f.Iyx.a(14576, new Object[] { this.networkType, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.fvc), Integer.valueOf(this.scene), this.sessionId, Integer.valueOf(this.qLJ), Integer.valueOf(this.qLK), Long.valueOf(this.qLL), Long.valueOf(this.qLM), this.username, Long.valueOf(this.nMB), this.cBH });
      AppMethodBeat.o(48159);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", new Object[] { localException });
      AppMethodBeat.o(48159);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48157);
    String str = "kv_14576{, networkType='" + this.networkType + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.fvc + ", scene=" + this.scene + ", sessionId='" + this.sessionId + '\'' + ", is_download_code=" + this.qLJ + ", is_load_x5=" + this.qLK + ", cost_time=" + this.qLL + ", event_time=" + this.qLM + ", load_time=" + this.qLH + ", real_time=" + Util.currentTicks() + ", username=" + this.username + ", appType=" + this.nMB + ", instanceId=" + this.cBH + '}';
    AppMethodBeat.o(48157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n
 * JD-Core Version:    0.7.0.1
 */