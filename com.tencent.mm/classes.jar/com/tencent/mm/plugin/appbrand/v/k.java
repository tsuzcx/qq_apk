package com.tencent.mm.plugin.appbrand.v;

import android.annotation.SuppressLint;
import com.tencent.mm.plugin.appbrand.i.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.MalformedURLException;
import java.net.URL;

public final class k
{
  public static void a(f paramf, String paramString, k.a parama)
  {
    if (bk.bl(paramString))
    {
      if (parama != null) {
        parama.fM("isNullOrNil script");
      }
      return;
    }
    paramf.evaluateJavascript(paramString + String.format(";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) }), new k.1(parama));
  }
  
  @SuppressLint({"DefaultLocale"})
  public static void a(f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, k.a parama)
  {
    y.i("MicroMsg.JsValidationInjector", "hy: injecting file %s", new Object[] { paramString1 });
    if (bk.bl(paramString4))
    {
      y.e("MicroMsg.JsValidationInjector", "hy: empty script!");
      if (parama != null) {
        parama.fM("isNullOrNil script");
      }
      return;
    }
    paramString4 = paramString4 + String.format(";(function(){return %d;})();", new Object[] { Integer.valueOf(11111) });
    String str = paramString4 + bk.pm(paramString5);
    paramString5 = null;
    paramString4 = paramString5;
    if (paramString1 != null) {
      paramString4 = paramString5;
    }
    try
    {
      if (paramString1.length() > 0) {
        paramString4 = new URL(paramString1);
      }
      if (bk.bl(paramString3))
      {
        paramf.a(paramString4, str, new k.2(paramString1, parama));
        return;
      }
    }
    catch (MalformedURLException paramf)
    {
      y.e("MicroMsg.JsValidationInjector", "hy: MalformedURLException");
      parama.fM("MalformedURLException");
      return;
    }
    paramf.a(paramString4, paramString2, paramString3, str, new k.3(paramString1, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.v.k
 * JD-Core Version:    0.7.0.1
 */