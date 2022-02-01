package com.tencent.mm.am;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.b.b;
import com.tencent.mm.am.b.c;
import com.tencent.mm.am.b.e;
import com.tencent.mm.am.b.f;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class s
  implements h, com.tencent.mm.app.q
{
  private static s oum = null;
  private static int ouz = 1;
  public boolean foreground;
  public final MMHandler handler;
  private final Object lock;
  public g oun;
  public MMHandlerThread ouo;
  private Vector<p> oup;
  private Vector<p> ouq;
  private final Map<Integer, Set<h>> our;
  public Boolean ous;
  private final e ouu;
  private final a ouv;
  private long ouw;
  private boolean oux;
  private MTimerHandler ouy;
  
  private s(a parama)
  {
    AppMethodBeat.i(132335);
    this.ouo = null;
    this.our = new HashMap();
    this.foreground = false;
    this.ous = null;
    this.lock = new Object();
    this.ouu = new e();
    this.ouw = 21600000L;
    this.oux = false;
    this.ouy = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        boolean bool2 = false;
        AppMethodBeat.i(132316);
        if (s.b(s.this) == null)
        {
          AppMethodBeat.o(132316);
          return false;
        }
        Log.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", new Object[] { Integer.valueOf(s.c(s.this).size()), Integer.valueOf(s.d(s.this).size()), Boolean.valueOf(s.e(s.this)) });
        s.a locala = s.b(s.this);
        s locals = s.this;
        boolean bool1 = bool2;
        if (s.f(s.this))
        {
          bool1 = bool2;
          if (s.c(s.this).isEmpty())
          {
            bool1 = bool2;
            if (s.d(s.this).isEmpty()) {
              bool1 = true;
            }
          }
        }
        locala.a(locals, bool1);
        AppMethodBeat.o(132316);
        return true;
      }
    }, true);
    this.oup = new Vector();
    this.ouq = new Vector();
    this.handler = new s.2(this, Looper.getMainLooper());
    this.ouv = parama;
    AppForegroundDelegate.heY.a(this);
    AppMethodBeat.o(132335);
  }
  
  public static s a(a parama)
  {
    AppMethodBeat.i(132337);
    if (oum == null) {
      oum = new s(parama);
    }
    parama = oum;
    AppMethodBeat.o(132337);
    return parama;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(132351);
    this.handler.post(new s.6(this, paramp, paramInt1, paramInt2, paramString));
    this.ouu.notify(Integer.valueOf(paramp.getType()), new c(b.ovB, paramInt1, paramInt2, Util.nullAs(paramString, ""), paramp), false);
    AppMethodBeat.o(132351);
  }
  
  private void b(final p paramp, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(132349);
    boolean bool = bFW();
    int j = this.oup.size();
    int k = paramp.getType();
    int m = paramp.hashCode();
    int n = paramp.getMMReqRespHash();
    int i1 = this.ouq.size();
    if (this.oun == null)
    {
      Log.i("MicroMsg.NetSceneQueue", "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((paramInt != 0) || (!bool) || (this.oun == null)) {
        break label302;
      }
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.oup.add(paramp);
        if (j == this.oup.size()) {
          Log.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramp.hashCode()), Integer.valueOf(j), Integer.valueOf(this.oup.size()), Integer.valueOf(this.ouq.size()) });
        }
        this.ouo.postToWorker(new Runnable()
        {
          public final void run()
          {
            int k = 0;
            AppMethodBeat.i(132323);
            paramp.setOnSceneEnd(s.this);
            int j;
            if ((!paramp.isCanceled()) && (s.g(s.this) != null))
            {
              j = paramp.doScene(s.g(s.this), s.this);
              if (j >= 0) {}
            }
            for (int i = j;; i = 0)
            {
              int m = paramp.getType();
              int n = paramp.hashCode();
              int i1 = paramp.getMMReqRespHash();
              boolean bool = paramp.isCanceled();
              int i2 = s.c(s.this).size();
              int i3 = s.d(s.this).size();
              if (s.g(s.this) == null) {
                j = k;
              }
              for (;;)
              {
                Log.w("MicroMsg.NetSceneQueue", "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(j) });
                paramp.setOnSceneEnd(null);
                synchronized (s.h(s.this))
                {
                  s.c(s.this).remove(paramp);
                  if (paramp.isCanceled()) {
                    break;
                  }
                  s.i(s.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(132322);
                      s.this.onSceneEnd(3, -1, "doScene failed", s.5.this.hxO);
                      AppMethodBeat.o(132322);
                    }
                  });
                  AppMethodBeat.o(132323);
                  return;
                  j = s.g(s.this).hashCode();
                }
              }
              n = paramp.getMMReqRespHash();
              i1 = s.c(s.this).size();
              i2 = s.d(s.this).size();
              if (s.g(s.this) == null) {}
              for (i = 0;; i = s.g(s.this).hashCode())
              {
                Log.i("MicroMsg.NetSceneQueue", "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i) });
                paramp.setHasCallbackToQueue(false);
                AppMethodBeat.o(132323);
                return;
              }
            }
          }
          
          public final String toString()
          {
            AppMethodBeat.i(132324);
            String str = super.toString() + "|doSceneImp_" + paramp + "_type=" + paramp.getType();
            AppMethodBeat.o(132324);
            return str;
          }
        });
        if (this.oun != null) {
          break label497;
        }
        bFX();
        AppMethodBeat.o(132349);
        return;
        i = this.oun.hashCode();
      }
      label302:
      if (paramInt > 0)
      {
        ??? = Message.obtain();
        ((Message)???).obj = paramp;
        this.handler.sendMessageDelayed((Message)???, paramInt);
        Log.i("MicroMsg.NetSceneQueue", "timed: type=" + paramp.getType() + " id=" + paramp.hashCode() + " cur_after_sec=" + paramInt);
      }
      else
      {
        Log.i("MicroMsg.NetSceneQueue", "waited: type=" + paramp.getType() + " id=" + paramp.hashCode() + " cur_waiting_cnt=" + this.ouq.size());
        label497:
        synchronized (this.lock)
        {
          this.ouq.add(paramp);
          Log.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.ouq.size());
        }
      }
    }
  }
  
  private void bFS()
  {
    AppMethodBeat.i(132341);
    Vector localVector = this.ouq;
    this.ouq = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      Log.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localp.getType());
      localp.cancel();
      a(3, -1, "doScene failed clearWaitingQueue", localp);
    }
    localVector.clear();
    AppMethodBeat.o(132341);
  }
  
  private void bFV()
  {
    AppMethodBeat.i(132352);
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if (this.ouq.size() > 0)
        {
          p localp = (p)this.ouq.get(0);
          int j = localp.getPriority();
          i = 1;
          if (i < this.ouq.size())
          {
            if (((p)this.ouq.get(i)).getPriority() > j)
            {
              this.ouq.get(i);
              if (bFW())
              {
                localp = (p)this.ouq.get(i);
                j = localp.getPriority();
              }
            }
          }
          else
          {
            this.ouq.remove(localp);
            Log.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.ouq.size());
            b(localp, 0);
          }
        }
        else
        {
          AppMethodBeat.o(132352);
          return;
        }
      }
      i += 1;
    }
  }
  
  private boolean bFW()
  {
    AppMethodBeat.i(132353);
    if (this.oup.size() >= 50)
    {
      AppMethodBeat.o(132353);
      return false;
    }
    AppMethodBeat.o(132353);
    return true;
  }
  
  private void bFX()
  {
    AppMethodBeat.i(132355);
    if (this.ouv == null)
    {
      Log.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", new Object[] { this.ouv });
      AppMethodBeat.o(132355);
      return;
    }
    this.ouv.a(this);
    new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      private long timeout = 10L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(236785);
        if (s.g(s.this) == null)
        {
          long l = this.timeout;
          this.timeout = (l - 1L);
          if (l > 0L)
          {
            AppMethodBeat.o(236785);
            return true;
          }
        }
        s.k(s.this);
        AppMethodBeat.o(236785);
        return false;
      }
    }, true).startTimer(ouz * 100);
    if (ouz < 512) {
      ouz *= 2;
    }
    AppMethodBeat.o(132355);
  }
  
  private boolean c(p paramp)
  {
    AppMethodBeat.i(132354);
    int i = paramp.getType();
    if (paramp.uniqueInNetsceneQueue()) {}
    synchronized (this.lock)
    {
      Iterator localIterator = this.oup.iterator();
      p localp;
      while (localIterator.hasNext())
      {
        localp = (p)localIterator.next();
        if (localp.getType() == i)
        {
          Log.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + paramp.getType() + " id=" + paramp.hashCode() + " cur_running_cnt=" + this.oup.size());
          if (paramp.acceptConcurrent(localp))
          {
            AppMethodBeat.o(132354);
            return true;
          }
          if (paramp.accept(localp))
          {
            Log.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramp.getType() + " id=" + paramp.hashCode() + " cur_running_cnt=" + this.oup.size() + " ---" + localp.hashCode());
            if (!this.foreground)
            {
              Log.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramp.getType() + "acinfo[" + localp.getInfo() + "] scinfo[" + paramp.getInfo() + "]");
              Log.appenderFlush();
              Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + paramp.getType(), false);
            }
            a(localp);
            AppMethodBeat.o(132354);
            return true;
          }
          AppMethodBeat.o(132354);
          return false;
        }
      }
      localIterator = this.ouq.iterator();
      while (localIterator.hasNext())
      {
        localp = (p)localIterator.next();
        if (localp.getType() == i)
        {
          Log.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + paramp.getType() + " id=" + paramp.hashCode() + " cur_waiting_cnt=" + this.ouq.size());
          if (paramp.acceptConcurrent(localp))
          {
            AppMethodBeat.o(132354);
            return true;
          }
          if (paramp.accept(localp))
          {
            Log.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + paramp.getType() + " id=" + paramp.hashCode() + " cur_waiting_cnt=" + this.ouq.size() + " ---" + localp.hashCode());
            if (!this.foreground)
            {
              Log.appenderFlush();
              Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + paramp.getType(), false);
            }
            a(localp);
            AppMethodBeat.o(132354);
            return true;
          }
          AppMethodBeat.o(132354);
          return false;
        }
      }
      AppMethodBeat.o(132354);
      return true;
    }
  }
  
  private void setForeground(boolean paramBoolean)
  {
    AppMethodBeat.i(132331);
    this.foreground = paramBoolean;
    this.ous = Boolean.valueOf(paramBoolean);
    CrashReportFactory.setForeground(paramBoolean);
    com.tencent.mm.hardcoder.WXHardCoderJNI.foreground = paramBoolean;
    if (this.oun == null)
    {
      Log.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
      AppMethodBeat.o(132331);
      return;
    }
    this.oun.ha(paramBoolean);
    AppMethodBeat.o(132331);
  }
  
  public final void a(int paramInt, androidx.lifecycle.q paramq, a parama)
  {
    AppMethodBeat.i(236880);
    if (paramInt == -1)
    {
      paramq = new IllegalArgumentException("BROADCAST TYPE Not support, use add addSceneEndListener");
      AppMethodBeat.o(236880);
      throw paramq;
    }
    this.ouu.a(paramInt, paramq, "%MainThread%", parama);
    AppMethodBeat.o(236880);
  }
  
  public final void a(int paramInt, androidx.lifecycle.q paramq, h paramh)
  {
    AppMethodBeat.i(236882);
    if (paramInt == -1)
    {
      paramq = new IllegalArgumentException("BROADCAST TYPE Not support, use add addSceneEndListener");
      AppMethodBeat.o(236882);
      throw paramq;
    }
    this.ouu.a(paramInt, paramq, "%MainThread%", new f(paramh));
    AppMethodBeat.o(236882);
  }
  
  public final void a(int paramInt, h paramh)
  {
    AppMethodBeat.i(132338);
    synchronized (this.our)
    {
      if (!this.our.containsKey(Integer.valueOf(paramInt))) {
        this.our.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)this.our.get(Integer.valueOf(paramInt))).contains(paramh)) {}
      synchronized ((Set)this.our.get(Integer.valueOf(paramInt)))
      {
        if (???.add(paramh)) {
          ListenerInstanceMonitor.markInstanceRegistered(paramh);
        }
        AppMethodBeat.o(132338);
        return;
      }
    }
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(132346);
    if (paramp == null)
    {
      AppMethodBeat.o(132346);
      return;
    }
    Log.printInfoStack("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramp.hashCode()) });
    paramp.cancel();
    synchronized (this.lock)
    {
      this.ouq.remove(paramp);
      this.oup.remove(paramp);
      AppMethodBeat.o(132346);
      return;
    }
  }
  
  public final boolean a(p paramp, int paramInt)
  {
    AppMethodBeat.i(132348);
    if ((paramp != null) || (paramInt >= 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.ouo == null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("worker thread has not been set", bool);
      if (c(paramp)) {
        break label62;
      }
      AppMethodBeat.o(132348);
      return false;
      bool = false;
      break;
    }
    label62:
    b(paramp, paramInt);
    AppMethodBeat.o(132348);
    return true;
  }
  
  public final void b(int paramInt, h paramh)
  {
    AppMethodBeat.i(132339);
    synchronized (this.our)
    {
      for (;;)
      {
        try
        {
          localSet = (Set)this.our.get(Integer.valueOf(paramInt));
          if (localSet == null) {}
        }
        catch (Exception paramh)
        {
          Set localSet;
          continue;
        }
        try
        {
          if (localSet.remove(paramh)) {
            ListenerInstanceMonitor.markInstanceUnregistered(paramh);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(132339);
        }
      }
    }
  }
  
  public final boolean b(p paramp)
  {
    AppMethodBeat.i(369565);
    boolean bool = a(paramp, 0);
    AppMethodBeat.o(369565);
    return bool;
  }
  
  public final void bFP()
  {
    AppMethodBeat.i(236853);
    if (this.oun == null)
    {
      Log.e("MicroMsg.NetSceneQueue", "flushPushLog autoAuth  == null");
      AppMethodBeat.o(236853);
      return;
    }
    this.oun.bFP();
    AppMethodBeat.o(236853);
  }
  
  public final int bFQ()
  {
    AppMethodBeat.i(132332);
    try
    {
      if ((this.oun != null) && (this.oun.bGh() != null))
      {
        int i = this.oun.bGh().bQP();
        AppMethodBeat.o(132332);
        return i;
      }
      Log.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.NetSceneQueue", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
      AppMethodBeat.o(132332);
    }
    if (NetStatusUtil.isConnected(MMApplicationContext.getContext()))
    {
      AppMethodBeat.o(132332);
      return 6;
    }
    return 0;
  }
  
  public final boolean bFR()
  {
    AppMethodBeat.i(132333);
    if (this.oun != null)
    {
      boolean bool = this.oun.bFR();
      AppMethodBeat.o(132333);
      return bool;
    }
    AppMethodBeat.o(132333);
    return true;
  }
  
  public final void bFT()
  {
    AppMethodBeat.i(132342);
    Vector localVector = this.oup;
    this.oup = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      Log.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localp.getType());
      localp.cancel();
      a(3, -1, "doScene failed clearRunningQueue", localp);
    }
    localVector.clear();
    AppMethodBeat.o(132342);
  }
  
  public final void bFU()
  {
    AppMethodBeat.i(132343);
    Log.i("MicroMsg.NetSceneQueue", "resetDispatcher");
    if (this.oun != null)
    {
      this.oun.reset();
      this.oun = null;
    }
    AppMethodBeat.o(132343);
  }
  
  public final int bFY()
  {
    AppMethodBeat.i(236910);
    synchronized (this.our)
    {
      int i = ((Set)this.our.get(Integer.valueOf(825))).size();
      AppMethodBeat.o(236910);
      return i;
    }
  }
  
  public final g baa()
  {
    return this.oun;
  }
  
  public final void c(int paramInt, h paramh)
  {
    AppMethodBeat.i(236887);
    if (paramInt == -1)
    {
      paramh = new IllegalArgumentException("BROADCAST TYPE Not support, use add removeSceneEndListener");
      AppMethodBeat.o(236887);
      throw paramh;
    }
    this.ouu.removeObserver(Integer.valueOf(paramInt), new f(paramh));
    AppMethodBeat.o(236887);
  }
  
  public final void cancel(final int paramInt)
  {
    AppMethodBeat.i(132344);
    Log.printInfoStack("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.ouo.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132318);
        s.a(s.this, paramInt);
        AppMethodBeat.o(132318);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(132319);
        String str = super.toString() + "|cancelImp_" + paramInt;
        AppMethodBeat.o(132319);
        return str;
      }
    });
    AppMethodBeat.o(132344);
  }
  
  public final void d(g paramg)
  {
    AppMethodBeat.i(132336);
    this.oun = paramg;
    paramg.ha(this.foreground);
    bFV();
    AppMethodBeat.o(132336);
  }
  
  public final void gZ(boolean paramBoolean)
  {
    AppMethodBeat.i(132329);
    this.oux = paramBoolean;
    if (!this.oux)
    {
      this.ouy.stopTimer();
      AppMethodBeat.o(132329);
      return;
    }
    Log.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
    this.ouy.startTimer(this.ouw);
    AppMethodBeat.o(132329);
  }
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132334);
    if (this.oun != null)
    {
      String str = this.oun.getNetworkServerIp();
      AppMethodBeat.o(132334);
      return str;
    }
    AppMethodBeat.o(132334);
    return "unknown";
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(132328);
    Log.i("MicroMsg.NetSceneQueue", "onAppBackground");
    setForeground(false);
    AppMethodBeat.o(132328);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(132327);
    Log.i("MicroMsg.NetSceneQueue", "onAppForeground");
    setForeground(true);
    gZ(false);
    AppMethodBeat.o(132327);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 0;
    AppMethodBeat.i(132350);
    paramp.setHasCallbackToQueue(true);
    for (;;)
    {
      synchronized (this.lock)
      {
        this.oup.remove(paramp);
        int j = paramp.getType();
        int k = paramp.hashCode();
        int m = paramp.getMMReqRespHash();
        int n = this.oup.size();
        int i1 = this.ouq.size();
        if (this.oun == null)
        {
          Log.i("MicroMsg.NetSceneQueue", "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
          {
            ??? = new d();
            ((d)???).hyI.errType = paramInt1;
            ((d)???).hyI.errCode = paramInt2;
            ((d)???).hyI.errMsg = paramString;
            ((d)???).publish();
          }
          bFV();
          a(paramInt1, paramInt2, paramString, paramp);
          if ((this.oux) && (this.oup.isEmpty()) && (this.ouq.isEmpty())) {
            this.ouy.startTimer(this.ouw);
          }
          AppMethodBeat.o(132350);
          return;
        }
      }
      i = this.oun.hashCode();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132340);
    Log.i("MicroMsg.NetSceneQueue", "reset");
    if (this.oun != null) {
      this.oun.reset();
    }
    bFT();
    bFS();
    this.ouu.reset();
    AppMethodBeat.o(132340);
  }
  
  public final void vM(final int paramInt)
  {
    AppMethodBeat.i(132345);
    Log.printInfoStack("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.ouo.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132320);
        s.b(s.this, paramInt);
        AppMethodBeat.o(132320);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(132321);
        String str = super.toString() + "|cancelImp_" + paramInt;
        AppMethodBeat.o(132321);
        return str;
      }
    });
    AppMethodBeat.o(132345);
  }
  
  public static abstract interface a
  {
    public abstract void a(s params);
    
    public abstract void a(s params, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.s
 * JD-Core Version:    0.7.0.1
 */