package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import org.json.JSONObject;

final class m$a
  extends ai
{
  private static final int CTRL_INDEX = 187;
  private static final String NAME = "onBLECharacteristicValueChange";
  private static a hFE;
  private static JSONObject hFF;
  
  static
  {
    AppMethodBeat.i(94198);
    hFE = new a();
    hFF = new JSONObject();
    AppMethodBeat.o(94198);
  }
  
  /* Error */
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 46
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: ifnonnull +19 -> 28
    //   12: ldc 48
    //   14: ldc 50
    //   16: invokestatic 56	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 46
    //   21: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 2
    //   26: monitorexit
    //   27: return
    //   28: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   31: ldc 58
    //   33: invokevirtual 62	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   36: pop
    //   37: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   40: ldc 58
    //   42: aload 4
    //   44: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   47: pop
    //   48: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   51: ldc 68
    //   53: invokevirtual 62	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   56: pop
    //   57: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   60: ldc 68
    //   62: aload_1
    //   63: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   66: pop
    //   67: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   70: ldc 70
    //   72: invokevirtual 62	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   75: pop
    //   76: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   79: ldc 70
    //   81: aload_2
    //   82: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   85: pop
    //   86: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   89: ldc 72
    //   91: invokevirtual 62	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   94: pop
    //   95: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   98: ldc 72
    //   100: aload_3
    //   101: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   104: pop
    //   105: aload_0
    //   106: ifnonnull +43 -> 149
    //   109: ldc 48
    //   111: ldc 74
    //   113: invokestatic 77	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: ldc 46
    //   118: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: goto -97 -> 24
    //   124: astore_0
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_0
    //   129: athrow
    //   130: astore_1
    //   131: ldc 48
    //   133: ldc 79
    //   135: iconst_1
    //   136: anewarray 81	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: aload_1
    //   142: aastore
    //   143: invokestatic 84	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: goto -41 -> 105
    //   149: getstatic 32	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFE	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a;
    //   152: aload_0
    //   153: aload_0
    //   154: invokeinterface 90 1 0
    //   159: invokevirtual 94	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;I)Lcom/tencent/mm/plugin/appbrand/jsapi/ai;
    //   162: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   165: invokevirtual 98	org/json/JSONObject:toString	()Ljava/lang/String;
    //   168: invokevirtual 102	com/tencent/mm/plugin/appbrand/jsapi/ai:BN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/ai;
    //   171: invokevirtual 105	com/tencent/mm/plugin/appbrand/jsapi/ai:aBz	()V
    //   174: ldc 48
    //   176: ldc 107
    //   178: iconst_1
    //   179: anewarray 81	java/lang/Object
    //   182: dup
    //   183: iconst_0
    //   184: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:hFF	Lorg/json/JSONObject;
    //   187: invokevirtual 98	org/json/JSONObject:toString	()Ljava/lang/String;
    //   190: aastore
    //   191: invokestatic 109	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: ldc 46
    //   196: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: goto -175 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
    //   0	202	1	paramString1	String
    //   0	202	2	paramString2	String
    //   0	202	3	paramString3	String
    //   0	202	4	paramString4	String
    // Exception table:
    //   from	to	target	type
    //   3	8	124	finally
    //   12	24	124	finally
    //   28	105	124	finally
    //   109	121	124	finally
    //   131	146	124	finally
    //   149	199	124	finally
    //   28	105	130	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m.a
 * JD-Core Version:    0.7.0.1
 */