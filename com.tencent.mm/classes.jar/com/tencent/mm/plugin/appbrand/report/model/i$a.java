package com.tencent.mm.plugin.appbrand.report.model;

import java.util.Set;

final class i$a
{
  private static final Set<String> mxK;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 15
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 23	java/util/HashSet
    //   8: dup
    //   9: invokespecial 26	java/util/HashSet:<init>	()V
    //   12: putstatic 28	com/tencent/mm/plugin/appbrand/report/model/i$a:mxK	Ljava/util/Set;
    //   15: invokestatic 34	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   18: invokevirtual 40	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   21: ldc 42
    //   23: invokevirtual 48	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnull +125 -> 153
    //   31: new 50	java/io/InputStreamReader
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 53	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   39: astore_0
    //   40: new 55	java/io/BufferedReader
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 58	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   48: astore_1
    //   49: aload_1
    //   50: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore_2
    //   54: aload_2
    //   55: ifnull +68 -> 123
    //   58: aload_2
    //   59: invokestatic 68	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   62: ifne -13 -> 49
    //   65: getstatic 28	com/tencent/mm/plugin/appbrand/report/model/i$a:mxK	Ljava/util/Set;
    //   68: aload_2
    //   69: invokeinterface 74 2 0
    //   74: pop
    //   75: goto -26 -> 49
    //   78: astore_2
    //   79: ldc 76
    //   81: aload_2
    //   82: ldc 78
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 84	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload_1
    //   92: invokestatic 88	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   95: aload_0
    //   96: invokestatic 88	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   99: ldc 15
    //   101: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: return
    //   105: astore_0
    //   106: ldc 76
    //   108: aload_0
    //   109: ldc 93
    //   111: iconst_0
    //   112: anewarray 4	java/lang/Object
    //   115: invokestatic 84	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: aconst_null
    //   119: astore_0
    //   120: goto -93 -> 27
    //   123: aload_1
    //   124: invokestatic 88	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   127: aload_0
    //   128: invokestatic 88	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   131: ldc 15
    //   133: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: return
    //   137: astore_2
    //   138: aload_1
    //   139: invokestatic 88	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   142: aload_0
    //   143: invokestatic 88	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   146: ldc 15
    //   148: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_2
    //   152: athrow
    //   153: ldc 15
    //   155: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	70	0	localObject1	Object
    //   105	4	0	localException1	java.lang.Exception
    //   119	24	0	localCloseable	java.io.Closeable
    //   48	91	1	localBufferedReader	java.io.BufferedReader
    //   53	16	2	str	String
    //   78	4	2	localException2	java.lang.Exception
    //   137	15	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   49	54	78	java/lang/Exception
    //   58	75	78	java/lang/Exception
    //   15	27	105	java/lang/Exception
    //   49	54	137	finally
    //   58	75	137	finally
    //   79	91	137	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.model.i.a
 * JD-Core Version:    0.7.0.1
 */