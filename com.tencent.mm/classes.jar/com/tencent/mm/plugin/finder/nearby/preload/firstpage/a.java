package com.tencent.mm.plugin.finder.nearby.preload.firstpage;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.b.h;
import com.tencent.mm.plugin.findersdk.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload;", "T", "Lcom/tencent/mm/plugin/finder/nearby/preload/IPreload;", "()V", "PRELOAD_RESPONSE_EXPIRED_MS", "", "getPRELOAD_RESPONSE_EXPIRED_MS", "()I", "setPRELOAD_RESPONSE_EXPIRED_MS", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "WAITING_PRELOAD_TIMEOUT_MS", "getWAITING_PRELOAD_TIMEOUT_MS", "setWAITING_PRELOAD_TIMEOUT_MS", "cgiTimeTrace", "Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "getCgiTimeTrace", "()Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "loadingState", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload$LoadingState;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "response", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "getResponse", "()Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "setResponse", "(Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;)V", "fetchInternal", "", "getLoadingState", "handleFetchDoneInternal", "callback", "Lkotlin/Function0;", "isExpiredResponse", "", "isLoading", "requestCache", "requestCacheAsync", "Lkotlin/Function1;", "setLoadingState", "state", "startPreload", "stopPreload", "LoadingState", "plugin-finder-nearby_release"})
public abstract class a<T>
{
  private String TAG = "Finder.Nearby.Preload." + getClass().getSimpleName() + "_@" + hashCode();
  private final ReentrantLock eYl;
  private final Condition eYm;
  private h<T> zIA;
  private final c zIB;
  public volatile a zIC;
  private int zIy;
  private int zIz;
  
  public a()
  {
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.zIy = ((Number)com.tencent.mm.plugin.finder.storage.d.dTp().aSr()).intValue();
    locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    this.zIz = ((Number)com.tencent.mm.plugin.finder.storage.d.dTo().aSr()).intValue();
    this.eYl = new ReentrantLock();
    this.eYm = this.eYl.newCondition();
    this.zIB = new c(this.TAG);
    this.zIC = a.zID;
    Log.i(this.TAG, "init WAITING_PRELOAD_TIMEOUT_MS:" + this.zIy + ' ' + "PRELOAD_RESPONSE_EXPIRED_MS:" + this.zIz + ' ');
  }
  
  private final void a(a parama)
  {
    Log.i(this.TAG, "setLoadingState from " + this.zIC + " to " + parama);
    this.zIC = parama;
  }
  
  public final void N(final kotlin.g.a.b<? super h<T>, x> paramb)
  {
    p.k(paramb, "callback");
    Log.i(this.TAG, "requestCacheAsync state:" + this.zIC);
    com.tencent.mm.ae.d.h((kotlin.g.a.a)new b(this, paramb));
  }
  
  protected final void a(h<T> paramh)
  {
    this.zIA = paramh;
  }
  
