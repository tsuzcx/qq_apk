package com.tencent.mars.cdn;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

public class X509Util
{
  private static final char[] HEX_DIGITS;
  private static final String OID_ANY_EKU = "2.5.29.37.0";
  private static final String OID_SERVER_GATED_MICROSOFT = "1.3.6.1.4.1.311.10.3.3";
  private static final String OID_SERVER_GATED_NETSCAPE = "2.16.840.1.113730.4.1";
  private static final String OID_TLS_SERVER_AUTH = "1.3.6.1.5.5.7.3.1";
  private static final String TAG = "X509Util";
  private static CertificateFactory sCertificateFactory;
  private static X509Util.X509TrustManagerImplementation sDefaultTrustManager;
  private static boolean sLoadedSystemKeyStore;
  private static final Object sLock;
  private static File sSystemCertificateDirectory;
  private static KeyStore sSystemKeyStore;
  private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
  private static KeyStore sTestKeyStore;
  private static X509Util.X509TrustManagerImplementation sTestTrustManager;
  private static X509Util.TrustStorageListener sTrustStorageListener;
  
  static
  {
    if (!X509Util.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      sLock = new Object();
      HEX_DIGITS = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
      return;
    }
  }
  
  public static void addTestRootCertificate(byte[] arg0)
  {
    ensureInitialized();
    X509Certificate localX509Certificate = createCertificateFromBytes(???);
    synchronized (sLock)
    {
      sTestKeyStore.setCertificateEntry("root_cert_" + Integer.toString(sTestKeyStore.size()), localX509Certificate);
      reloadTestTrustManager();
      return;
    }
  }
  
  public static void clearTestRootCertificates()
  {
    
    try
    {
      synchronized (sLock)
      {
        sTestKeyStore.load(null);
        reloadTestTrustManager();
        label19:
        return;
      }
    }
    catch (IOException localIOException)
    {
      break label19;
    }
  }
  
