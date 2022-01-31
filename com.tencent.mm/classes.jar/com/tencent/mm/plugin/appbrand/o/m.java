package com.tencent.mm.plugin.appbrand.o;

import com.tencent.mm.sdk.platformtools.y;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class m
  implements X509TrustManager
{
  private LinkedList<X509TrustManager> gRD = new LinkedList();
  private LinkedList<X509TrustManager> gRE = new LinkedList();
  KeyStore gRF;
  private X509Certificate[] gRG;
  
  public m()
  {
    try
    {
      this.gRF = KeyStore.getInstance(KeyStore.getDefaultType());
      this.gRF.load(null, null);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrandX509TrustManager", "Local KeyStore init failed");
    }
  }
  
  private void amM()
  {
    if (this.gRF == null) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        ((TrustManagerFactory)localObject).init(this.gRF);
        localObject = ((TrustManagerFactory)localObject).getTrustManagers();
        int i = 0;
        while ((localObject != null) && (i < localObject.length))
        {
          this.gRE.add((X509TrustManager)localObject[i]);
          i += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrandX509TrustManager", "initLocalTrustManager: " + localException);
      }
    }
  }
  
  private void amN()
  {
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.gRD.iterator();
    X509Certificate[] arrayOfX509Certificate;
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate = ((X509TrustManager)localIterator.next()).getAcceptedIssuers();
      if (arrayOfX509Certificate != null) {
        localArrayList.addAll(Arrays.asList(arrayOfX509Certificate));
      }
    }
    long l2 = System.currentTimeMillis();
    localIterator = this.gRE.iterator();
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate = ((X509TrustManager)localIterator.next()).getAcceptedIssuers();
      if (arrayOfX509Certificate != null) {
        localArrayList.addAll(Arrays.asList(arrayOfX509Certificate));
      }
    }
    long l3 = System.currentTimeMillis();
    this.gRG = new X509Certificate[localArrayList.size()];
    this.gRG = ((X509Certificate[])localArrayList.toArray(this.gRG));
    y.i("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    throw new CertificateException("Client Certification not supported");
  }
  
  /* Error */
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/tencent/mm/plugin/appbrand/o/m:gRD	Ljava/util/LinkedList;
    //   4: invokevirtual 103	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   7: astore 4
    //   9: aload 4
    //   11: invokeinterface 109 1 0
    //   16: ifeq +102 -> 118
    //   19: aload 4
    //   21: invokeinterface 113 1 0
    //   26: checkcast 6	javax/net/ssl/X509TrustManager
    //   29: astore 5
    //   31: aload 5
    //   33: aload_1
    //   34: aload_2
    //   35: invokeinterface 162 3 0
    //   40: iconst_1
    //   41: istore_3
    //   42: iload_3
    //   43: ifeq +4 -> 47
    //   46: return
    //   47: aload_0
    //   48: getfield 27	com/tencent/mm/plugin/appbrand/o/m:gRE	Ljava/util/LinkedList;
    //   51: invokevirtual 103	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   54: astore 4
    //   56: aload 4
    //   58: invokeinterface 109 1 0
    //   63: ifeq +50 -> 113
    //   66: aload 4
    //   68: invokeinterface 113 1 0
    //   73: checkcast 6	javax/net/ssl/X509TrustManager
    //   76: astore 5
    //   78: aload 5
    //   80: aload_1
    //   81: aload_2
    //   82: invokeinterface 162 3 0
    //   87: iconst_1
    //   88: istore_3
    //   89: iload_3
    //   90: ifne -44 -> 46
    //   93: new 156	java/security/cert/CertificateException
    //   96: dup
    //   97: ldc 164
    //   99: invokespecial 159	java/security/cert/CertificateException:<init>	(Ljava/lang/String;)V
    //   102: athrow
    //   103: astore 5
    //   105: goto -96 -> 9
    //   108: astore 5
    //   110: goto -54 -> 56
    //   113: iconst_0
    //   114: istore_3
    //   115: goto -26 -> 89
    //   118: iconst_0
    //   119: istore_3
    //   120: goto -78 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	m
    //   0	123	1	paramArrayOfX509Certificate	X509Certificate[]
    //   0	123	2	paramString	String
    //   41	79	3	i	int
    //   7	60	4	localIterator	Iterator
    //   29	50	5	localX509TrustManager	X509TrustManager
    //   103	1	5	localCertificateException1	CertificateException
    //   108	1	5	localCertificateException2	CertificateException
    // Exception table:
    //   from	to	target	type
    //   31	40	103	java/security/cert/CertificateException
    //   78	87	108	java/security/cert/CertificateException
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return this.gRG;
  }
  
  public final void init()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int i = 0;
      while ((localObject != null) && (i < localObject.length))
      {
        this.gRD.add((X509TrustManager)localObject[i]);
        i += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrandX509TrustManager", "init SystemTrustManager: " + localException);
      amM();
      amN();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.o.m
 * JD-Core Version:    0.7.0.1
 */