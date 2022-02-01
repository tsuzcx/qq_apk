package com.tencent.mm.plugin.appbrand.page;

import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.t.i;
import com.tencent.mm.plugin.appbrand.t.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;

public class ao
{
  ad enm;
  private m tzd;
  volatile String tze;
  
  public ao(ad paramad)
  {
    this.enm = paramad;
  }
  
  public final boolean a(SslCertificate paramSslCertificate)
  {
    AppMethodBeat.i(135249);
    if (this.enm.getRuntime() == null)
    {
      AppMethodBeat.o(135249);
      return false;
    }
    if (this.tzd == null) {
      this.tzd = i.b((com.tencent.mm.plugin.appbrand.t.a)this.enm.getRuntime().aN(com.tencent.mm.plugin.appbrand.t.a.class));
    }
    if (this.tzd == null)
    {
      AppMethodBeat.o(135249);
      return false;
    }
    Log.d("Luggage.AppBrandWebViewClient", "subjectDN: ".concat(String.valueOf(paramSslCertificate.getIssuedTo().getDName())));
    for (;;)
    {
      try
      {
        Field localField = paramSslCertificate.getClass().getDeclaredField("mX509Certificate");
        localField.setAccessible(true);
        paramSslCertificate = (X509Certificate)localField.get(paramSslCertificate);
      }
      catch (Exception paramSslCertificate)
      {
        Log.e("Luggage.AppBrandWebViewClient", "Certificate check failed: ", new Object[] { paramSslCertificate });
        boolean bool = false;
        continue;
      }
      try
      {
        this.tzd.checkServerTrusted(new X509Certificate[] { paramSslCertificate }, "generic");
        bool = true;
      }
      catch (Exception paramSslCertificate)
      {
        Log.e("Luggage.AppBrandWebViewClient", "Certificate check failed: ".concat(String.valueOf(paramSslCertificate)));
        bool = false;
      }
    }
    AppMethodBeat.o(135249);
    return bool;
  }
  
  public final WebResourceResponse aeT(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(135250);
    if (paramString == null)
    {
      AppMethodBeat.o(135250);
      return null;
    }
    if (!this.enm.isRunning())
    {
      AppMethodBeat.o(135250);
      return null;
    }
    Object localObject2 = this.tze;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      Log.e("Luggage.AppBrandWebViewClient", "getAppResourceResponse with reqURL[%s], hostURL isEmpty", new Object[] { paramString });
      AppMethodBeat.o(135250);
      return null;
    }
    if (paramString.startsWith((String)localObject2))
    {
      localObject2 = bl.e(this.enm.getRuntime(), paramString.replaceFirst((String)localObject2, ""));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        Log.e("Luggage.AppBrandWebViewClient", "getAppResourceResponse %s not found", new Object[] { paramString });
        localObject2 = new WebResourceResponse("image/*", "utf-8", new ByteArrayInputStream(new byte[0]));
        localObject1 = localObject2;
        if (Build.VERSION.SDK_INT >= 21)
        {
          ((WebResourceResponse)localObject2).setStatusCodeAndReasonPhrase(404, "NotFound");
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      Log.i("Luggage.AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", new Object[] { paramString });
      AppMethodBeat.o(135250);
      return localObject1;
      if ((URLUtil.isAboutUrl(paramString)) || (URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)) || (URLUtil.isDataUrl(paramString)))
      {
        AppMethodBeat.o(135250);
        return null;
      }
      localObject2 = new k();
      this.enm.getRuntime().getFileSystem().b(paramString, (k)localObject2);
      if (((k)localObject2).value != null)
      {
        localObject1 = new WebResourceResponse("", "", new com.tencent.luggage.l.a((ByteBuffer)((k)localObject2).value));
        if (Build.VERSION.SDK_INT >= 21) {
          ((WebResourceResponse)localObject1).setStatusCodeAndReasonPhrase(200, "OK");
        }
      }
    }
  }
  
  public void eH(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ao
 * JD-Core Version:    0.7.0.1
 */