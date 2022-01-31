package com.tencent.mm.network;

import java.util.HashMap;

public final class ae
{
  private static ae ePg = null;
  private HashMap<Integer, ae.a> ePh = new HashMap();
  
  public static ae UB()
  {
    try
    {
      if (ePg == null) {
        ePg = new ae();
      }
      ae localae = ePg;
      return localae;
    }
    finally {}
  }
  
  /* Error */
  public final int i(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/mm/network/ae:ePh	Ljava/util/HashMap;
    //   6: iload_1
    //   7: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: invokevirtual 39	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 6	com/tencent/mm/network/ae$a
    //   16: astore 4
    //   18: aload_2
    //   19: ifnonnull +95 -> 114
    //   22: iconst_m1
    //   23: istore_3
    //   24: ldc 41
    //   26: ldc 43
    //   28: iconst_4
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: iload_1
    //   35: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload 4
    //   43: aastore
    //   44: dup
    //   45: iconst_2
    //   46: iload_3
    //   47: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: aastore
    //   51: dup
    //   52: iconst_3
    //   53: invokestatic 49	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   56: aastore
    //   57: invokestatic 54	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload 4
    //   62: ifnonnull +64 -> 126
    //   65: aload_2
    //   66: ifnonnull +54 -> 120
    //   69: iconst_m1
    //   70: istore_3
    //   71: ldc 41
    //   73: ldc 56
    //   75: iconst_4
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: iload_1
    //   82: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   85: aastore
    //   86: dup
    //   87: iconst_1
    //   88: aload 4
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: iload_3
    //   94: invokestatic 35	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: dup
    //   99: iconst_3
    //   100: invokestatic 49	com/tencent/mm/sdk/platformtools/bk:csb	()Lcom/tencent/mm/sdk/platformtools/ak;
    //   103: aastore
    //   104: invokestatic 59	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: bipush 253
    //   109: istore_1
    //   110: aload_0
    //   111: monitorexit
    //   112: iload_1
    //   113: ireturn
    //   114: aload_2
    //   115: arraylength
    //   116: istore_3
    //   117: goto -93 -> 24
    //   120: aload_2
    //   121: arraylength
    //   122: istore_3
    //   123: goto -52 -> 71
    //   126: aload 4
    //   128: invokeinterface 63 1 0
    //   133: istore_1
    //   134: goto -24 -> 110
    //   137: astore_2
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	ae
    //   0	142	1	paramInt	int
    //   0	142	2	paramArrayOfByte	byte[]
    //   23	100	3	i	int
    //   16	111	4	locala	ae.a
    // Exception table:
    //   from	to	target	type
    //   2	18	137	finally
    //   24	60	137	finally
    //   71	107	137	finally
    //   114	117	137	finally
    //   120	123	137	finally
    //   126	134	137	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.network.ae
 * JD-Core Version:    0.7.0.1
 */