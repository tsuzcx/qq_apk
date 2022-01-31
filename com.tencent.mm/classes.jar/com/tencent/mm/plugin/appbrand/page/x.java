package com.tencent.mm.plugin.appbrand.page;

import android.net.http.SslCertificate;
import android.net.http.SslCertificate.DName;
import android.os.Build.VERSION;
import android.webkit.WebResourceResponse;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o.j;
import com.tencent.mm.plugin.appbrand.o.m;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class x
  implements ag
{
  private q gSP;
  private m gVi;
  
  public x(q paramq)
  {
    this.gSP = paramq;
  }
  
  public final boolean a(SslCertificate paramSslCertificate)
  {
    if (this.gSP.getRuntime() == null) {
      return false;
    }
    if (this.gVi == null) {
      this.gVi = j.b((com.tencent.mm.plugin.appbrand.o.a)this.gSP.getRuntime().c(com.tencent.mm.plugin.appbrand.o.a.class, true));
    }
    Object localObject = paramSslCertificate.getIssuedTo().getDName();
    y.d("AppBrandWebViewClient", "subjectDN: " + (String)localObject);
    for (;;)
    {
      try
      {
        localObject = paramSslCertificate.getClass().getDeclaredField("mX509Certificate");
        ((Field)localObject).setAccessible(true);
        paramSslCertificate = (X509Certificate)((Field)localObject).get(paramSslCertificate);
      }
      catch (Exception paramSslCertificate)
      {
        y.e("AppBrandWebViewClient", "Certificate check failed: ", new Object[] { paramSslCertificate });
        boolean bool = false;
        continue;
      }
      try
      {
        this.gVi.checkServerTrusted(new X509Certificate[] { paramSslCertificate }, "generic");
        bool = true;
      }
      catch (Exception paramSslCertificate)
      {
        y.e("AppBrandWebViewClient", "Certificate check failed: " + paramSslCertificate);
        bool = false;
      }
    }
    return bool;
  }
  
  public final void anD()
  {
    q localq = this.gSP;
    localq.gTI = true;
    synchronized (localq.gTX)
    {
      Iterator localIterator = localq.gTX.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    localObject.gTX.clear();
  }
  
  public final WebResourceResponse vO(String paramString)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = localObject3;
    if (this.gSP.getRuntime() != null)
    {
      localObject2 = localObject3;
      if (this.gSP.getRuntime().dNk)
      {
        if (!this.gSP.getRuntime().mFinished) {
          break label52;
        }
        localObject2 = localObject3;
      }
    }
    return localObject2;
    label52:
    if (paramString.startsWith(this.gSP.ang()))
    {
      localObject2 = aq.c(this.gSP.getRuntime(), paramString.replaceFirst(this.gSP.ang(), ""));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        y.e("AppBrandWebViewClient", "getAppResourceResponse %s not found", new Object[] { paramString });
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
      if (paramString.startsWith("http"))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          break;
        }
      }
      y.i("AppBrandWebViewClient", "tryInterceptWebViewRequest, reqURL = %s", new Object[] { paramString });
      return localObject1;
      localObject2 = new com.tencent.mm.plugin.appbrand.u.k();
      this.gSP.getRuntime().Zl().b(paramString, (com.tencent.mm.plugin.appbrand.u.k)localObject2);
      if (((com.tencent.mm.plugin.appbrand.u.k)localObject2).value != null) {
        localObject1 = new WebResourceResponse("", "", new com.tencent.luggage.j.a((ByteBuffer)((com.tencent.mm.plugin.appbrand.u.k)localObject2).value));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.x
 * JD-Core Version:    0.7.0.1
 */