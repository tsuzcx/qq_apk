package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.ar;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.s.b;
import com.tencent.mm.plugin.appbrand.utils.t.a;
import com.tencent.mm.plugin.appbrand.w.b;
import com.tencent.mm.plugin.appbrand.w.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Locale;
import org.json.JSONObject;

public abstract class a<SERVICE extends com.tencent.mm.plugin.appbrand.r>
  implements d
{
  private final com.tencent.mm.plugin.appbrand.jsruntime.t coA;
  private final g coB;
  protected final SERVICE coz;
  
  protected a(SERVICE paramSERVICE, com.tencent.mm.plugin.appbrand.jsruntime.t paramt)
  {
    this.coz = paramSERVICE;
    this.coA = paramt;
    this.coB = paramt.bqS();
  }
  
  protected int Dd()
  {
    return 1;
  }
  
  protected g Dm()
  {
    return this.coA.bqS();
  }
  
  protected void Dn()
  {
    this.coA.bqR().b(this.coB, "WeixinJSContext");
  }
  
  protected abstract String Do();
  
  protected final SERVICE Ey()
  {
    return this.coz;
  }
  
  protected int a(g paramg, String paramString)
  {
    long l1 = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final PInt localPInt = new PInt();
    Object localObject = bg.M(this.coz.getRuntime());
    if (localObject == null)
    {
      ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript pkgListReader is null, err, appId(%s) scriptPath(%s)", new Object[] { this.coz.getAppId(), paramString });
      return 0;
    }
    localObject = ((q)localObject).LM(paramString);
    if (localObject == null)
    {
      ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript, scriptFileInfo is null, appId(%s) scriptPath(%s)", new Object[] { this.coz.getAppId(), paramString });
      return 0;
    }
    final com.tencent.mm.plugin.appbrand.y.i locali = new com.tencent.mm.plugin.appbrand.y.i();
    com.tencent.mm.plugin.appbrand.utils.t.a(this.coz.getRuntime(), paramg, paramString, (q.a)localObject, new s.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        locali.value = paramAnonymousc;
        localPInt.value = paramAnonymousc.sourceLength;
      }
      
      public final void cV(String paramAnonymousString)
      {
        localPBool.value = false;
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        localPBool.value = true;
      }
    });
    ae.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.coz.getAppId(), Integer.valueOf(paramg.bqQ()), paramString, Boolean.valueOf(localPBool.value) });
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.scriptName = paramString;
    paramg.cnx = null;
    paramg.cny = localPInt.value;
    paramg.jIJ = ((q.a)localObject).jIJ;
    paramg.aDD = ((q.a)localObject).aDD;
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
  
  @JavascriptInterface
  public final int alloc()
  {
    Object localObject2 = Dm();
    int i;
    if (localObject2 == null)
    {
      ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", new Object[] { this.coz.getAppId() });
      i = -2;
      if (i <= 0) {
        return i;
      }
    }
    else
    {
      ae.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", new Object[] { Integer.valueOf(((g)localObject2).bqQ()) });
      ((g)localObject2).setJsExceptionHandler(new h()
      {
        public final void u(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(146788);
          ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          ck.a(this.coC, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { com.tencent.mm.plugin.appbrand.utils.r.VN(paramAnonymousString1), com.tencent.mm.plugin.appbrand.utils.r.VN(paramAnonymousString2) }));
          b.a.bze();
          b.L("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(146788);
        }
      });
      this.coB.b((g)localObject2, "WeixinJSContext");
      if (this.coz.getRuntime() == null) {}
      for (localObject1 = this.coz.aXY();; localObject1 = this.coz.EP())
      {
        ((g)localObject2).evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[] { ((JSONObject)localObject1).toString() }), null);
        i = ((g)localObject2).bqQ();
        break;
      }
    }
    Object localObject1 = this.coA.tY(i);
    try
    {
      localObject2 = b(this.coz);
      String str = Do();
      long l1 = System.currentTimeMillis();
      final PBool localPBool = new PBool();
      final com.tencent.mm.plugin.appbrand.y.i locali = new com.tencent.mm.plugin.appbrand.y.i();
      com.tencent.mm.plugin.appbrand.utils.t.a(this.coz, (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject1, str, str, "v" + a(this.coz), Dd(), (String)localObject2, t.a.mUb, new s.b()
      {
        public final void a(m.c paramAnonymousc)
        {
          locali.value = paramAnonymousc;
        }
        
        public final void cV(String paramAnonymousString)
        {
          localPBool.value = false;
        }
        
        public final void onSuccess(String paramAnonymousString)
        {
          localPBool.value = true;
        }
      });
      long l2 = System.currentTimeMillis();
      d.a locala = new d.a();
      locala.scriptName = str;
      locala.cnx = ((String)localObject2);
      locala.cny = ((String)localObject2).length();
      a(locala, localPBool.value, l1, l2, locali.value);
      return ((g)localObject1).bqQ();
    }
    catch (aq localaq)
    {
      ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "inject sdk %s", new Object[] { localaq.getMessage() });
    }
    return 0;
  }
  
  protected abstract String b(SERVICE paramSERVICE);
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    ae.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[] { this.coz.getAppId(), paramString });
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[] { this.coz.getAppId() });
      return -1;
    }
    int i = alloc();
    if (i <= 0) {
      return i;
    }
    g localg = this.coA.tY(i);
    i = evaluateScriptFile(i, paramString);
    if (i != 1)
    {
      ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", new Object[] { this.coz.getAppId(), paramString, Integer.valueOf(i) });
      return -1;
    }
    ae.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[] { this.coz.getAppId(), paramString, Integer.valueOf(localg.bqQ()) });
    return localg.bqQ();
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    this.coA.tZ(paramInt);
  }
  
  @JavascriptInterface
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    ae.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", new Object[] { this.coz.getAppId(), Integer.valueOf(paramInt), paramString });
    Object localObject = this.coA.tY(paramInt);
    if (localObject == null)
    {
      ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", new Object[] { this.coz.getAppId(), Integer.valueOf(paramInt), paramString });
      return -1;
    }
    if (((g)localObject).bqP())
    {
      ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", new Object[] { this.coz.getAppId(), paramString });
      return -1;
    }
    a(this.coz, (g)localObject);
    if (this.coz.aYB().P(v.class) == null)
    {
      ae.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, appID(%s) contextId(%s) scriptPath(%s)", new Object[] { this.coz.getAppId(), Integer.valueOf(paramInt), paramString });
      for (;;)
      {
        AppBrandRuntime localAppBrandRuntime;
        String str2;
        String str3;
        t.a locala;
        s.b local2;
        try
        {
          String str1 = a(this.coz, paramString);
          long l1 = System.currentTimeMillis();
          final PBool localPBool = new PBool();
          final com.tencent.mm.plugin.appbrand.y.i locali = new com.tencent.mm.plugin.appbrand.y.i();
          localAppBrandRuntime = this.coz.getRuntime();
          str2 = paramString.replace('/', '_') + "_" + this.coz.getAppId();
          str3 = this.coz.getRuntime().Fm().kbw.md5;
          locala = t.a.mUc;
          local2 = new s.b()
          {
            public final void a(m.c paramAnonymousc)
            {
              locali.value = paramAnonymousc;
            }
            
            public final void cV(String paramAnonymousString)
            {
              localPBool.value = false;
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              localPBool.value = true;
            }
          };
          if ((localAppBrandRuntime == null) || (localAppBrandRuntime.Ey() == null))
          {
            ae.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
            ae.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectAppScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.coz.getAppId(), Integer.valueOf(((g)localObject).bqQ()), paramString, Boolean.valueOf(localPBool.value) });
            long l2 = System.currentTimeMillis();
            localObject = new d.a();
            ((d.a)localObject).scriptName = paramString;
            ((d.a)localObject).cnx = str1;
            ((d.a)localObject).cny = bu.nullAsNil(str1).length();
            a((d.a)localObject, localPBool.value, l1, l2, locali.value);
            return 1;
          }
        }
        catch (aq localaq)
        {
          ae.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, with appID(%s) contextId(%d), appScriptPath(%s), %s", new Object[] { this.coz.getAppId(), Integer.valueOf(paramInt), paramString, localaq.getMessage() });
          return 0;
        }
        String str4 = ar.a(localAppBrandRuntime, paramString, com.tencent.mm.plugin.appbrand.utils.t.a(localAppBrandRuntime.Ey(), locala));
        if (!bu.isNullOrNil(str4)) {
          s.a((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject, str4, null);
        }
        com.tencent.mm.plugin.appbrand.utils.t.a(localAppBrandRuntime.Ey(), (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject, paramString, str2, str3, 0, localaq, locala, local2);
      }
    }
    if (a((g)localObject, paramString) > 0) {
      return 1;
    }
    return 0;
  }
  
  /* Error */
  @JavascriptInterface
  public void loadJsFilesWithOptions(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 90
    //   2: ldc_w 408
    //   5: iconst_3
    //   6: anewarray 5	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: aload_0
    //   12: getfield 29	com/tencent/luggage/sdk/b/a/c/a:coz	Lcom/tencent/mm/plugin/appbrand/r;
    //   15: invokevirtual 95	com/tencent/mm/plugin/appbrand/r:getAppId	()Ljava/lang/String;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: iload_1
    //   22: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   25: aastore
    //   26: dup
    //   27: iconst_2
    //   28: aload_2
    //   29: aastore
    //   30: invokestatic 143	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 31	com/tencent/luggage/sdk/b/a/c/a:coA	Lcom/tencent/mm/plugin/appbrand/jsruntime/t;
    //   37: iload_1
    //   38: invokeinterface 244 2 0
    //   43: astore 4
    //   45: aload 4
    //   47: ifnonnull +33 -> 80
    //   50: ldc 90
    //   52: ldc_w 410
    //   55: iconst_2
    //   56: anewarray 5	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: getfield 29	com/tencent/luggage/sdk/b/a/c/a:coz	Lcom/tencent/mm/plugin/appbrand/r;
    //   65: invokevirtual 95	com/tencent/mm/plugin/appbrand/r:getAppId	()Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_1
    //   71: iload_1
    //   72: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: aastore
    //   76: invokestatic 101	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: return
    //   80: new 412	org/json/JSONArray
    //   83: dup
    //   84: aload_2
    //   85: invokespecial 413	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: aload_3
    //   90: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +12 -> 105
    //   96: new 224	org/json/JSONObject
    //   99: dup
    //   100: aload_3
    //   101: invokespecial 414	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   104: pop
    //   105: aload_0
    //   106: getfield 29	com/tencent/luggage/sdk/b/a/c/a:coz	Lcom/tencent/mm/plugin/appbrand/r;
    //   109: invokevirtual 82	com/tencent/mm/plugin/appbrand/r:getRuntime	()Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   112: aload_2
    //   113: aload 4
    //   115: aload_0
    //   116: getfield 29	com/tencent/luggage/sdk/b/a/c/a:coz	Lcom/tencent/mm/plugin/appbrand/r;
    //   119: invokevirtual 418	com/tencent/mm/plugin/appbrand/r:aWb	()Lcom/tencent/mm/plugin/appbrand/appcache/q;
    //   122: invokestatic 423	com/tencent/mm/plugin/appbrand/jsapi/file/w:a	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Lorg/json/JSONArray;Lcom/tencent/mm/plugin/appbrand/jsruntime/i;Lcom/tencent/mm/plugin/appbrand/appcache/q;)V
    //   125: return
    //   126: astore_2
    //   127: ldc 90
    //   129: ldc_w 425
    //   132: iconst_3
    //   133: anewarray 5	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: aload_0
    //   139: getfield 29	com/tencent/luggage/sdk/b/a/c/a:coz	Lcom/tencent/mm/plugin/appbrand/r;
    //   142: invokevirtual 95	com/tencent/mm/plugin/appbrand/r:getAppId	()Ljava/lang/String;
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: iload_1
    //   149: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: dup
    //   154: iconst_2
    //   155: aload_2
    //   156: aastore
    //   157: invokestatic 101	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: return
    //   161: astore_3
    //   162: ldc 90
    //   164: ldc_w 427
    //   167: iconst_3
    //   168: anewarray 5	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_0
    //   174: getfield 29	com/tencent/luggage/sdk/b/a/c/a:coz	Lcom/tencent/mm/plugin/appbrand/r;
    //   177: invokevirtual 95	com/tencent/mm/plugin/appbrand/r:getAppId	()Ljava/lang/String;
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: iload_1
    //   184: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: dup
    //   189: iconst_2
    //   190: aload_3
    //   191: aastore
    //   192: invokestatic 101	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   195: goto -90 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	a
    //   0	198	1	paramInt	int
    //   0	198	2	paramString1	String
    //   0	198	3	paramString2	String
    //   43	71	4	localg	g
    // Exception table:
    //   from	to	target	type
    //   80	89	126	org/json/JSONException
    //   89	105	161	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */