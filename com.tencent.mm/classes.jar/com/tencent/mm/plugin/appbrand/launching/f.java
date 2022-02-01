package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.h;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.g.b.a.fy.a;
import com.tencent.mm.g.b.a.fy.b;
import com.tencent.mm.g.b.a.fy.c;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.w.c;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ai;
import d.g.b.k;
import org.json.JSONObject;

public final class f
  extends e
{
  private final String iJl;
  private final AppBrandLaunchFromNotifyReferrer iJn;
  private bh kFY = null;
  private a kFZ = null;
  private final String kGa;
  private final String kGb;
  private final int launchMode;
  
  f(LaunchParcel paramLaunchParcel, String paramString, e.a parama)
  {
    this(paramLaunchParcel, paramString, parama, null);
  }
  
  public f(LaunchParcel paramLaunchParcel, String paramString, e.a parama, a parama1)
  {
    super(paramLaunchParcel, parama);
    this.kGa = paramString;
    this.iJl = paramLaunchParcel.iJl;
    this.launchMode = paramLaunchParcel.launchMode;
    this.kGb = paramLaunchParcel.iJm;
    this.kFZ = parama1;
    this.iJn = paramLaunchParcel.iJn;
  }
  
  protected final Pair<WxaAttributes, Boolean> bgg()
  {
    AppMethodBeat.i(47081);
    Object localObject1 = new Pair(null, Boolean.FALSE);
    for (;;)
    {
      try
      {
        Object localObject2 = this.username;
        String str = this.appId;
        int j = this.gXn;
        int k = this.pkgVersion;
        if (this.iJL != null) {
          continue;
        }
        i = 0;
        localObject2 = new bh((String)localObject2, str, j, k, i, this.iJb, this.iJL, this.cfi, this.kGa, this.iJn, new w.c()
        {
          public final void aTM()
          {
            AppMethodBeat.i(174931);
            if (f.a(f.this) != null) {
              f.a(f.this).bgh();
            }
            AppMethodBeat.o(174931);
          }
        });
        this.kFY = ((bh)localObject2);
        localObject2 = (Pair)((bh)localObject2).bgR();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        int i;
        ad.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "get attr ", new Object[0]);
        continue;
      }
      AppMethodBeat.o(47081);
      return localObject1;
      i = this.iJL.scene;
    }
  }
  
  protected final boolean f(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47082);
    String str = paramWxaAttributes.field_appId;
    if (new az(str).bgN())
    {
      AppMethodBeat.o(47082);
      return true;
    }
    if (2 == this.gXn)
    {
      if (this.kFZ != null) {
        this.kFZ.bgh();
      }
      if (!bi.ar(str, com.tencent.mm.plugin.appbrand.task.f.MQ(str)))
      {
        AppMethodBeat.o(47082);
        return true;
      }
    }
    if ((this.gXn == 0) && (!bi.a(paramWxaAttributes, this.kFX)))
    {
      AppMethodBeat.o(47082);
      return true;
    }
    AppMethodBeat.o(47082);
    return false;
  }
  
  public final void run()
  {
    AppMethodBeat.i(47080);
    Object localObject3 = bgg();
    Object localObject2 = (WxaAttributes)((Pair)localObject3).first;
    if (localObject2 == null)
    {
      ad.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
      localObject1 = new fy().lH(this.kGa).lI(this.appId);
      ((fy)localObject1).dYT = this.pkgVersion;
      ((fy)localObject1).eeP = fy.a.je(this.gXn + 1);
      ((fy)localObject1).eai = 0L;
      ((fy)localObject1).dKe = this.iJL.scene;
      ((fy)localObject1).eeQ = fy.c.efa;
      ((fy)localObject1).eeR = fy.b.eeW;
      ((fy)localObject1).dON = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((fy)localObject1).dTc = ((fy)localObject1).t("UserName", this.username, true);
      ((fy)localObject1).jn(this.kFY.kMg).jo(this.kFY.kMh).jl(this.kFY.kMi).aBj();
      onError();
      AppMethodBeat.o(47080);
      return;
    }
    if (f((WxaAttributes)localObject2))
    {
      c.c(((WxaAttributes)localObject2).field_appId, KSProcessWeAppLaunch.stepCheckBan);
      onError();
      AppMethodBeat.o(47080);
      return;
    }
    c.b(((WxaAttributes)localObject2).field_appId, KSProcessWeAppLaunch.stepCheckBan);
    Object localObject1 = com.tencent.mm.plugin.appbrand.config.g.aTy().c((WxaAttributes)localObject2);
    ((AppBrandInitConfigWC)localObject1).iOP = this.gXn;
    ((AppBrandInitConfigWC)localObject1).iJl = this.iJl;
    ((AppBrandInitConfigWC)localObject1).launchMode = this.launchMode;
    ((AppBrandInitConfigWC)localObject1).iJm = this.kGb;
    ((AppBrandInitConfigWC)localObject1).iJn = this.iJn;
    this.appId = ((AppBrandInitConfigWC)localObject1).appId;
    Object localObject4 = (b)j.T(b.class);
    k.h(localObject1, "initConfigWC");
    if (((AppBrandInitConfigWC)localObject1).jdl) {
      ((AppBrandInitConfigWC)localObject1).jdy = ((b)localObject4).b(((AppBrandInitConfigWC)localObject1).appId, ((AppBrandInitConfig)localObject1).iOP, ((AppBrandInitConfigWC)localObject1).aAS, ai.Eq());
    }
    ((AppBrandInitConfigWC)localObject1).jdx = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getInt("ClientBenchmarkLevel", -1);
    ((AppBrandInitConfigWC)localObject1).jdu = new QualitySession(this.kGa, (AppBrandInitConfigWC)localObject1, this.iJL);
    localObject4 = ((AppBrandInitConfigWC)localObject1).jdu;
    int i;
    if (this.kFY.kML)
    {
      i = 1;
      ((QualitySession)localObject4).ltA = i;
      ((AppBrandInitConfigWC)localObject1).cfc = this.kGa;
      if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
        break label543;
      }
      ((AppBrandInitConfigLU)localObject1).cfn = true;
      localObject3 = com.tencent.mm.plugin.appbrand.report.quality.f.e(((AppBrandInitConfigWC)localObject1).jdu);
      ((fy)localObject3).eeQ = fy.c.eeZ;
      localObject3 = ((fy)localObject3).jn(this.kFY.kMg).jo(this.kFY.kMh).jl(this.kFY.kMi);
      ((fy)localObject3).eeR = fy.b.eeW;
      ((fy)localObject3).dON = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((fy)localObject3).aBj();
      label487:
      if (this.gXn != 0) {
        break label551;
      }
      ((AppBrandInitConfigWC)localObject1).jbC = ((WxaAttributes)localObject2).aTP().jfz;
    }
    for (;;)
    {
      if (this.iJL == null) {
        this.iJL = new AppBrandStatObject();
      }
      b((AppBrandInitConfigLU)localObject1, this.iJL);
      AppMethodBeat.o(47080);
      return;
      i = 0;
      break;
      label543:
      ((AppBrandInitConfigLU)localObject1).cfn = false;
      break label487;
      label551:
      ((AppBrandInitConfigWC)localObject1).extInfo = ((t)j.T(t.class)).bG(this.appId, this.gXn);
      try
      {
        localObject2 = h.qE(((AppBrandInitConfigWC)localObject1).extInfo);
        ((AppBrandInitConfigWC)localObject1).jbC = ((JSONObject)localObject2).optString("device_orientation");
        ((AppBrandInitConfigWC)localObject1).cfe = ((JSONObject)localObject2).optBoolean("open_remote", false);
        ((AppBrandInitConfigWC)localObject1).jdq = ((JSONObject)localObject2).optString("debug_launch_info", null);
        ((AppBrandInitConfigWC)localObject1).cfl = y.Gx(((AppBrandInitConfigWC)localObject1).extInfo);
        ((JSONObject)localObject2).remove("debug_launch_info");
        ((t)j.T(t.class)).s(this.appId, this.gXn, ((JSONObject)localObject2).toString());
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "run() process extInfo with appId[%s] versionType[%d]", new Object[] { this.appId, Integer.valueOf(this.gXn) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bgh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */