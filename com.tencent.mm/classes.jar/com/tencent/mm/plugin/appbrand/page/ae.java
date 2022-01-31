package com.tencent.mm.plugin.appbrand.page;

import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.os.Build.VERSION;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.m.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;

public class ae
{
  v bBK;
  private n iyv;
  String iyw;
  
  public ae(v paramv)
  {
    this.bBK = paramv;
  }
  
  public final WebResourceResponse Ep(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(87313);
    if (paramString == null)
    {
      AppMethodBeat.o(87313);
      return null;
    }
    if (!this.bBK.isRunning())
    {
      AppMethodBeat.o(87313);
      return null;
    }
    Object localObject2 = this.iyw;
    if (paramString.startsWith((String)localObject2))
    {
      localObject2 = ax.e(this.bBK.getRuntime(), paramString.replaceFirst((String)localObject2, ""));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        ab.e("Luggage.AppBrandWebViewClient", "getAppResourceResponse %s not found", new Object[] { paramString });
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
      ab.i("Luggage.AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", new Object[] { paramString });
      AppMethodBeat.o(87313);
      return localObject1;
      if ((URLUtil.isAboutUrl(paramString)) || (URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)))
      {
        AppMethodBeat.o(87313);
        return null;
      }
      localObject2 = new com.tencent.mm.plugin.appbrand.s.j();
      this.bBK.getRuntime().wX().b(paramString, (com.tencent.mm.plugin.appbrand.s.j)localObject2);
      if (((com.tencent.mm.plugin.appbrand.s.j)localObject2).value != null) {
        localObject1 = new WebResourceResponse("", "", new com.tencent.luggage.g.a((ByteBuffer)((com.tencent.mm.plugin.appbrand.s.j)localObject2).value));
      }
    }
  }
  
  public final boolean a(SslCertificate paramSslCertificate)
  {
    AppMethodBeat.i(87312);
    if (this.bBK.getRuntime() == null)
    {
      AppMethodBeat.o(87312);
      return false;
    }
    if (this.iyv == null) {
      this.iyv = com.tencent.mm.plugin.appbrand.m.j.b((com.tencent.mm.plugin.appbrand.m.a)this.bBK.getRuntime().U(com.tencent.mm.plugin.appbrand.m.a.class));
    }
    ab.d("Luggage.AppBrandWebViewClient", "subjectDN: ".concat(String.valueOf(paramSslCertificate.getIssuedTo().getDName())));
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
        ab.e("Luggage.AppBrandWebViewClient", "Certificate check failed: ", new Object[] { paramSslCertificate });
        boolean bool = false;
        continue;
      }
      try
      {
        this.iyv.checkServerTrusted(new X509Certificate[] { paramSslCertificate }, "generic");
        bool = true;
      }
      catch (Exception paramSslCertificate)
      {
        ab.e("Luggage.AppBrandWebViewClient", "Certificate check failed: ".concat(String.valueOf(paramSslCertificate)));
        bool = false;
      }
    }
    AppMethodBeat.o(87312);
    return bool;
  }
  
  public void bF(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ae
 * JD-Core Version:    0.7.0.1
 */