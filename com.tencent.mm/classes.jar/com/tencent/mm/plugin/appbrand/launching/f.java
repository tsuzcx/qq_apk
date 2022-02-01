package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.g.b.a.hq;
import com.tencent.mm.g.b.a.hq.a;
import com.tencent.mm.g.b.a.hq.b;
import com.tencent.mm.g.b.a.hq.c;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.w.d;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.aj;
import d.g.b.k;
import org.json.JSONObject;

public final class f
  extends e
{
  private final String jjp;
  private final AppBrandLaunchFromNotifyReferrer jjr;
  private final int launchMode;
  private bh lhr = null;
  private a lhs = null;
  private final String lht;
  private final String lhu;
  
  f(LaunchParcel paramLaunchParcel, String paramString, e.a parama)
  {
    this(paramLaunchParcel, paramString, parama, null);
  }
  
  public f(LaunchParcel paramLaunchParcel, String paramString, e.a parama, a parama1)
  {
    super(paramLaunchParcel, parama);
    this.lht = paramString;
    this.jjp = paramLaunchParcel.jjp;
    this.launchMode = paramLaunchParcel.launchMode;
    this.lhu = paramLaunchParcel.jjq;
    this.lhs = parama1;
    this.jjr = paramLaunchParcel.jjr;
  }
  
  protected final Pair<WxaAttributes, Boolean> bna()
  {
    AppMethodBeat.i(47081);
    Object localObject1 = new Pair(null, Boolean.FALSE);
    for (;;)
    {
      try
      {
        Object localObject2 = this.username;
        String str = this.appId;
        int j = this.hxM;
        int k = this.pkgVersion;
        if (this.jjR != null) {
          continue;
        }
        i = 0;
        localObject2 = new bh((String)localObject2, str, j, k, i, this.jjf, this.jjR, this.cce, this.lht, this.jjr, new w.d()
        {
          public final void baK()
          {
            AppMethodBeat.i(174931);
            if (f.a(f.this) != null) {
              f.a(f.this).bnb();
            }
            AppMethodBeat.o(174931);
          }
        });
        this.lhr = ((bh)localObject2);
        localObject2 = (Pair)((bh)localObject2).bnL();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        int i;
        ac.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "get attr ", new Object[0]);
        continue;
      }
      AppMethodBeat.o(47081);
      return localObject1;
      i = this.jjR.scene;
    }
  }
  
  protected final boolean f(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47082);
    String str = paramWxaAttributes.field_appId;
    if (new az(str).bnH())
    {
      AppMethodBeat.o(47082);
      return true;
    }
    if (2 == this.hxM)
    {
      if (this.lhs != null) {
        this.lhs.bnb();
      }
      if (!bi.as(str, com.tencent.mm.plugin.appbrand.task.f.QZ(str)))
      {
        AppMethodBeat.o(47082);
        return true;
      }
    }
    if ((this.hxM == 0) && (!bi.a(paramWxaAttributes, this.lhq)))
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
    Object localObject3 = bna();
    Object localObject2 = (WxaAttributes)((Pair)localObject3).first;
    if (localObject2 == null)
    {
      ac.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
      localObject1 = new hq().oM(this.lht).oN(this.appId);
      ((hq)localObject1).eaM = this.pkgVersion;
      ((hq)localObject1).egW = hq.a.jc(this.hxM + 1);
      ((hq)localObject1).eco = 0L;
      ((hq)localObject1).dHY = this.jjR.scene;
      ((hq)localObject1).egX = hq.c.ehh;
      ((hq)localObject1).egY = hq.b.ehd;
      ((hq)localObject1).dQE = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((hq)localObject1).dGd = ((hq)localObject1).t("UserName", this.username, true);
      ((hq)localObject1).mP(this.lhr.lnD).mQ(this.lhr.lnE).mN(this.lhr.lnF).aHZ();
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
    Object localObject1 = com.tencent.mm.plugin.appbrand.config.g.baw().c((WxaAttributes)localObject2);
    ((AppBrandInitConfigWC)localObject1).joY = this.hxM;
    ((AppBrandInitConfigWC)localObject1).jjp = this.jjp;
    ((AppBrandInitConfigWC)localObject1).launchMode = this.launchMode;
    ((AppBrandInitConfigWC)localObject1).jjq = this.lhu;
    ((AppBrandInitConfigWC)localObject1).jjr = this.jjr;
    this.appId = ((AppBrandInitConfigWC)localObject1).appId;
    Object localObject4 = (b)j.T(b.class);
    k.h(localObject1, "initConfigWC");
    if (((AppBrandInitConfigWC)localObject1).jDy) {
      ((AppBrandInitConfigWC)localObject1).jDL = ((b)localObject4).b(((AppBrandInitConfigWC)localObject1).appId, ((AppBrandInitConfig)localObject1).joY, ((AppBrandInitConfigWC)localObject1).aBM, aj.DT());
    }
    ((AppBrandInitConfigWC)localObject1).jDK = ((a)com.tencent.mm.kernel.g.ab(a.class)).ZY().getInt("ClientBenchmarkLevel", -1);
    ((AppBrandInitConfigWC)localObject1).jDH = new QualitySession(this.lht, (AppBrandInitConfigWC)localObject1, this.jjR);
    localObject4 = ((AppBrandInitConfigWC)localObject1).jDH;
    int i;
    if (this.lhr.lok)
    {
      i = 1;
      ((QualitySession)localObject4).lVu = i;
      ((AppBrandInitConfigWC)localObject1).cbZ = this.lht;
      if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
        break label543;
      }
      ((AppBrandInitConfigLU)localObject1).cck = true;
      localObject3 = com.tencent.mm.plugin.appbrand.report.quality.f.e(((AppBrandInitConfigWC)localObject1).jDH);
      ((hq)localObject3).egX = hq.c.ehg;
      localObject3 = ((hq)localObject3).mP(this.lhr.lnD).mQ(this.lhr.lnE).mN(this.lhr.lnF);
      ((hq)localObject3).egY = hq.b.ehd;
      ((hq)localObject3).dQE = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((hq)localObject3).aHZ();
      label487:
      if (this.hxM != 0) {
        break label551;
      }
      ((AppBrandInitConfigWC)localObject1).jBP = ((WxaAttributes)localObject2).baN().jFO;
    }
    for (;;)
    {
      if (this.jjR == null) {
        this.jjR = new AppBrandStatObject();
      }
      b((AppBrandInitConfigLU)localObject1, this.jjR);
      AppMethodBeat.o(47080);
      return;
      i = 0;
      break;
      label543:
      ((AppBrandInitConfigLU)localObject1).cck = false;
      break label487;
      label551:
      ((AppBrandInitConfigWC)localObject1).extInfo = ((t)j.T(t.class)).bK(this.appId, this.hxM);
      try
      {
        localObject2 = h.tT(((AppBrandInitConfigWC)localObject1).extInfo);
        ((AppBrandInitConfigWC)localObject1).jBP = ((JSONObject)localObject2).optString("device_orientation");
        ((AppBrandInitConfigWC)localObject1).ccb = ((JSONObject)localObject2).optBoolean("open_remote", false);
        ((AppBrandInitConfigWC)localObject1).jDD = ((JSONObject)localObject2).optString("debug_launch_info", null);
        ((AppBrandInitConfigWC)localObject1).cch = y.KB(((AppBrandInitConfigWC)localObject1).extInfo);
        ((JSONObject)localObject2).remove("debug_launch_info");
        ((t)j.T(t.class)).s(this.appId, this.hxM, ((JSONObject)localObject2).toString());
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "run() process extInfo with appId[%s] versionType[%d]", new Object[] { this.appId, Integer.valueOf(this.hxM) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bnb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */