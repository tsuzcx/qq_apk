package com.tencent.mm.ah;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.network.e;
import com.tencent.mm.network.i;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class p
  implements f
{
  private static int edH = 1;
  private static p edw = null;
  private Vector<m> edA = new Vector();
  private final Map<Integer, Set<f>> edB = new HashMap();
  public Boolean edC = null;
  private final a edD;
  private long edE = 21600000L;
  private boolean edF = false;
  private am edG = new am(Looper.getMainLooper(), new am.a()
  {
    public final boolean tC()
    {
      boolean bool2 = false;
      if (p.b(p.this) == null) {
        return false;
      }
      y.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", new Object[] { Integer.valueOf(p.c(p.this).size()), Integer.valueOf(p.d(p.this).size()), Boolean.valueOf(p.e(p.this)) });
      p.a locala = p.b(p.this);
      p localp = p.this;
      boolean bool1 = bool2;
      if (p.f(p.this))
      {
        bool1 = bool2;
        if (p.c(p.this).isEmpty())
        {
          bool1 = bool2;
          if (p.d(p.this).isEmpty()) {
            bool1 = true;
          }
        }
      }
      locala.a(localp, bool1);
      return true;
    }
  }, true);
  public e edx;
  public ai edy = null;
  private Vector<m> edz = new Vector();
  public boolean foreground = false;
  private final ah handler = new ah(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      p.this.a((m)paramAnonymousMessage.obj, 0);
    }
  };
  private final Object lock = new Object();
  
  private p(a parama)
  {
    this.edD = parama;
  }
  
  private void KK()
  {
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if (this.edA.size() > 0)
        {
          m localm = (m)this.edA.get(0);
          int j = localm.priority;
          i = 1;
          if (i < this.edA.size())
          {
            if (((m)this.edA.get(i)).priority > j)
            {
              this.edA.get(i);
              if (KL())
              {
                localm = (m)this.edA.get(i);
                j = localm.priority;
              }
            }
          }
          else
          {
            this.edA.remove(localm);
            y.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.edA.size());
            b(localm, 0);
          }
        }
        else
        {
          return;
        }
      }
      i += 1;
    }
  }
  
  private boolean KL()
  {
    return this.edz.size() < 50;
  }
  
  public static p a(a parama)
  {
    if (edw == null) {
      edw = new p(parama);
    }
    return edw;
  }
  
  private void b(final int paramInt1, final int paramInt2, final String paramString, final m paramm)
  {
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        Set localSet = (Set)p.j(p.this).get(Integer.valueOf(paramm.getType()));
        Object localObject;
        f localf;
        if ((localSet != null) && (localSet.size() > 0))
        {
          localObject = new HashSet();
          ((Set)localObject).addAll(localSet);
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localf = (f)((Iterator)localObject).next();
            if ((localf != null) && (localSet.contains(localf))) {
              localf.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
            }
          }
        }
        localSet = (Set)p.j(p.this).get(Integer.valueOf(-1));
        if ((localSet != null) && (localSet.size() > 0))
        {
          localObject = new HashSet();
          ((Set)localObject).addAll(localSet);
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            localf = (f)((Iterator)localObject).next();
            if ((localf != null) && (localSet.contains(localf))) {
              localf.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
            }
          }
        }
      }
    });
  }
  
  private void b(final m paramm, int paramInt)
  {
    boolean bool = KL();
    int j = this.edz.size();
    int k = paramm.getType();
    int m = paramm.hashCode();
    int n = paramm.KC();
    int i1 = this.edA.size();
    int i;
    if (this.edx == null)
    {
      i = 0;
      y.i("MicroMsg.NetSceneQueue", "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((paramInt != 0) || (!bool) || (this.edx == null)) {
        break label308;
      }
    }
    label308:
    do
    {
      for (;;)
      {
        synchronized (this.lock)
        {
          this.edz.add(paramm);
          if (j == this.edz.size()) {
            y.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramm.hashCode()), Integer.valueOf(j), Integer.valueOf(this.edz.size()), Integer.valueOf(this.edA.size()) });
          }
          this.edy.O(new Runnable()
          {
            public final void run()
            {
              int k = 0;
              paramm.edg = p.this;
              int j;
              if ((!paramm.aSd) && (p.g(p.this) != null))
              {
                j = paramm.a(p.g(p.this), p.this);
                if (j >= 0) {}
              }
              for (int i = j;; i = 0)
              {
                int m = paramm.getType();
                int n = paramm.hashCode();
                int i1 = paramm.KC();
                boolean bool = paramm.aSd;
                int i2 = p.c(p.this).size();
                int i3 = p.d(p.this).size();
                if (p.g(p.this) == null) {
                  j = k;
                }
                for (;;)
                {
                  y.w("MicroMsg.NetSceneQueue", "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(j) });
                  paramm.edg = null;
                  synchronized (p.h(p.this))
                  {
                    p.c(p.this).remove(paramm);
                    if (!paramm.aSd) {
                      p.i(p.this).post(new Runnable()
                      {
                        public final void run()
                        {
                          p.this.onSceneEnd(3, -1, "doScene failed", p.5.this.bEe);
                        }
                      });
                    }
                    return;
                    j = p.g(p.this).hashCode();
                  }
                }
                k = paramm.getType();
                m = paramm.hashCode();
                n = paramm.KC();
                i1 = p.c(p.this).size();
                i2 = p.d(p.this).size();
                if (p.g(p.this) == null) {}
                for (i = 0;; i = p.g(p.this).hashCode())
                {
                  y.i("MicroMsg.NetSceneQueue", "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i) });
                  paramm.edh = false;
                  return;
                }
              }
            }
            
            public final String toString()
            {
              return super.toString() + "|doSceneImp_" + paramm + "_type=" + paramm.getType();
            }
          });
          if (this.edx != null) {
            break label563;
          }
          if (this.edD != null) {
            break;
          }
          y.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", new Object[] { this.edD });
          return;
          i = this.edx.hashCode();
        }
        if (paramInt > 0)
        {
          ??? = Message.obtain();
          ((Message)???).obj = paramm;
          this.handler.sendMessageDelayed((Message)???, paramInt);
          y.i("MicroMsg.NetSceneQueue", "timed: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_after_sec=" + paramInt);
        }
        else
        {
          y.i("MicroMsg.NetSceneQueue", "waited: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_waiting_cnt=" + this.edA.size());
          synchronized (this.lock)
          {
            this.edA.add(paramm);
            y.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.edA.size());
          }
        }
      }
      this.edD.a(this);
      paramm = new am(Looper.getMainLooper(), new am.a()
      {
        private long edM = 10L;
        
        public final boolean tC()
        {
          if (p.g(p.this) == null)
          {
            long l = this.edM;
            this.edM = (l - 1L);
            if (l > 0L) {
              return true;
            }
          }
          p.k(p.this);
          return false;
        }
      }, true);
      long l = edH * 100;
      paramm.S(l, l);
    } while (edH >= 512);
    edH *= 2;
    return;
    label563:
    edH = 1;
  }
  
  private boolean e(m paramm)
  {
    int i = paramm.getType();
    if (paramm.Kx()) {
      synchronized (this.lock)
      {
        Iterator localIterator = this.edz.iterator();
        m localm;
        while (localIterator.hasNext())
        {
          localm = (m)localIterator.next();
          if (localm.getType() == i)
          {
            y.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_running_cnt=" + this.edz.size());
            if (paramm.b(localm)) {
              return true;
            }
            if (paramm.a(localm))
            {
              y.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_running_cnt=" + this.edz.size() + " ---" + localm.hashCode());
              if (!this.foreground)
              {
                y.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramm.getType() + "acinfo[" + localm.getInfo() + "] scinfo[" + paramm.getInfo() + "]");
                y.cqL();
                Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + paramm.getType(), false);
              }
              c(localm);
              return true;
            }
            return false;
          }
        }
        localIterator = this.edA.iterator();
        while (localIterator.hasNext())
        {
          localm = (m)localIterator.next();
          if (localm.getType() == i)
          {
            y.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_waiting_cnt=" + this.edA.size());
            if (paramm.b(localm)) {
              return true;
            }
            if (paramm.a(localm))
            {
              y.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_waiting_cnt=" + this.edA.size() + " ---" + localm.hashCode());
              if (!this.foreground)
              {
                y.cqL();
                Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + paramm.getType(), false);
              }
              c(localm);
              return true;
            }
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public final e Do()
  {
    return this.edx;
  }
  
  public final int KG()
  {
    try
    {
      if ((this.edx != null) && (this.edx.KS() != null)) {
        return this.edx.KS().TV();
      }
      y.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.NetSceneQueue", "exception:%s", new Object[] { bk.j(localException) });
      }
    }
    if (aq.isConnected(ae.getContext())) {
      return 6;
    }
    return 0;
  }
  
  public final boolean KH()
  {
    if (this.edx != null) {
      return this.edx.KH();
    }
    return true;
  }
  
  public final void KI()
  {
    Vector localVector = this.edz;
    this.edz = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      y.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localm.getType());
      localm.cancel();
      b(3, -1, "doScene failed clearRunningQueue", localm);
    }
    localVector.clear();
  }
  
  public final void KJ()
  {
    y.i("MicroMsg.NetSceneQueue", "resetDispatcher");
    if (this.edx != null)
    {
      this.edx.reset();
      this.edx = null;
    }
  }
  
  public final void a(int paramInt, f paramf)
  {
    synchronized (this.edB)
    {
      if (!this.edB.containsKey(Integer.valueOf(paramInt))) {
        this.edB.put(Integer.valueOf(paramInt), new HashSet());
      }
      if ((!((Set)this.edB.get(Integer.valueOf(paramInt))).contains(paramf)) && (((Set)this.edB.get(Integer.valueOf(paramInt))).add(paramf))) {
        ListenerInstanceMonitor.bP(paramf);
      }
      return;
    }
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    if (this.edx == null)
    {
      y.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
      return;
    }
    this.edx.a(paramInt1, paramString, paramInt2, paramBoolean);
  }
  
  public final boolean a(m paramm, int paramInt)
  {
    if ((paramm != null) || (paramInt >= 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.edy == null) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("worker thread has not been set", bool);
      if (e(paramm)) {
        break label50;
      }
      return false;
      bool = false;
      break;
    }
    label50:
    b(paramm, paramInt);
    return true;
  }
  
  public final void b(int paramInt, f paramf)
  {
    try
    {
      synchronized (this.edB)
      {
        if ((this.edB.get(Integer.valueOf(paramInt)) != null) && (((Set)this.edB.get(Integer.valueOf(paramInt))).remove(paramf))) {
          ListenerInstanceMonitor.bQ(paramf);
        }
        label52:
        return;
      }
    }
    catch (Exception paramf)
    {
      break label52;
    }
  }
  
  public final void bM(boolean paramBoolean)
  {
    this.edF = paramBoolean;
    if (!this.edF)
    {
      this.edG.stopTimer();
      return;
    }
    y.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
    am localam = this.edG;
    long l = this.edE;
    localam.S(l, l);
  }
  
  public final void bN(boolean paramBoolean)
  {
    this.foreground = paramBoolean;
    this.edC = Boolean.valueOf(paramBoolean);
    b.bN(paramBoolean);
    com.tencent.mm.hardcoder.WXHardCoderJNI.foreground = paramBoolean;
    if (this.edx == null)
    {
      y.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
      return;
    }
    this.edx.bO(paramBoolean);
  }
  
  public final void c(m paramm)
  {
    if (paramm == null) {
      return;
    }
    y.l("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramm.hashCode()) });
    paramm.cancel();
    synchronized (this.lock)
    {
      this.edA.remove(paramm);
      this.edz.remove(paramm);
      return;
    }
  }
  
  public final void cancel(final int paramInt)
  {
    y.l("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.edy.O(new Runnable()
    {
      public final void run()
      {
        p.a(p.this, paramInt);
      }
      
      public final String toString()
      {
        return super.toString() + "|cancelImp_" + paramInt;
      }
    });
  }
  
  public final void d(e parame)
  {
    this.edx = parame;
    parame.bO(this.foreground);
    KK();
  }
  
  public final boolean d(m paramm)
  {
    return a(paramm, 0);
  }
  
  public final String getNetworkServerIp()
  {
    if (this.edx != null) {
      return this.edx.getNetworkServerIp();
    }
    return "unknown";
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    paramm.edh = true;
    for (;;)
    {
      synchronized (this.lock)
      {
        this.edz.remove(paramm);
        int j = paramm.getType();
        int k = paramm.hashCode();
        int m = paramm.KC();
        int n = this.edz.size();
        int i1 = this.edA.size();
        if (this.edx == null)
        {
          y.i("MicroMsg.NetSceneQueue", "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          KK();
          b(paramInt1, paramInt2, paramString, paramm);
          if ((this.edF) && (this.edz.isEmpty()) && (this.edA.isEmpty()))
          {
            paramString = this.edG;
            long l = this.edE;
            paramString.S(l, l);
          }
          return;
        }
      }
      i = this.edx.hashCode();
    }
  }
  
  public final void reset()
  {
    if (this.edx != null) {
      this.edx.reset();
    }
    KI();
    Vector localVector = this.edA;
    this.edA = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      y.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localm.getType());
      localm.cancel();
      b(3, -1, "doScene failed clearWaitingQueue", localm);
    }
    localVector.clear();
  }
  
  public static abstract interface a
  {
    public abstract void a(p paramp);
    
    public abstract void a(p paramp, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.p
 * JD-Core Version:    0.7.0.1
 */