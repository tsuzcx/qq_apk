package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class q
{
  public String appId;
  public int appVersion;
  public String eup;
  public int hzw;
  public String networkType;
  public long qMB;
  public int scene;
  public String sessionId;
  public volatile long tQo;
  public volatile boolean tQp = false;
  public int tQq;
  public int tQr;
  public long tQs;
  public long tQt;
  public String username;
  
  public final void report()
  {
    AppMethodBeat.i(48159);
    try
    {
      Log.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + toString());
      f.Ozc.b(14576, new Object[] { this.networkType, this.appId, Integer.valueOf(this.appVersion), Integer.valueOf(this.hzw), Integer.valueOf(this.scene), this.sessionId, Integer.valueOf(this.tQq), Integer.valueOf(this.tQr), Long.valueOf(this.tQs), Long.valueOf(this.tQt), this.username, Long.valueOf(this.qMB), this.eup });
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
    String str = "kv_14576{, networkType='" + this.networkType + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.appVersion + ", appState=" + this.hzw + ", scene=" + this.scene + ", sessionId='" + this.sessionId + '\'' + ", is_download_code=" + this.tQq + ", is_load_x5=" + this.tQr + ", cost_time=" + this.tQs + ", event_time=" + this.tQt + ", load_time=" + this.tQo + ", real_time=" + Util.currentTicks() + ", username=" + this.username + ", appType=" + this.qMB + ", instanceId=" + this.eup + '}';
    AppMethodBeat.o(48157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.q
 * JD-Core Version:    0.7.0.1
 */