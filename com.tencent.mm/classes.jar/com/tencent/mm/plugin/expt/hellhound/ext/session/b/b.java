package com.tencent.mm.plugin.expt.hellhound.ext.session.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eyu;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static void a(eyu parameyu)
  {
    try
    {
      AppMethodBeat.i(122128);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mkv_k_hellsscld", parameyu.toByteArray());
        AppMethodBeat.o(122128);
      }
      catch (Exception parameyu)
      {
        for (;;)
        {
          Log.printErrStackTrace("HABBYGE-MALI.HellSessionCloudConfigDao", parameyu, "HellSessionCloudConfigDao writeBack", new Object[0]);
          AppMethodBeat.o(122128);
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static eyu dLU()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 48
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 17
    //   10: invokestatic 52	com/tencent/mm/plugin/expt/hellhound/core/a/b:ard	(Ljava/lang/String;)[B
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +8 -> 23
    //   18: aload_1
    //   19: arraylength
    //   20: ifgt +22 -> 42
    //   23: ldc 34
    //   25: ldc 54
    //   27: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 48
    //   32: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aconst_null
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: new 19	com/tencent/mm/protocal/protobuf/eyu
    //   45: dup
    //   46: invokespecial 62	com/tencent/mm/protocal/protobuf/eyu:<init>	()V
    //   49: astore_0
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 66	com/tencent/mm/protocal/protobuf/eyu:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   55: pop
    //   56: ldc 48
    //   58: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: goto -24 -> 37
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    //   70: astore_0
    //   71: ldc 34
    //   73: aload_0
    //   74: ldc 68
    //   76: iconst_0
    //   77: anewarray 4	java/lang/Object
    //   80: invokestatic 42	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: ldc 48
    //   85: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   88: aconst_null
    //   89: astore_0
    //   90: goto -53 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	15	0	localeyu	eyu
    //   64	5	0	localObject1	Object
    //   70	4	0	localIOException	java.io.IOException
    //   89	1	0	localObject2	Object
    //   13	39	1	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   3	14	64	finally
    //   18	23	64	finally
    //   23	35	64	finally
    //   42	50	64	finally
    //   50	56	64	finally
    //   56	61	64	finally
    //   71	88	64	finally
    //   50	56	70	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.b.b
 * JD-Core Version:    0.7.0.1
 */