  /* Error */
  public final void a(h<T> paramh, kotlin.g.a.a<x> parama)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 193
    //   3: invokestatic 199	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield 163	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:zIB	Lcom/tencent/mm/plugin/findersdk/f/c;
    //   10: ldc 221
    //   12: invokevirtual 224	com/tencent/mm/plugin/findersdk/f/c:aGV	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 153	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:eYl	Ljava/util/concurrent/locks/ReentrantLock;
    //   19: invokevirtual 226	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   22: aload_2
    //   23: invokeinterface 229 1 0
    //   28: pop
    //   29: aload_1
    //   30: ifnull +50 -> 80
    //   33: aload_1
    //   34: getfield 234	com/tencent/mm/plugin/findersdk/b/h:errType	I
    //   37: ifne +43 -> 80
    //   40: aload_1
    //   41: getfield 237	com/tencent/mm/plugin/findersdk/b/h:errCode	I
    //   44: ifne +36 -> 80
    //   47: aload_0
    //   48: getstatic 240	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a:zII	Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a;
    //   51: invokespecial 242	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:a	(Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a;)V
    //   54: aload_0
    //   55: getfield 158	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:eYm	Ljava/util/concurrent/locks/Condition;
    //   58: invokeinterface 247 1 0
    //   63: aload_0
    //   64: getfield 153	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:eYl	Ljava/util/concurrent/locks/ReentrantLock;
    //   67: invokevirtual 250	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   70: aload_0
    //   71: getfield 163	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:zIB	Lcom/tencent/mm/plugin/findersdk/f/c;
    //   74: ldc 252
    //   76: invokevirtual 255	com/tencent/mm/plugin/findersdk/f/c:fp	(Ljava/lang/String;)V
    //   79: return
    //   80: aload_0
    //   81: getstatic 258	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a:zIH	Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a;
    //   84: invokespecial 242	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:a	(Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a;)V
    //   87: goto -33 -> 54
    //   90: astore_1
    //   91: aload_0
    //   92: getfield 153	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:eYl	Ljava/util/concurrent/locks/ReentrantLock;
    //   95: invokevirtual 250	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	a
    //   0	100	1	paramh	h<T>
    //   0	100	2	parama	kotlin.g.a.a<x>
    // Exception table:
    //   from	to	target	type
    //   22	29	90	finally
    //   33	54	90	finally
    //   54	63	90	finally
    //   80	87	90	finally
  }
  
  protected final boolean b(h<T> paramh)
  {
    p.k(paramh, "response");
    long l = SystemClock.elapsedRealtime() - paramh.wmE;
    if (l > this.zIz)
    {
      Log.i(this.TAG, "isExpiredResponse expiredMs:".concat(String.valueOf(l)));
      return true;
    }
    return false;
  }
  
  protected final h<T> dMq()
  {
    return this.zIA;
  }
  
  protected final c dMr()
  {
    return this.zIB;
  }
  
  public void dMs()
  {
    if (this.zIC != a.zID)
    {
      Log.i(this.TAG, "startPreload return for state:" + this.zIC);
      return;
    }
    Log.i(this.TAG, "startPreload");
    this.zIB.fo("startPreload begin");
    this.eYl.lock();
    try
    {
      a(a.zIE);
      dMu();
      this.eYl.unlock();
      this.zIB.aGV("startPreload end");
      return;
    }
    finally
    {
      this.eYl.unlock();
    }
  }
  
  public h<T> dMt()
  {
    Log.i(this.TAG, "requestCache state:" + this.zIC);
    this.eYl.lock();
    this.zIB.aGV("requestCache");
    long l = SystemClock.elapsedRealtime();
    h localh;
    do
    {
      try
      {
        if (this.zIC == a.zIE) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            Log.i(this.TAG, "requestCache waiting.");
            this.eYm.await(this.zIy, TimeUnit.MILLISECONDS);
          }
          this.eYl.unlock();
          l = SystemClock.elapsedRealtime() - l;
          if (this.zIA != null) {
            break;
          }
          Log.i(this.TAG, "requestCache hit null, state:" + this.zIC + " time:" + l);
          return this.zIA;
        }
        Log.i(this.TAG, "requestCache hit cache state:" + this.zIC + " response:" + this.zIA + " time:" + l);
      }
      finally
      {
        this.eYl.unlock();
      }
      localh = this.zIA;
      if (localh == null) {
        p.iCn();
      }
    } while (!b(localh));
    a(a.zIG);
    return null;
  }
  
  public abstract void dMu();
  
  public void dMv()
  {
    Log.i(this.TAG, "stopPreload state:" + this.zIC);
    this.eYl.lock();
    try
    {
      this.eYm.signalAll();
      this.eYl.unlock();
      this.zIA = null;
      a(a.zID);
      return;
    }
    finally
    {
      this.eYl.unlock();
    }
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void setTAG(String paramString)
  {
    p.k(paramString, "<set-?>");
    this.TAG = paramString;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload$LoadingState;", "", "(Ljava/lang/String;I)V", "IDLE", "LOADING", "DISABLE", "EXPIRED", "FAILED", "OK", "plugin-finder-nearby_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(200013);
      a locala1 = new a("IDLE", 0);
      zID = locala1;
      a locala2 = new a("LOADING", 1);
      zIE = locala2;
      a locala3 = new a("DISABLE", 2);
      zIF = locala3;
      a locala4 = new a("EXPIRED", 3);
      zIG = locala4;
      a locala5 = new a("FAILED", 4);
      zIH = locala5;
      a locala6 = new a("OK", 5);
      zII = locala6;
      zIJ = new a[] { locala1, locala2, locala3, locala4, locala5, locala6 };
      AppMethodBeat.o(200013);
    }
    
    private a() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(a parama, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.firstpage.a
 * JD-Core Version:    0.7.0.1
 */