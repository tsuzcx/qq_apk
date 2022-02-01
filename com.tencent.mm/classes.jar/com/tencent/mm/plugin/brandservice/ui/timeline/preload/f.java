package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.protocal.protobuf.dch;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.e;
import d.a.j;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "printDataState", "printDebugger", "prefix", "", "printProcessState", "printTmplState", "printWebViewState", "report", "", "data", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "toString", "format", "kotlin.jvm.PlatformType", "", "digits", "limit", "toDate", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class f
{
  public static final a ndO;
  private final String TAG;
  private String key;
  public int mSu;
  private long ncA;
  public long ncB;
  public long ncC;
  long ncD;
  public long ncE;
  public long ncF;
  public long ncG;
  public long ncH;
  public long ncI;
  public long ncJ;
  public long ncK;
  long ncL;
  public long ncM;
  public long ncN;
  public long ncO;
  public long ncP;
  public long ncQ;
  public long ncR;
  public long ncS;
  public long ncT;
  public long ncU;
  long ncV;
  long ncW;
  long ncX;
  long ncY;
  long ncZ;
  private final int nct;
  public dch ncu;
  public int ncv;
  private final d.f ncw;
  private final d.f ncx;
  private final d.f ncy;
  private final d.f ncz;
  private long ndA;
  private long ndB;
  private long ndC;
  private long ndD;
  private long ndE;
  private long ndF;
  private long ndG;
  private long ndH;
  public String ndI;
  private final d.f ndJ;
  public boolean ndK;
  public boolean ndL;
  private final d.f ndM;
  private long ndN;
  public long nda;
  public long ndb;
  public long ndc;
  public long ndd;
  public long nde;
  public long ndf;
  public long ndg;
  public long ndh;
  public long ndi;
  public boolean ndj;
  public boolean ndk;
  public boolean ndl;
  public boolean ndm;
  public boolean ndn;
  public boolean ndo;
  public boolean ndp;
  public boolean ndq;
  public boolean ndr;
  public boolean nds;
  public int ndt;
  public boolean ndu;
  public boolean ndv;
  private long ndw;
  private int ndx;
  private long ndy;
  private long ndz;
  public String url;
  
  static
  {
    AppMethodBeat.i(6601);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "contentId", "getContentId()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "pageDataSize", "getPageDataSize()I")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "dataCachedTime", "getDataCachedTime()J")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "dataVersion", "getDataVersion()I")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "webviewProcess", "getWebviewProcess()Ljava/lang/String;")), (d.l.k)w.a(new d.g.b.u(w.bk(f.class), "speedMatrix", "getSpeedMatrix()[Ljava/lang/Long;")) };
    ndO = new a((byte)0);
    AppMethodBeat.o(6601);
  }
  
  public f()
  {
    AppMethodBeat.i(6618);
    this.TAG = "MicroMsg.Preload.Kv15862";
    this.nct = 15862;
    this.key = "";
    this.url = "";
    this.ncw = d.g.E((d.g.a.a)new b(this));
    this.ncx = d.g.E((d.g.a.a)new e(this));
    this.ncy = d.g.E((d.g.a.a)new c(this));
    this.ncz = d.g.E((d.g.a.a)new d(this));
    this.ncA = -1L;
    this.ncN = -1L;
    this.ncO = -1L;
    this.ncP = -1L;
    this.ncQ = -1L;
    this.ncR = -1L;
    this.ncS = -1L;
    this.ncT = -1L;
    this.ncU = -1L;
    this.ndI = "";
    this.ndJ = d.g.E((d.g.a.a)h.ndR);
    this.mSu = 10000;
    this.ndM = d.g.E((d.g.a.a)new f(this));
    this.ndN = 3600000L;
    AppMethodBeat.o(6618);
  }
  
  private final String I(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(6610);
    StringBuilder localStringBuilder = new StringBuilder();
    g.a locala = g.ndS;
    if (g.a.bDG()) {
      localStringBuilder.append(paramCharSequence + "no re-direct;");
    }
    locala = g.ndS;
    if (!g.a.bDB()) {
      localStringBuilder.append(paramCharSequence + "no preload data;");
    }
    locala = g.ndS;
    if (g.a.bDH()) {
      localStringBuilder.append(paramCharSequence + "no preload webview;");
    }
    locala = g.ndS;
    if (g.a.bDD()) {
      localStringBuilder.append(paramCharSequence + "data no expire;");
    }
    locala = g.ndS;
    if (g.a.bDI()) {
      localStringBuilder.append(paramCharSequence + "no red;");
    }
    paramCharSequence = this.ncu;
    if (paramCharSequence == null) {
      d.g.b.k.aPZ("tmplParams");
    }
    paramCharSequence = paramCharSequence.EtN;
    d.g.b.k.g(paramCharSequence, "tmplParams.headers");
    if (!n.aC((CharSequence)paramCharSequence)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCharSequence = this.ncu;
        if (paramCharSequence == null) {
          d.g.b.k.aPZ("tmplParams");
        }
        localStringBuilder.append(paramCharSequence.EtN);
      }
      if (n.aC((CharSequence)localStringBuilder)) {
        localStringBuilder.append("none;");
      }
      paramCharSequence = localStringBuilder.toString();
      d.g.b.k.g(paramCharSequence, "sb.toString()");
      AppMethodBeat.o(6610);
      return paramCharSequence;
    }
  }
  
  private static String aM(float paramFloat)
  {
    AppMethodBeat.i(6615);
    String str = String.format("%.2f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(6615);
    return str;
  }
  
  private final String bDq()
  {
    AppMethodBeat.i(6602);
    String str = (String)this.ncw.getValue();
    AppMethodBeat.o(6602);
    return str;
  }
  
  private final int bDr()
  {
    AppMethodBeat.i(6603);
    int i = ((Number)this.ncx.getValue()).intValue();
    AppMethodBeat.o(6603);
    return i;
  }
  
  private final long bDs()
  {
    AppMethodBeat.i(6604);
    long l = ((Number)this.ncy.getValue()).longValue();
    AppMethodBeat.o(6604);
    return l;
  }
  
  private final int bDt()
  {
    AppMethodBeat.i(6605);
    int i = ((Number)this.ncz.getValue()).intValue();
    AppMethodBeat.o(6605);
    return i;
  }
  
  private final String bDu()
  {
    AppMethodBeat.i(6606);
    String str = (String)this.ndJ.getValue();
    AppMethodBeat.o(6606);
    return str;
  }
  
  private final Long[] bDv()
  {
    AppMethodBeat.i(6607);
    Long[] arrayOfLong = (Long[])this.ndM.getValue();
    AppMethodBeat.o(6607);
    return arrayOfLong;
  }
  
  private final String bDw()
  {
    AppMethodBeat.i(6611);
    Object localObject = new StringBuilder();
    if (this.ndt == 1) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.nds) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (n.aC((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    d.g.b.k.g(localObject, "sb.toString()");
    AppMethodBeat.o(6611);
    return localObject;
  }
  
  private final String bDx()
  {
    AppMethodBeat.i(6612);
    Object localObject = new StringBuilder();
    if (this.ndt == 2) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.ndk) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (!this.ndm)
    {
      ((StringBuilder)localObject).append("tmpl fail;");
      if (!this.ndL) {
        break label146;
      }
      ((StringBuilder)localObject).append("timeout;");
    }
    for (;;)
    {
      if (this.ndq) {
        ((StringBuilder)localObject).append("xweb_cc;");
      }
      if (n.aC((CharSequence)localObject)) {
        ((StringBuilder)localObject).append("ok;");
      }
      localObject = ((StringBuilder)localObject).toString();
      d.g.b.k.g(localObject, "sb.toString()");
      AppMethodBeat.o(6612);
      return localObject;
      if (this.ndl) {
        break;
      }
      ((StringBuilder)localObject).append("inject fail;");
      break;
      label146:
      if (this.ndK) {
        ((StringBuilder)localObject).append("h5;");
      }
    }
  }
  
  private final String bDy()
  {
    AppMethodBeat.i(6613);
    Object localObject = new StringBuilder();
    if (this.ndo) {
      ((StringBuilder)localObject).append("zip;");
    }
    if (this.ndp) {
      ((StringBuilder)localObject).append("prefixMP;");
    }
    if (n.aC((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("none;");
    }
    localObject = ((StringBuilder)localObject).toString();
    d.g.b.k.g(localObject, "sb.toString()");
    AppMethodBeat.o(6613);
    return localObject;
  }
  
  private final String bDz()
  {
    AppMethodBeat.i(6614);
    Object localObject = new StringBuilder();
    if (!this.ndj) {
      ((StringBuilder)localObject).append("async;");
    }
    if (this.ndn) {
      ((StringBuilder)localObject).append("mounted;");
    }
    if (this.ndr) {
      ((StringBuilder)localObject).append("cache_tmpl;");
    }
    if (n.aC((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    d.g.b.k.g(localObject, "sb.toString()");
    AppMethodBeat.o(6614);
    return localObject;
  }
  
  private final long nE(long paramLong)
  {
    AppMethodBeat.i(6609);
    paramLong = Math.min(Math.max(-this.ndN, paramLong), this.ndN);
    AppMethodBeat.o(6609);
    return paramLong;
  }
  
  private static String nF(long paramLong)
  {
    AppMethodBeat.i(6616);
    String str = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(paramLong));
    d.g.b.k.g(str, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
    AppMethodBeat.o(6616);
    return str;
  }
  
  public final void a(dch paramdch)
  {
    AppMethodBeat.i(193082);
    d.g.b.k.h(paramdch, "<set-?>");
    this.ncu = paramdch;
    AppMethodBeat.o(193082);
  }
  
  public final void a(q<? super String, ? super String, ? super List<o<String, String>>, d.y> paramq)
  {
    AppMethodBeat.i(6608);
    d.g.b.k.h(paramq, "data");
    if ((!this.ndu) || (!this.ndv))
    {
      AppMethodBeat.o(6608);
      return;
    }
    Object localObject1 = this.ncu;
    if (localObject1 == null) {
      d.g.b.k.aPZ("tmplParams");
    }
    com.tencent.mm.plugin.webview.g.a.fL(((dch)localObject1).reportId, 132);
    Object localObject3 = d.bDp();
    this.ndw = Math.max(this.ncC, this.ncM);
    if (this.ncC < this.ncM) {}
    int j;
    long l1;
    int k;
    for (int i = 1;; i = 2)
    {
      this.ndx = i;
      this.ndy = (this.ndw - this.ncB);
      this.ndE = (this.ncG - this.ncB);
      this.ndD = (this.ncQ - this.ncR);
      this.ndF = (this.ncM - this.ncB);
      this.ndG = (this.ncM - this.ncL);
      this.ncD = (this.ncC - this.ncB);
      this.ndz = (this.ncN - this.ncB);
      this.ndA = (this.ncO - this.ncN);
      this.ndC = (this.ncI - this.ncH);
      this.ndB = (this.ncQ - this.ncP);
      this.ncA = (this.ncQ - this.ncR);
      this.ndH = (this.ndz + this.ndA + this.ndC + this.ndB + this.ncF + this.ncE);
      localObject1 = this.TAG;
      Object localObject4 = this.ncu;
      if (localObject4 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      i = ((dch)localObject4).version;
      localObject4 = this.url;
      j = bDr();
      l1 = this.ndy;
      k = this.ndx;
      long l2 = this.ncE;
      long l3 = this.ndF;
      boolean bool1 = this.ndk;
      long l4 = this.ncT;
      long l5 = this.ncS;
      boolean bool2 = this.ndj;
      long l6 = this.ndC;
      long l7 = this.ndG;
      long l8 = this.ndE;
      long l9 = this.ncF;
      long l10 = this.ncE;
      Object localObject5 = this.ncu;
      if (localObject5 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      int m = ((dch)localObject5).nee;
      localObject5 = this.ncu;
      if (localObject5 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      ad.d((String)localObject1, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", new Object[] { Integer.valueOf(i), localObject4, Integer.valueOf(j), localObject3, Long.valueOf(l1), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Long.valueOf(l4 - l5), Boolean.valueOf(bool2), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Integer.valueOf(m), ((dch)localObject5).yaG, this.ndI, bDu(), Integer.valueOf(this.mSu), Long.valueOf(this.ndD), Boolean.valueOf(this.nds) });
      if (!com.tencent.mm.sdk.platformtools.h.IS_FLAVOR_RED) {
        bool1 = com.tencent.mm.sdk.platformtools.h.DEBUG;
      }
      try
      {
        localObject1 = this.url;
        if (localObject1 == null) {
          d.g.b.k.fvU();
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
          dch localdch;
          ad.printErrStackTrace(this.TAG, (Throwable)localUnsupportedEncodingException, "url:%d", new Object[] { this.url });
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
          com.tencent.mm.plugin.webview.g.a.aA(20, this.ndy);
          com.tencent.mm.plugin.webview.g.a.aA(21, this.ncD);
          com.tencent.mm.plugin.webview.g.a.aA(22, l1);
          com.tencent.mm.plugin.webview.g.a.aA(23, this.ncW - this.ncV);
          if (!this.ndj)
          {
            com.tencent.mm.plugin.webview.g.a.aA(24, this.ncK - this.ncJ);
            com.tencent.mm.plugin.webview.g.a.SW(107);
          }
        }
        paramq.d("['FirstScreen', 'BindMP', 'WebView', 'WebViewUI', null, 'BindMM', 'JsAPI', 'GetA8Key', 'GetData', 'InjectData']", localObject2, localObject3);
        ad.i(this.TAG, "terry performance report:" + this.ncB + '\n' + e.a(bDv(), null, null, null, 0, null, null, 63));
        AppMethodBeat.o(6608);
      }
      localObject4 = com.tencent.mm.plugin.report.service.h.vKh;
      m = this.nct;
      localObject5 = this.ncu;
      if (localObject5 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      n = ((dch)localObject5).version;
      i1 = bDr();
      l1 = nE(this.ndy);
      i2 = this.ndx;
      l2 = nE(this.ncD);
      l3 = nE(this.ndF);
      if (!this.ndk) {
        break;
      }
      i = 1;
      l4 = nE(this.ncT - this.ncS);
      if (!this.ndj) {
        break label2308;
      }
      j = 1;
      l5 = nE(this.ndC);
      l6 = nE(this.ndG);
      l7 = nE(this.ndE);
      l8 = nE(this.ncF);
      l9 = nE(this.ncE);
      localObject5 = this.ncu;
      if (localObject5 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      i3 = ((dch)localObject5).nee;
      localObject5 = this.ncu;
      if (localObject5 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      localObject5 = ((dch)localObject5).yaG;
      localObject6 = this.ndI;
      localObject7 = bDu();
      i4 = this.mSu;
      l10 = nE(this.ndD);
      if (!this.nds) {
        break label2313;
      }
      k = 1;
      ((com.tencent.mm.plugin.report.service.h)localObject4).f(m, new Object[] { Integer.valueOf(n), localObject1, Integer.valueOf(i1), localObject3, Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l4), Integer.valueOf(j), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i3), localObject5, localObject6, localObject7, Integer.valueOf(i4), Long.valueOf(l10), Integer.valueOf(k), Long.valueOf(nE(this.ndz)), Long.valueOf(nE(this.ndA)), Long.valueOf(nE(this.ndB)) });
      localObject4 = com.tencent.mm.plugin.report.service.h.vKh;
      localObject5 = new d.g.b.y(19);
      ((d.g.b.y)localObject5).add(localObject1);
      ((d.g.b.y)localObject5).add(Integer.valueOf(this.mSu));
      ((d.g.b.y)localObject5).add(localObject3);
      ((d.g.b.y)localObject5).add(Integer.valueOf(bDr()));
      localObject1 = this.ncu;
      if (localObject1 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      ((d.g.b.y)localObject5).add(((dch)localObject1).yaG);
      ((d.g.b.y)localObject5).add(bDu());
      ((d.g.b.y)localObject5).add(this.ndI);
      if (!this.ndj) {
        break label2319;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      if (this.nds) {
        break label2324;
      }
      i = 1;
      if (i == 0) {
        break label2329;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      if (this.ndk) {
        break label2334;
      }
      i = 1;
      if (i == 0) {
        break label2339;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      ((d.g.b.y)localObject5).add(Integer.valueOf(this.ndt));
      if (!this.ndn) {
        break label2344;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      if (!this.ndl) {
        break label2349;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      ((d.g.b.y)localObject5).add(Long.valueOf(this.ndy));
      ((d.g.b.y)localObject5).eI(bDv());
      ((d.g.b.y)localObject5).add(this.key);
      if (!this.ndo) {
        break label2354;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      if (!this.ndq) {
        break label2359;
      }
      i = 1;
      ((d.g.b.y)localObject5).add(Integer.valueOf(i));
      ((d.g.b.y)localObject5).add(Long.valueOf(this.ncU));
      ((com.tencent.mm.plugin.report.service.h)localObject4).f(16874, ((d.g.b.y)localObject5).toArray(new Object[((d.g.b.y)localObject5).cTm.size()]));
      com.tencent.mm.plugin.webview.g.a.SW(0);
      if (this.ndo)
      {
        com.tencent.mm.plugin.webview.g.a.SW(111);
        localObject1 = this.ncu;
        if (localObject1 == null) {
          d.g.b.k.aPZ("tmplParams");
        }
        com.tencent.mm.plugin.webview.g.a.fL(((dch)localObject1).reportId, 232);
      }
      if (this.ndq) {
        com.tencent.mm.plugin.webview.g.a.SW(113);
      }
      com.tencent.mm.plugin.webview.g.a.aA(1, this.ndy);
      com.tencent.mm.plugin.webview.g.a.aA(2, this.ncD);
      l1 = this.ncN - this.ncB;
      if (!this.nds) {
        break label2364;
      }
      com.tencent.mm.plugin.webview.g.a.aA(10, this.ndy);
      com.tencent.mm.plugin.webview.g.a.aA(11, this.ncD);
      com.tencent.mm.plugin.webview.g.a.aA(12, l1);
      com.tencent.mm.plugin.webview.g.a.aA(13, this.ncW - this.ncV);
      com.tencent.mm.plugin.webview.g.a.aA(14, this.ncT - this.ncS);
      com.tencent.mm.plugin.webview.g.a.aA(15, this.ncQ - this.ncP);
      localObject1 = "[" + j.a((Iterable)e.R(bDv()), null, null, null, 0, null, null, 63) + ']';
      localObject3 = d.u.P("section", "[debug]");
      localObject4 = d.u.P("info", bDq());
      localObject5 = d.u.P("settings", I((CharSequence)""));
      localObject6 = d.u.P("section", "[process]");
      localObject7 = d.u.P("process", bDu());
      localo1 = d.u.P("state", bDw());
      localo2 = d.u.P("section", "[webview]");
      localo3 = d.u.P("kind", this.ndI);
      localo4 = d.u.P("state", bDx());
      localo5 = d.u.P("section", "[tmpl]");
      localObject8 = this.ncu;
      if (localObject8 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      localObject8 = d.u.P("uid", ((dch)localObject8).yaG);
      localObject9 = this.ncu;
      if (localObject9 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      localObject9 = d.u.P("tmplType", String.valueOf(((dch)localObject9).nee));
      localObject10 = this.ncu;
      if (localObject10 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      localObject10 = d.u.P("version", String.valueOf(((dch)localObject10).version));
      localObject11 = this.ncu;
      if (localObject11 == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      localObject11 = d.u.P("md5", ((dch)localObject11).md5);
      localdch = this.ncu;
      if (localdch == null) {
        d.g.b.k.aPZ("tmplParams");
      }
      localObject3 = j.listOf(new o[] { localObject3, localObject4, localObject5, localObject6, localObject7, localo1, localo2, localo3, localo4, localo5, localObject8, localObject9, localObject10, localObject11, d.u.P("time", nF(localdch.wLF)), d.u.P("state", bDy()), d.u.P("section", "[data]"), d.u.P("dataSize", aM(bDr() / 1024.0F) + "Kb"), d.u.P("dataTime", String.valueOf(this.ndC)), d.u.P("cached", nF(bDs())), d.u.P("version", String.valueOf(bDt())), d.u.P("expire in", this.ncv + 's'), d.u.P("scene", String.valueOf(this.mSu)), d.u.P("state", bDz()) });
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
    AppMethodBeat.i(193083);
    d.g.b.k.h(paramString, "<set-?>");
    this.key = paramString;
    AppMethodBeat.o(193083);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6617);
    g localg = new g(this);
    ad.v(this.TAG, "terry performance log:\n" + this.ndz + ',' + this.ndA + ',' + (this.ncW - this.ncO) + ',' + (Math.max(this.ncW, this.ncT) - this.ncW) + ',' + (this.ncP - Math.max(this.ncW, this.ncT)) + ',' + this.ndB);
    ad.v(this.TAG, "terry performance timestamp:\n " + e.a(bDv(), null, null, null, 0, null, null, 63));
    Object localObject1 = new StringBuilder("\n            [debug]\n            info: ").append(bDq()).append("\n            settings: ").append(I((CharSequence)"\n")).append("\n\n            [process]\n            process: ").append(bDu()).append("\n            state: ").append(bDw()).append("\n\n            [webview]\n            kind: ").append(this.ndI).append("\n            state: ").append(bDx()).append("\n\n            [tmpl]\n            uid: ");
    Object localObject2 = this.ncu;
    if (localObject2 == null) {
      d.g.b.k.aPZ("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dch)localObject2).yaG).append("\n            tmplType: ");
    localObject2 = this.ncu;
    if (localObject2 == null) {
      d.g.b.k.aPZ("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dch)localObject2).nee).append("\n            version: ");
    localObject2 = this.ncu;
    if (localObject2 == null) {
      d.g.b.k.aPZ("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dch)localObject2).version).append("\n            md5: ");
    localObject2 = this.ncu;
    if (localObject2 == null) {
      d.g.b.k.aPZ("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dch)localObject2).md5).append("\n            time: ");
    localObject2 = this.ncu;
    if (localObject2 == null) {
      d.g.b.k.aPZ("tmplParams");
    }
    localObject2 = ((StringBuilder)localObject1).append(nF(((dch)localObject2).wLF)).append("\n            state: ").append(bDy()).append("\n\n            [data]\n            dataSize: ").append(aM(bDr() / 1024.0F)).append("Kb\n            dataTime: ").append(this.ndC).append("\n            cached: ").append(nF(bDs())).append("\n            version: ").append(bDt()).append("\n            expire in: ").append(this.ncv).append("s\n            scene: ").append(this.mSu).append("\n            state: ").append(bDz()).append("\n\n            [performance](ms)\n            finishType: ").append(this.ndx).append("\n            finishTime: ").append(this.ndy);
    if (this.ndy != Math.max(this.ndF, this.ndH)) {}
    for (localObject1 = "/" + localg.nG(this.ndH);; localObject1 = "")
    {
      localObject1 = n.aRa((String)localObject1 + "\n            firstScreenFinish: " + localg.nG(this.ncD) + '/' + localg.nG(this.ndH) + "\n            a8keyFinish: " + this.ndF + "\n\n            client:\n            TmplCostTime: " + (this.ncT - this.ncS) + "\n            WebViewUICostTime: " + (this.ncW - this.ncV) + "\n            NotifyPageCostTime: " + (this.ncU - this.ncQ) + "\n\n            1.bindWebViewCostTime: " + this.ndz + "\n            2.createWebViewCostTime: " + this.ndA + "\n            3.getPageDataCostTime: " + this.ndC + "\n            4.injectCostTime: " + localg.nG(this.ndB) + "\n            eval cost: " + this.ncA + "\n\n            js:\n            4.1.onReceivePageData: " + (this.ncR - this.ncG) + "\n            5.ctWebCompile: " + this.ncF + "\n            6.renderTime: " + this.ncE + "\n\n            [js]webReceivePageDataTime: " + this.ndE + "\n            a8KeyFinishTime: " + this.ndF + "\n            getA8KeyCostTime: " + this.ndG + "\n        ");
      AppMethodBeat.o(6617);
      return localObject1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<Long>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<Long[]>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"verify", "", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements b<Long, String>
  {
    g(f paramf)
    {
      super();
    }
    
    public final String nG(long paramLong)
    {
      AppMethodBeat.i(6598);
      if (f.a(this.ndP, paramLong))
      {
        AppMethodBeat.o(6598);
        return String.valueOf(paramLong);
      }
      AppMethodBeat.o(6598);
      return "NaN";
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    public static final h ndR;
    
    static
    {
      AppMethodBeat.i(6600);
      ndR = new h();
      AppMethodBeat.o(6600);
    }
    
    h()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.f
 * JD-Core Version:    0.7.0.1
 */