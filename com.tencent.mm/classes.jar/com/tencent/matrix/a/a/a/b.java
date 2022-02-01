package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.a.b.l;
import com.tencent.matrix.a.b.l.d;
import com.tencent.matrix.a.b.o;
import com.tencent.matrix.a.b.o.a;
import com.tencent.matrix.a.b.o.a.a;
import com.tencent.matrix.a.b.o.c;
import com.tencent.matrix.a.b.o.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b
  extends a
{
  protected d eOv;
  public h eOx;
  protected final List<m.a.a<a>> ePR = new ArrayList();
  protected final Map<Integer, a> ePS = new ConcurrentHashMap();
  protected final Map<String, Pair<? extends List<Integer>, Long>> ePT = new ConcurrentHashMap();
  protected final SparseArray<List<o.a>> ePU = new SparseArray();
  protected o.a ePV;
  protected int ePW = 200;
  protected int ePX = 50;
  protected Runnable ePY = new Runnable()
  {
    public final void run()
    {
      b.this.awO();
    }
  };
  
  private void awN()
  {
    this.eNY.mHandler.removeCallbacks(this.ePY);
    this.eNY.mHandler.postDelayed(this.ePY, 1000L);
  }
  
  public void P(String paramString, int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    a locala;
    do
    {
      return;
      locala = R(paramString, Process.myTid());
    } while (locala == null);
    this.ePS.put(Integer.valueOf(paramInt), locala);
    a(Process.myTid(), paramString, ((Long)locala.eQc.eSn).longValue());
  }
  
  public void Q(String paramString, int paramInt)
  {
    a locala = (a)this.ePS.remove(Integer.valueOf(paramInt));
    if ((Looper.myLooper() != Looper.getMainLooper()) && (locala != null))
    {
      paramString = R(paramString, Process.myTid());
      if (paramString != null)
      {
        paramString.isFinished = true;
        a(locala, paramString);
      }
      paramInt = Process.myTid();
      if (paramString != null) {
        break label85;
      }
    }
    label85:
    for (paramString = (Long)locala.eQc.eSn;; paramString = (Long)paramString.eQc.eSn)
    {
      a(paramInt, "thread_pool@idle", paramString.longValue());
      return;
    }
  }
  
  protected final a R(String paramString, int paramInt)
  {
    a locala = new a();
    locala.tid = paramInt;
    locala.name = paramString;
    locala.eQd = com.tencent.matrix.a.b.b.k(com.tencent.matrix.a.a.d.getContext(), this.eNY.ePI);
    locala.eQe = com.tencent.matrix.a.b.b.bW(com.tencent.matrix.a.a.d.getContext());
    for (;;)
    {
      try
      {
        localObject = this.eNY.ePD.ePc;
        if (localObject != null) {
          continue;
        }
        localObject = "";
        locala.scene = ((String)localObject);
      }
      catch (Exception localException)
      {
        Object localObject;
        locala.scene = "";
        continue;
        l.d locald = l.dm(Process.myPid(), paramInt);
        if (locald != null) {
          continue;
        }
        com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "parse task procStat fail, name = " + paramString + ", tid = " + paramInt, new Object[0]);
        return null;
        locala.eQc = m.a.c.b.c(Long.valueOf(locald.axC()));
      }
      if (!this.eNY.ePD.ePv) {
        continue;
      }
      locala.eQc = m.a.c.b.c(Long.valueOf(SystemClock.currentThreadTimeMillis() / 10L));
      return locala;
      localObject = (String)((Callable)localObject).call();
    }
    return locala;
  }
  
  protected void a(int paramInt, String paramString, long paramLong)
  {
    synchronized (this.ePU)
    {
      List localList = (List)this.ePU.get(paramInt);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        ((List)localObject).add(0, this.ePV);
        this.ePU.put(paramInt, localObject);
      }
      ((List)localObject).add(0, new o.a(paramString, paramLong));
      awN();
      return;
    }
  }
  
  protected final void a(a parama1, a parama2)
  {
    if (parama2.tid != parama1.tid) {
      com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "task tid mismatch: " + parama1 + " vs " + parama2, new Object[0]);
    }
    do
    {
      return;
      if (!parama2.name.equals(parama1.name))
      {
        com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "task name mismatch: " + parama1 + " vs " + parama2, new Object[0]);
        return;
      }
      parama2 = parama2.a(parama1);
    } while (!b(parama2));
    com.tencent.matrix.e.c.i("Matrix.battery.AbsTaskMonitorFeature", "onTaskReport: %s, jiffies = %s, millis = %s", new Object[] { ((a)parama2.eSh).name, ((a)parama2.eSh).eQc.eSn, Long.valueOf(parama2.eSi) });
    d.b localb;
    o.c.a locala;
    if (this.eOv != null)
    {
      localb = this.eOv.dF(parama2.eSi);
      if (!localb.eSe)
      {
        ((a)parama2.eSg).eSe = false;
        ((a)parama2.eSh).eSe = false;
      }
      parama1 = ((a)parama2.eSh).scene;
      locala = this.eOv.dG(parama2.eSi).axE();
      if (locala == null) {
        break label436;
      }
      parama1 = locala.key;
    }
    label436:
    for (long l = locala.ratio;; l = 100L)
    {
      ((a)parama2.eSh).eQf = ((Long)localb.eQJ.eSn).longValue();
      ((a)parama2.eSh).scene = parama1;
      ((a)parama2.eSh).eQh = l;
      if (this.eOx != null)
      {
        parama1 = this.eOx.dH(parama2.eSi);
        if (!parama1.eSe)
        {
          ((a)parama2.eSg).eSe = false;
          ((a)parama2.eSh).eSe = false;
        }
        ((a)parama2.eSh).eQg = ((Long)parama1.eRy.eSn).longValue();
      }
      c(parama2);
      if (this.ePR.size() < this.ePW) {
        break;
      }
      com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "task list overheat, size = " + this.ePR.size(), new Object[0]);
      awN();
      return;
    }
  }
  
  public void awI()
  {
    super.awI();
  }
  
  public void awJ()
  {
    super.awJ();
    this.ePS.clear();
    synchronized (this.ePT)
    {
      this.ePT.clear();
      synchronized (this.ePR)
      {
        this.ePR.clear();
      }
    }
    synchronized (this.ePU)
    {
      this.ePU.clear();
      return;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  public final List<m.a.a<a>> awL()
  {
    synchronized (this.ePR)
    {
      ArrayList localArrayList = new ArrayList(this.ePR);
      Collections.sort(localArrayList, new Comparator() {});
      return localArrayList;
    }
  }
  
  public final void awM()
  {
    synchronized (this.ePR)
    {
      this.ePR.clear();
      return;
    }
  }
  
  protected final void awO()
  {
    Object localObject1 = this.ePU;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.ePU.size())
        {
          List localList = (List)this.ePU.valueAt(i);
          if ((localList != null) && (localList.size() > this.ePW)) {
            o.bg(localList);
          }
        }
        else
        {
          if (this.ePR.size() > this.ePW)
          {
            com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "cooling task jiffies list, before = " + this.ePR.size(), new Object[0]);
            localObject1 = awL();
            awM();
            com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "cooling task jiffies list, after = " + this.ePR.size(), new Object[0]);
            com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "report task jiffies list overheat", new Object[0]);
            be((List)localObject1);
          }
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  protected boolean b(m.a.a<a> parama)
  {
    return (parama.eSi > 1000L) && (((Long)((a)parama.eSh).eQc.eSn).longValue() / Math.max(1L, parama.eSi / 60000L) > 100L);
  }
  
  protected void be(List<m.a.a<a>> paramList) {}
  
  protected void c(m.a.a<a> parama)
  {
    synchronized (this.ePR)
    {
      Iterator localIterator = this.ePR.iterator();
      while (localIterator.hasNext())
      {
        m.a.a locala = (m.a.a)localIterator.next();
        if ((((a)locala.eSh).name.equals(((a)parama.eSh).name)) && (((a)locala.eSh).tid == ((a)parama.eSh).tid) && (!((a)locala.eSh).isFinished)) {
          localIterator.remove();
        }
      }
    }
    this.ePR.add(parama);
  }
  
  public void g(com.tencent.matrix.a.a.d paramd)
  {
    super.g(paramd);
    this.eOv = ((d)paramd.aj(d.class));
    this.eOx = ((h)paramd.aj(h.class));
    this.ePV = new o.a("thread_pool@idle", 0L);
    this.ePW = Math.max(paramd.ePD.ePi, this.ePW);
  }
  
  protected String getTag()
  {
    return "Matrix.battery.AbsTaskMonitorFeature";
  }
  
  public o.c h(int paramInt, long paramLong1, final long paramLong2)
  {
    SparseArray localSparseArray = this.ePU;
    if (paramLong1 >= 0L) {}
    try
    {
      if (this.ePU.get(paramInt) == null)
      {
        localc = o.c.axD();
        return localc;
      }
      o.c localc = o.a((List)this.ePU.get(paramInt), paramLong1, new o.a.a()
      {
        public final o.a gr(String paramAnonymousString)
        {
          return new o.a(paramAnonymousString, paramLong2);
        }
      });
      return localc;
    }
    finally {}
  }
  
  public final ArrayList<o.a> mT(int paramInt)
  {
    synchronized (this.ePU)
    {
      Object localObject1 = (List)this.ePU.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = new ArrayList((Collection)localObject1);
        return localObject1;
      }
      return null;
    }
  }
  
  protected void mU(int paramInt)
  {
    this.ePS.remove(Integer.valueOf(paramInt));
  }
  
  public static class a
    extends m.a<a>
  {
    public long eQb = System.currentTimeMillis();
    public m.a.c.b<Long> eQc;
    public int eQd;
    public int eQe;
    public long eQf = 100L;
    public long eQg = 100L;
    public long eQh = 100L;
    public boolean isFinished = false;
    public String name;
    public String scene;
    public int tid;
    
    public final m.a.a<a> a(a parama)
    {
      new m.a.a(parama, this) {};
    }
    
    public String toString()
    {
      return "TaskJiffiesSnapshot{appStat=" + this.eQd + ", devStat=" + this.eQe + ", tid=" + this.tid + ", name='" + this.name + '\'' + ", jiffies=" + this.eQc + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */