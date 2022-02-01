package com.tencent.d.e.b.a.a.a;

import com.tencent.d.e.b.a.a.a;
import com.tencent.d.e.b.a.a.c;
import java.lang.reflect.Method;

public final class i
  implements a
{
  private static Object ZqB;
  private static Class<?> ZqC = null;
  private static Method ZqD = null;
  private String ZqA = "";
  private c Zqs;
  private int mErrorCode = -1;
  private long mTime = -1L;
  
  /* Error */
  public final c lS(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 50
    //   4: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 58	com/tencent/d/e/b/a/a/a/i:Zqs	Lcom/tencent/d/e/b/a/a/c;
    //   11: ifnull +27 -> 38
    //   14: aload_0
    //   15: getfield 58	com/tencent/d/e/b/a/a/a/i:Zqs	Lcom/tencent/d/e/b/a/a/c;
    //   18: getfield 63	com/tencent/d/e/b/a/a/c:errorCode	I
    //   21: ifne +17 -> 38
    //   24: aload_0
    //   25: getfield 58	com/tencent/d/e/b/a/a/a/i:Zqs	Lcom/tencent/d/e/b/a/a/c;
    //   28: astore_1
    //   29: ldc 50
    //   31: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: areturn
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 33	com/tencent/d/e/b/a/a/a/i:mErrorCode	I
    //   43: ldc 68
    //   45: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   48: putstatic 25	com/tencent/d/e/b/a/a/a/i:ZqC	Ljava/lang/Class;
    //   51: getstatic 25	com/tencent/d/e/b/a/a/a/i:ZqC	Ljava/lang/Class;
    //   54: ifnonnull +39 -> 93
    //   57: sipush -301
    //   60: invokestatic 78	com/tencent/d/e/b/a/a/c:aAp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   63: astore_1
    //   64: ldc 50
    //   66: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -35 -> 34
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: astore_1
    //   78: sipush -301
    //   81: invokestatic 78	com/tencent/d/e/b/a/a/c:aAp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   84: astore_1
    //   85: ldc 50
    //   87: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: goto -56 -> 34
    //   93: getstatic 25	com/tencent/d/e/b/a/a/a/i:ZqC	Ljava/lang/Class;
    //   96: invokevirtual 82	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   99: putstatic 84	com/tencent/d/e/b/a/a/a/i:ZqB	Ljava/lang/Object;
    //   102: getstatic 25	com/tencent/d/e/b/a/a/a/i:ZqC	Ljava/lang/Class;
    //   105: ldc 86
    //   107: iconst_1
    //   108: anewarray 70	java/lang/Class
    //   111: dup
    //   112: iconst_0
    //   113: ldc 88
    //   115: aastore
    //   116: invokevirtual 92	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   119: putstatic 27	com/tencent/d/e/b/a/a/a/i:ZqD	Ljava/lang/reflect/Method;
    //   122: getstatic 84	com/tencent/d/e/b/a/a/a/i:ZqB	Ljava/lang/Object;
    //   125: ifnull +41 -> 166
    //   128: getstatic 27	com/tencent/d/e/b/a/a/a/i:ZqD	Ljava/lang/reflect/Method;
    //   131: astore_2
    //   132: aload_2
    //   133: ifnull +33 -> 166
    //   136: getstatic 27	com/tencent/d/e/b/a/a/a/i:ZqD	Ljava/lang/reflect/Method;
    //   139: getstatic 84	com/tencent/d/e/b/a/a/a/i:ZqB	Ljava/lang/Object;
    //   142: iconst_1
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_1
    //   149: aastore
    //   150: invokevirtual 98	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   153: astore_1
    //   154: aload_1
    //   155: ifnull +83 -> 238
    //   158: aload_0
    //   159: aload_1
    //   160: checkcast 100	java/lang/String
    //   163: putfield 41	com/tencent/d/e/b/a/a/a/i:ZqA	Ljava/lang/String;
    //   166: new 60	com/tencent/d/e/b/a/a/c
    //   169: dup
    //   170: aload_0
    //   171: getfield 41	com/tencent/d/e/b/a/a/a/i:ZqA	Ljava/lang/String;
    //   174: aload_0
    //   175: getfield 33	com/tencent/d/e/b/a/a/a/i:mErrorCode	I
    //   178: invokespecial 103	com/tencent/d/e/b/a/a/c:<init>	(Ljava/lang/String;I)V
    //   181: astore_1
    //   182: ldc 50
    //   184: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: goto -153 -> 34
    //   190: astore_1
    //   191: sipush -302
    //   194: invokestatic 78	com/tencent/d/e/b/a/a/c:aAp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   197: astore_1
    //   198: ldc 50
    //   200: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: goto -169 -> 34
    //   206: astore_1
    //   207: sipush -303
    //   210: invokestatic 78	com/tencent/d/e/b/a/a/c:aAp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   213: astore_1
    //   214: ldc 50
    //   216: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   219: goto -185 -> 34
    //   222: astore_1
    //   223: sipush -304
    //   226: invokestatic 78	com/tencent/d/e/b/a/a/c:aAp	(I)Lcom/tencent/d/e/b/a/a/c;
    //   229: astore_1
    //   230: ldc 50
    //   232: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: goto -201 -> 34
    //   238: aload_0
    //   239: sipush -305
    //   242: putfield 33	com/tencent/d/e/b/a/a/a/i:mErrorCode	I
    //   245: goto -79 -> 166
    //   248: astore_1
    //   249: aload_0
    //   250: sipush -306
    //   253: putfield 33	com/tencent/d/e/b/a/a/a/i:mErrorCode	I
    //   256: goto -90 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	i
    //   0	259	1	paramContext	android.content.Context
    //   131	2	2	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   2	34	72	finally
    //   38	43	72	finally
    //   43	51	72	finally
    //   51	69	72	finally
    //   78	90	72	finally
    //   93	102	72	finally
    //   102	122	72	finally
    //   122	132	72	finally
    //   136	154	72	finally
    //   158	166	72	finally
    //   166	187	72	finally
    //   191	203	72	finally
    //   207	219	72	finally
    //   223	235	72	finally
    //   238	245	72	finally
    //   249	256	72	finally
    //   43	51	77	java/lang/Throwable
    //   93	102	190	java/lang/InstantiationException
    //   93	102	206	java/lang/IllegalAccessException
    //   102	122	222	java/lang/Throwable
    //   136	154	248	java/lang/Throwable
    //   158	166	248	java/lang/Throwable
    //   238	245	248	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.a.i
 * JD-Core Version:    0.7.0.1
 */