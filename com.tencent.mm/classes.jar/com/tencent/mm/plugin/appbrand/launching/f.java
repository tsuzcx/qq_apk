package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gx;
import com.tencent.mm.g.b.a.iw;
import com.tencent.mm.g.b.a.iw.a;
import com.tencent.mm.g.b.a.iw.b;
import com.tencent.mm.g.b.a.iw.c;
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
import com.tencent.mm.plugin.appbrand.config.x.e;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.ui.c.a.b;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.al;
import d.g.b.p;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public final class f
  extends e
{
  private final String jFV;
  private final AppBrandLaunchFromNotifyReferrer jFX;
  private final boolean lIQ;
  private as lIR;
  private final LaunchParcel lIS;
  private a lIT;
  private final String lIU;
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
    AppMethodBeat.i(222742);
    this.lIR = null;
    this.lIT = null;
    this.lIS = paramLaunchParcel;
    this.lIU = paramString;
    this.jFV = paramLaunchParcel.jFV;
    this.launchMode = paramLaunchParcel.launchMode;
    this.lIT = parama1;
    this.jFX = paramLaunchParcel.jFX;
    this.lIQ = paramBoolean;
    ae.i("MicroMsg.AppBrandPreLaunchProcessWC", "<init> username[%s] appId[%s] instanceId[%s] forceUseBackupWxaAttrs[%b]", new Object[] { paramLaunchParcel.username, paramLaunchParcel.appId, paramString, Boolean.valueOf(this.lIQ) });
    AppMethodBeat.o(222742);
  }
  
  private static void uh(int paramInt)
  {
    AppMethodBeat.i(222743);
    try
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(369, paramInt);
      AppMethodBeat.o(222743);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.e("MicroMsg.AppBrandPreLaunchProcessWC", "reportFallbackIDKey key(%d) get exception %s", new Object[] { Integer.valueOf(paramInt), localThrowable });
      AppMethodBeat.o(222743);
    }
  }
  
  protected final Pair<WxaAttributes, Boolean> brv()
  {
    AppMethodBeat.i(47081);
    localObject1 = new Pair(null, Boolean.FALSE);
    for (;;)
    {
      try
      {
        if (j.a.rT(this.hSZ))
        {
          if (this.lIQ)
          {
            ae.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] forceUseBackupWxaAttrs[TRUE]", new Object[] { this.username, this.appId });
            uh(31);
            av.b.bS(this.lIU, 0);
            localObject3 = new ar(this.username, this.appId);
            this.lIR = ((as)localObject3);
            localObject3 = ((as)localObject3).bsi();
            AppMethodBeat.o(47081);
            return localObject3;
          }
          if (av.dR(this.username, this.appId))
          {
            ae.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
            uh(32);
            av.b.bS(this.lIU, 0);
            localObject3 = new ar(this.username, this.appId);
            this.lIR = ((as)localObject3);
            localObject3 = ((as)localObject3).bsi();
            AppMethodBeat.o(47081);
            return localObject3;
          }
        }
        Object localObject3 = this.username;
        localObject5 = this.appId;
        int j = this.hSZ;
        int k = this.pkgVersion;
        if (this.jGF != null) {
          continue;
        }
        i = 0;
        localObject3 = new bk((String)localObject3, (String)localObject5, j, k, i, this.jFL, this.jGF, this.cmx, this.lIU, this.jFX, new x.e()
        {
          public final void beS()
          {
            AppMethodBeat.i(174931);
            if (f.a(f.this) != null) {
              f.a(f.this).brw();
            }
            AppMethodBeat.o(174931);
          }
        });
        this.lIR = ((as)localObject3);
        localObject3 = ((as)localObject3).bsi();
        localObject1 = localObject3;
      }
      catch (TimeoutException localTimeoutException)
      {
        Object localObject5;
        ae.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes timeout with username[%s] appId[%s] step[%s]", new Object[] { this.username, this.appId, this.lIR.name() });
        long l2 = this.lIR.bsh();
        if ((!j.a.rT(this.hSZ)) || (!av.bsj())) {
          continue;
        }
        ae.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
        try
        {
          av.b.bS(this.lIU, 0);
          localObject4 = new ar(this.username, this.appId);
          this.lIR = ((as)localObject4);
          localObject4 = ((as)localObject4).bsi();
          try
          {
            uh(33);
            localObject1 = (WxaAttributes)((Pair)localObject4).first;
            if (localObject1 != null)
            {
              localObject5 = new gx();
              ((gx)localObject5).qc(((WxaAttributes)localObject1).field_appId);
              ((gx)localObject5).qd(((WxaAttributes)localObject1).field_username);
              if (this.jGF != null) {
                continue;
              }
              l1 = 0L;
              ((gx)localObject5).esb = l1;
              ((gx)localObject5).esc = 0L;
              ((gx)localObject5).esd = ((WxaAttributes)localObject1).beV().aDD;
              ((gx)localObject5).esi = 0L;
              ((gx)localObject5).esj = l2;
              ((gx)localObject5).qe(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(ak.getContext()));
              ((gx)localObject5).esh = 0L;
              ((gx)localObject5).qf(this.lIU);
              ((gx)localObject5).aLH();
            }
          }
          catch (Throwable localThrowable)
          {
            long l1;
            ae.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() report fallback get exception %s", new Object[] { localThrowable });
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
        int i = this.jGF.scene;
        l1 = i;
        continue;
        ae.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes fallback with username[%s] appId[%s], get exception[%s]", new Object[] { this.username, this.appId, localObject4 });
        bf.Sx(ak.getContext().getString(2131755578, new Object[] { "" }));
        AppMethodBeat.o(47081);
        return localObject2;
        continue;
      }
      catch (Exception localException1)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException1, "get attr ", new Object[0]);
        continue;
      }
      AppMethodBeat.o(47081);
      return localObject1;
      i = this.jGF.scene;
    }
  }
  
  protected final boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47082);
    String str = paramWxaAttributes.field_appId;
    if (new bc(str).bsk())
    {
      AppMethodBeat.o(47082);
      return true;
    }
    if (2 == this.hSZ)
    {
      if (this.lIT != null) {
        this.lIT.brw();
      }
      if (!bl.au(str, com.tencent.mm.plugin.appbrand.task.f.Vq(str)))
      {
        AppMethodBeat.o(47082);
        return true;
      }
    }
    if ((this.hSZ == 0) && (!bl.a(paramWxaAttributes, this.lIP)))
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
    Object localObject3 = brv();
    Object localObject2 = (WxaAttributes)((Pair)localObject3).first;
    if (localObject2 == null)
    {
      ae.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
      localObject1 = new iw().rO(this.lIU).rP(this.appId);
      ((iw)localObject1).etb = this.pkgVersion;
      ((iw)localObject1).ezF = iw.a.jB(this.hSZ + 1);
      ((iw)localObject1).euA = 0L;
      ((iw)localObject1).dWt = this.jGF.scene;
      ((iw)localObject1).ezG = iw.c.ezQ;
      ((iw)localObject1).ezH = iw.b.ezM;
      ((iw)localObject1).ehL = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((iw)localObject1).dUy = ((iw)localObject1).t("UserName", this.username, true);
      ((iw)localObject1).pa(this.lIR.bsf()).pb(this.lIR.bsg()).oY(this.lIR.bsh()).aLH();
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
    Object localObject1 = com.tencent.mm.plugin.appbrand.config.g.beC().c((WxaAttributes)localObject2);
    ((AppBrandInitConfigWC)localObject1).dQv = this.hSZ;
    ((AppBrandInitConfigWC)localObject1).jFV = this.jFV;
    ((AppBrandInitConfigWC)localObject1).launchMode = this.launchMode;
    ((AppBrandInitConfigWC)localObject1).kaX = ((WxaAttributes)localObject2).beU().kcY.kaX;
    ((AppBrandInitConfigWC)localObject1).kaY = ((WxaAttributes)localObject2).beU().kcY.kaY;
    ((AppBrandInitConfigWC)localObject1).jFX = this.jFX;
    this.appId = ((AppBrandInitConfigWC)localObject1).appId;
    Object localObject4 = (b)j.T(b.class);
    p.h(localObject1, "initConfigWC");
    if (((AppBrandInitConfigWC)localObject1).kaJ) {
      ((AppBrandInitConfigWC)localObject1).kaW = ((b)localObject4).a(((AppBrandInitConfigWC)localObject1).appId, ((AppBrandInitConfig)localObject1).dQv, ((AppBrandInitConfigWC)localObject1).aDD, al.isDarkMode());
    }
    ((AppBrandInitConfigWC)localObject1).kaV = ((a)com.tencent.mm.kernel.g.ab(a.class)).acL().getInt("ClientBenchmarkLevel", -1);
    ((AppBrandInitConfigWC)localObject1).kaS = new QualitySession(this.lIU, (AppBrandInitConfigWC)localObject1, this.jGF);
    localObject4 = ((AppBrandInitConfigWC)localObject1).kaS;
    boolean bool;
    if (!((k)j.T(k.class)).Nl(this.username))
    {
      bool = true;
      ((QualitySession)localObject4).mAh = bool;
      ((AppBrandInitConfigWC)localObject1).cms = this.lIU;
      if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
        break label653;
      }
      ((AppBrandInitConfigLU)localObject1).cmD = true;
      localObject3 = com.tencent.mm.plugin.appbrand.report.quality.f.e(((AppBrandInitConfigWC)localObject1).kaS);
      ((iw)localObject3).ezG = iw.c.ezP;
      localObject3 = ((iw)localObject3).pa(this.lIR.bsf()).pb(this.lIR.bsg()).oY(this.lIR.bsh());
      ((iw)localObject3).ezH = iw.b.ezM;
      ((iw)localObject3).ehL = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((iw)localObject3).aLH();
      label533:
      if (this.hSZ != 0) {
        break label661;
      }
      ((AppBrandInitConfigWC)localObject1).cpm = ((WxaAttributes)localObject2).beV().kdo;
    }
    for (;;)
    {
      if (this.jGF == null) {
        this.jGF = new AppBrandStatObject();
      }
      if ((this.lIR instanceof ar)) {
        ((AppBrandInitConfigWC)localObject1).kaZ = true;
      }
      if (this.lIS.lRG != null) {
        ((AppBrandInitConfigWC)localObject1).kba = ((WeAppOpenDeclarePromptBundle)this.lIS.lRG);
      }
      if (this.lIS.lRH != null) {
        ((AppBrandInitConfigWC)localObject1).kbb = ((AppBrandRuntimeReloadReportBundle)this.lIS.lRH);
      }
      b((AppBrandInitConfigLU)localObject1, this.jGF);
      AppMethodBeat.o(47080);
      return;
      bool = false;
      break;
      label653:
      ((AppBrandInitConfigLU)localObject1).cmD = false;
      break label533;
      label661:
      ((AppBrandInitConfigWC)localObject1).extInfo = ((t)j.T(t.class)).bQ(this.appId, this.hSZ);
      try
      {
        localObject2 = com.tencent.mm.ab.h.xs(((AppBrandInitConfigWC)localObject1).extInfo);
        ((AppBrandInitConfigWC)localObject1).cpm = ((JSONObject)localObject2).optString("device_orientation");
        ((AppBrandInitConfigWC)localObject1).cmu = ((JSONObject)localObject2).optBoolean("open_remote", false);
        ((AppBrandInitConfigWC)localObject1).kaO = ((JSONObject)localObject2).optString("debug_launch_info", null);
        ((AppBrandInitConfigWC)localObject1).cmA = z.OB(((AppBrandInitConfigWC)localObject1).extInfo);
        ((JSONObject)localObject2).remove("debug_launch_info");
        ((t)j.T(t.class)).v(this.appId, this.hSZ, ((JSONObject)localObject2).toString());
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "run() process extInfo with appId[%s] versionType[%d]", new Object[] { this.appId, Integer.valueOf(this.hSZ) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void brw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */