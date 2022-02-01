package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.h.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.protocal.protobuf.dog;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.vfs.o;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager;", "", "()V", "TAG", "", "cacheControllers", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "contentBuff", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV$NativeBuffer;", "priorityWebView", "", "startredControllers", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "createWebViewController", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "contextWrapper", "Landroid/content/MutableContextWrapper;", "getNativeBuffer", "size", "getWebViewFromCache", "tmplType", "intent", "Landroid/content/Intent;", "onStartCreate", "", "obtainPreloadTmplWebView", "obtainTmplWebView", "pick", "preloadWebViewInner", "", "tryPreloadAllTmplWebview", "tryPreloadTmplWebview", "updateTmplWebview", "clear", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "MPWebView", "plugin-brandservice_release"})
public final class a
{
  private static final String TAG = "MicroMsg.Preload.TmplWebViewManager";
  private static final ConcurrentHashMap<Integer, MpWebViewController> otp;
  private static final ConcurrentHashMap<Integer, MpWebViewController> otq;
  private static boolean otr;
  private static ay.a ots;
  public static final a ott;
  
  static
  {
    AppMethodBeat.i(6940);
    ott = new a();
    TAG = "MicroMsg.Preload.TmplWebViewManager";
    otp = new ConcurrentHashMap();
    otq = new ConcurrentHashMap();
    ots = new ay.a();
    AppMethodBeat.o(6940);
  }
  
  public static void Ab(int paramInt)
  {
    AppMethodBeat.i(6930);
    h.a locala = h.oph;
    if (h.a.bQt())
    {
      AppMethodBeat.o(6930);
      return;
    }
    if (otr)
    {
      AppMethodBeat.o(6930);
      return;
    }
    ae.i(TAG, "tryPreloadTmplWebview:".concat(String.valueOf(paramInt)));
    c.h((d.g.a.a)new c(paramInt));
    AppMethodBeat.o(6930);
  }
  
