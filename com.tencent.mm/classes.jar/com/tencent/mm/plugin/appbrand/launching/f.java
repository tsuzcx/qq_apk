package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.g.b.a.iu;
import com.tencent.mm.g.b.a.iu.a;
import com.tencent.mm.g.b.a.iu.b;
import com.tencent.mm.g.b.a.iu.c;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.config.x.d;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.al;
import d.g.b.p;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public final class f
  extends e
{
  private final String jCX;
  private final AppBrandLaunchFromNotifyReferrer jCZ;
  private final boolean lEr;
  private as lEs;
  private final LaunchParcel lEt;
  private a lEu;
  private final String lEv;
  private final int launchMode;
  
  public f(LaunchParcel paramLaunchParcel, String paramString, e.a<AppBrandInitConfigWC> parama, a parama1)
  {
    this(paramLaunchParcel, paramString, false, parama, parama1);
  }
  
  f(LaunchParcel paramLaunchParcel, String paramString, boolean paramBoolean, e.a<AppBrandInitConfigWC> parama)
  {
    this(paramLaunchParcel, paramString, paramBoolean, parama, null);
  }
  
  private f(LaunchParcel paramLaunchParcel, String paramString, boolean paramBoolean, e.a<AppBrandInitConfigWC> parama, a parama1)
  {
    super(paramLaunchParcel, parama);
    AppMethodBeat.i(188583);
    this.lEs = null;
    this.lEu = null;
    this.lEt = paramLaunchParcel;
    this.lEv = paramString;
    this.jCX = paramLaunchParcel.jCX;
    this.launchMode = paramLaunchParcel.launchMode;
    this.lEu = parama1;
    this.jCZ = paramLaunchParcel.jCZ;
    this.lEr = paramBoolean;
    ad.i("MicroMsg.AppBrandPreLaunchProcessWC", "<init> username[%s] appId[%s] instanceId[%s] forceUseBackupWxaAttrs[%b]", new Object[] { paramLaunchParcel.username, paramLaunchParcel.appId, paramString, Boolean.valueOf(this.lEr) });
    AppMethodBeat.o(188583);
  }
  
  private static void ub(int paramInt)
  {
    AppMethodBeat.i(188584);
    try
    {
      com.tencent.mm.plugin.report.service.g.yhR.dD(369, paramInt);
      AppMethodBeat.o(188584);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.e("MicroMsg.AppBrandPreLaunchProcessWC", "reportFallbackIDKey key(%d) get exception %s", new Object[] { Integer.valueOf(paramInt), localThrowable });
      AppMethodBeat.o(188584);
    }
  }
  
  protected final Pair<WxaAttributes, Boolean> bqL()
  {
    AppMethodBeat.i(47081);
    localObject1 = new Pair(null, Boolean.FALSE);
    for (;;)
    {
      try
      {
        if (j.a.rQ(this.hQh))
        {
          if (this.lEr)
          {
            ad.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] forceUseBackupWxaAttrs[TRUE]", new Object[] { this.username, this.appId });
            ub(31);
            localObject3 = new ar(this.username, this.appId);
            this.lEs = ((as)localObject3);
            localObject3 = ((as)localObject3).brx();
            AppMethodBeat.o(47081);
            return localObject3;
          }
          if (av.dP(this.username, this.appId))
          {
            ad.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
            ub(32);
            localObject3 = new ar(this.username, this.appId);
            this.lEs = ((as)localObject3);
            localObject3 = ((as)localObject3).brx();
            AppMethodBeat.o(47081);
            return localObject3;
          }
        }
        Object localObject3 = this.username;
        localObject5 = this.appId;
        int j = this.hQh;
        int k = this.pkgVersion;
        if (this.jDH != null) {
          continue;
        }
        i = 0;
        localObject3 = new bk((String)localObject3, (String)localObject5, j, k, i, this.jCN, this.jDH, this.cmv, this.lEv, this.jCZ, new x.d()
        {
          public final void bek()
          {
            AppMethodBeat.i(174931);
            if (f.a(f.this) != null) {
              f.a(f.this).bqM();
            }
            AppMethodBeat.o(174931);
          }
        });
        this.lEs = ((as)localObject3);
        localObject3 = ((as)localObject3).brx();
        localObject1 = localObject3;
      }
      catch (TimeoutException localTimeoutException)
      {
        Object localObject5;
        ad.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes timeout with username[%s] appId[%s] step[%s]", new Object[] { this.username, this.appId, this.lEs.name() });
        long l2 = this.lEs.brw();
        if ((!j.a.rQ(this.hQh)) || (!av.bry())) {
          continue;
        }
        ad.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
        try
        {
          localObject4 = new ar(this.username, this.appId);
          this.lEs = ((as)localObject4);
          localObject4 = ((as)localObject4).brx();
          try
          {
            ub(33);
            localObject1 = (WxaAttributes)((Pair)localObject4).first;
            if (localObject1 != null)
            {
              localObject5 = new gv();
              ((gv)localObject5).pH(((WxaAttributes)localObject1).field_appId);
              ((gv)localObject5).pI(((WxaAttributes)localObject1).field_username);
              if (this.jDH != null) {
                continue;
              }
              l1 = 0L;
              ((gv)localObject5).equ = l1;
              ((gv)localObject5).eqv = 0L;
              ((gv)localObject5).eqw = ((WxaAttributes)localObject1).ben().aDD;
              ((gv)localObject5).eqB = 0L;
              ((gv)localObject5).eqC = l2;
              ((gv)localObject5).pJ(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(aj.getContext()));
              ((gv)localObject5).eqA = 0L;
              ((gv)localObject5).pK(this.lEv);
              ((gv)localObject5).aLk();
            }
          }
          catch (Throwable localThrowable)
          {
            long l1;
            ad.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() report fallback get exception %s", new Object[] { localThrowable });
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
        int i = this.jDH.scene;
        l1 = i;
        continue;
        ad.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes fallback with username[%s] appId[%s], get exception[%s]", new Object[] { this.username, this.appId, localObject4 });
        bf.RO(aj.getContext().getString(2131755578, new Object[] { "" }));
        AppMethodBeat.o(47081);
        return localObject2;
        continue;
      }
      catch (Exception localException1)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException1, "get attr ", new Object[0]);
        continue;
      }
      AppMethodBeat.o(47081);
      return localObject1;
      i = this.jDH.scene;
    }
  }
  
  protected final boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47082);
    String str = paramWxaAttributes.field_appId;
    if (new bc(str).brz())
    {
      AppMethodBeat.o(47082);
      return true;
    }
    if (2 == this.hQh)
    {
      if (this.lEu != null) {
        this.lEu.bqM();
      }
      if (!bl.au(str, com.tencent.mm.plugin.appbrand.task.f.UF(str)))
      {
        AppMethodBeat.o(47082);
        return true;
      }
    }
    if ((this.hQh == 0) && (!bl.a(paramWxaAttributes, this.lEq)))
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
    Object localObject3 = bqL();
    Object localObject2 = (WxaAttributes)((Pair)localObject3).first;
    if (localObject2 == null)
    {
      ad.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
      localObject1 = new iu().rt(this.lEv).ru(this.appId);
      ((iu)localObject1).eru = this.pkgVersion;
      ((iu)localObject1).exV = iu.a.jz(this.hQh + 1);
      ((iu)localObject1).esT = 0L;
      ((iu)localObject1).dVd = this.jDH.scene;
      ((iu)localObject1).exW = iu.c.eyh;
      ((iu)localObject1).exX = iu.b.eyc;
      ((iu)localObject1).ega = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((iu)localObject1).dTi = ((iu)localObject1).t("UserName", this.username, true);
      ((iu)localObject1).oN(this.lEs.bru()).oO(this.lEs.brv()).oL(this.lEs.brw()).aLk();
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
    Object localObject1 = com.tencent.mm.plugin.appbrand.config.g.bdW().c((WxaAttributes)localObject2);
    ((AppBrandInitConfigWC)localObject1).dPf = this.hQh;
    ((AppBrandInitConfigWC)localObject1).jCX = this.jCX;
    ((AppBrandInitConfigWC)localObject1).launchMode = this.launchMode;
    ((AppBrandInitConfigWC)localObject1).jXI = ((WxaAttributes)localObject2).bem().jZH.jXI;
    ((AppBrandInitConfigWC)localObject1).jXJ = ((WxaAttributes)localObject2).bem().jZH.jXJ;
    ((AppBrandInitConfigWC)localObject1).jCZ = this.jCZ;
    this.appId = ((AppBrandInitConfigWC)localObject1).appId;
    Object localObject4 = (b)j.T(b.class);
    p.h(localObject1, "initConfigWC");
    if (((AppBrandInitConfigWC)localObject1).jXu) {
      ((AppBrandInitConfigWC)localObject1).jXH = ((b)localObject4).a(((AppBrandInitConfigWC)localObject1).appId, ((AppBrandInitConfig)localObject1).dPf, ((AppBrandInitConfigWC)localObject1).aDD, al.isDarkMode());
    }
    ((AppBrandInitConfigWC)localObject1).jXG = ((a)com.tencent.mm.kernel.g.ab(a.class)).acA().getInt("ClientBenchmarkLevel", -1);
    ((AppBrandInitConfigWC)localObject1).jXD = new QualitySession(this.lEv, (AppBrandInitConfigWC)localObject1, this.jDH);
    localObject4 = ((AppBrandInitConfigWC)localObject1).jXD;
    boolean bool;
    if (!((k)j.T(k.class)).ME(this.username))
    {
      bool = true;
      ((QualitySession)localObject4).mvk = bool;
      ((AppBrandInitConfigWC)localObject1).cmq = this.lEv;
      if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
        break label653;
      }
      ((AppBrandInitConfigLU)localObject1).cmB = true;
      localObject3 = com.tencent.mm.plugin.appbrand.report.quality.f.e(((AppBrandInitConfigWC)localObject1).jXD);
      ((iu)localObject3).exW = iu.c.eyg;
      localObject3 = ((iu)localObject3).oN(this.lEs.bru()).oO(this.lEs.brv()).oL(this.lEs.brw());
      ((iu)localObject3).exX = iu.b.eyc;
      ((iu)localObject3).ega = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((iu)localObject3).aLk();
      label533:
      if (this.hQh != 0) {
        break label661;
      }
      ((AppBrandInitConfigWC)localObject1).jVL = ((WxaAttributes)localObject2).ben().jZX;
    }
    for (;;)
    {
      if (this.jDH == null) {
        this.jDH = new AppBrandStatObject();
      }
      if ((this.lEs instanceof ar)) {
        ((AppBrandInitConfigWC)localObject1).jXK = true;
      }
      if (this.lEt.lNf != null) {
        ((AppBrandInitConfigWC)localObject1).jXL = ((WeAppOpenDeclarePromptBundle)this.lEt.lNf);
      }
      if (this.lEt.lNg != null) {
        ((AppBrandInitConfigWC)localObject1).jXM = ((AppBrandRuntimeReloadReportBundle)this.lEt.lNg);
      }
      b((AppBrandInitConfigLU)localObject1, this.jDH);
      AppMethodBeat.o(47080);
      return;
      bool = false;
      break;
      label653:
      ((AppBrandInitConfigLU)localObject1).cmB = false;
      break label533;
      label661:
      ((AppBrandInitConfigWC)localObject1).extInfo = ((t)j.T(t.class)).bN(this.appId, this.hQh);
      try
      {
        localObject2 = com.tencent.mm.ac.h.wJ(((AppBrandInitConfigWC)localObject1).extInfo);
        ((AppBrandInitConfigWC)localObject1).jVL = ((JSONObject)localObject2).optString("device_orientation");
        ((AppBrandInitConfigWC)localObject1).cms = ((JSONObject)localObject2).optBoolean("open_remote", false);
        ((AppBrandInitConfigWC)localObject1).jXz = ((JSONObject)localObject2).optString("debug_launch_info", null);
        ((AppBrandInitConfigWC)localObject1).cmy = z.NU(((AppBrandInitConfigWC)localObject1).extInfo);
        ((JSONObject)localObject2).remove("debug_launch_info");
        ((t)j.T(t.class)).t(this.appId, this.hQh, ((JSONObject)localObject2).toString());
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "run() process extInfo with appId[%s] versionType[%d]", new Object[] { this.appId, Integer.valueOf(this.hQh) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bqM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */