package com.tencent.mm.plugin.appbrand.s.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/AndroidCheckServerTrustedIssueFixer;", "", "()V", "TAG", "", "certNetFetcher", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "getCertNetFetcher", "()Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "setCertNetFetcher", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;)V", "certVerifyProcess", "Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/CertVerifyProcess;", "getCertVerifyProcess$luggage_commons_release", "()Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/CertVerifyProcess;", "certVerifyProcess$delegate", "Lkotlin/Lazy;", "doFix", "", "urlConnection", "Ljavax/net/ssl/HttpsURLConnection;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/FixedX509TrustManager;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "luggage-commons_release"})
public final class a
{
  private static com.tencent.mm.plugin.appbrand.s.b.b.c qkh;
  static final f qki;
  public static final a qkj;
  
  static
  {
    AppMethodBeat.i(209023);
    qkj = new a();
    qkh = (com.tencent.mm.plugin.appbrand.s.b.b.c)new com.tencent.mm.plugin.appbrand.s.b.b.a();
    qki = g.ar((kotlin.g.a.a)a.qkk);
    AppMethodBeat.o(209023);
  }
  
  public static boolean b(HttpsURLConnection paramHttpsURLConnection)
  {
    b localb = null;
    AppMethodBeat.i(209018);
    p.k(paramHttpsURLConnection, "urlConnection");
    for (;;)
    {
      try
      {
        localObject = b.qkn;
        localObject = b.ccg();
        b.a locala = b.qkn;
        localObject = (X509TrustManager)((f)localObject).getValue();
        Log.i("MicroMsg.FixedX509TrustManager", "create, realX509TrustManager: ".concat(String.valueOf(localObject)));
        if (localObject != null) {
          continue;
        }
        if (localb == null) {
          continue;
        }
        localObject = SSLContext.getInstance("SSL");
        ((SSLContext)localObject).init(null, (TrustManager[])new b[] { localb }, new SecureRandom());
        p.j(localObject, "sslContext");
        paramHttpsURLConnection.setSSLSocketFactory(((SSLContext)localObject).getSocketFactory());
        bool = true;
      }
      catch (Exception paramHttpsURLConnection)
      {
        Object localObject;
        Log.printErrStackTrace("MicroMsg.AndroidCheckServerTrustedIssueFixer", (Throwable)paramHttpsURLConnection, "doFix for HttpsURLConnection, fix fail", new Object[0]);
        boolean bool = false;
        continue;
        bool = false;
        continue;
      }
      AppMethodBeat.o(209018);
      return bool;
      localb = new b((X509TrustManager)localObject, (byte)0);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.s.b.b.c ccf()
  {
    return qkh;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/CertVerifyProcess;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.s.b.d.c>
  {
    public static final a qkk;
    
    static
    {
      AppMethodBeat.i(210482);
      qkk = new a();
      AppMethodBeat.o(210482);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.a
 * JD-Core Version:    0.7.0.1
 */