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
    //   0: ldc 41
    //   2: ldc 43
    //   4: iconst_3
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: getfield 26	com/tencent/mm/plugin/mmsight/model/n$1:mhH	J
    //   14: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: invokestatic 55	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   23: invokevirtual 59	java/lang/Thread:getId	()J
    //   26: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   29: aastore
    //   30: dup
    //   31: iconst_2
    //   32: invokestatic 64	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   35: aload_0
    //   36: getfield 28	com/tencent/mm/plugin/mmsight/model/n$1:dhV	J
    //   39: lsub
    //   40: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   43: aastore
    //   44: invokestatic 70	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_0
    //   48: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:mhJ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   51: getfield 74	com/tencent/mm/plugin/mmsight/model/n:lock	Ljava/lang/Object;
    //   54: astore_1
    //   55: aload_1
    //   56: monitorenter
    //   57: aload_0
    //   58: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:mhJ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   61: aload_0
    //   62: getfield 30	com/tencent/mm/plugin/mmsight/model/n$1:val$context	Landroid/content/Context;
    //   65: aload_0
    //   66: getfield 32	com/tencent/mm/plugin/mmsight/model/n$1:mhI	I
    //   69: invokestatic 77	com/tencent/mm/compatible/e/d:u	(Landroid/content/Context;I)Lcom/tencent/mm/compatible/e/d$a$a;
    //   72: putfield 81	com/tencent/mm/plugin/mmsight/model/n:mhG	Lcom/tencent/mm/compatible/e/d$a$a;
    //   75: aload_0
    //   76: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:mhJ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   79: getfield 85	com/tencent/mm/plugin/mmsight/model/n:mhF	Z
    //   82: ifeq +70 -> 152
    //   85: aload_0
    //   86: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:mhJ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   89: getfield 81	com/tencent/mm/plugin/mmsight/model/n:mhG	Lcom/tencent/mm/compatible/e/d$a$a;
    //   92: ifnull +60 -> 152
    //   95: ldc 41
    //   97: ldc 87
    //   99: iconst_1
    //   100: anewarray 4	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: invokestatic 64	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   108: aload_0
    //   109: getfield 28	com/tencent/mm/plugin/mmsight/model/n$1:dhV	J
    //   112: lsub
    //   113: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: aastore
    //   117: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload_0
    //   121: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:mhJ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   124: getfield 81	com/tencent/mm/plugin/mmsight/model/n:mhG	Lcom/tencent/mm/compatible/e/d$a$a;
    //   127: getfield 96	com/tencent/mm/compatible/e/d$a$a:dwJ	Landroid/hardware/Camera;
    //   130: astore_2
    //   131: aload_2
    //   132: aconst_null
    //   133: invokevirtual 102	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   136: aload_2
    //   137: invokevirtual 105	android/hardware/Camera:stopPreview	()V
    //   140: aload_2
    //   141: invokevirtual 108	android/hardware/Camera:release	()V
    //   144: aload_0
    //   145: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:mhJ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   148: aconst_null
    //   149: putfield 81	com/tencent/mm/plugin/mmsight/model/n:mhG	Lcom/tencent/mm/compatible/e/d$a$a;
    //   152: aload_0
    //   153: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:mhJ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   156: getfield 74	com/tencent/mm/plugin/mmsight/model/n:lock	Ljava/lang/Object;
    //   159: invokevirtual 111	java/lang/Object:notify	()V
    //   162: aload_1
    //   163: monitorexit
    //   164: return
    //   165: astore_2
    //   166: ldc 41
    //   168: ldc 113
    //   170: iconst_1
    //   171: anewarray 4	java/lang/Object
    //   174: dup
    //   175: iconst_0
    //   176: aload_2
    //   177: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   180: aastore
    //   181: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_0
    //   185: getfield 24	com/tencent/mm/plugin/mmsight/model/n$1:mhJ	Lcom/tencent/mm/plugin/mmsight/model/n;
    //   188: aconst_null
    //   189: putfield 81	com/tencent/mm/plugin/mmsight/model/n:mhG	Lcom/tencent/mm/compatible/e/d$a$a;
    //   192: goto -117 -> 75
    //   195: astore_2
    //   196: aload_1
    //   197: monitorexit
    //   198: aload_2
    //   199: athrow
    //   200: astore_2
    //   201: ldc 41
    //   203: ldc 119
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload_2
    //   212: invokevirtual 117	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: aastore
    //   216: invokestatic 90	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: goto -67 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	1
    //   54	143	1	localObject1	Object
    //   130	11	2	localCamera	android.hardware.Camera
    //   165	12	2	localException1	java.lang.Exception
    //   195	4	2	localObject2	Object
    //   200	12	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   57	75	165	java/lang/Exception
    //   57	75	195	finally
    //   75	120	195	finally
    //   120	152	195	finally
    //   152	164	195	finally
    //   166	192	195	finally
    //   196	198	195	finally
    //   201	219	195	finally
    //   120	152	200	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.n.1
 * JD-Core Version:    0.7.0.1
 */