package com.tencent.mm.plugin.appbrand.q.a;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.a.e;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetHttpsCreateResult;
import com.tencent.mars.cdn.CronetLogic.CronetRequestParams;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.q.o;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.f.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class b
  implements Runnable
{
  private String bxn;
  String filename;
  public String hLO;
  private boolean hLX;
  private boolean hLY;
  private String hzZ;
  public volatile boolean isRunning;
  c joJ;
  public SSLContext kUC;
  final a kVW;
  public Map<String, String> kVX;
  public volatile int kVY;
  long kVZ;
  public ArrayList<String> kVe;
  int kVf;
  public String kVj;
  volatile boolean kVk;
  private boolean kVl;
  boolean kVm;
  private HttpURLConnection kWa;
  String kWb;
  private boolean kaI;
  private final String kwo;
  private long startTime;
  public int timeout;
  String uri;
  
  public b(c paramc, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, a parama)
  {
    AppMethodBeat.i(190831);
    this.kVf = 15;
    this.isRunning = false;
    this.kVk = false;
    this.bxn = "unknow";
    this.timeout = 60000;
    this.kaI = false;
    this.hLX = false;
    this.hLY = false;
    this.kVl = false;
    this.kVm = true;
    this.joJ = paramc;
    this.uri = paramString1;
    this.filename = paramString2;
    this.hzZ = paramString3;
    this.kVW = parama;
    this.startTime = System.currentTimeMillis();
    this.kwo = paramString4;
    this.kaI = paramBoolean1;
    this.hLX = paramBoolean2;
    this.hLY = paramBoolean3;
    this.kVl = paramBoolean4;
    this.kVm = paramBoolean5;
    AppMethodBeat.o(190831);
  }
  
  private static void I(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(144471);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      ad.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d return", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(144471);
      return;
    }
    int i = 34;
    double d = paramLong1 / paramLong2 * 0.9765625D;
    if (ay.is2G(aj.getContext())) {
      i = 30;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(437L, i, d, false);
      ad.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d, speed:%f, key:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Double.valueOf(d), Integer.valueOf(i) });
      AppMethodBeat.o(144471);
      return;
      if (ay.is3G(aj.getContext())) {
        i = 31;
      } else if (ay.is4G(aj.getContext())) {
        i = 32;
      } else if (ay.isWifi(aj.getContext())) {
        i = 33;
      }
    }
  }
  
  private String aEB()
  {
    return this.hLO;
  }
  
  private String aYC()
  {
    return this.kVj;
  }
  
  /* Error */
  private void biB()
  {
    // Byte code:
    //   0: ldc 205
    //   2: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   8: lstore 23
    //   10: iconst_0
    //   11: istore 9
    //   13: iconst_0
    //   14: istore 10
    //   16: iconst_0
    //   17: istore 11
    //   19: iconst_0
    //   20: istore 12
    //   22: iconst_0
    //   23: istore 13
    //   25: iconst_0
    //   26: istore 8
    //   28: iconst_0
    //   29: istore 14
    //   31: iconst_0
    //   32: istore 15
    //   34: iconst_0
    //   35: istore 16
    //   37: iconst_0
    //   38: istore 17
    //   40: iconst_0
    //   41: istore 18
    //   43: iconst_0
    //   44: istore_1
    //   45: lconst_0
    //   46: lstore 19
    //   48: aload_0
    //   49: getfield 69	com/tencent/mm/plugin/appbrand/q/a/b:isRunning	Z
    //   52: ifne +140 -> 192
    //   55: aload_0
    //   56: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   59: aload_0
    //   60: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   63: aload_0
    //   64: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   67: ldc 207
    //   69: invokeinterface 212 4 0
    //   74: aload_0
    //   75: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   78: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   81: ifeq +57 -> 138
    //   84: ldc 220
    //   86: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   89: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   92: aload_0
    //   93: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   96: invokeinterface 225 1 0
    //   101: aload_0
    //   102: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   105: ldc 229
    //   107: aload_0
    //   108: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   111: lconst_0
    //   112: lconst_0
    //   113: iconst_0
    //   114: iconst_2
    //   115: aload_0
    //   116: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   119: aload_0
    //   120: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   127: invokeinterface 239 14 0
    //   132: ldc 205
    //   134: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: ldc 220
    //   140: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   143: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   146: aload_0
    //   147: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   150: invokeinterface 225 1 0
    //   155: aload_0
    //   156: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   159: ldc 229
    //   161: aload_0
    //   162: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   165: lconst_0
    //   166: lconst_0
    //   167: iconst_0
    //   168: iconst_2
    //   169: aload_0
    //   170: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   173: aload_0
    //   174: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   177: aload_0
    //   178: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   181: invokeinterface 239 14 0
    //   186: ldc 205
    //   188: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: aload_0
    //   193: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   196: putfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   199: aload_0
    //   200: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   203: aload_0
    //   204: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   207: aload_0
    //   208: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   211: invokeinterface 245 3 0
    //   216: iload_1
    //   217: istore_2
    //   218: iload 14
    //   220: istore_3
    //   221: iload 15
    //   223: istore 4
    //   225: iload 16
    //   227: istore 5
    //   229: iload 17
    //   231: istore 6
    //   233: iload 18
    //   235: istore 7
    //   237: ldc 145
    //   239: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   242: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   245: ldc2_w 152
    //   248: lconst_0
    //   249: lconst_1
    //   250: iconst_0
    //   251: invokeinterface 157 8 0
    //   256: iload_1
    //   257: istore_2
    //   258: iload 14
    //   260: istore_3
    //   261: iload 15
    //   263: istore 4
    //   265: iload 16
    //   267: istore 5
    //   269: iload 17
    //   271: istore 6
    //   273: iload 18
    //   275: istore 7
    //   277: new 247	java/net/URL
    //   280: dup
    //   281: aload_0
    //   282: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   285: invokespecial 250	java/net/URL:<init>	(Ljava/lang/String;)V
    //   288: astore 27
    //   290: iload_1
    //   291: istore_2
    //   292: iload 14
    //   294: istore_3
    //   295: iload 15
    //   297: istore 4
    //   299: iload 16
    //   301: istore 5
    //   303: iload 17
    //   305: istore 6
    //   307: iload 18
    //   309: istore 7
    //   311: ldc 116
    //   313: ldc 252
    //   315: iconst_3
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: aload_0
    //   322: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   325: aastore
    //   326: dup
    //   327: iconst_1
    //   328: aload_0
    //   329: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   332: aastore
    //   333: dup
    //   334: iconst_2
    //   335: aload_0
    //   336: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   339: aastore
    //   340: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: iload_1
    //   344: istore_2
    //   345: iload 14
    //   347: istore_3
    //   348: iload 15
    //   350: istore 4
    //   352: iload 16
    //   354: istore 5
    //   356: iload 17
    //   358: istore 6
    //   360: iload 18
    //   362: istore 7
    //   364: aload_0
    //   365: aload 27
    //   367: invokevirtual 256	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   370: checkcast 258	java/net/HttpURLConnection
    //   373: putfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   376: iload_1
    //   377: istore_2
    //   378: iload 14
    //   380: istore_3
    //   381: iload 15
    //   383: istore 4
    //   385: iload 16
    //   387: istore 5
    //   389: iload 17
    //   391: istore 6
    //   393: iload 18
    //   395: istore 7
    //   397: aload_0
    //   398: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   401: instanceof 262
    //   404: ifeq +101 -> 505
    //   407: iload_1
    //   408: istore_2
    //   409: iload 14
    //   411: istore_3
    //   412: iload 15
    //   414: istore 4
    //   416: iload 16
    //   418: istore 5
    //   420: iload 17
    //   422: istore 6
    //   424: iload 18
    //   426: istore 7
    //   428: aload_0
    //   429: getfield 264	com/tencent/mm/plugin/appbrand/q/a/b:kUC	Ljavax/net/ssl/SSLContext;
    //   432: ifnull +73 -> 505
    //   435: iload_1
    //   436: istore_2
    //   437: iload 14
    //   439: istore_3
    //   440: iload 15
    //   442: istore 4
    //   444: iload 16
    //   446: istore 5
    //   448: iload 17
    //   450: istore 6
    //   452: iload 18
    //   454: istore 7
    //   456: aload_0
    //   457: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   460: checkcast 262	javax/net/ssl/HttpsURLConnection
    //   463: aload_0
    //   464: getfield 264	com/tencent/mm/plugin/appbrand/q/a/b:kUC	Ljavax/net/ssl/SSLContext;
    //   467: invokevirtual 270	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   470: invokevirtual 274	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   473: iload_1
    //   474: istore_2
    //   475: iload 14
    //   477: istore_3
    //   478: iload 15
    //   480: istore 4
    //   482: iload 16
    //   484: istore 5
    //   486: iload 17
    //   488: istore 6
    //   490: iload 18
    //   492: istore 7
    //   494: aload_0
    //   495: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   498: aload_0
    //   499: getfield 276	com/tencent/mm/plugin/appbrand/q/a/b:kVe	Ljava/util/ArrayList;
    //   502: invokestatic 281	com/tencent/mm/plugin/appbrand/q/j:a	(Ljava/net/HttpURLConnection;Ljava/util/ArrayList;)V
    //   505: iload_1
    //   506: istore_2
    //   507: iload 14
    //   509: istore_3
    //   510: iload 15
    //   512: istore 4
    //   514: iload 16
    //   516: istore 5
    //   518: iload 17
    //   520: istore 6
    //   522: iload 18
    //   524: istore 7
    //   526: aload_0
    //   527: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   530: iconst_1
    //   531: invokevirtual 285	java/net/HttpURLConnection:setDoInput	(Z)V
    //   534: iload_1
    //   535: istore_2
    //   536: iload 14
    //   538: istore_3
    //   539: iload 15
    //   541: istore 4
    //   543: iload 16
    //   545: istore 5
    //   547: iload 17
    //   549: istore 6
    //   551: iload 18
    //   553: istore 7
    //   555: aload_0
    //   556: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   559: aload_0
    //   560: getfield 78	com/tencent/mm/plugin/appbrand/q/a/b:timeout	I
    //   563: invokevirtual 288	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   566: iload_1
    //   567: istore_2
    //   568: iload 14
    //   570: istore_3
    //   571: iload 15
    //   573: istore 4
    //   575: iload 16
    //   577: istore 5
    //   579: iload 17
    //   581: istore 6
    //   583: iload 18
    //   585: istore 7
    //   587: aload_0
    //   588: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   591: aload_0
    //   592: getfield 78	com/tencent/mm/plugin/appbrand/q/a/b:timeout	I
    //   595: invokevirtual 291	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   598: iload_1
    //   599: istore_2
    //   600: iload 14
    //   602: istore_3
    //   603: iload 15
    //   605: istore 4
    //   607: iload 16
    //   609: istore 5
    //   611: iload 17
    //   613: istore 6
    //   615: iload 18
    //   617: istore 7
    //   619: aload_0
    //   620: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   623: iconst_0
    //   624: invokevirtual 294	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   627: iload_1
    //   628: istore_2
    //   629: iload 14
    //   631: istore_3
    //   632: iload 15
    //   634: istore 4
    //   636: iload 16
    //   638: istore 5
    //   640: iload 17
    //   642: istore 6
    //   644: iload 18
    //   646: istore 7
    //   648: aload_0
    //   649: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   652: ldc_w 296
    //   655: ldc_w 298
    //   658: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   661: iload_1
    //   662: istore_2
    //   663: iload 14
    //   665: istore_3
    //   666: iload 15
    //   668: istore 4
    //   670: iload 16
    //   672: istore 5
    //   674: iload 17
    //   676: istore 6
    //   678: iload 18
    //   680: istore 7
    //   682: aload_0
    //   683: getfield 303	com/tencent/mm/plugin/appbrand/q/a/b:kVX	Ljava/util/Map;
    //   686: ifnull +511 -> 1197
    //   689: iload_1
    //   690: istore_2
    //   691: iload 14
    //   693: istore_3
    //   694: iload 15
    //   696: istore 4
    //   698: iload 16
    //   700: istore 5
    //   702: iload 17
    //   704: istore 6
    //   706: iload 18
    //   708: istore 7
    //   710: ldc 116
    //   712: ldc_w 305
    //   715: iconst_1
    //   716: anewarray 4	java/lang/Object
    //   719: dup
    //   720: iconst_0
    //   721: aload 27
    //   723: aastore
    //   724: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   727: iload_1
    //   728: istore_2
    //   729: iload 14
    //   731: istore_3
    //   732: iload 15
    //   734: istore 4
    //   736: iload 16
    //   738: istore 5
    //   740: iload 17
    //   742: istore 6
    //   744: iload 18
    //   746: istore 7
    //   748: aload_0
    //   749: getfield 303	com/tencent/mm/plugin/appbrand/q/a/b:kVX	Ljava/util/Map;
    //   752: invokeinterface 311 1 0
    //   757: invokeinterface 317 1 0
    //   762: astore 28
    //   764: iload_1
    //   765: istore_2
    //   766: iload 14
    //   768: istore_3
    //   769: iload 15
    //   771: istore 4
    //   773: iload 16
    //   775: istore 5
    //   777: iload 17
    //   779: istore 6
    //   781: iload 18
    //   783: istore 7
    //   785: aload 28
    //   787: invokeinterface 323 1 0
    //   792: ifeq +405 -> 1197
    //   795: iload_1
    //   796: istore_2
    //   797: iload 14
    //   799: istore_3
    //   800: iload 15
    //   802: istore 4
    //   804: iload 16
    //   806: istore 5
    //   808: iload 17
    //   810: istore 6
    //   812: iload 18
    //   814: istore 7
    //   816: aload 28
    //   818: invokeinterface 327 1 0
    //   823: checkcast 329	java/util/Map$Entry
    //   826: astore 29
    //   828: iload_1
    //   829: istore_2
    //   830: iload 14
    //   832: istore_3
    //   833: iload 15
    //   835: istore 4
    //   837: iload 16
    //   839: istore 5
    //   841: iload 17
    //   843: istore 6
    //   845: iload 18
    //   847: istore 7
    //   849: aload_0
    //   850: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   853: aload 29
    //   855: invokeinterface 332 1 0
    //   860: checkcast 334	java/lang/String
    //   863: aload 29
    //   865: invokeinterface 337 1 0
    //   870: checkcast 334	java/lang/String
    //   873: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   876: iload_1
    //   877: istore_2
    //   878: iload 14
    //   880: istore_3
    //   881: iload 15
    //   883: istore 4
    //   885: iload 16
    //   887: istore 5
    //   889: iload 17
    //   891: istore 6
    //   893: iload 18
    //   895: istore 7
    //   897: ldc 116
    //   899: ldc_w 339
    //   902: iconst_3
    //   903: anewarray 4	java/lang/Object
    //   906: dup
    //   907: iconst_0
    //   908: aload_0
    //   909: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   912: aastore
    //   913: dup
    //   914: iconst_1
    //   915: aload 29
    //   917: invokeinterface 332 1 0
    //   922: aastore
    //   923: dup
    //   924: iconst_2
    //   925: aload 29
    //   927: invokeinterface 337 1 0
    //   932: aastore
    //   933: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   936: goto -172 -> 764
    //   939: astore 29
    //   941: aconst_null
    //   942: astore 27
    //   944: aconst_null
    //   945: astore 28
    //   947: iconst_0
    //   948: istore_1
    //   949: ldc 145
    //   951: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   954: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   957: ldc2_w 152
    //   960: lconst_1
    //   961: lconst_1
    //   962: iconst_0
    //   963: invokeinterface 157 8 0
    //   968: ldc 116
    //   970: aload 29
    //   972: ldc_w 341
    //   975: iconst_2
    //   976: anewarray 4	java/lang/Object
    //   979: dup
    //   980: iconst_0
    //   981: aload_0
    //   982: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   985: aastore
    //   986: dup
    //   987: iconst_1
    //   988: aload_0
    //   989: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   992: aastore
    //   993: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   996: aload_0
    //   997: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   1000: aload_0
    //   1001: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   1004: aload_0
    //   1005: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   1008: ldc_w 347
    //   1011: invokeinterface 212 4 0
    //   1016: iload_1
    //   1017: ifeq +5031 -> 6048
    //   1020: aload_0
    //   1021: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   1024: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1027: ifeq +4969 -> 5996
    //   1030: ldc 220
    //   1032: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1035: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   1038: aload_0
    //   1039: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   1042: invokeinterface 225 1 0
    //   1047: aload_0
    //   1048: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   1051: ldc 229
    //   1053: aload_0
    //   1054: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   1057: lconst_0
    //   1058: lload 19
    //   1060: iload_2
    //   1061: iconst_1
    //   1062: aload_0
    //   1063: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   1066: aload_0
    //   1067: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   1070: aload_0
    //   1071: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   1074: invokeinterface 239 14 0
    //   1079: ldc 145
    //   1081: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1084: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   1087: ldc2_w 152
    //   1090: ldc2_w 348
    //   1093: lconst_1
    //   1094: iconst_0
    //   1095: invokeinterface 157 8 0
    //   1100: ldc 145
    //   1102: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1105: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   1108: ldc2_w 152
    //   1111: ldc2_w 350
    //   1114: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1117: aload_0
    //   1118: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   1121: lsub
    //   1122: iconst_0
    //   1123: invokeinterface 157 8 0
    //   1128: aload 27
    //   1130: ifnull +8 -> 1138
    //   1133: aload 27
    //   1135: invokevirtual 356	java/io/OutputStream:close	()V
    //   1138: aload 28
    //   1140: ifnull +8 -> 1148
    //   1143: aload 28
    //   1145: invokevirtual 359	java/io/InputStream:close	()V
    //   1148: aload_0
    //   1149: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   1152: aload_0
    //   1153: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   1156: aload_0
    //   1157: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   1160: invokeinterface 367 2 0
    //   1165: ldc 116
    //   1167: ldc_w 369
    //   1170: iconst_2
    //   1171: anewarray 4	java/lang/Object
    //   1174: dup
    //   1175: iconst_0
    //   1176: aload_0
    //   1177: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   1180: aastore
    //   1181: dup
    //   1182: iconst_1
    //   1183: aload_0
    //   1184: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   1187: aastore
    //   1188: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1191: ldc 205
    //   1193: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1196: return
    //   1197: iload_1
    //   1198: istore_2
    //   1199: iload 14
    //   1201: istore_3
    //   1202: iload 15
    //   1204: istore 4
    //   1206: iload 16
    //   1208: istore 5
    //   1210: iload 17
    //   1212: istore 6
    //   1214: iload 18
    //   1216: istore 7
    //   1218: aload_0
    //   1219: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   1222: ldc_w 371
    //   1225: aload_0
    //   1226: getfield 108	com/tencent/mm/plugin/appbrand/q/a/b:kwo	Ljava/lang/String;
    //   1229: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1232: iload_1
    //   1233: istore_2
    //   1234: iload 14
    //   1236: istore_3
    //   1237: iload 15
    //   1239: istore 4
    //   1241: iload 16
    //   1243: istore 5
    //   1245: iload 17
    //   1247: istore 6
    //   1249: iload 18
    //   1251: istore 7
    //   1253: aload_0
    //   1254: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   1257: invokestatic 375	com/tencent/mm/plugin/appbrand/q/j:c	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
    //   1260: astore 28
    //   1262: iload_1
    //   1263: istore_2
    //   1264: iload 14
    //   1266: istore_3
    //   1267: iload 15
    //   1269: istore 4
    //   1271: iload 16
    //   1273: istore 5
    //   1275: iload 17
    //   1277: istore 6
    //   1279: iload 18
    //   1281: istore 7
    //   1283: aload_0
    //   1284: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   1287: aload 28
    //   1289: invokeinterface 379 2 0
    //   1294: iload_1
    //   1295: istore_2
    //   1296: iload 14
    //   1298: istore_3
    //   1299: iload 15
    //   1301: istore 4
    //   1303: iload 16
    //   1305: istore 5
    //   1307: iload 17
    //   1309: istore 6
    //   1311: iload 18
    //   1313: istore 7
    //   1315: aload_0
    //   1316: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   1319: invokevirtual 382	java/net/HttpURLConnection:getContentLength	()I
    //   1322: i2l
    //   1323: lstore 25
    //   1325: iload_1
    //   1326: istore_2
    //   1327: iload 14
    //   1329: istore_3
    //   1330: iload 15
    //   1332: istore 4
    //   1334: iload 16
    //   1336: istore 5
    //   1338: iload 17
    //   1340: istore 6
    //   1342: iload 18
    //   1344: istore 7
    //   1346: aload_0
    //   1347: aload_0
    //   1348: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   1351: ldc_w 384
    //   1354: invokevirtual 388	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1357: aload 27
    //   1359: invokevirtual 391	java/net/URL:toString	()Ljava/lang/String;
    //   1362: invokestatic 395	com/tencent/mm/plugin/appbrand/q/a/b:dK	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1365: putfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   1368: iload_1
    //   1369: istore_2
    //   1370: iload 14
    //   1372: istore_3
    //   1373: iload 15
    //   1375: istore 4
    //   1377: iload 16
    //   1379: istore 5
    //   1381: iload 17
    //   1383: istore 6
    //   1385: iload 18
    //   1387: istore 7
    //   1389: aload_0
    //   1390: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   1393: invokevirtual 398	java/net/HttpURLConnection:getResponseCode	()I
    //   1396: istore_1
    //   1397: lload 25
    //   1399: lconst_0
    //   1400: lcmp
    //   1401: ifle +41 -> 1442
    //   1404: iload_1
    //   1405: istore_2
    //   1406: iload_1
    //   1407: istore_3
    //   1408: iload_1
    //   1409: istore 4
    //   1411: iload_1
    //   1412: istore 5
    //   1414: iload_1
    //   1415: istore 6
    //   1417: iload_1
    //   1418: istore 7
    //   1420: ldc 145
    //   1422: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1425: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   1428: ldc2_w 152
    //   1431: ldc2_w 399
    //   1434: lload 25
    //   1436: iconst_0
    //   1437: invokeinterface 157 8 0
    //   1442: iload_1
    //   1443: istore_2
    //   1444: iload_1
    //   1445: istore_3
    //   1446: iload_1
    //   1447: istore 4
    //   1449: iload_1
    //   1450: istore 5
    //   1452: iload_1
    //   1453: istore 6
    //   1455: iload_1
    //   1456: istore 7
    //   1458: aload_0
    //   1459: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   1462: invokestatic 402	com/tencent/mm/plugin/appbrand/q/j:b	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
    //   1465: astore 27
    //   1467: iload_1
    //   1468: istore_2
    //   1469: iload_1
    //   1470: istore_3
    //   1471: iload_1
    //   1472: istore 4
    //   1474: iload_1
    //   1475: istore 5
    //   1477: iload_1
    //   1478: istore 6
    //   1480: iload_1
    //   1481: istore 7
    //   1483: iload_1
    //   1484: invokestatic 405	com/tencent/mm/plugin/appbrand/q/a/b:tm	(I)V
    //   1487: iload_1
    //   1488: istore_2
    //   1489: iload_1
    //   1490: istore_3
    //   1491: iload_1
    //   1492: istore 4
    //   1494: iload_1
    //   1495: istore 5
    //   1497: iload_1
    //   1498: istore 6
    //   1500: iload_1
    //   1501: istore 7
    //   1503: aload_0
    //   1504: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   1507: aload 27
    //   1509: invokeinterface 379 2 0
    //   1514: iload_1
    //   1515: sipush 200
    //   1518: if_icmpeq +823 -> 2341
    //   1521: iload_1
    //   1522: istore_2
    //   1523: iload_1
    //   1524: istore_3
    //   1525: iload_1
    //   1526: istore 4
    //   1528: iload_1
    //   1529: istore 5
    //   1531: iload_1
    //   1532: istore 6
    //   1534: iload_1
    //   1535: istore 7
    //   1537: ldc 116
    //   1539: ldc_w 407
    //   1542: iconst_4
    //   1543: anewarray 4	java/lang/Object
    //   1546: dup
    //   1547: iconst_0
    //   1548: iload_1
    //   1549: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1552: aastore
    //   1553: dup
    //   1554: iconst_1
    //   1555: aload_0
    //   1556: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   1559: aastore
    //   1560: dup
    //   1561: iconst_2
    //   1562: aload_0
    //   1563: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   1566: aastore
    //   1567: dup
    //   1568: iconst_3
    //   1569: aload_0
    //   1570: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   1573: aastore
    //   1574: invokestatic 410	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1577: iload_1
    //   1578: istore_2
    //   1579: iload_1
    //   1580: istore_3
    //   1581: iload_1
    //   1582: istore 4
    //   1584: iload_1
    //   1585: istore 5
    //   1587: iload_1
    //   1588: istore 6
    //   1590: iload_1
    //   1591: istore 7
    //   1593: iload_1
    //   1594: invokestatic 414	com/tencent/mm/plugin/appbrand/q/j:na	(I)Z
    //   1597: ifeq +744 -> 2341
    //   1600: iload_1
    //   1601: istore_2
    //   1602: iload_1
    //   1603: istore_3
    //   1604: iload_1
    //   1605: istore 4
    //   1607: iload_1
    //   1608: istore 5
    //   1610: iload_1
    //   1611: istore 6
    //   1613: iload_1
    //   1614: istore 7
    //   1616: aload_0
    //   1617: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   1620: invokestatic 417	com/tencent/mm/plugin/appbrand/q/j:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   1623: astore 27
    //   1625: iload_1
    //   1626: istore_2
    //   1627: iload_1
    //   1628: istore_3
    //   1629: iload_1
    //   1630: istore 4
    //   1632: iload_1
    //   1633: istore 5
    //   1635: iload_1
    //   1636: istore 6
    //   1638: iload_1
    //   1639: istore 7
    //   1641: aload 27
    //   1643: invokestatic 423	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1646: ifne +695 -> 2341
    //   1649: iload_1
    //   1650: istore_2
    //   1651: iload_1
    //   1652: istore_3
    //   1653: iload_1
    //   1654: istore 4
    //   1656: iload_1
    //   1657: istore 5
    //   1659: iload_1
    //   1660: istore 6
    //   1662: iload_1
    //   1663: istore 7
    //   1665: aload_0
    //   1666: getfield 67	com/tencent/mm/plugin/appbrand/q/a/b:kVf	I
    //   1669: istore 13
    //   1671: iload_1
    //   1672: istore_2
    //   1673: iload_1
    //   1674: istore_3
    //   1675: iload_1
    //   1676: istore 4
    //   1678: iload_1
    //   1679: istore 5
    //   1681: iload_1
    //   1682: istore 6
    //   1684: iload_1
    //   1685: istore 7
    //   1687: aload_0
    //   1688: iload 13
    //   1690: iconst_1
    //   1691: isub
    //   1692: putfield 67	com/tencent/mm/plugin/appbrand/q/a/b:kVf	I
    //   1695: iload 13
    //   1697: ifgt +286 -> 1983
    //   1700: iload_1
    //   1701: istore_2
    //   1702: iload_1
    //   1703: istore_3
    //   1704: iload_1
    //   1705: istore 4
    //   1707: iload_1
    //   1708: istore 5
    //   1710: iload_1
    //   1711: istore 6
    //   1713: iload_1
    //   1714: istore 7
    //   1716: ldc 116
    //   1718: ldc_w 425
    //   1721: iconst_1
    //   1722: anewarray 4	java/lang/Object
    //   1725: dup
    //   1726: iconst_0
    //   1727: bipush 15
    //   1729: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1732: aastore
    //   1733: invokestatic 428	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1736: iload_1
    //   1737: istore_2
    //   1738: iload_1
    //   1739: istore_3
    //   1740: iload_1
    //   1741: istore 4
    //   1743: iload_1
    //   1744: istore 5
    //   1746: iload_1
    //   1747: istore 6
    //   1749: iload_1
    //   1750: istore 7
    //   1752: aload_0
    //   1753: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   1756: aload_0
    //   1757: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   1760: aload_0
    //   1761: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   1764: aload_0
    //   1765: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   1768: iload_1
    //   1769: lconst_0
    //   1770: aconst_null
    //   1771: invokeinterface 431 8 0
    //   1776: aload_0
    //   1777: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   1780: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   1783: ifeq +149 -> 1932
    //   1786: ldc 220
    //   1788: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1791: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   1794: aload_0
    //   1795: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   1798: invokeinterface 225 1 0
    //   1803: aload_0
    //   1804: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   1807: ldc 229
    //   1809: aload_0
    //   1810: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   1813: lconst_0
    //   1814: lconst_0
    //   1815: iload_1
    //   1816: iconst_1
    //   1817: aload_0
    //   1818: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   1821: aload_0
    //   1822: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   1825: aload_0
    //   1826: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   1829: invokeinterface 239 14 0
    //   1834: ldc 145
    //   1836: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1839: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   1842: ldc2_w 152
    //   1845: ldc2_w 348
    //   1848: lconst_1
    //   1849: iconst_0
    //   1850: invokeinterface 157 8 0
    //   1855: ldc 145
    //   1857: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1860: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   1863: ldc2_w 152
    //   1866: ldc2_w 350
    //   1869: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1872: aload_0
    //   1873: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   1876: lsub
    //   1877: iconst_0
    //   1878: invokeinterface 157 8 0
    //   1883: aload_0
    //   1884: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   1887: aload_0
    //   1888: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   1891: aload_0
    //   1892: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   1895: invokeinterface 367 2 0
    //   1900: ldc 116
    //   1902: ldc_w 369
    //   1905: iconst_2
    //   1906: anewarray 4	java/lang/Object
    //   1909: dup
    //   1910: iconst_0
    //   1911: aload_0
    //   1912: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   1915: aastore
    //   1916: dup
    //   1917: iconst_1
    //   1918: aload_0
    //   1919: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   1922: aastore
    //   1923: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1926: ldc 205
    //   1928: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1931: return
    //   1932: ldc 220
    //   1934: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1937: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   1940: aload_0
    //   1941: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   1944: invokeinterface 225 1 0
    //   1949: aload_0
    //   1950: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   1953: ldc 229
    //   1955: aload_0
    //   1956: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   1959: lconst_0
    //   1960: lconst_0
    //   1961: iload_1
    //   1962: iconst_1
    //   1963: aload_0
    //   1964: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   1967: aload_0
    //   1968: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   1971: aload_0
    //   1972: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   1975: invokeinterface 239 14 0
    //   1980: goto -146 -> 1834
    //   1983: iload_1
    //   1984: istore_2
    //   1985: iload_1
    //   1986: istore_3
    //   1987: iload_1
    //   1988: istore 4
    //   1990: iload_1
    //   1991: istore 5
    //   1993: iload_1
    //   1994: istore 6
    //   1996: iload_1
    //   1997: istore 7
    //   1999: ldc 116
    //   2001: ldc_w 433
    //   2004: iconst_3
    //   2005: anewarray 4	java/lang/Object
    //   2008: dup
    //   2009: iconst_0
    //   2010: aload_0
    //   2011: getfield 67	com/tencent/mm/plugin/appbrand/q/a/b:kVf	I
    //   2014: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2017: aastore
    //   2018: dup
    //   2019: iconst_1
    //   2020: aload_0
    //   2021: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   2024: aastore
    //   2025: dup
    //   2026: iconst_2
    //   2027: aload 27
    //   2029: aastore
    //   2030: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2033: iload_1
    //   2034: istore_2
    //   2035: iload_1
    //   2036: istore_3
    //   2037: iload_1
    //   2038: istore 4
    //   2040: iload_1
    //   2041: istore 5
    //   2043: iload_1
    //   2044: istore 6
    //   2046: iload_1
    //   2047: istore 7
    //   2049: aload_0
    //   2050: aload 27
    //   2052: putfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   2055: iload_1
    //   2056: istore_2
    //   2057: iload_1
    //   2058: istore_3
    //   2059: iload_1
    //   2060: istore 4
    //   2062: iload_1
    //   2063: istore 5
    //   2065: iload_1
    //   2066: istore 6
    //   2068: iload_1
    //   2069: istore 7
    //   2071: aload_0
    //   2072: invokevirtual 436	com/tencent/mm/plugin/appbrand/q/a/b:run	()V
    //   2075: aload_0
    //   2076: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   2079: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   2082: ifeq +208 -> 2290
    //   2085: ldc 220
    //   2087: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2090: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   2093: aload_0
    //   2094: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   2097: invokeinterface 225 1 0
    //   2102: aload_0
    //   2103: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   2106: ldc 229
    //   2108: aload_0
    //   2109: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   2112: lconst_0
    //   2113: lconst_0
    //   2114: iload_1
    //   2115: iconst_2
    //   2116: aload_0
    //   2117: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   2120: aload_0
    //   2121: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   2124: aload_0
    //   2125: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   2128: invokeinterface 239 14 0
    //   2133: ldc 145
    //   2135: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2138: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   2141: ldc2_w 152
    //   2144: ldc2_w 437
    //   2147: lconst_1
    //   2148: iconst_0
    //   2149: invokeinterface 157 8 0
    //   2154: ldc 145
    //   2156: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2159: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   2162: ldc2_w 152
    //   2165: ldc2_w 439
    //   2168: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   2171: aload_0
    //   2172: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   2175: lsub
    //   2176: iconst_0
    //   2177: invokeinterface 157 8 0
    //   2182: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   2185: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   2188: istore_1
    //   2189: iload_1
    //   2190: iconst_m1
    //   2191: if_icmpne +24 -> 2215
    //   2194: ldc 145
    //   2196: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2199: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   2202: ldc2_w 152
    //   2205: ldc2_w 445
    //   2208: lconst_1
    //   2209: iconst_0
    //   2210: invokeinterface 157 8 0
    //   2215: ldc 116
    //   2217: ldc_w 448
    //   2220: iconst_2
    //   2221: anewarray 4	java/lang/Object
    //   2224: dup
    //   2225: iconst_0
    //   2226: aload_0
    //   2227: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   2230: aastore
    //   2231: dup
    //   2232: iconst_1
    //   2233: iload_1
    //   2234: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2237: aastore
    //   2238: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2241: aload_0
    //   2242: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   2245: aload_0
    //   2246: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   2249: aload_0
    //   2250: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   2253: invokeinterface 367 2 0
    //   2258: ldc 116
    //   2260: ldc_w 369
    //   2263: iconst_2
    //   2264: anewarray 4	java/lang/Object
    //   2267: dup
    //   2268: iconst_0
    //   2269: aload_0
    //   2270: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   2273: aastore
    //   2274: dup
    //   2275: iconst_1
    //   2276: aload_0
    //   2277: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   2280: aastore
    //   2281: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2284: ldc 205
    //   2286: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2289: return
    //   2290: ldc 220
    //   2292: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2295: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   2298: aload_0
    //   2299: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   2302: invokeinterface 225 1 0
    //   2307: aload_0
    //   2308: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   2311: ldc 229
    //   2313: aload_0
    //   2314: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   2317: lconst_0
    //   2318: lconst_0
    //   2319: iload_1
    //   2320: iconst_2
    //   2321: aload_0
    //   2322: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   2325: aload_0
    //   2326: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   2329: aload_0
    //   2330: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   2333: invokeinterface 239 14 0
    //   2338: goto -205 -> 2133
    //   2341: iload_1
    //   2342: istore_2
    //   2343: iload_1
    //   2344: istore_3
    //   2345: iload_1
    //   2346: istore 4
    //   2348: iload_1
    //   2349: istore 5
    //   2351: iload_1
    //   2352: istore 6
    //   2354: iload_1
    //   2355: istore 7
    //   2357: aload_0
    //   2358: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   2361: invokevirtual 382	java/net/HttpURLConnection:getContentLength	()I
    //   2364: istore 14
    //   2366: iload 14
    //   2368: ifle +393 -> 2761
    //   2371: iload_1
    //   2372: istore_2
    //   2373: iload_1
    //   2374: istore_3
    //   2375: iload_1
    //   2376: istore 4
    //   2378: iload_1
    //   2379: istore 5
    //   2381: iload_1
    //   2382: istore 6
    //   2384: iload_1
    //   2385: istore 7
    //   2387: aload_0
    //   2388: getfield 450	com/tencent/mm/plugin/appbrand/q/a/b:kVY	I
    //   2391: ifle +370 -> 2761
    //   2394: iload_1
    //   2395: istore_2
    //   2396: iload_1
    //   2397: istore_3
    //   2398: iload_1
    //   2399: istore 4
    //   2401: iload_1
    //   2402: istore 5
    //   2404: iload_1
    //   2405: istore 6
    //   2407: iload_1
    //   2408: istore 7
    //   2410: iload 14
    //   2412: aload_0
    //   2413: getfield 450	com/tencent/mm/plugin/appbrand/q/a/b:kVY	I
    //   2416: ldc_w 451
    //   2419: imul
    //   2420: if_icmplt +341 -> 2761
    //   2423: iload_1
    //   2424: istore_2
    //   2425: iload_1
    //   2426: istore_3
    //   2427: iload_1
    //   2428: istore 4
    //   2430: iload_1
    //   2431: istore 5
    //   2433: iload_1
    //   2434: istore 6
    //   2436: iload_1
    //   2437: istore 7
    //   2439: ldc 116
    //   2441: ldc_w 453
    //   2444: iconst_1
    //   2445: anewarray 4	java/lang/Object
    //   2448: dup
    //   2449: iconst_0
    //   2450: iload 14
    //   2452: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2455: aastore
    //   2456: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2459: iload_1
    //   2460: istore_2
    //   2461: iload_1
    //   2462: istore_3
    //   2463: iload_1
    //   2464: istore 4
    //   2466: iload_1
    //   2467: istore 5
    //   2469: iload_1
    //   2470: istore 6
    //   2472: iload_1
    //   2473: istore 7
    //   2475: aload_0
    //   2476: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   2479: aload_0
    //   2480: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   2483: aload_0
    //   2484: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   2487: ldc_w 455
    //   2490: invokeinterface 212 4 0
    //   2495: aload_0
    //   2496: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   2499: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   2502: ifeq +208 -> 2710
    //   2505: ldc 220
    //   2507: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2510: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   2513: aload_0
    //   2514: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   2517: invokeinterface 225 1 0
    //   2522: aload_0
    //   2523: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   2526: ldc 229
    //   2528: aload_0
    //   2529: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   2532: lconst_0
    //   2533: lconst_0
    //   2534: iload_1
    //   2535: iconst_2
    //   2536: aload_0
    //   2537: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   2540: aload_0
    //   2541: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   2544: aload_0
    //   2545: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   2548: invokeinterface 239 14 0
    //   2553: ldc 145
    //   2555: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2558: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   2561: ldc2_w 152
    //   2564: ldc2_w 437
    //   2567: lconst_1
    //   2568: iconst_0
    //   2569: invokeinterface 157 8 0
    //   2574: ldc 145
    //   2576: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2579: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   2582: ldc2_w 152
    //   2585: ldc2_w 439
    //   2588: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   2591: aload_0
    //   2592: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   2595: lsub
    //   2596: iconst_0
    //   2597: invokeinterface 157 8 0
    //   2602: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   2605: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   2608: istore_1
    //   2609: iload_1
    //   2610: iconst_m1
    //   2611: if_icmpne +24 -> 2635
    //   2614: ldc 145
    //   2616: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2619: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   2622: ldc2_w 152
    //   2625: ldc2_w 445
    //   2628: lconst_1
    //   2629: iconst_0
    //   2630: invokeinterface 157 8 0
    //   2635: ldc 116
    //   2637: ldc_w 448
    //   2640: iconst_2
    //   2641: anewarray 4	java/lang/Object
    //   2644: dup
    //   2645: iconst_0
    //   2646: aload_0
    //   2647: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   2650: aastore
    //   2651: dup
    //   2652: iconst_1
    //   2653: iload_1
    //   2654: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2657: aastore
    //   2658: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2661: aload_0
    //   2662: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   2665: aload_0
    //   2666: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   2669: aload_0
    //   2670: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   2673: invokeinterface 367 2 0
    //   2678: ldc 116
    //   2680: ldc_w 369
    //   2683: iconst_2
    //   2684: anewarray 4	java/lang/Object
    //   2687: dup
    //   2688: iconst_0
    //   2689: aload_0
    //   2690: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   2693: aastore
    //   2694: dup
    //   2695: iconst_1
    //   2696: aload_0
    //   2697: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   2700: aastore
    //   2701: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2704: ldc 205
    //   2706: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2709: return
    //   2710: ldc 220
    //   2712: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2715: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   2718: aload_0
    //   2719: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   2722: invokeinterface 225 1 0
    //   2727: aload_0
    //   2728: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   2731: ldc 229
    //   2733: aload_0
    //   2734: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   2737: lconst_0
    //   2738: lconst_0
    //   2739: iload_1
    //   2740: iconst_2
    //   2741: aload_0
    //   2742: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   2745: aload_0
    //   2746: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   2749: aload_0
    //   2750: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   2753: invokeinterface 239 14 0
    //   2758: goto -205 -> 2553
    //   2761: iload_1
    //   2762: istore_2
    //   2763: iload_1
    //   2764: istore_3
    //   2765: iload_1
    //   2766: istore 4
    //   2768: iload_1
    //   2769: istore 5
    //   2771: iload_1
    //   2772: istore 7
    //   2774: ldc_w 298
    //   2777: aload_0
    //   2778: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   2781: invokevirtual 458	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   2784: invokevirtual 462	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2787: ifeq +351 -> 3138
    //   2790: iload_1
    //   2791: istore_2
    //   2792: iload_1
    //   2793: istore_3
    //   2794: iload_1
    //   2795: istore 4
    //   2797: iload_1
    //   2798: istore 5
    //   2800: iload_1
    //   2801: istore 7
    //   2803: new 464	java/util/zip/GZIPInputStream
    //   2806: dup
    //   2807: aload_0
    //   2808: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   2811: invokevirtual 468	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2814: invokespecial 471	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   2817: astore 28
    //   2819: new 473	com/tencent/mm/vfs/e
    //   2822: dup
    //   2823: aload_0
    //   2824: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   2827: invokespecial 474	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   2830: astore 29
    //   2832: aload 29
    //   2834: invokevirtual 477	com/tencent/mm/vfs/e:exists	()Z
    //   2837: ifeq +701 -> 3538
    //   2840: ldc 116
    //   2842: ldc_w 479
    //   2845: iconst_2
    //   2846: anewarray 4	java/lang/Object
    //   2849: dup
    //   2850: iconst_0
    //   2851: aload_0
    //   2852: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   2855: aastore
    //   2856: dup
    //   2857: iconst_1
    //   2858: aload_0
    //   2859: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   2862: aastore
    //   2863: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2866: aload 29
    //   2868: invokevirtual 482	com/tencent/mm/vfs/e:delete	()Z
    //   2871: ifne +667 -> 3538
    //   2874: ldc 116
    //   2876: ldc_w 484
    //   2879: iconst_1
    //   2880: anewarray 4	java/lang/Object
    //   2883: dup
    //   2884: iconst_0
    //   2885: aload_0
    //   2886: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   2889: aastore
    //   2890: invokestatic 410	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2893: aload_0
    //   2894: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   2897: aload_0
    //   2898: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   2901: aload_0
    //   2902: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   2905: ldc_w 486
    //   2908: invokeinterface 212 4 0
    //   2913: aload_0
    //   2914: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   2917: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   2920: ifeq +468 -> 3388
    //   2923: ldc 220
    //   2925: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2928: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   2931: aload_0
    //   2932: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   2935: invokeinterface 225 1 0
    //   2940: aload_0
    //   2941: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   2944: ldc 229
    //   2946: aload_0
    //   2947: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   2950: lconst_0
    //   2951: lconst_0
    //   2952: iload_1
    //   2953: iconst_2
    //   2954: aload_0
    //   2955: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   2958: aload_0
    //   2959: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   2962: aload_0
    //   2963: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   2966: invokeinterface 239 14 0
    //   2971: ldc 145
    //   2973: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2976: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   2979: ldc2_w 152
    //   2982: ldc2_w 437
    //   2985: lconst_1
    //   2986: iconst_0
    //   2987: invokeinterface 157 8 0
    //   2992: ldc 145
    //   2994: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2997: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   3000: ldc2_w 152
    //   3003: ldc2_w 439
    //   3006: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   3009: aload_0
    //   3010: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   3013: lsub
    //   3014: iconst_0
    //   3015: invokeinterface 157 8 0
    //   3020: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   3023: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   3026: istore_1
    //   3027: iload_1
    //   3028: iconst_m1
    //   3029: if_icmpne +24 -> 3053
    //   3032: ldc 145
    //   3034: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3037: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   3040: ldc2_w 152
    //   3043: ldc2_w 445
    //   3046: lconst_1
    //   3047: iconst_0
    //   3048: invokeinterface 157 8 0
    //   3053: ldc 116
    //   3055: ldc_w 448
    //   3058: iconst_2
    //   3059: anewarray 4	java/lang/Object
    //   3062: dup
    //   3063: iconst_0
    //   3064: aload_0
    //   3065: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   3068: aastore
    //   3069: dup
    //   3070: iconst_1
    //   3071: iload_1
    //   3072: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3075: aastore
    //   3076: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3079: aload 28
    //   3081: ifnull +8 -> 3089
    //   3084: aload 28
    //   3086: invokevirtual 359	java/io/InputStream:close	()V
    //   3089: aload_0
    //   3090: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   3093: aload_0
    //   3094: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   3097: aload_0
    //   3098: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   3101: invokeinterface 367 2 0
    //   3106: ldc 116
    //   3108: ldc_w 369
    //   3111: iconst_2
    //   3112: anewarray 4	java/lang/Object
    //   3115: dup
    //   3116: iconst_0
    //   3117: aload_0
    //   3118: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   3121: aastore
    //   3122: dup
    //   3123: iconst_1
    //   3124: aload_0
    //   3125: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3128: aastore
    //   3129: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3132: ldc 205
    //   3134: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3137: return
    //   3138: iload_1
    //   3139: istore_2
    //   3140: iload_1
    //   3141: istore_3
    //   3142: iload_1
    //   3143: istore 4
    //   3145: iload_1
    //   3146: istore 5
    //   3148: iload_1
    //   3149: istore 7
    //   3151: ldc_w 488
    //   3154: aload_0
    //   3155: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   3158: invokevirtual 458	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3161: invokevirtual 462	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3164: ifeq +174 -> 3338
    //   3167: iload_1
    //   3168: istore_2
    //   3169: iload_1
    //   3170: istore_3
    //   3171: iload_1
    //   3172: istore 4
    //   3174: iload_1
    //   3175: istore 5
    //   3177: iload_1
    //   3178: istore 7
    //   3180: new 490	java/util/zip/InflaterInputStream
    //   3183: dup
    //   3184: aload_0
    //   3185: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   3188: invokevirtual 468	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3191: new 492	java/util/zip/Inflater
    //   3194: dup
    //   3195: iconst_1
    //   3196: invokespecial 494	java/util/zip/Inflater:<init>	(Z)V
    //   3199: invokespecial 497	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3202: astore 28
    //   3204: goto -385 -> 2819
    //   3207: astore 27
    //   3209: iload_1
    //   3210: istore_2
    //   3211: iload_1
    //   3212: istore_3
    //   3213: iload_1
    //   3214: istore 4
    //   3216: iload_1
    //   3217: istore 5
    //   3219: iload_1
    //   3220: istore 6
    //   3222: iload_1
    //   3223: istore 7
    //   3225: ldc 116
    //   3227: aload 27
    //   3229: ldc_w 499
    //   3232: iconst_0
    //   3233: anewarray 4	java/lang/Object
    //   3236: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3239: iload_1
    //   3240: istore_2
    //   3241: iload_1
    //   3242: istore_3
    //   3243: iload_1
    //   3244: istore 4
    //   3246: iload_1
    //   3247: istore 5
    //   3249: iload_1
    //   3250: istore 7
    //   3252: ldc_w 298
    //   3255: aload_0
    //   3256: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   3259: invokevirtual 458	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3262: invokevirtual 462	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3265: ifeq +98 -> 3363
    //   3268: iload_1
    //   3269: istore_2
    //   3270: iload_1
    //   3271: istore_3
    //   3272: iload_1
    //   3273: istore 4
    //   3275: iload_1
    //   3276: istore 5
    //   3278: iload_1
    //   3279: istore 7
    //   3281: new 464	java/util/zip/GZIPInputStream
    //   3284: dup
    //   3285: aload_0
    //   3286: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   3289: invokevirtual 502	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   3292: invokespecial 471	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3295: astore 28
    //   3297: goto -478 -> 2819
    //   3300: astore 28
    //   3302: iload_1
    //   3303: istore_2
    //   3304: iload_1
    //   3305: istore_3
    //   3306: iload_1
    //   3307: istore 4
    //   3309: iload_1
    //   3310: istore 5
    //   3312: iload_1
    //   3313: istore 6
    //   3315: iload_1
    //   3316: istore 7
    //   3318: ldc 116
    //   3320: aload 27
    //   3322: ldc_w 504
    //   3325: iconst_0
    //   3326: anewarray 4	java/lang/Object
    //   3329: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3332: aconst_null
    //   3333: astore 28
    //   3335: goto -516 -> 2819
    //   3338: iload_1
    //   3339: istore_2
    //   3340: iload_1
    //   3341: istore_3
    //   3342: iload_1
    //   3343: istore 4
    //   3345: iload_1
    //   3346: istore 5
    //   3348: iload_1
    //   3349: istore 7
    //   3351: aload_0
    //   3352: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   3355: invokevirtual 468	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3358: astore 28
    //   3360: goto -541 -> 2819
    //   3363: iload_1
    //   3364: istore_2
    //   3365: iload_1
    //   3366: istore_3
    //   3367: iload_1
    //   3368: istore 4
    //   3370: iload_1
    //   3371: istore 5
    //   3373: iload_1
    //   3374: istore 7
    //   3376: aload_0
    //   3377: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   3380: invokevirtual 502	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   3383: astore 28
    //   3385: goto -566 -> 2819
    //   3388: ldc 220
    //   3390: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3393: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   3396: aload_0
    //   3397: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   3400: invokeinterface 225 1 0
    //   3405: aload_0
    //   3406: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   3409: ldc 229
    //   3411: aload_0
    //   3412: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   3415: lconst_0
    //   3416: lconst_0
    //   3417: iload_1
    //   3418: iconst_2
    //   3419: aload_0
    //   3420: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   3423: aload_0
    //   3424: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   3427: aload_0
    //   3428: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   3431: invokeinterface 239 14 0
    //   3436: goto -465 -> 2971
    //   3439: astore 27
    //   3441: ldc 116
    //   3443: aload 27
    //   3445: ldc_w 506
    //   3448: iconst_2
    //   3449: anewarray 4	java/lang/Object
    //   3452: dup
    //   3453: iconst_0
    //   3454: aload_0
    //   3455: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3458: aastore
    //   3459: dup
    //   3460: iconst_1
    //   3461: aload_0
    //   3462: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3465: aastore
    //   3466: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3469: goto -380 -> 3089
    //   3472: astore 27
    //   3474: ldc 116
    //   3476: aload 27
    //   3478: ldc_w 508
    //   3481: iconst_2
    //   3482: anewarray 4	java/lang/Object
    //   3485: dup
    //   3486: iconst_0
    //   3487: aload_0
    //   3488: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3491: aastore
    //   3492: dup
    //   3493: iconst_1
    //   3494: aload_0
    //   3495: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3498: aastore
    //   3499: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3502: goto -413 -> 3089
    //   3505: astore 27
    //   3507: ldc 116
    //   3509: aload 27
    //   3511: ldc_w 510
    //   3514: iconst_2
    //   3515: anewarray 4	java/lang/Object
    //   3518: dup
    //   3519: iconst_0
    //   3520: aload_0
    //   3521: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3524: aastore
    //   3525: dup
    //   3526: iconst_1
    //   3527: aload_0
    //   3528: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3531: aastore
    //   3532: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3535: goto -446 -> 3089
    //   3538: aload 29
    //   3540: invokevirtual 514	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   3543: invokevirtual 477	com/tencent/mm/vfs/e:exists	()Z
    //   3546: ifne +454 -> 4000
    //   3549: ldc 116
    //   3551: ldc_w 516
    //   3554: iconst_2
    //   3555: anewarray 4	java/lang/Object
    //   3558: dup
    //   3559: iconst_0
    //   3560: aload_0
    //   3561: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   3564: aastore
    //   3565: dup
    //   3566: iconst_1
    //   3567: aload_0
    //   3568: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3571: aastore
    //   3572: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3575: aload 29
    //   3577: invokevirtual 514	com/tencent/mm/vfs/e:fhT	()Lcom/tencent/mm/vfs/e;
    //   3580: invokevirtual 519	com/tencent/mm/vfs/e:mkdirs	()Z
    //   3583: ifne +417 -> 4000
    //   3586: ldc 116
    //   3588: ldc_w 521
    //   3591: iconst_1
    //   3592: anewarray 4	java/lang/Object
    //   3595: dup
    //   3596: iconst_0
    //   3597: aload_0
    //   3598: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3601: aastore
    //   3602: invokestatic 410	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3605: aload_0
    //   3606: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   3609: aload_0
    //   3610: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3613: aload_0
    //   3614: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3617: ldc_w 523
    //   3620: invokeinterface 212 4 0
    //   3625: aload_0
    //   3626: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   3629: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   3632: ifeq +218 -> 3850
    //   3635: ldc 220
    //   3637: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3640: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   3643: aload_0
    //   3644: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   3647: invokeinterface 225 1 0
    //   3652: aload_0
    //   3653: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   3656: ldc 229
    //   3658: aload_0
    //   3659: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   3662: lconst_0
    //   3663: lconst_0
    //   3664: iload_1
    //   3665: iconst_2
    //   3666: aload_0
    //   3667: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   3670: aload_0
    //   3671: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3674: aload_0
    //   3675: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   3678: invokeinterface 239 14 0
    //   3683: ldc 145
    //   3685: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3688: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   3691: ldc2_w 152
    //   3694: ldc2_w 437
    //   3697: lconst_1
    //   3698: iconst_0
    //   3699: invokeinterface 157 8 0
    //   3704: ldc 145
    //   3706: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3709: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   3712: ldc2_w 152
    //   3715: ldc2_w 439
    //   3718: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   3721: aload_0
    //   3722: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   3725: lsub
    //   3726: iconst_0
    //   3727: invokeinterface 157 8 0
    //   3732: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   3735: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   3738: istore_1
    //   3739: iload_1
    //   3740: iconst_m1
    //   3741: if_icmpne +24 -> 3765
    //   3744: ldc 145
    //   3746: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3749: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   3752: ldc2_w 152
    //   3755: ldc2_w 445
    //   3758: lconst_1
    //   3759: iconst_0
    //   3760: invokeinterface 157 8 0
    //   3765: ldc 116
    //   3767: ldc_w 448
    //   3770: iconst_2
    //   3771: anewarray 4	java/lang/Object
    //   3774: dup
    //   3775: iconst_0
    //   3776: aload_0
    //   3777: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   3780: aastore
    //   3781: dup
    //   3782: iconst_1
    //   3783: iload_1
    //   3784: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3787: aastore
    //   3788: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3791: aload 28
    //   3793: ifnull +8 -> 3801
    //   3796: aload 28
    //   3798: invokevirtual 359	java/io/InputStream:close	()V
    //   3801: aload_0
    //   3802: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   3805: aload_0
    //   3806: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   3809: aload_0
    //   3810: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   3813: invokeinterface 367 2 0
    //   3818: ldc 116
    //   3820: ldc_w 369
    //   3823: iconst_2
    //   3824: anewarray 4	java/lang/Object
    //   3827: dup
    //   3828: iconst_0
    //   3829: aload_0
    //   3830: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   3833: aastore
    //   3834: dup
    //   3835: iconst_1
    //   3836: aload_0
    //   3837: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3840: aastore
    //   3841: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3844: ldc 205
    //   3846: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3849: return
    //   3850: ldc 220
    //   3852: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3855: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   3858: aload_0
    //   3859: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   3862: invokeinterface 225 1 0
    //   3867: aload_0
    //   3868: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   3871: ldc 229
    //   3873: aload_0
    //   3874: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   3877: lconst_0
    //   3878: lconst_0
    //   3879: iload_1
    //   3880: iconst_2
    //   3881: aload_0
    //   3882: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   3885: aload_0
    //   3886: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   3889: aload_0
    //   3890: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   3893: invokeinterface 239 14 0
    //   3898: goto -215 -> 3683
    //   3901: astore 27
    //   3903: ldc 116
    //   3905: aload 27
    //   3907: ldc_w 506
    //   3910: iconst_2
    //   3911: anewarray 4	java/lang/Object
    //   3914: dup
    //   3915: iconst_0
    //   3916: aload_0
    //   3917: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3920: aastore
    //   3921: dup
    //   3922: iconst_1
    //   3923: aload_0
    //   3924: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3927: aastore
    //   3928: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3931: goto -130 -> 3801
    //   3934: astore 27
    //   3936: ldc 116
    //   3938: aload 27
    //   3940: ldc_w 508
    //   3943: iconst_2
    //   3944: anewarray 4	java/lang/Object
    //   3947: dup
    //   3948: iconst_0
    //   3949: aload_0
    //   3950: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3953: aastore
    //   3954: dup
    //   3955: iconst_1
    //   3956: aload_0
    //   3957: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3960: aastore
    //   3961: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3964: goto -163 -> 3801
    //   3967: astore 27
    //   3969: ldc 116
    //   3971: aload 27
    //   3973: ldc_w 510
    //   3976: iconst_2
    //   3977: anewarray 4	java/lang/Object
    //   3980: dup
    //   3981: iconst_0
    //   3982: aload_0
    //   3983: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   3986: aastore
    //   3987: dup
    //   3988: iconst_1
    //   3989: aload_0
    //   3990: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   3993: aastore
    //   3994: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3997: goto -196 -> 3801
    //   4000: aload 28
    //   4002: ifnull +6275 -> 10277
    //   4005: aload 29
    //   4007: invokestatic 529	com/tencent/mm/vfs/i:ai	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   4010: astore 27
    //   4012: iload 14
    //   4014: i2l
    //   4015: lstore 21
    //   4017: lload 21
    //   4019: invokestatic 533	com/tencent/mm/plugin/appbrand/q/j:nk	(J)I
    //   4022: newarray byte
    //   4024: astore 30
    //   4026: iconst_m1
    //   4027: istore_2
    //   4028: lconst_0
    //   4029: lstore 19
    //   4031: aload 28
    //   4033: aload 30
    //   4035: invokevirtual 537	java/io/InputStream:read	([B)I
    //   4038: istore_3
    //   4039: iload_3
    //   4040: iconst_m1
    //   4041: if_icmpeq +1080 -> 5121
    //   4044: aload_0
    //   4045: getfield 69	com/tencent/mm/plugin/appbrand/q/a/b:isRunning	Z
    //   4048: ifeq +1073 -> 5121
    //   4051: aload_0
    //   4052: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   4055: invokestatic 541	com/tencent/mm/plugin/appbrand/q/j:F	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;)Z
    //   4058: ifeq +443 -> 4501
    //   4061: aload_0
    //   4062: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   4065: aload_0
    //   4066: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   4069: aload_0
    //   4070: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4073: ldc_w 543
    //   4076: invokeinterface 212 4 0
    //   4081: aload_0
    //   4082: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   4085: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   4088: ifeq +229 -> 4317
    //   4091: ldc 220
    //   4093: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4096: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   4099: aload_0
    //   4100: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   4103: invokeinterface 225 1 0
    //   4108: aload_0
    //   4109: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   4112: ldc 229
    //   4114: aload_0
    //   4115: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   4118: lconst_0
    //   4119: lload 19
    //   4121: iload_1
    //   4122: iconst_2
    //   4123: aload_0
    //   4124: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   4127: aload_0
    //   4128: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   4131: aload_0
    //   4132: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   4135: invokeinterface 239 14 0
    //   4140: ldc 145
    //   4142: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4145: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   4148: ldc2_w 152
    //   4151: ldc2_w 437
    //   4154: lconst_1
    //   4155: iconst_0
    //   4156: invokeinterface 157 8 0
    //   4161: ldc 145
    //   4163: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4166: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   4169: ldc2_w 152
    //   4172: ldc2_w 439
    //   4175: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   4178: aload_0
    //   4179: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   4182: lsub
    //   4183: iconst_0
    //   4184: invokeinterface 157 8 0
    //   4189: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   4192: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   4195: istore_1
    //   4196: iload_1
    //   4197: iconst_m1
    //   4198: if_icmpne +24 -> 4222
    //   4201: ldc 145
    //   4203: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4206: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   4209: ldc2_w 152
    //   4212: ldc2_w 445
    //   4215: lconst_1
    //   4216: iconst_0
    //   4217: invokeinterface 157 8 0
    //   4222: ldc 116
    //   4224: ldc_w 448
    //   4227: iconst_2
    //   4228: anewarray 4	java/lang/Object
    //   4231: dup
    //   4232: iconst_0
    //   4233: aload_0
    //   4234: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   4237: aastore
    //   4238: dup
    //   4239: iconst_1
    //   4240: iload_1
    //   4241: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4244: aastore
    //   4245: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4248: aload 27
    //   4250: ifnull +8 -> 4258
    //   4253: aload 27
    //   4255: invokevirtual 356	java/io/OutputStream:close	()V
    //   4258: aload 28
    //   4260: ifnull +8 -> 4268
    //   4263: aload 28
    //   4265: invokevirtual 359	java/io/InputStream:close	()V
    //   4268: aload_0
    //   4269: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   4272: aload_0
    //   4273: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   4276: aload_0
    //   4277: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   4280: invokeinterface 367 2 0
    //   4285: ldc 116
    //   4287: ldc_w 369
    //   4290: iconst_2
    //   4291: anewarray 4	java/lang/Object
    //   4294: dup
    //   4295: iconst_0
    //   4296: aload_0
    //   4297: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   4300: aastore
    //   4301: dup
    //   4302: iconst_1
    //   4303: aload_0
    //   4304: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4307: aastore
    //   4308: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4311: ldc 205
    //   4313: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4316: return
    //   4317: ldc 220
    //   4319: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4322: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   4325: aload_0
    //   4326: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   4329: invokeinterface 225 1 0
    //   4334: aload_0
    //   4335: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   4338: ldc 229
    //   4340: aload_0
    //   4341: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   4344: lconst_0
    //   4345: lload 19
    //   4347: iload_1
    //   4348: iconst_2
    //   4349: aload_0
    //   4350: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   4353: aload_0
    //   4354: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   4357: aload_0
    //   4358: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   4361: invokeinterface 239 14 0
    //   4366: goto -226 -> 4140
    //   4369: astore 27
    //   4371: ldc 116
    //   4373: aload 27
    //   4375: ldc_w 506
    //   4378: iconst_2
    //   4379: anewarray 4	java/lang/Object
    //   4382: dup
    //   4383: iconst_0
    //   4384: aload_0
    //   4385: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4388: aastore
    //   4389: dup
    //   4390: iconst_1
    //   4391: aload_0
    //   4392: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   4395: aastore
    //   4396: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4399: goto -141 -> 4258
    //   4402: astore 27
    //   4404: ldc 116
    //   4406: aload 27
    //   4408: ldc_w 506
    //   4411: iconst_2
    //   4412: anewarray 4	java/lang/Object
    //   4415: dup
    //   4416: iconst_0
    //   4417: aload_0
    //   4418: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4421: aastore
    //   4422: dup
    //   4423: iconst_1
    //   4424: aload_0
    //   4425: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   4428: aastore
    //   4429: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4432: goto -164 -> 4268
    //   4435: astore 27
    //   4437: ldc 116
    //   4439: aload 27
    //   4441: ldc_w 508
    //   4444: iconst_2
    //   4445: anewarray 4	java/lang/Object
    //   4448: dup
    //   4449: iconst_0
    //   4450: aload_0
    //   4451: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4454: aastore
    //   4455: dup
    //   4456: iconst_1
    //   4457: aload_0
    //   4458: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   4461: aastore
    //   4462: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4465: goto -197 -> 4268
    //   4468: astore 27
    //   4470: ldc 116
    //   4472: aload 27
    //   4474: ldc_w 510
    //   4477: iconst_2
    //   4478: anewarray 4	java/lang/Object
    //   4481: dup
    //   4482: iconst_0
    //   4483: aload_0
    //   4484: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4487: aastore
    //   4488: dup
    //   4489: iconst_1
    //   4490: aload_0
    //   4491: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   4494: aastore
    //   4495: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4498: goto -230 -> 4268
    //   4501: aload 27
    //   4503: aload 30
    //   4505: iconst_0
    //   4506: iload_3
    //   4507: invokevirtual 547	java/io/OutputStream:write	([BII)V
    //   4510: lload 19
    //   4512: iload_3
    //   4513: i2l
    //   4514: ladd
    //   4515: lstore 19
    //   4517: iload_2
    //   4518: istore_3
    //   4519: lload 25
    //   4521: lconst_0
    //   4522: lcmp
    //   4523: ifle +90 -> 4613
    //   4526: iload_2
    //   4527: istore_3
    //   4528: aload_0
    //   4529: getfield 69	com/tencent/mm/plugin/appbrand/q/a/b:isRunning	Z
    //   4532: ifeq +81 -> 4613
    //   4535: ldc2_w 548
    //   4538: lload 19
    //   4540: lmul
    //   4541: lload 25
    //   4543: ldiv
    //   4544: l2i
    //   4545: istore 4
    //   4547: iload_2
    //   4548: istore_3
    //   4549: iload_2
    //   4550: iload 4
    //   4552: if_icmpeq +25 -> 4577
    //   4555: aload_0
    //   4556: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   4559: aload_0
    //   4560: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4563: iload 4
    //   4565: lload 19
    //   4567: lload 25
    //   4569: invokeinterface 552 7 0
    //   4574: iload 4
    //   4576: istore_3
    //   4577: ldc 116
    //   4579: ldc_w 554
    //   4582: iconst_3
    //   4583: anewarray 4	java/lang/Object
    //   4586: dup
    //   4587: iconst_0
    //   4588: lload 19
    //   4590: invokestatic 124	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4593: aastore
    //   4594: dup
    //   4595: iconst_1
    //   4596: lload 25
    //   4598: invokestatic 124	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4601: aastore
    //   4602: dup
    //   4603: iconst_2
    //   4604: iload 4
    //   4606: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4609: aastore
    //   4610: invokestatic 557	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4613: lload 19
    //   4615: lconst_0
    //   4616: lcmp
    //   4617: ifle +5655 -> 10272
    //   4620: aload_0
    //   4621: getfield 450	com/tencent/mm/plugin/appbrand/q/a/b:kVY	I
    //   4624: ifle +5648 -> 10272
    //   4627: lload 19
    //   4629: aload_0
    //   4630: getfield 450	com/tencent/mm/plugin/appbrand/q/a/b:kVY	I
    //   4633: i2l
    //   4634: ldc2_w 558
    //   4637: lmul
    //   4638: lcmp
    //   4639: iflt +5633 -> 10272
    //   4642: ldc 116
    //   4644: ldc_w 561
    //   4647: iconst_1
    //   4648: anewarray 4	java/lang/Object
    //   4651: dup
    //   4652: iconst_0
    //   4653: lload 19
    //   4655: invokestatic 124	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4658: aastore
    //   4659: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4662: aload_0
    //   4663: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   4666: aload_0
    //   4667: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   4670: aload_0
    //   4671: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4674: ldc_w 455
    //   4677: invokeinterface 212 4 0
    //   4682: aload 27
    //   4684: invokestatic 565	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   4687: aload 28
    //   4689: invokestatic 565	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   4692: aload 29
    //   4694: invokevirtual 568	com/tencent/mm/vfs/e:getAbsolutePath	()Ljava/lang/String;
    //   4697: invokestatic 571	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   4700: pop
    //   4701: aload_0
    //   4702: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   4705: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   4708: ifeq +229 -> 4937
    //   4711: ldc 220
    //   4713: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4716: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   4719: aload_0
    //   4720: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   4723: invokeinterface 225 1 0
    //   4728: aload_0
    //   4729: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   4732: ldc 229
    //   4734: aload_0
    //   4735: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   4738: lconst_0
    //   4739: lload 19
    //   4741: iload_1
    //   4742: iconst_2
    //   4743: aload_0
    //   4744: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   4747: aload_0
    //   4748: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   4751: aload_0
    //   4752: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   4755: invokeinterface 239 14 0
    //   4760: ldc 145
    //   4762: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4765: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   4768: ldc2_w 152
    //   4771: ldc2_w 437
    //   4774: lconst_1
    //   4775: iconst_0
    //   4776: invokeinterface 157 8 0
    //   4781: ldc 145
    //   4783: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4786: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   4789: ldc2_w 152
    //   4792: ldc2_w 439
    //   4795: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   4798: aload_0
    //   4799: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   4802: lsub
    //   4803: iconst_0
    //   4804: invokeinterface 157 8 0
    //   4809: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   4812: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   4815: istore_1
    //   4816: iload_1
    //   4817: iconst_m1
    //   4818: if_icmpne +24 -> 4842
    //   4821: ldc 145
    //   4823: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4826: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   4829: ldc2_w 152
    //   4832: ldc2_w 445
    //   4835: lconst_1
    //   4836: iconst_0
    //   4837: invokeinterface 157 8 0
    //   4842: ldc 116
    //   4844: ldc_w 448
    //   4847: iconst_2
    //   4848: anewarray 4	java/lang/Object
    //   4851: dup
    //   4852: iconst_0
    //   4853: aload_0
    //   4854: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   4857: aastore
    //   4858: dup
    //   4859: iconst_1
    //   4860: iload_1
    //   4861: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4864: aastore
    //   4865: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4868: aload 27
    //   4870: ifnull +8 -> 4878
    //   4873: aload 27
    //   4875: invokevirtual 356	java/io/OutputStream:close	()V
    //   4878: aload 28
    //   4880: ifnull +8 -> 4888
    //   4883: aload 28
    //   4885: invokevirtual 359	java/io/InputStream:close	()V
    //   4888: aload_0
    //   4889: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   4892: aload_0
    //   4893: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   4896: aload_0
    //   4897: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   4900: invokeinterface 367 2 0
    //   4905: ldc 116
    //   4907: ldc_w 369
    //   4910: iconst_2
    //   4911: anewarray 4	java/lang/Object
    //   4914: dup
    //   4915: iconst_0
    //   4916: aload_0
    //   4917: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   4920: aastore
    //   4921: dup
    //   4922: iconst_1
    //   4923: aload_0
    //   4924: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   4927: aastore
    //   4928: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4931: ldc 205
    //   4933: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4936: return
    //   4937: ldc 220
    //   4939: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4942: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   4945: aload_0
    //   4946: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   4949: invokeinterface 225 1 0
    //   4954: aload_0
    //   4955: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   4958: ldc 229
    //   4960: aload_0
    //   4961: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   4964: lconst_0
    //   4965: lload 19
    //   4967: iload_1
    //   4968: iconst_2
    //   4969: aload_0
    //   4970: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   4973: aload_0
    //   4974: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   4977: aload_0
    //   4978: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   4981: invokeinterface 239 14 0
    //   4986: goto -226 -> 4760
    //   4989: astore 27
    //   4991: ldc 116
    //   4993: aload 27
    //   4995: ldc_w 506
    //   4998: iconst_2
    //   4999: anewarray 4	java/lang/Object
    //   5002: dup
    //   5003: iconst_0
    //   5004: aload_0
    //   5005: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5008: aastore
    //   5009: dup
    //   5010: iconst_1
    //   5011: aload_0
    //   5012: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5015: aastore
    //   5016: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5019: goto -141 -> 4878
    //   5022: astore 27
    //   5024: ldc 116
    //   5026: aload 27
    //   5028: ldc_w 506
    //   5031: iconst_2
    //   5032: anewarray 4	java/lang/Object
    //   5035: dup
    //   5036: iconst_0
    //   5037: aload_0
    //   5038: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5041: aastore
    //   5042: dup
    //   5043: iconst_1
    //   5044: aload_0
    //   5045: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5048: aastore
    //   5049: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5052: goto -164 -> 4888
    //   5055: astore 27
    //   5057: ldc 116
    //   5059: aload 27
    //   5061: ldc_w 508
    //   5064: iconst_2
    //   5065: anewarray 4	java/lang/Object
    //   5068: dup
    //   5069: iconst_0
    //   5070: aload_0
    //   5071: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5074: aastore
    //   5075: dup
    //   5076: iconst_1
    //   5077: aload_0
    //   5078: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5081: aastore
    //   5082: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5085: goto -197 -> 4888
    //   5088: astore 27
    //   5090: ldc 116
    //   5092: aload 27
    //   5094: ldc_w 510
    //   5097: iconst_2
    //   5098: anewarray 4	java/lang/Object
    //   5101: dup
    //   5102: iconst_0
    //   5103: aload_0
    //   5104: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5107: aastore
    //   5108: dup
    //   5109: iconst_1
    //   5110: aload_0
    //   5111: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5114: aastore
    //   5115: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5118: goto -230 -> 4888
    //   5121: aload 27
    //   5123: invokevirtual 574	java/io/OutputStream:flush	()V
    //   5126: iload_1
    //   5127: istore_3
    //   5128: lload 19
    //   5130: lstore 21
    //   5132: aload 27
    //   5134: astore 31
    //   5136: iload 13
    //   5138: istore_2
    //   5139: aload 28
    //   5141: astore 30
    //   5143: aload_0
    //   5144: getfield 69	com/tencent/mm/plugin/appbrand/q/a/b:isRunning	Z
    //   5147: ifeq +376 -> 5523
    //   5150: iload_1
    //   5151: istore_3
    //   5152: lload 19
    //   5154: lstore 21
    //   5156: aload 27
    //   5158: astore 31
    //   5160: iload 13
    //   5162: istore_2
    //   5163: aload 28
    //   5165: astore 30
    //   5167: aload_0
    //   5168: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   5171: aload_0
    //   5172: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5175: aload_0
    //   5176: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   5179: aload_0
    //   5180: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5183: iload_1
    //   5184: lload 19
    //   5186: aconst_null
    //   5187: invokeinterface 431 8 0
    //   5192: iload_1
    //   5193: istore_3
    //   5194: lload 19
    //   5196: lstore 21
    //   5198: aload 27
    //   5200: astore 31
    //   5202: iload 13
    //   5204: istore_2
    //   5205: aload 28
    //   5207: astore 30
    //   5209: lload 25
    //   5211: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   5214: aload_0
    //   5215: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   5218: lsub
    //   5219: invokestatic 576	com/tencent/mm/plugin/appbrand/q/a/b:I	(JJ)V
    //   5222: iconst_1
    //   5223: istore_2
    //   5224: ldc 116
    //   5226: ldc_w 578
    //   5229: iconst_3
    //   5230: anewarray 4	java/lang/Object
    //   5233: dup
    //   5234: iconst_0
    //   5235: aload_0
    //   5236: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   5239: aastore
    //   5240: dup
    //   5241: iconst_1
    //   5242: aload_0
    //   5243: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5246: aastore
    //   5247: dup
    //   5248: iconst_2
    //   5249: aload_0
    //   5250: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5253: aastore
    //   5254: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5257: aload_0
    //   5258: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   5261: invokevirtual 468	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5264: invokevirtual 359	java/io/InputStream:close	()V
    //   5267: aload_0
    //   5268: getfield 260	com/tencent/mm/plugin/appbrand/q/a/b:kWa	Ljava/net/HttpURLConnection;
    //   5271: invokevirtual 581	java/net/HttpURLConnection:disconnect	()V
    //   5274: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   5277: lload 23
    //   5279: lsub
    //   5280: lstore 21
    //   5282: ldc_w 583
    //   5285: ldc_w 585
    //   5288: lload 21
    //   5290: invokestatic 588	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5293: invokevirtual 591	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5296: invokestatic 593	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5299: ldc 145
    //   5301: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5304: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   5307: ldc2_w 594
    //   5310: ldc2_w 596
    //   5313: lload 21
    //   5315: iconst_0
    //   5316: invokeinterface 157 8 0
    //   5321: ldc 145
    //   5323: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5326: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   5329: ldc2_w 594
    //   5332: ldc2_w 548
    //   5335: lconst_1
    //   5336: iconst_0
    //   5337: invokeinterface 157 8 0
    //   5342: iload_2
    //   5343: ifeq +299 -> 5642
    //   5346: aload_0
    //   5347: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   5350: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   5353: ifeq +237 -> 5590
    //   5356: ldc 220
    //   5358: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5361: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   5364: aload_0
    //   5365: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   5368: invokeinterface 225 1 0
    //   5373: aload_0
    //   5374: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   5377: ldc 229
    //   5379: aload_0
    //   5380: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   5383: lconst_0
    //   5384: lload 19
    //   5386: iload_1
    //   5387: iconst_1
    //   5388: aload_0
    //   5389: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   5392: aload_0
    //   5393: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5396: aload_0
    //   5397: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   5400: invokeinterface 239 14 0
    //   5405: ldc 145
    //   5407: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5410: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   5413: ldc2_w 152
    //   5416: ldc2_w 348
    //   5419: lconst_1
    //   5420: iconst_0
    //   5421: invokeinterface 157 8 0
    //   5426: ldc 145
    //   5428: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5431: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   5434: ldc2_w 152
    //   5437: ldc2_w 350
    //   5440: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   5443: aload_0
    //   5444: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   5447: lsub
    //   5448: iconst_0
    //   5449: invokeinterface 157 8 0
    //   5454: aload 27
    //   5456: ifnull +8 -> 5464
    //   5459: aload 27
    //   5461: invokevirtual 356	java/io/OutputStream:close	()V
    //   5464: aload 28
    //   5466: ifnull +8 -> 5474
    //   5469: aload 28
    //   5471: invokevirtual 359	java/io/InputStream:close	()V
    //   5474: aload_0
    //   5475: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   5478: aload_0
    //   5479: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   5482: aload_0
    //   5483: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   5486: invokeinterface 367 2 0
    //   5491: ldc 116
    //   5493: ldc_w 369
    //   5496: iconst_2
    //   5497: anewarray 4	java/lang/Object
    //   5500: dup
    //   5501: iconst_0
    //   5502: aload_0
    //   5503: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   5506: aastore
    //   5507: dup
    //   5508: iconst_1
    //   5509: aload_0
    //   5510: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5513: aastore
    //   5514: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5517: ldc 205
    //   5519: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5522: return
    //   5523: iload_1
    //   5524: istore_3
    //   5525: lload 19
    //   5527: lstore 21
    //   5529: aload 27
    //   5531: astore 31
    //   5533: iload 13
    //   5535: istore_2
    //   5536: aload 28
    //   5538: astore 30
    //   5540: aload_0
    //   5541: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   5544: aload_0
    //   5545: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5548: aload_0
    //   5549: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5552: ldc 207
    //   5554: invokeinterface 212 4 0
    //   5559: iconst_0
    //   5560: istore_2
    //   5561: goto -337 -> 5224
    //   5564: astore 29
    //   5566: ldc 116
    //   5568: aload 29
    //   5570: invokevirtual 600	java/io/IOException:getMessage	()Ljava/lang/String;
    //   5573: invokestatic 602	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5576: goto -309 -> 5267
    //   5579: astore 29
    //   5581: iload_2
    //   5582: istore_3
    //   5583: iload_1
    //   5584: istore_2
    //   5585: iload_3
    //   5586: istore_1
    //   5587: goto -4638 -> 949
    //   5590: ldc 220
    //   5592: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5595: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   5598: aload_0
    //   5599: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   5602: invokeinterface 225 1 0
    //   5607: aload_0
    //   5608: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   5611: ldc 229
    //   5613: aload_0
    //   5614: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   5617: lconst_0
    //   5618: lload 19
    //   5620: iload_1
    //   5621: iconst_1
    //   5622: aload_0
    //   5623: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   5626: aload_0
    //   5627: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   5630: aload_0
    //   5631: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   5634: invokeinterface 239 14 0
    //   5639: goto -234 -> 5405
    //   5642: aload_0
    //   5643: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   5646: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   5649: ifeq +163 -> 5812
    //   5652: ldc 220
    //   5654: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5657: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   5660: aload_0
    //   5661: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   5664: invokeinterface 225 1 0
    //   5669: aload_0
    //   5670: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   5673: ldc 229
    //   5675: aload_0
    //   5676: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   5679: lconst_0
    //   5680: lload 19
    //   5682: iload_1
    //   5683: iconst_2
    //   5684: aload_0
    //   5685: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   5688: aload_0
    //   5689: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5692: aload_0
    //   5693: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   5696: invokeinterface 239 14 0
    //   5701: ldc 145
    //   5703: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5706: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   5709: ldc2_w 152
    //   5712: ldc2_w 437
    //   5715: lconst_1
    //   5716: iconst_0
    //   5717: invokeinterface 157 8 0
    //   5722: ldc 145
    //   5724: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5727: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   5730: ldc2_w 152
    //   5733: ldc2_w 439
    //   5736: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   5739: aload_0
    //   5740: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   5743: lsub
    //   5744: iconst_0
    //   5745: invokeinterface 157 8 0
    //   5750: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   5753: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   5756: istore_1
    //   5757: iload_1
    //   5758: iconst_m1
    //   5759: if_icmpne +24 -> 5783
    //   5762: ldc 145
    //   5764: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5767: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   5770: ldc2_w 152
    //   5773: ldc2_w 445
    //   5776: lconst_1
    //   5777: iconst_0
    //   5778: invokeinterface 157 8 0
    //   5783: ldc 116
    //   5785: ldc_w 448
    //   5788: iconst_2
    //   5789: anewarray 4	java/lang/Object
    //   5792: dup
    //   5793: iconst_0
    //   5794: aload_0
    //   5795: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   5798: aastore
    //   5799: dup
    //   5800: iconst_1
    //   5801: iload_1
    //   5802: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5805: aastore
    //   5806: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5809: goto -355 -> 5454
    //   5812: ldc 220
    //   5814: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5817: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   5820: aload_0
    //   5821: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   5824: invokeinterface 225 1 0
    //   5829: aload_0
    //   5830: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   5833: ldc 229
    //   5835: aload_0
    //   5836: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   5839: lconst_0
    //   5840: lload 19
    //   5842: iload_1
    //   5843: iconst_2
    //   5844: aload_0
    //   5845: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   5848: aload_0
    //   5849: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   5852: aload_0
    //   5853: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   5856: invokeinterface 239 14 0
    //   5861: goto -160 -> 5701
    //   5864: astore 27
    //   5866: ldc 116
    //   5868: aload 27
    //   5870: ldc_w 506
    //   5873: iconst_2
    //   5874: anewarray 4	java/lang/Object
    //   5877: dup
    //   5878: iconst_0
    //   5879: aload_0
    //   5880: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5883: aastore
    //   5884: dup
    //   5885: iconst_1
    //   5886: aload_0
    //   5887: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5890: aastore
    //   5891: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5894: goto -430 -> 5464
    //   5897: astore 27
    //   5899: ldc 116
    //   5901: aload 27
    //   5903: ldc_w 506
    //   5906: iconst_2
    //   5907: anewarray 4	java/lang/Object
    //   5910: dup
    //   5911: iconst_0
    //   5912: aload_0
    //   5913: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5916: aastore
    //   5917: dup
    //   5918: iconst_1
    //   5919: aload_0
    //   5920: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5923: aastore
    //   5924: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5927: goto -453 -> 5474
    //   5930: astore 27
    //   5932: ldc 116
    //   5934: aload 27
    //   5936: ldc_w 508
    //   5939: iconst_2
    //   5940: anewarray 4	java/lang/Object
    //   5943: dup
    //   5944: iconst_0
    //   5945: aload_0
    //   5946: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5949: aastore
    //   5950: dup
    //   5951: iconst_1
    //   5952: aload_0
    //   5953: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5956: aastore
    //   5957: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5960: goto -486 -> 5474
    //   5963: astore 27
    //   5965: ldc 116
    //   5967: aload 27
    //   5969: ldc_w 510
    //   5972: iconst_2
    //   5973: anewarray 4	java/lang/Object
    //   5976: dup
    //   5977: iconst_0
    //   5978: aload_0
    //   5979: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   5982: aastore
    //   5983: dup
    //   5984: iconst_1
    //   5985: aload_0
    //   5986: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   5989: aastore
    //   5990: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5993: goto -519 -> 5474
    //   5996: ldc 220
    //   5998: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6001: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   6004: aload_0
    //   6005: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   6008: invokeinterface 225 1 0
    //   6013: aload_0
    //   6014: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   6017: ldc 229
    //   6019: aload_0
    //   6020: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   6023: lconst_0
    //   6024: lload 19
    //   6026: iload_2
    //   6027: iconst_1
    //   6028: aload_0
    //   6029: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   6032: aload_0
    //   6033: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   6036: aload_0
    //   6037: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   6040: invokeinterface 239 14 0
    //   6045: goto -4966 -> 1079
    //   6048: aload_0
    //   6049: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   6052: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   6055: ifeq +163 -> 6218
    //   6058: ldc 220
    //   6060: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6063: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   6066: aload_0
    //   6067: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   6070: invokeinterface 225 1 0
    //   6075: aload_0
    //   6076: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   6079: ldc 229
    //   6081: aload_0
    //   6082: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   6085: lconst_0
    //   6086: lload 19
    //   6088: iload_2
    //   6089: iconst_2
    //   6090: aload_0
    //   6091: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   6094: aload_0
    //   6095: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6098: aload_0
    //   6099: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   6102: invokeinterface 239 14 0
    //   6107: ldc 145
    //   6109: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6112: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6115: ldc2_w 152
    //   6118: ldc2_w 437
    //   6121: lconst_1
    //   6122: iconst_0
    //   6123: invokeinterface 157 8 0
    //   6128: ldc 145
    //   6130: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6133: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6136: ldc2_w 152
    //   6139: ldc2_w 439
    //   6142: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   6145: aload_0
    //   6146: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   6149: lsub
    //   6150: iconst_0
    //   6151: invokeinterface 157 8 0
    //   6156: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   6159: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   6162: istore_1
    //   6163: iload_1
    //   6164: iconst_m1
    //   6165: if_icmpne +24 -> 6189
    //   6168: ldc 145
    //   6170: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6173: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6176: ldc2_w 152
    //   6179: ldc2_w 445
    //   6182: lconst_1
    //   6183: iconst_0
    //   6184: invokeinterface 157 8 0
    //   6189: ldc 116
    //   6191: ldc_w 448
    //   6194: iconst_2
    //   6195: anewarray 4	java/lang/Object
    //   6198: dup
    //   6199: iconst_0
    //   6200: aload_0
    //   6201: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   6204: aastore
    //   6205: dup
    //   6206: iconst_1
    //   6207: iload_1
    //   6208: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6211: aastore
    //   6212: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6215: goto -5087 -> 1128
    //   6218: ldc 220
    //   6220: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6223: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   6226: aload_0
    //   6227: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   6230: invokeinterface 225 1 0
    //   6235: aload_0
    //   6236: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   6239: ldc 229
    //   6241: aload_0
    //   6242: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   6245: lconst_0
    //   6246: lload 19
    //   6248: iload_2
    //   6249: iconst_2
    //   6250: aload_0
    //   6251: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   6254: aload_0
    //   6255: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   6258: aload_0
    //   6259: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   6262: invokeinterface 239 14 0
    //   6267: goto -160 -> 6107
    //   6270: astore 27
    //   6272: ldc 116
    //   6274: aload 27
    //   6276: ldc_w 506
    //   6279: iconst_2
    //   6280: anewarray 4	java/lang/Object
    //   6283: dup
    //   6284: iconst_0
    //   6285: aload_0
    //   6286: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   6289: aastore
    //   6290: dup
    //   6291: iconst_1
    //   6292: aload_0
    //   6293: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6296: aastore
    //   6297: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6300: goto -5162 -> 1138
    //   6303: astore 27
    //   6305: ldc 116
    //   6307: aload 27
    //   6309: ldc_w 506
    //   6312: iconst_2
    //   6313: anewarray 4	java/lang/Object
    //   6316: dup
    //   6317: iconst_0
    //   6318: aload_0
    //   6319: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   6322: aastore
    //   6323: dup
    //   6324: iconst_1
    //   6325: aload_0
    //   6326: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6329: aastore
    //   6330: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6333: goto -5185 -> 1148
    //   6336: astore 27
    //   6338: ldc 116
    //   6340: aload 27
    //   6342: ldc_w 508
    //   6345: iconst_2
    //   6346: anewarray 4	java/lang/Object
    //   6349: dup
    //   6350: iconst_0
    //   6351: aload_0
    //   6352: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   6355: aastore
    //   6356: dup
    //   6357: iconst_1
    //   6358: aload_0
    //   6359: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6362: aastore
    //   6363: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6366: goto -5218 -> 1148
    //   6369: astore 27
    //   6371: ldc 116
    //   6373: aload 27
    //   6375: ldc_w 510
    //   6378: iconst_2
    //   6379: anewarray 4	java/lang/Object
    //   6382: dup
    //   6383: iconst_0
    //   6384: aload_0
    //   6385: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   6388: aastore
    //   6389: dup
    //   6390: iconst_1
    //   6391: aload_0
    //   6392: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6395: aastore
    //   6396: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6399: goto -5251 -> 1148
    //   6402: astore 29
    //   6404: aconst_null
    //   6405: astore 27
    //   6407: aconst_null
    //   6408: astore 28
    //   6410: iload 8
    //   6412: istore 4
    //   6414: iload_3
    //   6415: istore_1
    //   6416: iload_1
    //   6417: istore_3
    //   6418: lload 19
    //   6420: lstore 21
    //   6422: aload 27
    //   6424: astore 31
    //   6426: iload 4
    //   6428: istore_2
    //   6429: aload 28
    //   6431: astore 30
    //   6433: ldc 145
    //   6435: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6438: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6441: ldc2_w 152
    //   6444: ldc2_w 603
    //   6447: lconst_1
    //   6448: iconst_0
    //   6449: invokeinterface 157 8 0
    //   6454: iload_1
    //   6455: istore_3
    //   6456: lload 19
    //   6458: lstore 21
    //   6460: aload 27
    //   6462: astore 31
    //   6464: iload 4
    //   6466: istore_2
    //   6467: aload 28
    //   6469: astore 30
    //   6471: ldc 116
    //   6473: aload 29
    //   6475: ldc_w 606
    //   6478: iconst_2
    //   6479: anewarray 4	java/lang/Object
    //   6482: dup
    //   6483: iconst_0
    //   6484: aload_0
    //   6485: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   6488: aastore
    //   6489: dup
    //   6490: iconst_1
    //   6491: aload_0
    //   6492: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6495: aastore
    //   6496: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6499: iload_1
    //   6500: istore_3
    //   6501: lload 19
    //   6503: lstore 21
    //   6505: aload 27
    //   6507: astore 31
    //   6509: iload 4
    //   6511: istore_2
    //   6512: aload 28
    //   6514: astore 30
    //   6516: aload_0
    //   6517: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   6520: aload_0
    //   6521: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6524: aload_0
    //   6525: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   6528: ldc_w 608
    //   6531: invokeinterface 212 4 0
    //   6536: iload 4
    //   6538: ifeq +232 -> 6770
    //   6541: aload_0
    //   6542: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   6545: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   6548: ifeq +170 -> 6718
    //   6551: ldc 220
    //   6553: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6556: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   6559: aload_0
    //   6560: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   6563: invokeinterface 225 1 0
    //   6568: aload_0
    //   6569: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   6572: ldc 229
    //   6574: aload_0
    //   6575: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   6578: lconst_0
    //   6579: lload 19
    //   6581: iload_1
    //   6582: iconst_1
    //   6583: aload_0
    //   6584: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   6587: aload_0
    //   6588: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6591: aload_0
    //   6592: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   6595: invokeinterface 239 14 0
    //   6600: ldc 145
    //   6602: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6605: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6608: ldc2_w 152
    //   6611: ldc2_w 348
    //   6614: lconst_1
    //   6615: iconst_0
    //   6616: invokeinterface 157 8 0
    //   6621: ldc 145
    //   6623: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6626: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6629: ldc2_w 152
    //   6632: ldc2_w 350
    //   6635: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   6638: aload_0
    //   6639: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   6642: lsub
    //   6643: iconst_0
    //   6644: invokeinterface 157 8 0
    //   6649: aload 27
    //   6651: ifnull +8 -> 6659
    //   6654: aload 27
    //   6656: invokevirtual 356	java/io/OutputStream:close	()V
    //   6659: aload 28
    //   6661: ifnull +8 -> 6669
    //   6664: aload 28
    //   6666: invokevirtual 359	java/io/InputStream:close	()V
    //   6669: aload_0
    //   6670: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   6673: aload_0
    //   6674: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   6677: aload_0
    //   6678: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   6681: invokeinterface 367 2 0
    //   6686: ldc 116
    //   6688: ldc_w 369
    //   6691: iconst_2
    //   6692: anewarray 4	java/lang/Object
    //   6695: dup
    //   6696: iconst_0
    //   6697: aload_0
    //   6698: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   6701: aastore
    //   6702: dup
    //   6703: iconst_1
    //   6704: aload_0
    //   6705: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   6708: aastore
    //   6709: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6712: ldc 205
    //   6714: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6717: return
    //   6718: ldc 220
    //   6720: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6723: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   6726: aload_0
    //   6727: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   6730: invokeinterface 225 1 0
    //   6735: aload_0
    //   6736: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   6739: ldc 229
    //   6741: aload_0
    //   6742: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   6745: lconst_0
    //   6746: lload 19
    //   6748: iload_1
    //   6749: iconst_1
    //   6750: aload_0
    //   6751: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   6754: aload_0
    //   6755: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   6758: aload_0
    //   6759: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   6762: invokeinterface 239 14 0
    //   6767: goto -167 -> 6600
    //   6770: aload_0
    //   6771: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   6774: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   6777: ifeq +163 -> 6940
    //   6780: ldc 220
    //   6782: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6785: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   6788: aload_0
    //   6789: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   6792: invokeinterface 225 1 0
    //   6797: aload_0
    //   6798: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   6801: ldc 229
    //   6803: aload_0
    //   6804: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   6807: lconst_0
    //   6808: lload 19
    //   6810: iload_1
    //   6811: iconst_2
    //   6812: aload_0
    //   6813: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   6816: aload_0
    //   6817: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   6820: aload_0
    //   6821: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   6824: invokeinterface 239 14 0
    //   6829: ldc 145
    //   6831: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6834: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6837: ldc2_w 152
    //   6840: ldc2_w 437
    //   6843: lconst_1
    //   6844: iconst_0
    //   6845: invokeinterface 157 8 0
    //   6850: ldc 145
    //   6852: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6855: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6858: ldc2_w 152
    //   6861: ldc2_w 439
    //   6864: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   6867: aload_0
    //   6868: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   6871: lsub
    //   6872: iconst_0
    //   6873: invokeinterface 157 8 0
    //   6878: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   6881: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   6884: istore_1
    //   6885: iload_1
    //   6886: iconst_m1
    //   6887: if_icmpne +24 -> 6911
    //   6890: ldc 145
    //   6892: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6895: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   6898: ldc2_w 152
    //   6901: ldc2_w 445
    //   6904: lconst_1
    //   6905: iconst_0
    //   6906: invokeinterface 157 8 0
    //   6911: ldc 116
    //   6913: ldc_w 448
    //   6916: iconst_2
    //   6917: anewarray 4	java/lang/Object
    //   6920: dup
    //   6921: iconst_0
    //   6922: aload_0
    //   6923: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   6926: aastore
    //   6927: dup
    //   6928: iconst_1
    //   6929: iload_1
    //   6930: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6933: aastore
    //   6934: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6937: goto -288 -> 6649
    //   6940: ldc 220
    //   6942: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6945: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   6948: aload_0
    //   6949: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   6952: invokeinterface 225 1 0
    //   6957: aload_0
    //   6958: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   6961: ldc 229
    //   6963: aload_0
    //   6964: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   6967: lconst_0
    //   6968: lload 19
    //   6970: iload_1
    //   6971: iconst_2
    //   6972: aload_0
    //   6973: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   6976: aload_0
    //   6977: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   6980: aload_0
    //   6981: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   6984: invokeinterface 239 14 0
    //   6989: goto -160 -> 6829
    //   6992: astore 27
    //   6994: ldc 116
    //   6996: aload 27
    //   6998: ldc_w 506
    //   7001: iconst_2
    //   7002: anewarray 4	java/lang/Object
    //   7005: dup
    //   7006: iconst_0
    //   7007: aload_0
    //   7008: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7011: aastore
    //   7012: dup
    //   7013: iconst_1
    //   7014: aload_0
    //   7015: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7018: aastore
    //   7019: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7022: goto -363 -> 6659
    //   7025: astore 27
    //   7027: ldc 116
    //   7029: aload 27
    //   7031: ldc_w 506
    //   7034: iconst_2
    //   7035: anewarray 4	java/lang/Object
    //   7038: dup
    //   7039: iconst_0
    //   7040: aload_0
    //   7041: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7044: aastore
    //   7045: dup
    //   7046: iconst_1
    //   7047: aload_0
    //   7048: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7051: aastore
    //   7052: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7055: goto -386 -> 6669
    //   7058: astore 27
    //   7060: ldc 116
    //   7062: aload 27
    //   7064: ldc_w 508
    //   7067: iconst_2
    //   7068: anewarray 4	java/lang/Object
    //   7071: dup
    //   7072: iconst_0
    //   7073: aload_0
    //   7074: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7077: aastore
    //   7078: dup
    //   7079: iconst_1
    //   7080: aload_0
    //   7081: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7084: aastore
    //   7085: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7088: goto -419 -> 6669
    //   7091: astore 27
    //   7093: ldc 116
    //   7095: aload 27
    //   7097: ldc_w 510
    //   7100: iconst_2
    //   7101: anewarray 4	java/lang/Object
    //   7104: dup
    //   7105: iconst_0
    //   7106: aload_0
    //   7107: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7110: aastore
    //   7111: dup
    //   7112: iconst_1
    //   7113: aload_0
    //   7114: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7117: aastore
    //   7118: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7121: goto -452 -> 6669
    //   7124: astore 29
    //   7126: aconst_null
    //   7127: astore 27
    //   7129: aconst_null
    //   7130: astore 28
    //   7132: iload 9
    //   7134: istore 5
    //   7136: iload 4
    //   7138: istore_1
    //   7139: iload_1
    //   7140: istore_3
    //   7141: lload 19
    //   7143: lstore 21
    //   7145: aload 27
    //   7147: astore 31
    //   7149: iload 5
    //   7151: istore_2
    //   7152: aload 28
    //   7154: astore 30
    //   7156: ldc 145
    //   7158: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7161: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   7164: ldc2_w 152
    //   7167: ldc2_w 609
    //   7170: lconst_1
    //   7171: iconst_0
    //   7172: invokeinterface 157 8 0
    //   7177: iload_1
    //   7178: istore_3
    //   7179: lload 19
    //   7181: lstore 21
    //   7183: aload 27
    //   7185: astore 31
    //   7187: iload 5
    //   7189: istore_2
    //   7190: aload 28
    //   7192: astore 30
    //   7194: ldc 116
    //   7196: aload 29
    //   7198: ldc_w 612
    //   7201: iconst_2
    //   7202: anewarray 4	java/lang/Object
    //   7205: dup
    //   7206: iconst_0
    //   7207: aload_0
    //   7208: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7211: aastore
    //   7212: dup
    //   7213: iconst_1
    //   7214: aload_0
    //   7215: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7218: aastore
    //   7219: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7222: iload_1
    //   7223: istore_3
    //   7224: lload 19
    //   7226: lstore 21
    //   7228: aload 27
    //   7230: astore 31
    //   7232: iload 5
    //   7234: istore_2
    //   7235: aload 28
    //   7237: astore 30
    //   7239: aload_0
    //   7240: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   7243: aload_0
    //   7244: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7247: aload_0
    //   7248: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7251: ldc_w 614
    //   7254: invokeinterface 212 4 0
    //   7259: iload 5
    //   7261: ifeq +232 -> 7493
    //   7264: aload_0
    //   7265: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   7268: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   7271: ifeq +170 -> 7441
    //   7274: ldc 220
    //   7276: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7279: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   7282: aload_0
    //   7283: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   7286: invokeinterface 225 1 0
    //   7291: aload_0
    //   7292: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   7295: ldc 229
    //   7297: aload_0
    //   7298: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   7301: lconst_0
    //   7302: lload 19
    //   7304: iload_1
    //   7305: iconst_1
    //   7306: aload_0
    //   7307: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   7310: aload_0
    //   7311: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7314: aload_0
    //   7315: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   7318: invokeinterface 239 14 0
    //   7323: ldc 145
    //   7325: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7328: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   7331: ldc2_w 152
    //   7334: ldc2_w 348
    //   7337: lconst_1
    //   7338: iconst_0
    //   7339: invokeinterface 157 8 0
    //   7344: ldc 145
    //   7346: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7349: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   7352: ldc2_w 152
    //   7355: ldc2_w 350
    //   7358: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   7361: aload_0
    //   7362: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   7365: lsub
    //   7366: iconst_0
    //   7367: invokeinterface 157 8 0
    //   7372: aload 27
    //   7374: ifnull +8 -> 7382
    //   7377: aload 27
    //   7379: invokevirtual 356	java/io/OutputStream:close	()V
    //   7382: aload 28
    //   7384: ifnull +8 -> 7392
    //   7387: aload 28
    //   7389: invokevirtual 359	java/io/InputStream:close	()V
    //   7392: aload_0
    //   7393: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   7396: aload_0
    //   7397: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   7400: aload_0
    //   7401: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   7404: invokeinterface 367 2 0
    //   7409: ldc 116
    //   7411: ldc_w 369
    //   7414: iconst_2
    //   7415: anewarray 4	java/lang/Object
    //   7418: dup
    //   7419: iconst_0
    //   7420: aload_0
    //   7421: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   7424: aastore
    //   7425: dup
    //   7426: iconst_1
    //   7427: aload_0
    //   7428: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7431: aastore
    //   7432: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7435: ldc 205
    //   7437: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7440: return
    //   7441: ldc 220
    //   7443: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7446: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   7449: aload_0
    //   7450: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   7453: invokeinterface 225 1 0
    //   7458: aload_0
    //   7459: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   7462: ldc 229
    //   7464: aload_0
    //   7465: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   7468: lconst_0
    //   7469: lload 19
    //   7471: iload_1
    //   7472: iconst_1
    //   7473: aload_0
    //   7474: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   7477: aload_0
    //   7478: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   7481: aload_0
    //   7482: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   7485: invokeinterface 239 14 0
    //   7490: goto -167 -> 7323
    //   7493: aload_0
    //   7494: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   7497: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   7500: ifeq +163 -> 7663
    //   7503: ldc 220
    //   7505: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7508: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   7511: aload_0
    //   7512: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   7515: invokeinterface 225 1 0
    //   7520: aload_0
    //   7521: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   7524: ldc 229
    //   7526: aload_0
    //   7527: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   7530: lconst_0
    //   7531: lload 19
    //   7533: iload_1
    //   7534: iconst_2
    //   7535: aload_0
    //   7536: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   7539: aload_0
    //   7540: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7543: aload_0
    //   7544: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   7547: invokeinterface 239 14 0
    //   7552: ldc 145
    //   7554: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7557: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   7560: ldc2_w 152
    //   7563: ldc2_w 437
    //   7566: lconst_1
    //   7567: iconst_0
    //   7568: invokeinterface 157 8 0
    //   7573: ldc 145
    //   7575: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7578: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   7581: ldc2_w 152
    //   7584: ldc2_w 439
    //   7587: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   7590: aload_0
    //   7591: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   7594: lsub
    //   7595: iconst_0
    //   7596: invokeinterface 157 8 0
    //   7601: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   7604: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   7607: istore_1
    //   7608: iload_1
    //   7609: iconst_m1
    //   7610: if_icmpne +24 -> 7634
    //   7613: ldc 145
    //   7615: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7618: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   7621: ldc2_w 152
    //   7624: ldc2_w 445
    //   7627: lconst_1
    //   7628: iconst_0
    //   7629: invokeinterface 157 8 0
    //   7634: ldc 116
    //   7636: ldc_w 448
    //   7639: iconst_2
    //   7640: anewarray 4	java/lang/Object
    //   7643: dup
    //   7644: iconst_0
    //   7645: aload_0
    //   7646: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   7649: aastore
    //   7650: dup
    //   7651: iconst_1
    //   7652: iload_1
    //   7653: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7656: aastore
    //   7657: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7660: goto -288 -> 7372
    //   7663: ldc 220
    //   7665: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7668: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   7671: aload_0
    //   7672: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   7675: invokeinterface 225 1 0
    //   7680: aload_0
    //   7681: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   7684: ldc 229
    //   7686: aload_0
    //   7687: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   7690: lconst_0
    //   7691: lload 19
    //   7693: iload_1
    //   7694: iconst_2
    //   7695: aload_0
    //   7696: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   7699: aload_0
    //   7700: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   7703: aload_0
    //   7704: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   7707: invokeinterface 239 14 0
    //   7712: goto -160 -> 7552
    //   7715: astore 27
    //   7717: ldc 116
    //   7719: aload 27
    //   7721: ldc_w 506
    //   7724: iconst_2
    //   7725: anewarray 4	java/lang/Object
    //   7728: dup
    //   7729: iconst_0
    //   7730: aload_0
    //   7731: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7734: aastore
    //   7735: dup
    //   7736: iconst_1
    //   7737: aload_0
    //   7738: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7741: aastore
    //   7742: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7745: goto -363 -> 7382
    //   7748: astore 27
    //   7750: ldc 116
    //   7752: aload 27
    //   7754: ldc_w 506
    //   7757: iconst_2
    //   7758: anewarray 4	java/lang/Object
    //   7761: dup
    //   7762: iconst_0
    //   7763: aload_0
    //   7764: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7767: aastore
    //   7768: dup
    //   7769: iconst_1
    //   7770: aload_0
    //   7771: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7774: aastore
    //   7775: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7778: goto -386 -> 7392
    //   7781: astore 27
    //   7783: ldc 116
    //   7785: aload 27
    //   7787: ldc_w 508
    //   7790: iconst_2
    //   7791: anewarray 4	java/lang/Object
    //   7794: dup
    //   7795: iconst_0
    //   7796: aload_0
    //   7797: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7800: aastore
    //   7801: dup
    //   7802: iconst_1
    //   7803: aload_0
    //   7804: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7807: aastore
    //   7808: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7811: goto -419 -> 7392
    //   7814: astore 27
    //   7816: ldc 116
    //   7818: aload 27
    //   7820: ldc_w 510
    //   7823: iconst_2
    //   7824: anewarray 4	java/lang/Object
    //   7827: dup
    //   7828: iconst_0
    //   7829: aload_0
    //   7830: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7833: aastore
    //   7834: dup
    //   7835: iconst_1
    //   7836: aload_0
    //   7837: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7840: aastore
    //   7841: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7844: goto -452 -> 7392
    //   7847: astore 29
    //   7849: aconst_null
    //   7850: astore 27
    //   7852: aconst_null
    //   7853: astore 28
    //   7855: iload 10
    //   7857: istore 4
    //   7859: iload 5
    //   7861: istore_1
    //   7862: iload_1
    //   7863: istore_3
    //   7864: lload 19
    //   7866: lstore 21
    //   7868: aload 27
    //   7870: astore 31
    //   7872: iload 4
    //   7874: istore_2
    //   7875: aload 28
    //   7877: astore 30
    //   7879: ldc 145
    //   7881: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7884: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   7887: ldc2_w 152
    //   7890: ldc2_w 615
    //   7893: lconst_1
    //   7894: iconst_0
    //   7895: invokeinterface 157 8 0
    //   7900: iload_1
    //   7901: istore_3
    //   7902: lload 19
    //   7904: lstore 21
    //   7906: aload 27
    //   7908: astore 31
    //   7910: iload 4
    //   7912: istore_2
    //   7913: aload 28
    //   7915: astore 30
    //   7917: ldc 116
    //   7919: aload 29
    //   7921: ldc_w 618
    //   7924: iconst_2
    //   7925: anewarray 4	java/lang/Object
    //   7928: dup
    //   7929: iconst_0
    //   7930: aload_0
    //   7931: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7934: aastore
    //   7935: dup
    //   7936: iconst_1
    //   7937: aload_0
    //   7938: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7941: aastore
    //   7942: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7945: iload_1
    //   7946: istore_3
    //   7947: lload 19
    //   7949: lstore 21
    //   7951: aload 27
    //   7953: astore 31
    //   7955: iload 4
    //   7957: istore_2
    //   7958: aload 28
    //   7960: astore 30
    //   7962: aload_0
    //   7963: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   7966: aload_0
    //   7967: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   7970: aload_0
    //   7971: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   7974: ldc_w 620
    //   7977: invokeinterface 212 4 0
    //   7982: iload 4
    //   7984: ifeq +232 -> 8216
    //   7987: aload_0
    //   7988: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   7991: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   7994: ifeq +170 -> 8164
    //   7997: ldc 220
    //   7999: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8002: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   8005: aload_0
    //   8006: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   8009: invokeinterface 225 1 0
    //   8014: aload_0
    //   8015: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   8018: ldc 229
    //   8020: aload_0
    //   8021: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   8024: lconst_0
    //   8025: lload 19
    //   8027: iload_1
    //   8028: iconst_1
    //   8029: aload_0
    //   8030: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   8033: aload_0
    //   8034: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8037: aload_0
    //   8038: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   8041: invokeinterface 239 14 0
    //   8046: ldc 145
    //   8048: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8051: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   8054: ldc2_w 152
    //   8057: ldc2_w 348
    //   8060: lconst_1
    //   8061: iconst_0
    //   8062: invokeinterface 157 8 0
    //   8067: ldc 145
    //   8069: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8072: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   8075: ldc2_w 152
    //   8078: ldc2_w 350
    //   8081: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   8084: aload_0
    //   8085: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   8088: lsub
    //   8089: iconst_0
    //   8090: invokeinterface 157 8 0
    //   8095: aload 27
    //   8097: ifnull +8 -> 8105
    //   8100: aload 27
    //   8102: invokevirtual 356	java/io/OutputStream:close	()V
    //   8105: aload 28
    //   8107: ifnull +8 -> 8115
    //   8110: aload 28
    //   8112: invokevirtual 359	java/io/InputStream:close	()V
    //   8115: aload_0
    //   8116: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   8119: aload_0
    //   8120: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   8123: aload_0
    //   8124: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   8127: invokeinterface 367 2 0
    //   8132: ldc 116
    //   8134: ldc_w 369
    //   8137: iconst_2
    //   8138: anewarray 4	java/lang/Object
    //   8141: dup
    //   8142: iconst_0
    //   8143: aload_0
    //   8144: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   8147: aastore
    //   8148: dup
    //   8149: iconst_1
    //   8150: aload_0
    //   8151: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   8154: aastore
    //   8155: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8158: ldc 205
    //   8160: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8163: return
    //   8164: ldc 220
    //   8166: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8169: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   8172: aload_0
    //   8173: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   8176: invokeinterface 225 1 0
    //   8181: aload_0
    //   8182: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   8185: ldc 229
    //   8187: aload_0
    //   8188: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   8191: lconst_0
    //   8192: lload 19
    //   8194: iload_1
    //   8195: iconst_1
    //   8196: aload_0
    //   8197: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   8200: aload_0
    //   8201: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   8204: aload_0
    //   8205: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   8208: invokeinterface 239 14 0
    //   8213: goto -167 -> 8046
    //   8216: aload_0
    //   8217: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   8220: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8223: ifeq +163 -> 8386
    //   8226: ldc 220
    //   8228: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8231: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   8234: aload_0
    //   8235: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   8238: invokeinterface 225 1 0
    //   8243: aload_0
    //   8244: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   8247: ldc 229
    //   8249: aload_0
    //   8250: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   8253: lconst_0
    //   8254: lload 19
    //   8256: iload_1
    //   8257: iconst_2
    //   8258: aload_0
    //   8259: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   8262: aload_0
    //   8263: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8266: aload_0
    //   8267: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   8270: invokeinterface 239 14 0
    //   8275: ldc 145
    //   8277: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8280: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   8283: ldc2_w 152
    //   8286: ldc2_w 437
    //   8289: lconst_1
    //   8290: iconst_0
    //   8291: invokeinterface 157 8 0
    //   8296: ldc 145
    //   8298: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8301: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   8304: ldc2_w 152
    //   8307: ldc2_w 439
    //   8310: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   8313: aload_0
    //   8314: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   8317: lsub
    //   8318: iconst_0
    //   8319: invokeinterface 157 8 0
    //   8324: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   8327: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   8330: istore_1
    //   8331: iload_1
    //   8332: iconst_m1
    //   8333: if_icmpne +24 -> 8357
    //   8336: ldc 145
    //   8338: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8341: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   8344: ldc2_w 152
    //   8347: ldc2_w 445
    //   8350: lconst_1
    //   8351: iconst_0
    //   8352: invokeinterface 157 8 0
    //   8357: ldc 116
    //   8359: ldc_w 448
    //   8362: iconst_2
    //   8363: anewarray 4	java/lang/Object
    //   8366: dup
    //   8367: iconst_0
    //   8368: aload_0
    //   8369: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   8372: aastore
    //   8373: dup
    //   8374: iconst_1
    //   8375: iload_1
    //   8376: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   8379: aastore
    //   8380: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8383: goto -288 -> 8095
    //   8386: ldc 220
    //   8388: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8391: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   8394: aload_0
    //   8395: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   8398: invokeinterface 225 1 0
    //   8403: aload_0
    //   8404: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   8407: ldc 229
    //   8409: aload_0
    //   8410: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   8413: lconst_0
    //   8414: lload 19
    //   8416: iload_1
    //   8417: iconst_2
    //   8418: aload_0
    //   8419: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   8422: aload_0
    //   8423: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   8426: aload_0
    //   8427: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   8430: invokeinterface 239 14 0
    //   8435: goto -160 -> 8275
    //   8438: astore 27
    //   8440: ldc 116
    //   8442: aload 27
    //   8444: ldc_w 506
    //   8447: iconst_2
    //   8448: anewarray 4	java/lang/Object
    //   8451: dup
    //   8452: iconst_0
    //   8453: aload_0
    //   8454: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   8457: aastore
    //   8458: dup
    //   8459: iconst_1
    //   8460: aload_0
    //   8461: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8464: aastore
    //   8465: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8468: goto -363 -> 8105
    //   8471: astore 27
    //   8473: ldc 116
    //   8475: aload 27
    //   8477: ldc_w 506
    //   8480: iconst_2
    //   8481: anewarray 4	java/lang/Object
    //   8484: dup
    //   8485: iconst_0
    //   8486: aload_0
    //   8487: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   8490: aastore
    //   8491: dup
    //   8492: iconst_1
    //   8493: aload_0
    //   8494: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8497: aastore
    //   8498: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8501: goto -386 -> 8115
    //   8504: astore 27
    //   8506: ldc 116
    //   8508: aload 27
    //   8510: ldc_w 508
    //   8513: iconst_2
    //   8514: anewarray 4	java/lang/Object
    //   8517: dup
    //   8518: iconst_0
    //   8519: aload_0
    //   8520: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   8523: aastore
    //   8524: dup
    //   8525: iconst_1
    //   8526: aload_0
    //   8527: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8530: aastore
    //   8531: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8534: goto -419 -> 8115
    //   8537: astore 27
    //   8539: ldc 116
    //   8541: aload 27
    //   8543: ldc_w 510
    //   8546: iconst_2
    //   8547: anewarray 4	java/lang/Object
    //   8550: dup
    //   8551: iconst_0
    //   8552: aload_0
    //   8553: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   8556: aastore
    //   8557: dup
    //   8558: iconst_1
    //   8559: aload_0
    //   8560: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8563: aastore
    //   8564: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8567: goto -452 -> 8115
    //   8570: astore 29
    //   8572: aconst_null
    //   8573: astore 27
    //   8575: aconst_null
    //   8576: astore 28
    //   8578: iload 11
    //   8580: istore 4
    //   8582: iload 6
    //   8584: istore_1
    //   8585: iload_1
    //   8586: istore_3
    //   8587: lload 19
    //   8589: lstore 21
    //   8591: aload 27
    //   8593: astore 31
    //   8595: iload 4
    //   8597: istore_2
    //   8598: aload 28
    //   8600: astore 30
    //   8602: ldc 145
    //   8604: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8607: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   8610: ldc2_w 152
    //   8613: ldc2_w 621
    //   8616: lconst_1
    //   8617: iconst_0
    //   8618: invokeinterface 157 8 0
    //   8623: iload_1
    //   8624: istore_3
    //   8625: lload 19
    //   8627: lstore 21
    //   8629: aload 27
    //   8631: astore 31
    //   8633: iload 4
    //   8635: istore_2
    //   8636: aload 28
    //   8638: astore 30
    //   8640: ldc 116
    //   8642: aload 29
    //   8644: ldc_w 624
    //   8647: iconst_2
    //   8648: anewarray 4	java/lang/Object
    //   8651: dup
    //   8652: iconst_0
    //   8653: aload_0
    //   8654: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   8657: aastore
    //   8658: dup
    //   8659: iconst_1
    //   8660: aload_0
    //   8661: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8664: aastore
    //   8665: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8668: iload_1
    //   8669: istore_3
    //   8670: lload 19
    //   8672: lstore 21
    //   8674: aload 27
    //   8676: astore 31
    //   8678: iload 4
    //   8680: istore_2
    //   8681: aload 28
    //   8683: astore 30
    //   8685: aload_0
    //   8686: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   8689: aload_0
    //   8690: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8693: aload_0
    //   8694: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   8697: new 626	java/lang/StringBuilder
    //   8700: dup
    //   8701: invokespecial 627	java/lang/StringBuilder:<init>	()V
    //   8704: aload 29
    //   8706: invokevirtual 628	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   8709: invokevirtual 632	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8712: invokevirtual 633	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8715: invokeinterface 212 4 0
    //   8720: iload 4
    //   8722: ifeq +232 -> 8954
    //   8725: aload_0
    //   8726: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   8729: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8732: ifeq +170 -> 8902
    //   8735: ldc 220
    //   8737: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8740: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   8743: aload_0
    //   8744: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   8747: invokeinterface 225 1 0
    //   8752: aload_0
    //   8753: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   8756: ldc 229
    //   8758: aload_0
    //   8759: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   8762: lconst_0
    //   8763: lload 19
    //   8765: iload_1
    //   8766: iconst_1
    //   8767: aload_0
    //   8768: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   8771: aload_0
    //   8772: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   8775: aload_0
    //   8776: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   8779: invokeinterface 239 14 0
    //   8784: ldc 145
    //   8786: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8789: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   8792: ldc2_w 152
    //   8795: ldc2_w 348
    //   8798: lconst_1
    //   8799: iconst_0
    //   8800: invokeinterface 157 8 0
    //   8805: ldc 145
    //   8807: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8810: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   8813: ldc2_w 152
    //   8816: ldc2_w 350
    //   8819: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   8822: aload_0
    //   8823: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   8826: lsub
    //   8827: iconst_0
    //   8828: invokeinterface 157 8 0
    //   8833: aload 27
    //   8835: ifnull +8 -> 8843
    //   8838: aload 27
    //   8840: invokevirtual 356	java/io/OutputStream:close	()V
    //   8843: aload 28
    //   8845: ifnull +8 -> 8853
    //   8848: aload 28
    //   8850: invokevirtual 359	java/io/InputStream:close	()V
    //   8853: aload_0
    //   8854: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   8857: aload_0
    //   8858: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   8861: aload_0
    //   8862: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   8865: invokeinterface 367 2 0
    //   8870: ldc 116
    //   8872: ldc_w 369
    //   8875: iconst_2
    //   8876: anewarray 4	java/lang/Object
    //   8879: dup
    //   8880: iconst_0
    //   8881: aload_0
    //   8882: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   8885: aastore
    //   8886: dup
    //   8887: iconst_1
    //   8888: aload_0
    //   8889: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   8892: aastore
    //   8893: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8896: ldc 205
    //   8898: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8901: return
    //   8902: ldc 220
    //   8904: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8907: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   8910: aload_0
    //   8911: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   8914: invokeinterface 225 1 0
    //   8919: aload_0
    //   8920: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   8923: ldc 229
    //   8925: aload_0
    //   8926: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   8929: lconst_0
    //   8930: lload 19
    //   8932: iload_1
    //   8933: iconst_1
    //   8934: aload_0
    //   8935: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   8938: aload_0
    //   8939: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   8942: aload_0
    //   8943: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   8946: invokeinterface 239 14 0
    //   8951: goto -167 -> 8784
    //   8954: aload_0
    //   8955: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   8958: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   8961: ifeq +163 -> 9124
    //   8964: ldc 220
    //   8966: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8969: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   8972: aload_0
    //   8973: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   8976: invokeinterface 225 1 0
    //   8981: aload_0
    //   8982: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   8985: ldc 229
    //   8987: aload_0
    //   8988: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   8991: lconst_0
    //   8992: lload 19
    //   8994: iload_1
    //   8995: iconst_2
    //   8996: aload_0
    //   8997: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   9000: aload_0
    //   9001: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9004: aload_0
    //   9005: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   9008: invokeinterface 239 14 0
    //   9013: ldc 145
    //   9015: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9018: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   9021: ldc2_w 152
    //   9024: ldc2_w 437
    //   9027: lconst_1
    //   9028: iconst_0
    //   9029: invokeinterface 157 8 0
    //   9034: ldc 145
    //   9036: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9039: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   9042: ldc2_w 152
    //   9045: ldc2_w 439
    //   9048: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   9051: aload_0
    //   9052: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   9055: lsub
    //   9056: iconst_0
    //   9057: invokeinterface 157 8 0
    //   9062: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   9065: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   9068: istore_1
    //   9069: iload_1
    //   9070: iconst_m1
    //   9071: if_icmpne +24 -> 9095
    //   9074: ldc 145
    //   9076: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9079: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   9082: ldc2_w 152
    //   9085: ldc2_w 445
    //   9088: lconst_1
    //   9089: iconst_0
    //   9090: invokeinterface 157 8 0
    //   9095: ldc 116
    //   9097: ldc_w 448
    //   9100: iconst_2
    //   9101: anewarray 4	java/lang/Object
    //   9104: dup
    //   9105: iconst_0
    //   9106: aload_0
    //   9107: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   9110: aastore
    //   9111: dup
    //   9112: iconst_1
    //   9113: iload_1
    //   9114: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9117: aastore
    //   9118: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9121: goto -288 -> 8833
    //   9124: ldc 220
    //   9126: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9129: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   9132: aload_0
    //   9133: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   9136: invokeinterface 225 1 0
    //   9141: aload_0
    //   9142: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   9145: ldc 229
    //   9147: aload_0
    //   9148: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   9151: lconst_0
    //   9152: lload 19
    //   9154: iload_1
    //   9155: iconst_2
    //   9156: aload_0
    //   9157: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   9160: aload_0
    //   9161: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   9164: aload_0
    //   9165: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   9168: invokeinterface 239 14 0
    //   9173: goto -160 -> 9013
    //   9176: astore 27
    //   9178: ldc 116
    //   9180: aload 27
    //   9182: ldc_w 506
    //   9185: iconst_2
    //   9186: anewarray 4	java/lang/Object
    //   9189: dup
    //   9190: iconst_0
    //   9191: aload_0
    //   9192: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9195: aastore
    //   9196: dup
    //   9197: iconst_1
    //   9198: aload_0
    //   9199: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9202: aastore
    //   9203: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9206: goto -363 -> 8843
    //   9209: astore 27
    //   9211: ldc 116
    //   9213: aload 27
    //   9215: ldc_w 506
    //   9218: iconst_2
    //   9219: anewarray 4	java/lang/Object
    //   9222: dup
    //   9223: iconst_0
    //   9224: aload_0
    //   9225: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9228: aastore
    //   9229: dup
    //   9230: iconst_1
    //   9231: aload_0
    //   9232: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9235: aastore
    //   9236: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9239: goto -386 -> 8853
    //   9242: astore 27
    //   9244: ldc 116
    //   9246: aload 27
    //   9248: ldc_w 508
    //   9251: iconst_2
    //   9252: anewarray 4	java/lang/Object
    //   9255: dup
    //   9256: iconst_0
    //   9257: aload_0
    //   9258: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9261: aastore
    //   9262: dup
    //   9263: iconst_1
    //   9264: aload_0
    //   9265: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9268: aastore
    //   9269: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9272: goto -419 -> 8853
    //   9275: astore 27
    //   9277: ldc 116
    //   9279: aload 27
    //   9281: ldc_w 510
    //   9284: iconst_2
    //   9285: anewarray 4	java/lang/Object
    //   9288: dup
    //   9289: iconst_0
    //   9290: aload_0
    //   9291: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9294: aastore
    //   9295: dup
    //   9296: iconst_1
    //   9297: aload_0
    //   9298: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9301: aastore
    //   9302: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9305: goto -452 -> 8853
    //   9308: astore 29
    //   9310: aconst_null
    //   9311: astore 27
    //   9313: aconst_null
    //   9314: astore 28
    //   9316: lconst_0
    //   9317: lstore 19
    //   9319: iload 12
    //   9321: istore_2
    //   9322: iload 7
    //   9324: istore_1
    //   9325: iload_2
    //   9326: ifeq +234 -> 9560
    //   9329: aload_0
    //   9330: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   9333: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9336: ifeq +172 -> 9508
    //   9339: ldc 220
    //   9341: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9344: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   9347: aload_0
    //   9348: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   9351: invokeinterface 225 1 0
    //   9356: aload_0
    //   9357: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   9360: ldc 229
    //   9362: aload_0
    //   9363: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   9366: lconst_0
    //   9367: lload 19
    //   9369: iload_1
    //   9370: iconst_1
    //   9371: aload_0
    //   9372: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   9375: aload_0
    //   9376: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9379: aload_0
    //   9380: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   9383: invokeinterface 239 14 0
    //   9388: ldc 145
    //   9390: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9393: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   9396: ldc2_w 152
    //   9399: ldc2_w 348
    //   9402: lconst_1
    //   9403: iconst_0
    //   9404: invokeinterface 157 8 0
    //   9409: ldc 145
    //   9411: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9414: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   9417: ldc2_w 152
    //   9420: ldc2_w 350
    //   9423: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   9426: aload_0
    //   9427: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   9430: lsub
    //   9431: iconst_0
    //   9432: invokeinterface 157 8 0
    //   9437: aload 27
    //   9439: ifnull +8 -> 9447
    //   9442: aload 27
    //   9444: invokevirtual 356	java/io/OutputStream:close	()V
    //   9447: aload 28
    //   9449: ifnull +8 -> 9457
    //   9452: aload 28
    //   9454: invokevirtual 359	java/io/InputStream:close	()V
    //   9457: aload_0
    //   9458: invokevirtual 362	com/tencent/mm/plugin/appbrand/q/a/b:biC	()V
    //   9461: aload_0
    //   9462: getfield 98	com/tencent/mm/plugin/appbrand/q/a/b:kVW	Lcom/tencent/mm/plugin/appbrand/q/a/a;
    //   9465: aload_0
    //   9466: invokespecial 364	com/tencent/mm/plugin/appbrand/q/a/b:aEB	()Ljava/lang/String;
    //   9469: invokeinterface 367 2 0
    //   9474: ldc 116
    //   9476: ldc_w 369
    //   9479: iconst_2
    //   9480: anewarray 4	java/lang/Object
    //   9483: dup
    //   9484: iconst_0
    //   9485: aload_0
    //   9486: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   9489: aastore
    //   9490: dup
    //   9491: iconst_1
    //   9492: aload_0
    //   9493: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9496: aastore
    //   9497: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9500: ldc 205
    //   9502: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   9505: aload 29
    //   9507: athrow
    //   9508: ldc 220
    //   9510: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9513: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   9516: aload_0
    //   9517: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   9520: invokeinterface 225 1 0
    //   9525: aload_0
    //   9526: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   9529: ldc 229
    //   9531: aload_0
    //   9532: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   9535: lconst_0
    //   9536: lload 19
    //   9538: iload_1
    //   9539: iconst_1
    //   9540: aload_0
    //   9541: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   9544: aload_0
    //   9545: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   9548: aload_0
    //   9549: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   9552: invokeinterface 239 14 0
    //   9557: goto -169 -> 9388
    //   9560: aload_0
    //   9561: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   9564: invokestatic 218	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   9567: ifeq +163 -> 9730
    //   9570: ldc 220
    //   9572: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9575: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   9578: aload_0
    //   9579: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   9582: invokeinterface 225 1 0
    //   9587: aload_0
    //   9588: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   9591: ldc 229
    //   9593: aload_0
    //   9594: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   9597: lconst_0
    //   9598: lload 19
    //   9600: iload_1
    //   9601: iconst_2
    //   9602: aload_0
    //   9603: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   9606: aload_0
    //   9607: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9610: aload_0
    //   9611: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   9614: invokeinterface 239 14 0
    //   9619: ldc 145
    //   9621: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9624: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   9627: ldc2_w 152
    //   9630: ldc2_w 437
    //   9633: lconst_1
    //   9634: iconst_0
    //   9635: invokeinterface 157 8 0
    //   9640: ldc 145
    //   9642: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9645: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   9648: ldc2_w 152
    //   9651: ldc2_w 439
    //   9654: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   9657: aload_0
    //   9658: getfield 241	com/tencent/mm/plugin/appbrand/q/a/b:kVZ	J
    //   9661: lsub
    //   9662: iconst_0
    //   9663: invokeinterface 157 8 0
    //   9668: invokestatic 137	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   9671: invokestatic 444	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
    //   9674: istore_1
    //   9675: iload_1
    //   9676: iconst_m1
    //   9677: if_icmpne +24 -> 9701
    //   9680: ldc 145
    //   9682: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9685: checkcast 145	com/tencent/mm/plugin/appbrand/u/a
    //   9688: ldc2_w 152
    //   9691: ldc2_w 445
    //   9694: lconst_1
    //   9695: iconst_0
    //   9696: invokeinterface 157 8 0
    //   9701: ldc 116
    //   9703: ldc_w 448
    //   9706: iconst_2
    //   9707: anewarray 4	java/lang/Object
    //   9710: dup
    //   9711: iconst_0
    //   9712: aload_0
    //   9713: getfield 182	com/tencent/mm/plugin/appbrand/q/a/b:hLO	Ljava/lang/String;
    //   9716: aastore
    //   9717: dup
    //   9718: iconst_1
    //   9719: iload_1
    //   9720: invokestatic 169	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9723: aastore
    //   9724: invokestatic 129	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9727: goto -290 -> 9437
    //   9730: ldc 220
    //   9732: invokestatic 151	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9735: checkcast 220	com/tencent/mm/plugin/appbrand/q/o
    //   9738: aload_0
    //   9739: getfield 90	com/tencent/mm/plugin/appbrand/q/a/b:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
    //   9742: invokeinterface 225 1 0
    //   9747: aload_0
    //   9748: invokespecial 227	com/tencent/mm/plugin/appbrand/q/a/b:aYC	()Ljava/lang/String;
    //   9751: ldc 229
    //   9753: aload_0
    //   9754: invokespecial 232	com/tencent/mm/plugin/appbrand/q/a/b:getUrl	()Ljava/lang/String;
    //   9757: lconst_0
    //   9758: lload 19
    //   9760: iload_1
    //   9761: iconst_2
    //   9762: aload_0
    //   9763: invokevirtual 236	com/tencent/mm/plugin/appbrand/q/a/b:bio	()I
    //   9766: aload_0
    //   9767: getfield 96	com/tencent/mm/plugin/appbrand/q/a/b:hzZ	Ljava/lang/String;
    //   9770: aload_0
    //   9771: getfield 75	com/tencent/mm/plugin/appbrand/q/a/b:bxn	Ljava/lang/String;
    //   9774: invokeinterface 239 14 0
    //   9779: goto -160 -> 9619
    //   9782: astore 27
    //   9784: ldc 116
    //   9786: aload 27
    //   9788: ldc_w 506
    //   9791: iconst_2
    //   9792: anewarray 4	java/lang/Object
    //   9795: dup
    //   9796: iconst_0
    //   9797: aload_0
    //   9798: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9801: aastore
    //   9802: dup
    //   9803: iconst_1
    //   9804: aload_0
    //   9805: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9808: aastore
    //   9809: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9812: goto -365 -> 9447
    //   9815: astore 27
    //   9817: ldc 116
    //   9819: aload 27
    //   9821: ldc_w 506
    //   9824: iconst_2
    //   9825: anewarray 4	java/lang/Object
    //   9828: dup
    //   9829: iconst_0
    //   9830: aload_0
    //   9831: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9834: aastore
    //   9835: dup
    //   9836: iconst_1
    //   9837: aload_0
    //   9838: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9841: aastore
    //   9842: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9845: goto -388 -> 9457
    //   9848: astore 27
    //   9850: ldc 116
    //   9852: aload 27
    //   9854: ldc_w 508
    //   9857: iconst_2
    //   9858: anewarray 4	java/lang/Object
    //   9861: dup
    //   9862: iconst_0
    //   9863: aload_0
    //   9864: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9867: aastore
    //   9868: dup
    //   9869: iconst_1
    //   9870: aload_0
    //   9871: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9874: aastore
    //   9875: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9878: goto -421 -> 9457
    //   9881: astore 27
    //   9883: ldc 116
    //   9885: aload 27
    //   9887: ldc_w 510
    //   9890: iconst_2
    //   9891: anewarray 4	java/lang/Object
    //   9894: dup
    //   9895: iconst_0
    //   9896: aload_0
    //   9897: getfield 92	com/tencent/mm/plugin/appbrand/q/a/b:uri	Ljava/lang/String;
    //   9900: aastore
    //   9901: dup
    //   9902: iconst_1
    //   9903: aload_0
    //   9904: getfield 94	com/tencent/mm/plugin/appbrand/q/a/b:filename	Ljava/lang/String;
    //   9907: aastore
    //   9908: invokestatic 345	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9911: goto -454 -> 9457
    //   9914: astore 29
    //   9916: aconst_null
    //   9917: astore 27
    //   9919: lconst_0
    //   9920: lstore 19
    //   9922: iload 12
    //   9924: istore_2
    //   9925: goto -600 -> 9325
    //   9928: astore 29
    //   9930: lconst_0
    //   9931: lstore 19
    //   9933: iload 12
    //   9935: istore_2
    //   9936: goto -611 -> 9325
    //   9939: astore 29
    //   9941: iload 12
    //   9943: istore_2
    //   9944: goto -619 -> 9325
    //   9947: astore 29
    //   9949: iload 12
    //   9951: istore_2
    //   9952: goto -627 -> 9325
    //   9955: astore 29
    //   9957: lload 21
    //   9959: lstore 19
    //   9961: iload_3
    //   9962: istore_1
    //   9963: aload 31
    //   9965: astore 27
    //   9967: aload 30
    //   9969: astore 28
    //   9971: goto -646 -> 9325
    //   9974: astore 29
    //   9976: goto -651 -> 9325
    //   9979: astore 29
    //   9981: iload_1
    //   9982: istore_3
    //   9983: iload_2
    //   9984: istore_1
    //   9985: iload_3
    //   9986: istore_2
    //   9987: goto -662 -> 9325
    //   9990: astore 29
    //   9992: aconst_null
    //   9993: astore 27
    //   9995: iload 11
    //   9997: istore 4
    //   9999: goto -1414 -> 8585
    //   10002: astore 29
    //   10004: iload 11
    //   10006: istore 4
    //   10008: goto -1423 -> 8585
    //   10011: astore 29
    //   10013: iload 11
    //   10015: istore 4
    //   10017: goto -1432 -> 8585
    //   10020: astore 29
    //   10022: iload 11
    //   10024: istore 4
    //   10026: goto -1441 -> 8585
    //   10029: astore 29
    //   10031: iload 11
    //   10033: istore 4
    //   10035: goto -1450 -> 8585
    //   10038: astore 29
    //   10040: iload_2
    //   10041: istore 4
    //   10043: goto -1458 -> 8585
    //   10046: astore 29
    //   10048: aconst_null
    //   10049: astore 27
    //   10051: iload 10
    //   10053: istore 4
    //   10055: goto -2193 -> 7862
    //   10058: astore 29
    //   10060: iload 10
    //   10062: istore 4
    //   10064: goto -2202 -> 7862
    //   10067: astore 29
    //   10069: iload 10
    //   10071: istore 4
    //   10073: goto -2211 -> 7862
    //   10076: astore 29
    //   10078: iload 10
    //   10080: istore 4
    //   10082: goto -2220 -> 7862
    //   10085: astore 29
    //   10087: iload 10
    //   10089: istore 4
    //   10091: goto -2229 -> 7862
    //   10094: astore 29
    //   10096: iload_2
    //   10097: istore 4
    //   10099: goto -2237 -> 7862
    //   10102: astore 29
    //   10104: aconst_null
    //   10105: astore 27
    //   10107: iload 9
    //   10109: istore 5
    //   10111: goto -2972 -> 7139
    //   10114: astore 29
    //   10116: iload 9
    //   10118: istore 5
    //   10120: goto -2981 -> 7139
    //   10123: astore 29
    //   10125: iload 9
    //   10127: istore 5
    //   10129: goto -2990 -> 7139
    //   10132: astore 29
    //   10134: iload 9
    //   10136: istore 5
    //   10138: goto -2999 -> 7139
    //   10141: astore 29
    //   10143: iload 9
    //   10145: istore 5
    //   10147: goto -3008 -> 7139
    //   10150: astore 29
    //   10152: iload_2
    //   10153: istore 5
    //   10155: goto -3016 -> 7139
    //   10158: astore 29
    //   10160: aconst_null
    //   10161: astore 27
    //   10163: iload 8
    //   10165: istore 4
    //   10167: goto -3751 -> 6416
    //   10170: astore 29
    //   10172: iload 8
    //   10174: istore 4
    //   10176: goto -3760 -> 6416
    //   10179: astore 29
    //   10181: iload 8
    //   10183: istore 4
    //   10185: goto -3769 -> 6416
    //   10188: astore 29
    //   10190: iload 8
    //   10192: istore 4
    //   10194: goto -3778 -> 6416
    //   10197: astore 29
    //   10199: iload 8
    //   10201: istore 4
    //   10203: goto -3787 -> 6416
    //   10206: astore 29
    //   10208: iload_2
    //   10209: istore 4
    //   10211: goto -3795 -> 6416
    //   10214: astore 29
    //   10216: aconst_null
    //   10217: astore 27
    //   10219: iconst_0
    //   10220: istore_3
    //   10221: iload_1
    //   10222: istore_2
    //   10223: iload_3
    //   10224: istore_1
    //   10225: goto -9276 -> 949
    //   10228: astore 29
    //   10230: iconst_0
    //   10231: istore_3
    //   10232: iload_1
    //   10233: istore_2
    //   10234: iload_3
    //   10235: istore_1
    //   10236: goto -9287 -> 949
    //   10239: astore 29
    //   10241: iconst_0
    //   10242: istore_3
    //   10243: iload_1
    //   10244: istore_2
    //   10245: iload_3
    //   10246: istore_1
    //   10247: goto -9298 -> 949
    //   10250: astore 29
    //   10252: iconst_0
    //   10253: istore_3
    //   10254: iload_1
    //   10255: istore_2
    //   10256: iload_3
    //   10257: istore_1
    //   10258: goto -9309 -> 949
    //   10261: astore 29
    //   10263: iconst_0
    //   10264: istore_3
    //   10265: iload_1
    //   10266: istore_2
    //   10267: iload_3
    //   10268: istore_1
    //   10269: goto -9320 -> 949
    //   10272: iload_3
    //   10273: istore_2
    //   10274: goto -6243 -> 4031
    //   10277: aconst_null
    //   10278: astore 27
    //   10280: goto -5154 -> 5126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10283	0	this	b
    //   44	10225	1	i	int
    //   217	10057	2	j	int
    //   220	10053	3	k	int
    //   223	9987	4	m	int
    //   227	9927	5	n	int
    //   231	8352	6	i1	int
    //   235	9088	7	i2	int
    //   26	10174	8	i3	int
    //   11	10133	9	i4	int
    //   14	10074	10	i5	int
    //   17	10015	11	i6	int
    //   20	9930	12	i7	int
    //   23	5511	13	i8	int
    //   29	3984	14	i9	int
    //   32	1342	15	i10	int
    //   35	1343	16	i11	int
    //   38	1344	17	i12	int
    //   41	1345	18	i13	int
    //   46	9914	19	l1	long
    //   4015	5943	21	l2	long
    //   8	5270	23	l3	long
    //   1323	3887	25	l4	long
    //   288	1763	27	localObject1	Object
    //   3207	114	27	localException1	Exception
    //   3439	5	27	localIOException1	IOException
    //   3472	5	27	localArrayIndexOutOfBoundsException1	java.lang.ArrayIndexOutOfBoundsException
    //   3505	5	27	localThrowable1	java.lang.Throwable
    //   3901	5	27	localIOException2	IOException
    //   3934	5	27	localArrayIndexOutOfBoundsException2	java.lang.ArrayIndexOutOfBoundsException
    //   3967	5	27	localThrowable2	java.lang.Throwable
    //   4010	244	27	localOutputStream	java.io.OutputStream
    //   4369	5	27	localIOException3	IOException
    //   4402	5	27	localIOException4	IOException
    //   4435	5	27	localArrayIndexOutOfBoundsException3	java.lang.ArrayIndexOutOfBoundsException
    //   4468	406	27	localThrowable3	java.lang.Throwable
    //   4989	5	27	localIOException5	IOException
    //   5022	5	27	localIOException6	IOException
    //   5055	5	27	localArrayIndexOutOfBoundsException4	java.lang.ArrayIndexOutOfBoundsException
    //   5088	442	27	localThrowable4	java.lang.Throwable
    //   5864	5	27	localIOException7	IOException
    //   5897	5	27	localIOException8	IOException
    //   5930	5	27	localArrayIndexOutOfBoundsException5	java.lang.ArrayIndexOutOfBoundsException
    //   5963	5	27	localThrowable5	java.lang.Throwable
    //   6270	5	27	localIOException9	IOException
    //   6303	5	27	localIOException10	IOException
    //   6336	5	27	localArrayIndexOutOfBoundsException6	java.lang.ArrayIndexOutOfBoundsException
    //   6369	5	27	localThrowable6	java.lang.Throwable
    //   6405	250	27	localObject2	Object
    //   6992	5	27	localIOException11	IOException
    //   7025	5	27	localIOException12	IOException
    //   7058	5	27	localArrayIndexOutOfBoundsException7	java.lang.ArrayIndexOutOfBoundsException
    //   7091	5	27	localThrowable7	java.lang.Throwable
    //   7127	251	27	localObject3	Object
    //   7715	5	27	localIOException13	IOException
    //   7748	5	27	localIOException14	IOException
    //   7781	5	27	localArrayIndexOutOfBoundsException8	java.lang.ArrayIndexOutOfBoundsException
    //   7814	5	27	localThrowable8	java.lang.Throwable
    //   7850	251	27	localObject4	Object
    //   8438	5	27	localIOException15	IOException
    //   8471	5	27	localIOException16	IOException
    //   8504	5	27	localArrayIndexOutOfBoundsException9	java.lang.ArrayIndexOutOfBoundsException
    //   8537	5	27	localThrowable9	java.lang.Throwable
    //   8573	266	27	localObject5	Object
    //   9176	5	27	localIOException17	IOException
    //   9209	5	27	localIOException18	IOException
    //   9242	5	27	localArrayIndexOutOfBoundsException10	java.lang.ArrayIndexOutOfBoundsException
    //   9275	5	27	localThrowable10	java.lang.Throwable
    //   9311	132	27	localObject6	Object
    //   9782	5	27	localIOException19	IOException
    //   9815	5	27	localIOException20	IOException
    //   9848	5	27	localArrayIndexOutOfBoundsException11	java.lang.ArrayIndexOutOfBoundsException
    //   9881	5	27	localThrowable11	java.lang.Throwable
    //   9917	362	27	localObject7	Object
    //   762	2534	28	localObject8	Object
    //   3300	1	28	localException2	Exception
    //   3333	6637	28	localObject9	Object
    //   826	100	29	localEntry	Map.Entry
    //   939	32	29	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   2830	1863	29	locale	com.tencent.mm.vfs.e
    //   5564	5	29	localIOException21	IOException
    //   5579	1	29	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   6402	72	29	localFileNotFoundException1	java.io.FileNotFoundException
    //   7124	73	29	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
    //   7847	73	29	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   8570	135	29	localException3	Exception
    //   9308	198	29	localObject10	Object
    //   9914	1	29	localObject11	Object
    //   9928	1	29	localObject12	Object
    //   9939	1	29	localObject13	Object
    //   9947	1	29	localObject14	Object
    //   9955	1	29	localObject15	Object
    //   9974	1	29	localObject16	Object
    //   9979	1	29	localObject17	Object
    //   9990	1	29	localException4	Exception
    //   10002	1	29	localException5	Exception
    //   10011	1	29	localException6	Exception
    //   10020	1	29	localException7	Exception
    //   10029	1	29	localException8	Exception
    //   10038	1	29	localException9	Exception
    //   10046	1	29	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   10058	1	29	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   10067	1	29	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   10076	1	29	localSocketTimeoutException5	java.net.SocketTimeoutException
    //   10085	1	29	localSocketTimeoutException6	java.net.SocketTimeoutException
    //   10094	1	29	localSocketTimeoutException7	java.net.SocketTimeoutException
    //   10102	1	29	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
    //   10114	1	29	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
    //   10123	1	29	localSSLHandshakeException4	javax.net.ssl.SSLHandshakeException
    //   10132	1	29	localSSLHandshakeException5	javax.net.ssl.SSLHandshakeException
    //   10141	1	29	localSSLHandshakeException6	javax.net.ssl.SSLHandshakeException
    //   10150	1	29	localSSLHandshakeException7	javax.net.ssl.SSLHandshakeException
    //   10158	1	29	localFileNotFoundException2	java.io.FileNotFoundException
    //   10170	1	29	localFileNotFoundException3	java.io.FileNotFoundException
    //   10179	1	29	localFileNotFoundException4	java.io.FileNotFoundException
    //   10188	1	29	localFileNotFoundException5	java.io.FileNotFoundException
    //   10197	1	29	localFileNotFoundException6	java.io.FileNotFoundException
    //   10206	1	29	localFileNotFoundException7	java.io.FileNotFoundException
    //   10214	1	29	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   10228	1	29	localUnsupportedEncodingException4	java.io.UnsupportedEncodingException
    //   10239	1	29	localUnsupportedEncodingException5	java.io.UnsupportedEncodingException
    //   10250	1	29	localUnsupportedEncodingException6	java.io.UnsupportedEncodingException
    //   10261	1	29	localUnsupportedEncodingException7	java.io.UnsupportedEncodingException
    //   4024	5944	30	localObject18	Object
    //   5134	4830	31	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   237	256	939	java/io/UnsupportedEncodingException
    //   277	290	939	java/io/UnsupportedEncodingException
    //   311	343	939	java/io/UnsupportedEncodingException
    //   364	376	939	java/io/UnsupportedEncodingException
    //   397	407	939	java/io/UnsupportedEncodingException
    //   428	435	939	java/io/UnsupportedEncodingException
    //   456	473	939	java/io/UnsupportedEncodingException
    //   494	505	939	java/io/UnsupportedEncodingException
    //   526	534	939	java/io/UnsupportedEncodingException
    //   555	566	939	java/io/UnsupportedEncodingException
    //   587	598	939	java/io/UnsupportedEncodingException
    //   619	627	939	java/io/UnsupportedEncodingException
    //   648	661	939	java/io/UnsupportedEncodingException
    //   682	689	939	java/io/UnsupportedEncodingException
    //   710	727	939	java/io/UnsupportedEncodingException
    //   748	764	939	java/io/UnsupportedEncodingException
    //   785	795	939	java/io/UnsupportedEncodingException
    //   816	828	939	java/io/UnsupportedEncodingException
    //   849	876	939	java/io/UnsupportedEncodingException
    //   897	936	939	java/io/UnsupportedEncodingException
    //   1218	1232	939	java/io/UnsupportedEncodingException
    //   1253	1262	939	java/io/UnsupportedEncodingException
    //   1283	1294	939	java/io/UnsupportedEncodingException
    //   1315	1325	939	java/io/UnsupportedEncodingException
    //   1346	1368	939	java/io/UnsupportedEncodingException
    //   1389	1397	939	java/io/UnsupportedEncodingException
    //   1420	1442	939	java/io/UnsupportedEncodingException
    //   1458	1467	939	java/io/UnsupportedEncodingException
    //   1483	1487	939	java/io/UnsupportedEncodingException
    //   1503	1514	939	java/io/UnsupportedEncodingException
    //   1537	1577	939	java/io/UnsupportedEncodingException
    //   1593	1600	939	java/io/UnsupportedEncodingException
    //   1616	1625	939	java/io/UnsupportedEncodingException
    //   1641	1649	939	java/io/UnsupportedEncodingException
    //   1665	1671	939	java/io/UnsupportedEncodingException
    //   1687	1695	939	java/io/UnsupportedEncodingException
    //   1716	1736	939	java/io/UnsupportedEncodingException
    //   1752	1776	939	java/io/UnsupportedEncodingException
    //   1999	2033	939	java/io/UnsupportedEncodingException
    //   2049	2055	939	java/io/UnsupportedEncodingException
    //   2071	2075	939	java/io/UnsupportedEncodingException
    //   2357	2366	939	java/io/UnsupportedEncodingException
    //   2387	2394	939	java/io/UnsupportedEncodingException
    //   2410	2423	939	java/io/UnsupportedEncodingException
    //   2439	2459	939	java/io/UnsupportedEncodingException
    //   2475	2495	939	java/io/UnsupportedEncodingException
    //   2774	2790	939	java/io/UnsupportedEncodingException
    //   2803	2819	939	java/io/UnsupportedEncodingException
    //   3151	3167	939	java/io/UnsupportedEncodingException
    //   3180	3204	939	java/io/UnsupportedEncodingException
    //   3225	3239	939	java/io/UnsupportedEncodingException
    //   3252	3268	939	java/io/UnsupportedEncodingException
    //   3281	3297	939	java/io/UnsupportedEncodingException
    //   3318	3332	939	java/io/UnsupportedEncodingException
    //   3351	3360	939	java/io/UnsupportedEncodingException
    //   3376	3385	939	java/io/UnsupportedEncodingException
    //   2774	2790	3207	java/lang/Exception
    //   2803	2819	3207	java/lang/Exception
    //   3151	3167	3207	java/lang/Exception
    //   3180	3204	3207	java/lang/Exception
    //   3351	3360	3207	java/lang/Exception
    //   3252	3268	3300	java/lang/Exception
    //   3281	3297	3300	java/lang/Exception
    //   3376	3385	3300	java/lang/Exception
    //   3084	3089	3439	java/io/IOException
    //   3084	3089	3472	java/lang/ArrayIndexOutOfBoundsException
    //   3084	3089	3505	java/lang/Throwable
    //   3796	3801	3901	java/io/IOException
    //   3796	3801	3934	java/lang/ArrayIndexOutOfBoundsException
    //   3796	3801	3967	java/lang/Throwable
    //   4253	4258	4369	java/io/IOException
    //   4263	4268	4402	java/io/IOException
    //   4263	4268	4435	java/lang/ArrayIndexOutOfBoundsException
    //   4263	4268	4468	java/lang/Throwable
    //   4873	4878	4989	java/io/IOException
    //   4883	4888	5022	java/io/IOException
    //   4883	4888	5055	java/lang/ArrayIndexOutOfBoundsException
    //   4883	4888	5088	java/lang/Throwable
    //   5257	5267	5564	java/io/IOException
    //   5224	5257	5579	java/io/UnsupportedEncodingException
    //   5257	5267	5579	java/io/UnsupportedEncodingException
    //   5267	5342	5579	java/io/UnsupportedEncodingException
    //   5566	5576	5579	java/io/UnsupportedEncodingException
    //   5459	5464	5864	java/io/IOException
    //   5469	5474	5897	java/io/IOException
    //   5469	5474	5930	java/lang/ArrayIndexOutOfBoundsException
    //   5469	5474	5963	java/lang/Throwable
    //   1133	1138	6270	java/io/IOException
    //   1143	1148	6303	java/io/IOException
    //   1143	1148	6336	java/lang/ArrayIndexOutOfBoundsException
    //   1143	1148	6369	java/lang/Throwable
    //   237	256	6402	java/io/FileNotFoundException
    //   277	290	6402	java/io/FileNotFoundException
    //   311	343	6402	java/io/FileNotFoundException
    //   364	376	6402	java/io/FileNotFoundException
    //   397	407	6402	java/io/FileNotFoundException
    //   428	435	6402	java/io/FileNotFoundException
    //   456	473	6402	java/io/FileNotFoundException
    //   494	505	6402	java/io/FileNotFoundException
    //   526	534	6402	java/io/FileNotFoundException
    //   555	566	6402	java/io/FileNotFoundException
    //   587	598	6402	java/io/FileNotFoundException
    //   619	627	6402	java/io/FileNotFoundException
    //   648	661	6402	java/io/FileNotFoundException
    //   682	689	6402	java/io/FileNotFoundException
    //   710	727	6402	java/io/FileNotFoundException
    //   748	764	6402	java/io/FileNotFoundException
    //   785	795	6402	java/io/FileNotFoundException
    //   816	828	6402	java/io/FileNotFoundException
    //   849	876	6402	java/io/FileNotFoundException
    //   897	936	6402	java/io/FileNotFoundException
    //   1218	1232	6402	java/io/FileNotFoundException
    //   1253	1262	6402	java/io/FileNotFoundException
    //   1283	1294	6402	java/io/FileNotFoundException
    //   1315	1325	6402	java/io/FileNotFoundException
    //   1346	1368	6402	java/io/FileNotFoundException
    //   1389	1397	6402	java/io/FileNotFoundException
    //   1420	1442	6402	java/io/FileNotFoundException
    //   1458	1467	6402	java/io/FileNotFoundException
    //   1483	1487	6402	java/io/FileNotFoundException
    //   1503	1514	6402	java/io/FileNotFoundException
    //   1537	1577	6402	java/io/FileNotFoundException
    //   1593	1600	6402	java/io/FileNotFoundException
    //   1616	1625	6402	java/io/FileNotFoundException
    //   1641	1649	6402	java/io/FileNotFoundException
    //   1665	1671	6402	java/io/FileNotFoundException
    //   1687	1695	6402	java/io/FileNotFoundException
    //   1716	1736	6402	java/io/FileNotFoundException
    //   1752	1776	6402	java/io/FileNotFoundException
    //   1999	2033	6402	java/io/FileNotFoundException
    //   2049	2055	6402	java/io/FileNotFoundException
    //   2071	2075	6402	java/io/FileNotFoundException
    //   2357	2366	6402	java/io/FileNotFoundException
    //   2387	2394	6402	java/io/FileNotFoundException
    //   2410	2423	6402	java/io/FileNotFoundException
    //   2439	2459	6402	java/io/FileNotFoundException
    //   2475	2495	6402	java/io/FileNotFoundException
    //   2774	2790	6402	java/io/FileNotFoundException
    //   2803	2819	6402	java/io/FileNotFoundException
    //   3151	3167	6402	java/io/FileNotFoundException
    //   3180	3204	6402	java/io/FileNotFoundException
    //   3225	3239	6402	java/io/FileNotFoundException
    //   3252	3268	6402	java/io/FileNotFoundException
    //   3281	3297	6402	java/io/FileNotFoundException
    //   3318	3332	6402	java/io/FileNotFoundException
    //   3351	3360	6402	java/io/FileNotFoundException
    //   3376	3385	6402	java/io/FileNotFoundException
    //   6654	6659	6992	java/io/IOException
    //   6664	6669	7025	java/io/IOException
    //   6664	6669	7058	java/lang/ArrayIndexOutOfBoundsException
    //   6664	6669	7091	java/lang/Throwable
    //   237	256	7124	javax/net/ssl/SSLHandshakeException
    //   277	290	7124	javax/net/ssl/SSLHandshakeException
    //   311	343	7124	javax/net/ssl/SSLHandshakeException
    //   364	376	7124	javax/net/ssl/SSLHandshakeException
    //   397	407	7124	javax/net/ssl/SSLHandshakeException
    //   428	435	7124	javax/net/ssl/SSLHandshakeException
    //   456	473	7124	javax/net/ssl/SSLHandshakeException
    //   494	505	7124	javax/net/ssl/SSLHandshakeException
    //   526	534	7124	javax/net/ssl/SSLHandshakeException
    //   555	566	7124	javax/net/ssl/SSLHandshakeException
    //   587	598	7124	javax/net/ssl/SSLHandshakeException
    //   619	627	7124	javax/net/ssl/SSLHandshakeException
    //   648	661	7124	javax/net/ssl/SSLHandshakeException
    //   682	689	7124	javax/net/ssl/SSLHandshakeException
    //   710	727	7124	javax/net/ssl/SSLHandshakeException
    //   748	764	7124	javax/net/ssl/SSLHandshakeException
    //   785	795	7124	javax/net/ssl/SSLHandshakeException
    //   816	828	7124	javax/net/ssl/SSLHandshakeException
    //   849	876	7124	javax/net/ssl/SSLHandshakeException
    //   897	936	7124	javax/net/ssl/SSLHandshakeException
    //   1218	1232	7124	javax/net/ssl/SSLHandshakeException
    //   1253	1262	7124	javax/net/ssl/SSLHandshakeException
    //   1283	1294	7124	javax/net/ssl/SSLHandshakeException
    //   1315	1325	7124	javax/net/ssl/SSLHandshakeException
    //   1346	1368	7124	javax/net/ssl/SSLHandshakeException
    //   1389	1397	7124	javax/net/ssl/SSLHandshakeException
    //   1420	1442	7124	javax/net/ssl/SSLHandshakeException
    //   1458	1467	7124	javax/net/ssl/SSLHandshakeException
    //   1483	1487	7124	javax/net/ssl/SSLHandshakeException
    //   1503	1514	7124	javax/net/ssl/SSLHandshakeException
    //   1537	1577	7124	javax/net/ssl/SSLHandshakeException
    //   1593	1600	7124	javax/net/ssl/SSLHandshakeException
    //   1616	1625	7124	javax/net/ssl/SSLHandshakeException
    //   1641	1649	7124	javax/net/ssl/SSLHandshakeException
    //   1665	1671	7124	javax/net/ssl/SSLHandshakeException
    //   1687	1695	7124	javax/net/ssl/SSLHandshakeException
    //   1716	1736	7124	javax/net/ssl/SSLHandshakeException
    //   1752	1776	7124	javax/net/ssl/SSLHandshakeException
    //   1999	2033	7124	javax/net/ssl/SSLHandshakeException
    //   2049	2055	7124	javax/net/ssl/SSLHandshakeException
    //   2071	2075	7124	javax/net/ssl/SSLHandshakeException
    //   2357	2366	7124	javax/net/ssl/SSLHandshakeException
    //   2387	2394	7124	javax/net/ssl/SSLHandshakeException
    //   2410	2423	7124	javax/net/ssl/SSLHandshakeException
    //   2439	2459	7124	javax/net/ssl/SSLHandshakeException
    //   2475	2495	7124	javax/net/ssl/SSLHandshakeException
    //   2774	2790	7124	javax/net/ssl/SSLHandshakeException
    //   2803	2819	7124	javax/net/ssl/SSLHandshakeException
    //   3151	3167	7124	javax/net/ssl/SSLHandshakeException
    //   3180	3204	7124	javax/net/ssl/SSLHandshakeException
    //   3225	3239	7124	javax/net/ssl/SSLHandshakeException
    //   3252	3268	7124	javax/net/ssl/SSLHandshakeException
    //   3281	3297	7124	javax/net/ssl/SSLHandshakeException
    //   3318	3332	7124	javax/net/ssl/SSLHandshakeException
    //   3351	3360	7124	javax/net/ssl/SSLHandshakeException
    //   3376	3385	7124	javax/net/ssl/SSLHandshakeException
    //   7377	7382	7715	java/io/IOException
    //   7387	7392	7748	java/io/IOException
    //   7387	7392	7781	java/lang/ArrayIndexOutOfBoundsException
    //   7387	7392	7814	java/lang/Throwable
    //   237	256	7847	java/net/SocketTimeoutException
    //   277	290	7847	java/net/SocketTimeoutException
    //   311	343	7847	java/net/SocketTimeoutException
    //   364	376	7847	java/net/SocketTimeoutException
    //   397	407	7847	java/net/SocketTimeoutException
    //   428	435	7847	java/net/SocketTimeoutException
    //   456	473	7847	java/net/SocketTimeoutException
    //   494	505	7847	java/net/SocketTimeoutException
    //   526	534	7847	java/net/SocketTimeoutException
    //   555	566	7847	java/net/SocketTimeoutException
    //   587	598	7847	java/net/SocketTimeoutException
    //   619	627	7847	java/net/SocketTimeoutException
    //   648	661	7847	java/net/SocketTimeoutException
    //   682	689	7847	java/net/SocketTimeoutException
    //   710	727	7847	java/net/SocketTimeoutException
    //   748	764	7847	java/net/SocketTimeoutException
    //   785	795	7847	java/net/SocketTimeoutException
    //   816	828	7847	java/net/SocketTimeoutException
    //   849	876	7847	java/net/SocketTimeoutException
    //   897	936	7847	java/net/SocketTimeoutException
    //   1218	1232	7847	java/net/SocketTimeoutException
    //   1253	1262	7847	java/net/SocketTimeoutException
    //   1283	1294	7847	java/net/SocketTimeoutException
    //   1315	1325	7847	java/net/SocketTimeoutException
    //   1346	1368	7847	java/net/SocketTimeoutException
    //   1389	1397	7847	java/net/SocketTimeoutException
    //   1420	1442	7847	java/net/SocketTimeoutException
    //   1458	1467	7847	java/net/SocketTimeoutException
    //   1483	1487	7847	java/net/SocketTimeoutException
    //   1503	1514	7847	java/net/SocketTimeoutException
    //   1537	1577	7847	java/net/SocketTimeoutException
    //   1593	1600	7847	java/net/SocketTimeoutException
    //   1616	1625	7847	java/net/SocketTimeoutException
    //   1641	1649	7847	java/net/SocketTimeoutException
    //   1665	1671	7847	java/net/SocketTimeoutException
    //   1687	1695	7847	java/net/SocketTimeoutException
    //   1716	1736	7847	java/net/SocketTimeoutException
    //   1752	1776	7847	java/net/SocketTimeoutException
    //   1999	2033	7847	java/net/SocketTimeoutException
    //   2049	2055	7847	java/net/SocketTimeoutException
    //   2071	2075	7847	java/net/SocketTimeoutException
    //   2357	2366	7847	java/net/SocketTimeoutException
    //   2387	2394	7847	java/net/SocketTimeoutException
    //   2410	2423	7847	java/net/SocketTimeoutException
    //   2439	2459	7847	java/net/SocketTimeoutException
    //   2475	2495	7847	java/net/SocketTimeoutException
    //   2774	2790	7847	java/net/SocketTimeoutException
    //   2803	2819	7847	java/net/SocketTimeoutException
    //   3151	3167	7847	java/net/SocketTimeoutException
    //   3180	3204	7847	java/net/SocketTimeoutException
    //   3225	3239	7847	java/net/SocketTimeoutException
    //   3252	3268	7847	java/net/SocketTimeoutException
    //   3281	3297	7847	java/net/SocketTimeoutException
    //   3318	3332	7847	java/net/SocketTimeoutException
    //   3351	3360	7847	java/net/SocketTimeoutException
    //   3376	3385	7847	java/net/SocketTimeoutException
    //   8100	8105	8438	java/io/IOException
    //   8110	8115	8471	java/io/IOException
    //   8110	8115	8504	java/lang/ArrayIndexOutOfBoundsException
    //   8110	8115	8537	java/lang/Throwable
    //   237	256	8570	java/lang/Exception
    //   277	290	8570	java/lang/Exception
    //   311	343	8570	java/lang/Exception
    //   364	376	8570	java/lang/Exception
    //   397	407	8570	java/lang/Exception
    //   428	435	8570	java/lang/Exception
    //   456	473	8570	java/lang/Exception
    //   494	505	8570	java/lang/Exception
    //   526	534	8570	java/lang/Exception
    //   555	566	8570	java/lang/Exception
    //   587	598	8570	java/lang/Exception
    //   619	627	8570	java/lang/Exception
    //   648	661	8570	java/lang/Exception
    //   682	689	8570	java/lang/Exception
    //   710	727	8570	java/lang/Exception
    //   748	764	8570	java/lang/Exception
    //   785	795	8570	java/lang/Exception
    //   816	828	8570	java/lang/Exception
    //   849	876	8570	java/lang/Exception
    //   897	936	8570	java/lang/Exception
    //   1218	1232	8570	java/lang/Exception
    //   1253	1262	8570	java/lang/Exception
    //   1283	1294	8570	java/lang/Exception
    //   1315	1325	8570	java/lang/Exception
    //   1346	1368	8570	java/lang/Exception
    //   1389	1397	8570	java/lang/Exception
    //   1420	1442	8570	java/lang/Exception
    //   1458	1467	8570	java/lang/Exception
    //   1483	1487	8570	java/lang/Exception
    //   1503	1514	8570	java/lang/Exception
    //   1537	1577	8570	java/lang/Exception
    //   1593	1600	8570	java/lang/Exception
    //   1616	1625	8570	java/lang/Exception
    //   1641	1649	8570	java/lang/Exception
    //   1665	1671	8570	java/lang/Exception
    //   1687	1695	8570	java/lang/Exception
    //   1716	1736	8570	java/lang/Exception
    //   1752	1776	8570	java/lang/Exception
    //   1999	2033	8570	java/lang/Exception
    //   2049	2055	8570	java/lang/Exception
    //   2071	2075	8570	java/lang/Exception
    //   2357	2366	8570	java/lang/Exception
    //   2387	2394	8570	java/lang/Exception
    //   2410	2423	8570	java/lang/Exception
    //   2439	2459	8570	java/lang/Exception
    //   2475	2495	8570	java/lang/Exception
    //   3225	3239	8570	java/lang/Exception
    //   3318	3332	8570	java/lang/Exception
    //   8838	8843	9176	java/io/IOException
    //   8848	8853	9209	java/io/IOException
    //   8848	8853	9242	java/lang/ArrayIndexOutOfBoundsException
    //   8848	8853	9275	java/lang/Throwable
    //   237	256	9308	finally
    //   277	290	9308	finally
    //   311	343	9308	finally
    //   364	376	9308	finally
    //   397	407	9308	finally
    //   428	435	9308	finally
    //   456	473	9308	finally
    //   494	505	9308	finally
    //   526	534	9308	finally
    //   555	566	9308	finally
    //   587	598	9308	finally
    //   619	627	9308	finally
    //   648	661	9308	finally
    //   682	689	9308	finally
    //   710	727	9308	finally
    //   748	764	9308	finally
    //   785	795	9308	finally
    //   816	828	9308	finally
    //   849	876	9308	finally
    //   897	936	9308	finally
    //   1218	1232	9308	finally
    //   1253	1262	9308	finally
    //   1283	1294	9308	finally
    //   1315	1325	9308	finally
    //   1346	1368	9308	finally
    //   1389	1397	9308	finally
    //   1420	1442	9308	finally
    //   1458	1467	9308	finally
    //   1483	1487	9308	finally
    //   1503	1514	9308	finally
    //   1537	1577	9308	finally
    //   1593	1600	9308	finally
    //   1616	1625	9308	finally
    //   1641	1649	9308	finally
    //   1665	1671	9308	finally
    //   1687	1695	9308	finally
    //   1716	1736	9308	finally
    //   1752	1776	9308	finally
    //   1999	2033	9308	finally
    //   2049	2055	9308	finally
    //   2071	2075	9308	finally
    //   2357	2366	9308	finally
    //   2387	2394	9308	finally
    //   2410	2423	9308	finally
    //   2439	2459	9308	finally
    //   2475	2495	9308	finally
    //   2774	2790	9308	finally
    //   2803	2819	9308	finally
    //   3151	3167	9308	finally
    //   3180	3204	9308	finally
    //   3225	3239	9308	finally
    //   3252	3268	9308	finally
    //   3281	3297	9308	finally
    //   3318	3332	9308	finally
    //   3351	3360	9308	finally
    //   3376	3385	9308	finally
    //   9442	9447	9782	java/io/IOException
    //   9452	9457	9815	java/io/IOException
    //   9452	9457	9848	java/lang/ArrayIndexOutOfBoundsException
    //   9452	9457	9881	java/lang/Throwable
    //   2819	2913	9914	finally
    //   3538	3625	9914	finally
    //   4005	4012	9914	finally
    //   4017	4026	9928	finally
    //   4031	4039	9939	finally
    //   4044	4081	9939	finally
    //   4501	4510	9939	finally
    //   5121	5126	9939	finally
    //   4528	4547	9947	finally
    //   4555	4574	9947	finally
    //   4577	4613	9947	finally
    //   4620	4701	9947	finally
    //   5143	5150	9955	finally
    //   5167	5192	9955	finally
    //   5209	5222	9955	finally
    //   5540	5559	9955	finally
    //   6433	6454	9955	finally
    //   6471	6499	9955	finally
    //   6516	6536	9955	finally
    //   7156	7177	9955	finally
    //   7194	7222	9955	finally
    //   7239	7259	9955	finally
    //   7879	7900	9955	finally
    //   7917	7945	9955	finally
    //   7962	7982	9955	finally
    //   8602	8623	9955	finally
    //   8640	8668	9955	finally
    //   8685	8720	9955	finally
    //   5224	5257	9974	finally
    //   5257	5267	9974	finally
    //   5267	5342	9974	finally
    //   5566	5576	9974	finally
    //   949	1016	9979	finally
    //   2819	2913	9990	java/lang/Exception
    //   3538	3625	9990	java/lang/Exception
    //   4005	4012	9990	java/lang/Exception
    //   4017	4026	10002	java/lang/Exception
    //   4031	4039	10011	java/lang/Exception
    //   4044	4081	10011	java/lang/Exception
    //   4501	4510	10011	java/lang/Exception
    //   5121	5126	10011	java/lang/Exception
    //   4528	4547	10020	java/lang/Exception
    //   4555	4574	10020	java/lang/Exception
    //   4577	4613	10020	java/lang/Exception
    //   4620	4701	10020	java/lang/Exception
    //   5143	5150	10029	java/lang/Exception
    //   5167	5192	10029	java/lang/Exception
    //   5209	5222	10029	java/lang/Exception
    //   5540	5559	10029	java/lang/Exception
    //   5224	5257	10038	java/lang/Exception
    //   5257	5267	10038	java/lang/Exception
    //   5267	5342	10038	java/lang/Exception
    //   5566	5576	10038	java/lang/Exception
    //   2819	2913	10046	java/net/SocketTimeoutException
    //   3538	3625	10046	java/net/SocketTimeoutException
    //   4005	4012	10046	java/net/SocketTimeoutException
    //   4017	4026	10058	java/net/SocketTimeoutException
    //   4031	4039	10067	java/net/SocketTimeoutException
    //   4044	4081	10067	java/net/SocketTimeoutException
    //   4501	4510	10067	java/net/SocketTimeoutException
    //   5121	5126	10067	java/net/SocketTimeoutException
    //   4528	4547	10076	java/net/SocketTimeoutException
    //   4555	4574	10076	java/net/SocketTimeoutException
    //   4577	4613	10076	java/net/SocketTimeoutException
    //   4620	4701	10076	java/net/SocketTimeoutException
    //   5143	5150	10085	java/net/SocketTimeoutException
    //   5167	5192	10085	java/net/SocketTimeoutException
    //   5209	5222	10085	java/net/SocketTimeoutException
    //   5540	5559	10085	java/net/SocketTimeoutException
    //   5224	5257	10094	java/net/SocketTimeoutException
    //   5257	5267	10094	java/net/SocketTimeoutException
    //   5267	5342	10094	java/net/SocketTimeoutException
    //   5566	5576	10094	java/net/SocketTimeoutException
    //   2819	2913	10102	javax/net/ssl/SSLHandshakeException
    //   3538	3625	10102	javax/net/ssl/SSLHandshakeException
    //   4005	4012	10102	javax/net/ssl/SSLHandshakeException
    //   4017	4026	10114	javax/net/ssl/SSLHandshakeException
    //   4031	4039	10123	javax/net/ssl/SSLHandshakeException
    //   4044	4081	10123	javax/net/ssl/SSLHandshakeException
    //   4501	4510	10123	javax/net/ssl/SSLHandshakeException
    //   5121	5126	10123	javax/net/ssl/SSLHandshakeException
    //   4528	4547	10132	javax/net/ssl/SSLHandshakeException
    //   4555	4574	10132	javax/net/ssl/SSLHandshakeException
    //   4577	4613	10132	javax/net/ssl/SSLHandshakeException
    //   4620	4701	10132	javax/net/ssl/SSLHandshakeException
    //   5143	5150	10141	javax/net/ssl/SSLHandshakeException
    //   5167	5192	10141	javax/net/ssl/SSLHandshakeException
    //   5209	5222	10141	javax/net/ssl/SSLHandshakeException
    //   5540	5559	10141	javax/net/ssl/SSLHandshakeException
    //   5224	5257	10150	javax/net/ssl/SSLHandshakeException
    //   5257	5267	10150	javax/net/ssl/SSLHandshakeException
    //   5267	5342	10150	javax/net/ssl/SSLHandshakeException
    //   5566	5576	10150	javax/net/ssl/SSLHandshakeException
    //   2819	2913	10158	java/io/FileNotFoundException
    //   3538	3625	10158	java/io/FileNotFoundException
    //   4005	4012	10158	java/io/FileNotFoundException
    //   4017	4026	10170	java/io/FileNotFoundException
    //   4031	4039	10179	java/io/FileNotFoundException
    //   4044	4081	10179	java/io/FileNotFoundException
    //   4501	4510	10179	java/io/FileNotFoundException
    //   5121	5126	10179	java/io/FileNotFoundException
    //   4528	4547	10188	java/io/FileNotFoundException
    //   4555	4574	10188	java/io/FileNotFoundException
    //   4577	4613	10188	java/io/FileNotFoundException
    //   4620	4701	10188	java/io/FileNotFoundException
    //   5143	5150	10197	java/io/FileNotFoundException
    //   5167	5192	10197	java/io/FileNotFoundException
    //   5209	5222	10197	java/io/FileNotFoundException
    //   5540	5559	10197	java/io/FileNotFoundException
    //   5224	5257	10206	java/io/FileNotFoundException
    //   5257	5267	10206	java/io/FileNotFoundException
    //   5267	5342	10206	java/io/FileNotFoundException
    //   5566	5576	10206	java/io/FileNotFoundException
    //   2819	2913	10214	java/io/UnsupportedEncodingException
    //   3538	3625	10214	java/io/UnsupportedEncodingException
    //   4005	4012	10214	java/io/UnsupportedEncodingException
    //   4017	4026	10228	java/io/UnsupportedEncodingException
    //   4031	4039	10239	java/io/UnsupportedEncodingException
    //   4044	4081	10239	java/io/UnsupportedEncodingException
    //   4501	4510	10239	java/io/UnsupportedEncodingException
    //   5121	5126	10239	java/io/UnsupportedEncodingException
    //   4528	4547	10250	java/io/UnsupportedEncodingException
    //   4555	4574	10250	java/io/UnsupportedEncodingException
    //   4577	4613	10250	java/io/UnsupportedEncodingException
    //   4620	4701	10250	java/io/UnsupportedEncodingException
    //   5143	5150	10261	java/io/UnsupportedEncodingException
    //   5167	5192	10261	java/io/UnsupportedEncodingException
    //   5209	5222	10261	java/io/UnsupportedEncodingException
    //   5540	5559	10261	java/io/UnsupportedEncodingException
  }
  
  static String dK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144469);
    paramString1 = d.a.aGF(paramString1);
    if (paramString1 == null)
    {
      paramString1 = d.aCP(paramString2);
      AppMethodBeat.o(144469);
      return paramString1;
    }
    if (paramString1.mimeType.contains("application/octet-stream"))
    {
      paramString2 = d.aCP(paramString2);
      if (bt.isNullOrNil(paramString2))
      {
        paramString1 = paramString1.mimeType;
        AppMethodBeat.o(144469);
        return paramString1;
      }
      AppMethodBeat.o(144469);
      return paramString2;
    }
    paramString1 = paramString1.mimeType;
    AppMethodBeat.o(144469);
    return paramString1;
  }
  
  private String getUrl()
  {
    return this.uri;
  }
  
  private static void tm(int paramInt)
  {
    AppMethodBeat.i(144470);
    int i = 28;
    if ((paramInt >= 100) && (paramInt < 200)) {
      i = 20;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(437L, i, 1L, false);
      ad.i("MicroMsg.AppBrandDownloadWorker", "reportStatusCode:%d, key:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(144470);
      return;
      if (200 == paramInt) {
        i = 21;
      } else if ((paramInt > 200) && (paramInt < 300)) {
        i = 22;
      } else if (302 == paramInt) {
        i = 23;
      } else if ((paramInt >= 300) && (paramInt < 400)) {
        i = 24;
      } else if (404 == paramInt) {
        i = 25;
      } else if ((paramInt >= 400) && (paramInt < 500)) {
        i = 26;
      } else if (paramInt >= 500) {
        i = 27;
      }
    }
  }
  
  public final void biC()
  {
    AppMethodBeat.i(144468);
    this.isRunning = false;
    if (this.kWa != null) {}
    try
    {
      this.kWa.getInputStream().close();
      this.kWa.disconnect();
      if (!bt.isNullOrNil(this.kWb)) {
        CronetLogic.cancelCronetTask(this.kWb);
      }
      AppMethodBeat.o(144468);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.AppBrandDownloadWorker", localIOException.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", localException, "abortTask Exception", new Object[0]);
      }
    }
  }
  
  public final int bio()
  {
    AppMethodBeat.i(144472);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(144472);
    return i;
  }
  
  public final void run()
  {
    AppMethodBeat.i(144466);
    if ((!URLUtil.isHttpsUrl(this.uri)) && (!URLUtil.isHttpUrl(this.uri)))
    {
      this.kVW.J(this.filename, this.uri, "downloadFile protocol must be http or https");
      AppMethodBeat.o(144466);
      return;
    }
    if ((this.kVe != null) && (!j.c(this.kVe, this.uri)))
    {
      this.kVW.J(this.filename, this.uri, "url not in domain list");
      ad.i("MicroMsg.AppBrandDownloadWorker", "not in domain url %s", new Object[] { this.uri });
      AppMethodBeat.o(144466);
      return;
    }
    if (this.kaI)
    {
      final long l = System.currentTimeMillis();
      Object localObject2 = new a();
      if (!this.isRunning)
      {
        this.kVW.J(this.filename, this.uri, "force stop");
        if (bt.isNullOrNil(this.hzZ))
        {
          ((o)e.L(o.class)).a(this.joJ.getAppId(), this.kVj, "GET", this.uri, 0L, 0L, 0, 2, bio(), this.filename, this.bxn);
          AppMethodBeat.o(144466);
          return;
        }
        ((o)e.L(o.class)).a(this.joJ.getAppId(), this.kVj, "GET", this.uri, 0L, 0L, 0, 2, bio(), this.hzZ, this.bxn);
        AppMethodBeat.o(144466);
        return;
      }
      this.kVZ = System.currentTimeMillis();
      this.kVW.dJ(this.filename, this.uri);
      ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 0L, 1L, false);
      ad.i("MicroMsg.AppBrandDownloadWorker", "downloadCronetFile prepare to start download taskid is %s, usehttp2 is %b, usequic is %b, usecache is %b, url is %s, filename is %s", new Object[] { this.hLO, Boolean.valueOf(this.hLX), Boolean.valueOf(this.hLY), Boolean.valueOf(this.kVl), this.uri, this.filename });
      Object localObject1 = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "AppBrandDownloadWorker#TimerTask";
        }
        
        public final void run()
        {
          AppMethodBeat.i(175396);
          ad.e("MicroMsg.AppBrandDownloadWorker", "call cronet time out taskid:%s,timeout:%d,url:%s", new Object[] { b.this.hLO, Integer.valueOf(b.this.timeout), b.this.uri });
          if (!b.this.kVk)
          {
            b.this.kVk = true;
            b.this.kVW.J(b.this.filename, b.this.uri, "socket timeout");
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 6L, 1L, false);
            if (!bt.isNullOrNil(b.this.kWb)) {
              CronetLogic.cancelCronetTask(b.this.kWb);
            }
            AppMethodBeat.o(175396);
            return;
            ad.e("MicroMsg.AppBrandDownloadWorker", "call cronet time out already callback");
          }
        }
      };
      localObject2 = new CronetLogic.CronetTaskCallback()
      {
        public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramAnonymousResponseHeader, int paramAnonymousInt)
        {
          AppMethodBeat.i(175399);
          ad.i("MicroMsg.AppBrandDownloadWorker", "cronet file download onCronetReceiveHeader status %d,taskid:%s,CronetRequestId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), b.h(b.this), b.g(b.this) });
          paramAnonymousResponseHeader = CronetLogic.getHeaderList(paramAnonymousResponseHeader);
          Object localObject1 = j.c(paramAnonymousResponseHeader, 2);
          b.f(b.this).C((JSONObject)localObject1);
          paramAnonymousResponseHeader = paramAnonymousResponseHeader.entrySet().iterator();
          Object localObject2;
          for (;;)
          {
            if (paramAnonymousResponseHeader.hasNext())
            {
              localObject2 = (Map.Entry)paramAnonymousResponseHeader.next();
              localObject1 = (String)((Map.Entry)localObject2).getKey();
              localObject2 = (List)((Map.Entry)localObject2).getValue();
              if ((!bt.isNullOrNil((String)localObject1)) && (localObject2 != null) && (!((List)localObject2).isEmpty())) {
                if (((String)localObject1).equals("Content-Length"))
                {
                  ad.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader Content-Length:%s", new Object[] { ((List)localObject2).get(0) });
                  paramAnonymousInt = Integer.parseInt((String)((List)localObject2).get(0));
                }
              }
            }
          }
          for (;;)
          {
            label190:
            if (paramAnonymousInt > 0)
            {
              ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 16L, paramAnonymousInt, false);
              label216:
              if ((paramAnonymousInt <= 0) || (b.i(b.this) <= 0) || (paramAnonymousInt < b.i(b.this) * 1048576)) {
                break label406;
              }
              ad.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader before actually read stream, contentLength %d exceed limit", new Object[] { Integer.valueOf(paramAnonymousInt) });
              if (b.b(b.this)) {
                break label396;
              }
              b.c(b.this);
              b.f(b.this).J(b.d(b.this), b.e(b.this), "exceed max file size");
            }
            for (;;)
            {
              if (this.kWd != null)
              {
                this.kWd.cancel();
                ad.i("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader exceed max file size TimerTask cancel");
              }
              AppMethodBeat.o(175399);
              return -1;
              if (!((String)localObject1).equals("content-length")) {
                break;
              }
              ad.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader content-length:%s", new Object[] { ((List)localObject2).get(0) });
              paramAnonymousInt = Integer.parseInt((String)((List)localObject2).get(0));
              break label190;
              ad.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader contentLength fail");
              break label216;
              label396:
              ad.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader max file size already callback");
            }
            label406:
            AppMethodBeat.o(175399);
            return 0;
            paramAnonymousInt = 0;
          }
        }
        
        public final void onCronetTaskCompleted(String paramAnonymousString, final CronetLogic.CronetTaskResult paramAnonymousCronetTaskResult)
        {
          AppMethodBeat.i(175400);
          ad.i("MicroMsg.AppBrandDownloadWorker", "onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s,fileKey:%s", new Object[] { Integer.valueOf(paramAnonymousCronetTaskResult.errorCode), paramAnonymousCronetTaskResult.errorMsg, Integer.valueOf(paramAnonymousCronetTaskResult.statusCode), Long.valueOf(paramAnonymousCronetTaskResult.totalReceiveByte), b.h(b.this), b.g(b.this), paramAnonymousString });
          if (this.kWd != null) {
            this.kWd.cancel();
          }
          h.Iye.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175397);
              int j = (int)paramAnonymousCronetTaskResult.totalReceiveByte;
              int k = paramAnonymousCronetTaskResult.statusCode;
              ad.i("MicroMsg.AppBrandDownloadWorker", "appbrand_cronetdownload_callback_thread run taskid:%s,CronetRequestId:%s", new Object[] { b.this.hLO, b.this.kWb });
              int i;
              if (paramAnonymousCronetTaskResult.errorCode == 0)
              {
                i = 28;
                if ((k >= 100) && (k < 200)) {
                  i = 20;
                }
                Object localObject1;
                String str;
                label161:
                Object localObject2;
                for (;;)
                {
                  ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, i, 1L, false);
                  ad.i("MicroMsg.AppBrandDownloadWorker", "reportCronetStatusCode:%d, key:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
                  localObject1 = paramAnonymousCronetTaskResult.getHeaderMap().entrySet().iterator();
                  Object localObject3;
                  for (str = ""; ((Iterator)localObject1).hasNext(); str = b.dK((String)localObject3, b.this.uri))
                  {
                    localObject3 = (Map.Entry)((Iterator)localObject1).next();
                    localObject2 = (String)((Map.Entry)localObject3).getKey();
                    localObject3 = (String)((Map.Entry)localObject3).getValue();
                    if ((!((String)localObject2).equalsIgnoreCase("Content-Type")) && (!((String)localObject2).equalsIgnoreCase("content-type"))) {
                      break label161;
                    }
                  }
                  if (200 == k) {
                    i = 21;
                  } else if ((k > 200) && (k < 300)) {
                    i = 22;
                  } else if (302 == k) {
                    i = 23;
                  } else if ((k >= 300) && (k < 400)) {
                    i = 24;
                  } else if (404 == k) {
                    i = 25;
                  } else if ((k >= 400) && (k < 500)) {
                    i = 26;
                  } else if (k >= 500) {
                    i = 27;
                  }
                }
                if (k != 200)
                {
                  ad.e("MicroMsg.AppBrandDownloadWorker", "failed code: %d,url is %s,filename is %s ", new Object[] { Integer.valueOf(k), b.this.uri, b.this.filename });
                  if (j.na(k))
                  {
                    localObject1 = paramAnonymousCronetTaskResult.newLocation;
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      localObject2 = b.this;
                      i = ((b)localObject2).kVf;
                      ((b)localObject2).kVf = (i - 1);
                      if (i <= 0)
                      {
                        ad.w("MicroMsg.AppBrandDownloadWorker", "reach the max redirect count(%d)", new Object[] { Integer.valueOf(15) });
                        if (!b.this.kVk)
                        {
                          b.this.kVk = true;
                          if (b.this.kVm) {
                            b.this.kVW.a(b.this.filename, str, b.this.uri, k, 0L, j.a(paramAnonymousCronetTaskResult.webPageProfile));
                          }
                          for (;;)
                          {
                            ((o)e.L(o.class)).a(b.this.joJ.getAppId(), b.this.kVj, "GET", b.this.uri, 0L, j, k, 1, b.this.bio(), b.this.filename, str);
                            ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 10L, 1L, false);
                            ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 12L, System.currentTimeMillis() - b.this.kVZ, false);
                            AppMethodBeat.o(175397);
                            return;
                            b.this.kVW.a(b.this.filename, str, b.this.uri, k, 0L, null);
                          }
                        }
                        ad.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted max redirect already callback");
                        AppMethodBeat.o(175397);
                        return;
                      }
                      ad.i("MicroMsg.AppBrandDownloadWorker", "redirect(%d) URL(%s) to URL(%s)", new Object[] { Integer.valueOf(b.this.kVf), b.this.uri, localObject1 });
                      b.this.uri = ((String)localObject1);
                      b.this.run();
                      AppMethodBeat.o(175397);
                      return;
                    }
                  }
                }
                if (!b.this.kVk)
                {
                  b.this.kVk = true;
                  long l1;
                  long l2;
                  if (b.this.isRunning) {
                    if (b.this.kVm)
                    {
                      b.this.kVW.a(b.this.filename, str, b.this.uri, k, j, j.a(paramAnonymousCronetTaskResult.webPageProfile));
                      l1 = paramAnonymousCronetTaskResult.totalReceiveByte;
                      l2 = System.currentTimeMillis() - b.this.kVZ;
                      if ((l1 > 0L) && (l2 > 0L)) {
                        break label1382;
                      }
                      ad.i("MicroMsg.AppBrandDownloadWorker", "reportCronetSpeed len:%d, time:%d return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                      b.2.this.kWe.success = true;
                    }
                  }
                  for (;;)
                  {
                    ad.i("MicroMsg.AppBrandDownloadWorker", "cronet download file finished taskid:%s,CronetRequestId:%s,contentType:%s,filename: %s, url:%s ", new Object[] { b.this.hLO, b.this.kWb, str, b.this.filename, b.this.uri });
                    b.this.kVW.KX(b.this.hLO);
                    ((o)e.L(o.class)).a(b.this.joJ.getAppId(), b.this.kVj, "GET", b.this.uri, 0L, j, k, 1, b.this.bio(), b.this.filename, str);
                    ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 10L, 1L, false);
                    ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 12L, System.currentTimeMillis() - b.this.kVZ, false);
                    l1 = System.currentTimeMillis() - b.2.this.hhs;
                    ad.i("cronet download time", "request time is ".concat(String.valueOf(l1)));
                    ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1199L, 99L, l1, false);
                    ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1199L, 97L, 1L, false);
                    AppMethodBeat.o(175397);
                    return;
                    b.this.kVW.a(b.this.filename, str, b.this.uri, k, j, null);
                    break;
                    label1382:
                    i = 34;
                    double d = l1 / l2 * 0.9765625D;
                    if (ay.is2G(aj.getContext())) {
                      i = 30;
                    }
                    for (;;)
                    {
                      ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, i, d, false);
                      ad.i("MicroMsg.AppBrandDownloadWorker", "reportCronetSpeed len:%d, time:%d, speed:%f, key:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Double.valueOf(d), Integer.valueOf(i) });
                      break;
                      if (ay.is3G(aj.getContext())) {
                        i = 31;
                      } else if (ay.is4G(aj.getContext())) {
                        i = 32;
                      } else if (ay.isWifi(aj.getContext())) {
                        i = 33;
                      }
                    }
                    b.this.kVW.J(b.this.filename, b.this.uri, "force stop");
                  }
                }
                ad.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted already callback");
                AppMethodBeat.o(175397);
                return;
              }
              if (!b.this.kVk)
              {
                b.this.kVk = true;
                b.this.kVW.J(b.this.filename, b.this.uri, "download fail:" + paramAnonymousCronetTaskResult.errorCode + ":" + paramAnonymousCronetTaskResult.errorMsg);
                ((o)e.L(o.class)).a(b.this.joJ.getAppId(), b.this.kVj, "GET", b.this.uri, 0L, j, k, 2, b.this.bio(), b.this.filename, "");
                ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 11L, 1L, false);
                ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 13L, System.currentTimeMillis() - b.this.kVZ, false);
                i = ay.getNetType(aj.getContext());
                if (i == -1) {
                  ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 7L, 1L, false);
                }
                ad.i("MicroMsg.AppBrandDownloadWorker", "cronet downloadFile fail ret:%d", new Object[] { Integer.valueOf(i) });
                AppMethodBeat.o(175397);
                return;
              }
              ad.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted downloadFile fail already callback");
              AppMethodBeat.o(175397);
            }
          });
          AppMethodBeat.o(175400);
        }
        
        public final void onDownloadProgressChanged(String paramAnonymousString, CronetLogic.CronetDownloadProgress paramAnonymousCronetDownloadProgress)
        {
          AppMethodBeat.i(175398);
          if (j.F(b.this.joJ))
          {
            ad.w("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged shouldStopTask fileKey:%s,taskid %s,CronetRequestId:%s", new Object[] { paramAnonymousString, b.h(b.this), b.g(b.this) });
            if (!b.b(b.this))
            {
              b.c(b.this);
              CronetLogic.cancelCronetTask(b.g(b.this));
              b.f(b.this).J(b.d(b.this), b.e(b.this), "interrupted");
            }
            for (;;)
            {
              if (this.kWd != null)
              {
                this.kWd.cancel();
                ad.i("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged shouldStopTask TimerTask cancel");
              }
              AppMethodBeat.o(175398);
              return;
              ad.e("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged already callback");
            }
          }
          if ((paramAnonymousCronetDownloadProgress.currentWriteByte > 0L) && (b.i(b.this) > 0) && (paramAnonymousCronetDownloadProgress.currentWriteByte >= b.i(b.this) * 1048576))
          {
            if (!b.b(b.this))
            {
              ad.i("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged currentWriteByte %d exceed limit,fileKey:%s,taskid %s,CronetRequestId:%s", new Object[] { Long.valueOf(paramAnonymousCronetDownloadProgress.currentWriteByte), paramAnonymousString, b.h(b.this), b.g(b.this) });
              b.c(b.this);
              CronetLogic.cancelCronetTask(b.g(b.this));
              b.f(b.this).J(b.d(b.this), b.e(b.this), "exceed max file size");
              if (this.kWd != null)
              {
                this.kWd.cancel();
                ad.i("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged exceed max file size TimerTask cancel");
              }
              AppMethodBeat.o(175398);
              return;
            }
            ad.e("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged max file size already callback");
            AppMethodBeat.o(175398);
            return;
          }
          if ((paramAnonymousCronetDownloadProgress.totalByte > 0L) && (b.j(b.this)))
          {
            this.kWe.percent = ((int)(paramAnonymousCronetDownloadProgress.currentWriteByte * 100L / paramAnonymousCronetDownloadProgress.totalByte));
            if (this.kWe.hKS != this.kWe.percent)
            {
              paramAnonymousString = b.f(b.this);
              b.d(b.this);
              paramAnonymousString.a(b.e(b.this), this.kWe.percent, paramAnonymousCronetDownloadProgress.currentWriteByte, paramAnonymousCronetDownloadProgress.totalByte);
              this.kWe.hKS = this.kWe.percent;
            }
            if (this.kWe.percent == 100) {
              ad.i("MicroMsg.AppBrandDownloadWorker", "cronet download size %d, totalSize %d, percent = %d", new Object[] { Long.valueOf(paramAnonymousCronetDownloadProgress.currentWriteByte), Long.valueOf(paramAnonymousCronetDownloadProgress.totalByte), Integer.valueOf(this.kWe.percent) });
            }
          }
          AppMethodBeat.o(175398);
        }
      };
      CronetLogic.CronetRequestParams localCronetRequestParams = new CronetLogic.CronetRequestParams();
      localCronetRequestParams.url = this.uri;
      localCronetRequestParams.taskId = this.hLO;
      localCronetRequestParams.followRedirect = false;
      localCronetRequestParams.savePath = this.filename;
      localCronetRequestParams.method = "GET";
      localCronetRequestParams.needWirteCache = true;
      localCronetRequestParams.useHttp2 = this.hLX;
      localCronetRequestParams.useQuic = this.hLY;
      localCronetRequestParams.useMemoryCache = this.kVl;
      Object localObject3 = this.kVX;
      if (!((Map)localObject3).containsKey("Accept-Encoding")) {
        ((Map)localObject3).put("Accept-Encoding", "gzip,compress,br,deflate");
      }
      for (;;)
      {
        ((Map)localObject3).put("User-Agent", this.kwo);
        localCronetRequestParams.makeRequestHeader((Map)localObject3);
        localObject3 = j.c(j.N((Map)localObject3), 1);
        this.kVW.C((JSONObject)localObject3);
        localCronetRequestParams.taskType = 2;
        h.Iye.q((Runnable)localObject1, this.timeout);
        ad.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest taskId:%s", new Object[] { localCronetRequestParams.taskId });
        localObject1 = CronetLogic.startCronetDownloadTask(localCronetRequestParams, (CronetLogic.CronetTaskCallback)localObject2);
        ad.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest createRet is %d, taskId %s,CronetRequestId:%s", new Object[] { Integer.valueOf(((CronetLogic.CronetHttpsCreateResult)localObject1).createRet), this.hLO, ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId });
        if ((localObject1 == null) || (((CronetLogic.CronetHttpsCreateResult)localObject1).createRet == 0)) {
          break;
        }
        ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 1L, 1L, false);
        AppMethodBeat.o(144466);
        return;
        ad.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest Accept-Encoding:%s", new Object[] { ((Map)localObject3).get("Accept-Encoding") });
      }
      this.kWb = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
      ((com.tencent.mm.plugin.appbrand.u.a)e.L(com.tencent.mm.plugin.appbrand.u.a.class)).idkeyStat(1197L, 2L, 1L, false);
      AppMethodBeat.o(144466);
      return;
    }
    biB();
    AppMethodBeat.o(144466);
  }
  
  final class a
  {
    public int hKS = -1;
    public int percent = 0;
    public boolean success = false;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.a.b
 * JD-Core Version:    0.7.0.1
 */