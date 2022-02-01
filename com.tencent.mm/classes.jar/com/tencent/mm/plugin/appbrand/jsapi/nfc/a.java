package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;

public final class a
  extends bc
{
  private static final int CTRL_INDEX = 355;
  private static final String NAME = "onHCEMessage";
  private static final a mgR;
  
  static
  {
    AppMethodBeat.i(136078);
    mgR = new a();
    AppMethodBeat.o(136078);
  }
  
  /* Error */
  static void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 35
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 37
    //   10: ldc 39
    //   12: iconst_2
    //   13: anewarray 41	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_0
    //   19: invokeinterface 47 1 0
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: iload_1
    //   28: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: invokestatic 58	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: iload_1
    //   36: bipush 31
    //   38: if_icmpne +68 -> 106
    //   41: aload_2
    //   42: ifnull +127 -> 169
    //   45: aload_2
    //   46: ldc 60
    //   48: invokevirtual 66	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_2
    //   52: new 68	java/util/HashMap
    //   55: dup
    //   56: invokespecial 69	java/util/HashMap:<init>	()V
    //   59: astore_3
    //   60: aload_3
    //   61: ldc 71
    //   63: iconst_1
    //   64: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   67: invokeinterface 77 3 0
    //   72: pop
    //   73: aload_3
    //   74: ldc 79
    //   76: aload_2
    //   77: invokeinterface 77 3 0
    //   82: pop
    //   83: getstatic 27	com/tencent/mm/plugin/appbrand/jsapi/nfc/a:mgR	Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/a;
    //   86: aload_0
    //   87: invokevirtual 83	com/tencent/mm/plugin/appbrand/jsapi/nfc/a:h	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;)Lcom/tencent/mm/plugin/appbrand/jsapi/bc;
    //   90: aload_3
    //   91: invokevirtual 87	com/tencent/mm/plugin/appbrand/jsapi/bc:L	(Ljava/util/Map;)Lcom/tencent/mm/plugin/appbrand/jsapi/bc;
    //   94: invokevirtual 90	com/tencent/mm/plugin/appbrand/jsapi/bc:bEo	()V
    //   97: ldc 35
    //   99: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   102: ldc 2
    //   104: monitorexit
    //   105: return
    //   106: iload_1
    //   107: bipush 41
    //   109: if_icmpne +60 -> 169
    //   112: aload_2
    //   113: ifnull +56 -> 169
    //   116: new 68	java/util/HashMap
    //   119: dup
    //   120: invokespecial 69	java/util/HashMap:<init>	()V
    //   123: astore_3
    //   124: aload_3
    //   125: ldc 71
    //   127: iconst_2
    //   128: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   131: invokeinterface 77 3 0
    //   136: pop
    //   137: aload_3
    //   138: ldc 92
    //   140: aload_2
    //   141: ldc 94
    //   143: invokevirtual 98	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   146: invokestatic 53	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   149: invokeinterface 77 3 0
    //   154: pop
    //   155: getstatic 27	com/tencent/mm/plugin/appbrand/jsapi/nfc/a:mgR	Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/a;
    //   158: aload_0
    //   159: invokevirtual 83	com/tencent/mm/plugin/appbrand/jsapi/nfc/a:h	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;)Lcom/tencent/mm/plugin/appbrand/jsapi/bc;
    //   162: aload_3
    //   163: invokevirtual 87	com/tencent/mm/plugin/appbrand/jsapi/bc:L	(Ljava/util/Map;)Lcom/tencent/mm/plugin/appbrand/jsapi/bc;
    //   166: invokevirtual 90	com/tencent/mm/plugin/appbrand/jsapi/bc:bEo	()V
    //   169: ldc 35
    //   171: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: goto -72 -> 102
    //   177: astore_0
    //   178: ldc 2
    //   180: monitorexit
    //   181: aload_0
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	paramf	com.tencent.mm.plugin.appbrand.jsapi.f
    //   0	183	1	paramInt	int
    //   0	183	2	paramBundle	android.os.Bundle
    //   59	104	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   3	35	177	finally
    //   45	102	177	finally
    //   116	169	177	finally
    //   169	174	177	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a
 * JD-Core Version:    0.7.0.1
 */