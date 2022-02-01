package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

public final class o
{
  private s bZA;
  n bZB;
  public f bZC;
  public p bZD;
  public ConcurrentHashMap<String, l> bZE;
  private ConcurrentHashMap<String, j> bZF;
  private ConcurrentHashMap<Integer, h> bZG;
  private AtomicInteger bZH;
  
  public o(s params)
  {
    AppMethodBeat.i(140336);
    this.bZE = new ConcurrentHashMap();
    this.bZF = new ConcurrentHashMap();
    this.bZG = new ConcurrentHashMap();
    this.bZH = new AtomicInteger(1);
    this.bZA = params;
    this.bZB = new n(this);
    this.bZC = new f(this.bZA);
    this.bZD = new q(this);
    this.bZA.addJavascriptInterface(new r(this.bZB), "_luggageBridgeNative");
    AppMethodBeat.o(140336);
  }
  
  private void a(i parami)
  {
    AppMethodBeat.i(140340);
    if ((j)this.bZF.get(parami.bZq) == null)
    {
      ad.e("LuggageBridge", "no listener for event: %s", new Object[] { parami.bZq });
      AppMethodBeat.o(140340);
      return;
    }
    AppMethodBeat.o(140340);
  }
  
  /* Error */
  public final void AK()
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
    //   26: getfield 50	com/tencent/luggage/bridge/o:bZA	Lcom/tencent/luggage/bridge/s;
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
    //   113: getfield 50	com/tencent/luggage/bridge/o:bZA	Lcom/tencent/luggage/bridge/s;
    //   116: aload 4
    //   118: invokevirtual 157	java/io/StringWriter:toString	()Ljava/lang/String;
    //   121: invokeinterface 161 2 0
    //   126: ldc 114
    //   128: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: astore_2
    //   133: ldc 102
    //   135: ldc 163
    //   137: iconst_1
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: aload_2
    //   144: aastore
    //   145: invokestatic 110	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: goto -36 -> 112
    //   151: astore_2
    //   152: ldc 102
    //   154: ldc 163
    //   156: iconst_1
    //   157: anewarray 4	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_2
    //   163: aastore
    //   164: invokestatic 110	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: ldc 114
    //   169: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: return
    //   173: astore_3
    //   174: aconst_null
    //   175: astore_2
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 153	java/io/InputStreamReader:close	()V
    //   184: ldc 114
    //   186: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_3
    //   190: athrow
    //   191: astore_2
    //   192: ldc 102
    //   194: ldc 163
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: aload_2
    //   203: aastore
    //   204: invokestatic 110	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: goto -23 -> 184
    //   210: astore_3
    //   211: goto -35 -> 176
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_3
    //   218: goto -142 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	this	o
    //   54	14	1	i	int
    //   47	31	2	localInputStreamReader1	java.io.InputStreamReader
    //   132	12	2	localException1	java.lang.Exception
    //   151	12	2	localException2	java.lang.Exception
    //   175	6	2	localObject1	Object
    //   191	12	2	localException3	java.lang.Exception
    //   45	64	3	localInputStreamReader2	java.io.InputStreamReader
    //   173	17	3	localObject2	Object
    //   210	1	3	localObject3	Object
    //   217	1	3	localObject4	Object
    //   19	44	4	localStringWriter	java.io.StringWriter
    //   74	43	4	localException4	java.lang.Exception
    //   214	1	4	localException5	java.lang.Exception
    //   10	55	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   48	55	74	java/lang/Exception
    //   62	71	74	java/lang/Exception
    //   108	112	132	java/lang/Exception
    //   98	102	151	java/lang/Exception
    //   21	46	173	finally
    //   180	184	191	java/lang/Exception
    //   48	55	210	finally
    //   62	71	210	finally
    //   78	94	210	finally
    //   21	46	214	java/lang/Exception
  }
  
  final e a(m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(140338);
    for (;;)
    {
      try
      {
        paramm = new k(this.bZC, paramm, paramBoolean);
        l locall = (l)this.bZE.get(paramm.bZn);
        if (locall != null)
        {
          locall.a(paramm);
          if (!paramm.bZt) {
            break;
          }
          paramm = paramm.AJ();
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
      ad.e("LuggageBridge", "Invoke Listener Not Found: %s", new Object[] { paramm.bZn });
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
      ad.i("LuggageBridge", "processEventFromJs, EventName = %s", new Object[] { paramm.bZq });
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
      if ((h)this.bZG.get(Integer.valueOf(paramm.bZo)) == null)
      {
        ad.e("LuggageBridge", "no listener for callback: %d", new Object[] { Integer.valueOf(paramm.bZo) });
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
    if (!paramm.bZp) {
      this.bZG.remove(Integer.valueOf(paramm.bZo));
    }
    AppMethodBeat.o(140341);
  }
  
  public final void bM(String paramString)
  {
    AppMethodBeat.i(140337);
    this.bZA.bO(paramString);
    AppMethodBeat.o(140337);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.bridge.o
 * JD-Core Version:    0.7.0.1
 */