package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.e.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PassiveTimedConnectionMatcher
{
  private final long zzym;
  private final int zzyn;
  private final m<String, Long> zzyo;
  
  public PassiveTimedConnectionMatcher()
  {
    AppMethodBeat.i(89961);
    this.zzym = 60000L;
    this.zzyn = 10;
    this.zzyo = new m(10);
    AppMethodBeat.o(89961);
  }
  
  public PassiveTimedConnectionMatcher(int paramInt, long paramLong)
  {
    AppMethodBeat.i(89962);
    this.zzym = paramLong;
    this.zzyn = paramInt;
    this.zzyo = new m();
    AppMethodBeat.o(89962);
  }
  
  public Long get(String paramString)
  {
    AppMethodBeat.i(89963);
    try
    {
      paramString = (Long)this.zzyo.get(paramString);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(89963);
    }
  }
  
  public Long put(String paramString)
  {
    AppMethodBeat.i(89964);
    long l2 = SystemClock.elapsedRealtime();
    long l1 = this.zzym;
    for (;;)
    {
      int i;
      try
      {
        if (this.zzyo.size() >= this.zzyn)
        {
          i = this.zzyo.size() - 1;
          if (i >= 0)
          {
            if (l2 - ((Long)this.zzyo.valueAt(i)).longValue() > l1) {
              this.zzyo.removeAt(i);
            }
          }
          else
          {
            l1 /= 2L;
            i = this.zzyn;
            new StringBuilder(94).append("The max capacity ").append(i).append(" is not enough. Current durationThreshold is: ").append(l1);
          }
        }
        else
        {
          paramString = (Long)this.zzyo.put(paramString, Long.valueOf(l2));
          return paramString;
        }
      }
      finally
      {
        AppMethodBeat.o(89964);
      }
      i -= 1;
    }
  }
  
  /* Error */
  public boolean remove(String paramString)
  {
    // Byte code:
    //   0: ldc 100
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 34	com/google/android/gms/common/stats/PassiveTimedConnectionMatcher:zzyo	Landroid/support/v4/e/m;
    //   11: aload_1
    //   12: invokevirtual 102	android/support/v4/e/m:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: ifnull +14 -> 29
    //   18: iconst_1
    //   19: istore_2
    //   20: aload_0
    //   21: monitorexit
    //   22: ldc 100
    //   24: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iload_2
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_2
    //   31: goto -11 -> 20
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: ldc 100
    //   39: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	PassiveTimedConnectionMatcher
    //   0	44	1	paramString	String
    //   19	12	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	18	34	finally
    //   20	22	34	finally
    //   35	37	34	finally
  }
  
  public boolean removeByPrefix(String paramString)
  {
    AppMethodBeat.i(89966);
    int i = 0;
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (i < size())
        {
          String str = (String)this.zzyo.keyAt(i);
          if ((str != null) && (str.startsWith(paramString)))
          {
            this.zzyo.remove(str);
            bool = true;
          }
        }
        else
        {
          return bool;
        }
      }
      finally
      {
        AppMethodBeat.o(89966);
      }
      i += 1;
    }
  }
  
  public int size()
  {
    AppMethodBeat.i(89967);
    try
    {
      int i = this.zzyo.size();
      return i;
    }
    finally
    {
      AppMethodBeat.o(89967);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.stats.PassiveTimedConnectionMatcher
 * JD-Core Version:    0.7.0.1
 */