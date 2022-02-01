package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

public final class o
{
  private s cgM;
  n cgN;
  public f cgO;
  public p cgP;
  public ConcurrentHashMap<String, l> cgQ;
  private ConcurrentHashMap<String, j> cgR;
  private ConcurrentHashMap<Integer, h> cgS;
  private AtomicInteger cgT;
  
  public o(s params)
  {
    AppMethodBeat.i(140336);
    this.cgQ = new ConcurrentHashMap();
    this.cgR = new ConcurrentHashMap();
    this.cgS = new ConcurrentHashMap();
    this.cgT = new AtomicInteger(1);
    this.cgM = params;
    this.cgN = new n(this);
    this.cgO = new f(this.cgM);
    this.cgP = new q(this);
    this.cgM.addJavascriptInterface(new r(this.cgN), "_luggageBridgeNative");
    AppMethodBeat.o(140336);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(140340);
    if ((j)this.cgR.get(parami.cgC) == null)
    {
      ad.e("LuggageBridge", "no listener for event: %s", new Object[] { parami.cgC });
      AppMethodBeat.o(140340);
      return;
    }
    AppMethodBeat.o(140340);
  }
  
  /* Error */
  public final void BL()
  {
    // Byte code:
    //   0: ldc 114
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: sipush 4096
    //   8: newarray char
    //   10: astore 5
    //   12: new 116	java/io/StringWriter
    //   15: dup
    //   16: invokespecial 117	java/io/StringWriter:<init>	()V
    //   19: astore 4
    //   21: new 119	java/io/InputStreamReader
    //   24: dup
    //   25: aload_0
    //   26: getfield 50	com/tencent/luggage/bridge/o:cgM	Lcom/tencent/luggage/bridge/s;
    //   29: invokeinterface 123 1 0
    //   34: invokevirtual 129	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   37: ldc 131
    //   39: invokevirtual 137	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   42: invokespecial 140	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   45: astore_3
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: aload 5
    //   51: invokevirtual 144	java/io/InputStreamReader:read	([C)I
    //   54: istore_1
    //   55: iconst_m1
    //   56: iload_1
    //   57: if_icmpeq +51 -> 108
    //   60: aload_3
    //   61: astore_2
    //   62: aload 4
    //   64: aload 5
    //   66: iconst_0
    //   67: iload_1
    //   68: invokevirtual 148	java/io/StringWriter:write	([CII)V
    //   71: goto -25 -> 46
    //   74: astore 4
    //   76: aload_3
    //   77: astore_2
    //   78: ldc 102
    //   80: ldc 150
    //   82: iconst_1
    //   83: anewarray 4	java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: aload 4
    //   90: aastore
    //   91: invokestatic 110	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 153	java/io/InputStreamReader:close	()V
    //   102: ldc 114
    //   104: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: aload_3
    //   109: invokevirtual 153	java/io/InputStreamReader:close	()V
    //   112: aload_0
    //   113: getfield 50	com/tencent/luggage/bridge/o:cgM	Lcom/tencent/luggage/bridge/s;
    //   116: aload 4
    //   118: invokevirtual 157	java/io/StringWriter:toString	()Ljava/lang/String;
    //   121: aconst_null
    //   122: invokeinterface 161 3 0
    //   127: ldc 114
    //   129: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: return
    //   133: astore_2
    //   134: ldc 102
    //   136: ldc 163
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_2
    //   145: aastore
    //   146: invokestatic 110	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: goto -37 -> 112
    //   152: astore_2
    //   153: ldc 102
    //   155: ldc 163
    //   157: iconst_1
    //   158: anewarray 4	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_2
    //   164: aastore
    //   165: invokestatic 110	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: ldc 114
    //   170: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: return
    //   174: astore_3
    //   175: aconst_null
    //   176: astore_2
    //   177: aload_2
    //   178: ifnull +7 -> 185
    //   181: aload_2
    //   182: invokevirtual 153	java/io/InputStreamReader:close	()V
    //   185: ldc 114
    //   187: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: aload_3
    //   191: athrow
    //   192: astore_2
    //   193: ldc 102
    //   195: ldc 163
    //   197: iconst_1
    //   198: anewarray 4	java/lang/Object
    //   201: dup
    //   202: iconst_0
    //   203: aload_2
    //   204: aastore
    //   205: invokestatic 110	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: goto -23 -> 185
    //   211: astore_3
    //   212: goto -35 -> 177
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_3
    //   219: goto -143 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	o
    //   54	14	1	i	int
    //   47	31	2	localInputStreamReader1	java.io.InputStreamReader
    //   133	12	2	localException1	java.lang.Exception
    //   152	12	2	localException2	java.lang.Exception
    //   176	6	2	localObject1	Object
    //   192	12	2	localException3	java.lang.Exception
    //   45	64	3	localInputStreamReader2	java.io.InputStreamReader
    //   174	17	3	localObject2	Object
    //   211	1	3	localObject3	Object
    //   218	1	3	localObject4	Object
    //   19	44	4	localStringWriter	java.io.StringWriter
    //   74	43	4	localException4	java.lang.Exception
    //   215	1	4	localException5	java.lang.Exception
    //   10	55	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   48	55	74	java/lang/Exception
    //   62	71	74	java/lang/Exception
    //   108	112	133	java/lang/Exception
    //   98	102	152	java/lang/Exception
    //   21	46	174	finally
    //   181	185	192	java/lang/Exception
    //   48	55	211	finally
    //   62	71	211	finally
    //   78	94	211	finally
    //   21	46	215	java/lang/Exception
  }
  
