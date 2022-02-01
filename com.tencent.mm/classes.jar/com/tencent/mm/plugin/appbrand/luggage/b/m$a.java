package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;

final class m$a
  implements m<IPCVoid, IPCBoolean>
{
  /* Error */
  private static IPCBoolean bEi()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 20
    //   4: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 28
    //   9: ldc 30
    //   11: invokestatic 35	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: ldc 37
    //   16: invokestatic 43	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   19: invokevirtual 49	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   22: ldc 50
    //   24: aconst_null
    //   25: invokevirtual 56	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 58	java/lang/String
    //   31: invokevirtual 62	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   34: istore_1
    //   35: ldc 28
    //   37: ldc 64
    //   39: iconst_1
    //   40: anewarray 5	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: iload_1
    //   46: invokestatic 70	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   49: aastore
    //   50: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: iload_1
    //   54: ifne +19 -> 73
    //   57: new 75	com/tencent/mm/ipcinvoker/type/IPCBoolean
    //   60: dup
    //   61: iload_0
    //   62: invokespecial 78	com/tencent/mm/ipcinvoker/type/IPCBoolean:<init>	(Z)V
    //   65: astore_2
    //   66: ldc 20
    //   68: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_2
    //   72: areturn
    //   73: iconst_0
    //   74: istore_0
    //   75: goto -18 -> 57
    //   78: astore_2
    //   79: ldc 28
    //   81: aload_2
    //   82: ldc 83
    //   84: iconst_0
    //   85: anewarray 5	java/lang/Object
    //   88: invokestatic 87	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: new 75	com/tencent/mm/ipcinvoker/type/IPCBoolean
    //   94: dup
    //   95: iconst_0
    //   96: invokespecial 78	com/tencent/mm/ipcinvoker/type/IPCBoolean:<init>	(Z)V
    //   99: astore_2
    //   100: ldc 20
    //   102: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	74	0	bool1	boolean
    //   34	20	1	bool2	boolean
    //   65	7	2	localIPCBoolean1	IPCBoolean
    //   78	4	2	localException	java.lang.Exception
    //   99	7	2	localIPCBoolean2	IPCBoolean
    // Exception table:
    //   from	to	target	type
    //   7	53	78	java/lang/Exception
    //   57	66	78	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.m.a
 * JD-Core Version:    0.7.0.1
 */