package com.tencent.mm.plugin.appbrand.jsapi.video.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class k
{
  @Deprecated
  public static boolean a(HttpsURLConnection paramHttpsURLConnection)
  {
    AppMethodBeat.i(194031);
    X509TrustManager local1 = new X509TrustManager()
    {
      public final void checkClientTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(194028);
        h.log(3, "SSLUtil", "checkClientTrusted");
        AppMethodBeat.o(194028);
      }
      
      public final void checkServerTrusted(X509Certificate[] paramAnonymousArrayOfX509Certificate, String paramAnonymousString)
      {
        AppMethodBeat.i(194029);
        if (a.bcR().cxf)
        {
          int i = 0;
          while (i < paramAnonymousArrayOfX509Certificate.length)
          {
            paramAnonymousString = paramAnonymousArrayOfX509Certificate[i];
            h.log(3, "SSLUtil", " Server certificate " + (i + 1) + ":");
            h.log(3, "SSLUtil", "  Subject DN: " + paramAnonymousString.getSubjectX500Principal());
            h.log(3, "SSLUtil", "  Issuer DN: " + paramAnonymousString.getIssuerX500Principal());
            h.log(3, "SSLUtil", "  Signature Algorithm: " + paramAnonymousString.getSigAlgName());
            h.log(3, "SSLUtil", "  Valid from: " + paramAnonymousString.getNotBefore());
            h.log(3, "SSLUtil", "  Valid until: " + paramAnonymousString.getNotAfter());
            h.log(3, "SSLUtil", "  Serial #: " + paramAnonymousString.getSerialNumber().toString(16));
            i += 1;
          }
        }
        AppMethodBeat.o(194029);
      }
      
      public final X509Certificate[] getAcceptedIssuers()
      {
        return null;
      }
    };
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("SSL");
      SecureRandom localSecureRandom = new SecureRandom();
      localSSLContext.init(null, new TrustManager[] { local1 }, localSecureRandom);
      paramHttpsURLConnection.setSSLSocketFactory(localSSLContext.getSocketFactory());
      paramHttpsURLConnection.setHostnameVerifier(new HostnameVerifier()
      {
        public final boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
        {
          AppMethodBeat.i(194030);
          h.log(3, "SSLUtil", "verifying ".concat(String.valueOf(paramAnonymousString)));
          AppMethodBeat.o(194030);
          return true;
        }
      });
      AppMethodBeat.o(194031);
      return true;
    }
    catch (Exception paramHttpsURLConnection)
    {
      h.log(6, "SSLUtil", "disableSSLCertVerify failed ".concat(String.valueOf(paramHttpsURLConnection)));
      AppMethodBeat.o(194031);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.e.k
 * JD-Core Version:    0.7.0.1
 */