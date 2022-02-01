package com.tencent.mm.ak;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class q
  implements f, o
{
  private static q hRn = null;
  private static int hRy = 1;
  public boolean foreground;
  public e hRo;
  public ar hRp;
  private Vector<n> hRq;
  private Vector<n> hRr;
  private final Map<Integer, Set<f>> hRs;
  public Boolean hRt;
  private final a hRu;
  private long hRv;
  private boolean hRw;
  private aw hRx;
  private final aq handler;
  private final Object lock;
  
  private q(a parama)
  {
    AppMethodBeat.i(132335);
    this.hRp = null;
    this.hRs = new HashMap();
    this.foreground = false;
    this.hRt = null;
    this.lock = new Object();
    this.hRv = 21600000L;
    this.hRw = false;
    this.hRx = new aw(Looper.getMainLooper(), new aw.a()
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
        ae.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", new Object[] { Integer.valueOf(q.c(q.this).size()), Integer.valueOf(q.d(q.this).size()), Boolean.valueOf(q.e(q.this)) });
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
    this.hRq = new Vector();
    this.hRr = new Vector();
    this.handler = new aq(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(132317);
        q.this.a((n)paramAnonymousMessage.obj, 0);
        AppMethodBeat.o(132317);
      }
    };
    this.hRu = parama;
    AppForegroundDelegate.cTA.a(this);
    AppMethodBeat.o(132335);
  }
  
  public static q a(a parama)
  {
    AppMethodBeat.i(132337);
    if (hRn == null) {
      hRn = new q(parama);
    }
    parama = hRn;
    AppMethodBeat.o(132337);
    return parama;
  }
  
  private void aFf()
  {
    AppMethodBeat.i(132341);
    Vector localVector = this.hRr;
    this.hRr = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      ae.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localn.getType());
      localn.cancel();
      b(3, -1, "doScene failed clearWaitingQueue", localn);
    }
    localVector.clear();
    AppMethodBeat.o(132341);
  }
  
  private void aFi()
  {
    AppMethodBeat.i(132352);
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if (this.hRr.size() > 0)
        {
          n localn = (n)this.hRr.get(0);
          int j = localn.getPriority();
          i = 1;
          if (i < this.hRr.size())
          {
            if (((n)this.hRr.get(i)).getPriority() > j)
            {
              this.hRr.get(i);
              if (aFj())
              {
                localn = (n)this.hRr.get(i);
                j = localn.getPriority();
              }
            }
          }
          else
          {
            this.hRr.remove(localn);
            ae.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.hRr.size());
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
  
  private boolean aFj()
  {
    AppMethodBeat.i(132353);
    if (this.hRq.size() >= 50)
    {
      AppMethodBeat.o(132353);
      return false;
    }
    AppMethodBeat.o(132353);
    return true;
  }
  
  private void aFk()
  {
    AppMethodBeat.i(132355);
    if (this.hRu == null)
    {
      ae.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", new Object[] { this.hRu });
      AppMethodBeat.o(132355);
      return;
    }
    this.hRu.a(this);
    aw localaw = new aw(Looper.getMainLooper(), new aw.a()
    {
      private long cBo = 10L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(132326);
        if (q.g(q.this) == null)
        {
          long l = this.cBo;
          this.cBo = (l - 1L);
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
    long l = hRy * 100;
    localaw.ay(l, l);
    if (hRy < 512) {
      hRy *= 2;
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
    boolean bool = aFj();
    int j = this.hRq.size();
    int k = paramn.getType();
    int m = paramn.hashCode();
    int n = paramn.getMMReqRespHash();
    int i1 = this.hRr.size();
    if (this.hRo == null)
    {
      ae.i("MicroMsg.NetSceneQueue", "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((paramInt != 0) || (!bool) || (this.hRo == null)) {
        break label307;
      }
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.hRq.add(paramn);
        if (j == this.hRq.size()) {
          ae.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramn.hashCode()), Integer.valueOf(j), Integer.valueOf(this.hRq.size()), Integer.valueOf(this.hRr.size()) });
        }
        this.hRp.aw(new Runnable()
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
                ae.w("MicroMsg.NetSceneQueue", "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(j) });
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
                      q.this.onSceneEnd(3, -1, "doScene failed", q.5.this.djA);
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
                ae.i("MicroMsg.NetSceneQueue", "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i) });
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
        if (this.hRo != null) {
          break;
        }
        aFk();
        AppMethodBeat.o(132349);
        return;
        i = this.hRo.hashCode();
      }
      label307:
      if (paramInt > 0)
      {
        ??? = Message.obtain();
        ((Message)???).obj = paramn;
        this.handler.sendMessageDelayed((Message)???, paramInt);
        ae.i("MicroMsg.NetSceneQueue", "timed: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_after_sec=" + paramInt);
      }
      else
      {
        ae.i("MicroMsg.NetSceneQueue", "waited: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_waiting_cnt=" + this.hRr.size());
        synchronized (this.lock)
        {
          this.hRr.add(paramn);
          ae.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.hRr.size());
        }
      }
    }
    hRy = 1;
    AppMethodBeat.o(132349);
  }
  
  private boolean c(n paramn)
  {
    AppMethodBeat.i(132354);
    int i = paramn.getType();
    if (paramn.uniqueInNetsceneQueue()) {}
    synchronized (this.lock)
    {
      Iterator localIterator = this.hRq.iterator();
      n localn;
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        if (localn.getType() == i)
        {
          ae.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_running_cnt=" + this.hRq.size());
          if (paramn.acceptConcurrent(localn))
          {
            AppMethodBeat.o(132354);
            return true;
          }
          if (paramn.accept(localn))
          {
            ae.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_running_cnt=" + this.hRq.size() + " ---" + localn.hashCode());
            if (!this.foreground)
            {
              ae.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramn.getType() + "acinfo[" + localn.getInfo() + "] scinfo[" + paramn.getInfo() + "]");
              ae.foo();
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
      localIterator = this.hRr.iterator();
      while (localIterator.hasNext())
      {
        localn = (n)localIterator.next();
        if (localn.getType() == i)
        {
          ae.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_waiting_cnt=" + this.hRr.size());
          if (paramn.acceptConcurrent(localn))
          {
            AppMethodBeat.o(132354);
            return true;
          }
          if (paramn.accept(localn))
          {
            ae.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + paramn.getType() + " id=" + paramn.hashCode() + " cur_waiting_cnt=" + this.hRr.size() + " ---" + localn.hashCode());
            if (!this.foreground)
            {
              ae.foo();
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
  
  private void eG(boolean paramBoolean)
  {
    AppMethodBeat.i(132331);
    this.foreground = paramBoolean;
    this.hRt = Boolean.valueOf(paramBoolean);
    com.tencent.mm.sdk.a.b.eG(paramBoolean);
    com.tencent.mm.hardcoder.WXHardCoderJNI.foreground = paramBoolean;
    if (this.hRo == null)
    {
      ae.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
      AppMethodBeat.o(132331);
      return;
    }
    this.hRo.eH(paramBoolean);
    AppMethodBeat.o(132331);
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(132338);
    synchronized (this.hRs)
    {
      if (!this.hRs.containsKey(Integer.valueOf(paramInt))) {
        this.hRs.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)this.hRs.get(Integer.valueOf(paramInt))).contains(paramf)) {}
      synchronized ((Set)this.hRs.get(Integer.valueOf(paramInt)))
      {
        if (???.add(paramf)) {
          ListenerInstanceMonitor.dS(paramf);
        }
        AppMethodBeat.o(132338);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(132330);
    if (this.hRo == null)
    {
      ae.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
      AppMethodBeat.o(132330);
      return;
    }
    this.hRo.a(paramInt1, paramString, paramInt2, paramBoolean);
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
    ae.m("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramn.hashCode()) });
    paramn.cancel();
    synchronized (this.lock)
    {
      this.hRr.remove(paramn);
      this.hRq.remove(paramn);
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
      if (this.hRp == null) {
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
  
  public final int aFd()
  {
    AppMethodBeat.i(132332);
    try
    {
      if ((this.hRo != null) && (this.hRo.aFt() != null))
      {
        int i = this.hRo.aFt().aPh();
        AppMethodBeat.o(132332);
        return i;
      }
      ae.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.NetSceneQueue", "exception:%s", new Object[] { bu.o(localException) });
      }
      AppMethodBeat.o(132332);
    }
    if (az.isConnected(ak.getContext()))
    {
      AppMethodBeat.o(132332);
      return 6;
    }
    return 0;
  }
  
  public final boolean aFe()
  {
    AppMethodBeat.i(132333);
    if (this.hRo != null)
    {
      boolean bool = this.hRo.aFe();
      AppMethodBeat.o(132333);
      return bool;
    }
    AppMethodBeat.o(132333);
    return true;
  }
  
  public final void aFg()
  {
    AppMethodBeat.i(132342);
    Vector localVector = this.hRq;
    this.hRq = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      ae.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localn.getType());
      localn.cancel();
      b(3, -1, "doScene failed clearRunningQueue", localn);
    }
    localVector.clear();
    AppMethodBeat.o(132342);
  }
  
  public final void aFh()
  {
    AppMethodBeat.i(132343);
    ae.i("MicroMsg.NetSceneQueue", "resetDispatcher");
    if (this.hRo != null)
    {
      this.hRo.reset();
      this.hRo = null;
    }
    AppMethodBeat.o(132343);
  }
  
  public final e ajn()
  {
    return this.hRo;
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(132339);
    synchronized (this.hRs)
    {
      for (;;)
      {
        try
        {
          localSet = (Set)this.hRs.get(Integer.valueOf(paramInt));
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
            ListenerInstanceMonitor.dT(paramf);
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
    AppMethodBeat.i(224420);
    boolean bool = a(paramn, 0);
    AppMethodBeat.o(224420);
    return bool;
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(132336);
    this.hRo = parame;
    parame.eH(this.foreground);
    aFi();
    AppMethodBeat.o(132336);
  }
  
  public final void cancel(final int paramInt)
  {
    AppMethodBeat.i(132344);
    ae.m("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.hRp.aw(new Runnable()
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
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(132329);
    this.hRw = paramBoolean;
    if (!this.hRw)
    {
      this.hRx.stopTimer();
      AppMethodBeat.o(132329);
      return;
    }
    ae.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
    aw localaw = this.hRx;
    long l = this.hRv;
    localaw.ay(l, l);
    AppMethodBeat.o(132329);
  }
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(132334);
    if (this.hRo != null)
    {
      String str = this.hRo.getNetworkServerIp();
      AppMethodBeat.o(132334);
      return str;
    }
    AppMethodBeat.o(132334);
    return "unknown";
  }
  
  public final void oW(final int paramInt)
  {
    AppMethodBeat.i(132345);
    ae.m("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.hRp.aw(new Runnable()
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
    ae.i("MicroMsg.NetSceneQueue", "onAppBackground");
    eG(false);
    AppMethodBeat.o(132328);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(132327);
    ae.i("MicroMsg.NetSceneQueue", "onAppForeground");
    eG(true);
    eF(false);
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
        this.hRq.remove(paramn);
        int j = paramn.getType();
        int k = paramn.hashCode();
        int m = paramn.getMMReqRespHash();
        int n = this.hRq.size();
        int i1 = this.hRr.size();
        if (this.hRo == null)
        {
          ae.i("MicroMsg.NetSceneQueue", "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          if ((paramInt1 == 4) && (paramInt2 == -100))
          {
            ??? = new c();
            ((c)???).dkE.errType = paramInt1;
            ((c)???).dkE.errCode = paramInt2;
            ((c)???).dkE.errMsg = paramString;
            a.IvT.l((com.tencent.mm.sdk.b.b)???);
          }
          aFi();
          b(paramInt1, paramInt2, paramString, paramn);
          if ((this.hRw) && (this.hRq.isEmpty()) && (this.hRr.isEmpty()))
          {
            paramString = this.hRx;
            long l = this.hRv;
            paramString.ay(l, l);
          }
          AppMethodBeat.o(132350);
          return;
        }
      }
      i = this.hRo.hashCode();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(132340);
    ae.i("MicroMsg.NetSceneQueue", "reset");
    if (this.hRo != null) {
      this.hRo.reset();
    }
    aFg();
    aFf();
    AppMethodBeat.o(132340);
  }
  
  public static abstract interface a
  {
    public abstract void a(q paramq);
    
    public abstract void a(q paramq, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.q
 * JD-Core Version:    0.7.0.1
 */