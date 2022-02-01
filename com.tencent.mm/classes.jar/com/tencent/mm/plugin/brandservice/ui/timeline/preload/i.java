package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.a.e;
import kotlin.g;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "printDataState", "printDebugger", "prefix", "", "printProcessState", "printTmplState", "printWebViewState", "report", "", "data", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "toString", "format", "", "digits", "limit", "toDate", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class i
{
  public static final a sMK;
  private final String TAG;
  private String key;
  public boolean npI;
  long sLA;
  public long sLB;
  public long sLC;
  public long sLD;
  public long sLE;
  public long sLF;
  public long sLG;
  public long sLH;
  long sLI;
  public long sLJ;
  public long sLK;
  public long sLL;
  public long sLM;
  public long sLN;
  public long sLO;
  public long sLP;
  public long sLQ;
  public long sLR;
  long sLS;
  long sLT;
  long sLU;
  long sLV;
  long sLW;
  public long sLX;
  public long sLY;
  public long sLZ;
  private final int sLq;
  public ese sLr;
  public int sLs;
  private final kotlin.f sLt;
  private final kotlin.f sLu;
  private final kotlin.f sLv;
  private final kotlin.f sLw;
  private long sLx;
  public long sLy;
  public long sLz;
  private long sMA;
  private long sMB;
  private long sMC;
  private long sMD;
  public String sME;
  private final kotlin.f sMF;
  public boolean sMG;
  public boolean sMH;
  private final kotlin.f sMI;
  private long sMJ;
  public long sMa;
  public long sMb;
  public long sMc;
  public long sMd;
  public long sMe;
  public long sMf;
  public boolean sMg;
  public boolean sMh;
  public boolean sMi;
  public boolean sMj;
  public boolean sMk;
  public boolean sMl;
  public boolean sMm;
  public boolean sMn;
  public boolean sMo;
  public int sMp;
  public boolean sMq;
  public boolean sMr;
  private long sMs;
  private int sMt;
  private long sMu;
  private long sMv;
  private long sMw;
  private long sMx;
  private long sMy;
  private long sMz;
  public int svv;
  public String url;
  
  static
  {
    AppMethodBeat.i(6601);
    sMK = new a((byte)0);
    AppMethodBeat.o(6601);
  }
  
  public i()
  {
    AppMethodBeat.i(6618);
    this.TAG = "MicroMsg.Preload.Kv15862";
    this.sLq = 15862;
    this.key = "";
    this.url = "";
    this.sLt = g.ar((kotlin.g.a.a)new b(this));
    this.sLu = g.ar((kotlin.g.a.a)new e(this));
    this.sLv = g.ar((kotlin.g.a.a)new c(this));
    this.sLw = g.ar((kotlin.g.a.a)new d(this));
    this.sLx = -1L;
    this.sLK = -1L;
    this.sLL = -1L;
    this.sLM = -1L;
    this.sLN = -1L;
    this.sLO = -1L;
    this.sLP = -1L;
    this.sLQ = -1L;
    this.sLR = -1L;
    this.sME = "";
    this.sMF = g.ar((kotlin.g.a.a)h.sMN);
    this.svv = 10000;
    this.sMI = g.ar((kotlin.g.a.a)new f(this));
    this.sMJ = 3600000L;
    AppMethodBeat.o(6618);
  }
  
  private final long HT(long paramLong)
  {
    AppMethodBeat.i(6609);
    paramLong = Math.min(Math.max(-this.sMJ, paramLong), this.sMJ);
    AppMethodBeat.o(6609);
    return paramLong;
  }
  
  private static String HU(long paramLong)
  {
    AppMethodBeat.i(6616);
    String str = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(paramLong));
    p.j(str, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
    AppMethodBeat.o(6616);
    return str;
  }
  
  private final String U(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(6610);
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.sMO;
    if (j.a.cCg()) {
      localStringBuilder.append(paramCharSequence + "no re-direct;");
    }
    locala = j.sMO;
    if (!j.a.cCb()) {
      localStringBuilder.append(paramCharSequence + "no preload data;");
    }
    locala = j.sMO;
    if (j.a.cCh()) {
      localStringBuilder.append(paramCharSequence + "no preload webview;");
    }
    locala = j.sMO;
    if (j.a.cCd()) {
      localStringBuilder.append(paramCharSequence + "data no expire;");
    }
    locala = j.sMO;
    if (j.a.cCi()) {
      localStringBuilder.append(paramCharSequence + "no red;");
    }
    paramCharSequence = this.sLr;
    if (paramCharSequence == null) {
      p.bGy("tmplParams");
    }
    paramCharSequence = paramCharSequence.UtY;
    p.j(paramCharSequence, "tmplParams.headers");
    if (!n.ba((CharSequence)paramCharSequence)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCharSequence = this.sLr;
        if (paramCharSequence == null) {
          p.bGy("tmplParams");
        }
        localStringBuilder.append(paramCharSequence.UtY);
      }
      if (n.ba((CharSequence)localStringBuilder)) {
        localStringBuilder.append("none;");
      }
      paramCharSequence = localStringBuilder.toString();
      p.j(paramCharSequence, "sb.toString()");
      AppMethodBeat.o(6610);
      return paramCharSequence;
    }
  }
  
  private static String ba(float paramFloat)
  {
    AppMethodBeat.i(6615);
    String str = String.format("%.2f", new Object[] { Float.valueOf(paramFloat) });
    p.j(str, "java.lang.String.format(\"%.${digits}f\", this)");
    AppMethodBeat.o(6615);
    return str;
  }
  
  private final String cBQ()
  {
    AppMethodBeat.i(6602);
    String str = (String)this.sLt.getValue();
    AppMethodBeat.o(6602);
    return str;
  }
  
  private final int cBR()
  {
    AppMethodBeat.i(6603);
    int i = ((Number)this.sLu.getValue()).intValue();
    AppMethodBeat.o(6603);
    return i;
  }
  
  private final long cBS()
  {
    AppMethodBeat.i(6604);
    long l = ((Number)this.sLv.getValue()).longValue();
    AppMethodBeat.o(6604);
    return l;
  }
  
  private final int cBT()
  {
    AppMethodBeat.i(6605);
    int i = ((Number)this.sLw.getValue()).intValue();
    AppMethodBeat.o(6605);
    return i;
  }
  
  private final String cBU()
  {
    AppMethodBeat.i(6606);
    String str = (String)this.sMF.getValue();
    AppMethodBeat.o(6606);
    return str;
  }
  
  private final Long[] cBV()
  {
    AppMethodBeat.i(6607);
    Long[] arrayOfLong = (Long[])this.sMI.getValue();
    AppMethodBeat.o(6607);
    return arrayOfLong;
  }
  
  private final String cBW()
  {
    AppMethodBeat.i(6611);
    Object localObject = new StringBuilder();
    if (this.sMp == 1) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.sMo) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (n.ba((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.j(localObject, "sb.toString()");
    AppMethodBeat.o(6611);
    return localObject;
  }
  
  private final String cBX()
  {
    AppMethodBeat.i(6612);
    Object localObject = new StringBuilder();
    if (this.sMp == 2) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.sMh) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (!this.sMj)
    {
      p.j(((StringBuilder)localObject).append("tmpl fail;"), "sb.append(\"tmpl fail;\")");
      if (!this.sMH) {
        break label156;
      }
      p.j(((StringBuilder)localObject).append("timeout;"), "sb.append(\"timeout;\")");
    }
    for (;;)
    {
      if (this.sMm) {
        ((StringBuilder)localObject).append("xweb_cc;");
      }
      if (n.ba((CharSequence)localObject)) {
        ((StringBuilder)localObject).append("ok;");
      }
      localObject = ((StringBuilder)localObject).toString();
      p.j(localObject, "sb.toString()");
      AppMethodBeat.o(6612);
      return localObject;
      if (this.sMi) {
        break;
      }
      ((StringBuilder)localObject).append("inject fail;");
      break;
      label156:
      if (this.sMG) {
        ((StringBuilder)localObject).append("h5;");
      }
    }
  }
  
  private final String cBY()
  {
    AppMethodBeat.i(6613);
    Object localObject = new StringBuilder();
    if (this.npI) {
      ((StringBuilder)localObject).append("zip;");
    }
    if (this.sMl) {
      ((StringBuilder)localObject).append("prefixMP;");
    }
    if (n.ba((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("none;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.j(localObject, "sb.toString()");
    AppMethodBeat.o(6613);
    return localObject;
  }
  
  private final String cBZ()
  {
    AppMethodBeat.i(6614);
    Object localObject = new StringBuilder();
    if (!this.sMg) {
      ((StringBuilder)localObject).append("async;");
    }
    if (this.sMk) {
      ((StringBuilder)localObject).append("mounted;");
    }
    if (this.sMn) {
      ((StringBuilder)localObject).append("cache_tmpl;");
    }
    if (n.ba((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.j(localObject, "sb.toString()");
    AppMethodBeat.o(6614);
    return localObject;
  }
  
  public final void a(ese paramese)
  {
    AppMethodBeat.i(265536);
    p.k(paramese, "<set-?>");
    this.sLr = paramese;
    AppMethodBeat.o(265536);
  }
  
  public final void b(kotlin.g.a.q<? super String, ? super String, ? super List<o<String, String>>, x> paramq)
  {
    AppMethodBeat.i(6608);
    p.k(paramq, "data");
    if ((!this.sMq) || (!this.sMr))
    {
      AppMethodBeat.o(6608);
      return;
    }
    Object localObject1 = this.sLr;
    if (localObject1 == null) {
      p.bGy("tmplParams");
    }
    com.tencent.mm.plugin.webview.h.a.gU(((ese)localObject1).reportId, 132);
    Object localObject3 = f.getNetWorkType();
    this.sMs = Math.max(this.sLz, this.sLJ);
    if (this.sLz < this.sLJ) {}
    int j;
    long l1;
    int k;
    for (int i = 1;; i = 2)
    {
      this.sMt = i;
      this.sMu = (this.sMs - this.sLy);
      this.sMA = (this.sLD - this.sLy);
      this.sMz = (this.sLN - this.sLO);
      this.sMB = (this.sLJ - this.sLy);
      this.sMC = (this.sLJ - this.sLI);
      this.sLA = (this.sLz - this.sLy);
      this.sMv = (this.sLK - this.sLy);
      this.sMw = (this.sLL - this.sLK);
      this.sMy = (this.sLF - this.sLE);
      this.sMx = (this.sLN - this.sLM);
      this.sLx = (this.sLN - this.sLO);
      this.sMD = (this.sMv + this.sMw + this.sMy + this.sMx + this.sLC + this.sLB);
      localObject1 = this.TAG;
      Object localObject4 = this.sLr;
      if (localObject4 == null) {
        p.bGy("tmplParams");
      }
      i = ((ese)localObject4).version;
      localObject4 = this.url;
      j = cBR();
      l1 = this.sMu;
      k = this.sMt;
      long l2 = this.sLB;
      long l3 = this.sMB;
      boolean bool1 = this.sMh;
      long l4 = this.sLQ;
      long l5 = this.sLP;
      boolean bool2 = this.sMg;
      long l6 = this.sMy;
      long l7 = this.sMC;
      long l8 = this.sMA;
      long l9 = this.sLC;
      long l10 = this.sLB;
      Object localObject5 = this.sLr;
      if (localObject5 == null) {
        p.bGy("tmplParams");
      }
      int m = ((ese)localObject5).sNh;
      localObject5 = this.sLr;
      if (localObject5 == null) {
        p.bGy("tmplParams");
      }
      Log.d((String)localObject1, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", new Object[] { Integer.valueOf(i), localObject4, Integer.valueOf(j), localObject3, Long.valueOf(l1), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Long.valueOf(l4 - l5), Boolean.valueOf(bool2), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Integer.valueOf(m), ((ese)localObject5).ktM, this.sME, cBU(), Integer.valueOf(this.svv), Long.valueOf(this.sMz), Boolean.valueOf(this.sMo) });
      if (!BuildInfo.IS_FLAVOR_RED) {
        bool1 = BuildInfo.DEBUG;
      }
      try
      {
        localObject1 = this.url;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = com.tencent.mm.compatible.util.q.an((String)localObject1, "UTF-8");
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
          ese localese;
          Log.printErrStackTrace(this.TAG, (Throwable)localUnsupportedEncodingException, "url:%d", new Object[] { this.url });
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
          com.tencent.mm.plugin.webview.h.a.bb(20, this.sMu);
          com.tencent.mm.plugin.webview.h.a.bb(21, this.sLA);
          com.tencent.mm.plugin.webview.h.a.bb(22, l1);
          com.tencent.mm.plugin.webview.h.a.bb(23, this.sLT - this.sLS);
          if (!this.sMg)
          {
            com.tencent.mm.plugin.webview.h.a.bb(24, this.sLH - this.sLG);
            com.tencent.mm.plugin.webview.h.a.anX(107);
          }
        }
        paramq.c("['FirstScreen', 'BindMP', 'WebView', 'WebViewUI', null, 'BindMM', 'JsAPI', 'GetA8Key', 'GetData', 'InjectData']", localObject2, localObject3);
        Log.i(this.TAG, "terry performance report:" + this.sLy + '\n' + e.a(cBV(), null, null, null, 0, null, null, 63));
        AppMethodBeat.o(6608);
      }
      localObject4 = h.IzE;
      m = this.sLq;
      localObject5 = this.sLr;
      if (localObject5 == null) {
        p.bGy("tmplParams");
      }
      n = ((ese)localObject5).version;
      i1 = cBR();
      l1 = HT(this.sMu);
      i2 = this.sMt;
      l2 = HT(this.sLA);
      l3 = HT(this.sMB);
      if (!this.sMh) {
        break;
      }
      i = 1;
      l4 = HT(this.sLQ - this.sLP);
      if (!this.sMg) {
        break label2308;
      }
      j = 1;
      l5 = HT(this.sMy);
      l6 = HT(this.sMC);
      l7 = HT(this.sMA);
      l8 = HT(this.sLC);
      l9 = HT(this.sLB);
      localObject5 = this.sLr;
      if (localObject5 == null) {
        p.bGy("tmplParams");
      }
      i3 = ((ese)localObject5).sNh;
      localObject5 = this.sLr;
      if (localObject5 == null) {
        p.bGy("tmplParams");
      }
      localObject5 = ((ese)localObject5).ktM;
      localObject6 = this.sME;
      localObject7 = cBU();
      i4 = this.svv;
      l10 = HT(this.sMz);
      if (!this.sMo) {
        break label2313;
      }
      k = 1;
      ((h)localObject4).a(m, new Object[] { Integer.valueOf(n), localObject1, Integer.valueOf(i1), localObject3, Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l4), Integer.valueOf(j), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i3), localObject5, localObject6, localObject7, Integer.valueOf(i4), Long.valueOf(l10), Integer.valueOf(k), Long.valueOf(HT(this.sMv)), Long.valueOf(HT(this.sMw)), Long.valueOf(HT(this.sMx)) });
      localObject4 = h.IzE;
      localObject5 = new ae(19);
      ((ae)localObject5).add(localObject1);
      ((ae)localObject5).add(Integer.valueOf(this.svv));
      ((ae)localObject5).add(localObject3);
      ((ae)localObject5).add(Integer.valueOf(cBR()));
      localObject1 = this.sLr;
      if (localObject1 == null) {
        p.bGy("tmplParams");
      }
      ((ae)localObject5).add(((ese)localObject1).ktM);
      ((ae)localObject5).add(cBU());
      ((ae)localObject5).add(this.sME);
      if (!this.sMg) {
        break label2319;
      }
      i = 1;
      ((ae)localObject5).add(Integer.valueOf(i));
      if (this.sMo) {
        break label2324;
      }
      i = 1;
      if (i == 0) {
        break label2329;
      }
      i = 1;
      ((ae)localObject5).add(Integer.valueOf(i));
      if (this.sMh) {
        break label2334;
      }
      i = 1;
      if (i == 0) {
        break label2339;
      }
      i = 1;
      ((ae)localObject5).add(Integer.valueOf(i));
      ((ae)localObject5).add(Integer.valueOf(this.sMp));
      if (!this.sMk) {
        break label2344;
      }
      i = 1;
      ((ae)localObject5).add(Integer.valueOf(i));
      if (!this.sMi) {
        break label2349;
      }
      i = 1;
      ((ae)localObject5).add(Integer.valueOf(i));
      ((ae)localObject5).add(Long.valueOf(this.sMu));
      ((ae)localObject5).eZ(cBV());
      ((ae)localObject5).add(this.key);
      if (!this.npI) {
        break label2354;
      }
      i = 1;
      ((ae)localObject5).add(Integer.valueOf(i));
      if (!this.sMm) {
        break label2359;
      }
      i = 1;
      ((ae)localObject5).add(Integer.valueOf(i));
      ((ae)localObject5).add(Long.valueOf(this.sLR));
      ((h)localObject4).a(16874, ((ae)localObject5).toArray(new Object[((ae)localObject5).fmA.size()]));
      com.tencent.mm.plugin.webview.h.a.anX(0);
      if (this.npI)
      {
        com.tencent.mm.plugin.webview.h.a.anX(111);
        localObject1 = this.sLr;
        if (localObject1 == null) {
          p.bGy("tmplParams");
        }
        com.tencent.mm.plugin.webview.h.a.gU(((ese)localObject1).reportId, 232);
      }
      if (this.sMm) {
        com.tencent.mm.plugin.webview.h.a.anX(113);
      }
      com.tencent.mm.plugin.webview.h.a.bb(1, this.sMu);
      com.tencent.mm.plugin.webview.h.a.bb(2, this.sLA);
      l1 = this.sLK - this.sLy;
      if (!this.sMo) {
        break label2364;
      }
      com.tencent.mm.plugin.webview.h.a.bb(10, this.sMu);
      com.tencent.mm.plugin.webview.h.a.bb(11, this.sLA);
      com.tencent.mm.plugin.webview.h.a.bb(12, l1);
      com.tencent.mm.plugin.webview.h.a.bb(13, this.sLT - this.sLS);
      com.tencent.mm.plugin.webview.h.a.bb(14, this.sLQ - this.sLP);
      com.tencent.mm.plugin.webview.h.a.bb(15, this.sLN - this.sLM);
      localObject1 = "[" + kotlin.a.j.a((Iterable)e.Y(cBV()), null, null, null, 0, null, null, 63) + ']';
      localObject3 = s.M("section", "[debug]");
      localObject4 = s.M("info", cBQ());
      localObject5 = s.M("settings", U((CharSequence)""));
      localObject6 = s.M("section", "[process]");
      localObject7 = s.M("process", cBU());
      localo1 = s.M("state", cBW());
      localo2 = s.M("section", "[webview]");
      localo3 = s.M("kind", this.sME);
      localo4 = s.M("state", cBX());
      localo5 = s.M("section", "[tmpl]");
      localObject8 = this.sLr;
      if (localObject8 == null) {
        p.bGy("tmplParams");
      }
      localObject8 = s.M("uid", ((ese)localObject8).ktM);
      localObject9 = this.sLr;
      if (localObject9 == null) {
        p.bGy("tmplParams");
      }
      localObject9 = s.M("tmplType", String.valueOf(((ese)localObject9).sNh));
      localObject10 = this.sLr;
      if (localObject10 == null) {
        p.bGy("tmplParams");
      }
      localObject10 = s.M("version", String.valueOf(((ese)localObject10).version));
      localObject11 = this.sLr;
      if (localObject11 == null) {
        p.bGy("tmplParams");
      }
      localObject11 = s.M("md5", ((ese)localObject11).md5);
      localese = this.sLr;
      if (localese == null) {
        p.bGy("tmplParams");
      }
      localObject3 = kotlin.a.j.listOf(new o[] { localObject3, localObject4, localObject5, localObject6, localObject7, localo1, localo2, localo3, localo4, localo5, localObject8, localObject9, localObject10, localObject11, s.M("time", HU(localese.KcG)), s.M("state", cBY()), s.M("section", "[data]"), s.M("dataSize", ba(cBR() / 1024.0F) + "Kb"), s.M("dataTime", String.valueOf(this.sMy)), s.M("cached", HU(cBS())), s.M("version", String.valueOf(cBT())), s.M("expire in", this.sLs + 's'), s.M("scene", String.valueOf(this.svv)), s.M("state", cBZ()) });
      if (localObject3 != null) {
        break label2432;
      }
      paramq = new t("null cannot be cast to non-null type kotlin.collections.List<kotlin.Pair<kotlin.String, kotlin.String>>");
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
    AppMethodBeat.i(265537);
    p.k(paramString, "<set-?>");
    this.key = paramString;
    AppMethodBeat.o(265537);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6617);
    g localg = new g(this);
    Log.v(this.TAG, "terry performance log:\n" + this.sMv + ',' + this.sMw + ',' + (this.sLT - this.sLL) + ',' + (Math.max(this.sLT, this.sLQ) - this.sLT) + ',' + (this.sLM - Math.max(this.sLT, this.sLQ)) + ',' + this.sMx);
    Log.v(this.TAG, "terry performance timestamp:\n " + e.a(cBV(), null, null, null, 0, null, null, 63));
    Object localObject1 = new StringBuilder("\n            [debug]\n            info: ").append(cBQ()).append("\n            settings: ").append(U((CharSequence)"\n")).append("\n\n            [process]\n            process: ").append(cBU()).append("\n            state: ").append(cBW()).append("\n\n            [webview]\n            kind: ").append(this.sME).append("\n            state: ").append(cBX()).append("\n\n            [tmpl]\n            uid: ");
    Object localObject2 = this.sLr;
    if (localObject2 == null) {
      p.bGy("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((ese)localObject2).ktM).append("\n            tmplType: ");
    localObject2 = this.sLr;
    if (localObject2 == null) {
      p.bGy("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((ese)localObject2).sNh).append("\n            version: ");
    localObject2 = this.sLr;
    if (localObject2 == null) {
      p.bGy("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((ese)localObject2).version).append("\n            md5: ");
    localObject2 = this.sLr;
    if (localObject2 == null) {
      p.bGy("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((ese)localObject2).md5).append("\n            time: ");
    localObject2 = this.sLr;
    if (localObject2 == null) {
      p.bGy("tmplParams");
    }
    localObject2 = ((StringBuilder)localObject1).append(HU(((ese)localObject2).KcG)).append("\n            state: ").append(cBY()).append("\n\n            [data]\n            dataSize: ").append(ba(cBR() / 1024.0F)).append("Kb\n            dataTime: ").append(this.sMy).append("\n            cached: ").append(HU(cBS())).append("\n            version: ").append(cBT()).append("\n            expire in: ").append(this.sLs).append("s\n            scene: ").append(this.svv).append("\n            state: ").append(cBZ()).append("\n\n            [performance](ms)\n            finishType: ").append(this.sMt).append("\n            finishTime: ").append(this.sMu);
    if (this.sMu != Math.max(this.sMB, this.sMD)) {}
    for (localObject1 = "/" + localg.HV(this.sMD);; localObject1 = "")
    {
      localObject1 = n.bHx((String)localObject1 + "\n            firstScreenFinish: " + localg.HV(this.sLA) + '/' + localg.HV(this.sMD) + "\n            a8keyFinish: " + this.sMB + "\n\n            client:\n            TmplCostTime: " + (this.sLQ - this.sLP) + "\n            WebViewUICostTime: " + (this.sLT - this.sLS) + "\n            NotifyPageCostTime: " + (this.sLR - this.sLN) + "\n\n            1.bindWebViewCostTime: " + this.sMv + "\n            2.createWebViewCostTime: " + this.sMw + "\n            3.getPageDataCostTime: " + this.sMy + "\n            4.injectCostTime: " + localg.HV(this.sMx) + "\n            eval cost: " + this.sLx + "\n\n            js:\n            4.1.onReceivePageData: " + (this.sLO - this.sLD) + "\n            5.ctWebCompile: " + this.sLC + "\n            6.renderTime: " + this.sLB + "\n\n            [js]webReceivePageDataTime: " + this.sMA + "\n            a8KeyFinishTime: " + this.sMB + "\n            getA8KeyCostTime: " + this.sMC + "\n        ");
      AppMethodBeat.o(6617);
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    e(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long[]>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"verify", "", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements b<Long, String>
  {
    g(i parami)
    {
      super();
    }
    
    public final String HV(long paramLong)
    {
      AppMethodBeat.i(6598);
      if (i.a(this.sML, paramLong))
      {
        AppMethodBeat.o(6598);
        return String.valueOf(paramLong);
      }
      AppMethodBeat.o(6598);
      return "NaN";
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final h sMN;
    
    static
    {
      AppMethodBeat.i(6600);
      sMN = new h();
      AppMethodBeat.o(6600);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.i
 * JD-Core Version:    0.7.0.1
 */