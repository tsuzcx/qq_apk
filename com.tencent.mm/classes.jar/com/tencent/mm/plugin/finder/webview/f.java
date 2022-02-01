package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/BoxWebViewPreloadManager;", "", "()V", "TAG", "", "cacheWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "createWebViewHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "enablePreloadNextWebViewAfterGet", "", "enablePreloadWebView", "enablePreloadWebViewFromFindTab", "syncObject", "createBoxWebView", "fetchBoxWebView", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function3;", "", "getCachedBoxWebView", "preloadBoxWebView", "delay", "", "preloadBoxWebViewInner", "runTask", "block", "Lkotlin/Function0;", "startPreloadBoxWebView", "scene", "", "Scene", "plugin-finder_release"})
public final class f
{
  private static volatile BoxWebView Brc;
  private static boolean Brd;
  private static boolean Bre;
  private static boolean Brf;
  private static Object Brg;
  private static MMHandler Brh;
  public static final f Bri;
  
  static
  {
    AppMethodBeat.i(285902);
    Bri = new f();
    Bre = Brd;
    Brg = new Object();
    int i = ((b)h.ae(b.class)).a(b.a.vNQ, 0);
    int j = ((b)h.ae(b.class)).a(b.a.vNR, 0);
    if ((i == 1) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED))
    {
      bool = true;
      Brd = bool;
      if ((j != 1) && (!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED)) {
        break label221;
      }
    }
    label221:
    for (boolean bool = true;; bool = false)
    {
      Brf = bool;
      Bre = Brd;
      Log.i("MicroMsg.BoxWebViewPreloadManager", "init enablePreloadWebView config: %d, configFindTab: %d, enablePreload: %b, enablePreloadAfterGet: %b, enablePreloadFromFindTab: %b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(Brd), Boolean.valueOf(Bre), Boolean.valueOf(Brf) });
      long l = System.currentTimeMillis();
      Brh = new MMHandler(Looper.getMainLooper());
      Log.d("MicroMsg.BoxWebViewPreloadManager", "createWebViewHandlerThread start cost %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(285902);
      return;
      bool = false;
      break;
    }
  }
  
  public static final BoxWebView a(Context paramContext, kotlin.g.a.q<? super Boolean, ? super Boolean, ? super Boolean, x> paramq)
  {
    AppMethodBeat.i(285898);
    p.k(paramContext, "context");
    p.k(paramq, "callback");
    Object localObject = elI();
    boolean bool;
    if (localObject == null)
    {
      paramContext = new BoxWebView(paramContext);
      bool = false;
    }
    for (;;)
    {
      paramq.c(Boolean.valueOf(Brd), Boolean.valueOf(Brf), Boolean.valueOf(bool));
      if ((Bre) && (Brd) && (Bre))
      {
        Log.v("MicroMsg.BoxWebViewPreloadManager", "alvinluo preloadBoxWebView delay: %d", new Object[] { Long.valueOf(1500L) });
        paramq = (a)a.Brj;
        localObject = Brh;
        if (localObject != null) {
          ((MMHandler)localObject).postDelayed((Runnable)new b(paramq), 1500L);
        }
      }
      AppMethodBeat.o(285898);
      return paramContext;
      ((BoxWebView)localObject).aD(paramContext);
      bool = true;
      paramContext = (Context)localObject;
    }
  }
  
  private static BoxWebView elI()
  {
    x localx = null;
    AppMethodBeat.i(285899);
    Object localObject3 = Brg;
    Object localObject1 = localx;
    try
    {
      if (Brc != null)
      {
        BoxWebView localBoxWebView = Brc;
        if (localBoxWebView == null) {
          p.iCn();
        }
        localObject1 = localx;
        if (!localBoxWebView.isDestroyed())
        {
          Log.v("MicroMsg.BoxWebViewPreloadManager", "alvinluo fetchBoxWebView use preload webView");
          localObject1 = Brc;
          Brc = null;
        }
      }
      localx = x.aazN;
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(285899);
    }
  }
  
  /* Error */
  private final void elJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 239
    //   4: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 220	com/tencent/mm/plugin/finder/webview/f:Brc	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   10: astore_2
    //   11: getstatic 220	com/tencent/mm/plugin/finder/webview/f:Brc	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +104 -> 120
    //   19: aload_1
    //   20: invokevirtual 227	com/tencent/mm/plugin/box/webview/BoxWebView:isDestroyed	()Z
    //   23: invokestatic 122	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   26: astore_1
    //   27: ldc 109
    //   29: ldc 241
    //   31: iconst_2
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: aload_2
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_1
    //   42: aastore
    //   43: invokestatic 192	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   46: getstatic 76	com/tencent/mm/plugin/finder/webview/f:Brg	Ljava/lang/Object;
    //   49: astore_1
    //   50: aload_1
    //   51: monitorenter
    //   52: getstatic 220	com/tencent/mm/plugin/finder/webview/f:Brc	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   55: ifnull +21 -> 76
    //   58: getstatic 220	com/tencent/mm/plugin/finder/webview/f:Brc	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   61: astore_2
    //   62: aload_2
    //   63: ifnonnull +6 -> 69
    //   66: invokestatic 223	kotlin/g/b/p:iCn	()V
    //   69: aload_2
    //   70: invokevirtual 227	com/tencent/mm/plugin/box/webview/BoxWebView:isDestroyed	()Z
    //   73: ifeq +33 -> 106
    //   76: ldc 109
    //   78: ldc 243
    //   80: invokestatic 232	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: new 176	com/tencent/mm/plugin/box/webview/BoxWebView
    //   86: dup
    //   87: new 245	android/content/MutableContextWrapper
    //   90: dup
    //   91: invokestatic 251	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   94: invokespecial 252	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   97: checkcast 254	android/content/Context
    //   100: invokespecial 179	com/tencent/mm/plugin/box/webview/BoxWebView:<init>	(Landroid/content/Context;)V
    //   103: putstatic 220	com/tencent/mm/plugin/finder/webview/f:Brc	Lcom/tencent/mm/plugin/box/webview/BoxWebView;
    //   106: getstatic 238	kotlin/x:aazN	Lkotlin/x;
    //   109: astore_2
    //   110: aload_1
    //   111: monitorexit
    //   112: ldc 239
    //   114: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_0
    //   118: monitorexit
    //   119: return
    //   120: aconst_null
    //   121: astore_1
    //   122: goto -95 -> 27
    //   125: astore_2
    //   126: aload_1
    //   127: monitorexit
    //   128: ldc 239
    //   130: invokestatic 159	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_2
    //   134: athrow
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	f
    //   135	4	1	localObject2	Object
    //   10	100	2	localObject3	Object
    //   125	9	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   52	62	125	finally
    //   66	69	125	finally
    //   69	76	125	finally
    //   76	106	125	finally
    //   106	110	125	finally
    //   2	15	135	finally
    //   19	27	135	finally
    //   27	52	135	finally
    //   110	117	135	finally
    //   126	135	135	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements a<x>
  {
    public static final a Brj;
    
    static
    {
      AppMethodBeat.i(271678);
      Brj = new a();
      AppMethodBeat.o(271678);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(275114);
      a locala = this.$block;
      Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new a(locala));
      AppMethodBeat.o(275114);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(a parama) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(276845);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        this.$block.invoke();
        AppMethodBeat.o(276845);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.f
 * JD-Core Version:    0.7.0.1
 */