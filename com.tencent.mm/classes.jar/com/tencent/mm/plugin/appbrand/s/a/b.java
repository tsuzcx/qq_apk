package com.tencent.mm.plugin.appbrand.s.a;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.mars.cdn.CronetLogic;
import com.tencent.mars.cdn.CronetLogic.CronetDownloadProgress;
import com.tencent.mars.cdn.CronetLogic.CronetHttpsCreateResult;
import com.tencent.mars.cdn.CronetLogic.CronetRequestParams;
import com.tencent.mars.cdn.CronetLogic.CronetTaskCallback;
import com.tencent.mars.cdn.CronetLogic.CronetTaskResult;
import com.tencent.mars.cdn.CronetLogic.ResponseHeader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil.ContentType;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
  private HttpURLConnection conn;
  private String contentType;
  String filename;
  public volatile boolean isRunning;
  private String mhI;
  public String mvB;
  private boolean mvK;
  private boolean mvL;
  com.tencent.mm.plugin.appbrand.jsapi.e okQ;
  private final String pFt;
  private boolean peH;
  public SSLContext qiA;
  final a qjX;
  public Map<String, String> qjY;
  public volatile int qjZ;
  public ArrayList<String> qjb;
  int qjc;
  public String qjg;
  volatile boolean qjh;
  private boolean qji;
  boolean qjj;
  long qka;
  String qkb;
  private long startTime;
  public int timeout;
  String uri;
  
  public b(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, a parama)
  {
    AppMethodBeat.i(186250);
    this.qjc = 15;
    this.isRunning = false;
    this.qjh = false;
    this.contentType = "unknow";
    this.timeout = 60000;
    this.peH = false;
    this.mvK = false;
    this.mvL = false;
    this.qji = false;
    this.qjj = true;
    this.okQ = parame;
    this.uri = paramString1;
    this.filename = paramString2;
    this.mhI = paramString3;
    this.qjX = parama;
    this.startTime = System.currentTimeMillis();
    this.pFt = paramString4;
    this.peH = paramBoolean1;
    this.mvK = paramBoolean2;
    this.mvL = paramBoolean3;
    this.qji = paramBoolean4;
    this.qjj = paramBoolean5;
    AppMethodBeat.o(186250);
  }
  
  private static void Ce(int paramInt)
  {
    AppMethodBeat.i(144470);
    int i = 28;
    if ((paramInt >= 100) && (paramInt < 200)) {
      i = 20;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(437L, i, 1L, false);
      Log.i("MicroMsg.AppBrandDownloadWorker", "reportStatusCode:%d, key:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
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
  
  private static void J(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(144471);
    if ((paramLong1 <= 0L) || (paramLong2 <= 0L))
    {
      Log.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d return", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(144471);
      return;
    }
    int i = 34;
    double d = paramLong1 / paramLong2 * 0.9765625D;
    if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
      i = 30;
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(437L, i, d, false);
      Log.i("MicroMsg.AppBrandDownloadWorker", "reportSpeed len:%d, time:%d, speed:%f, key:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Double.valueOf(d), Integer.valueOf(i) });
      AppMethodBeat.o(144471);
      return;
      if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
        i = 31;
      } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
        i = 32;
      } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
        i = 33;
      }
    }
  }
  
  private String bQF()
  {
    return this.qjg;
  }
  
  private String bsL()
  {
    return this.mvB;
  }
  
  /* Error */
  private void ccd()
  {
    // Byte code:
    //   0: ldc 210
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
    //   49: getfield 69	com/tencent/mm/plugin/appbrand/s/a/b:isRunning	Z
    //   52: ifne +140 -> 192
    //   55: aload_0
    //   56: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   59: aload_0
    //   60: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   63: aload_0
    //   64: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   67: ldc 212
    //   69: invokeinterface 217 4 0
    //   74: aload_0
    //   75: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   78: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   81: ifeq +57 -> 138
    //   84: ldc 225
    //   86: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   89: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   92: aload_0
    //   93: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   96: invokeinterface 230 1 0
    //   101: aload_0
    //   102: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   105: ldc 234
    //   107: aload_0
    //   108: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   111: lconst_0
    //   112: lconst_0
    //   113: iconst_0
    //   114: iconst_2
    //   115: aload_0
    //   116: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   119: aload_0
    //   120: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   127: invokeinterface 244 14 0
    //   132: ldc 210
    //   134: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: return
    //   138: ldc 225
    //   140: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   143: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   146: aload_0
    //   147: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   150: invokeinterface 230 1 0
    //   155: aload_0
    //   156: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   159: ldc 234
    //   161: aload_0
    //   162: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   165: lconst_0
    //   166: lconst_0
    //   167: iconst_0
    //   168: iconst_2
    //   169: aload_0
    //   170: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   173: aload_0
    //   174: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   177: aload_0
    //   178: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   181: invokeinterface 244 14 0
    //   186: ldc 210
    //   188: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: return
    //   192: aload_0
    //   193: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   196: putfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   199: aload_0
    //   200: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   203: aload_0
    //   204: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   207: aload_0
    //   208: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   211: invokeinterface 250 3 0
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
    //   237: ldc 116
    //   239: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   242: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   245: ldc2_w 123
    //   248: lconst_0
    //   249: lconst_1
    //   250: iconst_0
    //   251: invokeinterface 128 8 0
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
    //   277: new 252	java/net/URL
    //   280: dup
    //   281: aload_0
    //   282: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   285: invokespecial 255	java/net/URL:<init>	(Ljava/lang/String;)V
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
    //   311: ldc 130
    //   313: ldc_w 257
    //   316: iconst_3
    //   317: anewarray 4	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload_0
    //   323: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: aload_0
    //   330: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   333: aastore
    //   334: dup
    //   335: iconst_2
    //   336: aload_0
    //   337: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   340: aastore
    //   341: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   344: iload_1
    //   345: istore_2
    //   346: iload 14
    //   348: istore_3
    //   349: iload 15
    //   351: istore 4
    //   353: iload 16
    //   355: istore 5
    //   357: iload 17
    //   359: istore 6
    //   361: iload 18
    //   363: istore 7
    //   365: aload_0
    //   366: aload 27
    //   368: invokevirtual 261	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   371: checkcast 263	java/net/HttpURLConnection
    //   374: putfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   377: iload_1
    //   378: istore_2
    //   379: iload 14
    //   381: istore_3
    //   382: iload 15
    //   384: istore 4
    //   386: iload 16
    //   388: istore 5
    //   390: iload 17
    //   392: istore 6
    //   394: iload 18
    //   396: istore 7
    //   398: aload_0
    //   399: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   402: instanceof 267
    //   405: ifeq +101 -> 506
    //   408: iload_1
    //   409: istore_2
    //   410: iload 14
    //   412: istore_3
    //   413: iload 15
    //   415: istore 4
    //   417: iload 16
    //   419: istore 5
    //   421: iload 17
    //   423: istore 6
    //   425: iload 18
    //   427: istore 7
    //   429: aload_0
    //   430: getfield 269	com/tencent/mm/plugin/appbrand/s/a/b:qiA	Ljavax/net/ssl/SSLContext;
    //   433: ifnull +73 -> 506
    //   436: iload_1
    //   437: istore_2
    //   438: iload 14
    //   440: istore_3
    //   441: iload 15
    //   443: istore 4
    //   445: iload 16
    //   447: istore 5
    //   449: iload 17
    //   451: istore 6
    //   453: iload 18
    //   455: istore 7
    //   457: aload_0
    //   458: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   461: checkcast 267	javax/net/ssl/HttpsURLConnection
    //   464: aload_0
    //   465: getfield 269	com/tencent/mm/plugin/appbrand/s/a/b:qiA	Ljavax/net/ssl/SSLContext;
    //   468: invokevirtual 275	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   471: invokevirtual 279	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   474: iload_1
    //   475: istore_2
    //   476: iload 14
    //   478: istore_3
    //   479: iload 15
    //   481: istore 4
    //   483: iload 16
    //   485: istore 5
    //   487: iload 17
    //   489: istore 6
    //   491: iload 18
    //   493: istore 7
    //   495: aload_0
    //   496: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   499: aload_0
    //   500: getfield 281	com/tencent/mm/plugin/appbrand/s/a/b:qjb	Ljava/util/ArrayList;
    //   503: invokestatic 286	com/tencent/mm/plugin/appbrand/s/j:a	(Ljava/net/HttpURLConnection;Ljava/util/ArrayList;)V
    //   506: iload_1
    //   507: istore_2
    //   508: iload 14
    //   510: istore_3
    //   511: iload 15
    //   513: istore 4
    //   515: iload 16
    //   517: istore 5
    //   519: iload 17
    //   521: istore 6
    //   523: iload 18
    //   525: istore 7
    //   527: aload_0
    //   528: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   531: iconst_1
    //   532: invokevirtual 290	java/net/HttpURLConnection:setDoInput	(Z)V
    //   535: iload_1
    //   536: istore_2
    //   537: iload 14
    //   539: istore_3
    //   540: iload 15
    //   542: istore 4
    //   544: iload 16
    //   546: istore 5
    //   548: iload 17
    //   550: istore 6
    //   552: iload 18
    //   554: istore 7
    //   556: aload_0
    //   557: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   560: aload_0
    //   561: getfield 78	com/tencent/mm/plugin/appbrand/s/a/b:timeout	I
    //   564: invokevirtual 293	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   567: iload_1
    //   568: istore_2
    //   569: iload 14
    //   571: istore_3
    //   572: iload 15
    //   574: istore 4
    //   576: iload 16
    //   578: istore 5
    //   580: iload 17
    //   582: istore 6
    //   584: iload 18
    //   586: istore 7
    //   588: aload_0
    //   589: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   592: aload_0
    //   593: getfield 78	com/tencent/mm/plugin/appbrand/s/a/b:timeout	I
    //   596: invokevirtual 296	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   599: iload_1
    //   600: istore_2
    //   601: iload 14
    //   603: istore_3
    //   604: iload 15
    //   606: istore 4
    //   608: iload 16
    //   610: istore 5
    //   612: iload 17
    //   614: istore 6
    //   616: iload 18
    //   618: istore 7
    //   620: aload_0
    //   621: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   624: iconst_0
    //   625: invokevirtual 299	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   628: iload_1
    //   629: istore_2
    //   630: iload 14
    //   632: istore_3
    //   633: iload 15
    //   635: istore 4
    //   637: iload 16
    //   639: istore 5
    //   641: iload 17
    //   643: istore 6
    //   645: iload 18
    //   647: istore 7
    //   649: aload_0
    //   650: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   653: ldc_w 301
    //   656: ldc_w 303
    //   659: invokevirtual 306	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: iload_1
    //   663: istore_2
    //   664: iload 14
    //   666: istore_3
    //   667: iload 15
    //   669: istore 4
    //   671: iload 16
    //   673: istore 5
    //   675: iload 17
    //   677: istore 6
    //   679: iload 18
    //   681: istore 7
    //   683: aload_0
    //   684: getfield 308	com/tencent/mm/plugin/appbrand/s/a/b:qjY	Ljava/util/Map;
    //   687: ifnull +511 -> 1198
    //   690: iload_1
    //   691: istore_2
    //   692: iload 14
    //   694: istore_3
    //   695: iload 15
    //   697: istore 4
    //   699: iload 16
    //   701: istore 5
    //   703: iload 17
    //   705: istore 6
    //   707: iload 18
    //   709: istore 7
    //   711: ldc 130
    //   713: ldc_w 310
    //   716: iconst_1
    //   717: anewarray 4	java/lang/Object
    //   720: dup
    //   721: iconst_0
    //   722: aload 27
    //   724: aastore
    //   725: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   728: iload_1
    //   729: istore_2
    //   730: iload 14
    //   732: istore_3
    //   733: iload 15
    //   735: istore 4
    //   737: iload 16
    //   739: istore 5
    //   741: iload 17
    //   743: istore 6
    //   745: iload 18
    //   747: istore 7
    //   749: aload_0
    //   750: getfield 308	com/tencent/mm/plugin/appbrand/s/a/b:qjY	Ljava/util/Map;
    //   753: invokeinterface 316 1 0
    //   758: invokeinterface 322 1 0
    //   763: astore 28
    //   765: iload_1
    //   766: istore_2
    //   767: iload 14
    //   769: istore_3
    //   770: iload 15
    //   772: istore 4
    //   774: iload 16
    //   776: istore 5
    //   778: iload 17
    //   780: istore 6
    //   782: iload 18
    //   784: istore 7
    //   786: aload 28
    //   788: invokeinterface 328 1 0
    //   793: ifeq +405 -> 1198
    //   796: iload_1
    //   797: istore_2
    //   798: iload 14
    //   800: istore_3
    //   801: iload 15
    //   803: istore 4
    //   805: iload 16
    //   807: istore 5
    //   809: iload 17
    //   811: istore 6
    //   813: iload 18
    //   815: istore 7
    //   817: aload 28
    //   819: invokeinterface 332 1 0
    //   824: checkcast 334	java/util/Map$Entry
    //   827: astore 29
    //   829: iload_1
    //   830: istore_2
    //   831: iload 14
    //   833: istore_3
    //   834: iload 15
    //   836: istore 4
    //   838: iload 16
    //   840: istore 5
    //   842: iload 17
    //   844: istore 6
    //   846: iload 18
    //   848: istore 7
    //   850: aload_0
    //   851: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   854: aload 29
    //   856: invokeinterface 337 1 0
    //   861: checkcast 339	java/lang/String
    //   864: aload 29
    //   866: invokeinterface 342 1 0
    //   871: checkcast 339	java/lang/String
    //   874: invokevirtual 306	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   877: iload_1
    //   878: istore_2
    //   879: iload 14
    //   881: istore_3
    //   882: iload 15
    //   884: istore 4
    //   886: iload 16
    //   888: istore 5
    //   890: iload 17
    //   892: istore 6
    //   894: iload 18
    //   896: istore 7
    //   898: ldc 130
    //   900: ldc_w 344
    //   903: iconst_3
    //   904: anewarray 4	java/lang/Object
    //   907: dup
    //   908: iconst_0
    //   909: aload_0
    //   910: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   913: aastore
    //   914: dup
    //   915: iconst_1
    //   916: aload 29
    //   918: invokeinterface 337 1 0
    //   923: aastore
    //   924: dup
    //   925: iconst_2
    //   926: aload 29
    //   928: invokeinterface 342 1 0
    //   933: aastore
    //   934: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   937: goto -172 -> 765
    //   940: astore 29
    //   942: aconst_null
    //   943: astore 27
    //   945: aconst_null
    //   946: astore 28
    //   948: iconst_0
    //   949: istore_1
    //   950: ldc 116
    //   952: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   955: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   958: ldc2_w 123
    //   961: lconst_1
    //   962: lconst_1
    //   963: iconst_0
    //   964: invokeinterface 128 8 0
    //   969: ldc 130
    //   971: aload 29
    //   973: ldc_w 346
    //   976: iconst_2
    //   977: anewarray 4	java/lang/Object
    //   980: dup
    //   981: iconst_0
    //   982: aload_0
    //   983: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   986: aastore
    //   987: dup
    //   988: iconst_1
    //   989: aload_0
    //   990: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   993: aastore
    //   994: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   997: aload_0
    //   998: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   1001: aload_0
    //   1002: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   1005: aload_0
    //   1006: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   1009: ldc_w 352
    //   1012: invokeinterface 217 4 0
    //   1017: iload_1
    //   1018: ifeq +5031 -> 6049
    //   1021: aload_0
    //   1022: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   1025: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1028: ifeq +4969 -> 5997
    //   1031: ldc 225
    //   1033: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1036: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   1039: aload_0
    //   1040: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   1043: invokeinterface 230 1 0
    //   1048: aload_0
    //   1049: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   1052: ldc 234
    //   1054: aload_0
    //   1055: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   1058: lconst_0
    //   1059: lload 19
    //   1061: iload_2
    //   1062: iconst_1
    //   1063: aload_0
    //   1064: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   1067: aload_0
    //   1068: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   1071: aload_0
    //   1072: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   1075: invokeinterface 244 14 0
    //   1080: ldc 116
    //   1082: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1085: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   1088: ldc2_w 123
    //   1091: ldc2_w 353
    //   1094: lconst_1
    //   1095: iconst_0
    //   1096: invokeinterface 128 8 0
    //   1101: ldc 116
    //   1103: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1106: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   1109: ldc2_w 123
    //   1112: ldc2_w 355
    //   1115: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1118: aload_0
    //   1119: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   1122: lsub
    //   1123: iconst_0
    //   1124: invokeinterface 128 8 0
    //   1129: aload 27
    //   1131: ifnull +8 -> 1139
    //   1134: aload 27
    //   1136: invokevirtual 361	java/io/OutputStream:close	()V
    //   1139: aload 28
    //   1141: ifnull +8 -> 1149
    //   1144: aload 28
    //   1146: invokevirtual 364	java/io/InputStream:close	()V
    //   1149: aload_0
    //   1150: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   1153: aload_0
    //   1154: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   1157: aload_0
    //   1158: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   1161: invokeinterface 372 2 0
    //   1166: ldc 130
    //   1168: ldc_w 374
    //   1171: iconst_2
    //   1172: anewarray 4	java/lang/Object
    //   1175: dup
    //   1176: iconst_0
    //   1177: aload_0
    //   1178: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   1181: aastore
    //   1182: dup
    //   1183: iconst_1
    //   1184: aload_0
    //   1185: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   1188: aastore
    //   1189: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1192: ldc 210
    //   1194: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1197: return
    //   1198: iload_1
    //   1199: istore_2
    //   1200: iload 14
    //   1202: istore_3
    //   1203: iload 15
    //   1205: istore 4
    //   1207: iload 16
    //   1209: istore 5
    //   1211: iload 17
    //   1213: istore 6
    //   1215: iload 18
    //   1217: istore 7
    //   1219: aload_0
    //   1220: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   1223: ldc_w 376
    //   1226: aload_0
    //   1227: getfield 108	com/tencent/mm/plugin/appbrand/s/a/b:pFt	Ljava/lang/String;
    //   1230: invokevirtual 306	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1233: iload_1
    //   1234: istore_2
    //   1235: iload 14
    //   1237: istore_3
    //   1238: iload 15
    //   1240: istore 4
    //   1242: iload 16
    //   1244: istore 5
    //   1246: iload 17
    //   1248: istore 6
    //   1250: iload 18
    //   1252: istore 7
    //   1254: aload_0
    //   1255: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   1258: invokestatic 380	com/tencent/mm/plugin/appbrand/s/j:e	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
    //   1261: astore 28
    //   1263: iload_1
    //   1264: istore_2
    //   1265: iload 14
    //   1267: istore_3
    //   1268: iload 15
    //   1270: istore 4
    //   1272: iload 16
    //   1274: istore 5
    //   1276: iload 17
    //   1278: istore 6
    //   1280: iload 18
    //   1282: istore 7
    //   1284: aload_0
    //   1285: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   1288: aload 28
    //   1290: invokeinterface 384 2 0
    //   1295: iload_1
    //   1296: istore_2
    //   1297: iload 14
    //   1299: istore_3
    //   1300: iload 15
    //   1302: istore 4
    //   1304: iload 16
    //   1306: istore 5
    //   1308: iload 17
    //   1310: istore 6
    //   1312: iload 18
    //   1314: istore 7
    //   1316: aload_0
    //   1317: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   1320: invokevirtual 387	java/net/HttpURLConnection:getContentLength	()I
    //   1323: i2l
    //   1324: lstore 25
    //   1326: iload_1
    //   1327: istore_2
    //   1328: iload 14
    //   1330: istore_3
    //   1331: iload 15
    //   1333: istore 4
    //   1335: iload 16
    //   1337: istore 5
    //   1339: iload 17
    //   1341: istore 6
    //   1343: iload 18
    //   1345: istore 7
    //   1347: aload_0
    //   1348: aload_0
    //   1349: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   1352: ldc_w 389
    //   1355: invokevirtual 393	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1358: aload 27
    //   1360: invokevirtual 396	java/net/URL:toString	()Ljava/lang/String;
    //   1363: invokestatic 400	com/tencent/mm/plugin/appbrand/s/a/b:eN	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1366: putfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   1369: iload_1
    //   1370: istore_2
    //   1371: iload 14
    //   1373: istore_3
    //   1374: iload 15
    //   1376: istore 4
    //   1378: iload 16
    //   1380: istore 5
    //   1382: iload 17
    //   1384: istore 6
    //   1386: iload 18
    //   1388: istore 7
    //   1390: aload_0
    //   1391: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   1394: invokevirtual 403	java/net/HttpURLConnection:getResponseCode	()I
    //   1397: istore_1
    //   1398: lload 25
    //   1400: lconst_0
    //   1401: lcmp
    //   1402: ifle +41 -> 1443
    //   1405: iload_1
    //   1406: istore_2
    //   1407: iload_1
    //   1408: istore_3
    //   1409: iload_1
    //   1410: istore 4
    //   1412: iload_1
    //   1413: istore 5
    //   1415: iload_1
    //   1416: istore 6
    //   1418: iload_1
    //   1419: istore 7
    //   1421: ldc 116
    //   1423: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1426: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   1429: ldc2_w 123
    //   1432: ldc2_w 404
    //   1435: lload 25
    //   1437: iconst_0
    //   1438: invokeinterface 128 8 0
    //   1443: iload_1
    //   1444: istore_2
    //   1445: iload_1
    //   1446: istore_3
    //   1447: iload_1
    //   1448: istore 4
    //   1450: iload_1
    //   1451: istore 5
    //   1453: iload_1
    //   1454: istore 6
    //   1456: iload_1
    //   1457: istore 7
    //   1459: aload_0
    //   1460: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   1463: invokestatic 408	com/tencent/mm/plugin/appbrand/s/j:d	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
    //   1466: astore 27
    //   1468: iload_1
    //   1469: istore_2
    //   1470: iload_1
    //   1471: istore_3
    //   1472: iload_1
    //   1473: istore 4
    //   1475: iload_1
    //   1476: istore 5
    //   1478: iload_1
    //   1479: istore 6
    //   1481: iload_1
    //   1482: istore 7
    //   1484: iload_1
    //   1485: invokestatic 410	com/tencent/mm/plugin/appbrand/s/a/b:Ce	(I)V
    //   1488: iload_1
    //   1489: istore_2
    //   1490: iload_1
    //   1491: istore_3
    //   1492: iload_1
    //   1493: istore 4
    //   1495: iload_1
    //   1496: istore 5
    //   1498: iload_1
    //   1499: istore 6
    //   1501: iload_1
    //   1502: istore 7
    //   1504: aload_0
    //   1505: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   1508: aload 27
    //   1510: invokeinterface 384 2 0
    //   1515: iload_1
    //   1516: sipush 200
    //   1519: if_icmpeq +823 -> 2342
    //   1522: iload_1
    //   1523: istore_2
    //   1524: iload_1
    //   1525: istore_3
    //   1526: iload_1
    //   1527: istore 4
    //   1529: iload_1
    //   1530: istore 5
    //   1532: iload_1
    //   1533: istore 6
    //   1535: iload_1
    //   1536: istore 7
    //   1538: ldc 130
    //   1540: ldc_w 412
    //   1543: iconst_4
    //   1544: anewarray 4	java/lang/Object
    //   1547: dup
    //   1548: iconst_0
    //   1549: iload_1
    //   1550: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1553: aastore
    //   1554: dup
    //   1555: iconst_1
    //   1556: aload_0
    //   1557: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   1560: aastore
    //   1561: dup
    //   1562: iconst_2
    //   1563: aload_0
    //   1564: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   1567: aastore
    //   1568: dup
    //   1569: iconst_3
    //   1570: aload_0
    //   1571: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   1574: aastore
    //   1575: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1578: iload_1
    //   1579: istore_2
    //   1580: iload_1
    //   1581: istore_3
    //   1582: iload_1
    //   1583: istore 4
    //   1585: iload_1
    //   1586: istore 5
    //   1588: iload_1
    //   1589: istore 6
    //   1591: iload_1
    //   1592: istore 7
    //   1594: iload_1
    //   1595: invokestatic 418	com/tencent/mm/plugin/appbrand/s/j:uO	(I)Z
    //   1598: ifeq +744 -> 2342
    //   1601: iload_1
    //   1602: istore_2
    //   1603: iload_1
    //   1604: istore_3
    //   1605: iload_1
    //   1606: istore 4
    //   1608: iload_1
    //   1609: istore 5
    //   1611: iload_1
    //   1612: istore 6
    //   1614: iload_1
    //   1615: istore 7
    //   1617: aload_0
    //   1618: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   1621: invokestatic 421	com/tencent/mm/plugin/appbrand/s/j:c	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   1624: astore 27
    //   1626: iload_1
    //   1627: istore_2
    //   1628: iload_1
    //   1629: istore_3
    //   1630: iload_1
    //   1631: istore 4
    //   1633: iload_1
    //   1634: istore 5
    //   1636: iload_1
    //   1637: istore 6
    //   1639: iload_1
    //   1640: istore 7
    //   1642: aload 27
    //   1644: invokestatic 427	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1647: ifne +695 -> 2342
    //   1650: iload_1
    //   1651: istore_2
    //   1652: iload_1
    //   1653: istore_3
    //   1654: iload_1
    //   1655: istore 4
    //   1657: iload_1
    //   1658: istore 5
    //   1660: iload_1
    //   1661: istore 6
    //   1663: iload_1
    //   1664: istore 7
    //   1666: aload_0
    //   1667: getfield 67	com/tencent/mm/plugin/appbrand/s/a/b:qjc	I
    //   1670: istore 13
    //   1672: iload_1
    //   1673: istore_2
    //   1674: iload_1
    //   1675: istore_3
    //   1676: iload_1
    //   1677: istore 4
    //   1679: iload_1
    //   1680: istore 5
    //   1682: iload_1
    //   1683: istore 6
    //   1685: iload_1
    //   1686: istore 7
    //   1688: aload_0
    //   1689: iload 13
    //   1691: iconst_1
    //   1692: isub
    //   1693: putfield 67	com/tencent/mm/plugin/appbrand/s/a/b:qjc	I
    //   1696: iload 13
    //   1698: ifgt +286 -> 1984
    //   1701: iload_1
    //   1702: istore_2
    //   1703: iload_1
    //   1704: istore_3
    //   1705: iload_1
    //   1706: istore 4
    //   1708: iload_1
    //   1709: istore 5
    //   1711: iload_1
    //   1712: istore 6
    //   1714: iload_1
    //   1715: istore 7
    //   1717: ldc 130
    //   1719: ldc_w 429
    //   1722: iconst_1
    //   1723: anewarray 4	java/lang/Object
    //   1726: dup
    //   1727: iconst_0
    //   1728: bipush 15
    //   1730: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1733: aastore
    //   1734: invokestatic 432	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1737: iload_1
    //   1738: istore_2
    //   1739: iload_1
    //   1740: istore_3
    //   1741: iload_1
    //   1742: istore 4
    //   1744: iload_1
    //   1745: istore 5
    //   1747: iload_1
    //   1748: istore 6
    //   1750: iload_1
    //   1751: istore 7
    //   1753: aload_0
    //   1754: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   1757: aload_0
    //   1758: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   1761: aload_0
    //   1762: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   1765: aload_0
    //   1766: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   1769: iload_1
    //   1770: lconst_0
    //   1771: aconst_null
    //   1772: invokeinterface 435 8 0
    //   1777: aload_0
    //   1778: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   1781: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   1784: ifeq +149 -> 1933
    //   1787: ldc 225
    //   1789: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1792: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   1795: aload_0
    //   1796: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   1799: invokeinterface 230 1 0
    //   1804: aload_0
    //   1805: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   1808: ldc 234
    //   1810: aload_0
    //   1811: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   1814: lconst_0
    //   1815: lconst_0
    //   1816: iload_1
    //   1817: iconst_1
    //   1818: aload_0
    //   1819: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   1822: aload_0
    //   1823: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   1826: aload_0
    //   1827: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   1830: invokeinterface 244 14 0
    //   1835: ldc 116
    //   1837: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1840: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   1843: ldc2_w 123
    //   1846: ldc2_w 353
    //   1849: lconst_1
    //   1850: iconst_0
    //   1851: invokeinterface 128 8 0
    //   1856: ldc 116
    //   1858: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1861: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   1864: ldc2_w 123
    //   1867: ldc2_w 355
    //   1870: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   1873: aload_0
    //   1874: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   1877: lsub
    //   1878: iconst_0
    //   1879: invokeinterface 128 8 0
    //   1884: aload_0
    //   1885: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   1888: aload_0
    //   1889: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   1892: aload_0
    //   1893: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   1896: invokeinterface 372 2 0
    //   1901: ldc 130
    //   1903: ldc_w 374
    //   1906: iconst_2
    //   1907: anewarray 4	java/lang/Object
    //   1910: dup
    //   1911: iconst_0
    //   1912: aload_0
    //   1913: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   1916: aastore
    //   1917: dup
    //   1918: iconst_1
    //   1919: aload_0
    //   1920: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   1923: aastore
    //   1924: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1927: ldc 210
    //   1929: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1932: return
    //   1933: ldc 225
    //   1935: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   1938: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   1941: aload_0
    //   1942: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   1945: invokeinterface 230 1 0
    //   1950: aload_0
    //   1951: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   1954: ldc 234
    //   1956: aload_0
    //   1957: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   1960: lconst_0
    //   1961: lconst_0
    //   1962: iload_1
    //   1963: iconst_1
    //   1964: aload_0
    //   1965: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   1968: aload_0
    //   1969: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   1972: aload_0
    //   1973: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   1976: invokeinterface 244 14 0
    //   1981: goto -146 -> 1835
    //   1984: iload_1
    //   1985: istore_2
    //   1986: iload_1
    //   1987: istore_3
    //   1988: iload_1
    //   1989: istore 4
    //   1991: iload_1
    //   1992: istore 5
    //   1994: iload_1
    //   1995: istore 6
    //   1997: iload_1
    //   1998: istore 7
    //   2000: ldc 130
    //   2002: ldc_w 437
    //   2005: iconst_3
    //   2006: anewarray 4	java/lang/Object
    //   2009: dup
    //   2010: iconst_0
    //   2011: aload_0
    //   2012: getfield 67	com/tencent/mm/plugin/appbrand/s/a/b:qjc	I
    //   2015: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2018: aastore
    //   2019: dup
    //   2020: iconst_1
    //   2021: aload_0
    //   2022: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   2025: aastore
    //   2026: dup
    //   2027: iconst_2
    //   2028: aload 27
    //   2030: aastore
    //   2031: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2034: iload_1
    //   2035: istore_2
    //   2036: iload_1
    //   2037: istore_3
    //   2038: iload_1
    //   2039: istore 4
    //   2041: iload_1
    //   2042: istore 5
    //   2044: iload_1
    //   2045: istore 6
    //   2047: iload_1
    //   2048: istore 7
    //   2050: aload_0
    //   2051: aload 27
    //   2053: putfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   2056: iload_1
    //   2057: istore_2
    //   2058: iload_1
    //   2059: istore_3
    //   2060: iload_1
    //   2061: istore 4
    //   2063: iload_1
    //   2064: istore 5
    //   2066: iload_1
    //   2067: istore 6
    //   2069: iload_1
    //   2070: istore 7
    //   2072: aload_0
    //   2073: invokevirtual 440	com/tencent/mm/plugin/appbrand/s/a/b:run	()V
    //   2076: aload_0
    //   2077: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   2080: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2083: ifeq +208 -> 2291
    //   2086: ldc 225
    //   2088: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2091: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   2094: aload_0
    //   2095: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   2098: invokeinterface 230 1 0
    //   2103: aload_0
    //   2104: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   2107: ldc 234
    //   2109: aload_0
    //   2110: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   2113: lconst_0
    //   2114: lconst_0
    //   2115: iload_1
    //   2116: iconst_2
    //   2117: aload_0
    //   2118: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   2121: aload_0
    //   2122: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   2125: aload_0
    //   2126: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   2129: invokeinterface 244 14 0
    //   2134: ldc 116
    //   2136: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2139: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   2142: ldc2_w 123
    //   2145: ldc2_w 441
    //   2148: lconst_1
    //   2149: iconst_0
    //   2150: invokeinterface 128 8 0
    //   2155: ldc 116
    //   2157: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2160: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   2163: ldc2_w 123
    //   2166: ldc2_w 443
    //   2169: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   2172: aload_0
    //   2173: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   2176: lsub
    //   2177: iconst_0
    //   2178: invokeinterface 128 8 0
    //   2183: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2186: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   2189: istore_1
    //   2190: iload_1
    //   2191: iconst_m1
    //   2192: if_icmpne +24 -> 2216
    //   2195: ldc 116
    //   2197: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2200: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   2203: ldc2_w 123
    //   2206: ldc2_w 449
    //   2209: lconst_1
    //   2210: iconst_0
    //   2211: invokeinterface 128 8 0
    //   2216: ldc 130
    //   2218: ldc_w 452
    //   2221: iconst_2
    //   2222: anewarray 4	java/lang/Object
    //   2225: dup
    //   2226: iconst_0
    //   2227: aload_0
    //   2228: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   2231: aastore
    //   2232: dup
    //   2233: iconst_1
    //   2234: iload_1
    //   2235: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2238: aastore
    //   2239: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2242: aload_0
    //   2243: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   2246: aload_0
    //   2247: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   2250: aload_0
    //   2251: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   2254: invokeinterface 372 2 0
    //   2259: ldc 130
    //   2261: ldc_w 374
    //   2264: iconst_2
    //   2265: anewarray 4	java/lang/Object
    //   2268: dup
    //   2269: iconst_0
    //   2270: aload_0
    //   2271: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   2274: aastore
    //   2275: dup
    //   2276: iconst_1
    //   2277: aload_0
    //   2278: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   2281: aastore
    //   2282: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2285: ldc 210
    //   2287: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2290: return
    //   2291: ldc 225
    //   2293: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2296: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   2299: aload_0
    //   2300: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   2303: invokeinterface 230 1 0
    //   2308: aload_0
    //   2309: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   2312: ldc 234
    //   2314: aload_0
    //   2315: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   2318: lconst_0
    //   2319: lconst_0
    //   2320: iload_1
    //   2321: iconst_2
    //   2322: aload_0
    //   2323: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   2326: aload_0
    //   2327: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   2330: aload_0
    //   2331: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   2334: invokeinterface 244 14 0
    //   2339: goto -205 -> 2134
    //   2342: iload_1
    //   2343: istore_2
    //   2344: iload_1
    //   2345: istore_3
    //   2346: iload_1
    //   2347: istore 4
    //   2349: iload_1
    //   2350: istore 5
    //   2352: iload_1
    //   2353: istore 6
    //   2355: iload_1
    //   2356: istore 7
    //   2358: aload_0
    //   2359: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   2362: invokevirtual 387	java/net/HttpURLConnection:getContentLength	()I
    //   2365: istore 14
    //   2367: iload 14
    //   2369: ifle +393 -> 2762
    //   2372: iload_1
    //   2373: istore_2
    //   2374: iload_1
    //   2375: istore_3
    //   2376: iload_1
    //   2377: istore 4
    //   2379: iload_1
    //   2380: istore 5
    //   2382: iload_1
    //   2383: istore 6
    //   2385: iload_1
    //   2386: istore 7
    //   2388: aload_0
    //   2389: getfield 454	com/tencent/mm/plugin/appbrand/s/a/b:qjZ	I
    //   2392: ifle +370 -> 2762
    //   2395: iload_1
    //   2396: istore_2
    //   2397: iload_1
    //   2398: istore_3
    //   2399: iload_1
    //   2400: istore 4
    //   2402: iload_1
    //   2403: istore 5
    //   2405: iload_1
    //   2406: istore 6
    //   2408: iload_1
    //   2409: istore 7
    //   2411: iload 14
    //   2413: aload_0
    //   2414: getfield 454	com/tencent/mm/plugin/appbrand/s/a/b:qjZ	I
    //   2417: ldc_w 455
    //   2420: imul
    //   2421: if_icmplt +341 -> 2762
    //   2424: iload_1
    //   2425: istore_2
    //   2426: iload_1
    //   2427: istore_3
    //   2428: iload_1
    //   2429: istore 4
    //   2431: iload_1
    //   2432: istore 5
    //   2434: iload_1
    //   2435: istore 6
    //   2437: iload_1
    //   2438: istore 7
    //   2440: ldc 130
    //   2442: ldc_w 457
    //   2445: iconst_1
    //   2446: anewarray 4	java/lang/Object
    //   2449: dup
    //   2450: iconst_0
    //   2451: iload 14
    //   2453: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2456: aastore
    //   2457: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2460: iload_1
    //   2461: istore_2
    //   2462: iload_1
    //   2463: istore_3
    //   2464: iload_1
    //   2465: istore 4
    //   2467: iload_1
    //   2468: istore 5
    //   2470: iload_1
    //   2471: istore 6
    //   2473: iload_1
    //   2474: istore 7
    //   2476: aload_0
    //   2477: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   2480: aload_0
    //   2481: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   2484: aload_0
    //   2485: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   2488: ldc_w 459
    //   2491: invokeinterface 217 4 0
    //   2496: aload_0
    //   2497: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   2500: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2503: ifeq +208 -> 2711
    //   2506: ldc 225
    //   2508: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2511: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   2514: aload_0
    //   2515: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   2518: invokeinterface 230 1 0
    //   2523: aload_0
    //   2524: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   2527: ldc 234
    //   2529: aload_0
    //   2530: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   2533: lconst_0
    //   2534: lconst_0
    //   2535: iload_1
    //   2536: iconst_2
    //   2537: aload_0
    //   2538: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   2541: aload_0
    //   2542: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   2545: aload_0
    //   2546: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   2549: invokeinterface 244 14 0
    //   2554: ldc 116
    //   2556: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2559: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   2562: ldc2_w 123
    //   2565: ldc2_w 441
    //   2568: lconst_1
    //   2569: iconst_0
    //   2570: invokeinterface 128 8 0
    //   2575: ldc 116
    //   2577: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2580: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   2583: ldc2_w 123
    //   2586: ldc2_w 443
    //   2589: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   2592: aload_0
    //   2593: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   2596: lsub
    //   2597: iconst_0
    //   2598: invokeinterface 128 8 0
    //   2603: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   2606: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   2609: istore_1
    //   2610: iload_1
    //   2611: iconst_m1
    //   2612: if_icmpne +24 -> 2636
    //   2615: ldc 116
    //   2617: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2620: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   2623: ldc2_w 123
    //   2626: ldc2_w 449
    //   2629: lconst_1
    //   2630: iconst_0
    //   2631: invokeinterface 128 8 0
    //   2636: ldc 130
    //   2638: ldc_w 452
    //   2641: iconst_2
    //   2642: anewarray 4	java/lang/Object
    //   2645: dup
    //   2646: iconst_0
    //   2647: aload_0
    //   2648: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   2651: aastore
    //   2652: dup
    //   2653: iconst_1
    //   2654: iload_1
    //   2655: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2658: aastore
    //   2659: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2662: aload_0
    //   2663: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   2666: aload_0
    //   2667: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   2670: aload_0
    //   2671: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   2674: invokeinterface 372 2 0
    //   2679: ldc 130
    //   2681: ldc_w 374
    //   2684: iconst_2
    //   2685: anewarray 4	java/lang/Object
    //   2688: dup
    //   2689: iconst_0
    //   2690: aload_0
    //   2691: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   2694: aastore
    //   2695: dup
    //   2696: iconst_1
    //   2697: aload_0
    //   2698: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   2701: aastore
    //   2702: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2705: ldc 210
    //   2707: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2710: return
    //   2711: ldc 225
    //   2713: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2716: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   2719: aload_0
    //   2720: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   2723: invokeinterface 230 1 0
    //   2728: aload_0
    //   2729: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   2732: ldc 234
    //   2734: aload_0
    //   2735: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   2738: lconst_0
    //   2739: lconst_0
    //   2740: iload_1
    //   2741: iconst_2
    //   2742: aload_0
    //   2743: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   2746: aload_0
    //   2747: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   2750: aload_0
    //   2751: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   2754: invokeinterface 244 14 0
    //   2759: goto -205 -> 2554
    //   2762: iload_1
    //   2763: istore_2
    //   2764: iload_1
    //   2765: istore_3
    //   2766: iload_1
    //   2767: istore 4
    //   2769: iload_1
    //   2770: istore 5
    //   2772: iload_1
    //   2773: istore 7
    //   2775: ldc_w 303
    //   2778: aload_0
    //   2779: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   2782: invokevirtual 462	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   2785: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2788: ifeq +351 -> 3139
    //   2791: iload_1
    //   2792: istore_2
    //   2793: iload_1
    //   2794: istore_3
    //   2795: iload_1
    //   2796: istore 4
    //   2798: iload_1
    //   2799: istore 5
    //   2801: iload_1
    //   2802: istore 7
    //   2804: new 468	java/util/zip/GZIPInputStream
    //   2807: dup
    //   2808: aload_0
    //   2809: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   2812: invokevirtual 472	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2815: invokespecial 475	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   2818: astore 28
    //   2820: new 477	com/tencent/mm/vfs/q
    //   2823: dup
    //   2824: aload_0
    //   2825: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   2828: invokespecial 478	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   2831: astore 29
    //   2833: aload 29
    //   2835: invokevirtual 481	com/tencent/mm/vfs/q:ifE	()Z
    //   2838: ifeq +701 -> 3539
    //   2841: ldc 130
    //   2843: ldc_w 483
    //   2846: iconst_2
    //   2847: anewarray 4	java/lang/Object
    //   2850: dup
    //   2851: iconst_0
    //   2852: aload_0
    //   2853: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   2856: aastore
    //   2857: dup
    //   2858: iconst_1
    //   2859: aload_0
    //   2860: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   2863: aastore
    //   2864: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2867: aload 29
    //   2869: invokevirtual 486	com/tencent/mm/vfs/q:cFq	()Z
    //   2872: ifne +667 -> 3539
    //   2875: ldc 130
    //   2877: ldc_w 488
    //   2880: iconst_1
    //   2881: anewarray 4	java/lang/Object
    //   2884: dup
    //   2885: iconst_0
    //   2886: aload_0
    //   2887: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   2890: aastore
    //   2891: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2894: aload_0
    //   2895: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   2898: aload_0
    //   2899: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   2902: aload_0
    //   2903: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   2906: ldc_w 490
    //   2909: invokeinterface 217 4 0
    //   2914: aload_0
    //   2915: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   2918: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   2921: ifeq +468 -> 3389
    //   2924: ldc 225
    //   2926: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2929: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   2932: aload_0
    //   2933: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   2936: invokeinterface 230 1 0
    //   2941: aload_0
    //   2942: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   2945: ldc 234
    //   2947: aload_0
    //   2948: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   2951: lconst_0
    //   2952: lconst_0
    //   2953: iload_1
    //   2954: iconst_2
    //   2955: aload_0
    //   2956: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   2959: aload_0
    //   2960: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   2963: aload_0
    //   2964: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   2967: invokeinterface 244 14 0
    //   2972: ldc 116
    //   2974: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2977: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   2980: ldc2_w 123
    //   2983: ldc2_w 441
    //   2986: lconst_1
    //   2987: iconst_0
    //   2988: invokeinterface 128 8 0
    //   2993: ldc 116
    //   2995: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   2998: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   3001: ldc2_w 123
    //   3004: ldc2_w 443
    //   3007: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   3010: aload_0
    //   3011: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   3014: lsub
    //   3015: iconst_0
    //   3016: invokeinterface 128 8 0
    //   3021: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3024: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   3027: istore_1
    //   3028: iload_1
    //   3029: iconst_m1
    //   3030: if_icmpne +24 -> 3054
    //   3033: ldc 116
    //   3035: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3038: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   3041: ldc2_w 123
    //   3044: ldc2_w 449
    //   3047: lconst_1
    //   3048: iconst_0
    //   3049: invokeinterface 128 8 0
    //   3054: ldc 130
    //   3056: ldc_w 452
    //   3059: iconst_2
    //   3060: anewarray 4	java/lang/Object
    //   3063: dup
    //   3064: iconst_0
    //   3065: aload_0
    //   3066: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   3069: aastore
    //   3070: dup
    //   3071: iconst_1
    //   3072: iload_1
    //   3073: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3076: aastore
    //   3077: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3080: aload 28
    //   3082: ifnull +8 -> 3090
    //   3085: aload 28
    //   3087: invokevirtual 364	java/io/InputStream:close	()V
    //   3090: aload_0
    //   3091: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   3094: aload_0
    //   3095: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   3098: aload_0
    //   3099: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   3102: invokeinterface 372 2 0
    //   3107: ldc 130
    //   3109: ldc_w 374
    //   3112: iconst_2
    //   3113: anewarray 4	java/lang/Object
    //   3116: dup
    //   3117: iconst_0
    //   3118: aload_0
    //   3119: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   3122: aastore
    //   3123: dup
    //   3124: iconst_1
    //   3125: aload_0
    //   3126: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3129: aastore
    //   3130: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3133: ldc 210
    //   3135: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3138: return
    //   3139: iload_1
    //   3140: istore_2
    //   3141: iload_1
    //   3142: istore_3
    //   3143: iload_1
    //   3144: istore 4
    //   3146: iload_1
    //   3147: istore 5
    //   3149: iload_1
    //   3150: istore 7
    //   3152: ldc_w 492
    //   3155: aload_0
    //   3156: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   3159: invokevirtual 462	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3162: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3165: ifeq +174 -> 3339
    //   3168: iload_1
    //   3169: istore_2
    //   3170: iload_1
    //   3171: istore_3
    //   3172: iload_1
    //   3173: istore 4
    //   3175: iload_1
    //   3176: istore 5
    //   3178: iload_1
    //   3179: istore 7
    //   3181: new 494	java/util/zip/InflaterInputStream
    //   3184: dup
    //   3185: aload_0
    //   3186: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   3189: invokevirtual 472	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3192: new 496	java/util/zip/Inflater
    //   3195: dup
    //   3196: iconst_1
    //   3197: invokespecial 498	java/util/zip/Inflater:<init>	(Z)V
    //   3200: invokespecial 501	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3203: astore 28
    //   3205: goto -385 -> 2820
    //   3208: astore 27
    //   3210: iload_1
    //   3211: istore_2
    //   3212: iload_1
    //   3213: istore_3
    //   3214: iload_1
    //   3215: istore 4
    //   3217: iload_1
    //   3218: istore 5
    //   3220: iload_1
    //   3221: istore 6
    //   3223: iload_1
    //   3224: istore 7
    //   3226: ldc 130
    //   3228: aload 27
    //   3230: ldc_w 503
    //   3233: iconst_0
    //   3234: anewarray 4	java/lang/Object
    //   3237: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3240: iload_1
    //   3241: istore_2
    //   3242: iload_1
    //   3243: istore_3
    //   3244: iload_1
    //   3245: istore 4
    //   3247: iload_1
    //   3248: istore 5
    //   3250: iload_1
    //   3251: istore 7
    //   3253: ldc_w 303
    //   3256: aload_0
    //   3257: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   3260: invokevirtual 462	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3263: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3266: ifeq +98 -> 3364
    //   3269: iload_1
    //   3270: istore_2
    //   3271: iload_1
    //   3272: istore_3
    //   3273: iload_1
    //   3274: istore 4
    //   3276: iload_1
    //   3277: istore 5
    //   3279: iload_1
    //   3280: istore 7
    //   3282: new 468	java/util/zip/GZIPInputStream
    //   3285: dup
    //   3286: aload_0
    //   3287: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   3290: invokevirtual 506	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   3293: invokespecial 475	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3296: astore 28
    //   3298: goto -478 -> 2820
    //   3301: astore 28
    //   3303: iload_1
    //   3304: istore_2
    //   3305: iload_1
    //   3306: istore_3
    //   3307: iload_1
    //   3308: istore 4
    //   3310: iload_1
    //   3311: istore 5
    //   3313: iload_1
    //   3314: istore 6
    //   3316: iload_1
    //   3317: istore 7
    //   3319: ldc 130
    //   3321: aload 27
    //   3323: ldc_w 508
    //   3326: iconst_0
    //   3327: anewarray 4	java/lang/Object
    //   3330: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3333: aconst_null
    //   3334: astore 28
    //   3336: goto -516 -> 2820
    //   3339: iload_1
    //   3340: istore_2
    //   3341: iload_1
    //   3342: istore_3
    //   3343: iload_1
    //   3344: istore 4
    //   3346: iload_1
    //   3347: istore 5
    //   3349: iload_1
    //   3350: istore 7
    //   3352: aload_0
    //   3353: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   3356: invokevirtual 472	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3359: astore 28
    //   3361: goto -541 -> 2820
    //   3364: iload_1
    //   3365: istore_2
    //   3366: iload_1
    //   3367: istore_3
    //   3368: iload_1
    //   3369: istore 4
    //   3371: iload_1
    //   3372: istore 5
    //   3374: iload_1
    //   3375: istore 7
    //   3377: aload_0
    //   3378: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   3381: invokevirtual 506	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   3384: astore 28
    //   3386: goto -566 -> 2820
    //   3389: ldc 225
    //   3391: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3394: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   3397: aload_0
    //   3398: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   3401: invokeinterface 230 1 0
    //   3406: aload_0
    //   3407: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   3410: ldc 234
    //   3412: aload_0
    //   3413: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   3416: lconst_0
    //   3417: lconst_0
    //   3418: iload_1
    //   3419: iconst_2
    //   3420: aload_0
    //   3421: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   3424: aload_0
    //   3425: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   3428: aload_0
    //   3429: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   3432: invokeinterface 244 14 0
    //   3437: goto -465 -> 2972
    //   3440: astore 27
    //   3442: ldc 130
    //   3444: aload 27
    //   3446: ldc_w 510
    //   3449: iconst_2
    //   3450: anewarray 4	java/lang/Object
    //   3453: dup
    //   3454: iconst_0
    //   3455: aload_0
    //   3456: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3459: aastore
    //   3460: dup
    //   3461: iconst_1
    //   3462: aload_0
    //   3463: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3466: aastore
    //   3467: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3470: goto -380 -> 3090
    //   3473: astore 27
    //   3475: ldc 130
    //   3477: aload 27
    //   3479: ldc_w 512
    //   3482: iconst_2
    //   3483: anewarray 4	java/lang/Object
    //   3486: dup
    //   3487: iconst_0
    //   3488: aload_0
    //   3489: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3492: aastore
    //   3493: dup
    //   3494: iconst_1
    //   3495: aload_0
    //   3496: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3499: aastore
    //   3500: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3503: goto -413 -> 3090
    //   3506: astore 27
    //   3508: ldc 130
    //   3510: aload 27
    //   3512: ldc_w 514
    //   3515: iconst_2
    //   3516: anewarray 4	java/lang/Object
    //   3519: dup
    //   3520: iconst_0
    //   3521: aload_0
    //   3522: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3525: aastore
    //   3526: dup
    //   3527: iconst_1
    //   3528: aload_0
    //   3529: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3532: aastore
    //   3533: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3536: goto -446 -> 3090
    //   3539: aload 29
    //   3541: invokevirtual 518	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   3544: invokevirtual 481	com/tencent/mm/vfs/q:ifE	()Z
    //   3547: ifne +454 -> 4001
    //   3550: ldc 130
    //   3552: ldc_w 520
    //   3555: iconst_2
    //   3556: anewarray 4	java/lang/Object
    //   3559: dup
    //   3560: iconst_0
    //   3561: aload_0
    //   3562: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   3565: aastore
    //   3566: dup
    //   3567: iconst_1
    //   3568: aload_0
    //   3569: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3572: aastore
    //   3573: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3576: aload 29
    //   3578: invokevirtual 518	com/tencent/mm/vfs/q:ifB	()Lcom/tencent/mm/vfs/q;
    //   3581: invokevirtual 523	com/tencent/mm/vfs/q:ifL	()Z
    //   3584: ifne +417 -> 4001
    //   3587: ldc 130
    //   3589: ldc_w 525
    //   3592: iconst_1
    //   3593: anewarray 4	java/lang/Object
    //   3596: dup
    //   3597: iconst_0
    //   3598: aload_0
    //   3599: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3602: aastore
    //   3603: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3606: aload_0
    //   3607: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   3610: aload_0
    //   3611: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3614: aload_0
    //   3615: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3618: ldc_w 527
    //   3621: invokeinterface 217 4 0
    //   3626: aload_0
    //   3627: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   3630: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   3633: ifeq +218 -> 3851
    //   3636: ldc 225
    //   3638: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3641: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   3644: aload_0
    //   3645: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   3648: invokeinterface 230 1 0
    //   3653: aload_0
    //   3654: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   3657: ldc 234
    //   3659: aload_0
    //   3660: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   3663: lconst_0
    //   3664: lconst_0
    //   3665: iload_1
    //   3666: iconst_2
    //   3667: aload_0
    //   3668: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   3671: aload_0
    //   3672: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3675: aload_0
    //   3676: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   3679: invokeinterface 244 14 0
    //   3684: ldc 116
    //   3686: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3689: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   3692: ldc2_w 123
    //   3695: ldc2_w 441
    //   3698: lconst_1
    //   3699: iconst_0
    //   3700: invokeinterface 128 8 0
    //   3705: ldc 116
    //   3707: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3710: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   3713: ldc2_w 123
    //   3716: ldc2_w 443
    //   3719: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   3722: aload_0
    //   3723: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   3726: lsub
    //   3727: iconst_0
    //   3728: invokeinterface 128 8 0
    //   3733: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   3736: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   3739: istore_1
    //   3740: iload_1
    //   3741: iconst_m1
    //   3742: if_icmpne +24 -> 3766
    //   3745: ldc 116
    //   3747: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3750: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   3753: ldc2_w 123
    //   3756: ldc2_w 449
    //   3759: lconst_1
    //   3760: iconst_0
    //   3761: invokeinterface 128 8 0
    //   3766: ldc 130
    //   3768: ldc_w 452
    //   3771: iconst_2
    //   3772: anewarray 4	java/lang/Object
    //   3775: dup
    //   3776: iconst_0
    //   3777: aload_0
    //   3778: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   3781: aastore
    //   3782: dup
    //   3783: iconst_1
    //   3784: iload_1
    //   3785: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3788: aastore
    //   3789: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3792: aload 28
    //   3794: ifnull +8 -> 3802
    //   3797: aload 28
    //   3799: invokevirtual 364	java/io/InputStream:close	()V
    //   3802: aload_0
    //   3803: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   3806: aload_0
    //   3807: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   3810: aload_0
    //   3811: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   3814: invokeinterface 372 2 0
    //   3819: ldc 130
    //   3821: ldc_w 374
    //   3824: iconst_2
    //   3825: anewarray 4	java/lang/Object
    //   3828: dup
    //   3829: iconst_0
    //   3830: aload_0
    //   3831: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   3834: aastore
    //   3835: dup
    //   3836: iconst_1
    //   3837: aload_0
    //   3838: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3841: aastore
    //   3842: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3845: ldc 210
    //   3847: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3850: return
    //   3851: ldc 225
    //   3853: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   3856: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   3859: aload_0
    //   3860: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   3863: invokeinterface 230 1 0
    //   3868: aload_0
    //   3869: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   3872: ldc 234
    //   3874: aload_0
    //   3875: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   3878: lconst_0
    //   3879: lconst_0
    //   3880: iload_1
    //   3881: iconst_2
    //   3882: aload_0
    //   3883: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   3886: aload_0
    //   3887: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   3890: aload_0
    //   3891: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   3894: invokeinterface 244 14 0
    //   3899: goto -215 -> 3684
    //   3902: astore 27
    //   3904: ldc 130
    //   3906: aload 27
    //   3908: ldc_w 510
    //   3911: iconst_2
    //   3912: anewarray 4	java/lang/Object
    //   3915: dup
    //   3916: iconst_0
    //   3917: aload_0
    //   3918: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3921: aastore
    //   3922: dup
    //   3923: iconst_1
    //   3924: aload_0
    //   3925: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3928: aastore
    //   3929: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3932: goto -130 -> 3802
    //   3935: astore 27
    //   3937: ldc 130
    //   3939: aload 27
    //   3941: ldc_w 512
    //   3944: iconst_2
    //   3945: anewarray 4	java/lang/Object
    //   3948: dup
    //   3949: iconst_0
    //   3950: aload_0
    //   3951: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3954: aastore
    //   3955: dup
    //   3956: iconst_1
    //   3957: aload_0
    //   3958: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3961: aastore
    //   3962: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3965: goto -163 -> 3802
    //   3968: astore 27
    //   3970: ldc 130
    //   3972: aload 27
    //   3974: ldc_w 514
    //   3977: iconst_2
    //   3978: anewarray 4	java/lang/Object
    //   3981: dup
    //   3982: iconst_0
    //   3983: aload_0
    //   3984: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   3987: aastore
    //   3988: dup
    //   3989: iconst_1
    //   3990: aload_0
    //   3991: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   3994: aastore
    //   3995: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3998: goto -196 -> 3802
    //   4001: aload 28
    //   4003: ifnull +6275 -> 10278
    //   4006: aload 29
    //   4008: invokestatic 533	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   4011: astore 27
    //   4013: iload 14
    //   4015: i2l
    //   4016: lstore 21
    //   4018: lload 21
    //   4020: invokestatic 537	com/tencent/mm/plugin/appbrand/s/j:HB	(J)I
    //   4023: newarray byte
    //   4025: astore 30
    //   4027: iconst_m1
    //   4028: istore_2
    //   4029: lconst_0
    //   4030: lstore 19
    //   4032: aload 28
    //   4034: aload 30
    //   4036: invokevirtual 541	java/io/InputStream:read	([B)I
    //   4039: istore_3
    //   4040: iload_3
    //   4041: iconst_m1
    //   4042: if_icmpeq +1080 -> 5122
    //   4045: aload_0
    //   4046: getfield 69	com/tencent/mm/plugin/appbrand/s/a/b:isRunning	Z
    //   4049: ifeq +1073 -> 5122
    //   4052: aload_0
    //   4053: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   4056: invokestatic 544	com/tencent/mm/plugin/appbrand/s/j:L	(Lcom/tencent/mm/plugin/appbrand/jsapi/e;)Z
    //   4059: ifeq +443 -> 4502
    //   4062: aload_0
    //   4063: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   4066: aload_0
    //   4067: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   4070: aload_0
    //   4071: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4074: ldc_w 546
    //   4077: invokeinterface 217 4 0
    //   4082: aload_0
    //   4083: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   4086: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4089: ifeq +229 -> 4318
    //   4092: ldc 225
    //   4094: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4097: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   4100: aload_0
    //   4101: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   4104: invokeinterface 230 1 0
    //   4109: aload_0
    //   4110: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   4113: ldc 234
    //   4115: aload_0
    //   4116: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   4119: lconst_0
    //   4120: lload 19
    //   4122: iload_1
    //   4123: iconst_2
    //   4124: aload_0
    //   4125: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   4128: aload_0
    //   4129: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   4132: aload_0
    //   4133: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   4136: invokeinterface 244 14 0
    //   4141: ldc 116
    //   4143: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4146: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   4149: ldc2_w 123
    //   4152: ldc2_w 441
    //   4155: lconst_1
    //   4156: iconst_0
    //   4157: invokeinterface 128 8 0
    //   4162: ldc 116
    //   4164: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4167: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   4170: ldc2_w 123
    //   4173: ldc2_w 443
    //   4176: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   4179: aload_0
    //   4180: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   4183: lsub
    //   4184: iconst_0
    //   4185: invokeinterface 128 8 0
    //   4190: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4193: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   4196: istore_1
    //   4197: iload_1
    //   4198: iconst_m1
    //   4199: if_icmpne +24 -> 4223
    //   4202: ldc 116
    //   4204: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4207: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   4210: ldc2_w 123
    //   4213: ldc2_w 449
    //   4216: lconst_1
    //   4217: iconst_0
    //   4218: invokeinterface 128 8 0
    //   4223: ldc 130
    //   4225: ldc_w 452
    //   4228: iconst_2
    //   4229: anewarray 4	java/lang/Object
    //   4232: dup
    //   4233: iconst_0
    //   4234: aload_0
    //   4235: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   4238: aastore
    //   4239: dup
    //   4240: iconst_1
    //   4241: iload_1
    //   4242: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4245: aastore
    //   4246: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4249: aload 27
    //   4251: ifnull +8 -> 4259
    //   4254: aload 27
    //   4256: invokevirtual 361	java/io/OutputStream:close	()V
    //   4259: aload 28
    //   4261: ifnull +8 -> 4269
    //   4264: aload 28
    //   4266: invokevirtual 364	java/io/InputStream:close	()V
    //   4269: aload_0
    //   4270: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   4273: aload_0
    //   4274: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   4277: aload_0
    //   4278: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   4281: invokeinterface 372 2 0
    //   4286: ldc 130
    //   4288: ldc_w 374
    //   4291: iconst_2
    //   4292: anewarray 4	java/lang/Object
    //   4295: dup
    //   4296: iconst_0
    //   4297: aload_0
    //   4298: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   4301: aastore
    //   4302: dup
    //   4303: iconst_1
    //   4304: aload_0
    //   4305: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4308: aastore
    //   4309: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4312: ldc 210
    //   4314: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4317: return
    //   4318: ldc 225
    //   4320: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4323: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   4326: aload_0
    //   4327: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   4330: invokeinterface 230 1 0
    //   4335: aload_0
    //   4336: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   4339: ldc 234
    //   4341: aload_0
    //   4342: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   4345: lconst_0
    //   4346: lload 19
    //   4348: iload_1
    //   4349: iconst_2
    //   4350: aload_0
    //   4351: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   4354: aload_0
    //   4355: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   4358: aload_0
    //   4359: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   4362: invokeinterface 244 14 0
    //   4367: goto -226 -> 4141
    //   4370: astore 27
    //   4372: ldc 130
    //   4374: aload 27
    //   4376: ldc_w 510
    //   4379: iconst_2
    //   4380: anewarray 4	java/lang/Object
    //   4383: dup
    //   4384: iconst_0
    //   4385: aload_0
    //   4386: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4389: aastore
    //   4390: dup
    //   4391: iconst_1
    //   4392: aload_0
    //   4393: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   4396: aastore
    //   4397: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4400: goto -141 -> 4259
    //   4403: astore 27
    //   4405: ldc 130
    //   4407: aload 27
    //   4409: ldc_w 510
    //   4412: iconst_2
    //   4413: anewarray 4	java/lang/Object
    //   4416: dup
    //   4417: iconst_0
    //   4418: aload_0
    //   4419: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4422: aastore
    //   4423: dup
    //   4424: iconst_1
    //   4425: aload_0
    //   4426: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   4429: aastore
    //   4430: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4433: goto -164 -> 4269
    //   4436: astore 27
    //   4438: ldc 130
    //   4440: aload 27
    //   4442: ldc_w 512
    //   4445: iconst_2
    //   4446: anewarray 4	java/lang/Object
    //   4449: dup
    //   4450: iconst_0
    //   4451: aload_0
    //   4452: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4455: aastore
    //   4456: dup
    //   4457: iconst_1
    //   4458: aload_0
    //   4459: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   4462: aastore
    //   4463: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4466: goto -197 -> 4269
    //   4469: astore 27
    //   4471: ldc 130
    //   4473: aload 27
    //   4475: ldc_w 514
    //   4478: iconst_2
    //   4479: anewarray 4	java/lang/Object
    //   4482: dup
    //   4483: iconst_0
    //   4484: aload_0
    //   4485: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4488: aastore
    //   4489: dup
    //   4490: iconst_1
    //   4491: aload_0
    //   4492: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   4495: aastore
    //   4496: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4499: goto -230 -> 4269
    //   4502: aload 27
    //   4504: aload 30
    //   4506: iconst_0
    //   4507: iload_3
    //   4508: invokevirtual 550	java/io/OutputStream:write	([BII)V
    //   4511: lload 19
    //   4513: iload_3
    //   4514: i2l
    //   4515: ladd
    //   4516: lstore 19
    //   4518: iload_2
    //   4519: istore_3
    //   4520: lload 25
    //   4522: lconst_0
    //   4523: lcmp
    //   4524: ifle +90 -> 4614
    //   4527: iload_2
    //   4528: istore_3
    //   4529: aload_0
    //   4530: getfield 69	com/tencent/mm/plugin/appbrand/s/a/b:isRunning	Z
    //   4533: ifeq +81 -> 4614
    //   4536: ldc2_w 551
    //   4539: lload 19
    //   4541: lmul
    //   4542: lload 25
    //   4544: ldiv
    //   4545: l2i
    //   4546: istore 4
    //   4548: iload_2
    //   4549: istore_3
    //   4550: iload_2
    //   4551: iload 4
    //   4553: if_icmpeq +25 -> 4578
    //   4556: aload_0
    //   4557: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   4560: aload_0
    //   4561: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4564: iload 4
    //   4566: lload 19
    //   4568: lload 25
    //   4570: invokeinterface 555 7 0
    //   4575: iload 4
    //   4577: istore_3
    //   4578: ldc 130
    //   4580: ldc_w 557
    //   4583: iconst_3
    //   4584: anewarray 4	java/lang/Object
    //   4587: dup
    //   4588: iconst_0
    //   4589: lload 19
    //   4591: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4594: aastore
    //   4595: dup
    //   4596: iconst_1
    //   4597: lload 25
    //   4599: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4602: aastore
    //   4603: dup
    //   4604: iconst_2
    //   4605: iload 4
    //   4607: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4610: aastore
    //   4611: invokestatic 560	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4614: lload 19
    //   4616: lconst_0
    //   4617: lcmp
    //   4618: ifle +5655 -> 10273
    //   4621: aload_0
    //   4622: getfield 454	com/tencent/mm/plugin/appbrand/s/a/b:qjZ	I
    //   4625: ifle +5648 -> 10273
    //   4628: lload 19
    //   4630: aload_0
    //   4631: getfield 454	com/tencent/mm/plugin/appbrand/s/a/b:qjZ	I
    //   4634: i2l
    //   4635: ldc2_w 561
    //   4638: lmul
    //   4639: lcmp
    //   4640: iflt +5633 -> 10273
    //   4643: ldc 130
    //   4645: ldc_w 564
    //   4648: iconst_1
    //   4649: anewarray 4	java/lang/Object
    //   4652: dup
    //   4653: iconst_0
    //   4654: lload 19
    //   4656: invokestatic 152	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4659: aastore
    //   4660: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4663: aload_0
    //   4664: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   4667: aload_0
    //   4668: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   4671: aload_0
    //   4672: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4675: ldc_w 459
    //   4678: invokeinterface 217 4 0
    //   4683: aload 27
    //   4685: invokestatic 568	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   4688: aload 28
    //   4690: invokestatic 568	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   4693: aload 29
    //   4695: invokevirtual 571	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   4698: invokestatic 574	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   4701: pop
    //   4702: aload_0
    //   4703: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   4706: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   4709: ifeq +229 -> 4938
    //   4712: ldc 225
    //   4714: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4717: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   4720: aload_0
    //   4721: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   4724: invokeinterface 230 1 0
    //   4729: aload_0
    //   4730: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   4733: ldc 234
    //   4735: aload_0
    //   4736: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   4739: lconst_0
    //   4740: lload 19
    //   4742: iload_1
    //   4743: iconst_2
    //   4744: aload_0
    //   4745: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   4748: aload_0
    //   4749: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   4752: aload_0
    //   4753: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   4756: invokeinterface 244 14 0
    //   4761: ldc 116
    //   4763: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4766: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   4769: ldc2_w 123
    //   4772: ldc2_w 441
    //   4775: lconst_1
    //   4776: iconst_0
    //   4777: invokeinterface 128 8 0
    //   4782: ldc 116
    //   4784: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4787: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   4790: ldc2_w 123
    //   4793: ldc2_w 443
    //   4796: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   4799: aload_0
    //   4800: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   4803: lsub
    //   4804: iconst_0
    //   4805: invokeinterface 128 8 0
    //   4810: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   4813: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   4816: istore_1
    //   4817: iload_1
    //   4818: iconst_m1
    //   4819: if_icmpne +24 -> 4843
    //   4822: ldc 116
    //   4824: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4827: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   4830: ldc2_w 123
    //   4833: ldc2_w 449
    //   4836: lconst_1
    //   4837: iconst_0
    //   4838: invokeinterface 128 8 0
    //   4843: ldc 130
    //   4845: ldc_w 452
    //   4848: iconst_2
    //   4849: anewarray 4	java/lang/Object
    //   4852: dup
    //   4853: iconst_0
    //   4854: aload_0
    //   4855: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   4858: aastore
    //   4859: dup
    //   4860: iconst_1
    //   4861: iload_1
    //   4862: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4865: aastore
    //   4866: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4869: aload 27
    //   4871: ifnull +8 -> 4879
    //   4874: aload 27
    //   4876: invokevirtual 361	java/io/OutputStream:close	()V
    //   4879: aload 28
    //   4881: ifnull +8 -> 4889
    //   4884: aload 28
    //   4886: invokevirtual 364	java/io/InputStream:close	()V
    //   4889: aload_0
    //   4890: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   4893: aload_0
    //   4894: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   4897: aload_0
    //   4898: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   4901: invokeinterface 372 2 0
    //   4906: ldc 130
    //   4908: ldc_w 374
    //   4911: iconst_2
    //   4912: anewarray 4	java/lang/Object
    //   4915: dup
    //   4916: iconst_0
    //   4917: aload_0
    //   4918: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   4921: aastore
    //   4922: dup
    //   4923: iconst_1
    //   4924: aload_0
    //   4925: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   4928: aastore
    //   4929: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   4932: ldc 210
    //   4934: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   4937: return
    //   4938: ldc 225
    //   4940: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   4943: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   4946: aload_0
    //   4947: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   4950: invokeinterface 230 1 0
    //   4955: aload_0
    //   4956: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   4959: ldc 234
    //   4961: aload_0
    //   4962: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   4965: lconst_0
    //   4966: lload 19
    //   4968: iload_1
    //   4969: iconst_2
    //   4970: aload_0
    //   4971: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   4974: aload_0
    //   4975: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   4978: aload_0
    //   4979: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   4982: invokeinterface 244 14 0
    //   4987: goto -226 -> 4761
    //   4990: astore 27
    //   4992: ldc 130
    //   4994: aload 27
    //   4996: ldc_w 510
    //   4999: iconst_2
    //   5000: anewarray 4	java/lang/Object
    //   5003: dup
    //   5004: iconst_0
    //   5005: aload_0
    //   5006: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5009: aastore
    //   5010: dup
    //   5011: iconst_1
    //   5012: aload_0
    //   5013: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5016: aastore
    //   5017: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5020: goto -141 -> 4879
    //   5023: astore 27
    //   5025: ldc 130
    //   5027: aload 27
    //   5029: ldc_w 510
    //   5032: iconst_2
    //   5033: anewarray 4	java/lang/Object
    //   5036: dup
    //   5037: iconst_0
    //   5038: aload_0
    //   5039: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5042: aastore
    //   5043: dup
    //   5044: iconst_1
    //   5045: aload_0
    //   5046: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5049: aastore
    //   5050: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5053: goto -164 -> 4889
    //   5056: astore 27
    //   5058: ldc 130
    //   5060: aload 27
    //   5062: ldc_w 512
    //   5065: iconst_2
    //   5066: anewarray 4	java/lang/Object
    //   5069: dup
    //   5070: iconst_0
    //   5071: aload_0
    //   5072: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5075: aastore
    //   5076: dup
    //   5077: iconst_1
    //   5078: aload_0
    //   5079: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5082: aastore
    //   5083: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5086: goto -197 -> 4889
    //   5089: astore 27
    //   5091: ldc 130
    //   5093: aload 27
    //   5095: ldc_w 514
    //   5098: iconst_2
    //   5099: anewarray 4	java/lang/Object
    //   5102: dup
    //   5103: iconst_0
    //   5104: aload_0
    //   5105: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5108: aastore
    //   5109: dup
    //   5110: iconst_1
    //   5111: aload_0
    //   5112: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5115: aastore
    //   5116: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5119: goto -230 -> 4889
    //   5122: aload 27
    //   5124: invokevirtual 577	java/io/OutputStream:flush	()V
    //   5127: iload_1
    //   5128: istore_3
    //   5129: lload 19
    //   5131: lstore 21
    //   5133: aload 27
    //   5135: astore 31
    //   5137: iload 13
    //   5139: istore_2
    //   5140: aload 28
    //   5142: astore 30
    //   5144: aload_0
    //   5145: getfield 69	com/tencent/mm/plugin/appbrand/s/a/b:isRunning	Z
    //   5148: ifeq +376 -> 5524
    //   5151: iload_1
    //   5152: istore_3
    //   5153: lload 19
    //   5155: lstore 21
    //   5157: aload 27
    //   5159: astore 31
    //   5161: iload 13
    //   5163: istore_2
    //   5164: aload 28
    //   5166: astore 30
    //   5168: aload_0
    //   5169: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   5172: aload_0
    //   5173: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5176: aload_0
    //   5177: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   5180: aload_0
    //   5181: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5184: iload_1
    //   5185: lload 19
    //   5187: aconst_null
    //   5188: invokeinterface 435 8 0
    //   5193: iload_1
    //   5194: istore_3
    //   5195: lload 19
    //   5197: lstore 21
    //   5199: aload 27
    //   5201: astore 31
    //   5203: iload 13
    //   5205: istore_2
    //   5206: aload 28
    //   5208: astore 30
    //   5210: lload 25
    //   5212: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   5215: aload_0
    //   5216: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   5219: lsub
    //   5220: invokestatic 579	com/tencent/mm/plugin/appbrand/s/a/b:J	(JJ)V
    //   5223: iconst_1
    //   5224: istore_2
    //   5225: ldc 130
    //   5227: ldc_w 581
    //   5230: iconst_3
    //   5231: anewarray 4	java/lang/Object
    //   5234: dup
    //   5235: iconst_0
    //   5236: aload_0
    //   5237: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   5240: aastore
    //   5241: dup
    //   5242: iconst_1
    //   5243: aload_0
    //   5244: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5247: aastore
    //   5248: dup
    //   5249: iconst_2
    //   5250: aload_0
    //   5251: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5254: aastore
    //   5255: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5258: aload_0
    //   5259: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   5262: invokevirtual 472	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   5265: invokevirtual 364	java/io/InputStream:close	()V
    //   5268: aload_0
    //   5269: getfield 265	com/tencent/mm/plugin/appbrand/s/a/b:conn	Ljava/net/HttpURLConnection;
    //   5272: invokevirtual 584	java/net/HttpURLConnection:disconnect	()V
    //   5275: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   5278: lload 23
    //   5280: lsub
    //   5281: lstore 21
    //   5283: ldc_w 586
    //   5286: ldc_w 588
    //   5289: lload 21
    //   5291: invokestatic 591	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   5294: invokevirtual 594	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   5297: invokestatic 596	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   5300: ldc 116
    //   5302: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5305: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   5308: ldc2_w 597
    //   5311: ldc2_w 599
    //   5314: lload 21
    //   5316: iconst_0
    //   5317: invokeinterface 128 8 0
    //   5322: ldc 116
    //   5324: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5327: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   5330: ldc2_w 597
    //   5333: ldc2_w 551
    //   5336: lconst_1
    //   5337: iconst_0
    //   5338: invokeinterface 128 8 0
    //   5343: iload_2
    //   5344: ifeq +299 -> 5643
    //   5347: aload_0
    //   5348: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   5351: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5354: ifeq +237 -> 5591
    //   5357: ldc 225
    //   5359: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5362: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   5365: aload_0
    //   5366: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   5369: invokeinterface 230 1 0
    //   5374: aload_0
    //   5375: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   5378: ldc 234
    //   5380: aload_0
    //   5381: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   5384: lconst_0
    //   5385: lload 19
    //   5387: iload_1
    //   5388: iconst_1
    //   5389: aload_0
    //   5390: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   5393: aload_0
    //   5394: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5397: aload_0
    //   5398: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   5401: invokeinterface 244 14 0
    //   5406: ldc 116
    //   5408: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5411: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   5414: ldc2_w 123
    //   5417: ldc2_w 353
    //   5420: lconst_1
    //   5421: iconst_0
    //   5422: invokeinterface 128 8 0
    //   5427: ldc 116
    //   5429: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5432: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   5435: ldc2_w 123
    //   5438: ldc2_w 355
    //   5441: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   5444: aload_0
    //   5445: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   5448: lsub
    //   5449: iconst_0
    //   5450: invokeinterface 128 8 0
    //   5455: aload 27
    //   5457: ifnull +8 -> 5465
    //   5460: aload 27
    //   5462: invokevirtual 361	java/io/OutputStream:close	()V
    //   5465: aload 28
    //   5467: ifnull +8 -> 5475
    //   5470: aload 28
    //   5472: invokevirtual 364	java/io/InputStream:close	()V
    //   5475: aload_0
    //   5476: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   5479: aload_0
    //   5480: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   5483: aload_0
    //   5484: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   5487: invokeinterface 372 2 0
    //   5492: ldc 130
    //   5494: ldc_w 374
    //   5497: iconst_2
    //   5498: anewarray 4	java/lang/Object
    //   5501: dup
    //   5502: iconst_0
    //   5503: aload_0
    //   5504: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   5507: aastore
    //   5508: dup
    //   5509: iconst_1
    //   5510: aload_0
    //   5511: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5514: aastore
    //   5515: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5518: ldc 210
    //   5520: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   5523: return
    //   5524: iload_1
    //   5525: istore_3
    //   5526: lload 19
    //   5528: lstore 21
    //   5530: aload 27
    //   5532: astore 31
    //   5534: iload 13
    //   5536: istore_2
    //   5537: aload 28
    //   5539: astore 30
    //   5541: aload_0
    //   5542: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   5545: aload_0
    //   5546: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5549: aload_0
    //   5550: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5553: ldc 212
    //   5555: invokeinterface 217 4 0
    //   5560: iconst_0
    //   5561: istore_2
    //   5562: goto -337 -> 5225
    //   5565: astore 29
    //   5567: ldc 130
    //   5569: aload 29
    //   5571: invokevirtual 603	java/io/IOException:getMessage	()Ljava/lang/String;
    //   5574: invokestatic 605	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   5577: goto -309 -> 5268
    //   5580: astore 29
    //   5582: iload_2
    //   5583: istore_3
    //   5584: iload_1
    //   5585: istore_2
    //   5586: iload_3
    //   5587: istore_1
    //   5588: goto -4638 -> 950
    //   5591: ldc 225
    //   5593: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5596: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   5599: aload_0
    //   5600: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   5603: invokeinterface 230 1 0
    //   5608: aload_0
    //   5609: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   5612: ldc 234
    //   5614: aload_0
    //   5615: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   5618: lconst_0
    //   5619: lload 19
    //   5621: iload_1
    //   5622: iconst_1
    //   5623: aload_0
    //   5624: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   5627: aload_0
    //   5628: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   5631: aload_0
    //   5632: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   5635: invokeinterface 244 14 0
    //   5640: goto -234 -> 5406
    //   5643: aload_0
    //   5644: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   5647: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   5650: ifeq +163 -> 5813
    //   5653: ldc 225
    //   5655: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5658: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   5661: aload_0
    //   5662: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   5665: invokeinterface 230 1 0
    //   5670: aload_0
    //   5671: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   5674: ldc 234
    //   5676: aload_0
    //   5677: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   5680: lconst_0
    //   5681: lload 19
    //   5683: iload_1
    //   5684: iconst_2
    //   5685: aload_0
    //   5686: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   5689: aload_0
    //   5690: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5693: aload_0
    //   5694: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   5697: invokeinterface 244 14 0
    //   5702: ldc 116
    //   5704: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5707: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   5710: ldc2_w 123
    //   5713: ldc2_w 441
    //   5716: lconst_1
    //   5717: iconst_0
    //   5718: invokeinterface 128 8 0
    //   5723: ldc 116
    //   5725: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5728: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   5731: ldc2_w 123
    //   5734: ldc2_w 443
    //   5737: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   5740: aload_0
    //   5741: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   5744: lsub
    //   5745: iconst_0
    //   5746: invokeinterface 128 8 0
    //   5751: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   5754: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   5757: istore_1
    //   5758: iload_1
    //   5759: iconst_m1
    //   5760: if_icmpne +24 -> 5784
    //   5763: ldc 116
    //   5765: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5768: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   5771: ldc2_w 123
    //   5774: ldc2_w 449
    //   5777: lconst_1
    //   5778: iconst_0
    //   5779: invokeinterface 128 8 0
    //   5784: ldc 130
    //   5786: ldc_w 452
    //   5789: iconst_2
    //   5790: anewarray 4	java/lang/Object
    //   5793: dup
    //   5794: iconst_0
    //   5795: aload_0
    //   5796: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   5799: aastore
    //   5800: dup
    //   5801: iconst_1
    //   5802: iload_1
    //   5803: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5806: aastore
    //   5807: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5810: goto -355 -> 5455
    //   5813: ldc 225
    //   5815: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   5818: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   5821: aload_0
    //   5822: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   5825: invokeinterface 230 1 0
    //   5830: aload_0
    //   5831: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   5834: ldc 234
    //   5836: aload_0
    //   5837: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   5840: lconst_0
    //   5841: lload 19
    //   5843: iload_1
    //   5844: iconst_2
    //   5845: aload_0
    //   5846: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   5849: aload_0
    //   5850: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   5853: aload_0
    //   5854: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   5857: invokeinterface 244 14 0
    //   5862: goto -160 -> 5702
    //   5865: astore 27
    //   5867: ldc 130
    //   5869: aload 27
    //   5871: ldc_w 510
    //   5874: iconst_2
    //   5875: anewarray 4	java/lang/Object
    //   5878: dup
    //   5879: iconst_0
    //   5880: aload_0
    //   5881: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5884: aastore
    //   5885: dup
    //   5886: iconst_1
    //   5887: aload_0
    //   5888: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5891: aastore
    //   5892: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5895: goto -430 -> 5465
    //   5898: astore 27
    //   5900: ldc 130
    //   5902: aload 27
    //   5904: ldc_w 510
    //   5907: iconst_2
    //   5908: anewarray 4	java/lang/Object
    //   5911: dup
    //   5912: iconst_0
    //   5913: aload_0
    //   5914: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5917: aastore
    //   5918: dup
    //   5919: iconst_1
    //   5920: aload_0
    //   5921: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5924: aastore
    //   5925: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5928: goto -453 -> 5475
    //   5931: astore 27
    //   5933: ldc 130
    //   5935: aload 27
    //   5937: ldc_w 512
    //   5940: iconst_2
    //   5941: anewarray 4	java/lang/Object
    //   5944: dup
    //   5945: iconst_0
    //   5946: aload_0
    //   5947: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5950: aastore
    //   5951: dup
    //   5952: iconst_1
    //   5953: aload_0
    //   5954: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5957: aastore
    //   5958: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5961: goto -486 -> 5475
    //   5964: astore 27
    //   5966: ldc 130
    //   5968: aload 27
    //   5970: ldc_w 514
    //   5973: iconst_2
    //   5974: anewarray 4	java/lang/Object
    //   5977: dup
    //   5978: iconst_0
    //   5979: aload_0
    //   5980: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   5983: aastore
    //   5984: dup
    //   5985: iconst_1
    //   5986: aload_0
    //   5987: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   5990: aastore
    //   5991: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   5994: goto -519 -> 5475
    //   5997: ldc 225
    //   5999: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6002: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   6005: aload_0
    //   6006: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   6009: invokeinterface 230 1 0
    //   6014: aload_0
    //   6015: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   6018: ldc 234
    //   6020: aload_0
    //   6021: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   6024: lconst_0
    //   6025: lload 19
    //   6027: iload_2
    //   6028: iconst_1
    //   6029: aload_0
    //   6030: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   6033: aload_0
    //   6034: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   6037: aload_0
    //   6038: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   6041: invokeinterface 244 14 0
    //   6046: goto -4966 -> 1080
    //   6049: aload_0
    //   6050: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   6053: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   6056: ifeq +163 -> 6219
    //   6059: ldc 225
    //   6061: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6064: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   6067: aload_0
    //   6068: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   6071: invokeinterface 230 1 0
    //   6076: aload_0
    //   6077: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   6080: ldc 234
    //   6082: aload_0
    //   6083: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   6086: lconst_0
    //   6087: lload 19
    //   6089: iload_2
    //   6090: iconst_2
    //   6091: aload_0
    //   6092: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   6095: aload_0
    //   6096: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6099: aload_0
    //   6100: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   6103: invokeinterface 244 14 0
    //   6108: ldc 116
    //   6110: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6113: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6116: ldc2_w 123
    //   6119: ldc2_w 441
    //   6122: lconst_1
    //   6123: iconst_0
    //   6124: invokeinterface 128 8 0
    //   6129: ldc 116
    //   6131: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6134: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6137: ldc2_w 123
    //   6140: ldc2_w 443
    //   6143: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   6146: aload_0
    //   6147: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   6150: lsub
    //   6151: iconst_0
    //   6152: invokeinterface 128 8 0
    //   6157: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6160: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   6163: istore_1
    //   6164: iload_1
    //   6165: iconst_m1
    //   6166: if_icmpne +24 -> 6190
    //   6169: ldc 116
    //   6171: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6174: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6177: ldc2_w 123
    //   6180: ldc2_w 449
    //   6183: lconst_1
    //   6184: iconst_0
    //   6185: invokeinterface 128 8 0
    //   6190: ldc 130
    //   6192: ldc_w 452
    //   6195: iconst_2
    //   6196: anewarray 4	java/lang/Object
    //   6199: dup
    //   6200: iconst_0
    //   6201: aload_0
    //   6202: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   6205: aastore
    //   6206: dup
    //   6207: iconst_1
    //   6208: iload_1
    //   6209: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6212: aastore
    //   6213: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6216: goto -5087 -> 1129
    //   6219: ldc 225
    //   6221: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6224: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   6227: aload_0
    //   6228: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   6231: invokeinterface 230 1 0
    //   6236: aload_0
    //   6237: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   6240: ldc 234
    //   6242: aload_0
    //   6243: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   6246: lconst_0
    //   6247: lload 19
    //   6249: iload_2
    //   6250: iconst_2
    //   6251: aload_0
    //   6252: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   6255: aload_0
    //   6256: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   6259: aload_0
    //   6260: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   6263: invokeinterface 244 14 0
    //   6268: goto -160 -> 6108
    //   6271: astore 27
    //   6273: ldc 130
    //   6275: aload 27
    //   6277: ldc_w 510
    //   6280: iconst_2
    //   6281: anewarray 4	java/lang/Object
    //   6284: dup
    //   6285: iconst_0
    //   6286: aload_0
    //   6287: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   6290: aastore
    //   6291: dup
    //   6292: iconst_1
    //   6293: aload_0
    //   6294: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6297: aastore
    //   6298: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6301: goto -5162 -> 1139
    //   6304: astore 27
    //   6306: ldc 130
    //   6308: aload 27
    //   6310: ldc_w 510
    //   6313: iconst_2
    //   6314: anewarray 4	java/lang/Object
    //   6317: dup
    //   6318: iconst_0
    //   6319: aload_0
    //   6320: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   6323: aastore
    //   6324: dup
    //   6325: iconst_1
    //   6326: aload_0
    //   6327: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6330: aastore
    //   6331: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6334: goto -5185 -> 1149
    //   6337: astore 27
    //   6339: ldc 130
    //   6341: aload 27
    //   6343: ldc_w 512
    //   6346: iconst_2
    //   6347: anewarray 4	java/lang/Object
    //   6350: dup
    //   6351: iconst_0
    //   6352: aload_0
    //   6353: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   6356: aastore
    //   6357: dup
    //   6358: iconst_1
    //   6359: aload_0
    //   6360: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6363: aastore
    //   6364: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6367: goto -5218 -> 1149
    //   6370: astore 27
    //   6372: ldc 130
    //   6374: aload 27
    //   6376: ldc_w 514
    //   6379: iconst_2
    //   6380: anewarray 4	java/lang/Object
    //   6383: dup
    //   6384: iconst_0
    //   6385: aload_0
    //   6386: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   6389: aastore
    //   6390: dup
    //   6391: iconst_1
    //   6392: aload_0
    //   6393: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6396: aastore
    //   6397: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6400: goto -5251 -> 1149
    //   6403: astore 29
    //   6405: aconst_null
    //   6406: astore 27
    //   6408: aconst_null
    //   6409: astore 28
    //   6411: iload 8
    //   6413: istore 4
    //   6415: iload_3
    //   6416: istore_1
    //   6417: iload_1
    //   6418: istore_3
    //   6419: lload 19
    //   6421: lstore 21
    //   6423: aload 27
    //   6425: astore 31
    //   6427: iload 4
    //   6429: istore_2
    //   6430: aload 28
    //   6432: astore 30
    //   6434: ldc 116
    //   6436: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6439: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6442: ldc2_w 123
    //   6445: ldc2_w 606
    //   6448: lconst_1
    //   6449: iconst_0
    //   6450: invokeinterface 128 8 0
    //   6455: iload_1
    //   6456: istore_3
    //   6457: lload 19
    //   6459: lstore 21
    //   6461: aload 27
    //   6463: astore 31
    //   6465: iload 4
    //   6467: istore_2
    //   6468: aload 28
    //   6470: astore 30
    //   6472: ldc 130
    //   6474: aload 29
    //   6476: ldc_w 609
    //   6479: iconst_2
    //   6480: anewarray 4	java/lang/Object
    //   6483: dup
    //   6484: iconst_0
    //   6485: aload_0
    //   6486: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   6489: aastore
    //   6490: dup
    //   6491: iconst_1
    //   6492: aload_0
    //   6493: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6496: aastore
    //   6497: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6500: iload_1
    //   6501: istore_3
    //   6502: lload 19
    //   6504: lstore 21
    //   6506: aload 27
    //   6508: astore 31
    //   6510: iload 4
    //   6512: istore_2
    //   6513: aload 28
    //   6515: astore 30
    //   6517: aload_0
    //   6518: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   6521: aload_0
    //   6522: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6525: aload_0
    //   6526: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   6529: ldc_w 611
    //   6532: invokeinterface 217 4 0
    //   6537: iload 4
    //   6539: ifeq +232 -> 6771
    //   6542: aload_0
    //   6543: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   6546: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   6549: ifeq +170 -> 6719
    //   6552: ldc 225
    //   6554: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6557: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   6560: aload_0
    //   6561: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   6564: invokeinterface 230 1 0
    //   6569: aload_0
    //   6570: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   6573: ldc 234
    //   6575: aload_0
    //   6576: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   6579: lconst_0
    //   6580: lload 19
    //   6582: iload_1
    //   6583: iconst_1
    //   6584: aload_0
    //   6585: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   6588: aload_0
    //   6589: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6592: aload_0
    //   6593: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   6596: invokeinterface 244 14 0
    //   6601: ldc 116
    //   6603: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6606: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6609: ldc2_w 123
    //   6612: ldc2_w 353
    //   6615: lconst_1
    //   6616: iconst_0
    //   6617: invokeinterface 128 8 0
    //   6622: ldc 116
    //   6624: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6627: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6630: ldc2_w 123
    //   6633: ldc2_w 355
    //   6636: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   6639: aload_0
    //   6640: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   6643: lsub
    //   6644: iconst_0
    //   6645: invokeinterface 128 8 0
    //   6650: aload 27
    //   6652: ifnull +8 -> 6660
    //   6655: aload 27
    //   6657: invokevirtual 361	java/io/OutputStream:close	()V
    //   6660: aload 28
    //   6662: ifnull +8 -> 6670
    //   6665: aload 28
    //   6667: invokevirtual 364	java/io/InputStream:close	()V
    //   6670: aload_0
    //   6671: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   6674: aload_0
    //   6675: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   6678: aload_0
    //   6679: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   6682: invokeinterface 372 2 0
    //   6687: ldc 130
    //   6689: ldc_w 374
    //   6692: iconst_2
    //   6693: anewarray 4	java/lang/Object
    //   6696: dup
    //   6697: iconst_0
    //   6698: aload_0
    //   6699: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   6702: aastore
    //   6703: dup
    //   6704: iconst_1
    //   6705: aload_0
    //   6706: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   6709: aastore
    //   6710: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6713: ldc 210
    //   6715: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   6718: return
    //   6719: ldc 225
    //   6721: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6724: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   6727: aload_0
    //   6728: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   6731: invokeinterface 230 1 0
    //   6736: aload_0
    //   6737: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   6740: ldc 234
    //   6742: aload_0
    //   6743: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   6746: lconst_0
    //   6747: lload 19
    //   6749: iload_1
    //   6750: iconst_1
    //   6751: aload_0
    //   6752: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   6755: aload_0
    //   6756: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   6759: aload_0
    //   6760: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   6763: invokeinterface 244 14 0
    //   6768: goto -167 -> 6601
    //   6771: aload_0
    //   6772: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   6775: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   6778: ifeq +163 -> 6941
    //   6781: ldc 225
    //   6783: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6786: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   6789: aload_0
    //   6790: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   6793: invokeinterface 230 1 0
    //   6798: aload_0
    //   6799: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   6802: ldc 234
    //   6804: aload_0
    //   6805: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   6808: lconst_0
    //   6809: lload 19
    //   6811: iload_1
    //   6812: iconst_2
    //   6813: aload_0
    //   6814: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   6817: aload_0
    //   6818: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   6821: aload_0
    //   6822: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   6825: invokeinterface 244 14 0
    //   6830: ldc 116
    //   6832: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6835: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6838: ldc2_w 123
    //   6841: ldc2_w 441
    //   6844: lconst_1
    //   6845: iconst_0
    //   6846: invokeinterface 128 8 0
    //   6851: ldc 116
    //   6853: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6856: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6859: ldc2_w 123
    //   6862: ldc2_w 443
    //   6865: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   6868: aload_0
    //   6869: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   6872: lsub
    //   6873: iconst_0
    //   6874: invokeinterface 128 8 0
    //   6879: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   6882: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   6885: istore_1
    //   6886: iload_1
    //   6887: iconst_m1
    //   6888: if_icmpne +24 -> 6912
    //   6891: ldc 116
    //   6893: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6896: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   6899: ldc2_w 123
    //   6902: ldc2_w 449
    //   6905: lconst_1
    //   6906: iconst_0
    //   6907: invokeinterface 128 8 0
    //   6912: ldc 130
    //   6914: ldc_w 452
    //   6917: iconst_2
    //   6918: anewarray 4	java/lang/Object
    //   6921: dup
    //   6922: iconst_0
    //   6923: aload_0
    //   6924: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   6927: aastore
    //   6928: dup
    //   6929: iconst_1
    //   6930: iload_1
    //   6931: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6934: aastore
    //   6935: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   6938: goto -288 -> 6650
    //   6941: ldc 225
    //   6943: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   6946: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   6949: aload_0
    //   6950: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   6953: invokeinterface 230 1 0
    //   6958: aload_0
    //   6959: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   6962: ldc 234
    //   6964: aload_0
    //   6965: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   6968: lconst_0
    //   6969: lload 19
    //   6971: iload_1
    //   6972: iconst_2
    //   6973: aload_0
    //   6974: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   6977: aload_0
    //   6978: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   6981: aload_0
    //   6982: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   6985: invokeinterface 244 14 0
    //   6990: goto -160 -> 6830
    //   6993: astore 27
    //   6995: ldc 130
    //   6997: aload 27
    //   6999: ldc_w 510
    //   7002: iconst_2
    //   7003: anewarray 4	java/lang/Object
    //   7006: dup
    //   7007: iconst_0
    //   7008: aload_0
    //   7009: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7012: aastore
    //   7013: dup
    //   7014: iconst_1
    //   7015: aload_0
    //   7016: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7019: aastore
    //   7020: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7023: goto -363 -> 6660
    //   7026: astore 27
    //   7028: ldc 130
    //   7030: aload 27
    //   7032: ldc_w 510
    //   7035: iconst_2
    //   7036: anewarray 4	java/lang/Object
    //   7039: dup
    //   7040: iconst_0
    //   7041: aload_0
    //   7042: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7045: aastore
    //   7046: dup
    //   7047: iconst_1
    //   7048: aload_0
    //   7049: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7052: aastore
    //   7053: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7056: goto -386 -> 6670
    //   7059: astore 27
    //   7061: ldc 130
    //   7063: aload 27
    //   7065: ldc_w 512
    //   7068: iconst_2
    //   7069: anewarray 4	java/lang/Object
    //   7072: dup
    //   7073: iconst_0
    //   7074: aload_0
    //   7075: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7078: aastore
    //   7079: dup
    //   7080: iconst_1
    //   7081: aload_0
    //   7082: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7085: aastore
    //   7086: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7089: goto -419 -> 6670
    //   7092: astore 27
    //   7094: ldc 130
    //   7096: aload 27
    //   7098: ldc_w 514
    //   7101: iconst_2
    //   7102: anewarray 4	java/lang/Object
    //   7105: dup
    //   7106: iconst_0
    //   7107: aload_0
    //   7108: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7111: aastore
    //   7112: dup
    //   7113: iconst_1
    //   7114: aload_0
    //   7115: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7118: aastore
    //   7119: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7122: goto -452 -> 6670
    //   7125: astore 29
    //   7127: aconst_null
    //   7128: astore 27
    //   7130: aconst_null
    //   7131: astore 28
    //   7133: iload 9
    //   7135: istore 5
    //   7137: iload 4
    //   7139: istore_1
    //   7140: iload_1
    //   7141: istore_3
    //   7142: lload 19
    //   7144: lstore 21
    //   7146: aload 27
    //   7148: astore 31
    //   7150: iload 5
    //   7152: istore_2
    //   7153: aload 28
    //   7155: astore 30
    //   7157: ldc 116
    //   7159: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7162: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   7165: ldc2_w 123
    //   7168: ldc2_w 612
    //   7171: lconst_1
    //   7172: iconst_0
    //   7173: invokeinterface 128 8 0
    //   7178: iload_1
    //   7179: istore_3
    //   7180: lload 19
    //   7182: lstore 21
    //   7184: aload 27
    //   7186: astore 31
    //   7188: iload 5
    //   7190: istore_2
    //   7191: aload 28
    //   7193: astore 30
    //   7195: ldc 130
    //   7197: aload 29
    //   7199: ldc_w 615
    //   7202: iconst_2
    //   7203: anewarray 4	java/lang/Object
    //   7206: dup
    //   7207: iconst_0
    //   7208: aload_0
    //   7209: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7212: aastore
    //   7213: dup
    //   7214: iconst_1
    //   7215: aload_0
    //   7216: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7219: aastore
    //   7220: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7223: iload_1
    //   7224: istore_3
    //   7225: lload 19
    //   7227: lstore 21
    //   7229: aload 27
    //   7231: astore 31
    //   7233: iload 5
    //   7235: istore_2
    //   7236: aload 28
    //   7238: astore 30
    //   7240: aload_0
    //   7241: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   7244: aload_0
    //   7245: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7248: aload_0
    //   7249: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7252: ldc_w 617
    //   7255: invokeinterface 217 4 0
    //   7260: iload 5
    //   7262: ifeq +232 -> 7494
    //   7265: aload_0
    //   7266: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   7269: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   7272: ifeq +170 -> 7442
    //   7275: ldc 225
    //   7277: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7280: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   7283: aload_0
    //   7284: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   7287: invokeinterface 230 1 0
    //   7292: aload_0
    //   7293: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   7296: ldc 234
    //   7298: aload_0
    //   7299: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   7302: lconst_0
    //   7303: lload 19
    //   7305: iload_1
    //   7306: iconst_1
    //   7307: aload_0
    //   7308: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   7311: aload_0
    //   7312: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7315: aload_0
    //   7316: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   7319: invokeinterface 244 14 0
    //   7324: ldc 116
    //   7326: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7329: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   7332: ldc2_w 123
    //   7335: ldc2_w 353
    //   7338: lconst_1
    //   7339: iconst_0
    //   7340: invokeinterface 128 8 0
    //   7345: ldc 116
    //   7347: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7350: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   7353: ldc2_w 123
    //   7356: ldc2_w 355
    //   7359: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   7362: aload_0
    //   7363: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   7366: lsub
    //   7367: iconst_0
    //   7368: invokeinterface 128 8 0
    //   7373: aload 27
    //   7375: ifnull +8 -> 7383
    //   7378: aload 27
    //   7380: invokevirtual 361	java/io/OutputStream:close	()V
    //   7383: aload 28
    //   7385: ifnull +8 -> 7393
    //   7388: aload 28
    //   7390: invokevirtual 364	java/io/InputStream:close	()V
    //   7393: aload_0
    //   7394: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   7397: aload_0
    //   7398: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   7401: aload_0
    //   7402: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   7405: invokeinterface 372 2 0
    //   7410: ldc 130
    //   7412: ldc_w 374
    //   7415: iconst_2
    //   7416: anewarray 4	java/lang/Object
    //   7419: dup
    //   7420: iconst_0
    //   7421: aload_0
    //   7422: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   7425: aastore
    //   7426: dup
    //   7427: iconst_1
    //   7428: aload_0
    //   7429: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7432: aastore
    //   7433: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7436: ldc 210
    //   7438: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   7441: return
    //   7442: ldc 225
    //   7444: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7447: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   7450: aload_0
    //   7451: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   7454: invokeinterface 230 1 0
    //   7459: aload_0
    //   7460: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   7463: ldc 234
    //   7465: aload_0
    //   7466: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   7469: lconst_0
    //   7470: lload 19
    //   7472: iload_1
    //   7473: iconst_1
    //   7474: aload_0
    //   7475: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   7478: aload_0
    //   7479: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   7482: aload_0
    //   7483: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   7486: invokeinterface 244 14 0
    //   7491: goto -167 -> 7324
    //   7494: aload_0
    //   7495: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   7498: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   7501: ifeq +163 -> 7664
    //   7504: ldc 225
    //   7506: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7509: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   7512: aload_0
    //   7513: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   7516: invokeinterface 230 1 0
    //   7521: aload_0
    //   7522: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   7525: ldc 234
    //   7527: aload_0
    //   7528: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   7531: lconst_0
    //   7532: lload 19
    //   7534: iload_1
    //   7535: iconst_2
    //   7536: aload_0
    //   7537: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   7540: aload_0
    //   7541: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7544: aload_0
    //   7545: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   7548: invokeinterface 244 14 0
    //   7553: ldc 116
    //   7555: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7558: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   7561: ldc2_w 123
    //   7564: ldc2_w 441
    //   7567: lconst_1
    //   7568: iconst_0
    //   7569: invokeinterface 128 8 0
    //   7574: ldc 116
    //   7576: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7579: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   7582: ldc2_w 123
    //   7585: ldc2_w 443
    //   7588: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   7591: aload_0
    //   7592: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   7595: lsub
    //   7596: iconst_0
    //   7597: invokeinterface 128 8 0
    //   7602: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   7605: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   7608: istore_1
    //   7609: iload_1
    //   7610: iconst_m1
    //   7611: if_icmpne +24 -> 7635
    //   7614: ldc 116
    //   7616: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7619: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   7622: ldc2_w 123
    //   7625: ldc2_w 449
    //   7628: lconst_1
    //   7629: iconst_0
    //   7630: invokeinterface 128 8 0
    //   7635: ldc 130
    //   7637: ldc_w 452
    //   7640: iconst_2
    //   7641: anewarray 4	java/lang/Object
    //   7644: dup
    //   7645: iconst_0
    //   7646: aload_0
    //   7647: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   7650: aastore
    //   7651: dup
    //   7652: iconst_1
    //   7653: iload_1
    //   7654: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   7657: aastore
    //   7658: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7661: goto -288 -> 7373
    //   7664: ldc 225
    //   7666: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7669: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   7672: aload_0
    //   7673: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   7676: invokeinterface 230 1 0
    //   7681: aload_0
    //   7682: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   7685: ldc 234
    //   7687: aload_0
    //   7688: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   7691: lconst_0
    //   7692: lload 19
    //   7694: iload_1
    //   7695: iconst_2
    //   7696: aload_0
    //   7697: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   7700: aload_0
    //   7701: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   7704: aload_0
    //   7705: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   7708: invokeinterface 244 14 0
    //   7713: goto -160 -> 7553
    //   7716: astore 27
    //   7718: ldc 130
    //   7720: aload 27
    //   7722: ldc_w 510
    //   7725: iconst_2
    //   7726: anewarray 4	java/lang/Object
    //   7729: dup
    //   7730: iconst_0
    //   7731: aload_0
    //   7732: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7735: aastore
    //   7736: dup
    //   7737: iconst_1
    //   7738: aload_0
    //   7739: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7742: aastore
    //   7743: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7746: goto -363 -> 7383
    //   7749: astore 27
    //   7751: ldc 130
    //   7753: aload 27
    //   7755: ldc_w 510
    //   7758: iconst_2
    //   7759: anewarray 4	java/lang/Object
    //   7762: dup
    //   7763: iconst_0
    //   7764: aload_0
    //   7765: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7768: aastore
    //   7769: dup
    //   7770: iconst_1
    //   7771: aload_0
    //   7772: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7775: aastore
    //   7776: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7779: goto -386 -> 7393
    //   7782: astore 27
    //   7784: ldc 130
    //   7786: aload 27
    //   7788: ldc_w 512
    //   7791: iconst_2
    //   7792: anewarray 4	java/lang/Object
    //   7795: dup
    //   7796: iconst_0
    //   7797: aload_0
    //   7798: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7801: aastore
    //   7802: dup
    //   7803: iconst_1
    //   7804: aload_0
    //   7805: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7808: aastore
    //   7809: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7812: goto -419 -> 7393
    //   7815: astore 27
    //   7817: ldc 130
    //   7819: aload 27
    //   7821: ldc_w 514
    //   7824: iconst_2
    //   7825: anewarray 4	java/lang/Object
    //   7828: dup
    //   7829: iconst_0
    //   7830: aload_0
    //   7831: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7834: aastore
    //   7835: dup
    //   7836: iconst_1
    //   7837: aload_0
    //   7838: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7841: aastore
    //   7842: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7845: goto -452 -> 7393
    //   7848: astore 29
    //   7850: aconst_null
    //   7851: astore 27
    //   7853: aconst_null
    //   7854: astore 28
    //   7856: iload 10
    //   7858: istore 4
    //   7860: iload 5
    //   7862: istore_1
    //   7863: iload_1
    //   7864: istore_3
    //   7865: lload 19
    //   7867: lstore 21
    //   7869: aload 27
    //   7871: astore 31
    //   7873: iload 4
    //   7875: istore_2
    //   7876: aload 28
    //   7878: astore 30
    //   7880: ldc 116
    //   7882: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   7885: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   7888: ldc2_w 123
    //   7891: ldc2_w 618
    //   7894: lconst_1
    //   7895: iconst_0
    //   7896: invokeinterface 128 8 0
    //   7901: iload_1
    //   7902: istore_3
    //   7903: lload 19
    //   7905: lstore 21
    //   7907: aload 27
    //   7909: astore 31
    //   7911: iload 4
    //   7913: istore_2
    //   7914: aload 28
    //   7916: astore 30
    //   7918: ldc 130
    //   7920: aload 29
    //   7922: ldc_w 621
    //   7925: iconst_2
    //   7926: anewarray 4	java/lang/Object
    //   7929: dup
    //   7930: iconst_0
    //   7931: aload_0
    //   7932: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7935: aastore
    //   7936: dup
    //   7937: iconst_1
    //   7938: aload_0
    //   7939: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7942: aastore
    //   7943: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   7946: iload_1
    //   7947: istore_3
    //   7948: lload 19
    //   7950: lstore 21
    //   7952: aload 27
    //   7954: astore 31
    //   7956: iload 4
    //   7958: istore_2
    //   7959: aload 28
    //   7961: astore 30
    //   7963: aload_0
    //   7964: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   7967: aload_0
    //   7968: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   7971: aload_0
    //   7972: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   7975: ldc_w 623
    //   7978: invokeinterface 217 4 0
    //   7983: iload 4
    //   7985: ifeq +232 -> 8217
    //   7988: aload_0
    //   7989: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   7992: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   7995: ifeq +170 -> 8165
    //   7998: ldc 225
    //   8000: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8003: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   8006: aload_0
    //   8007: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   8010: invokeinterface 230 1 0
    //   8015: aload_0
    //   8016: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   8019: ldc 234
    //   8021: aload_0
    //   8022: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   8025: lconst_0
    //   8026: lload 19
    //   8028: iload_1
    //   8029: iconst_1
    //   8030: aload_0
    //   8031: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   8034: aload_0
    //   8035: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8038: aload_0
    //   8039: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   8042: invokeinterface 244 14 0
    //   8047: ldc 116
    //   8049: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8052: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   8055: ldc2_w 123
    //   8058: ldc2_w 353
    //   8061: lconst_1
    //   8062: iconst_0
    //   8063: invokeinterface 128 8 0
    //   8068: ldc 116
    //   8070: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8073: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   8076: ldc2_w 123
    //   8079: ldc2_w 355
    //   8082: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   8085: aload_0
    //   8086: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   8089: lsub
    //   8090: iconst_0
    //   8091: invokeinterface 128 8 0
    //   8096: aload 27
    //   8098: ifnull +8 -> 8106
    //   8101: aload 27
    //   8103: invokevirtual 361	java/io/OutputStream:close	()V
    //   8106: aload 28
    //   8108: ifnull +8 -> 8116
    //   8111: aload 28
    //   8113: invokevirtual 364	java/io/InputStream:close	()V
    //   8116: aload_0
    //   8117: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   8120: aload_0
    //   8121: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   8124: aload_0
    //   8125: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   8128: invokeinterface 372 2 0
    //   8133: ldc 130
    //   8135: ldc_w 374
    //   8138: iconst_2
    //   8139: anewarray 4	java/lang/Object
    //   8142: dup
    //   8143: iconst_0
    //   8144: aload_0
    //   8145: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   8148: aastore
    //   8149: dup
    //   8150: iconst_1
    //   8151: aload_0
    //   8152: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   8155: aastore
    //   8156: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8159: ldc 210
    //   8161: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8164: return
    //   8165: ldc 225
    //   8167: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8170: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   8173: aload_0
    //   8174: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   8177: invokeinterface 230 1 0
    //   8182: aload_0
    //   8183: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   8186: ldc 234
    //   8188: aload_0
    //   8189: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   8192: lconst_0
    //   8193: lload 19
    //   8195: iload_1
    //   8196: iconst_1
    //   8197: aload_0
    //   8198: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   8201: aload_0
    //   8202: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   8205: aload_0
    //   8206: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   8209: invokeinterface 244 14 0
    //   8214: goto -167 -> 8047
    //   8217: aload_0
    //   8218: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   8221: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   8224: ifeq +163 -> 8387
    //   8227: ldc 225
    //   8229: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8232: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   8235: aload_0
    //   8236: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   8239: invokeinterface 230 1 0
    //   8244: aload_0
    //   8245: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   8248: ldc 234
    //   8250: aload_0
    //   8251: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   8254: lconst_0
    //   8255: lload 19
    //   8257: iload_1
    //   8258: iconst_2
    //   8259: aload_0
    //   8260: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   8263: aload_0
    //   8264: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8267: aload_0
    //   8268: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   8271: invokeinterface 244 14 0
    //   8276: ldc 116
    //   8278: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8281: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   8284: ldc2_w 123
    //   8287: ldc2_w 441
    //   8290: lconst_1
    //   8291: iconst_0
    //   8292: invokeinterface 128 8 0
    //   8297: ldc 116
    //   8299: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8302: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   8305: ldc2_w 123
    //   8308: ldc2_w 443
    //   8311: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   8314: aload_0
    //   8315: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   8318: lsub
    //   8319: iconst_0
    //   8320: invokeinterface 128 8 0
    //   8325: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   8328: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   8331: istore_1
    //   8332: iload_1
    //   8333: iconst_m1
    //   8334: if_icmpne +24 -> 8358
    //   8337: ldc 116
    //   8339: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8342: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   8345: ldc2_w 123
    //   8348: ldc2_w 449
    //   8351: lconst_1
    //   8352: iconst_0
    //   8353: invokeinterface 128 8 0
    //   8358: ldc 130
    //   8360: ldc_w 452
    //   8363: iconst_2
    //   8364: anewarray 4	java/lang/Object
    //   8367: dup
    //   8368: iconst_0
    //   8369: aload_0
    //   8370: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   8373: aastore
    //   8374: dup
    //   8375: iconst_1
    //   8376: iload_1
    //   8377: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   8380: aastore
    //   8381: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8384: goto -288 -> 8096
    //   8387: ldc 225
    //   8389: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8392: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   8395: aload_0
    //   8396: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   8399: invokeinterface 230 1 0
    //   8404: aload_0
    //   8405: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   8408: ldc 234
    //   8410: aload_0
    //   8411: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   8414: lconst_0
    //   8415: lload 19
    //   8417: iload_1
    //   8418: iconst_2
    //   8419: aload_0
    //   8420: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   8423: aload_0
    //   8424: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   8427: aload_0
    //   8428: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   8431: invokeinterface 244 14 0
    //   8436: goto -160 -> 8276
    //   8439: astore 27
    //   8441: ldc 130
    //   8443: aload 27
    //   8445: ldc_w 510
    //   8448: iconst_2
    //   8449: anewarray 4	java/lang/Object
    //   8452: dup
    //   8453: iconst_0
    //   8454: aload_0
    //   8455: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   8458: aastore
    //   8459: dup
    //   8460: iconst_1
    //   8461: aload_0
    //   8462: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8465: aastore
    //   8466: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8469: goto -363 -> 8106
    //   8472: astore 27
    //   8474: ldc 130
    //   8476: aload 27
    //   8478: ldc_w 510
    //   8481: iconst_2
    //   8482: anewarray 4	java/lang/Object
    //   8485: dup
    //   8486: iconst_0
    //   8487: aload_0
    //   8488: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   8491: aastore
    //   8492: dup
    //   8493: iconst_1
    //   8494: aload_0
    //   8495: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8498: aastore
    //   8499: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8502: goto -386 -> 8116
    //   8505: astore 27
    //   8507: ldc 130
    //   8509: aload 27
    //   8511: ldc_w 512
    //   8514: iconst_2
    //   8515: anewarray 4	java/lang/Object
    //   8518: dup
    //   8519: iconst_0
    //   8520: aload_0
    //   8521: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   8524: aastore
    //   8525: dup
    //   8526: iconst_1
    //   8527: aload_0
    //   8528: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8531: aastore
    //   8532: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8535: goto -419 -> 8116
    //   8538: astore 27
    //   8540: ldc 130
    //   8542: aload 27
    //   8544: ldc_w 514
    //   8547: iconst_2
    //   8548: anewarray 4	java/lang/Object
    //   8551: dup
    //   8552: iconst_0
    //   8553: aload_0
    //   8554: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   8557: aastore
    //   8558: dup
    //   8559: iconst_1
    //   8560: aload_0
    //   8561: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8564: aastore
    //   8565: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8568: goto -452 -> 8116
    //   8571: astore 29
    //   8573: aconst_null
    //   8574: astore 27
    //   8576: aconst_null
    //   8577: astore 28
    //   8579: iload 11
    //   8581: istore 4
    //   8583: iload 6
    //   8585: istore_1
    //   8586: iload_1
    //   8587: istore_3
    //   8588: lload 19
    //   8590: lstore 21
    //   8592: aload 27
    //   8594: astore 31
    //   8596: iload 4
    //   8598: istore_2
    //   8599: aload 28
    //   8601: astore 30
    //   8603: ldc 116
    //   8605: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8608: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   8611: ldc2_w 123
    //   8614: ldc2_w 624
    //   8617: lconst_1
    //   8618: iconst_0
    //   8619: invokeinterface 128 8 0
    //   8624: iload_1
    //   8625: istore_3
    //   8626: lload 19
    //   8628: lstore 21
    //   8630: aload 27
    //   8632: astore 31
    //   8634: iload 4
    //   8636: istore_2
    //   8637: aload 28
    //   8639: astore 30
    //   8641: ldc 130
    //   8643: aload 29
    //   8645: ldc_w 627
    //   8648: iconst_2
    //   8649: anewarray 4	java/lang/Object
    //   8652: dup
    //   8653: iconst_0
    //   8654: aload_0
    //   8655: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   8658: aastore
    //   8659: dup
    //   8660: iconst_1
    //   8661: aload_0
    //   8662: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8665: aastore
    //   8666: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8669: iload_1
    //   8670: istore_3
    //   8671: lload 19
    //   8673: lstore 21
    //   8675: aload 27
    //   8677: astore 31
    //   8679: iload 4
    //   8681: istore_2
    //   8682: aload 28
    //   8684: astore 30
    //   8686: aload_0
    //   8687: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   8690: aload_0
    //   8691: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8694: aload_0
    //   8695: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   8698: new 629	java/lang/StringBuilder
    //   8701: dup
    //   8702: invokespecial 630	java/lang/StringBuilder:<init>	()V
    //   8705: aload 29
    //   8707: invokevirtual 631	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   8710: invokevirtual 635	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8713: invokevirtual 636	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8716: invokeinterface 217 4 0
    //   8721: iload 4
    //   8723: ifeq +232 -> 8955
    //   8726: aload_0
    //   8727: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   8730: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   8733: ifeq +170 -> 8903
    //   8736: ldc 225
    //   8738: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8741: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   8744: aload_0
    //   8745: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   8748: invokeinterface 230 1 0
    //   8753: aload_0
    //   8754: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   8757: ldc 234
    //   8759: aload_0
    //   8760: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   8763: lconst_0
    //   8764: lload 19
    //   8766: iload_1
    //   8767: iconst_1
    //   8768: aload_0
    //   8769: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   8772: aload_0
    //   8773: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   8776: aload_0
    //   8777: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   8780: invokeinterface 244 14 0
    //   8785: ldc 116
    //   8787: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8790: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   8793: ldc2_w 123
    //   8796: ldc2_w 353
    //   8799: lconst_1
    //   8800: iconst_0
    //   8801: invokeinterface 128 8 0
    //   8806: ldc 116
    //   8808: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8811: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   8814: ldc2_w 123
    //   8817: ldc2_w 355
    //   8820: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   8823: aload_0
    //   8824: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   8827: lsub
    //   8828: iconst_0
    //   8829: invokeinterface 128 8 0
    //   8834: aload 27
    //   8836: ifnull +8 -> 8844
    //   8839: aload 27
    //   8841: invokevirtual 361	java/io/OutputStream:close	()V
    //   8844: aload 28
    //   8846: ifnull +8 -> 8854
    //   8849: aload 28
    //   8851: invokevirtual 364	java/io/InputStream:close	()V
    //   8854: aload_0
    //   8855: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   8858: aload_0
    //   8859: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   8862: aload_0
    //   8863: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   8866: invokeinterface 372 2 0
    //   8871: ldc 130
    //   8873: ldc_w 374
    //   8876: iconst_2
    //   8877: anewarray 4	java/lang/Object
    //   8880: dup
    //   8881: iconst_0
    //   8882: aload_0
    //   8883: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   8886: aastore
    //   8887: dup
    //   8888: iconst_1
    //   8889: aload_0
    //   8890: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   8893: aastore
    //   8894: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   8897: ldc 210
    //   8899: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   8902: return
    //   8903: ldc 225
    //   8905: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8908: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   8911: aload_0
    //   8912: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   8915: invokeinterface 230 1 0
    //   8920: aload_0
    //   8921: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   8924: ldc 234
    //   8926: aload_0
    //   8927: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   8930: lconst_0
    //   8931: lload 19
    //   8933: iload_1
    //   8934: iconst_1
    //   8935: aload_0
    //   8936: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   8939: aload_0
    //   8940: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   8943: aload_0
    //   8944: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   8947: invokeinterface 244 14 0
    //   8952: goto -167 -> 8785
    //   8955: aload_0
    //   8956: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   8959: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   8962: ifeq +163 -> 9125
    //   8965: ldc 225
    //   8967: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   8970: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   8973: aload_0
    //   8974: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   8977: invokeinterface 230 1 0
    //   8982: aload_0
    //   8983: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   8986: ldc 234
    //   8988: aload_0
    //   8989: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   8992: lconst_0
    //   8993: lload 19
    //   8995: iload_1
    //   8996: iconst_2
    //   8997: aload_0
    //   8998: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   9001: aload_0
    //   9002: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9005: aload_0
    //   9006: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   9009: invokeinterface 244 14 0
    //   9014: ldc 116
    //   9016: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9019: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   9022: ldc2_w 123
    //   9025: ldc2_w 441
    //   9028: lconst_1
    //   9029: iconst_0
    //   9030: invokeinterface 128 8 0
    //   9035: ldc 116
    //   9037: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9040: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   9043: ldc2_w 123
    //   9046: ldc2_w 443
    //   9049: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   9052: aload_0
    //   9053: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   9056: lsub
    //   9057: iconst_0
    //   9058: invokeinterface 128 8 0
    //   9063: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9066: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   9069: istore_1
    //   9070: iload_1
    //   9071: iconst_m1
    //   9072: if_icmpne +24 -> 9096
    //   9075: ldc 116
    //   9077: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9080: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   9083: ldc2_w 123
    //   9086: ldc2_w 449
    //   9089: lconst_1
    //   9090: iconst_0
    //   9091: invokeinterface 128 8 0
    //   9096: ldc 130
    //   9098: ldc_w 452
    //   9101: iconst_2
    //   9102: anewarray 4	java/lang/Object
    //   9105: dup
    //   9106: iconst_0
    //   9107: aload_0
    //   9108: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   9111: aastore
    //   9112: dup
    //   9113: iconst_1
    //   9114: iload_1
    //   9115: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9118: aastore
    //   9119: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9122: goto -288 -> 8834
    //   9125: ldc 225
    //   9127: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9130: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   9133: aload_0
    //   9134: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   9137: invokeinterface 230 1 0
    //   9142: aload_0
    //   9143: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   9146: ldc 234
    //   9148: aload_0
    //   9149: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   9152: lconst_0
    //   9153: lload 19
    //   9155: iload_1
    //   9156: iconst_2
    //   9157: aload_0
    //   9158: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   9161: aload_0
    //   9162: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   9165: aload_0
    //   9166: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   9169: invokeinterface 244 14 0
    //   9174: goto -160 -> 9014
    //   9177: astore 27
    //   9179: ldc 130
    //   9181: aload 27
    //   9183: ldc_w 510
    //   9186: iconst_2
    //   9187: anewarray 4	java/lang/Object
    //   9190: dup
    //   9191: iconst_0
    //   9192: aload_0
    //   9193: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9196: aastore
    //   9197: dup
    //   9198: iconst_1
    //   9199: aload_0
    //   9200: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9203: aastore
    //   9204: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9207: goto -363 -> 8844
    //   9210: astore 27
    //   9212: ldc 130
    //   9214: aload 27
    //   9216: ldc_w 510
    //   9219: iconst_2
    //   9220: anewarray 4	java/lang/Object
    //   9223: dup
    //   9224: iconst_0
    //   9225: aload_0
    //   9226: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9229: aastore
    //   9230: dup
    //   9231: iconst_1
    //   9232: aload_0
    //   9233: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9236: aastore
    //   9237: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9240: goto -386 -> 8854
    //   9243: astore 27
    //   9245: ldc 130
    //   9247: aload 27
    //   9249: ldc_w 512
    //   9252: iconst_2
    //   9253: anewarray 4	java/lang/Object
    //   9256: dup
    //   9257: iconst_0
    //   9258: aload_0
    //   9259: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9262: aastore
    //   9263: dup
    //   9264: iconst_1
    //   9265: aload_0
    //   9266: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9269: aastore
    //   9270: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9273: goto -419 -> 8854
    //   9276: astore 27
    //   9278: ldc 130
    //   9280: aload 27
    //   9282: ldc_w 514
    //   9285: iconst_2
    //   9286: anewarray 4	java/lang/Object
    //   9289: dup
    //   9290: iconst_0
    //   9291: aload_0
    //   9292: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9295: aastore
    //   9296: dup
    //   9297: iconst_1
    //   9298: aload_0
    //   9299: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9302: aastore
    //   9303: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9306: goto -452 -> 8854
    //   9309: astore 29
    //   9311: aconst_null
    //   9312: astore 27
    //   9314: aconst_null
    //   9315: astore 28
    //   9317: lconst_0
    //   9318: lstore 19
    //   9320: iload 12
    //   9322: istore_2
    //   9323: iload 7
    //   9325: istore_1
    //   9326: iload_2
    //   9327: ifeq +234 -> 9561
    //   9330: aload_0
    //   9331: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   9334: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9337: ifeq +172 -> 9509
    //   9340: ldc 225
    //   9342: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9345: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   9348: aload_0
    //   9349: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   9352: invokeinterface 230 1 0
    //   9357: aload_0
    //   9358: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   9361: ldc 234
    //   9363: aload_0
    //   9364: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   9367: lconst_0
    //   9368: lload 19
    //   9370: iload_1
    //   9371: iconst_1
    //   9372: aload_0
    //   9373: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   9376: aload_0
    //   9377: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9380: aload_0
    //   9381: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   9384: invokeinterface 244 14 0
    //   9389: ldc 116
    //   9391: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9394: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   9397: ldc2_w 123
    //   9400: ldc2_w 353
    //   9403: lconst_1
    //   9404: iconst_0
    //   9405: invokeinterface 128 8 0
    //   9410: ldc 116
    //   9412: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9415: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   9418: ldc2_w 123
    //   9421: ldc2_w 355
    //   9424: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   9427: aload_0
    //   9428: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   9431: lsub
    //   9432: iconst_0
    //   9433: invokeinterface 128 8 0
    //   9438: aload 27
    //   9440: ifnull +8 -> 9448
    //   9443: aload 27
    //   9445: invokevirtual 361	java/io/OutputStream:close	()V
    //   9448: aload 28
    //   9450: ifnull +8 -> 9458
    //   9453: aload 28
    //   9455: invokevirtual 364	java/io/InputStream:close	()V
    //   9458: aload_0
    //   9459: invokevirtual 367	com/tencent/mm/plugin/appbrand/s/a/b:cce	()V
    //   9462: aload_0
    //   9463: getfield 98	com/tencent/mm/plugin/appbrand/s/a/b:qjX	Lcom/tencent/mm/plugin/appbrand/s/a/a;
    //   9466: aload_0
    //   9467: invokespecial 369	com/tencent/mm/plugin/appbrand/s/a/b:bsL	()Ljava/lang/String;
    //   9470: invokeinterface 372 2 0
    //   9475: ldc 130
    //   9477: ldc_w 374
    //   9480: iconst_2
    //   9481: anewarray 4	java/lang/Object
    //   9484: dup
    //   9485: iconst_0
    //   9486: aload_0
    //   9487: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   9490: aastore
    //   9491: dup
    //   9492: iconst_1
    //   9493: aload_0
    //   9494: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9497: aastore
    //   9498: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9501: ldc 210
    //   9503: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   9506: aload 29
    //   9508: athrow
    //   9509: ldc 225
    //   9511: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9514: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   9517: aload_0
    //   9518: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   9521: invokeinterface 230 1 0
    //   9526: aload_0
    //   9527: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   9530: ldc 234
    //   9532: aload_0
    //   9533: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   9536: lconst_0
    //   9537: lload 19
    //   9539: iload_1
    //   9540: iconst_1
    //   9541: aload_0
    //   9542: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   9545: aload_0
    //   9546: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   9549: aload_0
    //   9550: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   9553: invokeinterface 244 14 0
    //   9558: goto -169 -> 9389
    //   9561: aload_0
    //   9562: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   9565: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9568: ifeq +163 -> 9731
    //   9571: ldc 225
    //   9573: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9576: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   9579: aload_0
    //   9580: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   9583: invokeinterface 230 1 0
    //   9588: aload_0
    //   9589: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   9592: ldc 234
    //   9594: aload_0
    //   9595: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   9598: lconst_0
    //   9599: lload 19
    //   9601: iload_1
    //   9602: iconst_2
    //   9603: aload_0
    //   9604: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   9607: aload_0
    //   9608: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9611: aload_0
    //   9612: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   9615: invokeinterface 244 14 0
    //   9620: ldc 116
    //   9622: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9625: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   9628: ldc2_w 123
    //   9631: ldc2_w 441
    //   9634: lconst_1
    //   9635: iconst_0
    //   9636: invokeinterface 128 8 0
    //   9641: ldc 116
    //   9643: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9646: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   9649: ldc2_w 123
    //   9652: ldc2_w 443
    //   9655: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   9658: aload_0
    //   9659: getfield 246	com/tencent/mm/plugin/appbrand/s/a/b:qka	J
    //   9662: lsub
    //   9663: iconst_0
    //   9664: invokeinterface 128 8 0
    //   9669: invokestatic 160	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   9672: invokestatic 448	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
    //   9675: istore_1
    //   9676: iload_1
    //   9677: iconst_m1
    //   9678: if_icmpne +24 -> 9702
    //   9681: ldc 116
    //   9683: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9686: checkcast 116	com/tencent/mm/plugin/appbrand/w/a
    //   9689: ldc2_w 123
    //   9692: ldc2_w 449
    //   9695: lconst_1
    //   9696: iconst_0
    //   9697: invokeinterface 128 8 0
    //   9702: ldc 130
    //   9704: ldc_w 452
    //   9707: iconst_2
    //   9708: anewarray 4	java/lang/Object
    //   9711: dup
    //   9712: iconst_0
    //   9713: aload_0
    //   9714: getfield 191	com/tencent/mm/plugin/appbrand/s/a/b:mvB	Ljava/lang/String;
    //   9717: aastore
    //   9718: dup
    //   9719: iconst_1
    //   9720: iload_1
    //   9721: invokestatic 138	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   9724: aastore
    //   9725: invokestatic 143	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9728: goto -290 -> 9438
    //   9731: ldc 225
    //   9733: invokestatic 122	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
    //   9736: checkcast 225	com/tencent/mm/plugin/appbrand/s/o
    //   9739: aload_0
    //   9740: getfield 90	com/tencent/mm/plugin/appbrand/s/a/b:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
    //   9743: invokeinterface 230 1 0
    //   9748: aload_0
    //   9749: invokespecial 232	com/tencent/mm/plugin/appbrand/s/a/b:bQF	()Ljava/lang/String;
    //   9752: ldc 234
    //   9754: aload_0
    //   9755: invokespecial 237	com/tencent/mm/plugin/appbrand/s/a/b:getUrl	()Ljava/lang/String;
    //   9758: lconst_0
    //   9759: lload 19
    //   9761: iload_1
    //   9762: iconst_2
    //   9763: aload_0
    //   9764: invokevirtual 241	com/tencent/mm/plugin/appbrand/s/a/b:cbQ	()I
    //   9767: aload_0
    //   9768: getfield 96	com/tencent/mm/plugin/appbrand/s/a/b:mhI	Ljava/lang/String;
    //   9771: aload_0
    //   9772: getfield 75	com/tencent/mm/plugin/appbrand/s/a/b:contentType	Ljava/lang/String;
    //   9775: invokeinterface 244 14 0
    //   9780: goto -160 -> 9620
    //   9783: astore 27
    //   9785: ldc 130
    //   9787: aload 27
    //   9789: ldc_w 510
    //   9792: iconst_2
    //   9793: anewarray 4	java/lang/Object
    //   9796: dup
    //   9797: iconst_0
    //   9798: aload_0
    //   9799: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9802: aastore
    //   9803: dup
    //   9804: iconst_1
    //   9805: aload_0
    //   9806: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9809: aastore
    //   9810: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9813: goto -365 -> 9448
    //   9816: astore 27
    //   9818: ldc 130
    //   9820: aload 27
    //   9822: ldc_w 510
    //   9825: iconst_2
    //   9826: anewarray 4	java/lang/Object
    //   9829: dup
    //   9830: iconst_0
    //   9831: aload_0
    //   9832: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9835: aastore
    //   9836: dup
    //   9837: iconst_1
    //   9838: aload_0
    //   9839: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9842: aastore
    //   9843: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9846: goto -388 -> 9458
    //   9849: astore 27
    //   9851: ldc 130
    //   9853: aload 27
    //   9855: ldc_w 512
    //   9858: iconst_2
    //   9859: anewarray 4	java/lang/Object
    //   9862: dup
    //   9863: iconst_0
    //   9864: aload_0
    //   9865: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9868: aastore
    //   9869: dup
    //   9870: iconst_1
    //   9871: aload_0
    //   9872: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9875: aastore
    //   9876: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9879: goto -421 -> 9458
    //   9882: astore 27
    //   9884: ldc 130
    //   9886: aload 27
    //   9888: ldc_w 514
    //   9891: iconst_2
    //   9892: anewarray 4	java/lang/Object
    //   9895: dup
    //   9896: iconst_0
    //   9897: aload_0
    //   9898: getfield 92	com/tencent/mm/plugin/appbrand/s/a/b:uri	Ljava/lang/String;
    //   9901: aastore
    //   9902: dup
    //   9903: iconst_1
    //   9904: aload_0
    //   9905: getfield 94	com/tencent/mm/plugin/appbrand/s/a/b:filename	Ljava/lang/String;
    //   9908: aastore
    //   9909: invokestatic 350	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   9912: goto -454 -> 9458
    //   9915: astore 29
    //   9917: aconst_null
    //   9918: astore 27
    //   9920: lconst_0
    //   9921: lstore 19
    //   9923: iload 12
    //   9925: istore_2
    //   9926: goto -600 -> 9326
    //   9929: astore 29
    //   9931: lconst_0
    //   9932: lstore 19
    //   9934: iload 12
    //   9936: istore_2
    //   9937: goto -611 -> 9326
    //   9940: astore 29
    //   9942: iload 12
    //   9944: istore_2
    //   9945: goto -619 -> 9326
    //   9948: astore 29
    //   9950: iload 12
    //   9952: istore_2
    //   9953: goto -627 -> 9326
    //   9956: astore 29
    //   9958: lload 21
    //   9960: lstore 19
    //   9962: iload_3
    //   9963: istore_1
    //   9964: aload 31
    //   9966: astore 27
    //   9968: aload 30
    //   9970: astore 28
    //   9972: goto -646 -> 9326
    //   9975: astore 29
    //   9977: goto -651 -> 9326
    //   9980: astore 29
    //   9982: iload_1
    //   9983: istore_3
    //   9984: iload_2
    //   9985: istore_1
    //   9986: iload_3
    //   9987: istore_2
    //   9988: goto -662 -> 9326
    //   9991: astore 29
    //   9993: aconst_null
    //   9994: astore 27
    //   9996: iload 11
    //   9998: istore 4
    //   10000: goto -1414 -> 8586
    //   10003: astore 29
    //   10005: iload 11
    //   10007: istore 4
    //   10009: goto -1423 -> 8586
    //   10012: astore 29
    //   10014: iload 11
    //   10016: istore 4
    //   10018: goto -1432 -> 8586
    //   10021: astore 29
    //   10023: iload 11
    //   10025: istore 4
    //   10027: goto -1441 -> 8586
    //   10030: astore 29
    //   10032: iload 11
    //   10034: istore 4
    //   10036: goto -1450 -> 8586
    //   10039: astore 29
    //   10041: iload_2
    //   10042: istore 4
    //   10044: goto -1458 -> 8586
    //   10047: astore 29
    //   10049: aconst_null
    //   10050: astore 27
    //   10052: iload 10
    //   10054: istore 4
    //   10056: goto -2193 -> 7863
    //   10059: astore 29
    //   10061: iload 10
    //   10063: istore 4
    //   10065: goto -2202 -> 7863
    //   10068: astore 29
    //   10070: iload 10
    //   10072: istore 4
    //   10074: goto -2211 -> 7863
    //   10077: astore 29
    //   10079: iload 10
    //   10081: istore 4
    //   10083: goto -2220 -> 7863
    //   10086: astore 29
    //   10088: iload 10
    //   10090: istore 4
    //   10092: goto -2229 -> 7863
    //   10095: astore 29
    //   10097: iload_2
    //   10098: istore 4
    //   10100: goto -2237 -> 7863
    //   10103: astore 29
    //   10105: aconst_null
    //   10106: astore 27
    //   10108: iload 9
    //   10110: istore 5
    //   10112: goto -2972 -> 7140
    //   10115: astore 29
    //   10117: iload 9
    //   10119: istore 5
    //   10121: goto -2981 -> 7140
    //   10124: astore 29
    //   10126: iload 9
    //   10128: istore 5
    //   10130: goto -2990 -> 7140
    //   10133: astore 29
    //   10135: iload 9
    //   10137: istore 5
    //   10139: goto -2999 -> 7140
    //   10142: astore 29
    //   10144: iload 9
    //   10146: istore 5
    //   10148: goto -3008 -> 7140
    //   10151: astore 29
    //   10153: iload_2
    //   10154: istore 5
    //   10156: goto -3016 -> 7140
    //   10159: astore 29
    //   10161: aconst_null
    //   10162: astore 27
    //   10164: iload 8
    //   10166: istore 4
    //   10168: goto -3751 -> 6417
    //   10171: astore 29
    //   10173: iload 8
    //   10175: istore 4
    //   10177: goto -3760 -> 6417
    //   10180: astore 29
    //   10182: iload 8
    //   10184: istore 4
    //   10186: goto -3769 -> 6417
    //   10189: astore 29
    //   10191: iload 8
    //   10193: istore 4
    //   10195: goto -3778 -> 6417
    //   10198: astore 29
    //   10200: iload 8
    //   10202: istore 4
    //   10204: goto -3787 -> 6417
    //   10207: astore 29
    //   10209: iload_2
    //   10210: istore 4
    //   10212: goto -3795 -> 6417
    //   10215: astore 29
    //   10217: aconst_null
    //   10218: astore 27
    //   10220: iconst_0
    //   10221: istore_3
    //   10222: iload_1
    //   10223: istore_2
    //   10224: iload_3
    //   10225: istore_1
    //   10226: goto -9276 -> 950
    //   10229: astore 29
    //   10231: iconst_0
    //   10232: istore_3
    //   10233: iload_1
    //   10234: istore_2
    //   10235: iload_3
    //   10236: istore_1
    //   10237: goto -9287 -> 950
    //   10240: astore 29
    //   10242: iconst_0
    //   10243: istore_3
    //   10244: iload_1
    //   10245: istore_2
    //   10246: iload_3
    //   10247: istore_1
    //   10248: goto -9298 -> 950
    //   10251: astore 29
    //   10253: iconst_0
    //   10254: istore_3
    //   10255: iload_1
    //   10256: istore_2
    //   10257: iload_3
    //   10258: istore_1
    //   10259: goto -9309 -> 950
    //   10262: astore 29
    //   10264: iconst_0
    //   10265: istore_3
    //   10266: iload_1
    //   10267: istore_2
    //   10268: iload_3
    //   10269: istore_1
    //   10270: goto -9320 -> 950
    //   10273: iload_3
    //   10274: istore_2
    //   10275: goto -6243 -> 4032
    //   10278: aconst_null
    //   10279: astore 27
    //   10281: goto -5154 -> 5127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10284	0	this	b
    //   44	10226	1	i	int
    //   217	10058	2	j	int
    //   220	10054	3	k	int
    //   223	9988	4	m	int
    //   227	9928	5	n	int
    //   231	8353	6	i1	int
    //   235	9089	7	i2	int
    //   26	10175	8	i3	int
    //   11	10134	9	i4	int
    //   14	10075	10	i5	int
    //   17	10016	11	i6	int
    //   20	9931	12	i7	int
    //   23	5512	13	i8	int
    //   29	3985	14	i9	int
    //   32	1343	15	i10	int
    //   35	1344	16	i11	int
    //   38	1345	17	i12	int
    //   41	1346	18	i13	int
    //   46	9915	19	l1	long
    //   4016	5943	21	l2	long
    //   8	5271	23	l3	long
    //   1324	3887	25	l4	long
    //   288	1764	27	localObject1	Object
    //   3208	114	27	localException1	Exception
    //   3440	5	27	localIOException1	IOException
    //   3473	5	27	localArrayIndexOutOfBoundsException1	java.lang.ArrayIndexOutOfBoundsException
    //   3506	5	27	localThrowable1	java.lang.Throwable
    //   3902	5	27	localIOException2	IOException
    //   3935	5	27	localArrayIndexOutOfBoundsException2	java.lang.ArrayIndexOutOfBoundsException
    //   3968	5	27	localThrowable2	java.lang.Throwable
    //   4011	244	27	localOutputStream	java.io.OutputStream
    //   4370	5	27	localIOException3	IOException
    //   4403	5	27	localIOException4	IOException
    //   4436	5	27	localArrayIndexOutOfBoundsException3	java.lang.ArrayIndexOutOfBoundsException
    //   4469	406	27	localThrowable3	java.lang.Throwable
    //   4990	5	27	localIOException5	IOException
    //   5023	5	27	localIOException6	IOException
    //   5056	5	27	localArrayIndexOutOfBoundsException4	java.lang.ArrayIndexOutOfBoundsException
    //   5089	442	27	localThrowable4	java.lang.Throwable
    //   5865	5	27	localIOException7	IOException
    //   5898	5	27	localIOException8	IOException
    //   5931	5	27	localArrayIndexOutOfBoundsException5	java.lang.ArrayIndexOutOfBoundsException
    //   5964	5	27	localThrowable5	java.lang.Throwable
    //   6271	5	27	localIOException9	IOException
    //   6304	5	27	localIOException10	IOException
    //   6337	5	27	localArrayIndexOutOfBoundsException6	java.lang.ArrayIndexOutOfBoundsException
    //   6370	5	27	localThrowable6	java.lang.Throwable
    //   6406	250	27	localObject2	Object
    //   6993	5	27	localIOException11	IOException
    //   7026	5	27	localIOException12	IOException
    //   7059	5	27	localArrayIndexOutOfBoundsException7	java.lang.ArrayIndexOutOfBoundsException
    //   7092	5	27	localThrowable7	java.lang.Throwable
    //   7128	251	27	localObject3	Object
    //   7716	5	27	localIOException13	IOException
    //   7749	5	27	localIOException14	IOException
    //   7782	5	27	localArrayIndexOutOfBoundsException8	java.lang.ArrayIndexOutOfBoundsException
    //   7815	5	27	localThrowable8	java.lang.Throwable
    //   7851	251	27	localObject4	Object
    //   8439	5	27	localIOException15	IOException
    //   8472	5	27	localIOException16	IOException
    //   8505	5	27	localArrayIndexOutOfBoundsException9	java.lang.ArrayIndexOutOfBoundsException
    //   8538	5	27	localThrowable9	java.lang.Throwable
    //   8574	266	27	localObject5	Object
    //   9177	5	27	localIOException17	IOException
    //   9210	5	27	localIOException18	IOException
    //   9243	5	27	localArrayIndexOutOfBoundsException10	java.lang.ArrayIndexOutOfBoundsException
    //   9276	5	27	localThrowable10	java.lang.Throwable
    //   9312	132	27	localObject6	Object
    //   9783	5	27	localIOException19	IOException
    //   9816	5	27	localIOException20	IOException
    //   9849	5	27	localArrayIndexOutOfBoundsException11	java.lang.ArrayIndexOutOfBoundsException
    //   9882	5	27	localThrowable11	java.lang.Throwable
    //   9918	362	27	localObject7	Object
    //   763	2534	28	localObject8	Object
    //   3301	1	28	localException2	Exception
    //   3334	6637	28	localObject9	Object
    //   827	100	29	localEntry	Map.Entry
    //   940	32	29	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   2831	1863	29	localq	com.tencent.mm.vfs.q
    //   5565	5	29	localIOException21	IOException
    //   5580	1	29	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   6403	72	29	localFileNotFoundException1	java.io.FileNotFoundException
    //   7125	73	29	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
    //   7848	73	29	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   8571	135	29	localException3	Exception
    //   9309	198	29	localObject10	Object
    //   9915	1	29	localObject11	Object
    //   9929	1	29	localObject12	Object
    //   9940	1	29	localObject13	Object
    //   9948	1	29	localObject14	Object
    //   9956	1	29	localObject15	Object
    //   9975	1	29	localObject16	Object
    //   9980	1	29	localObject17	Object
    //   9991	1	29	localException4	Exception
    //   10003	1	29	localException5	Exception
    //   10012	1	29	localException6	Exception
    //   10021	1	29	localException7	Exception
    //   10030	1	29	localException8	Exception
    //   10039	1	29	localException9	Exception
    //   10047	1	29	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   10059	1	29	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   10068	1	29	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   10077	1	29	localSocketTimeoutException5	java.net.SocketTimeoutException
    //   10086	1	29	localSocketTimeoutException6	java.net.SocketTimeoutException
    //   10095	1	29	localSocketTimeoutException7	java.net.SocketTimeoutException
    //   10103	1	29	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
    //   10115	1	29	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
    //   10124	1	29	localSSLHandshakeException4	javax.net.ssl.SSLHandshakeException
    //   10133	1	29	localSSLHandshakeException5	javax.net.ssl.SSLHandshakeException
    //   10142	1	29	localSSLHandshakeException6	javax.net.ssl.SSLHandshakeException
    //   10151	1	29	localSSLHandshakeException7	javax.net.ssl.SSLHandshakeException
    //   10159	1	29	localFileNotFoundException2	java.io.FileNotFoundException
    //   10171	1	29	localFileNotFoundException3	java.io.FileNotFoundException
    //   10180	1	29	localFileNotFoundException4	java.io.FileNotFoundException
    //   10189	1	29	localFileNotFoundException5	java.io.FileNotFoundException
    //   10198	1	29	localFileNotFoundException6	java.io.FileNotFoundException
    //   10207	1	29	localFileNotFoundException7	java.io.FileNotFoundException
    //   10215	1	29	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
    //   10229	1	29	localUnsupportedEncodingException4	java.io.UnsupportedEncodingException
    //   10240	1	29	localUnsupportedEncodingException5	java.io.UnsupportedEncodingException
    //   10251	1	29	localUnsupportedEncodingException6	java.io.UnsupportedEncodingException
    //   10262	1	29	localUnsupportedEncodingException7	java.io.UnsupportedEncodingException
    //   4025	5944	30	localObject18	Object
    //   5135	4830	31	localObject19	Object
    // Exception table:
    //   from	to	target	type
    //   237	256	940	java/io/UnsupportedEncodingException
    //   277	290	940	java/io/UnsupportedEncodingException
    //   311	344	940	java/io/UnsupportedEncodingException
    //   365	377	940	java/io/UnsupportedEncodingException
    //   398	408	940	java/io/UnsupportedEncodingException
    //   429	436	940	java/io/UnsupportedEncodingException
    //   457	474	940	java/io/UnsupportedEncodingException
    //   495	506	940	java/io/UnsupportedEncodingException
    //   527	535	940	java/io/UnsupportedEncodingException
    //   556	567	940	java/io/UnsupportedEncodingException
    //   588	599	940	java/io/UnsupportedEncodingException
    //   620	628	940	java/io/UnsupportedEncodingException
    //   649	662	940	java/io/UnsupportedEncodingException
    //   683	690	940	java/io/UnsupportedEncodingException
    //   711	728	940	java/io/UnsupportedEncodingException
    //   749	765	940	java/io/UnsupportedEncodingException
    //   786	796	940	java/io/UnsupportedEncodingException
    //   817	829	940	java/io/UnsupportedEncodingException
    //   850	877	940	java/io/UnsupportedEncodingException
    //   898	937	940	java/io/UnsupportedEncodingException
    //   1219	1233	940	java/io/UnsupportedEncodingException
    //   1254	1263	940	java/io/UnsupportedEncodingException
    //   1284	1295	940	java/io/UnsupportedEncodingException
    //   1316	1326	940	java/io/UnsupportedEncodingException
    //   1347	1369	940	java/io/UnsupportedEncodingException
    //   1390	1398	940	java/io/UnsupportedEncodingException
    //   1421	1443	940	java/io/UnsupportedEncodingException
    //   1459	1468	940	java/io/UnsupportedEncodingException
    //   1484	1488	940	java/io/UnsupportedEncodingException
    //   1504	1515	940	java/io/UnsupportedEncodingException
    //   1538	1578	940	java/io/UnsupportedEncodingException
    //   1594	1601	940	java/io/UnsupportedEncodingException
    //   1617	1626	940	java/io/UnsupportedEncodingException
    //   1642	1650	940	java/io/UnsupportedEncodingException
    //   1666	1672	940	java/io/UnsupportedEncodingException
    //   1688	1696	940	java/io/UnsupportedEncodingException
    //   1717	1737	940	java/io/UnsupportedEncodingException
    //   1753	1777	940	java/io/UnsupportedEncodingException
    //   2000	2034	940	java/io/UnsupportedEncodingException
    //   2050	2056	940	java/io/UnsupportedEncodingException
    //   2072	2076	940	java/io/UnsupportedEncodingException
    //   2358	2367	940	java/io/UnsupportedEncodingException
    //   2388	2395	940	java/io/UnsupportedEncodingException
    //   2411	2424	940	java/io/UnsupportedEncodingException
    //   2440	2460	940	java/io/UnsupportedEncodingException
    //   2476	2496	940	java/io/UnsupportedEncodingException
    //   2775	2791	940	java/io/UnsupportedEncodingException
    //   2804	2820	940	java/io/UnsupportedEncodingException
    //   3152	3168	940	java/io/UnsupportedEncodingException
    //   3181	3205	940	java/io/UnsupportedEncodingException
    //   3226	3240	940	java/io/UnsupportedEncodingException
    //   3253	3269	940	java/io/UnsupportedEncodingException
    //   3282	3298	940	java/io/UnsupportedEncodingException
    //   3319	3333	940	java/io/UnsupportedEncodingException
    //   3352	3361	940	java/io/UnsupportedEncodingException
    //   3377	3386	940	java/io/UnsupportedEncodingException
    //   2775	2791	3208	java/lang/Exception
    //   2804	2820	3208	java/lang/Exception
    //   3152	3168	3208	java/lang/Exception
    //   3181	3205	3208	java/lang/Exception
    //   3352	3361	3208	java/lang/Exception
    //   3253	3269	3301	java/lang/Exception
    //   3282	3298	3301	java/lang/Exception
    //   3377	3386	3301	java/lang/Exception
    //   3085	3090	3440	java/io/IOException
    //   3085	3090	3473	java/lang/ArrayIndexOutOfBoundsException
    //   3085	3090	3506	java/lang/Throwable
    //   3797	3802	3902	java/io/IOException
    //   3797	3802	3935	java/lang/ArrayIndexOutOfBoundsException
    //   3797	3802	3968	java/lang/Throwable
    //   4254	4259	4370	java/io/IOException
    //   4264	4269	4403	java/io/IOException
    //   4264	4269	4436	java/lang/ArrayIndexOutOfBoundsException
    //   4264	4269	4469	java/lang/Throwable
    //   4874	4879	4990	java/io/IOException
    //   4884	4889	5023	java/io/IOException
    //   4884	4889	5056	java/lang/ArrayIndexOutOfBoundsException
    //   4884	4889	5089	java/lang/Throwable
    //   5258	5268	5565	java/io/IOException
    //   5225	5258	5580	java/io/UnsupportedEncodingException
    //   5258	5268	5580	java/io/UnsupportedEncodingException
    //   5268	5343	5580	java/io/UnsupportedEncodingException
    //   5567	5577	5580	java/io/UnsupportedEncodingException
    //   5460	5465	5865	java/io/IOException
    //   5470	5475	5898	java/io/IOException
    //   5470	5475	5931	java/lang/ArrayIndexOutOfBoundsException
    //   5470	5475	5964	java/lang/Throwable
    //   1134	1139	6271	java/io/IOException
    //   1144	1149	6304	java/io/IOException
    //   1144	1149	6337	java/lang/ArrayIndexOutOfBoundsException
    //   1144	1149	6370	java/lang/Throwable
    //   237	256	6403	java/io/FileNotFoundException
    //   277	290	6403	java/io/FileNotFoundException
    //   311	344	6403	java/io/FileNotFoundException
    //   365	377	6403	java/io/FileNotFoundException
    //   398	408	6403	java/io/FileNotFoundException
    //   429	436	6403	java/io/FileNotFoundException
    //   457	474	6403	java/io/FileNotFoundException
    //   495	506	6403	java/io/FileNotFoundException
    //   527	535	6403	java/io/FileNotFoundException
    //   556	567	6403	java/io/FileNotFoundException
    //   588	599	6403	java/io/FileNotFoundException
    //   620	628	6403	java/io/FileNotFoundException
    //   649	662	6403	java/io/FileNotFoundException
    //   683	690	6403	java/io/FileNotFoundException
    //   711	728	6403	java/io/FileNotFoundException
    //   749	765	6403	java/io/FileNotFoundException
    //   786	796	6403	java/io/FileNotFoundException
    //   817	829	6403	java/io/FileNotFoundException
    //   850	877	6403	java/io/FileNotFoundException
    //   898	937	6403	java/io/FileNotFoundException
    //   1219	1233	6403	java/io/FileNotFoundException
    //   1254	1263	6403	java/io/FileNotFoundException
    //   1284	1295	6403	java/io/FileNotFoundException
    //   1316	1326	6403	java/io/FileNotFoundException
    //   1347	1369	6403	java/io/FileNotFoundException
    //   1390	1398	6403	java/io/FileNotFoundException
    //   1421	1443	6403	java/io/FileNotFoundException
    //   1459	1468	6403	java/io/FileNotFoundException
    //   1484	1488	6403	java/io/FileNotFoundException
    //   1504	1515	6403	java/io/FileNotFoundException
    //   1538	1578	6403	java/io/FileNotFoundException
    //   1594	1601	6403	java/io/FileNotFoundException
    //   1617	1626	6403	java/io/FileNotFoundException
    //   1642	1650	6403	java/io/FileNotFoundException
    //   1666	1672	6403	java/io/FileNotFoundException
    //   1688	1696	6403	java/io/FileNotFoundException
    //   1717	1737	6403	java/io/FileNotFoundException
    //   1753	1777	6403	java/io/FileNotFoundException
    //   2000	2034	6403	java/io/FileNotFoundException
    //   2050	2056	6403	java/io/FileNotFoundException
    //   2072	2076	6403	java/io/FileNotFoundException
    //   2358	2367	6403	java/io/FileNotFoundException
    //   2388	2395	6403	java/io/FileNotFoundException
    //   2411	2424	6403	java/io/FileNotFoundException
    //   2440	2460	6403	java/io/FileNotFoundException
    //   2476	2496	6403	java/io/FileNotFoundException
    //   2775	2791	6403	java/io/FileNotFoundException
    //   2804	2820	6403	java/io/FileNotFoundException
    //   3152	3168	6403	java/io/FileNotFoundException
    //   3181	3205	6403	java/io/FileNotFoundException
    //   3226	3240	6403	java/io/FileNotFoundException
    //   3253	3269	6403	java/io/FileNotFoundException
    //   3282	3298	6403	java/io/FileNotFoundException
    //   3319	3333	6403	java/io/FileNotFoundException
    //   3352	3361	6403	java/io/FileNotFoundException
    //   3377	3386	6403	java/io/FileNotFoundException
    //   6655	6660	6993	java/io/IOException
    //   6665	6670	7026	java/io/IOException
    //   6665	6670	7059	java/lang/ArrayIndexOutOfBoundsException
    //   6665	6670	7092	java/lang/Throwable
    //   237	256	7125	javax/net/ssl/SSLHandshakeException
    //   277	290	7125	javax/net/ssl/SSLHandshakeException
    //   311	344	7125	javax/net/ssl/SSLHandshakeException
    //   365	377	7125	javax/net/ssl/SSLHandshakeException
    //   398	408	7125	javax/net/ssl/SSLHandshakeException
    //   429	436	7125	javax/net/ssl/SSLHandshakeException
    //   457	474	7125	javax/net/ssl/SSLHandshakeException
    //   495	506	7125	javax/net/ssl/SSLHandshakeException
    //   527	535	7125	javax/net/ssl/SSLHandshakeException
    //   556	567	7125	javax/net/ssl/SSLHandshakeException
    //   588	599	7125	javax/net/ssl/SSLHandshakeException
    //   620	628	7125	javax/net/ssl/SSLHandshakeException
    //   649	662	7125	javax/net/ssl/SSLHandshakeException
    //   683	690	7125	javax/net/ssl/SSLHandshakeException
    //   711	728	7125	javax/net/ssl/SSLHandshakeException
    //   749	765	7125	javax/net/ssl/SSLHandshakeException
    //   786	796	7125	javax/net/ssl/SSLHandshakeException
    //   817	829	7125	javax/net/ssl/SSLHandshakeException
    //   850	877	7125	javax/net/ssl/SSLHandshakeException
    //   898	937	7125	javax/net/ssl/SSLHandshakeException
    //   1219	1233	7125	javax/net/ssl/SSLHandshakeException
    //   1254	1263	7125	javax/net/ssl/SSLHandshakeException
    //   1284	1295	7125	javax/net/ssl/SSLHandshakeException
    //   1316	1326	7125	javax/net/ssl/SSLHandshakeException
    //   1347	1369	7125	javax/net/ssl/SSLHandshakeException
    //   1390	1398	7125	javax/net/ssl/SSLHandshakeException
    //   1421	1443	7125	javax/net/ssl/SSLHandshakeException
    //   1459	1468	7125	javax/net/ssl/SSLHandshakeException
    //   1484	1488	7125	javax/net/ssl/SSLHandshakeException
    //   1504	1515	7125	javax/net/ssl/SSLHandshakeException
    //   1538	1578	7125	javax/net/ssl/SSLHandshakeException
    //   1594	1601	7125	javax/net/ssl/SSLHandshakeException
    //   1617	1626	7125	javax/net/ssl/SSLHandshakeException
    //   1642	1650	7125	javax/net/ssl/SSLHandshakeException
    //   1666	1672	7125	javax/net/ssl/SSLHandshakeException
    //   1688	1696	7125	javax/net/ssl/SSLHandshakeException
    //   1717	1737	7125	javax/net/ssl/SSLHandshakeException
    //   1753	1777	7125	javax/net/ssl/SSLHandshakeException
    //   2000	2034	7125	javax/net/ssl/SSLHandshakeException
    //   2050	2056	7125	javax/net/ssl/SSLHandshakeException
    //   2072	2076	7125	javax/net/ssl/SSLHandshakeException
    //   2358	2367	7125	javax/net/ssl/SSLHandshakeException
    //   2388	2395	7125	javax/net/ssl/SSLHandshakeException
    //   2411	2424	7125	javax/net/ssl/SSLHandshakeException
    //   2440	2460	7125	javax/net/ssl/SSLHandshakeException
    //   2476	2496	7125	javax/net/ssl/SSLHandshakeException
    //   2775	2791	7125	javax/net/ssl/SSLHandshakeException
    //   2804	2820	7125	javax/net/ssl/SSLHandshakeException
    //   3152	3168	7125	javax/net/ssl/SSLHandshakeException
    //   3181	3205	7125	javax/net/ssl/SSLHandshakeException
    //   3226	3240	7125	javax/net/ssl/SSLHandshakeException
    //   3253	3269	7125	javax/net/ssl/SSLHandshakeException
    //   3282	3298	7125	javax/net/ssl/SSLHandshakeException
    //   3319	3333	7125	javax/net/ssl/SSLHandshakeException
    //   3352	3361	7125	javax/net/ssl/SSLHandshakeException
    //   3377	3386	7125	javax/net/ssl/SSLHandshakeException
    //   7378	7383	7716	java/io/IOException
    //   7388	7393	7749	java/io/IOException
    //   7388	7393	7782	java/lang/ArrayIndexOutOfBoundsException
    //   7388	7393	7815	java/lang/Throwable
    //   237	256	7848	java/net/SocketTimeoutException
    //   277	290	7848	java/net/SocketTimeoutException
    //   311	344	7848	java/net/SocketTimeoutException
    //   365	377	7848	java/net/SocketTimeoutException
    //   398	408	7848	java/net/SocketTimeoutException
    //   429	436	7848	java/net/SocketTimeoutException
    //   457	474	7848	java/net/SocketTimeoutException
    //   495	506	7848	java/net/SocketTimeoutException
    //   527	535	7848	java/net/SocketTimeoutException
    //   556	567	7848	java/net/SocketTimeoutException
    //   588	599	7848	java/net/SocketTimeoutException
    //   620	628	7848	java/net/SocketTimeoutException
    //   649	662	7848	java/net/SocketTimeoutException
    //   683	690	7848	java/net/SocketTimeoutException
    //   711	728	7848	java/net/SocketTimeoutException
    //   749	765	7848	java/net/SocketTimeoutException
    //   786	796	7848	java/net/SocketTimeoutException
    //   817	829	7848	java/net/SocketTimeoutException
    //   850	877	7848	java/net/SocketTimeoutException
    //   898	937	7848	java/net/SocketTimeoutException
    //   1219	1233	7848	java/net/SocketTimeoutException
    //   1254	1263	7848	java/net/SocketTimeoutException
    //   1284	1295	7848	java/net/SocketTimeoutException
    //   1316	1326	7848	java/net/SocketTimeoutException
    //   1347	1369	7848	java/net/SocketTimeoutException
    //   1390	1398	7848	java/net/SocketTimeoutException
    //   1421	1443	7848	java/net/SocketTimeoutException
    //   1459	1468	7848	java/net/SocketTimeoutException
    //   1484	1488	7848	java/net/SocketTimeoutException
    //   1504	1515	7848	java/net/SocketTimeoutException
    //   1538	1578	7848	java/net/SocketTimeoutException
    //   1594	1601	7848	java/net/SocketTimeoutException
    //   1617	1626	7848	java/net/SocketTimeoutException
    //   1642	1650	7848	java/net/SocketTimeoutException
    //   1666	1672	7848	java/net/SocketTimeoutException
    //   1688	1696	7848	java/net/SocketTimeoutException
    //   1717	1737	7848	java/net/SocketTimeoutException
    //   1753	1777	7848	java/net/SocketTimeoutException
    //   2000	2034	7848	java/net/SocketTimeoutException
    //   2050	2056	7848	java/net/SocketTimeoutException
    //   2072	2076	7848	java/net/SocketTimeoutException
    //   2358	2367	7848	java/net/SocketTimeoutException
    //   2388	2395	7848	java/net/SocketTimeoutException
    //   2411	2424	7848	java/net/SocketTimeoutException
    //   2440	2460	7848	java/net/SocketTimeoutException
    //   2476	2496	7848	java/net/SocketTimeoutException
    //   2775	2791	7848	java/net/SocketTimeoutException
    //   2804	2820	7848	java/net/SocketTimeoutException
    //   3152	3168	7848	java/net/SocketTimeoutException
    //   3181	3205	7848	java/net/SocketTimeoutException
    //   3226	3240	7848	java/net/SocketTimeoutException
    //   3253	3269	7848	java/net/SocketTimeoutException
    //   3282	3298	7848	java/net/SocketTimeoutException
    //   3319	3333	7848	java/net/SocketTimeoutException
    //   3352	3361	7848	java/net/SocketTimeoutException
    //   3377	3386	7848	java/net/SocketTimeoutException
    //   8101	8106	8439	java/io/IOException
    //   8111	8116	8472	java/io/IOException
    //   8111	8116	8505	java/lang/ArrayIndexOutOfBoundsException
    //   8111	8116	8538	java/lang/Throwable
    //   237	256	8571	java/lang/Exception
    //   277	290	8571	java/lang/Exception
    //   311	344	8571	java/lang/Exception
    //   365	377	8571	java/lang/Exception
    //   398	408	8571	java/lang/Exception
    //   429	436	8571	java/lang/Exception
    //   457	474	8571	java/lang/Exception
    //   495	506	8571	java/lang/Exception
    //   527	535	8571	java/lang/Exception
    //   556	567	8571	java/lang/Exception
    //   588	599	8571	java/lang/Exception
    //   620	628	8571	java/lang/Exception
    //   649	662	8571	java/lang/Exception
    //   683	690	8571	java/lang/Exception
    //   711	728	8571	java/lang/Exception
    //   749	765	8571	java/lang/Exception
    //   786	796	8571	java/lang/Exception
    //   817	829	8571	java/lang/Exception
    //   850	877	8571	java/lang/Exception
    //   898	937	8571	java/lang/Exception
    //   1219	1233	8571	java/lang/Exception
    //   1254	1263	8571	java/lang/Exception
    //   1284	1295	8571	java/lang/Exception
    //   1316	1326	8571	java/lang/Exception
    //   1347	1369	8571	java/lang/Exception
    //   1390	1398	8571	java/lang/Exception
    //   1421	1443	8571	java/lang/Exception
    //   1459	1468	8571	java/lang/Exception
    //   1484	1488	8571	java/lang/Exception
    //   1504	1515	8571	java/lang/Exception
    //   1538	1578	8571	java/lang/Exception
    //   1594	1601	8571	java/lang/Exception
    //   1617	1626	8571	java/lang/Exception
    //   1642	1650	8571	java/lang/Exception
    //   1666	1672	8571	java/lang/Exception
    //   1688	1696	8571	java/lang/Exception
    //   1717	1737	8571	java/lang/Exception
    //   1753	1777	8571	java/lang/Exception
    //   2000	2034	8571	java/lang/Exception
    //   2050	2056	8571	java/lang/Exception
    //   2072	2076	8571	java/lang/Exception
    //   2358	2367	8571	java/lang/Exception
    //   2388	2395	8571	java/lang/Exception
    //   2411	2424	8571	java/lang/Exception
    //   2440	2460	8571	java/lang/Exception
    //   2476	2496	8571	java/lang/Exception
    //   3226	3240	8571	java/lang/Exception
    //   3319	3333	8571	java/lang/Exception
    //   8839	8844	9177	java/io/IOException
    //   8849	8854	9210	java/io/IOException
    //   8849	8854	9243	java/lang/ArrayIndexOutOfBoundsException
    //   8849	8854	9276	java/lang/Throwable
    //   237	256	9309	finally
    //   277	290	9309	finally
    //   311	344	9309	finally
    //   365	377	9309	finally
    //   398	408	9309	finally
    //   429	436	9309	finally
    //   457	474	9309	finally
    //   495	506	9309	finally
    //   527	535	9309	finally
    //   556	567	9309	finally
    //   588	599	9309	finally
    //   620	628	9309	finally
    //   649	662	9309	finally
    //   683	690	9309	finally
    //   711	728	9309	finally
    //   749	765	9309	finally
    //   786	796	9309	finally
    //   817	829	9309	finally
    //   850	877	9309	finally
    //   898	937	9309	finally
    //   1219	1233	9309	finally
    //   1254	1263	9309	finally
    //   1284	1295	9309	finally
    //   1316	1326	9309	finally
    //   1347	1369	9309	finally
    //   1390	1398	9309	finally
    //   1421	1443	9309	finally
    //   1459	1468	9309	finally
    //   1484	1488	9309	finally
    //   1504	1515	9309	finally
    //   1538	1578	9309	finally
    //   1594	1601	9309	finally
    //   1617	1626	9309	finally
    //   1642	1650	9309	finally
    //   1666	1672	9309	finally
    //   1688	1696	9309	finally
    //   1717	1737	9309	finally
    //   1753	1777	9309	finally
    //   2000	2034	9309	finally
    //   2050	2056	9309	finally
    //   2072	2076	9309	finally
    //   2358	2367	9309	finally
    //   2388	2395	9309	finally
    //   2411	2424	9309	finally
    //   2440	2460	9309	finally
    //   2476	2496	9309	finally
    //   2775	2791	9309	finally
    //   2804	2820	9309	finally
    //   3152	3168	9309	finally
    //   3181	3205	9309	finally
    //   3226	3240	9309	finally
    //   3253	3269	9309	finally
    //   3282	3298	9309	finally
    //   3319	3333	9309	finally
    //   3352	3361	9309	finally
    //   3377	3386	9309	finally
    //   9443	9448	9783	java/io/IOException
    //   9453	9458	9816	java/io/IOException
    //   9453	9458	9849	java/lang/ArrayIndexOutOfBoundsException
    //   9453	9458	9882	java/lang/Throwable
    //   2820	2914	9915	finally
    //   3539	3626	9915	finally
    //   4006	4013	9915	finally
    //   4018	4027	9929	finally
    //   4032	4040	9940	finally
    //   4045	4082	9940	finally
    //   4502	4511	9940	finally
    //   5122	5127	9940	finally
    //   4529	4548	9948	finally
    //   4556	4575	9948	finally
    //   4578	4614	9948	finally
    //   4621	4702	9948	finally
    //   5144	5151	9956	finally
    //   5168	5193	9956	finally
    //   5210	5223	9956	finally
    //   5541	5560	9956	finally
    //   6434	6455	9956	finally
    //   6472	6500	9956	finally
    //   6517	6537	9956	finally
    //   7157	7178	9956	finally
    //   7195	7223	9956	finally
    //   7240	7260	9956	finally
    //   7880	7901	9956	finally
    //   7918	7946	9956	finally
    //   7963	7983	9956	finally
    //   8603	8624	9956	finally
    //   8641	8669	9956	finally
    //   8686	8721	9956	finally
    //   5225	5258	9975	finally
    //   5258	5268	9975	finally
    //   5268	5343	9975	finally
    //   5567	5577	9975	finally
    //   950	1017	9980	finally
    //   2820	2914	9991	java/lang/Exception
    //   3539	3626	9991	java/lang/Exception
    //   4006	4013	9991	java/lang/Exception
    //   4018	4027	10003	java/lang/Exception
    //   4032	4040	10012	java/lang/Exception
    //   4045	4082	10012	java/lang/Exception
    //   4502	4511	10012	java/lang/Exception
    //   5122	5127	10012	java/lang/Exception
    //   4529	4548	10021	java/lang/Exception
    //   4556	4575	10021	java/lang/Exception
    //   4578	4614	10021	java/lang/Exception
    //   4621	4702	10021	java/lang/Exception
    //   5144	5151	10030	java/lang/Exception
    //   5168	5193	10030	java/lang/Exception
    //   5210	5223	10030	java/lang/Exception
    //   5541	5560	10030	java/lang/Exception
    //   5225	5258	10039	java/lang/Exception
    //   5258	5268	10039	java/lang/Exception
    //   5268	5343	10039	java/lang/Exception
    //   5567	5577	10039	java/lang/Exception
    //   2820	2914	10047	java/net/SocketTimeoutException
    //   3539	3626	10047	java/net/SocketTimeoutException
    //   4006	4013	10047	java/net/SocketTimeoutException
    //   4018	4027	10059	java/net/SocketTimeoutException
    //   4032	4040	10068	java/net/SocketTimeoutException
    //   4045	4082	10068	java/net/SocketTimeoutException
    //   4502	4511	10068	java/net/SocketTimeoutException
    //   5122	5127	10068	java/net/SocketTimeoutException
    //   4529	4548	10077	java/net/SocketTimeoutException
    //   4556	4575	10077	java/net/SocketTimeoutException
    //   4578	4614	10077	java/net/SocketTimeoutException
    //   4621	4702	10077	java/net/SocketTimeoutException
    //   5144	5151	10086	java/net/SocketTimeoutException
    //   5168	5193	10086	java/net/SocketTimeoutException
    //   5210	5223	10086	java/net/SocketTimeoutException
    //   5541	5560	10086	java/net/SocketTimeoutException
    //   5225	5258	10095	java/net/SocketTimeoutException
    //   5258	5268	10095	java/net/SocketTimeoutException
    //   5268	5343	10095	java/net/SocketTimeoutException
    //   5567	5577	10095	java/net/SocketTimeoutException
    //   2820	2914	10103	javax/net/ssl/SSLHandshakeException
    //   3539	3626	10103	javax/net/ssl/SSLHandshakeException
    //   4006	4013	10103	javax/net/ssl/SSLHandshakeException
    //   4018	4027	10115	javax/net/ssl/SSLHandshakeException
    //   4032	4040	10124	javax/net/ssl/SSLHandshakeException
    //   4045	4082	10124	javax/net/ssl/SSLHandshakeException
    //   4502	4511	10124	javax/net/ssl/SSLHandshakeException
    //   5122	5127	10124	javax/net/ssl/SSLHandshakeException
    //   4529	4548	10133	javax/net/ssl/SSLHandshakeException
    //   4556	4575	10133	javax/net/ssl/SSLHandshakeException
    //   4578	4614	10133	javax/net/ssl/SSLHandshakeException
    //   4621	4702	10133	javax/net/ssl/SSLHandshakeException
    //   5144	5151	10142	javax/net/ssl/SSLHandshakeException
    //   5168	5193	10142	javax/net/ssl/SSLHandshakeException
    //   5210	5223	10142	javax/net/ssl/SSLHandshakeException
    //   5541	5560	10142	javax/net/ssl/SSLHandshakeException
    //   5225	5258	10151	javax/net/ssl/SSLHandshakeException
    //   5258	5268	10151	javax/net/ssl/SSLHandshakeException
    //   5268	5343	10151	javax/net/ssl/SSLHandshakeException
    //   5567	5577	10151	javax/net/ssl/SSLHandshakeException
    //   2820	2914	10159	java/io/FileNotFoundException
    //   3539	3626	10159	java/io/FileNotFoundException
    //   4006	4013	10159	java/io/FileNotFoundException
    //   4018	4027	10171	java/io/FileNotFoundException
    //   4032	4040	10180	java/io/FileNotFoundException
    //   4045	4082	10180	java/io/FileNotFoundException
    //   4502	4511	10180	java/io/FileNotFoundException
    //   5122	5127	10180	java/io/FileNotFoundException
    //   4529	4548	10189	java/io/FileNotFoundException
    //   4556	4575	10189	java/io/FileNotFoundException
    //   4578	4614	10189	java/io/FileNotFoundException
    //   4621	4702	10189	java/io/FileNotFoundException
    //   5144	5151	10198	java/io/FileNotFoundException
    //   5168	5193	10198	java/io/FileNotFoundException
    //   5210	5223	10198	java/io/FileNotFoundException
    //   5541	5560	10198	java/io/FileNotFoundException
    //   5225	5258	10207	java/io/FileNotFoundException
    //   5258	5268	10207	java/io/FileNotFoundException
    //   5268	5343	10207	java/io/FileNotFoundException
    //   5567	5577	10207	java/io/FileNotFoundException
    //   2820	2914	10215	java/io/UnsupportedEncodingException
    //   3539	3626	10215	java/io/UnsupportedEncodingException
    //   4006	4013	10215	java/io/UnsupportedEncodingException
    //   4018	4027	10229	java/io/UnsupportedEncodingException
    //   4032	4040	10240	java/io/UnsupportedEncodingException
    //   4045	4082	10240	java/io/UnsupportedEncodingException
    //   4502	4511	10240	java/io/UnsupportedEncodingException
    //   5122	5127	10240	java/io/UnsupportedEncodingException
    //   4529	4548	10251	java/io/UnsupportedEncodingException
    //   4556	4575	10251	java/io/UnsupportedEncodingException
    //   4578	4614	10251	java/io/UnsupportedEncodingException
    //   4621	4702	10251	java/io/UnsupportedEncodingException
    //   5144	5151	10262	java/io/UnsupportedEncodingException
    //   5168	5193	10262	java/io/UnsupportedEncodingException
    //   5210	5223	10262	java/io/UnsupportedEncodingException
    //   5541	5560	10262	java/io/UnsupportedEncodingException
  }
  
  static String eN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(144469);
    paramString1 = MimeTypeUtil.ContentType.obtain(paramString1);
    if (paramString1 == null)
    {
      paramString1 = MimeTypeUtil.getMimeTypeByFilePath(paramString2);
      AppMethodBeat.o(144469);
      return paramString1;
    }
    if (paramString1.mimeType.contains("application/octet-stream"))
    {
      paramString2 = MimeTypeUtil.getMimeTypeByFilePath(paramString2);
      if (Util.isNullOrNil(paramString2))
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
  
  public final int cbQ()
  {
    AppMethodBeat.i(144472);
    int i = (int)(System.currentTimeMillis() - this.startTime);
    AppMethodBeat.o(144472);
    return i;
  }
  
  public final void cce()
  {
    AppMethodBeat.i(144468);
    this.isRunning = false;
    if (this.conn != null) {}
    try
    {
      this.conn.getInputStream().close();
      this.conn.disconnect();
      if (!Util.isNullOrNil(this.qkb)) {
        CronetLogic.cancelCronetTask(this.qkb);
      }
      AppMethodBeat.o(144468);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.AppBrandDownloadWorker", localIOException.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", localException, "abortTask Exception", new Object[0]);
      }
    }
  }
  
  public final void run()
  {
    AppMethodBeat.i(144466);
    if ((!URLUtil.isHttpsUrl(this.uri)) && (!URLUtil.isHttpUrl(this.uri)))
    {
      this.qjX.J(this.filename, this.uri, "downloadFile protocol must be http or https");
      AppMethodBeat.o(144466);
      return;
    }
    Object localObject1;
    if ((this.qjb != null) && (!j.b(this.qjb, this.uri)))
    {
      localObject1 = null;
      try
      {
        String str = new URL(this.uri).getHost();
        localObject1 = str;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.AppBrandDownloadWorker", localMalformedURLException, "get redirect url host fail Exception", new Object[0]);
          continue;
          this.qjX.J(this.filename, this.uri, "redirect url not in domain list");
        }
      }
      if (!Util.isNullOrNil((String)localObject1))
      {
        this.qjX.J(this.filename, this.uri, "redirect url not in domain list:".concat(String.valueOf(localObject1)));
        this.qjX.J(this.filename, this.uri, "redirect url not in domain list");
        Log.i("MicroMsg.AppBrandDownloadWorker", "not in domain url %s", new Object[] { this.uri });
        AppMethodBeat.o(144466);
        return;
      }
    }
    if (this.peH)
    {
      final long l = System.currentTimeMillis();
      Object localObject2 = new a();
      if (!this.isRunning)
      {
        this.qjX.J(this.filename, this.uri, "force stop");
        if (Util.isNullOrNil(this.mhI))
        {
          ((o)com.tencent.luggage.a.e.L(o.class)).a(this.okQ.getAppId(), this.qjg, "GET", this.uri, 0L, 0L, 0, 2, cbQ(), this.filename, this.contentType);
          AppMethodBeat.o(144466);
          return;
        }
        ((o)com.tencent.luggage.a.e.L(o.class)).a(this.okQ.getAppId(), this.qjg, "GET", this.uri, 0L, 0L, 0, 2, cbQ(), this.mhI, this.contentType);
        AppMethodBeat.o(144466);
        return;
      }
      this.qka = System.currentTimeMillis();
      this.qjX.eM(this.filename, this.uri);
      ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 0L, 1L, false);
      Log.i("MicroMsg.AppBrandDownloadWorker", "downloadCronetFile prepare to start download taskid is %s, usehttp2 is %b, usequic is %b, usecache is %b, url is %s, filename is %s", new Object[] { this.mvB, Boolean.valueOf(this.mvK), Boolean.valueOf(this.mvL), Boolean.valueOf(this.qji), this.uri, this.filename });
      localObject1 = new com.tencent.e.i.b()
      {
        public final String getKey()
        {
          return "AppBrandDownloadWorker#TimerTask";
        }
        
        public final void run()
        {
          AppMethodBeat.i(175396);
          Log.e("MicroMsg.AppBrandDownloadWorker", "call cronet time out taskid:%s,timeout:%d,url:%s", new Object[] { b.this.mvB, Integer.valueOf(b.this.timeout), b.this.uri });
          if (!b.this.qjh)
          {
            b.this.qjh = true;
            b.this.qjX.J(b.this.filename, b.this.uri, "socket timeout");
          }
          for (;;)
          {
            ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 6L, 1L, false);
            if (!Util.isNullOrNil(b.this.qkb)) {
              CronetLogic.cancelCronetTask(b.this.qkb);
            }
            AppMethodBeat.o(175396);
            return;
            Log.e("MicroMsg.AppBrandDownloadWorker", "call cronet time out already callback");
          }
        }
      };
      localObject2 = new CronetLogic.CronetTaskCallback()
      {
        public final int onCronetReceiveHeader(CronetLogic.ResponseHeader paramAnonymousResponseHeader, int paramAnonymousInt, String paramAnonymousString)
        {
          AppMethodBeat.i(187253);
          Log.i("MicroMsg.AppBrandDownloadWorker", "cronet file download onCronetReceiveHeader status %d,taskid:%s,CronetRequestId:%s", new Object[] { Integer.valueOf(paramAnonymousInt), b.h(b.this), b.g(b.this) });
          paramAnonymousResponseHeader = CronetLogic.getHeaderList(paramAnonymousResponseHeader);
          paramAnonymousString = j.c(paramAnonymousResponseHeader, 2);
          b.f(b.this).M(paramAnonymousString);
          paramAnonymousResponseHeader = paramAnonymousResponseHeader.entrySet().iterator();
          Object localObject;
          for (;;)
          {
            if (paramAnonymousResponseHeader.hasNext())
            {
              localObject = (Map.Entry)paramAnonymousResponseHeader.next();
              paramAnonymousString = (String)((Map.Entry)localObject).getKey();
              localObject = (List)((Map.Entry)localObject).getValue();
              if ((!Util.isNullOrNil(paramAnonymousString)) && (localObject != null) && (!((List)localObject).isEmpty())) {
                if (paramAnonymousString.equals("Content-Length"))
                {
                  Log.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader Content-Length:%s", new Object[] { ((List)localObject).get(0) });
                  paramAnonymousInt = Integer.parseInt((String)((List)localObject).get(0));
                }
              }
            }
          }
          for (;;)
          {
            label190:
            if (paramAnonymousInt > 0)
            {
              ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 16L, paramAnonymousInt, false);
              label216:
              if ((paramAnonymousInt <= 0) || (b.i(b.this) <= 0) || (paramAnonymousInt < b.i(b.this) * 1048576)) {
                break label406;
              }
              Log.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader before actually read stream, contentLength %d exceed limit", new Object[] { Integer.valueOf(paramAnonymousInt) });
              if (b.b(b.this)) {
                break label396;
              }
              b.c(b.this);
              b.f(b.this).J(b.d(b.this), b.e(b.this), "exceed max file size");
            }
            for (;;)
            {
              if (this.qkd != null)
              {
                this.qkd.cancel();
                Log.i("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader exceed max file size TimerTask cancel");
              }
              AppMethodBeat.o(187253);
              return -1;
              if (!paramAnonymousString.equals("content-length")) {
                break;
              }
              Log.i("MicroMsg.AppBrandDownloadWorker", "onCronetReceiveHeader content-length:%s", new Object[] { ((List)localObject).get(0) });
              paramAnonymousInt = Integer.parseInt((String)((List)localObject).get(0));
              break label190;
              Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader contentLength fail");
              break label216;
              label396:
              Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetReceiveHeader max file size already callback");
            }
            label406:
            AppMethodBeat.o(187253);
            return 0;
            paramAnonymousInt = 0;
          }
        }
        
        public final void onCronetTaskCompleted(String paramAnonymousString1, final CronetLogic.CronetTaskResult paramAnonymousCronetTaskResult, String paramAnonymousString2)
        {
          AppMethodBeat.i(187257);
          Log.i("MicroMsg.AppBrandDownloadWorker", "onCronetTaskCompleted errorCode:%d,errorMsg:%s,statusCode:%d,totalReceiveByte:%d,taskid:%s,CronetRequestId:%s,fileKey:%s", new Object[] { Integer.valueOf(paramAnonymousCronetTaskResult.errorCode), paramAnonymousCronetTaskResult.errorMsg, Integer.valueOf(paramAnonymousCronetTaskResult.statusCode), Long.valueOf(paramAnonymousCronetTaskResult.totalReceiveByte), b.h(b.this), b.g(b.this), paramAnonymousString1 });
          if (this.qkd != null) {
            this.qkd.cancel();
          }
          h.ZvG.be(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175397);
              int j = (int)paramAnonymousCronetTaskResult.totalReceiveByte;
              int k = paramAnonymousCronetTaskResult.statusCode;
              Log.i("MicroMsg.AppBrandDownloadWorker", "appbrand_cronetdownload_callback_thread run taskid:%s,CronetRequestId:%s", new Object[] { b.this.mvB, b.this.qkb });
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
                  ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, i, 1L, false);
                  Log.i("MicroMsg.AppBrandDownloadWorker", "reportCronetStatusCode:%d, key:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
                  localObject1 = paramAnonymousCronetTaskResult.getHeaderMap().entrySet().iterator();
                  Object localObject3;
                  for (str = ""; ((Iterator)localObject1).hasNext(); str = b.eN((String)localObject3, b.this.uri))
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
                  Log.e("MicroMsg.AppBrandDownloadWorker", "failed code: %d,url is %s,filename is %s ", new Object[] { Integer.valueOf(k), b.this.uri, b.this.filename });
                  if (j.uO(k))
                  {
                    localObject1 = paramAnonymousCronetTaskResult.newLocation;
                    if (!TextUtils.isEmpty((CharSequence)localObject1))
                    {
                      localObject2 = b.this;
                      i = ((b)localObject2).qjc;
                      ((b)localObject2).qjc = (i - 1);
                      if (i <= 0)
                      {
                        Log.w("MicroMsg.AppBrandDownloadWorker", "reach the max redirect count(%d)", new Object[] { Integer.valueOf(15) });
                        if (!b.this.qjh)
                        {
                          b.this.qjh = true;
                          if (b.this.qjj) {
                            b.this.qjX.a(b.this.filename, str, b.this.uri, k, 0L, j.a(paramAnonymousCronetTaskResult.webPageProfile));
                          }
                          for (;;)
                          {
                            ((o)com.tencent.luggage.a.e.L(o.class)).a(b.this.okQ.getAppId(), b.this.qjg, "GET", b.this.uri, 0L, j, k, 1, b.this.cbQ(), b.this.filename, str);
                            ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 10L, 1L, false);
                            ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 12L, System.currentTimeMillis() - b.this.qka, false);
                            AppMethodBeat.o(175397);
                            return;
                            b.this.qjX.a(b.this.filename, str, b.this.uri, k, 0L, null);
                          }
                        }
                        Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted max redirect already callback");
                        AppMethodBeat.o(175397);
                        return;
                      }
                      Log.i("MicroMsg.AppBrandDownloadWorker", "redirect(%d) URL(%s) to URL(%s)", new Object[] { Integer.valueOf(b.this.qjc), b.this.uri, localObject1 });
                      b.this.uri = ((String)localObject1);
                      b.this.run();
                      AppMethodBeat.o(175397);
                      return;
                    }
                  }
                }
                if (!b.this.qjh)
                {
                  b.this.qjh = true;
                  long l1;
                  long l2;
                  if (b.this.isRunning) {
                    if (b.this.qjj)
                    {
                      b.this.qjX.a(b.this.filename, str, b.this.uri, k, j, j.a(paramAnonymousCronetTaskResult.webPageProfile));
                      l1 = paramAnonymousCronetTaskResult.totalReceiveByte;
                      l2 = System.currentTimeMillis() - b.this.qka;
                      if ((l1 > 0L) && (l2 > 0L)) {
                        break label1382;
                      }
                      Log.i("MicroMsg.AppBrandDownloadWorker", "reportCronetSpeed len:%d, time:%d return", new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
                      b.2.this.qke.success = true;
                    }
                  }
                  for (;;)
                  {
                    Log.i("MicroMsg.AppBrandDownloadWorker", "cronet download file finished taskid:%s,CronetRequestId:%s,contentType:%s,filename: %s, url:%s ", new Object[] { b.this.mvB, b.this.qkb, str, b.this.filename, b.this.uri });
                    b.this.qjX.akO(b.this.mvB);
                    ((o)com.tencent.luggage.a.e.L(o.class)).a(b.this.okQ.getAppId(), b.this.qjg, "GET", b.this.uri, 0L, j, k, 1, b.this.cbQ(), b.this.filename, str);
                    ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 10L, 1L, false);
                    ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 12L, System.currentTimeMillis() - b.this.qka, false);
                    l1 = System.currentTimeMillis() - b.2.this.val$startTime;
                    Log.i("cronet download time", "request time is ".concat(String.valueOf(l1)));
                    ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1199L, 99L, l1, false);
                    ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1199L, 97L, 1L, false);
                    AppMethodBeat.o(175397);
                    return;
                    b.this.qjX.a(b.this.filename, str, b.this.uri, k, j, null);
                    break;
                    label1382:
                    i = 34;
                    double d = l1 / l2 * 0.9765625D;
                    if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                      i = 30;
                    }
                    for (;;)
                    {
                      ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, i, d, false);
                      Log.i("MicroMsg.AppBrandDownloadWorker", "reportCronetSpeed len:%d, time:%d, speed:%f, key:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Double.valueOf(d), Integer.valueOf(i) });
                      break;
                      if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                        i = 31;
                      } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
                        i = 32;
                      } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                        i = 33;
                      }
                    }
                    b.this.qjX.J(b.this.filename, b.this.uri, "force stop");
                  }
                }
                Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted already callback");
                AppMethodBeat.o(175397);
                return;
              }
              if (!b.this.qjh)
              {
                b.this.qjh = true;
                b.this.qjX.J(b.this.filename, b.this.uri, "download fail:" + paramAnonymousCronetTaskResult.errorCode + ":" + paramAnonymousCronetTaskResult.errorMsg);
                ((o)com.tencent.luggage.a.e.L(o.class)).a(b.this.okQ.getAppId(), b.this.qjg, "GET", b.this.uri, 0L, j, k, 2, b.this.cbQ(), b.this.filename, "");
                ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 11L, 1L, false);
                ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 13L, System.currentTimeMillis() - b.this.qka, false);
                i = NetStatusUtil.getNetType(MMApplicationContext.getContext());
                if (i == -1) {
                  ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 7L, 1L, false);
                }
                Log.i("MicroMsg.AppBrandDownloadWorker", "cronet downloadFile fail ret:%d", new Object[] { Integer.valueOf(i) });
                AppMethodBeat.o(175397);
                return;
              }
              Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onCronetTaskCompleted downloadFile fail already callback");
              AppMethodBeat.o(175397);
            }
          });
          AppMethodBeat.o(187257);
        }
        
        public final void onDownloadProgressChanged(String paramAnonymousString, CronetLogic.CronetDownloadProgress paramAnonymousCronetDownloadProgress)
        {
          AppMethodBeat.i(175398);
          if (j.L(b.this.okQ))
          {
            Log.w("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged shouldStopTask fileKey:%s,taskid %s,CronetRequestId:%s", new Object[] { paramAnonymousString, b.h(b.this), b.g(b.this) });
            if (!b.b(b.this))
            {
              b.c(b.this);
              CronetLogic.cancelCronetTask(b.g(b.this));
              b.f(b.this).J(b.d(b.this), b.e(b.this), "interrupted");
            }
            for (;;)
            {
              if (this.qkd != null)
              {
                this.qkd.cancel();
                Log.i("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged shouldStopTask TimerTask cancel");
              }
              AppMethodBeat.o(175398);
              return;
              Log.e("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged already callback");
            }
          }
          if ((paramAnonymousCronetDownloadProgress.currentWriteByte > 0L) && (b.i(b.this) > 0) && (paramAnonymousCronetDownloadProgress.currentWriteByte >= b.i(b.this) * 1048576))
          {
            if (!b.b(b.this))
            {
              Log.i("MicroMsg.AppBrandDownloadWorker", "onDownloadProgressChanged currentWriteByte %d exceed limit,fileKey:%s,taskid %s,CronetRequestId:%s", new Object[] { Long.valueOf(paramAnonymousCronetDownloadProgress.currentWriteByte), paramAnonymousString, b.h(b.this), b.g(b.this) });
              b.c(b.this);
              CronetLogic.cancelCronetTask(b.g(b.this));
              b.f(b.this).J(b.d(b.this), b.e(b.this), "exceed max file size");
              if (this.qkd != null)
              {
                this.qkd.cancel();
                Log.i("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged exceed max file size TimerTask cancel");
              }
              AppMethodBeat.o(175398);
              return;
            }
            Log.e("MicroMsg.AppBrandDownloadWorker", "cronet onDownloadProgressChanged max file size already callback");
            AppMethodBeat.o(175398);
            return;
          }
          if ((paramAnonymousCronetDownloadProgress.totalByte > 0L) && (b.j(b.this)))
          {
            if (paramAnonymousCronetDownloadProgress.totalByte <= 0L) {
              break label545;
            }
            if (paramAnonymousCronetDownloadProgress.currentWriteByte <= paramAnonymousCronetDownloadProgress.totalByte) {
              break label521;
            }
            this.qke.percent = 100;
            if (this.qke.muD != this.qke.percent)
            {
              paramAnonymousString = b.f(b.this);
              b.d(b.this);
              paramAnonymousString.a(b.e(b.this), this.qke.percent, paramAnonymousCronetDownloadProgress.currentWriteByte, paramAnonymousCronetDownloadProgress.totalByte);
              this.qke.muD = this.qke.percent;
            }
          }
          for (;;)
          {
            if (this.qke.percent == 100) {
              Log.i("MicroMsg.AppBrandDownloadWorker", "cronet download size %d, totalSize %d, percent = %d", new Object[] { Long.valueOf(paramAnonymousCronetDownloadProgress.currentWriteByte), Long.valueOf(paramAnonymousCronetDownloadProgress.totalByte), Integer.valueOf(this.qke.percent) });
            }
            AppMethodBeat.o(175398);
            return;
            label521:
            this.qke.percent = ((int)(paramAnonymousCronetDownloadProgress.currentWriteByte * 100L / paramAnonymousCronetDownloadProgress.totalByte));
            break;
            label545:
            paramAnonymousString = b.f(b.this);
            b.d(b.this);
            paramAnonymousString.a(b.e(b.this), this.qke.percent, paramAnonymousCronetDownloadProgress.currentWriteByte, 0L);
          }
        }
      };
      CronetLogic.CronetRequestParams localCronetRequestParams = new CronetLogic.CronetRequestParams();
      localCronetRequestParams.url = this.uri;
      localCronetRequestParams.taskId = this.mvB;
      localCronetRequestParams.followRedirect = false;
      localCronetRequestParams.savePath = this.filename;
      localCronetRequestParams.method = "GET";
      localCronetRequestParams.needWirteCache = true;
      localCronetRequestParams.useHttp2 = this.mvK;
      localCronetRequestParams.useQuic = this.mvL;
      localCronetRequestParams.useMemoryCache = this.qji;
      Object localObject3 = this.qjY;
      if (!((Map)localObject3).containsKey("Accept-Encoding")) {
        ((Map)localObject3).put("Accept-Encoding", "gzip,compress,br,deflate");
      }
      for (;;)
      {
        ((Map)localObject3).put("User-Agent", this.pFt);
        localCronetRequestParams.makeRequestHeader((Map)localObject3);
        localObject3 = j.c(j.Q((Map)localObject3), 1);
        this.qjX.M((JSONObject)localObject3);
        localCronetRequestParams.taskType = 2;
        h.ZvG.o((Runnable)localObject1, this.timeout);
        Log.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest taskId:%s", new Object[] { localCronetRequestParams.taskId });
        localObject1 = CronetLogic.startCronetDownloadTask(localCronetRequestParams, (CronetLogic.CronetTaskCallback)localObject2);
        Log.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest createRet is %d, taskId %s,CronetRequestId:%s", new Object[] { Integer.valueOf(((CronetLogic.CronetHttpsCreateResult)localObject1).createRet), this.mvB, ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId });
        if ((localObject1 == null) || (((CronetLogic.CronetHttpsCreateResult)localObject1).createRet == 0)) {
          break;
        }
        ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 1L, 1L, false);
        AppMethodBeat.o(144466);
        return;
        Log.i("MicroMsg.AppBrandDownloadWorker", "startCronetHttpsRequest Accept-Encoding:%s", new Object[] { ((Map)localObject3).get("Accept-Encoding") });
      }
      this.qkb = ((CronetLogic.CronetHttpsCreateResult)localObject1).taskId;
      ((com.tencent.mm.plugin.appbrand.w.a)com.tencent.luggage.a.e.L(com.tencent.mm.plugin.appbrand.w.a.class)).idkeyStat(1197L, 2L, 1L, false);
      AppMethodBeat.o(144466);
      return;
    }
    ccd();
    AppMethodBeat.o(144466);
  }
  
  final class a
  {
    public int muD = -1;
    public int percent = 0;
    public boolean success = false;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.b
 * JD-Core Version:    0.7.0.1
 */