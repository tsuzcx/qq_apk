package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.v.8;
import com.tencent.mm.appbrand.v8.v.a;
import com.tencent.mm.appbrand.v8.v.b;
import com.tencent.mm.appbrand.v8.v.c;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.ai.b;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.plugin.appbrand.n.i;
import com.tencent.mm.plugin.appbrand.n.k;
import com.tencent.mm.plugin.appbrand.n.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class af
{
  private static ReentrantLock qxm;
  private w hnU;
  protected y qsi;
  private k qxf;
  public v qxg;
  private ArrayList<v.b> qxh;
  final b qxi;
  final LinkedList<a> qxj;
  private final AtomicBoolean qxk;
  final AtomicBoolean qxl;
  
  static
  {
    AppMethodBeat.i(316721);
    qxm = new ReentrantLock();
    AppMethodBeat.o(316721);
  }
  
  public af(y paramy)
  {
    AppMethodBeat.i(134612);
    this.qxi = new b();
    this.qxj = new LinkedList();
    this.qxk = new AtomicBoolean(false);
    this.qxl = new AtomicBoolean(false);
    this.hnU = new w()
    {
      public final int aEt()
      {
        AppMethodBeat.i(316877);
        if (af.d(af.this) != null)
        {
          int i = af.d(af.this).getNativeBufferId();
          AppMethodBeat.o(316877);
          return i;
        }
        AppMethodBeat.o(316877);
        return 0;
      }
      
      public final void bufferStoreBindTo(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(316898);
        if (af.d(af.this) != null) {
          af.d(af.this).bufferStoreBindTo(paramAnonymousLong1, paramAnonymousLong2);
        }
        AppMethodBeat.o(316898);
      }
      
      public final ByteBuffer nS(int paramAnonymousInt)
      {
        AppMethodBeat.i(316885);
        if (af.d(af.this) != null)
        {
          ByteBuffer localByteBuffer = af.d(af.this).ae(paramAnonymousInt, false);
          AppMethodBeat.o(316885);
          return localByteBuffer;
        }
        AppMethodBeat.o(316885);
        return null;
      }
      
      public final void q(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(316902);
        af.e(af.this).getJsRuntime().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString }), null);
        AppMethodBeat.o(316902);
      }
      
      public final void setBuffer(int paramAnonymousInt, ByteBuffer paramAnonymousByteBuffer)
      {
        AppMethodBeat.i(316887);
        if (af.d(af.this) != null) {
          af.d(af.this).setNativeBuffer(paramAnonymousInt, paramAnonymousByteBuffer);
        }
        AppMethodBeat.o(316887);
      }
      
      public final boolean supportBufferStoreBindTo()
      {
        AppMethodBeat.i(316893);
        if (af.d(af.this) != null)
        {
          boolean bool = af.d(af.this).supportBufferStoreBindTo();
          AppMethodBeat.o(316893);
          return bool;
        }
        AppMethodBeat.o(316893);
        return false;
      }
    };
    this.qsi = paramy;
    this.qxf = ((k)paramy.getJsRuntime().Z(k.class));
    this.qxg = cdq();
    this.qxh = new ArrayList();
    String str1 = this.qsi.arG() + "wxa_library/bootstrap_j2v8_worker.js";
    String str2 = d.ags("wxa_library/bootstrap_j2v8_worker.js");
    this.qxh.add(new v.b(str1, str2));
    paramy.getJsRuntime().addJavascriptInterface(this, "WeixinWorker");
    AppMethodBeat.o(134612);
  }
  
  private v.b A(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(316706);
    JSONObject localJSONObject;
    if (paramBoolean) {
      localJSONObject = this.qsi.cdo();
    }
    try
    {
      for (;;)
      {
        localJSONObject.put("workerContentType", paramString);
        label25:
        paramString = new v.b(this.qsi.arG() + "config", String.format("var __wxConfig = %s;", new Object[] { localJSONObject.toString() }));
        AppMethodBeat.o(316706);
        return paramString;
        localJSONObject = this.qsi.arC();
      }
    }
    catch (JSONException paramString)
    {
      break label25;
    }
  }
  
  private static boolean UD(String paramString)
  {
    AppMethodBeat.i(316700);
    try
    {
      boolean bool = "ad".equals(new JSONObject(paramString).optString("type"));
      AppMethodBeat.o(316700);
      return bool;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.AppBrandWorkerContainer", paramString, "[createWXLibWorker] get type fail", new Object[0]);
      AppMethodBeat.o(316700);
    }
    return false;
  }
  
  private int a(String paramString1, String paramString2, v.a parama, int paramInt, v.c paramc)
  {
    AppMethodBeat.i(316694);
    Log.d("MicroMsg.AppBrandWorkerContainer", "hy: create worker: %s, %s  %s", new Object[] { paramString1, paramString2, parama });
    ArrayList localArrayList2 = new ArrayList(this.qxh);
    switch (5.qxq[parama.ordinal()])
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
            localArrayList2.add(UE(paramString1));
            break;
            a(localArrayList2, paramString1, true, "wxlib");
            localArrayList2.add(new v.b(paramString1, this.qsi.cbl().UW(paramString1), paramString1, "V" + this.qsi.cbl().cfG()));
            break;
            paramString1 = null;
          }
          paramInt = this.qxg.a(localArrayList2, this.qsi, paramString1, parama, paramInt, paramc);
          AppMethodBeat.o(316694);
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
  
  protected v.b UE(String paramString)
  {
    AppMethodBeat.i(134615);
    paramString = new v.b(this.qsi.arF() + paramString, bl.d(this.qsi.getRuntime(), paramString) + this.qsi.ft(paramString));
    AppMethodBeat.o(134615);
    return paramString;
  }
  
  protected void a(ArrayList<v.b> paramArrayList, String paramString1, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(316752);
    paramArrayList.add(A(paramBoolean, paramString2));
    AppMethodBeat.o(316752);
  }
  
  protected v cdq()
  {
    AppMethodBeat.i(134613);
    v localv = new v(this.hnU);
    AppMethodBeat.o(134613);
    return localv;
  }
  
  final void cdr()
  {
    AppMethodBeat.i(316760);
    if ((this.qxk.get()) || (!this.qxl.get()))
    {
      AppMethodBeat.o(316760);
      return;
    }
    if (this.qsi.getRuntime() == null)
    {
      AppMethodBeat.o(316760);
      return;
    }
    if (this.qxi.qqS != null)
    {
      this.qxk.set(true);
      Log.i("MicroMsg.AppBrandWorkerContainer", "dispatch OnWxConfigReady to worker");
      o localo = a.g(this.qxi.qqS);
      localo.evaluateJavascript(String.format(Locale.ENGLISH, ";(function(global){if(typeof global.WXConfig==='undefined'){global.WXConfig={};};Object.assign(global.WXConfig, %s);})(this)", new Object[] { this.qsi.arC().toString() }), new ValueCallback() {});
      localo.evaluateJavascript(String.format(Locale.US, ";(function(global){ if(global.WXConfig.preload) { %s; return true; } else { return false; }})(this);", new Object[] { di.H("onWxConfigReady", "", 0) }), new ValueCallback() {});
    }
    AppMethodBeat.o(316760);
  }
  
  public final b cds()
  {
    if (this.qxi.qqS == null) {
      return null;
    }
    return this.qxi;
  }
  
  protected final w cdt()
  {
    return this.hnU;
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
  public int createWXLibWorker(String arg1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: ldc_w 394
    //   9: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_2
    //   13: invokestatic 396	com/tencent/mm/plugin/appbrand/af:UD	(Ljava/lang/String;)Z
    //   16: istore 7
    //   18: ldc 200
    //   20: ldc_w 398
    //   23: iload 7
    //   25: invokestatic 402	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   28: invokevirtual 405	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: iload 7
    //   36: ifeq +570 -> 606
    //   39: aload_0
    //   40: getfield 71	com/tencent/mm/plugin/appbrand/af:qxj	Ljava/util/LinkedList;
    //   43: astore 11
    //   45: aload 11
    //   47: monitorenter
    //   48: new 68	java/util/LinkedList
    //   51: dup
    //   52: aload_0
    //   53: getfield 71	com/tencent/mm/plugin/appbrand/af:qxj	Ljava/util/LinkedList;
    //   56: invokespecial 406	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   59: invokevirtual 410	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   62: astore 12
    //   64: aload 12
    //   66: invokeinterface 415 1 0
    //   71: ifeq +52 -> 123
    //   74: aload 12
    //   76: invokeinterface 419 1 0
    //   81: checkcast 16	com/tencent/mm/plugin/appbrand/af$a
    //   84: invokeinterface 422 1 0
    //   89: ifeq -25 -> 64
    //   92: aload 11
    //   94: monitorexit
    //   95: iload 7
    //   97: ifeq +18 -> 115
    //   100: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   103: invokevirtual 425	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   106: ifeq +9 -> 115
    //   109: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   112: invokevirtual 428	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   115: ldc_w 394
    //   118: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: aload 11
    //   125: monitorexit
    //   126: aload_0
    //   127: getfield 87	com/tencent/mm/plugin/appbrand/af:qsi	Lcom/tencent/mm/plugin/appbrand/y;
    //   130: invokevirtual 93	com/tencent/mm/plugin/appbrand/y:getJsRuntime	()Lcom/tencent/mm/plugin/appbrand/n/i;
    //   133: ldc_w 430
    //   136: invokeinterface 101 2 0
    //   141: checkcast 430	com/tencent/mm/plugin/appbrand/n/q
    //   144: invokeinterface 433 1 0
    //   149: ifeq +225 -> 374
    //   152: aload_0
    //   153: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   156: invokestatic 439	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   159: putfield 443	com/tencent/mm/plugin/appbrand/ai/b:uSp	J
    //   162: ldc 200
    //   164: new 116	java/lang/StringBuilder
    //   167: dup
    //   168: ldc_w 445
    //   171: invokespecial 272	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: aload_0
    //   175: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   178: getfield 443	com/tencent/mm/plugin/appbrand/ai/b:uSp	J
    //   181: invokevirtual 448	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   193: ldc2_w 449
    //   196: getstatic 456	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   199: invokevirtual 460	java/util/concurrent/locks/ReentrantLock:tryLock	(JLjava/util/concurrent/TimeUnit;)Z
    //   202: istore 8
    //   204: iload 8
    //   206: ifne +346 -> 552
    //   209: iload 7
    //   211: ifeq +18 -> 229
    //   214: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   217: invokevirtual 425	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   220: ifeq +9 -> 229
    //   223: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   226: invokevirtual 428	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   229: ldc_w 394
    //   232: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: iconst_m1
    //   236: ireturn
    //   237: astore_1
    //   238: aload 11
    //   240: monitorexit
    //   241: ldc_w 394
    //   244: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: aload_1
    //   248: athrow
    //   249: astore_1
    //   250: iconst_0
    //   251: istore_3
    //   252: iload 7
    //   254: ifeq +14 -> 268
    //   257: aload_0
    //   258: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   261: aload_1
    //   262: invokevirtual 463	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   265: putfield 467	com/tencent/mm/plugin/appbrand/ai/b:uSn	Ljava/lang/String;
    //   268: ldc 200
    //   270: aload_1
    //   271: ldc_w 370
    //   274: iconst_1
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: ldc_w 370
    //   283: aastore
    //   284: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: iload 7
    //   289: ifeq +558 -> 847
    //   292: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   295: invokevirtual 425	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   298: ifeq +9 -> 307
    //   301: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   304: invokevirtual 428	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   307: iload_3
    //   308: ifeq +539 -> 847
    //   311: aload_0
    //   312: getfield 71	com/tencent/mm/plugin/appbrand/af:qxj	Ljava/util/LinkedList;
    //   315: astore_1
    //   316: aload_1
    //   317: monitorenter
    //   318: new 68	java/util/LinkedList
    //   321: dup
    //   322: aload_0
    //   323: getfield 71	com/tencent/mm/plugin/appbrand/af:qxj	Ljava/util/LinkedList;
    //   326: invokespecial 406	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   329: invokevirtual 410	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   332: astore_2
    //   333: aload_2
    //   334: invokeinterface 415 1 0
    //   339: ifeq +506 -> 845
    //   342: aload_2
    //   343: invokeinterface 419 1 0
    //   348: checkcast 16	com/tencent/mm/plugin/appbrand/af$a
    //   351: aload_0
    //   352: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   355: invokeinterface 470 2 0
    //   360: goto -27 -> 333
    //   363: astore_2
    //   364: aload_1
    //   365: monitorexit
    //   366: ldc_w 394
    //   369: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_2
    //   373: athrow
    //   374: aload_0
    //   375: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   378: invokestatic 439	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   381: putfield 473	com/tencent/mm/plugin/appbrand/ai/b:uSo	J
    //   384: ldc 200
    //   386: new 116	java/lang/StringBuilder
    //   389: dup
    //   390: ldc_w 475
    //   393: invokespecial 272	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   396: aload_0
    //   397: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   400: getfield 473	com/tencent/mm/plugin/appbrand/ai/b:uSo	J
    //   403: invokevirtual 448	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: goto -222 -> 190
    //   415: astore_1
    //   416: iconst_0
    //   417: istore_3
    //   418: iload 7
    //   420: ifeq +14 -> 434
    //   423: aload_0
    //   424: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   427: aload_1
    //   428: invokevirtual 478	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   431: putfield 467	com/tencent/mm/plugin/appbrand/ai/b:uSn	Ljava/lang/String;
    //   434: ldc 200
    //   436: aload_1
    //   437: ldc_w 370
    //   440: iconst_1
    //   441: anewarray 4	java/lang/Object
    //   444: dup
    //   445: iconst_0
    //   446: ldc_w 370
    //   449: aastore
    //   450: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   453: ldc_w 394
    //   456: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: aload_1
    //   460: athrow
    //   461: astore_1
    //   462: iload 7
    //   464: ifeq +393 -> 857
    //   467: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   470: invokevirtual 425	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   473: ifeq +9 -> 482
    //   476: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   479: invokevirtual 428	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   482: iload_3
    //   483: ifeq +374 -> 857
    //   486: aload_0
    //   487: getfield 71	com/tencent/mm/plugin/appbrand/af:qxj	Ljava/util/LinkedList;
    //   490: astore_2
    //   491: aload_2
    //   492: monitorenter
    //   493: new 68	java/util/LinkedList
    //   496: dup
    //   497: aload_0
    //   498: getfield 71	com/tencent/mm/plugin/appbrand/af:qxj	Ljava/util/LinkedList;
    //   501: invokespecial 406	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   504: invokevirtual 410	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   507: astore 11
    //   509: aload 11
    //   511: invokeinterface 415 1 0
    //   516: ifeq +339 -> 855
    //   519: aload 11
    //   521: invokeinterface 419 1 0
    //   526: checkcast 16	com/tencent/mm/plugin/appbrand/af$a
    //   529: aload_0
    //   530: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   533: invokeinterface 470 2 0
    //   538: goto -29 -> 509
    //   541: astore_1
    //   542: aload_2
    //   543: monitorexit
    //   544: ldc_w 394
    //   547: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   550: aload_1
    //   551: athrow
    //   552: aload_0
    //   553: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   556: getfield 330	com/tencent/mm/plugin/appbrand/ai/b:qqS	Lcom/tencent/mm/appbrand/v8/m;
    //   559: ifnull +39 -> 598
    //   562: aload_0
    //   563: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   566: getfield 482	com/tencent/mm/plugin/appbrand/ai/b:id	I
    //   569: istore_3
    //   570: iload 7
    //   572: ifeq +18 -> 590
    //   575: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   578: invokevirtual 425	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   581: ifeq +9 -> 590
    //   584: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   587: invokevirtual 428	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   590: ldc_w 394
    //   593: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   596: iload_3
    //   597: ireturn
    //   598: aload_0
    //   599: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   602: aconst_null
    //   603: putfield 467	com/tencent/mm/plugin/appbrand/ai/b:uSn	Ljava/lang/String;
    //   606: invokestatic 439	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   609: lstore 9
    //   611: iload 7
    //   613: ifeq +293 -> 906
    //   616: getstatic 488	com/tencent/mm/plugin/appbrand/ae:qxc	Lcom/tencent/mm/plugin/appbrand/ae;
    //   619: invokevirtual 489	com/tencent/mm/plugin/appbrand/ae:ordinal	()I
    //   622: istore_3
    //   623: aload_0
    //   624: aload_1
    //   625: aload_2
    //   626: getstatic 493	com/tencent/mm/appbrand/v8/v$a:hoh	Lcom/tencent/mm/appbrand/v8/v$a;
    //   629: iload_3
    //   630: new 6	com/tencent/mm/plugin/appbrand/af$1
    //   633: dup
    //   634: aload_0
    //   635: iload 7
    //   637: invokespecial 496	com/tencent/mm/plugin/appbrand/af$1:<init>	(Lcom/tencent/mm/plugin/appbrand/af;Z)V
    //   640: invokespecial 498	com/tencent/mm/plugin/appbrand/af:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/appbrand/v8/v$a;ILcom/tencent/mm/appbrand/v8/v$c;)I
    //   643: istore 6
    //   645: iload 7
    //   647: ifeq +254 -> 901
    //   650: aload_0
    //   651: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   654: iload 6
    //   656: putfield 482	com/tencent/mm/plugin/appbrand/ai/b:id	I
    //   659: aload_0
    //   660: invokevirtual 500	com/tencent/mm/plugin/appbrand/af:cdr	()V
    //   663: aload_0
    //   664: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   667: aload_0
    //   668: getfield 109	com/tencent/mm/plugin/appbrand/af:qxg	Lcom/tencent/mm/appbrand/v8/v;
    //   671: iload 6
    //   673: invokevirtual 504	com/tencent/mm/appbrand/v8/v:nR	(I)Lcom/tencent/mm/appbrand/v8/m;
    //   676: putfield 330	com/tencent/mm/plugin/appbrand/ai/b:qqS	Lcom/tencent/mm/appbrand/v8/m;
    //   679: aload_0
    //   680: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   683: aload_0
    //   684: getfield 87	com/tencent/mm/plugin/appbrand/af:qsi	Lcom/tencent/mm/plugin/appbrand/y;
    //   687: putfield 507	com/tencent/mm/plugin/appbrand/ai/b:qqV	Lcom/tencent/mm/plugin/appbrand/y;
    //   690: aload_0
    //   691: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   694: astore_1
    //   695: new 509	kotlin/r
    //   698: dup
    //   699: lload 9
    //   701: invokestatic 514	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   704: invokestatic 439	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   707: invokestatic 514	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   710: invokespecial 517	kotlin/r:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   713: astore 11
    //   715: aload 11
    //   717: ldc_w 519
    //   720: invokestatic 524	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   723: aload_1
    //   724: aload 11
    //   726: putfield 528	com/tencent/mm/plugin/appbrand/ai/b:uSm	Lkotlin/r;
    //   729: aload_0
    //   730: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   733: aload_2
    //   734: putfield 531	com/tencent/mm/plugin/appbrand/ai/b:rRQ	Ljava/lang/String;
    //   737: ldc 200
    //   739: ldc_w 533
    //   742: invokestatic 337	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   745: iconst_1
    //   746: istore_3
    //   747: iload 7
    //   749: ifeq +87 -> 836
    //   752: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   755: invokevirtual 425	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   758: ifeq +9 -> 767
    //   761: getstatic 54	com/tencent/mm/plugin/appbrand/af:qxm	Ljava/util/concurrent/locks/ReentrantLock;
    //   764: invokevirtual 428	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   767: iload_3
    //   768: ifeq +68 -> 836
    //   771: aload_0
    //   772: getfield 71	com/tencent/mm/plugin/appbrand/af:qxj	Ljava/util/LinkedList;
    //   775: astore_1
    //   776: aload_1
    //   777: monitorenter
    //   778: new 68	java/util/LinkedList
    //   781: dup
    //   782: aload_0
    //   783: getfield 71	com/tencent/mm/plugin/appbrand/af:qxj	Ljava/util/LinkedList;
    //   786: invokespecial 406	java/util/LinkedList:<init>	(Ljava/util/Collection;)V
    //   789: invokevirtual 410	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   792: astore_2
    //   793: aload_2
    //   794: invokeinterface 415 1 0
    //   799: ifeq +35 -> 834
    //   802: aload_2
    //   803: invokeinterface 419 1 0
    //   808: checkcast 16	com/tencent/mm/plugin/appbrand/af$a
    //   811: aload_0
    //   812: getfield 66	com/tencent/mm/plugin/appbrand/af:qxi	Lcom/tencent/mm/plugin/appbrand/ai/b;
    //   815: invokeinterface 470 2 0
    //   820: goto -27 -> 793
    //   823: astore_2
    //   824: aload_1
    //   825: monitorexit
    //   826: ldc_w 394
    //   829: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   832: aload_2
    //   833: athrow
    //   834: aload_1
    //   835: monitorexit
    //   836: ldc_w 394
    //   839: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   842: iload 6
    //   844: ireturn
    //   845: aload_1
    //   846: monitorexit
    //   847: ldc_w 394
    //   850: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   853: iconst_m1
    //   854: ireturn
    //   855: aload_2
    //   856: monitorexit
    //   857: ldc_w 394
    //   860: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   863: aload_1
    //   864: athrow
    //   865: astore_1
    //   866: goto -404 -> 462
    //   869: astore_1
    //   870: iconst_0
    //   871: istore_3
    //   872: iconst_0
    //   873: istore 7
    //   875: goto -457 -> 418
    //   878: astore_1
    //   879: iload 5
    //   881: istore_3
    //   882: goto -464 -> 418
    //   885: astore_1
    //   886: iconst_0
    //   887: istore_3
    //   888: iconst_0
    //   889: istore 7
    //   891: goto -639 -> 252
    //   894: astore_1
    //   895: iload 4
    //   897: istore_3
    //   898: goto -646 -> 252
    //   901: iconst_0
    //   902: istore_3
    //   903: goto -156 -> 747
    //   906: iconst_m1
    //   907: istore_3
    //   908: goto -285 -> 623
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	911	0	this	af
    //   0	911	2	paramString2	String
    //   251	657	3	i	int
    //   4	892	4	j	int
    //   1	879	5	k	int
    //   643	200	6	m	int
    //   16	874	7	bool1	boolean
    //   202	3	8	bool2	boolean
    //   609	91	9	l	long
    //   43	682	11	localObject	Object
    //   62	13	12	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   48	64	237	finally
    //   64	95	237	finally
    //   18	34	249	java/lang/InterruptedException
    //   39	48	249	java/lang/InterruptedException
    //   123	190	249	java/lang/InterruptedException
    //   190	204	249	java/lang/InterruptedException
    //   238	249	249	java/lang/InterruptedException
    //   374	412	249	java/lang/InterruptedException
    //   552	570	249	java/lang/InterruptedException
    //   598	606	249	java/lang/InterruptedException
    //   606	611	249	java/lang/InterruptedException
    //   616	623	249	java/lang/InterruptedException
    //   623	645	249	java/lang/InterruptedException
    //   650	737	249	java/lang/InterruptedException
    //   318	333	363	finally
    //   333	360	363	finally
    //   845	847	363	finally
    //   18	34	415	finally
    //   39	48	415	finally
    //   123	190	415	finally
    //   190	204	415	finally
    //   238	249	415	finally
    //   374	412	415	finally
    //   552	570	415	finally
    //   598	606	415	finally
    //   606	611	415	finally
    //   616	623	415	finally
    //   623	645	415	finally
    //   650	737	415	finally
    //   423	434	461	finally
    //   434	461	461	finally
    //   493	509	541	finally
    //   509	538	541	finally
    //   855	857	541	finally
    //   778	793	823	finally
    //   793	820	823	finally
    //   834	836	823	finally
    //   257	268	865	finally
    //   268	287	865	finally
    //   12	18	869	finally
    //   737	745	878	finally
    //   12	18	885	java/lang/InterruptedException
    //   737	745	894	java/lang/InterruptedException
  }
  
  @JavascriptInterface
  public int createWithParams(String paramString1, String paramString2)
  {
    AppMethodBeat.i(316729);
    int i = a(paramString1, paramString2, v.a.hog, -1, null);
    AppMethodBeat.o(316729);
    return i;
  }
  
  @JavascriptInterface
  public void postMsgToWorker(int paramInt, String paramString)
  {
    AppMethodBeat.i(134618);
    v localv = this.qxg;
    m localm = (m)localv.hnT.get(Integer.valueOf(paramInt));
    if (localm != null) {
      localm.hmL.u(new v.8(localv, localm, paramString));
    }
    AppMethodBeat.o(134618);
  }
  
  @JavascriptInterface
  public void terminate(int paramInt)
  {
    AppMethodBeat.i(134617);
    this.qxg.terminate(paramInt);
    AppMethodBeat.o(134617);
  }
  
  public static abstract interface a
  {
    public abstract void ab(long paramLong1, long paramLong2);
    
    public abstract void b(b paramb);
    
    public abstract boolean cbe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.af
 * JD-Core Version:    0.7.0.1
 */