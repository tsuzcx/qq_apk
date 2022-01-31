package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import org.json.JSONObject;

final class m$b
  extends ac
{
  private static final int CTRL_INDEX = 188;
  private static final String NAME = "onBLEConnectionStateChanged";
  private static JSONObject glG = new JSONObject();
  private static b glH = new b();
  
  /* Error */
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +14 -> 18
    //   7: ldc 38
    //   9: ldc 40
    //   11: invokestatic 46	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b:glG	Lorg/json/JSONObject;
    //   21: ldc 48
    //   23: invokevirtual 52	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: pop
    //   27: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b:glG	Lorg/json/JSONObject;
    //   30: ldc 48
    //   32: aload_1
    //   33: invokevirtual 56	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   36: pop
    //   37: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b:glG	Lorg/json/JSONObject;
    //   40: ldc 58
    //   42: invokevirtual 52	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   45: pop
    //   46: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b:glG	Lorg/json/JSONObject;
    //   49: ldc 58
    //   51: iload_2
    //   52: invokevirtual 61	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_0
    //   57: ifnonnull +38 -> 95
    //   60: ldc 38
    //   62: ldc 63
    //   64: invokestatic 66	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: goto -53 -> 14
    //   70: astore_0
    //   71: ldc 2
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    //   76: astore_1
    //   77: ldc 38
    //   79: ldc 68
    //   81: iconst_1
    //   82: anewarray 70	java/lang/Object
    //   85: dup
    //   86: iconst_0
    //   87: aload_1
    //   88: aastore
    //   89: invokestatic 73	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: goto -36 -> 56
    //   95: getstatic 25	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b:glH	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b;
    //   98: aload_0
    //   99: aload_0
    //   100: invokeinterface 79 1 0
    //   105: invokevirtual 82	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;I)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   108: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b:glG	Lorg/json/JSONObject;
    //   111: invokevirtual 86	org/json/JSONObject:toString	()Ljava/lang/String;
    //   114: invokevirtual 90	com/tencent/mm/plugin/appbrand/jsapi/ac:tM	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   117: invokevirtual 93	com/tencent/mm/plugin/appbrand/jsapi/ac:dispatch	()V
    //   120: ldc 38
    //   122: ldc 95
    //   124: iconst_1
    //   125: anewarray 70	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$b:glG	Lorg/json/JSONObject;
    //   133: invokevirtual 86	org/json/JSONObject:toString	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 98	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: goto -126 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
    //   0	143	1	paramString	String
    //   0	143	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   7	14	70	finally
    //   18	56	70	finally
    //   60	67	70	finally
    //   77	92	70	finally
    //   95	140	70	finally
    //   18	56	76	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m.b
 * JD-Core Version:    0.7.0.1
 */