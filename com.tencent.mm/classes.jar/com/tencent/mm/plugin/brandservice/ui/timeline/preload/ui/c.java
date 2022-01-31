package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.b.j;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mmkv.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheWebViews", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$CacheWebView;", "Lkotlin/collections/HashMap;", "contentBuff", "Lcom/tencent/mmkv/NativeBuffer;", "priorityWebView", "", "createWebView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "delayInitJsAPI", "getNativeBuffer", "size", "getWebViewFromCache", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "tmplType", "onStartCreate", "", "obtainPreloadTmplWebView", "obtainTmplWebView", "pick", "preloadWebViewInner", "", "replaceContext", "mmWebView", "tryPreloadAllTmplWebview", "tryPreloadTmplWebview", "updateTmplWebview", "type", "contentId", "url", "startLoadPage", "clear", "CacheWebView", "plugin-brandservice_release"})
public final class c
{
  private static final String TAG = "MicroMsg.Preload.PreloadWebviewManager";
  private static HashMap<Integer, c.a> kdT;
  private static boolean kdU;
  private static d kdV;
  public static final c kdW;
  
  static
  {
    AppMethodBeat.i(15045);
    kdW = new c();
    TAG = "MicroMsg.Preload.PreloadWebviewManager";
    kdT = new HashMap();
    kdV = new d(0L, 0);
    AppMethodBeat.o(15045);
  }
  
  private static MMWebView a(Context paramContext, int paramInt, long paramLong)
  {
    AppMethodBeat.i(152748);
    b localb = sF(paramInt);
    if (localb != null)
    {
      ab.v(TAG, "[obtainPreloadWebview] preloadWebviews");
      paramContext = a((MMWebView)localb, paramContext);
      paramContext.getPerformanceHelper().aX("onCreateStart", paramLong);
      paramContext.getPerformanceHelper().aX("onCreateEnd", System.currentTimeMillis());
      AppMethodBeat.o(152748);
      return paramContext;
    }
    AppMethodBeat.o(152748);
    return null;
  }
  
