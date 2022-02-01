package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.aa.b.a;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.cy;
import com.tencent.mm.plugin.appbrand.jsapi.file.w.b;
import com.tencent.mm.plugin.appbrand.m.g;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.s.b;
import com.tencent.mm.plugin.appbrand.utils.t.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<SERVICE extends s>
  implements d, w.b
{
  protected final SERVICE cAJ;
  private final com.tencent.mm.plugin.appbrand.m.t cAK;
  private final g cAL;
  
  protected b(SERVICE paramSERVICE, com.tencent.mm.plugin.appbrand.m.t paramt)
  {
    this.cAJ = paramSERVICE;
    this.cAK = paramt;
    this.cAL = paramt.bME();
  }
  
  private void a(g paramg, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final i locali = new i();
    com.tencent.mm.plugin.appbrand.utils.t.a(this.cAJ, paramg, paramString1, paramString1, "v" + a(this.cAJ), Mz(), paramString2, t.a.ohc, new s.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        locali.value = paramAnonymousc;
      }
      
      public final void du(String paramAnonymousString)
      {
        localPBool.value = false;
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        localPBool.value = true;
      }
    });
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.scriptName = paramString1;
    paramg.czz = paramString2;
    paramg.czA = paramString2.length();
    a(paramg, localPBool.value, l1, l2, locali.value);
  }
  
  private g hQ(int paramInt)
  {
    return this.cAK.xX(paramInt);
  }
  
  protected g MI()
  {
    return this.cAK.bME();
  }
  
  protected void MJ()
  {
    this.cAK.bMD().b(this.cAL, "WeixinJSContext");
  }
  
  protected abstract String MK();
  
  protected int Mz()
  {
    return 1;
  }
  
  protected final SERVICE NY()
  {
    return this.cAJ;
  }
  
  protected int a(g paramg, String paramString)
  {
    long l1 = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final PInt localPInt = new PInt();
    Object localObject = bg.M(this.cAJ.getRuntime());
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript pkgListReader is null, err, appId(%s) scriptPath(%s)", new Object[] { this.cAJ.getAppId(), paramString });
      return 0;
    }
    localObject = ((q)localObject).UV(paramString);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript, scriptFileInfo is null, appId(%s) scriptPath(%s)", new Object[] { this.cAJ.getAppId(), paramString });
      return 0;
    }
    final i locali = new i();
    com.tencent.mm.plugin.appbrand.utils.t.a(this.cAJ.getRuntime(), paramg, paramString, (q.a)localObject, new s.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        locali.value = paramAnonymousc;
        localPInt.value = paramAnonymousc.sourceLength;
      }
      
      public final void du(String paramAnonymousString)
      {
        localPBool.value = false;
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        localPBool.value = true;
      }
    });
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b), entry(%s)", new Object[] { this.cAJ.getAppId(), Integer.valueOf(paramg.bMC()), paramString, Boolean.valueOf(localPBool.value), String.format(Locale.ENGLISH, "FileEntry{providerId:%s, appVersion:%d, appVersionStr:%s, fileName:%s, fileOffset:%d, fileLength:%d}", new Object[] { ((q.a)localObject).kKF, Integer.valueOf(((q.a)localObject).appVersion), ((q.a)localObject).kKG, ((q.a)localObject).fileName, Integer.valueOf(((q.a)localObject).kKJ), Integer.valueOf(((q.a)localObject).kKK) }) });
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.scriptName = paramString;
    paramg.czz = null;
    paramg.czA = localPInt.value;
    paramg.kKF = ((q.a)localObject).kKF;
    paramg.appVersion = ((q.a)localObject).appVersion;
    a(paramg, localPBool.value, l1, l2, locali.value);
    return localPInt.value;
  }
  
  protected abstract int a(SERVICE paramSERVICE);
  
  protected String a(SERVICE paramSERVICE, String paramString)
  {
    paramSERVICE = bg.d(paramSERVICE.getRuntime(), paramString);
    if (TextUtils.isEmpty(paramSERVICE)) {
      throw new aq(paramString);
    }
    return paramSERVICE;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  protected void a(SERVICE paramSERVICE, g paramg) {}
  
  public void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2) {}
  
  /* Error */
  @JavascriptInterface
  public final int alloc()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 270	com/tencent/luggage/sdk/b/a/c/b:allocEmpty	()I
    //   4: istore_1
    //   5: iload_1
    //   6: ifgt +5 -> 11
    //   9: iload_1
    //   10: ireturn
    //   11: aload_0
    //   12: iload_1
    //   13: invokespecial 272	com/tencent/luggage/sdk/b/a/c/b:hQ	(I)Lcom/tencent/mm/plugin/appbrand/m/g;
    //   16: astore_2
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   22: invokevirtual 275	com/tencent/luggage/sdk/b/a/c/b:b	(Lcom/tencent/mm/plugin/appbrand/s;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_0
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 277	com/tencent/luggage/sdk/b/a/c/b:MK	()Ljava/lang/String;
    //   32: aload_3
    //   33: invokespecial 279	com/tencent/luggage/sdk/b/a/c/b:a	(Lcom/tencent/mm/plugin/appbrand/m/g;Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_2
    //   37: invokeinterface 195 1 0
    //   42: ireturn
    //   43: astore_2
    //   44: ldc 165
    //   46: ldc_w 281
    //   49: iconst_1
    //   50: anewarray 5	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: invokevirtual 284	com/tencent/mm/plugin/appbrand/appcache/aq:getMessage	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_2
    //   66: ldc 165
    //   68: aload_2
    //   69: ldc_w 286
    //   72: iconst_0
    //   73: anewarray 5	java/lang/Object
    //   76: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload_2
    //   80: athrow
    //   81: astore_2
    //   82: ldc 165
    //   84: aload_2
    //   85: new 62	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 292
    //   92: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_0
    //   96: invokevirtual 277	com/tencent/luggage/sdk/b/a/c/b:MK	()Ljava/lang/String;
    //   99: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: iconst_0
    //   106: anewarray 5	java/lang/Object
    //   109: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_2
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	b
    //   4	9	1	i	int
    //   16	21	2	localg	g
    //   43	13	2	localaq	aq
    //   65	15	2	localException1	Exception
    //   81	32	2	localException2	Exception
    //   25	8	3	str	String
    // Exception table:
    //   from	to	target	type
    //   17	26	43	com/tencent/mm/plugin/appbrand/appcache/aq
    //   17	26	65	java/lang/Exception
    //   26	36	81	java/lang/Exception
  }
  
  @JavascriptInterface
  public final int allocEmpty()
  {
    final g localg = MI();
    if (localg == null)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", new Object[] { this.cAJ.getAppId() });
      return -2;
    }
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", new Object[] { Integer.valueOf(localg.bMC()) });
    localg.setJsExceptionHandler(new h()
    {
      public final void u(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(146788);
        Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        cy.a(localg, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { r.afJ(paramAnonymousString1), r.afJ(paramAnonymousString2) }));
        b.a.bVD();
        com.tencent.mm.plugin.appbrand.aa.b.N("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(146788);
      }
    });
    this.cAL.b(localg, "WeixinJSContext");
    if (this.cAJ.getRuntime() == null) {}
    for (JSONObject localJSONObject = this.cAJ.bte();; localJSONObject = this.cAJ.Or())
    {
      localg.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[] { localJSONObject.toString() }), null);
      return localg.bMC();
    }
  }
  
  protected abstract String b(SERVICE paramSERVICE);
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[] { this.cAJ.getAppId(), paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[] { this.cAJ.getAppId() });
      return -1;
    }
    int i = alloc();
    if (i <= 0) {
      return i;
    }
    g localg = this.cAK.xX(i);
    i = evaluateScriptFile(i, paramString);
    if (i != 1)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", new Object[] { this.cAJ.getAppId(), paramString, Integer.valueOf(i) });
      return -1;
    }
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[] { this.cAJ.getAppId(), paramString, Integer.valueOf(localg.bMC()) });
    return localg.bMC();
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    this.cAK.xY(paramInt);
  }
  
  /* Error */
  @JavascriptInterface
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc 165
    //   2: ldc_w 357
    //   5: iconst_3
    //   6: anewarray 5	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   15: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: iload_1
    //   22: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: aastore
    //   26: dup
    //   27: iconst_2
    //   28: aload_2
    //   29: aastore
    //   30: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 35	com/tencent/luggage/sdk/b/a/c/b:cAK	Lcom/tencent/mm/plugin/appbrand/m/t;
    //   37: iload_1
    //   38: invokeinterface 130 2 0
    //   43: astore 10
    //   45: aload 10
    //   47: ifnonnull +38 -> 85
    //   50: ldc 165
    //   52: ldc_w 359
    //   55: iconst_3
    //   56: anewarray 5	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   65: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: iload_1
    //   72: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: dup
    //   77: iconst_2
    //   78: aload_2
    //   79: aastore
    //   80: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: iconst_m1
    //   84: ireturn
    //   85: aload 10
    //   87: invokeinterface 363 1 0
    //   92: ifeq +31 -> 123
    //   95: ldc 165
    //   97: ldc_w 365
    //   100: iconst_2
    //   101: anewarray 5	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   110: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload_2
    //   117: aastore
    //   118: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: aload_0
    //   124: aload_0
    //   125: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   128: aload 10
    //   130: invokevirtual 367	com/tencent/luggage/sdk/b/a/c/b:a	(Lcom/tencent/mm/plugin/appbrand/s;Lcom/tencent/mm/plugin/appbrand/m/g;)V
    //   133: aload_0
    //   134: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   137: invokevirtual 371	com/tencent/mm/plugin/appbrand/s:getJsRuntime	()Lcom/tencent/mm/plugin/appbrand/m/i;
    //   140: ldc_w 373
    //   143: invokeinterface 379 2 0
    //   148: ifnonnull +433 -> 581
    //   151: ldc 165
    //   153: ldc_w 381
    //   156: iconst_3
    //   157: anewarray 5	java/lang/Object
    //   160: dup
    //   161: iconst_0
    //   162: aload_0
    //   163: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   166: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: iload_1
    //   173: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   176: aastore
    //   177: dup
    //   178: iconst_2
    //   179: aload_2
    //   180: aastore
    //   181: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_0
    //   185: aload_0
    //   186: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   189: aload_2
    //   190: invokevirtual 383	com/tencent/luggage/sdk/b/a/c/b:a	(Lcom/tencent/mm/plugin/appbrand/s;Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 7
    //   195: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   198: lstore_3
    //   199: new 56	com/tencent/mm/pointers/PBool
    //   202: dup
    //   203: invokespecial 57	com/tencent/mm/pointers/PBool:<init>	()V
    //   206: astore 8
    //   208: new 59	com/tencent/mm/plugin/appbrand/ac/i
    //   211: dup
    //   212: invokespecial 60	com/tencent/mm/plugin/appbrand/ac/i:<init>	()V
    //   215: astore 9
    //   217: aload_0
    //   218: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   221: invokevirtual 157	com/tencent/mm/plugin/appbrand/s:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   224: astore 11
    //   226: new 62	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 384	java/lang/StringBuilder:<init>	()V
    //   233: aload_2
    //   234: bipush 47
    //   236: bipush 95
    //   238: invokevirtual 388	java/lang/String:replace	(CC)Ljava/lang/String;
    //   241: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 390
    //   247: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_0
    //   251: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   254: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   257: invokevirtual 295	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore 12
    //   265: aload_0
    //   266: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   269: invokevirtual 157	com/tencent/mm/plugin/appbrand/s:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   272: invokevirtual 396	com/tencent/mm/plugin/appbrand/AppBrandRuntime:OT	()Lcom/tencent/mm/plugin/appbrand/config/l;
    //   275: getfield 402	com/tencent/mm/plugin/appbrand/config/l:leE	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   278: getfield 407	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:md5	Ljava/lang/String;
    //   281: astore 13
    //   283: getstatic 410	com/tencent/mm/plugin/appbrand/utils/t$a:ohd	Lcom/tencent/mm/plugin/appbrand/utils/t$a;
    //   286: astore 14
    //   288: new 15	com/tencent/luggage/sdk/b/a/c/b$3
    //   291: dup
    //   292: aload_0
    //   293: aload 9
    //   295: aload 8
    //   297: invokespecial 411	com/tencent/luggage/sdk/b/a/c/b$3:<init>	(Lcom/tencent/luggage/sdk/b/a/c/b;Lcom/tencent/mm/plugin/appbrand/ac/i;Lcom/tencent/mm/pointers/PBool;)V
    //   300: astore 15
    //   302: aload 11
    //   304: ifnull +11 -> 315
    //   307: aload 11
    //   309: invokevirtual 413	com/tencent/mm/plugin/appbrand/AppBrandRuntime:NY	()Lcom/tencent/mm/plugin/appbrand/s;
    //   312: ifnonnull +184 -> 496
    //   315: ldc_w 415
    //   318: ldc_w 417
    //   321: invokestatic 420	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: ldc 165
    //   326: ldc_w 422
    //   329: iconst_4
    //   330: anewarray 5	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: aload_0
    //   336: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   339: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: aload 10
    //   347: invokeinterface 195 1 0
    //   352: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: aastore
    //   356: dup
    //   357: iconst_2
    //   358: aload_2
    //   359: aastore
    //   360: dup
    //   361: iconst_3
    //   362: aload 8
    //   364: getfield 119	com/tencent/mm/pointers/PBool:value	Z
    //   367: invokestatic 206	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   370: aastore
    //   371: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   377: lstore 5
    //   379: new 98	com/tencent/luggage/sdk/b/a/d$a
    //   382: dup
    //   383: invokespecial 99	com/tencent/luggage/sdk/b/a/d$a:<init>	()V
    //   386: astore 10
    //   388: aload 10
    //   390: aload_2
    //   391: putfield 103	com/tencent/luggage/sdk/b/a/d$a:scriptName	Ljava/lang/String;
    //   394: aload 10
    //   396: aload 7
    //   398: putfield 106	com/tencent/luggage/sdk/b/a/d$a:czz	Ljava/lang/String;
    //   401: aload 10
    //   403: aload 7
    //   405: invokestatic 426	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   408: invokevirtual 111	java/lang/String:length	()I
    //   411: putfield 115	com/tencent/luggage/sdk/b/a/d$a:czA	I
    //   414: aload_0
    //   415: aload 10
    //   417: aload 8
    //   419: getfield 119	com/tencent/mm/pointers/PBool:value	Z
    //   422: lload_3
    //   423: lload 5
    //   425: aload 9
    //   427: getfield 122	com/tencent/mm/plugin/appbrand/ac/i:value	Ljava/lang/Object;
    //   430: invokevirtual 125	com/tencent/luggage/sdk/b/a/c/b:a	(Lcom/tencent/luggage/sdk/b/a/d$a;ZJJLjava/lang/Object;)V
    //   433: iconst_1
    //   434: ireturn
    //   435: astore 7
    //   437: ldc 165
    //   439: ldc_w 428
    //   442: iconst_4
    //   443: anewarray 5	java/lang/Object
    //   446: dup
    //   447: iconst_0
    //   448: aload_0
    //   449: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   452: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: iload_1
    //   459: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: dup
    //   464: iconst_2
    //   465: aload_2
    //   466: aastore
    //   467: dup
    //   468: iconst_3
    //   469: aload 7
    //   471: invokevirtual 284	com/tencent/mm/plugin/appbrand/appcache/aq:getMessage	()Ljava/lang/String;
    //   474: aastore
    //   475: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: iconst_0
    //   479: ireturn
    //   480: astore_2
    //   481: ldc 165
    //   483: aload_2
    //   484: ldc_w 430
    //   487: iconst_0
    //   488: anewarray 5	java/lang/Object
    //   491: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   494: aload_2
    //   495: athrow
    //   496: aload 11
    //   498: aload_2
    //   499: aload 11
    //   501: invokevirtual 413	com/tencent/mm/plugin/appbrand/AppBrandRuntime:NY	()Lcom/tencent/mm/plugin/appbrand/s;
    //   504: aload 14
    //   506: invokestatic 433	com/tencent/mm/plugin/appbrand/utils/t:a	(Lcom/tencent/mm/plugin/appbrand/s;Lcom/tencent/mm/plugin/appbrand/utils/t$a;)Ljava/lang/String;
    //   509: invokestatic 438	com/tencent/mm/plugin/appbrand/bc:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   512: astore 16
    //   514: aload 16
    //   516: invokestatic 338	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   519: ifne +11 -> 530
    //   522: aload 10
    //   524: aload 16
    //   526: aconst_null
    //   527: invokestatic 443	com/tencent/mm/plugin/appbrand/utils/s:a	(Lcom/tencent/mm/plugin/appbrand/m/i;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/utils/s$a;)V
    //   530: aload 11
    //   532: invokevirtual 413	com/tencent/mm/plugin/appbrand/AppBrandRuntime:NY	()Lcom/tencent/mm/plugin/appbrand/s;
    //   535: aload 10
    //   537: aload_2
    //   538: aload 12
    //   540: aload 13
    //   542: iconst_0
    //   543: aload 7
    //   545: aload 14
    //   547: aload 15
    //   549: invokestatic 96	com/tencent/mm/plugin/appbrand/utils/t:a	(Lcom/tencent/mm/plugin/appbrand/s;Lcom/tencent/mm/plugin/appbrand/m/i;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/utils/t$a;Lcom/tencent/mm/plugin/appbrand/utils/s$a;)V
    //   552: goto -228 -> 324
    //   555: astore 7
    //   557: ldc 165
    //   559: aload 7
    //   561: ldc_w 445
    //   564: aload_2
    //   565: invokestatic 448	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   568: invokevirtual 451	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   571: iconst_0
    //   572: anewarray 5	java/lang/Object
    //   575: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: aload 7
    //   580: athrow
    //   581: aload_0
    //   582: aload 10
    //   584: aload_2
    //   585: invokevirtual 453	com/tencent/luggage/sdk/b/a/c/b:a	(Lcom/tencent/mm/plugin/appbrand/m/g;Ljava/lang/String;)I
    //   588: istore_1
    //   589: iload_1
    //   590: ifle +5 -> 595
    //   593: iconst_1
    //   594: ireturn
    //   595: iconst_0
    //   596: ireturn
    //   597: astore 7
    //   599: ldc 165
    //   601: aload 7
    //   603: ldc_w 455
    //   606: aload_2
    //   607: invokestatic 448	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   610: invokevirtual 451	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   613: iconst_0
    //   614: anewarray 5	java/lang/Object
    //   617: invokestatic 290	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   620: aload 7
    //   622: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	this	b
    //   0	623	1	paramInt	int
    //   0	623	2	paramString	String
    //   198	225	3	l1	long
    //   377	47	5	l2	long
    //   193	211	7	str1	String
    //   435	109	7	localaq	aq
    //   555	24	7	localException1	Exception
    //   597	24	7	localException2	Exception
    //   206	212	8	localPBool	PBool
    //   215	211	9	locali	i
    //   43	540	10	localObject	Object
    //   224	307	11	localAppBrandRuntime	com.tencent.mm.plugin.appbrand.AppBrandRuntime
    //   263	276	12	str2	String
    //   281	260	13	str3	String
    //   286	260	14	locala	t.a
    //   300	248	15	local3	3
    //   512	13	16	str4	String
    // Exception table:
    //   from	to	target	type
    //   184	195	435	com/tencent/mm/plugin/appbrand/appcache/aq
    //   184	195	480	java/lang/Exception
    //   195	302	555	java/lang/Exception
    //   307	315	555	java/lang/Exception
    //   315	324	555	java/lang/Exception
    //   324	433	555	java/lang/Exception
    //   496	530	555	java/lang/Exception
    //   530	552	555	java/lang/Exception
    //   581	589	597	java/lang/Exception
  }
  
  /* Error */
  @JavascriptInterface
  public void loadJsFilesWithOptions(final int paramInt, final String paramString1, final String paramString2)
  {
    // Byte code:
    //   0: ldc 165
    //   2: ldc_w 463
    //   5: iconst_4
    //   6: anewarray 5	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   15: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: iload_1
    //   22: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: aastore
    //   26: dup
    //   27: iconst_2
    //   28: aload_2
    //   29: aastore
    //   30: dup
    //   31: iconst_3
    //   32: aload_3
    //   33: aastore
    //   34: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: aload_0
    //   38: getfield 35	com/tencent/luggage/sdk/b/a/c/b:cAK	Lcom/tencent/mm/plugin/appbrand/m/t;
    //   41: iload_1
    //   42: invokeinterface 130 2 0
    //   47: astore 5
    //   49: aload 5
    //   51: ifnonnull +33 -> 84
    //   54: ldc 165
    //   56: ldc_w 465
    //   59: iconst_2
    //   60: anewarray 5	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   69: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: iload_1
    //   76: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: return
    //   84: new 467	org/json/JSONArray
    //   87: dup
    //   88: aload_2
    //   89: invokespecial 468	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   92: astore 6
    //   94: aconst_null
    //   95: astore 4
    //   97: aload_3
    //   98: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifne +13 -> 114
    //   104: new 320	org/json/JSONObject
    //   107: dup
    //   108: aload_3
    //   109: invokespecial 469	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   112: astore 4
    //   114: invokestatic 472	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   117: pop2
    //   118: aload 4
    //   120: ifnonnull +167 -> 287
    //   123: aconst_null
    //   124: astore 4
    //   126: aload_0
    //   127: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   130: invokevirtual 157	com/tencent/mm/plugin/appbrand/s:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   133: aload 6
    //   135: aload 5
    //   137: aload_0
    //   138: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   141: invokevirtual 476	com/tencent/mm/plugin/appbrand/s:bqY	()Lcom/tencent/mm/plugin/appbrand/appcache/q;
    //   144: aload 4
    //   146: new 13	com/tencent/luggage/sdk/b/a/c/b$2
    //   149: dup
    //   150: aload_0
    //   151: iload_1
    //   152: aload_2
    //   153: aload_3
    //   154: invokespecial 479	com/tencent/luggage/sdk/b/a/c/b$2:<init>	(Lcom/tencent/luggage/sdk/b/a/c/b;ILjava/lang/String;Ljava/lang/String;)V
    //   157: invokestatic 484	com/tencent/mm/plugin/appbrand/jsapi/file/w:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Lorg/json/JSONArray;Lcom/tencent/mm/plugin/appbrand/m/i;Lcom/tencent/mm/plugin/appbrand/appcache/q;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/file/w$b;)V
    //   160: return
    //   161: astore 4
    //   163: ldc 165
    //   165: ldc_w 486
    //   168: iconst_5
    //   169: anewarray 5	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: aload_0
    //   175: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   178: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   181: aastore
    //   182: dup
    //   183: iconst_1
    //   184: iload_1
    //   185: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: aload_2
    //   192: aastore
    //   193: dup
    //   194: iconst_3
    //   195: aload_3
    //   196: aastore
    //   197: dup
    //   198: iconst_4
    //   199: aload 4
    //   201: aastore
    //   202: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: return
    //   206: astore_2
    //   207: ldc 165
    //   209: ldc_w 488
    //   212: iconst_3
    //   213: anewarray 5	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: aload_0
    //   219: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   222: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: iload_1
    //   229: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_2
    //   235: aload_2
    //   236: aastore
    //   237: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: return
    //   241: astore 4
    //   243: ldc 165
    //   245: ldc_w 490
    //   248: iconst_4
    //   249: anewarray 5	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_0
    //   255: getfield 33	com/tencent/luggage/sdk/b/a/c/b:cAJ	Lcom/tencent/mm/plugin/appbrand/s;
    //   258: invokevirtual 170	com/tencent/mm/plugin/appbrand/s:getAppId	()Ljava/lang/String;
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: iload_1
    //   265: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: aastore
    //   269: dup
    //   270: iconst_2
    //   271: aload_3
    //   272: aastore
    //   273: dup
    //   274: iconst_3
    //   275: aload 4
    //   277: aastore
    //   278: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: aconst_null
    //   282: astore 4
    //   284: goto -170 -> 114
    //   287: aload 4
    //   289: ldc_w 492
    //   292: invokevirtual 495	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   295: astore 4
    //   297: goto -171 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	this	b
    //   0	300	1	paramInt	int
    //   0	300	2	paramString1	String
    //   0	300	3	paramString2	String
    //   95	50	4	localJSONObject	JSONObject
    //   161	39	4	localThrowable	java.lang.Throwable
    //   241	35	4	localJSONException	JSONException
    //   282	14	4	str	String
    //   47	89	5	localg	g
    //   92	42	6	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   126	160	161	java/lang/Throwable
    //   84	94	206	org/json/JSONException
    //   97	114	241	org/json/JSONException
  }
  
  @JavascriptInterface
  public void loadLibFiles(int paramInt, String paramString)
  {
    g localg = hQ(paramInt);
    if (localg == null)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL context by id[%d], appId[%s]", new Object[] { Integer.valueOf(paramInt), this.cAJ.getAppId() });
      return;
    }
    JSONArray localJSONArray;
    ICommLibReader localICommLibReader;
    try
    {
      localJSONArray = new JSONArray(paramString);
      localICommLibReader = this.cAJ.bqZ();
      if (localICommLibReader == null)
      {
        Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL LibReader, id[%d], appId[%s]", new Object[] { Integer.valueOf(paramInt), this.cAJ.getAppId() });
        return;
      }
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles parse paths failed, id[%d] appId[%s] e=%s", new Object[] { Integer.valueOf(paramInt), this.cAJ.getAppId(), paramString });
      return;
    }
    int i = 0;
    label133:
    if (i < localJSONArray.length())
    {
      paramString = localJSONArray.optString(i);
      if (!TextUtils.isEmpty(paramString)) {
        break label199;
      }
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY name by index[%d] id[%d] appId[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), this.cAJ.getAppId() });
    }
    for (;;)
    {
      i += 1;
      break label133;
      break;
      label199:
      String str = localICommLibReader.UM(paramString);
      if (TextUtils.isEmpty(str))
      {
        Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY script by name[%s] id[%d] appId[%s]", new Object[] { paramString, Integer.valueOf(paramInt), this.cAJ.getAppId() });
        continue;
      }
      try
      {
        a(localg, (String)Objects.requireNonNull(paramString), (String)Objects.requireNonNull(str));
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandJSContextInterface[multicontext]", localException, "loadLibFiles::injectSdkScript::".concat(String.valueOf(paramString)), new Object[0]);
        throw localException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b
 * JD-Core Version:    0.7.0.1
 */