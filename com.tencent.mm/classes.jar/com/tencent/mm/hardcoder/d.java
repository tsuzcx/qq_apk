package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public final class d
  implements Runnable
{
  private l dEH;
  private Set<Integer> dEN;
  private j dEO;
  private long dEP;
  private long dEQ;
  
  public static Map<Integer, a> a(final long paramLong, l paraml)
  {
    TreeMap localTreeMap = new TreeMap();
    int j = Runtime.getRuntime().availableProcessors();
    final int i = 0;
    while (i < j)
    {
      File localFile = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
      if (localFile.exists()) {
        k.a(localFile.getAbsolutePath(), new k.a()
        {
          public final boolean fz(String paramAnonymousString)
          {
            long l = Long.parseLong(paramAnonymousString.trim());
            if (this.dER.dFq.containsKey(Integer.valueOf(i)))
            {
              paramAnonymousString = (Integer)((l.a)this.dER.dFq.get(Integer.valueOf(i))).dFw.get(Long.valueOf(l));
              if (paramAnonymousString == null) {}
            }
            for (int i = paramAnonymousString.intValue();; i = 0)
            {
              paramAnonymousString = new d.a(paramLong, i, l, i);
              this.dEU.put(Integer.valueOf(i), paramAnonymousString);
              if (HardCoderJNI.hcDebug) {
                c.d("HardCoder.Monitor", paramAnonymousString.toString());
              }
              return false;
            }
          }
        });
      }
      i += 1;
    }
    return localTreeMap;
  }
  
  protected final void finalize()
  {
    super.finalize();
    this.dEN = null;
    this.dEH = null;
    this.dEO = null;
  }
  
  public final void run()
  {
    if (!Thread.currentThread().isInterrupted()) {}
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            for (;;)
            {
              long l1;
              Object localObject6;
              try
              {
                l1 = System.currentTimeMillis();
                if ((l1 < this.dEP) || (l1 > this.dEQ)) {
                  break label657;
                }
                if (HardCoderJNI.hcDebug) {
                  c.d("HardCoder.Monitor", "get cpu current freq,begin:" + SystemClock.elapsedRealtime());
                }
                Map localMap = a(l1, this.dEH);
                if (HardCoderJNI.hcDebug) {
                  c.d("HardCoder.Monitor", "get cpu current freq,end:" + SystemClock.elapsedRealtime());
                }
                localObject6 = new HashSet();
                localObject7 = new File("/proc/" + Process.myPid() + "/task");
                if (!((File)localObject7).isDirectory()) {
                  break label488;
                }
                localObject7 = ((File)localObject7).listFiles();
                if (localObject7 == null) {
                  break label686;
                }
                if (localObject7.length != 0) {
                  continue;
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                c.e("HardCoder.Monitor", "Monitor thread need to interrupt:" + localInterruptedException.getMessage());
                Thread.currentThread().interrupt();
                return;
                if (!HardCoderJNI.hcDebug) {
                  continue;
                }
                c.i("HardCoder.Monitor", "thread size:" + localObject7.length);
                j = localObject7.length;
                i = 0;
                if (i >= j) {
                  break label483;
                }
                Object localObject8 = localObject7[i].getName();
                try
                {
                  ((Set)localObject6).add(Integer.valueOf(Integer.parseInt((String)localObject8, 0)));
                  i += 1;
                }
                catch (Exception localException2)
                {
                  c.e("HardCoder.Monitor", "integer parse error:" + localException2.getMessage());
                  continue;
                }
              }
              catch (Exception localException1)
              {
                c.e("HardCoder.Monitor", "exception:" + localException1.getMessage());
              }
              Object localObject7 = new TreeMap();
              this.dEN.addAll((Collection)localObject6);
              if (HardCoderJNI.hcDebug) {
                c.d("HardCoder.Monitor", "get thread current stat,end:" + SystemClock.elapsedRealtime());
              }
              if (i != 0) {
                break label628;
              }
              if (!this.dEN.isEmpty())
              {
                localObject6 = this.dEN.iterator();
                if (((Iterator)localObject6).hasNext())
                {
                  i = ((Integer)((Iterator)localObject6).next()).intValue();
                  localObject8 = HardCoderJNI.getThreadCpuJiffies(i);
                  int j = HardCoderJNI.getThreadCoreId(i);
                  long l2 = HardCoderJNI.getCpuFreqByCoreId(j);
                  if (((Map)localObject7).containsKey(Integer.valueOf(i)))
                  {
                    ((Map)localObject7).get(Integer.valueOf(i));
                    continue;
                    break;
                    label483:
                    i = 0;
                    continue;
                    label488:
                    c.e("HardCoder.Monitor", "impossible as usual");
                    i = 1;
                    continue;
                  }
                  ((Map)localObject7).put(Integer.valueOf(i), new c(i, l1, j, l2, localException2));
                  continue;
                }
                localObject6 = this.dEO;
                b localb = new b(l1, localException1, (Map)localObject7);
                if (((j)localObject6).dFi != null) {
                  ((j)localObject6).dFi.add(localb);
                }
                try
                {
                  for (;;)
                  {
                    localObject6.notify();
                    try
                    {
                      wait(50L);
                      break;
                    }
                    finally {}
                  }
                }
                finally {}
              }
            }
            try
            {
              wait();
              break;
            }
            finally {}
          }
          try
          {
            label628:
            wait(60000L);
            c.i("HardCoder.Monitor", "Monitor thread wait(pid/task error):60000");
            break;
          }
          finally {}
        }
        try
        {
          label657:
          wait(60000L);
          c.i("HardCoder.Monitor", "Monitor thread wait(no in time):60000");
          break;
        }
        finally {}
      }
      label686:
      int i = 1;
    }
  }
  
  public static final class a
  {
    public final int dEV;
    public final long dEW;
    public final int dEX;
    public final long startTime;
    
    public a(long paramLong1, int paramInt1, long paramLong2, int paramInt2)
    {
      this.startTime = paramLong1;
      this.dEV = paramInt1;
      this.dEW = paramLong2;
      this.dEX = paramInt2;
    }
    
    public final String toString()
    {
      return String.format("Cpu status,startTime:%s,coreId:%s,freq:%s,power:%s", new Object[] { Long.valueOf(this.startTime), Integer.valueOf(this.dEV), Long.valueOf(this.dEW), Integer.valueOf(this.dEX) });
    }
  }
  
  public static final class b
  {
    public final Map<Integer, d.a> dEY;
    public final Map<Integer, d.c> dEZ;
    public final long time;
    
    public b(long paramLong, Map<Integer, d.a> paramMap, Map<Integer, d.c> paramMap1)
    {
      this.time = paramLong;
      this.dEY = paramMap;
      this.dEZ = paramMap1;
    }
  }
  
  public static final class c
  {
    public final long[] dEx;
    public long dEz = 0L;
    public final int dFa;
    public final int dFb;
    public final long dFc;
    public long dFd = 0L;
    public final long startTime;
    
    public c(int paramInt1, long paramLong1, int paramInt2, long paramLong2, long[] paramArrayOfLong)
    {
      this.dFa = paramInt1;
      this.startTime = paramLong1;
      this.dFb = paramInt2;
      this.dFc = paramLong2;
      this.dEx = paramArrayOfLong;
      this.dEz = this.dFc;
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("Thread status,threadId:%s,startTime:%s,startCoreId:%s,startCoreFreq:%s", new Object[] { Integer.valueOf(this.dFa), Long.valueOf(this.startTime), Integer.valueOf(this.dFb), Long.valueOf(this.dFc) }));
      localStringBuilder.append(String.format(",sumJiffies:%s", new Object[] { Long.valueOf(this.dFd) }));
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.d
 * JD-Core Version:    0.7.0.1
 */