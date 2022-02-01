package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.l;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.core.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.floatball.d;
import com.tencent.mm.plugin.webview.ui.tools.p;
import com.tencent.mm.protocal.protobuf.fnn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "()V", "SHOW_PROGRESS_TIME", "", "TAG", "", "destroyed", "", "isForceUrl", "()Z", "isForceUrl$delegate", "Lkotlin/Lazy;", "mpController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplParams$delegate", "webViewControllerListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1;", "canTryPreloadNextWebView", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "createWebViewController", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "enableMinimize", "getMPController", "isPageCache", "loadForceUrl", "", "forceUrl", "fullScreen", "modifyForceUrl", "url", "onDestroy", "onPageReady", "onResetAfterCreate", "shouldInterceptProgressShow", "tryPreloadNextWebView", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public class TmplWebViewToolUI
  extends WebViewUI
{
  private final String TAG;
  private final long vXl;
  private boolean vXm;
  private final j vXn;
  private final j vXo;
  private MpWebViewController vXp;
  private final c vXq;
  
  public TmplWebViewToolUI()
  {
    AppMethodBeat.i(7019);
    this.TAG = "MicroMsg.TmplWebViewToolUI";
    this.vXl = 500L;
    this.vXn = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.vXo = kotlin.k.cm((kotlin.g.a.a)new a(this));
    this.vXq = new c(this);
    AppMethodBeat.o(7019);
  }
  
  private final fnn dfa()
  {
    AppMethodBeat.i(303405);
    fnn localfnn = (fnn)this.vXn.getValue();
    AppMethodBeat.o(303405);
    return localfnn;
  }
  
  private final boolean dhu()
  {
    AppMethodBeat.i(303412);
    boolean bool = ((Boolean)this.vXo.getValue()).booleanValue();
    AppMethodBeat.o(303412);
    return bool;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final void dhv()
  {
    Object localObject2 = null;
    AppMethodBeat.i(7000);
    Object localObject1;
    if (!dhu())
    {
      localObject1 = localObject2;
      if (d.izQ())
      {
        String str = getIntent().getStringExtra("float_ball_key");
        localObject1 = localObject2;
        if (!Util.isNullOrNil(str))
        {
          localObject1 = d.XbW;
          s.checkNotNull(str);
          localObject1 = d.bmc(str);
          if (!(localObject1 instanceof MpWebViewController)) {
            break label193;
          }
          localObject1 = (MpWebViewController)localObject1;
        }
      }
      if (localObject1 == null) {
        break label198;
      }
      this.vXp = ((MpWebViewController)localObject1);
      this.WXJ = true;
    }
    for (;;)
    {
      Log.i(this.TAG, s.X("onResetAfterCreate isForceUrl=", Boolean.valueOf(dhu())));
      super.dhv();
      if (this.vXp != null)
      {
        localObject1 = this.vXp;
        s.checkNotNull(localObject1);
        Log.i(this.TAG, "Abe-Debug createWebViewController");
        if (!this.WXJ)
        {
          localObject2 = this.WYQ;
          s.s(localObject2, "defaultWebViewInterceptor");
          ((MpWebViewController)localObject1).a((m)localObject2);
        }
        ((MpWebViewController)localObject1).a((l)this.vXq);
        localObject1 = this.vXp;
        s.checkNotNull(localObject1);
        ((BaseWebViewController)localObject1).WwK.xK(this.vXl);
      }
      AppMethodBeat.o(7000);
      return;
      label193:
      localObject1 = null;
      break;
      label198:
      localObject1 = getContext();
      s.s(localObject1, "context");
      localObject2 = a.a((Context)localObject1, dfa(), getIntent());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = getContext();
        s.s(localObject1, "context");
        localObject1 = a.a((Context)localObject1, dfa());
      }
      this.vXp = ((MpWebViewController)localObject1);
    }
  }
  
  public final MMWebView dhw()
  {
    AppMethodBeat.i(7002);
    if (this.WXJ)
    {
      localObject = super.dhw();
      AppMethodBeat.o(7002);
      return localObject;
    }
    if (this.vXp == null)
    {
      localObject = super.dhw();
      AppMethodBeat.o(7002);
      return localObject;
    }
    Object localObject = this.vXp;
    s.checkNotNull(localObject);
    localObject = ((BaseWebViewController)localObject).sMP;
    AppMethodBeat.o(7002);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.webview.core.k dhx()
  {
    AppMethodBeat.i(303439);
    Object localObject = this.vXp;
    if (localObject == null)
    {
      localObject = super.dhx();
      s.s(localObject, "super.createWebViewController()");
      AppMethodBeat.o(303439);
      return localObject;
    }
    localObject = (com.tencent.mm.plugin.webview.core.k)localObject;
    AppMethodBeat.o(303439);
    return localObject;
  }
  
  public final boolean dhy()
  {
    AppMethodBeat.i(303448);
    if (!dhu())
    {
      AppMethodBeat.o(303448);
      return true;
    }
    AppMethodBeat.o(303448);
    return false;
  }
  
  public final boolean dhz()
  {
    return true;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(7003);
    MpWebViewController localMpWebViewController = this.vXp;
    if (localMpWebViewController != null) {
      localMpWebViewController.b((l)this.vXq);
    }
    this.vXm = true;
    super.onDestroy();
    AppMethodBeat.o(7003);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    a(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/TmplParams;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<fnn>
  {
    b(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
    
    /* Error */
    private fnn dhA()
    {
      // Byte code:
      //   0: ldc 39
      //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 30	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:vXr	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   9: invokevirtual 48	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   12: astore_2
      //   13: getstatic 54	com/tencent/mm/ui/f$s:adwN	Ljava/lang/String;
      //   16: astore_3
      //   17: aload_3
      //   18: ldc 56
      //   20: invokestatic 62	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
      //   23: aload_2
      //   24: aload_3
      //   25: invokevirtual 68	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
      //   28: astore_2
      //   29: aload_2
      //   30: ifnull +205 -> 235
      //   33: aload_2
      //   34: arraylength
      //   35: istore_1
      //   36: iload_1
      //   37: ifne +172 -> 209
      //   40: iconst_1
      //   41: istore_1
      //   42: iload_1
      //   43: ifne +171 -> 214
      //   46: iconst_1
      //   47: istore_1
      //   48: iload_1
      //   49: ifeq +186 -> 235
      //   52: ldc 70
      //   54: invokevirtual 76	java/lang/Class:newInstance	()Ljava/lang/Object;
      //   57: astore_3
      //   58: aload_3
      //   59: checkcast 78	com/tencent/mm/bx/a
      //   62: aload_2
      //   63: invokevirtual 82	com/tencent/mm/bx/a:parseFrom	([B)Lcom/tencent/mm/bx/a;
      //   66: pop
      //   67: aload_3
      //   68: checkcast 78	com/tencent/mm/bx/a
      //   71: astore_2
      //   72: aload_2
      //   73: checkcast 70	com/tencent/mm/protocal/protobuf/fnn
      //   76: astore_3
      //   77: aload_3
      //   78: astore_2
      //   79: aload_3
      //   80: ifnonnull +122 -> 202
      //   83: new 84	android/content/res/Resources$NotFoundException
      //   86: dup
      //   87: ldc 86
      //   89: invokespecial 89	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
      //   92: astore_2
      //   93: ldc 39
      //   95: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: aload_2
      //   99: athrow
      //   100: astore_2
      //   101: aload_0
      //   102: getfield 30	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:vXr	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   105: invokestatic 96	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:a	(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;)Ljava/lang/String;
      //   108: new 98	java/lang/StringBuilder
      //   111: dup
      //   112: ldc 100
      //   114: invokespecial 101	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   117: aload_2
      //   118: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   121: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   124: bipush 32
      //   126: invokevirtual 112	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
      //   129: aload_0
      //   130: getfield 30	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:vXr	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   133: invokevirtual 48	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   136: invokestatic 118	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ai	(Landroid/content/Intent;)Ljava/lang/String;
      //   139: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   142: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   145: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   148: sipush 150
      //   151: invokestatic 135	com/tencent/mm/plugin/webview/g/a:atP	(I)V
      //   154: getstatic 141	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   157: sipush 17260
      //   160: iconst_2
      //   161: anewarray 143	java/lang/Object
      //   164: dup
      //   165: iconst_0
      //   166: iconst_2
      //   167: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   170: aastore
      //   171: dup
      //   172: iconst_1
      //   173: aload_0
      //   174: getfield 30	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:vXr	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   177: invokevirtual 48	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:getIntent	()Landroid/content/Intent;
      //   180: invokestatic 118	com/tencent/mm/plugin/brandservice/ui/timeline/preload/f:ai	(Landroid/content/Intent;)Ljava/lang/String;
      //   183: aastore
      //   184: invokevirtual 153	com/tencent/mm/plugin/report/service/h:b	(I[Ljava/lang/Object;)V
      //   187: aload_0
      //   188: getfield 30	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$b:vXr	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;
      //   191: invokevirtual 156	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI:finish	()V
      //   194: new 70	com/tencent/mm/protocal/protobuf/fnn
      //   197: dup
      //   198: invokespecial 157	com/tencent/mm/protocal/protobuf/fnn:<init>	()V
      //   201: astore_2
      //   202: ldc 39
      //   204: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   207: aload_2
      //   208: areturn
      //   209: iconst_0
      //   210: istore_1
      //   211: goto -169 -> 42
      //   214: iconst_0
      //   215: istore_1
      //   216: goto -168 -> 48
      //   219: astore_2
      //   220: ldc 159
      //   222: aload_2
      //   223: checkcast 161	java/lang/Throwable
      //   226: ldc 163
      //   228: iconst_0
      //   229: anewarray 143	java/lang/Object
      //   232: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   235: aconst_null
      //   236: astore_2
      //   237: goto -165 -> 72
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	240	0	this	b
      //   35	181	1	i	int
      //   12	87	2	localObject1	Object
      //   100	18	2	localException1	java.lang.Exception
      //   201	7	2	localfnn	fnn
      //   219	4	2	localException2	java.lang.Exception
      //   236	1	2	localObject2	Object
      //   16	64	3	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   5	29	100	java/lang/Exception
      //   33	36	100	java/lang/Exception
      //   72	77	100	java/lang/Exception
      //   83	100	100	java/lang/Exception
      //   220	235	100	java/lang/Exception
      //   52	72	219	java/lang/Exception
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onJsReady", "", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends l
  {
    c(TmplWebViewToolUI paramTmplWebViewToolUI) {}
    
    public final void cxT()
    {
      AppMethodBeat.i(303400);
      super.cxT();
      p localp = TmplWebViewToolUI.b(this.vXr);
      Object localObject = TmplWebViewToolUI.c(this.vXr);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((MpWebViewController)localObject).getCurrentUrl())
      {
        localp.blL((String)localObject);
        AppMethodBeat.o(303400);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
 * JD-Core Version:    0.7.0.1
 */