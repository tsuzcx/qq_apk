package com.tencent.matrix.a.a.a;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.matrix.a.b.h;
import com.tencent.matrix.a.b.h.c;
import com.tencent.matrix.a.b.k;
import com.tencent.matrix.a.b.k.a;
import com.tencent.matrix.a.b.k.a.a;
import com.tencent.matrix.a.b.k.c;
import com.tencent.matrix.a.b.k.c.a;
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
  protected d cTg;
  public f cTi;
  protected final List<j.a.a<a>> cUr = new ArrayList();
  protected final Map<Integer, a> cUs = new ConcurrentHashMap();
  protected final Map<String, Pair<? extends List<Integer>, Long>> cUt = new ConcurrentHashMap();
  protected final SparseArray<List<k.a>> cUu = new SparseArray();
  protected k.a cUv;
  protected int cUw = 200;
  protected int cUx = 50;
  protected Runnable cUy = new Runnable()
  {
    @SuppressLint({"RestrictedApi"})
    public final void run()
    {
      b.this.Wf();
    }
  };
  
  private void We()
  {
    this.cSI.mHandler.removeCallbacks(this.cUy);
    this.cSI.mHandler.postDelayed(this.cUy, 1000L);
  }
  
  protected void G(List<j.a.a<a>> paramList) {}
  
  public void H(String paramString, int paramInt)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    a locala;
    do
    {
      return;
      locala = J(paramString, Process.myTid());
    } while (locala == null);
    this.cUs.put(Integer.valueOf(paramInt), locala);
    b(Process.myTid(), paramString, ((Long)locala.cUC.cWu).longValue());
  }
  
  public void I(String paramString, int paramInt)
  {
    a locala = (a)this.cUs.remove(Integer.valueOf(paramInt));
    if ((Looper.myLooper() != Looper.getMainLooper()) && (locala != null))
    {
      paramString = J(paramString, Process.myTid());
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
    for (paramString = (Long)locala.cUC.cWu;; paramString = (Long)paramString.cUC.cWu)
    {
      b(paramInt, "thread_pool@idle", paramString.longValue());
      return;
    }
  }
  
  protected final a J(String paramString, int paramInt)
  {
    a locala = new a();
    locala.tid = paramInt;
    locala.name = paramString;
    locala.cUD = com.tencent.matrix.a.b.b.k(com.tencent.matrix.a.a.d.getContext(), this.cSI.cUh);
    locala.cUE = com.tencent.matrix.a.b.b.bl(com.tencent.matrix.a.a.d.getContext());
    for (;;)
    {
      try
      {
        localObject = this.cSI.cUb.cTA;
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
        h.c localc = h.cy(Process.myPid(), paramInt);
        if (localc != null) {
          continue;
        }
        com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "parse task procStat fail, name = " + paramString + ", tid = " + paramInt, new Object[0]);
        return null;
        locala.cUC = j.a.c.b.c(Long.valueOf(localc.WF()));
      }
      if (!this.cSI.cUb.cTT) {
        continue;
      }
      locala.cUC = j.a.c.b.c(Long.valueOf(SystemClock.currentThreadTimeMillis() / 10L));
      return locala;
      localObject = (String)((Callable)localObject).call();
    }
    return locala;
  }
  
  public void VZ()
  {
    super.VZ();
  }
  
  public void Wa()
  {
    super.Wa();
    this.cUs.clear();
    synchronized (this.cUt)
    {
      this.cUt.clear();
      synchronized (this.cUr)
      {
        this.cUr.clear();
      }
    }
    synchronized (this.cUu)
    {
      this.cUu.clear();
      return;
      localObject2 = finally;
      throw localObject2;
      localObject3 = finally;
      throw localObject3;
    }
  }
  
  public final List<j.a.a<a>> Wc()
  {
    synchronized (this.cUr)
    {
      ArrayList localArrayList = new ArrayList(this.cUr);
      Collections.sort(localArrayList, new Comparator() {});
      return localArrayList;
    }
  }
  
  public final void Wd()
  {
    synchronized (this.cUr)
    {
      this.cUr.clear();
      return;
    }
  }
  
  protected final void Wf()
  {
    Object localObject1 = this.cUu;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.cUu.size())
        {
          List localList = (List)this.cUu.valueAt(i);
          if ((localList != null) && (localList.size() > this.cUw)) {
            k.I(localList);
          }
        }
        else
        {
          if (this.cUr.size() > this.cUw)
          {
            com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "cooling task jiffies list, before = " + this.cUr.size(), new Object[0]);
            localObject1 = Wc();
            Wd();
            com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "cooling task jiffies list, after = " + this.cUr.size(), new Object[0]);
            com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "report task jiffies list overheat", new Object[0]);
            G((List)localObject1);
          }
          return;
        }
      }
      finally {}
      i += 1;
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
    } while (!i(parama2));
    com.tencent.matrix.e.c.i("Matrix.battery.AbsTaskMonitorFeature", "onTaskReport: %s, jiffies = %s, millis = %s", new Object[] { ((a)parama2.cWo).name, ((a)parama2.cWo).cUC.cWu, Long.valueOf(parama2.cWp) });
    d.b localb;
    k.c.a locala;
    if (this.cTg != null)
    {
      localb = this.cTg.bn(parama2.cWp);
      if (!localb.cWl)
      {
        ((a)parama2.cWn).cWl = false;
        ((a)parama2.cWo).cWl = false;
      }
      parama1 = ((a)parama2.cWo).scene;
      locala = this.cTg.bo(parama2.cWp).WH();
      if (locala == null) {
        break label436;
      }
      parama1 = locala.key;
    }
    label436:
    for (long l = locala.ratio;; l = 100L)
    {
      ((a)parama2.cWo).cUF = ((Long)localb.cVj.cWu).longValue();
      ((a)parama2.cWo).scene = parama1;
      ((a)parama2.cWo).cUH = l;
      if (this.cTi != null)
      {
        parama1 = this.cTi.bp(parama2.cWp);
        if (!parama1.cWl)
        {
          ((a)parama2.cWn).cWl = false;
          ((a)parama2.cWo).cWl = false;
        }
        ((a)parama2.cWo).cUG = ((Long)parama1.cVH.cWu).longValue();
      }
      j(parama2);
      if (this.cUr.size() < this.cUw) {
        break;
      }
      com.tencent.matrix.e.c.w("Matrix.battery.AbsTaskMonitorFeature", "task list overheat, size = " + this.cUr.size(), new Object[0]);
      We();
      return;
    }
  }
  
  protected void b(int paramInt, String paramString, long paramLong)
  {
    synchronized (this.cUu)
    {
      List localList = (List)this.cUu.get(paramInt);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        ((List)localObject).add(0, this.cUv);
        this.cUu.put(paramInt, localObject);
      }
      ((List)localObject).add(0, new k.a(paramString, paramLong));
      We();
      return;
    }
  }
  
  public void f(com.tencent.matrix.a.a.d paramd)
  {
    super.f(paramd);
    this.cTg = ((d)paramd.Z(d.class));
    this.cTi = ((f)paramd.Z(f.class));
    this.cUv = new k.a("thread_pool@idle", 0L);
    this.cUw = Math.max(paramd.cUb.cTG, this.cUw);
  }
  
  protected String getTag()
  {
    return "Matrix.battery.AbsTaskMonitorFeature";
  }
  
  @SuppressLint({"RestrictedApi"})
  public k.c h(int paramInt, long paramLong1, final long paramLong2)
  {
    SparseArray localSparseArray = this.cUu;
    if (paramLong1 >= 0L) {}
    try
    {
      if (this.cUu.get(paramInt) == null)
      {
        localc = k.c.WG();
        return localc;
      }
      k.c localc = k.a((List)this.cUu.get(paramInt), paramLong1, new k.a.a()
      {
        public final k.a eT(String paramAnonymousString)
        {
          return new k.a(paramAnonymousString, paramLong2);
        }
      });
      return localc;
    }
    finally {}
  }
  
  protected boolean i(j.a.a<a> parama)
  {
    return (parama.cWp > 1000L) && (((Long)((a)parama.cWo).cUC.cWu).longValue() / Math.max(1L, parama.cWp / 60000L) > 100L);
  }
  
  protected void j(j.a.a<a> parama)
  {
    synchronized (this.cUr)
    {
      Iterator localIterator = this.cUr.iterator();
      while (localIterator.hasNext())
      {
        j.a.a locala = (j.a.a)localIterator.next();
        if ((((a)locala.cWo).name.equals(((a)parama.cWo).name)) && (((a)locala.cWo).tid == ((a)parama.cWo).tid) && (!((a)locala.cWo).isFinished)) {
          localIterator.remove();
        }
      }
    }
    this.cUr.add(parama);
  }
  
  public final ArrayList<k.a> jr(int paramInt)
  {
    synchronized (this.cUu)
    {
      Object localObject1 = (List)this.cUu.get(paramInt);
      if (localObject1 != null)
      {
        localObject1 = new ArrayList((Collection)localObject1);
        return localObject1;
      }
      return null;
    }
  }
  
  protected void js(int paramInt)
  {
    this.cUs.remove(Integer.valueOf(paramInt));
  }
  
  public static final class a
    extends j.a<a>
  {
    public long cUB = System.currentTimeMillis();
    public j.a.c.b<Long> cUC;
    public int cUD;
    public int cUE;
    public long cUF = 100L;
    public long cUG = 100L;
    public long cUH = 100L;
    public boolean isFinished = false;
    public String name;
    public String scene;
    public int tid;
    
    public final j.a.a<a> a(a parama)
    {
      new j.a.a(parama, this) {};
    }
    
    public final String toString()
    {
      return "TaskJiffiesSnapshot{appStat=" + this.cUD + ", devStat=" + this.cUE + ", tid=" + this.tid + ", name='" + this.name + '\'' + ", jiffies=" + this.cUC + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */