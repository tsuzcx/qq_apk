package com.tencent.magicbrush.handler.glfont;

import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class e
{
  HashMap<String, Typeface> cnE;
  public b cnF;
  
  e(b paramb)
  {
    AppMethodBeat.i(140017);
    this.cnE = new HashMap();
    this.cnF = paramb;
    AppMethodBeat.o(140017);
  }
  
  /* Error */
  static String cz(String paramString)
  {
    // Byte code:
    //   0: ldc 37
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 43	com/tencent/magicbrush/utils/h:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 37
    //   14: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: ldc 45
    //   22: invokevirtual 50	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   25: ifne +18 -> 43
    //   28: invokestatic 56	com/tencent/magicbrush/handler/glfont/a:Gf	()Lcom/tencent/magicbrush/a/d$a;
    //   31: ifnull +12 -> 43
    //   34: invokestatic 56	com/tencent/magicbrush/handler/glfont/a:Gf	()Lcom/tencent/magicbrush/a/d$a;
    //   37: iconst_1
    //   38: invokeinterface 61 2 0
    //   43: new 63	com/tencent/magicbrush/handler/glfont/l
    //   46: dup
    //   47: invokespecial 64	com/tencent/magicbrush/handler/glfont/l:<init>	()V
    //   50: astore_1
    //   51: aload_1
    //   52: getfield 68	com/tencent/magicbrush/handler/glfont/l:coz	Ljava/util/Map;
    //   55: invokeinterface 73 1 0
    //   60: new 75	java/io/RandomAccessFile
    //   63: dup
    //   64: aload_0
    //   65: ldc 77
    //   67: invokespecial 80	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: astore_2
    //   71: aload_1
    //   72: aload_2
    //   73: invokevirtual 84	com/tencent/magicbrush/handler/glfont/l:c	(Ljava/io/RandomAccessFile;)V
    //   76: aload_2
    //   77: invokevirtual 87	java/io/RandomAccessFile:close	()V
    //   80: aload_1
    //   81: getfield 68	com/tencent/magicbrush/handler/glfont/l:coz	Ljava/util/Map;
    //   84: getstatic 91	com/tencent/magicbrush/handler/glfont/l:cou	I
    //   87: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: invokeinterface 101 2 0
    //   95: ifeq +99 -> 194
    //   98: aload_1
    //   99: getfield 68	com/tencent/magicbrush/handler/glfont/l:coz	Ljava/util/Map;
    //   102: getstatic 91	com/tencent/magicbrush/handler/glfont/l:cou	I
    //   105: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: invokeinterface 105 2 0
    //   113: checkcast 47	java/lang/String
    //   116: astore_0
    //   117: ldc 37
    //   119: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_0
    //   123: areturn
    //   124: astore_2
    //   125: ldc 107
    //   127: aload_2
    //   128: ldc 109
    //   130: iconst_0
    //   131: anewarray 4	java/lang/Object
    //   134: invokestatic 115	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: goto -57 -> 80
    //   140: astore_1
    //   141: ldc 117
    //   143: aload_1
    //   144: ldc 119
    //   146: iconst_1
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_0
    //   153: aastore
    //   154: invokestatic 115	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: ldc 37
    //   159: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aconst_null
    //   163: areturn
    //   164: astore_1
    //   165: aconst_null
    //   166: astore_2
    //   167: aload_2
    //   168: invokevirtual 87	java/io/RandomAccessFile:close	()V
    //   171: ldc 37
    //   173: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_1
    //   177: athrow
    //   178: astore_2
    //   179: ldc 107
    //   181: aload_2
    //   182: ldc 109
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 115	com/tencent/magicbrush/a/c$c:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: goto -20 -> 171
    //   194: aload_1
    //   195: getfield 68	com/tencent/magicbrush/handler/glfont/l:coz	Ljava/util/Map;
    //   198: getstatic 122	com/tencent/magicbrush/handler/glfont/l:coy	I
    //   201: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: invokeinterface 101 2 0
    //   209: ifeq +29 -> 238
    //   212: aload_1
    //   213: getfield 68	com/tencent/magicbrush/handler/glfont/l:coz	Ljava/util/Map;
    //   216: getstatic 122	com/tencent/magicbrush/handler/glfont/l:coy	I
    //   219: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   222: invokeinterface 105 2 0
    //   227: checkcast 47	java/lang/String
    //   230: astore_0
    //   231: ldc 37
    //   233: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_0
    //   237: areturn
    //   238: ldc 37
    //   240: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aconst_null
    //   244: areturn
    //   245: astore_1
    //   246: goto -79 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramString	String
    //   50	49	1	locall	l
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.glfont.e
 * JD-Core Version:    0.7.0.1
 */