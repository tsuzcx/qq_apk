package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.e.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PassiveTimedConnectionMatcher
{
  private final long zzym;
  private final int zzyn;
  private final n<String, Long> zzyo;
  
  public PassiveTimedConnectionMatcher()
  {
    AppMethodBeat.i(4983);
    this.zzym = 60000L;
    this.zzyn = 10;
    this.zzyo = new n(10);
    AppMethodBeat.o(4983);
  }
  
  public PassiveTimedConnectionMatcher(int paramInt, long paramLong)
  {
    AppMethodBeat.i(4984);
    this.zzym = paramLong;
    this.zzyn = paramInt;
    this.zzyo = new n();
    AppMethodBeat.o(4984);
  }
  
  public Long get(String paramString)
  {
    AppMethodBeat.i(4985);
    try
    {
      paramString = (Long)this.zzyo.get(paramString);
      return paramString;
    }
    finally
    {
      AppMethodBeat.o(4985);
    }
  }
  
  public Long put(String paramString)
  {
    AppMethodBeat.i(4986);
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
        AppMethodBeat.o(4986);
      }
      i -= 1;
    }
  }
  
  /* Error */
  public boolean remove(String paramString)
  {
    // Byte code:
    //   0: sipush 4987
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_0
    //   9: getfield 33	com/google/android/gms/common/stats/PassiveTimedConnectionMatcher:zzyo	Landroid/support/v4/e/n;
    //   12: aload_1
    //   13: invokevirtual 97	android/support/v4/e/n:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   16: ifnull +15 -> 31
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: sipush 4987
    //   26: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: iload_2
    //   30: ireturn
    //   31: iconst_0
    //   32: istore_2
    //   33: goto -12 -> 21
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: sipush 4987
    //   42: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	PassiveTimedConnectionMatcher
    //   0	47	1	paramString	String
    //   20	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   8	19	36	finally
    //   21	23	36	finally
    //   37	39	36	finally
  }
  
  public boolean removeByPrefix(String paramString)
  {
    AppMethodBeat.i(4988);
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
        AppMethodBeat.o(4988);
      }
      i += 1;
    }
  }
  
  public int size()
  {
    AppMethodBeat.i(4989);
    try
    {
      int i = this.zzyo.size();
      return i;
    }
    finally
    {
      AppMethodBeat.o(4989);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.stats.PassiveTimedConnectionMatcher
 * JD-Core Version:    0.7.0.1
 */