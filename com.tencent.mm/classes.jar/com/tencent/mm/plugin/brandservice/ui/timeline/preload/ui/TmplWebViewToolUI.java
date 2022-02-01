package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.aa;
import kotlin.g.b.y;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "()V", "SHOW_PROGRESS_TIME", "", "TAG", "", "destroyed", "", "isForceUrl", "()Z", "isForceUrl$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "lazyMgr", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getLazyMgr", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "mpController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplParams$delegate", "webViewControllerListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1;", "canTryPreloadNextWebView", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "createWebViewController", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "enableMinimize", "getMPController", "isPageCache", "loadForceUrl", "", "forceUrl", "fullScreen", "modifyForceUrl", "url", "onDestroy", "onPageReady", "onReset", "onResetAfterCreate", "shouldInterceptProgressShow", "tryPreloadNextWebView", "plugin-brandservice_release"})
public class TmplWebViewToolUI
  extends WebViewUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final long pGX;
  private boolean pGY;
  protected final r pGZ;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHa;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.q pHb;
  protected MpWebViewController pHc;
  private final c pHd;
  
  static
  {
    AppMethodBeat.i(6987);
    cLI = new kotlin.l.k[] { (kotlin.l.k)aa.a(new y(aa.bp(TmplWebViewToolUI.class), "tmplParams", "getTmplParams()Lcom/tencent/mm/protocal/protobuf/TmplParams;")), (kotlin.l.k)aa.a(new y(aa.bp(TmplWebViewToolUI.class), "isForceUrl", "isForceUrl()Z")) };
    AppMethodBeat.o(6987);
  }
  
  public TmplWebViewToolUI()
  {
    AppMethodBeat.i(7019);
    this.TAG = "MicroMsg.TmplWebViewToolUI";
    this.pGX = 500L;
    this.pGZ = new r();
    this.pHa = s.a(this.pGZ, (kotlin.g.a.a)new b(this));
    this.pHb = s.a(this.pGZ, (kotlin.g.a.a)new a(this));
    this.pHd = new c(this);
    AppMethodBeat.o(7019);
  }
  
  private final eic cpM()
  {
    AppMethodBeat.i(195881);
    eic localeic = (eic)this.pHa.a(cLI[0]);
    AppMethodBeat.o(195881);
    return localeic;
  }
  
  private final boolean cpN()
  {
    AppMethodBeat.i(195882);
    boolean bool = ((Boolean)this.pHb.a(cLI[1])).booleanValue();
    AppMethodBeat.o(195882);
    return bool;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(195886);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(195886);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(195885);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(195885);
    return localView1;
  }
  
  public void cpA()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(7000);
    Object localObject1;
    if (!cpN())
    {
      localObject1 = localObject3;
      if (d.ggy())
      {
        String str = getIntent().getStringExtra("float_ball_key");
        localObject1 = localObject3;
        if (!Util.isNullOrNil(str))
        {
          localObject1 = d.JmQ;
          kotlin.g.b.p.g(str, "floatBallKey");
          localObject1 = d.baD(str);
          if ((localObject1 instanceof MpWebViewController)) {
            break label285;
          }
          localObject1 = localObject2;
        }
      }
    }
    label285:
    for (;;)
    {
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && ((localObject1 instanceof MpWebViewController)))
      {
        this.pHc = ((MpWebViewController)localObject1);
        this.JiL = true;
      }
      for (;;)
      {
        Log.i(this.TAG, "onResetAfterCreate isForceUrl=" + cpN());
        super.cpA();
        localObject1 = this.pHc;
        if (localObject1 != null)
        {
          Log.i(this.TAG, "Abe-Debug createWebViewController");
          localObject2 = this.JjS;
          kotlin.g.b.p.g(localObject2, "defaultWebViewInterceptor");
          ((MpWebViewController)localObject1).a((com.tencent.mm.plugin.webview.core.k)localObject2);
          ((MpWebViewController)localObject1).a((j)this.pHd);
        }
        localObject1 = this.pHc;
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((BaseWebViewController)localObject1).IJZ;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.webview.core.l)localObject1).Mc(this.pGX);
        AppMethodBeat.o(7000);
        return;
        localObject1 = getContext();
        kotlin.g.b.p.g(localObject1, "context");
        localObject2 = a.a((Context)localObject1, cpM(), getIntent());
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = getContext();
          kotlin.g.b.p.g(localObject1, "context");
          localObject1 = a.a((Context)localObject1, cpM());
        }
        this.pHc = ((MpWebViewController)localObject1);
      }
      AppMethodBeat.o(7000);
      return;
    }
  }
  
  public final i cpO()
  {
    AppMethodBeat.i(195883);
    Object localObject = this.pHc;
    if (localObject != null)
    {
      localObject = (i)localObject;
      AppMethodBeat.o(195883);
      return localObject;
    }
    localObject = super.cpO();
    kotlin.g.b.p.g(localObject, "super.createWebViewController()");
    AppMethodBeat.o(195883);
    return localObject;
  }
  
  public final boolean cpP()
  {
    AppMethodBeat.i(195884);
    if (!cpN())
    {
      AppMethodBeat.o(195884);
      return true;
    }
    AppMethodBeat.o(195884);
    return false;
  }
  
  public MMWebView cpy()
  {
    AppMethodBeat.i(7002);
    if (this.JiL)
    {
      localObject = super.cpy();
      AppMethodBeat.o(7002);
      return localObject;
    }
    Object localObject = this.pHc;
    if (localObject != null)
    {
      MMWebView localMMWebView = ((BaseWebViewController)localObject).pGj;
      localObject = localMMWebView;
      if (localMMWebView != null) {}
    }
    else
    {
      localObject = super.cpy();
    }
    AppMethodBeat.o(7002);
    return localObject;
  }
  
  public boolean cpz()
  {
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7003);
    MpWebViewController localMpWebViewController = this.pHc;
    if (localMpWebViewController != null) {
      localMpWebViewController.b((j)this.pHd);
    }
    this.pGY = true;
    super.onDestroy();
    AppMethodBeat.o(7003);
  }
  
  public void onReset()
  {
    AppMethodBeat.i(6998);
    r localr = this.pGZ;
    synchronized (localr.pDt)
    {
      Iterator localIterator = ((Iterable)localr.pDt).iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.p)localIterator.next()).reset();
      }
    }
    localObject.pDt.clear();
    x localx = x.SXb;
    this.pHc = null;
    super.onReset();
    AppMethodBeat.o(6998);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Boolean>
  {
    a(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<eic>
  {
    b(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
    
    /* Error */
    private eic cpQ()
    {
      // Byte code:
      //   0: ldc 36
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:pHe	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   9: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   12: astore_2
      //   13: getstatic 51	com/tencent/mm/ui/e$p:Ozq	Ljava/lang/String;
      //   16: astore_3
      //   17: aload_3
      //   18: ldc 53
      //   20: invokestatic 59	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   23: aload_2
      //   24: aload_3
      //   25: invokevirtual 65	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
      //   28: astore_2
      //   29: aload_2
      //   30: ifnull +208 -> 238
      //   33: aload_2
      //   34: arraylength
      //   35: istore_1
      //   36: iload_1
      //   37: ifne +175 -> 212
      //   40: iconst_1
      //   41: istore_1
      //   42: iload_1
      //   43: ifne +174 -> 217
      //   46: iconst_1
      //   47: istore_1
      //   48: iload_1
      //   49: ifeq +189 -> 238
      //   52: ldc 67
      //   54: invokevirtual 73	java/lang/Class:newInstance	()Ljava/lang/Object;
      //   57: astore_3
      //   58: aload_3
      //   59: checkcast 75	com/tencent/mm/bw/a
      //   62: aload_2
      //   63: invokevirtual 79	com/tencent/mm/bw/a:parseFrom	([B)Lcom/tencent/mm/bw/a;
      //   66: pop
      //   67: aload_3
      //   68: checkcast 75	com/tencent/mm/bw/a
      //   71: astore_2
      //   72: aload_2
      //   73: checkcast 67	com/tencent/mm/protocal/protobuf/eic
      //   76: astore_3
      //   77: aload_3
      //   78: astore_2
      //   79: aload_3
      //   80: ifnonnull +125 -> 205
      //   83: new 81	android/content/res/Resources$NotFoundException
      //   86: dup
      //   87: ldc 83
      //   89: invokespecial 86	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
      //   92: checkcast 88	java/lang/Throwable
      //   95: astore_2
      //   96: ldc 36
      //   98: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   101: aload_2
      //   102: athrow
      //   103: astore_2
      //   104: aload_0
      //   105: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:pHe	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   108: invokestatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:a	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;)Ljava/lang/String;
      //   111: new 97	java/lang/StringBuilder
      //   114: dup
      //   115: ldc 99
      //   117: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   120: aload_2
      //   121: invokevirtual 104	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   124: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   127: bipush 32
      //   129: invokevirtual 111	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   132: aload_0
      //   133: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:pHe	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   136: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   139: invokestatic 117	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ag	(Landroid/content/Intent;)Ljava/lang/String;
      //   142: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   145: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   148: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   151: sipush 150
      //   154: invokestatic 131	com/tencent/mm/plugin/webview/h/a:agi	(I)V
      //   157: getstatic 137	com/tencent/mm/plugin/report/service/h:CyF	Lcom/tencent/mm/plugin/report/service/h;
      //   160: sipush 17260
      //   163: iconst_2
      //   164: anewarray 139	java/lang/Object
      //   167: dup
      //   168: iconst_0
      //   169: iconst_2
      //   170: invokestatic 145	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   173: aastore
      //   174: dup
      //   175: iconst_1
      //   176: aload_0
      //   177: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:pHe	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   180: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   183: invokestatic 117	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ag	(Landroid/content/Intent;)Ljava/lang/String;
      //   186: aastore
      //   187: invokevirtual 148	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   190: aload_0
      //   191: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:pHe	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   194: invokevirtual 151	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:finish	()V
      //   197: new 67	com/tencent/mm/protocal/protobuf/eic
      //   200: dup
      //   201: invokespecial 152	com/tencent/mm/protocal/protobuf/eic:<init>	()V
      //   204: astore_2
      //   205: ldc 36
      //   207: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   210: aload_2
      //   211: areturn
      //   212: iconst_0
      //   213: istore_1
      //   214: goto -172 -> 42
      //   217: iconst_0
      //   218: istore_1
      //   219: goto -171 -> 48
      //   222: astore_2
      //   223: ldc 154
      //   225: aload_2
      //   226: checkcast 88	java/lang/Throwable
      //   229: ldc 156
      //   231: iconst_0
      //   232: anewarray 139	java/lang/Object
      //   235: invokestatic 160	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   238: aconst_null
      //   239: astore_2
      //   240: goto -168 -> 72
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	243	0	this	b
      //   35	184	1	i	int
      //   12	90	2	localObject1	Object
      //   103	18	2	localException1	java.lang.Exception
      //   204	7	2	localeic	eic
      //   222	4	2	localException2	java.lang.Exception
      //   239	1	2	localObject2	Object
      //   16	64	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   5	29	103	java/lang/Exception
      //   33	36	103	java/lang/Exception
      //   72	77	103	java/lang/Exception
      //   83	103	103	java/lang/Exception
      //   223	238	103	java/lang/Exception
      //   52	72	222	java/lang/Exception
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onJsReady", "", "plugin-brandservice_release"})
  public static final class c
    extends j
  {
    public final void cpR()
    {
      AppMethodBeat.i(195880);
      super.cpR();
      com.tencent.mm.plugin.webview.ui.tools.k localk = TmplWebViewToolUI.b(this.pHe);
      Object localObject = TmplWebViewToolUI.c(this.pHe);
      if (localObject != null) {}
      for (localObject = ((MpWebViewController)localObject).getCurrentUrl();; localObject = null)
      {
        localk.setCurrentURL((String)localObject);
        AppMethodBeat.o(195880);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
 * JD-Core Version:    0.7.0.1
 */