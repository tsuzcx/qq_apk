package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements Runnable
{
  private Queue<Object> gyC;
  private boolean gyD;
  private Thread thread;
  
  public b()
  {
    AppMethodBeat.i(62452);
    this.gyC = new ConcurrentLinkedQueue();
    this.thread = null;
    this.gyD = false;
    AppMethodBeat.o(62452);
  }
  
  public final void aT(Object paramObject)
  {
    AppMethodBeat.i(62455);
    if (this.gyC != null) {
      try
      {
        this.gyC.add(paramObject);
        notify();
        return;
      }
      finally
      {
        AppMethodBeat.o(62455);
      }
    }
    AppMethodBeat.o(62455);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(62456);
    super.finalize();
    this.gyC.clear();
    AppMethodBeat.o(62456);
  }
  
  public final void run()
  {
    AppMethodBeat.i(62454);
    d.i("Hardcoder.HCPerfStatThread", "HCPerfStatThread start to run.");
    if (Thread.currentThread() == null)
    {
      d.e("Hardcoder.HCPerfStatThread", "run error, current thread is null!");
      AppMethodBeat.o(62454);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1;
        if ((localObject1 instanceof a.b)) {
          e.a((a.b)localObject1);
        }
        if ((Thread.currentThread() != null) && (!Thread.currentThread().isInterrupted())) {
          if (!this.gyC.isEmpty())
          {
            localObject1 = this.gyC.poll();
            if (!(localObject1 instanceof a)) {
              continue;
            }
            Object localObject3 = (a)localObject1;
            long l1 = ((a)localObject3).time;
            localObject1 = ((a)localObject3).gyE;
            int k = ((a)localObject3).gyF;
            m = ((a)localObject3).gyH;
            localObject3 = ((a)localObject3).gyA;
            d.d("Hardcoder.HardCoderReporter", String.format("forgives, time:%s, size:%s, cpu:%s, io:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(((List)localObject1).size()), Integer.valueOf(k), Integer.valueOf(m) }));
            i = 0;
            if (i >= ((List)localObject1).size()) {
              continue;
            }
            localb = (a.b)((List)localObject1).get(i);
            if (!localb.ahA()) {
              break label654;
            }
            l2 = l1 - localb.lastUpdateTime;
            localb.lastUpdateTime = l1;
            if (k != -1)
            {
              if (k == -2)
              {
                arrayOfInt = localb.gyy;
                j = localb.gyw;
                arrayOfInt[j] = ((int)(arrayOfInt[j] + l2));
                if (m == -1) {
                  continue;
                }
                if (m != -2) {
                  continue;
                }
                arrayOfInt = localb.gyz;
                j = localb.gyx;
                arrayOfInt[j] = ((int)(l2 + arrayOfInt[j]));
                if ((localObject3 != null) && (localObject3.length > 0)) {
                  localb.gyA = ((int[])localObject3);
                }
                if (!localb.ahA()) {
                  break label661;
                }
                j = localb.gyr[0];
                l2 = f.ms(f.mr(j));
                if (localb.gyB == 0L) {
                  localb.gyB = l2;
                }
                localb.gyB = ((l2 + localb.gyB) / 2L);
                break label654;
              }
              localb.gyw = k;
              arrayOfInt = localb.gyy;
              arrayOfInt[k] = ((int)(arrayOfInt[k] + l2));
              continue;
            }
          }
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        d.e("Hardcoder.HCPerfStatThread", "Performance status thread need to interrupt:" + localInterruptedException.getMessage());
        Thread.currentThread().interrupt();
        AppMethodBeat.o(62454);
        return;
        localb.gyw = 0;
        arrayOfInt = localb.gyy;
        j = localb.gyw;
        arrayOfInt[j] = ((int)(arrayOfInt[j] + l2));
        continue;
      }
      catch (Exception localException)
      {
        int m;
        a.b localb;
        long l2;
        d.printErrStackTrace("Hardcoder.HCPerfStatThread", localException, "run exception:", new Object[0]);
        continue;
        localb.gyx = m;
        int[] arrayOfInt = localb.gyz;
        arrayOfInt[m] = ((int)(l2 + arrayOfInt[m]));
        continue;
        localb.gyx = 0;
        arrayOfInt = localb.gyz;
        j = localb.gyx;
        arrayOfInt[j] = ((int)(l2 + arrayOfInt[j]));
        continue;
        try
        {
          if ((this.gyD) && (this.thread != null))
          {
            this.thread.interrupt();
            this.thread = null;
            this.gyD = false;
          }
          if (this.gyC.isEmpty())
          {
            wait();
            continue;
          }
        }
        finally
        {
          AppMethodBeat.o(62454);
        }
        continue;
        AppMethodBeat.o(62454);
        return;
      }
      label654:
      i += 1;
      continue;
      label661:
      int j = 0;
    }
  }
  
  public final void start()
  {
    try
    {
      AppMethodBeat.i(62453);
      if (this.thread == null)
      {
        this.thread = new Thread(this);
        this.thread.setPriority(5);
        this.thread.start();
      }
      AppMethodBeat.o(62453);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    public final int[] gyA;
    public final List<a.b> gyE;
    public final int gyF;
    public final int gyG;
    public final int gyH;
    public final long time;
    
    public a(long paramLong, List<a.b> paramList, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
    {
      this.time = paramLong;
      this.gyE = paramList;
      this.gyF = paramInt1;
      this.gyG = paramInt2;
      this.gyH = paramInt3;
      this.gyA = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.b
 * JD-Core Version:    0.7.0.1
 */