package com.tencent.mm.hardcoder;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class b
  implements Runnable
{
  private Queue<Object> eCh;
  private h eCi;
  private boolean eCj;
  private Thread thread;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(93958);
    this.eCh = new ConcurrentLinkedQueue();
    this.thread = null;
    this.eCj = false;
    this.eCi = new h(paramContext);
    paramContext = this.eCi;
    if (h.eCT == null)
    {
      paramContext.PG();
      AppMethodBeat.o(93958);
      return;
    }
    paramContext.PF();
    AppMethodBeat.o(93958);
  }
  
  public final void ac(Object paramObject)
  {
    AppMethodBeat.i(93961);
    if (this.eCh != null) {
      try
      {
        this.eCh.add(paramObject);
        notify();
        return;
      }
      finally
      {
        AppMethodBeat.o(93961);
      }
    }
    AppMethodBeat.o(93961);
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93962);
    super.finalize();
    this.eCh.clear();
    AppMethodBeat.o(93962);
  }
  
  public final void run()
  {
    AppMethodBeat.i(93960);
    c.i("HardCoder.HCPerfStatThread", "[oneliang]HCPerfStatThread start to run.");
    if (!Thread.currentThread().isInterrupted()) {}
    for (;;)
    {
      int m;
      Map localMap;
      int[] arrayOfInt2;
      int i;
      try
      {
        if (this.eCh.isEmpty()) {
          break label1260;
        }
        localObject1 = this.eCh.poll();
        if (!(localObject1 instanceof a)) {
          break label1241;
        }
        localObject1 = (a)localObject1;
        l1 = ((a)localObject1).time;
        localList = ((a)localObject1).eCk;
        k = ((a)localObject1).eCl;
        m = ((a)localObject1).eCn;
        arrayOfInt1 = ((a)localObject1).eBZ;
        c.d("HardCoder.HardCoderReporter", String.format("[oneliang]save task status,time:%s,size:%s,cpu:%s,io:%s", new Object[] { Long.valueOf(l1), Integer.valueOf(localList.size()), Integer.valueOf(k), Integer.valueOf(m) }));
        localMap = d.a(l1, this.eCi);
        arrayOfInt2 = f.b.i(localMap);
        localObject1 = g.PE();
        if (localObject1 != null) {
          break label1338;
        }
        localObject1 = new long[] { 0L, 0L };
      }
      catch (InterruptedException localInterruptedException)
      {
        Object localObject1;
        long l1;
        List localList;
        int k;
        int[] arrayOfInt1;
        c.e("HardCoder.HCPerfStatThread", "Performance status thread need to interrupt:" + localInterruptedException.getMessage());
        Thread.currentThread().interrupt();
        AppMethodBeat.o(93960);
        return;
        localb.eBV = k;
        localObject3 = localb.eBX;
        localObject3[k] = ((int)(localObject3[k] + l2));
        continue;
      }
      catch (Exception localException)
      {
        c.printErrStackTrace("HardCoder.HCPerfStatThread", localException, "run exception:", new Object[0]);
      }
      if (i >= localList.size()) {
        break;
      }
      a.b localb = (a.b)localList.get(i);
      if (localb.PC())
      {
        long l2 = l1 - localb.lastUpdateTime;
        localb.lastUpdateTime = l1;
        if (k != -1)
        {
          if (k == -2)
          {
            localObject3 = localb.eBX;
            j = localb.eBV;
            localObject3[j] = ((int)(localObject3[j] + l2));
            if (m == -1) {
              break label956;
            }
            if (m != -2) {
              break label924;
            }
            localObject3 = localb.eBY;
            j = localb.eBW;
            localObject3[j] = ((int)(l2 + localObject3[j]));
            if ((arrayOfInt1 != null) && (arrayOfInt1.length > 0)) {
              localb.eBZ = arrayOfInt1;
            }
            if (!localb.PC()) {
              break label1343;
            }
            j = localb.eBQ[0];
            localObject3 = g.jo(j);
            if (localObject3 != null) {
              break label1335;
            }
            localObject3 = new long[] { 0L, 0L };
            if (!localb.PC()) {
              break label1348;
            }
            j = localb.eBQ[0];
            l2 = g.jq(g.jp(j));
            if (localb.eCc == 0L) {
              localb.eCc = l2;
            }
            if (localb.eCa == null) {
              localb.eCa = ((long[])localObject3);
            }
            if (localb.eCb == null) {
              localb.eCb = ((long[])localObject1);
            }
            localb.eCc = ((l2 + localb.eCc) / 2L);
            if ((localObject3 != null) && (localb.PC()))
            {
              localb.eCd = ((int)(localObject3[0] - localb.eCa[0] + (localObject3[1] - localb.eCa[1])));
              c.d("HardCoder.HardCoderReporter", "bindTidsId:" + localb.PD() + ", start jiffies:[" + localb.eCa[0] + "," + localb.eCa[1] + "], end jiffies:[" + localObject3[0] + "," + localObject3[1] + "], sum thread jiffies:" + localb.eCd);
            }
            if ((HardCoderJNI.isHcDebug()) && (localObject1 != null) && (localb.PC()))
            {
              localb.eCe = (localObject1[0] - localb.eCb[0] + (localObject1[1] - localb.eCb[1]));
              c.d("HardCoder.HardCoderReporter", "bindTidsId:" + localb.PD() + ", process start jiffies:[" + localb.eCb[0] + "," + localb.eCb[1] + "], process end jiffies:[" + localObject1[0] + "," + localObject1[1] + "], sum process jiffies:" + localb.eCe);
            }
            if ((localb.eCf != null) || (localb.eCg != null)) {
              break label1124;
            }
            if (localMap.get(Integer.valueOf(arrayOfInt2[0])) != null) {
              break label991;
            }
            c.e("HardCoder.HCPerfStatThread", String.format("cpuStatusMap dosn't contain core 0 : %d", new Object[] { Integer.valueOf(arrayOfInt2[0]) }));
            break;
          }
          break;
        }
        localb.eBV = 0;
        Object localObject3 = localb.eBX;
        int j = localb.eBV;
        localObject3[j] = ((int)(localObject3[j] + l2));
        continue;
        label924:
        localb.eBW = m;
        localObject3 = localb.eBY;
        localObject3[m] = ((int)(l2 + localObject3[m]));
        continue;
        label956:
        localb.eBW = 0;
        localObject3 = localb.eBY;
        j = localb.eBW;
        localObject3[j] = ((int)(l2 + localObject3[j]));
        continue;
        label991:
        localb.eCf = new f.a(((d.a)localMap.get(Integer.valueOf(arrayOfInt2[0]))).eCy, ((d.a)localMap.get(Integer.valueOf(arrayOfInt2[0]))).eCz);
        if (arrayOfInt2[1] < 0)
        {
          c.e("HardCoder.HCPerfStatThread", "cluster one is unused?may be possible.");
          localb.eCg = null;
        }
        else
        {
          localb.eCg = new f.a(((d.a)localMap.get(Integer.valueOf(arrayOfInt2[1]))).eCy, ((d.a)localMap.get(Integer.valueOf(arrayOfInt2[1]))).eCz);
          break label1353;
          label1124:
          if (localb.eCf != null) {
            localb.eCf.x(((d.a)localMap.get(Integer.valueOf(arrayOfInt2[0]))).eCy, ((d.a)localMap.get(Integer.valueOf(arrayOfInt2[0]))).eCz);
          }
          if (localb.eCg != null)
          {
            localb.eCg.x(((d.a)localMap.get(Integer.valueOf(arrayOfInt2[1]))).eCy, ((d.a)localMap.get(Integer.valueOf(arrayOfInt2[1]))).eCz);
            break label1353;
            label1241:
            if (!(localException instanceof a.b)) {
              break;
            }
            e.a((a.b)localException);
            break;
            try
            {
              label1260:
              if ((this.eCj) && (this.thread != null))
              {
                this.thread.interrupt();
                this.thread = null;
                this.eCj = false;
              }
              while (this.eCh.isEmpty()) {
                wait();
              }
            }
            finally
            {
              AppMethodBeat.o(93960);
            }
            break;
            AppMethodBeat.o(93960);
            return;
            label1335:
            continue;
            label1338:
            i = 0;
            continue;
            label1343:
            j = 0;
            continue;
            label1348:
            j = 0;
            continue;
          }
        }
      }
      label1353:
      i += 1;
    }
  }
  
  public final void start()
  {
    try
    {
      AppMethodBeat.i(93959);
      if (this.thread == null)
      {
        this.thread = new Thread(this);
        this.thread.setPriority(5);
        this.thread.start();
      }
      AppMethodBeat.o(93959);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    public final int[] eBZ;
    public final List<a.b> eCk;
    public final int eCl;
    public final int eCm;
    public final int eCn;
    public final long time;
    
    public a(long paramLong, List<a.b> paramList, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
    {
      this.time = paramLong;
      this.eCk = paramList;
      this.eCl = paramInt1;
      this.eCm = paramInt2;
      this.eCn = paramInt3;
      this.eBZ = paramArrayOfInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.b
 * JD-Core Version:    0.7.0.1
 */