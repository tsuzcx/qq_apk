package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.e;
import d.a.j;
import d.f;
import d.g.a.b;
import d.g.a.m;
import d.g.a.q;
import d.g.b.w;
import d.n.n;
import d.o;
import d.v;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "printDataState", "printDebugger", "prefix", "", "printProcessState", "printTmplState", "printWebViewState", "report", "", "data", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "toString", "format", "kotlin.jvm.PlatformType", "", "digits", "limit", "toDate", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class g
{
  public static final a nGA;
  private final String TAG;
  private String key;
  public long nFA;
  public long nFB;
  public long nFC;
  public long nFD;
  public long nFE;
  public long nFF;
  public long nFG;
  long nFH;
  long nFI;
  long nFJ;
  long nFK;
  long nFL;
  public long nFM;
  public long nFN;
  public long nFO;
  public long nFP;
  public long nFQ;
  public long nFR;
  public long nFS;
  public long nFT;
  public long nFU;
  public boolean nFV;
  public boolean nFW;
  public boolean nFX;
  public boolean nFY;
  public boolean nFZ;
  private final int nFf;
  public dhu nFg;
  public int nFh;
  private final f nFi;
  private final f nFj;
  private final f nFk;
  private final f nFl;
  private long nFm;
  public long nFn;
  public long nFo;
  long nFp;
  public long nFq;
  public long nFr;
  public long nFs;
  public long nFt;
  public long nFu;
  public long nFv;
  public long nFw;
  long nFx;
  public long nFy;
  public long nFz;
  public boolean nGa;
  public boolean nGb;
  public boolean nGc;
  public boolean nGd;
  public boolean nGe;
  public int nGf;
  public boolean nGg;
  public boolean nGh;
  private long nGi;
  private int nGj;
  private long nGk;
  private long nGl;
  private long nGm;
  private long nGn;
  private long nGo;
  private long nGp;
  private long nGq;
  private long nGr;
  private long nGs;
  private long nGt;
  public String nGu;
  private final f nGv;
  public boolean nGw;
  public boolean nGx;
  private final f nGy;
  private long nGz;
  public int nuJ;
  public String url;
  
  static
  {
    AppMethodBeat.i(6601);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bn(g.class), "contentId", "getContentId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bn(g.class), "pageDataSize", "getPageDataSize()I")), (d.l.k)w.a(new d.g.b.u(w.bn(g.class), "dataCachedTime", "getDataCachedTime()J")), (d.l.k)w.a(new d.g.b.u(w.bn(g.class), "dataVersion", "getDataVersion()I")), (d.l.k)w.a(new d.g.b.u(w.bn(g.class), "webviewProcess", "getWebviewProcess()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bn(g.class), "speedMatrix", "getSpeedMatrix()[Ljava/lang/Long;")) };
    nGA = new a((byte)0);
    AppMethodBeat.o(6601);
  }
  
  public g()
  {
    AppMethodBeat.i(6618);
    this.TAG = "MicroMsg.Preload.Kv15862";
    this.nFf = 15862;
    this.key = "";
    this.url = "";
    this.nFi = d.g.K((d.g.a.a)new b(this));
    this.nFj = d.g.K((d.g.a.a)new e(this));
    this.nFk = d.g.K((d.g.a.a)new c(this));
    this.nFl = d.g.K((d.g.a.a)new d(this));
    this.nFm = -1L;
    this.nFz = -1L;
    this.nFA = -1L;
    this.nFB = -1L;
    this.nFC = -1L;
    this.nFD = -1L;
    this.nFE = -1L;
    this.nFF = -1L;
    this.nFG = -1L;
    this.nGu = "";
    this.nGv = d.g.K((d.g.a.a)h.nGD);
    this.nuJ = 10000;
    this.nGy = d.g.K((d.g.a.a)new f(this));
    this.nGz = 3600000L;
    AppMethodBeat.o(6618);
  }
  
  private final String I(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(6610);
    StringBuilder localStringBuilder = new StringBuilder();
    h.a locala = h.nGE;
    if (h.a.bKT()) {
      localStringBuilder.append(paramCharSequence + "no re-direct;");
    }
    locala = h.nGE;
    if (!h.a.bKO()) {
      localStringBuilder.append(paramCharSequence + "no preload data;");
    }
    locala = h.nGE;
    if (h.a.bKU()) {
      localStringBuilder.append(paramCharSequence + "no preload webview;");
    }
    locala = h.nGE;
    if (h.a.bKQ()) {
      localStringBuilder.append(paramCharSequence + "data no expire;");
    }
    locala = h.nGE;
    if (h.a.bKV()) {
      localStringBuilder.append(paramCharSequence + "no red;");
    }
    paramCharSequence = this.nFg;
    if (paramCharSequence == null) {
      d.g.b.k.aVY("tmplParams");
    }
    paramCharSequence = paramCharSequence.FQP;
    d.g.b.k.g(paramCharSequence, "tmplParams.headers");
    if (!n.aD((CharSequence)paramCharSequence)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCharSequence = this.nFg;
        if (paramCharSequence == null) {
          d.g.b.k.aVY("tmplParams");
        }
        localStringBuilder.append(paramCharSequence.FQP);
      }
      if (n.aD((CharSequence)localStringBuilder)) {
        localStringBuilder.append("none;");
      }
      paramCharSequence = localStringBuilder.toString();
      d.g.b.k.g(paramCharSequence, "sb.toString()");
      AppMethodBeat.o(6610);
      return paramCharSequence;
    }
  }
  
  private static String aQ(float paramFloat)
  {
    AppMethodBeat.i(6615);
    String str = String.format("%.2f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(6615);
    return str;
  }
  
  private final String bKD()
  {
    AppMethodBeat.i(6602);
    String str = (String)this.nFi.getValue();
    AppMethodBeat.o(6602);
    return str;
  }
  
  private final int bKE()
  {
    AppMethodBeat.i(6603);
    int i = ((Number)this.nFj.getValue()).intValue();
    AppMethodBeat.o(6603);
    return i;
  }
  
  private final long bKF()
  {
    AppMethodBeat.i(6604);
    long l = ((Number)this.nFk.getValue()).longValue();
    AppMethodBeat.o(6604);
    return l;
  }
  
  private final int bKG()
  {
    AppMethodBeat.i(6605);
    int i = ((Number)this.nFl.getValue()).intValue();
    AppMethodBeat.o(6605);
    return i;
  }
  
  private final String bKH()
  {
    AppMethodBeat.i(6606);
    String str = (String)this.nGv.getValue();
    AppMethodBeat.o(6606);
    return str;
  }
  
  private final Long[] bKI()
  {
    AppMethodBeat.i(6607);
    Long[] arrayOfLong = (Long[])this.nGy.getValue();
    AppMethodBeat.o(6607);
    return arrayOfLong;
  }
  
  private final String bKJ()
  {
    AppMethodBeat.i(6611);
    Object localObject = new StringBuilder();
    if (this.nGf == 1) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.nGe) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (n.aD((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    d.g.b.k.g(localObject, "sb.toString()");
    AppMethodBeat.o(6611);
    return localObject;
  }
  
  private final String bKK()
  {
    AppMethodBeat.i(6612);
    Object localObject = new StringBuilder();
    if (this.nGf == 2) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.nFW) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (!this.nFY)
    {
      ((StringBuilder)localObject).append("tmpl fail;");
      if (!this.nGx) {
        break label146;
      }
      ((StringBuilder)localObject).append("timeout;");
    }
    for (;;)
    {
      if (this.nGc) {
        ((StringBuilder)localObject).append("xweb_cc;");
      }
      if (n.aD((CharSequence)localObject)) {
        ((StringBuilder)localObject).append("ok;");
      }
      localObject = ((StringBuilder)localObject).toString();
      d.g.b.k.g(localObject, "sb.toString()");
      AppMethodBeat.o(6612);
      return localObject;
      if (this.nFX) {
        break;
      }
      ((StringBuilder)localObject).append("inject fail;");
      break;
      label146:
      if (this.nGw) {
        ((StringBuilder)localObject).append("h5;");
      }
    }
  }
  
  private final String bKL()
  {
    AppMethodBeat.i(6613);
    Object localObject = new StringBuilder();
    if (this.nGa) {
      ((StringBuilder)localObject).append("zip;");
    }
    if (this.nGb) {
      ((StringBuilder)localObject).append("prefixMP;");
    }
    if (n.aD((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("none;");
    }
    localObject = ((StringBuilder)localObject).toString();
    d.g.b.k.g(localObject, "sb.toString()");
    AppMethodBeat.o(6613);
    return localObject;
  }
  
  private final String bKM()
  {
    AppMethodBeat.i(6614);
    Object localObject = new StringBuilder();
    if (!this.nFV) {
      ((StringBuilder)localObject).append("async;");
    }
    if (this.nFZ) {
      ((StringBuilder)localObject).append("mounted;");
    }
    if (this.nGd) {
      ((StringBuilder)localObject).append("cache_tmpl;");
    }
    if (n.aD((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    d.g.b.k.g(localObject, "sb.toString()");
    AppMethodBeat.o(6614);
    return localObject;
  }
  
  private final long rq(long paramLong)
  {
    AppMethodBeat.i(6609);
    paramLong = Math.min(Math.max(-this.nGz, paramLong), this.nGz);
    AppMethodBeat.o(6609);
    return paramLong;
  }
  
  private static String rr(long paramLong)
  {
    AppMethodBeat.i(6616);
    String str = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(paramLong));
    d.g.b.k.g(str, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
    AppMethodBeat.o(6616);
    return str;
  }
  
  public final void a(dhu paramdhu)
  {
    AppMethodBeat.i(198878);
    d.g.b.k.h(paramdhu, "<set-?>");
    this.nFg = paramdhu;
    AppMethodBeat.o(198878);
  }
  
  public final void b(q<? super String, ? super String, ? super List<o<String, String>>, d.y> paramq)
  {
    AppMethodBeat.i(6608);
    d.g.b.k.h(paramq, "data");
    if ((!this.nGg) || (!this.nGh))
    {
      AppMethodBeat.o(6608);
      return;
    }
    Object localObject1 = this.nFg;
    if (localObject1 == null) {
      d.g.b.k.aVY("tmplParams");
    }
    com.tencent.mm.plugin.webview.g.a.fS(((dhu)localObject1).reportId, 132);
    Object localObject3 = d.bKC();
    this.nGi = Math.max(this.nFo, this.nFy);
    if (this.nFo < this.nFy) {}
    int j;
    long l1;
    int k;
    for (int i = 1;; i = 2)
    {
      this.nGj = i;
      this.nGk = (this.nGi - this.nFn);
      this.nGq = (this.nFs - this.nFn);
      this.nGp = (this.nFC - this.nFD);
      this.nGr = (this.nFy - this.nFn);
      this.nGs = (this.nFy - this.nFx);
      this.nFp = (this.nFo - this.nFn);
      this.nGl = (this.nFz - this.nFn);
      this.nGm = (this.nFA - this.nFz);
      this.nGo = (this.nFu - this.nFt);
      this.nGn = (this.nFC - this.nFB);
      this.nFm = (this.nFC - this.nFD);
      this.nGt = (this.nGl + this.nGm + this.nGo + this.nGn + this.nFr + this.nFq);
      localObject1 = this.TAG;
      Object localObject4 = this.nFg;
      if (localObject4 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      i = ((dhu)localObject4).version;
      localObject4 = this.url;
      j = bKE();
      l1 = this.nGk;
      k = this.nGj;
      long l2 = this.nFq;
      long l3 = this.nGr;
      boolean bool1 = this.nFW;
      long l4 = this.nFF;
      long l5 = this.nFE;
      boolean bool2 = this.nFV;
      long l6 = this.nGo;
      long l7 = this.nGs;
      long l8 = this.nGq;
      long l9 = this.nFr;
      long l10 = this.nFq;
      Object localObject5 = this.nFg;
      if (localObject5 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      int m = ((dhu)localObject5).nGQ;
      localObject5 = this.nFg;
      if (localObject5 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      ac.d((String)localObject1, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", new Object[] { Integer.valueOf(i), localObject4, Integer.valueOf(j), localObject3, Long.valueOf(l1), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Long.valueOf(l4 - l5), Boolean.valueOf(bool2), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Integer.valueOf(m), ((dhu)localObject5).znF, this.nGu, bKH(), Integer.valueOf(this.nuJ), Long.valueOf(this.nGp), Boolean.valueOf(this.nGe) });
      if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
        bool1 = com.tencent.mm.sdk.platformtools.h.DEBUG;
      }
      try
      {
        localObject1 = this.url;
        if (localObject1 == null) {
          d.g.b.k.fOy();
        }
        localObject1 = p.encode((String)localObject1, "UTF-8");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        Object localObject2;
        for (;;)
        {
          int n;
          int i1;
          int i2;
          int i3;
          Object localObject6;
          Object localObject7;
          int i4;
          o localo1;
          o localo2;
          o localo3;
          o localo4;
          o localo5;
          Object localObject8;
          Object localObject9;
          Object localObject10;
          Object localObject11;
          dhu localdhu;
          ac.printErrStackTrace(this.TAG, (Throwable)localUnsupportedEncodingException, "url:%d", new Object[] { this.url });
          localObject2 = null;
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
          com.tencent.mm.plugin.webview.g.a.aA(20, this.nGk);
          com.tencent.mm.plugin.webview.g.a.aA(21, this.nFp);
          com.tencent.mm.plugin.webview.g.a.aA(22, l1);
          com.tencent.mm.plugin.webview.g.a.aA(23, this.nFI - this.nFH);
          if (!this.nFV)
          {
            com.tencent.mm.plugin.webview.g.a.aA(24, this.nFw - this.nFv);
            com.tencent.mm.plugin.webview.g.a.Ve(107);
          }
        }
        paramq.d("['FirstScreen', 'BindMP', 'WebView', 'WebViewUI', null, 'BindMM', 'JsAPI', 'GetA8Key', 'GetData', 'InjectData']", localObject2, localObject3);
        ac.i(this.TAG, "terry performance report:" + this.nFn + '\n' + e.a(bKI(), null, null, null, 0, null, null, 63));
        AppMethodBeat.o(6608);
      }
      localObject4 = com.tencent.mm.plugin.report.service.h.wUl;
      m = this.nFf;
      localObject5 = this.nFg;
      if (localObject5 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      n = ((dhu)localObject5).version;
      i1 = bKE();
      l1 = rq(this.nGk);
      i2 = this.nGj;
      l2 = rq(this.nFp);
      l3 = rq(this.nGr);
      if (!this.nFW) {
        break;
      }
      i = 1;
      l4 = rq(this.nFF - this.nFE);
      if (!this.nFV) {
        break label2308;
      }
      j = 1;
      l5 = rq(this.nGo);
      l6 = rq(this.nGs);
      l7 = rq(this.nGq);
      l8 = rq(this.nFr);
      l9 = rq(this.nFq);
      localObject5 = this.nFg;
      if (localObject5 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      i3 = ((dhu)localObject5).nGQ;
      localObject5 = this.nFg;
      if (localObject5 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      localObject5 = ((dhu)localObject5).znF;
      localObject6 = this.nGu;
      localObject7 = bKH();
      i4 = this.nuJ;
      l10 = rq(this.nGp);
      if (!this.nGe) {
        break label2313;
      }
      k = 1;
      ((com.tencent.mm.plugin.report.service.h)localObject4).f(m, new Object[] { Integer.valueOf(n), localObject1, Integer.valueOf(i1), localObject3, Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l4), Integer.valueOf(j), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i3), localObject5, localObject6, localObject7, Integer.valueOf(i4), Long.valueOf(l10), Integer.valueOf(k), Long.valueOf(rq(this.nGl)), Long.valueOf(rq(this.nGm)), Long.valueOf(rq(this.nGn)) });
      localObject4 = com.tencent.mm.plugin.report.service.h.wUl;
      localObject5 = new d.g.b.y(19);
      ((d.g.b.y)localObject5).add(localObject1);
      ((d.g.b.y)localObject5).add(Integer.valueOf(this.nuJ));
      ((d.g.b.y)localObject5).add(localObject3);
      ((d.g.b.y)localObject5).add(Integer.valueOf(bKE()));
      localObject1 = this.nFg;
      if (localObject1 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      ((d.g.b.y)localObject5).add(((dhu)localObject1).znF);
      ((d.g.b.y)localObject5).add(bKH());
      ((d.g.b.y)localObject5).add(this.nGu);
      if (!this.nFV) {
        break label2319;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      if (this.nGe) {
        break label2324;
      }
      i = 1;
      if (i == 0) {
        break label2329;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      if (this.nFW) {
        break label2334;
      }
      i = 1;
      if (i == 0) {
        break label2339;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      ((d.g.b.y)localObject5).add(Integer.valueOf(this.nGf));
      if (!this.nFZ) {
        break label2344;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      if (!this.nFX) {
        break label2349;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      ((d.g.b.y)localObject5).add(Long.valueOf(this.nGk));
      ((d.g.b.y)localObject5).eL(bKI());
      ((d.g.b.y)localObject5).add(this.key);
      if (!this.nGa) {
        break label2354;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      if (!this.nGc) {
        break label2359;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      ((d.g.b.y)localObject5).add(Long.valueOf(this.nFG));
      ((com.tencent.mm.plugin.report.service.h)localObject4).f(16874, ((d.g.b.y)localObject5).toArray(new Object[((d.g.b.y)localObject5).cQJ.size()]));
      com.tencent.mm.plugin.webview.g.a.Ve(0);
      if (this.nGa)
      {
        com.tencent.mm.plugin.webview.g.a.Ve(111);
        localObject1 = this.nFg;
        if (localObject1 == null) {
          d.g.b.k.aVY("tmplParams");
        }
        com.tencent.mm.plugin.webview.g.a.fS(((dhu)localObject1).reportId, 232);
      }
      if (this.nGc) {
        com.tencent.mm.plugin.webview.g.a.Ve(113);
      }
      com.tencent.mm.plugin.webview.g.a.aA(1, this.nGk);
      com.tencent.mm.plugin.webview.g.a.aA(2, this.nFp);
      l1 = this.nFz - this.nFn;
      if (!this.nGe) {
        break label2364;
      }
      com.tencent.mm.plugin.webview.g.a.aA(10, this.nGk);
      com.tencent.mm.plugin.webview.g.a.aA(11, this.nFp);
      com.tencent.mm.plugin.webview.g.a.aA(12, l1);
      com.tencent.mm.plugin.webview.g.a.aA(13, this.nFI - this.nFH);
      com.tencent.mm.plugin.webview.g.a.aA(14, this.nFF - this.nFE);
      com.tencent.mm.plugin.webview.g.a.aA(15, this.nFC - this.nFB);
      localObject1 = "[" + j.a((Iterable)e.T(bKI()), null, null, null, 0, null, null, 63) + ']';
      localObject3 = d.u.Q("section", "[debug]");
      localObject4 = d.u.Q("info", bKD());
      localObject5 = d.u.Q("settings", I((CharSequence)""));
      localObject6 = d.u.Q("section", "[process]");
      localObject7 = d.u.Q("process", bKH());
      localo1 = d.u.Q("state", bKJ());
      localo2 = d.u.Q("section", "[webview]");
      localo3 = d.u.Q("kind", this.nGu);
      localo4 = d.u.Q("state", bKK());
      localo5 = d.u.Q("section", "[tmpl]");
      localObject8 = this.nFg;
      if (localObject8 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      localObject8 = d.u.Q("uid", ((dhu)localObject8).znF);
      localObject9 = this.nFg;
      if (localObject9 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      localObject9 = d.u.Q("tmplType", String.valueOf(((dhu)localObject9).nGQ));
      localObject10 = this.nFg;
      if (localObject10 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      localObject10 = d.u.Q("version", String.valueOf(((dhu)localObject10).version));
      localObject11 = this.nFg;
      if (localObject11 == null) {
        d.g.b.k.aVY("tmplParams");
      }
      localObject11 = d.u.Q("md5", ((dhu)localObject11).md5);
      localdhu = this.nFg;
      if (localdhu == null) {
        d.g.b.k.aVY("tmplParams");
      }
      localObject3 = j.listOf(new o[] { localObject3, localObject4, localObject5, localObject6, localObject7, localo1, localo2, localo3, localo4, localo5, localObject8, localObject9, localObject10, localObject11, d.u.Q("time", rr(localdhu.xYl)), d.u.Q("state", bKL()), d.u.Q("section", "[data]"), d.u.Q("dataSize", aQ(bKE() / 1024.0F) + "Kb"), d.u.Q("dataTime", String.valueOf(this.nGo)), d.u.Q("cached", rr(bKF())), d.u.Q("version", String.valueOf(bKG())), d.u.Q("expire in", this.nFh + 's'), d.u.Q("scene", String.valueOf(this.nuJ)), d.u.Q("state", bKM()) });
      if (localObject3 != null) {
        break label2432;
      }
      paramq = new v("null cannot be cast to non-null type kotlin.collections.List<kotlin.Pair<kotlin.String, kotlin.String>>");
      AppMethodBeat.o(6608);
      throw paramq;
    }
    label2308:
    label2313:
    label2319:
    label2324:
    label2329:
    label2334:
    label2339:
    label2344:
    label2349:
    label2354:
    label2359:
    label2364:
    return;
  }
  
  public final void setKey(String paramString)
  {
    AppMethodBeat.i(198879);
    d.g.b.k.h(paramString, "<set-?>");
    this.key = paramString;
    AppMethodBeat.o(198879);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6617);
    g localg = new g(this);
    ac.v(this.TAG, "terry performance log:\n" + this.nGl + ',' + this.nGm + ',' + (this.nFI - this.nFA) + ',' + (Math.max(this.nFI, this.nFF) - this.nFI) + ',' + (this.nFB - Math.max(this.nFI, this.nFF)) + ',' + this.nGn);
    ac.v(this.TAG, "terry performance timestamp:\n " + e.a(bKI(), null, null, null, 0, null, null, 63));
    Object localObject1 = new StringBuilder("\n            [debug]\n            info: ").append(bKD()).append("\n            settings: ").append(I((CharSequence)"\n")).append("\n\n            [process]\n            process: ").append(bKH()).append("\n            state: ").append(bKJ()).append("\n\n            [webview]\n            kind: ").append(this.nGu).append("\n            state: ").append(bKK()).append("\n\n            [tmpl]\n            uid: ");
    Object localObject2 = this.nFg;
    if (localObject2 == null) {
      d.g.b.k.aVY("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dhu)localObject2).znF).append("\n            tmplType: ");
    localObject2 = this.nFg;
    if (localObject2 == null) {
      d.g.b.k.aVY("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dhu)localObject2).nGQ).append("\n            version: ");
    localObject2 = this.nFg;
    if (localObject2 == null) {
      d.g.b.k.aVY("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dhu)localObject2).version).append("\n            md5: ");
    localObject2 = this.nFg;
    if (localObject2 == null) {
      d.g.b.k.aVY("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dhu)localObject2).md5).append("\n            time: ");
    localObject2 = this.nFg;
    if (localObject2 == null) {
      d.g.b.k.aVY("tmplParams");
    }
    localObject2 = ((StringBuilder)localObject1).append(rr(((dhu)localObject2).xYl)).append("\n            state: ").append(bKL()).append("\n\n            [data]\n            dataSize: ").append(aQ(bKE() / 1024.0F)).append("Kb\n            dataTime: ").append(this.nGo).append("\n            cached: ").append(rr(bKF())).append("\n            version: ").append(bKG()).append("\n            expire in: ").append(this.nFh).append("s\n            scene: ").append(this.nuJ).append("\n            state: ").append(bKM()).append("\n\n            [performance](ms)\n            finishType: ").append(this.nGj).append("\n            finishTime: ").append(this.nGk);
    if (this.nGk != Math.max(this.nGr, this.nGt)) {}
    for (localObject1 = "/" + localg.rs(this.nGt);; localObject1 = "")
    {
      localObject1 = n.aWZ((String)localObject1 + "\n            firstScreenFinish: " + localg.rs(this.nFp) + '/' + localg.rs(this.nGt) + "\n            a8keyFinish: " + this.nGr + "\n\n            client:\n            TmplCostTime: " + (this.nFF - this.nFE) + "\n            WebViewUICostTime: " + (this.nFI - this.nFH) + "\n            NotifyPageCostTime: " + (this.nFG - this.nFC) + "\n\n            1.bindWebViewCostTime: " + this.nGl + "\n            2.createWebViewCostTime: " + this.nGm + "\n            3.getPageDataCostTime: " + this.nGo + "\n            4.injectCostTime: " + localg.rs(this.nGn) + "\n            eval cost: " + this.nFm + "\n\n            js:\n            4.1.onReceivePageData: " + (this.nFD - this.nFs) + "\n            5.ctWebCompile: " + this.nFr + "\n            6.renderTime: " + this.nFq + "\n\n            [js]webReceivePageDataTime: " + this.nGq + "\n            a8KeyFinishTime: " + this.nGr + "\n            getA8KeyCostTime: " + this.nGs + "\n        ");
      AppMethodBeat.o(6617);
      return localObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
  public static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Long>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<Long[]>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"verify", "", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements b<Long, String>
  {
    g(g paramg)
    {
      super();
    }
    
    public final String rs(long paramLong)
    {
      AppMethodBeat.i(6598);
      if (g.a(this.nGB, paramLong))
      {
        AppMethodBeat.o(6598);
        return String.valueOf(paramLong);
      }
      AppMethodBeat.o(6598);
      return "NaN";
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    public static final h nGD;
    
    static
    {
      AppMethodBeat.i(6600);
      nGD = new h();
      AppMethodBeat.o(6600);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.g
 * JD-Core Version:    0.7.0.1
 */