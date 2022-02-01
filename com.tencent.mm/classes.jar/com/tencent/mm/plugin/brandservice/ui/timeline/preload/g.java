package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.e;
import d.f;
import d.g.a.b;
import d.g.a.m;
import d.g.b.ac;
import d.g.b.p;
import d.l;
import d.n.n;
import d.o;
import d.u;
import d.v;
import d.z;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "printDataState", "printDebugger", "prefix", "", "printProcessState", "printTmplState", "printWebViewState", "report", "", "data", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "toString", "format", "kotlin.jvm.PlatformType", "", "digits", "limit", "toDate", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class g
{
  public static final a opd;
  private final String TAG;
  private String key;
  public int obQ;
  private final int onI;
  public dog onJ;
  public int onK;
  private final f onL;
  private final f onM;
  private final f onN;
  private final f onO;
  private long onP;
  public long onQ;
  public long onR;
  long onS;
  public long onT;
  public long onU;
  public long onV;
  public long onW;
  public long onX;
  public long onY;
  public long onZ;
  public boolean ooA;
  public boolean ooB;
  public boolean ooC;
  public boolean ooD;
  public boolean ooE;
  public boolean ooF;
  public boolean ooG;
  public boolean ooH;
  public int ooI;
  public boolean ooJ;
  public boolean ooK;
  private long ooL;
  private int ooM;
  private long ooN;
  private long ooO;
  private long ooP;
  private long ooQ;
  private long ooR;
  private long ooS;
  private long ooT;
  private long ooU;
  private long ooV;
  private long ooW;
  public String ooX;
  private final f ooY;
  public boolean ooZ;
  long ooa;
  public long oob;
  public long ooc;
  public long ood;
  public long ooe;
  public long oof;
  public long oog;
  public long ooh;
  public long ooi;
  public long ooj;
  long ook;
  long ool;
  long oom;
  long oon;
  long ooo;
  public long oop;
  public long ooq;
  public long oor;
  public long oos;
  public long oot;
  public long oou;
  public long oov;
  public long oow;
  public long oox;
  public boolean ooy;
  public boolean ooz;
  public boolean opa;
  private final f opb;
  private long opc;
  public String url;
  
  static
  {
    AppMethodBeat.i(6601);
    opd = new a((byte)0);
    AppMethodBeat.o(6601);
  }
  
  public g()
  {
    AppMethodBeat.i(6618);
    this.TAG = "MicroMsg.Preload.Kv15862";
    this.onI = 15862;
    this.key = "";
    this.url = "";
    this.onL = d.g.O((d.g.a.a)new b(this));
    this.onM = d.g.O((d.g.a.a)new e(this));
    this.onN = d.g.O((d.g.a.a)new c(this));
    this.onO = d.g.O((d.g.a.a)new d(this));
    this.onP = -1L;
    this.ooc = -1L;
    this.ood = -1L;
    this.ooe = -1L;
    this.oof = -1L;
    this.oog = -1L;
    this.ooh = -1L;
    this.ooi = -1L;
    this.ooj = -1L;
    this.ooX = "";
    this.ooY = d.g.O((d.g.a.a)h.opg);
    this.obQ = 10000;
    this.opb = d.g.O((d.g.a.a)new f(this));
    this.opc = 3600000L;
    AppMethodBeat.o(6618);
  }
  
  private final String H(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(6610);
    StringBuilder localStringBuilder = new StringBuilder();
    h.a locala = h.oph;
    if (h.a.bQs()) {
      localStringBuilder.append(paramCharSequence + "no re-direct;");
    }
    locala = h.oph;
    if (!h.a.bQn()) {
      localStringBuilder.append(paramCharSequence + "no preload data;");
    }
    locala = h.oph;
    if (h.a.bQt()) {
      localStringBuilder.append(paramCharSequence + "no preload webview;");
    }
    locala = h.oph;
    if (h.a.bQp()) {
      localStringBuilder.append(paramCharSequence + "data no expire;");
    }
    locala = h.oph;
    if (h.a.bQu()) {
      localStringBuilder.append(paramCharSequence + "no red;");
    }
    paramCharSequence = this.onJ;
    if (paramCharSequence == null) {
      p.bdF("tmplParams");
    }
    paramCharSequence = paramCharSequence.HVi;
    p.g(paramCharSequence, "tmplParams.headers");
    if (!n.aD((CharSequence)paramCharSequence)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCharSequence = this.onJ;
        if (paramCharSequence == null) {
          p.bdF("tmplParams");
        }
        localStringBuilder.append(paramCharSequence.HVi);
      }
      if (n.aD((CharSequence)localStringBuilder)) {
        localStringBuilder.append("none;");
      }
      paramCharSequence = localStringBuilder.toString();
      p.g(paramCharSequence, "sb.toString()");
      AppMethodBeat.o(6610);
      return paramCharSequence;
    }
  }
  
  private static String aT(float paramFloat)
  {
    AppMethodBeat.i(6615);
    String str = String.format("%.2f", new Object[] { Float.valueOf(paramFloat) });
    AppMethodBeat.o(6615);
    return str;
  }
  
  private final String bQc()
  {
    AppMethodBeat.i(6602);
    String str = (String)this.onL.getValue();
    AppMethodBeat.o(6602);
    return str;
  }
  
  private final int bQd()
  {
    AppMethodBeat.i(6603);
    int i = ((Number)this.onM.getValue()).intValue();
    AppMethodBeat.o(6603);
    return i;
  }
  
  private final long bQe()
  {
    AppMethodBeat.i(6604);
    long l = ((Number)this.onN.getValue()).longValue();
    AppMethodBeat.o(6604);
    return l;
  }
  
  private final int bQf()
  {
    AppMethodBeat.i(6605);
    int i = ((Number)this.onO.getValue()).intValue();
    AppMethodBeat.o(6605);
    return i;
  }
  
  private final String bQg()
  {
    AppMethodBeat.i(6606);
    String str = (String)this.ooY.getValue();
    AppMethodBeat.o(6606);
    return str;
  }
  
  private final Long[] bQh()
  {
    AppMethodBeat.i(6607);
    Long[] arrayOfLong = (Long[])this.opb.getValue();
    AppMethodBeat.o(6607);
    return arrayOfLong;
  }
  
  private final String bQi()
  {
    AppMethodBeat.i(6611);
    Object localObject = new StringBuilder();
    if (this.ooI == 1) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.ooH) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (n.aD((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6611);
    return localObject;
  }
  
  private final String bQj()
  {
    AppMethodBeat.i(6612);
    Object localObject = new StringBuilder();
    if (this.ooI == 2) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.ooz) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (!this.ooB)
    {
      ((StringBuilder)localObject).append("tmpl fail;");
      if (!this.opa) {
        break label146;
      }
      ((StringBuilder)localObject).append("timeout;");
    }
    for (;;)
    {
      if (this.ooF) {
        ((StringBuilder)localObject).append("xweb_cc;");
      }
      if (n.aD((CharSequence)localObject)) {
        ((StringBuilder)localObject).append("ok;");
      }
      localObject = ((StringBuilder)localObject).toString();
      p.g(localObject, "sb.toString()");
      AppMethodBeat.o(6612);
      return localObject;
      if (this.ooA) {
        break;
      }
      ((StringBuilder)localObject).append("inject fail;");
      break;
      label146:
      if (this.ooZ) {
        ((StringBuilder)localObject).append("h5;");
      }
    }
  }
  
  private final String bQk()
  {
    AppMethodBeat.i(6613);
    Object localObject = new StringBuilder();
    if (this.ooD) {
      ((StringBuilder)localObject).append("zip;");
    }
    if (this.ooE) {
      ((StringBuilder)localObject).append("prefixMP;");
    }
    if (n.aD((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("none;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6613);
    return localObject;
  }
  
  private final String bQl()
  {
    AppMethodBeat.i(6614);
    Object localObject = new StringBuilder();
    if (!this.ooy) {
      ((StringBuilder)localObject).append("async;");
    }
    if (this.ooC) {
      ((StringBuilder)localObject).append("mounted;");
    }
    if (this.ooG) {
      ((StringBuilder)localObject).append("cache_tmpl;");
    }
    if (n.aD((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6614);
    return localObject;
  }
  
  private final long tD(long paramLong)
  {
    AppMethodBeat.i(6609);
    paramLong = Math.min(Math.max(-this.opc, paramLong), this.opc);
    AppMethodBeat.o(6609);
    return paramLong;
  }
  
  private static String tE(long paramLong)
  {
    AppMethodBeat.i(6616);
    String str = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(paramLong));
    p.g(str, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
    AppMethodBeat.o(6616);
    return str;
  }
  
  public final void a(dog paramdog)
  {
    AppMethodBeat.i(208819);
    p.h(paramdog, "<set-?>");
    this.onJ = paramdog;
    AppMethodBeat.o(208819);
  }
  
  public final void b(d.g.a.q<? super String, ? super String, ? super List<o<String, String>>, z> paramq)
  {
    AppMethodBeat.i(6608);
    p.h(paramq, "data");
    if ((!this.ooJ) || (!this.ooK))
    {
      AppMethodBeat.o(6608);
      return;
    }
    Object localObject1 = this.onJ;
    if (localObject1 == null) {
      p.bdF("tmplParams");
    }
    com.tencent.mm.plugin.webview.g.a.gi(((dog)localObject1).reportId, 132);
    Object localObject3 = d.bQb();
    this.ooL = Math.max(this.onR, this.oob);
    if (this.onR < this.oob) {}
    int j;
    long l1;
    int k;
    for (int i = 1;; i = 2)
    {
      this.ooM = i;
      this.ooN = (this.ooL - this.onQ);
      this.ooT = (this.onV - this.onQ);
      this.ooS = (this.oof - this.oog);
      this.ooU = (this.oob - this.onQ);
      this.ooV = (this.oob - this.ooa);
      this.onS = (this.onR - this.onQ);
      this.ooO = (this.ooc - this.onQ);
      this.ooP = (this.ood - this.ooc);
      this.ooR = (this.onX - this.onW);
      this.ooQ = (this.oof - this.ooe);
      this.onP = (this.oof - this.oog);
      this.ooW = (this.ooO + this.ooP + this.ooR + this.ooQ + this.onU + this.onT);
      localObject1 = this.TAG;
      Object localObject4 = this.onJ;
      if (localObject4 == null) {
        p.bdF("tmplParams");
      }
      i = ((dog)localObject4).version;
      localObject4 = this.url;
      j = bQd();
      l1 = this.ooN;
      k = this.ooM;
      long l2 = this.onT;
      long l3 = this.ooU;
      boolean bool1 = this.ooz;
      long l4 = this.ooi;
      long l5 = this.ooh;
      boolean bool2 = this.ooy;
      long l6 = this.ooR;
      long l7 = this.ooV;
      long l8 = this.ooT;
      long l9 = this.onU;
      long l10 = this.onT;
      Object localObject5 = this.onJ;
      if (localObject5 == null) {
        p.bdF("tmplParams");
      }
      int m = ((dog)localObject5).opt;
      localObject5 = this.onJ;
      if (localObject5 == null) {
        p.bdF("tmplParams");
      }
      ae.d((String)localObject1, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", new Object[] { Integer.valueOf(i), localObject4, Integer.valueOf(j), localObject3, Long.valueOf(l1), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Long.valueOf(l4 - l5), Boolean.valueOf(bool2), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Integer.valueOf(m), ((dog)localObject5).AXc, this.ooX, bQg(), Integer.valueOf(this.obQ), Long.valueOf(this.ooS), Boolean.valueOf(this.ooH) });
      if (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) {
        bool1 = com.tencent.mm.sdk.platformtools.j.DEBUG;
      }
      try
      {
        localObject1 = this.url;
        if (localObject1 == null) {
          p.gkB();
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
          dog localdog;
          ae.printErrStackTrace(this.TAG, (Throwable)localUnsupportedEncodingException, "url:%d", new Object[] { this.url });
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
          com.tencent.mm.plugin.webview.g.a.aK(20, this.ooN);
          com.tencent.mm.plugin.webview.g.a.aK(21, this.onS);
          com.tencent.mm.plugin.webview.g.a.aK(22, l1);
          com.tencent.mm.plugin.webview.g.a.aK(23, this.ool - this.ook);
          if (!this.ooy)
          {
            com.tencent.mm.plugin.webview.g.a.aK(24, this.onZ - this.onY);
            com.tencent.mm.plugin.webview.g.a.XA(107);
          }
        }
        paramq.d("['FirstScreen', 'BindMP', 'WebView', 'WebViewUI', null, 'BindMM', 'JsAPI', 'GetA8Key', 'GetData', 'InjectData']", localObject2, localObject3);
        ae.i(this.TAG, "terry performance report:" + this.onQ + '\n' + e.a(bQh(), null, null, null, 0, null, null, 63));
        AppMethodBeat.o(6608);
      }
      localObject4 = com.tencent.mm.plugin.report.service.g.yxI;
      m = this.onI;
      localObject5 = this.onJ;
      if (localObject5 == null) {
        p.bdF("tmplParams");
      }
      n = ((dog)localObject5).version;
      i1 = bQd();
      l1 = tD(this.ooN);
      i2 = this.ooM;
      l2 = tD(this.onS);
      l3 = tD(this.ooU);
      if (!this.ooz) {
        break;
      }
      i = 1;
      l4 = tD(this.ooi - this.ooh);
      if (!this.ooy) {
        break label2308;
      }
      j = 1;
      l5 = tD(this.ooR);
      l6 = tD(this.ooV);
      l7 = tD(this.ooT);
      l8 = tD(this.onU);
      l9 = tD(this.onT);
      localObject5 = this.onJ;
      if (localObject5 == null) {
        p.bdF("tmplParams");
      }
      i3 = ((dog)localObject5).opt;
      localObject5 = this.onJ;
      if (localObject5 == null) {
        p.bdF("tmplParams");
      }
      localObject5 = ((dog)localObject5).AXc;
      localObject6 = this.ooX;
      localObject7 = bQg();
      i4 = this.obQ;
      l10 = tD(this.ooS);
      if (!this.ooH) {
        break label2313;
      }
      k = 1;
      ((com.tencent.mm.plugin.report.service.g)localObject4).f(m, new Object[] { Integer.valueOf(n), localObject1, Integer.valueOf(i1), localObject3, Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l4), Integer.valueOf(j), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i3), localObject5, localObject6, localObject7, Integer.valueOf(i4), Long.valueOf(l10), Integer.valueOf(k), Long.valueOf(tD(this.ooO)), Long.valueOf(tD(this.ooP)), Long.valueOf(tD(this.ooQ)) });
      localObject4 = com.tencent.mm.plugin.report.service.g.yxI;
      localObject5 = new ac(19);
      ((ac)localObject5).add(localObject1);
      ((ac)localObject5).add(Integer.valueOf(this.obQ));
      ((ac)localObject5).add(localObject3);
      ((ac)localObject5).add(Integer.valueOf(bQd()));
      localObject1 = this.onJ;
      if (localObject1 == null) {
        p.bdF("tmplParams");
      }
      ((ac)localObject5).add(((dog)localObject1).AXc);
      ((ac)localObject5).add(bQg());
      ((ac)localObject5).add(this.ooX);
      if (!this.ooy) {
        break label2319;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      if (this.ooH) {
        break label2324;
      }
      i = 1;
      if (i == 0) {
        break label2329;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      if (this.ooz) {
        break label2334;
      }
      i = 1;
      if (i == 0) {
        break label2339;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      ((ac)localObject5).add(Integer.valueOf(this.ooI));
      if (!this.ooC) {
        break label2344;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      if (!this.ooA) {
        break label2349;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      ((ac)localObject5).add(Long.valueOf(this.ooN));
      ((ac)localObject5).eR(bQh());
      ((ac)localObject5).add(this.key);
      if (!this.ooD) {
        break label2354;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      if (!this.ooF) {
        break label2359;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      ((ac)localObject5).add(Long.valueOf(this.ooj));
      ((com.tencent.mm.plugin.report.service.g)localObject4).f(16874, ((ac)localObject5).toArray(new Object[((ac)localObject5).ddb.size()]));
      com.tencent.mm.plugin.webview.g.a.XA(0);
      if (this.ooD)
      {
        com.tencent.mm.plugin.webview.g.a.XA(111);
        localObject1 = this.onJ;
        if (localObject1 == null) {
          p.bdF("tmplParams");
        }
        com.tencent.mm.plugin.webview.g.a.gi(((dog)localObject1).reportId, 232);
      }
      if (this.ooF) {
        com.tencent.mm.plugin.webview.g.a.XA(113);
      }
      com.tencent.mm.plugin.webview.g.a.aK(1, this.ooN);
      com.tencent.mm.plugin.webview.g.a.aK(2, this.onS);
      l1 = this.ooc - this.onQ;
      if (!this.ooH) {
        break label2364;
      }
      com.tencent.mm.plugin.webview.g.a.aK(10, this.ooN);
      com.tencent.mm.plugin.webview.g.a.aK(11, this.onS);
      com.tencent.mm.plugin.webview.g.a.aK(12, l1);
      com.tencent.mm.plugin.webview.g.a.aK(13, this.ool - this.ook);
      com.tencent.mm.plugin.webview.g.a.aK(14, this.ooi - this.ooh);
      com.tencent.mm.plugin.webview.g.a.aK(15, this.oof - this.ooe);
      localObject1 = "[" + d.a.j.a((Iterable)e.T(bQh()), null, null, null, 0, null, null, 63) + ']';
      localObject3 = u.R("section", "[debug]");
      localObject4 = u.R("info", bQc());
      localObject5 = u.R("settings", H((CharSequence)""));
      localObject6 = u.R("section", "[process]");
      localObject7 = u.R("process", bQg());
      localo1 = u.R("state", bQi());
      localo2 = u.R("section", "[webview]");
      localo3 = u.R("kind", this.ooX);
      localo4 = u.R("state", bQj());
      localo5 = u.R("section", "[tmpl]");
      localObject8 = this.onJ;
      if (localObject8 == null) {
        p.bdF("tmplParams");
      }
      localObject8 = u.R("uid", ((dog)localObject8).AXc);
      localObject9 = this.onJ;
      if (localObject9 == null) {
        p.bdF("tmplParams");
      }
      localObject9 = u.R("tmplType", String.valueOf(((dog)localObject9).opt));
      localObject10 = this.onJ;
      if (localObject10 == null) {
        p.bdF("tmplParams");
      }
      localObject10 = u.R("version", String.valueOf(((dog)localObject10).version));
      localObject11 = this.onJ;
      if (localObject11 == null) {
        p.bdF("tmplParams");
      }
      localObject11 = u.R("md5", ((dog)localObject11).md5);
      localdog = this.onJ;
      if (localdog == null) {
        p.bdF("tmplParams");
      }
      localObject3 = d.a.j.listOf(new o[] { localObject3, localObject4, localObject5, localObject6, localObject7, localo1, localo2, localo3, localo4, localo5, localObject8, localObject9, localObject10, localObject11, u.R("time", tE(localdog.zFz)), u.R("state", bQk()), u.R("section", "[data]"), u.R("dataSize", aT(bQd() / 1024.0F) + "Kb"), u.R("dataTime", String.valueOf(this.ooR)), u.R("cached", tE(bQe())), u.R("version", String.valueOf(bQf())), u.R("expire in", this.onK + 's'), u.R("scene", String.valueOf(this.obQ)), u.R("state", bQl()) });
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
    AppMethodBeat.i(208820);
    p.h(paramString, "<set-?>");
    this.key = paramString;
    AppMethodBeat.o(208820);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6617);
    g localg = new g(this);
    ae.v(this.TAG, "terry performance log:\n" + this.ooO + ',' + this.ooP + ',' + (this.ool - this.ood) + ',' + (Math.max(this.ool, this.ooi) - this.ool) + ',' + (this.ooe - Math.max(this.ool, this.ooi)) + ',' + this.ooQ);
    ae.v(this.TAG, "terry performance timestamp:\n " + e.a(bQh(), null, null, null, 0, null, null, 63));
    Object localObject1 = new StringBuilder("\n            [debug]\n            info: ").append(bQc()).append("\n            settings: ").append(H((CharSequence)"\n")).append("\n\n            [process]\n            process: ").append(bQg()).append("\n            state: ").append(bQi()).append("\n\n            [webview]\n            kind: ").append(this.ooX).append("\n            state: ").append(bQj()).append("\n\n            [tmpl]\n            uid: ");
    Object localObject2 = this.onJ;
    if (localObject2 == null) {
      p.bdF("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dog)localObject2).AXc).append("\n            tmplType: ");
    localObject2 = this.onJ;
    if (localObject2 == null) {
      p.bdF("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dog)localObject2).opt).append("\n            version: ");
    localObject2 = this.onJ;
    if (localObject2 == null) {
      p.bdF("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dog)localObject2).version).append("\n            md5: ");
    localObject2 = this.onJ;
    if (localObject2 == null) {
      p.bdF("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dog)localObject2).md5).append("\n            time: ");
    localObject2 = this.onJ;
    if (localObject2 == null) {
      p.bdF("tmplParams");
    }
    localObject2 = ((StringBuilder)localObject1).append(tE(((dog)localObject2).zFz)).append("\n            state: ").append(bQk()).append("\n\n            [data]\n            dataSize: ").append(aT(bQd() / 1024.0F)).append("Kb\n            dataTime: ").append(this.ooR).append("\n            cached: ").append(tE(bQe())).append("\n            version: ").append(bQf()).append("\n            expire in: ").append(this.onK).append("s\n            scene: ").append(this.obQ).append("\n            state: ").append(bQl()).append("\n\n            [performance](ms)\n            finishType: ").append(this.ooM).append("\n            finishTime: ").append(this.ooN);
    if (this.ooN != Math.max(this.ooU, this.ooW)) {}
    for (localObject1 = "/" + localg.tF(this.ooW);; localObject1 = "")
    {
      localObject1 = n.beG((String)localObject1 + "\n            firstScreenFinish: " + localg.tF(this.onS) + '/' + localg.tF(this.ooW) + "\n            a8keyFinish: " + this.ooU + "\n\n            client:\n            TmplCostTime: " + (this.ooi - this.ooh) + "\n            WebViewUICostTime: " + (this.ool - this.ook) + "\n            NotifyPageCostTime: " + (this.ooj - this.oof) + "\n\n            1.bindWebViewCostTime: " + this.ooO + "\n            2.createWebViewCostTime: " + this.ooP + "\n            3.getPageDataCostTime: " + this.ooR + "\n            4.injectCostTime: " + localg.tF(this.ooQ) + "\n            eval cost: " + this.onP + "\n\n            js:\n            4.1.onReceivePageData: " + (this.oog - this.onV) + "\n            5.ctWebCompile: " + this.onU + "\n            6.renderTime: " + this.onT + "\n\n            [js]webReceivePageDataTime: " + this.ooT + "\n            a8KeyFinishTime: " + this.ooU + "\n            getA8KeyCostTime: " + this.ooV + "\n        ");
      AppMethodBeat.o(6617);
      return localObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<Long>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<Long[]>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"verify", "", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements b<Long, String>
  {
    g(g paramg)
    {
      super();
    }
    
    public final String tF(long paramLong)
    {
      AppMethodBeat.i(6598);
      if (g.a(this.ope, paramLong))
      {
        AppMethodBeat.o(6598);
        return String.valueOf(paramLong);
      }
      AppMethodBeat.o(6598);
      return "NaN";
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    public static final h opg;
    
    static
    {
      AppMethodBeat.i(6600);
      opg = new h();
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