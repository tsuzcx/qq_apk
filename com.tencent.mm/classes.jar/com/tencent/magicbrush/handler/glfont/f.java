package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class f
{
  HashMap<String, Typeface> cyQ;
  HashMap<String, Integer> cyR;
  public b cyS;
  
  f(b paramb)
  {
    AppMethodBeat.i(140017);
    this.cyQ = new HashMap();
    this.cyR = new f.1(this);
    this.cyS = paramb;
    AppMethodBeat.o(140017);
  }
  
  /* Error */
  static String dF(String paramString)
  {
    // Byte code:
    //   0: ldc 46
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 52	com/tencent/magicbrush/utils/h:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 46
    //   14: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: ldc 54
    //   22: invokevirtual 59	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   25: ifne +18 -> 43
    //   28: invokestatic 65	com/tencent/magicbrush/handler/glfont/a:HI	()Lcom/tencent/magicbrush/a/d$a;
    //   31: ifnull +12 -> 43
    //   34: invokestatic 65	com/tencent/magicbrush/handler/glfont/a:HI	()Lcom/tencent/magicbrush/a/d$a;
    //   37: iconst_1
    //   38: invokeinterface 70 2 0
    //   43: new 72	com/tencent/magicbrush/handler/glfont/m
    //   46: dup
    //   47: invokespecial 73	com/tencent/magicbrush/handler/glfont/m:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: getfield 77	com/tencent/magicbrush/handler/glfont/m:czQ	Ljava/util/Map;
    //   55: invokeinterface 82 1 0
    //   60: new 84	java/io/RandomAccessFile
    //   63: dup
    //   64: aload_0
    //   65: ldc 86
    //   67: invokespecial 89	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: astore_2
    //   71: aload_1
    //   72: aload_2
    //   73: invokevirtual 93	com/tencent/magicbrush/handler/glfont/m:c	(Ljava/io/RandomAccessFile;)V
    //   76: aload_2
    //   77: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   80: aload_1
    //   81: getfield 77	com/tencent/magicbrush/handler/glfont/m:czQ	Ljava/util/Map;
    //   84: getstatic 100	com/tencent/magicbrush/handler/glfont/m:czL	I
    //   87: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: invokeinterface 110 2 0
    //   95: ifeq +99 -> 194
    //   98: aload_1
    //   99: getfield 77	com/tencent/magicbrush/handler/glfont/m:czQ	Ljava/util/Map;
    //   102: getstatic 100	com/tencent/magicbrush/handler/glfont/m:czL	I
    //   105: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: invokeinterface 114 2 0
    //   113: checkcast 56	java/lang/String
    //   116: astore_0
    //   117: ldc 46
    //   119: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: areturn
    //   124: astore_2
    //   125: ldc 116
    //   127: aload_2
    //   128: ldc 118
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 124	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: goto -57 -> 80
    //   140: astore_1
    //   141: ldc 126
    //   143: aload_1
    //   144: ldc 128
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_0
    //   153: aastore
    //   154: invokestatic 124	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: ldc 46
    //   159: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aconst_null
    //   163: areturn
    //   164: astore_1
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   171: ldc 46
    //   173: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_1
    //   177: athrow
    //   178: astore_2
    //   179: ldc 116
    //   181: aload_2
    //   182: ldc 118
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 124	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: goto -20 -> 171
    //   194: aload_1
    //   195: getfield 77	com/tencent/magicbrush/handler/glfont/m:czQ	Ljava/util/Map;
    //   198: getstatic 131	com/tencent/magicbrush/handler/glfont/m:czP	I
    //   201: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: invokeinterface 110 2 0
    //   209: ifeq +29 -> 238
    //   212: aload_1
    //   213: getfield 77	com/tencent/magicbrush/handler/glfont/m:czQ	Ljava/util/Map;
    //   216: getstatic 131	com/tencent/magicbrush/handler/glfont/m:czP	I
    //   219: invokestatic 106	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: invokeinterface 114 2 0
    //   227: checkcast 56	java/lang/String
    //   230: astore_0
    //   231: ldc 46
    //   233: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_0
    //   237: areturn
    //   238: ldc 46
    //   240: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: goto -79 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString	String
    //   50	49	1	localm	m
    //   140	4	1	localException1	java.lang.Exception
    //   164	49	1	localObject1	Object
    //   245	1	1	localObject2	Object
    //   70	7	2	localRandomAccessFile	java.io.RandomAccessFile
    //   124	4	2	localException2	java.lang.Exception
    //   166	2	2	localObject3	Object
    //   178	4	2	localException3	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   76	80	124	java/lang/Exception
    //   51	60	140	java/lang/Exception
    //   125	137	140	java/lang/Exception
    //   171	178	140	java/lang/Exception
    //   179	191	140	java/lang/Exception
    //   60	71	164	finally
    //   167	171	178	java/lang/Exception
    //   71	76	245	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.f
 * JD-Core Version:    0.7.0.1
 */