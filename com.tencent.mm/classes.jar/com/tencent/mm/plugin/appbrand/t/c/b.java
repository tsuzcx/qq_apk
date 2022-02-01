package com.tencent.mm.plugin.appbrand.t.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.c.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/FixedX509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "realX509TrustManager", "(Ljavax/net/ssl/X509TrustManager;)V", "checkClientTrusted", "", "p0", "", "Ljava/security/cert/X509Certificate;", "kotlin.jvm.PlatformType", "p1", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "chain", "authType", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "Companion", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements X509TrustManager
{
  public static final a tpi;
  private static final j<X509TrustManager> tpk;
  private final X509TrustManager tpj;
  
  static
  {
    AppMethodBeat.i(319202);
    tpi = new a((byte)0);
    tpk = kotlin.k.cm((kotlin.g.a.a)b.tpl);
    AppMethodBeat.o(319202);
  }
  
  private b(X509TrustManager paramX509TrustManager)
  {
    this.tpj = paramX509TrustManager;
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    AppMethodBeat.i(319207);
    this.tpj.checkClientTrusted(paramArrayOfX509Certificate, paramString);
    AppMethodBeat.o(319207);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    AppMethodBeat.i(319223);
    Object localObject1 = a.tpe;
    c localc = a.cCB();
    X509TrustManager localX509TrustManager = this.tpj;
    s.u(localX509TrustManager, "trustManager");
    try
    {
      localX509TrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      AppMethodBeat.o(319223);
      return;
    }
    catch (CertificateException localCertificateException)
    {
      if (c.tpO) {
        Log.d("MicroMsg.Verify.CertVerifyProcess", s.X("doVerify, verify fail since ", localCertificateException));
      }
      if (paramArrayOfX509Certificate == null)
      {
        AppMethodBeat.o(319223);
        throw localCertificateException;
      }
    }
    int i;
    for (;;)
    {
      try
      {
        localList = kotlin.a.k.af(paramArrayOfX509Certificate);
        if (c.tpO) {
          Log.d("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching");
        }
        if (!localList.isEmpty()) {
          continue;
        }
        Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, chain is empty");
        i = 0;
      }
      catch (Exception paramArrayOfX509Certificate)
      {
        List localList;
        if (!c.tpO) {
          continue;
        }
        Log.printErrStackTrace("MicroMsg.Verify.CertVerifyProcess", (Throwable)paramArrayOfX509Certificate, "tryVerifyWithAIAFetching, verify fail", new Object[0]);
        i = 0;
        continue;
        AppMethodBeat.o(319223);
        return;
      }
      if (i != 0) {
        continue;
      }
      AppMethodBeat.o(319223);
      throw localCertificateException;
      paramArrayOfX509Certificate = c.a(localList, (X509Certificate)localList.get(0));
      if (paramArrayOfX509Certificate != null) {
        break label386;
      }
      Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, lastCertWithUnknownIssuer is null");
      i = 0;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.t.c.d.b.a(paramArrayOfX509Certificate);
      if (localObject1 == null)
      {
        Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, aiaInfo is null");
        i = 0;
        break;
      }
      if (((com.tencent.mm.plugin.appbrand.t.c.d.a)localObject1).tpL.isEmpty())
      {
        Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, caIssuersUris is empty");
        i = 0;
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.appbrand.t.c.d.a)localObject1).tpL.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (String)((Iterator)localObject1).next();
          int j = i + 1;
          if (5 < j)
          {
            Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, reach max fetch num");
            i = 0;
            break;
          }
          localObject2 = localc.aek((String)localObject2);
          i = j;
          if (localObject2 != null)
          {
            localList.add(localObject2);
            i = j;
            if (c.a(localX509TrustManager, localList, paramString))
            {
              Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, verify success");
              i = 1;
              break;
            }
          }
        }
      }
      localObject1 = c.a(localList, paramArrayOfX509Certificate);
      if (localObject1 != null)
      {
        boolean bool = s.p(localObject1, paramArrayOfX509Certificate);
        if (!bool) {}
      }
      else
      {
        i = 0;
        break;
      }
      paramArrayOfX509Certificate = (X509Certificate[])localObject1;
      continue;
      label386:
      i = 0;
    }
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    AppMethodBeat.i(319213);
    X509Certificate[] arrayOfX509Certificate = this.tpj.getAcceptedIssuers();
    AppMethodBeat.o(319213);
    return arrayOfX509Certificate;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/network/workaround/FixedX509TrustManager$Companion;", "", "()V", "TAG", "", "defaultX509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "getDefaultX509TrustManager", "()Ljavax/net/ssl/X509TrustManager;", "defaultX509TrustManager$delegate", "Lkotlin/Lazy;", "create", "Lcom/tencent/mm/plugin/appbrand/network/workaround/FixedX509TrustManager;", "realX509TrustManager", "provideDefaultX509TrustManager", "luggage-commons_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static X509TrustManager cCD()
    {
      AppMethodBeat.i(319179);
      Object localObject = TrustManagerFactory.getDefaultAlgorithm();
      s.s(localObject, "getDefaultAlgorithm()");
      localObject = TrustManagerFactory.getInstance((String)localObject);
      s.s(localObject, "getInstance(algorithm)");
      ((TrustManagerFactory)localObject).init(null);
      label176:
      for (;;)
      {
        try
        {
          localObject = ((TrustManagerFactory)localObject).getTrustManagers();
          s.s(localObject, "trustManagers");
          int i = 0;
          int j = localObject.length;
          if (i < j)
          {
            String str = localObject[i];
            i += 1;
            if (!(str instanceof X509TrustManager)) {
              break label176;
            }
            X509TrustManager localX509TrustManager;
            KeyStoreException localKeyStoreException;
            continue;
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          try
          {
            localX509TrustManager = (X509TrustManager)str;
            AppMethodBeat.o(319179);
            return localX509TrustManager;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            str = str.getClass().getName();
            s.s(str, "tm::class.java.name");
            Log.e("MicroMsg.FixedX509TrustManager", "Error creating trust manager (" + str + "): " + localIllegalArgumentException);
          }
          localRuntimeException = localRuntimeException;
          Log.e("MicroMsg.FixedX509TrustManager", s.X("TrustManagerFactory.getTrustManagers() unexpectedly threw: ", localRuntimeException));
          localKeyStoreException = new KeyStoreException((Throwable)localRuntimeException);
          AppMethodBeat.o(319179);
          throw localKeyStoreException;
        }
        Log.e("MicroMsg.FixedX509TrustManager", "Could not find suitable trust manager");
        AppMethodBeat.o(319179);
        return null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljavax/net/ssl/X509TrustManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<X509TrustManager>
  {
    public static final b tpl;
    
    static
    {
      AppMethodBeat.i(319178);
      tpl = new b();
      AppMethodBeat.o(319178);
    }
    
    b()
    {
      super();
    }
    
    private static X509TrustManager cCE()
    {
      AppMethodBeat.i(319175);
      try
      {
        Object localObject1 = b.tpi;
        localObject1 = b.a.cCD();
        AppMethodBeat.o(319175);
        return localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FixedX509TrustManager", (Throwable)localException, "provideDefaultX509TrustManager fail", new Object[0]);
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.c.b
 * JD-Core Version:    0.7.0.1
 */