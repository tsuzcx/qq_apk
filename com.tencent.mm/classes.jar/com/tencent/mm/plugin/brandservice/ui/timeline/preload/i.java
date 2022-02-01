package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.eic;
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
import kotlin.g.b.ad;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.s;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "printDataState", "printDebugger", "prefix", "", "printProcessState", "printTmplState", "printWebViewState", "report", "", "data", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "toString", "format", "", "digits", "limit", "toDate", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class i
{
  public static final a pCy;
  private final String TAG;
  private String key;
  public boolean kwO;
  public long pBA;
  public long pBB;
  public long pBC;
  public long pBD;
  public long pBE;
  public long pBF;
  long pBG;
  long pBH;
  long pBI;
  long pBJ;
  long pBK;
  public long pBL;
  public long pBM;
  public long pBN;
  public long pBO;
  public long pBP;
  public long pBQ;
  public long pBR;
  public long pBS;
  public long pBT;
  public boolean pBU;
  public boolean pBV;
  public boolean pBW;
  public boolean pBX;
  public boolean pBY;
  public boolean pBZ;
  private final int pBe;
  public eic pBf;
  public int pBg;
  private final kotlin.f pBh;
  private final kotlin.f pBi;
  private final kotlin.f pBj;
  private final kotlin.f pBk;
  private long pBl;
  public long pBm;
  public long pBn;
  long pBo;
  public long pBp;
  public long pBq;
  public long pBr;
  public long pBs;
  public long pBt;
  public long pBu;
  public long pBv;
  long pBw;
  public long pBx;
  public long pBy;
  public long pBz;
  public boolean pCa;
  public boolean pCb;
  public boolean pCc;
  public int pCd;
  public boolean pCe;
  public boolean pCf;
  private long pCg;
  private int pCh;
  private long pCi;
  private long pCj;
  private long pCk;
  private long pCl;
  private long pCm;
  private long pCn;
  private long pCo;
  private long pCp;
  private long pCq;
  private long pCr;
  public String pCs;
  private final kotlin.f pCt;
  public boolean pCu;
  public boolean pCv;
  private final kotlin.f pCw;
  private long pCx;
  public int pmM;
  public String url;
  
  static
  {
    AppMethodBeat.i(6601);
    pCy = new a((byte)0);
    AppMethodBeat.o(6601);
  }
  
  public i()
  {
    AppMethodBeat.i(6618);
    this.TAG = "MicroMsg.Preload.Kv15862";
    this.pBe = 15862;
    this.key = "";
    this.url = "";
    this.pBh = g.ah((kotlin.g.a.a)new b(this));
    this.pBi = g.ah((kotlin.g.a.a)new e(this));
    this.pBj = g.ah((kotlin.g.a.a)new c(this));
    this.pBk = g.ah((kotlin.g.a.a)new d(this));
    this.pBl = -1L;
    this.pBy = -1L;
    this.pBz = -1L;
    this.pBA = -1L;
    this.pBB = -1L;
    this.pBC = -1L;
    this.pBD = -1L;
    this.pBE = -1L;
    this.pBF = -1L;
    this.pCs = "";
    this.pCt = g.ah((kotlin.g.a.a)h.pCB);
    this.pmM = 10000;
    this.pCw = g.ah((kotlin.g.a.a)new f(this));
    this.pCx = 3600000L;
    AppMethodBeat.o(6618);
  }
  
  private final long BH(long paramLong)
  {
    AppMethodBeat.i(6609);
    paramLong = Math.min(Math.max(-this.pCx, paramLong), this.pCx);
    AppMethodBeat.o(6609);
    return paramLong;
  }
  
  private static String BI(long paramLong)
  {
    AppMethodBeat.i(6616);
    String str = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(paramLong));
    p.g(str, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
    AppMethodBeat.o(6616);
    return str;
  }
  
  private final String L(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(6610);
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.pCC;
    if (j.a.coa()) {
      localStringBuilder.append(paramCharSequence + "no re-direct;");
    }
    locala = j.pCC;
    if (!j.a.cnV()) {
      localStringBuilder.append(paramCharSequence + "no preload data;");
    }
    locala = j.pCC;
    if (j.a.cob()) {
      localStringBuilder.append(paramCharSequence + "no preload webview;");
    }
    locala = j.pCC;
    if (j.a.cnX()) {
      localStringBuilder.append(paramCharSequence + "data no expire;");
    }
    locala = j.pCC;
    if (j.a.coc()) {
      localStringBuilder.append(paramCharSequence + "no red;");
    }
    paramCharSequence = this.pBf;
    if (paramCharSequence == null) {
      p.btv("tmplParams");
    }
    paramCharSequence = paramCharSequence.Nhs;
    p.g(paramCharSequence, "tmplParams.headers");
    if (!n.aL((CharSequence)paramCharSequence)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCharSequence = this.pBf;
        if (paramCharSequence == null) {
          p.btv("tmplParams");
        }
        localStringBuilder.append(paramCharSequence.Nhs);
      }
      if (n.aL((CharSequence)localStringBuilder)) {
        localStringBuilder.append("none;");
      }
      paramCharSequence = localStringBuilder.toString();
      p.g(paramCharSequence, "sb.toString()");
      AppMethodBeat.o(6610);
      return paramCharSequence;
    }
  }
  
  private static String ba(float paramFloat)
  {
    AppMethodBeat.i(6615);
    String str = String.format("%.2f", new Object[] { Float.valueOf(paramFloat) });
    p.g(str, "java.lang.String.format(\"%.${digits}f\", this)");
    AppMethodBeat.o(6615);
    return str;
  }
  
  private final String cnK()
  {
    AppMethodBeat.i(6602);
    String str = (String)this.pBh.getValue();
    AppMethodBeat.o(6602);
    return str;
  }
  
  private final int cnL()
  {
    AppMethodBeat.i(6603);
    int i = ((Number)this.pBi.getValue()).intValue();
    AppMethodBeat.o(6603);
    return i;
  }
  
  private final long cnM()
  {
    AppMethodBeat.i(6604);
    long l = ((Number)this.pBj.getValue()).longValue();
    AppMethodBeat.o(6604);
    return l;
  }
  
  private final int cnN()
  {
    AppMethodBeat.i(6605);
    int i = ((Number)this.pBk.getValue()).intValue();
    AppMethodBeat.o(6605);
    return i;
  }
  
  private final String cnO()
  {
    AppMethodBeat.i(6606);
    String str = (String)this.pCt.getValue();
    AppMethodBeat.o(6606);
    return str;
  }
  
  private final Long[] cnP()
  {
    AppMethodBeat.i(6607);
    Long[] arrayOfLong = (Long[])this.pCw.getValue();
    AppMethodBeat.o(6607);
    return arrayOfLong;
  }
  
  private final String cnQ()
  {
    AppMethodBeat.i(6611);
    Object localObject = new StringBuilder();
    if (this.pCd == 1) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.pCc) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (n.aL((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6611);
    return localObject;
  }
  
  private final String cnR()
  {
    AppMethodBeat.i(6612);
    Object localObject = new StringBuilder();
    if (this.pCd == 2) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.pBV) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (!this.pBX)
    {
      p.g(((StringBuilder)localObject).append("tmpl fail;"), "sb.append(\"tmpl fail;\")");
      if (!this.pCv) {
        break label156;
      }
      p.g(((StringBuilder)localObject).append("timeout;"), "sb.append(\"timeout;\")");
    }
    for (;;)
    {
      if (this.pCa) {
        ((StringBuilder)localObject).append("xweb_cc;");
      }
      if (n.aL((CharSequence)localObject)) {
        ((StringBuilder)localObject).append("ok;");
      }
      localObject = ((StringBuilder)localObject).toString();
      p.g(localObject, "sb.toString()");
      AppMethodBeat.o(6612);
      return localObject;
      if (this.pBW) {
        break;
      }
      ((StringBuilder)localObject).append("inject fail;");
      break;
      label156:
      if (this.pCu) {
        ((StringBuilder)localObject).append("h5;");
      }
    }
  }
  
  private final String cnS()
  {
    AppMethodBeat.i(6613);
    Object localObject = new StringBuilder();
    if (this.kwO) {
      ((StringBuilder)localObject).append("zip;");
    }
    if (this.pBZ) {
      ((StringBuilder)localObject).append("prefixMP;");
    }
    if (n.aL((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("none;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6613);
    return localObject;
  }
  
  private final String cnT()
  {
    AppMethodBeat.i(6614);
    Object localObject = new StringBuilder();
    if (!this.pBU) {
      ((StringBuilder)localObject).append("async;");
    }
    if (this.pBY) {
      ((StringBuilder)localObject).append("mounted;");
    }
    if (this.pCb) {
      ((StringBuilder)localObject).append("cache_tmpl;");
    }
    if (n.aL((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6614);
    return localObject;
  }
  
  public final void a(eic parameic)
  {
    AppMethodBeat.i(195601);
    p.h(parameic, "<set-?>");
    this.pBf = parameic;
    AppMethodBeat.o(195601);
  }
  
  public final void b(kotlin.g.a.q<? super String, ? super String, ? super List<o<String, String>>, x> paramq)
  {
    AppMethodBeat.i(6608);
    p.h(paramq, "data");
    if ((!this.pCe) || (!this.pCf))
    {
      AppMethodBeat.o(6608);
      return;
    }
    Object localObject1 = this.pBf;
    if (localObject1 == null) {
      p.btv("tmplParams");
    }
    com.tencent.mm.plugin.webview.h.a.gH(((eic)localObject1).reportId, 132);
    Object localObject3 = f.getNetWorkType();
    this.pCg = Math.max(this.pBn, this.pBx);
    if (this.pBn < this.pBx) {}
    int j;
    long l1;
    int k;
    for (int i = 1;; i = 2)
    {
      this.pCh = i;
      this.pCi = (this.pCg - this.pBm);
      this.pCo = (this.pBr - this.pBm);
      this.pCn = (this.pBB - this.pBC);
      this.pCp = (this.pBx - this.pBm);
      this.pCq = (this.pBx - this.pBw);
      this.pBo = (this.pBn - this.pBm);
      this.pCj = (this.pBy - this.pBm);
      this.pCk = (this.pBz - this.pBy);
      this.pCm = (this.pBt - this.pBs);
      this.pCl = (this.pBB - this.pBA);
      this.pBl = (this.pBB - this.pBC);
      this.pCr = (this.pCj + this.pCk + this.pCm + this.pCl + this.pBq + this.pBp);
      localObject1 = this.TAG;
      Object localObject4 = this.pBf;
      if (localObject4 == null) {
        p.btv("tmplParams");
      }
      i = ((eic)localObject4).version;
      localObject4 = this.url;
      j = cnL();
      l1 = this.pCi;
      k = this.pCh;
      long l2 = this.pBp;
      long l3 = this.pCp;
      boolean bool1 = this.pBV;
      long l4 = this.pBE;
      long l5 = this.pBD;
      boolean bool2 = this.pBU;
      long l6 = this.pCm;
      long l7 = this.pCq;
      long l8 = this.pCo;
      long l9 = this.pBq;
      long l10 = this.pBp;
      Object localObject5 = this.pBf;
      if (localObject5 == null) {
        p.btv("tmplParams");
      }
      int m = ((eic)localObject5).pCV;
      localObject5 = this.pBf;
      if (localObject5 == null) {
        p.btv("tmplParams");
      }
      Log.d((String)localObject1, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", new Object[] { Integer.valueOf(i), localObject4, Integer.valueOf(j), localObject3, Long.valueOf(l1), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Long.valueOf(l4 - l5), Boolean.valueOf(bool2), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Integer.valueOf(m), ((eic)localObject5).hFF, this.pCs, cnO(), Integer.valueOf(this.pmM), Long.valueOf(this.pCn), Boolean.valueOf(this.pCc) });
      if (!BuildInfo.IS_FLAVOR_RED) {
        bool1 = BuildInfo.DEBUG;
      }
      try
      {
        localObject1 = this.url;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = com.tencent.mm.compatible.util.q.encode((String)localObject1, "UTF-8");
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
          eic localeic;
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
          com.tencent.mm.plugin.webview.h.a.aP(20, this.pCi);
          com.tencent.mm.plugin.webview.h.a.aP(21, this.pBo);
          com.tencent.mm.plugin.webview.h.a.aP(22, l1);
          com.tencent.mm.plugin.webview.h.a.aP(23, this.pBH - this.pBG);
          if (!this.pBU)
          {
            com.tencent.mm.plugin.webview.h.a.aP(24, this.pBv - this.pBu);
            com.tencent.mm.plugin.webview.h.a.agi(107);
          }
        }
        paramq.d("['FirstScreen', 'BindMP', 'WebView', 'WebViewUI', null, 'BindMM', 'JsAPI', 'GetA8Key', 'GetData', 'InjectData']", localObject2, localObject3);
        Log.i(this.TAG, "terry performance report:" + this.pBm + '\n' + e.a(cnP(), null, null, null, 0, null, null, 63));
        AppMethodBeat.o(6608);
      }
      localObject4 = h.CyF;
      m = this.pBe;
      localObject5 = this.pBf;
      if (localObject5 == null) {
        p.btv("tmplParams");
      }
      n = ((eic)localObject5).version;
      i1 = cnL();
      l1 = BH(this.pCi);
      i2 = this.pCh;
      l2 = BH(this.pBo);
      l3 = BH(this.pCp);
      if (!this.pBV) {
        break;
      }
      i = 1;
      l4 = BH(this.pBE - this.pBD);
      if (!this.pBU) {
        break label2308;
      }
      j = 1;
      l5 = BH(this.pCm);
      l6 = BH(this.pCq);
      l7 = BH(this.pCo);
      l8 = BH(this.pBq);
      l9 = BH(this.pBp);
      localObject5 = this.pBf;
      if (localObject5 == null) {
        p.btv("tmplParams");
      }
      i3 = ((eic)localObject5).pCV;
      localObject5 = this.pBf;
      if (localObject5 == null) {
        p.btv("tmplParams");
      }
      localObject5 = ((eic)localObject5).hFF;
      localObject6 = this.pCs;
      localObject7 = cnO();
      i4 = this.pmM;
      l10 = BH(this.pCn);
      if (!this.pCc) {
        break label2313;
      }
      k = 1;
      ((h)localObject4).a(m, new Object[] { Integer.valueOf(n), localObject1, Integer.valueOf(i1), localObject3, Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l4), Integer.valueOf(j), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i3), localObject5, localObject6, localObject7, Integer.valueOf(i4), Long.valueOf(l10), Integer.valueOf(k), Long.valueOf(BH(this.pCj)), Long.valueOf(BH(this.pCk)), Long.valueOf(BH(this.pCl)) });
      localObject4 = h.CyF;
      localObject5 = new ad(19);
      ((ad)localObject5).add(localObject1);
      ((ad)localObject5).add(Integer.valueOf(this.pmM));
      ((ad)localObject5).add(localObject3);
      ((ad)localObject5).add(Integer.valueOf(cnL()));
      localObject1 = this.pBf;
      if (localObject1 == null) {
        p.btv("tmplParams");
      }
      ((ad)localObject5).add(((eic)localObject1).hFF);
      ((ad)localObject5).add(cnO());
      ((ad)localObject5).add(this.pCs);
      if (!this.pBU) {
        break label2319;
      }
      i = 1;
      ((ad)localObject5).add(Integer.valueOf(i));
      if (this.pCc) {
        break label2324;
      }
      i = 1;
      if (i == 0) {
        break label2329;
      }
      i = 1;
      ((ad)localObject5).add(Integer.valueOf(i));
      if (this.pBV) {
        break label2334;
      }
      i = 1;
      if (i == 0) {
        break label2339;
      }
      i = 1;
      ((ad)localObject5).add(Integer.valueOf(i));
      ((ad)localObject5).add(Integer.valueOf(this.pCd));
      if (!this.pBY) {
        break label2344;
      }
      i = 1;
      ((ad)localObject5).add(Integer.valueOf(i));
      if (!this.pBW) {
        break label2349;
      }
      i = 1;
      ((ad)localObject5).add(Integer.valueOf(i));
      ((ad)localObject5).add(Long.valueOf(this.pCi));
      ((ad)localObject5).eS(cnP());
      ((ad)localObject5).add(this.key);
      if (!this.kwO) {
        break label2354;
      }
      i = 1;
      ((ad)localObject5).add(Integer.valueOf(i));
      if (!this.pCa) {
        break label2359;
      }
      i = 1;
      ((ad)localObject5).add(Integer.valueOf(i));
      ((ad)localObject5).add(Long.valueOf(this.pBF));
      ((h)localObject4).a(16874, ((ad)localObject5).toArray(new Object[((ad)localObject5).dtS.size()]));
      com.tencent.mm.plugin.webview.h.a.agi(0);
      if (this.kwO)
      {
        com.tencent.mm.plugin.webview.h.a.agi(111);
        localObject1 = this.pBf;
        if (localObject1 == null) {
          p.btv("tmplParams");
        }
        com.tencent.mm.plugin.webview.h.a.gH(((eic)localObject1).reportId, 232);
      }
      if (this.pCa) {
        com.tencent.mm.plugin.webview.h.a.agi(113);
      }
      com.tencent.mm.plugin.webview.h.a.aP(1, this.pCi);
      com.tencent.mm.plugin.webview.h.a.aP(2, this.pBo);
      l1 = this.pBy - this.pBm;
      if (!this.pCc) {
        break label2364;
      }
      com.tencent.mm.plugin.webview.h.a.aP(10, this.pCi);
      com.tencent.mm.plugin.webview.h.a.aP(11, this.pBo);
      com.tencent.mm.plugin.webview.h.a.aP(12, l1);
      com.tencent.mm.plugin.webview.h.a.aP(13, this.pBH - this.pBG);
      com.tencent.mm.plugin.webview.h.a.aP(14, this.pBE - this.pBD);
      com.tencent.mm.plugin.webview.h.a.aP(15, this.pBB - this.pBA);
      localObject1 = "[" + kotlin.a.j.a((Iterable)e.U(cnP()), null, null, null, 0, null, null, 63) + ']';
      localObject3 = s.U("section", "[debug]");
      localObject4 = s.U("info", cnK());
      localObject5 = s.U("settings", L((CharSequence)""));
      localObject6 = s.U("section", "[process]");
      localObject7 = s.U("process", cnO());
      localo1 = s.U("state", cnQ());
      localo2 = s.U("section", "[webview]");
      localo3 = s.U("kind", this.pCs);
      localo4 = s.U("state", cnR());
      localo5 = s.U("section", "[tmpl]");
      localObject8 = this.pBf;
      if (localObject8 == null) {
        p.btv("tmplParams");
      }
      localObject8 = s.U("uid", ((eic)localObject8).hFF);
      localObject9 = this.pBf;
      if (localObject9 == null) {
        p.btv("tmplParams");
      }
      localObject9 = s.U("tmplType", String.valueOf(((eic)localObject9).pCV));
      localObject10 = this.pBf;
      if (localObject10 == null) {
        p.btv("tmplParams");
      }
      localObject10 = s.U("version", String.valueOf(((eic)localObject10).version));
      localObject11 = this.pBf;
      if (localObject11 == null) {
        p.btv("tmplParams");
      }
      localObject11 = s.U("md5", ((eic)localObject11).md5);
      localeic = this.pBf;
      if (localeic == null) {
        p.btv("tmplParams");
      }
      localObject3 = kotlin.a.j.listOf(new o[] { localObject3, localObject4, localObject5, localObject6, localObject7, localo1, localo2, localo3, localo4, localo5, localObject8, localObject9, localObject10, localObject11, s.U("time", BI(localeic.DPz)), s.U("state", cnS()), s.U("section", "[data]"), s.U("dataSize", ba(cnL() / 1024.0F) + "Kb"), s.U("dataTime", String.valueOf(this.pCm)), s.U("cached", BI(cnM())), s.U("version", String.valueOf(cnN())), s.U("expire in", this.pBg + 's'), s.U("scene", String.valueOf(this.pmM)), s.U("state", cnT()) });
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
    AppMethodBeat.i(195602);
    p.h(paramString, "<set-?>");
    this.key = paramString;
    AppMethodBeat.o(195602);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6617);
    g localg = new g(this);
    Log.v(this.TAG, "terry performance log:\n" + this.pCj + ',' + this.pCk + ',' + (this.pBH - this.pBz) + ',' + (Math.max(this.pBH, this.pBE) - this.pBH) + ',' + (this.pBA - Math.max(this.pBH, this.pBE)) + ',' + this.pCl);
    Log.v(this.TAG, "terry performance timestamp:\n " + e.a(cnP(), null, null, null, 0, null, null, 63));
    Object localObject1 = new StringBuilder("\n            [debug]\n            info: ").append(cnK()).append("\n            settings: ").append(L((CharSequence)"\n")).append("\n\n            [process]\n            process: ").append(cnO()).append("\n            state: ").append(cnQ()).append("\n\n            [webview]\n            kind: ").append(this.pCs).append("\n            state: ").append(cnR()).append("\n\n            [tmpl]\n            uid: ");
    Object localObject2 = this.pBf;
    if (localObject2 == null) {
      p.btv("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((eic)localObject2).hFF).append("\n            tmplType: ");
    localObject2 = this.pBf;
    if (localObject2 == null) {
      p.btv("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((eic)localObject2).pCV).append("\n            version: ");
    localObject2 = this.pBf;
    if (localObject2 == null) {
      p.btv("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((eic)localObject2).version).append("\n            md5: ");
    localObject2 = this.pBf;
    if (localObject2 == null) {
      p.btv("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((eic)localObject2).md5).append("\n            time: ");
    localObject2 = this.pBf;
    if (localObject2 == null) {
      p.btv("tmplParams");
    }
    localObject2 = ((StringBuilder)localObject1).append(BI(((eic)localObject2).DPz)).append("\n            state: ").append(cnS()).append("\n\n            [data]\n            dataSize: ").append(ba(cnL() / 1024.0F)).append("Kb\n            dataTime: ").append(this.pCm).append("\n            cached: ").append(BI(cnM())).append("\n            version: ").append(cnN()).append("\n            expire in: ").append(this.pBg).append("s\n            scene: ").append(this.pmM).append("\n            state: ").append(cnT()).append("\n\n            [performance](ms)\n            finishType: ").append(this.pCh).append("\n            finishTime: ").append(this.pCi);
    if (this.pCi != Math.max(this.pCp, this.pCr)) {}
    for (localObject1 = "/" + localg.BJ(this.pCr);; localObject1 = "")
    {
      localObject1 = n.buv((String)localObject1 + "\n            firstScreenFinish: " + localg.BJ(this.pBo) + '/' + localg.BJ(this.pCr) + "\n            a8keyFinish: " + this.pCp + "\n\n            client:\n            TmplCostTime: " + (this.pBE - this.pBD) + "\n            WebViewUICostTime: " + (this.pBH - this.pBG) + "\n            NotifyPageCostTime: " + (this.pBF - this.pBB) + "\n\n            1.bindWebViewCostTime: " + this.pCj + "\n            2.createWebViewCostTime: " + this.pCk + "\n            3.getPageDataCostTime: " + this.pCm + "\n            4.injectCostTime: " + localg.BJ(this.pCl) + "\n            eval cost: " + this.pBl + "\n\n            js:\n            4.1.onReceivePageData: " + (this.pBC - this.pBr) + "\n            5.ctWebCompile: " + this.pBq + "\n            6.renderTime: " + this.pBp + "\n\n            [js]webReceivePageDataTime: " + this.pCo + "\n            a8KeyFinishTime: " + this.pCp + "\n            getA8KeyCostTime: " + this.pCq + "\n        ");
      AppMethodBeat.o(6617);
      return localObject1;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    e(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Long[]>
  {
    f(i parami)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"verify", "", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements b<Long, String>
  {
    g(i parami)
    {
      super();
    }
    
    public final String BJ(long paramLong)
    {
      AppMethodBeat.i(6598);
      if (i.a(this.pCz, paramLong))
      {
        AppMethodBeat.o(6598);
        return String.valueOf(paramLong);
      }
      AppMethodBeat.o(6598);
      return "NaN";
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<String>
  {
    public static final h pCB;
    
    static
    {
      AppMethodBeat.i(6600);
      pCB = new h();
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