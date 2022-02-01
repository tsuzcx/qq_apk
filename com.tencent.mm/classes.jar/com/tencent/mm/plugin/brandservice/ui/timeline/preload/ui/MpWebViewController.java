package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Process;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.b.g.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.webview.c.f.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.e;
import com.tencent.mm.plugin.webview.core.j.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.protocal.protobuf.ew;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import d.g.a.m;
import d.g.a.q;
import d.g.b.u;
import d.g.b.v.a;
import d.g.b.w;
import d.n.n;
import d.o;
import d.v;
import d.y;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.as;
import org.json.JSONObject;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "API", "", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "TIMEOUT_TIME", "", "getTIMEOUT_TIME", "()J", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "checkNotifyPageTimer", "Ljava/lang/Runnable;", "contentId", "fullUrl", "gettingA8KeyUrl", "Ljava/util/HashSet;", "injectAPI", "isCheckingInject", "<set-?>", "isInjectDataSuccess", "isNotifyPageSuccess", "setNotifyPageSuccess", "(Z)V", "isStopCheckNotifyPage", "setStopCheckNotifyPage", "isTmplReady", "isUseDataCache", "setUseDataCache", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "getKv15862", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "preloadNext", "getPreloadNext", "setPreloadNext", "rawUrl", "getRawUrl", "receivePageData", "getReceivePageData", "setReceivePageData", "(J)V", "recodeInject", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "getSession", "()Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "session$delegate", "startGetPageData", "getStartGetPageData", "setStartGetPageData", "startLoadPage", "getStartLoadPage", "setStartLoadPage", "adjustInnerWidth", "", "canHandleUrl", "url", "cancelReport", "checkInject", "checkNotifyPage", "getLogAPI", "value", "initEnviroment", "isPageCached", "isSameStart", "intent", "Landroid/content/Intent;", "loadForceUrl", "forceUrl", "fullScreen", "loadTmpl", "modifyForceUrl", "needSyncGetA8Key", "notifyPageInfo", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "pageInfo", "onError", "reason", "", "reqUrl", "errType", "errCode", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onStartLoad", "onWebLog", "processCommonGetA8KeyFullUrl", "httpHeader", "", "processData", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processReport", "setMpUrl", "startAuth", "force", "stopCheckNotifyPage", "tryPreloadNextWebView", "updateAuth", "isSuccess", "updateData", "updateKV", "updatePageAuth", "validCommitUrl", "validStartUrl", "waitForInject", "waitForReady", "Companion", "ForceUrl", "MpWebViewInterceptor", "NotifyAuth", "PreloadNext", "StartPreload", "UpdateData", "plugin-brandservice_release"})
public final class MpWebViewController
  extends com.tencent.mm.plugin.webview.core.h
{
  private static final int nKc = -101;
  static final int nKd = -102;
  private static final int nKe = -103;
  private static final int nKf = -111;
  private static final int nKg = -112;
  private static final int nKh = -113;
  private static final int nKi = -121;
  private static final int nKj = -122;
  private static final int nKk = -123;
  private static final int nKl = -124;
  private static final int nKm = -130;
  public static final e nKn;
  private final dhu nFg;
  private final d.f nJH;
  final com.tencent.mm.plugin.brandservice.ui.timeline.preload.g nJI;
  private long nJJ;
  private long nJK;
  private long nJL;
  private boolean nJM;
  private boolean nJN;
  private final long nJO;
  private final d.f nJP;
  private String nJQ;
  String nJR;
  private boolean nJS;
  private boolean nJT;
  private final String nJU;
  private final List<BaseWebViewController.e> nJV;
  private final String nJW;
  boolean nJX;
  private final HashSet<String> nJY;
  boolean nJZ;
  boolean nKa;
  private final Runnable nKb;
  
  static
  {
    AppMethodBeat.i(199089);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(MpWebViewController.class), "TAG", "getTAG()Ljava/lang/String;")), (d.l.k)w.a(new u(w.bn(MpWebViewController.class), "session", "getSession()Lcom/tencent/mm/protocal/protobuf/PreloadSession;")) };
    nKn = new e((byte)0);
    nKc = -101;
    nKd = -102;
    nKe = -103;
    nKf = -111;
    nKg = -112;
    nKh = -113;
    nKi = -121;
    nKj = -122;
    nKk = -123;
    nKl = -124;
    nKm = -130;
    AppMethodBeat.o(199089);
  }
  
  public MpWebViewController(dhu paramdhu, final MMWebView paramMMWebView)
  {
    super(paramMMWebView);
    AppMethodBeat.i(199116);
    this.nFg = paramdhu;
    this.nJH = d.g.K((d.g.a.a)new g(this));
    paramdhu = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.g();
    paramdhu.a(this.nFg);
    this.nJI = paramdhu;
    this.nJM = true;
    this.nJO = 5000L;
    this.nJP = d.g.K((d.g.a.a)new t(this, paramMMWebView));
    this.nJU = "__tmpl_webview_inject_data";
    if (!(paramMMWebView instanceof a.a)) {}
    for (paramdhu = null;; paramdhu = paramMMWebView)
    {
      paramdhu = (a.a)paramdhu;
      if (paramdhu != null) {
        paramdhu.setCurrentUrlProxy((d.g.a.a)new d(this));
      }
      paramdhu = super.bLP();
      paramdhu.addAll((Collection)d.a.j.listOf(new BaseWebViewController.e[] { new BaseWebViewController.e(w.bn(UpdateData.class), (d.g.a.a)new h((MpWebViewController)this)), new BaseWebViewController.e(w.bn(StartPreload.class), (d.g.a.a)new a(this)), new BaseWebViewController.e(w.bn(PreloadNext.class), (d.g.a.a)new i((MpWebViewController)this)), new BaseWebViewController.e(w.bn(NotifyAuth.class), (d.g.a.a)new b(this)), new BaseWebViewController.e(w.bn(ForceUrl.class), (d.g.a.a)new c(this)) }));
      this.nJV = paramdhu;
      this.nJW = (this.nJU + ".__getString()");
      this.nJY = new HashSet();
      this.nKb = ((Runnable)new k(this));
      AppMethodBeat.o(199116);
      return;
    }
  }
  
  private final void Ue(String paramString)
  {
    AppMethodBeat.i(199106);
    this.CcY = paramString;
    aAJ(paramString);
    aAK(paramString);
    d.g.b.k.h(paramString, "<set-?>");
    this.cHn = paramString;
    AppMethodBeat.o(199106);
  }
  
  private void Uf(String paramString)
  {
    AppMethodBeat.i(199113);
    d.g.b.k.h(paramString, "forceUrl");
    bLT();
    eyC();
    this.Cdr = true;
    k(Ug(paramString), true, 8);
    AppMethodBeat.o(199113);
  }
  
  private static String Ug(String paramString)
  {
    AppMethodBeat.i(199115);
    paramString = UrlExKt.appendUrlParam(UrlExKt.clearUrlParam(UrlExKt.clearUrlParam(UrlExKt.clearUrlParam(paramString, "fasttmpl_flag"), "fasttmpl_type"), "fasttmpl_fullversion"), "forceh5", "1");
    AppMethodBeat.o(199115);
    return paramString;
  }
  
  /* Error */
  private final boolean a(com.tencent.mm.plugin.webview.c.l paraml)
  {
    // Byte code:
    //   0: ldc_w 660
    //   3: invokestatic 285	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 664	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o:nKs	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o;
    //   9: astore 10
    //   11: aload_1
    //   12: invokestatic 667	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o:c	(Lcom/tencent/mm/plugin/webview/c/l;)Ljava/lang/String;
    //   15: astore 10
    //   17: aload_0
    //   18: invokevirtual 522	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   21: ldc_w 669
    //   24: aload 10
    //   26: invokestatic 675	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 678	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 539	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: new 680	org/json/JSONObject
    //   38: dup
    //   39: aload 10
    //   41: invokespecial 681	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 10
    //   46: new 680	org/json/JSONObject
    //   49: dup
    //   50: aload 10
    //   52: ldc_w 683
    //   55: invokevirtual 686	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 681	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore 11
    //   63: aload 11
    //   65: ldc_w 688
    //   68: invokevirtual 692	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   71: lstore_2
    //   72: aload 11
    //   74: ldc_w 694
    //   77: invokevirtual 692	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   80: lstore 4
    //   82: aload 11
    //   84: ldc_w 696
    //   87: invokevirtual 692	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   90: lstore 6
    //   92: aload 11
    //   94: ldc_w 698
    //   97: invokevirtual 692	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   100: lstore 8
    //   102: aload_0
    //   103: getfield 702	com/tencent/mm/plugin/webview/core/BaseWebViewController:Cdm	Lcom/tencent/mm/plugin/webview/j/h;
    //   106: ldc_w 696
    //   109: lload 6
    //   111: invokevirtual 708	com/tencent/mm/plugin/webview/j/h:bI	(Ljava/lang/String;J)V
    //   114: aload_0
    //   115: getfield 702	com/tencent/mm/plugin/webview/core/BaseWebViewController:Cdm	Lcom/tencent/mm/plugin/webview/j/h;
    //   118: ldc_w 698
    //   121: lload 8
    //   123: invokevirtual 708	com/tencent/mm/plugin/webview/j/h:bI	(Ljava/lang/String;J)V
    //   126: aload_0
    //   127: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   130: lload_2
    //   131: putfield 711	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:nFr	J
    //   134: aload_0
    //   135: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   138: lload 4
    //   140: putfield 714	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:nFs	J
    //   143: aload_0
    //   144: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   147: lload 6
    //   149: putfield 717	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:nFo	J
    //   152: aload_0
    //   153: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   156: lload 8
    //   158: putfield 720	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:nFq	J
    //   161: aload 10
    //   163: ldc_w 722
    //   166: ldc_w 724
    //   169: invokevirtual 726	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: ldc_w 728
    //   175: invokestatic 732	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   178: ifeq +122 -> 300
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 734	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJZ	Z
    //   186: aload_0
    //   187: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   190: iconst_1
    //   191: putfield 737	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:nGh	Z
    //   194: aload_0
    //   195: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   198: new 63	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 738	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;)V
    //   206: checkcast 740	d/g/a/q
    //   209: invokevirtual 743	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:b	(Ld/g/a/q;)V
    //   212: aload_0
    //   213: getfield 356	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nFg	Lcom/tencent/mm/protocal/protobuf/dhu;
    //   216: getfield 544	com/tencent/mm/protocal/protobuf/dhu:reportId	I
    //   219: sipush 131
    //   222: invokestatic 552	com/tencent/mm/plugin/webview/g/a:fS	(II)V
    //   225: bipush 108
    //   227: invokestatic 746	com/tencent/mm/plugin/webview/g/a:Ve	(I)V
    //   230: aload_0
    //   231: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   234: invokestatic 577	java/lang/System:currentTimeMillis	()J
    //   237: putfield 749	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:nFG	J
    //   240: aload_0
    //   241: invokespecial 633	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bLU	()V
    //   244: aload_0
    //   245: invokespecial 477	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bLT	()V
    //   248: aload_0
    //   249: invokevirtual 753	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   252: aload_1
    //   253: getfield 758	com/tencent/mm/plugin/webview/c/l:Ckt	Ljava/lang/String;
    //   256: ldc_w 760
    //   259: aconst_null
    //   260: invokevirtual 765	com/tencent/mm/plugin/webview/c/f:j	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   263: bipush 90
    //   265: invokestatic 768	com/tencent/mm/plugin/webview/g/a:lA	(I)V
    //   268: getstatic 774	kotlinx/coroutines/bh:LRM	Lkotlinx/coroutines/bh;
    //   271: checkcast 776	kotlinx/coroutines/ag
    //   274: aconst_null
    //   275: new 61	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p
    //   278: dup
    //   279: aload_0
    //   280: aconst_null
    //   281: invokespecial 779	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;Ld/d/d;)V
    //   284: checkcast 781	d/g/a/m
    //   287: iconst_3
    //   288: invokestatic 786	kotlinx/coroutines/f:b	(Lkotlinx/coroutines/ag;Ld/d/f;Ld/g/a/m;I)Lkotlinx/coroutines/bo;
    //   291: pop
    //   292: ldc_w 660
    //   295: invokestatic 340	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_0
    //   301: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   304: iconst_1
    //   305: putfield 630	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:nGw	Z
    //   308: aload_0
    //   309: getstatic 335	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nKl	I
    //   312: invokevirtual 789	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:Uz	(I)V
    //   315: aload_0
    //   316: invokevirtual 522	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   319: ldc_w 791
    //   322: invokestatic 539	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -95 -> 230
    //   328: astore 10
    //   330: aload_0
    //   331: invokevirtual 522	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   334: aload 10
    //   336: checkcast 793	java/lang/Throwable
    //   339: ldc_w 794
    //   342: iconst_0
    //   343: anewarray 796	java/lang/Object
    //   346: invokestatic 800	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: getfield 378	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nJI	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   353: iconst_1
    //   354: putfield 630	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:nGw	Z
    //   357: aload_0
    //   358: getstatic 335	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:nKl	I
    //   361: invokevirtual 789	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:Uz	(I)V
    //   364: goto -134 -> 230
    //   367: astore 10
    //   369: aload_0
    //   370: invokevirtual 522	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   373: aload 10
    //   375: checkcast 793	java/lang/Throwable
    //   378: ldc_w 801
    //   381: iconst_0
    //   382: anewarray 796	java/lang/Object
    //   385: invokestatic 800	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: aload_0
    //   389: invokevirtual 753	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   392: aload_1
    //   393: getfield 758	com/tencent/mm/plugin/webview/c/l:Ckt	Ljava/lang/String;
    //   396: ldc_w 803
    //   399: aconst_null
    //   400: invokevirtual 765	com/tencent/mm/plugin/webview/c/f:j	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   403: bipush 91
    //   405: invokestatic 768	com/tencent/mm/plugin/webview/g/a:lA	(I)V
    //   408: ldc_w 660
    //   411: invokestatic 340	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: iconst_0
    //   415: ireturn
    //   416: astore 10
    //   418: aload_0
    //   419: invokevirtual 522	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   422: aload 10
    //   424: checkcast 793	java/lang/Throwable
    //   427: ldc_w 801
    //   430: iconst_0
    //   431: anewarray 796	java/lang/Object
    //   434: invokestatic 800	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   437: goto -49 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	this	MpWebViewController
    //   0	440	1	paraml	com.tencent.mm.plugin.webview.c.l
    //   71	60	2	l1	long
    //   80	59	4	l2	long
    //   90	58	6	l3	long
    //   100	57	8	l4	long
    //   9	153	10	localObject	Object
    //   328	7	10	localJSONException1	org.json.JSONException
    //   367	7	10	localJSONException2	org.json.JSONException
    //   416	7	10	localRemoteException	android.os.RemoteException
    //   61	32	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   35	230	328	org/json/JSONException
    //   300	325	328	org/json/JSONException
    //   11	35	367	org/json/JSONException
    //   230	298	367	org/json/JSONException
    //   330	364	367	org/json/JSONException
    //   11	35	416	android/os/RemoteException
    //   35	230	416	android/os/RemoteException
    //   230	298	416	android/os/RemoteException
    //   300	325	416	android/os/RemoteException
    //   330	364	416	android/os/RemoteException
  }
  
  private chb bLK()
  {
    AppMethodBeat.i(199091);
    chb localchb = (chb)this.nJP.getValue();
    AppMethodBeat.o(199091);
    return localchb;
  }
  
  private final void bLT()
  {
    AppMethodBeat.i(199104);
    ac.d(getTAG(), "stopCheckNotifyPage");
    aMd().removeCallbacks(this.nKb);
    this.nKa = true;
    AppMethodBeat.o(199104);
  }
  
  private final void bLU()
  {
    AppMethodBeat.i(199105);
    ac.v(getTAG(), "terry trace updateKV");
    this.nJI.nFB = this.Cdm.bJ("onInjectStart", 0L);
    this.nJI.nFC = this.Cdm.bJ("onInjectEnd", 0L);
    this.nJI.nFE = this.Cdm.bJ("onTmplLoadStart", 0L);
    this.nJI.nFF = this.Cdm.bJ("onTmplLoadEnd", 0L);
    this.nJI.nFz = this.Cdm.bJ("onCreateStart", 0L);
    this.nJI.nFA = this.Cdm.bJ("onCreateEnd", 0L);
    this.nJI.nFX = this.nJX;
    this.nJI.nFD = this.Cdm.bJ("onWebInjectEnd", 0L);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.g localg = this.nJI;
    String str = this.nKq.getRandomStr();
    d.g.b.k.g(str, "viewWV.randomStr");
    localg.setKey(str);
    this.nJI.nFY = UA(nKd);
    AppMethodBeat.o(199105);
  }
  
  private final void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(199112);
    ac.i(getTAG(), "[updatePageAuth]reqUrl:" + paramString1 + " fullUrl:" + paramString2 + " httpHeader:" + paramMap);
    paramString1 = this.nKq.getSettings();
    d.g.b.k.g(paramString1, "viewWV.settings");
    paramString1 = paramString1.getUserAgentString();
    d.g.b.k.g(paramString1, "viewWV.settings.userAgentString");
    paramMap.put("User-agent", paramString1);
    getJsapi().aBj(new JSONObject(paramMap).toString());
    paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
    getJsapi().aBi(paramString1);
    AppMethodBeat.o(199112);
  }
  
  private void r(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(199107);
    d.g.b.k.h(paramString, "contentId");
    ac.v(getTAG(), "[updateData] " + bLL());
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.TO(bLL());
    Ue(bLL());
    this.nJR = paramString;
    this.nJJ = paramLong1;
    this.nJL = paramLong2;
    Uz(nKf);
    AppMethodBeat.o(199107);
  }
  
  public final boolean Ub(String paramString)
  {
    AppMethodBeat.i(199097);
    d.g.b.k.h(paramString, "url");
    if ((super.Uc(paramString)) && ((d.g.b.k.g(paramString, this.nFg.CkB) ^ true)))
    {
      AppMethodBeat.o(199097);
      return true;
    }
    AppMethodBeat.o(199097);
    return false;
  }
  
  public final boolean Uc(String paramString)
  {
    AppMethodBeat.i(199098);
    d.g.b.k.h(paramString, "url");
    if ((super.Uc(paramString)) && ((d.g.b.k.g(paramString, this.nFg.CkB) ^ true)))
    {
      AppMethodBeat.o(199098);
      return true;
    }
    AppMethodBeat.o(199098);
    return false;
  }
  
  public final boolean Ud(String paramString)
  {
    AppMethodBeat.i(199100);
    boolean bool = d.g.b.k.g(paramString, this.nFg.CkB);
    AppMethodBeat.o(199100);
    return bool;
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(199111);
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "errMsg");
    super.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
    if (paramInt1 == 0)
    {
      this.nJQ = paramString1;
      Uz(nKj);
    }
    AppMethodBeat.o(199111);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, arn paramarn)
  {
    AppMethodBeat.i(199108);
    d.g.b.k.h(paramString1, "reqUrl");
    d.g.b.k.h(paramString2, "fullUrl");
    d.g.b.k.h(paramarn, "response");
    if (paramInt == 0) {
      Ue(paramString2);
    }
    super.a(paramInt, paramString1, paramString2, paramarn);
    if (paramInt == 0)
    {
      this.nJQ = paramString2;
      paramarn = com.tencent.mm.plugin.webview.e.c.gI((List)paramarn.EKJ);
      d.g.b.k.g(paramarn, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      com.tencent.mm.plugin.webview.g.a.fS(this.nFg.reportId, 117);
      this.nJI.nFy = System.currentTimeMillis();
      this.nJI.nGg = true;
      bLU();
      this.nJI.b((q)new r(this));
      c(paramString1, paramString2, paramarn);
      Uz(nKi);
    }
    AppMethodBeat.o(199108);
  }
  
  public final boolean aE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(199101);
    d.g.b.k.h(paramString, "url");
    if (((d.g.b.k.g(paramString, this.nFg.CkB) ^ true)) && (super.aE(paramString, paramBoolean)))
    {
      AppMethodBeat.o(199101);
      return true;
    }
    AppMethodBeat.o(199101);
    return false;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(199102);
    super.b(paramWebView, paramString);
    if (d.g.b.k.g(paramString, this.nFg.CkB))
    {
      if ((UA(nKd)) || (UA(nKc)))
      {
        AppMethodBeat.o(199102);
        return;
      }
      ac.i(getTAG(), "checkInject start");
      com.tencent.mm.plugin.webview.g.a.fS(this.nFg.reportId, 113);
      g("JSON.stringify(window.__appmsg_skeleton_success__)", (d.g.a.b)new j(this));
      int i = com.tencent.mm.cc.a.ig(this.nKq.getContext());
      float f = com.tencent.mm.cc.a.getDensity(this.nKq.getContext());
      ac.i(getTAG(), "adjustInnerWidth() screenWidth:" + i + ", density:" + f);
      if ((i > 0) && (f > 0.0F))
      {
        i = (int)(i / f);
        ac.i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(i)));
        g("window.innerWidth = ".concat(String.valueOf(i)), null);
      }
      ac.i(getTAG(), "[onPageReady]");
    }
    AppMethodBeat.o(199102);
  }
  
  public final String bLL()
  {
    AppMethodBeat.i(199092);
    String str = getIntent().getStringExtra("rawUrl");
    d.g.b.k.g(str, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
    str = n.bg(str, "http://", "https://");
    AppMethodBeat.o(199092);
    return str;
  }
  
  public final boolean bLM()
  {
    AppMethodBeat.i(199093);
    if ((UA(nKg)) || (UA(nKh)))
    {
      AppMethodBeat.o(199093);
      return true;
    }
    AppMethodBeat.o(199093);
    return false;
  }
  
  public final boolean bLN()
  {
    AppMethodBeat.i(199094);
    if ((UA(this.Cdx)) && (UA(nKd)))
    {
      AppMethodBeat.o(199094);
      return true;
    }
    AppMethodBeat.o(199094);
    return false;
  }
  
  public final boolean bLO()
  {
    AppMethodBeat.i(199095);
    if ((eyx()) && (UA(nKi)))
    {
      AppMethodBeat.o(199095);
      return true;
    }
    AppMethodBeat.o(199095);
    return false;
  }
  
  public final List<BaseWebViewController.e> bLP()
  {
    return this.nJV;
  }
  
  public final void bLQ()
  {
    AppMethodBeat.i(199096);
    a((com.tencent.mm.plugin.webview.core.j)new f(this.nFg, this.nKq));
    super.bLQ();
    this.nKq.addJavascriptInterface(new l(this), this.nJU);
    getJsapi().ezH();
    getJsapi().a((f.a)new m(this));
    String str = this.nFg.CkB;
    ac.i(getTAG(), "WebView-Trace loadTmpl getResourceResponse, requrl:%s, url:%s", new Object[] { str, this.nFg.FQO });
    Object localObject = this.nFg.FQO;
    d.g.b.k.g(localObject, "tmplParams.initFilePath");
    localObject = new n((String)localObject);
    ac.v(getTAG(), "response path:" + bs.bG(((n)localObject).path, "null"));
    if (e.g((WebView)this.nKq, ((n)localObject).path) != null)
    {
      ac.i(getTAG(), "return intercepted success");
      this.nKq.loadUrl(str);
      Uz(this.Cdx);
      AppMethodBeat.o(199096);
      return;
    }
    ac.e(getTAG(), "return intercepted null");
    com.tencent.mm.plugin.webview.g.a.fS(this.nFg.reportId, 126);
    if (((n)localObject).nGa) {
      com.tencent.mm.plugin.webview.g.a.fS(this.nFg.reportId, 233);
    }
    AppMethodBeat.o(199096);
  }
  
  public final void bLR()
  {
    int j = 1;
    AppMethodBeat.i(199099);
    ac.i(getTAG(), "onStartLoad");
    Object localObject1 = getIntent();
    d.g.b.k.h(localObject1, "intent");
    ac.v(getTAG(), "processData");
    setIntent((Intent)localObject1);
    this.nJK = System.currentTimeMillis();
    this.nJM = ((Intent)localObject1).getBooleanExtra(e.m.Hhs, true);
    this.nJJ = ((Intent)localObject1).getLongExtra(e.m.Hht, 0L);
    Object localObject2 = com.tencent.mm.kernel.g.agO().agp();
    d.g.b.k.g(localObject2, "MMKernel.process().current()");
    localObject2 = ((com.tencent.mm.kernel.b.h)localObject2).ahK();
    String str = ((Intent)localObject1).getStringExtra(e.m.Hhv);
    if ((((Intent)localObject1).getStringExtra("rawUrl") == null) || (str == null))
    {
      ac.e(getTAG(), "rawUrl is null, " + com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ae((Intent)localObject1));
      com.tencent.mm.plugin.webview.g.a.Ve(151);
      com.tencent.mm.plugin.report.service.h.wUl.f(17260, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ae((Intent)localObject1) });
      i = 0;
      if (i == 0)
      {
        onFinish();
        AppMethodBeat.o(199099);
      }
    }
    else
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.g localg = this.nJI;
      if (((g.a)localObject2).gkt < this.nJJ)
      {
        bool = true;
        label233:
        localg.nGe = bool;
        if (!this.nJI.nGe) {
          break label541;
        }
        i = 104;
        label252:
        com.tencent.mm.plugin.webview.g.a.Ve(i);
        switch (s.a(((Intent)localObject1).getIntExtra(e.m.HhA, -1), this.nJJ, Process.myPid(), ((g.a)localObject2).gkl))
        {
        }
      }
      for (;;)
      {
        this.nJI.nGa = bLK().Fvh;
        this.nJI.nGb = bLK().Fvi;
        this.nJI.nGc = com.tencent.mm.plugin.webview.c.i.b((WebView)this.nKq);
        this.nJI.nGd = bLK().nGd;
        this.nJI.nFM = ((g.a)localObject2).gkl;
        this.nJI.nFN = ((g.a)localObject2).gkm;
        this.nJI.nFO = ((g.a)localObject2).gkn;
        this.nJI.nFP = ((g.a)localObject2).gko;
        this.nJI.nFQ = ((g.a)localObject2).gkp;
        this.nJI.nFR = ((g.a)localObject2).gkq;
        this.nJI.nFS = ((g.a)localObject2).gkr;
        this.nJI.nFT = ((g.a)localObject2).gks;
        this.nJI.nFU = ((g.a)localObject2).gkt;
        this.nJI.nFn = this.nJJ;
        this.nJI.nFt = this.nJK;
        this.nJI.nuJ = bLK().nuJ;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.nGP.a(this, str, bLK(), (q)new s(this));
        i = j;
        break;
        bool = false;
        break label233;
        label541:
        i = 103;
        break label252;
        this.nJI.nGf = 1;
        this.nJJ = ((g.a)localObject2).gkl;
        continue;
        this.nJI.nGf = 2;
        this.nJJ = -1L;
      }
    }
    this.nJI.a(this.nFg);
    localObject1 = this.nJI;
    localObject2 = bLL();
    d.g.b.k.h(localObject2, "<set-?>");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.g)localObject1).url = ((String)localObject2);
    boolean bool = UA(nKd);
    this.nJI.nFW = bool;
    this.nJI.nFV = this.nJN;
    this.nJI.nGu = this.nKq.getWebCoreType().name();
    if (bool) {}
    for (int i = 106;; i = 105)
    {
      com.tencent.mm.plugin.webview.g.a.Ve(i);
      BaseWebViewController.a(this, bLL());
      if (!this.nJZ)
      {
        bLT();
        ac.i(getTAG(), "check notifyPage");
        this.nKa = false;
        aMd().postUIDelayed(this.nKb, this.nJO);
      }
      AppMethodBeat.o(199099);
      return;
    }
  }
  
  public final boolean bLS()
  {
    return false;
  }
  
  public final boolean bLV()
  {
    AppMethodBeat.i(199110);
    boolean bool = UA(this.Cdx);
    AppMethodBeat.o(199110);
    return bool;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(199090);
    String str = (String)this.nJH.getValue();
    AppMethodBeat.o(199090);
    return str;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$ForceUrl;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class ForceUrl
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(199043);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(199043);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      MpWebViewController.e locale = MpWebViewController.nKn;
      if (((waitFor(MpWebViewController.bMe())) || (waitFor(MpWebViewController.bMb())) || (waitFor(MpWebViewController.bMc()))) && (waitFor(MpWebViewController.b((MpWebViewController)localObject))))
      {
        AppMethodBeat.o(199043);
        return true;
      }
      AppMethodBeat.o(199043);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$NotifyAuth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class NotifyAuth
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(199054);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(199054);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      if ((waitFor(MpWebViewController.bLW())) && (((waitFor(MpWebViewController.a((MpWebViewController)localObject))) && (waitFor(MpWebViewController.bLY()))) || (waitFor(MpWebViewController.bLZ()))))
      {
        AppMethodBeat.o(199054);
        return true;
      }
      AppMethodBeat.o(199054);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$PreloadNext;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class PreloadNext
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(199055);
      if (getController() == null)
      {
        v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(199055);
        throw localv;
      }
      boolean bool = waitFor(MpWebViewController.bMa());
      AppMethodBeat.o(199055);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$StartPreload;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class StartPreload
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(199056);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(199056);
        throw ((Throwable)localObject);
      }
      boolean bool = waitFor(MpWebViewController.b((MpWebViewController)localObject));
      AppMethodBeat.o(199056);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$UpdateData;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class UpdateData
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(199058);
      if (getController() == null)
      {
        v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(199058);
        throw localv;
      }
      if ((waitFor(MpWebViewController.bLW())) && (waitFor(MpWebViewController.bLX())))
      {
        AppMethodBeat.o(199058);
        return true;
      }
      AppMethodBeat.o(199058);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$2"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$4"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$5"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$1"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    d(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$Companion;", "", "()V", "MP_AUTH_ERR", "", "MP_AUTH_NOTIFIED", "MP_AUTH_SUCC", "MP_DATA_INJECT_ERR", "MP_DATA_INJECT_SUCC", "MP_DATA_READY", "MP_NOTIFY_ERR", "MP_PRELOAD_NEXT", "MP_TMPL_CHECKING", "MP_TMPL_ERR", "getMP_TMPL_ERR$plugin_brandservice_release", "()I", "MP_TMPL_READY", "readFileWebResp", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "fileName", "", "plugin-brandservice_release"})
  public static final class e
  {
    static WebResourceResponse g(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(199042);
      if (!com.tencent.mm.vfs.i.eA(paramString))
      {
        ac.e("MicroMsg.WebViewController", "tmpl file not found:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(199042);
        return null;
      }
      Object localObject1 = com.tencent.mm.sdk.f.d.aIh(paramString);
      Object localObject2;
      if ((n.nc(paramString, ".js")) && (com.tencent.mm.plugin.webview.c.i.b(paramWebView)))
      {
        paramWebView = new com.tencent.xweb.ag(3, 256, paramWebView);
        paramWebView.aUY(paramString);
        paramWebView = paramWebView.toString();
        localObject2 = StandardCharsets.UTF_8;
        d.g.b.k.g(localObject2, "StandardCharsets.UTF_8");
        if (paramWebView == null)
        {
          paramWebView = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199042);
          throw paramWebView;
        }
        localObject2 = paramWebView.getBytes((Charset)localObject2);
        d.g.b.k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", (InputStream)new ByteArrayInputStream((byte[])localObject2));
      }
      for (;;)
      {
        localObject2 = new HashMap();
        str = Integer.toHexString(paramString.hashCode() & 0xFFFFFFFF);
        d.g.b.k.g(str, "Integer.toHexString(file…Code() and (-1).ushr(32))");
        if (str != null) {
          break;
        }
        paramWebView = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(199042);
        throw paramWebView;
        try
        {
          paramWebView = (InputStream)new FileInputStream(paramString);
          if (paramWebView == null)
          {
            ac.e("MicroMsg.WebViewController", "stream is null, err");
            AppMethodBeat.o(199042);
            return null;
          }
        }
        catch (FileNotFoundException paramWebView)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.WebViewController", (Throwable)paramWebView, "", new Object[0]);
            paramWebView = null;
          }
          localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", paramWebView);
          paramWebView = null;
        }
      }
      String str = str.toLowerCase();
      d.g.b.k.g(str, "(this as java.lang.String).toLowerCase()");
      ((Map)localObject2).put("Cache-Control", "max-age=31536000");
      ((Map)localObject2).put("ETag", str);
      if (paramWebView != null) {
        ((Map)localObject2).put("RunLocalJS", paramWebView);
      }
      ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
      ac.i("MicroMsg.WebViewController", "readFileWebResp:%s\nETag:%s", new Object[] { paramString, str });
      AppMethodBeat.o(199042);
      return localObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideReload", "", "url", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "reason", "", "reqUrl", "fullUrl", "plugin-brandservice_release"})
  static final class f
    extends com.tencent.mm.plugin.webview.core.j
  {
    private final dhu nFg;
    private final MMWebView nKq;
    
    public f(dhu paramdhu, MMWebView paramMMWebView)
    {
      AppMethodBeat.i(199053);
      this.nFg = paramdhu;
      this.nKq = paramMMWebView;
      AppMethodBeat.o(199053);
    }
    
    public final boolean Ui(String paramString)
    {
      AppMethodBeat.i(199051);
      d.g.b.k.h(paramString, "url");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.b((MpWebViewController)localObject1))) && (d.g.b.k.g(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(((MpWebViewController)localObject1).bLL())))) || ((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.bLY())) && (d.g.b.k.g(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(MpWebViewController.c((MpWebViewController)localObject1)))) && (getController().eyC()))))
      {
        localObject2 = ((Iterable)MpWebViewController.d((MpWebViewController)localObject1)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ac.c.g((d.g.a.a)new b((com.tencent.mm.plugin.webview.core.i)((Iterator)localObject2).next()));
        }
        ((BaseWebViewController)localObject1).Cdr = true;
        ((MpWebViewController)localObject1).k(MpWebViewController.Uh(paramString), true, 8);
        AppMethodBeat.o(199051);
        return true;
      }
      AppMethodBeat.o(199051);
      return false;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(199050);
      d.g.b.k.h(paramWebView, "webview");
      d.g.b.k.h(paramWebResourceRequest, "request");
      paramWebView = paramWebResourceRequest.getUrl().toString();
      d.g.b.k.g(paramWebView, "request.url.toString()");
      if (((d.g.b.k.g(paramWebView, this.nFg.CkB) ^ true)) && (!n.nb(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix())))
      {
        ac.d("MicroMsg.WebViewController", "WebView-Trace intercept return");
        AppMethodBeat.o(199050);
        return null;
      }
      ac.i("MicroMsg.WebViewController", "getResourceResponse, requrl:%s, url:%s", new Object[] { paramWebView, this.nFg.FQO });
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.nFg.FQO;
        d.g.b.k.g(paramWebView, "tmplParams.initFilePath");
        paramWebView = new a(paramWebView, false);
      }
      while (paramWebView != null)
      {
        ac.v("MicroMsg.WebViewController", "response path: " + paramWebView.path);
        paramWebResourceRequest = MpWebViewController.nKn;
        paramWebResourceRequest = MpWebViewController.e.g((WebView)this.nKq, paramWebView.path);
        if (paramWebResourceRequest != null)
        {
          ac.i("MicroMsg.WebViewController", "return intercepted success");
          AppMethodBeat.o(199050);
          return paramWebResourceRequest;
          int i;
          if (n.nb(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bLH()))
          {
            i = this.nFg.nGQ;
            paramWebResourceRequest = this.nFg.znF;
            d.g.b.k.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(r.t(i, paramWebResourceRequest, new d.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bLH()).e(paramWebView, "")), true);
          }
          else if (n.nb(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()))
          {
            i = this.nFg.nGQ;
            paramWebResourceRequest = this.nFg.znF;
            d.g.b.k.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(r.t(i, paramWebResourceRequest, new d.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()).e(paramWebView, "")), true);
          }
          else
          {
            paramWebView = null;
          }
        }
        else
        {
          ac.e("MicroMsg.WebViewController", "return intercepted null");
          com.tencent.mm.plugin.webview.g.a.fS(this.nFg.reportId, 126);
          if (paramWebView.nGa) {
            com.tencent.mm.plugin.webview.g.a.fS(this.nFg.reportId, 233);
          }
        }
      }
      AppMethodBeat.o(199050);
      return null;
    }
    
    public final j.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(199052);
      d.g.b.k.h(paramWebView, "webView");
      d.g.b.k.h(paramWebResourceRequest, "request");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (paramWebResourceRequest.isForMainFrame()) && (paramWebResourceRequest.getUrl() != null))
      {
        ac.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url isForMainFrame");
        localObject2 = paramWebResourceRequest.getUrl().toString();
        d.g.b.k.g(localObject2, "request.url.toString()");
        if ((!n.nb((String)localObject2, "https://mp.weixin.qq.com/__tmpl__/")) && (getController().eyC()))
        {
          ac.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url exitTmpl");
          ((BaseWebViewController)localObject1).Cdr = true;
        }
      }
      paramWebView = super.c(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(199052);
      return paramWebView;
    }
    
    public final boolean u(int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(199049);
      d.g.b.k.h(paramString1, "reqUrl");
      d.g.b.k.h(paramString2, "fullUrl");
      if ((paramInt == 0) && (UrlExKt.isMpUrl(paramString2)) && (d.g.b.k.g(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(paramString1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.TD(paramString2))))
      {
        AppMethodBeat.o(199049);
        return true;
      }
      boolean bool = super.u(paramInt, paramString1, paramString2);
      AppMethodBeat.o(199049);
      return bool;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
    public static final class a
    {
      final boolean nGa;
      final String path;
      
      public a(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(199044);
        this.path = paramString;
        this.nGa = paramBoolean;
        AppMethodBeat.o(199044);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(199047);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!d.g.b.k.g(this.path, paramObject.path)) || (this.nGa != paramObject.nGa)) {}
          }
        }
        else
        {
          AppMethodBeat.o(199047);
          return true;
        }
        AppMethodBeat.o(199047);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(199045);
        String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.nGa + ")";
        AppMethodBeat.o(199045);
        return str;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(com.tencent.mm.plugin.webview.core.i parami)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<String>
  {
    g(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "value", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    j(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(MpWebViewController paramMpWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(199064);
      ac.v(MpWebViewController.e(this.nKo), "checkNotifyPageTimer isNotifyPageSuccess=" + this.nKo.nJZ + ", isStopCheckNotifyPage=" + this.nKo.nKa);
      if ((!this.nKo.nJZ) && (!this.nKo.nKa))
      {
        com.tencent.mm.plugin.webview.g.a.lA(92);
        this.nKo.nJI.nGw = true;
        this.nKo.nJI.nGx = true;
        MpWebViewController.o(this.nKo);
        MpWebViewController.b(this.nKo, MpWebViewController.bMc());
        ac.e(MpWebViewController.e(this.nKo), "check notifyPage timeout");
      }
      AppMethodBeat.o(199064);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$initEnviroment$1", "", "__getString", "", "__log", "", "value", "plugin-brandservice_release"})
  public static final class l
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String __getString()
    {
      AppMethodBeat.i(199066);
      Object localObject1 = MpWebViewController.f(this.nKo);
      d.g.b.k.h(localObject1, "$this$getContent");
      Object localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.nGP;
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.bKX(), (String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.vfs.f.af((com.tencent.mm.vfs.e)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      AppMethodBeat.o(199066);
      return localObject1;
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void __log(String paramString)
    {
      AppMethodBeat.i(199065);
      Object localObject = this.nKo;
      if (paramString != null)
      {
        paramString = new JSONObject(paramString).getJSONObject("err");
        if (paramString != null)
        {
          int i = paramString.getInt("errCode");
          paramString = paramString.getString("msg");
          String str = ((MpWebViewController)localObject).getTAG();
          StringBuilder localStringBuilder = new StringBuilder("onWebLog:");
          localObject = ((MpWebViewController)localObject).nJR;
          if (localObject == null) {
            d.g.b.k.aVY("contentId");
          }
          ac.e(str, (String)localObject + ',' + i + ',' + paramString);
          com.tencent.mm.plugin.webview.g.a.Ve(114);
          AppMethodBeat.o(199065);
          return;
        }
      }
      AppMethodBeat.o(199065);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "handleMsg"})
  static final class m
    implements f.a
  {
    m(MpWebViewController paramMpWebViewController) {}
    
    public final boolean b(com.tencent.mm.plugin.webview.c.l paraml)
    {
      AppMethodBeat.i(199067);
      MpWebViewController localMpWebViewController;
      if (d.g.b.k.g(paraml.kCH, "notifyPageInfo"))
      {
        ac.v(MpWebViewController.e(this.nKo), "handleMsg " + paraml.kCH);
        localMpWebViewController = this.nKo;
        d.g.b.k.g(paraml, "msg");
        MpWebViewController.a(localMpWebViewController, paraml);
        AppMethodBeat.o(199067);
        return true;
      }
      if (d.g.b.k.g(paraml.kCH, "updatePageAuth"))
      {
        ac.v(MpWebViewController.e(this.nKo), "handleMsg " + paraml.kCH);
        localMpWebViewController = this.nKo;
        d.g.b.k.g(paraml, "msg");
        MpWebViewController.b(localMpWebViewController, paraml);
        AppMethodBeat.o(199067);
        return true;
      }
      AppMethodBeat.o(199067);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  public static final class n
  {
    final boolean nGa;
    final String path;
    
    public n(String paramString)
    {
      AppMethodBeat.i(199068);
      this.path = paramString;
      this.nGa = false;
      AppMethodBeat.o(199068);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(199071);
      if (this != paramObject)
      {
        if ((paramObject instanceof n))
        {
          paramObject = (n)paramObject;
          if ((!d.g.b.k.g(this.path, paramObject.path)) || (this.nGa != paramObject.nGa)) {}
        }
      }
      else
      {
        AppMethodBeat.o(199071);
        return true;
      }
      AppMethodBeat.o(199071);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(199069);
      String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.nGa + ")";
      AppMethodBeat.o(199069);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"getNotifyPageInfoString", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "invoke"})
  static final class o
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.plugin.webview.c.l, String>
  {
    public static final o nKs;
    
    static
    {
      AppMethodBeat.i(199074);
      nKs = new o();
      AppMethodBeat.o(199074);
    }
    
    o()
    {
      super();
    }
    
    public static String c(com.tencent.mm.plugin.webview.c.l paraml)
    {
      AppMethodBeat.i(199073);
      d.g.b.k.h(paraml, "msg");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("performance", (String)paraml.vUl.get("performance"));
      localJSONObject.put("injectPageDataResult", (String)paraml.vUl.get("injectPageDataResult"));
      paraml = localJSONObject.toString();
      d.g.b.k.g(paraml, "pageInfo.toString()");
      AppMethodBeat.o(199073);
      return paraml;
    }
  }
  
  @d.d.b.a.e(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController$notifyPageInfo$2", f="MpWebViewController.kt", l={422}, m="invokeSuspend")
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class p
    extends d.d.b.a.i
    implements m<kotlinx.coroutines.ag, d.d.d<? super y>, Object>
  {
    int label;
    private kotlinx.coroutines.ag nvs;
    Object nvt;
    
    p(MpWebViewController paramMpWebViewController, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(199076);
      d.g.b.k.h(paramd, "completion");
      paramd = new p(this.nKo, paramd);
      paramd.nvs = ((kotlinx.coroutines.ag)paramObject);
      AppMethodBeat.o(199076);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(199075);
      paramObject = d.d.a.a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(199075);
        throw paramObject;
      case 0: 
        this.nvt = this.nvs;
        this.label = 1;
        if (as.b(300L, this) == paramObject)
        {
          AppMethodBeat.o(199075);
          return paramObject;
        }
        break;
      }
      MpWebViewController.b(this.nKo, MpWebViewController.bMa());
      paramObject = y.KTp;
      AppMethodBeat.o(199075);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(199077);
      paramObject1 = ((p)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(199077);
      return paramObject1;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class q
    extends d.g.b.l
    implements q<String, String, List<? extends o<? extends String, ? extends String>>, y>
  {
    q(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class r
    extends d.g.b.l
    implements q<String, String, List<? extends o<? extends String, ? extends String>>, y>
  {
    r(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "contextRef", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class s
    extends d.g.b.l
    implements q<WeakReference<Object>, k.c, ew, y>
  {
    s(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "invoke"})
  static final class t
    extends d.g.b.l
    implements d.g.a.a<chb>
  {
    t(MpWebViewController paramMpWebViewController, MMWebView paramMMWebView)
    {
      super();
    }
    
    private chb bMf()
    {
      AppMethodBeat.i(199082);
      try
      {
        localObject1 = MpWebViewController.l(this.nKo);
        localObject3 = e.m.HhD;
        d.g.b.k.g(localObject3, "ConstantsUI.WebViewUI.KTmplSession");
        localObject1 = ((Intent)localObject1).getByteArrayExtra((String)localObject3);
        if (localObject1 == null) {
          break label258;
        }
        i = localObject1.length;
        if (i != 0) {
          break label232;
        }
        i = 1;
      }
      catch (Exception localException1)
      {
        chb localchb;
        for (;;)
        {
          try
          {
            Object localObject3 = chb.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            Object localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject3 = (chb)localObject1;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = (Throwable)new Resources.NotFoundException("TmplSession");
            AppMethodBeat.o(199082);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException2)
          {
            int i;
            Object localObject2;
            ac.printErrStackTrace("Intent.decodeProtoBuffer", (Throwable)localException2, "decode ProtoBuffer", new Object[0]);
          }
          localException1 = localException1;
          ac.e(MpWebViewController.e(this.nKo), "session is null, " + localException1.getMessage() + ' ' + com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ae(MpWebViewController.l(this.nKo)));
          com.tencent.mm.plugin.webview.g.a.Ve(153);
          com.tencent.mm.plugin.report.service.h.wUl.f(17260, new Object[] { Integer.valueOf(2), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ae(MpWebViewController.l(this.nKo)) });
          if ((paramMMWebView.getActivityContextIfHas() instanceof Activity))
          {
            localObject2 = paramMMWebView.getActivityContextIfHas();
            if (localObject2 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(199082);
              throw ((Throwable)localObject2);
              i = 0;
              continue;
              i = 0;
              continue;
              localchb = null;
            }
            else
            {
              ((Activity)localchb).finish();
            }
          }
          else
          {
            localchb = new chb();
          }
        }
        AppMethodBeat.o(199082);
        return localchb;
      }
      if (i == 0)
      {
        i = 1;
        if (i == 0) {
          break label258;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class u
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    u(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "value", "", "invoke"})
  static final class v
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    v(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "value", "", "invoke"})
  static final class w
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    w(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "value", "", "invoke"})
  static final class x
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    x(MpWebViewController paramMpWebViewController, long paramLong1, v.a parama, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class y
    implements IPCRunCgi.a
  {
    y(MpWebViewController paramMpWebViewController, String paramString, com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(199088);
      MpWebViewController.g(this.nKo).remove(this.nKx);
      d.g.b.k.g(paramb, "rr");
      if (!(paramb.aBD() instanceof arn))
      {
        AppMethodBeat.o(199088);
        return;
      }
      paramString = paramb.aBD();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetA8KeyResp");
        AppMethodBeat.o(199088);
        throw paramString;
      }
      paramString = (arn)paramString;
      if (bs.isNullOrNil(paramString.EKZ))
      {
        ac.e(MpWebViewController.e(this.nKo), "updatePageAuth fail fullurl is null");
        com.tencent.mm.plugin.webview.g.a.lA(82);
        paramString = this.nKo.getJsapi();
        if (paramString != null)
        {
          paramString.j(this.nKy.Ckt, this.nKy.kCH + ":fail", null);
          AppMethodBeat.o(199088);
          return;
        }
        AppMethodBeat.o(199088);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        try
        {
          paramb = new JsapiPermissionWrapper(com.tencent.mm.platformtools.z.a(paramString.ELi));
          Object localObject = new GeneralControlWrapper(paramString.ELc);
          this.nKo.kYu.a(paramString.EKZ, paramb, (GeneralControlWrapper)localObject);
          paramb = this.nKo;
          localObject = this.nKx;
          String str = paramString.EKZ;
          d.g.b.k.g(str, "resp.FullURL");
          Map localMap = com.tencent.mm.plugin.webview.e.c.gI((List)paramString.EKJ);
          d.g.b.k.g(localMap, "LuggageGetA8Key.getHttpHeaders(resp.HttpHeader)");
          MpWebViewController.a(paramb, (String)localObject, str, localMap);
          com.tencent.mm.plugin.webview.g.a.Ve(109);
          paramb = (Map)new HashMap();
          paramString = paramString.EKZ;
          d.g.b.k.g(paramString, "resp.FullURL");
          paramb.put("fullUrl", paramString);
          ac.i(MpWebViewController.e(this.nKo), "updatePageAuth values:%s", new Object[] { paramb });
          com.tencent.mm.plugin.webview.g.a.lA(81);
          paramString = this.nKo.getJsapi();
          if (paramString != null)
          {
            paramString.j(this.nKy.Ckt, this.nKy.kCH + ":ok", paramb);
            AppMethodBeat.o(199088);
            return;
          }
        }
        catch (Exception paramString)
        {
          com.tencent.mm.plugin.webview.g.a.lA(82);
          paramString = this.nKo.getJsapi();
          if (paramString != null)
          {
            paramString.j(this.nKy.Ckt, this.nKy.kCH + ":fail", null);
            AppMethodBeat.o(199088);
            return;
            AppMethodBeat.o(199088);
            return;
          }
          AppMethodBeat.o(199088);
          return;
        }
      }
      com.tencent.mm.plugin.webview.g.a.lA(82);
      paramString = this.nKo.getJsapi();
      if (paramString != null)
      {
        paramString.j(this.nKy.Ckt, this.nKy.kCH + ":fail", null);
        AppMethodBeat.o(199088);
        return;
      }
      AppMethodBeat.o(199088);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController
 * JD-Core Version:    0.7.0.1
 */