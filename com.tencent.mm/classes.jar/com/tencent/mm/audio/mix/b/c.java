package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import java.util.ArrayList;

public class c
{
  private static c fmR;
  private volatile int count;
  public volatile ArrayList<com.tencent.mm.audio.mix.a.c> fmS;
  private long fmT;
  
  private c()
  {
    AppMethodBeat.i(182541);
    this.fmS = new ArrayList();
    this.fmT = 50L;
    this.count = 0;
    AppMethodBeat.o(182541);
  }
  
  public static c adm()
  {
    AppMethodBeat.i(182542);
    if (fmR == null) {}
    try
    {
      if (fmR == null) {
        fmR = new c();
      }
      c localc = fmR;
      AppMethodBeat.o(182542);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(182542);
    }
  }
  
  /* Error */
  public final void a(com.tencent.mm.audio.mix.a.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 48
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: aload_1
    //   12: getfield 54	com/tencent/mm/audio/mix/a/c:fmy	[B
    //   15: ifnonnull +11 -> 26
    //   18: ldc 48
    //   20: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_1
    //   27: iconst_0
    //   28: putfield 57	com/tencent/mm/audio/mix/a/c:channels	I
    //   31: aload_1
    //   32: iconst_0
    //   33: putfield 60	com/tencent/mm/audio/mix/a/c:sampleRate	I
    //   36: aload_1
    //   37: getfield 64	com/tencent/mm/audio/mix/a/c:fmz	Ljava/util/LinkedList;
    //   40: invokevirtual 69	java/util/LinkedList:clear	()V
    //   43: aload_1
    //   44: getfield 54	com/tencent/mm/audio/mix/a/c:fmy	[B
    //   47: iconst_0
    //   48: aload_1
    //   49: getfield 54	com/tencent/mm/audio/mix/a/c:fmy	[B
    //   52: arraylength
    //   53: iconst_0
    //   54: invokestatic 75	java/util/Arrays:fill	([BIIB)V
    //   57: aload_0
    //   58: getfield 29	com/tencent/mm/audio/mix/b/c:fmS	Ljava/util/ArrayList;
    //   61: iconst_0
    //   62: aload_1
    //   63: invokevirtual 79	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   66: aload_0
    //   67: aload_0
    //   68: getfield 35	com/tencent/mm/audio/mix/b/c:count	I
    //   71: iconst_1
    //   72: isub
    //   73: putfield 35	com/tencent/mm/audio/mix/b/c:count	I
    //   76: ldc 48
    //   78: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: goto -58 -> 23
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	c
    //   0	89	1	paramc	com.tencent.mm.audio.mix.a.c
    // Exception table:
    //   from	to	target	type
    //   2	7	84	finally
    //   11	18	84	finally
    //   18	23	84	finally
    //   26	81	84	finally
  }
  
  public final com.tencent.mm.audio.mix.a.c adn()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(182543);
        com.tencent.mm.audio.mix.a.c localc1;
        if (this.fmS.size() > 0)
        {
          localc1 = (com.tencent.mm.audio.mix.a.c)this.fmS.remove(this.fmS.size() - 1);
          AppMethodBeat.o(182543);
          return localc1;
        }
        if (this.count >= this.fmT)
        {
          b.e("MicroMsg.Mix.AudioOutputMixBufferPool", "size >= FIX_SIZE, size:%d", new Object[] { Integer.valueOf(this.count) });
          localc1 = null;
          AppMethodBeat.o(182543);
          continue;
        }
        this.count += 1;
      }
      finally {}
      com.tencent.mm.audio.mix.a.c localc2 = new com.tencent.mm.audio.mix.a.c();
      AppMethodBeat.o(182543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.c
 * JD-Core Version:    0.7.0.1
 */