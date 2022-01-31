package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.jsapi.ac;

public final class a
  extends ac
{
  private static final int CTRL_INDEX = 355;
  private static final String NAME = "onHCEMessage";
  private static final a gxL = new a();
  
  /* Error */
  static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 26
    //   5: ldc 28
    //   7: iconst_2
    //   8: anewarray 30	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: invokeinterface 36 1 0
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: iload_1
    //   23: invokestatic 42	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 48	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: iload_1
    //   31: bipush 31
    //   33: if_icmpne +63 -> 96
    //   36: aload_2
    //   37: ifnull +55 -> 92
    //   40: aload_2
    //   41: ldc 50
    //   43: invokevirtual 56	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore_2
    //   47: new 58	java/util/HashMap
    //   50: dup
    //   51: invokespecial 59	java/util/HashMap:<init>	()V
    //   54: astore_3
    //   55: aload_3
    //   56: ldc 61
    //   58: iconst_1
    //   59: invokestatic 42	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: invokeinterface 67 3 0
    //   67: pop
    //   68: aload_3
    //   69: ldc 69
    //   71: aload_2
    //   72: invokeinterface 67 3 0
    //   77: pop
    //   78: getstatic 20	com/tencent/mm/plugin/appbrand/jsapi/nfc/a:gxL	Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/a;
    //   81: aload_0
    //   82: invokevirtual 73	com/tencent/mm/plugin/appbrand/jsapi/nfc/a:e	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   85: aload_3
    //   86: invokevirtual 77	com/tencent/mm/plugin/appbrand/jsapi/ac:p	(Ljava/util/Map;)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   89: invokevirtual 80	com/tencent/mm/plugin/appbrand/jsapi/ac:dispatch	()V
    //   92: ldc 2
    //   94: monitorexit
    //   95: return
    //   96: iload_1
    //   97: bipush 41
    //   99: if_icmpne -7 -> 92
    //   102: aload_2
    //   103: ifnull -11 -> 92
    //   106: new 58	java/util/HashMap
    //   109: dup
    //   110: invokespecial 59	java/util/HashMap:<init>	()V
    //   113: astore_3
    //   114: aload_3
    //   115: ldc 61
    //   117: iconst_2
    //   118: invokestatic 42	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   121: invokeinterface 67 3 0
    //   126: pop
    //   127: aload_3
    //   128: ldc 82
    //   130: aload_2
    //   131: ldc 84
    //   133: invokevirtual 88	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   136: invokestatic 42	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: invokeinterface 67 3 0
    //   144: pop
    //   145: getstatic 20	com/tencent/mm/plugin/appbrand/jsapi/nfc/a:gxL	Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/a;
    //   148: aload_0
    //   149: invokevirtual 73	com/tencent/mm/plugin/appbrand/jsapi/nfc/a:e	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   152: aload_3
    //   153: invokevirtual 77	com/tencent/mm/plugin/appbrand/jsapi/ac:p	(Ljava/util/Map;)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   156: invokevirtual 80	com/tencent/mm/plugin/appbrand/jsapi/ac:dispatch	()V
    //   159: goto -67 -> 92
    //   162: astore_0
    //   163: ldc 2
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
    //   0	168	1	paramInt	int
    //   0	168	2	paramBundle	android.os.Bundle
    //   54	99	3	localHashMap	java.util.HashMap
    // Exception table:
    //   from	to	target	type
    //   3	30	162	finally
    //   40	92	162	finally
    //   106	159	162	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.a
 * JD-Core Version:    0.7.0.1
 */