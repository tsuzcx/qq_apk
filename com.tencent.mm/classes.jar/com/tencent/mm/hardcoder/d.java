package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class d
  implements Runnable
{
  private h eCi;
  private Set<Integer> eCp;
  private f eCq;
  private long eCr;
  private long eCs;
  
  public static Map<Integer, a> a(final long paramLong, h paramh)
  {
    AppMethodBeat.i(93929);
    TreeMap localTreeMap = new TreeMap();
    int j = Runtime.getRuntime().availableProcessors();
    final int i = 0;
    while (i < j)
    {
      File localFile = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
      if (localFile.exists()) {
        g.a(localFile.getAbsolutePath(), new g.a()
        {
          public final boolean lS(String paramAnonymousString)
          {
            AppMethodBeat.i(93923);
            long l = Long.parseLong(paramAnonymousString.trim());
            if (this.eCt.eCP.containsKey(Integer.valueOf(i)))
            {
              paramAnonymousString = (Integer)((h.a)this.eCt.eCP.get(Integer.valueOf(i))).eCW.get(Long.valueOf(l));
              if (paramAnonymousString == null) {}
            }
            for (int i = paramAnonymousString.intValue();; i = 0)
            {
              paramAnonymousString = new d.a(paramLong, i, l, i);
              this.eCw.put(Integer.valueOf(i), paramAnonymousString);
              c.d("HardCoder.HardCoderMonitor", paramAnonymousString.toString());
              AppMethodBeat.o(93923);
              return false;
            }
          }
        });
      }
      i += 1;
    }
    AppMethodBeat.o(93929);
    return localTreeMap;
  }
  
  protected final void finalize()
  {
    AppMethodBeat.i(93930);
    super.finalize();
    this.eCp = null;
    this.eCi = null;
    this.eCq = null;
    AppMethodBeat.o(93930);
  }
  
  public final void run()
  {
    AppMethodBeat.i(93928);
    if (!Thread.currentThread().isInterrupted()) {}
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            long l1;
            try
            {
              l1 = System.currentTimeMillis();
              if ((l1 < this.eCr) || (l1 > this.eCs)) {
                break label621;
              }
              c.d("HardCoder.HardCoderMonitor", "get cpu current freq,begin:" + SystemClock.elapsedRealtime());
              Map localMap = a(l1, this.eCi);
              c.d("HardCoder.HardCoderMonitor", "get cpu current freq,end:" + SystemClock.elapsedRealtime());
              localObject5 = new HashSet();
              localObject6 = new File("/proc/" + Process.myPid() + "/task");
              if (!((File)localObject6).isDirectory()) {
                break label462;
              }
              localObject6 = ((File)localObject6).listFiles();
              if (localObject6 == null) {
                break label661;
              }
              if (localObject6.length != 0) {
                continue;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              Object localObject5;
              c.e("HardCoder.HardCoderMonitor", "Monitor thread need to interrupt:" + localInterruptedException.getMessage());
              Thread.currentThread().interrupt();
              AppMethodBeat.o(93928);
              return;
              c.d("HardCoder.HardCoderMonitor", "thread size:" + localObject6.length);
              j = localObject6.length;
              i = 0;
              if (i >= j) {
                break label457;
              }
              Object localObject7 = localObject6[i].getName();
              try
              {
                ((Set)localObject5).add(Integer.valueOf(Integer.parseInt((String)localObject7, 0)));
                i += 1;
              }
              catch (Exception localException2)
              {
                c.e("HardCoder.HardCoderMonitor", "integer parse error:" + localException2.getMessage());
                continue;
              }
            }
            catch (Exception localException1)
            {
              c.printErrStackTrace("HardCoder.HardCoderMonitor", localException1, "exception:", new Object[0]);
            }
            Object localObject6 = new TreeMap();
            this.eCp.addAll((Collection)localObject5);
            c.d("HardCoder.HardCoderMonitor", "get thread current stat,end:" + SystemClock.elapsedRealtime());
            if (i != 0) {
              break label587;
            }
            if (!this.eCp.isEmpty())
            {
              localObject5 = this.eCp.iterator();
              if (((Iterator)localObject5).hasNext())
              {
                i = ((Integer)((Iterator)localObject5).next()).intValue();
                localObject7 = g.jo(i);
                int j = g.jp(i);
                long l2 = g.jq(j);
                if (((Map)localObject6).containsKey(Integer.valueOf(i)))
                {
                  ((Map)localObject6).get(Integer.valueOf(i));
                  continue;
                  break;
                  label457:
                  i = 0;
                  continue;
                  label462:
                  c.e("HardCoder.HardCoderMonitor", "impossible as usual");
                  i = 1;
                  continue;
                }
                ((Map)localObject6).put(Integer.valueOf(i), new c(i, l1, j, l2, localException2));
                continue;
              }
              this.eCq.a(new b(l1, localException1, (Map)localObject6));
              try
              {
                wait(50L);
                break;
              }
              finally
              {
                AppMethodBeat.o(93928);
              }
            }
          }
          try
          {
            while (this.eCp.isEmpty()) {
              wait();
            }
          }
          finally
          {
            AppMethodBeat.o(93928);
          }
          break;
          try
          {
            label587:
            wait(60000L);
            c.i("HardCoder.HardCoderMonitor", "Monitor thread wait(pid/task error):60000");
            break;
          }
          finally
          {
            AppMethodBeat.o(93928);
          }
        }
        try
        {
          label621:
          wait(60000L);
          c.i("HardCoder.HardCoderMonitor", "Monitor thread wait(no in time):60000");
          break;
        }
        finally
        {
          AppMethodBeat.o(93928);
        }
      }
      AppMethodBeat.o(93928);
      return;
      label661:
      int i = 1;
    }
  }
  
  public static final class a
  {
    public final int eCx;
    public final long eCy;
    public final int eCz;
    public final long startTime;
    
    public a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
    {
      this.startTime = paramLong1;
      this.eCx = paramInt1;
      this.eCy = paramLong2;
      this.eCz = paramInt2;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(93924);
      String str = String.format("Cpu status,startTime:%s,coreId:%s,freq:%s,power:%s", new Object[] { Long.valueOf(this.startTime), Integer.valueOf(this.eCx), Long.valueOf(this.eCy), Integer.valueOf(this.eCz) });
      AppMethodBeat.o(93924);
      return str;
    }
  }
  
  public static final class b
  {
    public final Map<Integer, d.a> eCA;
    public final Map<Integer, d.c> eCB;
    public final long time;
    
    public b(long paramLong, Map<Integer, d.a> paramMap, Map<Integer, d.c> paramMap1)
    {
      this.time = paramLong;
      this.eCA = paramMap;
      this.eCB = paramMap1;
    }
  }
  
  public static final class c
  {
    public final int eCC;
    public final int eCD;
    public final long eCE;
    public long eCF;
    public final long[] eCa;
    public long eCc;
    public final long startTime;
    
    public c(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long[] paramArrayOfLong)
    {
      AppMethodBeat.i(93925);
      this.eCc = 0L;
      this.eCF = 0L;
      this.eCC = paramInt1;
      this.startTime = paramLong1;
      this.eCD = paramInt2;
      this.eCE = paramLong2;
      this.eCa = paramArrayOfLong;
      this.eCc = this.eCE;
      AppMethodBeat.o(93925);
    }
    
    public final void a(long paramLong, long[] paramArrayOfLong)
    {
      AppMethodBeat.i(93926);
      this.eCc = ((this.eCc + paramLong) / 2L);
      if (paramArrayOfLong != null)
      {
        this.eCF = (paramArrayOfLong[0] - this.eCa[0] + (paramArrayOfLong[1] - this.eCa[1]));
        c.d("HardCoder.HardCoderMonitor", "thread id:" + this.eCC + ",start jiffies:[" + this.eCa[0] + "," + this.eCa[1] + "], end jiffies:[" + paramArrayOfLong[0] + "," + paramArrayOfLong[1] + "]");
      }
      AppMethodBeat.o(93926);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(93927);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(String.format("Thread status,threadId:%s,startTime:%s,startCoreId:%s,startCoreFreq:%s", new Object[] { Integer.valueOf(this.eCC), Long.valueOf(this.startTime), Integer.valueOf(this.eCD), Long.valueOf(this.eCE) }));
      ((StringBuilder)localObject).append(String.format(",sumJiffies:%s", new Object[] { Long.valueOf(this.eCF) }));
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(93927);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.d
 * JD-Core Version:    0.7.0.1
 */