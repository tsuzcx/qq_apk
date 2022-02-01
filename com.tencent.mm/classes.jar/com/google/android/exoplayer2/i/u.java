package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class u
{
  public long aZM;
  private long brm;
  public volatile long brn;
  
  public u(long paramLong)
  {
    AppMethodBeat.i(93205);
    this.brn = -9223372036854775807L;
    ar(paramLong);
    AppMethodBeat.o(93205);
  }
  
  public static long au(long paramLong)
  {
    return 1000000L * paramLong / 90000L;
  }
  
  public static long av(long paramLong)
  {
    return 90000L * paramLong / 1000000L;
  }
  
  /* Error */
  public final void ar(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 39
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 24	com/google/android/exoplayer2/i/u:brn	J
    //   11: ldc2_w 21
    //   14: lcmp
    //   15: ifne +22 -> 37
    //   18: iconst_1
    //   19: istore_3
    //   20: iload_3
    //   21: invokestatic 45	com/google/android/exoplayer2/i/a:checkState	(Z)V
    //   24: aload_0
    //   25: lload_1
    //   26: putfield 47	com/google/android/exoplayer2/i/u:aZM	J
    //   29: ldc 39
    //   31: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: iconst_0
    //   38: istore_3
    //   39: goto -19 -> 20
    //   42: astore 4
    //   44: aload_0
    //   45: monitorexit
    //   46: aload 4
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	u
    //   0	49	1	paramLong	long
    //   19	20	3	bool	boolean
    //   42	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	42	finally
    //   20	34	42	finally
  }
  
  public final long as(long paramLong)
  {
    AppMethodBeat.i(93207);
    if (paramLong == -9223372036854775807L)
    {
      AppMethodBeat.o(93207);
      return -9223372036854775807L;
    }
    if (this.brn != -9223372036854775807L)
    {
      long l2 = av(this.brn);
      long l3 = (4294967296L + l2) / 8589934592L;
      long l1 = (l3 - 1L) * 8589934592L + paramLong;
      paramLong = l3 * 8589934592L + paramLong;
      if (Math.abs(l1 - l2) < Math.abs(paramLong - l2)) {
        paramLong = l1;
      }
    }
    for (;;)
    {
      paramLong = at(au(paramLong));
      AppMethodBeat.o(93207);
      return paramLong;
    }
  }
  
  public final long at(long paramLong)
  {
    AppMethodBeat.i(93208);
    if (paramLong == -9223372036854775807L)
    {
      AppMethodBeat.o(93208);
      return -9223372036854775807L;
    }
    if (this.brn != -9223372036854775807L) {
      this.brn = paramLong;
    }
    for (;;)
    {
      long l = this.brm;
      AppMethodBeat.o(93208);
      return l + paramLong;
      if (this.aZM != 9223372036854775807L) {
        this.brm = (this.aZM - paramLong);
      }
      try
      {
        this.brn = paramLong;
        notifyAll();
      }
      finally
      {
        localObject = finally;
        AppMethodBeat.o(93208);
        throw localObject;
      }
    }
  }
  
  public final long vv()
  {
    long l = -9223372036854775807L;
    if (this.aZM == 9223372036854775807L) {
      l = 0L;
    }
    while (this.brn == -9223372036854775807L) {
      return l;
    }
    return this.brm;
  }
  
  public final void vw()
  {
    try
    {
      AppMethodBeat.i(93209);
      while (this.brn == -9223372036854775807L) {
        wait();
      }
      AppMethodBeat.o(93209);
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i.u
 * JD-Core Version:    0.7.0.1
 */