package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;

public final class n
{
  public String appId;
  public int appVersion;
  public int dCv;
  public String kEY;
  public long nJA;
  public volatile long nJu;
  public volatile boolean nJv = false;
  public int nJw;
  public int nJx;
  public long nJy;
  public long nJz;
  public String networkType;
  public int scene;
  public String sessionId;
  public String username;
  
  public final void bUO()
  {
    AppMethodBeat.i(258364);
    this.nJu = Util.currentTicks();
    AppMethodBeat.o(258364);
  }
  
  public final void f(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    int j = 1;
    AppMethodBeat.i(48158);
    this.sessionId = paramAppBrandInitConfigWC.cym;
    p.Um(paramAppBrandInitConfigWC.appId);
    this.networkType = i.getNetworkType(MMApplicationContext.getContext());
    this.appId = paramAppBrandInitConfigWC.appId;
    this.appVersion = paramAppBrandInitConfigWC.appVersion;
    this.dCv = paramAppBrandInitConfigWC.eix;
    this.scene = paramAppBrandStatObject.scene;
    if (this.nJv)
    {
      i = 1;
      this.nJw = i;
      if (!WebView.isX5()) {
        break label154;
      }
    }
    label154:
    for (int i = j;; i = 0)
    {
      this.nJx = i;
      this.nJy = Util.ticksToNow(this.nJu);
      this.nJz = Util.nowMilliSecond();
      this.username = paramAppBrandInitConfigWC.username;
      this.nJA = paramAppBrandInitConfigWC.ldW.apptype;
      this.kEY = paramAppBrandInitConfigWC.ldW.kEY;
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
      e.Cxv.a(14576, new Object[] { this.networkType, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.dCv), Integer.valueOf(this.scene), this.sessionId, Integer.valueOf(this.nJw), Integer.valueOf(this.nJx), Long.valueOf(this.nJy), Long.valueOf(this.nJz), this.username, Long.valueOf(this.nJA), this.kEY });
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
    String str = "kv_14576{, networkType='" + this.networkType + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.dCv + ", scene=" + this.scene + ", sessionId='" + this.sessionId + '\'' + ", is_download_code=" + this.nJw + ", is_load_x5=" + this.nJx + ", cost_time=" + this.nJy + ", event_time=" + this.nJz + ", load_time=" + this.nJu + ", real_time=" + Util.currentTicks() + ", username=" + this.username + ", appType=" + this.nJA + ", instanceId=" + this.kEY + '}';
    AppMethodBeat.o(48157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n
 * JD-Core Version:    0.7.0.1
 */