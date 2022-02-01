package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a;

import android.annotation.TargetApi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.g;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.h;
import com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.c.j;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@TargetApi(18)
public final class l
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  private static final int CTRL_INDEX = 173;
  private static final String NAME = "openBluetoothAdapter";
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(144515);
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(0);
    paramJSONObject = paramc.getAppId();
    ac.i("MicroMsg.JsApiOpenBluetoothAdapter", "appid:%s openBluetoothAdapter!", new Object[] { paramJSONObject });
    paramJSONObject = com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.a(paramJSONObject, new b.a()new h
    {
      public final void gm(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(144506);
        l.c.a(paramc, paramAnonymousBoolean, false);
        AppMethodBeat.o(144506);
      }
    }, new h()new g
    {
      public final void am(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(144507);
        l.b.a(paramc, paramAnonymousString, paramAnonymousBoolean);
        AppMethodBeat.o(144507);
      }
    }, new g()
    {
      public final void i(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(144508);
        l.a.a(paramc, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4);
        AppMethodBeat.o(144508);
      }
    });
    HashMap localHashMap = new HashMap();
    switch (paramJSONObject.errCode)
    {
    default: 
      localHashMap.put("errCode", Integer.valueOf(paramJSONObject.errCode));
      paramc.h(paramInt, k(paramJSONObject.errMsg, localHashMap));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(2);
      AppMethodBeat.o(144515);
      return;
    case 0: 
      paramc.h(paramInt, k("ok", localHashMap));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.lA(1);
      AppMethodBeat.o(144515);
      return;
    case 10009: 
      localHashMap.put("errCode", Integer.valueOf(10009));
      paramc.h(paramInt, k("fail:system not support", localHashMap));
      com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(2, 8);
      AppMethodBeat.o(144515);
      return;
    }
    localHashMap.put("errCode", Integer.valueOf(10001));
    paramc.h(paramInt, k("fail:not available", localHashMap));
    com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c.dL(2, 7);
    AppMethodBeat.o(144515);
  }
  
  static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 187;
    private static final String NAME = "onBLECharacteristicValueChange";
    private static a kiq;
    private static JSONObject kir;
    
    static
    {
      AppMethodBeat.i(144510);
      kiq = new a();
      kir = new JSONObject();
      AppMethodBeat.o(144510);
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
      //   16: invokestatic 56	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: ldc 46
      //   21: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   24: ldc 2
      //   26: monitorexit
      //   27: return
      //   28: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   31: ldc 58
      //   33: invokevirtual 62	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   36: pop
      //   37: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   40: ldc 58
      //   42: aload 4
      //   44: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   47: pop
      //   48: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   51: ldc 68
      //   53: invokevirtual 62	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   56: pop
      //   57: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   60: ldc 68
      //   62: aload_1
      //   63: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   66: pop
      //   67: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   70: ldc 70
      //   72: invokevirtual 62	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   75: pop
      //   76: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   79: ldc 70
      //   81: aload_2
      //   82: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   85: pop
      //   86: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   89: ldc 72
      //   91: invokevirtual 62	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   94: pop
      //   95: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   98: ldc 72
      //   100: aload_3
      //   101: invokevirtual 66	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   104: pop
      //   105: aload_0
      //   106: ifnonnull +43 -> 149
      //   109: ldc 48
      //   111: ldc 74
      //   113: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
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
      //   143: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   146: goto -41 -> 105
      //   149: getstatic 32	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kiq	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a;
      //   152: aload_0
      //   153: aload_0
      //   154: invokeinterface 90 1 0
      //   159: invokevirtual 94	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;I)Lcom/tencent/mm/plugin/appbrand/jsapi/ar;
      //   162: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   165: invokevirtual 98	org/json/JSONObject:toString	()Ljava/lang/String;
      //   168: invokevirtual 102	com/tencent/mm/plugin/appbrand/jsapi/ar:LO	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/ar;
      //   171: invokevirtual 105	com/tencent/mm/plugin/appbrand/jsapi/ar:beN	()V
      //   174: ldc 48
      //   176: ldc 107
      //   178: iconst_1
      //   179: anewarray 81	java/lang/Object
      //   182: dup
      //   183: iconst_0
      //   184: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$a:kir	Lorg/json/JSONObject;
      //   187: invokevirtual 98	org/json/JSONObject:toString	()Ljava/lang/String;
      //   190: aastore
      //   191: invokestatic 109	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 188;
    private static final String NAME = "onBLEConnectionStateChanged";
    private static JSONObject kir;
    private static b kis;
    
    static
    {
      AppMethodBeat.i(144512);
      kis = new b();
      kir = new JSONObject();
      AppMethodBeat.o(144512);
    }
    
    /* Error */
    public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString, boolean paramBoolean)
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 47
      //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: ifnonnull +19 -> 28
      //   12: ldc 49
      //   14: ldc 51
      //   16: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: ldc 47
      //   21: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   24: ldc 2
      //   26: monitorexit
      //   27: return
      //   28: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b:kir	Lorg/json/JSONObject;
      //   31: ldc 59
      //   33: invokevirtual 63	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   36: pop
      //   37: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b:kir	Lorg/json/JSONObject;
      //   40: ldc 59
      //   42: aload_1
      //   43: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
      //   46: pop
      //   47: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b:kir	Lorg/json/JSONObject;
      //   50: ldc 69
      //   52: invokevirtual 63	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   55: pop
      //   56: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b:kir	Lorg/json/JSONObject;
      //   59: ldc 69
      //   61: iload_2
      //   62: invokevirtual 72	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
      //   65: pop
      //   66: aload_0
      //   67: ifnonnull +43 -> 110
      //   70: ldc 49
      //   72: ldc 74
      //   74: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   77: ldc 47
      //   79: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   82: goto -58 -> 24
      //   85: astore_0
      //   86: ldc 2
      //   88: monitorexit
      //   89: aload_0
      //   90: athrow
      //   91: astore_1
      //   92: ldc 49
      //   94: ldc 79
      //   96: iconst_1
      //   97: anewarray 81	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_1
      //   103: aastore
      //   104: invokestatic 84	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   107: goto -41 -> 66
      //   110: getstatic 32	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b:kis	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b;
      //   113: aload_0
      //   114: aload_0
      //   115: invokeinterface 90 1 0
      //   120: invokevirtual 93	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;I)Lcom/tencent/mm/plugin/appbrand/jsapi/ar;
      //   123: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b:kir	Lorg/json/JSONObject;
      //   126: invokevirtual 97	org/json/JSONObject:toString	()Ljava/lang/String;
      //   129: invokevirtual 101	com/tencent/mm/plugin/appbrand/jsapi/ar:LO	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/ar;
      //   132: invokevirtual 104	com/tencent/mm/plugin/appbrand/jsapi/ar:beN	()V
      //   135: ldc 49
      //   137: ldc 106
      //   139: iconst_1
      //   140: anewarray 81	java/lang/Object
      //   143: dup
      //   144: iconst_0
      //   145: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$b:kir	Lorg/json/JSONObject;
      //   148: invokevirtual 97	org/json/JSONObject:toString	()Ljava/lang/String;
      //   151: aastore
      //   152: invokestatic 108	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   155: ldc 47
      //   157: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   160: goto -136 -> 24
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
      //   0	163	1	paramString	String
      //   0	163	2	paramBoolean	boolean
      // Exception table:
      //   from	to	target	type
      //   3	8	85	finally
      //   12	24	85	finally
      //   28	66	85	finally
      //   70	82	85	finally
      //   92	107	85	finally
      //   110	160	85	finally
      //   28	66	91	org/json/JSONException
    }
  }
  
  public static final class c
    extends ar
  {
    private static final int CTRL_INDEX = 189;
    private static final String NAME = "onBluetoothAdapterStateChange";
    private static JSONObject kir;
    private static c kit;
    
    static
    {
      AppMethodBeat.i(144514);
      kit = new c();
      kir = new JSONObject();
      AppMethodBeat.o(144514);
    }
    
    /* Error */
    public static void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, boolean paramBoolean1, boolean paramBoolean2)
    {
      // Byte code:
      //   0: ldc 2
      //   2: monitorenter
      //   3: ldc 47
      //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   8: aload_0
      //   9: ifnonnull +19 -> 28
      //   12: ldc 49
      //   14: ldc 51
      //   16: invokestatic 57	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: ldc 47
      //   21: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   24: ldc 2
      //   26: monitorexit
      //   27: return
      //   28: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c:kir	Lorg/json/JSONObject;
      //   31: ldc 59
      //   33: invokevirtual 63	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   36: pop
      //   37: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c:kir	Lorg/json/JSONObject;
      //   40: ldc 59
      //   42: iload_1
      //   43: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
      //   46: pop
      //   47: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c:kir	Lorg/json/JSONObject;
      //   50: ldc 69
      //   52: invokevirtual 63	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
      //   55: pop
      //   56: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c:kir	Lorg/json/JSONObject;
      //   59: ldc 69
      //   61: iload_2
      //   62: invokevirtual 67	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
      //   65: pop
      //   66: aload_0
      //   67: ifnonnull +43 -> 110
      //   70: ldc 49
      //   72: ldc 71
      //   74: invokestatic 74	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   77: ldc 47
      //   79: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   82: goto -58 -> 24
      //   85: astore_0
      //   86: ldc 2
      //   88: monitorexit
      //   89: aload_0
      //   90: athrow
      //   91: astore_3
      //   92: ldc 49
      //   94: ldc 76
      //   96: iconst_1
      //   97: anewarray 78	java/lang/Object
      //   100: dup
      //   101: iconst_0
      //   102: aload_3
      //   103: aastore
      //   104: invokestatic 81	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   107: goto -41 -> 66
      //   110: getstatic 32	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c:kit	Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c;
      //   113: aload_0
      //   114: aload_0
      //   115: invokeinterface 87 1 0
      //   120: invokevirtual 91	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c:b	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;I)Lcom/tencent/mm/plugin/appbrand/jsapi/ar;
      //   123: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c:kir	Lorg/json/JSONObject;
      //   126: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
      //   129: invokevirtual 99	com/tencent/mm/plugin/appbrand/jsapi/ar:LO	(Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/jsapi/ar;
      //   132: invokevirtual 102	com/tencent/mm/plugin/appbrand/jsapi/ar:beN	()V
      //   135: ldc 49
      //   137: ldc 104
      //   139: iconst_1
      //   140: anewarray 78	java/lang/Object
      //   143: dup
      //   144: iconst_0
      //   145: getstatic 37	com/tencent/mm/plugin/appbrand/jsapi/bluetooth/a/l$c:kir	Lorg/json/JSONObject;
      //   148: invokevirtual 95	org/json/JSONObject:toString	()Ljava/lang/String;
      //   151: aastore
      //   152: invokestatic 106	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   155: ldc 47
      //   157: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   160: goto -136 -> 24
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	paramc	com.tencent.mm.plugin.appbrand.jsapi.c
      //   0	163	1	paramBoolean1	boolean
      //   0	163	2	paramBoolean2	boolean
      //   91	12	3	localJSONException	org.json.JSONException
      // Exception table:
      //   from	to	target	type
      //   3	8	85	finally
      //   12	24	85	finally
      //   28	66	85	finally
      //   70	82	85	finally
      //   92	107	85	finally
      //   110	160	85	finally
      //   28	66	91	org/json/JSONException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.a.l
 * JD-Core Version:    0.7.0.1
 */