package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.b;
import java.util.ArrayList;

public class a
{
  private static a ddl;
  private ArrayList<b> ddm;
  
  private a()
  {
    AppMethodBeat.i(136727);
    this.ddm = new ArrayList();
    AppMethodBeat.o(136727);
  }
  
  public static a Ok()
  {
    AppMethodBeat.i(136728);
    if (ddl == null) {}
    try
    {
      if (ddl == null) {
        ddl = new a();
      }
      a locala = ddl;
      AppMethodBeat.o(136728);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(136728);
    }
  }
  
  /* Error */
  public final b Ol()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 38
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mm/audio/mix/b/a:ddm	Ljava/util/ArrayList;
    //   11: invokevirtual 42	java/util/ArrayList:size	()I
    //   14: ifle +32 -> 46
    //   17: aload_0
    //   18: getfield 25	com/tencent/mm/audio/mix/b/a:ddm	Ljava/util/ArrayList;
    //   21: aload_0
    //   22: getfield 25	com/tencent/mm/audio/mix/b/a:ddm	Ljava/util/ArrayList;
    //   25: invokevirtual 42	java/util/ArrayList:size	()I
    //   28: iconst_1
    //   29: isub
    //   30: invokevirtual 46	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   33: checkcast 48	com/tencent/mm/audio/mix/a/b
    //   36: astore_1
    //   37: ldc 38
    //   39: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: new 48	com/tencent/mm/audio/mix/a/b
    //   49: dup
    //   50: invokespecial 49	com/tencent/mm/audio/mix/a/b:<init>	()V
    //   53: astore_1
    //   54: ldc 38
    //   56: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: goto -17 -> 42
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	a
    //   36	18	1	localb	b
    //   62	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	42	62	finally
    //   46	59	62	finally
  }
  
  /* Error */
  public final void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 52
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: aload_1
    //   12: getfield 56	com/tencent/mm/audio/mix/a/b:dcZ	[B
    //   15: ifnonnull +11 -> 26
    //   18: ldc 52
    //   20: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_1
    //   27: iconst_0
    //   28: putfield 60	com/tencent/mm/audio/mix/a/b:channels	I
    //   31: aload_1
    //   32: iconst_0
    //   33: putfield 63	com/tencent/mm/audio/mix/a/b:sampleRate	I
    //   36: aload_1
    //   37: getfield 67	com/tencent/mm/audio/mix/a/b:dda	Ljava/util/LinkedList;
    //   40: invokevirtual 72	java/util/LinkedList:clear	()V
    //   43: aload_1
    //   44: getfield 56	com/tencent/mm/audio/mix/a/b:dcZ	[B
    //   47: iconst_0
    //   48: aload_1
    //   49: getfield 56	com/tencent/mm/audio/mix/a/b:dcZ	[B
    //   52: arraylength
    //   53: iconst_0
    //   54: invokestatic 78	java/util/Arrays:fill	([BIIB)V
    //   57: aload_0
    //   58: getfield 25	com/tencent/mm/audio/mix/b/a:ddm	Ljava/util/ArrayList;
    //   61: iconst_0
    //   62: aload_1
    //   63: invokevirtual 82	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   66: ldc 52
    //   68: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: goto -48 -> 23
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   0	79	1	paramb	b
    // Exception table:
    //   from	to	target	type
    //   2	7	74	finally
    //   11	18	74	finally
    //   18	23	74	finally
    //   26	71	74	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.b.a
 * JD-Core Version:    0.7.0.1
 */