package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.mm.plugin.appbrand.jsapi.p;

public final class a
  extends p
{
  private static final int CTRL_INDEX = 153;
  private static final String NAME = "onNetworkStatusChange";
  private static a iaI;
  
  /* Error */
  public static void k(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 21
    //   7: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: new 29	java/util/HashMap
    //   13: dup
    //   14: invokespecial 30	java/util/HashMap:<init>	()V
    //   17: astore_2
    //   18: invokestatic 36	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   21: invokestatic 42	com/tencent/mm/plugin/appbrand/jsapi/r/d:cM	(Landroid/content/Context;)Lcom/tencent/mm/plugin/appbrand/jsapi/r/d$a;
    //   24: astore_3
    //   25: aload_3
    //   26: getstatic 48	com/tencent/mm/plugin/appbrand/jsapi/r/d$a:iaJ	Lcom/tencent/mm/plugin/appbrand/jsapi/r/d$a;
    //   29: if_acmpeq +82 -> 111
    //   32: aload_2
    //   33: ldc 50
    //   35: iload_1
    //   36: invokestatic 56	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   39: invokevirtual 60	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: aload_2
    //   44: ldc 62
    //   46: aload_3
    //   47: getfield 65	com/tencent/mm/plugin/appbrand/jsapi/r/d$a:value	Ljava/lang/String;
    //   50: invokevirtual 60	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   53: pop
    //   54: ldc 67
    //   56: ldc 69
    //   58: iconst_1
    //   59: anewarray 71	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_3
    //   65: getfield 65	com/tencent/mm/plugin/appbrand/jsapi/r/d$a:value	Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 76	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: getstatic 78	com/tencent/mm/plugin/appbrand/jsapi/r/a:iaI	Lcom/tencent/mm/plugin/appbrand/jsapi/r/a;
    //   75: ifnonnull +13 -> 88
    //   78: new 2	com/tencent/mm/plugin/appbrand/jsapi/r/a
    //   81: dup
    //   82: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/r/a:<init>	()V
    //   85: putstatic 78	com/tencent/mm/plugin/appbrand/jsapi/r/a:iaI	Lcom/tencent/mm/plugin/appbrand/jsapi/r/a;
    //   88: getstatic 78	com/tencent/mm/plugin/appbrand/jsapi/r/a:iaI	Lcom/tencent/mm/plugin/appbrand/jsapi/r/a;
    //   91: aload_0
    //   92: invokevirtual 82	com/tencent/mm/plugin/appbrand/jsapi/r/a:i	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;)Lcom/tencent/mm/plugin/appbrand/jsapi/p;
    //   95: aload_2
    //   96: invokevirtual 86	com/tencent/mm/plugin/appbrand/jsapi/p:w	(Ljava/util/Map;)Lcom/tencent/mm/plugin/appbrand/jsapi/p;
    //   99: invokevirtual 89	com/tencent/mm/plugin/appbrand/jsapi/p:aBz	()V
    //   102: ldc 21
    //   104: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: ldc 2
    //   109: monitorexit
    //   110: return
    //   111: iconst_0
    //   112: istore_1
    //   113: goto -81 -> 32
    //   116: astore_0
    //   117: ldc 2
    //   119: monitorexit
    //   120: aload_0
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
    //   1	112	1	bool	boolean
    //   17	79	2	localHashMap	java.util.HashMap
    //   24	41	3	locala	d.a
    // Exception table:
    //   from	to	target	type
    //   5	32	116	finally
    //   32	88	116	finally
    //   88	107	116	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.a
 * JD-Core Version:    0.7.0.1
 */