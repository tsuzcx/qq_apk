package com.tencent.matrix.a.a.a;

import android.os.Handler;
import android.os.Process;
import com.tencent.matrix.a.a.d;
import com.tencent.matrix.a.b.e;
import com.tencent.matrix.a.b.f;
import com.tencent.matrix.a.b.j;
import com.tencent.matrix.e.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class g
  extends b
{
  public j eRi;
  
  private void axb()
  {
    int j = 0;
    if (this.eRi != null) {
      return;
    }
    try
    {
      if (this.eRi != null) {
        return;
      }
    }
    finally {}
    try
    {
      this.eRi = j.ce(d.getContext());
      int i = 0;
      while (i < this.eRi.axr())
      {
        new e(i, this.eRi.nf(this.eRi.nd(i))).axt();
        i += 1;
      }
      int[] arrayOfInt = new int[this.eRi.eTN.length];
      i = j;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = this.eRi.nf(i);
        i += 1;
      }
      new f(Process.myPid(), arrayOfInt).axt();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        c.w("Matrix.battery.CpuStatFeature", "Init cpuStat failed: " + localIOException.getMessage(), new Object[0]);
        this.eRi = null;
      }
    }
  }
  
  public final void awI()
  {
    super.awI();
    axb();
  }
  
  public final int awQ()
  {
    return 0;
  }
  
  public final a axc()
  {
    a locala = new a();
    try
    {
      if (!isSupported()) {
        throw new IOException("PowerProfile not supported");
      }
    }
    catch (Exception localException)
    {
      c.w("Matrix.battery.CpuStatFeature", "Read cpu core state fail: " + localException.getMessage(), new Object[0]);
      locala.eSe = false;
      return locala;
    }
    try
    {
      if (!isSupported()) {
        throw new IOException("PowerProfile not supported");
      }
    }
    finally {}
    locala.eRk = new ArrayList();
    int i = 0;
    while (i < this.eRi.axr())
    {
      localObject2 = m.a.c.c.b(new e(i, this.eRi.nf(this.eRi.nd(i))).axu());
      locala.eRk.add(localObject2);
      i += 1;
    }
    Object localObject2 = new int[this.eRi.eTN.length];
    i = 0;
    while (i < localObject2.length)
    {
      localObject2[i] = this.eRi.nf(i);
      i += 1;
    }
    localObject2 = new f(Process.myPid(), (int[])localObject2).axv();
    locala.eRl = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      m.a.c.c localc = m.a.c.c.b((long[])((Iterator)localObject2).next());
      locala.eRl.add(localc);
    }
    return locala;
  }
  
  protected final String getTag()
  {
    return "Matrix.battery.CpuStatFeature";
  }
  
  public final boolean isSupported()
  {
    return this.eRi != null;
  }
  
  public final void onForeground(boolean paramBoolean)
  {
    super.onForeground(paramBoolean);
    if ((!paramBoolean) && (this.eRi == null)) {
      this.eNY.mHandler.post(new Runnable()
      {
        public final void run()
        {
          g.a(g.this);
        }
      });
    }
  }
  
  public static final class a
    extends m.a<a>
  {
    public List<m.a.c.c<m.a.c.b<Long>>> eRk = Collections.emptyList();
    public List<m.a.c.c<m.a.c.b<Long>>> eRl = Collections.emptyList();
    
    public final double a(j paramj)
    {
      double d1 = 0.0D;
      double d2;
      if (!paramj.isSupported())
      {
        d2 = d1;
        return d2;
      }
      int i = 0;
      for (;;)
      {
        d2 = d1;
        if (i >= this.eRk.size()) {
          break;
        }
        List localList = ((m.a.c.c)this.eRk.get(i)).list;
        int j = 0;
        while (j < localList.size())
        {
          d2 = ((Long)((m.a.c.b)localList.get(j)).eSn).longValue();
          double d3 = paramj.dl(paramj.nd(i), j);
          d1 += d2 * 10.0D / 3600000.0D * d3;
          j += 1;
        }
        i += 1;
      }
    }
    
    public final double a(j paramj, long paramLong)
    {
      double d2;
      if (!paramj.isSupported())
      {
        d2 = 0.0D;
        return d2;
      }
      Object localObject = this.eRl.iterator();
      long l1 = 0L;
      if (((Iterator)localObject).hasNext())
      {
        Iterator localIterator = ((m.a.c.c)((Iterator)localObject).next()).list.iterator();
        for (long l2 = l1;; l2 += ((Long)((m.a.c.b)localIterator.next()).eSn).longValue())
        {
          l1 = l2;
          if (!localIterator.hasNext()) {
            break;
          }
        }
      }
      int i = 0;
      double d1 = 0.0D;
      for (;;)
      {
        d2 = d1;
        if (i >= this.eRl.size()) {
          break;
        }
        localObject = ((m.a.c.c)this.eRl.get(i)).list;
        int j = 0;
        while (j < ((List)localObject).size())
        {
          d2 = ((Long)((m.a.c.b)((List)localObject).get(j)).eSn).longValue() / l1;
          double d3 = paramLong;
          double d4 = paramj.dl(i, j);
          d1 += d2 * d3 * 10.0D / 3600000.0D * d4;
          j += 1;
        }
        i += 1;
      }
    }
    
    public final long axd()
    {
      Iterator localIterator1 = this.eRk.iterator();
      long l1 = 0L;
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((m.a.c.c)localIterator1.next()).list.iterator();
        for (long l2 = l1;; l2 += ((Long)((m.a.c.b)localIterator2.next()).eSn).longValue())
        {
          l1 = l2;
          if (!localIterator2.hasNext()) {
            break;
          }
        }
      }
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */