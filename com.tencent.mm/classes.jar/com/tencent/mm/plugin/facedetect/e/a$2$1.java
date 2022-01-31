package com.tencent.mm.plugin.facedetect.e;

final class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:jTq	Lcom/tencent/mm/plugin/facedetect/e/a$2;
    //   4: getfield 31	com/tencent/mm/plugin/facedetect/e/a$2:jTm	Lcom/tencent/mm/plugin/facedetect/e/a;
    //   7: invokestatic 37	com/tencent/mm/plugin/facedetect/e/a:g	(Lcom/tencent/mm/plugin/facedetect/e/a;)Lcom/tencent/mm/plugin/mmsight/model/a/d;
    //   10: ifnull +18 -> 28
    //   13: aload_0
    //   14: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:jTq	Lcom/tencent/mm/plugin/facedetect/e/a$2;
    //   17: getfield 31	com/tencent/mm/plugin/facedetect/e/a$2:jTm	Lcom/tencent/mm/plugin/facedetect/e/a;
    //   20: invokestatic 37	com/tencent/mm/plugin/facedetect/e/a:g	(Lcom/tencent/mm/plugin/facedetect/e/a;)Lcom/tencent/mm/plugin/mmsight/model/a/d;
    //   23: invokeinterface 42 1 0
    //   28: aload_0
    //   29: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:jTq	Lcom/tencent/mm/plugin/facedetect/e/a$2;
    //   32: getfield 31	com/tencent/mm/plugin/facedetect/e/a$2:jTm	Lcom/tencent/mm/plugin/facedetect/e/a;
    //   35: invokestatic 46	com/tencent/mm/plugin/facedetect/e/a:d	(Lcom/tencent/mm/plugin/facedetect/e/a;)V
    //   38: aload_0
    //   39: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:jTq	Lcom/tencent/mm/plugin/facedetect/e/a$2;
    //   42: getfield 31	com/tencent/mm/plugin/facedetect/e/a$2:jTm	Lcom/tencent/mm/plugin/facedetect/e/a;
    //   45: invokestatic 50	com/tencent/mm/plugin/facedetect/e/a:a	(Lcom/tencent/mm/plugin/facedetect/e/a;)Ljava/lang/Object;
    //   48: astore_1
    //   49: aload_1
    //   50: monitorenter
    //   51: aload_0
    //   52: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:jTq	Lcom/tencent/mm/plugin/facedetect/e/a$2;
    //   55: getfield 31	com/tencent/mm/plugin/facedetect/e/a$2:jTm	Lcom/tencent/mm/plugin/facedetect/e/a;
    //   58: getstatic 56	com/tencent/mm/plugin/facedetect/e/a$a:jTz	Lcom/tencent/mm/plugin/facedetect/e/a$a;
    //   61: invokestatic 59	com/tencent/mm/plugin/facedetect/e/a:a	(Lcom/tencent/mm/plugin/facedetect/e/a;Lcom/tencent/mm/plugin/facedetect/e/a$a;)Lcom/tencent/mm/plugin/facedetect/e/a$a;
    //   64: pop
    //   65: aload_1
    //   66: monitorexit
    //   67: invokestatic 65	com/tencent/mm/plugin/facedetect/model/FaceContextData:aOh	()Lcom/tencent/mm/plugin/facedetect/model/FaceContextData;
    //   70: getfield 69	com/tencent/mm/plugin/facedetect/model/FaceContextData:jNI	J
    //   73: iconst_2
    //   74: aload_0
    //   75: getfield 21	com/tencent/mm/plugin/facedetect/e/a$2$1:fsD	I
    //   78: invokestatic 75	com/tencent/mm/plugin/facedetect/model/FaceDetectReporter:e	(JII)V
    //   81: return
    //   82: astore_1
    //   83: ldc 77
    //   85: ldc 79
    //   87: iconst_1
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: aload_1
    //   94: invokevirtual 83	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: aastore
    //   98: invokestatic 88	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_0
    //   102: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:jTq	Lcom/tencent/mm/plugin/facedetect/e/a$2;
    //   105: getfield 31	com/tencent/mm/plugin/facedetect/e/a$2:jTm	Lcom/tencent/mm/plugin/facedetect/e/a;
    //   108: invokestatic 46	com/tencent/mm/plugin/facedetect/e/a:d	(Lcom/tencent/mm/plugin/facedetect/e/a;)V
    //   111: goto -73 -> 38
    //   114: astore_1
    //   115: aload_0
    //   116: getfield 19	com/tencent/mm/plugin/facedetect/e/a$2$1:jTq	Lcom/tencent/mm/plugin/facedetect/e/a$2;
    //   119: getfield 31	com/tencent/mm/plugin/facedetect/e/a$2:jTm	Lcom/tencent/mm/plugin/facedetect/e/a;
    //   122: invokestatic 46	com/tencent/mm/plugin/facedetect/e/a:d	(Lcom/tencent/mm/plugin/facedetect/e/a;)V
    //   125: aload_1
    //   126: athrow
    //   127: astore_2
    //   128: aload_1
    //   129: monitorexit
    //   130: aload_2
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	1
    //   82	12	1	localException	java.lang.Exception
    //   114	15	1	localObject2	Object
    //   127	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	28	82	java/lang/Exception
    //   0	28	114	finally
    //   83	101	114	finally
    //   51	67	127	finally
    //   128	130	127	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.2.1
 * JD-Core Version:    0.7.0.1
 */