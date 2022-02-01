package com.tencent.matrix.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.b.a.d.d;
import com.tencent.matrix.a.b.a.g.a;
import com.tencent.matrix.a.b.a.g.a.a;
import com.tencent.matrix.a.b.a.g.a.c.b;
import com.tencent.matrix.a.c.e;
import com.tencent.matrix.a.c.e.a;
import com.tencent.matrix.a.c.h.b;
import com.tencent.matrix.report.a.a;
import com.tencent.matrix.report.a.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  extends com.tencent.matrix.a.b.a.a
{
  private Runnable cSK = new Runnable()
  {
    public final void run()
    {
      if (c.a(c.this).size() < c.b(c.this)) {}
      for (;;)
      {
        return;
        Log.w("Matrix.battery.ThreadPoolJiffies", "cooling thread pools jiffies, before = " + c.a(c.this).size());
        Object localObject = c.this.SJ();
        c.this.SK();
        Log.w("Matrix.battery.ThreadPoolJiffies", "cooling thread pools jiffies, after = " + c.a(c.this).size());
        Log.w("Matrix.battery.ThreadPoolJiffies", "report thread pools jiffies");
        if (c.c(c.this) != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            g.a.a locala = (g.a.a)((Iterator)localObject).next();
            c.c(c.this);
            com.tencent.matrix.b.b.e(locala);
          }
        }
      }
    }
  };
  private com.tencent.matrix.a.b.a.c cUL;
  private d cUM;
  private int cVg = 1024;
  private final List<g.a.a<b>> cVh = new ArrayList();
  final Map<Integer, b> cVi = new ConcurrentHashMap();
  private com.tencent.matrix.b.b cVj;
  private a cVk;
  
  private void a(b paramb1, b paramb2)
  {
    if (paramb2.tid != paramb1.tid)
    {
      Log.w("Matrix.battery.ThreadPoolJiffies", "task tid mismatch: " + paramb1 + " vs " + paramb2);
      return;
    }
    if (!paramb2.name.equals(paramb1.name))
    {
      Log.w("Matrix.battery.ThreadPoolJiffies", "task name mismatch: " + paramb1 + " vs " + paramb2);
      return;
    }
    Object localObject;
    synchronized (this.cVh)
    {
      paramb2 = paramb2.a(paramb1);
      paramb1 = this.cVh.iterator();
      while (paramb1.hasNext())
      {
        localObject = (g.a.a)paramb1.next();
        if ((((b)((g.a.a)localObject).cTt).name.equals(((b)paramb2.cTt).name)) && (((b)((g.a.a)localObject).cTt).tid == ((b)paramb2.cTt).tid) && (!((b)((g.a.a)localObject).cTt).isFinished)) {
          paramb1.remove();
        }
      }
    }
    long l;
    android.support.v4.e.k localk;
    if (this.cUL != null)
    {
      localObject = this.cUL.bb(paramb2.cTu);
      if (!((g.a)localObject).cTq)
      {
        ((b)paramb2.cTs).cTq = false;
        ((b)paramb2.cTt).cTq = false;
      }
      paramb1 = ((b)paramb2.cTt).scene;
      l = 100L;
      localk = this.cUL.bc(paramb2.cTu).Ss();
      if (localk == null) {
        break label534;
      }
      paramb1 = (String)localk.first;
      if (localk.second != null) {
        break label515;
      }
      l = 0L;
      break label537;
    }
    label515:
    label534:
    label537:
    for (;;)
    {
      ((b)paramb2.cTt).cVr = ((Long)((com.tencent.matrix.a.b.a.c.b)localObject).cSO.cTz).longValue();
      ((b)paramb2.cTt).scene = paramb1;
      ((b)paramb2.cTt).cVt = l;
      if (this.cUM != null)
      {
        paramb1 = this.cUM.bd(paramb2.cTu);
        if (!paramb1.cTq)
        {
          ((b)paramb2.cTs).cTq = false;
          ((b)paramb2.cTt).cTq = false;
        }
        ((b)paramb2.cTt).cVs = ((Long)paramb1.cTb.cTz).longValue();
      }
      this.cVh.add(paramb2);
      if (this.cVh.size() < this.cVg) {
        break;
      }
      Log.w("Matrix.battery.ThreadPoolJiffies", "thread pools jiffies overheat, size = " + this.cVh.size());
      this.cSq.mHandler.post(this.cSK);
      return;
      int i = ((Integer)localk.second).intValue();
      l = i;
      break label537;
    }
  }
  
  public final List<g.a.a<b>> SJ()
  {
    ??? = this.cVi.values().iterator();
    Object localObject2;
    while (((Iterator)???).hasNext())
    {
      localObject2 = (b)((Iterator)???).next();
      b localb = b.t(((b)localObject2).name, ((b)localObject2).tid);
      if (localb != null) {
        a((b)localObject2, localb);
      }
    }
    synchronized (this.cVh)
    {
      localObject2 = new ArrayList(this.cVh);
      Collections.sort((List)localObject2, new Comparator() {});
      return localObject2;
    }
  }
  
  public final void SK()
  {
    synchronized (this.cVh)
    {
      Iterator localIterator = this.cVh.iterator();
      while (localIterator.hasNext()) {
        if (((b)((g.a.a)localIterator.next()).cTt).isFinished) {
          localIterator.remove();
        }
      }
    }
  }
  
  public final void Se()
  {
    super.Se();
    com.tencent.f.c.b.RTE = new c.a.1(this.cVk);
  }
  
  public final void Sf()
  {
    super.Sf();
    this.cVi.clear();
    this.cVh.clear();
    com.tencent.f.c.b.RTE = this.cVk.cVm;
  }
  
  public final int Sg()
  {
    return 0;
  }
  
  protected final void b(String paramString, Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    b localb;
    do
    {
      do
      {
        return;
        localb = (b)this.cVi.get(Integer.valueOf(paramRunnable.hashCode()));
      } while (localb == null);
      this.cVi.remove(Integer.valueOf(paramRunnable.hashCode()));
      paramString = b.t(paramString, Process.myTid());
    } while (paramString == null);
    paramString.isFinished = true;
    a(localb, paramString);
  }
  
  public final void d(com.tencent.matrix.a.b.c paramc)
  {
    super.d(paramc);
    this.cVk = new a(com.tencent.f.c.b.RTE, (byte)0);
    this.cUL = ((com.tencent.matrix.a.b.a.c)paramc.aa(com.tencent.matrix.a.b.a.c.class));
    this.cUM = ((d)paramc.aa(d.class));
    com.tencent.matrix.a.b.a locala = paramc.cSe.cRJ;
    if ((locala instanceof com.tencent.matrix.b.b)) {
      this.cVj = ((com.tencent.matrix.b.b)locala);
    }
    this.cVg = Math.max(paramc.cSe.cRQ, this.cVg);
  }
  
  final class a
  {
    final com.tencent.f.b.c cVm;
    
    private a(com.tencent.f.b.c paramc)
    {
      this.cVm = paramc;
    }
  }
  
  public static final class b
    extends g.a<b>
  {
    public g.a.c.b<Long> cVo;
    public int cVp;
    public int cVq;
    public long cVr = 100L;
    public long cVs = 100L;
    public long cVt = 100L;
    public boolean isFinished = false;
    public String name;
    public String scene;
    public int tid;
    
    static b t(String paramString, int paramInt)
    {
      b localb = new b();
      localb.tid = paramInt;
      localb.name = paramString;
      localb.cVp = com.tencent.matrix.report.a.SP();
      localb.cVq = com.tencent.matrix.report.a.SQ();
      localb.scene = com.tencent.matrix.report.a.SO();
      if (a.SF())
      {
        localb.cVo = g.a.c.b.b(Long.valueOf(SystemClock.currentThreadTimeMillis() / 10L));
        return localb;
      }
      int i = Process.myPid();
      e.a locala = e.cf(i, paramInt);
      if (locala == null)
      {
        Log.w("Matrix.battery.ThreadPoolJiffies", "parse task procStat fail, name = " + paramString + ", tid = " + paramInt);
        a.a.SR();
        a.b.b.c(i, paramInt, paramString);
        return null;
      }
      localb.cVo = g.a.c.b.b(Long.valueOf(locala.Sr()));
      return localb;
    }
    
    public final g.a.a<b> a(b paramb)
    {
      new g.a.a(paramb, this) {};
    }
    
    public final String toString()
    {
      return "TaskJiffiesSnapshot{appStat=" + this.cVp + ", devStat=" + this.cVq + ", tid=" + this.tid + ", name='" + this.name + '\'' + ", jiffies=" + this.cVo + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.c.c
 * JD-Core Version:    0.7.0.1
 */