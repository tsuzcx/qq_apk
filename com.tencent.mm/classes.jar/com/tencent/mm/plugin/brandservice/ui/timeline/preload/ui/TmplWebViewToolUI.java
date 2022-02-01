package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.protocal.protobuf.ese;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "()V", "SHOW_PROGRESS_TIME", "", "TAG", "", "destroyed", "", "isForceUrl", "()Z", "isForceUrl$delegate", "Lkotlin/Lazy;", "mpController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplParams$delegate", "webViewControllerListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1;", "canTryPreloadNextWebView", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "createWebViewController", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "enableMinimize", "getMPController", "isPageCache", "loadForceUrl", "", "forceUrl", "fullScreen", "modifyForceUrl", "url", "onDestroy", "onPageReady", "onResetAfterCreate", "shouldInterceptProgressShow", "tryPreloadNextWebView", "plugin-brandservice_release"})
public class TmplWebViewToolUI
  extends WebViewUI
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final long sRQ;
  private boolean sRR;
  private final f sRS;
  private final f sRT;
  private MpWebViewController sRU;
  private final c sRV;
  
  public TmplWebViewToolUI()
  {
    AppMethodBeat.i(7019);
    this.TAG = "MicroMsg.TmplWebViewToolUI";
    this.sRQ = 500L;
    this.sRS = g.ar((kotlin.g.a.a)new b(this));
    this.sRT = g.ar((kotlin.g.a.a)new a(this));
    this.sRV = new c(this);
    AppMethodBeat.o(7019);
  }
  
  private final ese cDR()
  {
    AppMethodBeat.i(262588);
    ese localese = (ese)this.sRS.getValue();
    AppMethodBeat.o(262588);
    return localese;
  }
  
  private final boolean cDS()
  {
    AppMethodBeat.i(262590);
    boolean bool = ((Boolean)this.sRT.getValue()).booleanValue();
    AppMethodBeat.o(262590);
    return bool;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(262617);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(262617);
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(262615);
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
    AppMethodBeat.o(262615);
    return localView1;
  }
  
  public final void cDT()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(7000);
    Object localObject1;
    if (!cDS())
    {
      localObject1 = localObject3;
      if (d.gZN())
      {
        String str = getIntent().getStringExtra("float_ball_key");
        localObject1 = localObject3;
        if (!Util.isNullOrNil(str))
        {
          localObject1 = d.Qkh;
          p.j(str, "floatBallKey");
          localObject1 = d.bmB(str);
          if ((localObject1 instanceof MpWebViewController)) {
            break label289;
          }
          localObject1 = localObject2;
        }
      }
    }
    label289:
    for (;;)
    {
      localObject1 = (MpWebViewController)localObject1;
      if ((localObject1 != null) && ((localObject1 instanceof MpWebViewController)))
      {
        this.sRU = ((MpWebViewController)localObject1);
        this.QfL = true;
      }
      for (;;)
      {
        Log.i(this.TAG, "onResetAfterCreate isForceUrl=" + cDS());
        super.cDT();
        if (this.sRU != null)
        {
          localObject1 = this.sRU;
          if (localObject1 == null) {
            p.iCn();
          }
          Log.i(this.TAG, "Abe-Debug createWebViewController");
          if (!this.QfL)
          {
            localObject2 = this.QgS;
            p.j(localObject2, "defaultWebViewInterceptor");
            ((MpWebViewController)localObject1).a((k)localObject2);
          }
          ((MpWebViewController)localObject1).a((j)this.sRV);
          localObject1 = this.sRU;
          if (localObject1 == null) {
            p.iCn();
          }
          ((BaseWebViewController)localObject1).PFX.TA(this.sRQ);
        }
        AppMethodBeat.o(7000);
        return;
        localObject1 = getContext();
        p.j(localObject1, "context");
        localObject2 = a.a((Context)localObject1, cDR(), getIntent());
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = getContext();
          p.j(localObject1, "context");
          localObject1 = a.a((Context)localObject1, cDR());
        }
        this.sRU = ((MpWebViewController)localObject1);
      }
    }
  }
  
  public final MMWebView cDU()
  {
    AppMethodBeat.i(7002);
    if (this.QfL)
    {
      localObject = super.cDU();
      AppMethodBeat.o(7002);
      return localObject;
    }
    if (!(this.sRU instanceof MpWebViewController))
    {
      localObject = super.cDU();
      AppMethodBeat.o(7002);
      return localObject;
    }
    Object localObject = this.sRU;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((BaseWebViewController)localObject).pHS;
    AppMethodBeat.o(7002);
    return localObject;
  }
  
  public final i cDV()
  {
    AppMethodBeat.i(262598);
    Object localObject = this.sRU;
    if (localObject != null)
    {
      localObject = (i)localObject;
      AppMethodBeat.o(262598);
      return localObject;
    }
    localObject = super.cDV();
    p.j(localObject, "super.createWebViewController()");
    AppMethodBeat.o(262598);
    return localObject;
  }
  
  public final boolean cDW()
  {
    AppMethodBeat.i(262602);
    if (!cDS())
    {
      AppMethodBeat.o(262602);
      return true;
    }
    AppMethodBeat.o(262602);
    return false;
  }
  
  public final boolean cDX()
  {
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7003);
    MpWebViewController localMpWebViewController = this.sRU;
    if (localMpWebViewController != null) {
      localMpWebViewController.b((j)this.sRV);
    }
    this.sRR = true;
    super.onDestroy();
    AppMethodBeat.o(7003);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    a(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ese>
  {
    b(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
    
    /* Error */
    private ese cDY()
    {
      // Byte code:
      //   0: ldc 36
      //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:sRW	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   9: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   12: astore_2
      //   13: getstatic 51	com/tencent/mm/ui/f$r:VSE	Ljava/lang/String;
      //   16: astore_3
      //   17: aload_3
      //   18: ldc 53
      //   20: invokestatic 59	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
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
      //   59: checkcast 75	com/tencent/mm/cd/a
      //   62: aload_2
      //   63: invokevirtual 79	com/tencent/mm/cd/a:parseFrom	([B)Lcom/tencent/mm/cd/a;
      //   66: pop
      //   67: aload_3
      //   68: checkcast 75	com/tencent/mm/cd/a
      //   71: astore_2
      //   72: aload_2
      //   73: checkcast 67	com/tencent/mm/protocal/protobuf/ese
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
      //   105: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:sRW	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
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
      //   133: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:sRW	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   136: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   139: invokestatic 117	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ae	(Landroid/content/Intent;)Ljava/lang/String;
      //   142: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   145: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   148: invokestatic 126	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   151: sipush 150
      //   154: invokestatic 131	com/tencent/mm/plugin/webview/h/a:anX	(I)V
      //   157: getstatic 137	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
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
      //   177: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:sRW	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   180: invokevirtual 45	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   183: invokestatic 117	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ae	(Landroid/content/Intent;)Ljava/lang/String;
      //   186: aastore
      //   187: invokevirtual 148	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
      //   190: aload_0
      //   191: getfield 27	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:sRW	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   194: invokevirtual 151	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:finish	()V
      //   197: new 67	com/tencent/mm/protocal/protobuf/ese
      //   200: dup
      //   201: invokespecial 152	com/tencent/mm/protocal/protobuf/ese:<init>	()V
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
      //   204	7	2	localese	ese
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onJsReady", "", "plugin-brandservice_release"})
  public static final class c
    extends j
  {
    public final void bXI()
    {
      AppMethodBeat.i(258319);
      super.bXI();
      com.tencent.mm.plugin.webview.ui.tools.l locall = TmplWebViewToolUI.b(this.sRW);
      Object localObject = TmplWebViewToolUI.c(this.sRW);
      if (localObject != null) {}
      for (localObject = ((MpWebViewController)localObject).getCurrentUrl();; localObject = null)
      {
        locall.bmj((String)localObject);
        AppMethodBeat.o(258319);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
 * JD-Core Version:    0.7.0.1
 */