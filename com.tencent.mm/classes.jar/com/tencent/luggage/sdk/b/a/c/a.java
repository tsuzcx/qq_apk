package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.aq;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.file.w;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.plugin.appbrand.x.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<SERVICE extends com.tencent.mm.plugin.appbrand.q>
  implements d
{
  protected final SERVICE cox;
  private final t coy;
  private final g coz;
  
  protected a(SERVICE paramSERVICE, t paramt)
  {
    this.cox = paramSERVICE;
    this.coy = paramt;
    this.coz = paramt.bqj();
  }
  
  protected int Da()
  {
    return 1;
  }
  
  protected g Dj()
  {
    return this.coy.bqj();
  }
  
  protected void Dk()
  {
    this.coy.bqi().b(this.coz, "WeixinJSContext");
  }
  
  protected abstract String Dl();
  
  protected final SERVICE Ew()
  {
    return this.cox;
  }
  
  protected int a(g paramg, String paramString)
  {
    long l1 = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final PInt localPInt = new PInt();
    Object localObject = bf.O(this.cox.getRuntime());
    if (localObject == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript pkgListReader is null, err, appId(%s) scriptPath(%s)", new Object[] { this.cox.getAppId(), paramString });
      return 0;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.appcache.q)localObject).Ll(paramString);
    if (localObject == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript, scriptFileInfo is null, appId(%s) scriptPath(%s)", new Object[] { this.cox.getAppId(), paramString });
      return 0;
    }
    final com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
    r.a(this.cox.getRuntime(), paramg, paramString, (q.a)localObject, new q.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        locali.value = paramAnonymousc;
        localPInt.value = paramAnonymousc.sourceLength;
      }
      
      public final void cT(String paramAnonymousString)
      {
        localPBool.value = false;
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        localPBool.value = true;
      }
    });
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.cox.getAppId(), Integer.valueOf(paramg.bqh()), paramString, Boolean.valueOf(localPBool.value) });
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.scriptName = paramString;
    paramg.cnv = null;
    paramg.cnw = localPInt.value;
    paramg.jFK = ((q.a)localObject).jFK;
    paramg.aDD = ((q.a)localObject).aDD;
    a(paramg, localPBool.value, l1, l2, locali.value);
    return localPInt.value;
  }
  
  protected abstract int a(SERVICE paramSERVICE);
  
  protected String a(SERVICE paramSERVICE, String paramString)
  {
    paramSERVICE = bf.d(paramSERVICE.getRuntime(), paramString);
    if (TextUtils.isEmpty(paramSERVICE)) {
      throw new ap(paramString);
    }
    return paramSERVICE;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  protected void a(SERVICE paramSERVICE, g paramg) {}
  
  @JavascriptInterface
  public final int alloc()
  {
    final g localg = Dj();
    if (localg == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", new Object[] { this.cox.getAppId() });
      return -2;
    }
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", new Object[] { Integer.valueOf(localg.bqh()) });
    localg.setJsExceptionHandler(new h()
    {
      public final void u(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(146788);
        ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        ck.a(localg, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { p.Vc(paramAnonymousString1), p.Vc(paramAnonymousString2) }));
        b.a.byl();
        b.K("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(146788);
      }
    });
    this.coz.b(localg, "WeixinJSContext");
    if (this.cox.getRuntime() == null) {}
    for (Object localObject = this.cox.aXD();; localObject = this.cox.EN())
    {
      localg.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[] { ((JSONObject)localObject).toString() }), null);
      try
      {
        localObject = b(this.cox);
        String str = Dl();
        long l1 = System.currentTimeMillis();
        final PBool localPBool = new PBool();
        final com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
        r.a(this.cox, localg, str, str, "v" + a(this.cox), Da(), (String)localObject, r.a.mOW, new q.b()
        {
          public final void a(m.c paramAnonymousc)
          {
            locali.value = paramAnonymousc;
          }
          
          public final void cT(String paramAnonymousString)
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
        locala.cnv = ((String)localObject);
        locala.cnw = ((String)localObject).length();
        a(locala, localPBool.value, l1, l2, locali.value);
        return localg.bqh();
      }
      catch (ap localap)
      {
        ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "inject sdk %s", new Object[] { localap.getMessage() });
      }
    }
    return 0;
  }
  
  protected abstract String b(SERVICE paramSERVICE);
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[] { this.cox.getAppId(), paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[] { this.cox.getAppId() });
      return -1;
    }
    int i = alloc();
    if (i <= 0) {
      return i;
    }
    g localg = this.coy.tS(i);
    i = evaluateScriptFile(i, paramString);
    if (i != 1)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", new Object[] { this.cox.getAppId(), paramString, Integer.valueOf(i) });
      return -1;
    }
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[] { this.cox.getAppId(), paramString, Integer.valueOf(localg.bqh()) });
    return localg.bqh();
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    this.coy.tT(paramInt);
  }
  
  @JavascriptInterface
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", new Object[] { this.cox.getAppId(), Integer.valueOf(paramInt), paramString });
    Object localObject = this.coy.tS(paramInt);
    if (localObject == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", new Object[] { this.cox.getAppId(), Integer.valueOf(paramInt), paramString });
      return -1;
    }
    if (((g)localObject).bqg())
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", new Object[] { this.cox.getAppId(), paramString });
      return -1;
    }
    a(this.cox, (g)localObject);
    if (this.cox.aYh().P(v.class) == null)
    {
      ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, appID(%s) contextId(%s) scriptPath(%s)", new Object[] { this.cox.getAppId(), Integer.valueOf(paramInt), paramString });
      for (;;)
      {
        AppBrandRuntime localAppBrandRuntime;
        String str2;
        String str3;
        r.a locala;
        q.b local2;
        try
        {
          String str1 = a(this.cox, paramString);
          long l1 = System.currentTimeMillis();
          final PBool localPBool = new PBool();
          final com.tencent.mm.plugin.appbrand.z.i locali = new com.tencent.mm.plugin.appbrand.z.i();
          localAppBrandRuntime = this.cox.getRuntime();
          str2 = paramString.replace('/', '_') + "_" + this.cox.getAppId();
          str3 = this.cox.getRuntime().Fh().jYh.md5;
          locala = r.a.mOX;
          local2 = new q.b()
          {
            public final void a(m.c paramAnonymousc)
            {
              locali.value = paramAnonymousc;
            }
            
            public final void cT(String paramAnonymousString)
            {
              localPBool.value = false;
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              localPBool.value = true;
            }
          };
          if ((localAppBrandRuntime == null) || (localAppBrandRuntime.Ew() == null))
          {
            ad.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
            ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectAppScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.cox.getAppId(), Integer.valueOf(((g)localObject).bqh()), paramString, Boolean.valueOf(localPBool.value) });
            long l2 = System.currentTimeMillis();
            localObject = new d.a();
            ((d.a)localObject).scriptName = paramString;
            ((d.a)localObject).cnv = str1;
            ((d.a)localObject).cnw = bt.nullAsNil(str1).length();
            a((d.a)localObject, localPBool.value, l1, l2, locali.value);
            return 1;
          }
        }
        catch (ap localap)
        {
          ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, with appID(%s) contextId(%d), appScriptPath(%s), %s", new Object[] { this.cox.getAppId(), Integer.valueOf(paramInt), paramString, localap.getMessage() });
          return 0;
        }
        String str4 = aq.a(localAppBrandRuntime, paramString, r.a(localAppBrandRuntime.Ew(), locala));
        if (!bt.isNullOrNil(str4)) {
          com.tencent.mm.plugin.appbrand.utils.q.a((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject, str4, null);
        }
        r.a(localAppBrandRuntime.Ew(), (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject, paramString, str2, str3, 0, localap, locala, local2);
      }
    }
    if (a((g)localObject, paramString) > 0) {
      return 1;
    }
    return 0;
  }
  
  @JavascriptInterface
  public void loadJsFiles(int paramInt, String paramString)
  {
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] paths[%s]", new Object[] { this.cox.getAppId(), Integer.valueOf(paramInt), paramString });
    g localg = this.coy.tS(paramInt);
    if (localg == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] get NULL context", new Object[] { this.cox.getAppId(), Integer.valueOf(paramInt) });
      return;
    }
    try
    {
      paramString = new JSONArray(paramString);
      w.a(this.cox.getRuntime(), paramString, localg, this.cox.aVC());
      return;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles parse json appId[%s] context[%d] e=%s", new Object[] { this.cox.getAppId(), Integer.valueOf(paramInt), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */