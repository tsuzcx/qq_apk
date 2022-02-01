package com.tencent.mm.plugin.appbrand.launching;

import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.l;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.zu;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.g.b.a.gx;
import com.tencent.mm.g.b.a.ix;
import com.tencent.mm.model.ao;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.bp.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appcache.x;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.y.i<Lcom.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction;>;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import junit.framework.Assert;

public final class k
  implements ILaunchWxaAppInfoNotify
{
  private static final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> lKA;
  private static final android.support.v4.e.a<String, k> lKb;
  private static final ay lKc;
  private static final ConcurrentHashMap<String, QualitySession> lKf;
  final String appId;
  private final boolean ciE;
  final AppBrandLaunchReferrer cmx;
  final int dLf;
  final int enterScene;
  final int hSZ;
  final String jFL;
  private AppBrandLaunchFromNotifyReferrer jFX;
  private final QualitySession kaS;
  final ICommLibReader kbE;
  private final String lIU;
  private final long lKd;
  private final boolean lKe;
  volatile b lKg;
  volatile boolean lKh;
  volatile com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> lKi;
  volatile long lKj;
  final String lKk;
  final boolean lKl;
  private final WxaAttributes.WxaVersionInfo lKm;
  private boolean lKn;
  private final AppStartupPerformanceReportBundle lKo;
  private volatile long lKp;
  private final List<kv_14609> lKq;
  private final com.tencent.mm.sdk.b.c<kp> lKr;
  private final List<ix> lKs;
  private final com.tencent.mm.sdk.b.c<zu> lKt;
  private final com.tencent.mm.sdk.b.c<zv> lKu;
  private volatile ax lKv;
  volatile Boolean lKw;
  private volatile HashMap<String, AppRuntimeApiPermissionBundle> lKx;
  volatile boolean lKy;
  volatile boolean lKz;
  volatile boolean started;
  final String username;
  
  static
  {
    AppMethodBeat.i(47151);
    lKb = new android.support.v4.e.a();
    lKc = ay.aRW("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]");
    lKf = new ConcurrentHashMap();
    lKA = com.tencent.mm.vending.j.a.i(null, null, null);
    AppMethodBeat.o(47151);
  }
  
  k(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    this(str1, str2, i, j, k, paramAppBrandStatObject, localAppBrandLaunchReferrer, str3, com.tencent.mm.plugin.appbrand.appcache.at.baF(), paramAppBrandInitConfigWC.cmA, paramAppBrandInitConfigWC.Ee(), paramAppBrandInitConfigWC.cmu, paramAppBrandInitConfigWC.kaS, paramAppBrandInitConfigWC.startTime, paramAppBrandInitConfigWC.kaZ, paramAppBrandInitConfigWC.jFX);
    AppMethodBeat.i(47135);
    AppMethodBeat.o(47135);
  }
  
  public k(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString4, ICommLibReader paramICommLibReader, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean1, boolean paramBoolean2, QualitySession paramQualitySession, long paramLong, boolean paramBoolean3, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer)
  {
    AppMethodBeat.i(222752);
    this.lKj = -1L;
    this.lKn = false;
    this.lKq = new CopyOnWriteArrayList();
    this.lKr = new com.tencent.mm.sdk.b.c() {};
    this.lKs = new CopyOnWriteArrayList();
    this.lKt = new com.tencent.mm.sdk.b.c() {};
    this.lKu = new com.tencent.mm.sdk.b.c() {};
    this.lKw = null;
    this.lKy = false;
    this.lKz = false;
    this.username = paramString1;
    this.appId = paramString2;
    this.hSZ = paramInt1;
    this.dLf = paramInt2;
    this.enterScene = paramInt3;
    this.jFL = paramString3;
    this.cmx = paramAppBrandLaunchReferrer;
    this.lKk = paramString4;
    this.kbE = paramICommLibReader;
    this.lIU = paramQualitySession.lIU;
    this.lKd = paramLong;
    this.lKe = paramBoolean3;
    this.jFX = paramAppBrandLaunchFromNotifyReferrer;
    Assert.assertNotNull("<init> NULL wxaVersionInfo ".concat(String.valueOf(paramString2)), paramWxaVersionInfo);
    this.lKm = paramWxaVersionInfo;
    ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> username[%s] appId[%s] versionType[%d] appVersion[%d], scene[%d] sessionId[%s] instanceId[%s] mIsLaunchedByBackupWxaAttrs[%b]", new Object[] { this.username, this.appId, Integer.valueOf(this.hSZ), Integer.valueOf(paramWxaVersionInfo.aDD), Integer.valueOf(this.enterScene), this.lKk, this.lIU, Boolean.valueOf(this.lKe) });
    if (paramICommLibReader == null) {
      ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "<init> NULL acceptedLibReader, instanceId[%s]", new Object[] { this.lIU });
    }
    this.ciE = paramBoolean1;
    this.lKl = paramBoolean2;
    this.kaS = paramQualitySession;
    this.lKo = new AppStartupPerformanceReportBundle(paramQualitySession.lIU);
    lKf.put(paramQualitySession.lIU, paramQualitySession);
    if (paramBoolean1) {
      x.LR(paramString2);
    }
    AppMethodBeat.o(222752);
  }
  
  static k Sr(String paramString)
  {
    AppMethodBeat.i(47132);
    for (;;)
    {
      synchronized (lKb)
      {
        k localk = (k)lKb.remove(paramString);
        ??? = Log.getStackTraceString(new Throwable());
        if (localk != null)
        {
          ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess appId(%s) type(%d) sessionId(%s), stacktrace=%s", new Object[] { localk.appId, Integer.valueOf(localk.hSZ), paramString, ??? });
          AppMethodBeat.o(47132);
          return localk;
        }
      }
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "pollProcess sessionId(%s) get NULL, stacktrace=%s", new Object[] { paramString, ??? });
    }
  }
  
  static k Ss(String paramString)
  {
    AppMethodBeat.i(47133);
    synchronized (lKb)
    {
      paramString = (k)lKb.get(paramString);
      AppMethodBeat.o(47133);
      return paramString;
    }
  }
  
  static QualitySession St(String paramString)
  {
    AppMethodBeat.i(47134);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(47134);
      return null;
    }
    paramString = (QualitySession)lKf.get(paramString);
    AppMethodBeat.o(47134);
    return paramString;
  }
  
  private boolean a(AppBrandSysConfigWC paramAppBrandSysConfigWC, final com.tencent.mm.plugin.appbrand.y.i<AppBrandLaunchErrorAction> parami)
  {
    AppMethodBeat.i(222754);
    this.lKr.alive();
    Object localObject4;
    Object localObject5;
    boolean bool;
    label113:
    Object localObject2;
    if (this.hSZ == 0)
    {
      this.lKt.alive();
      paramAppBrandSysConfigWC.kbE = this.kbE;
      localObject4 = new bi(paramAppBrandSysConfigWC.appId, this.hSZ, this.jFL, this.enterScene, this.lKm, this.ciE, this.kbE, this.kaS)
      {
        public final void brG()
        {
          AppMethodBeat.i(47125);
          super.brG();
          k.h(k.this);
          AppMethodBeat.o(47125);
        }
        
        public final void brx()
        {
          AppMethodBeat.i(47124);
          super.brx();
          k.g(k.this);
          AppMethodBeat.o(47124);
        }
        
        public final void onDownloadProgress(int paramAnonymousInt)
        {
          AppMethodBeat.i(47126);
          super.onDownloadProgress(paramAnonymousInt);
          if (k.this.lKg != null) {
            k.this.lKg.onDownloadProgress(paramAnonymousInt);
          }
          AppMethodBeat.o(47126);
        }
      };
      localObject5 = ((bi)localObject4).bsn();
      bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qze, true);
      if (!bool) {
        break label321;
      }
      i = 1;
      ae.i("MicroMsg.PkgABTest", "openGameIsolatedPluginPermissionCheck exp:%d", new Object[] { Integer.valueOf(i) });
      if (!bool) {
        break label326;
      }
      localObject2 = new bg(this.appId, this.hSZ, this.ciE, this.lKm, this.enterScene, this.lKk, this.kaS)
      {
        final void aXK()
        {
          AppMethodBeat.i(222749);
          k.i(k.this);
          AppMethodBeat.o(222749);
        }
      };
    }
    Object localObject3;
    for (Object localObject1 = ((bg)localObject2).bsn();; localObject1 = null)
    {
      localObject6 = new bj(this.appId, this.hSZ, this.dLf, this.enterScene, this.jFL, this.cmx, this.lKk, this.kbE, this.kaS, this.username, this.jFX)
      {
        final void aXJ()
        {
          AppMethodBeat.i(222750);
          k.j(k.this);
          AppMethodBeat.o(222750);
        }
      };
      localObject3 = (ax)((bj)localObject6).bso();
      this.lKo.lKH = ((bj)localObject6).lPv;
      this.lKo.lKI = ((bj)localObject6).lPw;
      if (localObject3 != null) {
        break label335;
      }
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null launchInfo", new Object[] { this.username, this.appId });
      AppMethodBeat.o(222754);
      return false;
      this.lKu.alive();
      break;
      label321:
      i = 0;
      break label113;
      label326:
      localObject2 = null;
    }
    label335:
    Object localObject6 = AppBrandLaunchErrorAction.CREATOR;
    localObject6 = AppBrandLaunchErrorAction.a.a(this.appId, this.hSZ, (ax)localObject3);
    if (localObject6 != null)
    {
      parami.value = localObject6;
      ui(54);
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, launch ban code %d", new Object[] { this.username, this.appId, Integer.valueOf(((ax)localObject3).field_launchAction.FJl) });
      AppMethodBeat.o(222754);
      return false;
    }
    this.lKo.lKO = ((ax)localObject3).lOV;
    if ((((ax)localObject3).field_jsapiInfo == null) || (((ax)localObject3).field_jsapiInfo.Gph == null))
    {
      ui(54);
      ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, get null jsapi_info", new Object[] { this.username, this.appId });
      AppMethodBeat.o(222754);
      return false;
    }
    ((ax)localObject3).a(paramAppBrandSysConfigWC);
    parami = com.tencent.luggage.sdk.e.c.cqj;
    parami = com.tencent.luggage.sdk.e.c.dq(this.lIU).cqf.values().iterator();
    int i = 0;
    if (parami.hasNext())
    {
      if (!((com.tencent.luggage.sdk.e.a)parami.next()).cqb) {
        break label2625;
      }
      i = 1;
    }
    label951:
    label956:
    label2625:
    for (;;)
    {
      break;
      parami = this.lKo;
      long l1;
      label631:
      String str;
      int j;
      long l2;
      if (i != 0)
      {
        i = 1;
        parami.lKN = i;
        if ((!j.a.rT(this.hSZ)) || (this.lKe)) {
          break label966;
        }
        parami = av.SB(this.appId);
        if (!(parami instanceof av.c.a)) {
          break label956;
        }
        l1 = ((av.c.a)parami).lOS - (bu.fpO() - this.lKd);
        if (l1 > 0L) {
          break label951;
        }
        l1 = 9223372036854775807L;
        i = 0;
        localObject6 = this.username;
        str = this.appId;
        j = this.hSZ;
        bool = this.lKe;
        l2 = this.lKd;
        if (i == 0) {
          break label978;
        }
      }
      label966:
      label978:
      for (localObject3 = l1 + "ms";; localObject3 = "false")
      {
        ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig() before get app pkg, username[%s] appId[%s] versionType[%d] mIsLaunchedByBackupWxaAttrs[%b] clickTimestamp[%d] timeoutStrategy=[%s], fallbackStrategy[%s]", new Object[] { localObject6, str, Integer.valueOf(j), Boolean.valueOf(bool), Long.valueOf(l2), localObject3, parami });
        try
        {
          ((Future)localObject5).get(l1, TimeUnit.MILLISECONDS);
          parami = (WxaPkgWrappingInfo)((Pair)((Future)localObject5).get()).first;
          localObject3 = (List)((Pair)((Future)localObject5).get()).second;
          this.lKh = true;
          brC();
          this.lKr.dead();
          this.lKt.dead();
          this.lKu.dead();
          this.lKo.lKE.addAll(this.lKs);
          this.lKo.lKF.addAll(this.lKq);
          this.lKo.lKJ = ((bi)localObject4).lPv;
          this.lKo.lKK = ((bi)localObject4).lPw;
          if (parami != null) {
            break label1291;
          }
          if (j.a.rT(this.hSZ)) {
            av.dO(this.username, this.appId);
          }
          ui(55);
          ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig null app pkg, username %s appId %s", new Object[] { this.username, this.appId });
          AppMethodBeat.o(222754);
          return false;
        }
        catch (TimeoutException paramAppBrandSysConfigWC)
        {
          if (i == 0) {
            break label1283;
          }
          ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, get app pkg timeout, try fallback backup wxaattrs, username[%s] appId[%s] awaitTimeout[%d]", new Object[] { this.username, this.appId, Long.valueOf(l1) });
          this.lKz = true;
          paramAppBrandSysConfigWC = this.lKg;
          localObject1 = this.username;
          localObject2 = this.appId;
          if (paramAppBrandSysConfigWC != null) {
            break label1257;
          }
          bool = true;
          for (;;)
          {
            ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyFallbackBackupWxaAttrs username[%s] appId[%s] null==callback[%b]", new Object[] { localObject1, localObject2, Boolean.valueOf(bool) });
            if (paramAppBrandSysConfigWC != null) {
              paramAppBrandSysConfigWC.bry();
            }
            try
            {
              paramAppBrandSysConfigWC = new gx();
              paramAppBrandSysConfigWC.qc(this.appId);
              paramAppBrandSysConfigWC.qd(this.username);
              paramAppBrandSysConfigWC.esb = this.enterScene;
              paramAppBrandSysConfigWC.esc = this.lKm.aDD;
              paramAppBrandSysConfigWC.esd = ((s)j.T(s.class)).e(this.appId, new String[] { "versionInfo" }).beV().aDD;
              paramAppBrandSysConfigWC.esi = 1L;
              paramAppBrandSysConfigWC.esj = ((av.c.a)parami).lOS;
              paramAppBrandSysConfigWC.qe(com.tencent.mm.plugin.appbrand.report.h.getNetworkType(ak.getContext()));
              paramAppBrandSysConfigWC.esh = 0L;
              paramAppBrandSysConfigWC.qf(this.kaS.lIU);
              paramAppBrandSysConfigWC.aLH();
              av.b.a(this.kaS.lIU, paramAppBrandSysConfigWC);
              av.b.bS(this.kaS.lIU, 2);
              AppMethodBeat.o(222754);
              return false;
              bool = false;
            }
            catch (Throwable paramAppBrandSysConfigWC)
            {
              for (;;)
              {
                ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, report fallback get exception %s", new Object[] { paramAppBrandSysConfigWC });
              }
            }
          }
          AppMethodBeat.o(222754);
          throw paramAppBrandSysConfigWC;
        }
        i = 0;
        break;
        i = 1;
        break label631;
        l1 = 9223372036854775807L;
        i = 0;
        break label631;
        parami = null;
        i = 0;
        l1 = 9223372036854775807L;
        break label631;
      }
      label1257:
      paramAppBrandSysConfigWC.kbw = parami;
      paramAppBrandSysConfigWC.cnk = ((List)localObject3);
      if (paramAppBrandSysConfigWC.kbw.jLV != 0) {
        paramAppBrandSysConfigWC.kbw.pkgVersion = 0;
      }
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig username %s, appId %s, app pkg %s", new Object[] { this.username, paramAppBrandSysConfigWC.appId, paramAppBrandSysConfigWC.kbw });
      if (com.tencent.mm.plugin.appbrand.ui.recommend.e.ci(this.appId, this.hSZ))
      {
        if (this.lKj <= 0L)
        {
          i = 1;
          parami = com.tencent.mm.plugin.report.service.g.yxI;
          if (i == 0) {
            break label1737;
          }
          i = 53;
          label1389:
          parami.dD(1089, i);
        }
      }
      else
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          this.lKo.lKL = ((bg)localObject2).lPv;
          this.lKo.lKM = ((bg)localObject2).lPw;
          if (((Future)localObject1).get() != null)
          {
            parami = (HashMap)((Pair)((Future)localObject1).get()).first;
            if (parami == null) {
              break label1743;
            }
            i = parami.size();
            ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "checkWxaJsApiInfoHashMap size:%d", new Object[] { Integer.valueOf(i) });
            paramAppBrandSysConfigWC.cmL = parami;
            this.lKo.lKP = ((Boolean)((Pair)((Future)localObject1).get()).second).booleanValue();
          }
        }
        paramAppBrandSysConfigWC.cnh = AppBrandGlobalSystemConfig.bez();
        parami = com.tencent.mm.plugin.appbrand.message.h.lYX;
        parami = com.tencent.mm.plugin.appbrand.message.h.ee(this.appId, "copypath");
        if (parami != null) {
          break label1748;
        }
        l1 = 0L;
        paramAppBrandSysConfigWC.cng = l1;
        ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "copyPathMenuShowExpireTime = " + paramAppBrandSysConfigWC.cng);
        parami = paramAppBrandSysConfigWC.kbw;
        com.tencent.e.h.MqF.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(47129);
            Object localObject = com.tencent.mm.plugin.appbrand.config.v.Ol(k.this.username);
            if ((localObject != null) && (localObject.length > 0))
            {
              int j = localObject.length;
              int i = 0;
              while (i < j)
              {
                String str = localObject[i];
                com.tencent.mm.modelappbrand.a.b.aEl().CU(str);
                i += 1;
              }
            }
            if (k.brF())
            {
              localObject = new l(12);
              com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject, 0);
            }
            bp.a.a(k.this.appId, parami);
            AppMethodBeat.o(47129);
          }
        }, "AppLaunchPrepareProcess#ExtraWorks");
        ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig ok username %s, appId %s", new Object[] { this.username, this.appId });
        brD();
        com.tencent.mm.vfs.v.fTP();
        parami = com.tencent.mm.plugin.appbrand.appstorage.b.b.jRe;
        parami = com.tencent.mm.plugin.appbrand.appstorage.b.b.a.Ni(w.B(new com.tencent.mm.vfs.k(Environment.getExternalStorageDirectory(), "tencent/MicroMsg").fTh()));
        if (parami != null) {
          break label1757;
        }
        ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: srcBaseDirPath ==null");
        parami = com.tencent.mm.plugin.appbrand.appstorage.e.kRd;
        paramAppBrandSysConfigWC.kbx = e.a.ME(this.appId);
        paramAppBrandSysConfigWC.kby = com.tencent.mm.plugin.appbrand.appstorage.f.jPr.bbU();
        i = paramAppBrandSysConfigWC.kbx;
        if (i != 2) {
          break label2558;
        }
        com.tencent.mm.plugin.report.service.g.yxI.n(1016L, 7L, 1L);
      }
      for (;;)
      {
        AppMethodBeat.o(222754);
        return true;
        i = 0;
        break;
        label1737:
        i = 52;
        break label1389;
        label1743:
        i = 0;
        break label1467;
        label1748:
        l1 = parami.longValue();
        break label1546;
        label1757:
        if (com.tencent.mm.sdcard_migrate.b.aRn(parami))
        {
          ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForScopedStorage: Migrated");
          break label1676;
        }
        com.tencent.mm.kernel.g.ajP();
        localObject1 = com.tencent.mm.b.p.getString(com.tencent.mm.kernel.a.getUin());
        parami = new com.tencent.mm.plugin.appbrand.appstorage.b.b();
        d.g.b.p.h(localObject1, "uin");
        parami.uin = ((String)localObject1);
        localObject3 = parami.Nh(this.appId);
        localObject2 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject3).cCf;
        localObject4 = new StringBuilder();
        localObject5 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject3).appId;
        if (localObject5 == null) {
          d.g.b.p.bdF("appId");
        }
        localObject4 = ((StringBuilder)localObject4).append((String)localObject5);
        localObject3 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject3).uin;
        if (localObject3 == null) {
          d.g.b.p.bdF("uin");
        }
        if (((ay)localObject2).getBoolean((String)localObject3, false))
        {
          com.tencent.mm.plugin.report.service.g.yxI.dD(1323, 2);
          ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForCompatibility: appId = [%s] isTransferred", new Object[] { this.appId });
          break label1676;
        }
        localObject5 = com.tencent.mm.plugin.appbrand.jsapi.file.at.m(new String[] { localObject1, this.appId }) + "/";
        localObject2 = com.tencent.mm.plugin.appbrand.jsapi.file.at.m(new String[] { localObject1, this.appId, "opendata" }) + "/";
        localObject3 = com.tencent.mm.plugin.appbrand.jsapi.file.at.m(new String[] { localObject1, this.appId, "clientdata" }) + "/";
        localObject1 = com.tencent.mm.loader.j.b.asj();
        localObject4 = parami.Nh(this.appId);
        d.g.b.p.h(localObject1, "path");
        parami = (com.tencent.mm.plugin.appbrand.y.i<AppBrandLaunchErrorAction>)localObject1;
        if (!d.n.n.nG((String)localObject1, "/")) {
          parami = (String)localObject1 + '/';
        }
        ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jRc = parami;
        d.g.b.p.h(localObject5, "nonFlattenedFSPath");
        d.g.b.p.h(localObject2, "nonFlattenedOpenFSPath");
        d.g.b.p.h(localObject3, "nonFlattenedClientFSPath");
        parami = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).iuz;
        if (parami == null) {
          d.g.b.p.gkB();
        }
        if (d.n.n.nG(parami, "/")) {}
        for (parami = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).iuz;; parami = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).iuz + "/")
        {
          localObject1 = new StringBuilder().append(parami).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.jRj.dir).append('/');
          localObject6 = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).appId;
          if (localObject6 == null) {
            d.g.b.p.bdF("appId");
          }
          localObject1 = (String)localObject6 + '/';
          localObject6 = new StringBuilder();
          str = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jRc;
          if (str == null) {
            d.g.b.p.bdF("appBrandTargetFolder");
          }
          localObject6 = ((StringBuilder)localObject6).append(str).append(com.tencent.mm.plugin.appbrand.appstorage.b.d.jRj.dir).append('/');
          str = ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).appId;
          if (str == null) {
            d.g.b.p.bdF("appId");
          }
          localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.c((String)localObject1, str + '/');
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jRd.add(localObject1);
          localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.c(parami + com.tencent.mm.plugin.appbrand.appstorage.b.d.jRk.dir + d.n.n.nL((String)localObject5, com.tencent.mm.plugin.appbrand.appstorage.b.d.jRk.dir), (String)localObject5);
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jRd.add(localObject1);
          localObject1 = new com.tencent.mm.plugin.appbrand.appstorage.b.c(parami + com.tencent.mm.plugin.appbrand.appstorage.b.d.jRk.dir + d.n.n.nL((String)localObject2, com.tencent.mm.plugin.appbrand.appstorage.b.d.jRk.dir), (String)localObject2);
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jRd.add(localObject1);
          parami = new com.tencent.mm.plugin.appbrand.appstorage.b.c(parami + com.tencent.mm.plugin.appbrand.appstorage.b.d.jRk.dir + d.n.n.nL((String)localObject3, com.tencent.mm.plugin.appbrand.appstorage.b.d.jRk.dir), (String)localObject3);
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).jRd.add(parami);
          ((com.tencent.mm.plugin.appbrand.appstorage.b.b)localObject4).commit();
          break;
        }
        label2558:
        if (i == 3) {
          com.tencent.mm.plugin.report.service.g.yxI.n(1016L, 8L, 1L);
        } else if (i == 1) {
          if (com.tencent.mm.plugin.appbrand.appstorage.f.jPr.bbT()) {
            com.tencent.mm.plugin.report.service.g.yxI.n(1016L, 10L, 1L);
          } else {
            com.tencent.mm.plugin.report.service.g.yxI.n(1016L, 9L, 1L);
          }
        }
      }
    }
  }
  
  private void b(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47141);
    ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] onPrepareDone %s %d in mm process", new Object[] { this.appId, Integer.valueOf(this.hSZ) });
    a(paramd);
    paramd = com.tencent.luggage.sdk.e.c.cqj;
    paramd = com.tencent.luggage.sdk.e.c.dq(this.lIU);
    if ((paramd instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
      ((com.tencent.mm.plugin.appbrand.launching.d.c)paramd).d(this.kaS);
    }
    paramd = com.tencent.luggage.sdk.e.c.cqj;
    com.tencent.luggage.sdk.e.c.dr(this.lIU);
    lKf.remove(this.lIU);
    AppMethodBeat.o(47141);
  }
  
  private void brD()
  {
    boolean bool2 = false;
    AppMethodBeat.i(174932);
    Object localObject1 = this.appId;
    Object localObject2;
    if (this.lKg != null)
    {
      bool1 = true;
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "transferDataForDB start with appId:%s callback!=null:%b ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      localObject1 = new Timer();
      ((Timer)localObject1).schedule(new TimerTask()
      {
        public final void run()
        {
          boolean bool = false;
          AppMethodBeat.i(222751);
          String str = k.this.appId;
          if (k.this.lKg != null) {
            bool = true;
          }
          ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_OVER_THRESHOLD with appId:%s, callback!=null:%b", new Object[] { str, Boolean.valueOf(bool) });
          if (k.this.lKg != null) {
            k.this.lKg.rF(3);
          }
          AppMethodBeat.o(222751);
        }
      }, 5000L);
      localObject2 = this.appId;
      if (this.lKg == null) {
        break label191;
      }
    }
    label191:
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_START with appId:%s, callback!=null:%b", new Object[] { localObject2, Boolean.valueOf(bool1) });
      if (this.lKg != null) {
        this.lKg.rF(1);
      }
      localObject2 = new com.tencent.mm.plugin.appbrand.appstorage.e(this.appId);
      int i = 0;
      while (i <= 0)
      {
        ao localao = new ao[] { localObject2 }[0];
        if (localao.os(com.tencent.mm.protocal.d.FFH)) {
          localao.transfer(com.tencent.mm.protocal.d.FFH);
        }
        i += 1;
      }
      bool1 = false;
      break;
    }
    ((Timer)localObject1).cancel();
    localObject1 = this.appId;
    bool1 = bool2;
    if (this.lKg != null) {
      bool1 = true;
    }
    ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "DATA_TRANSFER_STATE_FINISH with appId:%s, callback!=null:%b", new Object[] { localObject1, Boolean.valueOf(bool1) });
    if (this.lKg != null) {
      this.lKg.rF(2);
    }
    AppMethodBeat.o(174932);
  }
  
  private void ui(int paramInt)
  {
    AppMethodBeat.i(47136);
    if (this.lKn)
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!"wxb6d22f922f37b35a".equals(this.appId))
    {
      AppMethodBeat.o(47136);
      return;
    }
    if (!j.a.rT(this.hSZ))
    {
      AppMethodBeat.o(47136);
      return;
    }
    this.lKn = true;
    com.tencent.mm.plugin.report.service.g.yxI.dD(1089, paramInt);
    String str = this.appId;
    if (this.lKm == null) {}
    for (int i = 0;; i = this.lKm.aDD)
    {
      com.tencent.mm.plugin.appbrand.report.h.b(str, i, this.hSZ, 1089, paramInt);
      AppMethodBeat.o(47136);
      return;
    }
  }
  
  final void a(com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> paramd)
  {
    AppMethodBeat.i(47138);
    this.lKi = paramd;
    AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)paramd.get(0);
    Object localObject = (AppBrandLaunchErrorAction)paramd.get(1);
    if (this.lKv != null)
    {
      if (localAppBrandSysConfigWC != null)
      {
        this.lKv.a(localAppBrandSysConfigWC);
        ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cmK, this.username, this.appId });
      }
      localObject = AppBrandLaunchErrorAction.CREATOR;
      AppBrandLaunchErrorAction localAppBrandLaunchErrorAction = AppBrandLaunchErrorAction.a.a(this.appId, this.hSZ, this.lKv);
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][permission] onResult, updated errorAction[%s] username[%s] appId[%s]", new Object[] { localAppBrandLaunchErrorAction, this.username, this.appId });
      localObject = localAppBrandLaunchErrorAction;
      if (localAppBrandLaunchErrorAction != null)
      {
        localAppBrandSysConfigWC = null;
        localObject = localAppBrandLaunchErrorAction;
      }
    }
    for (;;)
    {
      if ((this.lKx != null) && (localAppBrandSysConfigWC != null))
      {
        localAppBrandSysConfigWC.cmL = this.lKx;
        ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch][ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate]] onResult, update permissionBundle[%s] username[%s] appId[%s]", new Object[] { localAppBrandSysConfigWC.cmK, this.username, this.appId });
      }
      if (this.lKg != null)
      {
        this.lKg.a(localAppBrandSysConfigWC, (AppBrandLaunchErrorAction)localObject, (AppStartupPerformanceReportBundle)paramd.get(2));
        Sr(this.lKk);
      }
      AppMethodBeat.o(47138);
      return;
    }
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, ax paramax)
  {
    AppMethodBeat.i(47139);
    if (this.lKi != null)
    {
      Object localObject = AppBrandLaunchErrorAction.CREATOR;
      localObject = AppBrandLaunchErrorAction.a.a(this.appId, this.hSZ, paramax);
      if (localObject != null)
      {
        this.lKi = com.tencent.mm.vending.j.a.i(null, localObject, this.lKo);
        AppMethodBeat.o(47139);
        return;
      }
      localObject = (AppBrandSysConfigWC)this.lKi.get(0);
      if (localObject == null)
      {
        ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(47139);
        return;
      }
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramax });
      paramax.a((AppBrandSysConfigWC)localObject);
      this.lKi = com.tencent.mm.vending.j.a.i(localObject, null, this.lKo);
      AppMethodBeat.o(47139);
      return;
    }
    ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifyLaunchInfoUpdate] set mMaybeUpdatedLaunchPB appId[%s] type[%d] sessionId[%s] info[%s]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, paramax });
    this.lKv = paramax;
    AppMethodBeat.o(47139);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(222753);
    if (this.lKi != null)
    {
      AppBrandSysConfigWC localAppBrandSysConfigWC = (AppBrandSysConfigWC)this.lKi.get(0);
      if (localAppBrandSysConfigWC == null)
      {
        ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[] { paramString1 });
        AppMethodBeat.o(222753);
        return;
      }
      if (paramHashMap == null) {}
      for (;;)
      {
        ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] fillLaunchConfig to pending launchResult appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
        localAppBrandSysConfigWC.cmL = paramHashMap;
        this.lKi = com.tencent.mm.vending.j.a.i(localAppBrandSysConfigWC, null, this.lKo);
        AppMethodBeat.o(222753);
        return;
        i = paramHashMap.size();
      }
    }
    if (paramHashMap == null) {}
    for (i = j;; i = paramHashMap.size())
    {
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[ILaunchWxaAppInfoNotify][notifPluginPermissionInfoUpdate] set mMaybeUpdatedPluginPermissionMap appId[%s] type[%d] sessionId[%s] info[%d]", new Object[] { paramString1, Integer.valueOf(paramInt), paramString2, Integer.valueOf(i) });
      this.lKx = paramHashMap;
      AppMethodBeat.o(222753);
      return;
    }
  }
  
  public final void brA()
  {
    AppMethodBeat.i(47140);
    if (this.started)
    {
      AppMethodBeat.o(47140);
      return;
    }
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceGroup);
    com.tencent.mm.plugin.appbrand.keylogger.c.a(this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
    this.started = true;
    this.lKp = bu.fpO();
    ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "[applaunch] startPrepare in mm appId[%s] type[%d] scene[%d]", new Object[] { this.appId, Integer.valueOf(this.hSZ), Integer.valueOf(this.enterScene) });
    synchronized (lKb)
    {
      lKb.put(this.lKk, this);
      ??? = new a(this.lKk, this.lIU, this.kaS);
      long l = TimeUnit.SECONDS.toMillis(300L);
      ((aw)???).ay(l, l);
      if (this.lKm == null)
      {
        ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "startPrepare() NULL wxaVersionInfo username[%s], appId[%s]", new Object[] { this.username, this.appId });
        bf.uq(2131755507);
        b(lKA);
        AppMethodBeat.o(47140);
        return;
      }
    }
    new aq(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[] { this.appId, Integer.valueOf(this.hSZ) })).post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(47123);
        try
        {
          k.a(k.this, k.this.brB());
          com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess);
          return;
        }
        catch (Exception localException)
        {
          ae.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", localException, "call() exp ", new Object[0]);
          com.tencent.mm.plugin.appbrand.keylogger.c.b(k.this.appId, KSProcessWeAppLaunch.stepPrepareResourceProcess, localException.getLocalizedMessage());
          bf.uq(2131755506);
          k.a(k.this, k.brE());
          k.f(k.this);
          return;
        }
        finally
        {
          if (k.this.kbE != null) {
            org.apache.commons.a.e.closeQuietly(k.this.kbE);
          }
          AppMethodBeat.o(47123);
        }
        AppMethodBeat.o(47123);
      }
    });
    AppMethodBeat.o(47140);
  }
  
  public final com.tencent.mm.vending.j.d<AppBrandSysConfigWC, AppBrandLaunchErrorAction, AppStartupPerformanceReportBundle> brB()
  {
    int i = 0;
    AppMethodBeat.i(47142);
    AppBrandSysConfigWC localAppBrandSysConfigWC = com.tencent.mm.plugin.appbrand.config.v.Oj(this.appId);
    if (localAppBrandSysConfigWC == null) {
      bf.Sx(com.tencent.mm.plugin.appbrand.utils.f.getMMString(2131755578, new Object[] { "" }));
    }
    if (localAppBrandSysConfigWC == null)
    {
      ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "get null config!!!, username:%s, appId:%s", new Object[] { this.username, this.appId });
      if (this.lKm == null) {}
      for (i = 0;; i = this.lKm.aDD)
      {
        com.tencent.mm.plugin.appbrand.n.a(7, this.appId, i, this.hSZ, this.ciE);
        localObject = lKA;
        AppMethodBeat.o(47142);
        return localObject;
      }
    }
    ((com.tencent.mm.plugin.appbrand.appusage.k)j.T(com.tencent.mm.plugin.appbrand.appusage.k.class)).P(com.tencent.mm.plugin.appbrand.config.v.Oo(this.appId), bu.aRi());
    Object localObject = new com.tencent.mm.plugin.appbrand.y.i();
    if (!a(localAppBrandSysConfigWC, (com.tencent.mm.plugin.appbrand.y.i)localObject))
    {
      ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "fillConfig, false, username %s, appId %s", new Object[] { this.username, this.appId });
      if (this.lKm == null) {}
      for (;;)
      {
        com.tencent.mm.plugin.appbrand.n.a(8, this.appId, i, this.hSZ, this.ciE);
        localObject = com.tencent.mm.vending.j.a.i(null, ((com.tencent.mm.plugin.appbrand.y.i)localObject).value, this.lKo);
        AppMethodBeat.o(47142);
        return localObject;
        i = this.lKm.aDD;
      }
    }
    ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, just go weapp, username %s, appId %s", new Object[] { this.username, this.appId });
    if (j.a.rT(this.hSZ)) {}
    try
    {
      localObject = av.SA(this.username);
      if ((localObject != null) && (((WxaAttributes)localObject).beV().aDD == this.lKm.aDD)) {
        break label506;
      }
      localObject = ((u)j.T(u.class)).d(this.username, new String[0]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, try backup available attrs failed with username(%s) appId(%s) by exception:%s", new Object[] { this.username, this.appId, localException });
      }
    }
    ae.i("MicroMsg.AppBrand.AppLaunchPrepareProcess[applaunch]", "prepare ok, try backup available attrs with username(%s) appId(%s), now.versionInfo.appVersion:%d, record.versionInfo.appVersion:%d", new Object[] { this.username, this.appId, Integer.valueOf(this.lKm.aDD), Integer.valueOf(((WxaAttributes)localObject).beV().aDD) });
    if (((WxaAttributes)localObject).beV().aDD == this.lKm.aDD) {
      ((s)j.T(s.class)).d((WxaAttributes)localObject);
    }
    av.dN(this.username, this.appId);
    av.dP(this.username, this.appId);
    this.lKo.lKp = this.lKp;
    this.lKo.lKG = bu.fpO();
    localObject = com.tencent.mm.vending.j.a.i(localAppBrandSysConfigWC, null, this.lKo);
    AppMethodBeat.o(47142);
    return localObject;
  }
  
  final void brC()
  {
    AppMethodBeat.i(47143);
    if (this.lKg != null) {
      this.lKg.onDownloadProgress(100);
    }
    AppMethodBeat.o(47143);
  }
  
  static final class a
    extends aw
  {
    public a(final String paramString1, String paramString2, final QualitySession paramQualitySession)
    {
      super(new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(47130);
          Object localObject = com.tencent.luggage.sdk.e.c.cqj;
          localObject = com.tencent.luggage.sdk.e.c.dq(k.a.this);
          if ((localObject instanceof com.tencent.mm.plugin.appbrand.launching.d.c)) {
            ((com.tencent.mm.plugin.appbrand.launching.d.c)localObject).d(paramQualitySession);
          }
          localObject = com.tencent.luggage.sdk.e.c.cqj;
          com.tencent.luggage.sdk.e.c.dr(k.a.this);
          k.aQT().remove(k.a.this);
          localObject = k.Sr(paramString1);
          String str;
          if (localObject != null)
          {
            str = ((k)localObject).appId;
            if (k.a((k)localObject) != null) {
              break label105;
            }
          }
          label105:
          for (int i = 0;; i = k.a((k)localObject).aDD)
          {
            com.tencent.mm.plugin.appbrand.n.a(23, str, i, ((k)localObject).hSZ, k.b((k)localObject));
            AppMethodBeat.o(47130);
            return false;
          }
        }
      }, false);
      AppMethodBeat.i(47131);
      AppMethodBeat.o(47131);
    }
  }
  
  static abstract interface b
    extends q
  {
    public abstract void a(AppBrandSysConfigWC paramAppBrandSysConfigWC, AppBrandLaunchErrorAction paramAppBrandLaunchErrorAction, AppStartupPerformanceReportBundle paramAppStartupPerformanceReportBundle);
    
    public abstract void aXJ();
    
    public abstract void aXK();
    
    public abstract void brx();
    
    public abstract void bry();
    
    public abstract void onDownloadProgress(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.k
 * JD-Core Version:    0.7.0.1
 */