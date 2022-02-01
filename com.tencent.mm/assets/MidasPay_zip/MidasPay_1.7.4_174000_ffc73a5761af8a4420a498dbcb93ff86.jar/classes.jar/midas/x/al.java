package midas.x;

import android.util.Patterns;
import com.pay.tool.APAppDataInterface;
import com.tencent.midas.comm.APLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStore.Entry;
import java.security.KeyStore.TrustedCertificateEntry;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class al
{
  public static void a(HttpsURLConnection paramHttpsURLConnection, String paramString)
  {
    try
    {
      paramHttpsURLConnection = SSLContext.getInstance("TLS");
      if (Patterns.IP_ADDRESS.matcher(paramString).matches())
      {
        APLog.i("APHttpsReqPost", "ssl check init");
        paramString = new a();
        SecureRandom localSecureRandom = new SecureRandom();
        paramHttpsURLConnection.init(null, new TrustManager[] { paramString }, localSecureRandom);
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier()
        {
          public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
          {
            return true;
          }
        });
      }
      else
      {
        APLog.i("APHttpsReqPost", "ssl system check init");
        paramHttpsURLConnection.init(null, null, new SecureRandom());
      }
      HttpsURLConnection.setDefaultSSLSocketFactory(paramHttpsURLConnection.getSocketFactory());
      return;
    }
    catch (Exception paramHttpsURLConnection)
    {
      paramHttpsURLConnection.printStackTrace();
    }
  }
  
  public static class a
    implements X509TrustManager
  {
    private X509TrustManager a;
    
    a()
    {
      for (;;)
      {
        try
        {
          if (APAppDataInterface.singleton().e().equals("testing"))
          {
            Object localObject1 = "-----BEGIN CERTIFICATE-----\nMIIB+zCCAWQCCQDnbabaPRGSojANBgkqhkiG9w0BAQUFADBCMQswCQYDVQQGEwJY\nWDEVMBMGA1UEBwwMRGVmYXVsdCBDaXR5MRwwGgYDVQQKDBNEZWZhdWx0IENvbXBh\nbnkgTHRkMB4XDTE3MDYxMjA0NTgxM1oXDTE4MDYxMjA0NTgxM1owQjELMAkGA1UE\nBhMCWFgxFTATBgNVBAcMDERlZmF1bHQgQ2l0eTEcMBoGA1UECgwTRGVmYXVsdCBD\nb21wYW55IEx0ZDCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAtPIG5lntvILM\nKq5DGq6WelrdovgxgwmncBgCsvI/iSzpBrOIXOh/ut+d+/pSUYAN0AadZp2tdb3F\nNS4AZbRhKjBWOuJv+Oj2KpjCW98iymoBbW8CHRHYbdTY/cpbkxPLN7v4bBNA8K2T\nKeRSp+NMHoR3POKos6iiUtVdQw2LP1kCAwEAATANBgkqhkiG9w0BAQUFAAOBgQBt\n03Qe2CVPZqgAAixUw/K3eY1Su7MAsJpgNKH5L9lQ7F6Fop9D3MQ9ku6OGQSRzhZ9\nI85Sw6jnBgmze2vBC5z+OKDgVvCW3AsRdK1YAcNKwxrTjFOw4drtLhk/avv7Gj/8\nS2b6fi3l9JumOBWy3YHaTRzkhE9ejtczdmHjzXLnhQ==\n-----END CERTIFICATE-----\n";
            Object localObject2 = CertificateFactory.getInstance("X.509");
            localObject1 = new ByteArrayInputStream(((String)localObject1).getBytes());
            localObject2 = (X509Certificate)((CertificateFactory)localObject2).generateCertificate((InputStream)localObject1);
            ((InputStream)localObject1).close();
            localObject2 = new KeyStore.TrustedCertificateEntry((Certificate)localObject2);
            localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
            ((KeyStore)localObject1).load(null, null);
            ((KeyStore)localObject1).setEntry("ca_root", (KeyStore.Entry)localObject2, null);
            localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            ((TrustManagerFactory)localObject2).init((KeyStore)localObject1);
            localObject1 = ((TrustManagerFactory)localObject2).getTrustManagers();
            int i = 0;
            if (i < localObject1.length)
            {
              if ((localObject1[i] instanceof X509TrustManager))
              {
                this.a = ((X509TrustManager)localObject1[i]);
                return;
              }
              i += 1;
              continue;
            }
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        String str = "-----BEGIN CERTIFICATE-----\nMIIEDzCCAvegAwIBAgIJAJhHK18zh2o5MA0GCSqGSIb3DQEBBQUAMGIxCzAJBgNV\nBAYTAkNOMRIwEAYDVQQIEwlHdWFuZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUw\nEwYDVQQKEwxDUGF5IFJvb3QgQ0ExFTATBgNVBAsTDENQYXkgUm9vdCBDQTAeFw0x\nMzEwMzEwNzE1NDVaFw0yMzEwMjkwNzE1NDVaMGIxCzAJBgNVBAYTAkNOMRIwEAYD\nVQQIEwlHdWFuZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUwEwYDVQQKEwxDUGF5\nIFJvb3QgQ0ExFTATBgNVBAsTDENQYXkgUm9vdCBDQTCCASIwDQYJKoZIhvcNAQEB\nBQADggEPADCCAQoCggEBALKfVOTFtDzHXOl78oi+R1MvJ80GFN/i71zbxpZnLEdz\ny4KIyotmnmt1av8ONC17bYrmHCimwyiMTonme5gBNm83XWPxByAccQbqeBowx+7a\nXUojJQwdykDE1AafiZWdtmI2vq9HGXtmZJWatxda/G3vo1lUpqQeB1juvNVb1flq\n2IZFxGihmV8EDhtTt3gGlaLwmBsI40Et+vJX/XXrd158qF6wmhzztI+obmYEqjJT\nNxor/fOMWXSIZOtvLdAA1fbrH1cMon62v2v2Sx/69KCrV9CgmK3dYJiUaAiv3SYP\n4CB+r8odiulK42QPnVxFbPR0ID8al+fewDomREqt6RkCAwEAAaOBxzCBxDAdBgNV\nHQ4EFgQUFb1Jpcd4xDZYyNLV2D3iV44X9SMwgZQGA1UdIwSBjDCBiYAUFb1Jpcd4\nxDZYyNLV2D3iV44X9SOhZqRkMGIxCzAJBgNVBAYTAkNOMRIwEAYDVQQIEwlHdWFu\nZ2RvbmcxETAPBgNVBAcTCFNoZW56aGVuMRUwEwYDVQQKEwxDUGF5IFJvb3QgQ0Ex\nFTATBgNVBAsTDENQYXkgUm9vdCBDQYIJAJhHK18zh2o5MAwGA1UdEwQFMAMBAf8w\nDQYJKoZIhvcNAQEFBQADggEBAC+WGUZTncBGxgcEfWt3MFOuL1ht3hF03WFx+6wt\n9TyEySEPRrH/g+jNUL9wsdVFztzHcY3iFmtVHqAioGXwz+Kjd7E0iCV1ijNusMv6\nN2MQsZ70JC2mbMewcwK6c2eCGABMD6hV8crTVGe7OIvz4M7mk1hevly0SlxS7Lfc\nF3i2504uOQp9bVpzQMZ++6m7s7KTysostxMsQbuPLN2xTSx+SEzVZQN/oqemSh2F\nJpODYHOnU5wDf5b7UFcZ7jL4FSJWrIfcxlHVZse/kX7e38a9odrFHxmaNhsBWYn0\nLqZpfR9qWZSjihLXz0lPTnB4ZJNVAsP0DfI/veTyoSBkX2g=\n-----END CERTIFICATE-----\n";
      }
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      APLog.i("APBaseHttpReq", "checkServerTrusted");
      this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return this.a.getAcceptedIssuers();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.al
 * JD-Core Version:    0.7.0.1
 */