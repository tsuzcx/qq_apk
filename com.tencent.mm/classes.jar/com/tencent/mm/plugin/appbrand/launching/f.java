package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.km;
import com.tencent.mm.g.b.a.ms;
import com.tencent.mm.g.b.a.ms.a;
import com.tencent.mm.g.b.a.ms.b;
import com.tencent.mm.g.b.a.ms.c;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.k;
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
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

public final class f
  extends e
  implements aa
{
  private final String kEY;
  private final String kHG;
  private final AppBrandLaunchFromNotifyReferrer kHI;
  private final HalfScreenConfig kHL;
  private final boolean kHM;
  private final int launchMode;
  private final boolean mQD;
  private ak mQE;
  private final LaunchParcel mQF;
  private a mQG;
  private volatile com.tencent.luggage.sdk.launching.b mQH;
  
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
    AppMethodBeat.i(227056);
    this.mQE = null;
    this.mQG = null;
    this.mQH = com.tencent.luggage.sdk.launching.b.cBB;
    this.mQF = paramLaunchParcel;
    this.kEY = paramString;
    this.kHG = paramLaunchParcel.kHG;
    this.launchMode = paramLaunchParcel.launchMode;
    this.mQG = parama1;
    this.kHI = paramLaunchParcel.kHI;
    this.mQD = paramBoolean;
    this.kHL = paramLaunchParcel.kHL;
    this.kHM = paramLaunchParcel.kHM;
    Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "<init> username[%s] appId[%s] instanceId[%s] forceUseBackupWxaAttrs[%b]", new Object[] { paramLaunchParcel.username, paramLaunchParcel.appId, paramString, Boolean.valueOf(this.mQD) });
    AppMethodBeat.o(227056);
  }
  
  private static void yg(int paramInt)
  {
    AppMethodBeat.i(227057);
    try
    {
      com.tencent.mm.plugin.report.service.h.CyF.dN(369, paramInt);
      AppMethodBeat.o(227057);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "reportFallbackIDKey key(%d) get exception %s", new Object[] { Integer.valueOf(paramInt), localThrowable });
      AppMethodBeat.o(227057);
    }
  }
  
  public final void a(com.tencent.luggage.sdk.launching.b paramb)
  {
    this.mQH = paramb;
  }
  
  protected final Pair<WxaAttributes, Boolean> bNg()
  {
    AppMethodBeat.i(47081);
    localObject1 = new Pair(null, Boolean.FALSE);
    for (;;)
    {
      try
      {
        if (j.a.vP(this.iOo))
        {
          if (this.mQD)
          {
            Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] forceUseBackupWxaAttrs[TRUE]", new Object[] { this.username, this.appId });
            yg(31);
            an.b.bV(this.kEY, 0);
            localObject3 = new aj(this.username, this.appId);
            this.mQE = ((ak)localObject3);
            localObject3 = ((ak)localObject3).bNI();
            AppMethodBeat.o(47081);
            return localObject3;
          }
          if (an.ei(this.username, this.appId))
          {
            Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
            yg(32);
            an.b.bV(this.kEY, 0);
            localObject3 = new aj(this.username, this.appId);
            this.mQE = ((ak)localObject3);
            localObject3 = ((ak)localObject3).bNI();
            AppMethodBeat.o(47081);
            return localObject3;
          }
        }
        if (this.kEH != null) {
          continue;
        }
        i = 0;
        Object localObject3 = null;
        if (1173 == i) {
          localObject3 = com.tencent.mm.plugin.appbrand.openmaterial.model.a.ado(this.mQF.ldR);
        }
        localObject3 = new bc(this.username, this.appId, this.iOo, this.pkgVersion, i, this.kHw, this.kEH, this.cys, this.kEY, this.kHI, (String)localObject3, new aa.f()
        {
          public final void bAm()
          {
            AppMethodBeat.i(174931);
            if (f.a(f.this) != null) {
              f.a(f.this).bto();
            }
            AppMethodBeat.o(174931);
          }
        }, this.mQH);
        this.mQE = ((ak)localObject3);
        localObject3 = ((ak)localObject3).bNI();
        localObject1 = localObject3;
      }
      catch (TimeoutException localTimeoutException)
      {
        Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes timeout with username[%s] appId[%s] step[%s]", new Object[] { this.username, this.appId, this.mQE.name() });
        long l2 = this.mQE.bNH();
        if ((!j.a.vP(this.iOo)) || (!an.bNJ())) {
          continue;
        }
        Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
        try
        {
          an.b.bV(this.kEY, 0);
          localObject4 = new aj(this.username, this.appId);
          this.mQE = ((ak)localObject4);
          localObject4 = ((ak)localObject4).bNI();
          try
          {
            yg(33);
            localObject1 = (WxaAttributes)((Pair)localObject4).first;
            if (localObject1 != null)
            {
              km localkm = new km();
              localkm.xO(((WxaAttributes)localObject1).field_appId);
              localkm.xP(((WxaAttributes)localObject1).field_username);
              if (this.kEH != null) {
                continue;
              }
              l1 = 0L;
              localkm.eWc = l1;
              localkm.eWd = 0L;
              localkm.eWe = ((WxaAttributes)localObject1).bAp().appVersion;
              localkm.eWj = 0L;
              localkm.eWk = l2;
              localkm.xQ(i.getNetworkType(MMApplicationContext.getContext()));
              localkm.eWi = 0L;
              localkm.xR(this.kEY);
              localkm.bfK();
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
        int i = this.kEH.scene;
        l1 = i;
        continue;
        Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes fallback with username[%s] appId[%s], get exception[%s]", new Object[] { this.username, this.appId, localObject4 });
        ax.a(MMApplicationContext.getContext().getString(2131755621, new Object[] { "" }), this);
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
      i = this.kEH.scene;
    }
  }
  
  public final boolean bNh()
  {
    return this.mQF.cyz != com.tencent.luggage.sdk.launching.b.cBC;
  }
  
  protected final boolean g(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47082);
    String str = paramWxaAttributes.field_appId;
    if (new au(str).bNK())
    {
      AppMethodBeat.o(47082);
      return true;
    }
    if (2 == this.iOo)
    {
      if (this.mQG != null) {
        this.mQG.bto();
      }
      if (!bd.a(str, com.tencent.mm.plugin.appbrand.task.h.bWb().afi(str), this))
      {
        AppMethodBeat.o(47082);
        return true;
      }
    }
    if ((this.iOo == 0) && (!bd.a(paramWxaAttributes, this.mQC)))
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
    Object localObject3 = bNg();
    Object localObject2 = (WxaAttributes)((Pair)localObject3).first;
    if (localObject2 == null)
    {
      Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
      localObject1 = new ms().zW(this.kEY).zX(this.appId);
      ((ms)localObject1).eXc = this.pkgVersion;
      ((ms)localObject1).fec = ms.a.mD(this.iOo + 1);
      ((ms)localObject1).eYW = 0L;
      ((ms)localObject1).erW = this.kEH.scene;
      ((ms)localObject1).fed = ms.c.fen;
      ((ms)localObject1).fee = ms.b.fej;
      ((ms)localObject1).eJb = com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
      ((ms)localObject1).eoK = ((ms)localObject1).x("UserName", this.username, true);
      ((ms)localObject1).wL(this.mQE.bNF()).wM(this.mQE.bNG()).wJ(this.mQE.bNH()).bfK();
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
    Object localObject1 = com.tencent.mm.plugin.appbrand.config.h.bzT().c((WxaAttributes)localObject2);
    ((AppBrandInitConfigWC)localObject1).eix = this.iOo;
    ((AppBrandInitConfigWC)localObject1).kHG = this.kHG;
    ((AppBrandInitConfigWC)localObject1).launchMode = this.launchMode;
    ((AppBrandInitConfigWC)localObject1).leb = ((WxaAttributes)localObject2).bAo().lgD.leb;
    ((AppBrandInitConfigWC)localObject1).lec = ((WxaAttributes)localObject2).bAo().lgD.lec;
    ((AppBrandInitConfigWC)localObject1).kHI = this.kHI;
    ((AppBrandInitConfigWC)localObject1).kHL = this.kHL;
    ((AppBrandInitConfigWC)localObject1).kHM = this.kHM;
    ((AppBrandInitConfigWC)localObject1).ldR = this.mQF.ldR;
    ((AppBrandInitConfigWC)localObject1).ldQ = this.mQF.ldQ;
    ((AppBrandInitConfigWC)localObject1).kHQ = this.mQF.kHQ;
    this.appId = ((AppBrandInitConfigWC)localObject1).appId;
    Object localObject4 = (com.tencent.mm.plugin.appbrand.ui.c.a.b)n.W(com.tencent.mm.plugin.appbrand.ui.c.a.b.class);
    kotlin.g.b.p.h(localObject1, "initConfigWC");
    if (((AppBrandInitConfigWC)localObject1).ldN) {
      ((AppBrandInitConfigWC)localObject1).lea = ((com.tencent.mm.plugin.appbrand.ui.c.a.b)localObject4).a(((AppBrandInitConfigWC)localObject1).appId, ((AppBrandInitConfig)localObject1).eix, ((AppBrandInitConfigWC)localObject1).appVersion, ao.isDarkMode());
    }
    ((AppBrandInitConfigWC)localObject1).ldZ = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ClientBenchmarkLevel", -1);
    ((AppBrandInitConfigWC)localObject1).ldW = new QualitySession(this.kEY, (AppBrandInitConfigWC)localObject1, this.kEH);
    localObject4 = ((AppBrandInitConfigWC)localObject1).ldW;
    boolean bool;
    if (!((k)n.W(k.class)).Wt(this.username))
    {
      bool = true;
      ((QualitySession)localObject4).nLm = bool;
      ((AppBrandInitConfigWC)localObject1).dC(this.kEY);
      if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
        break label702;
      }
      ((AppBrandInitConfigLU)localObject1).cyy = true;
      localObject3 = com.tencent.mm.plugin.appbrand.report.quality.g.d(((AppBrandInitConfigWC)localObject1).ldW);
      ((ms)localObject3).fed = ms.c.fem;
      localObject3 = ((ms)localObject3).wL(this.mQE.bNF()).wM(this.mQE.bNG()).wJ(this.mQE.bNH());
      ((ms)localObject3).fee = ms.b.fej;
      ((ms)localObject3).eJb = com.tencent.mm.plugin.appbrand.report.quality.g.getNetworkType();
      ((ms)localObject3).bfK();
      label582:
      if (this.iOo != 0) {
        break label710;
      }
      ((AppBrandInitConfigWC)localObject1).cBG = ((WxaAttributes)localObject2).bAp().lgT;
    }
    for (;;)
    {
      if (this.kEH == null) {
        this.kEH = new AppBrandStatObject();
      }
      if ((this.mQE instanceof aj)) {
        ((AppBrandInitConfigWC)localObject1).led = true;
      }
      if (this.mQF.mYQ != null) {
        ((AppBrandInitConfigWC)localObject1).lee = ((WeAppOpenDeclarePromptBundle)this.mQF.mYQ);
      }
      if (this.mQF.mYR != null) {
        ((AppBrandInitConfigWC)localObject1).lef = ((AppBrandRuntimeReloadReportBundle)this.mQF.mYR);
      }
      a((AppBrandInitConfigLU)localObject1, this.kEH);
      AppMethodBeat.o(47080);
      return;
      bool = false;
      break;
      label702:
      ((AppBrandInitConfigLU)localObject1).cyy = false;
      break label582;
      label710:
      ((AppBrandInitConfigWC)localObject1).extInfo = ((t)n.W(t.class)).bU(this.appId, this.iOo);
      try
      {
        localObject2 = com.tencent.mm.ab.h.FE(((AppBrandInitConfigWC)localObject1).extInfo);
        ((AppBrandInitConfigWC)localObject1).cBG = ((JSONObject)localObject2).optString("device_orientation");
        ((AppBrandInitConfigWC)localObject1).cyp = ((JSONObject)localObject2).optBoolean("open_remote", false);
        ((AppBrandInitConfigWC)localObject1).ldS = ((JSONObject)localObject2).optString("debug_launch_info", null);
        ((AppBrandInitConfigWC)localObject1).cyv = ac.XM(((AppBrandInitConfigWC)localObject1).extInfo);
        ((JSONObject)localObject2).remove("debug_launch_info");
        ((t)n.W(t.class)).A(this.appId, this.iOo, ((JSONObject)localObject2).toString());
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "run() process extInfo with appId[%s] versionType[%d]", new Object[] { this.appId, Integer.valueOf(this.iOo) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bto();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */