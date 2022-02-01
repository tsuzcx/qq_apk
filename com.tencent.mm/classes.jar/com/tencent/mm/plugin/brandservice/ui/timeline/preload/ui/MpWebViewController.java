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
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.protocal.protobuf.fa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ag;
import d.g.a.m;
import d.g.b.p;
import d.g.b.y.a;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "API", "", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "TIMEOUT_TIME", "", "getTIMEOUT_TIME", "()J", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "canFinishProgress", "", "getCanFinishProgress", "()Z", "checkNotifyPageTimer", "Ljava/lang/Runnable;", "contentId", "fullUrl", "gettingA8KeyUrl", "Ljava/util/HashSet;", "injectAPI", "isCheckingInject", "<set-?>", "isInjectDataSuccess", "isNotifyPageSuccess", "setNotifyPageSuccess", "(Z)V", "isStopCheckNotifyPage", "setStopCheckNotifyPage", "isTmplReady", "isUseDataCache", "setUseDataCache", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "getKv15862", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "preloadNext", "getPreloadNext", "setPreloadNext", "rawUrl", "getRawUrl", "receivePageData", "getReceivePageData", "setReceivePageData", "(J)V", "recodeInject", "session", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "getSession", "()Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "session$delegate", "startGetPageData", "getStartGetPageData", "setStartGetPageData", "startLoadPage", "getStartLoadPage", "setStartLoadPage", "adjustInnerWidth", "", "canHandleUrl", "url", "cancelReport", "checkInject", "checkNotifyPage", "getLogAPI", "value", "initEnviroment", "isPageCached", "isSameStart", "intent", "Landroid/content/Intent;", "loadForceUrl", "forceUrl", "fullScreen", "loadTmpl", "modifyForceUrl", "needSyncGetA8Key", "notifyPageInfo", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "pageInfo", "onError", "reason", "", "reqUrl", "errType", "errCode", "errMsg", "onPageFinished", "view", "Lcom/tencent/xweb/WebView;", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onStartLoad", "onWebLog", "processCommonGetA8KeyFullUrl", "httpHeader", "", "processData", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processReport", "setMpUrl", "startAuth", "force", "stopCheckNotifyPage", "tryPreloadNextWebView", "updateAuth", "isSuccess", "updateData", "updateKV", "updatePageAuth", "validCommitUrl", "validStartUrl", "waitForInject", "waitForReady", "Companion", "ForceUrl", "MpWebViewInterceptor", "NotifyAuth", "PreloadNext", "StartPreload", "UpdateData", "plugin-brandservice_release"})
public final class MpWebViewController
  extends com.tencent.mm.plugin.webview.core.h
{
  private static final int osA = -103;
  private static final int osB = -111;
  private static final int osC = -112;
  private static final int osD = -113;
  private static final int osE = -121;
  private static final int osF = -122;
  private static final int osG = -123;
  private static final int osH = -124;
  private static final int osI = -130;
  public static final f osJ;
  private static final int osy = -101;
  static final int osz = -102;
  private final dog onJ;
  private final d.f osd;
  final com.tencent.mm.plugin.brandservice.ui.timeline.preload.g ose;
  private long osf;
  private long osg;
  private long osh;
  private boolean osi;
  private boolean osj;
  private final long osk;
  private final d.f osl;
  private String osm;
  String osn;
  private boolean oso;
  private boolean osp;
  private final String osq;
  private final List<BaseWebViewController.e> osr;
  private final String oss;
  boolean ost;
  private final HashSet<String> osu;
  boolean osv;
  boolean osw;
  private final Runnable osx;
  
  static
  {
    AppMethodBeat.i(209052);
    osJ = new f((byte)0);
    osy = -101;
    osz = -102;
    osA = -103;
    osB = -111;
    osC = -112;
    osD = -113;
    osE = -121;
    osF = -122;
    osG = -123;
    osH = -124;
    osI = -130;
    AppMethodBeat.o(209052);
  }
  
  public MpWebViewController(dog paramdog, final MMWebView paramMMWebView)
  {
    super(paramMMWebView);
    AppMethodBeat.i(209051);
    this.onJ = paramdog;
    this.osd = d.g.O((d.g.a.a)new h(this));
    paramdog = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.g();
    paramdog.a(this.onJ);
    this.ose = paramdog;
    this.osi = true;
    this.osk = 5000L;
    this.osl = d.g.O((d.g.a.a)new u(this, paramMMWebView));
    this.osq = "__tmpl_webview_inject_data";
    if (!(paramMMWebView instanceof a.a)) {}
    for (paramdog = null;; paramdog = paramMMWebView)
    {
      paramdog = (a.a)paramdog;
      if (paramdog != null)
      {
        paramdog.setValidUrlProxy((d.g.a.b)new d(this));
        paramdog.setCurrentUrlProxy((d.g.a.a)new e(this));
      }
      paramdog = super.bRr();
      paramdog.addAll((Collection)d.a.j.listOf(new BaseWebViewController.e[] { new BaseWebViewController.e(d.g.b.z.bp(UpdateData.class), (d.g.a.a)new i((MpWebViewController)this)), new BaseWebViewController.e(d.g.b.z.bp(StartPreload.class), (d.g.a.a)new a(this)), new BaseWebViewController.e(d.g.b.z.bp(PreloadNext.class), (d.g.a.a)new j((MpWebViewController)this)), new BaseWebViewController.e(d.g.b.z.bp(NotifyAuth.class), (d.g.a.a)new b(this)), new BaseWebViewController.e(d.g.b.z.bp(ForceUrl.class), (d.g.a.a)new c(this)) }));
      this.osr = paramdog;
      this.oss = (this.osq + ".__getString()");
      this.osu = new HashSet();
      this.osx = ((Runnable)new l(this));
      AppMethodBeat.o(209051);
      return;
    }
  }
  
  private final void YA(String paramString)
  {
    AppMethodBeat.i(209041);
    this.DXV = paramString;
    aHx(paramString);
    aHy(paramString);
    p.h(paramString, "<set-?>");
    this.cTb = paramString;
    AppMethodBeat.o(209041);
  }
  
  private void YB(String paramString)
  {
    AppMethodBeat.i(209048);
    p.h(paramString, "forceUrl");
    bRv();
    h.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.oph;
    if (h.a.bQs())
    {
      AppMethodBeat.o(209048);
      return;
    }
    eRd();
    this.DYo = true;
    k(YC(paramString), true, 8);
    AppMethodBeat.o(209048);
  }
  
  private static String YC(String paramString)
  {
    AppMethodBeat.i(209050);
    paramString = UrlExKt.appendUrlParam(UrlExKt.clearUrlParam(UrlExKt.clearUrlParam(UrlExKt.clearUrlParam(paramString, "fasttmpl_flag"), "fasttmpl_type"), "fasttmpl_fullversion"), "forceh5", "1");
    AppMethodBeat.o(209050);
    return paramString;
  }
  
  /* Error */
  private final boolean a(com.tencent.mm.plugin.webview.c.l paraml)
  {
    // Byte code:
    //   0: ldc_w 659
    //   3: invokestatic 285	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: getstatic 663	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:osO	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p;
    //   9: astore 10
    //   11: aload_1
    //   12: invokestatic 666	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$p:c	(Lcom/tencent/mm/plugin/webview/c/l;)Ljava/lang/String;
    //   15: astore 10
    //   17: aload_0
    //   18: invokevirtual 521	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   21: ldc_w 668
    //   24: aload 10
    //   26: invokestatic 674	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   29: invokevirtual 677	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 538	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: new 679	org/json/JSONObject
    //   38: dup
    //   39: aload 10
    //   41: invokespecial 680	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 10
    //   46: new 679	org/json/JSONObject
    //   49: dup
    //   50: aload 10
    //   52: ldc_w 682
    //   55: invokevirtual 685	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokespecial 680	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore 11
    //   63: aload 11
    //   65: ldc_w 687
    //   68: invokevirtual 691	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   71: lstore_2
    //   72: aload 11
    //   74: ldc_w 693
    //   77: invokevirtual 691	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   80: lstore 4
    //   82: aload 11
    //   84: ldc_w 695
    //   87: invokevirtual 691	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   90: lstore 6
    //   92: aload 11
    //   94: ldc_w 697
    //   97: invokevirtual 691	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   100: lstore 8
    //   102: aload_0
    //   103: getfield 701	com/tencent/mm/plugin/webview/core/BaseWebViewController:DYj	Lcom/tencent/mm/plugin/webview/j/i;
    //   106: ldc_w 695
    //   109: lload 6
    //   111: invokevirtual 707	com/tencent/mm/plugin/webview/j/i:bM	(Ljava/lang/String;J)V
    //   114: aload_0
    //   115: getfield 701	com/tencent/mm/plugin/webview/core/BaseWebViewController:DYj	Lcom/tencent/mm/plugin/webview/j/i;
    //   118: ldc_w 697
    //   121: lload 8
    //   123: invokevirtual 707	com/tencent/mm/plugin/webview/j/i:bM	(Ljava/lang/String;J)V
    //   126: aload_0
    //   127: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   130: lload_2
    //   131: putfield 710	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:onU	J
    //   134: aload_0
    //   135: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   138: lload 4
    //   140: putfield 713	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:onV	J
    //   143: aload_0
    //   144: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   147: lload 6
    //   149: putfield 716	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:onR	J
    //   152: aload_0
    //   153: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   156: lload 8
    //   158: putfield 719	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:onT	J
    //   161: aload 10
    //   163: ldc_w 721
    //   166: ldc_w 723
    //   169: invokevirtual 725	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: ldc_w 727
    //   175: invokestatic 730	d/g/b/p:i	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   178: ifeq +122 -> 300
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 732	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:osv	Z
    //   186: aload_0
    //   187: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   190: iconst_1
    //   191: putfield 735	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:ooK	Z
    //   194: aload_0
    //   195: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   198: new 65	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$r
    //   201: dup
    //   202: aload_0
    //   203: invokespecial 736	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$r:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;)V
    //   206: checkcast 738	d/g/a/q
    //   209: invokevirtual 741	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:b	(Ld/g/a/q;)V
    //   212: aload_0
    //   213: getfield 331	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:onJ	Lcom/tencent/mm/protocal/protobuf/dog;
    //   216: getfield 543	com/tencent/mm/protocal/protobuf/dog:reportId	I
    //   219: sipush 131
    //   222: invokestatic 551	com/tencent/mm/plugin/webview/g/a:gi	(II)V
    //   225: bipush 108
    //   227: invokestatic 744	com/tencent/mm/plugin/webview/g/a:XA	(I)V
    //   230: aload_0
    //   231: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   234: invokestatic 576	java/lang/System:currentTimeMillis	()J
    //   237: putfield 747	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:ooj	J
    //   240: aload_0
    //   241: invokespecial 632	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bRw	()V
    //   244: aload_0
    //   245: invokespecial 465	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:bRv	()V
    //   248: aload_0
    //   249: invokevirtual 751	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   252: aload_1
    //   253: getfield 756	com/tencent/mm/plugin/webview/c/l:Efy	Ljava/lang/String;
    //   256: ldc_w 758
    //   259: aconst_null
    //   260: invokevirtual 762	com/tencent/mm/plugin/webview/c/f:i	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   263: bipush 90
    //   265: invokestatic 765	com/tencent/mm/plugin/webview/g/a:md	(I)V
    //   268: getstatic 771	kotlinx/coroutines/bk:OfO	Lkotlinx/coroutines/bk;
    //   271: checkcast 773	kotlinx/coroutines/ah
    //   274: aconst_null
    //   275: new 63	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q
    //   278: dup
    //   279: aload_0
    //   280: aconst_null
    //   281: invokespecial 776	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$q:<init>	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;Ld/d/d;)V
    //   284: checkcast 778	d/g/a/m
    //   287: iconst_3
    //   288: invokestatic 783	kotlinx/coroutines/f:b	(Lkotlinx/coroutines/ah;Ld/d/f;Ld/g/a/m;I)Lkotlinx/coroutines/br;
    //   291: pop
    //   292: ldc_w 659
    //   295: invokestatic 315	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: iconst_1
    //   299: ireturn
    //   300: aload_0
    //   301: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   304: iconst_1
    //   305: putfield 629	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:ooZ	Z
    //   308: aload_0
    //   309: getstatic 311	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:osH	I
    //   312: invokevirtual 786	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:WY	(I)V
    //   315: aload_0
    //   316: invokevirtual 521	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   319: ldc_w 788
    //   322: invokestatic 538	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: goto -95 -> 230
    //   328: astore 10
    //   330: aload_0
    //   331: invokevirtual 521	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   334: aload 10
    //   336: checkcast 790	java/lang/Throwable
    //   339: ldc_w 791
    //   342: iconst_0
    //   343: anewarray 793	java/lang/Object
    //   346: invokestatic 797	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: getfield 353	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:ose	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/g;
    //   353: iconst_1
    //   354: putfield 629	com/tencent/mm/plugin/brandservice/ui/timeline/preload/g:ooZ	Z
    //   357: aload_0
    //   358: getstatic 311	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:osH	I
    //   361: invokevirtual 786	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:WY	(I)V
    //   364: goto -134 -> 230
    //   367: astore 10
    //   369: aload_0
    //   370: invokevirtual 521	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   373: aload 10
    //   375: checkcast 790	java/lang/Throwable
    //   378: ldc_w 798
    //   381: iconst_0
    //   382: anewarray 793	java/lang/Object
    //   385: invokestatic 797	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: aload_0
    //   389: invokevirtual 751	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getJsapi	()Lcom/tencent/mm/plugin/webview/c/f;
    //   392: aload_1
    //   393: getfield 756	com/tencent/mm/plugin/webview/c/l:Efy	Ljava/lang/String;
    //   396: ldc_w 800
    //   399: aconst_null
    //   400: invokevirtual 762	com/tencent/mm/plugin/webview/c/f:i	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   403: bipush 91
    //   405: invokestatic 765	com/tencent/mm/plugin/webview/g/a:md	(I)V
    //   408: ldc_w 659
    //   411: invokestatic 315	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: iconst_0
    //   415: ireturn
    //   416: astore 10
    //   418: aload_0
    //   419: invokevirtual 521	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:getTAG	()Ljava/lang/String;
    //   422: aload 10
    //   424: checkcast 790	java/lang/Throwable
    //   427: ldc_w 798
    //   430: iconst_0
    //   431: anewarray 793	java/lang/Object
    //   434: invokestatic 797	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private cmu bRm()
  {
    AppMethodBeat.i(209025);
    cmu localcmu = (cmu)this.osl.getValue();
    AppMethodBeat.o(209025);
    return localcmu;
  }
  
  private final void bRv()
  {
    AppMethodBeat.i(209039);
    ae.d(getTAG(), "stopCheckNotifyPage");
    aPI().removeCallbacks(this.osx);
    this.osw = true;
    AppMethodBeat.o(209039);
  }
  
  private final void bRw()
  {
    AppMethodBeat.i(209040);
    ae.v(getTAG(), "terry trace updateKV");
    this.ose.ooe = this.DYj.bN("onInjectStart", 0L);
    this.ose.oof = this.DYj.bN("onInjectEnd", 0L);
    this.ose.ooh = this.DYj.bN("onTmplLoadStart", 0L);
    this.ose.ooi = this.DYj.bN("onTmplLoadEnd", 0L);
    this.ose.ooc = this.DYj.bN("onCreateStart", 0L);
    this.ose.ood = this.DYj.bN("onCreateEnd", 0L);
    this.ose.ooA = this.ost;
    this.ose.oog = this.DYj.bN("onWebInjectEnd", 0L);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.g localg = this.ose;
    String str = this.osM.getRandomStr();
    p.g(str, "viewWV.randomStr");
    localg.setKey(str);
    this.ose.ooB = WZ(osz);
    AppMethodBeat.o(209040);
  }
  
  private final void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(209047);
    ae.i(getTAG(), "[updatePageAuth]reqUrl:" + paramString1 + " fullUrl:" + paramString2 + " httpHeader:" + paramMap);
    paramString1 = this.osM.getSettings();
    p.g(paramString1, "viewWV.settings");
    paramString1 = paramString1.getUserAgentString();
    p.g(paramString1, "viewWV.settings.userAgentString");
    paramMap.put("User-agent", paramString1);
    getJsapi().aHZ(new JSONObject(paramMap).toString());
    paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
    getJsapi().aHY(paramString1);
    AppMethodBeat.o(209047);
  }
  
  private void s(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(209042);
    p.h(paramString, "contentId");
    ae.v(getTAG(), "[updateData] " + bRn());
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.Yj(bRn());
    YA(bRn());
    this.osn = paramString;
    this.osf = paramLong1;
    this.osh = paramLong2;
    WY(osB);
    AppMethodBeat.o(209042);
  }
  
  public final boolean Yx(String paramString)
  {
    AppMethodBeat.i(209032);
    p.h(paramString, "url");
    if ((super.Yy(paramString)) && ((p.i(paramString, this.onJ.EfF) ^ true)))
    {
      AppMethodBeat.o(209032);
      return true;
    }
    AppMethodBeat.o(209032);
    return false;
  }
  
  public final boolean Yy(String paramString)
  {
    AppMethodBeat.i(209033);
    p.h(paramString, "url");
    if ((super.Yy(paramString)) && ((p.i(paramString, this.onJ.EfF) ^ true)))
    {
      AppMethodBeat.o(209033);
      return true;
    }
    AppMethodBeat.o(209033);
    return false;
  }
  
  public final boolean Yz(String paramString)
  {
    AppMethodBeat.i(209035);
    boolean bool = p.i(paramString, this.onJ.EfF);
    AppMethodBeat.o(209035);
    return bool;
  }
  
  public final void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(209046);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "errMsg");
    super.a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
    if (paramInt1 == 0)
    {
      this.osm = paramString1;
      WY(osF);
    }
    AppMethodBeat.o(209046);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, avz paramavz)
  {
    AppMethodBeat.i(209043);
    p.h(paramString1, "reqUrl");
    p.h(paramString2, "fullUrl");
    p.h(paramavz, "response");
    if (paramInt == 0) {
      YA(paramString2);
    }
    super.a(paramInt, paramString1, paramString2, paramavz);
    if (paramInt == 0)
    {
      this.osm = paramString2;
      paramavz = com.tencent.mm.plugin.webview.e.c.he((List)paramavz.GNl);
      p.g(paramavz, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
      com.tencent.mm.plugin.webview.g.a.gi(this.onJ.reportId, 117);
      this.ose.oob = System.currentTimeMillis();
      this.ose.ooJ = true;
      bRw();
      this.ose.b((d.g.a.q)new s(this));
      c(paramString1, paramString2, paramavz);
      WY(osE);
    }
    AppMethodBeat.o(209043);
  }
  
  public final boolean aI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(209036);
    p.h(paramString, "url");
    if (((p.i(paramString, this.onJ.EfF) ^ true)) && (super.aI(paramString, paramBoolean)))
    {
      AppMethodBeat.o(209036);
      return true;
    }
    AppMethodBeat.o(209036);
    return false;
  }
  
  public final boolean ah(Intent paramIntent)
  {
    AppMethodBeat.i(209027);
    p.h(paramIntent, "intent");
    if (this.DYa)
    {
      paramIntent = paramIntent.getStringExtra("rawUrl");
      p.g(paramIntent, "intent.getStringExtra(Co…antsUI.WebViewUI.KRawUrl)");
      if (p.i(d.n.n.bq(paramIntent, "http://", "https://"), bRn()))
      {
        AppMethodBeat.o(209027);
        return true;
      }
    }
    AppMethodBeat.o(209027);
    return false;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(209037);
    super.b(paramWebView, paramString);
    if (p.i(paramString, this.onJ.EfF))
    {
      if ((WZ(osz)) || (WZ(osy)))
      {
        AppMethodBeat.o(209037);
        return;
      }
      ae.i(getTAG(), "checkInject start");
      com.tencent.mm.plugin.webview.g.a.gi(this.onJ.reportId, 113);
      h("JSON.stringify(window.__appmsg_skeleton_success__)", (d.g.a.b)new k(this));
      int i = com.tencent.mm.cb.a.iu(this.osM.getContext());
      float f = com.tencent.mm.cb.a.getDensity(this.osM.getContext());
      ae.i(getTAG(), "adjustInnerWidth() screenWidth:" + i + ", density:" + f);
      if ((i > 0) && (f > 0.0F))
      {
        i = (int)(i / f);
        ae.i(getTAG(), "adjustInnerWidth() innerWidth:".concat(String.valueOf(i)));
        h("window.innerWidth = ".concat(String.valueOf(i)), null);
      }
      ae.i(getTAG(), "[onPageReady]");
    }
    AppMethodBeat.o(209037);
  }
  
  public final String bRn()
  {
    AppMethodBeat.i(209026);
    String str = d.n.n.bq(BaseWebViewController.b.aY(getIntent()), "http://", "https://");
    AppMethodBeat.o(209026);
    return str;
  }
  
  public final boolean bRo()
  {
    AppMethodBeat.i(209028);
    if ((WZ(osC)) || (WZ(osD)))
    {
      AppMethodBeat.o(209028);
      return true;
    }
    AppMethodBeat.o(209028);
    return false;
  }
  
  public final boolean bRp()
  {
    AppMethodBeat.i(209029);
    if ((WZ(this.DYu)) && (WZ(osz)))
    {
      AppMethodBeat.o(209029);
      return true;
    }
    AppMethodBeat.o(209029);
    return false;
  }
  
  public final boolean bRq()
  {
    AppMethodBeat.i(209030);
    if ((eQY()) && (WZ(osE)))
    {
      AppMethodBeat.o(209030);
      return true;
    }
    AppMethodBeat.o(209030);
    return false;
  }
  
  public final List<BaseWebViewController.e> bRr()
  {
    return this.osr;
  }
  
  public final void bRs()
  {
    AppMethodBeat.i(209031);
    a((com.tencent.mm.plugin.webview.core.j)new g(this.onJ, this.osM));
    super.bRs();
    this.osM.addJavascriptInterface(new m(this), this.osq);
    getJsapi().eSh();
    getJsapi().a((f.a)new n(this));
    String str = this.onJ.EfF;
    ae.i(getTAG(), "WebView-Trace loadTmpl getResourceResponse, requrl:%s, url:%s", new Object[] { str, this.onJ.HVh });
    Object localObject = this.onJ.HVh;
    p.g(localObject, "tmplParams.initFilePath");
    localObject = new o((String)localObject);
    ae.v(getTAG(), "response path:" + bu.bI(((o)localObject).path, "null"));
    if (f.g((WebView)this.osM, ((o)localObject).path) != null)
    {
      ae.i(getTAG(), "return intercepted success");
      WY(this.DYv);
      this.osM.loadUrl(str);
      WY(this.DYu);
      AppMethodBeat.o(209031);
      return;
    }
    ae.e(getTAG(), "return intercepted null");
    com.tencent.mm.plugin.webview.g.a.gi(this.onJ.reportId, 126);
    if (((o)localObject).ooD) {
      com.tencent.mm.plugin.webview.g.a.gi(this.onJ.reportId, 233);
    }
    AppMethodBeat.o(209031);
  }
  
  public final void bRt()
  {
    int j = 1;
    AppMethodBeat.i(209034);
    ae.i(getTAG(), "onStartLoad");
    Object localObject1 = getIntent();
    p.h(localObject1, "intent");
    ae.v(getTAG(), "processData");
    setIntent((Intent)localObject1);
    this.osg = System.currentTimeMillis();
    this.osi = ((Intent)localObject1).getBooleanExtra(e.m.Jpq, true);
    this.osf = ((Intent)localObject1).getLongExtra(e.m.Jpr, 0L);
    Object localObject2 = com.tencent.mm.kernel.g.ajO().ajq();
    p.g(localObject2, "MMKernel.process().current()");
    localObject2 = ((com.tencent.mm.kernel.b.h)localObject2).akK();
    String str = ((Intent)localObject1).getStringExtra(e.m.Jpt);
    if ((((Intent)localObject1).getStringExtra("rawUrl") == null) || (str == null))
    {
      ae.e(getTAG(), "rawUrl is null, " + com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ag((Intent)localObject1));
      com.tencent.mm.plugin.webview.g.a.XA(151);
      com.tencent.mm.plugin.report.service.g.yxI.f(17260, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ag((Intent)localObject1) });
      i = 0;
      if (i == 0)
      {
        onFinish();
        AppMethodBeat.o(209034);
      }
    }
    else
    {
      com.tencent.mm.plugin.brandservice.ui.timeline.preload.g localg = this.ose;
      if (((g.a)localObject2).gGK < this.osf)
      {
        bool = true;
        label233:
        localg.ooH = bool;
        if (!this.ose.ooH) {
          break label541;
        }
        i = 104;
        label252:
        com.tencent.mm.plugin.webview.g.a.XA(i);
        switch (s.a(((Intent)localObject1).getIntExtra(e.m.Jpy, -1), this.osf, Process.myPid(), ((g.a)localObject2).gGC))
        {
        }
      }
      for (;;)
      {
        this.ose.ooD = bRm().HyM;
        this.ose.ooE = bRm().HyN;
        this.ose.ooF = com.tencent.mm.plugin.webview.c.i.b((WebView)this.osM);
        this.ose.ooG = bRm().ooG;
        this.ose.oop = ((g.a)localObject2).gGC;
        this.ose.ooq = ((g.a)localObject2).gGD;
        this.ose.oor = ((g.a)localObject2).gGE;
        this.ose.oos = ((g.a)localObject2).gGF;
        this.ose.oot = ((g.a)localObject2).gGG;
        this.ose.oou = ((g.a)localObject2).gGH;
        this.ose.oov = ((g.a)localObject2).gGI;
        this.ose.oow = ((g.a)localObject2).gGJ;
        this.ose.oox = ((g.a)localObject2).gGK;
        this.ose.onQ = this.osf;
        this.ose.onW = this.osg;
        this.ose.obQ = bRm().obQ;
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.ops.a(this, str, bRm(), (d.g.a.q)new t(this));
        i = j;
        break;
        bool = false;
        break label233;
        label541:
        i = 103;
        break label252;
        this.ose.ooI = 1;
        this.osf = ((g.a)localObject2).gGC;
        continue;
        this.ose.ooI = 2;
        this.osf = -1L;
      }
    }
    this.ose.a(this.onJ);
    localObject1 = this.ose;
    localObject2 = bRn();
    p.h(localObject2, "<set-?>");
    ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.g)localObject1).url = ((String)localObject2);
    boolean bool = WZ(osz);
    this.ose.ooz = bool;
    this.ose.ooy = this.osj;
    this.ose.ooX = this.osM.getWebCoreType().name();
    if (bool) {}
    for (int i = 106;; i = 105)
    {
      com.tencent.mm.plugin.webview.g.a.XA(i);
      BaseWebViewController.a(this, bRn());
      if (!this.osv)
      {
        bRv();
        ae.i(getTAG(), "check notifyPage");
        this.osw = false;
        aPI().postUIDelayed(this.osx, this.osk);
      }
      AppMethodBeat.o(209034);
      return;
    }
  }
  
  public final boolean bRu()
  {
    return false;
  }
  
  public final boolean bRx()
  {
    AppMethodBeat.i(209045);
    boolean bool = WZ(this.DYu);
    AppMethodBeat.o(209045);
    return bool;
  }
  
  final String getTAG()
  {
    AppMethodBeat.i(209024);
    String str = (String)this.osd.getValue();
    AppMethodBeat.o(209024);
    return str;
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$ForceUrl;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class ForceUrl
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(208979);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(208979);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      MpWebViewController.f localf = MpWebViewController.osJ;
      if (((waitFor(MpWebViewController.bRG())) || (waitFor(MpWebViewController.bRD())) || (waitFor(MpWebViewController.bRE()))) && (waitFor(MpWebViewController.b((MpWebViewController)localObject))))
      {
        AppMethodBeat.o(208979);
        return true;
      }
      AppMethodBeat.o(208979);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$NotifyAuth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class NotifyAuth
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(208990);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(208990);
        throw ((Throwable)localObject);
      }
      localObject = (MpWebViewController)localObject;
      if ((waitFor(MpWebViewController.bRy())) && (((waitFor(MpWebViewController.a((MpWebViewController)localObject))) && (waitFor(MpWebViewController.bRA()))) || (waitFor(MpWebViewController.bRB()))))
      {
        AppMethodBeat.o(208990);
        return true;
      }
      AppMethodBeat.o(208990);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$PreloadNext;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class PreloadNext
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(208991);
      if (getController() == null)
      {
        v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(208991);
        throw localv;
      }
      boolean bool = waitFor(MpWebViewController.bRC());
      AppMethodBeat.o(208991);
      return bool;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$StartPreload;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class StartPreload
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(208992);
      Object localObject = getController();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(208992);
        throw ((Throwable)localObject);
      }
      boolean bool = waitFor(MpWebViewController.b((MpWebViewController)localObject));
      AppMethodBeat.o(208992);
      return bool;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$UpdateData;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "plugin-brandservice_release"})
  @Keep
  protected static final class UpdateData
    extends BaseWebViewController.ControllerAction
  {
    public final boolean verify()
    {
      AppMethodBeat.i(208994);
      if (getController() == null)
      {
        v localv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController");
        AppMethodBeat.o(208994);
        throw localv;
      }
      if ((waitFor(MpWebViewController.bRy())) && (waitFor(MpWebViewController.bRz())))
      {
        AppMethodBeat.o(208994);
        return true;
      }
      AppMethodBeat.o(208994);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$2"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    a(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$4"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    b(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$actionsCheckList$1$5"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<d.z>
  {
    c(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$1"})
  static final class d
    extends d.g.b.q
    implements d.g.a.b<String, Boolean>
  {
    d(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$1$2"})
  static final class e
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    e(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$Companion;", "", "()V", "MP_AUTH_ERR", "", "MP_AUTH_NOTIFIED", "MP_AUTH_SUCC", "MP_DATA_INJECT_ERR", "MP_DATA_INJECT_SUCC", "MP_DATA_READY", "MP_NOTIFY_ERR", "MP_PRELOAD_NEXT", "MP_TMPL_CHECKING", "MP_TMPL_ERR", "getMP_TMPL_ERR$plugin_brandservice_release", "()I", "MP_TMPL_READY", "readFileWebResp", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "fileName", "", "plugin-brandservice_release"})
  public static final class f
  {
    static WebResourceResponse g(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(208978);
      if (!com.tencent.mm.vfs.o.fB(paramString))
      {
        ae.e("MicroMsg.WebViewController", "tmpl file not found:".concat(String.valueOf(paramString)));
        AppMethodBeat.o(208978);
        return null;
      }
      Object localObject1 = com.tencent.mm.sdk.f.d.aPg(paramString);
      Object localObject2;
      if ((d.n.n.nG(paramString, ".js")) && (com.tencent.mm.plugin.webview.c.i.b(paramWebView)))
      {
        paramWebView = new ag(3, 256, paramWebView);
        paramWebView.bcE(paramString);
        paramWebView = paramWebView.toString();
        localObject2 = StandardCharsets.UTF_8;
        p.g(localObject2, "StandardCharsets.UTF_8");
        if (paramWebView == null)
        {
          paramWebView = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(208978);
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
        AppMethodBeat.o(208978);
        throw paramWebView;
        try
        {
          paramWebView = (InputStream)new FileInputStream(paramString);
          if (paramWebView == null)
          {
            ae.e("MicroMsg.WebViewController", "stream is null, err");
            AppMethodBeat.o(208978);
            return null;
          }
        }
        catch (FileNotFoundException paramWebView)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.WebViewController", (Throwable)paramWebView, "", new Object[0]);
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
      ae.i("MicroMsg.WebViewController", "readFileWebResp:%s\nETag:%s", new Object[] { paramString, str });
      AppMethodBeat.o(208978);
      return localObject1;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "(Lcom/tencent/mm/protocal/protobuf/TmplParams;Lcom/tencent/mm/ui/widget/MMWebView;)V", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "overrideReload", "", "url", "", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "reason", "", "forceRedirect", "reqUrl", "fullUrl", "plugin-brandservice_release"})
  static final class g
    extends com.tencent.mm.plugin.webview.core.j
  {
    private final dog onJ;
    private final MMWebView osM;
    
    public g(dog paramdog, MMWebView paramMMWebView)
    {
      AppMethodBeat.i(208989);
      this.onJ = paramdog;
      this.osM = paramMMWebView;
      AppMethodBeat.o(208989);
    }
    
    public final boolean YE(String paramString)
    {
      AppMethodBeat.i(208987);
      p.h(paramString, "url");
      Object localObject2 = getController();
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof MpWebViewController)) {
        localObject1 = null;
      }
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && (((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.b((MpWebViewController)localObject1))) && (p.i(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XX(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XX(((MpWebViewController)localObject1).bRn())))) || ((MpWebViewController.a((MpWebViewController)localObject1, MpWebViewController.bRA())) && (p.i(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XX(paramString), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XX(MpWebViewController.c((MpWebViewController)localObject1)))) && (getController().eRd()))))
      {
        localObject2 = ((Iterable)MpWebViewController.d((MpWebViewController)localObject1)).iterator();
        while (((Iterator)localObject2).hasNext()) {
          com.tencent.mm.ac.c.h((d.g.a.a)new b((com.tencent.mm.plugin.webview.core.i)((Iterator)localObject2).next()));
        }
        ((BaseWebViewController)localObject1).DYo = true;
        ((MpWebViewController)localObject1).k(MpWebViewController.YD(paramString), true, 8);
        AppMethodBeat.o(208987);
        return true;
      }
      AppMethodBeat.o(208987);
      return false;
    }
    
    public final boolean a(int paramInt, boolean paramBoolean, String paramString1, String paramString2)
    {
      AppMethodBeat.i(208985);
      p.h(paramString1, "reqUrl");
      p.h(paramString2, "fullUrl");
      if ((paramInt == 0) && (UrlExKt.isMpUrl(paramString2)) && (p.i(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XX(paramString1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.XX(paramString2))))
      {
        AppMethodBeat.o(208985);
        return true;
      }
      paramBoolean = super.a(paramInt, paramBoolean, paramString1, paramString2);
      AppMethodBeat.o(208985);
      return paramBoolean;
    }
    
    public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(208986);
      p.h(paramWebView, "webview");
      p.h(paramWebResourceRequest, "request");
      paramWebView = paramWebResourceRequest.getUrl().toString();
      p.g(paramWebView, "request.url.toString()");
      if (((p.i(paramWebView, this.onJ.EfF) ^ true)) && (!d.n.n.nF(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix())))
      {
        ae.d("MicroMsg.WebViewController", "WebView-Trace intercept return");
        AppMethodBeat.o(208986);
        return null;
      }
      ae.i("MicroMsg.WebViewController", "getResourceResponse, requrl:%s, url:%s", new Object[] { paramWebView, this.onJ.HVh });
      if (paramWebResourceRequest.isForMainFrame())
      {
        paramWebView = this.onJ.HVh;
        p.g(paramWebView, "tmplParams.initFilePath");
        paramWebView = new a(paramWebView, false);
      }
      while (paramWebView != null)
      {
        ae.v("MicroMsg.WebViewController", "response path: " + paramWebView.path);
        paramWebResourceRequest = MpWebViewController.osJ;
        paramWebResourceRequest = MpWebViewController.f.g((WebView)this.osM, paramWebView.path);
        if (paramWebResourceRequest != null)
        {
          ae.i("MicroMsg.WebViewController", "return intercepted success");
          AppMethodBeat.o(208986);
          return paramWebResourceRequest;
          int i;
          if (d.n.n.nF(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bRj()))
          {
            i = this.onJ.opt;
            paramWebResourceRequest = this.onJ.AXc;
            p.g(paramWebResourceRequest, "tmplParams.uid");
            paramWebView = (CharSequence)paramWebView;
            paramWebView = new a(r.t(i, paramWebResourceRequest, new d.n.k(com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bRj()).f(paramWebView, "")), true);
          }
          else if (d.n.n.nF(paramWebView, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix()))
          {
            i = this.onJ.opt;
            paramWebResourceRequest = this.onJ.AXc;
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
          ae.e("MicroMsg.WebViewController", "return intercepted null");
          com.tencent.mm.plugin.webview.g.a.gi(this.onJ.reportId, 126);
          if (paramWebView.ooD) {
            com.tencent.mm.plugin.webview.g.a.gi(this.onJ.reportId, 233);
          }
        }
      }
      AppMethodBeat.o(208986);
      return null;
    }
    
    public final j.a c(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      AppMethodBeat.i(208988);
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
        ae.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url isForMainFrame");
        localObject2 = paramWebResourceRequest.getUrl().toString();
        p.g(localObject2, "request.url.toString()");
        if ((!d.n.n.nF((String)localObject2, "https://mp.weixin.qq.com/__tmpl__/")) && (getController().eRd()))
        {
          ae.i(MpWebViewController.e((MpWebViewController)localObject1), "edw opt, shouldOverride url exitTmpl");
          MpWebViewController.f((MpWebViewController)localObject1);
          ((BaseWebViewController)localObject1).DYo = true;
        }
      }
      paramWebView = super.c(paramWebView, paramWebResourceRequest);
      AppMethodBeat.o(208988);
      return paramWebView;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$MpWebViewInterceptor$intercept$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
    public static final class a
    {
      final boolean ooD;
      final String path;
      
      public a(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(208980);
        this.path = paramString;
        this.ooD = paramBoolean;
        AppMethodBeat.o(208980);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(208983);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if ((!p.i(this.path, paramObject.path)) || (this.ooD != paramObject.ooD)) {}
          }
        }
        else
        {
          AppMethodBeat.o(208983);
          return true;
        }
        AppMethodBeat.o(208983);
        return false;
      }
      
      public final int hashCode()
      {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
      }
      
      public final String toString()
      {
        AppMethodBeat.i(208981);
        String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.ooD + ")";
        AppMethodBeat.o(208981);
        return str;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.a<String>
  {
    h(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "value", "", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    k(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(MpWebViewController paramMpWebViewController) {}
    
    public final void run()
    {
      AppMethodBeat.i(209000);
      ae.v(MpWebViewController.e(this.osK), "checkNotifyPageTimer isNotifyPageSuccess=" + this.osK.osv + ", isStopCheckNotifyPage=" + this.osK.osw);
      if ((!this.osK.osv) && (!this.osK.osw))
      {
        com.tencent.mm.plugin.webview.g.a.md(92);
        this.osK.ose.ooZ = true;
        this.osK.ose.opa = true;
        MpWebViewController.p(this.osK);
        MpWebViewController.b(this.osK, MpWebViewController.bRE());
        ae.e(MpWebViewController.e(this.osK), "check notifyPage timeout");
      }
      AppMethodBeat.o(209000);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$initEnviroment$1", "", "__getString", "", "__log", "", "value", "plugin-brandservice_release"})
  public static final class m
  {
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String __getString()
    {
      AppMethodBeat.i(209002);
      Object localObject1 = MpWebViewController.g(this.osK);
      p.h(localObject1, "$this$getContent");
      Object localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.ops;
      localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b(com.tencent.mm.plugin.brandservice.ui.timeline.preload.k.bQw(), (String)localObject1);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.vfs.l.ah((com.tencent.mm.vfs.k)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = "";
      }
      AppMethodBeat.o(209002);
      return localObject1;
    }
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void __log(String paramString)
    {
      AppMethodBeat.i(209001);
      Object localObject = this.osK;
      if (paramString != null)
      {
        paramString = new JSONObject(paramString).getJSONObject("err");
        if (paramString != null)
        {
          int i = paramString.getInt("errCode");
          paramString = paramString.getString("msg");
          String str = ((MpWebViewController)localObject).getTAG();
          StringBuilder localStringBuilder = new StringBuilder("onWebLog:");
          localObject = ((MpWebViewController)localObject).osn;
          if (localObject == null) {
            p.bdF("contentId");
          }
          ae.e(str, (String)localObject + ',' + i + ',' + paramString);
          com.tencent.mm.plugin.webview.g.a.XA(114);
          AppMethodBeat.o(209001);
          return;
        }
      }
      AppMethodBeat.o(209001);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/protocal/JsapiPermissionWrapper;", "handleMsg"})
  static final class n
    implements f.a
  {
    n(MpWebViewController paramMpWebViewController) {}
    
    public final boolean b(com.tencent.mm.plugin.webview.c.l paraml)
    {
      AppMethodBeat.i(209003);
      MpWebViewController localMpWebViewController;
      if (p.i(paraml.lcx, "notifyPageInfo"))
      {
        ae.v(MpWebViewController.e(this.osK), "handleMsg " + paraml.lcx);
        localMpWebViewController = this.osK;
        p.g(paraml, "msg");
        MpWebViewController.a(localMpWebViewController, paraml);
        AppMethodBeat.o(209003);
        return true;
      }
      if (p.i(paraml.lcx, "updatePageAuth"))
      {
        ae.v(MpWebViewController.e(this.osK), "handleMsg " + paraml.lcx);
        localMpWebViewController = this.osK;
        p.g(paraml, "msg");
        MpWebViewController.b(localMpWebViewController, paraml);
        AppMethodBeat.o(209003);
        return true;
      }
      AppMethodBeat.o(209003);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo", "", "path", "", "isZip", "", "(Ljava/lang/String;Z)V", "()Z", "getPath", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Z)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController$loadTmpl$InterceptInfo;", "equals", "other", "hashCode", "", "toString", "plugin-brandservice_release"})
  public static final class o
  {
    final boolean ooD;
    final String path;
    
    public o(String paramString)
    {
      AppMethodBeat.i(209004);
      this.path = paramString;
      this.ooD = false;
      AppMethodBeat.o(209004);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(209007);
      if (this != paramObject)
      {
        if ((paramObject instanceof o))
        {
          paramObject = (o)paramObject;
          if ((!p.i(this.path, paramObject.path)) || (this.ooD != paramObject.ooD)) {}
        }
      }
      else
      {
        AppMethodBeat.o(209007);
        return true;
      }
      AppMethodBeat.o(209007);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(209005);
      String str = "InterceptInfo(path=" + this.path + ", isZip=" + this.ooD + ")";
      AppMethodBeat.o(209005);
      return str;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"getNotifyPageInfoString", "", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "invoke"})
  static final class p
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.plugin.webview.c.l, String>
  {
    public static final p osO;
    
    static
    {
      AppMethodBeat.i(209010);
      osO = new p();
      AppMethodBeat.o(209010);
    }
    
    p()
    {
      super();
    }
    
    public static String c(com.tencent.mm.plugin.webview.c.l paraml)
    {
      AppMethodBeat.i(209009);
      p.h(paraml, "msg");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("performance", (String)paraml.xqN.get("performance"));
      localJSONObject.put("injectPageDataResult", (String)paraml.xqN.get("injectPageDataResult"));
      paraml = localJSONObject.toString();
      p.g(paraml, "pageInfo.toString()");
      AppMethodBeat.o(209009);
      return paraml;
    }
  }
  
  @d.d.b.a.f(c="com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController$notifyPageInfo$2", f="MpWebViewController.kt", gkn={432}, m="invokeSuspend")
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class q
    extends d.d.b.a.j
    implements m<ah, d.d.d<? super d.z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    
    q(MpWebViewController paramMpWebViewController, d.d.d paramd)
    {
      super();
    }
    
    public final d.d.d<d.z> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(209012);
      p.h(paramd, "completion");
      paramd = new q(this.osK, paramd);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(209012);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(209011);
      paramObject = d.d.a.a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(209011);
        throw paramObject;
      case 0: 
        this.ocA = this.ocz;
        this.label = 1;
        if (at.a(300L, this) == paramObject)
        {
          AppMethodBeat.o(209011);
          return paramObject;
        }
        break;
      }
      MpWebViewController.b(this.osK, MpWebViewController.bRC());
      paramObject = d.z.Nhr;
      AppMethodBeat.o(209011);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(209013);
      paramObject1 = ((q)a(paramObject1, (d.d.d)paramObject2)).cR(d.z.Nhr);
      AppMethodBeat.o(209013);
      return paramObject1;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class r
    extends d.g.b.q
    implements d.g.a.q<String, String, List<? extends d.o<? extends String, ? extends String>>, d.z>
  {
    r(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "titles", "", "data", "performance", "", "Lkotlin/Pair;", "invoke"})
  static final class s
    extends d.g.b.q
    implements d.g.a.q<String, String, List<? extends d.o<? extends String, ? extends String>>, d.z>
  {
    s(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "contextRef", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class t
    extends d.g.b.q
    implements d.g.a.q<WeakReference<Object>, k.c, fa, d.z>
  {
    t(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/PreloadSession;", "invoke"})
  static final class u
    extends d.g.b.q
    implements d.g.a.a<cmu>
  {
    u(MpWebViewController paramMpWebViewController, MMWebView paramMMWebView)
    {
      super();
    }
    
    private cmu bRH()
    {
      AppMethodBeat.i(209018);
      try
      {
        localObject1 = MpWebViewController.m(this.osK);
        localObject3 = e.m.JpB;
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
        cmu localcmu;
        for (;;)
        {
          try
          {
            Object localObject3 = cmu.class.newInstance();
            ((com.tencent.mm.bw.a)localObject3).parseFrom((byte[])localObject1);
            Object localObject1 = (com.tencent.mm.bw.a)localObject3;
            localObject3 = (cmu)localObject1;
            localObject1 = localObject3;
            if (localObject3 != null) {
              break;
            }
            localObject1 = (Throwable)new Resources.NotFoundException("TmplSession");
            AppMethodBeat.o(209018);
            throw ((Throwable)localObject1);
          }
          catch (Exception localException2)
          {
            int i;
            Object localObject2;
            ae.printErrStackTrace("Intent.decodeProtoBuffer", (Throwable)localException2, "decode ProtoBuffer", new Object[0]);
          }
          localException1 = localException1;
          ae.e(MpWebViewController.e(this.osK), "session is null, " + localException1.getMessage() + ' ' + com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ag(MpWebViewController.m(this.osK)));
          com.tencent.mm.plugin.webview.g.a.XA(153);
          com.tencent.mm.plugin.report.service.g.yxI.f(17260, new Object[] { Integer.valueOf(2), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.ag(MpWebViewController.m(this.osK)) });
          if ((paramMMWebView.getActivityContextIfHas() instanceof Activity))
          {
            localObject2 = paramMMWebView.getActivityContextIfHas();
            if (localObject2 == null)
            {
              localObject2 = new v("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(209018);
              throw ((Throwable)localObject2);
              i = 0;
              continue;
              i = 0;
              continue;
              localcmu = null;
            }
            else
            {
              ((Activity)localcmu).finish();
            }
          }
          else
          {
            localcmu = new cmu();
          }
        }
        AppMethodBeat.o(209018);
        return localcmu;
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class v
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    v(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "value", "", "invoke"})
  static final class w
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    w(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "value", "", "invoke"})
  static final class x
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    x(MpWebViewController paramMpWebViewController)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "value", "", "invoke"})
  static final class y
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    y(MpWebViewController paramMpWebViewController, long paramLong1, y.a parama, long paramLong2)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class z
    implements IPCRunCgi.a
  {
    z(MpWebViewController paramMpWebViewController, String paramString, com.tencent.mm.plugin.webview.c.l paraml) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(209023);
      MpWebViewController.h(this.osK).remove(this.osT);
      p.g(paramb, "rr");
      if (!(paramb.aEV() instanceof avz))
      {
        AppMethodBeat.o(209023);
        return;
      }
      paramString = paramb.aEV();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.GetA8KeyResp");
        AppMethodBeat.o(209023);
        throw paramString;
      }
      paramString = (avz)paramString;
      if (bu.isNullOrNil(paramString.GNB))
      {
        ae.e(MpWebViewController.e(this.osK), "updatePageAuth fail fullurl is null");
        com.tencent.mm.plugin.webview.g.a.md(82);
        paramString = this.osK.getJsapi();
        if (paramString != null)
        {
          paramString.i(this.osU.Efy, this.osU.lcx + ":fail", null);
          AppMethodBeat.o(209023);
          return;
        }
        AppMethodBeat.o(209023);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        try
        {
          paramb = new JsapiPermissionWrapper(com.tencent.mm.platformtools.z.a(paramString.GNK));
          Object localObject = new GeneralControlWrapper(paramString.GNE);
          this.osK.lzU.a(paramString.GNB, paramb, (GeneralControlWrapper)localObject);
          paramb = this.osK;
          localObject = this.osT;
          String str = paramString.GNB;
          p.g(str, "resp.FullURL");
          Map localMap = com.tencent.mm.plugin.webview.e.c.he((List)paramString.GNl);
          p.g(localMap, "LuggageGetA8Key.getHttpHeaders(resp.HttpHeader)");
          MpWebViewController.a(paramb, (String)localObject, str, localMap);
          com.tencent.mm.plugin.webview.g.a.XA(109);
          paramb = (Map)new HashMap();
          paramString = paramString.GNB;
          p.g(paramString, "resp.FullURL");
          paramb.put("fullUrl", paramString);
          ae.i(MpWebViewController.e(this.osK), "updatePageAuth values:%s", new Object[] { paramb });
          com.tencent.mm.plugin.webview.g.a.md(81);
          paramString = this.osK.getJsapi();
          if (paramString != null)
          {
            paramString.i(this.osU.Efy, this.osU.lcx + ":ok", paramb);
            AppMethodBeat.o(209023);
            return;
          }
        }
        catch (Exception paramString)
        {
          com.tencent.mm.plugin.webview.g.a.md(82);
          paramString = this.osK.getJsapi();
          if (paramString != null)
          {
            paramString.i(this.osU.Efy, this.osU.lcx + ":fail", null);
            AppMethodBeat.o(209023);
            return;
            AppMethodBeat.o(209023);
            return;
          }
          AppMethodBeat.o(209023);
          return;
        }
      }
      com.tencent.mm.plugin.webview.g.a.md(82);
      paramString = this.osK.getJsapi();
      if (paramString != null)
      {
        paramString.i(this.osU.Efy, this.osU.lcx + ":fail", null);
        AppMethodBeat.o(209023);
        return;
      }
      AppMethodBeat.o(209023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.MpWebViewController
 * JD-Core Version:    0.7.0.1
 */