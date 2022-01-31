package com.tencent.mm.ai;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.j;
import com.tencent.mm.network.e;
import com.tencent.mm.network.i;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class p
  implements f, j
{
  private static int ftK = 1;
  private static p ftz = null;
  public boolean foreground;
  public e ftA;
  public al ftB;
  private Vector<m> ftC;
  private Vector<m> ftD;
  private final Map<Integer, Set<f>> ftE;
  public Boolean ftF;
  private final a ftG;
  private long ftH;
  private boolean ftI;
  private ap ftJ;
  private final ak handler;
  private final Object lock;
  
  private p(a parama)
  {
    AppMethodBeat.i(58187);
    this.ftB = null;
    this.ftE = new HashMap();
    this.foreground = false;
    this.ftF = null;
    this.lock = new Object();
    this.ftH = 21600000L;
    this.ftI = false;
    this.ftJ = new ap(Looper.getMainLooper(), new ap.a()
    {
      public final boolean onTimerExpired()
      {
        boolean bool2 = false;
        AppMethodBeat.i(58170);
        if (p.b(p.this) == null)
        {
          AppMethodBeat.o(58170);
          return false;
        }
        ab.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", new Object[] { Integer.valueOf(p.c(p.this).size()), Integer.valueOf(p.d(p.this).size()), Boolean.valueOf(p.e(p.this)) });
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
        AppMethodBeat.o(58170);
        return true;
      }
    }, true);
    this.ftC = new Vector();
    this.ftD = new Vector();
    this.handler = new ak(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(58171);
        p.this.a((m)paramAnonymousMessage.obj, 0);
        AppMethodBeat.o(58171);
      }
    };
    this.ftG = parama;
    AppForegroundDelegate.bXk.a(this);
    AppMethodBeat.o(58187);
  }
  
  public static p a(a parama)
  {
    AppMethodBeat.i(58189);
    if (ftz == null) {
      ftz = new p(parama);
    }
    parama = ftz;
    AppMethodBeat.o(58189);
    return parama;
  }
  
  private void adA()
  {
    AppMethodBeat.i(58207);
    if (this.ftG == null)
    {
      ab.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", new Object[] { this.ftG });
      AppMethodBeat.o(58207);
      return;
    }
    this.ftG.a(this);
    ap localap = new ap(Looper.getMainLooper(), new ap.a()
    {
      private long ftP = 10L;
      
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(58180);
        if (p.g(p.this) == null)
        {
          long l = this.ftP;
          this.ftP = (l - 1L);
          if (l > 0L)
          {
            AppMethodBeat.o(58180);
            return true;
          }
        }
        p.k(p.this);
        AppMethodBeat.o(58180);
        return false;
      }
    }, true);
    long l = ftK * 100;
    localap.ag(l, l);
    if (ftK < 512) {
      ftK *= 2;
    }
    AppMethodBeat.o(58207);
  }
  
  private void adv()
  {
    AppMethodBeat.i(58193);
    Vector localVector = this.ftD;
    this.ftD = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      ab.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localm.getType());
      localm.cancel();
      b(3, -1, "doScene failed clearWaitingQueue", localm);
    }
    localVector.clear();
    AppMethodBeat.o(58193);
  }
  
  private void ady()
  {
    AppMethodBeat.i(58204);
    for (;;)
    {
      int i;
      synchronized (this.lock)
      {
        if (this.ftD.size() > 0)
        {
          m localm = (m)this.ftD.get(0);
          int j = localm.getPriority();
          i = 1;
          if (i < this.ftD.size())
          {
            if (((m)this.ftD.get(i)).getPriority() > j)
            {
              this.ftD.get(i);
              if (adz())
              {
                localm = (m)this.ftD.get(i);
                j = localm.getPriority();
              }
            }
          }
          else
          {
            this.ftD.remove(localm);
            ab.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.ftD.size());
            b(localm, 0);
          }
        }
        else
        {
          AppMethodBeat.o(58204);
          return;
        }
      }
      i += 1;
    }
  }
  
  private boolean adz()
  {
    AppMethodBeat.i(58205);
    if (this.ftC.size() >= 50)
    {
      AppMethodBeat.o(58205);
      return false;
    }
    AppMethodBeat.o(58205);
    return true;
  }
  
  private void b(final int paramInt1, final int paramInt2, final String paramString, final m paramm)
  {
    AppMethodBeat.i(58203);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(58179);
        Set localSet = (Set)p.j(p.this).get(Integer.valueOf(paramm.getType()));
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
                localf.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
              }
            }
            localSet = (Set)p.j(p.this).get(Integer.valueOf(-1));
          }
          finally
          {
            AppMethodBeat.o(58179);
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
                localf.onSceneEnd(paramInt1, paramInt2, paramString, paramm);
              }
            }
            AppMethodBeat.o(58179);
          }
          finally
          {
            AppMethodBeat.o(58179);
          }
        }
      }
    });
    AppMethodBeat.o(58203);
  }
  
  private void b(final m paramm, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(58201);
    boolean bool = adz();
    int j = this.ftC.size();
    int k = paramm.getType();
    int m = paramm.hashCode();
    int n = paramm.getMMReqRespHash();
    int i1 = this.ftD.size();
    if (this.ftA == null)
    {
      ab.i("MicroMsg.NetSceneQueue", "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(j), Integer.valueOf(i1), Integer.valueOf(paramInt), Boolean.valueOf(bool), Integer.valueOf(i) });
      if ((paramInt != 0) || (!bool) || (this.ftA == null)) {
        break label307;
      }
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        this.ftC.add(paramm);
        if (j == this.ftC.size()) {
          ab.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramm.hashCode()), Integer.valueOf(j), Integer.valueOf(this.ftC.size()), Integer.valueOf(this.ftD.size()) });
        }
        this.ftB.ac(new Runnable()
        {
          public final void run()
          {
            int k = 0;
            AppMethodBeat.i(58177);
            paramm.setOnSceneEnd(p.this);
            int j;
            if ((!paramm.isCanceled()) && (p.g(p.this) != null))
            {
              j = paramm.doScene(p.g(p.this), p.this);
              if (j >= 0) {}
            }
            for (int i = j;; i = 0)
            {
              int m = paramm.getType();
              int n = paramm.hashCode();
              int i1 = paramm.getMMReqRespHash();
              boolean bool = paramm.isCanceled();
              int i2 = p.c(p.this).size();
              int i3 = p.d(p.this).size();
              if (p.g(p.this) == null) {
                j = k;
              }
              for (;;)
              {
                ab.w("MicroMsg.NetSceneQueue", "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Boolean.valueOf(bool), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(j) });
                paramm.setOnSceneEnd(null);
                synchronized (p.h(p.this))
                {
                  p.c(p.this).remove(paramm);
                  if (paramm.isCanceled()) {
                    break;
                  }
                  p.i(p.this).post(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(58176);
                      p.this.onSceneEnd(3, -1, "doScene failed", p.5.this.ckS);
                      AppMethodBeat.o(58176);
                    }
                  });
                  AppMethodBeat.o(58177);
                  return;
                  j = p.g(p.this).hashCode();
                }
              }
              k = paramm.getType();
              m = paramm.hashCode();
              n = paramm.getMMReqRespHash();
              i1 = p.c(p.this).size();
              i2 = p.d(p.this).size();
              if (p.g(p.this) == null) {}
              for (i = 0;; i = p.g(p.this).hashCode())
              {
                ab.i("MicroMsg.NetSceneQueue", "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(j), Integer.valueOf(i) });
                paramm.setHasCallbackToQueue(false);
                AppMethodBeat.o(58177);
                return;
              }
            }
          }
          
          public final String toString()
          {
            AppMethodBeat.i(58178);
            String str = super.toString() + "|doSceneImp_" + paramm + "_type=" + paramm.getType();
            AppMethodBeat.o(58178);
            return str;
          }
        });
        if (this.ftA != null) {
          break;
        }
        adA();
        AppMethodBeat.o(58201);
        return;
        i = this.ftA.hashCode();
      }
      label307:
      if (paramInt > 0)
      {
        ??? = Message.obtain();
        ((Message)???).obj = paramm;
        this.handler.sendMessageDelayed((Message)???, paramInt);
        ab.i("MicroMsg.NetSceneQueue", "timed: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_after_sec=" + paramInt);
      }
      else
      {
        ab.i("MicroMsg.NetSceneQueue", "waited: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_waiting_cnt=" + this.ftD.size());
        synchronized (this.lock)
        {
          this.ftD.add(paramm);
          ab.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.ftD.size());
        }
      }
    }
    ftK = 1;
    AppMethodBeat.o(58201);
  }
  
  private boolean c(m paramm)
  {
    AppMethodBeat.i(58206);
    int i = paramm.getType();
    if (paramm.uniqueInNetsceneQueue()) {}
    synchronized (this.lock)
    {
      Iterator localIterator = this.ftC.iterator();
      m localm;
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if (localm.getType() == i)
        {
          ab.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_running_cnt=" + this.ftC.size());
          if (paramm.acceptConcurrent(localm))
          {
            AppMethodBeat.o(58206);
            return true;
          }
          if (paramm.accept(localm))
          {
            ab.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_running_cnt=" + this.ftC.size() + " ---" + localm.hashCode());
            if (!this.foreground)
            {
              ab.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + paramm.getType() + "acinfo[" + localm.getInfo() + "] scinfo[" + paramm.getInfo() + "]");
              ab.dsI();
              Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + paramm.getType(), false);
            }
            a(localm);
            AppMethodBeat.o(58206);
            return true;
          }
          AppMethodBeat.o(58206);
          return false;
        }
      }
      localIterator = this.ftD.iterator();
      while (localIterator.hasNext())
      {
        localm = (m)localIterator.next();
        if (localm.getType() == i)
        {
          ab.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_waiting_cnt=" + this.ftD.size());
          if (paramm.acceptConcurrent(localm))
          {
            AppMethodBeat.o(58206);
            return true;
          }
          if (paramm.accept(localm))
          {
            ab.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + paramm.getType() + " id=" + paramm.hashCode() + " cur_waiting_cnt=" + this.ftD.size() + " ---" + localm.hashCode());
            if (!this.foreground)
            {
              ab.dsI();
              Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + paramm.getType(), false);
            }
            a(localm);
            AppMethodBeat.o(58206);
            return true;
          }
          AppMethodBeat.o(58206);
          return false;
        }
      }
      AppMethodBeat.o(58206);
      return true;
    }
  }
  
  private void cP(boolean paramBoolean)
  {
    AppMethodBeat.i(58183);
    this.foreground = paramBoolean;
    this.ftF = Boolean.valueOf(paramBoolean);
    b.cP(paramBoolean);
    com.tencent.mm.hardcoder.WXHardCoderJNI.foreground = paramBoolean;
    if (this.ftA == null)
    {
      ab.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
      AppMethodBeat.o(58183);
      return;
    }
    this.ftA.cQ(paramBoolean);
    AppMethodBeat.o(58183);
  }
  
  public final e Rg()
  {
    return this.ftA;
  }
  
  public final void a(int paramInt, f paramf)
  {
    AppMethodBeat.i(58190);
    synchronized (this.ftE)
    {
      if (!this.ftE.containsKey(Integer.valueOf(paramInt))) {
        this.ftE.put(Integer.valueOf(paramInt), new HashSet());
      }
      if (!((Set)this.ftE.get(Integer.valueOf(paramInt))).contains(paramf)) {}
      synchronized ((Set)this.ftE.get(Integer.valueOf(paramInt)))
      {
        if (???.add(paramf)) {
          ListenerInstanceMonitor.ct(paramf);
        }
        AppMethodBeat.o(58190);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(58182);
    if (this.ftA == null)
    {
      ab.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
      AppMethodBeat.o(58182);
      return;
    }
    this.ftA.a(paramInt1, paramString, paramInt2, paramBoolean);
    AppMethodBeat.o(58182);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(58198);
    if (paramm == null)
    {
      AppMethodBeat.o(58198);
      return;
    }
    ab.b("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramm.hashCode()) });
    paramm.cancel();
    synchronized (this.lock)
    {
      this.ftD.remove(paramm);
      this.ftC.remove(paramm);
      AppMethodBeat.o(58198);
      return;
    }
  }
  
  public final boolean a(m paramm, int paramInt)
  {
    AppMethodBeat.i(58200);
    if ((paramm != null) || (paramInt >= 0))
    {
      bool = true;
      Assert.assertTrue(bool);
      if (this.ftB == null) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("worker thread has not been set", bool);
      if (c(paramm)) {
        break label62;
      }
      AppMethodBeat.o(58200);
      return false;
      bool = false;
      break;
    }
    label62:
    b(paramm, paramInt);
    AppMethodBeat.o(58200);
    return true;
  }
  
  public final int adt()
  {
    AppMethodBeat.i(58184);
    try
    {
      if ((this.ftA != null) && (this.ftA.adJ() != null))
      {
        int i = this.ftA.adJ().anj();
        AppMethodBeat.o(58184);
        return i;
      }
      ab.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneQueue", "exception:%s", new Object[] { bo.l(localException) });
      }
      AppMethodBeat.o(58184);
    }
    if (at.isConnected(ah.getContext()))
    {
      AppMethodBeat.o(58184);
      return 6;
    }
    return 0;
  }
  
  public final boolean adu()
  {
    AppMethodBeat.i(58185);
    if (this.ftA != null)
    {
      boolean bool = this.ftA.adu();
      AppMethodBeat.o(58185);
      return bool;
    }
    AppMethodBeat.o(58185);
    return true;
  }
  
  public final void adw()
  {
    AppMethodBeat.i(58194);
    Vector localVector = this.ftC;
    this.ftC = new Vector();
    Iterator localIterator = localVector.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      ab.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + localm.getType());
      localm.cancel();
      b(3, -1, "doScene failed clearRunningQueue", localm);
    }
    localVector.clear();
    AppMethodBeat.o(58194);
  }
  
  public final void adx()
  {
    AppMethodBeat.i(58195);
    ab.i("MicroMsg.NetSceneQueue", "resetDispatcher");
    if (this.ftA != null)
    {
      this.ftA.reset();
      this.ftA = null;
    }
    AppMethodBeat.o(58195);
  }
  
  public final void b(int paramInt, f paramf)
  {
    AppMethodBeat.i(58191);
    synchronized (this.ftE)
    {
      for (;;)
      {
        try
        {
          localSet = (Set)this.ftE.get(Integer.valueOf(paramInt));
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
            ListenerInstanceMonitor.cu(paramf);
          }
          return;
        }
        finally
        {
          AppMethodBeat.o(58191);
        }
      }
    }
  }
  
  public final boolean b(m paramm)
  {
    AppMethodBeat.i(156840);
    boolean bool = a(paramm, 0);
    AppMethodBeat.o(156840);
    return bool;
  }
  
  public final void c(e parame)
  {
    AppMethodBeat.i(58188);
    this.ftA = parame;
    parame.cQ(this.foreground);
    ady();
    AppMethodBeat.o(58188);
  }
  
  public final void cO(boolean paramBoolean)
  {
    AppMethodBeat.i(58181);
    this.ftI = paramBoolean;
    if (!this.ftI)
    {
      this.ftJ.stopTimer();
      AppMethodBeat.o(58181);
      return;
    }
    ab.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
    ap localap = this.ftJ;
    long l = this.ftH;
    localap.ag(l, l);
    AppMethodBeat.o(58181);
  }
  
  public final void cancel(final int paramInt)
  {
    AppMethodBeat.i(58196);
    ab.b("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.ftB.ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(58172);
        p.a(p.this, paramInt);
        AppMethodBeat.o(58172);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(58173);
        String str = super.toString() + "|cancelImp_" + paramInt;
        AppMethodBeat.o(58173);
        return str;
      }
    });
    AppMethodBeat.o(58196);
  }
  
  public final String getNetworkServerIp()
  {
    AppMethodBeat.i(58186);
    if (this.ftA != null)
    {
      String str = this.ftA.getNetworkServerIp();
      AppMethodBeat.o(58186);
      return str;
    }
    AppMethodBeat.o(58186);
    return "unknown";
  }
  
  public final void kW(final int paramInt)
  {
    AppMethodBeat.i(58197);
    ab.b("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", new Object[] { Integer.valueOf(paramInt) });
    this.ftB.ac(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(58174);
        p.b(p.this, paramInt);
        AppMethodBeat.o(58174);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(58175);
        String str = super.toString() + "|cancelImp_" + paramInt;
        AppMethodBeat.o(58175);
        return str;
      }
    });
    AppMethodBeat.o(58197);
  }
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(146119);
    ab.i("MicroMsg.NetSceneQueue", "onAppBackground");
    cP(false);
    AppMethodBeat.o(146119);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(146118);
    ab.i("MicroMsg.NetSceneQueue", "onAppForeground");
    cP(true);
    cO(false);
    AppMethodBeat.o(146118);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(58202);
    paramm.setHasCallbackToQueue(true);
    for (;;)
    {
      synchronized (this.lock)
      {
        this.ftC.remove(paramm);
        int j = paramm.getType();
        int k = paramm.hashCode();
        int m = paramm.getMMReqRespHash();
        int n = this.ftC.size();
        int i1 = this.ftD.size();
        if (this.ftA == null)
        {
          ab.i("MicroMsg.NetSceneQueue", "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
          ady();
          b(paramInt1, paramInt2, paramString, paramm);
          if ((this.ftI) && (this.ftC.isEmpty()) && (this.ftD.isEmpty()))
          {
            paramString = this.ftJ;
            long l = this.ftH;
            paramString.ag(l, l);
          }
          AppMethodBeat.o(58202);
          return;
        }
      }
      i = this.ftA.hashCode();
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(58192);
    ab.i("MicroMsg.NetSceneQueue", "reset");
    if (this.ftA != null) {
      this.ftA.reset();
    }
    adw();
    adv();
    AppMethodBeat.o(58192);
  }
  
  public static abstract interface a
  {
    public abstract void a(p paramp);
    
    public abstract void a(p paramp, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ai.p
 * JD-Core Version:    0.7.0.1
 */