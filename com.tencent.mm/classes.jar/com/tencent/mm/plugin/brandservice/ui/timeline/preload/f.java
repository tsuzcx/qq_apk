package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.a.e;
import a.f.b.j;
import a.f.b.t;
import a.f.b.v;
import a.f.b.x;
import a.g;
import a.j.k;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "invalidId", "getInvalidId", "invalidId$delegate", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/plugin/webview/preload/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "report", "", "toString", "limit", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class f
{
  public static final f.a kbt;
  private final String TAG;
  private final int jZU;
  public TmplParams jZV;
  public int jZW;
  private final a.f jZX;
  private final a.f jZY;
  private final a.f jZZ;
  public long kaA;
  public long kaB;
  public long kaC;
  public long kaD;
  public long kaE;
  public long kaF;
  public long kaG;
  public long kaH;
  public long kaI;
  public long kaJ;
  public long kaK;
  public long kaL;
  public boolean kaM;
  public boolean kaN;
  public boolean kaO;
  public boolean kaP;
  public boolean kaQ;
  public boolean kaR;
  public boolean kaS;
  public boolean kaT;
  public boolean kaU;
  public boolean kaV;
  public boolean kaW;
  public int kaX;
  public boolean kaY;
  public boolean kaZ;
  private final a.f kaa;
  private final a.f kab;
  private long kac;
  public long kad;
  public long kae;
  long kaf;
  public long kag;
  public long kah;
  public long kai;
  public long kaj;
  public long kak;
  public long kal;
  public long kam;
  public long kan;
  public long kao;
  public long kap;
  public long kaq;
  public long kar;
  public long kas;
  public long kat;
  public long kau;
  public long kav;
  public long kaw;
  public long kax;
  public long kay;
  public long kaz;
  private long kba;
  private int kbb;
  private long kbc;
  private long kbd;
  private long kbe;
  private long kbf;
  private long kbg;
  private long kbh;
  private long kbi;
  private long kbj;
  private long kbk;
  private long kbl;
  public String kbm;
  private final a.f kbn;
  public boolean kbo;
  public boolean kbp;
  public int kbq;
  private final a.f kbr;
  private long kbs;
  public String key;
  public String url;
  
  static
  {
    AppMethodBeat.i(14833);
    eOJ = new k[] { (k)v.a(new t(v.aG(f.class), "contentId", "getContentId()Ljava/lang/String;")), (k)v.a(new t(v.aG(f.class), "pageDataSize", "getPageDataSize()I")), (k)v.a(new t(v.aG(f.class), "invalidId", "getInvalidId()Ljava/lang/String;")), (k)v.a(new t(v.aG(f.class), "dataCachedTime", "getDataCachedTime()J")), (k)v.a(new t(v.aG(f.class), "dataVersion", "getDataVersion()I")), (k)v.a(new t(v.aG(f.class), "webviewProcess", "getWebviewProcess()Ljava/lang/String;")), (k)v.a(new t(v.aG(f.class), "speedMatrix", "getSpeedMatrix()[Ljava/lang/Long;")) };
    kbt = new f.a((byte)0);
    AppMethodBeat.o(14833);
  }
  
  public f()
  {
    AppMethodBeat.i(14842);
    this.TAG = "MicroMsg.Preload.Kv15862";
    this.jZU = 15862;
    this.key = "";
    this.url = "";
    this.jZX = g.j((a.f.a.a)new f.b(this));
    this.jZY = g.j((a.f.a.a)new f.f(this));
    this.jZZ = g.j((a.f.a.a)new f.e(this));
    this.kaa = g.j((a.f.a.a)new f.c(this));
    this.kab = g.j((a.f.a.a)new f.d(this));
    this.kac = -1L;
    this.kap = -1L;
    this.kaq = -1L;
    this.kar = -1L;
    this.kas = -1L;
    this.kat = -1L;
    this.kau = -1L;
    this.kav = -1L;
    this.kaw = -1L;
    this.kbn = g.j((a.f.a.a)f.p.kby);
    this.kbq = 10000;
    this.kbr = g.j((a.f.a.a)new f.g(this));
    this.kbs = 3600000L;
    AppMethodBeat.o(14842);
  }
  
  private final String aXo()
  {
    AppMethodBeat.i(14835);
    String str = (String)this.jZX.getValue();
    AppMethodBeat.o(14835);
    return str;
  }
  
  private final int aXp()
  {
    AppMethodBeat.i(14836);
    int i = ((Number)this.jZY.getValue()).intValue();
    AppMethodBeat.o(14836);
    return i;
  }
  
  private final String aXq()
  {
    AppMethodBeat.i(14837);
    String str = (String)this.kbn.getValue();
    AppMethodBeat.o(14837);
    return str;
  }
  
  private final Long[] aXr()
  {
    AppMethodBeat.i(14838);
    Long[] arrayOfLong = (Long[])this.kbr.getValue();
    AppMethodBeat.o(14838);
    return arrayOfLong;
  }
  
  private final long hY(long paramLong)
  {
    AppMethodBeat.i(14840);
    paramLong = Math.min(Math.max(-this.kbs, paramLong), this.kbs);
    AppMethodBeat.o(14840);
    return paramLong;
  }
  
  public final void IE()
  {
    AppMethodBeat.i(14839);
    if ((!this.kaY) || (!this.kaZ))
    {
      AppMethodBeat.o(14839);
      return;
    }
    Object localObject1 = this.jZV;
    if (localObject1 == null) {
      j.ays("tmplParams");
    }
    com.tencent.mm.plugin.webview.preload.a.gK(((TmplParams)localObject1).uYL, 132);
    String str1 = d.aXm();
    this.kba = Math.max(this.kae, this.kao);
    if (this.kae < this.kao) {}
    for (i = 1;; i = 2)
    {
      this.kbb = i;
      this.kbc = (this.kba - this.kad);
      this.kbi = (this.kai - this.kad);
      this.kbh = (this.kas - this.kat);
      this.kbj = (this.kao - this.kad);
      this.kbk = (this.kao - this.kan);
      this.kaf = (this.kae - this.kad);
      this.kbd = (this.kap - this.kad);
      this.kbe = (this.kaq - this.kap);
      this.kbg = (this.kak - this.kaj);
      this.kbf = (this.kas - this.kar);
      this.kac = (this.kas - this.kat);
      this.kbl = (this.kbd + this.kbe + this.kbg + this.kbf + this.kah + this.kag);
      localObject1 = this.TAG;
      Object localObject3 = this.jZV;
      if (localObject3 == null) {
        j.ays("tmplParams");
      }
      i = ((TmplParams)localObject3).version;
      localObject3 = this.url;
      j = aXp();
      l1 = this.kbc;
      k = this.kbb;
      long l2 = this.kag;
      long l3 = this.kbj;
      boolean bool1 = this.kaN;
      long l4 = this.kav;
      long l5 = this.kau;
      boolean bool2 = this.kaM;
      long l6 = this.kbg;
      long l7 = this.kbk;
      long l8 = this.kbi;
      long l9 = this.kah;
      long l10 = this.kag;
      Object localObject4 = this.jZV;
      if (localObject4 == null) {
        j.ays("tmplParams");
      }
      int m = ((TmplParams)localObject4).kbM;
      localObject4 = this.jZV;
      if (localObject4 == null) {
        j.ays("tmplParams");
      }
      ab.d((String)localObject1, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", new Object[] { Integer.valueOf(i), localObject3, Integer.valueOf(j), str1, Long.valueOf(l1), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Long.valueOf(l4 - l5), Boolean.valueOf(bool2), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Integer.valueOf(m), ((TmplParams)localObject4).kbP, this.kbm, aXq(), Integer.valueOf(this.kbq), Long.valueOf(this.kbh), Boolean.valueOf(this.kaW) });
      if (!com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) {
        bool1 = com.tencent.mm.sdk.platformtools.f.DEBUG;
      }
      try
      {
        localObject1 = this.url;
        if (localObject1 == null) {
          j.ebi();
        }
        localObject1 = q.encode((String)localObject1, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          int n;
          int i1;
          int i2;
          int i3;
          String str2;
          String str3;
          int i4;
          ab.printErrStackTrace(this.TAG, (Throwable)localUnsupportedEncodingException, "url:%d", new Object[] { this.url });
          Object localObject2 = null;
          continue;
          i = 0;
          continue;
          j = 0;
          continue;
          k = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          com.tencent.mm.plugin.webview.preload.a.ai(20, this.kbc);
          com.tencent.mm.plugin.webview.preload.a.ai(21, this.kaf);
          com.tencent.mm.plugin.webview.preload.a.ai(22, l1);
          com.tencent.mm.plugin.webview.preload.a.ai(23, this.kaz - this.kax);
          if (!this.kaM)
          {
            com.tencent.mm.plugin.webview.preload.a.ai(24, this.kam - this.kal);
            com.tencent.mm.plugin.webview.preload.a.JZ(107);
          }
        }
      }
      localObject3 = h.qsU;
      m = this.jZU;
      localObject4 = this.jZV;
      if (localObject4 == null) {
        j.ays("tmplParams");
      }
      n = ((TmplParams)localObject4).version;
      i1 = aXp();
      l1 = hY(this.kbc);
      i2 = this.kbb;
      l2 = hY(this.kaf);
      l3 = hY(this.kbj);
      if (!this.kaN) {
        break;
      }
      i = 1;
      l4 = hY(this.kav - this.kau);
      if (!this.kaM) {
        break label1733;
      }
      j = 1;
      l5 = hY(this.kbg);
      l6 = hY(this.kbk);
      l7 = hY(this.kbi);
      l8 = hY(this.kah);
      l9 = hY(this.kag);
      localObject4 = this.jZV;
      if (localObject4 == null) {
        j.ays("tmplParams");
      }
      i3 = ((TmplParams)localObject4).kbM;
      localObject4 = this.jZV;
      if (localObject4 == null) {
        j.ays("tmplParams");
      }
      localObject4 = ((TmplParams)localObject4).kbP;
      str2 = this.kbm;
      str3 = aXq();
      i4 = this.kbq;
      l10 = hY(this.kbh);
      if (!this.kaW) {
        break label1738;
      }
      k = 1;
      ((h)localObject3).e(m, new Object[] { Integer.valueOf(n), localObject1, Integer.valueOf(i1), str1, Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l4), Integer.valueOf(j), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i3), localObject4, str2, str3, Integer.valueOf(i4), Long.valueOf(l10), Integer.valueOf(k), Long.valueOf(hY(this.kbd)), Long.valueOf(hY(this.kbe)), Long.valueOf(hY(this.kbf)) });
      localObject3 = h.qsU;
      localObject4 = new x(19);
      ((x)localObject4).add(localObject1);
      ((x)localObject4).add(Integer.valueOf(this.kbq));
      ((x)localObject4).add(str1);
      ((x)localObject4).add(Integer.valueOf(aXp()));
      localObject1 = this.jZV;
      if (localObject1 == null) {
        j.ays("tmplParams");
      }
      ((x)localObject4).add(((TmplParams)localObject1).kbP);
      ((x)localObject4).add(aXq());
      ((x)localObject4).add(this.kbm);
      if (!this.kaM) {
        break label1743;
      }
      i = 1;
      ((x)localObject4).add(Integer.valueOf(i));
      if (this.kaW) {
        break label1748;
      }
      i = 1;
      if (i == 0) {
        break label1753;
      }
      i = 1;
      ((x)localObject4).add(Integer.valueOf(i));
      if (this.kaN) {
        break label1758;
      }
      i = 1;
      if (i == 0) {
        break label1763;
      }
      i = 1;
      ((x)localObject4).add(Integer.valueOf(i));
      ((x)localObject4).add(Integer.valueOf(this.kaX));
      if (!this.kaR) {
        break label1768;
      }
      i = 1;
      ((x)localObject4).add(Integer.valueOf(i));
      if (!this.kaP) {
        break label1773;
      }
      i = 1;
      ((x)localObject4).add(Integer.valueOf(i));
      ((x)localObject4).add(Long.valueOf(this.kbc));
      ((x)localObject4).dh(aXr());
      ((x)localObject4).add(this.key);
      if (!this.kaS) {
        break label1778;
      }
      i = 1;
      ((x)localObject4).add(Integer.valueOf(i));
      if (!this.kaU) {
        break label1783;
      }
      i = 1;
      ((x)localObject4).add(Integer.valueOf(i));
      ((x)localObject4).add(Long.valueOf(this.kaw));
      ((h)localObject3).e(16874, ((x)localObject4).toArray(new Object[((x)localObject4).ceo.size()]));
      com.tencent.mm.plugin.webview.preload.a.JZ(0);
      if (this.kaS)
      {
        com.tencent.mm.plugin.webview.preload.a.JZ(111);
        localObject1 = this.jZV;
        if (localObject1 == null) {
          j.ays("tmplParams");
        }
        com.tencent.mm.plugin.webview.preload.a.gK(((TmplParams)localObject1).uYL, 232);
      }
      if (this.kaU) {
        com.tencent.mm.plugin.webview.preload.a.JZ(113);
      }
      com.tencent.mm.plugin.webview.preload.a.ai(1, this.kbc);
      com.tencent.mm.plugin.webview.preload.a.ai(2, this.kaf);
      l1 = this.kap - this.kad;
      if (!this.kaW) {
        break label1788;
      }
      com.tencent.mm.plugin.webview.preload.a.ai(10, this.kbc);
      com.tencent.mm.plugin.webview.preload.a.ai(11, this.kaf);
      com.tencent.mm.plugin.webview.preload.a.ai(12, l1);
      com.tencent.mm.plugin.webview.preload.a.ai(13, this.kaz - this.kax);
      com.tencent.mm.plugin.webview.preload.a.ai(14, this.kav - this.kau);
      com.tencent.mm.plugin.webview.preload.a.ai(15, this.kas - this.kar);
      ab.i(this.TAG, "terry performance report:" + this.kad + '\n' + e.a(aXr(), null, null, null, 0, null, null, 63));
      AppMethodBeat.o(14839);
      return;
    }
  }
  
  public final TmplParams aXn()
  {
    AppMethodBeat.i(14834);
    TmplParams localTmplParams = this.jZV;
    if (localTmplParams == null) {
      j.ays("tmplParams");
    }
    AppMethodBeat.o(14834);
    return localTmplParams;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(14841);
    Object localObject1 = f.h.kbw;
    f.i locali = new f.i(this);
    localObject1 = f.j.kbx;
    ab.v(this.TAG, "terry performance log:\n" + this.kbd + ',' + this.kbe + ',' + (this.kaz - this.kaq) + ',' + (Math.max(this.kaz, this.kav) - this.kaz) + ',' + (this.kar - Math.max(this.kaz, this.kav)) + ',' + this.kbf);
    ab.v(this.TAG, "terry performance timestamp:\n " + e.a(aXr(), null, null, null, 0, null, null, 63));
    Object localObject3 = new f.k(this);
    localObject1 = new f.l(this);
    Object localObject4 = new f.m(this);
    f.n localn = new f.n(this);
    Object localObject2 = new f.o(this);
    localObject3 = new StringBuilder("\n            [debug]\n            info: ").append(aXo()).append("\n            settings: ").append(((f.k)localObject3).aXs()).append("\n\n            [process]\n            process: ").append(aXq()).append("\n            state: ").append(localn.aXs()).append("\n\n            [webview]\n            kind: ").append(this.kbm).append("\n            state: ").append(((f.m)localObject4).aXs()).append("\n\n            [tmpl]\n            uid: ");
    localObject4 = this.jZV;
    if (localObject4 == null) {
      j.ays("tmplParams");
    }
    localObject3 = ((StringBuilder)localObject3).append(((TmplParams)localObject4).kbP).append("\n            tmplType: ");
    localObject4 = this.jZV;
    if (localObject4 == null) {
      j.ays("tmplParams");
    }
    localObject3 = ((StringBuilder)localObject3).append(((TmplParams)localObject4).kbM).append("\n            version: ");
    localObject4 = this.jZV;
    if (localObject4 == null) {
      j.ays("tmplParams");
    }
    localObject3 = ((StringBuilder)localObject3).append(((TmplParams)localObject4).version).append("\n            md5: ");
    localObject4 = this.jZV;
    if (localObject4 == null) {
      j.ays("tmplParams");
    }
    localObject3 = ((StringBuilder)localObject3).append(((TmplParams)localObject4).cqq).append("\n            time: ");
    localObject4 = this.jZV;
    if (localObject4 == null) {
      j.ays("tmplParams");
    }
    localObject2 = ((StringBuilder)localObject3).append(f.j.hZ(((TmplParams)localObject4).rjN)).append("\n            state: ").append(((f.o)localObject2).aXs()).append("\n\n            [data]\n            dataSize: ").append(f.h.d(aXp() / 1024.0F, 2)).append("Kb\n            dataTime: ").append(this.kbg).append("\n            cached: ").append(f.j.hZ(((Number)this.kaa.getValue()).longValue())).append("\n            version: ").append(((Number)this.kab.getValue()).intValue()).append("\n            expire in: ").append(this.jZW).append("s\n            scene: ").append(this.kbq).append("\n            state: ").append(((f.l)localObject1).aXs()).append("\n\n            [performance](ms)\n            finishType: ").append(this.kbb).append("\n            finishTime: ").append(this.kbc);
    if (this.kbc != Math.max(this.kbj, this.kbl)) {}
    for (localObject1 = "/" + locali.hZ(this.kbl);; localObject1 = "")
    {
      localObject1 = (String)localObject1 + "\n            firstScreenFinish: " + locali.hZ(this.kaf) + '/' + locali.hZ(this.kbl) + "\n            a8keyFinish: " + this.kbj + "\n\n            client:\n            TmplCostTime: " + (this.kav - this.kau) + "\n            WebViewUICostTime: " + (this.kaz - this.kax) + "\n            NotifyPageCostTime: " + (this.kaw - this.kas) + "\n\n            1.bindWebViewCostTime: " + this.kbd + "\n            2.createWebViewCostTime: " + this.kbe + "\n            3.getPageDataCostTime: " + this.kbg + "\n            4.injectCostTime: " + locali.hZ(this.kbf) + "\n            eval cost: " + this.kac + "\n\n            js:\n            4.1.onReceivePageData: " + (this.kat - this.kai) + "\n            5.ctWebCompile: " + this.kah + "\n            6.renderTime: " + this.kag + "\n\n            [js]webReceivePageDataTime: " + this.kbi + "\n            a8KeyFinishTime: " + this.kbj + "\n            getA8KeyCostTime: " + this.kbk + "\n        ";
      j.q(localObject1, "receiver$0");
      localObject1 = m.jv((String)localObject1, "");
      AppMethodBeat.o(14841);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f
 * JD-Core Version:    0.7.0.1
 */