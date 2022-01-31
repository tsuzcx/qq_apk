package com.tencent.mm.plugin.mmsight.model;

import android.content.Context;

final class n$1
  implements Runnable
{
  n$1(n paramn, long paramLong1, long paramLong2, Context paramContext, int paramInt) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 40
    //   2: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 48
    //   7: ldc 50
    //   9: iconst_3
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: getfield 26	com/tencent/mm/plugin/mmsight/model/n$1:oHO	J
    //   19: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: invokestatic 62	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   28: invokevirtual 66	java/lang/Thread:getId	()J
    //   31: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: aastore
    //   35: dup
    //   36: iconst_2
    //   37: invokestatic 71	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   40: aload_0
    //   41: getfield 28	com/tencent/mm/plugin/mmsight/model/n$1:dZo	J
    //   44: lsub
    //   45: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aastore
    //   49: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   52: aload_0
    //   53: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:oHQ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   56: getfield 80	com/tencent/mm/plugin/mmsight/model/n:lock	Ljava/lang/Object;
    //   59: astore_1
    //   60: aload_1
    //   61: monitorenter
    //   62: aload_0
    //   63: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:oHQ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   66: aload_0
    //   67: getfield 30	com/tencent/mm/plugin/mmsight/model/n$1:val$context	Landroid/content/Context;
    //   70: aload_0
    //   71: getfield 32	com/tencent/mm/plugin/mmsight/model/n$1:oHP	I
    //   74: invokestatic 86	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   77: invokestatic 92	com/tencent/mm/compatible/e/d:a	(Landroid/content/Context;ILandroid/os/Looper;)Lcom/tencent/mm/compatible/e/d$a$a;
    //   80: putfield 96	com/tencent/mm/plugin/mmsight/model/n:faL	Lcom/tencent/mm/compatible/e/d$a$a;
    //   83: aload_0
    //   84: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:oHQ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   87: getfield 100	com/tencent/mm/plugin/mmsight/model/n:faK	Z
    //   90: ifeq +70 -> 160
    //   93: aload_0
    //   94: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:oHQ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   97: getfield 96	com/tencent/mm/plugin/mmsight/model/n:faL	Lcom/tencent/mm/compatible/e/d$a$a;
    //   100: ifnull +60 -> 160
    //   103: ldc 48
    //   105: ldc 102
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: invokestatic 71	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   116: aload_0
    //   117: getfield 28	com/tencent/mm/plugin/mmsight/model/n$1:dZo	J
    //   120: lsub
    //   121: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: aastore
    //   125: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_0
    //   129: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:oHQ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   132: getfield 96	com/tencent/mm/plugin/mmsight/model/n:faL	Lcom/tencent/mm/compatible/e/d$a$a;
    //   135: getfield 111	com/tencent/mm/compatible/e/d$a$a:eoH	Lcom/tencent/mm/compatible/e/u;
    //   138: astore_2
    //   139: aload_2
    //   140: aconst_null
    //   141: invokevirtual 117	com/tencent/mm/compatible/e/u:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   144: aload_2
    //   145: invokevirtual 120	com/tencent/mm/compatible/e/u:stopPreview	()V
    //   148: aload_2
    //   149: invokevirtual 123	com/tencent/mm/compatible/e/u:release	()V
    //   152: aload_0
    //   153: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:oHQ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   156: aconst_null
    //   157: putfield 96	com/tencent/mm/plugin/mmsight/model/n:faL	Lcom/tencent/mm/compatible/e/d$a$a;
    //   160: aload_0
    //   161: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:oHQ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   164: getfield 80	com/tencent/mm/plugin/mmsight/model/n:lock	Ljava/lang/Object;
    //   167: invokevirtual 126	java/lang/Object:notify	()V
    //   170: aload_1
    //   171: monitorexit
    //   172: ldc 40
    //   174: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: return
    //   178: astore_2
    //   179: ldc 48
    //   181: ldc 131
    //   183: iconst_1
    //   184: anewarray 4	java/lang/Object
    //   187: dup
    //   188: iconst_0
    //   189: aload_2
    //   190: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: aload_0
    //   198: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:oHQ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   201: aconst_null
    //   202: putfield 96	com/tencent/mm/plugin/mmsight/model/n:faL	Lcom/tencent/mm/compatible/e/d$a$a;
    //   205: goto -122 -> 83
    //   208: astore_2
    //   209: aload_1
    //   210: monitorexit
    //   211: ldc 40
    //   213: invokestatic 129	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload_2
    //   217: athrow
    //   218: astore_2
    //   219: ldc 48
    //   221: ldc 137
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_2
    //   230: invokevirtual 135	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: goto -77 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	1
    //   59	151	1	localObject1	Object
    //   138	11	2	localu	com.tencent.mm.compatible.e.u
    //   178	12	2	localException1	java.lang.Exception
    //   208	9	2	localObject2	Object
    //   218	12	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   62	83	178	java/lang/Exception
    //   62	83	208	finally
    //   83	128	208	finally
    //   128	160	208	finally
    //   160	172	208	finally
    //   179	205	208	finally
    //   209	211	208	finally
    //   219	237	208	finally
    //   128	160	218	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n.1
 * JD-Core Version:    0.7.0.1
 */