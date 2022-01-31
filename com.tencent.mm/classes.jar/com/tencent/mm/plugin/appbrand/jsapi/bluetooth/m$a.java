package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import org.json.JSONObject;

final class m$a
  extends ac
{
  private static final int CTRL_INDEX = 187;
  private static final String NAME = "onBLECharacteristicValueChange";
  private static a glF = new a();
  private static JSONObject glG = new JSONObject();
  
  /* Error */
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +14 -> 18
    //   7: ldc 37
    //   9: ldc 39
    //   11: invokestatic 45	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: ldc 2
    //   16: monitorexit
    //   17: return
    //   18: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   21: ldc 47
    //   23: invokevirtual 51	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   26: pop
    //   27: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   30: ldc 47
    //   32: aload 4
    //   34: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   37: pop
    //   38: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   41: ldc 57
    //   43: invokevirtual 51	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   46: pop
    //   47: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   50: ldc 57
    //   52: aload_1
    //   53: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   56: pop
    //   57: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   60: ldc 59
    //   62: invokevirtual 51	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   65: pop
    //   66: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   69: ldc 59
    //   71: aload_2
    //   72: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   75: pop
    //   76: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   79: ldc 61
    //   81: invokevirtual 51	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   84: pop
    //   85: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   88: ldc 61
    //   90: aload_3
    //   91: invokevirtual 55	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload_0
    //   96: ifnonnull +38 -> 134
    //   99: ldc 37
    //   101: ldc 63
    //   103: invokestatic 66	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: goto -92 -> 14
    //   109: astore_0
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    //   115: astore_1
    //   116: ldc 37
    //   118: ldc 68
    //   120: iconst_1
    //   121: anewarray 70	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: invokestatic 73	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: goto -36 -> 95
    //   134: getstatic 25	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glF	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a;
    //   137: aload_0
    //   138: aload_0
    //   139: invokeinterface 79 1 0
    //   144: invokevirtual 83	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;I)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   147: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   150: invokevirtual 87	org/json/JSONObject:toString	()Ljava/lang/String;
    //   153: invokevirtual 91	com/tencent/mm/plugin/appbrand/jsapi/ac:tM	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   156: invokevirtual 94	com/tencent/mm/plugin/appbrand/jsapi/ac:dispatch	()V
    //   159: ldc 37
    //   161: ldc 96
    //   163: iconst_1
    //   164: anewarray 70	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/m$a:glG	Lorg/json/JSONObject;
    //   172: invokevirtual 87	org/json/JSONObject:toString	()Ljava/lang/String;
    //   175: aastore
    //   176: invokestatic 99	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: goto -165 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
    //   0	182	1	paramString1	String
    //   0	182	2	paramString2	String
    //   0	182	3	paramString3	String
    //   0	182	4	paramString4	String
    // Exception table:
    //   from	to	target	type
    //   7	14	109	finally
    //   18	95	109	finally
    //   99	106	109	finally
    //   116	131	109	finally
    //   134	179	109	finally
    //   18	95	115	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.m.a
 * JD-Core Version:    0.7.0.1
 */