  private final void Ac(final int paramInt)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(6931);
        ae.i(TAG, "[preloadWebViewInner]tmplParams: ".concat(String.valueOf(paramInt)));
        Object localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.zY(paramInt);
        if (localObject1 == null) {
          break label203;
        }
        if (!otp.containsKey(Integer.valueOf(paramInt)))
        {
          localObject1 = a((dog)localObject1, new MutableContextWrapper(ak.getContext()));
          if (localObject1 != null)
          {
            ((Map)otp).put(Integer.valueOf(paramInt), localObject1);
            Object localObject3 = MpWebViewController.osJ;
            int i = MpWebViewController.bRG();
            localObject3 = (d.g.a.a)new b((MpWebViewController)localObject1, paramInt);
            p.h(localObject3, "callback");
            ((BaseWebViewController)localObject1).WX(i).add(localObject3);
            ae.i(TAG, "preload:" + paramInt + ", " + ((MpWebViewController)localObject1).eQU());
            AppMethodBeat.o(6931);
            return;
          }
          AppMethodBeat.o(6931);
          continue;
        }
        ae.i(TAG, "preload skip when exist:".concat(String.valueOf(paramInt)));
      }
      finally {}
      AppMethodBeat.o(6931);
      continue;
      label203:
      AppMethodBeat.o(6931);
    }
  }
  
  /* Error */
  public static final MpWebViewController a(Context paramContext, dog paramdog)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 239
    //   5: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ldc 240
    //   11: invokestatic 201	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: aload_1
    //   15: ldc 241
    //   17: invokestatic 201	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   20: invokestatic 247	java/lang/System:currentTimeMillis	()J
    //   23: lstore_2
    //   24: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   27: new 214	java/lang/StringBuilder
    //   30: dup
    //   31: ldc 249
    //   33: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: getfield 255	com/tencent/mm/protocal/protobuf/dog:opt	I
    //   40: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 258	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload_1
    //   50: new 163	android/content/MutableContextWrapper
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 172	android/content/MutableContextWrapper:<init>	(Landroid/content/Context;)V
    //   58: invokestatic 175	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:a	(Lcom/tencent/mm/protocal/protobuf/dog;Landroid/content/MutableContextWrapper;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull +43 -> 106
    //   66: aload_0
    //   67: getfield 261	com/tencent/mm/plugin/webview/core/BaseWebViewController:osM	Lcom/tencent/mm/ui/widget/MMWebView;
    //   70: invokevirtual 267	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   73: ldc_w 269
    //   76: lload_2
    //   77: invokevirtual 275	com/tencent/mm/pluginsdk/r:bM	(Ljava/lang/String;J)V
    //   80: aload_0
    //   81: getfield 261	com/tencent/mm/plugin/webview/core/BaseWebViewController:osM	Lcom/tencent/mm/ui/widget/MMWebView;
    //   84: invokevirtual 267	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   87: ldc_w 277
    //   90: invokestatic 247	java/lang/System:currentTimeMillis	()J
    //   93: invokevirtual 275	com/tencent/mm/pluginsdk/r:bM	(Ljava/lang/String;J)V
    //   96: ldc 239
    //   98: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: ldc 2
    //   103: monitorexit
    //   104: aload_0
    //   105: areturn
    //   106: aconst_null
    //   107: astore_0
    //   108: ldc 239
    //   110: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: goto -12 -> 101
    //   116: astore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramContext	Context
    //   0	122	1	paramdog	dog
    //   23	54	2	l	long
    // Exception table:
    //   from	to	target	type
    //   3	62	116	finally
    //   66	101	116	finally
    //   108	113	116	finally
  }
  
  /* Error */
  public static final MpWebViewController a(Context paramContext, dog paramdog, Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 279
    //   6: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: ldc 240
    //   12: invokestatic 201	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_1
    //   16: ldc 241
    //   18: invokestatic 201	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   21: aload_2
    //   22: ldc_w 280
    //   25: invokestatic 201	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   28: invokestatic 247	java/lang/System:currentTimeMillis	()J
    //   31: lstore_3
    //   32: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   35: new 214	java/lang/StringBuilder
    //   38: dup
    //   39: ldc_w 282
    //   42: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: getfield 255	com/tencent/mm/protocal/protobuf/dog:opt	I
    //   49: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 258	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: getstatic 82	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:ott	Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a;
    //   61: aload_1
    //   62: getfield 255	com/tencent/mm/protocal/protobuf/dog:opt	I
    //   65: aload_2
    //   66: invokespecial 286	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:c	(ILandroid/content/Intent;)Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull +59 -> 130
    //   74: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   77: ldc_w 288
    //   80: invokestatic 258	com/tencent/mm/sdk/platformtools/ae:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_1
    //   84: getfield 261	com/tencent/mm/plugin/webview/core/BaseWebViewController:osM	Lcom/tencent/mm/ui/widget/MMWebView;
    //   87: astore_2
    //   88: aload_2
    //   89: invokevirtual 267	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   92: ldc_w 269
    //   95: lload_3
    //   96: invokevirtual 275	com/tencent/mm/pluginsdk/r:bM	(Ljava/lang/String;J)V
    //   99: aload_2
    //   100: aload_0
    //   101: invokevirtual 291	com/tencent/mm/ui/widget/MMWebView:ax	(Landroid/content/Context;)V
    //   104: aload_2
    //   105: invokevirtual 267	com/tencent/mm/ui/widget/MMWebView:getPerformanceHelper	()Lcom/tencent/mm/pluginsdk/r;
    //   108: ldc_w 277
    //   111: invokestatic 247	java/lang/System:currentTimeMillis	()J
    //   114: invokevirtual 275	com/tencent/mm/pluginsdk/r:bM	(Ljava/lang/String;J)V
    //   117: ldc_w 279
    //   120: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_1
    //   124: astore_0
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_0
    //   129: areturn
    //   130: aconst_null
    //   131: astore_0
    //   132: ldc_w 279
    //   135: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: goto -13 -> 125
    //   141: astore_0
    //   142: ldc 2
    //   144: monitorexit
    //   145: aload_0
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramContext	Context
    //   0	147	1	paramdog	dog
    //   0	147	2	paramIntent	Intent
    //   31	65	3	l	long
    // Exception table:
    //   from	to	target	type
    //   3	70	141	finally
    //   74	123	141	finally
    //   132	138	141	finally
  }
  
  private static MpWebViewController a(dog paramdog, MutableContextWrapper paramMutableContextWrapper)
  {
    AppMethodBeat.i(209077);
    if (paramdog.opt == -1)
    {
      ae.w(TAG, "[preloadWebViewInner] empty tmplType %d", new Object[] { Integer.valueOf(paramdog.opt) });
      AppMethodBeat.o(209077);
      return null;
    }
    if (bu.isNullOrNil(paramdog.EfF))
    {
      ae.w(TAG, "[preloadWebViewInner] initUrl " + paramdog.EfF + " is empty");
      AppMethodBeat.o(209077);
      return null;
    }
    if (!o.fB(paramdog.HVh))
    {
      ae.w(TAG, "[preloadWebViewInner] filePath %s isn't exist", new Object[] { paramdog.HVh });
      AppMethodBeat.o(209077);
      return null;
    }
    paramdog = new MpWebViewController(paramdog, ew((Context)paramMutableContextWrapper));
    paramdog.init();
    AppMethodBeat.o(209077);
    return paramdog;
  }
  
  /* Error */
  public static final void ai(Intent paramIntent)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc_w 343
    //   8: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_0
    //   12: ldc_w 280
    //   15: invokestatic 201	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   18: getstatic 348	com/tencent/mm/ui/e$m:Jpp	Ljava/lang/String;
    //   21: astore_3
    //   22: aload_3
    //   23: ldc_w 350
    //   26: invokestatic 353	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 359	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +329 -> 365
    //   39: aload_3
    //   40: arraylength
    //   41: istore_1
    //   42: iload_1
    //   43: ifne +294 -> 337
    //   46: iconst_1
    //   47: istore_1
    //   48: iload_1
    //   49: ifne +293 -> 342
    //   52: iload_2
    //   53: istore_1
    //   54: iload_1
    //   55: ifeq +310 -> 365
    //   58: ldc 251
    //   60: invokevirtual 365	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   63: astore 4
    //   65: aload 4
    //   67: checkcast 367	com/tencent/mm/bw/a
    //   70: aload_3
    //   71: invokevirtual 371	com/tencent/mm/bw/a:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   74: pop
    //   75: aload 4
    //   77: checkcast 367	com/tencent/mm/bw/a
    //   80: astore_3
    //   81: aload_3
    //   82: checkcast 251	com/tencent/mm/protocal/protobuf/dog
    //   85: astore 4
    //   87: aload 4
    //   89: astore_3
    //   90: aload 4
    //   92: ifnonnull +99 -> 191
    //   95: new 373	android/content/res/Resources$NotFoundException
    //   98: dup
    //   99: ldc_w 375
    //   102: invokespecial 376	android/content/res/Resources$NotFoundException:<init>	(Ljava/lang/String;)V
    //   105: checkcast 378	java/lang/Throwable
    //   108: astore_3
    //   109: ldc_w 343
    //   112: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_3
    //   116: athrow
    //   117: astore_3
    //   118: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   121: new 214	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 380
    //   128: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload_3
    //   132: invokevirtual 383	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: bipush 32
    //   140: invokevirtual 386	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokestatic 392	com/tencent/mm/plugin/brandservice/ui/timeline/preload/d:ag	(Landroid/content/Intent;)Ljava/lang/String;
    //   147: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 395	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: sipush 152
    //   159: invokestatic 400	com/tencent/mm/plugin/webview/g/a:XA	(I)V
    //   162: getstatic 406	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   165: sipush 17260
    //   168: iconst_2
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: iconst_2
    //   175: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: aastore
    //   179: dup
    //   180: iconst_1
    //   181: aload_0
    //   182: invokestatic 392	com/tencent/mm/plugin/brandservice/ui/timeline/preload/d:ag	(Landroid/content/Intent;)Ljava/lang/String;
    //   185: aastore
    //   186: invokevirtual 410	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   189: aconst_null
    //   190: astore_3
    //   191: aload_3
    //   192: ifnull +244 -> 436
    //   195: aload_3
    //   196: getfield 255	com/tencent/mm/protocal/protobuf/dog:opt	I
    //   199: istore_1
    //   200: getstatic 89	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:otp	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: iload_1
    //   204: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokevirtual 414	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 183	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   213: astore_3
    //   214: aload_3
    //   215: ifnull +190 -> 405
    //   218: aload_3
    //   219: getstatic 417	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:osz	I
    //   222: invokevirtual 421	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:WZ	(I)Z
    //   225: ifeq +145 -> 370
    //   228: getstatic 89	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:otp	Ljava/util/concurrent/ConcurrentHashMap;
    //   231: iload_1
    //   232: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   235: invokevirtual 424	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   238: pop
    //   239: aload_3
    //   240: aload_0
    //   241: invokevirtual 427	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:au	(Landroid/content/Intent;)V
    //   244: getstatic 91	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:otq	Ljava/util/concurrent/ConcurrentHashMap;
    //   247: iload_1
    //   248: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: invokevirtual 424	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   254: checkcast 183	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController
    //   257: astore_0
    //   258: aload_0
    //   259: ifnull +7 -> 266
    //   262: aload_0
    //   263: invokevirtual 430	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:destroy	()V
    //   266: getstatic 91	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:otq	Ljava/util/concurrent/ConcurrentHashMap;
    //   269: checkcast 177	java/util/Map
    //   272: astore_0
    //   273: aload_3
    //   274: ldc_w 432
    //   277: invokestatic 353	d/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   280: aload_0
    //   281: iload_1
    //   282: invokestatic 157	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aload_3
    //   286: invokeinterface 181 3 0
    //   291: pop
    //   292: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   295: new 214	java/lang/StringBuilder
    //   298: dup
    //   299: ldc_w 434
    //   302: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: iload_1
    //   306: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: ldc 225
    //   311: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_3
    //   315: invokevirtual 231	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:eQU	()I
    //   318: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 133	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: ldc_w 343
    //   330: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: ldc 2
    //   335: monitorexit
    //   336: return
    //   337: iconst_0
    //   338: istore_1
    //   339: goto -291 -> 48
    //   342: iconst_0
    //   343: istore_1
    //   344: goto -290 -> 54
    //   347: astore_3
    //   348: ldc_w 436
    //   351: aload_3
    //   352: checkcast 378	java/lang/Throwable
    //   355: ldc_w 438
    //   358: iconst_0
    //   359: anewarray 4	java/lang/Object
    //   362: invokestatic 442	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aconst_null
    //   366: astore_3
    //   367: goto -286 -> 81
    //   370: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   373: new 214	java/lang/StringBuilder
    //   376: dup
    //   377: ldc_w 444
    //   380: invokespecial 219	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   383: iload_1
    //   384: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: ldc 225
    //   389: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: aload_3
    //   393: invokevirtual 231	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController:eQU	()I
    //   396: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   399: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 313	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: getstatic 84	com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/a:TAG	Ljava/lang/String;
    //   408: ldc_w 446
    //   411: iload_1
    //   412: invokestatic 124	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   415: invokevirtual 128	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   418: invokestatic 313	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: ldc_w 343
    //   424: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: goto -94 -> 333
    //   430: astore_0
    //   431: ldc 2
    //   433: monitorexit
    //   434: aload_0
    //   435: athrow
    //   436: ldc_w 343
    //   439: invokestatic 99	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   442: goto -109 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	paramIntent	Intent
    //   41	371	1	i	int
    //   1	52	2	j	int
    //   21	95	3	localObject1	Object
    //   117	15	3	localException1	java.lang.Exception
    //   190	125	3	localMpWebViewController	MpWebViewController
    //   347	5	3	localException2	java.lang.Exception
    //   366	27	3	localObject2	Object
    //   63	28	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   18	35	117	java/lang/Exception
    //   39	42	117	java/lang/Exception
    //   81	87	117	java/lang/Exception
    //   95	117	117	java/lang/Exception
    //   348	365	117	java/lang/Exception
    //   58	81	347	java/lang/Exception
    //   5	18	430	finally
    //   18	35	430	finally
    //   39	42	430	finally
    //   58	81	430	finally
    //   81	87	430	finally
    //   95	117	430	finally
    //   118	189	430	finally
    //   195	214	430	finally
    //   218	258	430	finally
    //   262	266	430	finally
    //   266	333	430	finally
    //   348	365	430	finally
    //   370	405	430	finally
    //   405	427	430	finally
    //   436	442	430	finally
  }
  
  public static final void bRZ()
  {
    AppMethodBeat.i(6929);
    Ab(-1);
    AppMethodBeat.o(6929);
  }
  
  private final MpWebViewController c(int paramInt, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(209076);
        MpWebViewController localMpWebViewController = (MpWebViewController)otq.get(Integer.valueOf(paramInt));
        if ((localMpWebViewController != null) && (localMpWebViewController.ah(paramIntent)))
        {
          ae.i(TAG, "pick started:" + paramInt + ", " + localMpWebViewController.eQU());
          otq.remove(Integer.valueOf(paramInt));
          AppMethodBeat.o(209076);
          paramIntent = localMpWebViewController;
          return paramIntent;
        }
        paramIntent = (MpWebViewController)otp.get(Integer.valueOf(paramInt));
        if (paramIntent != null)
        {
          if (paramIntent.WZ(MpWebViewController.osz))
          {
            otp.remove(Integer.valueOf(paramInt));
            ae.i(TAG, "pick cached:" + paramInt + ", " + paramIntent.eQU());
            AppMethodBeat.o(209076);
            continue;
          }
          ae.w(TAG, "pick null when tmpl not ready:" + paramInt + ", " + paramIntent.eQU());
        }
      }
      finally {}
      ae.w(TAG, "pick null:".concat(String.valueOf(paramInt)));
      paramIntent = null;
      AppMethodBeat.o(209076);
    }
  }
  
  private static MMWebView ew(Context paramContext)
  {
    AppMethodBeat.i(209078);
    WebView.c localc = MMWebView.LoI;
    String str;
    if (ak.coh()) {
      str = "mm";
    }
    for (;;)
    {
      WebView.initWebviewCore(paramContext, localc, str, null);
      paramContext = (MMWebView)new a(paramContext);
      AppMethodBeat.o(209078);
      return paramContext;
      if (ak.foD()) {
        str = "toolsmp";
      } else {
        str = "tools";
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$MPWebView;", "Lcom/tencent/mm/ui/widget/MMWebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentUrlProxy", "Lkotlin/Function0;", "", "getCurrentUrlProxy", "()Lkotlin/jvm/functions/Function0;", "setCurrentUrlProxy", "(Lkotlin/jvm/functions/Function0;)V", "validUrlProxy", "Lkotlin/Function1;", "", "getValidUrlProxy", "()Lkotlin/jvm/functions/Function1;", "setValidUrlProxy", "(Lkotlin/jvm/functions/Function1;)V", "getUrl", "plugin-brandservice_release"})
  public static final class a
    extends MMWebView
  {
    private d.g.a.a<String> otu;
    private d.g.a.b<? super String, Boolean> otv;
    
    public a(Context paramContext)
    {
      super();
      AppMethodBeat.i(209071);
      this.gff = true;
      this.isX5Kernel = getIsX5Kernel();
      AppMethodBeat.o(209071);
    }
    
    public final d.g.a.a<String> getCurrentUrlProxy()
    {
      return this.otu;
    }
    
    public final String getUrl()
    {
      AppMethodBeat.i(209070);
      Object localObject = super.getUrl();
      if ((this.otu != null) && (this.otv != null))
      {
        d.g.a.b localb = this.otv;
        if (localb == null) {
          p.gkB();
        }
        if (!((Boolean)localb.invoke(localObject)).booleanValue()) {}
      }
      else
      {
        AppMethodBeat.o(209070);
        return localObject;
      }
      localObject = this.otu;
      if (localObject == null) {
        p.gkB();
      }
      localObject = (String)((d.g.a.a)localObject).invoke();
      AppMethodBeat.o(209070);
      return localObject;
    }
    
    public final d.g.a.b<String, Boolean> getValidUrlProxy()
    {
      return this.otv;
    }
    
    public final void setCurrentUrlProxy(d.g.a.a<String> parama)
    {
      this.otu = parama;
    }
    
    public final void setValidUrlProxy(d.g.a.b<? super String, Boolean> paramb)
    {
      this.otv = paramb;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$preloadWebViewInner$1$1$1", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewManager$$special$$inlined$also$lambda$1"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(MpWebViewController paramMpWebViewController, int paramInt)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(int paramInt)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
    public static final class a
      implements MessageQueue.IdleHandler
    {
      public a(a.c paramc) {}
      
      public final boolean queueIdle()
      {
        AppMethodBeat.i(209073);
        Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
        if (this.otz.oty == -1)
        {
          Object localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.orT;
          localObject = com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.bRg();
          int j = localObject.length;
          int i = 0;
          while (i < j)
          {
            int k = ((Number)localObject[i]).intValue();
            a.a(a.ott, k);
            i += 1;
          }
        }
        a.a(a.ott, this.otz.oty);
        AppMethodBeat.o(209073);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.a
 * JD-Core Version:    0.7.0.1
 */