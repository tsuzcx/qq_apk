package com.tencent.mm.plugin.appbrand.appcache;

abstract class WxaCommLibRuntimeReader$a
  implements i
{
  String versionName = null;
  
  /* Error */
  private String abR()
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 26
    //   3: invokevirtual 30	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$a:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: aload_2
    //   10: invokestatic 34	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader:u	(Ljava/io/InputStream;)Ljava/lang/String;
    //   13: astore 4
    //   15: aload_2
    //   16: astore_3
    //   17: new 36	com/tencent/mm/ab/i
    //   20: dup
    //   21: aload 4
    //   23: invokespecial 39	com/tencent/mm/ab/i:<init>	(Ljava/lang/String;)V
    //   26: ldc 41
    //   28: invokevirtual 45	com/tencent/mm/ab/i:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_1
    //   32: aload_2
    //   33: astore_3
    //   34: ldc 47
    //   36: ldc 49
    //   38: iconst_2
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: aastore
    //   46: dup
    //   47: iconst_1
    //   48: aload 4
    //   50: aastore
    //   51: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_2
    //   55: invokestatic 61	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: ifnonnull +6 -> 67
    //   64: ldc 63
    //   66: astore_2
    //   67: aload_2
    //   68: areturn
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_1
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: astore_3
    //   77: ldc 47
    //   79: aload 4
    //   81: ldc 65
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 69	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: aload_2
    //   91: invokestatic 61	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   94: goto -36 -> 58
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_3
    //   101: invokestatic 61	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   104: aload_1
    //   105: athrow
    //   106: astore_1
    //   107: goto -7 -> 100
    //   110: astore 4
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -39 -> 75
    //   117: astore 4
    //   119: goto -44 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	a
    //   31	42	1	str1	String
    //   97	8	1	localObject1	Object
    //   106	1	1	localObject2	Object
    //   113	1	1	localObject3	Object
    //   6	85	2	localObject4	Object
    //   8	93	3	localObject5	Object
    //   13	36	4	str2	String
    //   69	11	4	localException1	java.lang.Exception
    //   110	1	4	localException2	java.lang.Exception
    //   117	1	4	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	7	69	java/lang/Exception
    //   0	7	97	finally
    //   9	15	106	finally
    //   17	32	106	finally
    //   34	54	106	finally
    //   77	90	106	finally
    //   9	15	110	java/lang/Exception
    //   17	32	110	java/lang/Exception
    //   34	54	117	java/lang/Exception
  }
  
  /* Error */
  public final String abC()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$a:versionName	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 17	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$a:versionName	Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_0
    //   20: invokespecial 72	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$a:abR	()Ljava/lang/String;
    //   23: putfield 17	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$a:versionName	Ljava/lang/String;
    //   26: aload_0
    //   27: getfield 17	com/tencent/mm/plugin/appbrand/appcache/WxaCommLibRuntimeReader$a:versionName	Ljava/lang/String;
    //   30: astore_1
    //   31: goto -17 -> 14
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	a
    //   13	18	1	str	String
    //   34	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	34	finally
    //   18	31	34	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader.a
 * JD-Core Version:    0.7.0.1
 */