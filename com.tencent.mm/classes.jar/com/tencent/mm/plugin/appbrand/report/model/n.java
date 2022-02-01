package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.atomic.AtomicBoolean;

public final class n
{
  public int aDD;
  public String appId;
  public int dli;
  public String lIU;
  public String mxS;
  public volatile long myt;
  public volatile boolean myu = false;
  public int myv;
  public int myw;
  public long myx;
  public long myy;
  public long myz;
  public int scene;
  public String sessionId;
  public String username;
  
  public final void byw()
  {
    AppMethodBeat.i(224370);
    this.myt = bu.HQ();
    AppMethodBeat.o(224370);
  }
  
  public final void f(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    int j = 1;
    AppMethodBeat.i(48158);
    this.sessionId = paramAppBrandInitConfigWC.Ef();
    o localo = o.Ld(paramAppBrandInitConfigWC.appId);
    this.mxS = h.getNetworkType(ak.getContext());
    this.appId = paramAppBrandInitConfigWC.appId;
    this.aDD = paramAppBrandInitConfigWC.aDD;
    this.dli = paramAppBrandInitConfigWC.dQv;
    this.scene = paramAppBrandStatObject.scene;
    if (this.myu)
    {
      i = 1;
      this.myv = i;
      if (!localo.jBV.get()) {
        break label160;
      }
    }
    label160:
    for (int i = j;; i = 0)
    {
      this.myw = i;
      this.myx = bu.aO(this.myt);
      this.myy = bu.fpO();
      this.username = paramAppBrandInitConfigWC.username;
      this.myz = paramAppBrandInitConfigWC.kaS.apptype;
      this.lIU = paramAppBrandInitConfigWC.kaS.lIU;
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
      ae.i("MicroMsg.AppBrand.Report.kv_14576", "report|" + toString());
      e.ywz.f(14576, new Object[] { this.mxS, this.appId, Integer.valueOf(this.aDD), Integer.valueOf(this.dli), Integer.valueOf(this.scene), this.sessionId, Integer.valueOf(this.myv), Integer.valueOf(this.myw), Long.valueOf(this.myx), Long.valueOf(this.myy), this.username, Long.valueOf(this.myz), this.lIU });
      AppMethodBeat.o(48159);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.AppBrand.Report.kv_14576", "report exp %s", new Object[] { localException });
      AppMethodBeat.o(48159);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(48157);
    String str = "kv_14576{, networkType='" + this.mxS + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.aDD + ", appState=" + this.dli + ", scene=" + this.scene + ", sessionId='" + this.sessionId + '\'' + ", is_download_code=" + this.myv + ", is_load_x5=" + this.myw + ", cost_time=" + this.myx + ", event_time=" + this.myy + ", load_time=" + this.myt + ", real_time=" + bu.HQ() + ", username=" + this.username + ", appType=" + this.myz + ", instanceId=" + this.lIU + '}';
    AppMethodBeat.o(48157);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.n
 * JD-Core Version:    0.7.0.1
 */