package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.ag;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.i.g;
import com.tencent.mm.plugin.appbrand.i.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.t.o;
import com.tencent.mm.plugin.appbrand.t.o.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import org.json.JSONObject;

public abstract class a<SERVICE extends r>
  implements com.tencent.luggage.sdk.b.a.d
{
  public final SERVICE bEw;
  private final q bEx;
  private final g bEy;
  
  protected a(SERVICE paramSERVICE, q paramq)
  {
    this.bEw = paramSERVICE;
    this.bEx = paramq;
    this.bEy = paramq.aGC();
  }
  
  protected abstract int a(SERVICE paramSERVICE);
  
  protected String a(SERVICE paramSERVICE, String paramString)
  {
    paramSERVICE = ax.c(paramSERVICE.getRuntime(), paramString);
    if (TextUtils.isEmpty(paramSERVICE)) {
      throw new a.a(paramString);
    }
    return paramSERVICE;
  }
  
  protected void a(g paramg, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    PBool localPBool = new PBool();
    o.a(this.bEw.getRuntime(), paramg, paramString1, paramString1.replace('/', '_') + "_" + this.bEw.getAppId(), this.bEw.getRuntime().wY().hiX.cqq, paramString2, o.a.iXQ, new a.2(this, localPBool));
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s), contextId(%d), appScriptPath(%s), succeed(%b)", new Object[] { this.bEw.getAppId(), Integer.valueOf(paramg.aGA()), paramString1, Boolean.valueOf(localPBool.value) });
    long l2 = System.currentTimeMillis();
    a(paramString1, paramString2, localPBool.value, l1, l2);
  }
  
  @JavascriptInterface
  public final int alloc()
  {
    g localg = vk();
    if (localg == null)
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", new Object[] { this.bEw.getAppId() });
      return -2;
    }
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", new Object[] { Integer.valueOf(localg.aGA()) });
    localg.setJsExceptionHandler(new a.1(this, localg));
    this.bEy.a(localg, "WeixinJSContext");
    if (this.bEw.getRuntime() == null) {}
    for (Object localObject = this.bEw.auh();; localObject = this.bEw.wE())
    {
      localg.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[] { ((JSONObject)localObject).toString() }), null);
      try
      {
        localObject = b(this.bEw);
        String str = vm();
        long l1 = System.currentTimeMillis();
        PBool localPBool = new PBool();
        o.a(this.bEw, localg, str, str, "v" + a(this.bEw), (String)localObject, o.a.iXP, new a.3(this, localPBool));
        ag.a(this.bEw.getRuntime(), localg);
        long l2 = System.currentTimeMillis();
        a(str, (String)localObject, localPBool.value, l1, l2);
        return localg.aGA();
      }
      catch (a.a locala)
      {
        com.tencent.luggage.g.d.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "inject sdk %s", new Object[] { locala.getMessage() });
      }
    }
    return 0;
  }
  
  protected abstract String b(SERVICE paramSERVICE);
  
  @JavascriptInterface
  public final int create(String paramString)
  {
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[] { this.bEw.getAppId(), paramString });
    if (bo.isNullOrNil(paramString))
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[] { this.bEw.getAppId() });
      return -1;
    }
    int i = alloc();
    if (i <= 0) {
      return i;
    }
    g localg = this.bEx.ow(i);
    i = evaluateScriptFile(i, paramString);
    if (i != 1)
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", new Object[] { this.bEw.getAppId(), paramString, Integer.valueOf(i) });
      return -1;
    }
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[] { this.bEw.getAppId(), paramString, Integer.valueOf(localg.aGA()) });
    return localg.aGA();
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    this.bEx.ox(paramInt);
  }
  
  @JavascriptInterface
  public final int evaluateScriptFile(int paramInt, String paramString)
  {
    com.tencent.luggage.g.d.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", new Object[] { this.bEw.getAppId(), Integer.valueOf(paramInt), paramString });
    g localg = this.bEx.ow(paramInt);
    if (localg == null)
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", new Object[] { this.bEw.getAppId(), Integer.valueOf(paramInt), paramString });
      return -1;
    }
    if (localg.aGz())
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", new Object[] { this.bEw.getAppId(), paramString });
      return -1;
    }
    try
    {
      String str = a(this.bEw, paramString);
      a(localg, paramString, str);
      return 1;
    }
    catch (a.a locala)
    {
      com.tencent.luggage.g.d.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), %s", new Object[] { this.bEw.getAppId(), Integer.valueOf(paramInt), paramString, locala.getMessage() });
    }
    return 0;
  }
  
  protected g vk()
  {
    return this.bEx.aGC();
  }
  
  protected void vl()
  {
    this.bEx.aGB().a(this.bEy, "WeixinJSContext");
  }
  
  protected abstract String vm();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.a
 * JD-Core Version:    0.7.0.1
 */