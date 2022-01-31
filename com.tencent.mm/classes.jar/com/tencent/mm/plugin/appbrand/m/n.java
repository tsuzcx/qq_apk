package com.tencent.mm.plugin.appbrand.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class n
  implements X509TrustManager
{
  private LinkedList<X509TrustManager> itp;
  private LinkedList<X509TrustManager> itq;
  private KeyStore itr;
  private int its;
  private List<String> itt;
  private KeyStore itu;
  private X509Certificate[] itv;
  
  public n()
  {
    AppMethodBeat.i(108252);
    this.itt = null;
    this.itu = null;
    this.itp = new LinkedList();
    this.itq = new LinkedList();
    try
    {
      this.itr = KeyStore.getInstance(KeyStore.getDefaultType());
      this.itr.load(null, null);
      AppMethodBeat.o(108252);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", localException, "Exception: Local KeyStore init failed", new Object[0]);
      AppMethodBeat.o(108252);
    }
  }
  
  public n(int paramInt)
  {
    AppMethodBeat.i(108253);
    this.itt = null;
    this.itu = null;
    this.itp = new LinkedList();
    this.itq = new LinkedList();
    this.its = paramInt;
    try
    {
      this.itr = KeyStore.getInstance(KeyStore.getDefaultType());
      this.itr.load(null, null);
      AppMethodBeat.o(108253);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", localException, "Exception: Local KeyStore init failed", new Object[0]);
      AppMethodBeat.o(108253);
    }
  }
  
  private void aIr()
  {
    AppMethodBeat.i(108258);
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int i = 0;
      while ((localObject != null) && (i < localObject.length))
      {
        this.itp.add((X509TrustManager)localObject[i]);
        i += 1;
      }
      AppMethodBeat.o(108258);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", localException, "Exception: init SystemTrustManager", new Object[0]);
      AppMethodBeat.o(108258);
    }
  }
  
  private void aIs()
  {
    AppMethodBeat.i(108259);
    if (this.itr == null)
    {
      AppMethodBeat.o(108259);
      return;
    }
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(this.itr);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int i = 0;
      while ((localObject != null) && (i < localObject.length))
      {
        this.itq.add((X509TrustManager)localObject[i]);
        i += 1;
      }
      AppMethodBeat.o(108259);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", localException, "Exception: init LocalTrustManager", new Object[0]);
      AppMethodBeat.o(108259);
    }
  }
  
  private void aIt()
  {
    AppMethodBeat.i(108260);
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.itp.iterator();
    X509Certificate[] arrayOfX509Certificate;
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate = ((X509TrustManager)localIterator.next()).getAcceptedIssuers();
      if (arrayOfX509Certificate != null) {
        localArrayList.addAll(Arrays.asList(arrayOfX509Certificate));
      }
    }
    long l2 = System.currentTimeMillis();
    localIterator = this.itq.iterator();
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate = ((X509TrustManager)localIterator.next()).getAcceptedIssuers();
      if (arrayOfX509Certificate != null) {
        localArrayList.addAll(Arrays.asList(arrayOfX509Certificate));
      }
    }
    long l3 = System.currentTimeMillis();
    this.itv = new X509Certificate[localArrayList.size()];
    this.itv = ((X509Certificate[])localArrayList.toArray(this.itv));
    ab.i("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
    AppMethodBeat.o(108260);
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    AppMethodBeat.i(108256);
    paramArrayOfX509Certificate = new CertificateException("Client Certification not supported");
    AppMethodBeat.o(108256);
    throw paramArrayOfX509Certificate;
  }
  
  /* Error */
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    // Byte code:
    //   0: ldc 186
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 188
    //   7: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   10: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   13: ldc2_w 195
    //   16: lconst_0
    //   17: lconst_1
    //   18: iconst_0
    //   19: invokeinterface 200 8 0
    //   24: ldc 65
    //   26: new 202	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 204
    //   32: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 42	com/tencent/mm/plugin/appbrand/m/n:itp	Ljava/util/LinkedList;
    //   39: invokevirtual 206	java/util/LinkedList:size	()I
    //   42: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 42	com/tencent/mm/plugin/appbrand/m/n:itp	Ljava/util/LinkedList;
    //   55: invokevirtual 120	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   58: astore 9
    //   60: iconst_0
    //   61: istore_3
    //   62: aload 9
    //   64: invokeinterface 126 1 0
    //   69: ifeq +76 -> 145
    //   72: aload 9
    //   74: invokeinterface 130 1 0
    //   79: checkcast 6	javax/net/ssl/X509TrustManager
    //   82: astore 10
    //   84: ldc 65
    //   86: new 202	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 218
    //   92: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload 10
    //   97: invokevirtual 219	java/lang/Object:toString	()Ljava/lang/String;
    //   100: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload 10
    //   111: aload_1
    //   112: aload_2
    //   113: invokeinterface 224 3 0
    //   118: ldc 65
    //   120: new 202	java/lang/StringBuilder
    //   123: dup
    //   124: ldc 226
    //   126: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload 10
    //   131: invokevirtual 219	java/lang/Object:toString	()Ljava/lang/String;
    //   134: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: iconst_1
    //   144: istore_3
    //   145: iload_3
    //   146: ifeq +53 -> 199
    //   149: ldc 65
    //   151: ldc 228
    //   153: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: ldc 188
    //   158: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   161: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   164: ldc2_w 195
    //   167: lconst_1
    //   168: lconst_1
    //   169: iconst_0
    //   170: invokeinterface 200 8 0
    //   175: ldc 186
    //   177: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   180: return
    //   181: astore 10
    //   183: ldc 65
    //   185: aload 10
    //   187: ldc 230
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: goto -136 -> 60
    //   199: ldc 65
    //   201: ldc 232
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload_0
    //   210: getfield 44	com/tencent/mm/plugin/appbrand/m/n:itq	Ljava/util/LinkedList;
    //   213: invokevirtual 206	java/util/LinkedList:size	()I
    //   216: invokestatic 237	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   219: aastore
    //   220: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: aload_0
    //   224: getfield 44	com/tencent/mm/plugin/appbrand/m/n:itq	Ljava/util/LinkedList;
    //   227: invokevirtual 120	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   230: astore 9
    //   232: iconst_0
    //   233: istore_3
    //   234: aload 9
    //   236: invokeinterface 126 1 0
    //   241: ifeq +51 -> 292
    //   244: aload 9
    //   246: invokeinterface 130 1 0
    //   251: checkcast 6	javax/net/ssl/X509TrustManager
    //   254: astore 10
    //   256: aload 10
    //   258: aload_1
    //   259: aload_2
    //   260: invokeinterface 224 3 0
    //   265: ldc 65
    //   267: new 202	java/lang/StringBuilder
    //   270: dup
    //   271: ldc 239
    //   273: invokespecial 205	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   276: aload 10
    //   278: invokevirtual 219	java/lang/Object:toString	()Ljava/lang/String;
    //   281: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: iconst_1
    //   291: istore_3
    //   292: iload_3
    //   293: ifeq +55 -> 348
    //   296: ldc 65
    //   298: ldc 241
    //   300: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: ldc 188
    //   305: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   308: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   311: ldc2_w 195
    //   314: ldc2_w 242
    //   317: lconst_1
    //   318: iconst_0
    //   319: invokeinterface 200 8 0
    //   324: ldc 186
    //   326: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: astore 10
    //   332: ldc 65
    //   334: aload 10
    //   336: ldc 245
    //   338: iconst_0
    //   339: anewarray 4	java/lang/Object
    //   342: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: goto -113 -> 232
    //   348: aload_0
    //   349: getfield 77	com/tencent/mm/plugin/appbrand/m/n:its	I
    //   352: iconst_1
    //   353: if_icmpeq +11 -> 364
    //   356: aload_0
    //   357: getfield 77	com/tencent/mm/plugin/appbrand/m/n:its	I
    //   360: iconst_2
    //   361: if_icmpne +945 -> 1306
    //   364: ldc 65
    //   366: ldc 247
    //   368: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: iconst_0
    //   372: istore 5
    //   374: iconst_0
    //   375: istore 6
    //   377: iconst_0
    //   378: istore 7
    //   380: iconst_0
    //   381: istore 8
    //   383: iconst_0
    //   384: istore 4
    //   386: iload 8
    //   388: istore_3
    //   389: aload_0
    //   390: getfield 37	com/tencent/mm/plugin/appbrand/m/n:itu	Ljava/security/KeyStore;
    //   393: ifnonnull +27 -> 420
    //   396: iload 8
    //   398: istore_3
    //   399: aload_0
    //   400: ldc 249
    //   402: invokestatic 54	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   405: putfield 37	com/tencent/mm/plugin/appbrand/m/n:itu	Ljava/security/KeyStore;
    //   408: iload 8
    //   410: istore_3
    //   411: aload_0
    //   412: getfield 37	com/tencent/mm/plugin/appbrand/m/n:itu	Ljava/security/KeyStore;
    //   415: aconst_null
    //   416: aconst_null
    //   417: invokevirtual 60	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   420: iload 8
    //   422: istore_3
    //   423: aload_0
    //   424: getfield 35	com/tencent/mm/plugin/appbrand/m/n:itt	Ljava/util/List;
    //   427: ifnonnull +172 -> 599
    //   430: iload 8
    //   432: istore_3
    //   433: aload_0
    //   434: new 109	java/util/ArrayList
    //   437: dup
    //   438: invokespecial 110	java/util/ArrayList:<init>	()V
    //   441: putfield 35	com/tencent/mm/plugin/appbrand/m/n:itt	Ljava/util/List;
    //   444: iload 8
    //   446: istore_3
    //   447: aload_0
    //   448: getfield 37	com/tencent/mm/plugin/appbrand/m/n:itu	Ljava/security/KeyStore;
    //   451: invokevirtual 253	java/security/KeyStore:aliases	()Ljava/util/Enumeration;
    //   454: astore_2
    //   455: iload 8
    //   457: istore_3
    //   458: aload_2
    //   459: invokeinterface 258 1 0
    //   464: ifeq +135 -> 599
    //   467: iload 8
    //   469: istore_3
    //   470: aload_2
    //   471: invokeinterface 261 1 0
    //   476: checkcast 263	java/lang/String
    //   479: astore 9
    //   481: aload 9
    //   483: ifnull -28 -> 455
    //   486: iload 8
    //   488: istore_3
    //   489: aload 9
    //   491: ldc_w 265
    //   494: invokevirtual 269	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   497: ifeq -42 -> 455
    //   500: iload 8
    //   502: istore_3
    //   503: aload_0
    //   504: getfield 35	com/tencent/mm/plugin/appbrand/m/n:itt	Ljava/util/List;
    //   507: aload 9
    //   509: invokeinterface 272 2 0
    //   514: pop
    //   515: goto -60 -> 455
    //   518: astore_1
    //   519: iload 4
    //   521: istore_3
    //   522: ldc 65
    //   524: aload_1
    //   525: ldc_w 274
    //   528: iconst_0
    //   529: anewarray 4	java/lang/Object
    //   532: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: iload 4
    //   537: istore_3
    //   538: ldc 188
    //   540: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   543: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   546: ldc2_w 195
    //   549: ldc2_w 275
    //   552: lconst_1
    //   553: iconst_0
    //   554: invokeinterface 200 8 0
    //   559: iload 4
    //   561: ifeq +286 -> 847
    //   564: ldc 65
    //   566: ldc_w 278
    //   569: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: ldc 188
    //   574: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   577: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   580: ldc2_w 195
    //   583: ldc2_w 279
    //   586: lconst_1
    //   587: iconst_0
    //   588: invokeinterface 200 8 0
    //   593: ldc 186
    //   595: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   598: return
    //   599: iload 8
    //   601: istore_3
    //   602: aload_0
    //   603: getfield 35	com/tencent/mm/plugin/appbrand/m/n:itt	Ljava/util/List;
    //   606: invokeinterface 281 1 0
    //   611: ifle +111 -> 722
    //   614: iload 8
    //   616: istore_3
    //   617: aload_0
    //   618: getfield 35	com/tencent/mm/plugin/appbrand/m/n:itt	Ljava/util/List;
    //   621: invokeinterface 282 1 0
    //   626: astore_2
    //   627: iconst_0
    //   628: istore_3
    //   629: iload_3
    //   630: istore 4
    //   632: aload_2
    //   633: invokeinterface 126 1 0
    //   638: ifeq +122 -> 760
    //   641: aload_2
    //   642: invokeinterface 130 1 0
    //   647: checkcast 263	java/lang/String
    //   650: astore 9
    //   652: aload_0
    //   653: getfield 37	com/tencent/mm/plugin/appbrand/m/n:itu	Ljava/security/KeyStore;
    //   656: aload 9
    //   658: invokevirtual 286	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   661: checkcast 150	java/security/cert/X509Certificate
    //   664: astore 9
    //   666: iconst_0
    //   667: istore 4
    //   669: aload_1
    //   670: arraylength
    //   671: istore 5
    //   673: iload 4
    //   675: iload 5
    //   677: if_icmpge -48 -> 629
    //   680: aload_1
    //   681: iload 4
    //   683: aaload
    //   684: aload 9
    //   686: invokevirtual 290	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   689: invokevirtual 294	java/security/cert/X509Certificate:verify	(Ljava/security/PublicKey;)V
    //   692: iconst_1
    //   693: istore_3
    //   694: goto -65 -> 629
    //   697: astore 10
    //   699: ldc 65
    //   701: aload 10
    //   703: ldc_w 296
    //   706: iconst_0
    //   707: anewarray 4	java/lang/Object
    //   710: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   713: iload 4
    //   715: iconst_1
    //   716: iadd
    //   717: istore 4
    //   719: goto -50 -> 669
    //   722: iload 8
    //   724: istore_3
    //   725: ldc 65
    //   727: ldc_w 298
    //   730: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: iload 8
    //   735: istore_3
    //   736: ldc 188
    //   738: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   741: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   744: ldc2_w 195
    //   747: ldc2_w 299
    //   750: lconst_1
    //   751: iconst_0
    //   752: invokeinterface 200 8 0
    //   757: iconst_0
    //   758: istore 4
    //   760: iload 4
    //   762: ifeq +38 -> 800
    //   765: ldc 65
    //   767: ldc_w 278
    //   770: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   773: ldc 188
    //   775: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   778: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   781: ldc2_w 195
    //   784: ldc2_w 279
    //   787: lconst_1
    //   788: iconst_0
    //   789: invokeinterface 200 8 0
    //   794: ldc 186
    //   796: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   799: return
    //   800: ldc 65
    //   802: ldc_w 302
    //   805: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   808: ldc 188
    //   810: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   813: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   816: ldc2_w 195
    //   819: ldc2_w 303
    //   822: lconst_1
    //   823: iconst_0
    //   824: invokeinterface 200 8 0
    //   829: new 173	java/security/cert/CertificateException
    //   832: dup
    //   833: ldc_w 306
    //   836: invokespecial 178	java/security/cert/CertificateException:<init>	(Ljava/lang/String;)V
    //   839: astore_1
    //   840: ldc 186
    //   842: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   845: aload_1
    //   846: athrow
    //   847: ldc 65
    //   849: ldc_w 302
    //   852: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   855: ldc 188
    //   857: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   860: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   863: ldc2_w 195
    //   866: ldc2_w 303
    //   869: lconst_1
    //   870: iconst_0
    //   871: invokeinterface 200 8 0
    //   876: goto -47 -> 829
    //   879: astore_1
    //   880: iload 5
    //   882: istore 4
    //   884: iload 4
    //   886: istore_3
    //   887: ldc 65
    //   889: aload_1
    //   890: ldc_w 308
    //   893: iconst_0
    //   894: anewarray 4	java/lang/Object
    //   897: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   900: iload 4
    //   902: istore_3
    //   903: ldc 188
    //   905: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   908: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   911: ldc2_w 195
    //   914: ldc2_w 309
    //   917: lconst_1
    //   918: iconst_0
    //   919: invokeinterface 200 8 0
    //   924: iload 4
    //   926: ifeq +38 -> 964
    //   929: ldc 65
    //   931: ldc_w 278
    //   934: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   937: ldc 188
    //   939: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   942: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   945: ldc2_w 195
    //   948: ldc2_w 279
    //   951: lconst_1
    //   952: iconst_0
    //   953: invokeinterface 200 8 0
    //   958: ldc 186
    //   960: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   963: return
    //   964: ldc 65
    //   966: ldc_w 302
    //   969: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   972: ldc 188
    //   974: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   977: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   980: ldc2_w 195
    //   983: ldc2_w 303
    //   986: lconst_1
    //   987: iconst_0
    //   988: invokeinterface 200 8 0
    //   993: goto -164 -> 829
    //   996: astore_1
    //   997: iload 6
    //   999: istore 4
    //   1001: iload 4
    //   1003: istore_3
    //   1004: ldc 65
    //   1006: aload_1
    //   1007: ldc_w 312
    //   1010: iconst_0
    //   1011: anewarray 4	java/lang/Object
    //   1014: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1017: iload 4
    //   1019: istore_3
    //   1020: ldc 188
    //   1022: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1025: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1028: ldc2_w 195
    //   1031: ldc2_w 313
    //   1034: lconst_1
    //   1035: iconst_0
    //   1036: invokeinterface 200 8 0
    //   1041: iload 4
    //   1043: ifeq +38 -> 1081
    //   1046: ldc 65
    //   1048: ldc_w 278
    //   1051: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1054: ldc 188
    //   1056: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1059: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1062: ldc2_w 195
    //   1065: ldc2_w 279
    //   1068: lconst_1
    //   1069: iconst_0
    //   1070: invokeinterface 200 8 0
    //   1075: ldc 186
    //   1077: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1080: return
    //   1081: ldc 65
    //   1083: ldc_w 302
    //   1086: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: ldc 188
    //   1091: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1094: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1097: ldc2_w 195
    //   1100: ldc2_w 303
    //   1103: lconst_1
    //   1104: iconst_0
    //   1105: invokeinterface 200 8 0
    //   1110: goto -281 -> 829
    //   1113: astore_1
    //   1114: iload 7
    //   1116: istore 4
    //   1118: iload 4
    //   1120: istore_3
    //   1121: ldc 65
    //   1123: aload_1
    //   1124: ldc_w 316
    //   1127: iconst_0
    //   1128: anewarray 4	java/lang/Object
    //   1131: invokestatic 73	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1134: iload 4
    //   1136: istore_3
    //   1137: ldc 188
    //   1139: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1142: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1145: ldc2_w 195
    //   1148: ldc2_w 317
    //   1151: lconst_1
    //   1152: iconst_0
    //   1153: invokeinterface 200 8 0
    //   1158: iload 4
    //   1160: ifeq +38 -> 1198
    //   1163: ldc 65
    //   1165: ldc_w 278
    //   1168: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1171: ldc 188
    //   1173: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1176: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1179: ldc2_w 195
    //   1182: ldc2_w 279
    //   1185: lconst_1
    //   1186: iconst_0
    //   1187: invokeinterface 200 8 0
    //   1192: ldc 186
    //   1194: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1197: return
    //   1198: ldc 65
    //   1200: ldc_w 302
    //   1203: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1206: ldc 188
    //   1208: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1211: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1214: ldc2_w 195
    //   1217: ldc2_w 303
    //   1220: lconst_1
    //   1221: iconst_0
    //   1222: invokeinterface 200 8 0
    //   1227: goto -398 -> 829
    //   1230: astore_1
    //   1231: iload_3
    //   1232: ifeq +38 -> 1270
    //   1235: ldc 65
    //   1237: ldc_w 278
    //   1240: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1243: ldc 188
    //   1245: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1248: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1251: ldc2_w 195
    //   1254: ldc2_w 279
    //   1257: lconst_1
    //   1258: iconst_0
    //   1259: invokeinterface 200 8 0
    //   1264: ldc 186
    //   1266: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1269: return
    //   1270: ldc 65
    //   1272: ldc_w 302
    //   1275: invokestatic 216	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1278: ldc 188
    //   1280: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1283: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1286: ldc2_w 195
    //   1289: ldc2_w 303
    //   1292: lconst_1
    //   1293: iconst_0
    //   1294: invokeinterface 200 8 0
    //   1299: ldc 186
    //   1301: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1304: aload_1
    //   1305: athrow
    //   1306: ldc 188
    //   1308: invokestatic 194	com/tencent/luggage/a/e:r	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1311: checkcast 188	com/tencent/mm/plugin/appbrand/o/a
    //   1314: ldc2_w 195
    //   1317: ldc2_w 319
    //   1320: lconst_1
    //   1321: iconst_0
    //   1322: invokeinterface 200 8 0
    //   1327: goto -498 -> 829
    //   1330: astore_1
    //   1331: goto -100 -> 1231
    //   1334: astore_1
    //   1335: iload_3
    //   1336: istore 4
    //   1338: goto -220 -> 1118
    //   1341: astore_1
    //   1342: iload_3
    //   1343: istore 4
    //   1345: goto -344 -> 1001
    //   1348: astore_1
    //   1349: iload_3
    //   1350: istore 4
    //   1352: goto -468 -> 884
    //   1355: astore_1
    //   1356: iload_3
    //   1357: istore 4
    //   1359: goto -840 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1362	0	this	n
    //   0	1362	1	paramArrayOfX509Certificate	X509Certificate[]
    //   0	1362	2	paramString	String
    //   61	1296	3	i	int
    //   384	974	4	j	int
    //   372	509	5	k	int
    //   375	623	6	m	int
    //   378	737	7	n	int
    //   381	353	8	i1	int
    //   58	627	9	localObject	Object
    //   82	48	10	localX509TrustManager1	X509TrustManager
    //   181	5	10	localCertificateException1	CertificateException
    //   254	23	10	localX509TrustManager2	X509TrustManager
    //   330	5	10	localCertificateException2	CertificateException
    //   697	5	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   84	118	181	java/security/cert/CertificateException
    //   256	265	330	java/security/cert/CertificateException
    //   389	396	518	java/security/KeyStoreException
    //   399	408	518	java/security/KeyStoreException
    //   411	420	518	java/security/KeyStoreException
    //   423	430	518	java/security/KeyStoreException
    //   433	444	518	java/security/KeyStoreException
    //   447	455	518	java/security/KeyStoreException
    //   458	467	518	java/security/KeyStoreException
    //   470	481	518	java/security/KeyStoreException
    //   489	500	518	java/security/KeyStoreException
    //   503	515	518	java/security/KeyStoreException
    //   602	614	518	java/security/KeyStoreException
    //   617	627	518	java/security/KeyStoreException
    //   725	733	518	java/security/KeyStoreException
    //   736	757	518	java/security/KeyStoreException
    //   680	692	697	java/lang/Exception
    //   389	396	879	java/security/NoSuchAlgorithmException
    //   399	408	879	java/security/NoSuchAlgorithmException
    //   411	420	879	java/security/NoSuchAlgorithmException
    //   423	430	879	java/security/NoSuchAlgorithmException
    //   433	444	879	java/security/NoSuchAlgorithmException
    //   447	455	879	java/security/NoSuchAlgorithmException
    //   458	467	879	java/security/NoSuchAlgorithmException
    //   470	481	879	java/security/NoSuchAlgorithmException
    //   489	500	879	java/security/NoSuchAlgorithmException
    //   503	515	879	java/security/NoSuchAlgorithmException
    //   602	614	879	java/security/NoSuchAlgorithmException
    //   617	627	879	java/security/NoSuchAlgorithmException
    //   725	733	879	java/security/NoSuchAlgorithmException
    //   736	757	879	java/security/NoSuchAlgorithmException
    //   389	396	996	java/io/IOException
    //   399	408	996	java/io/IOException
    //   411	420	996	java/io/IOException
    //   423	430	996	java/io/IOException
    //   433	444	996	java/io/IOException
    //   447	455	996	java/io/IOException
    //   458	467	996	java/io/IOException
    //   470	481	996	java/io/IOException
    //   489	500	996	java/io/IOException
    //   503	515	996	java/io/IOException
    //   602	614	996	java/io/IOException
    //   617	627	996	java/io/IOException
    //   725	733	996	java/io/IOException
    //   736	757	996	java/io/IOException
    //   389	396	1113	java/lang/Exception
    //   399	408	1113	java/lang/Exception
    //   411	420	1113	java/lang/Exception
    //   423	430	1113	java/lang/Exception
    //   433	444	1113	java/lang/Exception
    //   447	455	1113	java/lang/Exception
    //   458	467	1113	java/lang/Exception
    //   470	481	1113	java/lang/Exception
    //   489	500	1113	java/lang/Exception
    //   503	515	1113	java/lang/Exception
    //   602	614	1113	java/lang/Exception
    //   617	627	1113	java/lang/Exception
    //   725	733	1113	java/lang/Exception
    //   736	757	1113	java/lang/Exception
    //   389	396	1230	finally
    //   399	408	1230	finally
    //   411	420	1230	finally
    //   423	430	1230	finally
    //   433	444	1230	finally
    //   447	455	1230	finally
    //   458	467	1230	finally
    //   470	481	1230	finally
    //   489	500	1230	finally
    //   503	515	1230	finally
    //   522	535	1230	finally
    //   538	559	1230	finally
    //   602	614	1230	finally
    //   617	627	1230	finally
    //   725	733	1230	finally
    //   736	757	1230	finally
    //   887	900	1230	finally
    //   903	924	1230	finally
    //   1004	1017	1230	finally
    //   1020	1041	1230	finally
    //   1121	1134	1230	finally
    //   1137	1158	1230	finally
    //   632	666	1330	finally
    //   669	673	1330	finally
    //   680	692	1330	finally
    //   699	713	1330	finally
    //   632	666	1334	java/lang/Exception
    //   669	673	1334	java/lang/Exception
    //   699	713	1334	java/lang/Exception
    //   632	666	1341	java/io/IOException
    //   669	673	1341	java/io/IOException
    //   680	692	1341	java/io/IOException
    //   699	713	1341	java/io/IOException
    //   632	666	1348	java/security/NoSuchAlgorithmException
    //   669	673	1348	java/security/NoSuchAlgorithmException
    //   680	692	1348	java/security/NoSuchAlgorithmException
    //   699	713	1348	java/security/NoSuchAlgorithmException
    //   632	666	1355	java/security/KeyStoreException
    //   669	673	1355	java/security/KeyStoreException
    //   680	692	1355	java/security/KeyStoreException
    //   699	713	1355	java/security/KeyStoreException
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return this.itv;
  }
  
  public final void init()
  {
    AppMethodBeat.i(108255);
    aIr();
    aIs();
    aIt();
    AppMethodBeat.o(108255);
  }
  
  public final void x(InputStream paramInputStream)
  {
    AppMethodBeat.i(108254);
    if (this.itr == null)
    {
      ab.e("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
      AppMethodBeat.o(108254);
      return;
    }
    try
    {
      Object localObject1 = CertificateFactory.getInstance("X.509");
      try
      {
        localObject1 = ((CertificateFactory)localObject1).generateCertificate(paramInputStream);
        paramInputStream.close();
        this.itr.setCertificateEntry(((X509Certificate)localObject1).getSubjectDN(), (Certificate)localObject1);
        AppMethodBeat.o(108254);
        return;
      }
      finally
      {
        paramInputStream.close();
        AppMethodBeat.o(108254);
      }
      return;
    }
    catch (Exception paramInputStream)
    {
      ab.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", paramInputStream, "Exception: initLocalSelfSignedCertificate", new Object[0]);
      AppMethodBeat.o(108254);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.n
 * JD-Core Version:    0.7.0.1
 */