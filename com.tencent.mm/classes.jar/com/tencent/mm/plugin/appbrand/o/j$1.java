package com.tencent.mm.plugin.appbrand.o;

import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class j$1
  implements HostnameVerifier
{
  j$1(HostnameVerifier paramHostnameVerifier, ArrayList paramArrayList) {}
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return (this.gRu.verify(paramString, paramSSLSession)) || (j.d(this.gRv, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.j.1
 * JD-Core Version:    0.7.0.1
 */