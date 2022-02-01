package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import android.os.ParcelUuid;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.i;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
public final class o
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  private static final int CTRL_INDEX = 176;
  private static final String NAME = "startBluetoothDevicesDiscovery";
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(144524);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(11);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "startBluetoothDevicesDiscovery data is null");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10013));
      paramf.i(paramInt, n("fail:invalid data", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(13, 14);
      AppMethodBeat.o(144524);
      return;
    }
    Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "appId:%s startBluetoothDevicesDiscovery data:%s", new Object[] { paramf.getAppId(), paramJSONObject });
    Object localObject3 = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.ZC(paramf.getAppId());
    if (localObject3 == null)
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bleWorker is null, may not open ble");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10000));
      paramf.i(paramInt, n("fail:not init", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(13, 16);
      AppMethodBeat.o(144524);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(13, 18);
      AppMethodBeat.o(144524);
      return;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.c.bFE())
    {
      Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "adapter is null or not enabled!");
      paramJSONObject = new HashMap();
      paramJSONObject.put("errCode", Integer.valueOf(10001));
      paramf.i(paramInt, n("fail:not available", paramJSONObject));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dY(13, 18);
      AppMethodBeat.o(144524);
      return;
    }
    boolean bool1 = paramJSONObject.optBoolean("allowDuplicatesKey");
    int j = paramJSONObject.optInt("interval");
    String str = paramJSONObject.optString("powerLevel", "medium");
    boolean bool2 = paramJSONObject.optBoolean("customParsePacket", true);
    boolean bool3 = paramJSONObject.optBoolean("refreshCache", true);
    Object localObject1 = null;
    if (paramJSONObject.has("services"))
    {
      localObject2 = new ArrayList();
      try
      {
        paramJSONObject = new JSONArray(paramJSONObject.optString("services"));
        int i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= paramJSONObject.length()) {
            break;
          }
          localObject1 = ParcelUuid.fromString(paramJSONObject.getString(i).toUpperCase());
          ((List)localObject2).add(new ScanFilterCompat.a().a((ParcelUuid)localObject1).bFx());
          i += 1;
        }
        paramJSONObject = new a.a();
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "get uuid error!");
        paramJSONObject = new HashMap();
        paramJSONObject.put("isDiscovering", Boolean.FALSE);
        paramJSONObject.put("errCode", Integer.valueOf(10004));
        paramf.i(paramInt, n("fail:no service", paramJSONObject));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(13);
        AppMethodBeat.o(144524);
        return;
      }
    }
    paramJSONObject.gTn = j;
    paramJSONObject.lMd = bool1;
    paramJSONObject.lMm = str;
    paramJSONObject.lMq = bool2;
    paramJSONObject.lMo = bool3;
    paramJSONObject = paramJSONObject.bFn();
    if (((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject3).bFg() != null)
    {
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.d.a.i("MicroMsg.Ble.BleManager", "initBleConfig:%s", new Object[] { paramJSONObject });
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a.a(paramJSONObject);
    }
    paramJSONObject = new com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.b()
    {
      public final void a(j paramAnonymousj)
      {
        AppMethodBeat.i(144518);
        Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[onScanResult]result:%s", new Object[] { paramAnonymousj });
        switch (paramAnonymousj.errCode)
        {
        default: 
          HashMap localHashMap = new HashMap();
          localHashMap.put("errCode", Integer.valueOf(paramAnonymousj.errCode));
          localHashMap.put("isDiscovering", Boolean.FALSE);
          paramf.i(paramInt, o.this.n(paramAnonymousj.errMsg, localHashMap));
          com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(13);
          AppMethodBeat.o(144518);
          return;
        }
        paramAnonymousj = new HashMap();
        paramAnonymousj.put("errCode", Integer.valueOf(0));
        paramAnonymousj.put("isDiscovering", Boolean.TRUE);
        paramf.i(paramInt, o.this.n("ok", paramAnonymousj));
        com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.pl(12);
        AppMethodBeat.o(144518);
      }
    };
    Object localObject2 = new i()
    {
      public final void a(com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d paramAnonymousd)
      {
        AppMethodBeat.i(144519);
        o.a.a(paramf, paramAnonymousd);
        AppMethodBeat.o(144519);
      }
      
      public final void bA(List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> paramAnonymousList)
      {
        AppMethodBeat.i(144520);
        o.a.a(paramf, paramAnonymousList);
        AppMethodBeat.o(144520);
      }
    };
    localObject3 = ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b)localObject3).bFg();
    if (localObject3 != null) {
      ((com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.b)localObject3).lMs.a(paramJSONObject, (List)localObject1, (i)localObject2);
    }
    l.c.a(paramf, true, true);
    AppMethodBeat.o(144524);
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 190;
    private static final String NAME = "onBluetoothDeviceFound";
    private static JSONObject lKZ;
    private static a lLh;
    
    static
    {
      AppMethodBeat.i(144523);
      lLh = new a();
      lKZ = new JSONObject();
      AppMethodBeat.o(144523);
    }
    
    /* Error */
    public static void a(f paramf, com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d paramd)
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
      //   16: invokestatic 56	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   38: invokevirtual 65	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/c/d:bEw	()Lorg/json/JSONObject;
      //   41: invokevirtual 69	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
      //   44: pop
      //   45: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/o$a:lKZ	Lorg/json/JSONObject;
      //   48: ldc 71
      //   50: invokevirtual 75	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   53: pop
      //   54: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/o$a:lKZ	Lorg/json/JSONObject;
      //   57: ldc 71
      //   59: aload_2
      //   60: invokevirtual 78	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   63: pop
      //   64: aload_0
      //   65: ifnonnull +62 -> 127
      //   68: ldc 48
      //   70: ldc 80
      //   72: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   102: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   121: invokestatic 90	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   124: goto -60 -> 64
      //   127: getstatic 32	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/o$a:lLh	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/o$a;
      //   130: aload_0
      //   131: aload_0
      //   132: invokeinterface 96 1 0
      //   137: invokevirtual 100	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/o$a:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;I)Lcom/tencent/mm/plugin/appbrand/jsapi/bc;
      //   140: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/o$a:lKZ	Lorg/json/JSONObject;
      //   143: invokevirtual 104	org/json/JSONObject:toString	()Ljava/lang/String;
      //   146: invokevirtual 108	com/tencent/mm/plugin/appbrand/jsapi/bc:Zh	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/bc;
      //   149: invokevirtual 111	com/tencent/mm/plugin/appbrand/jsapi/bc:bEo	()V
      //   152: ldc 48
      //   154: ldc 113
      //   156: iconst_1
      //   157: anewarray 87	java/lang/Object
      //   160: dup
      //   161: iconst_0
      //   162: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/o$a:lKZ	Lorg/json/JSONObject;
      //   165: invokevirtual 104	org/json/JSONObject:toString	()Ljava/lang/String;
      //   168: aastore
      //   169: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   172: ldc 46
      //   174: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   177: goto -153 -> 24
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	180	0	paramf	f
      //   0	180	1	paramd	com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d
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
    
    public static void a(f paramf, List<com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d> paramList)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(144522);
          if (paramf == null)
          {
            Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothAdapterStateChangeEvent dispatch fail, service is null");
            AppMethodBeat.o(144522);
            return;
          }
          JSONArray localJSONArray = new JSONArray();
          paramList = paramList.iterator();
          if (paramList.hasNext())
          {
            com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d locald = (com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.d)paramList.next();
            try
            {
              localJSONArray.put(locald.bEw());
            }
            catch (JSONException localJSONException)
            {
              Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { localJSONException });
            }
          }
          else
          {
            try
            {
              lKZ.remove("devices");
              lKZ.put("devices", localJSONArray);
              if (paramf == null)
              {
                Log.w("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "service is null, fail");
                AppMethodBeat.o(144522);
              }
            }
            catch (JSONException paramList)
            {
              for (;;)
              {
                Log.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[] { paramList });
              }
              lLh.b(paramf, paramf.getComponentId()).Zh(lKZ.toString()).bEo();
              Log.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "OnBluetoothDeviceFoundEvent %s", new Object[] { lKZ.toString() });
              AppMethodBeat.o(144522);
            }
          }
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.o
 * JD-Core Version:    0.7.0.1
 */