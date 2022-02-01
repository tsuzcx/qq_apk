package com.tencent.mm.plugin.finder.nearby.preload.firstpage;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.b.i;
import com.tencent.mm.plugin.findersdk.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload;", "T", "Lcom/tencent/mm/plugin/finder/nearby/preload/IPreload;", "()V", "PRELOAD_RESPONSE_EXPIRED_MS", "", "getPRELOAD_RESPONSE_EXPIRED_MS", "()I", "setPRELOAD_RESPONSE_EXPIRED_MS", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "WAITING_PRELOAD_TIMEOUT_MS", "getWAITING_PRELOAD_TIMEOUT_MS", "setWAITING_PRELOAD_TIMEOUT_MS", "cgiTimeTrace", "Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "getCgiTimeTrace", "()Lcom/tencent/mm/plugin/findersdk/trace/TimeConsumingTrace;", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "loadingState", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload$LoadingState;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "response", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "getResponse", "()Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "setResponse", "(Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;)V", "fetchInternal", "", "getLoadingState", "handleFetchDoneInternal", "callback", "Lkotlin/Function0;", "isExpiredResponse", "", "isLoading", "isResponseValid", "requestCache", "requestCacheAsync", "Lkotlin/Function1;", "setLoadingState", "state", "startPreload", "stopPreload", "LoadingState", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
{
  private int EPQ;
  private int EPR;
  private i<T> EPS;
  private final c EPT;
  public volatile a EPU;
  private String TAG = "Finder.Nearby.Preload." + getClass().getSimpleName() + "_@" + hashCode();
  private final ReentrantLock bKF;
  private final Condition hbM;
  
  public a()
  {
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.EPQ = ((Number)com.tencent.mm.plugin.finder.storage.d.eRE().bmg()).intValue();
    locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    this.EPR = ((Number)com.tencent.mm.plugin.finder.storage.d.eRD().bmg()).intValue();
    this.bKF = new ReentrantLock();
    this.hbM = this.bKF.newCondition();
    this.EPT = new c(this.TAG);
    this.EPU = a.EPV;
    Log.i(this.TAG, "init WAITING_PRELOAD_TIMEOUT_MS:" + this.EPQ + " PRELOAD_RESPONSE_EXPIRED_MS:" + this.EPR + ' ');
  }
  
  private final void a(a parama)
  {
    Log.i(this.TAG, "setLoadingState from " + this.EPU + " to " + parama);
    this.EPU = parama;
  }
  
  public static boolean b(i<T> parami)
  {
    return (parami != null) && (parami.errType == 0) && (parami.errCode == 0);
  }
  
  protected final void a(i<T> parami)
  {
    this.EPS = parami;
  }
  
  /* Error */
  public final void a(i<T> parami, kotlin.g.a.a<ah> parama)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc 212
    //   3: invokestatic 218	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield 170	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:EPT	Lcom/tencent/mm/plugin/findersdk/f/c;
    //   10: ldc 220
    //   12: invokevirtual 223	com/tencent/mm/plugin/findersdk/f/c:aDn	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 160	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   19: invokevirtual 225	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   22: aload_2
    //   23: invokeinterface 230 1 0
    //   28: pop
    //   29: aload_1
    //   30: invokestatic 232	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:b	(Lcom/tencent/mm/plugin/findersdk/b/i;)Z
    //   33: ifeq +36 -> 69
    //   36: aload_0
    //   37: getstatic 235	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a:EQa	Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a;
    //   40: invokespecial 237	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:a	(Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a;)V
    //   43: aload_0
    //   44: getfield 165	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:hbM	Ljava/util/concurrent/locks/Condition;
    //   47: invokeinterface 242 1 0
    //   52: aload_0
    //   53: getfield 160	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   56: invokevirtual 245	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   59: aload_0
    //   60: getfield 170	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:EPT	Lcom/tencent/mm/plugin/findersdk/f/c;
    //   63: ldc 247
    //   65: invokevirtual 250	com/tencent/mm/plugin/findersdk/f/c:gG	(Ljava/lang/String;)V
    //   68: return
    //   69: aload_0
    //   70: getstatic 253	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a:EPZ	Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a;
    //   73: invokespecial 237	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:a	(Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/a$a;)V
    //   76: goto -33 -> 43
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 160	com/tencent/mm/plugin/finder/nearby/preload/firstpage/a:bKF	Ljava/util/concurrent/locks/ReentrantLock;
    //   84: invokevirtual 245	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	a
    //   0	89	1	parami	i<T>
    //   0	89	2	parama	kotlin.g.a.a<ah>
    // Exception table:
    //   from	to	target	type
    //   22	43	79	finally
    //   43	52	79	finally
    //   69	76	79	finally
  }
  
  public final void at(kotlin.g.a.b<? super i<T>, ah> paramb)
  {
    s.u(paramb, "callback");
    Log.i(this.TAG, s.X("requestCacheAsync state:", this.EPU));
    com.tencent.mm.ae.d.B((kotlin.g.a.a)new b(paramb, this));
  }
  
  protected final boolean c(i<T> parami)
  {
    s.u(parami, "response");
    long l = SystemClock.elapsedRealtime() - parami.zIH;
    if (l > this.EPR)
    {
      Log.i(this.TAG, s.X("isExpiredResponse expiredMs:", Long.valueOf(l)));
      return true;
    }
    return false;
  }
  
  public abstract void eGA();
  
  public void eGB()
  {
    Log.i(this.TAG, s.X("stopPreload state:", this.EPU));
    this.bKF.lock();
    try
    {
      this.hbM.signalAll();
      this.bKF.unlock();
      this.EPS = null;
      a(a.EPV);
      return;
    }
    finally
    {
      this.bKF.unlock();
    }
  }
  
  protected final i<T> eGw()
  {
    return this.EPS;
  }
  
  protected final c eGx()
  {
    return this.EPT;
  }
  
  public void eGy()
  {
    if (this.EPU != a.EPV)
    {
      Log.i(this.TAG, s.X("startPreload return for state:", this.EPU));
      return;
    }
    Log.i(this.TAG, "startPreload");
    this.EPT.gF("startPreload begin");
    this.bKF.lock();
    try
    {
      a(a.EPW);
      eGA();
      this.bKF.unlock();
      this.EPT.aDn("startPreload end");
      return;
    }
    finally
    {
      this.bKF.unlock();
    }
  }
  
  public i<T> eGz()
  {
    Log.i(this.TAG, s.X("requestCache state:", this.EPU));
    this.bKF.lock();
    this.EPT.aDn("requestCache");
    long l = SystemClock.elapsedRealtime();
    i locali;
    do
    {
      try
      {
        if (this.EPU == a.EPW) {}
        for (int i = 1;; i = 0)
        {
          if (i != 0)
          {
            Log.i(this.TAG, "requestCache waiting.");
            this.hbM.await(this.EPQ, TimeUnit.MILLISECONDS);
          }
          this.bKF.unlock();
          l = SystemClock.elapsedRealtime() - l;
          if (this.EPS != null) {
            break;
          }
          Log.i(this.TAG, "requestCache hit null, state:" + this.EPU + " time:" + l);
          return this.EPS;
        }
        Log.i(this.TAG, "requestCache hit cache state:" + this.EPU + " response:" + this.EPS + " time:" + l);
      }
      finally
      {
        this.bKF.unlock();
      }
      locali = this.EPS;
      s.checkNotNull(locali);
    } while (!c(locali));
    a(a.EPY);
    return null;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void setTAG(String paramString)
  {
    s.u(paramString, "<set-?>");
    this.TAG = paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/FirstPagePreload$LoadingState;", "", "(Ljava/lang/String;I)V", "IDLE", "LOADING", "DISABLE", "EXPIRED", "FAILED", "OK", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(340009);
      EPV = new a("IDLE", 0);
      EPW = new a("LOADING", 1);
      EPX = new a("DISABLE", 2);
      EPY = new a("EXPIRED", 3);
      EPZ = new a("FAILED", 4);
      EQa = new a("OK", 5);
      EQb = new a[] { EPV, EPW, EPX, EPY, EPZ, EQa };
      AppMethodBeat.o(340009);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(kotlin.g.a.b<? super i<T>, ah> paramb, a<T> parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.firstpage.a
 * JD-Core Version:    0.7.0.1
 */