package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.fnn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.al;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.v;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "printDataState", "printDebugger", "prefix", "", "printProcessState", "printTmplState", "printWebViewState", "report", "", "data", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "toString", "format", "kotlin.jvm.PlatformType", "", "digits", "limit", "toDate", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final a vRe;
  private final String TAG;
  private String key;
  public boolean qon;
  public String url;
  public int vAZ;
  public long vRA;
  public long vRB;
  public long vRC;
  public long vRD;
  public long vRE;
  public long vRF;
  public long vRG;
  long vRH;
  long vRI;
  long vRJ;
  long vRK;
  long vRL;
  public long vRM;
  public long vRN;
  public long vRO;
  public long vRP;
  public long vRQ;
  public long vRR;
  public long vRS;
  public long vRT;
  public long vRU;
  public boolean vRV;
  public boolean vRW;
  public boolean vRX;
  public boolean vRY;
  public boolean vRZ;
  private final int vRf;
  public fnn vRg;
  public int vRh;
  private final kotlin.j vRi;
  private final kotlin.j vRj;
  private final kotlin.j vRk;
  private final kotlin.j vRl;
  private long vRm;
  public long vRn;
  public long vRo;
  long vRp;
  public long vRq;
  public long vRr;
  public long vRs;
  public long vRt;
  public long vRu;
  public long vRv;
  public long vRw;
  long vRx;
  public long vRy;
  public long vRz;
  public boolean vSa;
  public boolean vSb;
  public boolean vSc;
  public boolean vSd;
  public int vSe;
  public boolean vSf;
  public boolean vSg;
  private long vSh;
  private int vSi;
  private long vSj;
  private long vSk;
  private long vSl;
  private long vSm;
  private long vSn;
  private long vSo;
  private long vSp;
  private long vSq;
  private long vSr;
  private long vSs;
  public String vSt;
  private final kotlin.j vSu;
  public boolean vSv;
  public boolean vSw;
  private final kotlin.j vSx;
  private long vSy;
  
  static
  {
    AppMethodBeat.i(6601);
    vRe = new a((byte)0);
    AppMethodBeat.o(6601);
  }
  
  public i()
  {
    AppMethodBeat.i(6618);
    this.TAG = "MicroMsg.Preload.Kv15862";
    this.vRf = 15862;
    this.key = "";
    this.url = "";
    this.vRi = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.vRj = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.vRk = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.vRl = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.vRm = -1L;
    this.vRz = -1L;
    this.vRA = -1L;
    this.vRB = -1L;
    this.vRC = -1L;
    this.vRD = -1L;
    this.vRE = -1L;
    this.vRF = -1L;
    this.vRG = -1L;
    this.vSt = "";
    this.vSu = kotlin.k.cm((kotlin.g.a.a)g.vSA);
    this.vAZ = 10000;
    this.vSx = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.vSy = 3600000L;
    AppMethodBeat.o(6618);
  }
  
  private final String Y(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(6610);
    StringBuilder localStringBuilder = new StringBuilder();
    j.a locala = j.vSB;
    if (j.a.dfs()) {
      localStringBuilder.append(paramCharSequence + "no re-direct;");
    }
    locala = j.vSB;
    if (!j.a.dfm()) {
      localStringBuilder.append(paramCharSequence + "no preload data;");
    }
    locala = j.vSB;
    if (j.a.dft()) {
      localStringBuilder.append(paramCharSequence + "no preload webview;");
    }
    locala = j.vSB;
    if (j.a.dfo()) {
      localStringBuilder.append(paramCharSequence + "data no expire;");
    }
    locala = j.vSB;
    if (j.a.dfu()) {
      localStringBuilder.append(paramCharSequence + "no red;");
    }
    paramCharSequence = dfa().abNz;
    s.s(paramCharSequence, "tmplParams.headers");
    if (!n.bp((CharSequence)paramCharSequence)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuilder.append(dfa().abNz);
      }
      if (n.bp((CharSequence)localStringBuilder)) {
        localStringBuilder.append("none;");
      }
      paramCharSequence = localStringBuilder.toString();
      s.s(paramCharSequence, "sb.toString()");
      AppMethodBeat.o(6610);
      return paramCharSequence;
    }
  }
  
  private static final String a(long paramLong, i parami)
  {
    AppMethodBeat.i(303373);
    if (parami.km(paramLong))
    {
      AppMethodBeat.o(303373);
      return String.valueOf(paramLong);
    }
    AppMethodBeat.o(303373);
    return "NaN";
  }
  
  private static String cd(float paramFloat)
  {
    AppMethodBeat.i(6615);
    String str = String.format("%.2f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(6615);
    return str;
  }
  
  private fnn dfa()
  {
    AppMethodBeat.i(303255);
    fnn localfnn = this.vRg;
    if (localfnn != null)
    {
      AppMethodBeat.o(303255);
      return localfnn;
    }
    s.bIx("tmplParams");
    AppMethodBeat.o(303255);
    return null;
  }
  
  private final String dfb()
  {
    AppMethodBeat.i(6602);
    String str = (String)this.vRi.getValue();
    AppMethodBeat.o(6602);
    return str;
  }
  
  private final int dfc()
  {
    AppMethodBeat.i(6603);
    int i = ((Number)this.vRj.getValue()).intValue();
    AppMethodBeat.o(6603);
    return i;
  }
  
  private final long dfd()
  {
    AppMethodBeat.i(6604);
    long l = ((Number)this.vRk.getValue()).longValue();
    AppMethodBeat.o(6604);
    return l;
  }
  
  private final int dfe()
  {
    AppMethodBeat.i(6605);
    int i = ((Number)this.vRl.getValue()).intValue();
    AppMethodBeat.o(6605);
    return i;
  }
  
  private final String dff()
  {
    AppMethodBeat.i(6606);
    String str = (String)this.vSu.getValue();
    AppMethodBeat.o(6606);
    return str;
  }
  
  private final Long[] dfg()
  {
    AppMethodBeat.i(6607);
    Long[] arrayOfLong = (Long[])this.vSx.getValue();
    AppMethodBeat.o(6607);
    return arrayOfLong;
  }
  
  private final String dfh()
  {
    AppMethodBeat.i(6611);
    Object localObject = new StringBuilder();
    if (this.vSe == 1) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.vSd) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (n.bp((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "sb.toString()");
    AppMethodBeat.o(6611);
    return localObject;
  }
  
  private final String dfi()
  {
    AppMethodBeat.i(6612);
    Object localObject = new StringBuilder();
    if (this.vSe == 2) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.vRW) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (!this.vRY)
    {
      ((StringBuilder)localObject).append("tmpl fail;");
      if (!this.vSw) {
        break label146;
      }
      ((StringBuilder)localObject).append("timeout;");
    }
    for (;;)
    {
      if (this.vSb) {
        ((StringBuilder)localObject).append("xweb_cc;");
      }
      if (n.bp((CharSequence)localObject)) {
        ((StringBuilder)localObject).append("ok;");
      }
      localObject = ((StringBuilder)localObject).toString();
      s.s(localObject, "sb.toString()");
      AppMethodBeat.o(6612);
      return localObject;
      if (this.vRX) {
        break;
      }
      ((StringBuilder)localObject).append("inject fail;");
      break;
      label146:
      if (this.vSv) {
        ((StringBuilder)localObject).append("h5;");
      }
    }
  }
  
  private final String dfj()
  {
    AppMethodBeat.i(6613);
    Object localObject = new StringBuilder();
    if (this.qon) {
      ((StringBuilder)localObject).append("zip;");
    }
    if (this.vSa) {
      ((StringBuilder)localObject).append("prefixMP;");
    }
    if (n.bp((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("none;");
    }
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "sb.toString()");
    AppMethodBeat.o(6613);
    return localObject;
  }
  
  private final String dfk()
  {
    AppMethodBeat.i(6614);
    Object localObject = new StringBuilder();
    if (!this.vRV) {
      ((StringBuilder)localObject).append("async;");
    }
    if (this.vRZ) {
      ((StringBuilder)localObject).append("mounted;");
    }
    if (this.vSc) {
      ((StringBuilder)localObject).append("cache_tmpl;");
    }
    if (n.bp((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "sb.toString()");
    AppMethodBeat.o(6614);
    return localObject;
  }
  
  private final long kl(long paramLong)
  {
    AppMethodBeat.i(6609);
    paramLong = Math.min(Math.max(-this.vSy, paramLong), this.vSy);
    AppMethodBeat.o(6609);
    return paramLong;
  }
  
  private final boolean km(long paramLong)
  {
    AppMethodBeat.i(303317);
    if (kl(paramLong) == paramLong)
    {
      AppMethodBeat.o(303317);
      return true;
    }
    AppMethodBeat.o(303317);
    return false;
  }
  
  private static String kn(long paramLong)
  {
    AppMethodBeat.i(6616);
    String str = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(paramLong));
    s.s(str, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
    AppMethodBeat.o(6616);
    return str;
  }
  
  public final void a(fnn paramfnn)
  {
    AppMethodBeat.i(303409);
    s.u(paramfnn, "<set-?>");
    this.vRg = paramfnn;
    AppMethodBeat.o(303409);
  }
  
  public final void h(q<? super String, ? super String, ? super List<kotlin.r<String, String>>, ah> paramq)
  {
    AppMethodBeat.i(6608);
    s.u(paramq, "data");
    if ((!this.vSf) || (!this.vSg))
    {
      AppMethodBeat.o(6608);
      return;
    }
    com.tencent.mm.plugin.webview.g.a.ik(dfa().reportId, 132);
    String str2 = f.getNetWorkType();
    this.vSh = Math.max(this.vRo, this.vRy);
    int i;
    if (this.vRo < this.vRy) {
      i = 1;
    }
    for (;;)
    {
      this.vSi = i;
      this.vSj = (this.vSh - this.vRn);
      this.vSp = (this.vRs - this.vRn);
      this.vSo = (this.vRC - this.vRD);
      this.vSq = (this.vRy - this.vRn);
      this.vSr = (this.vRy - this.vRx);
      this.vRp = (this.vRo - this.vRn);
      this.vSk = (this.vRz - this.vRn);
      this.vSl = (this.vRA - this.vRz);
      this.vSn = (this.vRu - this.vRt);
      this.vSm = (this.vRC - this.vRB);
      this.vRm = (this.vRC - this.vRD);
      this.vSs = (this.vSk + this.vSl + this.vSn + this.vSm + this.vRr + this.vRq);
      Log.d(this.TAG, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", new Object[] { Integer.valueOf(dfa().version), this.url, Integer.valueOf(dfc()), str2, Long.valueOf(this.vSj), Integer.valueOf(this.vSi), Long.valueOf(this.vRq), Long.valueOf(this.vSq), Boolean.valueOf(this.vRW), Long.valueOf(this.vRF - this.vRE), Boolean.valueOf(this.vRV), Long.valueOf(this.vSn), Long.valueOf(this.vSr), Long.valueOf(this.vSp), Long.valueOf(this.vRr), Long.valueOf(this.vRq), Integer.valueOf(dfa().vST), dfa().mXG, this.vSt, dff(), Integer.valueOf(this.vAZ), Long.valueOf(this.vSo), Boolean.valueOf(this.vSd) });
      if (!BuildInfo.IS_FLAVOR_RED) {
        boolean bool = BuildInfo.DEBUG;
      }
      try
      {
        String str1 = this.url;
        s.checkNotNull(str1);
        str1 = com.tencent.mm.compatible.util.r.as(str1, "UTF-8");
        h localh = h.OAn;
        int m = this.vRf;
        int n = dfa().version;
        int i1 = dfc();
        l1 = kl(this.vSj);
        int i2 = this.vSi;
        long l2 = kl(this.vRp);
        long l3 = kl(this.vSq);
        if (this.vRW)
        {
          i = 1;
          long l4 = kl(this.vRF - this.vRE);
          if (!this.vRV) {
            break label1997;
          }
          j = 1;
          long l5 = kl(this.vSn);
          long l6 = kl(this.vSr);
          long l7 = kl(this.vSp);
          long l8 = kl(this.vRr);
          long l9 = kl(this.vRq);
          int i3 = dfa().vST;
          Object localObject2 = dfa().mXG;
          String str3 = this.vSt;
          String str4 = dff();
          int i4 = this.vAZ;
          long l10 = kl(this.vSo);
          if (!this.vSd) {
            break label2002;
          }
          k = 1;
          localh.b(m, new Object[] { Integer.valueOf(n), str1, Integer.valueOf(i1), str2, Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l4), Integer.valueOf(j), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i3), localObject2, str3, str4, Integer.valueOf(i4), Long.valueOf(l10), Integer.valueOf(k), Long.valueOf(kl(this.vSk)), Long.valueOf(kl(this.vSl)), Long.valueOf(kl(this.vSm)) });
          localh = h.OAn;
          localObject2 = new al(19);
          ((al)localObject2).add(str1);
          ((al)localObject2).add(Integer.valueOf(this.vAZ));
          ((al)localObject2).add(str2);
          ((al)localObject2).add(Integer.valueOf(dfc()));
          ((al)localObject2).add(dfa().mXG);
          ((al)localObject2).add(dff());
          ((al)localObject2).add(this.vSt);
          if (!this.vRV) {
            break label2008;
          }
          i = 1;
          ((al)localObject2).add(Integer.valueOf(i));
          if (this.vSd) {
            break label2013;
          }
          i = 1;
          if (i == 0) {
            break label2018;
          }
          i = 1;
          ((al)localObject2).add(Integer.valueOf(i));
          if (this.vRW) {
            break label2023;
          }
          i = 1;
          if (i == 0) {
            break label2028;
          }
          i = 1;
          ((al)localObject2).add(Integer.valueOf(i));
          ((al)localObject2).add(Integer.valueOf(this.vSe));
          if (!this.vRZ) {
            break label2033;
          }
          i = 1;
          ((al)localObject2).add(Integer.valueOf(i));
          if (!this.vRX) {
            break label2038;
          }
          i = 1;
          ((al)localObject2).add(Integer.valueOf(i));
          ((al)localObject2).add(Long.valueOf(this.vSj));
          ((al)localObject2).hx(dfg());
          ((al)localObject2).add(this.key);
          if (!this.qon) {
            break label2043;
          }
          i = 1;
          ((al)localObject2).add(Integer.valueOf(i));
          if (!this.vSb) {
            break label2048;
          }
          i = 1;
          ((al)localObject2).add(Integer.valueOf(i));
          ((al)localObject2).add(Long.valueOf(this.vRG));
          localh.b(16874, ((al)localObject2).toArray(new Object[((al)localObject2).hqL.size()]));
          com.tencent.mm.plugin.webview.g.a.atP(0);
          if (this.qon)
          {
            com.tencent.mm.plugin.webview.g.a.atP(111);
            com.tencent.mm.plugin.webview.g.a.ik(dfa().reportId, 232);
          }
          if (this.vSb) {
            com.tencent.mm.plugin.webview.g.a.atP(113);
          }
          com.tencent.mm.plugin.webview.g.a.bk(1, this.vSj);
          com.tencent.mm.plugin.webview.g.a.bk(2, this.vRp);
          l1 = this.vRz - this.vRn;
          if (!this.vSd) {
            break label2053;
          }
          com.tencent.mm.plugin.webview.g.a.bk(10, this.vSj);
          com.tencent.mm.plugin.webview.g.a.bk(11, this.vRp);
          com.tencent.mm.plugin.webview.g.a.bk(12, l1);
          com.tencent.mm.plugin.webview.g.a.bk(13, this.vRI - this.vRH);
          com.tencent.mm.plugin.webview.g.a.bk(14, this.vRF - this.vRE);
          com.tencent.mm.plugin.webview.g.a.bk(15, this.vRC - this.vRB);
          paramq.invoke("['FirstScreen', 'BindMP', 'WebView', 'WebViewUI', null, 'BindMM', 'JsAPI', 'GetA8Key', 'GetData', 'InjectData']", "[" + p.a((Iterable)kotlin.a.k.ac(dfg()), null, null, null, 0, null, null, 63) + ']', p.listOf(new kotlin.r[] { v.Y("section", "[debug]"), v.Y("info", dfb()), v.Y("settings", Y((CharSequence)"")), v.Y("section", "[process]"), v.Y("process", dff()), v.Y("state", dfh()), v.Y("section", "[webview]"), v.Y("kind", this.vSt), v.Y("state", dfi()), v.Y("section", "[tmpl]"), v.Y("uid", dfa().mXG), v.Y("tmplType", String.valueOf(dfa().vST)), v.Y("version", String.valueOf(dfa().version)), v.Y("md5", dfa().md5), v.Y("time", kn(dfa().QzY)), v.Y("state", dfj()), v.Y("section", "[data]"), v.Y("dataSize", s.X(cd(dfc() / 1024.0F), "Kb")), v.Y("dataTime", String.valueOf(this.vSn)), v.Y("cached", kn(dfd())), v.Y("version", String.valueOf(dfe())), v.Y("expire in", this.vRh + 's'), v.Y("scene", String.valueOf(this.vAZ)), v.Y("state", dfk()) }));
          Log.i(this.TAG, "terry performance report:" + this.vRn + '\n' + kotlin.a.k.a(dfg(), null, null, null, 0, null, null, 63));
          AppMethodBeat.o(6608);
          return;
          i = 2;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          long l1;
          Log.printErrStackTrace(this.TAG, (Throwable)localUnsupportedEncodingException, "url:%d", new Object[] { this.url });
          Object localObject1 = null;
          continue;
          i = 0;
          continue;
          label1997:
          int j = 0;
          continue;
          label2002:
          int k = 0;
          continue;
          label2008:
          i = 0;
          continue;
          label2013:
          i = 0;
          continue;
          label2018:
          i = 0;
          continue;
          label2023:
          i = 0;
          continue;
          label2028:
          i = 0;
          continue;
          label2033:
          i = 0;
          continue;
          label2038:
          i = 0;
          continue;
          label2043:
          i = 0;
          continue;
          label2048:
          i = 0;
          continue;
          label2053:
          com.tencent.mm.plugin.webview.g.a.bk(20, this.vSj);
          com.tencent.mm.plugin.webview.g.a.bk(21, this.vRp);
          com.tencent.mm.plugin.webview.g.a.bk(22, l1);
          com.tencent.mm.plugin.webview.g.a.bk(23, this.vRI - this.vRH);
          if (!this.vRV)
          {
            com.tencent.mm.plugin.webview.g.a.bk(24, this.vRw - this.vRv);
            com.tencent.mm.plugin.webview.g.a.atP(107);
          }
        }
      }
    }
  }
  
  public final void setKey(String paramString)
  {
    AppMethodBeat.i(303416);
    s.u(paramString, "<set-?>");
    this.key = paramString;
    AppMethodBeat.o(303416);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6617);
    Log.v(this.TAG, "terry performance log:\n" + this.vSk + ',' + this.vSl + ',' + (this.vRI - this.vRA) + ',' + (Math.max(this.vRI, this.vRF) - this.vRI) + ',' + (this.vRB - Math.max(this.vRI, this.vRF)) + ',' + this.vSm);
    Log.v(this.TAG, s.X("terry performance timestamp:\n ", kotlin.a.k.a(dfg(), null, null, null, 0, null, null, 63)));
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("\n            [debug]\n            info: ").append(dfb()).append("\n            settings: ").append(Y((CharSequence)"\n")).append("\n\n            [process]\n            process: ").append(dff()).append("\n            state: ").append(dfh()).append("\n\n            [webview]\n            kind: ").append(this.vSt).append("\n            state: ").append(dfi()).append("\n\n            [tmpl]\n            uid: ").append(dfa().mXG).append("\n            tmplType: ").append(dfa().vST).append("\n            version: ").append(dfa().version).append("\n            md5: ").append(dfa().md5).append("\n            time: ").append(kn(dfa().QzY)).append("\n            state: ");
    StringBuilder localStringBuilder2 = localStringBuilder1.append(dfj()).append("\n\n            [data]\n            dataSize: ").append(cd(dfc() / 1024.0F)).append("Kb\n            dataTime: ").append(this.vSn).append("\n            cached: ").append(kn(dfd())).append("\n            version: ").append(dfe()).append("\n            expire in: ").append(this.vRh).append("s\n            scene: ").append(this.vAZ).append("\n            state: ").append(dfk()).append("\n\n            [performance](ms)\n            finishType: ").append(this.vSi).append("\n            finishTime: ").append(this.vSj);
    if (this.vSj != Math.max(this.vSq, this.vSs)) {}
    for (String str = s.X("/", a(this.vSs, this));; str = "")
    {
      localStringBuilder2.append(str).append("\n            firstScreenFinish: ").append(a(this.vRp, this)).append('/');
      localStringBuilder1.append(a(this.vSs, this)).append("\n            a8keyFinish: ").append(this.vSq).append("\n\n            client:\n            TmplCostTime: ").append(this.vRF - this.vRE).append("\n            WebViewUICostTime: ").append(this.vRI - this.vRH).append("\n            NotifyPageCostTime: ").append(this.vRG - this.vRC).append("\n\n            1.bindWebViewCostTime: ").append(this.vSk).append("\n            2.createWebViewCostTime: ").append(this.vSl).append("\n            3.getPageDataCostTime: ").append(this.vSn).append("\n            4.injectCostTime: ").append(a(this.vSm, this)).append("\n            eval cost: ").append(this.vRm).append("\n\n            js:\n            4.1.onReceivePageData: ").append(this.vRD - this.vRs).append("\n            5.ctWebCompile: ").append(this.vRr);
      localStringBuilder1.append("\n            6.renderTime: ").append(this.vRq).append("\n\n            [js]webReceivePageDataTime: ").append(this.vSp).append("\n            a8KeyFinishTime: ").append(this.vSq).append("\n            getA8KeyCostTime: ").append(this.vSr).append("\n        ");
      str = n.bJB(localStringBuilder1.toString());
      AppMethodBeat.o(6617);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<String>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Long>
  {
    c(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    d(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<Integer>
  {
    e(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<Long[]>
  {
    f(i parami)
    {
      super();
    }
    
    private static final Long[] a(i parami, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(303044);
      parami = i.a(new Long[] { Long.valueOf(paramLong2 - paramLong1), Long.valueOf(paramLong2 - parami.vRn) }, new long[] { paramLong1, paramLong2 });
      AppMethodBeat.o(303044);
      return parami;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<String>
  {
    public static final g vSA;
    
    static
    {
      AppMethodBeat.i(6600);
      vSA = new g();
      AppMethodBeat.o(6600);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.i
 * JD-Core Version:    0.7.0.1
 */