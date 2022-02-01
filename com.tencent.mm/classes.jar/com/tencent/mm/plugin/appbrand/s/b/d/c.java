package com.tencent.mm.plugin.appbrand.s.b.d;

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
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/verify/CertVerifyProcess;", "", "certNetFetcher", "Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;", "(Lcom/tencent/mm/plugin/appbrand/network/workaround/fetch/ICertNetFetcher;)V", "attemptVerifyAfterAIAFetch", "", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "chain", "", "Ljava/security/cert/X509Certificate;", "authType", "", "doVerify", "", "", "(Ljavax/net/ssl/X509TrustManager;[Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "findLastCertWithUnknownIssuer", "certs", "startCert", "performAIAFetch", "caIssuerUri", "tryVerifyWithAIAFetching", "Companion", "luggage-commons_release"})
public final class c
{
  public static final boolean qkQ;
  private static final f qkR;
  public static final c.a qkS;
  private final com.tencent.mm.plugin.appbrand.s.b.b.c qkh;
  
  static
  {
    AppMethodBeat.i(207669);
    qkS = new c.a((byte)0);
    qkQ = com.tencent.mm.plugin.appbrand.s.b.c.a.ccu();
    qkR = g.ar((kotlin.g.a.a)b.qkT);
    AppMethodBeat.o(207669);
  }
  
  public c(com.tencent.mm.plugin.appbrand.s.b.b.c paramc)
  {
    AppMethodBeat.i(207665);
    this.qkh = paramc;
    AppMethodBeat.o(207665);
  }
  
  public static X509Certificate a(List<X509Certificate> paramList, X509Certificate paramX509Certificate)
  {
    AppMethodBeat.i(207656);
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
        if (qkQ) {
          Log.d("MicroMsg.Verify.CertVerifyProcess", "findLastCertWithUnknownIssuer, certSubject: " + localX500Principal1 + ", lastCertIssuer: " + localX500Principal2);
        }
        if (p.h(localX500Principal1, localX500Principal2))
        {
          paramX509Certificate = (X509Certificate)localObject2;
          if (qkQ) {
            Log.d("MicroMsg.Verify.CertVerifyProcess", "findLastCertWithUnknownIssuer, certSubject is the same as lastCertIssuer");
          }
        }
      }
    }
    for (paramX509Certificate = (X509Certificate)localObject2;; paramX509Certificate = null)
    {
      if (paramX509Certificate == null)
      {
        AppMethodBeat.o(207656);
        return localObject1;
      }
      localObject1 = paramX509Certificate.getSubjectX500Principal();
      localObject2 = paramX509Certificate.getIssuerX500Principal();
      if (qkQ) {
        Log.d("MicroMsg.Verify.CertVerifyProcess", "findLastCertWithUnknownIssuer, lastIssuerCertSubject: " + localObject1 + ", lastIssuerCertIssuer: " + localObject2);
      }
      if (p.h(localObject1, localObject2))
      {
        if (qkQ) {
          Log.d("MicroMsg.Verify.CertVerifyProcess", "findLastCertWithUnknownIssuer, lastIssuerCertSubject is the same as lastIssuerCertIssuer");
        }
        AppMethodBeat.o(207656);
        return null;
      }
      if (localHashSet.contains(paramX509Certificate))
      {
        AppMethodBeat.o(207656);
        return null;
      }
      localObject1 = paramX509Certificate;
      break;
    }
  }
  
  public static boolean a(X509TrustManager paramX509TrustManager, List<X509Certificate> paramList, String paramString)
  {
    AppMethodBeat.i(207663);
    boolean bool;
    try
    {
      paramList = ((Collection)paramList).toArray(new X509Certificate[0]);
      if (paramList == null)
      {
        paramX509TrustManager = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(207663);
        throw paramX509TrustManager;
      }
    }
    catch (Exception paramX509TrustManager)
    {
      if (qkQ) {
        Log.d("MicroMsg.Verify.CertVerifyProcess", "attemptVerifyAfterAIAFetch, verify fail since ".concat(String.valueOf(paramX509TrustManager)));
      }
      bool = false;
    }
    for (;;)
    {
      AppMethodBeat.o(207663);
      return bool;
      paramX509TrustManager.checkServerTrusted((X509Certificate[])paramList, paramString);
      bool = true;
    }
  }
  
  public final X509Certificate ald(String paramString)
  {
    AppMethodBeat.i(207659);
    if (qkQ) {
      Log.d("MicroMsg.Verify.CertVerifyProcess", "performAIAFetch, caIssuerUri: ".concat(String.valueOf(paramString)));
    }
    CertificateFactory localCertificateFactory = (CertificateFactory)qkR.getValue();
    if (localCertificateFactory == null)
    {
      if (qkQ) {
        Log.d("MicroMsg.Verify.CertVerifyProcess", "performAIAFetch, certificateFactory is null");
      }
      AppMethodBeat.o(207659);
      return null;
    }
    for (paramString = this.qkh.alc(paramString);; paramString = (X509Certificate)paramString) {
      try
      {
        paramString = paramString.ccs();
        try
        {
          paramString = localCertificateFactory.generateCertificate((InputStream)new ByteArrayInputStream(paramString));
          if (paramString != null) {
            continue;
          }
          paramString = new t("null cannot be cast to non-null type java.security.cert.X509Certificate");
          AppMethodBeat.o(207659);
          throw paramString;
        }
        catch (Exception paramString)
        {
          Log.printErrStackTrace("MicroMsg.Verify.CertVerifyProcess", (Throwable)paramString, "performAIAFetch, generate certificate fail", new Object[0]);
          paramString = null;
        }
        AppMethodBeat.o(207659);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.w("MicroMsg.Verify.CertVerifyProcess", "performAIAFetch, fetch fail since ".concat(String.valueOf(paramString)));
        AppMethodBeat.o(207659);
        return null;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/security/cert/CertificateFactory;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<CertificateFactory>
  {
    public static final b qkT;
    
    static
    {
      AppMethodBeat.i(208424);
      qkT = new b();
      AppMethodBeat.o(208424);
    }
    
    b()
    {
      super();
    }
    
    private static CertificateFactory ccv()
    {
      AppMethodBeat.i(208423);
      try
      {
        CertificateFactory localCertificateFactory = CertificateFactory.getInstance("X.509");
        AppMethodBeat.o(208423);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.d.c
 * JD-Core Version:    0.7.0.1
 */