package com.tencent.magicbrush.handler.a;

import android.graphics.Typeface;
import java.util.HashMap;

final class f
{
  HashMap<String, Typeface> bkP = new HashMap();
  b bkQ;
  
  f(b paramb)
  {
    this.bkQ = paramb;
  }
  
  /* Error */
  static String bo(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 34	com/tencent/magicbrush/a:bl	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: ldc 36
    //   12: invokevirtual 41	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   15: ifne +18 -> 33
    //   18: invokestatic 47	com/tencent/magicbrush/handler/a/a:qK	()Lcom/tencent/magicbrush/a/e$a;
    //   21: ifnull +12 -> 33
    //   24: invokestatic 47	com/tencent/magicbrush/handler/a/a:qK	()Lcom/tencent/magicbrush/a/e$a;
    //   27: iconst_1
    //   28: invokeinterface 53 2 0
    //   33: new 55	com/tencent/magicbrush/handler/a/m
    //   36: dup
    //   37: invokespecial 56	com/tencent/magicbrush/handler/a/m:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: getfield 60	com/tencent/magicbrush/handler/a/m:blL	Ljava/util/Map;
    //   45: invokeinterface 65 1 0
    //   50: new 67	java/io/RandomAccessFile
    //   53: dup
    //   54: aload_0
    //   55: ldc 69
    //   57: invokespecial 72	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   60: astore_2
    //   61: aload_1
    //   62: aload_2
    //   63: invokevirtual 76	com/tencent/magicbrush/handler/a/m:b	(Ljava/io/RandomAccessFile;)V
    //   66: aload_2
    //   67: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   70: aload_1
    //   71: getfield 60	com/tencent/magicbrush/handler/a/m:blL	Ljava/util/Map;
    //   74: getstatic 83	com/tencent/magicbrush/handler/a/m:blG	I
    //   77: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   80: invokeinterface 93 2 0
    //   85: ifeq +82 -> 167
    //   88: aload_1
    //   89: getfield 60	com/tencent/magicbrush/handler/a/m:blL	Ljava/util/Map;
    //   92: getstatic 83	com/tencent/magicbrush/handler/a/m:blG	I
    //   95: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: invokeinterface 97 2 0
    //   103: checkcast 38	java/lang/String
    //   106: areturn
    //   107: astore_2
    //   108: ldc 99
    //   110: aload_2
    //   111: ldc 101
    //   113: iconst_0
    //   114: anewarray 4	java/lang/Object
    //   117: invokestatic 107	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: goto -50 -> 70
    //   123: astore_1
    //   124: ldc 109
    //   126: aload_1
    //   127: ldc 111
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_0
    //   136: aastore
    //   137: invokestatic 107	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_2
    //   145: aload_2
    //   146: invokevirtual 79	java/io/RandomAccessFile:close	()V
    //   149: aload_1
    //   150: athrow
    //   151: astore_2
    //   152: ldc 99
    //   154: aload_2
    //   155: ldc 101
    //   157: iconst_0
    //   158: anewarray 4	java/lang/Object
    //   161: invokestatic 107	com/tencent/magicbrush/a/d$f:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: goto -15 -> 149
    //   167: aload_1
    //   168: getfield 60	com/tencent/magicbrush/handler/a/m:blL	Ljava/util/Map;
    //   171: getstatic 114	com/tencent/magicbrush/handler/a/m:blK	I
    //   174: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: invokeinterface 93 2 0
    //   182: ifeq -175 -> 7
    //   185: aload_1
    //   186: getfield 60	com/tencent/magicbrush/handler/a/m:blL	Ljava/util/Map;
    //   189: getstatic 114	com/tencent/magicbrush/handler/a/m:blK	I
    //   192: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: invokeinterface 97 2 0
    //   200: checkcast 38	java/lang/String
    //   203: areturn
    //   204: astore_1
    //   205: goto -60 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString	String
    //   40	49	1	localm	m
    //   123	4	1	localIOException	java.io.IOException
    //   142	44	1	localObject1	Object
    //   204	1	1	localObject2	Object
    //   60	7	2	localRandomAccessFile	java.io.RandomAccessFile
    //   107	4	2	localException1	java.lang.Exception
    //   144	2	2	localObject3	Object
    //   151	4	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   66	70	107	java/lang/Exception
    //   41	50	123	java/io/IOException
    //   66	70	123	java/io/IOException
    //   108	120	123	java/io/IOException
    //   145	149	123	java/io/IOException
    //   149	151	123	java/io/IOException
    //   152	164	123	java/io/IOException
    //   50	61	142	finally
    //   145	149	151	java/lang/Exception
    //   61	66	204	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.a.f
 * JD-Core Version:    0.7.0.1
 */