package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.v.8;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.appbrand.v8.v.b;
import com.tencent.mm.appbrand.v8.v.c;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.ah.b;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ab
{
  private w fjH;
  protected v ntA;
  k nxR;
  public com.tencent.mm.appbrand.v8.v nxS;
  private ArrayList<v.b> nxT;
  final b nxU;
  final LinkedList<a> nxV;
  private final AtomicBoolean nxW;
  final AtomicBoolean nxX;
  
  public ab(v paramv)
  {
    AppMethodBeat.i(134612);
    this.nxU = new b();
    this.nxV = new LinkedList();
    this.nxW = new AtomicBoolean(false);
    this.nxX = new AtomicBoolean(false);
    this.fjH = new ab.4(this);
    this.ntA = paramv;
    this.nxR = ((k)paramv.getJsRuntime().Q(k.class));
    this.nxS = bEe();
    this.nxT = new ArrayList();
    String str1 = this.ntA.Rs() + "wxa_library/bootstrap_j2v8_worker.js";
    String str2 = d.anc("wxa_library/bootstrap_j2v8_worker.js");
    this.nxT.add(new v.b(str1, str2));
    paramv.getJsRuntime().addJavascriptInterface(this, "WeixinWorker");
    AppMethodBeat.o(134612);
  }
  
  private int a(String paramString1, String paramString2, v.a parama, int paramInt, v.c paramc)
  {
    AppMethodBeat.i(243313);
    Log.d("MicroMsg.AppBrandWorkerContainer", "hy: create worker: %s, %s  %s", new Object[] { paramString1, paramString2, parama });
    ArrayList localArrayList2 = new ArrayList(this.nxT);
    switch (ab.5.nyb[parama.ordinal()])
    {
    default: 
      if (paramString2 == null) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        localJSONArray = new JSONObject(paramString2).optJSONArray("APIList");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          localArrayList1 = new ArrayList(10);
          i = 0;
          paramString1 = localArrayList1;
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          JSONArray localJSONArray;
          int i;
          if (i < localJSONArray.length())
          {
            localArrayList1.add(localJSONArray.getString(i));
            i += 1;
            continue;
            a(localArrayList2, paramString1, false, "app");
            localArrayList2.add(acc(paramString1));
            break;
            a(localArrayList2, paramString1, true, "wxlib");
            localArrayList2.add(new v.b(paramString1, this.ntA.bBP().acw(paramString1)));
            break;
            paramString1 = null;
          }
          paramInt = this.nxS.a(localArrayList2, this.ntA, paramString1, parama, paramInt, paramc);
          AppMethodBeat.o(243313);
          return paramInt;
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            ArrayList localArrayList1;
            paramString1 = localArrayList1;
          }
        }
        localJSONException1 = localJSONException1;
        paramString1 = null;
      }
      Log.printErrStackTrace("MicroMsg.AppBrandWorkerContainer", localJSONException1, "hy: json format error! %s", new Object[] { paramString2 });
      continue;
      paramString1 = null;
    }
  }
  
  private static boolean acb(String paramString)
  {
    AppMethodBeat.i(243315);
    try
    {
      boolean bool = "ad".equals(new JSONObject(paramString).optString("type"));
      AppMethodBeat.o(243315);
      return bool;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandWorkerContainer", paramString, "[createWXLibWorker] get type fail", new Object[0]);
      AppMethodBeat.o(243315);
    }
    return false;
  }
  
  private v.b n(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(243318);
    JSONObject localJSONObject;
    if (paramBoolean) {
      localJSONObject = this.ntA.bEc();
    }
    try
    {
      for (;;)
      {
        localJSONObject.put("workerContentType", paramString);
        label25:
        paramString = new v.b(this.ntA.Rs() + "config", String.format("var __wxConfig = %s;", new Object[] { localJSONObject.toString() }));
        AppMethodBeat.o(243318);
        return paramString;
        localJSONObject = this.ntA.Ro();
      }
    }
    catch (JSONException paramString)
    {
      break label25;
    }
  }
  
  protected void a(ArrayList<v.b> paramArrayList, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(243317);
    paramArrayList.add(n(paramBoolean, paramString2));
    AppMethodBeat.o(243317);
  }
  
  protected v.b acc(String paramString)
  {
    AppMethodBeat.i(134615);
    paramString = new v.b(this.ntA.Rr() + paramString, bl.d(this.ntA.getRuntime(), paramString) + this.ntA.ea(paramString));
    AppMethodBeat.o(134615);
    return paramString;
  }
  
  protected com.tencent.mm.appbrand.v8.v bEe()
  {
    AppMethodBeat.i(134613);
    com.tencent.mm.appbrand.v8.v localv = new com.tencent.mm.appbrand.v8.v(this.fjH);
    AppMethodBeat.o(134613);
    return localv;
  }
  
  final void bEf()
  {
    AppMethodBeat.i(243320);
    if ((this.nxW.get()) && (!this.nxX.get()))
    {
      AppMethodBeat.o(243320);
      return;
    }
    if (this.nxU.nsn != null)
    {
      this.nxW.set(true);
      Log.i("MicroMsg.AppBrandWorkerContainer", "dispatch OnWxConfigReady to worker");
      o localo = a.b(this.nxU.nsn);
      localo.evaluateJavascript(String.format(Locale.ENGLISH, ";(function(global){if(typeof global.WXConfig==='undefined'){global.WXConfig={};};Object.assign(global.WXConfig, %s);})(this)", new Object[] { this.ntA.Ro().toString() }), new ValueCallback() {});
      localo.evaluateJavascript(String.format(Locale.US, ";(function(global){ if(global.WXConfig.preload) { %s; return true; } else { return false; }})(this);", new Object[] { cy.C("onWxConfigReady", "", 0) }), new ValueCallback() {});
    }
    AppMethodBeat.o(243320);
  }
  
  protected final w bEg()
  {
    return this.fjH;
  }
  
  @JavascriptInterface
  public int create(String paramString)
  {
    AppMethodBeat.i(134614);
    int i = createWithParams(paramString, null);
    AppMethodBeat.o(134614);
    return i;
  }
  
  /* Error */
  @JavascriptInterface
  public int createWXLibWorker(String arg1, String arg2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc_w 364
    //   9: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_2
    //   13: invokestatic 366	com/tencent/mm/plugin/appbrand/ab:acb	(Ljava/lang/String;)Z
    //   16: istore 6
    //   18: iload 6
    //   20: istore 4
    //   22: ldc 146
    //   24: ldc_w 368
    //   27: iload 4
    //   29: invokestatic 372	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   32: invokevirtual 375	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: iload 4
    //   40: ifeq +107 -> 147
    //   43: aload_0
    //   44: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   47: getfield 302	com/tencent/mm/plugin/appbrand/ah/b:nsn	Lcom/tencent/mm/appbrand/v8/m;
    //   50: ifnull +89 -> 139
    //   53: aload_0
    //   54: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   57: getfield 379	com/tencent/mm/plugin/appbrand/ah/b:id	I
    //   60: istore_3
    //   61: iload 4
    //   63: ifeq +68 -> 131
    //   66: aload_0
    //   67: getfield 54	com/tencent/mm/plugin/appbrand/ab:nxV	Ljava/util/LinkedList;
    //   70: astore_1
    //   71: aload_1
    //   72: monitorenter
    //   73: new 51	java/util/LinkedList
    //   76: dup
    //   77: aload_0
    //   78: getfield 54	com/tencent/mm/plugin/appbrand/ab:nxV	Ljava/util/LinkedList;
    //   81: invokespecial 380	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   84: invokevirtual 384	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   87: astore_2
    //   88: aload_2
    //   89: invokeinterface 389 1 0
    //   94: ifeq +35 -> 129
    //   97: aload_2
    //   98: invokeinterface 393 1 0
    //   103: checkcast 12	com/tencent/mm/plugin/appbrand/ab$a
    //   106: aload_0
    //   107: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   110: invokeinterface 396 2 0
    //   115: goto -27 -> 88
    //   118: astore_2
    //   119: aload_1
    //   120: monitorexit
    //   121: ldc_w 364
    //   124: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_2
    //   128: athrow
    //   129: aload_1
    //   130: monitorexit
    //   131: ldc_w 364
    //   134: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iload_3
    //   138: ireturn
    //   139: aload_0
    //   140: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   143: aconst_null
    //   144: putfield 400	com/tencent/mm/plugin/appbrand/ah/b:rGY	Ljava/lang/String;
    //   147: invokestatic 406	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   150: lstore 7
    //   152: iconst_m1
    //   153: istore_3
    //   154: iload 4
    //   156: ifeq +10 -> 166
    //   159: getstatic 412	com/tencent/mm/plugin/appbrand/aa:nxO	Lcom/tencent/mm/plugin/appbrand/aa;
    //   162: invokevirtual 413	com/tencent/mm/plugin/appbrand/aa:ordinal	()I
    //   165: istore_3
    //   166: aload_0
    //   167: aload_1
    //   168: aload_2
    //   169: getstatic 417	com/tencent/mm/appbrand/v8/v$a:fjU	Lcom/tencent/mm/appbrand/v8/v$a;
    //   172: iload_3
    //   173: new 6	com/tencent/mm/plugin/appbrand/ab$1
    //   176: dup
    //   177: aload_0
    //   178: iload 4
    //   180: invokespecial 420	com/tencent/mm/plugin/appbrand/ab$1:<init>	(Lcom/tencent/mm/plugin/appbrand/ab;Z)V
    //   183: invokespecial 422	com/tencent/mm/plugin/appbrand/ab:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/appbrand/v8/v$a;ILcom/tencent/mm/appbrand/v8/v$c;)I
    //   186: istore_3
    //   187: iload 4
    //   189: ifeq +74 -> 263
    //   192: aload_0
    //   193: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   196: iload_3
    //   197: putfield 379	com/tencent/mm/plugin/appbrand/ah/b:id	I
    //   200: aload_0
    //   201: invokevirtual 424	com/tencent/mm/plugin/appbrand/ab:bEf	()V
    //   204: aload_0
    //   205: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   208: aload_0
    //   209: getfield 94	com/tencent/mm/plugin/appbrand/ab:nxS	Lcom/tencent/mm/appbrand/v8/v;
    //   212: iload_3
    //   213: invokevirtual 428	com/tencent/mm/appbrand/v8/v:kj	(I)Lcom/tencent/mm/appbrand/v8/m;
    //   216: putfield 302	com/tencent/mm/plugin/appbrand/ah/b:nsn	Lcom/tencent/mm/appbrand/v8/m;
    //   219: aload_0
    //   220: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   223: astore_1
    //   224: new 430	kotlin/o
    //   227: dup
    //   228: lload 7
    //   230: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: invokestatic 406	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   236: invokestatic 435	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   239: invokespecial 438	kotlin/o:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   242: astore_2
    //   243: aload_2
    //   244: ldc_w 440
    //   247: invokestatic 445	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   250: aload_1
    //   251: aload_2
    //   252: putfield 449	com/tencent/mm/plugin/appbrand/ah/b:rGX	Lkotlin/o;
    //   255: ldc 146
    //   257: ldc_w 451
    //   260: invokestatic 309	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: iload 4
    //   265: ifeq +68 -> 333
    //   268: aload_0
    //   269: getfield 54	com/tencent/mm/plugin/appbrand/ab:nxV	Ljava/util/LinkedList;
    //   272: astore_1
    //   273: aload_1
    //   274: monitorenter
    //   275: new 51	java/util/LinkedList
    //   278: dup
    //   279: aload_0
    //   280: getfield 54	com/tencent/mm/plugin/appbrand/ab:nxV	Ljava/util/LinkedList;
    //   283: invokespecial 380	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   286: invokevirtual 384	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   289: astore_2
    //   290: aload_2
    //   291: invokeinterface 389 1 0
    //   296: ifeq +35 -> 331
    //   299: aload_2
    //   300: invokeinterface 393 1 0
    //   305: checkcast 12	com/tencent/mm/plugin/appbrand/ab$a
    //   308: aload_0
    //   309: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   312: invokeinterface 396 2 0
    //   317: goto -27 -> 290
    //   320: astore_2
    //   321: aload_1
    //   322: monitorexit
    //   323: ldc_w 364
    //   326: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: aload_2
    //   330: athrow
    //   331: aload_1
    //   332: monitorexit
    //   333: ldc_w 364
    //   336: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: iload_3
    //   340: ireturn
    //   341: astore_1
    //   342: iload 5
    //   344: ifeq +18 -> 362
    //   347: iload 5
    //   349: istore 4
    //   351: aload_0
    //   352: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   355: aload_1
    //   356: invokevirtual 454	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   359: putfield 400	com/tencent/mm/plugin/appbrand/ah/b:rGY	Ljava/lang/String;
    //   362: iload 5
    //   364: istore 4
    //   366: ldc 146
    //   368: aload_1
    //   369: ldc_w 342
    //   372: iconst_1
    //   373: anewarray 4	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: ldc_w 342
    //   381: aastore
    //   382: invokestatic 225	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   385: iload 5
    //   387: istore 4
    //   389: ldc_w 364
    //   392: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: iload 5
    //   397: istore 4
    //   399: aload_1
    //   400: athrow
    //   401: astore_1
    //   402: iload 4
    //   404: ifeq +71 -> 475
    //   407: aload_0
    //   408: getfield 54	com/tencent/mm/plugin/appbrand/ab:nxV	Ljava/util/LinkedList;
    //   411: astore_2
    //   412: aload_2
    //   413: monitorenter
    //   414: new 51	java/util/LinkedList
    //   417: dup
    //   418: aload_0
    //   419: getfield 54	com/tencent/mm/plugin/appbrand/ab:nxV	Ljava/util/LinkedList;
    //   422: invokespecial 380	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   425: invokevirtual 384	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   428: astore 9
    //   430: aload 9
    //   432: invokeinterface 389 1 0
    //   437: ifeq +36 -> 473
    //   440: aload 9
    //   442: invokeinterface 393 1 0
    //   447: checkcast 12	com/tencent/mm/plugin/appbrand/ab$a
    //   450: aload_0
    //   451: getfield 49	com/tencent/mm/plugin/appbrand/ab:nxU	Lcom/tencent/mm/plugin/appbrand/ah/b;
    //   454: invokeinterface 396 2 0
    //   459: goto -29 -> 430
    //   462: astore_1
    //   463: aload_2
    //   464: monitorexit
    //   465: ldc_w 364
    //   468: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   471: aload_1
    //   472: athrow
    //   473: aload_2
    //   474: monitorexit
    //   475: ldc_w 364
    //   478: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   481: aload_1
    //   482: athrow
    //   483: astore_1
    //   484: goto -82 -> 402
    //   487: astore_1
    //   488: iload 4
    //   490: istore 5
    //   492: goto -150 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	495	0	this	ab
    //   60	280	3	i	int
    //   1	488	4	bool1	boolean
    //   4	487	5	bool2	boolean
    //   16	3	6	bool3	boolean
    //   150	79	7	l	long
    //   428	13	9	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   73	88	118	finally
    //   88	115	118	finally
    //   129	131	118	finally
    //   275	290	320	finally
    //   290	317	320	finally
    //   331	333	320	finally
    //   12	18	341	java/lang/Throwable
    //   12	18	401	finally
    //   351	362	401	finally
    //   366	385	401	finally
    //   389	395	401	finally
    //   399	401	401	finally
    //   414	430	462	finally
    //   430	459	462	finally
    //   473	475	462	finally
    //   22	38	483	finally
    //   43	61	483	finally
    //   139	147	483	finally
    //   147	152	483	finally
    //   159	166	483	finally
    //   166	187	483	finally
    //   192	263	483	finally
    //   22	38	487	java/lang/Throwable
    //   43	61	487	java/lang/Throwable
    //   139	147	487	java/lang/Throwable
    //   147	152	487	java/lang/Throwable
    //   159	166	487	java/lang/Throwable
    //   166	187	487	java/lang/Throwable
    //   192	263	487	java/lang/Throwable
  }
  
  @JavascriptInterface
  public int createWithParams(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243311);
    int i = a(paramString1, paramString2, v.a.fjT, -1, null);
    AppMethodBeat.o(243311);
    return i;
  }
  
  @JavascriptInterface
  public void postMsgToWorker(int paramInt, String paramString)
  {
    AppMethodBeat.i(134618);
    com.tencent.mm.appbrand.v8.v localv = this.nxS;
    m localm = (m)localv.fjG.get(Integer.valueOf(paramInt));
    if (localm != null) {
      localm.fiy.q(new v.8(localv, localm, paramString));
    }
    AppMethodBeat.o(134618);
  }
  
  @JavascriptInterface
  public void terminate(int paramInt)
  {
    AppMethodBeat.i(134617);
    this.nxS.terminate(paramInt);
    AppMethodBeat.o(134617);
  }
  
  public static abstract interface a
  {
    public abstract void E(long paramLong1, long paramLong2);
    
    public abstract void b(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab
 * JD-Core Version:    0.7.0.1
 */