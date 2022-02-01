package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.nh;
import com.tencent.mm.f.b.a.pr;
import com.tencent.mm.f.b.a.pr.a;
import com.tencent.mm.f.b.a.pr.b;
import com.tencent.mm.f.b.a.pr.c;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.config.aa.f;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import java.util.concurrent.TimeoutException;
import kotlin.g.b.p;
import org.json.JSONObject;

public final class e
  extends d
  implements y
{
  private final String cBH;
  private final String fWY;
  private final int launchMode;
  private final AppBrandLaunchFromNotifyReferrer nBB;
  private final HalfScreenConfig nBE;
  private final boolean nBF;
  private ae pRA;
  private final LaunchParcel pRB;
  private a pRC;
  private volatile com.tencent.luggage.sdk.launching.b pRD;
  private final boolean pRz;
  
  public e(LaunchParcel paramLaunchParcel, String paramString, d.a<AppBrandInitConfigWC> parama, a parama1)
  {
    this(paramLaunchParcel, paramString, false, parama, parama1);
  }
  
  e(LaunchParcel paramLaunchParcel, String paramString, boolean paramBoolean, d.a<AppBrandInitConfigWC> parama)
  {
    this(paramLaunchParcel, paramString, paramBoolean, parama, null);
  }
  
  private e(LaunchParcel paramLaunchParcel, String paramString, boolean paramBoolean, d.a<AppBrandInitConfigWC> parama, a parama1)
  {
    super(paramLaunchParcel, parama);
    AppMethodBeat.i(284363);
    this.pRA = null;
    this.pRC = null;
    this.pRD = com.tencent.luggage.sdk.launching.b.cBe;
    this.pRB = paramLaunchParcel;
    this.cBH = paramString;
    this.fWY = paramLaunchParcel.fWY;
    this.launchMode = paramLaunchParcel.launchMode;
    this.pRC = parama1;
    this.nBB = paramLaunchParcel.nBB;
    this.pRz = paramBoolean;
    this.nBE = paramLaunchParcel.nBE;
    this.nBF = paramLaunchParcel.nBF;
    Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "<init> username[%s] appId[%s] instanceId[%s] forceUseBackupWxaAttrs[%b]", new Object[] { paramLaunchParcel.username, paramLaunchParcel.appId, paramString, Boolean.valueOf(this.pRz) });
    AppMethodBeat.o(284363);
  }
  
  private static void BG(int paramInt)
  {
    AppMethodBeat.i(284364);
    try
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(369, paramInt);
      AppMethodBeat.o(284364);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "reportFallbackIDKey key(%d) get exception %s", new Object[] { Integer.valueOf(paramInt), localThrowable });
      AppMethodBeat.o(284364);
    }
  }
  
  public final void a(com.tencent.luggage.sdk.launching.b paramb)
  {
    this.pRD = paramb;
  }
  
  protected final Pair<WxaAttributes, Boolean> bZx()
  {
    AppMethodBeat.i(47081);
    localObject1 = new Pair(null, Boolean.FALSE);
    for (;;)
    {
      try
      {
        if (j.a.za(this.cBU))
        {
          if (this.pRz)
          {
            Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] forceUseBackupWxaAttrs[TRUE]", new Object[] { this.username, this.appId });
            BG(31);
            ah.b.ct(this.cBH, 0);
            localObject3 = new ad(this.username, this.appId);
            this.pRA = ((ae)localObject3);
            localObject3 = ((ae)localObject3).caa();
            AppMethodBeat.o(47081);
            return localObject3;
          }
          if (ah.eu(this.username, this.appId))
          {
            Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
            BG(32);
            ah.b.ct(this.cBH, 0);
            localObject3 = new ad(this.username, this.appId);
            this.pRA = ((ae)localObject3);
            localObject3 = ((ae)localObject3).caa();
            AppMethodBeat.o(47081);
            return localObject3;
          }
        }
        if (this.nyh != null) {
          continue;
        }
        i = 0;
        Object localObject3 = null;
        if (1173 == i) {
          localObject3 = com.tencent.mm.plugin.appbrand.openmaterial.model.a.alj(this.pRB.nYf);
        }
        localObject3 = new ba(this.username, this.appId, this.cBU, this.pkgVersion, i, this.nBq, this.nyh, this.cwV, this.cBH, this.nBB, (String)localObject3, new aa.f()
        {
          public final void bLE()
          {
            AppMethodBeat.i(174931);
            if (e.a(e.this) != null) {
              e.a(e.this).bEl();
            }
            AppMethodBeat.o(174931);
          }
        }, this.pRD);
        this.pRA = ((ae)localObject3);
        localObject3 = ((ae)localObject3).caa();
        localObject1 = localObject3;
      }
      catch (TimeoutException localTimeoutException)
      {
        Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes timeout with username[%s] appId[%s] step[%s]", new Object[] { this.username, this.appId, this.pRA.name() });
        long l2 = this.pRA.bZZ();
        if ((!j.a.za(this.cBU)) || (!ah.cab())) {
          continue;
        }
        Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
        try
        {
          ah.b.ct(this.cBH, 0);
          localObject4 = new ad(this.username, this.appId);
          this.pRA = ((ae)localObject4);
          localObject4 = ((ae)localObject4).caa();
          try
          {
            BG(33);
            localObject1 = (WxaAttributes)((Pair)localObject4).first;
            if (localObject1 != null)
            {
              nh localnh = new nh();
              localnh.Ef(((WxaAttributes)localObject1).field_appId);
              localnh.Eg(((WxaAttributes)localObject1).field_username);
              if (this.nyh != null) {
                continue;
              }
              l1 = 0L;
              localnh.gYC = l1;
              localnh.gYD = 0L;
              localnh.gYE = ((WxaAttributes)localObject1).bLH().appVersion;
              localnh.gYJ = 0L;
              localnh.gYK = l2;
              localnh.Eh(j.getNetworkType(MMApplicationContext.getContext()));
              localnh.gYI = 0L;
              localnh.Ei(this.cBH);
              localnh.bpa();
            }
          }
          catch (Throwable localThrowable)
          {
            long l1;
            Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() report fallback get exception %s", new Object[] { localThrowable });
            continue;
          }
          catch (Exception localException3)
          {
            localObject2 = localObject4;
            localObject4 = localException3;
          }
          AppMethodBeat.o(47081);
          return localObject4;
        }
        catch (Exception localException2)
        {
          Object localObject4;
          Object localObject2;
          continue;
        }
        int i = this.nyh.scene;
        l1 = i;
        continue;
        Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes fallback with username[%s] appId[%s], get exception[%s]", new Object[] { this.username, this.appId, localObject4 });
        av.a(MMApplicationContext.getContext().getString(au.i.app_brand_preparing_attr_sync_timeout, new Object[] { "" }), this);
        AppMethodBeat.o(47081);
        return localObject2;
        continue;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException1, "get attr ", new Object[0]);
        continue;
      }
      AppMethodBeat.o(47081);
      return localObject1;
      i = this.nyh.scene;
    }
  }
  
  public final boolean bZy()
  {
    return this.pRB.cxe != com.tencent.luggage.sdk.launching.b.cBf;
  }
  
  protected final boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47082);
    String str = paramWxaAttributes.field_appId;
    if (new as(str).cac())
    {
      AppMethodBeat.o(47082);
      return true;
    }
    if (2 == this.cBU)
    {
      if (this.pRC != null) {
        this.pRC.bEl();
      }
      if (!bb.a(str, i.cjb().w(str, -1), this))
      {
        AppMethodBeat.o(47082);
        return true;
      }
    }
    if ((this.cBU == 0) && (!bb.a(paramWxaAttributes, this.pRy)))
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
    Object localObject3 = bZx();
    Object localObject2 = (WxaAttributes)((Pair)localObject3).first;
    if (localObject2 == null)
    {
      Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
      localObject1 = new pr().GH(this.cBH).GI(this.appId);
      ((pr)localObject1).gYL = this.pkgVersion;
      ((pr)localObject1).hhc = pr.a.oO(this.cBU + 1);
      ((pr)localObject1).gYN = 0L;
      ((pr)localObject1).gnP = this.nyh.scene;
      ((pr)localObject1).hhd = pr.c.hhn;
      ((pr)localObject1).hhe = pr.b.hhj;
      ((pr)localObject1).gHC = g.getNetworkType();
      ((pr)localObject1).gjX = ((pr)localObject1).z("UserName", this.username, true);
      ((pr)localObject1).CL(this.pRA.bZX()).CM(this.pRA.bZY()).CJ(this.pRA.bZZ()).bpa();
      onError();
      AppMethodBeat.o(47080);
      return;
    }
    if (g((WxaAttributes)localObject2))
    {
      c.c(((WxaAttributes)localObject2).field_appId, KSProcessWeAppLaunch.stepCheckBan);
      onError();
      AppMethodBeat.o(47080);
      return;
    }
    c.b(((WxaAttributes)localObject2).field_appId, KSProcessWeAppLaunch.stepCheckBan);
    Object localObject1 = com.tencent.mm.plugin.appbrand.config.h.bLi().c((WxaAttributes)localObject2);
    ((AppBrandInitConfigWC)localObject1).cBI = this.cBU;
    ((AppBrandInitConfigWC)localObject1).fWY = this.fWY;
    ((AppBrandInitConfigWC)localObject1).launchMode = this.launchMode;
    ((AppBrandInitConfigWC)localObject1).nYp = ((WxaAttributes)localObject2).bLG().obf.nYp;
    ((AppBrandInitConfigWC)localObject1).nYq = ((WxaAttributes)localObject2).bLG().obf.nYq;
    ((AppBrandInitConfigWC)localObject1).nBB = this.nBB;
    ((AppBrandInitConfigWC)localObject1).nBE = this.nBE;
    ((AppBrandInitConfigWC)localObject1).nBF = this.nBF;
    ((AppBrandInitConfigWC)localObject1).nYf = this.pRB.nYf;
    ((AppBrandInitConfigWC)localObject1).nYe = this.pRB.nYe;
    ((AppBrandInitConfigWC)localObject1).nBJ = this.pRB.nBJ;
    this.appId = ((AppBrandInitConfigWC)localObject1).appId;
    Object localObject4 = (com.tencent.mm.plugin.appbrand.ui.c.a.b)m.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class);
    p.k(localObject1, "initConfigWC");
    if (((AppBrandInitConfigWC)localObject1).nYb) {
      ((AppBrandInitConfigWC)localObject1).nYo = ((com.tencent.mm.plugin.appbrand.ui.c.a.b)localObject4).a(((AppBrandInitConfigWC)localObject1).appId, ((AppBrandInitConfig)localObject1).cBI, ((AppBrandInitConfigWC)localObject1).appVersion, ar.isDarkMode());
    }
    ((AppBrandInitConfigWC)localObject1).nYn = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getInt("ClientBenchmarkLevel", -1);
    ((AppBrandInitConfigWC)localObject1).nYk = new QualitySession(this.cBH, (AppBrandInitConfigWC)localObject1, this.nyh);
    localObject4 = ((AppBrandInitConfigWC)localObject1).nYk;
    boolean bool;
    if (!((k)m.W(k.class)).aef(this.username))
    {
      bool = true;
      ((QualitySession)localObject4).qNz = bool;
      ((AppBrandInitConfigWC)localObject1).dW(this.cBH);
      if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
        break label702;
      }
      ((AppBrandInitConfigLU)localObject1).cxd = true;
      localObject3 = g.c(((AppBrandInitConfigWC)localObject1).nYk);
      ((pr)localObject3).hhd = pr.c.hhm;
      localObject3 = ((pr)localObject3).CL(this.pRA.bZX()).CM(this.pRA.bZY()).CJ(this.pRA.bZZ());
      ((pr)localObject3).hhe = pr.b.hhj;
      ((pr)localObject3).gHC = g.getNetworkType();
      ((pr)localObject3).bpa();
      label582:
      if (this.cBU != 0) {
        break label710;
      }
      ((AppBrandInitConfigWC)localObject1).cCi = ((WxaAttributes)localObject2).bLH().obz;
    }
    for (;;)
    {
      if (this.nyh == null) {
        this.nyh = new AppBrandStatObject();
      }
      if ((this.pRA instanceof ad)) {
        ((AppBrandInitConfigWC)localObject1).nYr = true;
      }
      if (this.pRB.pZo != null) {
        ((AppBrandInitConfigWC)localObject1).nYs = ((WeAppOpenDeclarePromptBundle)this.pRB.pZo);
      }
      if (this.pRB.pZp != null) {
        ((AppBrandInitConfigWC)localObject1).nYt = ((AppBrandRuntimeReloadReportBundle)this.pRB.pZp);
      }
      a((AppBrandInitConfigLU)localObject1, this.nyh);
      AppMethodBeat.o(47080);
      return;
      bool = false;
      break;
      label702:
      ((AppBrandInitConfigLU)localObject1).cxd = false;
      break label582;
      label710:
      ((AppBrandInitConfigWC)localObject1).extInfo = ((s)m.W(s.class)).cs(this.appId, this.cBU);
      try
      {
        localObject2 = com.tencent.mm.ad.h.ME(((AppBrandInitConfigWC)localObject1).extInfo);
        ((AppBrandInitConfigWC)localObject1).cCi = ((JSONObject)localObject2).optString("device_orientation");
        ((AppBrandInitConfigWC)localObject1).cwS = ((JSONObject)localObject2).optBoolean("open_remote", false);
        ((AppBrandInitConfigWC)localObject1).nYg = ((JSONObject)localObject2).optString("debug_launch_info", null);
        ((AppBrandInitConfigWC)localObject1).cwY = ac.afy(((AppBrandInitConfigWC)localObject1).extInfo);
        if (TextUtils.isEmpty(((AppBrandInitConfigWC)localObject1).cwY.oby))
        {
          localObject3 = m.bFP().c(this.appId, this.cBU, new String[] { "versionMd5" });
          if (localObject3 != null) {
            ((AppBrandInitConfigWC)localObject1).cwY.oby = ((bh)localObject3).field_versionMd5;
          }
        }
        ((JSONObject)localObject2).remove("debug_launch_info");
        ((s)m.W(s.class)).B(this.appId, this.cBU, ((JSONObject)localObject2).toString());
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "run() process extInfo with appId[%s] versionType[%d]", new Object[] { this.appId, Integer.valueOf(this.cBU) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bEl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e
 * JD-Core Version:    0.7.0.1
 */