package com.tencent.mm.an;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.b.b;
import com.tencent.mm.an.b.e;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.network.g;
import com.tencent.mm.network.k;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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

public final class t
  implements i, o
{
  private static t lCC = null;
  private static int lCO = 1;
  public boolean foreground;
  private final MMHandler handler;
  public g lCD;
  public MMHandlerThread lCE;
  private Vector<q> lCF;
  private Vector<q> lCG;
  private final Map<Integer, Set<i>> lCH;
  public Boolean lCI;
  public final e lCJ;
  private final a lCK;
  private long lCL;
  private boolean lCM;
  private MTimerHandler lCN;
  private final Object lock;
  
  private t(a parama)
  {
    AppMethodBeat.i(132335);
    this.lCE = null;
    this.lCH = new HashMap();
    this.foreground = false;
    this.lCI = null;
    this.lock = new Object();
    this.lCJ = new e();
    this.lCL = 21600000L;
    this.lCM = false;
    this.lCN = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        boolean bool2 = false;
        AppMethodBeat.i(132316);
        if (t.b(t.this) == null)
        {
          AppMethodBeat.o(132316);
          return false;
        }
        Log.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", new Object[] { Integer.valueOf(t.c(t.this).size()), Integer.valueOf(t.d(t.this).size()), Boolean.valueOf(t.e(t.this)) });
        t.a locala = t.b(t.this);
        t localt = t.this;
        boolean bool1 = bool2;
        if (t.f(t.this))
        {
          bool1 = bool2;
          if (t.c(t.this).isEmpty())
          {
            bool1 = bool2;
            if (t.d(t.this).isEmpty()) {
              bool1 = true;
            }
          }
        }
        locala.a(localt, bool1);
        AppMethodBeat.o(132316);
        return true;
      }
    }, true);
    this.lCF = new Vector();
    this.lCG = new Vector();
    this.handler = new MMHandler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(132317);
        t.this.a((q)paramAnonymousMessage.obj, 0);
        AppMethodBeat.o(132317);
      }
    };
    this.lCK = parama;
    AppForegroundDelegate.fby.a(this);
    AppMethodBeat.o(132335);
  }
  
  public static t a(a parama)
  {
    AppMethodBeat.i(132337);
    if (lCC == null) {
      lCC = new t(parama);
    }
    parama = lCC;
    AppMethodBeat.o(132337);
    return parama;
  }
  
  private void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(132351);
    this.handler.post(new t.6(this, paramq, paramInt1, paramInt2, paramString));
    this.lCJ.notify(Integer.valueOf(paramq.getType()), new com.tencent.mm.an.b.c(b.lDQ, paramInt1, paramInt2, Util.nullAs(paramString, ""), paramq), false);
    AppMethodBeat.o(132351);
  }
  
  private void b(final q paramq, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(132349);
    boolean bool = bin();
    int j = this.lCF.size();
    int k = paramq.getType();
    int m = paramq.hashCode();
    int n = paramq.getMMReqRespHash();
    int i1 = this.lCG.size();
    if (this.lCD == null)
    {
      Log.i("MicroMsg.NetSceneQueue", "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((paramInt != 0) || (!bool) || (this.lCD == null)) {
        break label302;
      }
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.lCF.add(paramq);
        if (j == this.lCF.size()) {
          Log.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramq.hashCode()), Integer.valueOf(j), Integer.valueOf(this.lCF.size()), Integer.valueOf(this.lCG.size()) });
        }
        this.lCE.postToWorker(new Runnable()
        {
          public final void run()
          {
            int k = 0;
            AppMethodBeat.i(132323);
            paramq.setOnSceneEnd(t.this);
            int j;
            if ((!paramq.isCanceled()) && (t.g(t.this) != null))
            {
              j = paramq.doScene(t.g(t.this), t.this);
              if (j >= 0) {}
            }
            for (int i = j;; i = 0)
            {
              int m = paramq.getType();
              int n = paramq.hashCode();
              int i1 = paramq.getMMReqRespHash();
              boolean bool = paramq.isCanceled();
              int i2 = t.c(t.this).size();
              int i3 = t.d(t.this).size();
              if (t.g(t.this) == null) {
                j = k;
              }
              for (;;)
              {
                Log.w("MicroMsg.NetSceneQueue", "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(j) });
                paramq.setOnSceneEnd(null);
                synchronized (t.h(t.this))
                {
                  t.c(t.this).remove(paramq);
                  if (paramq.isCanceled()) {
                    break;
                  }
                  t.i(t.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(132322);
                      t.this.onSceneEnd(3, -1, "doScene failed", t.5.this.ftz);
                      AppMethodBeat.o(132322);
                    }
                  });
                  AppMethodBeat.o(132323);
                  return;
                  j = t.g(t.this).hashCode();
                }
              }
              n = paramq.getMMReqRespHash();
              i1 = t.c(t.this).size();
              i2 = t.d(t.this).size();
              if (t.g(t.this) == null) {}
              for (i = 0;; i = t.g(t.this).hashCode())
              {
                Log.i("MicroMsg.NetSceneQueue", "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i) });
                paramq.setHasCallbackToQueue(false);
                AppMethodBeat.o(132323);
                return;
              }
            }
          }
          
          public final String toString()
          {
            AppMethodBeat.i(132324);
            String str = super.toString() + "|doSceneImp_" + paramq + "_type=" + paramq.getType();
            AppMethodBeat.o(132324);
            return str;
          }
        });
        if (this.lCD != null) {
          break label497;
        }
        bio();
        AppMethodBeat.o(132349);
        return;
        i = this.lCD.hashCode();
      }
      label302:
      if (paramInt > 0)
      {
        ??? = Message.obtain();
        ((Message)???).obj = paramq;
        this.handler.sendMessageDelayed((Message)???, paramInt);
        Log.i("MicroMsg.NetSceneQueue", "timed: type=" + paramq.getType() + " id=" + paramq.hashCode() + " cur_after_sec=" + paramInt);
      }
      else
      {
        Log.i("MicroMsg.NetSceneQueue", "waited: type=" + paramq.getType() + " id=" + paramq.hashCode() + " cur_waiting_cnt=" + this.lCG.size());
        label497:
        synchronized (this.lock)
        {
          this.lCG.add(paramq);
          Log.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.lCG.size());
        }
      }
    }
  }
  
  private void bij()
  {
    AppMethodBeat.i(132341);
    Vector localVector = this.lCG;
    this.lCG = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      Log.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localq.getType());
      localq.cancel();
      b(3, -1, "doScene failed clearWaitingQueue", localq);
    }
    localVector.clear();
    AppMethodBeat.o(132341);
  }
  
  private void bim()
  {
    AppMethodBeat.i(132352);
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if (this.lCG.size() > 0)
        {
          q localq = (q)this.lCG.get(0);
          int j = localq.getPriority();
          i = 1;
          if (i < this.lCG.size())
          {
            if (((q)this.lCG.get(i)).getPriority() > j)
            {
              this.lCG.get(i);
              if (bin())
              {
                localq = (q)this.lCG.get(i);
                j = localq.getPriority();
              }
            }
          }
          else
          {
            this.lCG.remove(localq);
            Log.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.lCG.size());
            b(localq, 0);
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
  
  private boolean bin()
  {
    AppMethodBeat.i(132353);
    if (this.lCF.size() >= 50)
    {
      AppMethodBeat.o(132353);
      return false;
    }
    AppMethodBeat.o(132353);
    return true;
  }
  
  private void bio()
  {
    AppMethodBeat.i(132355);
    if (this.lCK == null)
    {
      Log.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", new Object[] { this.lCK });
      AppMethodBeat.o(132355);
      return;
    }
    this.lCK.a(this);
    new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      private long timeout = 10L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(207074);
        if (t.g(t.this) == null)
        {
          long l = this.timeout;
          this.timeout = (l - 1L);
          if (l > 0L)
          {
            AppMethodBeat.o(207074);
            return true;
          }
        }
        t.k(t.this);
        AppMethodBeat.o(207074);
        return false;
      }
    }, true).startTimer(lCO * 100);
    if (lCO < 512) {
      lCO *= 2;
    }
    AppMethodBeat.o(132355);
  }
  
  private boolean c(q paramq)
  {
    AppMethodBeat.i(132354);
    int i = paramq.getType();
    if (paramq.uniqueInNetsceneQueue()) {}
    synchronized (this.lock)
    {
      Iterator localIterator = this.lCF.iterator();
      q localq;
      while (localIterator.hasNext())
      {
        localq = (q)localIterator.next();
        if (localq.getType() == i)
        {
          Log.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + paramq.getType() + " id=" + paramq.hashCode() + " cur_running_cnt=" + this.lCF.size());
          if (paramq.acceptConcurrent(localq))
          {
            AppMethodBeat.o(132354);
            return true;
          }
          if (paramq.accept(localq))
          {
            Log.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramq.getType() + " id=" + paramq.hashCode() + " cur_running_cnt=" + this.lCF.size() + " ---" + localq.hashCode());
            if (!this.foreground)
            {
              Log.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramq.getType() + "acinfo[" + localq.getInfo() + "] scinfo[" + paramq.getInfo() + "]");
              Log.appenderFlush();
              Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + paramq.getType(), false);
            }
            a(localq);
            AppMethodBeat.o(132354);
            return true;
          }
          AppMethodBeat.o(132354);
          return false;
        }
      }
      localIterator = this.lCG.iterator();
      while (localIterator.hasNext())
      {
        localq = (q)localIterator.next();
        if (localq.getType() == i)
        {
          Log.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + paramq.getType() + " id=" + paramq.hashCode() + " cur_waiting_cnt=" + this.lCG.size());
          if (paramq.acceptConcurrent(localq))
          {
            AppMethodBeat.o(132354);
            return true;
          }
          if (paramq.accept(localq))
          {
            Log.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + paramq.getType() + " id=" + paramq.hashCode() + " cur_waiting_cnt=" + this.lCG.size() + " ---" + localq.hashCode());
            if (!this.foreground)
            {
              Log.appenderFlush();
              Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + paramq.getType(), false);
            }
            a(localq);
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
    this.lCI = Boolean.valueOf(paramBoolean);
    CrashReportFactory.setForeground(paramBoolean);
    com.tencent.mm.hardcoder.WXHardCoderJNI.foreground = paramBoolean;
    if (this.lCD == null)
    {
      Log.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
      AppMethodBeat.o(132331);
      return;
    }
    this.lCD.gj(paramBoolean);
    AppMethodBeat.o(132331);
  }
  
  public final void a(int paramInt, i parami)
  {
    AppMethodBeat.i(132338);
    synchronized (this.lCH)
    {
      if (!this.lCH.containsKey(Integer.valueOf(paramInt))) {
        this.lCH.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)this.lCH.get(Integer.valueOf(paramInt))).contains(parami)) {}
      synchronized ((Set)this.lCH.get(Integer.valueOf(paramInt)))
      {
        if (???.add(parami)) {
          ListenerInstanceMonitor.markInstanceRegistered(parami);
        }
        AppMethodBeat.o(132338);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132330);
    if (this.lCD == null)
    {
      Log.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
      AppMethodBeat.o(132330);
      return;
    }
    this.lCD.a(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.o(132330);
  }
  
  public final void a(q paramq)
  {
    AppMethodBeat.i(132346);
    if (paramq == null)
    {
      AppMethodBeat.o(132346);
      return;
    }
    Log.printInfoStack("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramq.hashCode()) });
    paramq.cancel();
    synchronized (this.lock)
    {
      this.lCG.remove(paramq);
      this.lCF.remove(paramq);
      AppMethodBeat.o(132346);
      return;
    }
  }
  
  public final boolean a(q paramq, int paramInt)
  {
    AppMethodBeat.i(132348);
    if ((paramq != null) || (paramInt >= 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.lCE == null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("worker thread has not been set", bool);
      if (c(paramq)) {
        break label62;
      }
      AppMethodBeat.o(132348);
      return false;
      bool = false;
      break;
    }
    label62:
    b(paramq, paramInt);
    AppMethodBeat.o(132348);
    return true;
  }
  
  public final g aHc()
  {
    return this.lCD;
  }
  
  public final void b(int paramInt, i parami)
  {
    AppMethodBeat.i(132339);
    synchronized (this.lCH)
    {
      for (;;)
      {
        try
        {
          localSet = (Set)this.lCH.get(Integer.valueOf(paramInt));
          if (localSet == null) {}
        }
        catch (Exception parami)
        {
          Set localSet;
          continue;
        }
        try
        {
          if (localSet.remove(parami)) {
            ListenerInstanceMonitor.markInstanceUnregistered(parami);
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
  
  public final boolean b(q paramq)
  {
    AppMethodBeat.i(292850);
    boolean bool = a(paramq, 0);
    AppMethodBeat.o(292850);
    return bool;
  }
  
  public final int bih()
  {
    AppMethodBeat.i(132332);
    try
    {
      if ((this.lCD != null) && (this.lCD.bix() != null))
      {
        int i = this.lCD.bix().btg();
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
  
  public final boolean bii()
  {
    AppMethodBeat.i(132333);
    if (this.lCD != null)
    {
      boolean bool = this.lCD.bii();
      AppMethodBeat.o(132333);
      return bool;
    }
    AppMethodBeat.o(132333);
    return true;
  }
  
  public final void bik()
  {
    AppMethodBeat.i(132342);
    Vector localVector = this.lCF;
    this.lCF = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      Log.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localq.getType());
      localq.cancel();
      b(3, -1, "doScene failed clearRunningQueue", localq);
    }
    localVector.clear();
    AppMethodBeat.o(132342);
  }
  
  public final void bil()
  {
    AppMethodBeat.i(132343);
    Log.i("MicroMsg.NetSceneQueue", "resetDispatcher");
    if (this.lCD != null)
    {
      this.lCD.reset();
      this.lCD = null;
    }
    AppMethodBeat.o(132343);
  }
  
  public final void c(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(196083);
    this.handler.post(new t.7(this, paramInt1, paramInt2, paramString, paramq));
    AppMethodBeat.o(196083);
  }
  
  public final void c(g paramg)
  {
    AppMethodBeat.i(132336);
    this.lCD = paramg;
    paramg.gj(this.foreground);
    bim();
    AppMethodBeat.o(132336);
  }
  
  public final void cancel(final int paramInt)
  {
    AppMethodBeat.i(132344);
    Log.printInfoStack("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.lCE.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132318);
        t.a(t.this, paramInt);
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
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132334);
    if (this.lCD != null)
    {
      String str = this.lCD.getNetworkServerIp();
      AppMethodBeat.o(132334);
      return str;
    }
    AppMethodBeat.o(132334);
    return "unknown";
  }
  
  public final void gi(boolean paramBoolean)
  {
    AppMethodBeat.i(132329);
    this.lCM = paramBoolean;
    if (!this.lCM)
    {
      this.lCN.stopTimer();
      AppMethodBeat.o(132329);
      return;
    }
    Log.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
    this.lCN.startTimer(this.lCL);
    AppMethodBeat.o(132329);
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
    gi(false);
    AppMethodBeat.o(132327);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    int i = 0;
    AppMethodBeat.i(132350);
    paramq.setHasCallbackToQueue(true);
    for (;;)
    {
      synchronized (this.lock)
      {
        this.lCF.remove(paramq);
        int j = paramq.getType();
        int k = paramq.hashCode();
        int m = paramq.getMMReqRespHash();
        int n = this.lCF.size();
        int i1 = this.lCG.size();
        if (this.lCD == null)
        {
          Log.i("MicroMsg.NetSceneQueue", "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          if ((paramInt1 == 4) && ((paramInt2 == -100) || (paramInt2 == -2023)))
          {
            ??? = new com.tencent.mm.f.a.c();
            ((com.tencent.mm.f.a.c)???).fuq.errType = paramInt1;
            ((com.tencent.mm.f.a.c)???).fuq.errCode = paramInt2;
            ((com.tencent.mm.f.a.c)???).fuq.errMsg = paramString;
            EventCenter.instance.publish((IEvent)???);
          }
          bim();
          b(paramInt1, paramInt2, paramString, paramq);
          if ((this.lCM) && (this.lCF.isEmpty()) && (this.lCG.isEmpty())) {
            this.lCN.startTimer(this.lCL);
          }
          AppMethodBeat.o(132350);
          return;
        }
      }
      i = this.lCD.hashCode();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132340);
    Log.i("MicroMsg.NetSceneQueue", "reset");
    if (this.lCD != null) {
      this.lCD.reset();
    }
    bik();
    bij();
    this.lCJ.reset();
    AppMethodBeat.o(132340);
  }
  
  public final void vH(final int paramInt)
  {
    AppMethodBeat.i(132345);
    Log.printInfoStack("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.lCE.postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132320);
        t.b(t.this, paramInt);
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
    public abstract void a(t paramt);
    
    public abstract void a(t paramt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.an.t
 * JD-Core Version:    0.7.0.1
 */