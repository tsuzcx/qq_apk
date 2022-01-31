package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class o$a
  extends ai
{
  private static final int CTRL_INDEX = 190;
  private static final String NAME = "onBluetoothDeviceFound";
  private static JSONObject hFF;
  private static a hFK;
  
  static
  {
    AppMethodBeat.i(94211);
    hFK = new a();
    hFF = new JSONObject();
    AppMethodBeat.o(94211);
  }
  
  /* Error */
  public static void a(c paramc, d paramd)
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
    //   28: new 58	org/json/JSONArray
    //   31: dup
    //   32: invokespecial 59	org/json/JSONArray:<init>	()V
    //   35: astore_2
    //   36: aload_2
    //   37: aload_1
    //   38: invokevirtual 65	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/d:aBI	()Lorg/json/JSONObject;
    //   41: invokevirtual 69	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   44: pop
    //   45: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:hFF	Lorg/json/JSONObject;
    //   48: ldc 71
    //   50: invokevirtual 75	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: pop
    //   54: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:hFF	Lorg/json/JSONObject;
    //   57: ldc 71
    //   59: aload_2
    //   60: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   63: pop
    //   64: aload_0
    //   65: ifnonnull +62 -> 127
    //   68: ldc 48
    //   70: ldc 80
    //   72: invokestatic 83	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: ldc 46
    //   77: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: goto -56 -> 24
    //   83: astore_0
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_0
    //   88: athrow
    //   89: astore_1
    //   90: ldc 48
    //   92: ldc 85
    //   94: iconst_1
    //   95: anewarray 87	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_1
    //   101: aastore
    //   102: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: goto -60 -> 45
    //   108: astore_1
    //   109: ldc 48
    //   111: ldc 85
    //   113: iconst_1
    //   114: anewarray 87	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_1
    //   120: aastore
    //   121: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   124: goto -60 -> 64
    //   127: getstatic 32	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:hFK	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a;
    //   130: aload_0
    //   131: aload_0
    //   132: invokeinterface 96 1 0
    //   137: invokevirtual 100	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;I)Lcom/tencent/mm/plugin/appbrand/jsapi/ai;
    //   140: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:hFF	Lorg/json/JSONObject;
    //   143: invokevirtual 104	org/json/JSONObject:toString	()Ljava/lang/String;
    //   146: invokevirtual 108	com/tencent/mm/plugin/appbrand/jsapi/ai:BN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/ai;
    //   149: invokevirtual 111	com/tencent/mm/plugin/appbrand/jsapi/ai:aBz	()V
    //   152: ldc 48
    //   154: ldc 113
    //   156: iconst_1
    //   157: anewarray 87	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:hFF	Lorg/json/JSONObject;
    //   165: invokevirtual 104	org/json/JSONObject:toString	()Ljava/lang/String;
    //   168: aastore
    //   169: invokestatic 115	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   172: ldc 46
    //   174: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: goto -153 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramc	c
    //   0	180	1	paramd	d
    //   35	25	2	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   3	8	83	finally
    //   12	24	83	finally
    //   28	36	83	finally
    //   36	45	83	finally
    //   45	64	83	finally
    //   68	80	83	finally
    //   90	105	83	finally
    //   109	124	83	finally
    //   127	177	83	finally
    //   36	45	89	org/json/JSONException
    //   45	64	108	org/json/JSONException
  }
  
  public static void a(c paramc, List<d> paramList)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(94210);
        if (paramc == null)
        {
          ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
          AppMethodBeat.o(94210);
          return;
        }
        JSONArray localJSONArray = new JSONArray();
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          d locald = (d)paramList.next();
          try
          {
            localJSONArray.put(locald.aBI());
          }
          catch (JSONException localJSONException)
          {
            ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
          }
        }
        else
        {
          try
          {
            hFF.remove("devices");
            hFF.put("devices", localJSONArray);
            if (paramc == null)
            {
              ab.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
              AppMethodBeat.o(94210);
            }
          }
          catch (JSONException paramList)
          {
            for (;;)
            {
              ab.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { paramList });
            }
            hFK.b(paramc, paramc.aAN()).BN(hFF.toString()).aBz();
            ab.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[] { hFF.toString() });
            AppMethodBeat.o(94210);
          }
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o.a
 * JD-Core Version:    0.7.0.1
 */