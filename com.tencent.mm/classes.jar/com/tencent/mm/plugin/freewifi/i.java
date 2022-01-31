package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i
{
  private b mIo;
  
  private i()
  {
    AppMethodBeat.i(20600);
    this.mIo = j.bAL();
    AppMethodBeat.o(20600);
  }
  
  public final void V(String paramString, long paramLong)
  {
    try
    {
      AppMethodBeat.i(20603);
      this.mIo.ex(paramString, String.valueOf(paramLong));
      AppMethodBeat.o(20603);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void cl(String paramString, int paramInt)
  {
    try
    {
      AppMethodBeat.i(20604);
      this.mIo.ex(paramString, String.valueOf(paramInt));
      AppMethodBeat.o(20604);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final int getInt(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 20602
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   12: ifeq +13 -> 25
    //   15: sipush 20602
    //   18: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 26	com/tencent/mm/plugin/freewifi/i:mIo	Lcom/tencent/mm/plugin/freewifi/g/b;
    //   29: aload_1
    //   30: invokevirtual 65	com/tencent/mm/plugin/freewifi/g/b:OI	(Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   38: istore 4
    //   40: iload 4
    //   42: ifeq +17 -> 59
    //   45: sipush 20602
    //   48: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    //   59: aload_1
    //   60: invokestatic 70	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   63: invokevirtual 74	java/lang/Integer:intValue	()I
    //   66: istore_3
    //   67: iload_3
    //   68: istore_2
    //   69: sipush 20602
    //   72: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: goto -54 -> 21
    //   78: astore_1
    //   79: sipush 20602
    //   82: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: goto -64 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	i
    //   0	88	1	paramString	String
    //   0	88	2	paramInt	int
    //   66	2	3	i	int
    //   38	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	54	finally
    //   25	40	54	finally
    //   45	51	54	finally
    //   59	67	54	finally
    //   69	75	54	finally
    //   79	85	54	finally
    //   25	40	78	java/lang/Exception
    //   59	67	78	java/lang/Exception
  }
  
  /* Error */
  public final long lU(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: sipush 20601
    //   7: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_1
    //   11: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   14: ifeq +13 -> 27
    //   17: sipush 20601
    //   20: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aload_0
    //   24: monitorexit
    //   25: lload_2
    //   26: lreturn
    //   27: aload_0
    //   28: getfield 26	com/tencent/mm/plugin/freewifi/i:mIo	Lcom/tencent/mm/plugin/freewifi/g/b;
    //   31: aload_1
    //   32: invokevirtual 65	com/tencent/mm/plugin/freewifi/g/b:OI	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_1
    //   36: aload_1
    //   37: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   40: istore 6
    //   42: iload 6
    //   44: ifeq +17 -> 61
    //   47: sipush 20601
    //   50: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: goto -30 -> 23
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    //   61: aload_1
    //   62: invokestatic 81	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   65: invokevirtual 85	java/lang/Long:longValue	()J
    //   68: lstore 4
    //   70: lload 4
    //   72: lstore_2
    //   73: sipush 20601
    //   76: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -56 -> 23
    //   82: astore_1
    //   83: sipush 20601
    //   86: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   89: goto -66 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	i
    //   0	92	1	paramString	String
    //   1	72	2	l1	long
    //   68	3	4	l2	long
    //   40	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	23	56	finally
    //   27	42	56	finally
    //   47	53	56	finally
    //   61	70	56	finally
    //   73	79	56	finally
    //   83	89	56	finally
    //   27	42	82	java/lang/Exception
    //   61	70	82	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.i
 * JD-Core Version:    0.7.0.1
 */