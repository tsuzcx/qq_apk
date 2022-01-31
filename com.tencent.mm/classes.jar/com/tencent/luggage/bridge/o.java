package com.tencent.luggage.bridge;

import com.tencent.luggage.j.c;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;

public final class o
{
  private s bhK;
  n bhL;
  public f bhM;
  public p bhN;
  public ConcurrentHashMap<String, l> bhO = new ConcurrentHashMap();
  ConcurrentHashMap<String, j> bhP = new ConcurrentHashMap();
  ConcurrentHashMap<Integer, h> bhQ = new ConcurrentHashMap();
  private AtomicInteger bhR = new AtomicInteger(1);
  
  public o(s params)
  {
    this.bhK = params;
    this.bhL = new n(this);
    this.bhM = new f(this.bhK);
    this.bhN = new q(this);
    this.bhK.addJavascriptInterface(new r(this.bhL), "_luggageBridgeNative");
  }
  
  final e a(m paramm, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        paramm = new k(this.bhM, paramm, paramBoolean);
        l locall = (l)this.bhO.get(paramm.bhw);
        if (locall != null)
        {
          locall.a(paramm);
          if (!paramm.bhC) {
            break;
          }
          return paramm.pR();
        }
      }
      catch (JSONException paramm)
      {
        c.e("LuggageBridge", "inflate Js2JavaInvokeContext failed: %s", new Object[] { paramm });
        return null;
      }
      c.e("LuggageBridge", "Invoke Listener Not Found: %s", new Object[] { paramm.bhw });
      paramm.a("Method not found", null);
    }
    return null;
  }
  
  public final void aV(String paramString)
  {
    this.bhK.aX(paramString);
  }
  
  /* Error */
  final void pS()
  {
    // Byte code:
    //   0: sipush 4096
    //   3: newarray char
    //   5: astore 5
    //   7: new 133	java/io/StringWriter
    //   10: dup
    //   11: invokespecial 134	java/io/StringWriter:<init>	()V
    //   14: astore 4
    //   16: new 136	java/io/InputStreamReader
    //   19: dup
    //   20: aload_0
    //   21: getfield 44	com/tencent/luggage/bridge/o:bhK	Lcom/tencent/luggage/bridge/s;
    //   24: invokeinterface 140 1 0
    //   29: invokevirtual 146	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: ldc 148
    //   34: invokevirtual 154	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: invokespecial 157	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: astore_3
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: aload 5
    //   46: invokevirtual 161	java/io/InputStreamReader:read	([C)I
    //   49: istore_1
    //   50: iconst_m1
    //   51: iload_1
    //   52: if_icmpeq +46 -> 98
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: aload 5
    //   61: iconst_0
    //   62: iload_1
    //   63: invokevirtual 165	java/io/StringWriter:write	([CII)V
    //   66: goto -25 -> 41
    //   69: astore 4
    //   71: aload_3
    //   72: astore_2
    //   73: ldc 108
    //   75: ldc 167
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload 4
    //   85: aastore
    //   86: invokestatic 116	com/tencent/luggage/j/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: aload_3
    //   90: ifnull +7 -> 97
    //   93: aload_3
    //   94: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   97: return
    //   98: aload_3
    //   99: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   102: aload_0
    //   103: getfield 44	com/tencent/luggage/bridge/o:bhK	Lcom/tencent/luggage/bridge/s;
    //   106: aload 4
    //   108: invokevirtual 174	java/io/StringWriter:toString	()Ljava/lang/String;
    //   111: invokeinterface 128 2 0
    //   116: return
    //   117: astore_2
    //   118: ldc 108
    //   120: ldc 176
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_2
    //   129: aastore
    //   130: invokestatic 116	com/tencent/luggage/j/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: goto -31 -> 102
    //   136: astore_2
    //   137: ldc 108
    //   139: ldc 176
    //   141: iconst_1
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_2
    //   148: aastore
    //   149: invokestatic 116	com/tencent/luggage/j/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: return
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 170	java/io/InputStreamReader:close	()V
    //   164: aload_3
    //   165: athrow
    //   166: astore_2
    //   167: ldc 108
    //   169: ldc 176
    //   171: iconst_1
    //   172: anewarray 4	java/lang/Object
    //   175: dup
    //   176: iconst_0
    //   177: aload_2
    //   178: aastore
    //   179: invokestatic 116	com/tencent/luggage/j/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: goto -18 -> 164
    //   185: astore_3
    //   186: goto -30 -> 156
    //   189: astore 4
    //   191: aconst_null
    //   192: astore_3
    //   193: goto -122 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	o
    //   49	14	1	i	int
    //   42	31	2	localInputStreamReader1	java.io.InputStreamReader
    //   117	12	2	localException1	java.lang.Exception
    //   136	12	2	localException2	java.lang.Exception
    //   155	6	2	localObject1	Object
    //   166	12	2	localException3	java.lang.Exception
    //   40	59	3	localInputStreamReader2	java.io.InputStreamReader
    //   153	12	3	localObject2	Object
    //   185	1	3	localObject3	Object
    //   192	1	3	localObject4	Object
    //   14	44	4	localStringWriter	java.io.StringWriter
    //   69	38	4	localException4	java.lang.Exception
    //   189	1	4	localException5	java.lang.Exception
    //   5	55	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   43	50	69	java/lang/Exception
    //   57	66	69	java/lang/Exception
    //   98	102	117	java/lang/Exception
    //   93	97	136	java/lang/Exception
    //   16	41	153	finally
    //   160	164	166	java/lang/Exception
    //   43	50	185	finally
    //   57	66	185	finally
    //   73	89	185	finally
    //   16	41	189	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.bridge.o
 * JD-Core Version:    0.7.0.1
 */