  /* Error */
  public static final MMWebView a(Context paramContext, TmplParams paramTmplParams)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 15042
    //   6: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 139
    //   12: invokestatic 145	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   18: lstore_2
    //   19: aload_1
    //   20: ifnonnull +24 -> 44
    //   23: getstatic 80	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/c:TAG	Ljava/lang/String;
    //   26: ldc 147
    //   28: invokestatic 150	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   31: aconst_null
    //   32: astore_0
    //   33: sipush 15042
    //   36: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: getstatic 80	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/c:TAG	Ljava/lang/String;
    //   47: ldc 152
    //   49: iconst_1
    //   50: anewarray 4	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_1
    //   56: aastore
    //   57: invokestatic 155	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: aload_1
    //   62: getfield 161	com/tencent/mm/plugin/webview/preload/TmplParams:kbM	I
    //   65: lload_2
    //   66: invokestatic 163	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/c:a	(Landroid/content/Context;IJ)Lcom/tencent/mm/ui/widget/MMWebView;
    //   69: astore_0
    //   70: sipush 15042
    //   73: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -37 -> 39
    //   79: astore_0
    //   80: ldc 2
    //   82: monitorexit
    //   83: aload_0
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramContext	Context
    //   0	85	1	paramTmplParams	TmplParams
    //   18	48	2	l	long
    // Exception table:
    //   from	to	target	type
    //   3	19	79	finally
    //   23	31	79	finally
    //   33	39	79	finally
    //   44	76	79	finally
  }
  
  private static MMWebView a(MMWebView paramMMWebView, Context paramContext)
  {
    AppMethodBeat.i(15044);
    j.q(paramMMWebView, "mmWebView");
    j.q(paramContext, "context");
    if ((paramMMWebView.getContext() instanceof MutableContextWrapper))
    {
      Context localContext = paramMMWebView.getContext();
      if (localContext == null)
      {
        paramMMWebView = new v("null cannot be cast to non-null type android.content.MutableContextWrapper");
        AppMethodBeat.o(15044);
        throw paramMMWebView;
      }
      ((MutableContextWrapper)localContext).setBaseContext(paramContext);
    }
    AppMethodBeat.o(15044);
    return paramMMWebView;
  }
  
  /* Error */
  public static final void a(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: sipush 15040
    //   6: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: ldc 183
    //   12: invokestatic 145	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_2
    //   16: ldc 184
    //   18: invokestatic 145	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: getstatic 85	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/c:kdT	Ljava/util/HashMap;
    //   24: iload_0
    //   25: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   28: invokevirtual 194	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 6	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/c$a
    //   34: astore 5
    //   36: aload 5
    //   38: ifnull +37 -> 75
    //   41: aload 5
    //   43: getfield 198	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/c$a:kdY	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/b;
    //   46: astore 5
    //   48: aload 5
    //   50: ifnull +25 -> 75
    //   53: aload 5
    //   55: aload_1
    //   56: aload_2
    //   57: lload_3
    //   58: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   61: invokevirtual 204	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/b:b	(Ljava/lang/String;Ljava/lang/String;JJ)Z
    //   64: pop
    //   65: sipush 15040
    //   68: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: ldc 2
    //   73: monitorexit
    //   74: return
    //   75: sipush 15040
    //   78: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: goto -10 -> 71
    //   84: astore_1
    //   85: ldc 2
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramInt	int
    //   0	90	1	paramString1	String
    //   0	90	2	paramString2	String
    //   0	90	3	paramLong	long
    //   34	20	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	36	84	finally
    //   41	48	84	finally
    //   53	71	84	finally
    //   75	81	84	finally
  }
  
  public static final void aYG()
  {
    AppMethodBeat.i(152744);
    sC(-1);
    AppMethodBeat.o(152744);
  }
  
  private static b b(TmplParams paramTmplParams, boolean paramBoolean)
  {
    AppMethodBeat.i(15041);
    if (paramTmplParams == null)
    {
      ab.w(TAG, "[preloadWebViewInner] tmplParams is null");
      AppMethodBeat.o(15041);
      return null;
    }
    if (paramTmplParams.kbM == -1)
    {
      ab.w(TAG, "[preloadWebViewInner] tmplType %d", new Object[] { Integer.valueOf(paramTmplParams.kbM) });
      AppMethodBeat.o(15041);
      return null;
    }
    if (bo.isNullOrNil(paramTmplParams.keN))
    {
      ab.w(TAG, "[preloadWebViewInner] initUrl " + paramTmplParams.keN + " is empty");
      AppMethodBeat.o(15041);
      return null;
    }
    if (!e.cN(paramTmplParams.uYJ))
    {
      ab.w(TAG, "[preloadWebViewInner] filePath %s isn't exist", new Object[] { paramTmplParams.uYJ });
      AppMethodBeat.o(15041);
      return null;
    }
    long l1 = System.currentTimeMillis();
    paramTmplParams = new b((Context)new MutableContextWrapper(ah.getContext()), paramTmplParams, paramBoolean);
    if (paramBoolean)
    {
      kdU = true;
      paramTmplParams.f((a.f.a.b)c.b.keb);
    }
    long l2 = System.currentTimeMillis();
    ab.v(TAG, "terry performance create tmplWebView:%dms", new Object[] { Long.valueOf(l2 - l1) });
    AppMethodBeat.o(15041);
    return paramTmplParams;
  }
  
  public static final MMWebView b(Context paramContext, TmplParams paramTmplParams)
  {
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(15043);
        j.q(paramContext, "context");
        l = System.currentTimeMillis();
        ab.v(TAG, "[obtainTmplWebView]tmplParams:%s", new Object[] { paramTmplParams });
        if (paramTmplParams == null)
        {
          paramContext = TAG;
          j.ebi();
          ab.w(paramContext, "[preloadWebViewInner] tmplParams %s is null", new Object[] { paramTmplParams.keN });
          AppMethodBeat.o(15043);
          paramContext = null;
          return paramContext;
        }
        MMWebView localMMWebView = a(paramContext, paramTmplParams.kbM, l);
        if (localMMWebView != null)
        {
          AppMethodBeat.o(15043);
          paramContext = localMMWebView;
          continue;
        }
        paramTmplParams = b(paramTmplParams, true);
      }
      finally {}
      if (paramTmplParams == null)
      {
        AppMethodBeat.o(15043);
        paramContext = null;
      }
      else
      {
        paramContext = a((MMWebView)paramTmplParams, paramContext);
        paramContext.getPerformanceHelper().aX("onCreateStart", l);
        paramContext.getPerformanceHelper().aX("onCreateEnd", System.currentTimeMillis());
        AppMethodBeat.o(15043);
      }
    }
  }
  
  private static void q(b paramb)
  {
    AppMethodBeat.i(152747);
    try
    {
      paramb.kdw.clear();
      paramb.removeAllViews();
      paramb.stopLoading();
      paramb.clearHistory();
      paramb.clearView();
      paramb.destroy();
      y localy = y.BMg;
      return;
    }
    finally
    {
      AppMethodBeat.o(152747);
    }
  }
  
  public static void sC(int paramInt)
  {
    AppMethodBeat.i(152745);
    g.a locala = g.kbz;
    if (g.a.aXA())
    {
      AppMethodBeat.o(152745);
      return;
    }
    if (kdU)
    {
      AppMethodBeat.o(152745);
      return;
    }
    al.d((Runnable)new d(paramInt));
    AppMethodBeat.o(152745);
  }
  
  public static final d sD(int paramInt)
  {
    AppMethodBeat.i(15038);
    paramInt = 1048576 * (int)Math.ceil(paramInt / 1048576.0D);
    d locald;
    if (kdV.AZY == 0L)
    {
      locald = as.createNativeBuffer(paramInt);
      j.p(locald, "MultiProcessMMKV.createNativeBuffer(calcSize)");
      kdV = locald;
    }
    for (;;)
    {
      locald = kdV;
      AppMethodBeat.o(15038);
      return locald;
      if (kdV.size < paramInt)
      {
        as.destroyNativeBuffer(kdV);
        locald = as.createNativeBuffer(paramInt);
        j.p(locald, "MultiProcessMMKV.createNativeBuffer(calcSize)");
        kdV = locald;
      }
    }
  }
  
  private final void sE(int paramInt)
  {
    c.a locala1;
    int i;
    label74:
    label82:
    try
    {
      AppMethodBeat.i(152746);
      ab.i(TAG, "[preloadWebViewInner]tmplParams: ".concat(String.valueOf(paramInt)));
      locala1 = (c.a)kdT.get(Integer.valueOf(paramInt));
      if (locala1 == null) {
        break label204;
      }
      if (locala1.kdY != null)
      {
        i = 1;
        break label390;
        if (i != 1) {
          break label204;
        }
        ab.w(TAG, "[preloadWebViewInner] already preinit, ignore");
        AppMethodBeat.o(152746);
        return;
      }
      i = 0;
    }
    finally {}
    if ((locala1.kdX != null) && (System.currentTimeMillis() - locala1.createTime < 5000L)) {
      i = 1;
    }
    label390:
    label413:
    for (;;)
    {
      for (;;)
      {
        j.p(locala1, "cache");
        try
        {
          b localb = locala1.kdX;
          if (localb != null) {
            q(localb);
          }
          locala1.kdX = null;
          localb = locala1.kdY;
          if (localb != null) {
            q(localb);
          }
          locala1.kdY = null;
          locala1.createTime = 0L;
          kdT.remove(Integer.valueOf(locala1.kbM));
          i = 0;
          break;
        }
        finally
        {
          AppMethodBeat.o(152746);
        }
      }
      label204:
      Object localObject2 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.sw(paramInt);
      Object localObject4 = kdT;
      if (((Map)localObject4).containsKey(Integer.valueOf(paramInt)))
      {
        localObject4 = ((HashMap)localObject4).get(Integer.valueOf(paramInt));
        if (localObject4 == null) {
          j.ebi();
        }
        c.a locala2 = (c.a)localObject4;
        locala2.kdX = b((TmplParams)localObject2, false);
        locala2.createTime = System.currentTimeMillis();
        localObject2 = (c.a)localObject4;
      }
      for (;;)
      {
        j.p(localObject2, "cacheWebViews.let {\n    …}\n            }\n        }");
        localObject4 = ((c.a)localObject2).kdX;
        if (localObject4 == null) {
          break label381;
        }
        localObject4 = ((b)localObject4).f((a.f.a.b)new c.c((c.a)localObject2));
        if (localObject4 == null) {
          break label381;
        }
        j.q(localObject4, "<set-?>");
        ((c.a)localObject2).kdZ = ((a.f.a.b)localObject4);
        AppMethodBeat.o(152746);
        break;
        localObject2 = new c.a(paramInt, System.currentTimeMillis(), b((TmplParams)localObject2, false));
        ((Map)localObject4).put(Integer.valueOf(paramInt), localObject2);
      }
      label381:
      AppMethodBeat.o(152746);
      break label74;
      if (1 != i) {
        break label82;
      }
      i = 1;
      break;
      for (;;)
      {
        if (1 != i) {
          break label413;
        }
        i = 1;
        break;
        i = 0;
      }
    }
  }
  
  private static b sF(int paramInt)
  {
    AppMethodBeat.i(154583);
    c.a locala = (c.a)kdT.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      b localb1 = locala.kdY;
      if (localb1 != null)
      {
        locala.createTime = 0L;
        b localb2 = locala.kdX;
        if (localb2 != null) {
          q(localb2);
        }
        locala.kdX = null;
        locala.kdY = null;
        kdT.remove(Integer.valueOf(paramInt));
        AppMethodBeat.o(154583);
        return localb1;
      }
    }
    AppMethodBeat.o(154583);
    return null;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(15035);
      Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new c.d.1(this));
      AppMethodBeat.o(15035);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.c
 * JD-Core Version:    0.7.0.1
 */