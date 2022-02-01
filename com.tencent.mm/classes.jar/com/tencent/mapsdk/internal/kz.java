package com.tencent.mapsdk.internal;

import android.os.Build.VERSION;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.processor.Processor;
import com.tencent.map.tools.net.processor.RequestProcessor;
import com.tencent.map.tools.net.processor.ResponseProcessor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class kz
  extends ky
{
  private static final String b = "URLNetImpl";
  private static final boolean c = false;
  private HttpURLConnection d;
  
  private static void a(NetResponse paramNetResponse)
  {
    AppMethodBeat.i(222234);
    Object localObject = Arrays.asList(paramNetResponse.getProcessors().toArray(new Processor[0]));
    Collections.reverse((List)localObject);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Processor localProcessor = (Processor)((Iterator)localObject).next();
      if ((localProcessor instanceof ResponseProcessor)) {
        ((ResponseProcessor)localProcessor).onResponse(paramNetResponse);
      }
    }
    AppMethodBeat.o(222234);
  }
  
  private static void b()
  {
    AppMethodBeat.i(222202);
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    AppMethodBeat.o(222202);
  }
  
  /* Error */
  private NetResponse c(NetRequest paramNetRequest)
  {
    // Byte code:
    //   0: ldc 116
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: getfield 122	com/tencent/map/tools/net/NetRequest:processors	Ljava/util/Set;
    //   9: invokeinterface 123 1 0
    //   14: astore 5
    //   16: aload 5
    //   18: invokeinterface 72 1 0
    //   23: ifeq +39 -> 62
    //   26: aload 5
    //   28: invokeinterface 76 1 0
    //   33: checkcast 42	com/tencent/map/tools/net/processor/Processor
    //   36: astore 6
    //   38: aload 6
    //   40: instanceof 125
    //   43: ifeq -27 -> 16
    //   46: aload 6
    //   48: checkcast 125	com/tencent/map/tools/net/processor/RequestProcessor
    //   51: aload_1
    //   52: invokeinterface 129 2 0
    //   57: goto -41 -> 16
    //   60: astore 5
    //   62: new 36	com/tencent/map/tools/net/NetResponse
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 131	com/tencent/map/tools/net/NetResponse:<init>	(Lcom/tencent/map/tools/net/NetRequest;)V
    //   70: astore 14
    //   72: aload_1
    //   73: getfield 134	com/tencent/map/tools/net/NetRequest:url	Ljava/lang/String;
    //   76: astore 5
    //   78: aload_1
    //   79: getfield 138	com/tencent/map/tools/net/NetRequest:retryMethod	I
    //   82: istore_2
    //   83: aload_1
    //   84: getfield 141	com/tencent/map/tools/net/NetRequest:timeout	I
    //   87: istore 4
    //   89: aload_1
    //   90: getfield 145	com/tencent/map/tools/net/NetRequest:postData	[B
    //   93: astore 15
    //   95: aload_1
    //   96: getfield 149	com/tencent/map/tools/net/NetRequest:mapHeaders	Ljava/util/Map;
    //   99: astore 16
    //   101: aload_1
    //   102: getfield 153	com/tencent/map/tools/net/NetRequest:canceler	Lcom/tencent/map/tools/net/http/HttpCanceler;
    //   105: astore 17
    //   107: aload_1
    //   108: getfield 157	com/tencent/map/tools/net/NetRequest:proxy	Lcom/tencent/map/tools/net/http/HttpProxy;
    //   111: astore 18
    //   113: aload_1
    //   114: getfield 160	com/tencent/map/tools/net/NetRequest:respHeaders	Ljava/util/Set;
    //   117: astore 19
    //   119: new 162	java/net/URL
    //   122: dup
    //   123: aload 5
    //   125: invokespecial 165	java/net/URL:<init>	(Ljava/lang/String;)V
    //   128: astore 5
    //   130: aload 18
    //   132: invokestatic 171	com/tencent/map/tools/net/http/HttpProxy:getProxyURL	(Lcom/tencent/map/tools/net/http/HttpProxy;)Ljava/net/URL;
    //   135: astore 6
    //   137: aload 6
    //   139: ifnull +965 -> 1104
    //   142: aload 6
    //   144: astore 5
    //   146: aload 5
    //   148: astore 9
    //   150: aload 9
    //   152: ifnull +886 -> 1038
    //   155: new 8	com/tencent/mapsdk/internal/kz$a
    //   158: dup
    //   159: iload_2
    //   160: invokespecial 173	com/tencent/mapsdk/internal/kz$a:<init>	(I)V
    //   163: astore 20
    //   165: aload 20
    //   167: getfield 175	com/tencent/mapsdk/internal/kz$a:b	Z
    //   170: ifeq +419 -> 589
    //   173: aload 20
    //   175: getfield 177	com/tencent/mapsdk/internal/kz$a:a	I
    //   178: ifle +411 -> 589
    //   181: iconst_1
    //   182: istore_2
    //   183: iload_2
    //   184: ifeq +854 -> 1038
    //   187: aconst_null
    //   188: astore 11
    //   190: aconst_null
    //   191: astore 12
    //   193: aconst_null
    //   194: astore 13
    //   196: aconst_null
    //   197: astore 10
    //   199: iconst_0
    //   200: istore_3
    //   201: aload 10
    //   203: astore 8
    //   205: aload 12
    //   207: astore 6
    //   209: aload 13
    //   211: astore 7
    //   213: aload 9
    //   215: aload 18
    //   217: invokestatic 181	com/tencent/map/tools/net/http/HttpProxy:getForwardProxy	(Lcom/tencent/map/tools/net/http/HttpProxy;)Ljava/net/Proxy;
    //   220: invokevirtual 185	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   223: checkcast 187	java/net/HttpURLConnection
    //   226: astore 21
    //   228: aload 10
    //   230: astore 8
    //   232: aload 12
    //   234: astore 6
    //   236: aload 13
    //   238: astore 7
    //   240: aload 21
    //   242: aload_1
    //   243: getfield 191	com/tencent/map/tools/net/NetRequest:mNetMethod	Lcom/tencent/map/tools/net/NetMethod;
    //   246: invokevirtual 197	com/tencent/map/tools/net/NetMethod:name	()Ljava/lang/String;
    //   249: invokevirtual 200	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   252: aload 10
    //   254: astore 8
    //   256: aload 12
    //   258: astore 6
    //   260: aload 13
    //   262: astore 7
    //   264: aload 21
    //   266: iconst_0
    //   267: invokevirtual 204	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   270: iload 4
    //   272: ifle +41 -> 313
    //   275: aload 10
    //   277: astore 8
    //   279: aload 12
    //   281: astore 6
    //   283: aload 13
    //   285: astore 7
    //   287: aload 21
    //   289: iload 4
    //   291: invokevirtual 207	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   294: aload 10
    //   296: astore 8
    //   298: aload 12
    //   300: astore 6
    //   302: aload 13
    //   304: astore 7
    //   306: aload 21
    //   308: iload 4
    //   310: invokevirtual 210	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   313: aload 10
    //   315: astore 8
    //   317: aload 12
    //   319: astore 6
    //   321: aload 13
    //   323: astore 7
    //   325: aload 16
    //   327: invokeinterface 215 1 0
    //   332: ifne +262 -> 594
    //   335: aload 10
    //   337: astore 8
    //   339: aload 12
    //   341: astore 6
    //   343: aload 13
    //   345: astore 7
    //   347: aload 16
    //   349: invokeinterface 218 1 0
    //   354: invokeinterface 123 1 0
    //   359: astore 5
    //   361: aload 10
    //   363: astore 8
    //   365: aload 12
    //   367: astore 6
    //   369: aload 13
    //   371: astore 7
    //   373: aload 5
    //   375: invokeinterface 72 1 0
    //   380: ifeq +214 -> 594
    //   383: aload 10
    //   385: astore 8
    //   387: aload 12
    //   389: astore 6
    //   391: aload 13
    //   393: astore 7
    //   395: aload 5
    //   397: invokeinterface 76 1 0
    //   402: checkcast 220	java/util/Map$Entry
    //   405: astore 23
    //   407: aload 10
    //   409: astore 8
    //   411: aload 12
    //   413: astore 6
    //   415: aload 13
    //   417: astore 7
    //   419: aload 23
    //   421: invokeinterface 223 1 0
    //   426: checkcast 225	java/lang/String
    //   429: astore 22
    //   431: aload 10
    //   433: astore 8
    //   435: aload 12
    //   437: astore 6
    //   439: aload 13
    //   441: astore 7
    //   443: aload 23
    //   445: invokeinterface 228 1 0
    //   450: checkcast 225	java/lang/String
    //   453: astore 23
    //   455: aload 10
    //   457: astore 8
    //   459: aload 12
    //   461: astore 6
    //   463: aload 13
    //   465: astore 7
    //   467: aload 22
    //   469: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   472: ifne -111 -> 361
    //   475: aload 10
    //   477: astore 8
    //   479: aload 12
    //   481: astore 6
    //   483: aload 13
    //   485: astore 7
    //   487: aload 23
    //   489: invokestatic 233	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   492: ifne -131 -> 361
    //   495: aload 10
    //   497: astore 8
    //   499: aload 12
    //   501: astore 6
    //   503: aload 13
    //   505: astore 7
    //   507: aload 21
    //   509: aload 22
    //   511: aload 23
    //   513: invokevirtual 237	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: goto -155 -> 361
    //   519: astore 7
    //   521: iconst_0
    //   522: istore_2
    //   523: aload 8
    //   525: astore 5
    //   527: aload 5
    //   529: astore 6
    //   531: aload 14
    //   533: aload 7
    //   535: invokevirtual 241	com/tencent/map/tools/net/NetResponse:exception	(Ljava/lang/Exception;)V
    //   538: aload 5
    //   540: astore 6
    //   542: aload 14
    //   544: iload_2
    //   545: putfield 244	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   548: aload 5
    //   550: astore 6
    //   552: aload 20
    //   554: invokevirtual 246	com/tencent/mapsdk/internal/kz$a:a	()V
    //   557: aload 14
    //   559: invokestatic 248	com/tencent/mapsdk/internal/kz:a	(Lcom/tencent/map/tools/net/NetResponse;)V
    //   562: aload 5
    //   564: invokestatic 254	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   567: goto -402 -> 165
    //   570: astore 6
    //   572: aconst_null
    //   573: astore 5
    //   575: aload 14
    //   577: aload 6
    //   579: invokevirtual 241	com/tencent/map/tools/net/NetResponse:exception	(Ljava/lang/Exception;)V
    //   582: aload 5
    //   584: astore 9
    //   586: goto -436 -> 150
    //   589: iconst_0
    //   590: istore_2
    //   591: goto -408 -> 183
    //   594: aload 17
    //   596: ifnull +49 -> 645
    //   599: aload 10
    //   601: astore 8
    //   603: aload 12
    //   605: astore 6
    //   607: aload 13
    //   609: astore 7
    //   611: aload 17
    //   613: aload_0
    //   614: new 6	com/tencent/mapsdk/internal/kz$1
    //   617: dup
    //   618: aload_0
    //   619: aload 20
    //   621: invokespecial 257	com/tencent/mapsdk/internal/kz$1:<init>	(Lcom/tencent/mapsdk/internal/kz;Lcom/tencent/mapsdk/internal/kz$a;)V
    //   624: invokevirtual 263	com/tencent/map/tools/net/http/HttpCanceler:setHttpAccessRequest	(Lcom/tencent/map/tools/net/NetAdapter;Lcom/tencent/map/tools/Callback;)V
    //   627: aload 10
    //   629: astore 8
    //   631: aload 12
    //   633: astore 6
    //   635: aload 13
    //   637: astore 7
    //   639: aload_0
    //   640: aload 21
    //   642: putfield 26	com/tencent/mapsdk/internal/kz:d	Ljava/net/HttpURLConnection;
    //   645: aload 11
    //   647: astore 5
    //   649: aload 15
    //   651: ifnull +69 -> 720
    //   654: aload 10
    //   656: astore 8
    //   658: aload 11
    //   660: astore 5
    //   662: aload 12
    //   664: astore 6
    //   666: aload 13
    //   668: astore 7
    //   670: aload 15
    //   672: arraylength
    //   673: ifle +47 -> 720
    //   676: aload 10
    //   678: astore 8
    //   680: aload 12
    //   682: astore 6
    //   684: aload 13
    //   686: astore 7
    //   688: aload 21
    //   690: iconst_1
    //   691: invokevirtual 266	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   694: aload 10
    //   696: astore 8
    //   698: aload 12
    //   700: astore 6
    //   702: aload 13
    //   704: astore 7
    //   706: aload 21
    //   708: invokevirtual 270	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   711: astore 5
    //   713: aload 15
    //   715: aload 5
    //   717: invokestatic 274	com/tencent/map/tools/net/NetUtil:writeBytesWithoutClose	([BLjava/io/OutputStream;)V
    //   720: aload 5
    //   722: astore 8
    //   724: aload 5
    //   726: astore 6
    //   728: aload 5
    //   730: astore 7
    //   732: aload 21
    //   734: invokevirtual 277	java/net/HttpURLConnection:connect	()V
    //   737: aload 5
    //   739: astore 8
    //   741: aload 5
    //   743: astore 6
    //   745: aload 5
    //   747: astore 7
    //   749: aload 21
    //   751: invokevirtual 281	java/net/HttpURLConnection:getResponseCode	()I
    //   754: istore_2
    //   755: aload 5
    //   757: astore 6
    //   759: aload 14
    //   761: iload_2
    //   762: putfield 244	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   765: aload 5
    //   767: astore 6
    //   769: aload 14
    //   771: aload 21
    //   773: invokevirtual 284	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   776: invokestatic 287	com/tencent/mapsdk/internal/kz:a	(Ljava/lang/String;)Ljava/lang/String;
    //   779: putfield 290	com/tencent/map/tools/net/NetResponse:charset	Ljava/lang/String;
    //   782: aload 5
    //   784: astore 6
    //   786: aload 19
    //   788: invokeinterface 291 1 0
    //   793: ifne +81 -> 874
    //   796: aload 5
    //   798: astore 6
    //   800: aload 19
    //   802: invokeinterface 123 1 0
    //   807: astore 7
    //   809: aload 5
    //   811: astore 6
    //   813: aload 7
    //   815: invokeinterface 72 1 0
    //   820: ifeq +54 -> 874
    //   823: aload 5
    //   825: astore 6
    //   827: aload 7
    //   829: invokeinterface 76 1 0
    //   834: checkcast 225	java/lang/String
    //   837: astore 8
    //   839: aload 5
    //   841: astore 6
    //   843: aload 21
    //   845: aload 8
    //   847: invokevirtual 294	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   850: astore 10
    //   852: aload 5
    //   854: astore 6
    //   856: aload 14
    //   858: getfield 297	com/tencent/map/tools/net/NetResponse:respHeads	Ljava/util/Map;
    //   861: aload 8
    //   863: aload 10
    //   865: invokeinterface 301 3 0
    //   870: pop
    //   871: goto -62 -> 809
    //   874: iload_2
    //   875: sipush 200
    //   878: if_icmpne +68 -> 946
    //   881: aload 5
    //   883: astore 6
    //   885: aload 14
    //   887: iconst_0
    //   888: putfield 304	com/tencent/map/tools/net/NetResponse:errorCode	I
    //   891: aload 5
    //   893: astore 6
    //   895: aload 14
    //   897: aload 21
    //   899: invokevirtual 307	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   902: putfield 310	com/tencent/map/tools/net/NetResponse:contentEncoding	Ljava/lang/String;
    //   905: aload 5
    //   907: astore 6
    //   909: aload 14
    //   911: new 312	com/tencent/map/tools/net/http/HttpConnectionInputStream
    //   914: dup
    //   915: aload 21
    //   917: invokespecial 315	com/tencent/map/tools/net/http/HttpConnectionInputStream:<init>	(Ljava/net/HttpURLConnection;)V
    //   920: putfield 319	com/tencent/map/tools/net/NetResponse:dataStream	Ljava/io/InputStream;
    //   923: aload 5
    //   925: astore 6
    //   927: aload 20
    //   929: iconst_0
    //   930: putfield 175	com/tencent/mapsdk/internal/kz$a:b	Z
    //   933: aload 14
    //   935: invokestatic 248	com/tencent/mapsdk/internal/kz:a	(Lcom/tencent/map/tools/net/NetResponse;)V
    //   938: aload 5
    //   940: invokestatic 254	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   943: goto -778 -> 165
    //   946: aload 5
    //   948: astore 6
    //   950: aload 14
    //   952: aload 21
    //   954: invokevirtual 323	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   957: invokestatic 327	com/tencent/map/tools/net/NetUtil:toBytesThrow	(Ljava/io/InputStream;)[B
    //   960: putfield 330	com/tencent/map/tools/net/NetResponse:errorData	[B
    //   963: aload 5
    //   965: astore 6
    //   967: aload 20
    //   969: invokevirtual 246	com/tencent/mapsdk/internal/kz$a:a	()V
    //   972: goto -39 -> 933
    //   975: astore 8
    //   977: aload 5
    //   979: astore 6
    //   981: aload 14
    //   983: aload 8
    //   985: invokevirtual 241	com/tencent/map/tools/net/NetResponse:exception	(Ljava/lang/Exception;)V
    //   988: aload 5
    //   990: astore 6
    //   992: aload 14
    //   994: iload_2
    //   995: putfield 244	com/tencent/map/tools/net/NetResponse:statusCode	I
    //   998: aload 5
    //   1000: astore 6
    //   1002: aload 20
    //   1004: invokevirtual 246	com/tencent/mapsdk/internal/kz$a:a	()V
    //   1007: aload 14
    //   1009: invokestatic 248	com/tencent/mapsdk/internal/kz:a	(Lcom/tencent/map/tools/net/NetResponse;)V
    //   1012: aload 5
    //   1014: invokestatic 254	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   1017: goto -852 -> 165
    //   1020: astore_1
    //   1021: aload 14
    //   1023: invokestatic 248	com/tencent/mapsdk/internal/kz:a	(Lcom/tencent/map/tools/net/NetResponse;)V
    //   1026: aload 6
    //   1028: invokestatic 254	com/tencent/map/tools/net/NetUtil:safeClose	(Ljava/io/Closeable;)V
    //   1031: ldc 116
    //   1033: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1036: aload_1
    //   1037: athrow
    //   1038: ldc 116
    //   1040: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1043: aload 14
    //   1045: areturn
    //   1046: astore 6
    //   1048: goto -110 -> 938
    //   1051: astore 6
    //   1053: goto -491 -> 562
    //   1056: astore 6
    //   1058: goto -46 -> 1012
    //   1061: astore 5
    //   1063: goto -37 -> 1026
    //   1066: astore_1
    //   1067: aload 5
    //   1069: astore 6
    //   1071: goto -50 -> 1021
    //   1074: astore 8
    //   1076: iload_3
    //   1077: istore_2
    //   1078: aload 7
    //   1080: astore 5
    //   1082: goto -105 -> 977
    //   1085: astore 8
    //   1087: iload_3
    //   1088: istore_2
    //   1089: goto -112 -> 977
    //   1092: astore 7
    //   1094: iconst_0
    //   1095: istore_2
    //   1096: goto -569 -> 527
    //   1099: astore 6
    //   1101: goto -526 -> 575
    //   1104: goto -958 -> 146
    //   1107: astore 7
    //   1109: goto -582 -> 527
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1112	0	this	kz
    //   0	1112	1	paramNetRequest	NetRequest
    //   82	1014	2	i	int
    //   200	888	3	j	int
    //   87	222	4	k	int
    //   14	13	5	localIterator	Iterator
    //   60	1	5	localException1	java.lang.Exception
    //   76	937	5	localObject1	Object
    //   1061	7	5	localException2	java.lang.Exception
    //   1080	1	5	localObject2	Object
    //   36	515	6	localObject3	Object
    //   570	8	6	localMalformedURLException1	java.net.MalformedURLException
    //   605	422	6	localObject4	Object
    //   1046	1	6	localException3	java.lang.Exception
    //   1051	1	6	localException4	java.lang.Exception
    //   1056	1	6	localException5	java.lang.Exception
    //   1069	1	6	localException6	java.lang.Exception
    //   1099	1	6	localMalformedURLException2	java.net.MalformedURLException
    //   211	295	7	localObject5	Object
    //   519	15	7	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   609	470	7	localObject6	Object
    //   1092	1	7	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1107	1	7	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   203	659	8	localObject7	Object
    //   975	9	8	localIOException1	java.io.IOException
    //   1074	1	8	localIOException2	java.io.IOException
    //   1085	1	8	localIOException3	java.io.IOException
    //   148	437	9	localObject8	Object
    //   197	667	10	str1	String
    //   188	471	11	localObject9	Object
    //   191	508	12	localObject10	Object
    //   194	509	13	localObject11	Object
    //   70	974	14	localNetResponse	NetResponse
    //   93	621	15	arrayOfByte	byte[]
    //   99	249	16	localMap	java.util.Map
    //   105	507	17	localHttpCanceler	com.tencent.map.tools.net.http.HttpCanceler
    //   111	105	18	localHttpProxy	com.tencent.map.tools.net.http.HttpProxy
    //   117	684	19	localSet	Set
    //   163	840	20	locala	a
    //   226	727	21	localHttpURLConnection	HttpURLConnection
    //   429	81	22	str2	String
    //   405	107	23	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   5	16	60	java/lang/Exception
    //   16	57	60	java/lang/Exception
    //   213	228	519	java/net/SocketTimeoutException
    //   240	252	519	java/net/SocketTimeoutException
    //   264	270	519	java/net/SocketTimeoutException
    //   287	294	519	java/net/SocketTimeoutException
    //   306	313	519	java/net/SocketTimeoutException
    //   325	335	519	java/net/SocketTimeoutException
    //   347	361	519	java/net/SocketTimeoutException
    //   373	383	519	java/net/SocketTimeoutException
    //   395	407	519	java/net/SocketTimeoutException
    //   419	431	519	java/net/SocketTimeoutException
    //   443	455	519	java/net/SocketTimeoutException
    //   467	475	519	java/net/SocketTimeoutException
    //   487	495	519	java/net/SocketTimeoutException
    //   507	516	519	java/net/SocketTimeoutException
    //   611	627	519	java/net/SocketTimeoutException
    //   639	645	519	java/net/SocketTimeoutException
    //   670	676	519	java/net/SocketTimeoutException
    //   688	694	519	java/net/SocketTimeoutException
    //   706	713	519	java/net/SocketTimeoutException
    //   732	737	519	java/net/SocketTimeoutException
    //   749	755	519	java/net/SocketTimeoutException
    //   119	130	570	java/net/MalformedURLException
    //   759	765	975	java/io/IOException
    //   769	782	975	java/io/IOException
    //   786	796	975	java/io/IOException
    //   800	809	975	java/io/IOException
    //   813	823	975	java/io/IOException
    //   827	839	975	java/io/IOException
    //   843	852	975	java/io/IOException
    //   856	871	975	java/io/IOException
    //   885	891	975	java/io/IOException
    //   895	905	975	java/io/IOException
    //   909	923	975	java/io/IOException
    //   927	933	975	java/io/IOException
    //   950	963	975	java/io/IOException
    //   967	972	975	java/io/IOException
    //   213	228	1020	finally
    //   240	252	1020	finally
    //   264	270	1020	finally
    //   287	294	1020	finally
    //   306	313	1020	finally
    //   325	335	1020	finally
    //   347	361	1020	finally
    //   373	383	1020	finally
    //   395	407	1020	finally
    //   419	431	1020	finally
    //   443	455	1020	finally
    //   467	475	1020	finally
    //   487	495	1020	finally
    //   507	516	1020	finally
    //   531	538	1020	finally
    //   542	548	1020	finally
    //   552	557	1020	finally
    //   611	627	1020	finally
    //   639	645	1020	finally
    //   670	676	1020	finally
    //   688	694	1020	finally
    //   706	713	1020	finally
    //   732	737	1020	finally
    //   749	755	1020	finally
    //   759	765	1020	finally
    //   769	782	1020	finally
    //   786	796	1020	finally
    //   800	809	1020	finally
    //   813	823	1020	finally
    //   827	839	1020	finally
    //   843	852	1020	finally
    //   856	871	1020	finally
    //   885	891	1020	finally
    //   895	905	1020	finally
    //   909	923	1020	finally
    //   927	933	1020	finally
    //   950	963	1020	finally
    //   967	972	1020	finally
    //   981	988	1020	finally
    //   992	998	1020	finally
    //   1002	1007	1020	finally
    //   933	938	1046	java/lang/Exception
    //   557	562	1051	java/lang/Exception
    //   1007	1012	1056	java/lang/Exception
    //   1021	1026	1061	java/lang/Exception
    //   713	720	1066	finally
    //   213	228	1074	java/io/IOException
    //   240	252	1074	java/io/IOException
    //   264	270	1074	java/io/IOException
    //   287	294	1074	java/io/IOException
    //   306	313	1074	java/io/IOException
    //   325	335	1074	java/io/IOException
    //   347	361	1074	java/io/IOException
    //   373	383	1074	java/io/IOException
    //   395	407	1074	java/io/IOException
    //   419	431	1074	java/io/IOException
    //   443	455	1074	java/io/IOException
    //   467	475	1074	java/io/IOException
    //   487	495	1074	java/io/IOException
    //   507	516	1074	java/io/IOException
    //   611	627	1074	java/io/IOException
    //   639	645	1074	java/io/IOException
    //   670	676	1074	java/io/IOException
    //   688	694	1074	java/io/IOException
    //   706	713	1074	java/io/IOException
    //   732	737	1074	java/io/IOException
    //   749	755	1074	java/io/IOException
    //   713	720	1085	java/io/IOException
    //   713	720	1092	java/net/SocketTimeoutException
    //   130	137	1099	java/net/MalformedURLException
    //   759	765	1107	java/net/SocketTimeoutException
    //   769	782	1107	java/net/SocketTimeoutException
    //   786	796	1107	java/net/SocketTimeoutException
    //   800	809	1107	java/net/SocketTimeoutException
    //   813	823	1107	java/net/SocketTimeoutException
    //   827	839	1107	java/net/SocketTimeoutException
    //   843	852	1107	java/net/SocketTimeoutException
    //   856	871	1107	java/net/SocketTimeoutException
    //   885	891	1107	java/net/SocketTimeoutException
    //   895	905	1107	java/net/SocketTimeoutException
    //   909	923	1107	java/net/SocketTimeoutException
    //   927	933	1107	java/net/SocketTimeoutException
    //   950	963	1107	java/net/SocketTimeoutException
    //   967	972	1107	java/net/SocketTimeoutException
  }
  
  private static void d(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222226);
    Iterator localIterator = paramNetRequest.processors.iterator();
    while (localIterator.hasNext())
    {
      Processor localProcessor = (Processor)localIterator.next();
      if ((localProcessor instanceof RequestProcessor)) {
        ((RequestProcessor)localProcessor).onRequest(paramNetRequest);
      }
    }
    AppMethodBeat.o(222226);
  }
  
  protected final NetResponse a(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222260);
    paramNetRequest.setNetMethod(NetMethod.GET);
    paramNetRequest = doRequest(paramNetRequest);
    AppMethodBeat.o(222260);
    return paramNetRequest;
  }
  
  protected final void a()
  {
    AppMethodBeat.i(222251);
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    AppMethodBeat.o(222251);
  }
  
  protected final NetResponse b(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222269);
    paramNetRequest.setNetMethod(NetMethod.POST);
    paramNetRequest = doRequest(paramNetRequest);
    AppMethodBeat.o(222269);
    return paramNetRequest;
  }
  
  public final boolean cancel()
  {
    AppMethodBeat.i(222293);
    if (this.d != null)
    {
      this.d.disconnect();
      AppMethodBeat.o(222293);
      return true;
    }
    AppMethodBeat.o(222293);
    return false;
  }
  
  public final NetResponse doRequest(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222275);
    paramNetRequest.addProcessor(new ll());
    paramNetRequest = c(paramNetRequest);
    AppMethodBeat.o(222275);
    return paramNetRequest;
  }
  
  public final NetResponse openStream(NetRequest paramNetRequest)
  {
    AppMethodBeat.i(222284);
    paramNetRequest.addProcessor(new lr());
    paramNetRequest = c(paramNetRequest);
    AppMethodBeat.o(222284);
    return paramNetRequest;
  }
  
  static final class a
  {
    private static final int c = 3;
    int a;
    boolean b;
    
    a(int paramInt)
    {
      AppMethodBeat.i(225536);
      this.b = true;
      this.a = paramInt;
      if (this.a > 3) {
        this.a = 3;
      }
      if (this.a <= 0) {
        this.a = 1;
      }
      AppMethodBeat.o(225536);
    }
    
    private boolean b()
    {
      return (this.b) && (this.a > 0);
    }
    
    private void c()
    {
      this.b = false;
    }
    
    final void a()
    {
      this.a -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kz
 * JD-Core Version:    0.7.0.1
 */