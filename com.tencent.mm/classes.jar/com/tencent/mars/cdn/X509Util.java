package com.tencent.mars.cdn;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
  public static final int STATE_APPBRAND = 1;
  public static final int STATE_CDN = 0;
  private static final String TAG = "X509Util";
  private static CertificateFactory sCertificateFactory;
  private static X509TrustManagerImplementation sDefaultTrustManager;
  private static boolean sLoadedSystemKeyStore;
  private static final Object sLock;
  private static o sSystemCertificateDirectory;
  private static KeyStore sSystemKeyStore;
  private static Set<Pair<X500Principal, PublicKey>> sSystemTrustAnchorCache;
  private static KeyStore sTestKeyStore;
  private static X509TrustManagerImplementation sTestTrustManager;
  private static TrustStorageListener sTrustStorageListener;
  
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
  
  private static X509TrustManagerImplementation createTrustManager(KeyStore paramKeyStore)
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
          X509TrustManagerIceCreamSandwich localX509TrustManagerIceCreamSandwich = new X509TrustManagerIceCreamSandwich((X509TrustManager)localObject);
          return localX509TrustManagerIceCreamSandwich;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject = localObject.getClass().getName();
          Log.e("X509Util", "Error creating trust manager (" + (String)localObject + "): " + localIllegalArgumentException);
        }
      }
      i += 1;
    }
    Log.e("X509Util", "Could not find suitable trust manager");
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
    //   0: getstatic 73	com/tencent/mars/cdn/X509Util:$assertionsDisabled	Z
    //   3: ifne +20 -> 23
    //   6: getstatic 78	com/tencent/mars/cdn/X509Util:sLock	Ljava/lang/Object;
    //   9: invokestatic 231	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   12: ifne +11 -> 23
    //   15: new 233	java/lang/AssertionError
    //   18: dup
    //   19: invokespecial 234	java/lang/AssertionError:<init>	()V
    //   22: athrow
    //   23: getstatic 154	com/tencent/mars/cdn/X509Util:sCertificateFactory	Ljava/security/cert/CertificateFactory;
    //   26: ifnonnull +11 -> 37
    //   29: ldc 236
    //   31: invokestatic 239	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   34: putstatic 154	com/tencent/mars/cdn/X509Util:sCertificateFactory	Ljava/security/cert/CertificateFactory;
    //   37: getstatic 241	com/tencent/mars/cdn/X509Util:sDefaultTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   40: ifnonnull +10 -> 50
    //   43: aconst_null
    //   44: invokestatic 243	com/tencent/mars/cdn/X509Util:createTrustManager	(Ljava/security/KeyStore;)Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   47: putstatic 241	com/tencent/mars/cdn/X509Util:sDefaultTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   50: getstatic 245	com/tencent/mars/cdn/X509Util:sLoadedSystemKeyStore	Z
    //   53: ifne +57 -> 110
    //   56: ldc 247
    //   58: invokestatic 250	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   61: putstatic 252	com/tencent/mars/cdn/X509Util:sSystemKeyStore	Ljava/security/KeyStore;
    //   64: getstatic 252	com/tencent/mars/cdn/X509Util:sSystemKeyStore	Ljava/security/KeyStore;
    //   67: aconst_null
    //   68: invokevirtual 152	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   71: new 254	com/tencent/mm/vfs/o
    //   74: dup
    //   75: new 114	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 255	java/lang/StringBuilder:<init>	()V
    //   82: ldc_w 257
    //   85: invokestatic 263	java/lang/System:getenv	(Ljava/lang/String;)Ljava/lang/String;
    //   88: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc_w 265
    //   94: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 266	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   103: putstatic 268	com/tencent/mars/cdn/X509Util:sSystemCertificateDirectory	Lcom/tencent/mm/vfs/o;
    //   106: iconst_1
    //   107: putstatic 245	com/tencent/mars/cdn/X509Util:sLoadedSystemKeyStore	Z
    //   110: getstatic 270	com/tencent/mars/cdn/X509Util:sSystemTrustAnchorCache	Ljava/util/Set;
    //   113: ifnonnull +13 -> 126
    //   116: new 272	java/util/HashSet
    //   119: dup
    //   120: invokespecial 273	java/util/HashSet:<init>	()V
    //   123: putstatic 270	com/tencent/mars/cdn/X509Util:sSystemTrustAnchorCache	Ljava/util/Set;
    //   126: getstatic 112	com/tencent/mars/cdn/X509Util:sTestKeyStore	Ljava/security/KeyStore;
    //   129: ifnonnull +19 -> 148
    //   132: invokestatic 276	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   135: invokestatic 250	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   138: putstatic 112	com/tencent/mars/cdn/X509Util:sTestKeyStore	Ljava/security/KeyStore;
    //   141: getstatic 112	com/tencent/mars/cdn/X509Util:sTestKeyStore	Ljava/security/KeyStore;
    //   144: aconst_null
    //   145: invokevirtual 152	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   148: getstatic 278	com/tencent/mars/cdn/X509Util:sTestTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   151: ifnonnull +12 -> 163
    //   154: getstatic 112	com/tencent/mars/cdn/X509Util:sTestKeyStore	Ljava/security/KeyStore;
    //   157: invokestatic 243	com/tencent/mars/cdn/X509Util:createTrustManager	(Ljava/security/KeyStore;)Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   160: putstatic 278	com/tencent/mars/cdn/X509Util:sTestTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   163: getstatic 280	com/tencent/mars/cdn/X509Util:sTrustStorageListener	Lcom/tencent/mars/cdn/X509Util$TrustStorageListener;
    //   166: ifnonnull +62 -> 228
    //   169: new 10	com/tencent/mars/cdn/X509Util$TrustStorageListener
    //   172: dup
    //   173: aconst_null
    //   174: invokespecial 283	com/tencent/mars/cdn/X509Util$TrustStorageListener:<init>	(Lcom/tencent/mars/cdn/X509Util$1;)V
    //   177: putstatic 280	com/tencent/mars/cdn/X509Util:sTrustStorageListener	Lcom/tencent/mars/cdn/X509Util$TrustStorageListener;
    //   180: new 285	android/content/IntentFilter
    //   183: dup
    //   184: invokespecial 286	android/content/IntentFilter:<init>	()V
    //   187: astore_0
    //   188: getstatic 194	android/os/Build$VERSION:SDK_INT	I
    //   191: bipush 26
    //   193: if_icmplt +36 -> 229
    //   196: aload_0
    //   197: ldc_w 288
    //   200: invokevirtual 291	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   203: aload_0
    //   204: ldc_w 293
    //   207: invokevirtual 291	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   210: aload_0
    //   211: ldc_w 295
    //   214: invokevirtual 291	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   217: invokestatic 301	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   220: getstatic 280	com/tencent/mars/cdn/X509Util:sTrustStorageListener	Lcom/tencent/mars/cdn/X509Util$TrustStorageListener;
    //   223: aload_0
    //   224: invokevirtual 307	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   227: pop
    //   228: return
    //   229: aload_0
    //   230: ldc_w 309
    //   233: invokevirtual 291	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   236: goto -19 -> 217
    //   239: astore_0
    //   240: goto -92 -> 148
    //   243: astore_0
    //   244: goto -138 -> 106
    //   247: astore_0
    //   248: goto -177 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   187	43	0	localIntentFilter	android.content.IntentFilter
    //   239	1	0	localIOException1	IOException
    //   243	1	0	localKeyStoreException	KeyStoreException
    //   247	1	0	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   141	148	239	java/io/IOException
    //   56	64	243	java/security/KeyStoreException
    //   64	71	243	java/security/KeyStoreException
    //   71	106	243	java/security/KeyStoreException
    //   64	71	247	java/io/IOException
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
    Log.i("X509Util", "certificate dn %s cn %s", new Object[] { localObject2, paramX509Certificate });
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
        break label101;
      }
      String str = "*" + paramString.substring(i);
      Log.i("X509Util", "try match nhost ".concat(String.valueOf(str)));
      if (paramList.contains(str)) {
        break;
      }
      i = paramString.indexOf(".", i + 1);
    }
    label101:
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
    } while (!new o(sSystemCertificateDirectory, (String)localObject1).exists());
    Object localObject2 = sSystemKeyStore.getCertificate("system:".concat(String.valueOf(localObject1)));
    if (localObject2 != null)
    {
      if ((localObject2 instanceof X509Certificate)) {
        break label197;
      }
      localObject2 = localObject2.getClass().getName();
      Log.e("X509Util", "Anchor " + (String)localObject1 + " not an X509Certificate: " + (String)localObject2);
    }
    label197:
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
    return verifyServerCertificates(paramArrayOfByte, paramString1, paramString2, 0, null);
  }
  
  /* Error */
  public static AndroidCertVerifyResult verifyServerCertificates(byte[][] paramArrayOfByte, String paramString1, String paramString2, int paramInt, X509TrustManager paramX509TrustManager)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 7
    //   6: ldc 45
    //   8: ldc_w 503
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_2
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_1
    //   22: aastore
    //   23: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: ifnull +14 -> 41
    //   30: aload_0
    //   31: arraylength
    //   32: ifeq +9 -> 41
    //   35: aload_0
    //   36: iconst_0
    //   37: aaload
    //   38: ifnonnull +31 -> 69
    //   41: new 170	java/lang/IllegalArgumentException
    //   44: dup
    //   45: new 114	java/lang/StringBuilder
    //   48: dup
    //   49: ldc_w 505
    //   52: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   55: aload_0
    //   56: invokestatic 511	java/util/Arrays:deepToString	([Ljava/lang/Object;)Ljava/lang/String;
    //   59: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokespecial 512	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   68: athrow
    //   69: invokestatic 106	com/tencent/mars/cdn/X509Util:ensureInitialized	()V
    //   72: new 316	java/util/ArrayList
    //   75: dup
    //   76: invokespecial 317	java/util/ArrayList:<init>	()V
    //   79: astore 8
    //   81: aload 8
    //   83: aload_0
    //   84: iconst_0
    //   85: aaload
    //   86: invokestatic 110	com/tencent/mars/cdn/X509Util:createCertificateFromBytes	([B)Ljava/security/cert/X509Certificate;
    //   89: invokeinterface 346 2 0
    //   94: pop
    //   95: aload 8
    //   97: iconst_0
    //   98: invokeinterface 338 2 0
    //   103: checkcast 166	java/security/cert/X509Certificate
    //   106: invokestatic 514	com/tencent/mars/cdn/X509Util:getSubjectAlternativeNames	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   109: astore 9
    //   111: ldc 45
    //   113: ldc_w 516
    //   116: iconst_2
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_2
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: aload 9
    //   128: invokevirtual 517	java/lang/Object:toString	()Ljava/lang/String;
    //   131: aastore
    //   132: invokestatic 378	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload 9
    //   137: aload_2
    //   138: invokestatic 519	com/tencent/mars/cdn/X509Util:isHostMatched	(Ljava/util/List;Ljava/lang/String;)Z
    //   141: ifne +492 -> 633
    //   144: ldc 45
    //   146: ldc_w 521
    //   149: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: iload_3
    //   153: iconst_1
    //   154: if_icmpeq +37 -> 191
    //   157: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   160: dup
    //   161: iconst_m1
    //   162: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   165: astore 9
    //   167: aload 9
    //   169: areturn
    //   170: astore_0
    //   171: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   174: dup
    //   175: iconst_m1
    //   176: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   179: areturn
    //   180: astore_0
    //   181: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   184: dup
    //   185: bipush 251
    //   187: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   190: areturn
    //   191: iconst_0
    //   192: istore 6
    //   194: iload 5
    //   196: istore_3
    //   197: iload_3
    //   198: aload_0
    //   199: arraylength
    //   200: if_icmpge +99 -> 299
    //   203: aload 8
    //   205: aload_0
    //   206: iload_3
    //   207: aaload
    //   208: invokestatic 110	com/tencent/mars/cdn/X509Util:createCertificateFromBytes	([B)Ljava/security/cert/X509Certificate;
    //   211: invokeinterface 346 2 0
    //   216: pop
    //   217: iload_3
    //   218: iconst_1
    //   219: iadd
    //   220: istore_3
    //   221: goto -24 -> 197
    //   224: astore 9
    //   226: ldc 45
    //   228: new 114	java/lang/StringBuilder
    //   231: dup
    //   232: ldc_w 528
    //   235: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   238: aload 9
    //   240: invokevirtual 531	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   243: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: iload_3
    //   253: iconst_1
    //   254: if_icmpeq +370 -> 624
    //   257: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   260: dup
    //   261: iconst_m1
    //   262: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   265: areturn
    //   266: astore 9
    //   268: ldc 45
    //   270: new 114	java/lang/StringBuilder
    //   273: dup
    //   274: ldc_w 533
    //   277: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   280: iload_3
    //   281: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: ldc_w 535
    //   287: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 538	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -79 -> 217
    //   299: aload 8
    //   301: aload 8
    //   303: invokeinterface 539 1 0
    //   308: anewarray 166	java/security/cert/X509Certificate
    //   311: invokeinterface 543 2 0
    //   316: checkcast 545	[Ljava/security/cert/X509Certificate;
    //   319: astore 9
    //   321: aload 9
    //   323: iconst_0
    //   324: aaload
    //   325: invokevirtual 548	java/security/cert/X509Certificate:checkValidity	()V
    //   328: aload 9
    //   330: iconst_0
    //   331: aaload
    //   332: invokestatic 550	com/tencent/mars/cdn/X509Util:verifyKeyUsage	(Ljava/security/cert/X509Certificate;)Z
    //   335: ifne +47 -> 382
    //   338: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   341: dup
    //   342: bipush 250
    //   344: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   347: astore_0
    //   348: aload_0
    //   349: areturn
    //   350: astore_0
    //   351: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   354: dup
    //   355: bipush 253
    //   357: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   360: areturn
    //   361: astore_0
    //   362: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   365: dup
    //   366: bipush 252
    //   368: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   371: areturn
    //   372: astore_0
    //   373: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   376: dup
    //   377: iconst_m1
    //   378: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   381: areturn
    //   382: getstatic 78	com/tencent/mars/cdn/X509Util:sLock	Ljava/lang/Object;
    //   385: astore 8
    //   387: aload 8
    //   389: monitorenter
    //   390: getstatic 241	com/tencent/mars/cdn/X509Util:sDefaultTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   393: ifnonnull +28 -> 421
    //   396: aload 4
    //   398: ifnonnull +23 -> 421
    //   401: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   404: dup
    //   405: iconst_m1
    //   406: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   409: astore_0
    //   410: aload 8
    //   412: monitorexit
    //   413: aload_0
    //   414: areturn
    //   415: astore_0
    //   416: aload 8
    //   418: monitorexit
    //   419: aload_0
    //   420: athrow
    //   421: aload 4
    //   423: ifnull +78 -> 501
    //   426: aload 4
    //   428: aload 9
    //   430: aload_1
    //   431: invokeinterface 554 3 0
    //   436: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   439: dup
    //   440: iconst_0
    //   441: iconst_1
    //   442: new 316	java/util/ArrayList
    //   445: dup
    //   446: invokespecial 317	java/util/ArrayList:<init>	()V
    //   449: iload 6
    //   451: invokespecial 557	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(IZLjava/util/List;Z)V
    //   454: astore_0
    //   455: aload 8
    //   457: monitorexit
    //   458: aload_0
    //   459: areturn
    //   460: astore_0
    //   461: ldc 45
    //   463: new 114	java/lang/StringBuilder
    //   466: dup
    //   467: ldc_w 559
    //   470: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   473: aload_0
    //   474: invokevirtual 562	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   477: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 428	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   489: dup
    //   490: bipush 254
    //   492: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   495: astore_0
    //   496: aload 8
    //   498: monitorexit
    //   499: aload_0
    //   500: areturn
    //   501: getstatic 241	com/tencent/mars/cdn/X509Util:sDefaultTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   504: aload 9
    //   506: aload_1
    //   507: aload_2
    //   508: invokeinterface 565 4 0
    //   513: astore_0
    //   514: aload_0
    //   515: invokeinterface 539 1 0
    //   520: ifle +25 -> 545
    //   523: aload_0
    //   524: aload_0
    //   525: invokeinterface 539 1 0
    //   530: iconst_1
    //   531: isub
    //   532: invokeinterface 338 2 0
    //   537: checkcast 166	java/security/cert/X509Certificate
    //   540: invokestatic 567	com/tencent/mars/cdn/X509Util:isKnownRoot	(Ljava/security/cert/X509Certificate;)Z
    //   543: istore 7
    //   545: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   548: dup
    //   549: iconst_0
    //   550: iload 7
    //   552: aload_0
    //   553: iload 6
    //   555: invokespecial 557	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(IZLjava/util/List;Z)V
    //   558: astore_0
    //   559: aload 8
    //   561: monitorexit
    //   562: aload_0
    //   563: areturn
    //   564: astore 4
    //   566: getstatic 278	com/tencent/mars/cdn/X509Util:sTestTrustManager	Lcom/tencent/mars/cdn/X509Util$X509TrustManagerImplementation;
    //   569: aload 9
    //   571: aload_1
    //   572: aload_2
    //   573: invokeinterface 565 4 0
    //   578: astore_0
    //   579: goto -65 -> 514
    //   582: astore_0
    //   583: ldc 45
    //   585: new 114	java/lang/StringBuilder
    //   588: dup
    //   589: ldc_w 569
    //   592: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   595: aload 4
    //   597: invokevirtual 562	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   600: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 428	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   609: new 523	com/tencent/mars/cdn/AndroidCertVerifyResult
    //   612: dup
    //   613: bipush 254
    //   615: invokespecial 526	com/tencent/mars/cdn/AndroidCertVerifyResult:<init>	(I)V
    //   618: astore_0
    //   619: aload 8
    //   621: monitorexit
    //   622: aload_0
    //   623: areturn
    //   624: iconst_0
    //   625: istore 6
    //   627: iload 5
    //   629: istore_3
    //   630: goto -433 -> 197
    //   633: iconst_1
    //   634: istore 6
    //   636: goto -442 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	639	0	paramArrayOfByte	byte[][]
    //   0	639	1	paramString1	String
    //   0	639	2	paramString2	String
    //   0	639	3	paramInt	int
    //   0	639	4	paramX509TrustManager	X509TrustManager
    //   1	627	5	i	int
    //   192	443	6	bool1	boolean
    //   4	547	7	bool2	boolean
    //   109	59	9	localObject2	Object
    //   224	15	9	localException	java.lang.Exception
    //   266	1	9	localCertificateException	CertificateException
    //   319	251	9	arrayOfX509Certificate	X509Certificate[]
    // Exception table:
    //   from	to	target	type
    //   69	72	170	java/security/cert/CertificateException
    //   81	95	180	java/security/cert/CertificateException
    //   95	152	224	java/lang/Exception
    //   157	167	224	java/lang/Exception
    //   203	217	266	java/security/cert/CertificateException
    //   321	348	350	java/security/cert/CertificateExpiredException
    //   321	348	361	java/security/cert/CertificateNotYetValidException
    //   321	348	372	java/security/cert/CertificateException
    //   390	396	415	finally
    //   401	413	415	finally
    //   416	419	415	finally
    //   426	436	415	finally
    //   436	458	415	finally
    //   461	499	415	finally
    //   501	514	415	finally
    //   514	545	415	finally
    //   545	562	415	finally
    //   566	579	415	finally
    //   583	622	415	finally
    //   426	436	460	java/security/cert/CertificateException
    //   501	514	564	java/security/cert/CertificateException
    //   566	579	582	java/security/cert/CertificateException
  }
  
  public static AndroidCertVerifyResult verifyServerCertificates(byte[][] paramArrayOfByte, String paramString1, String paramString2, X509TrustManager paramX509TrustManager)
  {
    return verifyServerCertificates(paramArrayOfByte, paramString1, paramString2, 0, paramX509TrustManager);
  }
  
  static final class TrustStorageListener
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool;
      if (Build.VERSION.SDK_INT >= 26) {
        if (("android.security.action.KEYCHAIN_CHANGED".equals(paramIntent.getAction())) || ("android.security.action.TRUST_STORE_CHANGED".equals(paramIntent.getAction()))) {
          bool = true;
        }
      }
      for (;;)
      {
        if (bool) {}
        try
        {
          X509Util.access$000();
          return;
        }
        catch (CertificateException paramContext)
        {
          Log.e("X509Util", "Unable to reload the default TrustManager", new Object[] { paramContext });
          return;
        }
        catch (KeyStoreException paramContext)
        {
          Log.e("X509Util", "Unable to reload the default TrustManager", new Object[] { paramContext });
          return;
        }
        catch (NoSuchAlgorithmException paramContext)
        {
          Log.e("X509Util", "Unable to reload the default TrustManager", new Object[] { paramContext });
          return;
        }
        if (("android.security.action.KEY_ACCESS_CHANGED".equals(paramIntent.getAction())) && (!paramIntent.getBooleanExtra("android.security.extra.KEY_ACCESSIBLE", false)))
        {
          bool = true;
          continue;
          bool = "android.security.STORAGE_CHANGED".equals(paramIntent.getAction());
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  static final class X509TrustManagerIceCreamSandwich
    implements X509Util.X509TrustManagerImplementation
  {
    private final X509TrustManager mTrustManager;
    
    public X509TrustManagerIceCreamSandwich(X509TrustManager paramX509TrustManager)
    {
      this.mTrustManager = paramX509TrustManager;
    }
    
    public final List<X509Certificate> checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
    {
      this.mTrustManager.checkServerTrusted(paramArrayOfX509Certificate, paramString1);
      return Collections.emptyList();
    }
  }
  
  static abstract interface X509TrustManagerImplementation
  {
    public abstract List<X509Certificate> checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2);
  }
  
  static final class X509TrustManagerJellyBean
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mars.cdn.X509Util
 * JD-Core Version:    0.7.0.1
 */