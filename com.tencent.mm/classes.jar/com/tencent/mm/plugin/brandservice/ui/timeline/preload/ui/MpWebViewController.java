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
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.webview.c.f.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.b;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.e;
import com.tencent.mm.plugin.webview.core.j.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.e;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ag;
import d.g.a.m;
import d.g.b.p;
import d.g.b.y.a;
import d.o;
import d.v;
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
import kotlinx.coroutines.ah;
import kotlinx.coroutines.at;
import org.json.JSONObject;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "API", "", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "TIMEOUT_TIME", "", "getTIMEOUT_TIME", "()J", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "checkNotifyPageTimer", "Ljava/lang/Runnable;", "contentId", "fullUrl", "gettingA8KeyUrl", "Ljava/util/HashSet;", "injectAPI", "isCheckingInject", "<set-?>", "isInjectDataSuccess", "isNotifyPageSuccess", "setNotifyPageSuccess", "(Z)V", "isStopCheckNotifyPage", "setStopCheckNotifyPage", "isTmplReady", "isUseDataCache", "setUseDataCache", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "getKv15862", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "preloadNext", "getPreloadNext", "setPreloadNext", "rawUrl", "getRawUrl", "receivePageData", "getReceivePageData", "setReceivePageData", "(J)V", "recodeInject", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "getSession", "()Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "session$delegate", "startGetPageData", "getStartGetPageData", "setStartGetPageData", "startLoadPage", "getStartLoadPage", "setStartLoadPage", "adjustInnerWidth", "", "canHandleUrl", "url", "cancelReport", "checkInject", "checkNotifyPage", "getLogAPI", "value", "initEnviroment", "isPageCached", "isSameStart", "intent", "Landroid/content/Intent;", "loadForceUrl", "forceUrl", "fullScreen", "loadTmpl", "modifyForceUrl", "needSyncGetA8Key", "notifyPageInfo", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "pageInfo", "onError", "reason", "", "reqUrl", "errType", "errCode", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onStartLoad", "onWebLog", "processCommonGetA8KeyFullUrl", "httpHeader", "", "processData", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processReport", "setMpUrl", "startAuth", "force", "stopCheckNotifyPage", "tryPreloadNextWebView", "updateAuth", "isSuccess", "updateData", "updateKV", "updatePageAuth", "validCommitUrl", "validStartUrl", "waitForInject", "waitForReady", "Companion", "ForceUrl", "MpWebViewInterceptor", "NotifyAuth", "PreloadNext", "StartPreload", "UpdateData", "plugin-brandservice_release"})
public final class MpWebViewController
  extends com.tencent.mm.plugin.webview.core.h
{
  private static final int omI = -101;
  static final int omJ = -102;
  private static final int omK = -103;
  private static final int omL = -111;
  private static final int omM = -112;
  private static final int omN = -113;
  private static final int omO = -121;
  private static final int omP = -122;
  private static final int omQ = -123;
  private static final int omR = -124;
  private static final int omS = -130;
  public static final e omT;
  private final dnj ohJ;
  private final String omA;
  private final List<BaseWebViewController.e> omB;
  private final String omC;
  boolean omD;
  private final HashSet<String> omE;
  boolean omF;
  boolean omG;
  private final Runnable omH;
  private final d.f omn;
  final com.tencent.mm.plugin.brandservice.ui.timeline.preload.g omo;
  private long omp;
  private long omq;
  private long omr;
  private boolean oms;
  private boolean omt;
  private final long omu;
  private final d.f omv;
  private String omw;
  String omx;
  private boolean omy;
  private boolean omz;
  
  static
  {
    AppMethodBeat.i(210062);
    omT = new e((byte)0);
    omI = -101;
    omJ = -102;
    omK = -103;
    omL = -111;
    omM = -112;
    omN = -113;
    omO = -121;
    omP = -122;
    omQ = -123;
    omR = -124;
    omS = -130;
    AppMethodBeat.o(210062);
  }
  
  public MpWebViewController(dnj paramdnj, final MMWebView paramMMWebView)
  {
    super(paramMMWebView);
    AppMethodBeat.i(210061);
    this.ohJ = paramdnj;
    this.omn = d.g.O((d.g.a.a)new g(this));
    paramdnj = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.g();
    paramdnj.a(this.ohJ);
    this.omo = paramdnj;
    this.oms = true;
    this.omu = 5000L;
    this.omv = d.g.O((d.g.a.a)new t(this, paramMMWebView));
    this.omA = "__tmpl_webview_inject_data";
    if (!(paramMMWebView instanceof a.a)) {}
    for (paramdnj = null;; paramdnj = paramMMWebView)
    {
      paramdnj = (a.a)paramdnj;
      if (paramdnj != null) {
        paramdnj.setCurrentUrlProxy((d.g.a.a)new d(this));
      }
      paramdnj = super.bQq();
      paramdnj.addAll((Collection)d.a.j.listOf(new BaseWebViewController.e[] { new BaseWebViewController.e(d.g.b.z.bp(UpdateData.class), (d.g.a.a)new h((MpWebViewController)this)), new BaseWebViewController.e(d.g.b.z.bp(StartPreload.class), (d.g.a.a)new a(this)), new BaseWebViewController.e(d.g.b.z.bp(PreloadNext.class), (d.g.a.a)new i((MpWebViewController)this)), new BaseWebViewController.e(d.g.b.z.bp(NotifyAuth.class), (d.g.a.a)new b(this)), new BaseWebViewController.e(d.g.b.z.bp(ForceUrl.class), (d.g.a.a)new c(this)) }));
      this.omB = paramdnj;
      this.omC = (this.omA + ".__getString()");
      this.omE = new HashSet();
      this.omH = ((Runnable)new k(this));
      AppMethodBeat.o(210061);
      return;
    }
  }
  
  private final void XN(String paramString)
  {
    AppMethodBeat.i(210051);
    this.DFY = paramString;
    aGd(paramString);
    aGe(paramString);
    p.h(paramString, "<set-?>");
    this.cSr = paramString;
    AppMethodBeat.o(210051);
  }
  
  private void XO(String paramString)
  {
    AppMethodBeat.i(210058);
    p.h(paramString, "forceUrl");
    bQu();
    h.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.ojh;
    if (h.a.bPu())
    {
      AppMethodBeat.o(210058);
      return;
    }
    eNs();
    this.DGq = true;
    k(XP(paramString), true, 8);
    AppMethodBeat.o(210058);
  }
  
  private static String XP(String paramString)
  {
    AppMethodBeat.i(210060);
    paramString = UrlExKt.appendUrlParam(UrlExKt.clearUrlParam(UrlExKt.clearUrlParam(UrlExKt.clearUrlParam(paramString, "fasttmpl_flag"), "fasttmpl_type"), "fasttmpl_fullversion"), "forceh5", "1");
    AppMethodBeat.o(210060);
    return paramString;
  }
  
  /* Error */
  private final boolean a(com.tencent.mm.plugin.webview.c.l paraml)
  {
    // Byte code:
    //   0: ldc_w 651
    //   3: invokestatic 283	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 655	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o:omY	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o;
    //   9: astore 10
    //   11: aload_1
    //   12: invokestatic 658	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$o:c	(Lcom/tencent/mm/plugin/webview/c/l;)Ljava/lang/String;
    //   15: astore 10
    //   17: aload_0
    //   18: invokevirtual 513	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   21: ldc_w 660
    //   24: aload 10
    //   26: invokestatic 666	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 669	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 530	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: new 671	org/json/JSONObject
    //   38: dup
    //   39: aload 10
    //   41: invokespecial 672	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 10
    //   46: new 671	org/json/JSONObject
    //   49: dup
    //   50: aload 10
    //   52: ldc_w 674
    //   55: invokevirtual 677	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 672	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore 11
    //   63: aload 11
    //   65: ldc_w 679
    //   68: invokevirtual 683	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   71: lstore_2
    //   72: aload 11
    //   74: ldc_w 685
    //   77: invokevirtual 683	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   80: lstore 4
    //   82: aload 11
    //   84: ldc_w 687
    //   87: invokevirtual 683	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   90: lstore 6
    //   92: aload 11
    //   94: ldc_w 689
    //   97: invokevirtual 683	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   100: lstore 8
    //   102: aload_0
    //   103: getfield 693	com/tencent/mm/plugin/webview/core/BaseWebViewController:DGl	Lcom/tencent/mm/plugin/webview/j/i;
    //   106: ldc_w 687
    //   109: lload 6
    //   111: invokevirtual 699	com/tencent/mm/plugin/webview/j/i:bL	(Ljava/lang/String;J)V
    //   114: aload_0
    //   115: getfield 693	com/tencent/mm/plugin/webview/core/BaseWebViewController:DGl	Lcom/tencent/mm/plugin/webview/j/i;
    //   118: ldc_w 689
    //   121: lload 8
    //   123: invokevirtual 699	com/tencent/mm/plugin/webview/j/i:bL	(Ljava/lang/String;J)V
    //   126: aload_0
    //   127: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   130: lload_2
    //   131: putfield 702	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:ohU	J
    //   134: aload_0
    //   135: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   138: lload 4
    //   140: putfield 705	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:ohV	J
    //   143: aload_0
    //   144: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   147: lload 6
    //   149: putfield 708	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:ohR	J
    //   152: aload_0
    //   153: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   156: lload 8
    //   158: putfield 711	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:ohT	J
    //   161: aload 10
    //   163: ldc_w 713
    //   166: ldc_w 715
    //   169: invokevirtual 717	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: ldc_w 719
    //   175: invokestatic 722	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   178: ifeq +122 -> 300
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 724	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omF	Z
    //   186: aload_0
    //   187: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   190: iconst_1
    //   191: putfield 727	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:oiK	Z
    //   194: aload_0
    //   195: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   198: new 63	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 728	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;)V
    //   206: checkcast 730	d/g/a/q
    //   209: invokevirtual 733	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:b	(Ld/g/a/q;)V
    //   212: aload_0
    //   213: getfield 330	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ohJ	Lcom/tencent/mm/protocal/protobuf/dnj;
    //   216: getfield 535	com/tencent/mm/protocal/protobuf/dnj:reportId	I
    //   219: sipush 131
    //   222: invokestatic 543	com/tencent/mm/plugin/webview/g/a:gi	(II)V
    //   225: bipush 108
    //   227: invokestatic 736	com/tencent/mm/plugin/webview/g/a:WU	(I)V
    //   230: aload_0
    //   231: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   234: invokestatic 568	java/lang/System:currentTimeMillis	()J
    //   237: putfield 739	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:oij	J
    //   240: aload_0
    //   241: invokespecial 624	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bQv	()V
    //   244: aload_0
    //   245: invokespecial 457	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bQu	()V
    //   248: aload_0
    //   249: invokevirtual 743	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   252: aload_1
    //   253: getfield 748	com/tencent/mm/plugin/webview/c/l:DNz	Ljava/lang/String;
    //   256: ldc_w 750
    //   259: aconst_null
    //   260: invokevirtual 754	com/tencent/mm/plugin/webview/c/f:i	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   263: bipush 90
    //   265: invokestatic 757	com/tencent/mm/plugin/webview/g/a:ma	(I)V
    //   268: getstatic 763	kotlinx/coroutines/bk:NII	Lkotlinx/coroutines/bk;
    //   271: checkcast 765	kotlinx/coroutines/ah
    //   274: aconst_null
    //   275: new 61	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p
    //   278: dup
    //   279: aload_0
    //   280: aconst_null
    //   281: invokespecial 768	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;Ld/d/d;)V
    //   284: checkcast 770	d/g/a/m
    //   287: iconst_3
    //   288: invokestatic 775	kotlinx/coroutines/f:b	(Lkotlinx/coroutines/ah;Ld/d/f;Ld/g/a/m;I)Lkotlinx/coroutines/br;
    //   291: pop
    //   292: ldc_w 651
    //   295: invokestatic 314	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_0
    //   301: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   304: iconst_1
    //   305: putfield 621	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:oiZ	Z
    //   308: aload_0
    //   309: getstatic 309	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omR	I
    //   312: invokevirtual 778	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:Wr	(I)V
    //   315: aload_0
    //   316: invokevirtual 513	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   319: ldc_w 780
    //   322: invokestatic 530	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -95 -> 230
    //   328: astore 10
    //   330: aload_0
    //   331: invokevirtual 513	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   334: aload 10
    //   336: checkcast 782	java/lang/Throwable
    //   339: ldc_w 783
    //   342: iconst_0
    //   343: anewarray 785	java/lang/Object
    //   346: invokestatic 789	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: getfield 352	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omo	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   353: iconst_1
    //   354: putfield 621	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:oiZ	Z
    //   357: aload_0
    //   358: getstatic 309	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:omR	I
    //   361: invokevirtual 778	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:Wr	(I)V
    //   364: goto -134 -> 230
    //   367: astore 10
    //   369: aload_0
    //   370: invokevirtual 513	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   373: aload 10
    //   375: checkcast 782	java/lang/Throwable
    //   378: ldc_w 790
    //   381: iconst_0
    //   382: anewarray 785	java/lang/Object
    //   385: invokestatic 789	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: aload_0
    //   389: invokevirtual 743	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   392: aload_1
    //   393: getfield 748	com/tencent/mm/plugin/webview/c/l:DNz	Ljava/lang/String;
    //   396: ldc_w 792
    //   399: aconst_null
    //   400: invokevirtual 754	com/tencent/mm/plugin/webview/c/f:i	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   403: bipush 91
    //   405: invokestatic 757	com/tencent/mm/plugin/webview/g/a:ma	(I)V
    //   408: ldc_w 651
    //   411: invokestatic 314	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: iconst_0
    //   415: ireturn
    //   416: astore 10
    //   418: aload_0
    //   419: invokevirtual 513	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   422: aload 10
    //   424: checkcast 782	java/lang/Throwable
    //   427: ldc_w 790
    //   430: iconst_0
    //   431: anewarray 785	java/lang/Object
    //   434: invokestatic 789	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private cma bQl()
  {
    AppMethodBeat.i(210036);
    cma localcma = (cma)this.omv.getValue();
    AppMethodBeat.o(210036);
    return localcma;
  }
  
  private final void bQu()
  {
    AppMethodBeat.i(210049);
    ad.d(getTAG(), "stopCheckNotifyPage");
    aPk().removeCallbacks(this.omH);
    this.omG = true;
    AppMethodBeat.o(210049);
  }
  
  private final void bQv()
  {
    AppMethodBeat.i(210050);
    ad.v(getTAG(), "terry trace updateKV");
    this.omo.oie = this.DGl.bM("onInjectStart", 0L);
    this.omo.oif = this.DGl.bM("onInjectEnd", 0L);
    this.omo.oih = this.DGl.bM("onTmplLoadStart", 0L);
    this.omo.oii = this.DGl.bM("onTmplLoadEnd", 0L);
    this.omo.oic = this.DGl.bM("onCreateStart", 0L);
    this.omo.oid = this.DGl.bM("onCreateEnd", 0L);
    this.omo.oiA = this.omD;
    this.omo.oig = this.DGl.bM("onWebInjectEnd", 0L);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.g localg = this.omo;
    String str = this.omW.getRandomStr();
    p.g(str, "viewWV.randomStr");
    localg.setKey(str);
    this.omo.oiB = Ws(omJ);
    AppMethodBeat.o(210050);
  }
  
  private final void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(210057);
    ad.i(getTAG(), "[updatePageAuth]reqUrl:" + paramString1 + " fullUrl:" + paramString2 + " httpHeader:" + paramMap);
    paramString1 = this.omW.getSettings();
    p.g(paramString1, "viewWV.settings");
    paramString1 = paramString1.getUserAgentString();
    p.g(paramString1, "viewWV.settings.userAgentString");
    paramMap.put("User-agent", paramString1);
    getJsapi().aGF(new JSONObject(paramMap).toString());
    paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
    getJsapi().aGE(paramString1);
    AppMethodBeat.o(210057);
  }
  
  private void s(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210052);
    p.h(paramString, "contentId");
    ad.v(getTAG(), "[updateData] " + bQm());
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.Xw(bQm());
    XN(bQm());
    this.omx = paramString;
    this.omp = paramLong1;
    this.omr = paramLong2;
    Wr(omL);
    AppMethodBeat.o(210052);
  }
  
  public final boolean XK(String paramString)
  {
    AppMethodBeat.i(210042);
    p.h(paramString, "url");
    if ((super.XL(paramString)) && ((p.i(paramString, this.ohJ.DNG) ^ true)))
    {
      AppMethodBeat.o(210042);
      return true;
    }
    AppMethodBeat.o(210042);
    return false;
  }
  
  public final boolean XL(String paramString)
  {
    AppMethodBeat.i(210043);
    p.h(paramString, "url");
    if ((super.XL(paramString)) && ((p.i(paramString, this.ohJ.DNG) ^ true)))
    {
      AppMethodBeat.o(210043);
      return true;
    }
    AppMethodBeat.o(210043);
    return false;
  }
  
  public final boolean XM(String paramString)
  {
    AppMethodBeat.i(210045);
    boolean bool = p.i(paramString, this.ohJ.DNG);
    AppMethodBeat.o(210045);
    return bool;
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(210056);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "errMsg");
    super.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
    if (paramInt1 == 0)
    {
      this.omw = paramString1;
      Wr(omP);
    }
    AppMethodBeat.o(210056);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, avj paramavj)
  {
    AppMethodBeat.i(210053);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    p.h(paramavj, "response");
    if (paramInt == 0) {
      XN(paramString2);
    }
    super.a(paramInt, paramString1, paramString2, paramavj);
    if (paramInt == 0)
    {
      this.omw = paramString2;
      paramavj = com.tencent.mm.plugin.webview.e.c.gU((List)paramavj.GtM);
      p.g(paramavj, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      com.tencent.mm.plugin.webview.g.a.gi(this.ohJ.reportId, 117);
      this.omo.oib = System.currentTimeMillis();
      this.omo.oiJ = true;
      bQv();
      this.omo.b((d.g.a.q)new r(this));
      c(paramString1, paramString2, paramavj);
      Wr(omO);
    }
    AppMethodBeat.o(210053);
  }
  
  public final boolean aG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(210046);
    p.h(paramString, "url");
    if (((p.i(paramString, this.ohJ.DNG) ^ true)) && (super.aG(paramString, paramBoolean)))
    {
      AppMethodBeat.o(210046);
      return true;
    }
    AppMethodBeat.o(210046);
    return false;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(210047);
    super.b(paramWebView, paramString);
    if (p.i(paramString, this.ohJ.DNG))
    {
      if ((Ws(omJ)) || (Ws(omI)))
      {
        AppMethodBeat.o(210047);
        return;
      }
      ad.i(getTAG(), "checkInject start");
      com.tencent.mm.plugin.webview.g.a.gi(this.ohJ.reportId, 113);
      g("JSON.stringify(window.__appmsg_skeleton_success__)", (d.g.a.b)new j(this));
      int i = com.tencent.mm.cc.a.ip(this.omW.getContext());
      float f = com.tencent.mm.cc.a.getDensity(this.omW.getContext());
      ad.i(getTAG(), "adjustInnerWidth() screenWidth:" + i + ", density:" + f);
      if ((i > 0) && (f > 0.0F))
      {
        i = (int)(i / f);
        ad.i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(i)));
        g("window.innerWidth = ".concat(String.valueOf(i)), null);
      }
      ad.i(getTAG(), "[onPageReady]");
    }
    AppMethodBeat.o(210047);
  }
  
  public final String bQm()
  {
    AppMethodBeat.i(210037);
    String str = d.n.n.bp(BaseWebViewController.b.aX(getIntent()), "http://", "https://");
    AppMethodBeat.o(210037);
    return str;
  }
  
  public final boolean bQn()
  {
    AppMethodBeat.i(210038);
    if ((Ws(omM)) || (Ws(omN)))
    {
      AppMethodBeat.o(210038);
      return true;
    }
    AppMethodBeat.o(210038);
    return false;
  }
  
  public final boolean bQo()
  {
    AppMethodBeat.i(210039);
    if ((Ws(this.DGw)) && (Ws(omJ)))
    {
      AppMethodBeat.o(210039);
      return true;
    }
    AppMethodBeat.o(210039);
    return false;
  }
  
  public final boolean bQp()
  {
    AppMethodBeat.i(210040);
    if ((eNn()) && (Ws(omO)))
    {
      AppMethodBeat.o(210040);
      return true;
    }
    AppMethodBeat.o(210040);
    return false;
  }
  
  public final List<BaseWebViewController.e> bQq()
  {
    return this.omB;
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(210041);
    a((com.tencent.mm.plugin.webview.core.j)new f(this.ohJ, this.omW));
    super.bQr();
    this.omW.addJavascriptInterface(new l(this), this.omA);
    getJsapi().eOw();
    getJsapi().a((f.a)new m(this));
    String str = this.ohJ.DNG;
    ad.i(getTAG(), "WebView-Trace loadTmpl getResourceResponse, requrl:%s, url:%s", new Object[] { str, this.ohJ.HBu });
    Object localObject = this.ohJ.HBu;
    p.g(localObject, "tmplParams.initFilePath");
    localObject = new n((String)localObject);
    ad.v(getTAG(), "response path:" + bt.bI(((n)localObject).path, "null"));
    if (e.g((WebView)this.omW, ((n)localObject).path) != null)
    {
      ad.i(getTAG(), "return intercepted success");
      Wr(this.DGx);
      this.omW.loadUrl(str);
      Wr(this.DGw);
      AppMethodBeat.o(210041);
      return;
    }
    ad.e(getTAG(), "return intercepted null");
    com.tencent.mm.plugin.webview.g.a.gi(this.ohJ.reportId, 126);
    if (((n)localObject).oiD) {
      com.tencent.mm.plugin.webview.g.a.gi(this.ohJ.reportId, 233);
    }
    AppMethodBeat.o(210041);
  }
  
  public final void bQs()
  {
    int j = 1;
    AppMethodBeat.i(210044);
    ad.i(getTAG(), "onStartLoad");
    Object localObject1 = getIntent();
    p.h(localObject1, "intent");
    ad.v(getTAG(), "processData");
    setIntent((Intent)localObject1);
    this.omq = System.currentTimeMillis();
    this.oms = ((Intent)localObject1).getBooleanExtra(e.m.IUI, true);
    this.omp = ((Intent)localObject1).getLongExtra(e.m.IUJ, 0L);
    Object localObject2 = com.tencent.mm.kernel.g.ajz().ajb();
    p.g(localObject2, "MMKernel.process().current()");
    localObject2 = ((com.tencent.mm.kernel.b.h)localObject2).akv();
    String str = ((Intent)localObject1).getStringExtra(e.m.IUL);
    if ((((Intent)localObject1).getStringExtra("rawUrl") == null) || (str == null))
    {
      ad.e(getTAG(), "rawUrl is null, " + com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ag((Intent)localObject1));
      com.tencent.mm.plugin.webview.g.a.WU(151);
      com.tencent.mm.plugin.report.service.g.yhR.f(17260, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ag((Intent)localObject1) });
      i = 0;
      if (i == 0)
      {
        onFinish();
        AppMethodBeat.o(210044);
      }
    }
    else
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.g localg = this.omo;
      if (((g.a)localObject2).gEd < this.omp)
      {
        bool = true;
        label233:
        localg.oiH = bool;
        if (!this.omo.oiH) {
          break label541;
        }
        i = 104;
        label252:
        com.tencent.mm.plugin.webview.g.a.WU(i);
        switch (s.a(((Intent)localObject1).getIntExtra(e.m.IUQ, -1), this.omp, Process.myPid(), ((g.a)localObject2).gDV))
        {
        }
      }
      for (;;)
      {
        this.omo.oiD = bQl().Hfm;
        this.omo.oiE = bQl().Hfn;
        this.omo.oiF = com.tencent.mm.plugin.webview.c.i.b((WebView)this.omW);
        this.omo.oiG = bQl().oiG;
        this.omo.oip = ((g.a)localObject2).gDV;
        this.omo.oiq = ((g.a)localObject2).gDW;
        this.omo.oir = ((g.a)localObject2).gDX;
        this.omo.ois = ((g.a)localObject2).gDY;
        this.omo.oit = ((g.a)localObject2).gDZ;
        this.omo.oiu = ((g.a)localObject2).gEa;
        this.omo.oiv = ((g.a)localObject2).gEb;
        this.omo.oiw = ((g.a)localObject2).gEc;
        this.omo.oix = ((g.a)localObject2).gEd;
        this.omo.ohQ = this.omp;
        this.omo.ohW = this.omq;
        this.omo.nWh = bQl().nWh;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.ojs.a(this, str, bQl(), (d.g.a.q)new s(this));
        i = j;
        break;
        bool = false;
        break label233;
        label541:
        i = 103;
        break label252;
        this.omo.oiI = 1;
        this.omp = ((g.a)localObject2).gDV;
        continue;
        this.omo.oiI = 2;
        this.omp = -1L;
      }
    }
    this.omo.a(this.ohJ);
    localObject1 = this.omo;
    localObject2 = bQm();
    p.h(localObject2, "<set-?>");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.g)localObject1).url = ((String)localObject2);
    boolean bool = Ws(omJ);
    this.omo.oiz = bool;
    this.omo.oiy = this.omt;
    this.omo.oiX = this.omW.getWebCoreType().name();
    if (bool) {}
    for (int i = 106;; i = 105)
    {
      com.tencent.mm.plugin.webview.g.a.WU(i);
      BaseWebViewController.a(this, bQm());
      if (!this.omF)
      {
        bQu();
        ad.i(getTAG(), "check notifyPage");
        this.omG = false;
        aPk().postUIDelayed(this.omH, this.omu);
      }
      AppMethodBeat.o(210044);
      return;
    }
  }
  
  public final boolean bQt()
  {
    return false;
  }
  
  public final boolean bQw()
  {
    AppMethodBeat.i(210055);
    boolean bool = Ws(this.DGw);
    AppMethodBeat.o(210055);
    return bool;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(210035);
    String str = (String)this.omn.getValue();
    AppMethodBeat.o(210035);
    return str;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$ForceUrl;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class ForceUrl
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(209990);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(209990);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      MpWebViewController.e locale = MpWebViewController.omT;
      if (((waitFor(MpWebViewController.bQF())) || (waitFor(MpWebViewController.bQC())) || (waitFor(MpWebViewController.bQD()))) && (waitFor(MpWebViewController.b((MpWebViewController)localObject))))
      {
        AppMethodBeat.o(209990);
        return true;
      }
      AppMethodBeat.o(209990);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$NotifyAuth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class NotifyAuth
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(210001);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(210001);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      if ((waitFor(MpWebViewController.bQx())) && (((waitFor(MpWebViewController.a((MpWebViewController)localObject))) && (waitFor(MpWebViewController.bQz()))) || (waitFor(MpWebViewController.bQA()))))
      {
        AppMethodBeat.o(210001);
        return true;
      }
      AppMethodBeat.o(210001);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$PreloadNext;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class PreloadNext
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(210002);
      if (getController() == null)
      {
        v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(210002);
        throw localv;
      }
      boolean bool = waitFor(MpWebViewController.bQB());
      AppMethodBeat.o(210002);
      return bool;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$StartPreload;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class StartPreload
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(210003);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(210003);
        throw ((Throwable)localObject);
      }
      boolean bool = waitFor(MpWebViewController.b((MpWebViewController)localObject));
      AppMethodBeat.o(210003);
      return bool;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$UpdateData;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class UpdateData
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(210005);
      if (getController() == null)
      {
        v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(210005);
        throw localv;
      }
      if ((waitFor(MpWebViewController.bQx())) && (waitFor(MpWebViewController.bQy())))
      {
        AppMethodBeat.o(210005);
        return true;
      }
      AppMethodBeat.o(210005);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$2"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    a(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$4"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    b(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$5"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    c(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$1"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    d(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$Companion;", "", "()V", "MP_AUTH_ERR", "", "MP_AUTH_NOTIFIED", "MP_AUTH_SUCC", "MP_DATA_INJECT_ERR", "MP_DATA_INJECT_SUCC", "MP_DATA_READY", "MP_NOTIFY_ERR", "MP_PRELOAD_NEXT", "MP_TMPL_CHECKING", "MP_TMPL_ERR", "getMP_TMPL_ERR$plugin_brandservice_release", "()I", "MP_TMPL_READY", "readFileWebResp", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "fileName", "", "plugin-brandservice_release"})
  public static final class e
  {
    static WebResourceResponse g(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(209989);
      if (!com.tencent.mm.vfs.i.fv(paramString))
      {
        ad.e("MicroMsg.WebViewController", "tmpl file not found:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(209989);
        return null;
      }
      Object localObject1 = com.tencent.mm.sdk.f.d.aNJ(paramString);
      Object localObject2;
      if ((d.n.n.nA(paramString, ".js")) && (com.tencent.mm.plugin.webview.c.i.b(paramWebView)))
      {
        paramWebView = new ag(3, 256, paramWebView);
        paramWebView.bbb(paramString);
        paramWebView = paramWebView.toString();
        localObject2 = StandardCharsets.UTF_8;
        p.g(localObject2, "StandardCharsets.UTF_8");
        if (paramWebView == null)
        {
          paramWebView = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(209989);
          throw paramWebView;
        }
        localObject2 = paramWebView.getBytes((Charset)localObject2);
        p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", (InputStream)new ByteArrayInputStream((byte[])localObject2));
      }
      for (;;)
      {
        localObject2 = new HashMap();
        str = Integer.toHexString(paramString.hashCode() & 0xFFFFFFFF);
        p.g(str, "Integer.toHexString(file…Code() and (-1).ushr(32))");
        if (str != null) {
          break;
        }
        paramWebView = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(209989);
        throw paramWebView;
        try
        {
          paramWebView = (InputStream)new FileInputStream(paramString);
          if (paramWebView == null)
          {
            ad.e("MicroMsg.WebViewController", "stream is null, err");
            AppMethodBeat.o(209989);
            return null;
          }
        }
        catch (FileNotFoundException paramWebView)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.WebViewController", (Throwable)paramWebView, "", new Object[0]);
            paramWebView = null;
          }
          localObject1 = new WebResourceResponse((String)localObject1, "UTF-8", paramWebView);
          paramWebView = null;
        }
      }
      String str = str.toLowerCase();
      p.g(str, "(this as java.lang.String).toLowerCase()");
      ((Map)localObject2).put("Cache-Control", "max-age=31536000");
      ((Map)localObject2).put("ETag", str);
      if (paramWebView != null) {
        ((Map)localObject2).put("RunLocalJS", paramWebView);
      }
      ((WebResourceResponse)localObject1).setResponseHeaders((Map)localObject2);
      ad.i("MicroMsg.WebViewController", "readFileWebResp:%s\nETag:%s", new Object[] { paramString, str });
      AppMethodBeat.o(209989);
      return localObject1;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideReload", "", "url", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "reason", "", "forceRedirect", "reqUrl", "fullUrl", "plugin-brandservice_release"})
  static final class f
    extends com.tencent.mm.plugin.webview.core.j
  {
    private final dnj ohJ;
    private final MMWebView omW;
    
    public f(dnj paramdnj, MMWebView paramMMWebView)
    {
      AppMethodBeat.i(210000);
      this.ohJ = paramdnj;
      this.omW = paramMMWebView;
      AppMethodBeat.o(210000);
    }
    
    public final boolean XR(String paramString)
    {
      AppMethodBeat.i(209998);
      p.h(paramString, "url");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.b((MpWebViewController)localObject1))) && (p.i(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xl(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xl(((MpWebViewController)localObject1).bQm())))) || ((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.bQz())) && (p.i(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xl(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xl(MpWebViewController.c((MpWebViewController)localObject1)))) && (getController().eNs()))))
      {
        localObject2 = ((Iterable)MpWebViewController.d((MpWebViewController)localObject1)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ad.c.g((d.g.a.a)new b((com.tencent.mm.plugin.webview.core.i)((Iterator)localObject2).next()));
        }
        ((BaseWebViewController)localObject1).DGq = true;
        ((MpWebViewController)localObject1).k(MpWebViewController.XQ(paramString), true, 8);
        AppMethodBeat.o(209998);
        return true;
      }
      AppMethodBeat.o(209998);
      return false;
    }
    
    public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(209996);
      p.h(paramString1, "reqUrl");
      p.h(paramString2, "fullUrl");
      if ((paramInt == 0) && (UrlExKt.isMpUrl(paramString2)) && (p.i(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xl(paramString1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.Xl(paramString2))))
      {
        AppMethodBeat.o(209996);
        return true;
      }
      paramBoolean = super.a(paramInt, paramBoolean, paramString1, paramString2);
      AppMethodBeat.o(209996);
      return paramBoolean;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(209997);
      p.h(paramWebView, "webview");
      p.h(paramWebResourceRequest, "request");
      paramWebView = paramWebResourceRequest.getUrl().toString();
      p.g(paramWebView, "request.url.toString()");
      if (((p.i(paramWebView, this.ohJ.DNG) ^ true)) && (!d.n.n.nz(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix())))
      {
        ad.d("MicroMsg.WebViewController", "WebView-Trace intercept return");
        AppMethodBeat.o(209997);
        return null;
      }
      ad.i("MicroMsg.WebViewController", "getResourceResponse, requrl:%s, url:%s", new Object[] { paramWebView, this.ohJ.HBu });
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.ohJ.HBu;
        p.g(paramWebView, "tmplParams.initFilePath");
        paramWebView = new a(paramWebView, false);
      }
      while (paramWebView != null)
      {
        ad.v("MicroMsg.WebViewController", "response path: " + paramWebView.path);
        paramWebResourceRequest = MpWebViewController.omT;
        paramWebResourceRequest = MpWebViewController.e.g((WebView)this.omW, paramWebView.path);
        if (paramWebResourceRequest != null)
        {
          ad.i("MicroMsg.WebViewController", "return intercepted success");
          AppMethodBeat.o(209997);
          return paramWebResourceRequest;
          int i;
          if (d.n.n.nz(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bQi()))
          {
            i = this.ohJ.ojt;
            paramWebResourceRequest = this.ohJ.AFz;
            p.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(r.t(i, paramWebResourceRequest, new d.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bQi()).f(paramWebView, "")), true);
          }
          else if (d.n.n.nz(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()))
          {
            i = this.ohJ.ojt;
            paramWebResourceRequest = this.ohJ.AFz;
            p.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(r.t(i, paramWebResourceRequest, new d.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()).f(paramWebView, "")), true);
          }
          else
          {
            paramWebView = null;
          }
        }
        else
        {
          ad.e("MicroMsg.WebViewController", "return intercepted null");
          com.tencent.mm.plugin.webview.g.a.gi(this.ohJ.reportId, 126);
          if (paramWebView.oiD) {
            com.tencent.mm.plugin.webview.g.a.gi(this.ohJ.reportId, 233);
          }
        }
      }
      AppMethodBeat.o(209997);
      return null;
    }
    
    public final j.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(209999);
      p.h(paramWebView, "webView");
      p.h(paramWebResourceRequest, "request");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (paramWebResourceRequest.isForMainFrame()) && (paramWebResourceRequest.getUrl() != null))
      {
        ad.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url isForMainFrame");
        localObject2 = paramWebResourceRequest.getUrl().toString();
        p.g(localObject2, "request.url.toString()");
        if ((!d.n.n.nz((String)localObject2, "https://mp.weixin.qq.com/__tmpl__/")) && (getController().eNs()))
        {
          ad.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url exitTmpl");
          MpWebViewController.f((MpWebViewController)localObject1);
          ((BaseWebViewController)localObject1).DGq = true;
        }
      }
      paramWebView = super.c(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(209999);
      return paramWebView;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
    public static final class a
    {
      final boolean oiD;
      final String path;
      
      public a(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(209991);
        this.path = paramString;
        this.oiD = paramBoolean;
        AppMethodBeat.o(209991);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(209994);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!p.i(this.path, paramObject.path)) || (this.oiD != paramObject.oiD)) {}
          }
        }
        else
        {
          AppMethodBeat.o(209994);
          return true;
        }
        AppMethodBeat.o(209994);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(209992);
        String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.oiD + ")";
        AppMethodBeat.o(209992);
        return str;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      b(com.tencent.mm.plugin.webview.core.i parami)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    g(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "value", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    j(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(MpWebViewController paramMpWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(210011);
      ad.v(MpWebViewController.e(this.omU), "checkNotifyPageTimer isNotifyPageSuccess=" + this.omU.omF + ", isStopCheckNotifyPage=" + this.omU.omG);
      if ((!this.omU.omF) && (!this.omU.omG))
      {
        com.tencent.mm.plugin.webview.g.a.ma(92);
        this.omU.omo.oiZ = true;
        this.omU.omo.oja = true;
        MpWebViewController.p(this.omU);
        MpWebViewController.b(this.omU, MpWebViewController.bQD());
        ad.e(MpWebViewController.e(this.omU), "check notifyPage timeout");
      }
      AppMethodBeat.o(210011);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$initEnviroment$1", "", "__getString", "", "__log", "", "value", "plugin-brandservice_release"})
  public static final class l
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String __getString()
    {
      AppMethodBeat.i(210013);
      Object localObject1 = MpWebViewController.g(this.omU);
      p.h(localObject1, "$this$getContent");
      Object localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.ojs;
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.bPy(), (String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.vfs.f.ah((e)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      AppMethodBeat.o(210013);
      return localObject1;
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void __log(String paramString)
    {
      AppMethodBeat.i(210012);
      Object localObject = this.omU;
      if (paramString != null)
      {
        paramString = new JSONObject(paramString).getJSONObject("err");
        if (paramString != null)
        {
          int i = paramString.getInt("errCode");
          paramString = paramString.getString("msg");
          String str = ((MpWebViewController)localObject).getTAG();
          StringBuilder localStringBuilder = new StringBuilder("onWebLog:");
          localObject = ((MpWebViewController)localObject).omx;
          if (localObject == null) {
            p.bcb("contentId");
          }
          ad.e(str, (String)localObject + ',' + i + ',' + paramString);
          com.tencent.mm.plugin.webview.g.a.WU(114);
          AppMethodBeat.o(210012);
          return;
        }
      }
      AppMethodBeat.o(210012);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "handleMsg"})
  static final class m
    implements f.a
  {
    m(MpWebViewController paramMpWebViewController) {}
    
    public final boolean b(com.tencent.mm.plugin.webview.c.l paraml)
    {
      AppMethodBeat.i(210014);
      MpWebViewController localMpWebViewController;
      if (p.i(paraml.kYO, "notifyPageInfo"))
      {
        ad.v(MpWebViewController.e(this.omU), "handleMsg " + paraml.kYO);
        localMpWebViewController = this.omU;
        p.g(paraml, "msg");
        MpWebViewController.a(localMpWebViewController, paraml);
        AppMethodBeat.o(210014);
        return true;
      }
      if (p.i(paraml.kYO, "updatePageAuth"))
      {
        ad.v(MpWebViewController.e(this.omU), "handleMsg " + paraml.kYO);
        localMpWebViewController = this.omU;
        p.g(paraml, "msg");
        MpWebViewController.b(localMpWebViewController, paraml);
        AppMethodBeat.o(210014);
        return true;
      }
      AppMethodBeat.o(210014);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  public static final class n
  {
    final boolean oiD;
    final String path;
    
    public n(String paramString)
    {
      AppMethodBeat.i(210015);
      this.path = paramString;
      this.oiD = false;
      AppMethodBeat.o(210015);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(210018);
      if (this != paramObject)
      {
        if ((paramObject instanceof n))
        {
          paramObject = (n)paramObject;
          if ((!p.i(this.path, paramObject.path)) || (this.oiD != paramObject.oiD)) {}
        }
      }
      else
      {
        AppMethodBeat.o(210018);
        return true;
      }
      AppMethodBeat.o(210018);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(210016);
      String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.oiD + ")";
      AppMethodBeat.o(210016);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"getNotifyPageInfoString", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "invoke"})
  static final class o
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.plugin.webview.c.l, String>
  {
    public static final o omY;
    
    static
    {
      AppMethodBeat.i(210021);
      omY = new o();
      AppMethodBeat.o(210021);
    }
    
    o()
    {
      super();
    }
    
    public static String c(com.tencent.mm.plugin.webview.c.l paraml)
    {
      AppMethodBeat.i(210020);
      p.h(paraml, "msg");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("performance", (String)paraml.xaW.get("performance"));
      localJSONObject.put("injectPageDataResult", (String)paraml.xaW.get("injectPageDataResult"));
      paraml = localJSONObject.toString();
      p.g(paraml, "pageInfo.toString()");
      AppMethodBeat.o(210020);
      return paraml;
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController$notifyPageInfo$2", f="MpWebViewController.kt", gfL={425}, m="invokeSuspend")
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class p
    extends d.d.b.a.j
    implements m<ah, d.d.d<? super d.z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    
    p(MpWebViewController paramMpWebViewController, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(210023);
      p.h(paramd, "completion");
      paramd = new p(this.omU, paramd);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(210023);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(210022);
      paramObject = d.d.a.a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(210022);
        throw paramObject;
      case 0: 
        this.nWR = this.nWQ;
        this.label = 1;
        if (at.a(300L, this) == paramObject)
        {
          AppMethodBeat.o(210022);
          return paramObject;
        }
        break;
      }
      MpWebViewController.b(this.omU, MpWebViewController.bQB());
      paramObject = d.z.MKo;
      AppMethodBeat.o(210022);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(210024);
      paramObject1 = ((p)a(paramObject1, (d.d.d)paramObject2)).cQ(d.z.MKo);
      AppMethodBeat.o(210024);
      return paramObject1;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class q
    extends d.g.b.q
    implements d.g.a.q<String, String, List<? extends o<? extends String, ? extends String>>, d.z>
  {
    q(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class r
    extends d.g.b.q
    implements d.g.a.q<String, String, List<? extends o<? extends String, ? extends String>>, d.z>
  {
    r(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "contextRef", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class s
    extends d.g.b.q
    implements d.g.a.q<WeakReference<Object>, k.c, fa, d.z>
  {
    s(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "invoke"})
  static final class t
    extends d.g.b.q
    implements d.g.a.a<cma>
  {
    t(MpWebViewController paramMpWebViewController, MMWebView paramMMWebView)
    {
      super();
    }
    
    private cma bQG()
    {
      AppMethodBeat.i(210029);
      try
      {
        localObject1 = MpWebViewController.m(this.omU);
        localObject3 = e.m.IUT;
        p.g(localObject3, "ConstantsUI.WebViewUI.KTmplSession");
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
        cma localcma;
        for (;;)
        {
          try
          {
            Object localObject3 = cma.class.newInstance();
            ((com.tencent.mm.bx.a)localObject3).parseFrom((byte[])localObject1);
            Object localObject1 = (com.tencent.mm.bx.a)localObject3;
            localObject3 = (cma)localObject1;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = (Throwable)new Resources.NotFoundException("TmplSession");
            AppMethodBeat.o(210029);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException2)
          {
            int i;
            Object localObject2;
            ad.printErrStackTrace("Intent.decodeProtoBuffer", (Throwable)localException2, "decode ProtoBuffer", new Object[0]);
          }
          localException1 = localException1;
          ad.e(MpWebViewController.e(this.omU), "session is null, " + localException1.getMessage() + ' ' + com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ag(MpWebViewController.m(this.omU)));
          com.tencent.mm.plugin.webview.g.a.WU(153);
          com.tencent.mm.plugin.report.service.g.yhR.f(17260, new Object[] { Integer.valueOf(2), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ag(MpWebViewController.m(this.omU)) });
          if ((paramMMWebView.getActivityContextIfHas() instanceof Activity))
          {
            localObject2 = paramMMWebView.getActivityContextIfHas();
            if (localObject2 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(210029);
              throw ((Throwable)localObject2);
              i = 0;
              continue;
              i = 0;
              continue;
              localcma = null;
            }
            else
            {
              ((Activity)localcma).finish();
            }
          }
          else
          {
            localcma = new cma();
          }
        }
        AppMethodBeat.o(210029);
        return localcma;
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class u
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    u(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "value", "", "invoke"})
  static final class v
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    v(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "value", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    w(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "value", "", "invoke"})
  static final class x
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    x(MpWebViewController paramMpWebViewController, long paramLong1, y.a parama, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class y
    implements IPCRunCgi.a
  {
    y(MpWebViewController paramMpWebViewController, String paramString, com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(210034);
      MpWebViewController.h(this.omU).remove(this.ond);
      p.g(paramb, "rr");
      if (!(paramb.aEF() instanceof avj))
      {
        AppMethodBeat.o(210034);
        return;
      }
      paramString = paramb.aEF();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetA8KeyResp");
        AppMethodBeat.o(210034);
        throw paramString;
      }
      paramString = (avj)paramString;
      if (bt.isNullOrNil(paramString.Guc))
      {
        ad.e(MpWebViewController.e(this.omU), "updatePageAuth fail fullurl is null");
        com.tencent.mm.plugin.webview.g.a.ma(82);
        paramString = this.omU.getJsapi();
        if (paramString != null)
        {
          paramString.i(this.one.DNz, this.one.kYO + ":fail", null);
          AppMethodBeat.o(210034);
          return;
        }
        AppMethodBeat.o(210034);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        try
        {
          paramb = new JsapiPermissionWrapper(com.tencent.mm.platformtools.z.a(paramString.Gul));
          Object localObject = new GeneralControlWrapper(paramString.Guf);
          this.omU.lvw.a(paramString.Guc, paramb, (GeneralControlWrapper)localObject);
          paramb = this.omU;
          localObject = this.ond;
          String str = paramString.Guc;
          p.g(str, "resp.FullURL");
          Map localMap = com.tencent.mm.plugin.webview.e.c.gU((List)paramString.GtM);
          p.g(localMap, "LuggageGetA8Key.getHttpHeaders(resp.HttpHeader)");
          MpWebViewController.a(paramb, (String)localObject, str, localMap);
          com.tencent.mm.plugin.webview.g.a.WU(109);
          paramb = (Map)new HashMap();
          paramString = paramString.Guc;
          p.g(paramString, "resp.FullURL");
          paramb.put("fullUrl", paramString);
          ad.i(MpWebViewController.e(this.omU), "updatePageAuth values:%s", new Object[] { paramb });
          com.tencent.mm.plugin.webview.g.a.ma(81);
          paramString = this.omU.getJsapi();
          if (paramString != null)
          {
            paramString.i(this.one.DNz, this.one.kYO + ":ok", paramb);
            AppMethodBeat.o(210034);
            return;
          }
        }
        catch (Exception paramString)
        {
          com.tencent.mm.plugin.webview.g.a.ma(82);
          paramString = this.omU.getJsapi();
          if (paramString != null)
          {
            paramString.i(this.one.DNz, this.one.kYO + ":fail", null);
            AppMethodBeat.o(210034);
            return;
            AppMethodBeat.o(210034);
            return;
          }
          AppMethodBeat.o(210034);
          return;
        }
      }
      com.tencent.mm.plugin.webview.g.a.ma(82);
      paramString = this.omU.getJsapi();
      if (paramString != null)
      {
        paramString.i(this.one.DNz, this.one.kYO + ":fail", null);
        AppMethodBeat.o(210034);
        return;
      }
      AppMethodBeat.o(210034);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController
 * JD-Core Version:    0.7.0.1
 */