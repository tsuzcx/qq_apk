package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements Runnable
{
  private Queue<Object> gvV;
  private boolean gvW;
  private Thread thread;
  
  public b()
  {
    AppMethodBeat.i(62452);
    this.gvV = new ConcurrentLinkedQueue();
    this.thread = null;
    this.gvW = false;
    AppMethodBeat.o(62452);
  }
  
  public final void aT(Object paramObject)
  {
    AppMethodBeat.i(62455);
    if (this.gvV != null) {
      try
      {
        this.gvV.add(paramObject);
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
    this.gvV.clear();
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
          if (!this.gvV.isEmpty())
          {
            localObject1 = this.gvV.poll();
            if (!(localObject1 instanceof a)) {
              continue;
            }
            Object localObject3 = (a)localObject1;
            long l1 = ((a)localObject3).time;
            localObject1 = ((a)localObject3).gvX;
            int k = ((a)localObject3).gvY;
            m = ((a)localObject3).gwa;
            localObject3 = ((a)localObject3).gvT;
            d.d("Hardcoder.HardCoderReporter", String.format("forgives, time:%s, size:%s, cpu:%s, io:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(((List)localObject1).size()), Integer.valueOf(k), Integer.valueOf(m) }));
            i = 0;
            if (i >= ((List)localObject1).size()) {
              continue;
            }
            localb = (a.b)((List)localObject1).get(i);
            if (!localb.ahl()) {
              break label654;
            }
            l2 = l1 - localb.lastUpdateTime;
            localb.lastUpdateTime = l1;
            if (k != -1)
            {
              if (k == -2)
              {
                arrayOfInt = localb.gvR;
                j = localb.gvP;
                arrayOfInt[j] = ((int)(arrayOfInt[j] + l2));
                if (m == -1) {
                  continue;
                }
                if (m != -2) {
                  continue;
                }
                arrayOfInt = localb.gvS;
                j = localb.gvQ;
                arrayOfInt[j] = ((int)(l2 + arrayOfInt[j]));
                if ((localObject3 != null) && (localObject3.length > 0)) {
                  localb.gvT = ((int[])localObject3);
                }
                if (!localb.ahl()) {
                  break label661;
                }
                j = localb.gvK[0];
                l2 = f.mp(f.mo(j));
                if (localb.gvU == 0L) {
                  localb.gvU = l2;
                }
                localb.gvU = ((l2 + localb.gvU) / 2L);
                break label654;
              }
              localb.gvP = k;
              arrayOfInt = localb.gvR;
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
        localb.gvP = 0;
        arrayOfInt = localb.gvR;
        j = localb.gvP;
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
        localb.gvQ = m;
        int[] arrayOfInt = localb.gvS;
        arrayOfInt[m] = ((int)(l2 + arrayOfInt[m]));
        continue;
        localb.gvQ = 0;
        arrayOfInt = localb.gvS;
        j = localb.gvQ;
        arrayOfInt[j] = ((int)(l2 + arrayOfInt[j]));
        continue;
        try
        {
          if ((this.gvW) && (this.thread != null))
          {
            this.thread.interrupt();
            this.thread = null;
            this.gvW = false;
          }
          if (this.gvV.isEmpty())
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
    public final int[] gvT;
    public final List<a.b> gvX;
    public final int gvY;
    public final int gvZ;
    public final int gwa;
    public final long time;
    
    public a(long paramLong, List<a.b> paramList, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
    {
      this.time = paramLong;
      this.gvX = paramList;
      this.gvY = paramInt1;
      this.gvZ = paramInt2;
      this.gwa = paramInt3;
      this.gvT = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.b
 * JD-Core Version:    0.7.0.1
 */