package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements Runnable
{
  private Queue<Object> hlp;
  private boolean hlq;
  private Thread thread;
  
  public b()
  {
    AppMethodBeat.i(62452);
    this.hlp = new ConcurrentLinkedQueue();
    this.thread = null;
    this.hlq = false;
    AppMethodBeat.o(62452);
  }
  
  public final void bc(Object paramObject)
  {
    AppMethodBeat.i(62455);
    if (this.hlp != null) {
      try
      {
        this.hlp.add(paramObject);
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
    this.hlp.clear();
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
          if (!this.hlp.isEmpty())
          {
            localObject1 = this.hlp.poll();
            if (!(localObject1 instanceof a)) {
              continue;
            }
            Object localObject3 = (a)localObject1;
            long l1 = ((a)localObject3).time;
            localObject1 = ((a)localObject3).hlr;
            int k = ((a)localObject3).hls;
            m = ((a)localObject3).hlu;
            localObject3 = ((a)localObject3).hln;
            d.d("Hardcoder.HardCoderReporter", String.format("forgives, time:%s, size:%s, cpu:%s, io:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(((List)localObject1).size()), Integer.valueOf(k), Integer.valueOf(m) }));
            i = 0;
            if (i >= ((List)localObject1).size()) {
              continue;
            }
            localb = (a.b)((List)localObject1).get(i);
            if (!localb.axM()) {
              break label654;
            }
            l2 = l1 - localb.lastUpdateTime;
            localb.lastUpdateTime = l1;
            if (k != -1)
            {
              if (k == -2)
              {
                arrayOfInt = localb.hll;
                j = localb.hlj;
                arrayOfInt[j] = ((int)(arrayOfInt[j] + l2));
                if (m == -1) {
                  continue;
                }
                if (m != -2) {
                  continue;
                }
                arrayOfInt = localb.hlm;
                j = localb.hlk;
                arrayOfInt[j] = ((int)(l2 + arrayOfInt[j]));
                if ((localObject3 != null) && (localObject3.length > 0)) {
                  localb.hln = ((int[])localObject3);
                }
                if (!localb.axM()) {
                  break label661;
                }
                j = localb.hle[0];
                l2 = f.pF(f.pE(j));
                if (localb.hlo == 0L) {
                  localb.hlo = l2;
                }
                localb.hlo = ((l2 + localb.hlo) / 2L);
                break label654;
              }
              localb.hlj = k;
              arrayOfInt = localb.hll;
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
        localb.hlj = 0;
        arrayOfInt = localb.hll;
        j = localb.hlj;
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
        localb.hlk = m;
        int[] arrayOfInt = localb.hlm;
        arrayOfInt[m] = ((int)(l2 + arrayOfInt[m]));
        continue;
        localb.hlk = 0;
        arrayOfInt = localb.hlm;
        j = localb.hlk;
        arrayOfInt[j] = ((int)(l2 + arrayOfInt[j]));
        continue;
        try
        {
          if ((this.hlq) && (this.thread != null))
          {
            this.thread.interrupt();
            this.thread = null;
            this.hlq = false;
          }
          if (this.hlp.isEmpty())
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
    public final int[] hln;
    public final List<a.b> hlr;
    public final int hls;
    public final int hlt;
    public final int hlu;
    public final long time;
    
    public a(long paramLong, List<a.b> paramList, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
    {
      this.time = paramLong;
      this.hlr = paramList;
      this.hls = paramInt1;
      this.hlt = paramInt2;
      this.hlu = paramInt3;
      this.hln = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.b
 * JD-Core Version:    0.7.0.1
 */