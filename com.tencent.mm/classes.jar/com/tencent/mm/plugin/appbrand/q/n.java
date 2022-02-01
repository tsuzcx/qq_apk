package com.tencent.mm.plugin.appbrand.q;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  private LinkedList<X509TrustManager> kVE;
  private LinkedList<X509TrustManager> kVF;
  private KeyStore kVG;
  private final boolean kVH;
  private List<String> kVI;
  private KeyStore kVJ;
  private X509Certificate[] kVK;
  
  public n(boolean paramBoolean)
  {
    AppMethodBeat.i(144434);
    this.kVI = null;
    this.kVJ = null;
    this.kVE = new LinkedList();
    this.kVF = new LinkedList();
    this.kVH = paramBoolean;
    try
    {
      this.kVG = KeyStore.getInstance(KeyStore.getDefaultType());
      this.kVG.load(null, null);
      AppMethodBeat.o(144434);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", localException, "Exception: Local KeyStore init failed", new Object[0]);
      AppMethodBeat.o(144434);
    }
  }
  
  private void biw()
  {
    AppMethodBeat.i(144439);
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int i = 0;
      while ((localObject != null) && (i < localObject.length))
      {
        this.kVE.add((X509TrustManager)localObject[i]);
        i += 1;
      }
      AppMethodBeat.o(144439);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", localException, "Exception: init SystemTrustManager", new Object[0]);
      AppMethodBeat.o(144439);
    }
  }
  
  private void bix()
  {
    AppMethodBeat.i(144440);
    if (this.kVG == null)
    {
      AppMethodBeat.o(144440);
      return;
    }
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init(this.kVG);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      int i = 0;
      while ((localObject != null) && (i < localObject.length))
      {
        this.kVF.add((X509TrustManager)localObject[i]);
        i += 1;
      }
      AppMethodBeat.o(144440);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", localException, "Exception: init LocalTrustManager", new Object[0]);
      AppMethodBeat.o(144440);
    }
  }
  
  private void biy()
  {
    AppMethodBeat.i(144441);
    ArrayList localArrayList = new ArrayList();
    long l1 = System.currentTimeMillis();
    Iterator localIterator = this.kVE.iterator();
    X509Certificate[] arrayOfX509Certificate;
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate = ((X509TrustManager)localIterator.next()).getAcceptedIssuers();
      if (arrayOfX509Certificate != null) {
        localArrayList.addAll(Arrays.asList(arrayOfX509Certificate));
      }
    }
    long l2 = System.currentTimeMillis();
    localIterator = this.kVF.iterator();
    while (localIterator.hasNext())
    {
      arrayOfX509Certificate = ((X509TrustManager)localIterator.next()).getAcceptedIssuers();
      if (arrayOfX509Certificate != null) {
        localArrayList.addAll(Arrays.asList(arrayOfX509Certificate));
      }
    }
    long l3 = System.currentTimeMillis();
    this.kVK = new X509Certificate[localArrayList.size()];
    this.kVK = ((X509Certificate[])localArrayList.toArray(this.kVK));
    ad.i("MicroMsg.AppBrandX509TrustManager", "initAcceptedIssuers: %d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l3 - l2), Long.valueOf(System.currentTimeMillis() - l3) });
    AppMethodBeat.o(144441);
  }
  
  public final void E(InputStream paramInputStream)
  {
    AppMethodBeat.i(144435);
    if (this.kVG == null)
    {
      ad.e("MicroMsg.AppBrandX509TrustManager", "local keystore is null");
      AppMethodBeat.o(144435);
      return;
    }
    try
    {
      Object localObject1 = CertificateFactory.getInstance("X.509");
      try
      {
        localObject1 = ((CertificateFactory)localObject1).generateCertificate(paramInputStream);
        paramInputStream.close();
        this.kVG.setCertificateEntry(((X509Certificate)localObject1).getSubjectDN(), (Certificate)localObject1);
        AppMethodBeat.o(144435);
        return;
      }
      finally
      {
        paramInputStream.close();
        AppMethodBeat.o(144435);
      }
      return;
    }
    catch (Exception paramInputStream)
    {
      ad.printErrStackTrace("MicroMsg.AppBrandX509TrustManager", paramInputStream, "Exception: initLocalSelfSignedCertificate", new Object[0]);
      AppMethodBeat.o(144435);
    }
  }
  
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    AppMethodBeat.i(144437);
    paramArrayOfX509Certificate = new CertificateException("Client Certification not supported");
    AppMethodBeat.o(144437);
    throw paramArrayOfX509Certificate;
  }
  
  /* Error */
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    // Byte code:
    //   0: ldc 231
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 233
    //   7: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   10: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   13: ldc2_w 240
    //   16: lconst_0
    //   17: lconst_1
    //   18: iconst_0
    //   19: invokeinterface 245 8 0
    //   24: ldc 68
    //   26: new 195	java/lang/StringBuilder
    //   29: dup
    //   30: ldc 247
    //   32: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 43	com/tencent/mm/plugin/appbrand/q/n:kVE	Ljava/util/LinkedList;
    //   39: invokevirtual 249	java/util/LinkedList:size	()I
    //   42: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_0
    //   52: getfield 43	com/tencent/mm/plugin/appbrand/q/n:kVE	Ljava/util/LinkedList;
    //   55: invokevirtual 120	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   58: astore 9
    //   60: iconst_0
    //   61: istore_3
    //   62: aload 9
    //   64: invokeinterface 126 1 0
    //   69: ifeq +78 -> 147
    //   72: aload 9
    //   74: invokeinterface 130 1 0
    //   79: checkcast 6	javax/net/ssl/X509TrustManager
    //   82: astore 10
    //   84: ldc 68
    //   86: new 195	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 256
    //   93: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload 10
    //   98: invokevirtual 257	java/lang/Object:toString	()Ljava/lang/String;
    //   101: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 10
    //   112: aload_1
    //   113: aload_2
    //   114: invokeinterface 262 3 0
    //   119: ldc 68
    //   121: new 195	java/lang/StringBuilder
    //   124: dup
    //   125: ldc_w 264
    //   128: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: aload 10
    //   133: invokevirtual 257	java/lang/Object:toString	()Ljava/lang/String;
    //   136: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: iconst_1
    //   146: istore_3
    //   147: iload_3
    //   148: ifeq +55 -> 203
    //   151: ldc 68
    //   153: ldc_w 266
    //   156: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: ldc 233
    //   161: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   164: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   167: ldc2_w 240
    //   170: lconst_1
    //   171: lconst_1
    //   172: iconst_0
    //   173: invokeinterface 245 8 0
    //   178: ldc 231
    //   180: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: return
    //   184: astore 10
    //   186: ldc 68
    //   188: aload 10
    //   190: ldc_w 268
    //   193: iconst_0
    //   194: anewarray 4	java/lang/Object
    //   197: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: goto -140 -> 60
    //   203: ldc 68
    //   205: ldc_w 270
    //   208: iconst_1
    //   209: anewarray 4	java/lang/Object
    //   212: dup
    //   213: iconst_0
    //   214: aload_0
    //   215: getfield 45	com/tencent/mm/plugin/appbrand/q/n:kVF	Ljava/util/LinkedList;
    //   218: invokevirtual 249	java/util/LinkedList:size	()I
    //   221: invokestatic 275	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   224: aastore
    //   225: invokestatic 168	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: aload_0
    //   229: getfield 45	com/tencent/mm/plugin/appbrand/q/n:kVF	Ljava/util/LinkedList;
    //   232: invokevirtual 120	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   235: astore 9
    //   237: iconst_0
    //   238: istore_3
    //   239: aload 9
    //   241: invokeinterface 126 1 0
    //   246: ifeq +52 -> 298
    //   249: aload 9
    //   251: invokeinterface 130 1 0
    //   256: checkcast 6	javax/net/ssl/X509TrustManager
    //   259: astore 10
    //   261: aload 10
    //   263: aload_1
    //   264: aload_2
    //   265: invokeinterface 262 3 0
    //   270: ldc 68
    //   272: new 195	java/lang/StringBuilder
    //   275: dup
    //   276: ldc_w 277
    //   279: invokespecial 248	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   282: aload 10
    //   284: invokevirtual 257	java/lang/Object:toString	()Ljava/lang/String;
    //   287: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: iconst_1
    //   297: istore_3
    //   298: iload_3
    //   299: ifeq +57 -> 356
    //   302: ldc 68
    //   304: ldc_w 279
    //   307: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: ldc 233
    //   312: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   315: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   318: ldc2_w 240
    //   321: ldc2_w 280
    //   324: lconst_1
    //   325: iconst_0
    //   326: invokeinterface 245 8 0
    //   331: ldc 231
    //   333: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: return
    //   337: astore 10
    //   339: ldc 68
    //   341: aload 10
    //   343: ldc_w 283
    //   346: iconst_0
    //   347: anewarray 4	java/lang/Object
    //   350: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: goto -116 -> 237
    //   356: aload_0
    //   357: getfield 47	com/tencent/mm/plugin/appbrand/q/n:kVH	Z
    //   360: ifeq +951 -> 1311
    //   363: ldc 68
    //   365: ldc_w 285
    //   368: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   390: getfield 38	com/tencent/mm/plugin/appbrand/q/n:kVJ	Ljava/security/KeyStore;
    //   393: ifnonnull +28 -> 421
    //   396: iload 8
    //   398: istore_3
    //   399: aload_0
    //   400: ldc_w 287
    //   403: invokestatic 57	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   406: putfield 38	com/tencent/mm/plugin/appbrand/q/n:kVJ	Ljava/security/KeyStore;
    //   409: iload 8
    //   411: istore_3
    //   412: aload_0
    //   413: getfield 38	com/tencent/mm/plugin/appbrand/q/n:kVJ	Ljava/security/KeyStore;
    //   416: aconst_null
    //   417: aconst_null
    //   418: invokevirtual 63	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   421: iload 8
    //   423: istore_3
    //   424: aload_0
    //   425: getfield 36	com/tencent/mm/plugin/appbrand/q/n:kVI	Ljava/util/List;
    //   428: ifnonnull +172 -> 600
    //   431: iload 8
    //   433: istore_3
    //   434: aload_0
    //   435: new 109	java/util/ArrayList
    //   438: dup
    //   439: invokespecial 110	java/util/ArrayList:<init>	()V
    //   442: putfield 36	com/tencent/mm/plugin/appbrand/q/n:kVI	Ljava/util/List;
    //   445: iload 8
    //   447: istore_3
    //   448: aload_0
    //   449: getfield 38	com/tencent/mm/plugin/appbrand/q/n:kVJ	Ljava/security/KeyStore;
    //   452: invokevirtual 291	java/security/KeyStore:aliases	()Ljava/util/Enumeration;
    //   455: astore_2
    //   456: iload 8
    //   458: istore_3
    //   459: aload_2
    //   460: invokeinterface 296 1 0
    //   465: ifeq +135 -> 600
    //   468: iload 8
    //   470: istore_3
    //   471: aload_2
    //   472: invokeinterface 299 1 0
    //   477: checkcast 301	java/lang/String
    //   480: astore 9
    //   482: aload 9
    //   484: ifnull -28 -> 456
    //   487: iload 8
    //   489: istore_3
    //   490: aload 9
    //   492: ldc_w 303
    //   495: invokevirtual 307	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   498: ifeq -42 -> 456
    //   501: iload 8
    //   503: istore_3
    //   504: aload_0
    //   505: getfield 36	com/tencent/mm/plugin/appbrand/q/n:kVI	Ljava/util/List;
    //   508: aload 9
    //   510: invokeinterface 310 2 0
    //   515: pop
    //   516: goto -60 -> 456
    //   519: astore_1
    //   520: iload 4
    //   522: istore_3
    //   523: ldc 68
    //   525: aload_1
    //   526: ldc_w 312
    //   529: iconst_0
    //   530: anewarray 4	java/lang/Object
    //   533: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   536: iload 4
    //   538: istore_3
    //   539: ldc 233
    //   541: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   544: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   547: ldc2_w 240
    //   550: ldc2_w 313
    //   553: lconst_1
    //   554: iconst_0
    //   555: invokeinterface 245 8 0
    //   560: iload 4
    //   562: ifeq +290 -> 852
    //   565: ldc 68
    //   567: ldc_w 316
    //   570: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: ldc 233
    //   575: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   578: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   581: ldc2_w 240
    //   584: ldc2_w 317
    //   587: lconst_1
    //   588: iconst_0
    //   589: invokeinterface 245 8 0
    //   594: ldc 231
    //   596: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   599: return
    //   600: iload 8
    //   602: istore_3
    //   603: aload_0
    //   604: getfield 36	com/tencent/mm/plugin/appbrand/q/n:kVI	Ljava/util/List;
    //   607: invokeinterface 319 1 0
    //   612: ifle +115 -> 727
    //   615: iload 8
    //   617: istore_3
    //   618: aload_0
    //   619: getfield 36	com/tencent/mm/plugin/appbrand/q/n:kVI	Ljava/util/List;
    //   622: invokeinterface 320 1 0
    //   627: astore_2
    //   628: iconst_0
    //   629: istore_3
    //   630: iload_3
    //   631: istore 4
    //   633: aload_2
    //   634: invokeinterface 126 1 0
    //   639: ifeq +126 -> 765
    //   642: aload_2
    //   643: invokeinterface 130 1 0
    //   648: checkcast 301	java/lang/String
    //   651: astore 9
    //   653: aload_0
    //   654: getfield 38	com/tencent/mm/plugin/appbrand/q/n:kVJ	Ljava/security/KeyStore;
    //   657: aload 9
    //   659: invokevirtual 324	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   662: checkcast 150	java/security/cert/X509Certificate
    //   665: astore 9
    //   667: aload_1
    //   668: arraylength
    //   669: istore 5
    //   671: iconst_0
    //   672: istore 4
    //   674: iload 4
    //   676: iload 5
    //   678: if_icmpge -48 -> 630
    //   681: aload_1
    //   682: iload 4
    //   684: aaload
    //   685: astore 10
    //   687: aload 10
    //   689: aload 9
    //   691: invokevirtual 328	java/security/cert/X509Certificate:getPublicKey	()Ljava/security/PublicKey;
    //   694: invokevirtual 332	java/security/cert/X509Certificate:verify	(Ljava/security/PublicKey;)V
    //   697: iconst_1
    //   698: istore_3
    //   699: goto -69 -> 630
    //   702: astore 10
    //   704: ldc 68
    //   706: aload 10
    //   708: ldc_w 334
    //   711: iconst_0
    //   712: anewarray 4	java/lang/Object
    //   715: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   718: iload 4
    //   720: iconst_1
    //   721: iadd
    //   722: istore 4
    //   724: goto -50 -> 674
    //   727: iload 8
    //   729: istore_3
    //   730: ldc 68
    //   732: ldc_w 336
    //   735: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   738: iload 8
    //   740: istore_3
    //   741: ldc 233
    //   743: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   746: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   749: ldc2_w 240
    //   752: ldc2_w 337
    //   755: lconst_1
    //   756: iconst_0
    //   757: invokeinterface 245 8 0
    //   762: iconst_0
    //   763: istore 4
    //   765: iload 4
    //   767: ifeq +38 -> 805
    //   770: ldc 68
    //   772: ldc_w 316
    //   775: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   778: ldc 233
    //   780: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   783: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   786: ldc2_w 240
    //   789: ldc2_w 317
    //   792: lconst_1
    //   793: iconst_0
    //   794: invokeinterface 245 8 0
    //   799: ldc 231
    //   801: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   804: return
    //   805: ldc 68
    //   807: ldc_w 340
    //   810: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: ldc 233
    //   815: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   818: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   821: ldc2_w 240
    //   824: ldc2_w 341
    //   827: lconst_1
    //   828: iconst_0
    //   829: invokeinterface 245 8 0
    //   834: new 218	java/security/cert/CertificateException
    //   837: dup
    //   838: ldc_w 344
    //   841: invokespecial 223	java/security/cert/CertificateException:<init>	(Ljava/lang/String;)V
    //   844: astore_1
    //   845: ldc 231
    //   847: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   850: aload_1
    //   851: athrow
    //   852: ldc 68
    //   854: ldc_w 340
    //   857: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: ldc 233
    //   862: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   865: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   868: ldc2_w 240
    //   871: ldc2_w 341
    //   874: lconst_1
    //   875: iconst_0
    //   876: invokeinterface 245 8 0
    //   881: goto -47 -> 834
    //   884: astore_1
    //   885: iload 5
    //   887: istore 4
    //   889: iload 4
    //   891: istore_3
    //   892: ldc 68
    //   894: aload_1
    //   895: ldc_w 346
    //   898: iconst_0
    //   899: anewarray 4	java/lang/Object
    //   902: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   905: iload 4
    //   907: istore_3
    //   908: ldc 233
    //   910: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   913: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   916: ldc2_w 240
    //   919: ldc2_w 347
    //   922: lconst_1
    //   923: iconst_0
    //   924: invokeinterface 245 8 0
    //   929: iload 4
    //   931: ifeq +38 -> 969
    //   934: ldc 68
    //   936: ldc_w 316
    //   939: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   942: ldc 233
    //   944: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   947: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   950: ldc2_w 240
    //   953: ldc2_w 317
    //   956: lconst_1
    //   957: iconst_0
    //   958: invokeinterface 245 8 0
    //   963: ldc 231
    //   965: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   968: return
    //   969: ldc 68
    //   971: ldc_w 340
    //   974: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   977: ldc 233
    //   979: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   982: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   985: ldc2_w 240
    //   988: ldc2_w 341
    //   991: lconst_1
    //   992: iconst_0
    //   993: invokeinterface 245 8 0
    //   998: goto -164 -> 834
    //   1001: astore_1
    //   1002: iload 6
    //   1004: istore 4
    //   1006: iload 4
    //   1008: istore_3
    //   1009: ldc 68
    //   1011: aload_1
    //   1012: ldc_w 350
    //   1015: iconst_0
    //   1016: anewarray 4	java/lang/Object
    //   1019: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1022: iload 4
    //   1024: istore_3
    //   1025: ldc 233
    //   1027: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1030: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1033: ldc2_w 240
    //   1036: ldc2_w 351
    //   1039: lconst_1
    //   1040: iconst_0
    //   1041: invokeinterface 245 8 0
    //   1046: iload 4
    //   1048: ifeq +38 -> 1086
    //   1051: ldc 68
    //   1053: ldc_w 316
    //   1056: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1059: ldc 233
    //   1061: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1064: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1067: ldc2_w 240
    //   1070: ldc2_w 317
    //   1073: lconst_1
    //   1074: iconst_0
    //   1075: invokeinterface 245 8 0
    //   1080: ldc 231
    //   1082: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1085: return
    //   1086: ldc 68
    //   1088: ldc_w 340
    //   1091: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1094: ldc 233
    //   1096: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1099: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1102: ldc2_w 240
    //   1105: ldc2_w 341
    //   1108: lconst_1
    //   1109: iconst_0
    //   1110: invokeinterface 245 8 0
    //   1115: goto -281 -> 834
    //   1118: astore_1
    //   1119: iload 7
    //   1121: istore 4
    //   1123: iload 4
    //   1125: istore_3
    //   1126: ldc 68
    //   1128: aload_1
    //   1129: ldc_w 354
    //   1132: iconst_0
    //   1133: anewarray 4	java/lang/Object
    //   1136: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1139: iload 4
    //   1141: istore_3
    //   1142: ldc 233
    //   1144: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1147: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1150: ldc2_w 240
    //   1153: ldc2_w 355
    //   1156: lconst_1
    //   1157: iconst_0
    //   1158: invokeinterface 245 8 0
    //   1163: iload 4
    //   1165: ifeq +38 -> 1203
    //   1168: ldc 68
    //   1170: ldc_w 316
    //   1173: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1176: ldc 233
    //   1178: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1181: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1184: ldc2_w 240
    //   1187: ldc2_w 317
    //   1190: lconst_1
    //   1191: iconst_0
    //   1192: invokeinterface 245 8 0
    //   1197: ldc 231
    //   1199: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1202: return
    //   1203: ldc 68
    //   1205: ldc_w 340
    //   1208: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1211: ldc 233
    //   1213: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1216: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1219: ldc2_w 240
    //   1222: ldc2_w 341
    //   1225: lconst_1
    //   1226: iconst_0
    //   1227: invokeinterface 245 8 0
    //   1232: goto -398 -> 834
    //   1235: astore_1
    //   1236: iload_3
    //   1237: ifeq +38 -> 1275
    //   1240: ldc 68
    //   1242: ldc_w 316
    //   1245: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1248: ldc 233
    //   1250: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1253: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1256: ldc2_w 240
    //   1259: ldc2_w 317
    //   1262: lconst_1
    //   1263: iconst_0
    //   1264: invokeinterface 245 8 0
    //   1269: ldc 231
    //   1271: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1274: return
    //   1275: ldc 68
    //   1277: ldc_w 340
    //   1280: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1283: ldc 233
    //   1285: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1288: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1291: ldc2_w 240
    //   1294: ldc2_w 341
    //   1297: lconst_1
    //   1298: iconst_0
    //   1299: invokeinterface 245 8 0
    //   1304: ldc 231
    //   1306: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1309: aload_1
    //   1310: athrow
    //   1311: ldc 233
    //   1313: invokestatic 239	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1316: checkcast 233	com/tencent/mm/plugin/appbrand/u/a
    //   1319: ldc2_w 240
    //   1322: ldc2_w 357
    //   1325: lconst_1
    //   1326: iconst_0
    //   1327: invokeinterface 245 8 0
    //   1332: goto -498 -> 834
    //   1335: astore_1
    //   1336: goto -100 -> 1236
    //   1339: astore_1
    //   1340: iload_3
    //   1341: istore 4
    //   1343: goto -220 -> 1123
    //   1346: astore_1
    //   1347: iload_3
    //   1348: istore 4
    //   1350: goto -344 -> 1006
    //   1353: astore_1
    //   1354: iload_3
    //   1355: istore 4
    //   1357: goto -468 -> 889
    //   1360: astore_1
    //   1361: iload_3
    //   1362: istore 4
    //   1364: goto -844 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1367	0	this	n
    //   0	1367	1	paramArrayOfX509Certificate	X509Certificate[]
    //   0	1367	2	paramString	String
    //   61	1301	3	i	int
    //   384	979	4	j	int
    //   372	514	5	k	int
    //   375	628	6	m	int
    //   378	742	7	n	int
    //   381	358	8	i1	int
    //   58	632	9	localObject	Object
    //   82	50	10	localX509TrustManager1	X509TrustManager
    //   184	5	10	localCertificateException1	CertificateException
    //   259	24	10	localX509TrustManager2	X509TrustManager
    //   337	5	10	localCertificateException2	CertificateException
    //   685	3	10	localX509Certificate	X509Certificate
    //   702	5	10	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   84	119	184	java/security/cert/CertificateException
    //   261	270	337	java/security/cert/CertificateException
    //   389	396	519	java/security/KeyStoreException
    //   399	409	519	java/security/KeyStoreException
    //   412	421	519	java/security/KeyStoreException
    //   424	431	519	java/security/KeyStoreException
    //   434	445	519	java/security/KeyStoreException
    //   448	456	519	java/security/KeyStoreException
    //   459	468	519	java/security/KeyStoreException
    //   471	482	519	java/security/KeyStoreException
    //   490	501	519	java/security/KeyStoreException
    //   504	516	519	java/security/KeyStoreException
    //   603	615	519	java/security/KeyStoreException
    //   618	628	519	java/security/KeyStoreException
    //   730	738	519	java/security/KeyStoreException
    //   741	762	519	java/security/KeyStoreException
    //   687	697	702	java/lang/Exception
    //   389	396	884	java/security/NoSuchAlgorithmException
    //   399	409	884	java/security/NoSuchAlgorithmException
    //   412	421	884	java/security/NoSuchAlgorithmException
    //   424	431	884	java/security/NoSuchAlgorithmException
    //   434	445	884	java/security/NoSuchAlgorithmException
    //   448	456	884	java/security/NoSuchAlgorithmException
    //   459	468	884	java/security/NoSuchAlgorithmException
    //   471	482	884	java/security/NoSuchAlgorithmException
    //   490	501	884	java/security/NoSuchAlgorithmException
    //   504	516	884	java/security/NoSuchAlgorithmException
    //   603	615	884	java/security/NoSuchAlgorithmException
    //   618	628	884	java/security/NoSuchAlgorithmException
    //   730	738	884	java/security/NoSuchAlgorithmException
    //   741	762	884	java/security/NoSuchAlgorithmException
    //   389	396	1001	java/io/IOException
    //   399	409	1001	java/io/IOException
    //   412	421	1001	java/io/IOException
    //   424	431	1001	java/io/IOException
    //   434	445	1001	java/io/IOException
    //   448	456	1001	java/io/IOException
    //   459	468	1001	java/io/IOException
    //   471	482	1001	java/io/IOException
    //   490	501	1001	java/io/IOException
    //   504	516	1001	java/io/IOException
    //   603	615	1001	java/io/IOException
    //   618	628	1001	java/io/IOException
    //   730	738	1001	java/io/IOException
    //   741	762	1001	java/io/IOException
    //   389	396	1118	java/lang/Exception
    //   399	409	1118	java/lang/Exception
    //   412	421	1118	java/lang/Exception
    //   424	431	1118	java/lang/Exception
    //   434	445	1118	java/lang/Exception
    //   448	456	1118	java/lang/Exception
    //   459	468	1118	java/lang/Exception
    //   471	482	1118	java/lang/Exception
    //   490	501	1118	java/lang/Exception
    //   504	516	1118	java/lang/Exception
    //   603	615	1118	java/lang/Exception
    //   618	628	1118	java/lang/Exception
    //   730	738	1118	java/lang/Exception
    //   741	762	1118	java/lang/Exception
    //   389	396	1235	finally
    //   399	409	1235	finally
    //   412	421	1235	finally
    //   424	431	1235	finally
    //   434	445	1235	finally
    //   448	456	1235	finally
    //   459	468	1235	finally
    //   471	482	1235	finally
    //   490	501	1235	finally
    //   504	516	1235	finally
    //   523	536	1235	finally
    //   539	560	1235	finally
    //   603	615	1235	finally
    //   618	628	1235	finally
    //   730	738	1235	finally
    //   741	762	1235	finally
    //   892	905	1235	finally
    //   908	929	1235	finally
    //   1009	1022	1235	finally
    //   1025	1046	1235	finally
    //   1126	1139	1235	finally
    //   1142	1163	1235	finally
    //   633	671	1335	finally
    //   687	697	1335	finally
    //   704	718	1335	finally
    //   633	671	1339	java/lang/Exception
    //   704	718	1339	java/lang/Exception
    //   633	671	1346	java/io/IOException
    //   687	697	1346	java/io/IOException
    //   704	718	1346	java/io/IOException
    //   633	671	1353	java/security/NoSuchAlgorithmException
    //   687	697	1353	java/security/NoSuchAlgorithmException
    //   704	718	1353	java/security/NoSuchAlgorithmException
    //   633	671	1360	java/security/KeyStoreException
    //   687	697	1360	java/security/KeyStoreException
    //   704	718	1360	java/security/KeyStoreException
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return this.kVK;
  }
  
  public final void init()
  {
    AppMethodBeat.i(144436);
    long l = bt.eGO();
    biw();
    bix();
    biy();
    ad.d("MicroMsg.AppBrandX509TrustManager", "init() cost[%dms]", new Object[] { Long.valueOf(bt.eGO() - l) });
    AppMethodBeat.o(144436);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.n
 * JD-Core Version:    0.7.0.1
 */