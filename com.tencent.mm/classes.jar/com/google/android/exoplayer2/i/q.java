package com.google.android.exoplayer2.i;

public final class q
{
  public long aDd;
  private long aSQ;
  public volatile long aSR = -9223372036854775807L;
  
  public q(long paramLong)
  {
    V(paramLong);
  }
  
  public static long Y(long paramLong)
  {
    return 1000000L * paramLong / 90000L;
  }
  
  public static long Z(long paramLong)
  {
    return 90000L * paramLong / 1000000L;
  }
  
  /* Error */
  public final void V(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/google/android/exoplayer2/i/q:aSR	J
    //   6: ldc2_w 14
    //   9: lcmp
    //   10: ifne +17 -> 27
    //   13: iconst_1
    //   14: istore_3
    //   15: iload_3
    //   16: invokestatic 34	com/google/android/exoplayer2/i/a:aC	(Z)V
    //   19: aload_0
    //   20: lload_1
    //   21: putfield 36	com/google/android/exoplayer2/i/q:aDd	J
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: iconst_0
    //   28: istore_3
    //   29: goto -14 -> 15
    //   32: astore 4
    //   34: aload_0
    //   35: monitorexit
    //   36: aload 4
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	q
    //   0	39	1	paramLong	long
    //   14	15	3	bool	boolean
    //   32	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	32	finally
    //   15	24	32	finally
  }
  
  public final long W(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    if (this.aSR != -9223372036854775807L)
    {
      long l2 = Z(this.aSR);
      long l3 = (4294967296L + l2) / 8589934592L;
      long l1 = (l3 - 1L) * 8589934592L + paramLong;
      paramLong = l3 * 8589934592L + paramLong;
      if (Math.abs(l1 - l2) < Math.abs(paramLong - l2)) {
        paramLong = l1;
      }
    }
    for (;;)
    {
      return X(Y(paramLong));
    }
  }
  
  public final long X(long paramLong)
  {
    if (paramLong == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    if (this.aSR != -9223372036854775807L) {
      this.aSR = paramLong;
    }
    for (;;)
    {
      return this.aSQ + paramLong;
      if (this.aDd != 9223372036854775807L) {
        this.aSQ = (this.aDd - paramLong);
      }
      try
      {
        this.aSR = paramLong;
        notifyAll();
      }
      finally {}
    }
  }
  
  public final long op()
  {
    long l = -9223372036854775807L;
    if (this.aDd == 9223372036854775807L) {
      l = 0L;
    }
    while (this.aSR == -9223372036854775807L) {
      return l;
    }
    return this.aSQ;
  }
  
  public final void oq()
  {
    try
    {
      if (this.aSR == -9223372036854775807L) {
        wait();
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.i.q
 * JD-Core Version:    0.7.0.1
 */