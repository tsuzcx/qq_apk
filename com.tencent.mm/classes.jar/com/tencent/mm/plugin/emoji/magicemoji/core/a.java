package com.tencent.mm.plugin.emoji.magicemoji.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.emoji.magicemoji.b.a;
import com.tencent.mm.plugin.emoji.magicemoji.bean.WxaPkgRecordForME;
import com.tencent.mm.plugin.emoji.magicemoji.service.MagicEmojiServiceContext;
import com.tencent.mm.plugin.emoji.magicemoji.service.MagicEmojiServiceContextAppBrand;
import com.tencent.mm.plugin.emoji.magicemoji.service.MagicEmojiServiceContextMM;
import com.tencent.mm.plugin.expansions.e.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiEntityRemote;", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiEntity;", "Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiServiceCallback$Stub;", "appIdBundle", "Lcom/tencent/mm/plugin/emoji/magicemoji/util/ConstantsMagicEmoji$AppIdBundle;", "(Lcom/tencent/mm/plugin/emoji/magicemoji/util/ConstantsMagicEmoji$AppIdBundle;)V", "binding", "", "connExceptionListener", "Ljava/util/HashSet;", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiConnExptListener;", "Lkotlin/collections/HashSet;", "defaultJsApiHandler", "", "", "Lcom/tencent/mm/plugin/emoji/magicemoji/jsapi/IJsApiDefaultHandler;", "jsApiHandler", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiJsApiHandler;", "lastBindTime", "", "lifecycleListeners", "Lcom/tencent/mm/plugin/emoji/magicemoji/api/IMagicEmojiLifecycleListener;", "mHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "mPendingMsgList", "Ljava/util/LinkedList;", "", "record", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/WxaPkgRecordForME;", "recordMgr", "Lcom/tencent/mm/plugin/emoji/magicemoji/util/MagicEmojiRecordMgr;", "service", "Lcom/tencent/mm/plugin/emoji/magicemoji/IMagicEmojiService;", "serviceConn", "com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiEntityRemote$serviceConn$1", "Lcom/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiEntityRemote$serviceConn$1;", "surface", "Landroid/view/Surface;", "surfaceHeight", "surfaceWidth", "bindService", "", "checkServiceExist", "cleanUp", "configEnvSync", "version", "exitService", "forceDownloadPkg", "getIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "invoke", "type", "data", "onServiceCreate", "onServiceDestroy", "reason", "onServicePause", "onServicePlayed", "onServiceResume", "onServiceStart", "pauseService", "postEvent", "msg", "postSurface", "width", "height", "preloadService", "registerConnExptListener", "listener", "registerJsApiHandler", "handler", "runOnMainThread", "registerLifecycleListener", "revokeSurface", "setRecord", "setService", "tryBindService", "unregisterConnExptListener", "unregisterJsApiHandler", "unregisterLifecycleListener", "Companion", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b.a
  implements com.tencent.mm.plugin.emoji.magicemoji.a.b
{
  public static final a.a xIg;
  private static final Class<? extends MagicEmojiServiceContextBase> xIt;
  private final MMHandler mHandler;
  private Surface surface;
  private int surfaceHeight;
  private int surfaceWidth;
  private final com.tencent.mm.plugin.emoji.magicemoji.d.a.a xIh;
  private WxaPkgRecordForME xIi;
  private final com.tencent.mm.plugin.emoji.magicemoji.d.d xIj;
  private com.tencent.mm.plugin.emoji.magicemoji.a xIk;
  private long xIl;
  private boolean xIm;
  private r<? extends com.tencent.mm.plugin.emoji.magicemoji.a.c, Boolean> xIn;
  private final HashSet<com.tencent.mm.plugin.emoji.magicemoji.a.d> xIo;
  private final HashSet<com.tencent.mm.plugin.emoji.magicemoji.a.a> xIp;
  private final LinkedList<r<Integer, String>> xIq;
  private final Map<Integer, com.tencent.mm.plugin.emoji.magicemoji.c.a> xIr;
  private final g xIs;
  
  static
  {
    AppMethodBeat.i(270200);
    xIg = new a.a((byte)0);
    int j = MultiProcessMMKV.getSingleMMKV("__magic_emoji__").decodeInt("target_process", 1);
    int i = j;
    switch (j)
    {
    default: 
      i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zwZ, 1);
    }
    Object localObject;
    switch (i)
    {
    default: 
      localObject = MagicEmojiServiceContextMM.class;
    }
    for (;;)
    {
      Log.i("MicroMsg.MagicEmojiEntityRemote", s.X("hy: try init magic emoji in ", ((Class)localObject).getSimpleName()));
      xIt = (Class)localObject;
      AppMethodBeat.o(270200);
      return;
      localObject = MagicEmojiServiceContext.class;
      continue;
      localObject = MagicEmojiServiceContextAppBrand.class;
    }
  }
  
  public a(com.tencent.mm.plugin.emoji.magicemoji.d.a.a parama)
  {
    AppMethodBeat.i(270076);
    this.xIh = parama;
    this.surfaceWidth = 1;
    this.surfaceHeight = 1;
    this.xIj = new com.tencent.mm.plugin.emoji.magicemoji.d.d(this.xIh);
    this.xIo = new HashSet();
    this.xIp = new HashSet();
    this.mHandler = new MMHandler(Looper.getMainLooper());
    this.xIq = new LinkedList();
    this.xIr = ak.l(new r(Integer.valueOf(4), new com.tencent.mm.plugin.emoji.magicemoji.c.a.b()));
    this.xIs = new g(this);
    AppMethodBeat.o(270076);
  }
  
  private final void cIf()
  {
    AppMethodBeat.i(270097);
    this.xIk = null;
    this.xIi = null;
    this.xIm = false;
    this.xIq.clear();
    AppMethodBeat.o(270097);
  }
  
  /* Error */
  private final void dqa()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 355
    //   5: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 348	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIm	Z
    //   12: ifeq +26 -> 38
    //   15: aload_0
    //   16: getfield 357	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIl	J
    //   19: invokestatic 363	com/tencent/mm/sdk/platformtools/Util:ticksToNow	(J)J
    //   22: ldc2_w 364
    //   25: lcmp
    //   26: ifge +12 -> 38
    //   29: ldc_w 355
    //   32: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: iconst_1
    //   40: putfield 348	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIm	Z
    //   43: aload_0
    //   44: invokestatic 369	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   47: putfield 357	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIl	J
    //   50: ldc 214
    //   52: ldc_w 371
    //   55: aload_0
    //   56: getfield 357	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIl	J
    //   59: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   62: invokestatic 228	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   65: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: invokestatic 382	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   71: astore_1
    //   72: aload_1
    //   73: ldc_w 383
    //   76: invokestatic 386	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   79: aload_1
    //   80: aload_0
    //   81: aload_1
    //   82: invokespecial 389	com/tencent/mm/plugin/emoji/magicemoji/core/a:getIntent	(Landroid/content/Context;)Landroid/content/Intent;
    //   85: aload_0
    //   86: getfield 316	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIs	Lcom/tencent/mm/plugin/emoji/magicemoji/core/a$g;
    //   89: checkcast 391	android/content/ServiceConnection
    //   92: iconst_1
    //   93: invokevirtual 396	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   96: pop
    //   97: ldc_w 355
    //   100: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: goto -68 -> 35
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	a
    //   71	11	1	localContext	Context
    //   106	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	35	106	finally
    //   38	103	106	finally
  }
  
  private final void dyJ()
  {
    AppMethodBeat.i(270084);
    if (com.tencent.mm.plugin.expansions.e.aQh())
    {
      dqa();
      AppMethodBeat.o(270084);
      return;
    }
    com.tencent.mm.plugin.expansions.e.install((e.b)new j(this));
    AppMethodBeat.o(270084);
  }
  
  private final Intent getIntent(Context paramContext)
  {
    AppMethodBeat.i(270081);
    paramContext = new Intent(paramContext, xIt);
    paramContext.putExtra("timeStamp", Util.currentTicks());
    paramContext.putExtra("appId", this.xIh.appId);
    AppMethodBeat.o(270081);
    return paramContext;
  }
  
  public final void Kk(int paramInt)
  {
    try
    {
      AppMethodBeat.i(270326);
      Log.i("MicroMsg.MagicEmojiEntityRemote", s.X("stevecai: service destroy with reason ", Integer.valueOf(paramInt)));
      Iterator localIterator = ((Iterable)this.xIo).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)localIterator.next()).Kk(paramInt);
      }
      MMApplicationContext.getContext().unbindService((ServiceConnection)this.xIs);
    }
    finally {}
    cIf();
    AppMethodBeat.o(270326);
  }
  
  public final void Kl(int paramInt)
  {
    AppMethodBeat.i(270261);
    Log.i("MicroMsg.MagicEmojiEntityRemote", s.X("stevecai: configEnvSync() called with: version = ", Integer.valueOf(paramInt)));
    ((w)h.ax(w.class)).A(this.xIh.userName, this.xIh.appId, 999);
    ((x)h.ax(x.class)).bM(this.xIh.appId, paramInt);
    AppMethodBeat.o(270261);
  }
  
  public final void a(com.tencent.mm.plugin.emoji.magicemoji.a.a parama)
  {
    try
    {
      AppMethodBeat.i(270242);
      s.u(parama, "listener");
      this.xIp.add(parama);
      AppMethodBeat.o(270242);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  /* Error */
  public final void a(com.tencent.mm.plugin.emoji.magicemoji.a.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 507
    //   5: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 508
    //   12: invokestatic 249	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 510	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIn	Lkotlin/r;
    //   19: ifnull +35 -> 54
    //   22: ldc 214
    //   24: ldc_w 512
    //   27: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload_0
    //   31: new 291	kotlin/r
    //   34: dup
    //   35: aload_1
    //   36: getstatic 520	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   39: invokespecial 303	kotlin/r:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   42: putfield 510	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIn	Lkotlin/r;
    //   45: ldc_w 507
    //   48: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: ldc 214
    //   56: new 522	java/lang/StringBuilder
    //   59: dup
    //   60: ldc_w 524
    //   63: invokespecial 527	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: invokevirtual 531	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: ldc_w 533
    //   73: invokevirtual 536	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 539	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: goto -52 -> 30
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	a
    //   0	90	1	paramc	com.tencent.mm.plugin.emoji.magicemoji.a.c
    // Exception table:
    //   from	to	target	type
    //   2	30	85	finally
    //   30	51	85	finally
    //   54	82	85	finally
  }
  
  public final void a(com.tencent.mm.plugin.emoji.magicemoji.a.d paramd)
  {
    try
    {
      AppMethodBeat.i(270227);
      s.u(paramd, "listener");
      this.xIo.add(paramd);
      AppMethodBeat.o(270227);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final void b(com.tencent.mm.plugin.emoji.magicemoji.a.a parama)
  {
    try
    {
      AppMethodBeat.i(270250);
      s.u(parama, "listener");
      this.xIp.remove(parama);
      AppMethodBeat.o(270250);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  /* Error */
  public final void b(com.tencent.mm.plugin.emoji.magicemoji.a.c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc_w 546
    //   7: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_1
    //   11: ldc_w 508
    //   14: invokestatic 249	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 510	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIn	Lkotlin/r;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnonnull +37 -> 60
    //   26: aload_1
    //   27: aload_2
    //   28: invokestatic 550	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   31: ifeq +20 -> 51
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 510	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIn	Lkotlin/r;
    //   39: ldc 214
    //   41: ldc_w 552
    //   44: aload_1
    //   45: invokestatic 228	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: ldc_w 546
    //   54: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: aload_3
    //   61: getfield 556	kotlin/r:bsC	Ljava/lang/Object;
    //   64: checkcast 558	com/tencent/mm/plugin/emoji/magicemoji/a/c
    //   67: astore_2
    //   68: goto -42 -> 26
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	a
    //   0	76	1	paramc	com.tencent.mm.plugin.emoji.magicemoji.a.c
    //   1	67	2	localObject	Object
    //   21	40	3	localr	r
    // Exception table:
    //   from	to	target	type
    //   4	22	71	finally
    //   26	51	71	finally
    //   51	57	71	finally
    //   60	68	71	finally
  }
  
  public final void b(com.tencent.mm.plugin.emoji.magicemoji.a.d paramd)
  {
    try
    {
      AppMethodBeat.i(270234);
      s.u(paramd, "listener");
      this.xIo.remove(paramd);
      AppMethodBeat.o(270234);
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public final String bd(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(270311);
    s.u(paramString, "data");
    Object localObject = this.xIn;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = (com.tencent.mm.plugin.emoji.magicemoji.c.a)this.xIr.get(Integer.valueOf(paramInt));
      if (localObject == null)
      {
        AppMethodBeat.o(270311);
        return null;
        if (((Boolean)((r)localObject).bsD).booleanValue()) {
          localObject = (String)new d((r)localObject, paramInt, paramString).exec(this.mHandler);
        } else {
          localObject = ((com.tencent.mm.plugin.emoji.magicemoji.a.c)((r)localObject).bsC).b(paramInt, new JSONObject(paramString));
        }
      }
      else
      {
        paramString = ((com.tencent.mm.plugin.emoji.magicemoji.c.a)localObject).anU(paramString);
        AppMethodBeat.o(270311);
        return paramString;
      }
    }
    AppMethodBeat.o(270311);
    return localObject;
  }
  
  public final void be(final int paramInt, final String paramString)
  {
    AppMethodBeat.i(270294);
    s.u(paramString, "msg");
    com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
    com.tencent.mm.plugin.emoji.magicemoji.d.e.a(this, (kotlin.g.a.a)new f(this, paramInt, paramString));
    AppMethodBeat.o(270294);
  }
  
  public final void dyC()
  {
    AppMethodBeat.i(270269);
    if (!com.tencent.mm.plugin.expansions.e.aQh())
    {
      AppMethodBeat.o(270269);
      return;
    }
    try
    {
      Object localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "context");
      ((Context)localObject1).startService(getIntent((Context)localObject1));
      localObject1 = this.xIj;
      localObject2 = ((com.tencent.mm.plugin.emoji.magicemoji.d.d)localObject1).dzk();
      if (localObject2 != null)
      {
        i = ((WxaPkgRecordForME)localObject2).version;
        localObject2 = f.mfZ;
        int j = f.aUn().version;
        Log.i("MicroMsg.MagicEmojiRecordMgr", "stevecai: local version = " + i + ", emoji version = " + j);
        if (j > i)
        {
          ((com.tencent.mm.plugin.emoji.magicemoji.d.d)localObject1).xKu = true;
          ((com.tencent.mm.plugin.emoji.magicemoji.d.d)localObject1).dzo();
        }
        AppMethodBeat.o(270269);
        return;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        Log.w("MicroMsg.MagicEmojiEntityRemote", s.X("stevecai: can not startService for ill state: ", localIllegalStateException.getLocalizedMessage()));
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        Log.w("MicroMsg.MagicEmojiEntityRemote", s.X("stevecai: can not startService for security: ", localSecurityException.getLocalizedMessage()));
        continue;
        Log.i("MicroMsg.MagicEmojiRecordMgr", "stevecai: local record not found, read from res update");
        Object localObject2 = com.tencent.mm.plugin.emoji.magicemoji.d.d.dzl();
        if (localObject2 != null)
        {
          com.tencent.mm.plugin.emoji.magicemoji.d.b localb = com.tencent.mm.plugin.emoji.magicemoji.d.b.xKn;
          localObject2 = com.tencent.mm.plugin.emoji.magicemoji.d.b.anX((String)localObject2);
          if ((localObject2 != null) && (n.T(localSecurityException.xIh.appId, ((com.tencent.mm.plugin.emoji.magicemoji.bean.c)localObject2).appId, true)))
          {
            i = ((com.tencent.mm.plugin.emoji.magicemoji.bean.c)localObject2).version;
            continue;
          }
        }
        int i = 0;
      }
    }
  }
  
  /* Error */
  public final void dyD()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 688
    //   5: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 319	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIk	Lcom/tencent/mm/plugin/emoji/magicemoji/a;
    //   12: ifnull +12 -> 24
    //   15: ldc_w 688
    //   18: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: invokespecial 417	com/tencent/mm/plugin/emoji/magicemoji/core/a:dyJ	()V
    //   28: ldc_w 688
    //   31: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: goto -13 -> 21
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	a
    //   37	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	21	37	finally
    //   24	34	37	finally
  }
  
  public final void dyE()
  {
    AppMethodBeat.i(270290);
    com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
    com.tencent.mm.plugin.emoji.magicemoji.d.e.a(this, (kotlin.g.a.a)new c(this.xIj));
    AppMethodBeat.o(270290);
  }
  
  public final void dyq()
  {
    AppMethodBeat.i(270284);
    com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
    com.tencent.mm.plugin.emoji.magicemoji.d.e.a(this, (kotlin.g.a.a)new e(this));
    AppMethodBeat.o(270284);
  }
  
  public final void dyr()
  {
    AppMethodBeat.i(270287);
    com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
    com.tencent.mm.plugin.emoji.magicemoji.d.e.a(this, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(270287);
  }
  
  public final void dyt()
  {
    try
    {
      AppMethodBeat.i(270314);
      Iterator localIterator = ((Iterable)this.xIo).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)localIterator.next()).dyt();
      }
      AppMethodBeat.o(270314);
    }
    finally {}
  }
  
  public final void dyu()
  {
    try
    {
      AppMethodBeat.i(270316);
      Iterator localIterator = ((Iterable)this.xIo).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)localIterator.next()).dyu();
      }
      AppMethodBeat.o(270316);
    }
    finally {}
  }
  
  public final void dyv()
  {
    try
    {
      AppMethodBeat.i(270319);
      Iterator localIterator = ((Iterable)this.xIo).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)localIterator.next()).dyv();
      }
      AppMethodBeat.o(270319);
    }
    finally {}
  }
  
  public final void dyw()
  {
    try
    {
      AppMethodBeat.i(270321);
      Iterator localIterator = ((Iterable)this.xIo).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)localIterator.next()).dyw();
      }
      AppMethodBeat.o(270321);
    }
    finally {}
  }
  
  public final void dyx()
  {
    try
    {
      AppMethodBeat.i(270322);
      Iterator localIterator = ((Iterable)this.xIo).iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.emoji.magicemoji.a.d)localIterator.next()).dyx();
      }
      AppMethodBeat.o(270322);
    }
    finally {}
  }
  
  public final void e(Surface paramSurface, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(270300);
        s.u(paramSurface, "surface");
        Log.i("MicroMsg.MagicEmojiEntityRemote", "stevecai: postSurface: " + paramSurface + ' ' + paramInt1 + ' ' + paramInt2);
        if (!s.p(paramSurface, this.surface))
        {
          Object localObject = this.surface;
          if (localObject != null) {
            p((Surface)localObject);
          }
          this.surface = paramSurface;
          this.surfaceWidth = paramInt1;
          this.surfaceHeight = paramInt2;
          localObject = this.xIk;
          if (localObject == null) {
            break label185;
          }
          ((com.tencent.mm.plugin.emoji.magicemoji.a)localObject).d(paramSurface, paramInt1, paramInt2);
          AppMethodBeat.o(270300);
          return;
        }
        if ((paramInt1 == this.surfaceWidth) && (paramInt2 == this.surfaceHeight))
        {
          AppMethodBeat.o(270300);
          continue;
        }
        this.surfaceWidth = paramInt1;
      }
      finally {}
      this.surfaceHeight = paramInt2;
      paramSurface = this.xIk;
      if (paramSurface != null) {
        paramSurface.gP(paramInt1, paramInt2);
      }
      label185:
      AppMethodBeat.o(270300);
    }
  }
  
  /* Error */
  public final void p(Surface paramSurface)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 739
    //   5: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ldc_w 722
    //   12: invokestatic 249	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   15: ldc 214
    //   17: ldc_w 741
    //   20: aload_1
    //   21: invokestatic 228	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   24: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 446	com/tencent/mm/plugin/emoji/magicemoji/core/a:surface	Landroid/view/Surface;
    //   32: invokestatic 550	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   35: ifne +20 -> 55
    //   38: ldc 214
    //   40: ldc_w 743
    //   43: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: ldc_w 739
    //   49: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: getfield 319	com/tencent/mm/plugin/emoji/magicemoji/core/a:xIk	Lcom/tencent/mm/plugin/emoji/magicemoji/a;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +9 -> 70
    //   64: aload_1
    //   65: invokeinterface 746 1 0
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 446	com/tencent/mm/plugin/emoji/magicemoji/core/a:surface	Landroid/view/Surface;
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 256	com/tencent/mm/plugin/emoji/magicemoji/core/a:surfaceWidth	I
    //   80: aload_0
    //   81: iconst_1
    //   82: putfield 258	com/tencent/mm/plugin/emoji/magicemoji/core/a:surfaceHeight	I
    //   85: ldc_w 739
    //   88: invokestatic 238	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: goto -39 -> 52
    //   94: astore_1
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	a
    //   0	99	1	paramSurface	Surface
    // Exception table:
    //   from	to	target	type
    //   2	52	94	finally
    //   55	60	94	finally
    //   64	70	94	finally
    //   70	91	94	finally
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiEntityRemote$invoke$1$task$1", "Lcom/tencent/mm/sdk/platformtools/SyncTask;", "", "run", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends SyncTask<String>
  {
    d(r<? extends com.tencent.mm.plugin.emoji.magicemoji.a.c, Boolean> paramr, int paramInt, String paramString) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(a parama, int paramInt, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiEntityRemote$serviceConn$1", "Landroid/content/ServiceConnection;", "onBindingDied", "", "name", "Landroid/content/ComponentName;", "onNullBinding", "onServiceConnected", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements ServiceConnection
  {
    g(a parama) {}
    
    public final void onBindingDied(ComponentName paramComponentName)
    {
      AppMethodBeat.i(270127);
      s.u(paramComponentName, "name");
      com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
      com.tencent.mm.plugin.emoji.magicemoji.d.e.a(this.xIu, (kotlin.g.a.a)new a(paramComponentName, this.xIu));
      AppMethodBeat.o(270127);
    }
    
    public final void onNullBinding(ComponentName paramComponentName)
    {
      AppMethodBeat.i(270134);
      s.u(paramComponentName, "name");
      com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
      com.tencent.mm.plugin.emoji.magicemoji.d.e.a(this.xIu, (kotlin.g.a.a)new b(paramComponentName, this.xIu));
      AppMethodBeat.o(270134);
    }
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      AppMethodBeat.i(270109);
      s.u(paramComponentName, "name");
      s.u(paramIBinder, "service");
      Log.i("MicroMsg.MagicEmojiEntityRemote", "stevecai: onServiceConnected: name = " + paramComponentName + ", service = " + paramIBinder);
      paramComponentName = com.tencent.mm.plugin.emoji.magicemoji.a.a.C(paramIBinder);
      paramIBinder = this.xIu;
      s.s(paramComponentName, "rawService");
      a.b(paramIBinder, (com.tencent.mm.plugin.emoji.magicemoji.a)new com.tencent.mm.plugin.emoji.magicemoji.core.a.b(paramComponentName, (kotlin.g.a.b)new c(this.xIu)));
      AppMethodBeat.o(270109);
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      AppMethodBeat.i(270119);
      s.u(paramComponentName, "name");
      com.tencent.mm.plugin.emoji.magicemoji.d.e locale = com.tencent.mm.plugin.emoji.magicemoji.d.e.xKw;
      com.tencent.mm.plugin.emoji.magicemoji.d.e.a(this.xIu, (kotlin.g.a.a)new d(paramComponentName, this.xIu));
      AppMethodBeat.o(270119);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ComponentName paramComponentName, a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(ComponentName paramComponentName, a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements kotlin.g.a.b<String, ah>
    {
      c(a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.a<ah>
    {
      d(ComponentName paramComponentName, a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ah>
  {
    h(a parama, WxaPkgRecordForME paramWxaPkgRecordForME)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ah>
  {
    i(a parama, com.tencent.mm.plugin.emoji.magicemoji.a parama1)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emoji/magicemoji/core/MagicEmojiEntityRemote$tryBindService$1", "Lcom/tencent/mm/plugin/expansions/JExpansions$Callback;", "onFail", "", "onSuccess", "behavior", "Lcom/tencent/mm/toolkit/frontia/ext/ShareLibrary$SoLibBehavior;", "plugin-magic-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements e.b
  {
    j(a parama) {}
    
    public final void a(com.tencent.mm.toolkit.frontia.a.c.a parama)
    {
      AppMethodBeat.i(270141);
      Log.i("MicroMsg.MagicEmojiEntityRemote", "stevecai: onSuccess: install appbrand success");
      a.f(this.xIu);
      AppMethodBeat.o(270141);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.magicemoji.core.a
 * JD-Core Version:    0.7.0.1
 */