  public static X509Certificate createCertificateFromBytes(byte[] paramArrayOfByte)
  {
    ensureInitialized();
    return (X509Certificate)sCertificateFactory.generateCertificate(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  private static X509Util.X509TrustManagerImplementation createTrustManager(KeyStore paramKeyStore)
  {
    Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    ((TrustManagerFactory)localObject).init(paramKeyStore);
    paramKeyStore = ((TrustManagerFactory)localObject).getTrustManagers();
    int j = paramKeyStore.length;
    int i = 0;
    while (i < j)
    {
      localObject = paramKeyStore[i];
      if ((localObject instanceof X509TrustManager)) {
        try
        {
          if (Build.VERSION.SDK_INT >= 17) {
            return new X509TrustManagerJellyBean((X509TrustManager)localObject);
          }
          X509Util.X509TrustManagerIceCreamSandwich localX509TrustManagerIceCreamSandwich = new X509Util.X509TrustManagerIceCreamSandwich((X509TrustManager)localObject);
          return localX509TrustManagerIceCreamSandwich;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject = localObject.getClass().getName();
          y.e("X509Util", "Error creating trust manager (" + (String)localObject + "): " + localIllegalArgumentException);
        }
      }
      i += 1;
    }
    y.e("X509Util", "Could not find suitable trust manager");
    return null;
  }
  
  private static void ensureInitialized()
  {
    synchronized (sLock)
    {
      ensureInitializedLocked();
      return;
    }
  }
  
  /* Error */
  private static void ensureInitializedLocked()
  {
    // Byte code:
    //   0: getstatic 64	com/tencent/mars/cdn/X509Util:$assertionsDisabled	Z
    //   3: ifne +20 -> 23
    //   6: getstatic 69	com/tencent/mars/cdn/X509Util:sLock	Ljava/lang/Object;
    //   9: invokestatic 223	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   12: ifne +11 -> 23
    //   15: new 225	java/lang/AssertionError
    //   18: dup
    //   19: invokespecial 226	java/lang/AssertionError:<init>	()V
    //   22: athrow
    //   23: getstatic 145	com/tencent/mars/cdn/X509Util:sCertificateFactory	Ljava/security/cert/CertificateFactory;
    //   26: ifnonnull +11 -> 37
    //   29: ldc 228
    //   31: invokestatic 231	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   34: putstatic 145	com/tencent/mars/cdn/X509Util:sCertificateFactory	Ljava/security/cert/CertificateFactory;
    //   37: getstatic 233	com/tencent/mars/cdn/X509Util:sDefaultTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   40: ifnonnull +10 -> 50
    //   43: aconst_null
    //   44: invokestatic 235	com/tencent/mars/cdn/X509Util:createTrustManager	(Ljava/security/KeyStore;)Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   47: putstatic 233	com/tencent/mars/cdn/X509Util:sDefaultTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   50: getstatic 237	com/tencent/mars/cdn/X509Util:sLoadedSystemKeyStore	Z
    //   53: ifne +56 -> 109
    //   56: ldc 239
    //   58: invokestatic 242	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   61: putstatic 244	com/tencent/mars/cdn/X509Util:sSystemKeyStore	Ljava/security/KeyStore;
    //   64: getstatic 244	com/tencent/mars/cdn/X509Util:sSystemKeyStore	Ljava/security/KeyStore;
    //   67: aconst_null
    //   68: invokevirtual 143	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   71: new 246	java/io/File
    //   74: dup
    //   75: new 105	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 247	java/lang/StringBuilder:<init>	()V
    //   82: ldc 249
    //   84: invokestatic 255	java/lang/System:getenv	(Ljava/lang/String;)Ljava/lang/String;
    //   87: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 257
    //   93: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 258	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: putstatic 260	com/tencent/mars/cdn/X509Util:sSystemCertificateDirectory	Ljava/io/File;
    //   105: iconst_1
    //   106: putstatic 237	com/tencent/mars/cdn/X509Util:sLoadedSystemKeyStore	Z
    //   109: getstatic 262	com/tencent/mars/cdn/X509Util:sSystemTrustAnchorCache	Ljava/util/Set;
    //   112: ifnonnull +13 -> 125
    //   115: new 264	java/util/HashSet
    //   118: dup
    //   119: invokespecial 265	java/util/HashSet:<init>	()V
    //   122: putstatic 262	com/tencent/mars/cdn/X509Util:sSystemTrustAnchorCache	Ljava/util/Set;
    //   125: getstatic 103	com/tencent/mars/cdn/X509Util:sTestKeyStore	Ljava/security/KeyStore;
    //   128: ifnonnull +19 -> 147
    //   131: invokestatic 268	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   134: invokestatic 242	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   137: putstatic 103	com/tencent/mars/cdn/X509Util:sTestKeyStore	Ljava/security/KeyStore;
    //   140: getstatic 103	com/tencent/mars/cdn/X509Util:sTestKeyStore	Ljava/security/KeyStore;
    //   143: aconst_null
    //   144: invokevirtual 143	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   147: getstatic 270	com/tencent/mars/cdn/X509Util:sTestTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   150: ifnonnull +12 -> 162
    //   153: getstatic 103	com/tencent/mars/cdn/X509Util:sTestKeyStore	Ljava/security/KeyStore;
    //   156: invokestatic 235	com/tencent/mars/cdn/X509Util:createTrustManager	(Ljava/security/KeyStore;)Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   159: putstatic 270	com/tencent/mars/cdn/X509Util:sTestTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   162: getstatic 272	com/tencent/mars/cdn/X509Util:sTrustStorageListener	Lcom/tencent/mars/cdn/X509Util$TrustStorageListener;
    //   165: ifnonnull +62 -> 227
    //   168: new 9	com/tencent/mars/cdn/X509Util$TrustStorageListener
    //   171: dup
    //   172: aconst_null
    //   173: invokespecial 275	com/tencent/mars/cdn/X509Util$TrustStorageListener:<init>	(Lcom/tencent/mars/cdn/X509Util$1;)V
    //   176: putstatic 272	com/tencent/mars/cdn/X509Util:sTrustStorageListener	Lcom/tencent/mars/cdn/X509Util$TrustStorageListener;
    //   179: new 277	android/content/IntentFilter
    //   182: dup
    //   183: invokespecial 278	android/content/IntentFilter:<init>	()V
    //   186: astore_0
    //   187: getstatic 186	android/os/Build$VERSION:SDK_INT	I
    //   190: bipush 26
    //   192: if_icmplt +36 -> 228
    //   195: aload_0
    //   196: ldc_w 280
    //   199: invokevirtual 283	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   202: aload_0
    //   203: ldc_w 285
    //   206: invokevirtual 283	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   209: aload_0
    //   210: ldc_w 287
    //   213: invokevirtual 283	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   216: invokestatic 293	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   219: getstatic 272	com/tencent/mars/cdn/X509Util:sTrustStorageListener	Lcom/tencent/mars/cdn/X509Util$TrustStorageListener;
    //   222: aload_0
    //   223: invokevirtual 299	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   226: pop
    //   227: return
    //   228: aload_0
    //   229: ldc_w 301
    //   232: invokevirtual 283	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   235: goto -19 -> 216
    //   238: astore_0
    //   239: goto -92 -> 147
    //   242: astore_0
    //   243: goto -138 -> 105
    //   246: astore_0
    //   247: goto -176 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   186	43	0	localIntentFilter	android.content.IntentFilter
    //   238	1	0	localIOException1	IOException
    //   242	1	0	localKeyStoreException	java.security.KeyStoreException
    //   246	1	0	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   140	147	238	java/io/IOException
    //   56	64	242	java/security/KeyStoreException
    //   64	71	242	java/security/KeyStoreException
    //   71	105	242	java/security/KeyStoreException
    //   64	71	246	java/io/IOException
  }
  
  private static List<String> getSubjectAlternativeNames(X509Certificate paramX509Certificate)
  {
    Object localObject1 = paramX509Certificate.getSubjectAlternativeNames();
    if (localObject1 == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Collection)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((List)((Iterator)localObject1).next()).get(1);
      if ((localObject2 instanceof String)) {
        localArrayList.add(((String)localObject2).toLowerCase());
      }
    }
    Object localObject2 = paramX509Certificate.getSubjectDN().getName().trim();
    int i = ((String)localObject2).indexOf("CN=");
    paramX509Certificate = "";
    if (i >= 0)
    {
      localObject1 = ((String)localObject2).substring(i + 3);
      i = ((String)localObject1).indexOf(",");
      paramX509Certificate = (X509Certificate)localObject1;
      if (i > 0) {
        paramX509Certificate = ((String)localObject1).substring(0, i);
      }
    }
    y.i("X509Util", "certificate dn %s cn %s", new Object[] { localObject2, paramX509Certificate });
    if (paramX509Certificate.length() > 0) {
      localArrayList.add(paramX509Certificate);
    }
    return localArrayList;
  }
  
  private static String hashPrincipal(X500Principal paramX500Principal)
  {
    paramX500Principal = MessageDigest.getInstance("MD5").digest(paramX500Principal.getEncoded());
    char[] arrayOfChar = new char[8];
    int i = 0;
    while (i < 4)
    {
      arrayOfChar[(i * 2)] = HEX_DIGITS[(paramX500Principal[(3 - i)] >> 4 & 0xF)];
      arrayOfChar[(i * 2 + 1)] = HEX_DIGITS[(paramX500Principal[(3 - i)] & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  private static boolean isHostMatched(List<String> paramList, String paramString)
  {
    if (paramList.contains(paramString)) {
      return true;
    }
    int i = paramString.indexOf(".");
    int j = paramString.lastIndexOf(".");
    for (;;)
    {
      if ((i <= 0) || (i >= j)) {
        break label108;
      }
      String str = "*" + paramString.substring(i);
      y.i("X509Util", "try match nhost " + str);
      if (paramList.contains(str)) {
        break;
      }
      i = paramString.indexOf(".", i + 1);
    }
    label108:
    return false;
  }
  
  private static boolean isKnownRoot(X509Certificate paramX509Certificate)
  {
    assert (Thread.holdsLock(sLock));
    if (sSystemKeyStore == null) {}
    Pair localPair;
    int i;
    Object localObject1;
    do
    {
      return false;
      localPair = new Pair(paramX509Certificate.getSubjectX500Principal(), paramX509Certificate.getPublicKey());
      if (sSystemTrustAnchorCache.contains(localPair)) {
        return true;
      }
      String str = hashPrincipal(paramX509Certificate.getSubjectX500Principal());
      i = 0;
      localObject1 = str + '.' + i;
    } while (!new File(sSystemCertificateDirectory, (String)localObject1).exists());
    Object localObject2 = sSystemKeyStore.getCertificate("system:" + (String)localObject1);
    if (localObject2 != null)
    {
      if ((localObject2 instanceof X509Certificate)) {
        break label204;
      }
      localObject2 = localObject2.getClass().getName();
      y.e("X509Util", "Anchor " + (String)localObject1 + " not an X509Certificate: " + (String)localObject2);
    }
    label204:
    do
    {
      i += 1;
      break;
      localObject1 = (X509Certificate)localObject2;
    } while ((!paramX509Certificate.getSubjectX500Principal().equals(((X509Certificate)localObject1).getSubjectX500Principal())) || (!paramX509Certificate.getPublicKey().equals(((X509Certificate)localObject1).getPublicKey())));
    sSystemTrustAnchorCache.add(localPair);
    return true;
  }
  
  private static void reloadDefaultTrustManager()
  {
    synchronized (sLock)
    {
      sDefaultTrustManager = null;
      sSystemTrustAnchorCache = null;
      ensureInitializedLocked();
      return;
    }
  }
  
  private static void reloadTestTrustManager()
  {
    assert (Thread.holdsLock(sLock));
    sTestTrustManager = createTrustManager(sTestKeyStore);
  }
  
  static boolean verifyKeyUsage(X509Certificate paramX509Certificate)
  {
    try
    {
      paramX509Certificate = paramX509Certificate.getExtendedKeyUsage();
      if (paramX509Certificate == null) {
        return true;
      }
    }
    catch (NullPointerException paramX509Certificate)
    {
      return false;
    }
    paramX509Certificate = paramX509Certificate.iterator();
    while (paramX509Certificate.hasNext())
    {
      String str = (String)paramX509Certificate.next();
      if ((str.equals("1.3.6.1.5.5.7.3.1")) || (str.equals("2.5.29.37.0")) || (str.equals("2.16.840.1.113730.4.1")) || (str.equals("1.3.6.1.4.1.311.10.3.3"))) {
        return true;
      }
    }
    return false;
  }
  
  public static AndroidCertVerifyResult verifyServerCertificates(byte[][] paramArrayOfByte, String paramString1, String paramString2)
  {
    y.i("X509Util", "verifyServerCertificates %s type %s", new Object[] { paramString2, paramString1 });
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte[0] == null)) {
      throw new IllegalArgumentException("Expected non-null and non-empty certificate chain passed as |certChain|. |certChain|=" + Arrays.deepToString(paramArrayOfByte));
    }
    try
    {
      ensureInitialized();
      ??? = new ArrayList();
      List localList;
      i = 1;
    }
    catch (CertificateException paramArrayOfByte)
    {
      try
      {
        ((List)???).add(createCertificateFromBytes(paramArrayOfByte[0]));
      }
      catch (CertificateException paramArrayOfByte)
      {
        return new AndroidCertVerifyResult(-5);
      }
      try
      {
        localList = getSubjectAlternativeNames((X509Certificate)((List)???).get(0));
        y.i("X509Util", "check host %s in altnames %s", new Object[] { paramString2, localList.toString() });
        if (isHostMatched(localList, paramString2)) {
          break label213;
        }
        y.e("X509Util", "hostname mismatch");
        paramArrayOfByte = new AndroidCertVerifyResult(-1);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        y.e("X509Util", "hostname verify failed " + paramArrayOfByte.getLocalizedMessage());
        return new AndroidCertVerifyResult(-1);
      }
      paramArrayOfByte = paramArrayOfByte;
      return new AndroidCertVerifyResult(-1);
    }
    for (;;)
    {
      label213:
      int i;
      if (i < paramArrayOfByte.length) {
        try
        {
          ((List)???).add(createCertificateFromBytes(paramArrayOfByte[i]));
          i += 1;
        }
        catch (CertificateException localCertificateException1)
        {
          for (;;)
          {
            y.w("X509Util", "intermediate " + i + " failed parsing");
          }
        }
      }
    }
    X509Certificate[] arrayOfX509Certificate = (X509Certificate[])((List)???).toArray(new X509Certificate[((List)???).size()]);
    try
    {
      arrayOfX509Certificate[0].checkValidity();
      if (!verifyKeyUsage(arrayOfX509Certificate[0]))
      {
        paramArrayOfByte = new AndroidCertVerifyResult(-6);
        return paramArrayOfByte;
      }
    }
    catch (CertificateExpiredException paramArrayOfByte)
    {
      return new AndroidCertVerifyResult(-3);
    }
    catch (CertificateNotYetValidException paramArrayOfByte)
    {
      return new AndroidCertVerifyResult(-4);
    }
    catch (CertificateException paramArrayOfByte)
    {
      return new AndroidCertVerifyResult(-1);
    }
    synchronized (sLock)
    {
      if (sDefaultTrustManager == null)
      {
        paramArrayOfByte = new AndroidCertVerifyResult(-1);
        return paramArrayOfByte;
      }
    }
    try
    {
      paramArrayOfByte = sDefaultTrustManager.checkServerTrusted(arrayOfX509Certificate, paramString1, paramString2);
      if (paramArrayOfByte.size() > 0)
      {
        bool = isKnownRoot((X509Certificate)paramArrayOfByte.get(paramArrayOfByte.size() - 1));
        paramArrayOfByte = new AndroidCertVerifyResult(0, bool, paramArrayOfByte);
        return paramArrayOfByte;
      }
    }
    catch (CertificateException localCertificateException2)
    {
      for (;;)
      {
        try
        {
          paramArrayOfByte = sTestTrustManager.checkServerTrusted(arrayOfX509Certificate, paramString1, paramString2);
        }
        catch (CertificateException paramArrayOfByte)
        {
          y.i("X509Util", "Failed to validate the certificate chain, error: " + localCertificateException2.getMessage());
          paramArrayOfByte = new AndroidCertVerifyResult(-2);
          return paramArrayOfByte;
        }
        boolean bool = false;
      }
    }
  }
  
  private static final class CertVerifyStatusAndroid
  {
    public static final int EXPIRED = -3;
    public static final int FAILED = -1;
    public static final int INCORRECT_KEY_USAGE = -6;
    public static final int NOT_YET_VALID = -4;
    public static final int NO_TRUSTED_ROOT = -2;
    public static final int OK = 0;
    public static final int UNABLE_TO_PARSE = -5;
  }
  
  private static final class X509TrustManagerJellyBean
    implements X509Util.X509TrustManagerImplementation
  {
    private final X509TrustManagerExtensions mTrustManagerExtensions;
    
    @SuppressLint({"NewApi"})
    public X509TrustManagerJellyBean(X509TrustManager paramX509TrustManager)
    {
      this.mTrustManagerExtensions = new X509TrustManagerExtensions(paramX509TrustManager);
    }
    
    @SuppressLint({"NewApi"})
    public final List<X509Certificate> checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
    {
      return this.mTrustManagerExtensions.checkServerTrusted(paramArrayOfX509Certificate, paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.cdn.X509Util
 * JD-Core Version:    0.7.0.1
 */