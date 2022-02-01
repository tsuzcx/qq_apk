package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import com.tencent.mm.plugin.appbrand.jsapi.bc;

final class m$b
  extends bc
{
  private static final int CTRL_INDEX = 188;
  private static final String NAME = "onBLEConnectionStateChanged";
  
  /* Error */
  public static void b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 23
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnonnull +19 -> 28
    //   12: ldc 31
    //   14: ldc 33
    //   16: invokestatic 39	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 23
    //   21: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: new 2	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/m$b
    //   31: dup
    //   32: invokespecial 43	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/m$b:<init>	()V
    //   35: astore_3
    //   36: new 45	org/json/JSONObject
    //   39: dup
    //   40: invokespecial 46	org/json/JSONObject:<init>	()V
    //   43: astore 4
    //   45: aload 4
    //   47: ldc 48
    //   49: invokevirtual 52	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   52: pop
    //   53: aload 4
    //   55: ldc 48
    //   57: aload_1
    //   58: invokevirtual 56	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   61: pop
    //   62: aload 4
    //   64: ldc 58
    //   66: invokevirtual 52	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   69: pop
    //   70: aload 4
    //   72: ldc 58
    //   74: iload_2
    //   75: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload_3
    //   80: aload_0
    //   81: aload_0
    //   82: invokeinterface 67 1 0
    //   87: invokevirtual 70	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/m$b:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;I)Lcom/tencent/mm/plugin/appbrand/jsapi/bc;
    //   90: aload 4
    //   92: invokevirtual 74	org/json/JSONObject:toString	()Ljava/lang/String;
    //   95: invokevirtual 78	com/tencent/mm/plugin/appbrand/jsapi/bc:ZR	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/bc;
    //   98: invokevirtual 81	com/tencent/mm/plugin/appbrand/jsapi/bc:cpV	()V
    //   101: ldc 31
    //   103: ldc 83
    //   105: iconst_1
    //   106: anewarray 85	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload 4
    //   113: invokevirtual 74	org/json/JSONObject:toString	()Ljava/lang/String;
    //   116: aastore
    //   117: invokestatic 88	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: ldc 23
    //   122: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: goto -101 -> 24
    //   128: astore_0
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload_0
    //   133: athrow
    //   134: astore_1
    //   135: ldc 31
    //   137: ldc 90
    //   139: iconst_1
    //   140: anewarray 85	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload_1
    //   146: aastore
    //   147: invokestatic 92	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: goto -71 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramf	com.tencent.mm.plugin.appbrand.jsapi.f
    //   0	153	1	paramString	String
    //   0	153	2	paramBoolean	boolean
    //   35	45	3	localb	b
    //   43	69	4	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   3	8	128	finally
    //   12	24	128	finally
    //   28	45	128	finally
    //   45	79	128	finally
    //   79	125	128	finally
    //   135	150	128	finally
    //   45	79	134	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.m.b
 * JD-Core Version:    0.7.0.1
 */