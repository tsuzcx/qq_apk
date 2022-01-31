package com.tencent.mm.plugin.clean.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.HashSet;

public final class b
  implements c
{
  public HashMap<Long, ak> kHi;
  private HashSet<Long> kHj;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    AppMethodBeat.i(18727);
    this.kHj = new HashSet(5);
    this.kHi = new HashMap(5);
    paramByte = 0;
    while (paramByte <= 5)
    {
      d.a(new b.1(this), "ThreadController_handler", 1).start();
      paramByte += 1;
    }
    AppMethodBeat.o(18727);
  }
  
  private void e(Long paramLong)
  {
    try
    {
      AppMethodBeat.i(18729);
      if (this.kHj.remove(paramLong)) {
        ab.d("MicroMsg.ThreadController", "thread is idle, id=%d", new Object[] { paramLong });
      }
      AppMethodBeat.o(18729);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean b(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 18728
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: aload_0
    //   10: putfield 82	com/tencent/mm/plugin/clean/c/a/a:kHh	Lcom/tencent/mm/plugin/clean/c/a/c;
    //   13: ldc 66
    //   15: ldc 84
    //   17: iconst_1
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: aload_0
    //   24: getfield 32	com/tencent/mm/plugin/clean/c/a/b:kHj	Ljava/util/HashSet;
    //   27: invokevirtual 88	java/util/HashSet:toString	()Ljava/lang/String;
    //   30: aastore
    //   31: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 37	com/tencent/mm/plugin/clean/c/a/b:kHi	Ljava/util/HashMap;
    //   38: invokevirtual 92	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   41: invokeinterface 98 1 0
    //   46: astore_3
    //   47: aload_3
    //   48: invokeinterface 104 1 0
    //   53: ifeq +73 -> 126
    //   56: aload_3
    //   57: invokeinterface 108 1 0
    //   62: checkcast 110	java/util/Map$Entry
    //   65: astore 4
    //   67: aload_0
    //   68: getfield 32	com/tencent/mm/plugin/clean/c/a/b:kHj	Ljava/util/HashSet;
    //   71: aload 4
    //   73: invokeinterface 113 1 0
    //   78: invokevirtual 116	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   81: ifne -34 -> 47
    //   84: aload 4
    //   86: invokeinterface 119 1 0
    //   91: checkcast 121	com/tencent/mm/sdk/platformtools/ak
    //   94: aload_1
    //   95: invokevirtual 125	com/tencent/mm/sdk/platformtools/ak:post	(Ljava/lang/Runnable;)Z
    //   98: pop
    //   99: aload_0
    //   100: getfield 32	com/tencent/mm/plugin/clean/c/a/b:kHj	Ljava/util/HashSet;
    //   103: aload 4
    //   105: invokeinterface 113 1 0
    //   110: invokevirtual 128	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: sipush 18728
    //   117: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: iconst_1
    //   121: istore_2
    //   122: aload_0
    //   123: monitorexit
    //   124: iload_2
    //   125: ireturn
    //   126: sipush 18728
    //   129: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: iconst_0
    //   133: istore_2
    //   134: goto -12 -> 122
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	b
    //   0	142	1	parama	a
    //   121	13	2	bool	boolean
    //   46	11	3	localIterator	java.util.Iterator
    //   65	39	4	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   2	47	137	finally
    //   47	120	137	finally
    //   126	132	137	finally
  }
  
  public final void f(Long paramLong)
  {
    AppMethodBeat.i(18730);
    e(paramLong);
    AppMethodBeat.o(18730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.c.a.b
 * JD-Core Version:    0.7.0.1
 */