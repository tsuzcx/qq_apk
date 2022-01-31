package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public final class f
  implements Runnable
{
  private Queue<d.b> eCH;
  private b eCI;
  private Deque<b> eCJ;
  private boolean eCj;
  private Thread thread;
  
  public final void a(d.b paramb)
  {
    AppMethodBeat.i(93940);
    if (this.eCH != null) {
      try
      {
        this.eCH.add(paramb);
        notify();
        return;
      }
      finally
      {
        AppMethodBeat.o(93940);
      }
    }
    AppMethodBeat.o(93940);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93941);
    super.finalize();
    this.eCH = null;
    this.eCI = null;
    this.eCJ = null;
    AppMethodBeat.o(93941);
  }
  
  public final void run()
  {
    AppMethodBeat.i(93939);
    while (!Thread.currentThread().isInterrupted())
    {
      try
      {
        if (this.eCH.isEmpty()) {
          break label399;
        }
        localObject3 = (d.b)this.eCH.poll();
        if (localObject3 == null) {
          continue;
        }
        l = ((d.b)localObject3).time;
        localObject1 = ((d.b)localObject3).eCA;
        localObject3 = ((d.b)localObject3).eCB;
        if (this.eCI != null) {
          break label227;
        }
        this.eCI = new b(l, (Map)localObject1, (Map)localObject3);
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
          AppMethodBeat.o(93939);
          return;
          b localb = this.eCI;
          int[] arrayOfInt = b.i(localInterruptedException);
          localb.updateTime = l;
          localb.eCf.x(((d.a)localInterruptedException.get(Integer.valueOf(arrayOfInt[0]))).eCy, ((d.a)localInterruptedException.get(Integer.valueOf(arrayOfInt[0]))).eCz);
          if (localb.eCg != null) {
            localb.eCg.x(((d.a)localInterruptedException.get(Integer.valueOf(arrayOfInt[1]))).eCy, ((d.a)localInterruptedException.get(Integer.valueOf(arrayOfInt[1]))).eCz);
          }
          localb.j((Map)localObject3);
        }
      }
      catch (Exception localException)
      {
        label227:
        c.e("HardCoder.HardCoderStatThread", "exception:" + localException.getMessage());
      }
      c.i("HardCoder.HardCoderStatThread", this.eCI.toString());
      localObject1 = new b(l, (Map)localObject1, (Map)localObject3);
      localObject3 = (b)this.eCJ.peekFirst();
      localb = (b)this.eCJ.peekLast();
      if ((localObject3 != null) && (localb != null))
      {
        if (localb.startTime - ((b)localObject3).startTime >= 30000L) {
          this.eCJ.removeFirst();
        }
        this.eCJ.add(localObject1);
      }
      else
      {
        this.eCJ.add(localException);
        continue;
        try
        {
          label399:
          if (this.eCj)
          {
            c.i("HardCoder.HardCoderStatThread", "snapshotStatDeque size:" + this.eCJ.size());
            if (this.thread != null)
            {
              this.thread.interrupt();
              this.thread = null;
              this.eCj = false;
            }
          }
          while (this.eCH.isEmpty()) {
            wait();
          }
        }
        finally
        {
          AppMethodBeat.o(93939);
        }
      }
    }
    AppMethodBeat.o(93939);
  }
  
  public static final class a
  {
    public final long eCK;
    public final long eCL;
    public long eCM;
    public long eCN;
    
    public a(long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(93933);
      this.eCM = 0L;
      this.eCN = 0L;
      this.eCK = paramLong1;
      this.eCL = paramLong2;
      this.eCM = this.eCK;
      this.eCN = this.eCL;
      AppMethodBeat.o(93933);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(93934);
      String str = String.format("startFreq:%s, startPower:%s, averageFreq:%s, averagePower:%s", new Object[] { Long.valueOf(this.eCK), Long.valueOf(this.eCL), Long.valueOf(this.eCM), Long.valueOf(this.eCN) });
      AppMethodBeat.o(93934);
      return str;
    }
    
    public final void x(long paramLong1, long paramLong2)
    {
      this.eCM = ((this.eCM + paramLong1) / 2L);
      this.eCN = ((this.eCN + paramLong2) / 2L);
    }
  }
  
  public static final class b
  {
    public final Map<Integer, d.a> eCA;
    public final Map<Integer, d.c> eCO;
    public final f.a eCf;
    public final f.a eCg;
    public final long startTime;
    public long updateTime;
    
    public b(long paramLong, Map<Integer, d.a> paramMap, Map<Integer, d.c> paramMap1)
    {
      AppMethodBeat.i(93935);
      this.eCO = new TreeMap();
      this.updateTime = 0L;
      int[] arrayOfInt = i(paramMap);
      this.eCA = paramMap;
      this.eCf = new f.a(((d.a)paramMap.get(Integer.valueOf(arrayOfInt[0]))).eCy, ((d.a)paramMap.get(Integer.valueOf(arrayOfInt[0]))).eCz);
      if (arrayOfInt[1] < 0) {
        c.e("HardCoder.HardCoderStatThread", "cluster one is unused?may be possible.");
      }
      for (this.eCg = null;; this.eCg = new f.a(((d.a)paramMap.get(Integer.valueOf(arrayOfInt[1]))).eCy, ((d.a)paramMap.get(Integer.valueOf(arrayOfInt[1]))).eCz))
      {
        this.startTime = paramLong;
        this.updateTime = this.startTime;
        j(paramMap1);
        AppMethodBeat.o(93935);
        return;
      }
    }
    
    public static int[] i(Map<Integer, d.a> paramMap)
    {
      AppMethodBeat.i(93936);
      if (paramMap == null)
      {
        paramMap = new NullPointerException("cpuStatusMap can not be null");
        AppMethodBeat.o(93936);
        throw paramMap;
      }
      int i = h.eCR;
      if (i >= 0) {
        if (!paramMap.containsKey(Integer.valueOf(i))) {}
      }
      for (int j = i;; j = -1)
      {
        if (j < 0) {
          c.e("HardCoder.HardCoderStatThread", "cluster zero is unused?impossible.CLUSTER_ZERO_CORE_ID:" + h.eCR);
        }
        i = h.eCS;
        label80:
        if (i > h.eCR) {
          if (!paramMap.containsKey(Integer.valueOf(i))) {}
        }
        for (;;)
        {
          AppMethodBeat.o(93936);
          return new int[] { j, i };
          i -= 1;
          break;
          i -= 1;
          break label80;
          i = -1;
        }
      }
    }
    
    final void j(Map<Integer, d.c> paramMap)
    {
      AppMethodBeat.i(93937);
      if (paramMap == null)
      {
        paramMap = new NullPointerException("threadStatusMap can not be null");
        AppMethodBeat.o(93937);
        throw paramMap;
      }
      Iterator localIterator = paramMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        int i = ((Integer)paramMap.getKey()).intValue();
        d.c localc = (d.c)paramMap.getValue();
        if (this.eCO.containsKey(Integer.valueOf(i))) {
          paramMap = (d.c)this.eCO.get(Integer.valueOf(i));
        }
        for (;;)
        {
          paramMap.a(localc.eCE, localc.eCa);
          break;
          paramMap = new d.c(localc.eCC, localc.startTime, localc.eCD, localc.eCE, localc.eCa);
          this.eCO.put(Integer.valueOf(i), paramMap);
        }
      }
      AppMethodBeat.o(93937);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(93938);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.format("startTime:%s,updateTime:%s", new Object[] { Long.valueOf(this.startTime), Long.valueOf(this.updateTime) }));
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.eCf);
      if (this.eCg != null)
      {
        ((StringBuilder)localObject).append(",");
        ((StringBuilder)localObject).append(this.eCg);
      }
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.eCO.toString());
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(93938);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.f
 * JD-Core Version:    0.7.0.1
 */