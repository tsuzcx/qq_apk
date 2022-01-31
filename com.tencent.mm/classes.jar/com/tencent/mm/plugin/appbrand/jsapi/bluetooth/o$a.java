package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class o$a
  extends ac
{
  private static final int CTRL_INDEX = 190;
  private static final String NAME = "onBluetoothDeviceFound";
  private static JSONObject glG = new JSONObject();
  private static a glL = new a();
  
  /* Error */
  public static void a(c paramc, d paramd)
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
    //   18: new 47	org/json/JSONArray
    //   21: dup
    //   22: invokespecial 48	org/json/JSONArray:<init>	()V
    //   25: astore_2
    //   26: aload_2
    //   27: aload_1
    //   28: invokevirtual 54	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/d:ahT	()Lorg/json/JSONObject;
    //   31: invokevirtual 58	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   34: pop
    //   35: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:glG	Lorg/json/JSONObject;
    //   38: ldc 60
    //   40: invokevirtual 64	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   43: pop
    //   44: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:glG	Lorg/json/JSONObject;
    //   47: ldc 60
    //   49: aload_2
    //   50: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   53: pop
    //   54: aload_0
    //   55: ifnonnull +57 -> 112
    //   58: ldc 37
    //   60: ldc 69
    //   62: invokestatic 72	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: goto -51 -> 14
    //   68: astore_0
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    //   74: astore_1
    //   75: ldc 37
    //   77: ldc 74
    //   79: iconst_1
    //   80: anewarray 76	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: aload_1
    //   86: aastore
    //   87: invokestatic 79	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: goto -55 -> 35
    //   93: astore_1
    //   94: ldc 37
    //   96: ldc 74
    //   98: iconst_1
    //   99: anewarray 76	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_1
    //   105: aastore
    //   106: invokestatic 79	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -55 -> 54
    //   112: getstatic 25	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:glL	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a;
    //   115: aload_0
    //   116: aload_0
    //   117: invokeinterface 85 1 0
    //   122: invokevirtual 89	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;I)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   125: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:glG	Lorg/json/JSONObject;
    //   128: invokevirtual 93	org/json/JSONObject:toString	()Ljava/lang/String;
    //   131: invokevirtual 97	com/tencent/mm/plugin/appbrand/jsapi/ac:tM	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/ac;
    //   134: invokevirtual 100	com/tencent/mm/plugin/appbrand/jsapi/ac:dispatch	()V
    //   137: ldc 37
    //   139: ldc 102
    //   141: iconst_1
    //   142: anewarray 76	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: getstatic 30	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/o$a:glG	Lorg/json/JSONObject;
    //   150: invokevirtual 93	org/json/JSONObject:toString	()Ljava/lang/String;
    //   153: aastore
    //   154: invokestatic 105	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   157: goto -143 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramc	c
    //   0	160	1	paramd	d
    //   25	25	2	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   7	14	68	finally
    //   18	26	68	finally
    //   26	35	68	finally
    //   35	54	68	finally
    //   58	65	68	finally
    //   75	90	68	finally
    //   94	109	68	finally
    //   112	157	68	finally
    //   26	35	74	org/json/JSONException
    //   35	54	93	org/json/JSONException
  }
  
  public static void a(c paramc, List<d> paramList)
  {
    if (paramc == null) {}
    for (;;)
    {
      try
      {
        y.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
        return;
      }
      finally {}
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        try
        {
          localJSONArray.put(locald.ahT());
        }
        catch (JSONException localJSONException)
        {
          y.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
        }
      }
      else
      {
        try
        {
          glG.remove("devices");
          glG.put("devices", localJSONArray);
          if (paramc == null) {
            y.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
          }
        }
        catch (JSONException paramList)
        {
          for (;;)
          {
            y.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { paramList });
          }
          glL.b(paramc, paramc.ahJ()).tM(glG.toString()).dispatch();
          y.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[] { glG.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.o.a
 * JD-Core Version:    0.7.0.1
 */