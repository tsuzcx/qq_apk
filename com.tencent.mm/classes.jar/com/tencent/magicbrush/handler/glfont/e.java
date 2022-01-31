package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e
{
  HashMap<String, Typeface> bJN;
  public b bJO;
  
  e(b paramb)
  {
    AppMethodBeat.i(115916);
    this.bJN = new HashMap();
    this.bJO = paramb;
    AppMethodBeat.o(115916);
  }
  
  /* Error */
  static String cq(String paramString)
  {
    // Byte code:
    //   0: ldc 39
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 45	com/tencent/magicbrush/d/e:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 39
    //   14: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: ldc 47
    //   22: invokevirtual 52	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   25: ifne +18 -> 43
    //   28: invokestatic 58	com/tencent/magicbrush/handler/glfont/a:ys	()Lcom/tencent/magicbrush/a/d$a;
    //   31: ifnull +12 -> 43
    //   34: invokestatic 58	com/tencent/magicbrush/handler/glfont/a:ys	()Lcom/tencent/magicbrush/a/d$a;
    //   37: iconst_1
    //   38: invokeinterface 63 2 0
    //   43: new 65	com/tencent/magicbrush/handler/glfont/l
    //   46: dup
    //   47: invokespecial 66	com/tencent/magicbrush/handler/glfont/l:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: getfield 70	com/tencent/magicbrush/handler/glfont/l:bKI	Ljava/util/Map;
    //   55: invokeinterface 75 1 0
    //   60: new 77	java/io/RandomAccessFile
    //   63: dup
    //   64: aload_0
    //   65: ldc 79
    //   67: invokespecial 82	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: astore_2
    //   71: aload_1
    //   72: aload_2
    //   73: invokevirtual 86	com/tencent/magicbrush/handler/glfont/l:b	(Ljava/io/RandomAccessFile;)V
    //   76: aload_2
    //   77: invokevirtual 89	java/io/RandomAccessFile:close	()V
    //   80: aload_1
    //   81: getfield 70	com/tencent/magicbrush/handler/glfont/l:bKI	Ljava/util/Map;
    //   84: getstatic 93	com/tencent/magicbrush/handler/glfont/l:bKD	I
    //   87: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: invokeinterface 103 2 0
    //   95: ifeq +99 -> 194
    //   98: aload_1
    //   99: getfield 70	com/tencent/magicbrush/handler/glfont/l:bKI	Ljava/util/Map;
    //   102: getstatic 93	com/tencent/magicbrush/handler/glfont/l:bKD	I
    //   105: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: invokeinterface 107 2 0
    //   113: checkcast 49	java/lang/String
    //   116: astore_0
    //   117: ldc 39
    //   119: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: areturn
    //   124: astore_2
    //   125: ldc 109
    //   127: aload_2
    //   128: ldc 111
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 117	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: goto -57 -> 80
    //   140: astore_1
    //   141: ldc 119
    //   143: aload_1
    //   144: ldc 121
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_0
    //   153: aastore
    //   154: invokestatic 117	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: ldc 39
    //   159: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aconst_null
    //   163: areturn
    //   164: astore_1
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 89	java/io/RandomAccessFile:close	()V
    //   171: ldc 39
    //   173: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_1
    //   177: athrow
    //   178: astore_2
    //   179: ldc 109
    //   181: aload_2
    //   182: ldc 111
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 117	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: goto -20 -> 171
    //   194: aload_1
    //   195: getfield 70	com/tencent/magicbrush/handler/glfont/l:bKI	Ljava/util/Map;
    //   198: getstatic 124	com/tencent/magicbrush/handler/glfont/l:bKH	I
    //   201: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: invokeinterface 103 2 0
    //   209: ifeq +29 -> 238
    //   212: aload_1
    //   213: getfield 70	com/tencent/magicbrush/handler/glfont/l:bKI	Ljava/util/Map;
    //   216: getstatic 124	com/tencent/magicbrush/handler/glfont/l:bKH	I
    //   219: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: invokeinterface 107 2 0
    //   227: checkcast 49	java/lang/String
    //   230: astore_0
    //   231: ldc 39
    //   233: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_0
    //   237: areturn
    //   238: ldc 39
    //   240: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: goto -79 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString	String
    //   50	49	1	locall	l
    //   140	4	1	localIOException	java.io.IOException
    //   164	49	1	localObject1	Object
    //   245	1	1	localObject2	Object
    //   70	7	2	localRandomAccessFile	java.io.RandomAccessFile
    //   124	4	2	localException1	java.lang.Exception
    //   166	2	2	localObject3	Object
    //   178	4	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   76	80	124	java/lang/Exception
    //   51	60	140	java/io/IOException
    //   76	80	140	java/io/IOException
    //   125	137	140	java/io/IOException
    //   167	171	140	java/io/IOException
    //   171	178	140	java/io/IOException
    //   179	191	140	java/io/IOException
    //   60	71	164	finally
    //   167	171	178	java/lang/Exception
    //   71	76	245	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.e
 * JD-Core Version:    0.7.0.1
 */