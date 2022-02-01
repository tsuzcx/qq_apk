package com.tencent.mm.plugin.appbrand.t.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/AndroidCheckServerTrustedIssueFixer;", "", "()V", "TAG", "", "certNetFetcher", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "getCertNetFetcher", "()Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "setCertNetFetcher", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;)V", "certVerifyProcess", "Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/CertVerifyProcess;", "getCertVerifyProcess$luggage_commons_release", "()Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/CertVerifyProcess;", "certVerifyProcess$delegate", "Lkotlin/Lazy;", "doFix", "", "urlConnection", "Ljavax/net/ssl/HttpsURLConnection;", "Lcom/tencent/mm/plugin/appbrand/network/workaround/FixedX509TrustManager;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a tpe;
  private static com.tencent.mm.plugin.appbrand.t.c.b.c tpf;
  private static final j tpg;
  
  static
  {
    AppMethodBeat.i(319208);
    tpe = new a();
    tpf = (com.tencent.mm.plugin.appbrand.t.c.b.c)new com.tencent.mm.plugin.appbrand.t.c.b.a();
    tpg = k.cm((kotlin.g.a.a)a.tph);
    AppMethodBeat.o(319208);
  }
  
  public static boolean b(HttpsURLConnection paramHttpsURLConnection)
  {
    b localb = null;
    AppMethodBeat.i(319203);
    s.u(paramHttpsURLConnection, "urlConnection");
    for (;;)
    {
      try
      {
        localObject = b.tpi;
        localObject = (X509TrustManager)b.cCC().getValue();
        Log.i("MicroMsg.FixedX509TrustManager", s.X("create, realX509TrustManager: ", localObject));
        if (localObject != null) {
          continue;
        }
        if (localb == null) {
          continue;
        }
        localObject = SSLContext.getInstance("SSL");
        ((SSLContext)localObject).init(null, (TrustManager[])new b[] { localb }, new SecureRandom());
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
      AppMethodBeat.o(319203);
      return bool;
      localb = new b((X509TrustManager)localObject, (byte)0);
    }
  }
  
  public static com.tencent.mm.plugin.appbrand.t.c.b.c cCA()
  {
    return tpf;
  }
  
  public static com.tencent.mm.plugin.appbrand.t.c.d.c cCB()
  {
    AppMethodBeat.i(319192);
    com.tencent.mm.plugin.appbrand.t.c.d.c localc = (com.tencent.mm.plugin.appbrand.t.c.d.c)tpg.getValue();
    AppMethodBeat.o(319192);
    return localc;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/CertVerifyProcess;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.appbrand.t.c.d.c>
  {
    public static final a tph;
    
    static
    {
      AppMethodBeat.i(319189);
      tph = new a();
      AppMethodBeat.o(319189);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.a
 * JD-Core Version:    0.7.0.1
 */