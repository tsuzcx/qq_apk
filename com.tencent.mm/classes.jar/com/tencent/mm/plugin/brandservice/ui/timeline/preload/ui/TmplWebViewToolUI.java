package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.n;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.o;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.h;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.c;
import com.tencent.mm.protocal.protobuf.dnj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMWebView;
import d.g.b.x;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "()V", "SHOW_PROGRESS_TIME", "", "TAG", "", "destroyed", "", "isForceUrl", "()Z", "isForceUrl$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "lazyMgr", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getLazyMgr", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "mpController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplParams$delegate", "canTryPreloadNextWebView", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "createWebViewController", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "enableMinimize", "getMPController", "isPageCache", "loadForceUrl", "", "forceUrl", "fullScreen", "modifyForceUrl", "url", "onDestroy", "onPageReady", "onReset", "onResetAfterCreate", "shouldInterceptProgressShow", "tryPreloadNextWebView", "plugin-brandservice_release"})
public class TmplWebViewToolUI
  extends WebViewUI
{
  private final String TAG;
  private final long onJ;
  private boolean onK;
  protected final com.tencent.mm.plugin.brandservice.ui.timeline.preload.p onL;
  private final o onM;
  private final o onN;
  protected MpWebViewController onO;
  
  static
  {
    AppMethodBeat.i(6987);
    cwV = new d.l.k[] { (d.l.k)d.g.b.z.a(new x(d.g.b.z.bp(TmplWebViewToolUI.class), "tmplParams", "getTmplParams()Lcom/tencent/mm/protocal/protobuf/TmplParams;")), (d.l.k)d.g.b.z.a(new x(d.g.b.z.bp(TmplWebViewToolUI.class), "isForceUrl", "isForceUrl()Z")) };
    AppMethodBeat.o(6987);
  }
  
  public TmplWebViewToolUI()
  {
    AppMethodBeat.i(7019);
    this.TAG = "MicroMsg.TmplWebViewToolUI";
    this.onJ = 500L;
    this.onL = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.p();
    this.onM = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new c(this));
    this.onN = com.tencent.mm.plugin.brandservice.ui.timeline.preload.q.a(this.onL, (d.g.a.a)new a(this));
    AppMethodBeat.o(7019);
  }
  
  private final dnj bRb()
  {
    AppMethodBeat.i(210093);
    dnj localdnj = (dnj)this.onM.a(cwV[0]);
    AppMethodBeat.o(210093);
    return localdnj;
  }
  
  private final boolean bRc()
  {
    AppMethodBeat.i(210094);
    boolean bool = ((Boolean)this.onN.a(cwV[1])).booleanValue();
    AppMethodBeat.o(210094);
    return bool;
  }
  
  public MMWebView bQN()
  {
    AppMethodBeat.i(7002);
    Object localObject = this.onO;
    if (localObject != null)
    {
      MMWebView localMMWebView = ((BaseWebViewController)localObject).omW;
      localObject = localMMWebView;
      if (localMMWebView != null) {}
    }
    else
    {
      localObject = super.bQN();
    }
    AppMethodBeat.o(7002);
    return localObject;
  }
  
  public boolean bQO()
  {
    return true;
  }
  
  public void bQP()
  {
    AppMethodBeat.i(7000);
    if (!bRc())
    {
      localObject = getContext();
      d.g.b.p.g(localObject, "context");
      MpWebViewController localMpWebViewController = a.a((Context)localObject, bRb(), getIntent());
      localObject = localMpWebViewController;
      if (localMpWebViewController == null)
      {
        localObject = getContext();
        d.g.b.p.g(localObject, "context");
        localObject = a.a((Context)localObject, bRb());
      }
      this.onO = ((MpWebViewController)localObject);
    }
    ad.i(this.TAG, "onResetAfterCreate isForceUrl=" + bRc());
    super.bQP();
    Object localObject = this.onO;
    if (localObject != null)
    {
      ad.i(this.TAG, "Abe-Debug createWebViewController");
      ((MpWebViewController)localObject).a((com.tencent.mm.plugin.webview.core.j)new WebViewUI.c(this));
      ((MpWebViewController)localObject).a((i)new b((MpWebViewController)localObject, this));
    }
    localObject = this.onO;
    if (localObject != null)
    {
      localObject = ((BaseWebViewController)localObject).DGk;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.webview.core.k)localObject).Cp(this.onJ);
        AppMethodBeat.o(7000);
        return;
      }
    }
    AppMethodBeat.o(7000);
  }
  
  public final h bRd()
  {
    AppMethodBeat.i(210095);
    Object localObject = this.onO;
    if (localObject != null)
    {
      localObject = (h)localObject;
      AppMethodBeat.o(210095);
      return localObject;
    }
    localObject = super.bRd();
    d.g.b.p.g(localObject, "super.createWebViewController()");
    AppMethodBeat.o(210095);
    return localObject;
  }
  
  public final boolean bRe()
  {
    AppMethodBeat.i(210096);
    if (!bRc())
    {
      AppMethodBeat.o(210096);
      return true;
    }
    AppMethodBeat.o(210096);
    return false;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7003);
    this.onK = true;
    super.onDestroy();
    AppMethodBeat.o(7003);
  }
  
  public void onReset()
  {
    AppMethodBeat.i(6998);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.p localp = this.onL;
    synchronized (localp.ojS)
    {
      Iterator localIterator = ((Iterable)localp.ojS).iterator();
      if (localIterator.hasNext()) {
        ((n)localIterator.next()).reset();
      }
    }
    localObject.ojS.clear();
    d.z localz = d.z.MKo;
    this.onO = null;
    super.onReset();
    AppMethodBeat.o(6998);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.q
    implements d.g.a.a<Boolean>
  {
    a(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$onResetAfterCreate$1$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onJsReady", "", "plugin-brandservice_release"})
  public static final class b
    extends i
  {
    b(MpWebViewController paramMpWebViewController, TmplWebViewToolUI paramTmplWebViewToolUI) {}
    
    public final void bRf()
    {
      AppMethodBeat.i(210091);
      super.bRf();
      TmplWebViewToolUI.a(jdField_this).setCurrentURL(this.onQ.getCurrentUrl());
      AppMethodBeat.o(210091);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<dnj>
  {
    c(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
    
    /* Error */
    private dnj bRg()
    {
      // Byte code:
      //   0: ldc 36
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$c:onP	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   9: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   12: astore_2
      //   13: getstatic 51	com/tencent/mm/ui/e$m:IUH	Ljava/lang/String;
      //   16: astore_3
      //   17: aload_3
      //   18: ldc 53
      //   20: invokestatic 59	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
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
      //   59: checkcast 75	com/tencent/mm/bx/a
      //   62: aload_2
      //   63: invokevirtual 79	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   66: pop
      //   67: aload_3
      //   68: checkcast 75	com/tencent/mm/bx/a
      //   71: astore_2
      //   72: aload_2
      //   73: checkcast 67	com/tencent/mm/protocal/protobuf/dnj
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
      //   105: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$c:onP	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   108: invokestatic 95	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:b	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;)Ljava/lang/String;
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
      //   133: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$c:onP	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   136: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   139: invokestatic 117	com/tencent/mm/plugin/brandservice/ui/timeline/preload/d:ag	(Landroid/content/Intent;)Ljava/lang/String;
      //   142: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   145: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   148: invokestatic 126	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   151: sipush 150
      //   154: invokestatic 131	com/tencent/mm/plugin/webview/g/a:WU	(I)V
      //   157: getstatic 137	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
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
      //   177: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$c:onP	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   180: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   183: invokestatic 117	com/tencent/mm/plugin/brandservice/ui/timeline/preload/d:ag	(Landroid/content/Intent;)Ljava/lang/String;
      //   186: aastore
      //   187: invokevirtual 149	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
      //   190: aload_0
      //   191: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$c:onP	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   194: invokevirtual 152	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:finish	()V
      //   197: new 67	com/tencent/mm/protocal/protobuf/dnj
      //   200: dup
      //   201: invokespecial 153	com/tencent/mm/protocal/protobuf/dnj:<init>	()V
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
      //   223: ldc 155
      //   225: aload_2
      //   226: checkcast 88	java/lang/Throwable
      //   229: ldc 157
      //   231: iconst_0
      //   232: anewarray 139	java/lang/Object
      //   235: invokestatic 161	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   238: aconst_null
      //   239: astore_2
      //   240: goto -168 -> 72
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	243	0	this	c
      //   35	184	1	i	int
      //   12	90	2	localObject1	Object
      //   103	18	2	localException1	java.lang.Exception
      //   204	7	2	localdnj	dnj
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
 * JD-Core Version:    0.7.0.1
 */