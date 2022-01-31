package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.wk;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.b.a.cr;
import com.tencent.mm.model.ai;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appstorage.c.a;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.j.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.protobuf.azj;
import com.tencent.mm.protocal.protobuf.se;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.vending.j.b;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class g
  implements ILaunchWxaAppInfoNotify
{
  private static final android.support.v4.e.a<String, g> ikE;
  private static final as ikF;
  private static final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> ikU;
  final String appId;
  private final boolean bAa;
  final int cJb;
  final int cxS;
  final int hcr;
  private final QualitySession hiI;
  final String hiw;
  final AppBrandLaunchReferrer hiz;
  volatile g.b ikG;
  volatile boolean ikH;
  volatile com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> ikI;
  volatile long ikJ;
  final String ikK;
  final int ikL;
  private final WxaAttributes.WxaVersionInfo ikM;
  private boolean ikN;
  private final AppStartupPerformanceReportBundle ikO;
  private final List<kv_14609> ikP;
  private final com.tencent.mm.sdk.b.c<ja> ikQ;
  private final List<cr> ikR;
  private final com.tencent.mm.sdk.b.c<wk> ikS;
  private final com.tencent.mm.sdk.b.c<wl> ikT;
  volatile boolean started;
  final String username;
  
  static
  {
    AppMethodBeat.i(131801);
    ikE = new android.support.v4.e.a();
    ikF = as.eu("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", 2);
    ikU = com.tencent.mm.vending.j.a.i(null, null, null);
    AppMethodBeat.o(131801);
  }
  
  public g(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this(paramAppBrandInitConfigWC.username, paramAppBrandInitConfigWC.appId, paramAppBrandInitConfigWC.gXd, paramAppBrandStatObject.cJb, paramAppBrandStatObject.scene, paramAppBrandInitConfigWC.hiw, paramAppBrandInitConfigWC.hiz, paramAppBrandInitConfigWC.vZ(), -1, paramAppBrandInitConfigWC.bDe, paramAppBrandInitConfigWC.vY(), paramAppBrandInitConfigWC.hiI);
    AppMethodBeat.i(131789);
    AppMethodBeat.o(131789);
  }
  
  public g(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, int paramInt4, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(143443);
    this.ikJ = -1L;
    this.ikN = false;
    this.ikP = new CopyOnWriteArrayList();
    this.ikQ = new g.1(this);
    this.ikR = new CopyOnWriteArrayList();
    this.ikS = new g.2(this);
    this.ikT = new g.3(this);
    this.username = paramString1;
    this.appId = paramString2;
    this.hcr = paramInt1;
    this.cJb = paramInt2;
    this.cxS = paramInt3;
    this.hiw = paramString3;
    this.hiz = paramAppBrandLaunchReferrer;
    this.ikK = paramString4;
    this.ikL = paramInt4;
    if (paramWxaVersionInfo == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> NULL wxaVersionInfo, username[%s] appId[%s]", new Object[] { paramString1, paramString2 });
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString3 = com.tencent.mm.plugin.appbrand.app.g.auF().d(paramString1, new String[] { "versionInfo" });
        if (paramString3 == null) {
          break label309;
        }
        paramString3 = paramString3.ayE();
      }
    }
    for (;;)
    {
      label191:
      this.ikM = paramString3;
      if (this.ikM == null) {}
      for (paramInt1 = -1;; paramInt1 = this.ikM.bDc)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> wxaVersionInfo username[%s] appId[%s] version[%d]", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt1) });
        this.bAa = paramBoolean;
        this.hiI = paramQualitySession;
        this.ikO = new AppStartupPerformanceReportBundle(paramQualitySession.ikX);
        if (paramBoolean) {
          s.yp(paramString2);
        }
        AppMethodBeat.o(143443);
        return;
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString3 = com.tencent.mm.plugin.appbrand.app.g.auF().e(paramString2, new String[] { "versionInfo" });
          break;
        }
        paramString3 = null;
        break;
        label309:
        paramString3 = null;
        break label191;
      }
      paramString3 = paramWxaVersionInfo;
    }
  }
  
  static g Dk(String paramString)
  {
    AppMethodBeat.i(131787);
    synchronized (ikE)
    {
      g localg = (g)ikE.remove(paramString);
      if (localg != null) {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s)", new Object[] { localg.appId, Integer.valueOf(localg.hcr), paramString });
      }
      AppMethodBeat.o(131787);
      return localg;
    }
  }
  
  static g Dl(String paramString)
  {
    AppMethodBeat.i(131788);
    synchronized (ikE)
    {
      paramString = (g)ikE.get(paramString);
      AppMethodBeat.o(131788);
      return paramString;
    }
  }
  
  private void aGO()
  {
    AppMethodBeat.i(131796);
    Object localObject = new StringBuilder("transferData   callback != null ");
    if (this.ikG != null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", bool);
      localObject = new Timer();
      ((Timer)localObject).schedule(new g.8(this), 5000L);
      if (this.ikG != null)
      {
        this.ikG.ng(1);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START ");
      }
      com.tencent.mm.plugin.appbrand.appstorage.c localc = new com.tencent.mm.plugin.appbrand.appstorage.c(this.appId);
      int i = 0;
      while (i <= 0)
      {
        ai localai = new ai[] { localc }[0];
        if (localai.kv(com.tencent.mm.protocal.d.whH)) {
          localai.transfer(com.tencent.mm.protocal.d.whH);
        }
        i += 1;
      }
    }
    ((Timer)localObject).cancel();
    if (this.ikG != null)
    {
      this.ikG.ng(2);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH ");
    }
    AppMethodBeat.o(131796);
  }
  
  private void b(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(143444);
    com.tencent.mm.sdk.platformtools.ab.v("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process", new Object[] { this.appId, Integer.valueOf(this.hcr) });
    a(paramd);
    paramd = (com.tencent.mm.plugin.appbrand.config.h)paramd.get(0);
    String str = this.appId;
    int i = this.hcr;
    int j = this.cxS;
    if (paramd != null) {}
    for (boolean bool = true;; bool = false)
    {
      LaunchBroadCast.a(str, i, j, bool);
      AppMethodBeat.o(143444);
      return;
    }
  }
  
  private void oD(int paramInt)
  {
    AppMethodBeat.i(155924);
    if (this.ikN)
    {
      AppMethodBeat.o(155924);
      return;
    }
    if (!"wxb6d22f922f37b35a".equals(this.appId))
    {
      AppMethodBeat.o(155924);
      return;
    }
    if (!j.a.nk(this.hcr))
    {
      AppMethodBeat.o(155924);
      return;
    }
    this.ikN = true;
    com.tencent.mm.plugin.report.service.h.qsU.cT(1089, paramInt);
    String str = this.appId;
    if (this.ikM == null) {}
    for (int i = 0;; i = this.ikM.bDc)
    {
      com.tencent.mm.plugin.appbrand.report.e.b(str, i, this.hcr, 1089, paramInt);
      AppMethodBeat.o(155924);
      return;
    }
  }
  
  final void a(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(131791);
    this.ikI = paramd;
    if (this.ikG != null)
    {
      this.ikG.a((AppBrandSysConfigWC)paramd.get(0), (AppBrandLaunchErrorAction)paramd.get(1), (AppStartupPerformanceReportBundle)paramd.get(2));
      Dk(this.ikK);
    }
    AppMethodBeat.o(131791);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, ab paramab)
  {
    AppMethodBeat.i(131792);
    if (this.ikI != null)
    {
      paramString2 = AppBrandLaunchErrorAction.CREATOR;
      paramString2 = AppBrandLaunchErrorAction.a.a(this.appId, this.hcr, paramab);
      if (paramString2 != null)
      {
        this.ikI = com.tencent.mm.vending.j.a.i(null, paramString2, this.ikO);
        AppMethodBeat.o(131792);
        return;
      }
      paramString2 = (AppBrandSysConfigWC)this.ikI.get(0);
      if (paramString2 == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(131792);
        return;
      }
      paramab.a(paramString2);
      this.ikI = com.tencent.mm.vending.j.a.i(paramString2, null, this.ikO);
    }
    AppMethodBeat.o(131792);
  }
  
  public final void aGK()
  {
    AppMethodBeat.i(131793);
    if (this.started)
    {
      AppMethodBeat.o(131793);
      return;
    }
    this.started = true;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm appId[%s] type[%d] scene[%d]", new Object[] { this.appId, Integer.valueOf(this.hcr), Integer.valueOf(this.cxS) });
    synchronized (ikE)
    {
      ikE.put(this.ikK, this);
      ??? = new g.a(this.ikK);
      long l = TimeUnit.SECONDS.toMillis(300L);
      ((ap)???).ag(l, l);
      if (this.ikM == null)
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "startPrepare() NULL wxaVersionInfo username[%s], appId[%s]", new Object[] { this.username, this.appId });
        ah.oH(2131296726);
        b(ikU);
        AppMethodBeat.o(131793);
        return;
      }
    }
    ??? = com.tencent.mm.sdk.g.d.aqu(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[] { this.appId, Integer.valueOf(this.hcr) }));
    ((HandlerThread)???).start();
    new com.tencent.mm.sdk.platformtools.ak(((HandlerThread)???).getLooper()).post(new g.4(this, (HandlerThread)???));
    AppMethodBeat.o(131793);
  }
  
  public final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> aGM()
  {
    AppMethodBeat.i(131794);
    Object localObject1 = q.An(this.appId);
    if (localObject1 == null) {
      ah.Do(com.tencent.mm.plugin.appbrand.t.e.getMMString(2131296787, new Object[] { "" }));
    }
    if (localObject1 == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!");
      localObject1 = ikU;
      AppMethodBeat.o(131794);
      return localObject1;
    }
    ((k)com.tencent.mm.plugin.appbrand.app.g.w(k.class)).E(q.As(this.appId), bo.aox());
    j localj = new j();
    this.ikQ.alive();
    Object localObject3;
    Object localObject2;
    int i;
    if (this.hcr == 0)
    {
      this.ikS.alive();
      localObject3 = new g.5(this, ((AppBrandSysConfigWC)localObject1).appId, this.hcr, this.hiw, this.cxS, this.ikM, this.bAa);
      localObject2 = new FutureTask((Callable)localObject3);
      com.tencent.mm.sdk.g.d.ysm.a((Runnable)localObject2, ((ag)localObject3).getTag(), new ag.1((ag)localObject3, (FutureTask)localObject2));
      localObject3 = (ab)new g.6(this, this.appId, this.hcr, this.cJb, this.cxS, this.hiw, this.hiz, this.ikK, this.ikL, this.hiI).aHg();
      if (localObject3 != null) {
        break label343;
      }
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", new Object[] { this.username, this.appId });
      i = 0;
    }
    for (;;)
    {
      if (i == 0)
      {
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", new Object[] { this.username, this.appId });
        localObject1 = com.tencent.mm.vending.j.a.i(null, localj.value, this.ikO);
        AppMethodBeat.o(131794);
        return localObject1;
        this.ikT.alive();
        break;
        label343:
        Object localObject4 = AppBrandLaunchErrorAction.CREATOR;
        localObject4 = AppBrandLaunchErrorAction.a.a(this.appId, this.hcr, (ab)localObject3);
        if (localObject4 != null)
        {
          localj.value = localObject4;
          oD(54);
          com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", new Object[] { this.username, this.appId, Integer.valueOf(((ab)localObject3).field_launchAction.wld) });
          i = 0;
        }
        else
        {
          this.ikO.ila = ((ab)localObject3).imf;
          if ((((ab)localObject3).field_jsapiInfo == null) || (((ab)localObject3).field_jsapiInfo.wKA == null))
          {
            oD(54);
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", new Object[] { this.username, this.appId });
            i = 0;
          }
          else
          {
            ((ab)localObject3).a((AppBrandSysConfigWC)localObject1);
            boolean bool;
            if (((ab)localObject3).field_launchAction.xoG)
            {
              com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
              if (!com.tencent.mm.kernel.g.RL().Ru().getBoolean(ac.a.yDh, false))
              {
                bool = true;
                label537:
                ((AppBrandSysConfigWC)localObject1).bDl = bool;
                com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDh, Boolean.TRUE);
              }
            }
            for (;;)
            {
              localObject2 = (WxaPkgWrappingInfo)((Future)localObject2).get();
              this.ikH = true;
              aGN();
              this.ikQ.dead();
              this.ikS.dead();
              this.ikT.dead();
              this.ikO.ikY.addAll(this.ikR);
              this.ikO.ikZ.addAll(this.ikP);
              if (localObject2 != null) {
                break label690;
              }
              oD(55);
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", new Object[] { this.username, this.appId });
              i = 0;
              break;
              bool = false;
              break label537;
              ((AppBrandSysConfigWC)localObject1).bDl = false;
            }
            label690:
            ((AppBrandSysConfigWC)localObject1).hiX = ((WxaPkgWrappingInfo)localObject2);
            if (((AppBrandSysConfigWC)localObject1).hiX.gXe != 0) {
              ((AppBrandSysConfigWC)localObject1).hiX.gXf = 0;
            }
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, app pkg %s", new Object[] { this.username, ((AppBrandSysConfigWC)localObject1).appId, ((AppBrandSysConfigWC)localObject1).hiX });
            label777:
            label789:
            long l;
            if (com.tencent.mm.plugin.appbrand.ui.recommend.e.bz(this.appId, this.hcr))
            {
              if (this.ikJ <= 0L)
              {
                i = 1;
                localObject2 = com.tencent.mm.plugin.report.service.h.qsU;
                if (i == 0) {
                  break label996;
                }
                i = 53;
                ((com.tencent.mm.plugin.report.service.h)localObject2).cT(1089, i);
              }
            }
            else
            {
              ((AppBrandSysConfigWC)localObject1).bDI = AppBrandGlobalSystemConfig.ayt();
              ((AppBrandSysConfigWC)localObject1).bDJ = com.tencent.mm.plugin.appbrand.app.g.wg().get("key_sendtodesktop_no_more_show_permission_notify_dialog", "0").equals("1");
              localObject2 = f.irL;
              localObject2 = f.cK(this.appId, "copypath");
              if (localObject2 != null) {
                break label1002;
              }
              l = 0L;
              label853:
              ((AppBrandSysConfigWC)localObject1).bDH = l;
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + ((AppBrandSysConfigWC)localObject1).bDH);
              com.tencent.mm.sdk.g.d.ysm.b(new g.7(this), "AppLaunchPrepareProcess#ExtraWorks");
              com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", new Object[] { this.username, this.appId });
              aGO();
              localObject2 = com.tencent.mm.plugin.appbrand.appstorage.c.gZf;
              ((AppBrandSysConfigWC)localObject1).hiY = c.a.yV(this.appId);
              ((AppBrandSysConfigWC)localObject1).hiZ = com.tencent.mm.plugin.appbrand.appstorage.d.gZl.awC();
              i = ((AppBrandSysConfigWC)localObject1).hiY;
              if (i != 2) {
                break label1011;
              }
              com.tencent.mm.plugin.report.service.h.qsU.j(1016L, 7L, 1L);
            }
            for (;;)
            {
              i = 1;
              break;
              i = 0;
              break label777;
              label996:
              i = 52;
              break label789;
              label1002:
              l = ((Long)localObject2).longValue();
              break label853;
              label1011:
              if (i == 3) {
                com.tencent.mm.plugin.report.service.h.qsU.j(1016L, 8L, 1L);
              } else if (i == 1) {
                if (com.tencent.mm.plugin.appbrand.appstorage.d.gZl.awB()) {
                  com.tencent.mm.plugin.report.service.h.qsU.j(1016L, 10L, 1L);
                } else {
                  com.tencent.mm.plugin.report.service.h.qsU.j(1016L, 9L, 1L);
                }
              }
            }
          }
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", new Object[] { this.username, this.appId });
    localObject1 = com.tencent.mm.vending.j.a.i(localObject1, null, this.ikO);
    AppMethodBeat.o(131794);
    return localObject1;
  }
  
  final void aGN()
  {
    AppMethodBeat.i(131795);
    if (this.ikG != null) {
      this.ikG.onDownloadProgress(100);
    }
    AppMethodBeat.o(131795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g
 * JD-Core Version:    0.7.0.1
 */