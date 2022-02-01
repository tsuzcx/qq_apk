package com.tencent.luggage.sdk.b.a.d;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.commonjni.AppBrandCommonBindingJni;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.ac.b.a;
import com.tencent.mm.plugin.appbrand.ad;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.as;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appcache.s;
import com.tencent.mm.plugin.appbrand.appcache.s.a;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.jsapi.dj;
import com.tencent.mm.plugin.appbrand.jsapi.file.w.b;
import com.tencent.mm.plugin.appbrand.n.g;
import com.tencent.mm.plugin.appbrand.n.h;
import com.tencent.mm.plugin.appbrand.n.t;
import com.tencent.mm.plugin.appbrand.n.v;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
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

public abstract class b<SERVICE extends com.tencent.mm.plugin.appbrand.y>
  implements com.tencent.luggage.sdk.b.a.d, ad, w.b
{
  protected final SERVICE esk;
  private final t esl;
  private final g esm;
  private final SparseIntArray esn = new SparseIntArray();
  private final SparseIntArray eso = new SparseIntArray();
  
  protected b(SERVICE paramSERVICE, t paramt)
  {
    this.esk = paramSERVICE;
    this.esl = paramt;
    this.esm = paramt.czj();
  }
  
  private void a(g paramg, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final k localk = new k();
    aa.a(this.esk, paramg, paramString1, paramString1, "v" + a(this.esk), apz(), paramString2, aa.a.urb, new z.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        localk.value = paramAnonymousc;
      }
      
      public final void eW(String paramAnonymousString)
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
    paramg.eqP = paramString2;
    paramg.eqQ = paramString2.length();
    a(paramg, localPBool.value, l1, l2, localk.value);
  }
  
  private g ms(int paramInt)
  {
    return this.esl.BK(paramInt);
  }
  
  protected int a(g paramg, String paramString)
  {
    a(paramg);
    long l1 = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final PInt localPInt = new PInt();
    Object localObject = bl.R(this.esk.getRuntime());
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript pkgListReader is null, err, appId(%s) scriptPath(%s)", new Object[] { this.esk.getAppId(), paramString });
      return 0;
    }
    localObject = ((s)localObject).Ve(paramString);
    if (localObject == null)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript, scriptFileInfo is null, appId(%s) scriptPath(%s)", new Object[] { this.esk.getAppId(), paramString });
      return 0;
    }
    final k localk = new k();
    aa.a(this.esk.getRuntime(), paramg, paramString, (s.a)localObject, new z.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        localk.value = paramAnonymousc;
        localPInt.value = paramAnonymousc.sourceLength;
      }
      
      public final void eW(String paramAnonymousString)
      {
        localPBool.value = false;
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        localPBool.value = true;
      }
    });
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b), entry(%s)", new Object[] { this.esk.getAppId(), Integer.valueOf(paramg.czh()), paramString, Boolean.valueOf(localPBool.value), String.format(Locale.ENGLISH, "FileEntry{providerId:%s, appVersion:%d, appVersionStr:%s, fileName:%s, fileOffset:%d, fileLength:%d}", new Object[] { ((s.a)localObject).qEr, Integer.valueOf(((s.a)localObject).appVersion), ((s.a)localObject).qEs, ((s.a)localObject).fileName, Integer.valueOf(((s.a)localObject).qEv), Integer.valueOf(((s.a)localObject).qEw) }) });
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.scriptName = paramString;
    paramg.eqP = null;
    paramg.eqQ = localPInt.value;
    paramg.qEr = ((s.a)localObject).qEr;
    paramg.appVersion = ((s.a)localObject).appVersion;
    a(paramg, localPBool.value, l1, l2, localk.value);
    return localPInt.value;
  }
  
  protected abstract int a(SERVICE paramSERVICE);
  
  protected String a(SERVICE paramSERVICE, String paramString)
  {
    paramSERVICE = bl.d(paramSERVICE.getRuntime(), paramString);
    if (TextUtils.isEmpty(paramSERVICE)) {
      throw new as(paramString);
    }
    return paramSERVICE;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  protected final void a(g paramg)
  {
    if (this.esn.get(paramg.czh(), 0) <= 0)
    {
      String str = this.esk.arC().toString();
      str = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { str });
      long l1 = Util.currentTicks();
      paramg.evaluateJavascript(str, null);
      long l2 = Util.currentTicks();
      Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "ensureFullWxConfigInjected inject wxConfig, appId:%s, cost:%sms", new Object[] { this.esk.getAppId(), Long.valueOf(l2 - l1) });
      this.esn.put(paramg.czh(), 1);
    }
  }
  
  protected void a(SERVICE paramSERVICE, g paramg)
  {
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "beforeEvaluateScriptFile appId:%s, contextId:%d", new Object[] { paramSERVICE.getAppId(), Integer.valueOf(paramg.czh()) });
  }
  
  public void a(String paramString, d.a[] paramArrayOfa, boolean[] paramArrayOfBoolean, Object[] paramArrayOfObject, long paramLong1, long paramLong2) {}
  
  /* Error */
  @JavascriptInterface
  public final int alloc()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 308	com/tencent/luggage/sdk/b/a/d/b:allocEmpty	()I
    //   4: istore_1
    //   5: iload_1
    //   6: ifgt +5 -> 11
    //   9: iload_1
    //   10: ireturn
    //   11: aload_0
    //   12: iload_1
    //   13: invokespecial 310	com/tencent/luggage/sdk/b/a/d/b:ms	(I)Lcom/tencent/mm/plugin/appbrand/n/g;
    //   16: astore_2
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   22: invokevirtual 314	com/tencent/luggage/sdk/b/a/d/b:b	(Lcom/tencent/mm/plugin/appbrand/y;)Ljava/lang/String;
    //   25: astore_3
    //   26: aload_0
    //   27: aload_2
    //   28: aload_0
    //   29: invokevirtual 317	com/tencent/luggage/sdk/b/a/d/b:apK	()Ljava/lang/String;
    //   32: aload_3
    //   33: invokespecial 319	com/tencent/luggage/sdk/b/a/d/b:a	(Lcom/tencent/mm/plugin/appbrand/n/g;Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_2
    //   37: invokeinterface 195 1 0
    //   42: ireturn
    //   43: astore_2
    //   44: ldc 163
    //   46: ldc_w 321
    //   49: iconst_1
    //   50: anewarray 5	java/lang/Object
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: invokevirtual 324	com/tencent/mm/plugin/appbrand/appcache/as:getMessage	()Ljava/lang/String;
    //   59: aastore
    //   60: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_2
    //   66: ldc 163
    //   68: aload_2
    //   69: ldc_w 326
    //   72: iconst_0
    //   73: anewarray 5	java/lang/Object
    //   76: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: aload_2
    //   80: athrow
    //   81: astore_2
    //   82: ldc 163
    //   84: aload_2
    //   85: new 74	java/lang/StringBuilder
    //   88: dup
    //   89: ldc_w 332
    //   92: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_0
    //   96: invokevirtual 317	com/tencent/luggage/sdk/b/a/d/b:apK	()Ljava/lang/String;
    //   99: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: iconst_0
    //   106: anewarray 5	java/lang/Object
    //   109: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_2
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	b
    //   4	9	1	i	int
    //   16	21	2	localg	g
    //   43	13	2	localas	as
    //   65	15	2	localException1	Exception
    //   81	32	2	localException2	Exception
    //   25	8	3	str	String
    // Exception table:
    //   from	to	target	type
    //   17	26	43	com/tencent/mm/plugin/appbrand/appcache/as
    //   17	26	65	java/lang/Exception
    //   26	36	81	java/lang/Exception
  }
  
  @JavascriptInterface
  public final int allocEmpty()
  {
    final g localg = apI();
    if (localg == null)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", new Object[] { this.esk.getAppId() });
      return -2;
    }
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", new Object[] { Integer.valueOf(localg.czh()) });
    localg.setJsExceptionHandler(new h()
    {
      public final void handleException(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(146788);
        Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        dj.a(localg, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.y.agF(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.y.agF(paramAnonymousString2) }));
        b.a.cJD();
        com.tencent.mm.plugin.appbrand.ac.b.R("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(146788);
      }
    });
    this.esm.b(localg, "WeixinJSContext");
    JSONObject localJSONObject = this.esk.cdo();
    localg.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[] { localJSONObject.toString() }), null);
    return localg.czh();
  }
  
  protected g apI()
  {
    g localg = this.esl.czj();
    if (m.aEk()) {
      return localg;
    }
    v localv = (v)localg.Z(v.class);
    if ((this.esk instanceof d)) {}
    for (a locala = ((d)this.esk).esM.arN();; locala = null)
    {
      if ((localv != null) && (locala != null)) {
        locala.esf.notifyBindConsoleTo(localv.getIsolatePtr(), localv.aEn(), localv.getUVLoopPtr());
      }
      return localg;
    }
  }
  
  protected void apJ()
  {
    this.esl.czi().b(this.esm, "WeixinJSContext");
  }
  
  protected abstract String apK();
  
  protected int apz()
  {
    return 1;
  }
  
  protected final SERVICE ari()
  {
    return this.esk;
  }
  
  protected abstract String b(SERVICE paramSERVICE);
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[] { this.esk.getAppId(), paramString });
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[] { this.esk.getAppId() });
      return -1;
    }
    int i = alloc();
    if (i <= 0) {
      return i;
    }
    g localg = this.esl.BK(i);
    i = evaluateScriptFile(i, paramString);
    if (i != 1)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", new Object[] { this.esk.getAppId(), paramString, Integer.valueOf(i) });
      return -1;
    }
    Log.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[] { this.esk.getAppId(), paramString, Integer.valueOf(localg.czh()) });
    return localg.czh();
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    this.esl.BL(paramInt);
  }
  
  /* Error */
  @JavascriptInterface
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    // Byte code:
    //   0: ldc 163
    //   2: ldc_w 438
    //   5: iconst_3
    //   6: anewarray 5	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   15: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
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
    //   34: getfield 47	com/tencent/luggage/sdk/b/a/d/b:esl	Lcom/tencent/mm/plugin/appbrand/n/t;
    //   37: iload_1
    //   38: invokeinterface 142 2 0
    //   43: astore 10
    //   45: aload 10
    //   47: ifnonnull +38 -> 85
    //   50: ldc 163
    //   52: ldc_w 440
    //   55: iconst_3
    //   56: anewarray 5	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   65: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
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
    //   80: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: iconst_m1
    //   84: ireturn
    //   85: aload 10
    //   87: invokeinterface 443 1 0
    //   92: ifeq +31 -> 123
    //   95: ldc 163
    //   97: ldc_w 445
    //   100: iconst_2
    //   101: anewarray 5	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   110: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   113: aastore
    //   114: dup
    //   115: iconst_1
    //   116: aload_2
    //   117: aastore
    //   118: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: aload_0
    //   124: getfield 43	com/tencent/luggage/sdk/b/a/d/b:eso	Landroid/util/SparseIntArray;
    //   127: iload_1
    //   128: iconst_0
    //   129: invokevirtual 264	android/util/SparseIntArray:get	(II)I
    //   132: ifgt +22 -> 154
    //   135: aload_0
    //   136: aload_0
    //   137: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   140: aload 10
    //   142: invokevirtual 447	com/tencent/luggage/sdk/b/a/d/b:a	(Lcom/tencent/mm/plugin/appbrand/y;Lcom/tencent/mm/plugin/appbrand/n/g;)V
    //   145: aload_0
    //   146: getfield 43	com/tencent/luggage/sdk/b/a/d/b:eso	Landroid/util/SparseIntArray;
    //   149: iload_1
    //   150: iconst_1
    //   151: invokevirtual 296	android/util/SparseIntArray:put	(II)V
    //   154: aload_0
    //   155: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   158: invokevirtual 451	com/tencent/mm/plugin/appbrand/y:getJsRuntime	()Lcom/tencent/mm/plugin/appbrand/n/i;
    //   161: ldc_w 368
    //   164: invokeinterface 454 2 0
    //   169: ifnonnull +439 -> 608
    //   172: ldc 163
    //   174: ldc_w 456
    //   177: iconst_3
    //   178: anewarray 5	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_0
    //   184: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   187: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   190: aastore
    //   191: dup
    //   192: iconst_1
    //   193: iload_1
    //   194: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: aastore
    //   198: dup
    //   199: iconst_2
    //   200: aload_2
    //   201: aastore
    //   202: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload_0
    //   206: aload_0
    //   207: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   210: aload_2
    //   211: invokevirtual 458	com/tencent/luggage/sdk/b/a/d/b:a	(Lcom/tencent/mm/plugin/appbrand/y;Ljava/lang/String;)Ljava/lang/String;
    //   214: astore 7
    //   216: aload_0
    //   217: aload 10
    //   219: invokevirtual 146	com/tencent/luggage/sdk/b/a/d/b:a	(Lcom/tencent/mm/plugin/appbrand/n/g;)V
    //   222: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   225: lstore_3
    //   226: new 68	com/tencent/mm/pointers/PBool
    //   229: dup
    //   230: invokespecial 69	com/tencent/mm/pointers/PBool:<init>	()V
    //   233: astore 8
    //   235: new 71	com/tencent/mm/plugin/appbrand/af/k
    //   238: dup
    //   239: invokespecial 72	com/tencent/mm/plugin/appbrand/af/k:<init>	()V
    //   242: astore 9
    //   244: aload_0
    //   245: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   248: invokevirtual 155	com/tencent/mm/plugin/appbrand/y:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   251: astore 11
    //   253: new 74	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   260: aload_2
    //   261: bipush 47
    //   263: bipush 95
    //   265: invokevirtual 463	java/lang/String:replace	(CC)Ljava/lang/String;
    //   268: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc_w 465
    //   274: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   281: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   284: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: astore 12
    //   292: aload_0
    //   293: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   296: invokevirtual 155	com/tencent/mm/plugin/appbrand/y:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   299: invokevirtual 471	com/tencent/mm/plugin/appbrand/AppBrandRuntime:asG	()Lcom/tencent/mm/plugin/appbrand/config/n;
    //   302: getfield 477	com/tencent/mm/plugin/appbrand/config/n:qYY	Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;
    //   305: getfield 482	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:md5	Ljava/lang/String;
    //   308: astore 13
    //   310: getstatic 485	com/tencent/mm/plugin/appbrand/utils/aa$a:urc	Lcom/tencent/mm/plugin/appbrand/utils/aa$a;
    //   313: astore 14
    //   315: new 17	com/tencent/luggage/sdk/b/a/d/b$3
    //   318: dup
    //   319: aload_0
    //   320: aload 9
    //   322: aload 8
    //   324: invokespecial 486	com/tencent/luggage/sdk/b/a/d/b$3:<init>	(Lcom/tencent/luggage/sdk/b/a/d/b;Lcom/tencent/mm/plugin/appbrand/af/k;Lcom/tencent/mm/pointers/PBool;)V
    //   327: astore 15
    //   329: aload 11
    //   331: ifnull +11 -> 342
    //   334: aload 11
    //   336: invokevirtual 488	com/tencent/mm/plugin/appbrand/AppBrandRuntime:ari	()Lcom/tencent/mm/plugin/appbrand/y;
    //   339: ifnonnull +184 -> 523
    //   342: ldc_w 490
    //   345: ldc_w 492
    //   348: invokestatic 495	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: ldc 163
    //   353: ldc_w 497
    //   356: iconst_4
    //   357: anewarray 5	java/lang/Object
    //   360: dup
    //   361: iconst_0
    //   362: aload_0
    //   363: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   366: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   369: aastore
    //   370: dup
    //   371: iconst_1
    //   372: aload 10
    //   374: invokeinterface 195 1 0
    //   379: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   382: aastore
    //   383: dup
    //   384: iconst_2
    //   385: aload_2
    //   386: aastore
    //   387: dup
    //   388: iconst_3
    //   389: aload 8
    //   391: getfield 131	com/tencent/mm/pointers/PBool:value	Z
    //   394: invokestatic 206	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   397: aastore
    //   398: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: invokestatic 66	java/lang/System:currentTimeMillis	()J
    //   404: lstore 5
    //   406: new 110	com/tencent/luggage/sdk/b/a/d$a
    //   409: dup
    //   410: invokespecial 111	com/tencent/luggage/sdk/b/a/d$a:<init>	()V
    //   413: astore 10
    //   415: aload 10
    //   417: aload_2
    //   418: putfield 115	com/tencent/luggage/sdk/b/a/d$a:scriptName	Ljava/lang/String;
    //   421: aload 10
    //   423: aload 7
    //   425: putfield 118	com/tencent/luggage/sdk/b/a/d$a:eqP	Ljava/lang/String;
    //   428: aload 10
    //   430: aload 7
    //   432: invokestatic 501	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   435: invokevirtual 123	java/lang/String:length	()I
    //   438: putfield 127	com/tencent/luggage/sdk/b/a/d$a:eqQ	I
    //   441: aload_0
    //   442: aload 10
    //   444: aload 8
    //   446: getfield 131	com/tencent/mm/pointers/PBool:value	Z
    //   449: lload_3
    //   450: lload 5
    //   452: aload 9
    //   454: getfield 134	com/tencent/mm/plugin/appbrand/af/k:value	Ljava/lang/Object;
    //   457: invokevirtual 137	com/tencent/luggage/sdk/b/a/d/b:a	(Lcom/tencent/luggage/sdk/b/a/d$a;ZJJLjava/lang/Object;)V
    //   460: iconst_1
    //   461: ireturn
    //   462: astore 7
    //   464: ldc 163
    //   466: ldc_w 503
    //   469: iconst_4
    //   470: anewarray 5	java/lang/Object
    //   473: dup
    //   474: iconst_0
    //   475: aload_0
    //   476: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   479: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   482: aastore
    //   483: dup
    //   484: iconst_1
    //   485: iload_1
    //   486: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   489: aastore
    //   490: dup
    //   491: iconst_2
    //   492: aload_2
    //   493: aastore
    //   494: dup
    //   495: iconst_3
    //   496: aload 7
    //   498: invokevirtual 324	com/tencent/mm/plugin/appbrand/appcache/as:getMessage	()Ljava/lang/String;
    //   501: aastore
    //   502: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   505: iconst_0
    //   506: ireturn
    //   507: astore_2
    //   508: ldc 163
    //   510: aload_2
    //   511: ldc_w 505
    //   514: iconst_0
    //   515: anewarray 5	java/lang/Object
    //   518: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: aload_2
    //   522: athrow
    //   523: aload 11
    //   525: aload_2
    //   526: aload 11
    //   528: invokevirtual 488	com/tencent/mm/plugin/appbrand/AppBrandRuntime:ari	()Lcom/tencent/mm/plugin/appbrand/y;
    //   531: aload 14
    //   533: invokestatic 508	com/tencent/mm/plugin/appbrand/utils/aa:a	(Lcom/tencent/mm/plugin/appbrand/y;Lcom/tencent/mm/plugin/appbrand/utils/aa$a;)Ljava/lang/String;
    //   536: invokestatic 513	com/tencent/mm/plugin/appbrand/bk:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   539: astore 16
    //   541: aload 16
    //   543: invokestatic 419	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   546: ifne +11 -> 557
    //   549: aload 10
    //   551: aload 16
    //   553: aconst_null
    //   554: invokestatic 518	com/tencent/mm/plugin/appbrand/utils/z:a	(Lcom/tencent/mm/plugin/appbrand/n/i;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/utils/z$a;)V
    //   557: aload 11
    //   559: invokevirtual 488	com/tencent/mm/plugin/appbrand/AppBrandRuntime:ari	()Lcom/tencent/mm/plugin/appbrand/y;
    //   562: aload 10
    //   564: aload_2
    //   565: aload 12
    //   567: aload 13
    //   569: iconst_0
    //   570: aload 7
    //   572: aload 14
    //   574: aload 15
    //   576: invokestatic 108	com/tencent/mm/plugin/appbrand/utils/aa:a	(Lcom/tencent/mm/plugin/appbrand/y;Lcom/tencent/mm/plugin/appbrand/n/i;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/tencent/mm/plugin/appbrand/utils/aa$a;Lcom/tencent/mm/plugin/appbrand/utils/z$a;)V
    //   579: goto -228 -> 351
    //   582: astore 7
    //   584: ldc 163
    //   586: aload 7
    //   588: ldc_w 520
    //   591: aload_2
    //   592: invokestatic 523	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   595: invokevirtual 526	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   598: iconst_0
    //   599: anewarray 5	java/lang/Object
    //   602: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   605: aload 7
    //   607: athrow
    //   608: aload_0
    //   609: aload 10
    //   611: aload_2
    //   612: invokevirtual 528	com/tencent/luggage/sdk/b/a/d/b:a	(Lcom/tencent/mm/plugin/appbrand/n/g;Ljava/lang/String;)I
    //   615: istore_1
    //   616: iload_1
    //   617: ifle +5 -> 622
    //   620: iconst_1
    //   621: ireturn
    //   622: iconst_0
    //   623: ireturn
    //   624: astore 7
    //   626: ldc 163
    //   628: aload 7
    //   630: ldc_w 530
    //   633: aload_2
    //   634: invokestatic 523	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   637: invokevirtual 526	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   640: iconst_0
    //   641: anewarray 5	java/lang/Object
    //   644: invokestatic 330	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   647: aload 7
    //   649: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	650	0	this	b
    //   0	650	1	paramInt	int
    //   0	650	2	paramString	String
    //   225	225	3	l1	long
    //   404	47	5	l2	long
    //   214	217	7	str1	String
    //   462	109	7	localas	as
    //   582	24	7	localException1	Exception
    //   624	24	7	localException2	Exception
    //   233	212	8	localPBool	PBool
    //   242	211	9	localk	k
    //   43	567	10	localObject	Object
    //   251	307	11	localAppBrandRuntime	com.tencent.mm.plugin.appbrand.AppBrandRuntime
    //   290	276	12	str2	String
    //   308	260	13	str3	String
    //   313	260	14	locala	aa.a
    //   327	248	15	local3	3
    //   539	13	16	str4	String
    // Exception table:
    //   from	to	target	type
    //   205	216	462	com/tencent/mm/plugin/appbrand/appcache/as
    //   205	216	507	java/lang/Exception
    //   216	329	582	java/lang/Exception
    //   334	342	582	java/lang/Exception
    //   342	351	582	java/lang/Exception
    //   351	460	582	java/lang/Exception
    //   523	557	582	java/lang/Exception
    //   557	579	582	java/lang/Exception
    //   608	616	624	java/lang/Exception
  }
  
  /* Error */
  @JavascriptInterface
  public void loadJsFilesWithOptions(final int paramInt, final String paramString1, final String paramString2)
  {
    // Byte code:
    //   0: ldc 163
    //   2: ldc_w 536
    //   5: iconst_4
    //   6: anewarray 5	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   15: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
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
    //   38: getfield 47	com/tencent/luggage/sdk/b/a/d/b:esl	Lcom/tencent/mm/plugin/appbrand/n/t;
    //   41: iload_1
    //   42: invokeinterface 142 2 0
    //   47: astore 8
    //   49: aload 8
    //   51: ifnonnull +33 -> 84
    //   54: ldc 163
    //   56: ldc_w 538
    //   59: iconst_2
    //   60: anewarray 5	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload_0
    //   66: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   69: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   72: aastore
    //   73: dup
    //   74: iconst_1
    //   75: iload_1
    //   76: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   83: return
    //   84: aload_0
    //   85: aload 8
    //   87: invokevirtual 146	com/tencent/luggage/sdk/b/a/d/b:a	(Lcom/tencent/mm/plugin/appbrand/n/g;)V
    //   90: aload_0
    //   91: getfield 43	com/tencent/luggage/sdk/b/a/d/b:eso	Landroid/util/SparseIntArray;
    //   94: iload_1
    //   95: iconst_0
    //   96: invokevirtual 264	android/util/SparseIntArray:get	(II)I
    //   99: ifgt +22 -> 121
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   107: aload 8
    //   109: invokevirtual 447	com/tencent/luggage/sdk/b/a/d/b:a	(Lcom/tencent/mm/plugin/appbrand/y;Lcom/tencent/mm/plugin/appbrand/n/g;)V
    //   112: aload_0
    //   113: getfield 43	com/tencent/luggage/sdk/b/a/d/b:eso	Landroid/util/SparseIntArray;
    //   116: iload_1
    //   117: iconst_1
    //   118: invokevirtual 296	android/util/SparseIntArray:put	(II)V
    //   121: new 540	org/json/JSONArray
    //   124: dup
    //   125: aload_2
    //   126: invokespecial 541	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   129: astore 7
    //   131: aconst_null
    //   132: astore 6
    //   134: aload_3
    //   135: invokestatic 256	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +13 -> 151
    //   141: new 270	org/json/JSONObject
    //   144: dup
    //   145: aload_3
    //   146: invokespecial 542	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   149: astore 6
    //   151: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   154: lstore 4
    //   156: aload 6
    //   158: ifnonnull +174 -> 332
    //   161: aconst_null
    //   162: astore 6
    //   164: aload_0
    //   165: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   168: invokevirtual 155	com/tencent/mm/plugin/appbrand/y:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   171: aload 7
    //   173: aload 8
    //   175: aload_0
    //   176: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   179: invokevirtual 546	com/tencent/mm/plugin/appbrand/y:cbk	()Lcom/tencent/mm/plugin/appbrand/appcache/s;
    //   182: aload 6
    //   184: new 15	com/tencent/luggage/sdk/b/a/d/b$2
    //   187: dup
    //   188: aload_0
    //   189: iload_1
    //   190: aload_2
    //   191: aload_3
    //   192: invokespecial 549	com/tencent/luggage/sdk/b/a/d/b$2:<init>	(Lcom/tencent/luggage/sdk/b/a/d/b;ILjava/lang/String;Ljava/lang/String;)V
    //   195: invokestatic 554	com/tencent/mm/plugin/appbrand/jsapi/file/w:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Lorg/json/JSONArray;Lcom/tencent/mm/plugin/appbrand/n/i;Lcom/tencent/mm/plugin/appbrand/appcache/s;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/file/w$b;)V
    //   198: ldc 163
    //   200: ldc_w 556
    //   203: iconst_4
    //   204: anewarray 5	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload_0
    //   210: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   213: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   216: aastore
    //   217: dup
    //   218: iconst_1
    //   219: iload_1
    //   220: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: dup
    //   225: iconst_2
    //   226: aload 7
    //   228: invokevirtual 557	org/json/JSONArray:length	()I
    //   231: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   234: aastore
    //   235: dup
    //   236: iconst_3
    //   237: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   240: lload 4
    //   242: lsub
    //   243: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   246: aastore
    //   247: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: return
    //   251: astore_2
    //   252: ldc 163
    //   254: ldc_w 559
    //   257: iconst_3
    //   258: anewarray 5	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload_0
    //   264: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   267: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: iload_1
    //   274: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: aastore
    //   278: dup
    //   279: iconst_2
    //   280: aload_2
    //   281: aastore
    //   282: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: return
    //   286: astore 6
    //   288: ldc 163
    //   290: ldc_w 561
    //   293: iconst_4
    //   294: anewarray 5	java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: aload_0
    //   300: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   303: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   306: aastore
    //   307: dup
    //   308: iconst_1
    //   309: iload_1
    //   310: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: dup
    //   315: iconst_2
    //   316: aload_3
    //   317: aastore
    //   318: dup
    //   319: iconst_3
    //   320: aload 6
    //   322: aastore
    //   323: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   326: aconst_null
    //   327: astore 6
    //   329: goto -178 -> 151
    //   332: aload 6
    //   334: ldc_w 563
    //   337: invokevirtual 566	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   340: astore 6
    //   342: goto -178 -> 164
    //   345: astore 6
    //   347: ldc 163
    //   349: ldc_w 568
    //   352: iconst_5
    //   353: anewarray 5	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: aload_0
    //   359: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   362: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   365: aastore
    //   366: dup
    //   367: iconst_1
    //   368: iload_1
    //   369: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   372: aastore
    //   373: dup
    //   374: iconst_2
    //   375: aload_2
    //   376: aastore
    //   377: dup
    //   378: iconst_3
    //   379: aload_3
    //   380: aastore
    //   381: dup
    //   382: iconst_4
    //   383: aload 6
    //   385: aastore
    //   386: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: ldc 163
    //   391: ldc_w 556
    //   394: iconst_4
    //   395: anewarray 5	java/lang/Object
    //   398: dup
    //   399: iconst_0
    //   400: aload_0
    //   401: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   404: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   407: aastore
    //   408: dup
    //   409: iconst_1
    //   410: iload_1
    //   411: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   414: aastore
    //   415: dup
    //   416: iconst_2
    //   417: aload 7
    //   419: invokevirtual 557	org/json/JSONArray:length	()I
    //   422: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   425: aastore
    //   426: dup
    //   427: iconst_3
    //   428: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   431: lload 4
    //   433: lsub
    //   434: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   437: aastore
    //   438: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   441: return
    //   442: astore_2
    //   443: ldc 163
    //   445: ldc_w 556
    //   448: iconst_4
    //   449: anewarray 5	java/lang/Object
    //   452: dup
    //   453: iconst_0
    //   454: aload_0
    //   455: getfield 45	com/tencent/luggage/sdk/b/a/d/b:esk	Lcom/tencent/mm/plugin/appbrand/y;
    //   458: invokevirtual 168	com/tencent/mm/plugin/appbrand/y:getAppId	()Ljava/lang/String;
    //   461: aastore
    //   462: dup
    //   463: iconst_1
    //   464: iload_1
    //   465: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aastore
    //   469: dup
    //   470: iconst_2
    //   471: aload 7
    //   473: invokevirtual 557	org/json/JSONArray:length	()I
    //   476: invokestatic 201	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   479: aastore
    //   480: dup
    //   481: iconst_3
    //   482: invokestatic 281	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   485: lload 4
    //   487: lsub
    //   488: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   491: aastore
    //   492: invokestatic 241	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   495: aload_2
    //   496: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	b
    //   0	497	1	paramInt	int
    //   0	497	2	paramString1	String
    //   0	497	3	paramString2	String
    //   154	332	4	l	long
    //   132	51	6	localJSONObject	JSONObject
    //   286	35	6	localJSONException	JSONException
    //   327	14	6	str	String
    //   345	39	6	localObject	Object
    //   129	343	7	localJSONArray	JSONArray
    //   47	127	8	localg	g
    // Exception table:
    //   from	to	target	type
    //   121	131	251	org/json/JSONException
    //   134	151	286	org/json/JSONException
    //   164	198	345	finally
    //   347	389	442	finally
  }
  
  @JavascriptInterface
  public void loadLibFiles(int paramInt, String paramString)
  {
    g localg = ms(paramInt);
    if (localg == null)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL context by id[%d], appId[%s]", new Object[] { Integer.valueOf(paramInt), this.esk.getAppId() });
      return;
    }
    JSONArray localJSONArray;
    ICommLibReader localICommLibReader;
    try
    {
      localJSONArray = new JSONArray(paramString);
      localICommLibReader = this.esk.cbl();
      if (localICommLibReader == null)
      {
        Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get NULL LibReader, id[%d], appId[%s]", new Object[] { Integer.valueOf(paramInt), this.esk.getAppId() });
        return;
      }
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles parse paths failed, id[%d] appId[%s] e=%s", new Object[] { Integer.valueOf(paramInt), this.esk.getAppId(), paramString });
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
      Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY name by index[%d] id[%d] appId[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt), this.esk.getAppId() });
    }
    for (;;)
    {
      i += 1;
      break label133;
      break;
      label199:
      String str = localICommLibReader.UW(paramString);
      if (TextUtils.isEmpty(str))
      {
        Log.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadLibFiles get EMPTY script by name[%s] id[%d] appId[%s]", new Object[] { paramString, Integer.valueOf(paramInt), this.esk.getAppId() });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.d.b
 * JD-Core Version:    0.7.0.1
 */