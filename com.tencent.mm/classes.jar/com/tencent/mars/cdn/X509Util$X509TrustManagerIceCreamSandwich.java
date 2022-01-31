package com.tencent.mars.cdn;

import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.X509TrustManager;

final class X509Util$X509TrustManagerIceCreamSandwich
  implements X509Util.X509TrustManagerImplementation
{
  private final X509TrustManager mTrustManager;
  
  public X509Util$X509TrustManagerIceCreamSandwich(X509TrustManager paramX509TrustManager)
  {
    this.mTrustManager = paramX509TrustManager;
  }
  
  public final List<X509Certificate> checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
  {
    this.mTrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString1);
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.X509Util.X509TrustManagerIceCreamSandwich
 * JD-Core Version:    0.7.0.1
 */