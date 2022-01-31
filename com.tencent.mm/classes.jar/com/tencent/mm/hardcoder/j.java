package com.tencent.mm.hardcoder;

import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public final class j
  implements Runnable
{
  private boolean dEI;
  Queue<d.b> dFi;
  private b dFj;
  private Deque<b> dFk;
  private Thread thread;
  
  protected final void finalize()
  {
    super.finalize();
    this.dFi = null;
    this.dFj = null;
    this.dFk = null;
  }
  
  public final void run()
  {
    for (;;)
    {
      if (!Thread.currentThread().isInterrupted()) {}
      try
      {
        if (this.dFi.isEmpty()) {
          break label389;
        }
        localObject3 = (d.b)this.dFi.poll();
        if (localObject3 == null) {
          continue;
        }
        l = ((d.b)localObject3).time;
        localObject1 = ((d.b)localObject3).dEY;
        localObject3 = ((d.b)localObject3).dEZ;
        if (this.dFj != null) {
          break label217;
        }
        this.dFj = new b(l, (Map)localObject1, (Map)localObject3);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Object localObject3;
          long l;
          Object localObject1;
          c.e("HardCoder.HardCoderStatThread", "Stat thread need to interrupt:" + localInterruptedException.getMessage());
          Thread.currentThread().interrupt();
          return;
          b localb = this.dFj;
          int[] arrayOfInt = b.g(localInterruptedException);
          localb.updateTime = l;
          localb.dEC.p(((d.a)localInterruptedException.get(Integer.valueOf(arrayOfInt[0]))).dEW, ((d.a)localInterruptedException.get(Integer.valueOf(arrayOfInt[0]))).dEX);
          if (localb.dED != null) {
            localb.dED.p(((d.a)localInterruptedException.get(Integer.valueOf(arrayOfInt[1]))).dEW, ((d.a)localInterruptedException.get(Integer.valueOf(arrayOfInt[1]))).dEX);
          }
          localb.h((Map)localObject3);
        }
      }
      catch (Exception localException)
      {
        c.e("HardCoder.HardCoderStatThread", "exception:" + localException.getMessage());
      }
      c.i("HardCoder.HardCoderStatThread", this.dFj.toString());
      localObject1 = new b(l, (Map)localObject1, (Map)localObject3);
      localObject3 = (b)this.dFk.peekFirst();
      localb = (b)this.dFk.peekLast();
      if ((localObject3 != null) && (localb != null))
      {
        if (localb.startTime - ((b)localObject3).startTime >= 30000L) {
          this.dFk.removeFirst();
        }
        this.dFk.add(localObject1);
        continue;
        label217:
        continue;
      }
      this.dFk.add(localException);
      continue;
      try
      {
        label389:
        if (this.dEI)
        {
          c.i("HardCoder.HardCoderStatThread", "snapshotStatDeque size:" + this.dFk.size());
          if (this.thread != null)
          {
            this.thread.interrupt();
            this.thread = null;
            this.dEI = false;
          }
        }
        wait();
      }
      finally {}
    }
  }
  
  public static final class a
  {
    public final long dFl;
    public final long dFm;
    public long dFn = 0L;
    public long dFo = 0L;
    
    public a(long paramLong1, long paramLong2)
    {
      this.dFl = paramLong1;
      this.dFm = paramLong2;
      this.dFn = this.dFl;
      this.dFo = this.dFm;
    }
    
    public final void p(long paramLong1, long paramLong2)
    {
      this.dFn = ((this.dFn + paramLong1) / 2L);
      this.dFo = ((this.dFo + paramLong2) / 2L);
    }
    
    public final String toString()
    {
      return String.format("startFreq:%s,startPower:%s,averageFreq:%s,averagePower:%s", new Object[] { Long.valueOf(this.dFl), Long.valueOf(this.dFm), Long.valueOf(this.dFn), Long.valueOf(this.dFo) });
    }
  }
  
  public static final class b
  {
    public final j.a dEC;
    public final j.a dED;
    public final Map<Integer, d.a> dEY;
    public final Map<Integer, d.c> dFp = new TreeMap();
    public final long startTime;
    public long updateTime = 0L;
    
    public b(long paramLong, Map<Integer, d.a> paramMap, Map<Integer, d.c> paramMap1)
    {
      int[] arrayOfInt = g(paramMap);
      this.dEY = paramMap;
      this.dEC = new j.a(((d.a)paramMap.get(Integer.valueOf(arrayOfInt[0]))).dEW, ((d.a)paramMap.get(Integer.valueOf(arrayOfInt[0]))).dEX);
      if (arrayOfInt[1] < 0) {
        c.e("HardCoder.HardCoderStatThread", "cluster one is unused?may be possible.");
      }
      for (this.dED = null;; this.dED = new j.a(((d.a)paramMap.get(Integer.valueOf(arrayOfInt[1]))).dEW, ((d.a)paramMap.get(Integer.valueOf(arrayOfInt[1]))).dEX))
      {
        this.startTime = paramLong;
        this.updateTime = this.startTime;
        h(paramMap1);
        return;
      }
    }
    
    public static int[] g(Map<Integer, d.a> paramMap)
    {
      if (paramMap == null) {
        throw new NullPointerException("cpuStatusMap can not be null");
      }
      int i = l.dFs;
      if (i >= 0) {
        if (!paramMap.containsKey(Integer.valueOf(i))) {}
      }
      for (int j = i;; j = -1)
      {
        if (j < 0)
        {
          throw new NullPointerException("cluster zero is unused?impossible.");
          i -= 1;
          break;
        }
        i = l.dFt;
        if (i > l.dFs) {
          if (!paramMap.containsKey(Integer.valueOf(i))) {}
        }
        for (;;)
        {
          return new int[] { j, i };
          i -= 1;
          break;
          i = -1;
        }
      }
    }
    
    final void h(Map<Integer, d.c> paramMap)
    {
      if (paramMap == null) {
        throw new NullPointerException("threadStatusMap can not be null");
      }
      Iterator localIterator = paramMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        Object localObject = (d.c)paramMap.get(localInteger);
        d.c localc;
        if (this.dFp.containsKey(localInteger)) {
          localc = (d.c)this.dFp.get(localInteger);
        }
        for (;;)
        {
          long l = ((d.c)localObject).dFc;
          localObject = ((d.c)localObject).dEx;
          localc.dEz = ((l + localc.dEz) / 2L);
          if (localObject == null) {
            break;
          }
          localc.dFd = (localObject[0] - localc.dEx[0] + (localObject[1] - localc.dEx[1]));
          if (!HardCoderJNI.hcDebug) {
            break;
          }
          c.d("HardCoder.Monitor", "thread id:" + localc.dFa + ",start jiffies:[" + localc.dEx[0] + "," + localc.dEx[1] + "], end jiffies:[" + localObject[0] + "," + localObject[1] + "]");
          break;
          localc = new d.c(((d.c)localObject).dFa, ((d.c)localObject).startTime, ((d.c)localObject).dFb, ((d.c)localObject).dFc, ((d.c)localObject).dEx);
          this.dFp.put(localInteger, localc);
        }
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("startTime:%s,updateTime:%s", new Object[] { Long.valueOf(this.startTime), Long.valueOf(this.updateTime) }));
      localStringBuilder.append(",");
      localStringBuilder.append(this.dEC);
      if (this.dED != null)
      {
        localStringBuilder.append(",");
        localStringBuilder.append(this.dED);
      }
      localStringBuilder.append(",");
      localStringBuilder.append(this.dFp.toString());
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.j
 * JD-Core Version:    0.7.0.1
 */