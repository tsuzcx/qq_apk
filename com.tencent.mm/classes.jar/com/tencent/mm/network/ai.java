package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class ai
{
  private static ai iGD = null;
  private HashMap<Integer, a> iGE;
  
  public ai()
  {
    AppMethodBeat.i(132943);
    this.iGE = new HashMap();
    AppMethodBeat.o(132943);
  }
  
  public static ai aPs()
  {
    try
    {
      AppMethodBeat.i(132944);
      if (iGD == null) {
        iGD = new ai();
      }
      ai localai = iGD;
      AppMethodBeat.o(132944);
      return localai;
    }
    finally {}
  }
  
  /* Error */
  public final int k(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 42
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 32	com/tencent/mm/network/ai:iGE	Ljava/util/HashMap;
    //   11: iload_1
    //   12: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: invokevirtual 52	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   18: checkcast 6	com/tencent/mm/network/ai$a
    //   21: astore 4
    //   23: aload_2
    //   24: ifnonnull +100 -> 124
    //   27: iconst_m1
    //   28: istore_3
    //   29: ldc 54
    //   31: ldc 56
    //   33: iconst_4
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: iload_1
    //   40: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload 4
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: iload_3
    //   52: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_3
    //   58: invokestatic 62	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
    //   61: aastore
    //   62: invokestatic 67	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload 4
    //   67: ifnonnull +69 -> 136
    //   70: aload_2
    //   71: ifnonnull +59 -> 130
    //   74: iconst_m1
    //   75: istore_3
    //   76: ldc 54
    //   78: ldc 69
    //   80: iconst_4
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: iload_1
    //   87: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: aload 4
    //   95: aastore
    //   96: dup
    //   97: iconst_2
    //   98: iload_3
    //   99: invokestatic 48	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: invokestatic 62	com/tencent/mm/sdk/platformtools/bt:flS	()Lcom/tencent/mm/sdk/platformtools/at;
    //   108: aastore
    //   109: invokestatic 72	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: bipush 253
    //   114: istore_1
    //   115: ldc 42
    //   117: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aload_0
    //   121: monitorexit
    //   122: iload_1
    //   123: ireturn
    //   124: aload_2
    //   125: arraylength
    //   126: istore_3
    //   127: goto -98 -> 29
    //   130: aload_2
    //   131: arraylength
    //   132: istore_3
    //   133: goto -57 -> 76
    //   136: aload 4
    //   138: invokeinterface 76 1 0
    //   143: istore_1
    //   144: ldc 42
    //   146: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: goto -29 -> 120
    //   152: astore_2
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ai
    //   0	157	1	paramInt	int
    //   0	157	2	paramArrayOfByte	byte[]
    //   28	105	3	i	int
    //   21	116	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	23	152	finally
    //   29	65	152	finally
    //   76	112	152	finally
    //   115	120	152	finally
    //   124	127	152	finally
    //   130	133	152	finally
    //   136	149	152	finally
  }
  
  public static abstract interface a
  {
    public abstract int aPt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.network.ai
 * JD-Core Version:    0.7.0.1
 */