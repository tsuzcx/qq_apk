package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandEncryptKVStorageTransferABTest;", "", "()V", "PHASES_FINISH", "", "PHASES_NONE", "PHASES_ROLLBACK", "PHASES_TEST", "TAG", "", "isNeedTransfer", "", "phases", "isFinishPhases", "isRollbackPhases", "load", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b qLK;
  private static volatile boolean qLL;
  private static volatile int qLM;
  
  static
  {
    AppMethodBeat.i(323132);
    b localb = new b();
    qLK = localb;
    localb.Td();
    AppMethodBeat.o(323132);
  }
  
  /* Error */
  private void Td()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 56
    //   4: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: ldc 58
    //   9: ldc 60
    //   11: invokestatic 65	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: ldc 67
    //   16: invokestatic 73	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   19: checkcast 67	com/tencent/mm/plugin/expt/b/c
    //   22: getstatic 79	com/tencent/mm/plugin/expt/b/c$a:zxg	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   25: iconst_0
    //   26: invokeinterface 83 3 0
    //   31: istore_1
    //   32: iload_1
    //   33: putstatic 85	com/tencent/mm/plugin/appbrand/appstorage/b:qLM	I
    //   36: iload_1
    //   37: ifeq +51 -> 88
    //   40: iconst_1
    //   41: istore_2
    //   42: iload_2
    //   43: putstatic 87	com/tencent/mm/plugin/appbrand/appstorage/b:qLL	Z
    //   46: ldc 58
    //   48: new 89	java/lang/StringBuilder
    //   51: dup
    //   52: ldc 91
    //   54: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: getstatic 87	com/tencent/mm/plugin/appbrand/appstorage/b:qLL	Z
    //   60: invokevirtual 98	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   63: ldc 100
    //   65: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: getstatic 85	com/tencent/mm/plugin/appbrand/appstorage/b:qLM	I
    //   71: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 65	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc 56
    //   82: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: iconst_0
    //   89: istore_2
    //   90: goto -48 -> 42
    //   93: astore_3
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_3
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	b
    //   31	6	1	i	int
    //   41	49	2	bool	boolean
    //   93	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	93	finally
    //   42	85	93	finally
  }
  
  /* Error */
  public final boolean chR()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 85	com/tencent/mm/plugin/appbrand/appstorage/b:qLM	I
    //   5: istore_1
    //   6: iload_1
    //   7: iconst_3
    //   8: if_icmpne +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	b
    //   5	4	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	22	finally
  }
  
  /* Error */
  public final boolean chS()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 85	com/tencent/mm/plugin/appbrand/appstorage/b:qLM	I
    //   5: istore_1
    //   6: iload_1
    //   7: iconst_2
    //   8: if_icmpne +9 -> 17
    //   11: iconst_1
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_2
    //   19: goto -6 -> 13
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	b
    //   5	4	1	i	int
    //   12	7	2	bool	boolean
    //   22	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	22	finally
  }
  
  public final boolean chT()
  {
    try
    {
      boolean bool = qLL;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b
 * JD-Core Version:    0.7.0.1
 */