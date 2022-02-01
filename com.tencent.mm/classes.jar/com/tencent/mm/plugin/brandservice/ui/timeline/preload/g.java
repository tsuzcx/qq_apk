package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import d.a.e;
import d.a.j;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "", "()V", "MAX_LIMIT", "", "MM_WEBIVEW_PRELOAD_LOAD_TIME", "", "TAG", "", "a8KeyFinishTime", "bindWebViewCostTime", "cacheItemShowType", "", "getCacheItemShowType", "()Z", "setCacheItemShowType", "(Z)V", "clientCachedTime", "getClientCachedTime", "()I", "setClientCachedTime", "(I)V", "clientFirstFinishTime", "contentId", "getContentId", "()Ljava/lang/String;", "contentId$delegate", "Lkotlin/Lazy;", "createWebViewCostTime", "ctWebCompile", "getCtWebCompile", "()J", "setCtWebCompile", "(J)V", "ctWebFirstScreen", "getCtWebFirstScreen", "setCtWebFirstScreen", "dataCachedTime", "getDataCachedTime", "dataCachedTime$delegate", "dataVersion", "getDataVersion", "dataVersion$delegate", "etWebFirstScreen", "getEtWebFirstScreen", "setEtWebFirstScreen", "evalCostTime", "getEvalCostTime", "setEvalCostTime", "evalPageDataCostTime", "getA8KeyCostTime", "getPageDataCostTime", "hasAuth", "getHasAuth", "setHasAuth", "hasInject", "getHasInject", "setHasInject", "injectCostTime", "isInjectSuccess", "setInjectSuccess", "isMounted", "setMounted", "isOnlineWebView", "setOnlineWebView", "isPrefixMP", "setPrefixMP", "isSyncGetPageData", "setSyncGetPageData", "isTimeoutRedirect", "setTimeoutRedirect", "isTmplReady", "setTmplReady", "isWebViewCreated", "setWebViewCreated", "isWebViewPreUpdated", "setWebViewPreUpdated", "isWebViewProcessCreated", "setWebViewProcessCreated", "isZip", "setZip", "key", "getKey", "setKey", "(Ljava/lang/String;)V", "openScene", "getOpenScene", "setOpenScene", "pageDataSize", "getPageDataSize", "pageDataSize$delegate", "pageFinishTime", "pageFinishTimeType", "pageFinishTimestamp", "relaunchState", "getRelaunchState", "setRelaunchState", "speedMatrix", "", "getSpeedMatrix", "()[Ljava/lang/Long;", "speedMatrix$delegate", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "setTmplParams", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;)V", "tsEndAcGetData", "getTsEndAcGetData", "setTsEndAcGetData", "tsEndGetA8Key", "getTsEndGetA8Key", "setTsEndGetA8Key", "tsEndGetData", "getTsEndGetData", "setTsEndGetData", "tsEndInject", "getTsEndInject", "setTsEndInject", "tsEndNotifyPage", "getTsEndNotifyPage", "setTsEndNotifyPage", "tsEndPostBind", "getTsEndPostBind", "setTsEndPostBind", "tsEndProcessInit", "getTsEndProcessInit", "setTsEndProcessInit", "tsEndTmplLoad", "getTsEndTmplLoad", "setTsEndTmplLoad", "tsEndUIInit", "getTsEndUIInit", "setTsEndUIInit", "tsEndWebGetData", "getTsEndWebGetData", "setTsEndWebGetData", "tsEndWebInject", "getTsEndWebInject", "setTsEndWebInject", "tsEndWebViewCreate", "getTsEndWebViewCreate", "setTsEndWebViewCreate", "tsStartAcGetData", "getTsStartAcGetData", "setTsStartAcGetData", "tsStartEndBind", "getTsStartEndBind", "setTsStartEndBind", "tsStartGetA8Key", "getTsStartGetA8Key", "setTsStartGetA8Key", "tsStartGetData", "getTsStartGetData", "setTsStartGetData", "tsStartInject", "getTsStartInject", "setTsStartInject", "tsStartPage", "getTsStartPage", "setTsStartPage", "tsStartPostBind", "getTsStartPostBind", "setTsStartPostBind", "tsStartProcessConfiguration", "getTsStartProcessConfiguration", "setTsStartProcessConfiguration", "tsStartProcessDependency", "getTsStartProcessDependency", "setTsStartProcessDependency", "tsStartProcessExecution", "getTsStartProcessExecution", "setTsStartProcessExecution", "tsStartProcessExtensions", "getTsStartProcessExtensions", "setTsStartProcessExtensions", "tsStartProcessHello", "getTsStartProcessHello", "setTsStartProcessHello", "tsStartProcessInit", "getTsStartProcessInit", "setTsStartProcessInit", "tsStartProcessInstall", "getTsStartProcessInstall", "setTsStartProcessInstall", "tsStartProcessTerminate", "getTsStartProcessTerminate", "setTsStartProcessTerminate", "tsStartTmplLoad", "getTsStartTmplLoad", "setTsStartTmplLoad", "tsStartTryBind", "getTsStartTryBind", "setTsStartTryBind", "tsStartUICreate", "getTsStartUICreate", "setTsStartUICreate", "tsStartUIInit", "getTsStartUIInit", "setTsStartUIInit", "tsStartWebViewCreate", "getTsStartWebViewCreate", "setTsStartWebViewCreate", "tsWebFirstScreen", "getTsWebFirstScreen", "setTsWebFirstScreen", "url", "getUrl", "setUrl", "useLocalJs", "getUseLocalJs", "setUseLocalJs", "webReceivePageDataTime", "webviewKind", "getWebviewKind", "setWebviewKind", "webviewProcess", "getWebviewProcess", "webviewProcess$delegate", "printDataState", "printDebugger", "prefix", "", "printProcessState", "printTmplState", "printWebViewState", "report", "", "data", "Lkotlin/Function3;", "", "Lkotlin/Pair;", "toString", "format", "kotlin.jvm.PlatformType", "", "digits", "limit", "toDate", "valid", "verify", "vals", "", "([Ljava/lang/Long;[J)[Ljava/lang/Long;", "Companion", "plugin-brandservice_release"})
public final class g
{
  public static final a ojd;
  private final String TAG;
  private String key;
  public int nWh;
  private final int ohI;
  public dnj ohJ;
  public int ohK;
  private final f ohL;
  private final f ohM;
  private final f ohN;
  private final f ohO;
  private long ohP;
  public long ohQ;
  public long ohR;
  long ohS;
  public long ohT;
  public long ohU;
  public long ohV;
  public long ohW;
  public long ohX;
  public long ohY;
  public long ohZ;
  public boolean oiA;
  public boolean oiB;
  public boolean oiC;
  public boolean oiD;
  public boolean oiE;
  public boolean oiF;
  public boolean oiG;
  public boolean oiH;
  public int oiI;
  public boolean oiJ;
  public boolean oiK;
  private long oiL;
  private int oiM;
  private long oiN;
  private long oiO;
  private long oiP;
  private long oiQ;
  private long oiR;
  private long oiS;
  private long oiT;
  private long oiU;
  private long oiV;
  private long oiW;
  public String oiX;
  private final f oiY;
  public boolean oiZ;
  long oia;
  public long oib;
  public long oic;
  public long oid;
  public long oie;
  public long oif;
  public long oig;
  public long oih;
  public long oii;
  public long oij;
  long oik;
  long oil;
  long oim;
  long oin;
  long oio;
  public long oip;
  public long oiq;
  public long oir;
  public long ois;
  public long oit;
  public long oiu;
  public long oiv;
  public long oiw;
  public long oix;
  public boolean oiy;
  public boolean oiz;
  public boolean oja;
  private final f ojb;
  private long ojc;
  public String url;
  
  static
  {
    AppMethodBeat.i(6601);
    ojd = new a((byte)0);
    AppMethodBeat.o(6601);
  }
  
  public g()
  {
    AppMethodBeat.i(6618);
    this.TAG = "MicroMsg.Preload.Kv15862";
    this.ohI = 15862;
    this.key = "";
    this.url = "";
    this.ohL = d.g.O((d.g.a.a)new b(this));
    this.ohM = d.g.O((d.g.a.a)new e(this));
    this.ohN = d.g.O((d.g.a.a)new c(this));
    this.ohO = d.g.O((d.g.a.a)new d(this));
    this.ohP = -1L;
    this.oic = -1L;
    this.oid = -1L;
    this.oie = -1L;
    this.oif = -1L;
    this.oig = -1L;
    this.oih = -1L;
    this.oii = -1L;
    this.oij = -1L;
    this.oiX = "";
    this.oiY = d.g.O((d.g.a.a)h.ojg);
    this.nWh = 10000;
    this.ojb = d.g.O((d.g.a.a)new f(this));
    this.ojc = 3600000L;
    AppMethodBeat.o(6618);
  }
  
  private final String I(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(6610);
    StringBuilder localStringBuilder = new StringBuilder();
    h.a locala = h.ojh;
    if (h.a.bPu()) {
      localStringBuilder.append(paramCharSequence + "no re-direct;");
    }
    locala = h.ojh;
    if (!h.a.bPp()) {
      localStringBuilder.append(paramCharSequence + "no preload data;");
    }
    locala = h.ojh;
    if (h.a.bPv()) {
      localStringBuilder.append(paramCharSequence + "no preload webview;");
    }
    locala = h.ojh;
    if (h.a.bPr()) {
      localStringBuilder.append(paramCharSequence + "data no expire;");
    }
    locala = h.ojh;
    if (h.a.bPw()) {
      localStringBuilder.append(paramCharSequence + "no red;");
    }
    paramCharSequence = this.ohJ;
    if (paramCharSequence == null) {
      p.bcb("tmplParams");
    }
    paramCharSequence = paramCharSequence.HBv;
    p.g(paramCharSequence, "tmplParams.headers");
    if (!n.aE((CharSequence)paramCharSequence)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramCharSequence = this.ohJ;
        if (paramCharSequence == null) {
          p.bcb("tmplParams");
        }
        localStringBuilder.append(paramCharSequence.HBv);
      }
      if (n.aE((CharSequence)localStringBuilder)) {
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
  
  private final String bPe()
  {
    AppMethodBeat.i(6602);
    String str = (String)this.ohL.getValue();
    AppMethodBeat.o(6602);
    return str;
  }
  
  private final int bPf()
  {
    AppMethodBeat.i(6603);
    int i = ((Number)this.ohM.getValue()).intValue();
    AppMethodBeat.o(6603);
    return i;
  }
  
  private final long bPg()
  {
    AppMethodBeat.i(6604);
    long l = ((Number)this.ohN.getValue()).longValue();
    AppMethodBeat.o(6604);
    return l;
  }
  
  private final int bPh()
  {
    AppMethodBeat.i(6605);
    int i = ((Number)this.ohO.getValue()).intValue();
    AppMethodBeat.o(6605);
    return i;
  }
  
  private final String bPi()
  {
    AppMethodBeat.i(6606);
    String str = (String)this.oiY.getValue();
    AppMethodBeat.o(6606);
    return str;
  }
  
  private final Long[] bPj()
  {
    AppMethodBeat.i(6607);
    Long[] arrayOfLong = (Long[])this.ojb.getValue();
    AppMethodBeat.o(6607);
    return arrayOfLong;
  }
  
  private final String bPk()
  {
    AppMethodBeat.i(6611);
    Object localObject = new StringBuilder();
    if (this.oiI == 1) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.oiH) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (n.aE((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6611);
    return localObject;
  }
  
  private final String bPl()
  {
    AppMethodBeat.i(6612);
    Object localObject = new StringBuilder();
    if (this.oiI == 2) {
      ((StringBuilder)localObject).append("relanuch;");
    }
    if (!this.oiz) {
      ((StringBuilder)localObject).append("cold;");
    }
    if (!this.oiB)
    {
      ((StringBuilder)localObject).append("tmpl fail;");
      if (!this.oja) {
        break label146;
      }
      ((StringBuilder)localObject).append("timeout;");
    }
    for (;;)
    {
      if (this.oiF) {
        ((StringBuilder)localObject).append("xweb_cc;");
      }
      if (n.aE((CharSequence)localObject)) {
        ((StringBuilder)localObject).append("ok;");
      }
      localObject = ((StringBuilder)localObject).toString();
      p.g(localObject, "sb.toString()");
      AppMethodBeat.o(6612);
      return localObject;
      if (this.oiA) {
        break;
      }
      ((StringBuilder)localObject).append("inject fail;");
      break;
      label146:
      if (this.oiZ) {
        ((StringBuilder)localObject).append("h5;");
      }
    }
  }
  
  private final String bPm()
  {
    AppMethodBeat.i(6613);
    Object localObject = new StringBuilder();
    if (this.oiD) {
      ((StringBuilder)localObject).append("zip;");
    }
    if (this.oiE) {
      ((StringBuilder)localObject).append("prefixMP;");
    }
    if (n.aE((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("none;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6613);
    return localObject;
  }
  
  private final String bPn()
  {
    AppMethodBeat.i(6614);
    Object localObject = new StringBuilder();
    if (!this.oiy) {
      ((StringBuilder)localObject).append("async;");
    }
    if (this.oiC) {
      ((StringBuilder)localObject).append("mounted;");
    }
    if (this.oiG) {
      ((StringBuilder)localObject).append("cache_tmpl;");
    }
    if (n.aE((CharSequence)localObject)) {
      ((StringBuilder)localObject).append("ok;");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "sb.toString()");
    AppMethodBeat.o(6614);
    return localObject;
  }
  
  private final long tp(long paramLong)
  {
    AppMethodBeat.i(6609);
    paramLong = Math.min(Math.max(-this.ojc, paramLong), this.ojc);
    AppMethodBeat.o(6609);
    return paramLong;
  }
  
  private static String tq(long paramLong)
  {
    AppMethodBeat.i(6616);
    String str = new SimpleDateFormat("MM/dd HH:mm:ss").format(new Date(paramLong));
    p.g(str, "SimpleDateFormat(\"MM/dd …m:ss\").format(Date(this))");
    AppMethodBeat.o(6616);
    return str;
  }
  
  public final void a(dnj paramdnj)
  {
    AppMethodBeat.i(209824);
    p.h(paramdnj, "<set-?>");
    this.ohJ = paramdnj;
    AppMethodBeat.o(209824);
  }
  
  public final void b(d.g.a.q<? super String, ? super String, ? super List<o<String, String>>, z> paramq)
  {
    AppMethodBeat.i(6608);
    p.h(paramq, "data");
    if ((!this.oiJ) || (!this.oiK))
    {
      AppMethodBeat.o(6608);
      return;
    }
    Object localObject1 = this.ohJ;
    if (localObject1 == null) {
      p.bcb("tmplParams");
    }
    com.tencent.mm.plugin.webview.g.a.gi(((dnj)localObject1).reportId, 132);
    Object localObject3 = d.bPd();
    this.oiL = Math.max(this.ohR, this.oib);
    if (this.ohR < this.oib) {}
    int j;
    long l1;
    int k;
    for (int i = 1;; i = 2)
    {
      this.oiM = i;
      this.oiN = (this.oiL - this.ohQ);
      this.oiT = (this.ohV - this.ohQ);
      this.oiS = (this.oif - this.oig);
      this.oiU = (this.oib - this.ohQ);
      this.oiV = (this.oib - this.oia);
      this.ohS = (this.ohR - this.ohQ);
      this.oiO = (this.oic - this.ohQ);
      this.oiP = (this.oid - this.oic);
      this.oiR = (this.ohX - this.ohW);
      this.oiQ = (this.oif - this.oie);
      this.ohP = (this.oif - this.oig);
      this.oiW = (this.oiO + this.oiP + this.oiR + this.oiQ + this.ohU + this.ohT);
      localObject1 = this.TAG;
      Object localObject4 = this.ohJ;
      if (localObject4 == null) {
        p.bcb("tmplParams");
      }
      i = ((dnj)localObject4).version;
      localObject4 = this.url;
      j = bPf();
      l1 = this.oiN;
      k = this.oiM;
      long l2 = this.ohT;
      long l3 = this.oiU;
      boolean bool1 = this.oiz;
      long l4 = this.oii;
      long l5 = this.oih;
      boolean bool2 = this.oiy;
      long l6 = this.oiR;
      long l7 = this.oiV;
      long l8 = this.oiT;
      long l9 = this.ohU;
      long l10 = this.ohT;
      Object localObject5 = this.ohJ;
      if (localObject5 == null) {
        p.bcb("tmplParams");
      }
      int m = ((dnj)localObject5).ojt;
      localObject5 = this.ohJ;
      if (localObject5 == null) {
        p.bcb("tmplParams");
      }
      ad.d((String)localObject1, "templateVersion:%d, url:%s, size:%d, networkType:%s, pageFinishTime:%d, pageFinishTimeType:%d, ctWebFirstScreen:%d, a8KeyFinishTime:%d, isWebViewCreated:%b, ctTmplLoad:%d, isSyncGetPageData:%b, getPageDataCostTime:%d, getA8KeyCostTime:%d, webReceivePageDataTime:%d, ctWebCompile:%d, ctWebFirstScreen:%d, tmplType:%d tmplUid:%s webviewKind:%s webviewProcess:%s scene:%d evalPageDataCostTime:%d isWebViewProcessCreated:%b", new Object[] { Integer.valueOf(i), localObject4, Integer.valueOf(j), localObject3, Long.valueOf(l1), Integer.valueOf(k), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool1), Long.valueOf(l4 - l5), Boolean.valueOf(bool2), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Long.valueOf(l10), Integer.valueOf(m), ((dnj)localObject5).AFz, this.oiX, bPi(), Integer.valueOf(this.nWh), Long.valueOf(this.oiS), Boolean.valueOf(this.oiH) });
      if (!i.IS_FLAVOR_RED) {
        bool1 = i.DEBUG;
      }
      try
      {
        localObject1 = this.url;
        if (localObject1 == null) {
          p.gfZ();
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
          dnj localdnj;
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
          com.tencent.mm.plugin.webview.g.a.aK(20, this.oiN);
          com.tencent.mm.plugin.webview.g.a.aK(21, this.ohS);
          com.tencent.mm.plugin.webview.g.a.aK(22, l1);
          com.tencent.mm.plugin.webview.g.a.aK(23, this.oil - this.oik);
          if (!this.oiy)
          {
            com.tencent.mm.plugin.webview.g.a.aK(24, this.ohZ - this.ohY);
            com.tencent.mm.plugin.webview.g.a.WU(107);
          }
        }
        paramq.d("['FirstScreen', 'BindMP', 'WebView', 'WebViewUI', null, 'BindMM', 'JsAPI', 'GetA8Key', 'GetData', 'InjectData']", localObject2, localObject3);
        ad.i(this.TAG, "terry performance report:" + this.ohQ + '\n' + e.a(bPj(), null, null, null, 0, null, null, 63));
        AppMethodBeat.o(6608);
      }
      localObject4 = com.tencent.mm.plugin.report.service.g.yhR;
      m = this.ohI;
      localObject5 = this.ohJ;
      if (localObject5 == null) {
        p.bcb("tmplParams");
      }
      n = ((dnj)localObject5).version;
      i1 = bPf();
      l1 = tp(this.oiN);
      i2 = this.oiM;
      l2 = tp(this.ohS);
      l3 = tp(this.oiU);
      if (!this.oiz) {
        break;
      }
      i = 1;
      l4 = tp(this.oii - this.oih);
      if (!this.oiy) {
        break label2308;
      }
      j = 1;
      l5 = tp(this.oiR);
      l6 = tp(this.oiV);
      l7 = tp(this.oiT);
      l8 = tp(this.ohU);
      l9 = tp(this.ohT);
      localObject5 = this.ohJ;
      if (localObject5 == null) {
        p.bcb("tmplParams");
      }
      i3 = ((dnj)localObject5).ojt;
      localObject5 = this.ohJ;
      if (localObject5 == null) {
        p.bcb("tmplParams");
      }
      localObject5 = ((dnj)localObject5).AFz;
      localObject6 = this.oiX;
      localObject7 = bPi();
      i4 = this.nWh;
      l10 = tp(this.oiS);
      if (!this.oiH) {
        break label2313;
      }
      k = 1;
      ((com.tencent.mm.plugin.report.service.g)localObject4).f(m, new Object[] { Integer.valueOf(n), localObject1, Integer.valueOf(i1), localObject3, Long.valueOf(l1), Integer.valueOf(i2), Long.valueOf(l2), Long.valueOf(l3), Integer.valueOf(i), Long.valueOf(l4), Integer.valueOf(j), Long.valueOf(l5), Long.valueOf(l6), Long.valueOf(l7), Long.valueOf(l8), Long.valueOf(l9), Integer.valueOf(i3), localObject5, localObject6, localObject7, Integer.valueOf(i4), Long.valueOf(l10), Integer.valueOf(k), Long.valueOf(tp(this.oiO)), Long.valueOf(tp(this.oiP)), Long.valueOf(tp(this.oiQ)) });
      localObject4 = com.tencent.mm.plugin.report.service.g.yhR;
      localObject5 = new ac(19);
      ((ac)localObject5).add(localObject1);
      ((ac)localObject5).add(Integer.valueOf(this.nWh));
      ((ac)localObject5).add(localObject3);
      ((ac)localObject5).add(Integer.valueOf(bPf()));
      localObject1 = this.ohJ;
      if (localObject1 == null) {
        p.bcb("tmplParams");
      }
      ((ac)localObject5).add(((dnj)localObject1).AFz);
      ((ac)localObject5).add(bPi());
      ((ac)localObject5).add(this.oiX);
      if (!this.oiy) {
        break label2319;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      if (this.oiH) {
        break label2324;
      }
      i = 1;
      if (i == 0) {
        break label2329;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      if (this.oiz) {
        break label2334;
      }
      i = 1;
      if (i == 0) {
        break label2339;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      ((ac)localObject5).add(Integer.valueOf(this.oiI));
      if (!this.oiC) {
        break label2344;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      if (!this.oiA) {
        break label2349;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      ((ac)localObject5).add(Long.valueOf(this.oiN));
      ((ac)localObject5).eO(bPj());
      ((ac)localObject5).add(this.key);
      if (!this.oiD) {
        break label2354;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      if (!this.oiF) {
        break label2359;
      }
      i = 1;
      ((ac)localObject5).add(Integer.valueOf(i));
      ((ac)localObject5).add(Long.valueOf(this.oij));
      ((com.tencent.mm.plugin.report.service.g)localObject4).f(16874, ((ac)localObject5).toArray(new Object[((ac)localObject5).dbZ.size()]));
      com.tencent.mm.plugin.webview.g.a.WU(0);
      if (this.oiD)
      {
        com.tencent.mm.plugin.webview.g.a.WU(111);
        localObject1 = this.ohJ;
        if (localObject1 == null) {
          p.bcb("tmplParams");
        }
        com.tencent.mm.plugin.webview.g.a.gi(((dnj)localObject1).reportId, 232);
      }
      if (this.oiF) {
        com.tencent.mm.plugin.webview.g.a.WU(113);
      }
      com.tencent.mm.plugin.webview.g.a.aK(1, this.oiN);
      com.tencent.mm.plugin.webview.g.a.aK(2, this.ohS);
      l1 = this.oic - this.ohQ;
      if (!this.oiH) {
        break label2364;
      }
      com.tencent.mm.plugin.webview.g.a.aK(10, this.oiN);
      com.tencent.mm.plugin.webview.g.a.aK(11, this.ohS);
      com.tencent.mm.plugin.webview.g.a.aK(12, l1);
      com.tencent.mm.plugin.webview.g.a.aK(13, this.oil - this.oik);
      com.tencent.mm.plugin.webview.g.a.aK(14, this.oii - this.oih);
      com.tencent.mm.plugin.webview.g.a.aK(15, this.oif - this.oie);
      localObject1 = "[" + j.a((Iterable)e.U(bPj()), null, null, null, 0, null, null, 63) + ']';
      localObject3 = u.S("section", "[debug]");
      localObject4 = u.S("info", bPe());
      localObject5 = u.S("settings", I((CharSequence)""));
      localObject6 = u.S("section", "[process]");
      localObject7 = u.S("process", bPi());
      localo1 = u.S("state", bPk());
      localo2 = u.S("section", "[webview]");
      localo3 = u.S("kind", this.oiX);
      localo4 = u.S("state", bPl());
      localo5 = u.S("section", "[tmpl]");
      localObject8 = this.ohJ;
      if (localObject8 == null) {
        p.bcb("tmplParams");
      }
      localObject8 = u.S("uid", ((dnj)localObject8).AFz);
      localObject9 = this.ohJ;
      if (localObject9 == null) {
        p.bcb("tmplParams");
      }
      localObject9 = u.S("tmplType", String.valueOf(((dnj)localObject9).ojt));
      localObject10 = this.ohJ;
      if (localObject10 == null) {
        p.bcb("tmplParams");
      }
      localObject10 = u.S("version", String.valueOf(((dnj)localObject10).version));
      localObject11 = this.ohJ;
      if (localObject11 == null) {
        p.bcb("tmplParams");
      }
      localObject11 = u.S("md5", ((dnj)localObject11).md5);
      localdnj = this.ohJ;
      if (localdnj == null) {
        p.bcb("tmplParams");
      }
      localObject3 = j.listOf(new o[] { localObject3, localObject4, localObject5, localObject6, localObject7, localo1, localo2, localo3, localo4, localo5, localObject8, localObject9, localObject10, localObject11, u.S("time", tq(localdnj.zok)), u.S("state", bPm()), u.S("section", "[data]"), u.S("dataSize", aT(bPf() / 1024.0F) + "Kb"), u.S("dataTime", String.valueOf(this.oiR)), u.S("cached", tq(bPg())), u.S("version", String.valueOf(bPh())), u.S("expire in", this.ohK + 's'), u.S("scene", String.valueOf(this.nWh)), u.S("state", bPn()) });
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
    AppMethodBeat.i(209825);
    p.h(paramString, "<set-?>");
    this.key = paramString;
    AppMethodBeat.o(209825);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(6617);
    g localg = new g(this);
    ad.v(this.TAG, "terry performance log:\n" + this.oiO + ',' + this.oiP + ',' + (this.oil - this.oid) + ',' + (Math.max(this.oil, this.oii) - this.oil) + ',' + (this.oie - Math.max(this.oil, this.oii)) + ',' + this.oiQ);
    ad.v(this.TAG, "terry performance timestamp:\n " + e.a(bPj(), null, null, null, 0, null, null, 63));
    Object localObject1 = new StringBuilder("\n            [debug]\n            info: ").append(bPe()).append("\n            settings: ").append(I((CharSequence)"\n")).append("\n\n            [process]\n            process: ").append(bPi()).append("\n            state: ").append(bPk()).append("\n\n            [webview]\n            kind: ").append(this.oiX).append("\n            state: ").append(bPl()).append("\n\n            [tmpl]\n            uid: ");
    Object localObject2 = this.ohJ;
    if (localObject2 == null) {
      p.bcb("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dnj)localObject2).AFz).append("\n            tmplType: ");
    localObject2 = this.ohJ;
    if (localObject2 == null) {
      p.bcb("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dnj)localObject2).ojt).append("\n            version: ");
    localObject2 = this.ohJ;
    if (localObject2 == null) {
      p.bcb("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dnj)localObject2).version).append("\n            md5: ");
    localObject2 = this.ohJ;
    if (localObject2 == null) {
      p.bcb("tmplParams");
    }
    localObject1 = ((StringBuilder)localObject1).append(((dnj)localObject2).md5).append("\n            time: ");
    localObject2 = this.ohJ;
    if (localObject2 == null) {
      p.bcb("tmplParams");
    }
    localObject2 = ((StringBuilder)localObject1).append(tq(((dnj)localObject2).zok)).append("\n            state: ").append(bPm()).append("\n\n            [data]\n            dataSize: ").append(aT(bPf() / 1024.0F)).append("Kb\n            dataTime: ").append(this.oiR).append("\n            cached: ").append(tq(bPg())).append("\n            version: ").append(bPh()).append("\n            expire in: ").append(this.ohK).append("s\n            scene: ").append(this.nWh).append("\n            state: ").append(bPn()).append("\n\n            [performance](ms)\n            finishType: ").append(this.oiM).append("\n            finishTime: ").append(this.oiN);
    if (this.oiN != Math.max(this.oiU, this.oiW)) {}
    for (localObject1 = "/" + localg.tr(this.oiW);; localObject1 = "")
    {
      localObject1 = n.bdc((String)localObject1 + "\n            firstScreenFinish: " + localg.tr(this.ohS) + '/' + localg.tr(this.oiW) + "\n            a8keyFinish: " + this.oiU + "\n\n            client:\n            TmplCostTime: " + (this.oii - this.oih) + "\n            WebViewUICostTime: " + (this.oil - this.oik) + "\n            NotifyPageCostTime: " + (this.oij - this.oif) + "\n\n            1.bindWebViewCostTime: " + this.oiO + "\n            2.createWebViewCostTime: " + this.oiP + "\n            3.getPageDataCostTime: " + this.oiR + "\n            4.injectCostTime: " + localg.tr(this.oiQ) + "\n            eval cost: " + this.ohP + "\n\n            js:\n            4.1.onReceivePageData: " + (this.oig - this.ohV) + "\n            5.ctWebCompile: " + this.ohU + "\n            6.renderTime: " + this.ohT + "\n\n            [js]webReceivePageDataTime: " + this.oiT + "\n            a8KeyFinishTime: " + this.oiU + "\n            getA8KeyCostTime: " + this.oiV + "\n        ");
      AppMethodBeat.o(6617);
      return localObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862$Companion;", "", "()V", "RELAUNCH_STATE_DEFAULT", "", "RELAUNCH_STATE_PROCESS", "RELAUNCH_STATE_WEBVIEW", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<Long>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    e(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "invoke", "()[Ljava/lang/Long;"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<Long[]>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"verify", "", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements b<Long, String>
  {
    g(g paramg)
    {
      super();
    }
    
    public final String tr(long paramLong)
    {
      AppMethodBeat.i(6598);
      if (g.a(this.oje, paramLong))
      {
        AppMethodBeat.o(6598);
        return String.valueOf(paramLong);
      }
      AppMethodBeat.o(6598);
      return "NaN";
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    public static final h ojg;
    
    static
    {
      AppMethodBeat.i(6600);
      ojg = new h();
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