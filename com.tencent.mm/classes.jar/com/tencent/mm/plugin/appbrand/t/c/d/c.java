package com.tencent.mm.plugin.appbrand.t.c.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/CertVerifyProcess;", "", "certNetFetcher", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;)V", "attemptVerifyAfterAIAFetch", "", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "chain", "", "Ljava/security/cert/X509Certificate;", "authType", "", "doVerify", "", "", "(Ljavax/net/ssl/X509TrustManager;[Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "findLastCertWithUnknownIssuer", "certs", "startCert", "performAIAFetch", "caIssuerUri", "tryVerifyWithAIAFetching", "Companion", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a tpN;
  public static final boolean tpO;
  private static final j<CertificateFactory> tpP;
  private final com.tencent.mm.plugin.appbrand.t.c.b.c tpf;
  
  static
  {
    AppMethodBeat.i(319217);
    tpN = new c.a((byte)0);
    tpO = com.tencent.mm.plugin.appbrand.t.c.c.a.cCQ();
    tpP = k.cm((kotlin.g.a.a)b.tpQ);
    AppMethodBeat.o(319217);
  }
  
  public c(com.tencent.mm.plugin.appbrand.t.c.b.c paramc)
  {
    AppMethodBeat.i(319195);
    this.tpf = paramc;
    AppMethodBeat.o(319195);
  }
  
  public static X509Certificate a(List<X509Certificate> paramList, X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(319204);
    HashSet localHashSet = new HashSet();
    Object localObject1 = paramX509Certificate;
    localHashSet.add(localObject1);
    paramX509Certificate = paramList.iterator();
    Object localObject2;
    for (;;)
    {
      if (paramX509Certificate.hasNext())
      {
        localObject2 = (X509Certificate)paramX509Certificate.next();
        X500Principal localX500Principal1 = ((X509Certificate)localObject2).getSubjectX500Principal();
        X500Principal localX500Principal2 = ((X509Certificate)localObject1).getIssuerX500Principal();
        if (tpO) {
          Log.d("MicroMsg.Verify.CertVerifyProcess", "findLastCertWithUnknownIssuer, certSubject: " + localX500Principal1 + ", lastCertIssuer: " + localX500Principal2);
        }
        if (s.p(localX500Principal1, localX500Principal2))
        {
          paramX509Certificate = (X509Certificate)localObject2;
          if (tpO) {
            Log.d("MicroMsg.Verify.CertVerifyProcess", "findLastCertWithUnknownIssuer, certSubject is the same as lastCertIssuer");
          }
        }
      }
    }
    for (paramX509Certificate = (X509Certificate)localObject2;; paramX509Certificate = null)
    {
      if (paramX509Certificate == null)
      {
        AppMethodBeat.o(319204);
        return localObject1;
      }
      localObject1 = paramX509Certificate.getSubjectX500Principal();
      localObject2 = paramX509Certificate.getIssuerX500Principal();
      if (tpO) {
        Log.d("MicroMsg.Verify.CertVerifyProcess", "findLastCertWithUnknownIssuer, lastIssuerCertSubject: " + localObject1 + ", lastIssuerCertIssuer: " + localObject2);
      }
      if (s.p(localObject1, localObject2))
      {
        if (tpO) {
          Log.d("MicroMsg.Verify.CertVerifyProcess", "findLastCertWithUnknownIssuer, lastIssuerCertSubject is the same as lastIssuerCertIssuer");
        }
        AppMethodBeat.o(319204);
        return null;
      }
      if (localHashSet.contains(paramX509Certificate))
      {
        AppMethodBeat.o(319204);
        return null;
      }
      localObject1 = paramX509Certificate;
      break;
    }
  }
  
  public static boolean a(X509TrustManager paramX509TrustManager, List<X509Certificate> paramList, String paramString)
  {
    AppMethodBeat.i(319212);
    boolean bool;
    try
    {
      paramList = ((Collection)paramList).toArray(new X509Certificate[0]);
      if (paramList == null)
      {
        paramX509TrustManager = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(319212);
        throw paramX509TrustManager;
      }
    }
    catch (Exception paramX509TrustManager)
    {
      if (tpO) {
        Log.d("MicroMsg.Verify.CertVerifyProcess", s.X("attemptVerifyAfterAIAFetch, verify fail since ", paramX509TrustManager));
      }
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(319212);
      return bool;
      paramX509TrustManager.checkServerTrusted((X509Certificate[])paramList, paramString);
      bool = true;
    }
  }
  
  public final X509Certificate aek(String paramString)
  {
    AppMethodBeat.i(319225);
    if (tpO) {
      Log.d("MicroMsg.Verify.CertVerifyProcess", s.X("performAIAFetch, caIssuerUri: ", paramString));
    }
    CertificateFactory localCertificateFactory = (CertificateFactory)tpP.getValue();
    if (localCertificateFactory == null)
    {
      if (tpO) {
        Log.d("MicroMsg.Verify.CertVerifyProcess", "performAIAFetch, certificateFactory is null");
      }
      AppMethodBeat.o(319225);
      return null;
    }
    for (paramString = this.tpf.aej(paramString);; paramString = (X509Certificate)paramString) {
      try
      {
        paramString = paramString.cCO();
        try
        {
          paramString = localCertificateFactory.generateCertificate((InputStream)new ByteArrayInputStream(paramString));
          if (paramString != null) {
            continue;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
          AppMethodBeat.o(319225);
          throw paramString;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Verify.CertVerifyProcess", (Throwable)paramString, "performAIAFetch, generate certificate fail", new Object[0]);
          paramString = null;
        }
        AppMethodBeat.o(319225);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.Verify.CertVerifyProcess", s.X("performAIAFetch, fetch fail since ", paramString));
        AppMethodBeat.o(319225);
        return null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/security/cert/CertificateFactory;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<CertificateFactory>
  {
    public static final b tpQ;
    
    static
    {
      AppMethodBeat.i(319229);
      tpQ = new b();
      AppMethodBeat.o(319229);
    }
    
    b()
    {
      super();
    }
    
    private static CertificateFactory cCR()
    {
      AppMethodBeat.i(319221);
      try
      {
        CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
        AppMethodBeat.o(319221);
        return localCertificateFactory;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Verify.CertVerifyProcess", (Throwable)localException, "initialize certificateFactory fail", new Object[0]);
          Object localObject = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.d.c
 * JD-Core Version:    0.7.0.1
 */