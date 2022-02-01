package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  private boolean Tz;
  
  public final void block()
  {
    try
    {
      AppMethodBeat.i(93134);
      while (!this.Tz) {
        wait();
      }
      AppMethodBeat.o(93134);
    }
    finally {}
  }
  
  public final boolean close()
  {
    try
    {
      boolean bool = this.Tz;
      this.Tz = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean open()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 31
    //   6: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 21	com/google/android/exoplayer2/i/f:Tz	Z
    //   13: ifeq +14 -> 27
    //   16: iconst_0
    //   17: istore_1
    //   18: ldc 31
    //   20: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 21	com/google/android/exoplayer2/i/f:Tz	Z
    //   32: aload_0
    //   33: invokevirtual 34	java/lang/Object:notifyAll	()V
    //   36: ldc 31
    //   38: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: goto -18 -> 23
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	f
    //   1	25	1	bool	boolean
    //   44	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	16	44	finally
    //   18	23	44	finally
    //   27	41	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.f
 * JD-Core Version:    0.7.0.1
 */