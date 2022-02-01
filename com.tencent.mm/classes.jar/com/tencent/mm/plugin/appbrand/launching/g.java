package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.qz;
import com.tencent.mm.autogen.mmdata.rpt.tk;
import com.tencent.mm.autogen.mmdata.rpt.tk.a;
import com.tencent.mm.autogen.mmdata.rpt.tk.b;
import com.tencent.mm.autogen.mmdata.rpt.tk.c;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.c.a;
import com.tencent.mm.plugin.appbrand.config.ag.f;
import com.tencent.mm.plugin.appbrand.config.aj;
import com.tencent.mm.plugin.appbrand.keylogger.c;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.concurrent.TimeoutException;
import kotlin.g.b.s;
import org.json.JSONObject;

public final class g
  extends f
  implements aa
{
  private final String eup;
  private final String icX;
  private final int launchMode;
  private final AppBrandLaunchFromNotifyReferrer qAQ;
  private final HalfScreenConfig qAT;
  private final boolean sWm;
  private af sWn;
  public final LaunchParcel sWo;
  private a sWp;
  public volatile e sWq;
  
  public g(LaunchParcel paramLaunchParcel, String paramString, f.a<AppBrandInitConfigWC> parama, a parama1)
  {
    this(paramLaunchParcel, paramString, false, parama, parama1);
  }
  
  g(LaunchParcel paramLaunchParcel, String paramString, boolean paramBoolean, f.a<AppBrandInitConfigWC> parama)
  {
    this(paramLaunchParcel, paramString, paramBoolean, parama, null);
  }
  
  private g(LaunchParcel paramLaunchParcel, String paramString, boolean paramBoolean, f.a<AppBrandInitConfigWC> parama, a parama1)
  {
    super(paramLaunchParcel, parama);
    AppMethodBeat.i(320819);
    this.sWn = null;
    this.sWp = null;
    this.sWq = e.etI;
    this.sWo = paramLaunchParcel;
    this.eup = paramString;
    this.icX = paramLaunchParcel.icX;
    this.launchMode = paramLaunchParcel.launchMode;
    this.sWp = parama1;
    this.qAQ = paramLaunchParcel.qAQ;
    this.sWm = paramBoolean;
    this.qAT = paramLaunchParcel.qAT;
    Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "<init> username[%s] appId[%s] instanceId[%s] forceUseBackupWxaAttrs[%b]", new Object[] { paramLaunchParcel.username, paramLaunchParcel.appId, paramString, Boolean.valueOf(this.sWm) });
    AppMethodBeat.o(320819);
  }
  
  private static void BT(int paramInt)
  {
    AppMethodBeat.i(320822);
    try
    {
      com.tencent.mm.plugin.report.service.h.OAn.kJ(369, paramInt);
      AppMethodBeat.o(320822);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "reportFallbackIDKey key(%d) get exception %s", new Object[] { Integer.valueOf(paramInt), localObject });
      AppMethodBeat.o(320822);
    }
  }
  
  protected final Pair<WxaAttributes, Boolean> czI()
  {
    AppMethodBeat.i(47081);
    localObject1 = new Pair(null, Boolean.FALSE);
    for (;;)
    {
      try
      {
        if (k.a.zn(this.euz))
        {
          if (this.sWm)
          {
            Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] forceUseBackupWxaAttrs[TRUE]", new Object[] { this.username, this.appId });
            BT(31);
            ai.b.cS(this.eup, 0);
            localObject4 = new ae(this.username, this.appId);
            this.sWn = ((af)localObject4);
            localObject4 = ((af)localObject4).cAm();
            AppMethodBeat.o(47081);
            return localObject4;
          }
          if (ai.eM(this.username, this.appId))
          {
            Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
            BT(32);
            ai.b.cS(this.eup, 0);
            localObject4 = new ae(this.username, this.appId);
            this.sWn = ((af)localObject4);
            localObject4 = ((af)localObject4).cAm();
            AppMethodBeat.o(47081);
            return localObject4;
          }
        }
        if (this.qxv != null) {
          continue;
        }
        i = 0;
        Object localObject4 = null;
        if (1173 == i) {
          localObject4 = com.tencent.mm.plugin.appbrand.openmaterial.model.a.aeq(this.sWo.qYh);
        }
        localObject4 = new bc(this.username, this.appId, this.euz, this.pkgVersion, i, this.qAF, this.qxv, this.eoV, this.eup, this.qAQ, (String)localObject4, new ag.f()
        {
          public final void clc()
          {
            AppMethodBeat.i(174931);
            if (g.a(g.this) != null) {
              g.a(g.this).showPrompt();
            }
            AppMethodBeat.o(174931);
          }
        }, this.sWq);
        this.sWn = ((af)localObject4);
        localObject4 = ((af)localObject4).cAm();
        localObject1 = localObject4;
      }
      catch (TimeoutException localTimeoutException)
      {
        Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes timeout with username[%s] appId[%s] step[%s]", new Object[] { this.username, this.appId, this.sWn.name() });
        long l2 = this.sWn.cAl();
        if ((!k.a.zn(this.euz)) || (!ai.cAo())) {
          continue;
        }
        Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() username[%s] appId[%s] checkIfUseBackupWxaAttrsForLaunchDirectly[TRUE]", new Object[] { this.username, this.appId });
        try
        {
          ai.b.cS(this.eup, 0);
          localObject5 = new ae(this.username, this.appId);
          this.sWn = ((af)localObject5);
          localObject5 = ((af)localObject5).cAm();
          try
          {
            BT(33);
            localObject1 = (WxaAttributes)((Pair)localObject5).first;
            if (localObject1 != null)
            {
              qz localqz = new qz();
              localqz.xV(((WxaAttributes)localObject1).field_appId);
              localqz.xW(((WxaAttributes)localObject1).field_username);
              if (this.qxv != null) {
                continue;
              }
              l1 = 0L;
              localqz.juq = l1;
              localqz.jur = 0L;
              localqz.jus = ((WxaAttributes)localObject1).clf().appVersion;
              localqz.jux = 0L;
              localqz.juy = l2;
              localqz.xX(com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext()));
              localqz.juw = 0L;
              localqz.xY(this.eup);
              localqz.bMH();
            }
          }
          finally
          {
            try
            {
              long l1;
              Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes() report fallback get exception %s", new Object[] { localObject2 });
            }
            catch (Exception localException3)
            {
              localObject3 = localObject5;
              localObject5 = localException3;
            }
          }
          AppMethodBeat.o(47081);
          return localObject5;
        }
        catch (Exception localException2)
        {
          Object localObject5;
          Object localObject3;
          continue;
        }
        int i = this.qxv.scene;
        l1 = i;
        continue;
        Log.e("MicroMsg.AppBrandPreLaunchProcessWC", "prepareStepCheckWxaAttributes fallback with username[%s] appId[%s], get exception[%s]", new Object[] { this.username, this.appId, localObject5 });
        ax.a(MMApplicationContext.getContext().getString(ba.i.app_brand_preparing_attr_sync_timeout, new Object[] { "" }), this);
        AppMethodBeat.o(47081);
        return localObject3;
        continue;
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException1, "get attr ", new Object[0]);
        continue;
      }
      AppMethodBeat.o(47081);
      return localObject1;
      i = this.qxv.scene;
    }
  }
  
  public final boolean czJ()
  {
    AppMethodBeat.i(320828);
    if (!this.sWo.epm.arX())
    {
      AppMethodBeat.o(320828);
      return true;
    }
    AppMethodBeat.o(320828);
    return false;
  }
  
  protected final boolean i(WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(47082);
    String str = paramWxaAttributes.field_appId;
    if (new au(str).cAp())
    {
      AppMethodBeat.o(47082);
      return true;
    }
    if (2 == this.euz)
    {
      if (this.sWp != null) {
        this.sWp.showPrompt();
      }
      if (!bd.a(str, i.cJV().fA(str), this))
      {
        AppMethodBeat.o(47082);
        return true;
      }
    }
    if ((this.euz == 0) && (!bd.a(paramWxaAttributes, this.sWl)))
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
    Object localObject3 = czI();
    Object localObject2 = (WxaAttributes)((Pair)localObject3).first;
    if (localObject2 == null)
    {
      Log.i("MicroMsg.AppBrandPreLaunchProcessWC", "onGetWxaAttr null return");
      localObject1 = new tk().zO(this.eup).zP(this.appId);
      ((tk)localObject1).ind = this.pkgVersion;
      ((tk)localObject1).jCT = tk.a.pa(this.euz + 1);
      ((tk)localObject1).jax = 0L;
      ((tk)localObject1).iqr = this.qxv.scene;
      ((tk)localObject1).jCU = tk.c.jDf;
      ((tk)localObject1).jCV = tk.b.jDb;
      ((tk)localObject1).iVU = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((tk)localObject1).irj = ((tk)localObject1).F("UserName", this.username, true);
      ((tk)localObject1).gm(this.sWn.cAj()).gn(this.sWn.cAk()).gl(this.sWn.cAl()).zQ(com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext())).bMH();
      atR();
      AppMethodBeat.o(47080);
      return;
    }
    if (i((WxaAttributes)localObject2))
    {
      c.c(((WxaAttributes)localObject2).field_appId, KSProcessWeAppLaunch.stepCheckBan);
      atR();
      AppMethodBeat.o(47080);
      return;
    }
    c.b(((WxaAttributes)localObject2).field_appId, KSProcessWeAppLaunch.stepCheckBan);
    this.username = ((WxaAttributes)localObject2).field_username;
    Object localObject1 = b.sVC;
    b.a(this.eup, this.username, ((WxaAttributes)localObject2).cle().rbR.rcf, this.euz);
    localObject1 = com.tencent.mm.plugin.appbrand.config.h.ckG().b((WxaAttributes)localObject2);
    ((AppBrandInitConfigWC)localObject1).eul = this.euz;
    ((AppBrandInitConfigWC)localObject1).icX = this.icX;
    ((AppBrandInitConfigWC)localObject1).launchMode = this.launchMode;
    int i;
    boolean bool;
    if (((WxaAttributes)localObject2).cld() != null)
    {
      i = ((WxaAttributes)localObject2).cld().nOX;
      ((AppBrandInitConfigWC)localObject1).nOX = i;
      ((AppBrandInitConfigWC)localObject1).qYr = ((WxaAttributes)localObject2).cle().rbR.qYr;
      ((AppBrandInitConfigWC)localObject1).qAQ = this.qAQ;
      ((AppBrandInitConfigWC)localObject1).qAT = this.qAT;
      ((AppBrandInitConfigWC)localObject1).qYh = this.sWo.qYh;
      ((AppBrandInitConfigWC)localObject1).qYg = this.sWo.qYg;
      ((AppBrandInitConfigWC)localObject1).qAX = this.sWo.qAX;
      ((AppBrandInitConfigWC)localObject1).qBa = this.sWo.qBa;
      ((AppBrandInitConfigWC)localObject1).qYy = this.sWo.qYy;
      ((AppBrandInitConfigWC)localObject1).epk = com.tencent.mm.ce.b.iRp();
      ((AppBrandInitConfigWC)localObject1).epi = ((d)com.tencent.mm.kernel.h.ax(d.class)).aBu();
      this.appId = ((AppBrandInitConfigWC)localObject1).appId;
      Object localObject4 = (com.tencent.mm.plugin.appbrand.ui.b.a.b)n.ag(com.tencent.mm.plugin.appbrand.ui.b.a.b.class);
      s.u(localObject1, "initConfigWC");
      if (((AppBrandInitConfigWC)localObject1).qYd) {
        ((AppBrandInitConfigWC)localObject1).qYq = ((com.tencent.mm.plugin.appbrand.ui.b.a.b)localObject4).a(((AppBrandInitConfigWC)localObject1).appId, ((AppBrandInitConfig)localObject1).eul, ((AppBrandInitConfigWC)localObject1).appVersion, aw.isDarkMode());
      }
      ((AppBrandInitConfigWC)localObject1).qYp = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("ClientBenchmarkLevel", -1);
      ((AppBrandInitConfigWC)localObject1).qYm = new QualitySession(this.eup, (AppBrandInitConfigWC)localObject1, this.qxv);
      localObject4 = ((AppBrandInitConfigWC)localObject1).qYm;
      if (((com.tencent.mm.plugin.appbrand.appusage.j)n.ag(com.tencent.mm.plugin.appbrand.appusage.j.class)).WI(this.username)) {
        break label814;
      }
      bool = true;
      label571:
      ((QualitySession)localObject4).tSj = bool;
      ((AppBrandInitConfigWC)localObject1).fk(this.eup);
      if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
        break label819;
      }
      ((AppBrandInitConfigLU)localObject1).epl = true;
      localObject3 = com.tencent.mm.plugin.appbrand.report.quality.f.d(((AppBrandInitConfigWC)localObject1).qYm);
      ((tk)localObject3).jCU = tk.c.jDe;
      localObject3 = ((tk)localObject3).gm(this.sWn.cAj()).gn(this.sWn.cAk()).gl(this.sWn.cAl());
      ((tk)localObject3).jCV = tk.b.jDb;
      ((tk)localObject3).iVU = com.tencent.mm.plugin.appbrand.report.quality.f.getNetworkType();
      ((tk)localObject3).zQ(com.tencent.mm.plugin.appbrand.report.j.getNetworkType(MMApplicationContext.getContext())).bMH();
      label693:
      if (this.euz != 0) {
        break label827;
      }
      ((AppBrandInitConfigWC)localObject1).euP = ((WxaAttributes)localObject2).clf().rcm;
    }
    for (;;)
    {
      if (this.qxv == null) {
        this.qxv = new AppBrandStatObject();
      }
      if ((this.sWn instanceof ae)) {
        ((AppBrandInitConfigWC)localObject1).qYs = true;
      }
      if (this.sWo.tec != null) {
        ((AppBrandInitConfigWC)localObject1).qYt = ((WeAppOpenDeclarePromptBundle)this.sWo.tec);
      }
      if (this.sWo.ted != null) {
        ((AppBrandInitConfigWC)localObject1).qYu = ((AppBrandRuntimeReloadReportBundle)this.sWo.ted);
      }
      b((AppBrandInitConfigLU)localObject1, this.qxv);
      AppMethodBeat.o(47080);
      return;
      i = 0;
      break;
      label814:
      bool = false;
      break label571;
      label819:
      ((AppBrandInitConfigLU)localObject1).epl = false;
      break label693;
      label827:
      ((AppBrandInitConfigWC)localObject1).extInfo = ((t)n.ag(t.class)).cR(this.appId, this.euz);
      try
      {
        localObject2 = com.tencent.mm.ad.h.Fn(((AppBrandInitConfigWC)localObject1).extInfo);
        ((AppBrandInitConfigWC)localObject1).euP = ((JSONObject)localObject2).optString("device_orientation");
        ((AppBrandInitConfigWC)localObject1).eoX = ((JSONObject)localObject2).optBoolean("open_remote", false);
        ((AppBrandInitConfigWC)localObject1).qYi = ((JSONObject)localObject2).optString("debug_launch_info", null);
        ((AppBrandInitConfigWC)localObject1).epa = aj.Ya(((AppBrandInitConfigWC)localObject1).extInfo);
        if (TextUtils.isEmpty(((AppBrandInitConfigWC)localObject1).epa.rcl))
        {
          localObject3 = n.cfm().c(this.appId, this.euz, new String[] { "versionMd5" });
          if (localObject3 != null) {
            ((AppBrandInitConfigWC)localObject1).epa.rcl = ((bh)localObject3).field_versionMd5;
          }
        }
        ((JSONObject)localObject2).remove("debug_launch_info");
        ((t)n.ag(t.class)).D(this.appId, this.euz, ((JSONObject)localObject2).toString());
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcessWC", localException, "run() process extInfo with appId[%s] versionType[%d]", new Object[] { this.appId, Integer.valueOf(this.euz) });
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void showPrompt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g
 * JD-Core Version:    0.7.0.1
 */