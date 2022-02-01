package com.tencent.mm.al;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.g.a.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class q
  implements f, com.tencent.mm.app.n
{
  private static int hOF = 1;
  private static q hOu = null;
  public boolean foreground;
  public Boolean hOA;
  private final a hOB;
  private long hOC;
  private boolean hOD;
  private av hOE;
  public e hOv;
  public aq hOw;
  private Vector<n> hOx;
  private Vector<n> hOy;
  private final Map<Integer, Set<f>> hOz;
  private final ap handler;
  private final Object lock;
  
  private q(a parama)
  {
    AppMethodBeat.i(132335);
    this.hOw = null;
    this.hOz = new HashMap();
    this.foreground = false;
    this.hOA = null;
    this.lock = new Object();
    this.hOC = 21600000L;
    this.hOD = false;
    this.hOE = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        boolean bool2 = false;
        AppMethodBeat.i(132316);
        if (q.b(q.this) == null)
        {
          AppMethodBeat.o(132316);
          return false;
        }
        ad.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", new Object[] { Integer.valueOf(q.c(q.this).size()), Integer.valueOf(q.d(q.this).size()), Boolean.valueOf(q.e(q.this)) });
        q.a locala = q.b(q.this);
        q localq = q.this;
        boolean bool1 = bool2;
        if (q.f(q.this))
        {
          bool1 = bool2;
          if (q.c(q.this).isEmpty())
          {
            bool1 = bool2;
            if (q.d(q.this).isEmpty()) {
              bool1 = true;
            }
          }
        }
        locala.a(localq, bool1);
        AppMethodBeat.o(132316);
        return true;
      }
    }, true);
    this.hOx = new Vector();
    this.hOy = new Vector();
    this.handler = new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(132317);
        q.this.a((n)paramAnonymousMessage.obj, 0);
        AppMethodBeat.o(132317);
      }
    };
    this.hOB = parama;
    AppForegroundDelegate.cSQ.a(this);
    AppMethodBeat.o(132335);
  }
  
  public static q a(a parama)
  {
    AppMethodBeat.i(132337);
    if (hOu == null) {
      hOu = new q(parama);
    }
    parama = hOu;
    AppMethodBeat.o(132337);
    return parama;
  }
  
  private void aEP()
  {
    AppMethodBeat.i(132341);
    Vector localVector = this.hOy;
    this.hOy = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      ad.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localn.getType());
      localn.cancel();
      b(3, -1, "doScene failed clearWaitingQueue", localn);
    }
    localVector.clear();
    AppMethodBeat.o(132341);
  }
  
  private void aES()
  {
    AppMethodBeat.i(132352);
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if (this.hOy.size() > 0)
        {
          n localn = (n)this.hOy.get(0);
          int j = localn.getPriority();
          i = 1;
          if (i < this.hOy.size())
          {
            if (((n)this.hOy.get(i)).getPriority() > j)
            {
              this.hOy.get(i);
              if (aET())
              {
                localn = (n)this.hOy.get(i);
                j = localn.getPriority();
              }
            }
          }
          else
          {
            this.hOy.remove(localn);
            ad.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.hOy.size());
            b(localn, 0);
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
  
  private boolean aET()
  {
    AppMethodBeat.i(132353);
    if (this.hOx.size() >= 50)
    {
      AppMethodBeat.o(132353);
      return false;
    }
    AppMethodBeat.o(132353);
    return true;
  }
  
  private void aEU()
  {
    AppMethodBeat.i(132355);
    if (this.hOB == null)
    {
      ad.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", new Object[] { this.hOB });
      AppMethodBeat.o(132355);
      return;
    }
    this.hOB.a(this);
    av localav = new av(Looper.getMainLooper(), new av.a()
    {
      private long cAH = 10L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132326);
        if (q.g(q.this) == null)
        {
          long l = this.cAH;
          this.cAH = (l - 1L);
          if (l > 0L)
          {
            AppMethodBeat.o(132326);
            return true;
          }
        }
        q.k(q.this);
        AppMethodBeat.o(132326);
        return false;
      }
    }, true);
    long l = hOF * 100;
    localav.az(l, l);
    if (hOF < 512) {
      hOF *= 2;
    }
    AppMethodBeat.o(132355);
  }
  
  private void b(final int paramInt1, final int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(132351);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132325);
        Set localSet = (Set)q.j(q.this).get(Integer.valueOf(paramn.getType()));
        f localf;
        if ((localSet != null) && (localSet.size() > 0))
        {
          Object localObject1 = new HashSet();
          try
          {
            ((Set)localObject1).addAll(localSet);
            localObject1 = ((Set)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localf = (f)((Iterator)localObject1).next();
              if ((localf != null) && (localSet.contains(localf))) {
                localf.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
              }
            }
            localSet = (Set)q.j(q.this).get(Integer.valueOf(-1));
          }
          finally
          {
            AppMethodBeat.o(132325);
          }
        }
        if ((localSet != null) && (localSet.size() > 0))
        {
          Object localObject3 = new HashSet();
          try
          {
            ((Set)localObject3).addAll(localSet);
            localObject3 = ((Set)localObject3).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localf = (f)((Iterator)localObject3).next();
              if ((localf != null) && (localSet.contains(localf))) {
                localf.onSceneEnd(paramInt1, paramInt2, paramString, paramn);
              }
            }
            AppMethodBeat.o(132325);
          }
          finally
          {
            AppMethodBeat.o(132325);
          }
        }
      }
    });
    AppMethodBeat.o(132351);
  }
  
  private void b(final n paramn, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(132349);
    boolean bool = aET();
    int j = this.hOx.size();
    int k = paramn.getType();
    int m = paramn.hashCode();
    int n = paramn.getMMReqRespHash();
    int i1 = this.hOy.size();
    if (this.hOv == null)
    {
      ad.i("MicroMsg.NetSceneQueue", "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((paramInt != 0) || (!bool) || (this.hOv == null)) {
        break label307;
      }
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.hOx.add(paramn);
        if (j == this.hOx.size()) {
          ad.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramn.hashCode()), Integer.valueOf(j), Integer.valueOf(this.hOx.size()), Integer.valueOf(this.hOy.size()) });
        }
        this.hOw.ay(new Runnable()
        {
          public final void run()
          {
            int k = 0;
            AppMethodBeat.i(132323);
            paramn.setOnSceneEnd(q.this);
            int j;
            if ((!paramn.isCanceled()) && (q.g(q.this) != null))
            {
              j = paramn.doScene(q.g(q.this), q.this);
              if (j >= 0) {}
            }
            for (int i = j;; i = 0)
            {
              int m = paramn.getType();
              int n = paramn.hashCode();
              int i1 = paramn.getMMReqRespHash();
              boolean bool = paramn.isCanceled();
              int i2 = q.c(q.this).size();
              int i3 = q.d(q.this).size();
              if (q.g(q.this) == null) {
                j = k;
              }
              for (;;)
              {
                ad.w("MicroMsg.NetSceneQueue", "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(j) });
                paramn.setOnSceneEnd(null);
                synchronized (q.h(q.this))
                {
                  q.c(q.this).remove(paramn);
                  if (paramn.isCanceled()) {
                    break;
                  }
                  q.i(q.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(132322);
                      q.this.onSceneEnd(3, -1, "doScene failed", q.5.this.diy);
                      AppMethodBeat.o(132322);
                    }
                  });
                  AppMethodBeat.o(132323);
                  return;
                  j = q.g(q.this).hashCode();
                }
              }
              k = paramn.getType();
              m = paramn.hashCode();
              n = paramn.getMMReqRespHash();
              i1 = q.c(q.this).size();
              i2 = q.d(q.this).size();
              if (q.g(q.this) == null) {}
              for (i = 0;; i = q.g(q.this).hashCode())
              {
                ad.i("MicroMsg.NetSceneQueue", "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i) });
                paramn.setHasCallbackToQueue(false);
                AppMethodBeat.o(132323);
                return;
              }
            }
          }
          
          public final String toString()
          {
            AppMethodBeat.i(132324);
            String str = super.toString() + "|doSceneImp_" + paramn + "_type=" + paramn.getType();
            AppMethodBeat.o(132324);
            return str;
          }
        });
        if (this.hOv != null) {
          break;
        }
        aEU();
        AppMethodBeat.o(132349);
        return;
        i = this.hOv.hashCode();
      }
      label307:
      if (paramInt > 0)
      {
        ??? = Message.obtain();
        ((Message)???).obj = paramn;
        this.handler.sendMessageDelayed((Message)???, paramInt);
        ad.i("MicroMsg.NetSceneQueue", "timed: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_after_sec=" + paramInt);
      }
      else
      {
        ad.i("MicroMsg.NetSceneQueue", "waited: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_waiting_cnt=" + this.hOy.size());
        synchronized (this.lock)
        {
          this.hOy.add(paramn);
          ad.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.hOy.size());
        }
      }
    }
    hOF = 1;
    AppMethodBeat.o(132349);
  }
  
  private boolean c(n paramn)
  {
    AppMethodBeat.i(132354);
    int i = paramn.getType();
    if (paramn.uniqueInNetsceneQueue()) {}
    synchronized (this.lock)
    {
      Iterator localIterator = this.hOx.iterator();
      n localn;
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        if (localn.getType() == i)
        {
          ad.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_running_cnt=" + this.hOx.size());
          if (paramn.acceptConcurrent(localn))
          {
            AppMethodBeat.o(132354);
            return true;
          }
          if (paramn.accept(localn))
          {
            ad.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_running_cnt=" + this.hOx.size() + " ---" + localn.hashCode());
            if (!this.foreground)
            {
              ad.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramn.getType() + "acinfo[" + localn.getInfo() + "] scinfo[" + paramn.getInfo() + "]");
              ad.fku();
              Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + paramn.getType(), false);
            }
            a(localn);
            AppMethodBeat.o(132354);
            return true;
          }
          AppMethodBeat.o(132354);
          return false;
        }
      }
      localIterator = this.hOy.iterator();
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        if (localn.getType() == i)
        {
          ad.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_waiting_cnt=" + this.hOy.size());
          if (paramn.acceptConcurrent(localn))
          {
            AppMethodBeat.o(132354);
            return true;
          }
          if (paramn.accept(localn))
          {
            ad.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_waiting_cnt=" + this.hOy.size() + " ---" + localn.hashCode());
            if (!this.foreground)
            {
              ad.fku();
              Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + paramn.getType(), false);
            }
            a(localn);
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
  
  private void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(132331);
    this.foreground = paramBoolean;
    this.hOA = Boolean.valueOf(paramBoolean);
    com.tencent.mm.sdk.a.b.eE(paramBoolean);
    com.tencent.mm.hardcoder.WXHardCoderJNI.foreground = paramBoolean;
    if (this.hOv == null)
    {
      ad.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
      AppMethodBeat.o(132331);
      return;
    }
    this.hOv.eF(paramBoolean);
    AppMethodBeat.o(132331);
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(132338);
    synchronized (this.hOz)
    {
      if (!this.hOz.containsKey(Integer.valueOf(paramInt))) {
        this.hOz.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)this.hOz.get(Integer.valueOf(paramInt))).contains(paramf)) {}
      synchronized ((Set)this.hOz.get(Integer.valueOf(paramInt)))
      {
        if (???.add(paramf)) {
          ListenerInstanceMonitor.dR(paramf);
        }
        AppMethodBeat.o(132338);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132330);
    if (this.hOv == null)
    {
      ad.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
      AppMethodBeat.o(132330);
      return;
    }
    this.hOv.a(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.o(132330);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(132346);
    if (paramn == null)
    {
      AppMethodBeat.o(132346);
      return;
    }
    ad.m("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramn.hashCode()) });
    paramn.cancel();
    synchronized (this.lock)
    {
      this.hOy.remove(paramn);
      this.hOx.remove(paramn);
      AppMethodBeat.o(132346);
      return;
    }
  }
  
  public final boolean a(n paramn, int paramInt)
  {
    AppMethodBeat.i(132348);
    if ((paramn != null) || (paramInt >= 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.hOw == null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("worker thread has not been set", bool);
      if (c(paramn)) {
        break label62;
      }
      AppMethodBeat.o(132348);
      return false;
      bool = false;
      break;
    }
    label62:
    b(paramn, paramInt);
    AppMethodBeat.o(132348);
    return true;
  }
  
  public final int aEN()
  {
    AppMethodBeat.i(132332);
    try
    {
      if ((this.hOv != null) && (this.hOv.aFd() != null))
      {
        int i = this.hOv.aFd().aOK();
        AppMethodBeat.o(132332);
        return i;
      }
      ad.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.NetSceneQueue", "exception:%s", new Object[] { bt.n(localException) });
      }
      AppMethodBeat.o(132332);
    }
    if (ay.isConnected(aj.getContext()))
    {
      AppMethodBeat.o(132332);
      return 6;
    }
    return 0;
  }
  
  public final boolean aEO()
  {
    AppMethodBeat.i(132333);
    if (this.hOv != null)
    {
      boolean bool = this.hOv.aEO();
      AppMethodBeat.o(132333);
      return bool;
    }
    AppMethodBeat.o(132333);
    return true;
  }
  
  public final void aEQ()
  {
    AppMethodBeat.i(132342);
    Vector localVector = this.hOx;
    this.hOx = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      ad.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localn.getType());
      localn.cancel();
      b(3, -1, "doScene failed clearRunningQueue", localn);
    }
    localVector.clear();
    AppMethodBeat.o(132342);
  }
  
  public final void aER()
  {
    AppMethodBeat.i(132343);
    ad.i("MicroMsg.NetSceneQueue", "resetDispatcher");
    if (this.hOv != null)
    {
      this.hOv.reset();
      this.hOv = null;
    }
    AppMethodBeat.o(132343);
  }
  
  public final e aiY()
  {
    return this.hOv;
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(132339);
    synchronized (this.hOz)
    {
      for (;;)
      {
        try
        {
          localSet = (Set)this.hOz.get(Integer.valueOf(paramInt));
          if (localSet == null) {}
        }
        catch (Exception paramf)
        {
          Set localSet;
          continue;
        }
        try
        {
          if (localSet.remove(paramf)) {
            ListenerInstanceMonitor.dS(paramf);
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
  
  public final boolean b(n paramn)
  {
    AppMethodBeat.i(221711);
    boolean bool = a(paramn, 0);
    AppMethodBeat.o(221711);
    return bool;
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(132336);
    this.hOv = parame;
    parame.eF(this.foreground);
    aES();
    AppMethodBeat.o(132336);
  }
  
  public final void cancel(final int paramInt)
  {
    AppMethodBeat.i(132344);
    ad.m("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.hOw.ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132318);
        q.a(q.this, paramInt);
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
  
  public final void eD(boolean paramBoolean)
  {
    AppMethodBeat.i(132329);
    this.hOD = paramBoolean;
    if (!this.hOD)
    {
      this.hOE.stopTimer();
      AppMethodBeat.o(132329);
      return;
    }
    ad.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
    av localav = this.hOE;
    long l = this.hOC;
    localav.az(l, l);
    AppMethodBeat.o(132329);
  }
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132334);
    if (this.hOv != null)
    {
      String str = this.hOv.getNetworkServerIp();
      AppMethodBeat.o(132334);
      return str;
    }
    AppMethodBeat.o(132334);
    return "unknown";
  }
  
  public final void oT(final int paramInt)
  {
    AppMethodBeat.i(132345);
    ad.m("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.hOw.ay(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(132320);
        q.b(q.this, paramInt);
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
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(132328);
    ad.i("MicroMsg.NetSceneQueue", "onAppBackground");
    eE(false);
    AppMethodBeat.o(132328);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(132327);
    ad.i("MicroMsg.NetSceneQueue", "onAppForeground");
    eE(true);
    eD(false);
    AppMethodBeat.o(132327);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(132350);
    paramn.setHasCallbackToQueue(true);
    for (;;)
    {
      synchronized (this.lock)
      {
        this.hOx.remove(paramn);
        int j = paramn.getType();
        int k = paramn.hashCode();
        int m = paramn.getMMReqRespHash();
        int n = this.hOx.size();
        int i1 = this.hOy.size();
        if (this.hOv == null)
        {
          ad.i("MicroMsg.NetSceneQueue", "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          if ((paramInt1 == 4) && (paramInt2 == -100))
          {
            ??? = new c();
            ((c)???).djC.errType = paramInt1;
            ((c)???).djC.errCode = paramInt2;
            ((c)???).djC.errMsg = paramString;
            a.IbL.l((com.tencent.mm.sdk.b.b)???);
          }
          aES();
          b(paramInt1, paramInt2, paramString, paramn);
          if ((this.hOD) && (this.hOx.isEmpty()) && (this.hOy.isEmpty()))
          {
            paramString = this.hOE;
            long l = this.hOC;
            paramString.az(l, l);
          }
          AppMethodBeat.o(132350);
          return;
        }
      }
      i = this.hOv.hashCode();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132340);
    ad.i("MicroMsg.NetSceneQueue", "reset");
    if (this.hOv != null) {
      this.hOv.reset();
    }
    aEQ();
    aEP();
    AppMethodBeat.o(132340);
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
    
    public abstract void a(q paramq, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.al.q
 * JD-Core Version:    0.7.0.1
 */