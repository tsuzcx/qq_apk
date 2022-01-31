package com.tencent.mm.plugin.appbrand;

import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.i.d;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.plugin.appbrand.i.l;
import com.tencent.mm.plugin.appbrand.v.k;
import com.tencent.mm.plugin.appbrand.v.k.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Locale;
import org.json.JSONObject;

public abstract class e
{
  public final o fxC;
  private final l fxD;
  private final d fxE;
  
  public e(o paramo, l paraml)
  {
    this.fxC = paramo;
    this.fxD = paraml;
    this.fxE = paraml.agp();
  }
  
  public void Zn()
  {
    this.fxD.ago().a(this.fxE, "WeixinJSContext");
  }
  
  public d Zo()
  {
    return this.fxD.agp();
  }
  
  public abstract String Zp();
  
  public abstract String Zq();
  
  public abstract int Zr();
  
  public void Zs() {}
  
  public void Zt() {}
  
  public void a(f paramf, String paramString1, String paramString2)
  {
    k.a(paramf, this.fxC.aay() + paramString1, paramString1, "v" + Zr(), paramString2, "", new e.2(this, paramString1));
  }
  
  public void a(f paramf, String paramString1, String paramString2, k.a parama)
  {
    k.a(paramf, this.fxC.aaz() + paramString1, paramString1 + "_" + this.fxC.mAppId, this.fxC.getRuntime().ZB().fPS.bIW, paramString2, this.fxC.qK(paramString1), parama);
  }
  
  @JavascriptInterface
  public int alloc()
  {
    d locald = Zo();
    if (locald == null)
    {
      y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), allocJsContext failed", new Object[] { this.fxC.mAppId });
      return -2;
    }
    y.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "hy: created context id is %d", new Object[] { Integer.valueOf(locald.agf()) });
    this.fxE.a(locald, "WeixinJSContext");
    if (this.fxC.getRuntime() == null) {}
    String str;
    for (Object localObject = this.fxC.aax();; localObject = this.fxC.aaw())
    {
      locald.evaluateJavascript(String.format(Locale.US, "var __wxConfig = %s;", new Object[] { ((JSONObject)localObject).toString() }), null);
      localObject = Zp();
      str = Zq();
      if (!bk.bl(str)) {
        break;
      }
      y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "alloc with appID(%s), sdkScript 404", new Object[] { this.fxC.mAppId });
      Zs();
      return 0;
    }
    a(locald, (String)localObject, str);
    return locald.agf();
  }
  
  public void cC(boolean paramBoolean) {}
  
  public void cD(boolean paramBoolean) {}
  
  @JavascriptInterface
  public int create(String paramString)
  {
    y.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s)", new Object[] { this.fxC.mAppId, paramString });
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), nil appScriptPath", new Object[] { this.fxC.mAppId });
      return -1;
    }
    int i = alloc();
    if (i <= 0) {
      return i;
    }
    d locald = this.fxD.kQ(i);
    i = evaluateScriptFile(i, paramString);
    if (i != 1)
    {
      y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s), appScriptPath(%s), eval ret = %d", new Object[] { this.fxC.mAppId, paramString, Integer.valueOf(i) });
      return -1;
    }
    y.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "create with appID(%s) appScriptPath(%s), success with contextId(%d)", new Object[] { this.fxC.mAppId, paramString, Integer.valueOf(locald.agf()) });
    return locald.agf();
  }
  
  @JavascriptInterface
  public final void destroy(int paramInt)
  {
    this.fxD.kR(paramInt);
  }
  
  @JavascriptInterface
  public int evaluateScriptFile(int paramInt, String paramString)
  {
    y.i("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d) appScriptPath(%s)", new Object[] { this.fxC.mAppId, Integer.valueOf(paramInt), paramString });
    d locald = this.fxD.kQ(paramInt);
    if (locald == null)
    {
      y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), get null context", new Object[] { this.fxC.mAppId, Integer.valueOf(paramInt), paramString });
      return -1;
    }
    if (locald.age())
    {
      y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) scriptPath(%s), but want to inject main-context", new Object[] { this.fxC.mAppId, paramString });
      return -1;
    }
    String str = aq.a(this.fxC.getRuntime(), paramString);
    if (bk.bl(str))
    {
      y.e("MicroMsg.AppBrandJSContextInterface[multicontext]", "evaluateScriptFile with appID(%s) contextId(%d), appScriptPath(%s), script 404", new Object[] { this.fxC.mAppId, Integer.valueOf(paramInt), paramString });
      Zt();
      return 0;
    }
    qs(paramString);
    a(locald, paramString, str, new e.1(this, locald, paramString));
    return 1;
  }
  
  public void qs(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.e
 * JD-Core Version:    0.7.0.1
 */