  final e a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(140338);
    for (;;)
    {
      try
      {
        paramm = new k(this.cgO, paramm, paramBoolean);
        l locall = (l)this.cgQ.get(paramm.cgz);
        if (locall != null)
        {
          locall.a(paramm);
          if (!paramm.cgF) {
            break;
          }
          paramm = paramm.BK();
          AppMethodBeat.o(140338);
          return paramm;
        }
      }
      catch (JSONException paramm)
      {
        ad.e("LuggageBridge", "inflate Js2JavaInvokeContext failed: %s", new Object[] { paramm });
        AppMethodBeat.o(140338);
        return null;
      }
      ad.e("LuggageBridge", "Invoke Listener Not Found: %s", new Object[] { paramm.cgz });
      paramm.a("system:function_not_exist", null);
    }
    AppMethodBeat.o(140338);
    return null;
  }
  
  final void a(m paramm)
  {
    AppMethodBeat.i(140339);
    try
    {
      paramm = new i(paramm);
      ad.i("LuggageBridge", "processEventFromJs, EventName = %s", new Object[] { paramm.cgC });
      a(paramm);
      AppMethodBeat.o(140339);
      return;
    }
    catch (JSONException paramm)
    {
      ad.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", new Object[] { paramm });
      AppMethodBeat.o(140339);
    }
  }
  
  final void b(m paramm)
  {
    AppMethodBeat.i(140341);
    try
    {
      paramm = new g(paramm);
      if ((h)this.cgS.get(Integer.valueOf(paramm.cgA)) == null)
      {
        ad.e("LuggageBridge", "no listener for callback: %d", new Object[] { Integer.valueOf(paramm.cgA) });
        AppMethodBeat.o(140341);
        return;
      }
    }
    catch (JSONException paramm)
    {
      ad.e("LuggageBridge", "inflate Js2JavaEventContext failed: %s", new Object[] { paramm });
      AppMethodBeat.o(140341);
      return;
    }
    if (!paramm.cgB) {
      this.cgS.remove(Integer.valueOf(paramm.cgA));
    }
    AppMethodBeat.o(140341);
  }
  
  public final void cv(String paramString)
  {
    AppMethodBeat.i(140337);
    this.cgM.evaluateJavascript(paramString, null);
    AppMethodBeat.o(140337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.o
 * JD-Core Version:    0.7.0.1
 */