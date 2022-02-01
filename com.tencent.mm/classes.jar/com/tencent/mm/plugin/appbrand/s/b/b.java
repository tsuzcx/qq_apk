package com.tencent.mm.plugin.appbrand.s.b;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.b.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.security.KeyStoreException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.a.e;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/FixedX509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "realX509TrustManager", "(Ljavax/net/ssl/X509TrustManager;)V", "checkClientTrusted", "", "p0", "", "Ljava/security/cert/X509Certificate;", "kotlin.jvm.PlatformType", "p1", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "chain", "authType", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "Companion", "luggage-commons_release"})
@SuppressLint({"TrustAllX509TrustManager"})
public final class b
  implements X509TrustManager
{
  private static final f qkm;
  public static final a qkn;
  private final X509TrustManager qkl;
  
  static
  {
    AppMethodBeat.i(209872);
    qkn = new a((byte)0);
    qkm = g.ar((kotlin.g.a.a)b.qko);
    AppMethodBeat.o(209872);
  }
  
  private b(X509TrustManager paramX509TrustManager)
  {
    this.qkl = paramX509TrustManager;
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    AppMethodBeat.i(209873);
    this.qkl.checkClientTrusted(paramArrayOfX509Certificate, paramString);
    AppMethodBeat.o(209873);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    AppMethodBeat.i(209871);
    Object localObject1 = a.qkj;
    c localc = (c)a.qki.getValue();
    X509TrustManager localX509TrustManager = this.qkl;
    p.k(localX509TrustManager, "trustManager");
    try
    {
      localX509TrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      AppMethodBeat.o(209871);
      return;
    }
    catch (CertificateException localCertificateException)
    {
      if (c.qkQ) {
        Log.d("MicroMsg.Verify.CertVerifyProcess", "doVerify, verify fail since ".concat(String.valueOf(localCertificateException)));
      }
      if (paramArrayOfX509Certificate == null)
      {
        paramArrayOfX509Certificate = (Throwable)localCertificateException;
        AppMethodBeat.o(209871);
        throw paramArrayOfX509Certificate;
      }
    }
    int i;
    for (;;)
    {
      try
      {
        localList = e.ab(paramArrayOfX509Certificate);
        if (c.qkQ) {
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
        if (!c.qkQ) {
          continue;
        }
        Log.printErrStackTrace("MicroMsg.Verify.CertVerifyProcess", (Throwable)paramArrayOfX509Certificate, "tryVerifyWithAIAFetching, verify fail", new Object[0]);
        i = 0;
        continue;
        AppMethodBeat.o(209871);
        return;
      }
      if (i != 0) {
        continue;
      }
      paramArrayOfX509Certificate = (Throwable)localCertificateException;
      AppMethodBeat.o(209871);
      throw paramArrayOfX509Certificate;
      paramArrayOfX509Certificate = c.a(localList, (X509Certificate)localList.get(0));
      if (paramArrayOfX509Certificate != null) {
        break label407;
      }
      Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, lastCertWithUnknownIssuer is null");
      i = 0;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.appbrand.s.b.d.b.a(paramArrayOfX509Certificate);
      if (localObject1 == null)
      {
        Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, aiaInfo is null");
        i = 0;
        break;
      }
      if (((com.tencent.mm.plugin.appbrand.s.b.d.a)localObject1).qkO.isEmpty())
      {
        Log.i("MicroMsg.Verify.CertVerifyProcess", "tryVerifyWithAIAFetching, caIssuersUris is empty");
        i = 0;
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.appbrand.s.b.d.a)localObject1).qkO.iterator();
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
          localObject2 = localc.ald((String)localObject2);
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
        boolean bool = p.h(localObject1, paramArrayOfX509Certificate);
        if (!bool) {}
      }
      else
      {
        i = 0;
        break;
      }
      paramArrayOfX509Certificate = (X509Certificate[])localObject1;
      continue;
      label407:
      i = 0;
    }
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    AppMethodBeat.i(209874);
    X509Certificate[] arrayOfX509Certificate = this.qkl.getAcceptedIssuers();
    AppMethodBeat.o(209874);
    return arrayOfX509Certificate;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/network/workaround/FixedX509TrustManager$Companion;", "", "()V", "TAG", "", "defaultX509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "getDefaultX509TrustManager", "()Ljavax/net/ssl/X509TrustManager;", "defaultX509TrustManager$delegate", "Lkotlin/Lazy;", "create", "Lcom/tencent/mm/plugin/appbrand/network/workaround/FixedX509TrustManager;", "realX509TrustManager", "provideDefaultX509TrustManager", "luggage-commons_release"})
  public static final class a
  {
    static X509TrustManager cch()
    {
      AppMethodBeat.i(208747);
      Object localObject = TrustManagerFactory.getDefaultAlgorithm();
      p.j(localObject, "TrustManagerFactory.getDefaultAlgorithm()");
      localObject = TrustManagerFactory.getInstance((String)localObject);
      p.j(localObject, "TrustManagerFactory.getInstance(algorithm)");
      ((TrustManagerFactory)localObject).init(null);
      for (;;)
      {
        try
        {
          localObject = ((TrustManagerFactory)localObject).getTrustManagers();
          int j = localObject.length;
          int i = 0;
          if (i >= j) {
            break;
          }
          String str = localObject[i];
          if ((str instanceof X509TrustManager)) {}
          X509TrustManager localX509TrustManager;
          Throwable localThrowable;
          i += 1;
        }
        catch (RuntimeException localRuntimeException)
        {
          try
          {
            localX509TrustManager = (X509TrustManager)str;
            AppMethodBeat.o(208747);
            return localX509TrustManager;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            str = str.getClass().getName();
            p.j(str, "tm::class.java.name");
            Log.e("MicroMsg.FixedX509TrustManager", "Error creating trust manager (" + str + "): " + localIllegalArgumentException);
          }
          localRuntimeException = localRuntimeException;
          Log.e("MicroMsg.FixedX509TrustManager", "TrustManagerFactory.getTrustManagers() unexpectedly threw: ".concat(String.valueOf(localRuntimeException)));
          localThrowable = (Throwable)new KeyStoreException((Throwable)localRuntimeException);
          AppMethodBeat.o(208747);
          throw localThrowable;
        }
      }
      Log.e("MicroMsg.FixedX509TrustManager", "Could not find suitable trust manager");
      AppMethodBeat.o(208747);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljavax/net/ssl/X509TrustManager;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<X509TrustManager>
  {
    public static final b qko;
    
    static
    {
      AppMethodBeat.i(208240);
      qko = new b();
      AppMethodBeat.o(208240);
    }
    
    b()
    {
      super();
    }
    
    private static X509TrustManager cci()
    {
      AppMethodBeat.i(208232);
      try
      {
        Object localObject1 = b.qkn;
        localObject1 = b.a.cch();
        AppMethodBeat.o(208232);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.b.b
 * JD-Core Version:    0.7.0.1
 */