package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.luggage.sdk.b.a.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.q.a;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.ch;
import com.tencent.mm.plugin.appbrand.jsapi.file.w;
import com.tencent.mm.plugin.appbrand.jsruntime.g;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.t;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.plugin.appbrand.utils.q.b;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.r.a;
import com.tencent.mm.plugin.appbrand.y.b;
import com.tencent.mm.plugin.appbrand.y.b.a;
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
  protected final SERVICE chm;
  private final t chn;
  private final g cho;
  
  protected a(SERVICE paramSERVICE, t paramt)
  {
    this.chm = paramSERVICE;
    this.chn = paramt;
    this.cho = paramt.bfE();
  }
  
  protected int BX()
  {
    return 1;
  }
  
  protected g Cg()
  {
    return this.chn.bfE();
  }
  
  protected void Ch()
  {
    this.chn.bfD().b(this.cho, "WeixinJSContext");
  }
  
  protected abstract String Ci();
  
  protected final SERVICE Du()
  {
    return this.chm;
  }
  
  protected int a(g paramg, String paramString)
  {
    long l1 = System.currentTimeMillis();
    final PBool localPBool = new PBool();
    final PInt localPInt = new PInt();
    Object localObject = be.U(this.chm.getRuntime());
    if (localObject == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript pkgListReader is null, err, appId(%s) scriptPath(%s)", new Object[] { this.chm.getAppId(), paramString });
      return 0;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.appcache.q)localObject).DQ(paramString);
    if (localObject == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript, scriptFileInfo is null, appId(%s) scriptPath(%s)", new Object[] { this.chm.getAppId(), paramString });
      return 0;
    }
    final com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
    r.a(this.chm.getRuntime(), paramg, paramString, (q.a)localObject, new q.b()
    {
      public final void a(m.c paramAnonymousc)
      {
        locali.value = paramAnonymousc;
        localPInt.value = paramAnonymousc.sourceLength;
      }
      
      public final void cj(String paramAnonymousString)
      {
        localPBool.value = false;
      }
      
      public final void onSuccess(String paramAnonymousString)
      {
        localPBool.value = true;
      }
    });
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectWxaScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.chm.getAppId(), Integer.valueOf(paramg.bfC()), paramString, Boolean.valueOf(localPBool.value) });
    long l2 = System.currentTimeMillis();
    paramg = new d.a();
    paramg.scriptName = paramString;
    paramg.cgh = null;
    paramg.cgj = localPInt.value;
    paramg.iLN = ((q.a)localObject).iLN;
    paramg.aAS = ((q.a)localObject).aAS;
    a(paramg, localPBool.value, l1, l2, locali.value);
    return localPInt.value;
  }
  
  protected abstract int a(SERVICE paramSERVICE);
  
  protected String a(SERVICE paramSERVICE, String paramString)
  {
    paramSERVICE = be.d(paramSERVICE.getRuntime(), paramString);
    if (TextUtils.isEmpty(paramSERVICE)) {
      throw new ao(paramString);
    }
    return paramSERVICE;
  }
  
  public void a(d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, Object paramObject) {}
  
  protected void a(SERVICE paramSERVICE, g paramg) {}
  
  @JavascriptInterface
  public final int alloc()
  {
    final g localg = Cg();
    if (localg == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", new Object[] { this.chm.getAppId() });
      return -2;
    }
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", new Object[] { Integer.valueOf(localg.bfC()) });
    localg.setJsExceptionHandler(new h()
    {
      public final void t(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(146788);
        ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: on exception! message: %s, stacktrace %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        ch.a(localg, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { p.Nn(paramAnonymousString1), p.Nn(paramAnonymousString2) }));
        b.a.bnk();
        b.L("WeAppLaunch", paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(146788);
      }
    });
    this.cho.b(localg, "WeixinJSContext");
    if (this.chm.getRuntime() == null) {}
    for (Object localObject = this.chm.aNC();; localObject = this.chm.DL())
    {
      localg.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[] { ((JSONObject)localObject).toString() }), null);
      try
      {
        localObject = b(this.chm);
        String str = Ci();
        long l1 = System.currentTimeMillis();
        final PBool localPBool = new PBool();
        final com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
        r.a(this.chm, localg, str, str, "v" + a(this.chm), BX(), (String)localObject, r.a.lMx, new q.b()
        {
          public final void a(m.c paramAnonymousc)
          {
            locali.value = paramAnonymousc;
          }
          
          public final void cj(String paramAnonymousString)
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
        locala.cgh = ((String)localObject);
        locala.cgj = ((String)localObject).length();
        a(locala, localPBool.value, l1, l2, locali.value);
        return localg.bfC();
      }
      catch (ao localao)
      {
        ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "inject sdk %s", new Object[] { localao.getMessage() });
      }
    }
    return 0;
  }
  
  protected abstract String b(SERVICE paramSERVICE);
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[] { this.chm.getAppId(), paramString });
    if (bt.isNullOrNil(paramString))
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[] { this.chm.getAppId() });
      return -1;
    }
    int i = alloc();
    if (i <= 0) {
      return i;
    }
    g localg = this.chn.sy(i);
    i = evaluateScriptFile(i, paramString);
    if (i != 1)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", new Object[] { this.chm.getAppId(), paramString, Integer.valueOf(i) });
      return -1;
    }
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[] { this.chm.getAppId(), paramString, Integer.valueOf(localg.bfC()) });
    return localg.bfC();
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    this.chn.sz(paramInt);
  }
  
  @JavascriptInterface
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", new Object[] { this.chm.getAppId(), Integer.valueOf(paramInt), paramString });
    Object localObject = this.chn.sy(paramInt);
    if (localObject == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", new Object[] { this.chm.getAppId(), Integer.valueOf(paramInt), paramString });
      return -1;
    }
    if (((g)localObject).bfB())
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", new Object[] { this.chm.getAppId(), paramString });
      return -1;
    }
    a(this.chm, (g)localObject);
    if (this.chm.aOf().P(v.class) == null)
    {
      ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, appID(%s) contextId(%s) scriptPath(%s)", new Object[] { this.chm.getAppId(), Integer.valueOf(paramInt), paramString });
      for (;;)
      {
        AppBrandRuntime localAppBrandRuntime;
        String str2;
        String str3;
        r.a locala;
        q.b local2;
        try
        {
          String str1 = a(this.chm, paramString);
          long l1 = System.currentTimeMillis();
          final PBool localPBool = new PBool();
          final com.tencent.mm.plugin.appbrand.aa.i locali = new com.tencent.mm.plugin.appbrand.aa.i();
          localAppBrandRuntime = this.chm.getRuntime();
          str2 = paramString.replace('/', '_') + "_" + this.chm.getAppId();
          str3 = this.chm.getRuntime().Ef().jdS.md5;
          locala = r.a.lMy;
          local2 = new q.b()
          {
            public final void a(m.c paramAnonymousc)
            {
              locali.value = paramAnonymousc;
            }
            
            public final void cj(String paramAnonymousString)
            {
              localPBool.value = false;
            }
            
            public final void onSuccess(String paramAnonymousString)
            {
              localPBool.value = true;
            }
          };
          if ((localAppBrandRuntime == null) || (localAppBrandRuntime.Du() == null))
          {
            ad.i("MicroMsg.JsValidationInjectorWC", "hy: runtime or service is null!");
            ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "injectAppScript with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.chm.getAppId(), Integer.valueOf(((g)localObject).bfC()), paramString, Boolean.valueOf(localPBool.value) });
            long l2 = System.currentTimeMillis();
            localObject = new d.a();
            ((d.a)localObject).scriptName = paramString;
            ((d.a)localObject).cgh = str1;
            ((d.a)localObject).cgj = bt.nullAsNil(str1).length();
            a((d.a)localObject, localPBool.value, l1, l2, locali.value);
            return 1;
          }
        }
        catch (ao localao)
        {
          ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile without v8, with appID(%s) contextId(%d), appScriptPath(%s), %s", new Object[] { this.chm.getAppId(), Integer.valueOf(paramInt), paramString, localao.getMessage() });
          return 0;
        }
        String str4 = ap.a(localAppBrandRuntime, paramString, r.a(localAppBrandRuntime.Du(), locala));
        if (!bt.isNullOrNil(str4)) {
          com.tencent.mm.plugin.appbrand.utils.q.a((com.tencent.mm.plugin.appbrand.jsruntime.i)localObject, str4, null);
        }
        r.a(localAppBrandRuntime.Du(), (com.tencent.mm.plugin.appbrand.jsruntime.i)localObject, paramString, str2, str3, 0, localao, locala, local2);
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
    ad.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] paths[%s]", new Object[] { this.chm.getAppId(), Integer.valueOf(paramInt), paramString });
    g localg = this.chn.sy(paramInt);
    if (localg == null)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles appId[%s] contextId[%d] get NULL context", new Object[] { this.chm.getAppId(), Integer.valueOf(paramInt) });
      return;
    }
    try
    {
      paramString = new JSONArray(paramString);
      w.a(this.chm.getRuntime(), paramString, localg, this.chm.aLz());
      return;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "loadJsFiles parse json appId[%s] context[%d] e=%s", new Object[] { this.chm.getAppId(), Integer.valueOf(paramInt), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */