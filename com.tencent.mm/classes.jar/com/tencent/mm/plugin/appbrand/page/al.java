package com.tencent.mm.plugin.appbrand.page;

import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.o.n;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;

public class al
{
  aa ckN;
  private n mdF;
  volatile String mdG;
  
  public al(aa paramaa)
  {
    this.ckN = paramaa;
  }
  
  public final WebResourceResponse Tt(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(135250);
    if (paramString == null)
    {
      AppMethodBeat.o(135250);
      return null;
    }
    if (!this.ckN.isRunning())
    {
      AppMethodBeat.o(135250);
      return null;
    }
    Object localObject2 = this.mdG;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ad.e("Luggage.AppBrandWebViewClient", "getAppResourceResponse with reqURL[%s], hostURL isEmpty", new Object[] { paramString });
      AppMethodBeat.o(135250);
      return null;
    }
    if (paramString.startsWith((String)localObject2))
    {
      localObject2 = bf.e(this.ckN.getRuntime(), paramString.replaceFirst((String)localObject2, ""));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ad.e("Luggage.AppBrandWebViewClient", "getAppResourceResponse %s not found", new Object[] { paramString });
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
      ad.i("Luggage.AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", new Object[] { paramString });
      AppMethodBeat.o(135250);
      return localObject1;
      if ((URLUtil.isAboutUrl(paramString)) || (URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)) || (URLUtil.isDataUrl(paramString)))
      {
        AppMethodBeat.o(135250);
        return null;
      }
      localObject2 = new i();
      this.ckN.getRuntime().Fg().b(paramString, (i)localObject2);
      if (((i)localObject2).value != null) {
        localObject1 = new WebResourceResponse("", "", new com.tencent.luggage.h.a((ByteBuffer)((i)localObject2).value));
      }
    }
  }
  
  public final boolean a(SslCertificate paramSslCertificate)
  {
    AppMethodBeat.i(135249);
    if (this.ckN.getRuntime() == null)
    {
      AppMethodBeat.o(135249);
      return false;
    }
    if (this.mdF == null) {
      this.mdF = j.b((com.tencent.mm.plugin.appbrand.o.a)this.ckN.getRuntime().ar(com.tencent.mm.plugin.appbrand.o.a.class));
    }
    if (this.mdF == null)
    {
      AppMethodBeat.o(135249);
      return false;
    }
    ad.d("Luggage.AppBrandWebViewClient", "subjectDN: ".concat(String.valueOf(paramSslCertificate.getIssuedTo().getDName())));
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
        ad.e("Luggage.AppBrandWebViewClient", "Certificate check failed: ", new Object[] { paramSslCertificate });
        boolean bool = false;
        continue;
      }
      try
      {
        this.mdF.checkServerTrusted(new X509Certificate[] { paramSslCertificate }, "generic");
        bool = true;
      }
      catch (Exception paramSslCertificate)
      {
        ad.e("Luggage.AppBrandWebViewClient", "Certificate check failed: ".concat(String.valueOf(paramSslCertificate)));
        bool = false;
      }
    }
    AppMethodBeat.o(135249);
    return bool;
  }
  
  public void cE(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al
 * JD-Core Version:    0.7.0.1
 */