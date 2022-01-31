package com.tencent.mm.hardcoder;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements Runnable
{
  private Queue<Object> dEG = new ConcurrentLinkedQueue();
  private l dEH;
  private boolean dEI = false;
  private Thread thread = null;
  
  public b(Context paramContext)
  {
    this.dEH = new l(paramContext);
    paramContext = this.dEH;
    if (l.context == null)
    {
      paramContext.BQ();
      return;
    }
    paramContext.BP();
  }
  
  public final void T(Object paramObject)
  {
    if (this.dEG != null)
    {
      this.dEG.add(paramObject);
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  protected final void finalize()
  {
    super.finalize();
    this.dEG = null;
  }
  
  public final void run()
  {
    c.i("HardCoder.HCPerfStatThread", "[oneliang]HCPerfStatThread running");
    if (!Thread.currentThread().isInterrupted()) {}
    for (;;)
    {
      for (;;)
      {
        int k;
        Map localMap;
        int[] arrayOfInt2;
        try
        {
          if (this.dEG.isEmpty()) {
            break label1232;
          }
          localObject1 = this.dEG.poll();
          if (!(localObject1 instanceof a)) {
            break label1194;
          }
          localObject1 = (a)localObject1;
          l1 = ((a)localObject1).time;
          localList = ((a)localObject1).dEJ;
          j = ((a)localObject1).dEK;
          k = ((a)localObject1).dEL;
          arrayOfInt1 = ((a)localObject1).dEw;
          if (HardCoderJNI.hcDebug) {
            c.d("HardCoder.HardCoderReporter", String.format("[oneliang]save task status,time:%s,size:%s,cpu:%s,io:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(localList.size()), Integer.valueOf(j), Integer.valueOf(k) }));
          }
          localMap = d.a(l1, this.dEH);
          arrayOfInt2 = j.b.g(localMap);
          localObject1 = HardCoderJNI.getMyProcCpuTime();
          if (localObject1 != null) {
            break label1281;
          }
          localObject1 = new long[] { 0L, 0L };
        }
        catch (InterruptedException localInterruptedException)
        {
          Object localObject1;
          long l1;
          List localList;
          int j;
          int[] arrayOfInt1;
          long[] arrayOfLong;
          c.e("HardCoder.HCPerfStatThread", "Performance status thread need to interrupt:" + localInterruptedException.getMessage());
          Thread.currentThread().interrupt();
          return;
          localb.dEs = 0;
          localObject3 = localb.dEu;
          m = localb.dEs;
          localObject3[m] = ((int)(localObject3[m] + l2));
          continue;
        }
        catch (Exception localException)
        {
          c.e("HardCoder.HCPerfStatThread", "exception:" + localException.getMessage());
        }
        if (i >= localList.size()) {
          break;
        }
        a.b localb = (a.b)localList.get(i);
        if (localb.dEn == 0) {
          break label1286;
        }
        long l2 = l1 - localb.lastUpdateTime;
        localb.lastUpdateTime = l1;
        if (j != -1)
        {
          if (j == -2)
          {
            localObject3 = localb.dEu;
            m = localb.dEs;
            localObject3[m] = ((int)(localObject3[m] + l2));
            if (k == -1) {
              break label983;
            }
            if (k == -2)
            {
              localObject3 = localb.dEv;
              m = localb.dEt;
              localObject3[m] = ((int)(l2 + localObject3[m]));
              if ((arrayOfInt1 != null) && (arrayOfInt1.length > 0)) {
                localb.dEw = arrayOfInt1;
              }
              arrayOfLong = HardCoderJNI.getThreadCpuJiffies(localb.dEn);
              localObject3 = arrayOfLong;
              if (arrayOfLong == null)
              {
                localObject3 = new long[2];
                Object tmp359_357 = localObject3;
                tmp359_357[0] = 0L;
                Object tmp363_359 = tmp359_357;
                tmp363_359[1] = 0L;
                tmp363_359;
              }
              l2 = HardCoderJNI.getCpuFreqByCoreId(HardCoderJNI.getThreadCoreId(localb.dEn));
              if (localb.dEz == 0L) {
                localb.dEz = l2;
              }
              if (localb.dEx == null) {
                localb.dEx = ((long[])localObject3);
              }
              if (localb.dEy == null) {
                localb.dEy = ((long[])localObject1);
              }
              localb.dEz = ((l2 + localb.dEz) / 2L);
              if ((localObject3 != null) && (localb.dEn > 0))
              {
                localb.dEA = ((int)(localObject3[0] - localb.dEx[0] + (localObject3[1] - localb.dEx[1])));
                if (HardCoderJNI.hcDebug) {
                  c.d("HardCoder.HardCoderReporter", "thread id:" + localb.dEn + ",start jiffies:[" + localb.dEx[0] + "," + localb.dEx[1] + "], end jiffies:[" + localObject3[0] + "," + localObject3[1] + "],sum thread jiffies:" + localb.dEA);
                }
              }
              if ((localObject1 != null) && (localb.dEn > 0) && (HardCoderJNI.hcDebug))
              {
                localb.dEB = (localObject1[0] - localb.dEy[0] + (localObject1[1] - localb.dEy[1]));
                c.d("HardCoder.HardCoderReporter", "thread id:" + localb.dEn + ",process start jiffies:[" + localb.dEy[0] + "," + localb.dEy[1] + "], process end jiffies:[" + localObject1[0] + "," + localObject1[1] + "],sum process jiffies:" + localb.dEB);
              }
              if ((localb.dEC != null) || (localb.dED != null)) {
                break label1077;
              }
              localb.dEC = new j.a(((d.a)localMap.get(Integer.valueOf(arrayOfInt2[0]))).dEW, ((d.a)localMap.get(Integer.valueOf(arrayOfInt2[0]))).dEX);
              if (arrayOfInt2[1] >= 0) {
                break label1021;
              }
              c.e("HardCoder.HCPerfStatThread", "cluster one is unused?may be possible.");
              localb.dED = null;
              break label1286;
            }
          }
          else
          {
            localb.dEs = j;
            localObject3 = localb.dEu;
            localObject3[j] = ((int)(localObject3[j] + l2));
            continue;
          }
        }
        else {
          break;
        }
        localb.dEt = k;
        Object localObject3 = localb.dEv;
        localObject3[k] = ((int)(l2 + localObject3[k]));
        continue;
        label983:
        localb.dEt = 0;
        localObject3 = localb.dEv;
        int m = localb.dEt;
        localObject3[m] = ((int)(l2 + localObject3[m]));
        continue;
        label1021:
        localb.dED = new j.a(((d.a)localMap.get(Integer.valueOf(arrayOfInt2[1]))).dEW, ((d.a)localMap.get(Integer.valueOf(arrayOfInt2[1]))).dEX);
        break label1286;
        label1077:
        if (localb.dEC != null) {
          localb.dEC.p(((d.a)localMap.get(Integer.valueOf(arrayOfInt2[0]))).dEW, ((d.a)localMap.get(Integer.valueOf(arrayOfInt2[0]))).dEX);
        }
        if (localb.dED == null) {
          break label1286;
        }
        localb.dED.p(((d.a)localMap.get(Integer.valueOf(arrayOfInt2[1]))).dEW, ((d.a)localMap.get(Integer.valueOf(arrayOfInt2[1]))).dEX);
        break label1286;
        label1194:
        if ((localException instanceof a.b))
        {
          h.a((a.b)localException);
          break;
        }
        if (!(localException instanceof e)) {
          break;
        }
        ((e)localException).wn();
        break;
        try
        {
          label1232:
          if ((this.dEI) && (this.thread != null))
          {
            this.thread.interrupt();
            this.thread = null;
            this.dEI = false;
          }
          wait();
          break;
        }
        finally {}
      }
      label1281:
      int i = 0;
      continue;
      label1286:
      i += 1;
    }
  }
  
  public final void start()
  {
    try
    {
      if (this.thread == null)
      {
        this.thread = new Thread(this);
        this.thread.setPriority(5);
        this.thread.start();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
  {
    public final List<a.b> dEJ;
    public final int dEK;
    public final int dEL;
    public final int[] dEw;
    public final long time;
    
    public a(long paramLong, List<a.b> paramList, int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      this.time = paramLong;
      this.dEJ = paramList;
      this.dEK = paramInt1;
      this.dEL = paramInt2;
      this.dEw = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.b
 * JD-Core Version:    0.7.0.1
 */