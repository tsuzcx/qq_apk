package com.tencent.mm.plugin.appbrand.s;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class g
{
  e okQ;
  final String pFt;
  SSLContext qiA;
  protected final ArrayList<String> qiB;
  private int qjn;
  public final ArrayList<h> qjo;
  
  public g(e parame)
  {
    AppMethodBeat.i(144347);
    this.qjo = new ArrayList();
    this.qiB = new ArrayList();
    this.okQ = parame;
    parame = (a)parame.au(a.class);
    this.qjn = parame.cxq;
    this.pFt = parame.qiv;
    this.qiA = j.a(parame);
    AppMethodBeat.o(144347);
  }
  
  private void LG(String paramString)
  {
    AppMethodBeat.i(144349);
    if (paramString == null)
    {
      AppMethodBeat.o(144349);
      return;
    }
    synchronized (this.qjo)
    {
      Iterator localIterator = this.qjo.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.mvB)) {
          this.qjo.remove(localh);
        }
      }
      AppMethodBeat.o(144349);
      return;
    }
  }
  
  private void a(String paramString, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(144353);
    LG(paramString);
    if (paramHttpURLConnection != null) {
      try
      {
        paramHttpURLConnection.getInputStream().close();
        paramHttpURLConnection.disconnect();
        AppMethodBeat.o(144353);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", paramHttpURLConnection, "removeTask Exception: id %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(144353);
  }
  
  public final void a(int paramInt, String paramString1, String arg3, JSONObject paramJSONObject, Map<String, String> paramMap, ArrayList<String> paramArrayList, a parama, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(144348);
    String str1 = j.akZ(paramJSONObject.optString("url"));
    String str2 = paramJSONObject.optString("name");
    paramJSONObject = j.as(paramJSONObject);
    synchronized (this.qjo)
    {
      if (this.qjo.size() >= this.qjn)
      {
        parama.aik("tasked refused max connected");
        Log.i("MicroMsg.AppBrandNetworkUpload", "max connected mUploadTaskList.size():%d,mMaxUploadConcurrent:%d", new Object[] { Integer.valueOf(this.qjo.size()), Integer.valueOf(this.qjn) });
        AppMethodBeat.o(144348);
        return;
      }
      if (TextUtils.isEmpty(str2))
      {
        parama.aik("fileName error");
        Log.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
        AppMethodBeat.o(144348);
        return;
      }
    }
    paramString1 = new h(???, str1, str2, paramString5, paramInt, paramString1, parama);
    paramString1.qjs = paramJSONObject;
    paramString1.mvC = paramMap;
    paramString1.qjb = paramArrayList;
    paramString1.isRunning = true;
    paramString1.mvB = paramString3;
    paramString1.qjg = paramString4;
    synchronized (this.qjo)
    {
      this.qjo.add(paramString1);
      ThreadPool.post(new b(paramString1), "appbrand_upload_thread");
      AppMethodBeat.o(144348);
      return;
    }
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(144351);
    if (paramh == null)
    {
      AppMethodBeat.o(144351);
      return;
    }
    this.qiB.add(paramh.mvB);
    paramh.isRunning = false;
    a(paramh.mvB, paramh.qje);
    AppMethodBeat.o(144351);
  }
  
  public final boolean akN(String paramString)
  {
    AppMethodBeat.i(144352);
    boolean bool = this.qiB.contains(paramString);
    AppMethodBeat.o(144352);
    return bool;
  }
  
  public final h akU(String paramString)
  {
    AppMethodBeat.i(144350);
    if (paramString == null)
    {
      AppMethodBeat.o(144350);
      return null;
    }
    synchronized (this.qjo)
    {
      Iterator localIterator = this.qjo.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.mvB))
        {
          AppMethodBeat.o(144350);
          return localh;
        }
      }
      AppMethodBeat.o(144350);
      return null;
    }
  }
  
  public static abstract interface a
  {
    public abstract void M(JSONObject paramJSONObject);
    
    public abstract void aik(String paramString);
    
    public abstract void j(int paramInt1, String paramString, int paramInt2);
    
    public abstract void k(int paramInt, long paramLong1, long paramLong2);
  }
  
  public final class b
    implements Runnable
  {
    private h qjp;
    
    public b(h paramh)
    {
      this.qjp = paramh;
    }
    
    /* Error */
    private void b(h paramh)
    {
      // Byte code:
      //   0: ldc 43
      //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   9: astore 32
      //   11: aload_1
      //   12: getfield 58	com/tencent/mm/plugin/appbrand/s/h:qjr	Ljava/lang/String;
      //   15: astore 33
      //   17: aload_1
      //   18: getfield 61	com/tencent/mm/plugin/appbrand/s/h:mName	Ljava/lang/String;
      //   21: astore 20
      //   23: aload_1
      //   24: getfield 64	com/tencent/mm/plugin/appbrand/s/h:mMimeType	Ljava/lang/String;
      //   27: ldc 66
      //   29: invokestatic 70	com/tencent/mm/plugin/appbrand/s/g$b:du	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   32: astore 34
      //   34: aload_1
      //   35: getfield 73	com/tencent/mm/plugin/appbrand/s/h:mFileName	Ljava/lang/String;
      //   38: astore 22
      //   40: ldc 75
      //   42: ldc 77
      //   44: iconst_1
      //   45: anewarray 4	java/lang/Object
      //   48: dup
      //   49: iconst_0
      //   50: aload 22
      //   52: aastore
      //   53: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   56: aload_1
      //   57: getfield 87	com/tencent/mm/plugin/appbrand/s/h:qjs	Ljava/util/Map;
      //   60: astore 23
      //   62: aload_1
      //   63: getfield 90	com/tencent/mm/plugin/appbrand/s/h:mvC	Ljava/util/Map;
      //   66: astore 38
      //   68: iconst_0
      //   69: istore 6
      //   71: iconst_0
      //   72: istore 7
      //   74: iconst_0
      //   75: istore 8
      //   77: iconst_0
      //   78: istore 9
      //   80: iconst_0
      //   81: istore 5
      //   83: iconst_0
      //   84: istore 10
      //   86: iconst_0
      //   87: istore 11
      //   89: iconst_0
      //   90: istore 12
      //   92: iconst_0
      //   93: istore 13
      //   95: iconst_0
      //   96: istore 14
      //   98: iconst_0
      //   99: istore 4
      //   101: aload_1
      //   102: getfield 94	com/tencent/mm/plugin/appbrand/s/h:qjt	Lcom/tencent/mm/plugin/appbrand/s/g$a;
      //   105: astore 35
      //   107: aload_1
      //   108: getfield 98	com/tencent/mm/plugin/appbrand/s/h:qjb	Ljava/util/ArrayList;
      //   111: astore 39
      //   113: aload 39
      //   115: ifnull +189 -> 304
      //   118: aload 39
      //   120: aload 32
      //   122: invokestatic 103	com/tencent/mm/plugin/appbrand/s/j:b	(Ljava/util/ArrayList;Ljava/lang/String;)Z
      //   125: ifne +179 -> 304
      //   128: aconst_null
      //   129: astore 20
      //   131: new 105	java/net/URL
      //   134: dup
      //   135: aload_1
      //   136: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   139: invokespecial 108	java/net/URL:<init>	(Ljava/lang/String;)V
      //   142: invokevirtual 112	java/net/URL:getHost	()Ljava/lang/String;
      //   145: astore 21
      //   147: aload 21
      //   149: astore 20
      //   151: aload 20
      //   153: invokestatic 118	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   156: ifne +129 -> 285
      //   159: aload_0
      //   160: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   163: aload 35
      //   165: ldc 120
      //   167: aload 20
      //   169: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   172: invokevirtual 130	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   175: aload_1
      //   176: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   179: aconst_null
      //   180: invokestatic 137	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   183: aload_0
      //   184: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   187: aload 35
      //   189: ldc 139
      //   191: aload_1
      //   192: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   195: aconst_null
      //   196: invokestatic 137	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   199: ldc 141
      //   201: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   204: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   207: aload_0
      //   208: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   211: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   214: invokeinterface 156 1 0
      //   219: aload_1
      //   220: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   223: ldc 161
      //   225: aload_1
      //   226: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   229: lconst_0
      //   230: lconst_0
      //   231: iconst_0
      //   232: iconst_2
      //   233: aload_1
      //   234: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   237: aconst_null
      //   238: aload 34
      //   240: invokeinterface 168 14 0
      //   245: ldc 75
      //   247: ldc 170
      //   249: iconst_1
      //   250: anewarray 4	java/lang/Object
      //   253: dup
      //   254: iconst_0
      //   255: aload 32
      //   257: aastore
      //   258: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   261: ldc 43
      //   263: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   266: return
      //   267: astore 21
      //   269: ldc 75
      //   271: aload 21
      //   273: ldc 177
      //   275: iconst_0
      //   276: anewarray 4	java/lang/Object
      //   279: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   282: goto -131 -> 151
      //   285: aload_0
      //   286: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   289: aload 35
      //   291: ldc 139
      //   293: aload_1
      //   294: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   297: aconst_null
      //   298: invokestatic 137	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   301: goto -118 -> 183
      //   304: aconst_null
      //   305: astore 28
      //   307: aconst_null
      //   308: astore 29
      //   310: aconst_null
      //   311: astore 30
      //   313: aconst_null
      //   314: astore 31
      //   316: aconst_null
      //   317: astore 26
      //   319: aconst_null
      //   320: astore 25
      //   322: aload_1
      //   323: getfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   326: ifne +78 -> 404
      //   329: aload_0
      //   330: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   333: aload 35
      //   335: ldc 187
      //   337: aload_1
      //   338: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   341: aconst_null
      //   342: invokestatic 137	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   345: ldc 141
      //   347: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   350: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   353: aload_0
      //   354: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   357: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   360: invokeinterface 156 1 0
      //   365: aload_1
      //   366: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   369: ldc 161
      //   371: aload_1
      //   372: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   375: lconst_0
      //   376: lconst_0
      //   377: iconst_0
      //   378: iconst_2
      //   379: aload_1
      //   380: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   383: aconst_null
      //   384: aload 34
      //   386: invokeinterface 168 14 0
      //   391: ldc 75
      //   393: ldc 189
      //   395: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   398: ldc 43
      //   400: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   403: return
      //   404: aload_1
      //   405: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   408: invokestatic 198	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
      //   411: ifne +81 -> 492
      //   414: aload_1
      //   415: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   418: invokestatic 201	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
      //   421: ifne +71 -> 492
      //   424: aload_0
      //   425: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   428: aload 35
      //   430: ldc 203
      //   432: aload_1
      //   433: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   436: aconst_null
      //   437: invokestatic 137	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   440: ldc 141
      //   442: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   445: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   448: aload_0
      //   449: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   452: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   455: invokeinterface 156 1 0
      //   460: aload_1
      //   461: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   464: ldc 161
      //   466: aload_1
      //   467: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   470: lconst_0
      //   471: lconst_0
      //   472: iconst_0
      //   473: iconst_2
      //   474: aload_1
      //   475: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   478: aconst_null
      //   479: aload 34
      //   481: invokeinterface 168 14 0
      //   486: ldc 43
      //   488: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   491: return
      //   492: invokestatic 209	java/lang/System:currentTimeMillis	()J
      //   495: invokestatic 215	java/lang/Long:toString	(J)Ljava/lang/String;
      //   498: astore 37
      //   500: ldc 217
      //   502: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   505: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   508: ldc2_w 218
      //   511: lconst_0
      //   512: lconst_1
      //   513: iconst_0
      //   514: invokeinterface 223 8 0
      //   519: new 225	com/tencent/mm/vfs/q
      //   522: dup
      //   523: aload 33
      //   525: invokespecial 226	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
      //   528: astore 36
      //   530: aload 36
      //   532: invokestatic 232	com/tencent/mm/vfs/u:al	(Lcom/tencent/mm/vfs/q;)Ljava/io/InputStream;
      //   535: astore 21
      //   537: new 105	java/net/URL
      //   540: dup
      //   541: aload 32
      //   543: invokespecial 108	java/net/URL:<init>	(Ljava/lang/String;)V
      //   546: astore 27
      //   548: aload 27
      //   550: invokevirtual 236	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   553: checkcast 238	java/net/HttpURLConnection
      //   556: astore 24
      //   558: aload_1
      //   559: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   562: invokestatic 118	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   565: ifne +9 -> 574
      //   568: aload_1
      //   569: aload 24
      //   571: putfield 242	com/tencent/mm/plugin/appbrand/s/h:qje	Ljava/net/HttpURLConnection;
      //   574: aload 24
      //   576: instanceof 244
      //   579: ifeq +38 -> 617
      //   582: aload_0
      //   583: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   586: getfield 248	com/tencent/mm/plugin/appbrand/s/g:qiA	Ljavax/net/ssl/SSLContext;
      //   589: ifnull +28 -> 617
      //   592: aload 24
      //   594: checkcast 244	javax/net/ssl/HttpsURLConnection
      //   597: aload_0
      //   598: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   601: getfield 248	com/tencent/mm/plugin/appbrand/s/g:qiA	Ljavax/net/ssl/SSLContext;
      //   604: invokevirtual 254	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
      //   607: invokevirtual 258	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
      //   610: aload 24
      //   612: aload 39
      //   614: invokestatic 261	com/tencent/mm/plugin/appbrand/s/j:a	(Ljava/net/HttpURLConnection;Ljava/util/ArrayList;)V
      //   617: aload 24
      //   619: iconst_1
      //   620: invokevirtual 265	java/net/HttpURLConnection:setDoInput	(Z)V
      //   623: aload 24
      //   625: iconst_1
      //   626: invokevirtual 268	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   629: aload 24
      //   631: iconst_0
      //   632: invokevirtual 271	java/net/HttpURLConnection:setUseCaches	(Z)V
      //   635: aload 24
      //   637: aload_1
      //   638: getfield 275	com/tencent/mm/plugin/appbrand/s/h:mTimeout	I
      //   641: invokevirtual 278	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   644: aload 24
      //   646: aload_1
      //   647: getfield 275	com/tencent/mm/plugin/appbrand/s/h:mTimeout	I
      //   650: invokevirtual 281	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   653: aload 24
      //   655: ldc 161
      //   657: invokevirtual 284	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   660: aload 24
      //   662: ldc_w 286
      //   665: ldc_w 288
      //   668: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   671: aload 24
      //   673: ldc_w 293
      //   676: ldc_w 295
      //   679: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   682: ldc 75
      //   684: ldc_w 297
      //   687: iconst_2
      //   688: anewarray 4	java/lang/Object
      //   691: dup
      //   692: iconst_0
      //   693: aload 36
      //   695: invokevirtual 300	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
      //   698: aastore
      //   699: dup
      //   700: iconst_1
      //   701: aload 36
      //   703: invokevirtual 303	com/tencent/mm/vfs/q:length	()J
      //   706: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   709: aastore
      //   710: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   713: aload 24
      //   715: iconst_0
      //   716: invokevirtual 309	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   719: aload 38
      //   721: ifnull +737 -> 1458
      //   724: ldc 75
      //   726: ldc_w 311
      //   729: iconst_1
      //   730: anewarray 4	java/lang/Object
      //   733: dup
      //   734: iconst_0
      //   735: aload 32
      //   737: aastore
      //   738: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   741: aload 38
      //   743: invokeinterface 317 1 0
      //   748: invokeinterface 323 1 0
      //   753: astore 38
      //   755: aload 38
      //   757: invokeinterface 329 1 0
      //   762: ifeq +696 -> 1458
      //   765: aload 38
      //   767: invokeinterface 333 1 0
      //   772: checkcast 335	java/util/Map$Entry
      //   775: astore 39
      //   777: ldc 75
      //   779: ldc_w 337
      //   782: iconst_3
      //   783: anewarray 4	java/lang/Object
      //   786: dup
      //   787: iconst_0
      //   788: aload 32
      //   790: aastore
      //   791: dup
      //   792: iconst_1
      //   793: aload 39
      //   795: invokeinterface 340 1 0
      //   800: aastore
      //   801: dup
      //   802: iconst_2
      //   803: aload 39
      //   805: invokeinterface 343 1 0
      //   810: aastore
      //   811: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   814: aload 39
      //   816: invokeinterface 340 1 0
      //   821: checkcast 122	java/lang/String
      //   824: invokestatic 118	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   827: ifne -72 -> 755
      //   830: aload 39
      //   832: invokeinterface 343 1 0
      //   837: checkcast 122	java/lang/String
      //   840: invokestatic 118	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   843: ifne -88 -> 755
      //   846: aload 39
      //   848: invokeinterface 340 1 0
      //   853: checkcast 122	java/lang/String
      //   856: invokevirtual 346	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   859: ldc_w 348
      //   862: invokevirtual 352	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   865: ifeq +254 -> 1119
      //   868: ldc 75
      //   870: ldc_w 354
      //   873: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   876: goto -121 -> 755
      //   879: astore 22
      //   881: aload 21
      //   883: astore 20
      //   885: aconst_null
      //   886: astore 21
      //   888: lconst_0
      //   889: lstore 16
      //   891: iconst_0
      //   892: istore_2
      //   893: aload 25
      //   895: astore 23
      //   897: iload 4
      //   899: istore_3
      //   900: ldc 217
      //   902: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   905: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   908: ldc2_w 218
      //   911: lconst_1
      //   912: lconst_1
      //   913: iconst_0
      //   914: invokeinterface 223 8 0
      //   919: ldc 75
      //   921: aload 22
      //   923: ldc_w 356
      //   926: iconst_2
      //   927: anewarray 4	java/lang/Object
      //   930: dup
      //   931: iconst_0
      //   932: aload 32
      //   934: aastore
      //   935: dup
      //   936: iconst_1
      //   937: aload 33
      //   939: aastore
      //   940: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   943: aload_0
      //   944: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   947: aload 35
      //   949: iconst_m1
      //   950: ldc_w 358
      //   953: iload_3
      //   954: aload_1
      //   955: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   958: aload 24
      //   960: invokestatic 361	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   963: ldc 141
      //   965: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   968: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   971: aload_0
      //   972: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   975: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   978: invokeinterface 156 1 0
      //   983: aload_1
      //   984: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   987: ldc 161
      //   989: aload_1
      //   990: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   993: lload 16
      //   995: iload_2
      //   996: i2l
      //   997: iload_3
      //   998: iconst_2
      //   999: aload_1
      //   1000: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   1003: aconst_null
      //   1004: aload 34
      //   1006: invokeinterface 168 14 0
      //   1011: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   1014: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   1017: istore_2
      //   1018: iload_2
      //   1019: iconst_m1
      //   1020: if_icmpne +24 -> 1044
      //   1023: ldc 217
      //   1025: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1028: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   1031: ldc2_w 218
      //   1034: ldc2_w 374
      //   1037: lconst_1
      //   1038: iconst_0
      //   1039: invokeinterface 223 8 0
      //   1044: ldc 75
      //   1046: ldc_w 377
      //   1049: iconst_1
      //   1050: anewarray 4	java/lang/Object
      //   1053: dup
      //   1054: iconst_0
      //   1055: iload_2
      //   1056: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1059: aastore
      //   1060: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1063: aload_1
      //   1064: iconst_0
      //   1065: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   1068: aload 20
      //   1070: ifnull +8 -> 1078
      //   1073: aload 20
      //   1075: invokevirtual 387	java/io/InputStream:close	()V
      //   1078: aload 21
      //   1080: ifnull +8 -> 1088
      //   1083: aload 21
      //   1085: invokevirtual 387	java/io/InputStream:close	()V
      //   1088: aload 23
      //   1090: ifnull +8 -> 1098
      //   1093: aload 23
      //   1095: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   1098: aload_0
      //   1099: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   1102: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   1105: aload_1
      //   1106: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   1109: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   1112: pop
      //   1113: ldc 43
      //   1115: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1118: return
      //   1119: aload 24
      //   1121: aload 39
      //   1123: invokeinterface 340 1 0
      //   1128: checkcast 122	java/lang/String
      //   1131: aload 39
      //   1133: invokeinterface 343 1 0
      //   1138: checkcast 122	java/lang/String
      //   1141: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1144: goto -389 -> 755
      //   1147: astore 20
      //   1149: aconst_null
      //   1150: astore 22
      //   1152: lconst_0
      //   1153: lstore 16
      //   1155: aload 21
      //   1157: astore 27
      //   1159: aload 24
      //   1161: astore 26
      //   1163: aload 28
      //   1165: astore 23
      //   1167: iload 10
      //   1169: istore_2
      //   1170: iload_2
      //   1171: istore 4
      //   1173: aload 23
      //   1175: astore 25
      //   1177: aload 27
      //   1179: astore 24
      //   1181: aload 22
      //   1183: astore 21
      //   1185: iload 5
      //   1187: istore_3
      //   1188: lload 16
      //   1190: lstore 18
      //   1192: ldc 217
      //   1194: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1197: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   1200: ldc2_w 218
      //   1203: ldc2_w 400
      //   1206: lconst_1
      //   1207: iconst_0
      //   1208: invokeinterface 223 8 0
      //   1213: iload_2
      //   1214: istore 4
      //   1216: aload 23
      //   1218: astore 25
      //   1220: aload 27
      //   1222: astore 24
      //   1224: aload 22
      //   1226: astore 21
      //   1228: iload 5
      //   1230: istore_3
      //   1231: lload 16
      //   1233: lstore 18
      //   1235: ldc 75
      //   1237: aload 20
      //   1239: ldc_w 403
      //   1242: iconst_2
      //   1243: anewarray 4	java/lang/Object
      //   1246: dup
      //   1247: iconst_0
      //   1248: aload 32
      //   1250: aastore
      //   1251: dup
      //   1252: iconst_1
      //   1253: aload 33
      //   1255: aastore
      //   1256: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1259: iload_2
      //   1260: istore 4
      //   1262: aload 23
      //   1264: astore 25
      //   1266: aload 27
      //   1268: astore 24
      //   1270: aload 22
      //   1272: astore 21
      //   1274: iload 5
      //   1276: istore_3
      //   1277: lload 16
      //   1279: lstore 18
      //   1281: aload_0
      //   1282: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   1285: aload 35
      //   1287: iconst_m1
      //   1288: ldc_w 405
      //   1291: iload_2
      //   1292: aload_1
      //   1293: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   1296: aload 26
      //   1298: invokestatic 361	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   1301: ldc 141
      //   1303: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1306: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   1309: aload_0
      //   1310: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   1313: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   1316: invokeinterface 156 1 0
      //   1321: aload_1
      //   1322: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   1325: ldc 161
      //   1327: aload_1
      //   1328: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   1331: lload 16
      //   1333: iload 5
      //   1335: i2l
      //   1336: iload_2
      //   1337: iconst_2
      //   1338: aload_1
      //   1339: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   1342: aconst_null
      //   1343: aload 34
      //   1345: invokeinterface 168 14 0
      //   1350: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   1353: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   1356: istore_2
      //   1357: iload_2
      //   1358: iconst_m1
      //   1359: if_icmpne +24 -> 1383
      //   1362: ldc 217
      //   1364: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1367: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   1370: ldc2_w 218
      //   1373: ldc2_w 374
      //   1376: lconst_1
      //   1377: iconst_0
      //   1378: invokeinterface 223 8 0
      //   1383: ldc 75
      //   1385: ldc_w 377
      //   1388: iconst_1
      //   1389: anewarray 4	java/lang/Object
      //   1392: dup
      //   1393: iconst_0
      //   1394: iload_2
      //   1395: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1398: aastore
      //   1399: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1402: aload_1
      //   1403: iconst_0
      //   1404: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   1407: aload 27
      //   1409: ifnull +8 -> 1417
      //   1412: aload 27
      //   1414: invokevirtual 387	java/io/InputStream:close	()V
      //   1417: aload 22
      //   1419: ifnull +8 -> 1427
      //   1422: aload 22
      //   1424: invokevirtual 387	java/io/InputStream:close	()V
      //   1427: aload 23
      //   1429: ifnull +8 -> 1437
      //   1432: aload 23
      //   1434: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   1437: aload_0
      //   1438: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   1441: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   1444: aload_1
      //   1445: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   1448: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   1451: pop
      //   1452: ldc 43
      //   1454: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1457: return
      //   1458: aload 24
      //   1460: ldc_w 407
      //   1463: aload_0
      //   1464: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   1467: getfield 410	com/tencent/mm/plugin/appbrand/s/g:pFt	Ljava/lang/String;
      //   1470: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1473: aload 36
      //   1475: invokevirtual 303	com/tencent/mm/vfs/q:length	()J
      //   1478: lstore 16
      //   1480: new 412	java/lang/StringBuilder
      //   1483: dup
      //   1484: invokespecial 413	java/lang/StringBuilder:<init>	()V
      //   1487: astore 39
      //   1489: new 412	java/lang/StringBuilder
      //   1492: dup
      //   1493: invokespecial 413	java/lang/StringBuilder:<init>	()V
      //   1496: astore 38
      //   1498: aload 23
      //   1500: ifnull +670 -> 2170
      //   1503: aload 24
      //   1505: ldc_w 415
      //   1508: ldc_w 417
      //   1511: aload 37
      //   1513: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   1516: invokevirtual 130	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1519: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1522: aload 23
      //   1524: invokeinterface 420 1 0
      //   1529: invokeinterface 323 1 0
      //   1534: astore 40
      //   1536: aload 40
      //   1538: invokeinterface 329 1 0
      //   1543: ifeq +467 -> 2010
      //   1546: aload 40
      //   1548: invokeinterface 333 1 0
      //   1553: checkcast 122	java/lang/String
      //   1556: astore 41
      //   1558: aload 23
      //   1560: aload 41
      //   1562: invokeinterface 424 2 0
      //   1567: checkcast 122	java/lang/String
      //   1570: astore 42
      //   1572: ldc 75
      //   1574: ldc_w 426
      //   1577: iconst_2
      //   1578: anewarray 4	java/lang/Object
      //   1581: dup
      //   1582: iconst_0
      //   1583: aload 41
      //   1585: aastore
      //   1586: dup
      //   1587: iconst_1
      //   1588: aload 42
      //   1590: aastore
      //   1591: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1594: aload 39
      //   1596: new 412	java/lang/StringBuilder
      //   1599: dup
      //   1600: invokespecial 413	java/lang/StringBuilder:<init>	()V
      //   1603: ldc_w 428
      //   1606: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1609: aload 37
      //   1611: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1614: ldc_w 434
      //   1617: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1620: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1623: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1626: pop
      //   1627: aload 39
      //   1629: new 412	java/lang/StringBuilder
      //   1632: dup
      //   1633: ldc_w 438
      //   1636: invokespecial 439	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1639: aload 41
      //   1641: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1644: ldc_w 441
      //   1647: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1650: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1653: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1656: pop
      //   1657: aload 39
      //   1659: ldc_w 434
      //   1662: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1665: pop
      //   1666: aload 39
      //   1668: ldc_w 434
      //   1671: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1674: pop
      //   1675: aload 39
      //   1677: aload 42
      //   1679: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1682: pop
      //   1683: aload 39
      //   1685: ldc_w 434
      //   1688: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1691: pop
      //   1692: goto -156 -> 1536
      //   1695: astore 20
      //   1697: aconst_null
      //   1698: astore 22
      //   1700: lconst_0
      //   1701: lstore 16
      //   1703: iload 6
      //   1705: istore 5
      //   1707: aload 21
      //   1709: astore 27
      //   1711: aload 24
      //   1713: astore 26
      //   1715: aload 29
      //   1717: astore 23
      //   1719: iload 11
      //   1721: istore_2
      //   1722: iload_2
      //   1723: istore 4
      //   1725: aload 23
      //   1727: astore 25
      //   1729: aload 27
      //   1731: astore 24
      //   1733: aload 22
      //   1735: astore 21
      //   1737: iload 5
      //   1739: istore_3
      //   1740: lload 16
      //   1742: lstore 18
      //   1744: ldc 217
      //   1746: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1749: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   1752: ldc2_w 218
      //   1755: ldc2_w 442
      //   1758: lconst_1
      //   1759: iconst_0
      //   1760: invokeinterface 223 8 0
      //   1765: iload_2
      //   1766: istore 4
      //   1768: aload 23
      //   1770: astore 25
      //   1772: aload 27
      //   1774: astore 24
      //   1776: aload 22
      //   1778: astore 21
      //   1780: iload 5
      //   1782: istore_3
      //   1783: lload 16
      //   1785: lstore 18
      //   1787: ldc 75
      //   1789: aload 20
      //   1791: ldc_w 445
      //   1794: iconst_2
      //   1795: anewarray 4	java/lang/Object
      //   1798: dup
      //   1799: iconst_0
      //   1800: aload 32
      //   1802: aastore
      //   1803: dup
      //   1804: iconst_1
      //   1805: aload 33
      //   1807: aastore
      //   1808: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1811: iload_2
      //   1812: istore 4
      //   1814: aload 23
      //   1816: astore 25
      //   1818: aload 27
      //   1820: astore 24
      //   1822: aload 22
      //   1824: astore 21
      //   1826: iload 5
      //   1828: istore_3
      //   1829: lload 16
      //   1831: lstore 18
      //   1833: aload_0
      //   1834: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   1837: aload 35
      //   1839: iconst_m1
      //   1840: ldc_w 447
      //   1843: iload_2
      //   1844: aload_1
      //   1845: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   1848: aload 26
      //   1850: invokestatic 361	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   1853: ldc 141
      //   1855: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1858: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   1861: aload_0
      //   1862: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   1865: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   1868: invokeinterface 156 1 0
      //   1873: aload_1
      //   1874: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   1877: ldc 161
      //   1879: aload_1
      //   1880: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   1883: lload 16
      //   1885: iload 5
      //   1887: i2l
      //   1888: iload_2
      //   1889: iconst_2
      //   1890: aload_1
      //   1891: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   1894: aconst_null
      //   1895: aload 34
      //   1897: invokeinterface 168 14 0
      //   1902: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   1905: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   1908: istore_2
      //   1909: iload_2
      //   1910: iconst_m1
      //   1911: if_icmpne +24 -> 1935
      //   1914: ldc 217
      //   1916: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1919: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   1922: ldc2_w 218
      //   1925: ldc2_w 374
      //   1928: lconst_1
      //   1929: iconst_0
      //   1930: invokeinterface 223 8 0
      //   1935: ldc 75
      //   1937: ldc_w 377
      //   1940: iconst_1
      //   1941: anewarray 4	java/lang/Object
      //   1944: dup
      //   1945: iconst_0
      //   1946: iload_2
      //   1947: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1950: aastore
      //   1951: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1954: aload_1
      //   1955: iconst_0
      //   1956: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   1959: aload 27
      //   1961: ifnull +8 -> 1969
      //   1964: aload 27
      //   1966: invokevirtual 387	java/io/InputStream:close	()V
      //   1969: aload 22
      //   1971: ifnull +8 -> 1979
      //   1974: aload 22
      //   1976: invokevirtual 387	java/io/InputStream:close	()V
      //   1979: aload 23
      //   1981: ifnull +8 -> 1989
      //   1984: aload 23
      //   1986: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   1989: aload_0
      //   1990: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   1993: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   1996: aload_1
      //   1997: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   2000: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   2003: pop
      //   2004: ldc 43
      //   2006: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2009: return
      //   2010: aload 39
      //   2012: new 412	java/lang/StringBuilder
      //   2015: dup
      //   2016: invokespecial 413	java/lang/StringBuilder:<init>	()V
      //   2019: ldc_w 428
      //   2022: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2025: aload 37
      //   2027: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2030: ldc_w 434
      //   2033: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2036: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2039: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2042: pop
      //   2043: aload 39
      //   2045: new 412	java/lang/StringBuilder
      //   2048: dup
      //   2049: ldc_w 438
      //   2052: invokespecial 439	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2055: aload 20
      //   2057: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2060: ldc_w 449
      //   2063: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2066: aload 22
      //   2068: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2071: ldc_w 441
      //   2074: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2077: ldc_w 434
      //   2080: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2083: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2086: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2089: pop
      //   2090: aload 39
      //   2092: ldc_w 451
      //   2095: aload 34
      //   2097: invokestatic 126	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   2100: invokevirtual 130	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   2103: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2106: pop
      //   2107: aload 39
      //   2109: ldc_w 434
      //   2112: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2115: pop
      //   2116: aload 39
      //   2118: ldc_w 434
      //   2121: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2124: pop
      //   2125: aload 38
      //   2127: new 412	java/lang/StringBuilder
      //   2130: dup
      //   2131: invokespecial 413	java/lang/StringBuilder:<init>	()V
      //   2134: ldc_w 434
      //   2137: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2140: ldc_w 428
      //   2143: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2146: aload 37
      //   2148: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2151: ldc_w 428
      //   2154: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2157: ldc_w 434
      //   2160: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2163: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2166: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2169: pop
      //   2170: aload 39
      //   2172: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2175: ldc_w 453
      //   2178: invokevirtual 457	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   2181: astore 20
      //   2183: aload 38
      //   2185: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2188: ldc_w 453
      //   2191: invokevirtual 457	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   2194: astore 23
      //   2196: aload 20
      //   2198: astore 22
      //   2200: aload 20
      //   2202: ifnonnull +8 -> 2210
      //   2205: iconst_0
      //   2206: newarray byte
      //   2208: astore 22
      //   2210: aload 23
      //   2212: ifnonnull +4980 -> 7192
      //   2215: iconst_0
      //   2216: newarray byte
      //   2218: astore 23
      //   2220: lload 16
      //   2222: aload 22
      //   2224: arraylength
      //   2225: i2l
      //   2226: ladd
      //   2227: aload 23
      //   2229: arraylength
      //   2230: i2l
      //   2231: ladd
      //   2232: lstore 16
      //   2234: ldc 75
      //   2236: ldc_w 459
      //   2239: iconst_1
      //   2240: anewarray 4	java/lang/Object
      //   2243: dup
      //   2244: iconst_0
      //   2245: lload 16
      //   2247: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2250: aastore
      //   2251: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2254: aload 24
      //   2256: ldc_w 461
      //   2259: lload 16
      //   2261: invokestatic 463	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   2264: invokevirtual 291	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   2267: aload 35
      //   2269: aload 24
      //   2271: invokestatic 466	com/tencent/mm/plugin/appbrand/s/j:e	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
      //   2274: invokeinterface 472 2 0
      //   2279: new 389	java/io/DataOutputStream
      //   2282: dup
      //   2283: aload 24
      //   2285: invokevirtual 476	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   2288: invokespecial 479	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   2291: astore 20
      //   2293: aload 20
      //   2295: aload 22
      //   2297: invokevirtual 483	java/io/DataOutputStream:write	([B)V
      //   2300: lload 16
      //   2302: invokestatic 487	com/tencent/mm/plugin/appbrand/s/j:HB	(J)I
      //   2305: newarray byte
      //   2307: astore 22
      //   2309: aload 36
      //   2311: invokevirtual 303	com/tencent/mm/vfs/q:length	()J
      //   2314: lstore 18
      //   2316: iconst_m1
      //   2317: istore_2
      //   2318: lconst_0
      //   2319: lstore 16
      //   2321: aload 21
      //   2323: aload 22
      //   2325: invokevirtual 491	java/io/InputStream:read	([B)I
      //   2328: istore_3
      //   2329: iload_3
      //   2330: iconst_m1
      //   2331: if_icmpeq +346 -> 2677
      //   2334: aload_1
      //   2335: getfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   2338: ifeq +339 -> 2677
      //   2341: aload_0
      //   2342: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   2345: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   2348: invokestatic 494	com/tencent/mm/plugin/appbrand/s/j:L	(Lcom/tencent/mm/plugin/appbrand/jsapi/e;)Z
      //   2351: ifeq +219 -> 2570
      //   2354: aload_0
      //   2355: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   2358: aload 35
      //   2360: ldc_w 496
      //   2363: aload_1
      //   2364: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   2367: aload 24
      //   2369: invokestatic 137	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   2372: ldc 141
      //   2374: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   2377: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   2380: aload_0
      //   2381: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   2384: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   2387: invokeinterface 156 1 0
      //   2392: aload_1
      //   2393: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   2396: ldc 161
      //   2398: aload_1
      //   2399: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   2402: lload 16
      //   2404: lconst_0
      //   2405: iconst_0
      //   2406: iconst_2
      //   2407: aload_1
      //   2408: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   2411: aconst_null
      //   2412: aload 34
      //   2414: invokeinterface 168 14 0
      //   2419: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   2422: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   2425: istore_2
      //   2426: iload_2
      //   2427: iconst_m1
      //   2428: if_icmpne +24 -> 2452
      //   2431: ldc 217
      //   2433: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   2436: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   2439: ldc2_w 218
      //   2442: ldc2_w 374
      //   2445: lconst_1
      //   2446: iconst_0
      //   2447: invokeinterface 223 8 0
      //   2452: ldc 75
      //   2454: ldc_w 377
      //   2457: iconst_1
      //   2458: anewarray 4	java/lang/Object
      //   2461: dup
      //   2462: iconst_0
      //   2463: iload_2
      //   2464: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2467: aastore
      //   2468: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2471: aload_1
      //   2472: iconst_0
      //   2473: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   2476: aload 21
      //   2478: ifnull +8 -> 2486
      //   2481: aload 21
      //   2483: invokevirtual 387	java/io/InputStream:close	()V
      //   2486: aload 20
      //   2488: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   2491: aload_0
      //   2492: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   2495: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   2498: aload_1
      //   2499: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   2502: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   2505: pop
      //   2506: ldc 43
      //   2508: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2511: return
      //   2512: astore 21
      //   2514: ldc 75
      //   2516: aload 21
      //   2518: ldc_w 498
      //   2521: iconst_2
      //   2522: anewarray 4	java/lang/Object
      //   2525: dup
      //   2526: iconst_0
      //   2527: aload 32
      //   2529: aastore
      //   2530: dup
      //   2531: iconst_1
      //   2532: aload 33
      //   2534: aastore
      //   2535: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2538: goto -52 -> 2486
      //   2541: astore 20
      //   2543: ldc 75
      //   2545: aload 20
      //   2547: ldc_w 500
      //   2550: iconst_2
      //   2551: anewarray 4	java/lang/Object
      //   2554: dup
      //   2555: iconst_0
      //   2556: aload 32
      //   2558: aastore
      //   2559: dup
      //   2560: iconst_1
      //   2561: aload 33
      //   2563: aastore
      //   2564: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2567: goto -76 -> 2491
      //   2570: aload 20
      //   2572: aload 22
      //   2574: iconst_0
      //   2575: iload_3
      //   2576: invokevirtual 503	java/io/DataOutputStream:write	([BII)V
      //   2579: iload_3
      //   2580: i2l
      //   2581: lload 16
      //   2583: ladd
      //   2584: lstore 16
      //   2586: lload 18
      //   2588: lconst_0
      //   2589: lcmp
      //   2590: ifle +4599 -> 7189
      //   2593: aload_1
      //   2594: getfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   2597: ifeq +4592 -> 7189
      //   2600: ldc2_w 504
      //   2603: lload 16
      //   2605: lmul
      //   2606: lload 18
      //   2608: ldiv
      //   2609: l2i
      //   2610: istore 15
      //   2612: iload_2
      //   2613: istore_3
      //   2614: iload_2
      //   2615: iload 15
      //   2617: if_icmpeq +19 -> 2636
      //   2620: aload 35
      //   2622: iload 15
      //   2624: lload 16
      //   2626: lload 18
      //   2628: invokeinterface 509 6 0
      //   2633: iload 15
      //   2635: istore_3
      //   2636: ldc 75
      //   2638: ldc_w 511
      //   2641: iconst_3
      //   2642: anewarray 4	java/lang/Object
      //   2645: dup
      //   2646: iconst_0
      //   2647: lload 16
      //   2649: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2652: aastore
      //   2653: dup
      //   2654: iconst_1
      //   2655: lload 18
      //   2657: invokestatic 306	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2660: aastore
      //   2661: dup
      //   2662: iconst_2
      //   2663: iload 15
      //   2665: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2668: aastore
      //   2669: invokestatic 83	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2672: iload_3
      //   2673: istore_2
      //   2674: goto -353 -> 2321
      //   2677: aload 20
      //   2679: aload 23
      //   2681: invokevirtual 483	java/io/DataOutputStream:write	([B)V
      //   2684: aload 20
      //   2686: invokevirtual 514	java/io/DataOutputStream:flush	()V
      //   2689: aload 24
      //   2691: invokevirtual 517	java/net/HttpURLConnection:getResponseCode	()I
      //   2694: istore_2
      //   2695: aload 35
      //   2697: aload 24
      //   2699: invokestatic 520	com/tencent/mm/plugin/appbrand/s/j:d	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
      //   2702: invokeinterface 472 2 0
      //   2707: sipush 200
      //   2710: iload_2
      //   2711: if_icmpeq +496 -> 3207
      //   2714: ldc 75
      //   2716: ldc_w 522
      //   2719: iconst_3
      //   2720: anewarray 4	java/lang/Object
      //   2723: dup
      //   2724: iconst_0
      //   2725: iload_2
      //   2726: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2729: aastore
      //   2730: dup
      //   2731: iconst_1
      //   2732: aload 32
      //   2734: aastore
      //   2735: dup
      //   2736: iconst_2
      //   2737: aload 33
      //   2739: aastore
      //   2740: invokestatic 524	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2743: iload_2
      //   2744: invokestatic 528	com/tencent/mm/plugin/appbrand/s/j:uO	(I)Z
      //   2747: ifeq +460 -> 3207
      //   2750: aload 24
      //   2752: invokestatic 532	com/tencent/mm/plugin/appbrand/s/j:c	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
      //   2755: astore 22
      //   2757: aload_1
      //   2758: getfield 535	com/tencent/mm/plugin/appbrand/s/h:qjc	I
      //   2761: istore_3
      //   2762: aload 22
      //   2764: invokestatic 540	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   2767: ifne +440 -> 3207
      //   2770: iload_3
      //   2771: ifgt +189 -> 2960
      //   2774: ldc 75
      //   2776: ldc_w 542
      //   2779: iconst_1
      //   2780: anewarray 4	java/lang/Object
      //   2783: dup
      //   2784: iconst_0
      //   2785: bipush 15
      //   2787: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2790: aastore
      //   2791: invokestatic 545	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2794: aload_0
      //   2795: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   2798: aload 35
      //   2800: iconst_0
      //   2801: ldc_w 547
      //   2804: iload_2
      //   2805: aload_1
      //   2806: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   2809: aload 24
      //   2811: invokestatic 361	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   2814: ldc 141
      //   2816: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   2819: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   2822: aload_0
      //   2823: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   2826: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   2829: invokeinterface 156 1 0
      //   2834: aload_1
      //   2835: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   2838: ldc 161
      //   2840: aload_1
      //   2841: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   2844: lload 16
      //   2846: lconst_0
      //   2847: iload_2
      //   2848: iconst_1
      //   2849: aload_1
      //   2850: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   2853: aconst_null
      //   2854: aload 34
      //   2856: invokeinterface 168 14 0
      //   2861: aload_1
      //   2862: iconst_0
      //   2863: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   2866: aload 21
      //   2868: ifnull +8 -> 2876
      //   2871: aload 21
      //   2873: invokevirtual 387	java/io/InputStream:close	()V
      //   2876: aload 20
      //   2878: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   2881: aload_0
      //   2882: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   2885: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   2888: aload_1
      //   2889: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   2892: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   2895: pop
      //   2896: ldc 43
      //   2898: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2901: return
      //   2902: astore 21
      //   2904: ldc 75
      //   2906: aload 21
      //   2908: ldc_w 498
      //   2911: iconst_2
      //   2912: anewarray 4	java/lang/Object
      //   2915: dup
      //   2916: iconst_0
      //   2917: aload 32
      //   2919: aastore
      //   2920: dup
      //   2921: iconst_1
      //   2922: aload 33
      //   2924: aastore
      //   2925: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2928: goto -52 -> 2876
      //   2931: astore 20
      //   2933: ldc 75
      //   2935: aload 20
      //   2937: ldc_w 500
      //   2940: iconst_2
      //   2941: anewarray 4	java/lang/Object
      //   2944: dup
      //   2945: iconst_0
      //   2946: aload 32
      //   2948: aastore
      //   2949: dup
      //   2950: iconst_1
      //   2951: aload 33
      //   2953: aastore
      //   2954: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2957: goto -76 -> 2881
      //   2960: ldc 75
      //   2962: ldc_w 549
      //   2965: iconst_3
      //   2966: anewarray 4	java/lang/Object
      //   2969: dup
      //   2970: iconst_0
      //   2971: iload_3
      //   2972: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2975: aastore
      //   2976: dup
      //   2977: iconst_1
      //   2978: aload_1
      //   2979: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   2982: aastore
      //   2983: dup
      //   2984: iconst_2
      //   2985: aload 22
      //   2987: aastore
      //   2988: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2991: aload_1
      //   2992: aload 22
      //   2994: putfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   2997: aload_1
      //   2998: iload_3
      //   2999: iconst_1
      //   3000: isub
      //   3001: putfield 535	com/tencent/mm/plugin/appbrand/s/h:qjc	I
      //   3004: aload_0
      //   3005: aload_1
      //   3006: invokespecial 551	com/tencent/mm/plugin/appbrand/s/g$b:b	(Lcom/tencent/mm/plugin/appbrand/s/h;)V
      //   3009: ldc 141
      //   3011: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3014: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   3017: aload_0
      //   3018: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   3021: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   3024: invokeinterface 156 1 0
      //   3029: aload_1
      //   3030: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   3033: ldc 161
      //   3035: aload_1
      //   3036: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   3039: lload 16
      //   3041: lconst_0
      //   3042: iload_2
      //   3043: iconst_2
      //   3044: aload_1
      //   3045: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   3048: aconst_null
      //   3049: aload 34
      //   3051: invokeinterface 168 14 0
      //   3056: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   3059: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   3062: istore_2
      //   3063: iload_2
      //   3064: iconst_m1
      //   3065: if_icmpne +24 -> 3089
      //   3068: ldc 217
      //   3070: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3073: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   3076: ldc2_w 218
      //   3079: ldc2_w 374
      //   3082: lconst_1
      //   3083: iconst_0
      //   3084: invokeinterface 223 8 0
      //   3089: ldc 75
      //   3091: ldc_w 377
      //   3094: iconst_1
      //   3095: anewarray 4	java/lang/Object
      //   3098: dup
      //   3099: iconst_0
      //   3100: iload_2
      //   3101: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3104: aastore
      //   3105: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3108: aload_1
      //   3109: iconst_0
      //   3110: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   3113: aload 21
      //   3115: ifnull +8 -> 3123
      //   3118: aload 21
      //   3120: invokevirtual 387	java/io/InputStream:close	()V
      //   3123: aload 20
      //   3125: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   3128: aload_0
      //   3129: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   3132: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   3135: aload_1
      //   3136: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   3139: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   3142: pop
      //   3143: ldc 43
      //   3145: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   3148: return
      //   3149: astore 21
      //   3151: ldc 75
      //   3153: aload 21
      //   3155: ldc_w 498
      //   3158: iconst_2
      //   3159: anewarray 4	java/lang/Object
      //   3162: dup
      //   3163: iconst_0
      //   3164: aload 32
      //   3166: aastore
      //   3167: dup
      //   3168: iconst_1
      //   3169: aload 33
      //   3171: aastore
      //   3172: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3175: goto -52 -> 3123
      //   3178: astore 20
      //   3180: ldc 75
      //   3182: aload 20
      //   3184: ldc_w 500
      //   3187: iconst_2
      //   3188: anewarray 4	java/lang/Object
      //   3191: dup
      //   3192: iconst_0
      //   3193: aload 32
      //   3195: aastore
      //   3196: dup
      //   3197: iconst_1
      //   3198: aload 33
      //   3200: aastore
      //   3201: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3204: goto -76 -> 3128
      //   3207: ldc 75
      //   3209: ldc_w 553
      //   3212: iconst_1
      //   3213: anewarray 4	java/lang/Object
      //   3216: dup
      //   3217: iconst_0
      //   3218: aload 32
      //   3220: aastore
      //   3221: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3224: ldc_w 295
      //   3227: aload 24
      //   3229: invokevirtual 556	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
      //   3232: invokevirtual 559	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   3235: ifeq +116 -> 3351
      //   3238: new 561	java/util/zip/GZIPInputStream
      //   3241: dup
      //   3242: aload 24
      //   3244: invokevirtual 565	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   3247: invokespecial 568	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   3250: astore 22
      //   3252: aload 22
      //   3254: ifnull +3925 -> 7179
      //   3257: new 570	java/io/BufferedReader
      //   3260: dup
      //   3261: new 572	java/io/InputStreamReader
      //   3264: dup
      //   3265: aload 22
      //   3267: invokespecial 573	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   3270: invokespecial 576	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   3273: astore 23
      //   3275: new 412	java/lang/StringBuilder
      //   3278: dup
      //   3279: invokespecial 413	java/lang/StringBuilder:<init>	()V
      //   3282: astore 25
      //   3284: aload 23
      //   3286: invokevirtual 579	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   3289: astore 26
      //   3291: aload 26
      //   3293: ifnull +147 -> 3440
      //   3296: aload_1
      //   3297: getfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   3300: ifeq +140 -> 3440
      //   3303: aload 25
      //   3305: aload 26
      //   3307: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3310: pop
      //   3311: goto -27 -> 3284
      //   3314: astore 23
      //   3316: aload 22
      //   3318: astore 25
      //   3320: aload 20
      //   3322: astore 26
      //   3324: iconst_0
      //   3325: istore 4
      //   3327: aload 23
      //   3329: astore 22
      //   3331: iload_2
      //   3332: istore_3
      //   3333: aload 21
      //   3335: astore 20
      //   3337: aload 25
      //   3339: astore 21
      //   3341: aload 26
      //   3343: astore 23
      //   3345: iload 4
      //   3347: istore_2
      //   3348: goto -2448 -> 900
      //   3351: aload 24
      //   3353: invokevirtual 565	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   3356: astore 22
      //   3358: goto -106 -> 3252
      //   3361: astore 23
      //   3363: ldc 75
      //   3365: aload 23
      //   3367: ldc_w 581
      //   3370: iconst_0
      //   3371: anewarray 4	java/lang/Object
      //   3374: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3377: ldc_w 295
      //   3380: aload 24
      //   3382: invokevirtual 556	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
      //   3385: invokevirtual 559	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   3388: ifeq +42 -> 3430
      //   3391: new 561	java/util/zip/GZIPInputStream
      //   3394: dup
      //   3395: aload 24
      //   3397: invokevirtual 584	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
      //   3400: invokespecial 568	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   3403: astore 22
      //   3405: goto -153 -> 3252
      //   3408: astore 22
      //   3410: ldc 75
      //   3412: aload 23
      //   3414: ldc_w 586
      //   3417: iconst_0
      //   3418: anewarray 4	java/lang/Object
      //   3421: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3424: aconst_null
      //   3425: astore 22
      //   3427: goto -175 -> 3252
      //   3430: aload 24
      //   3432: invokevirtual 584	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
      //   3435: astore 22
      //   3437: goto -185 -> 3252
      //   3440: aload 25
      //   3442: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3445: astore 23
      //   3447: aload 23
      //   3449: ldc_w 453
      //   3452: invokestatic 592	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   3455: invokevirtual 595	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   3458: arraylength
      //   3459: istore_3
      //   3460: ldc 75
      //   3462: ldc_w 597
      //   3465: iconst_3
      //   3466: anewarray 4	java/lang/Object
      //   3469: dup
      //   3470: iconst_0
      //   3471: aload 27
      //   3473: aastore
      //   3474: dup
      //   3475: iconst_1
      //   3476: aload 23
      //   3478: aastore
      //   3479: dup
      //   3480: iconst_2
      //   3481: iload_2
      //   3482: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3485: aastore
      //   3486: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3489: aload_1
      //   3490: getfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   3493: ifeq +151 -> 3644
      //   3496: aload_0
      //   3497: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   3500: aload 35
      //   3502: iconst_0
      //   3503: aload 23
      //   3505: iload_2
      //   3506: aload_1
      //   3507: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   3510: aload 24
      //   3512: invokestatic 361	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   3515: ldc 75
      //   3517: ldc_w 599
      //   3520: iconst_2
      //   3521: anewarray 4	java/lang/Object
      //   3524: dup
      //   3525: iconst_0
      //   3526: aload 32
      //   3528: aastore
      //   3529: dup
      //   3530: iconst_1
      //   3531: aload 33
      //   3533: aastore
      //   3534: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3537: iconst_1
      //   3538: istore 4
      //   3540: iload 4
      //   3542: ifeq +134 -> 3676
      //   3545: ldc 141
      //   3547: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3550: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   3553: aload_0
      //   3554: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   3557: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   3560: invokeinterface 156 1 0
      //   3565: aload_1
      //   3566: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   3569: ldc 161
      //   3571: aload_1
      //   3572: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   3575: lload 16
      //   3577: iload_3
      //   3578: i2l
      //   3579: iload_2
      //   3580: iconst_1
      //   3581: aload_1
      //   3582: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   3585: aconst_null
      //   3586: aload 34
      //   3588: invokeinterface 168 14 0
      //   3593: aload_1
      //   3594: iconst_0
      //   3595: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   3598: aload 21
      //   3600: ifnull +8 -> 3608
      //   3603: aload 21
      //   3605: invokevirtual 387	java/io/InputStream:close	()V
      //   3608: aload 22
      //   3610: ifnull +8 -> 3618
      //   3613: aload 22
      //   3615: invokevirtual 387	java/io/InputStream:close	()V
      //   3618: aload 20
      //   3620: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   3623: aload_0
      //   3624: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   3627: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   3630: aload_1
      //   3631: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   3634: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   3637: pop
      //   3638: ldc 43
      //   3640: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   3643: return
      //   3644: aload_0
      //   3645: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   3648: aload 35
      //   3650: iconst_m1
      //   3651: ldc 187
      //   3653: iload_2
      //   3654: aload_1
      //   3655: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   3658: aload 24
      //   3660: invokestatic 361	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   3663: ldc 75
      //   3665: ldc 189
      //   3667: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   3670: iconst_0
      //   3671: istore 4
      //   3673: goto -133 -> 3540
      //   3676: ldc 141
      //   3678: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3681: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   3684: aload_0
      //   3685: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   3688: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   3691: invokeinterface 156 1 0
      //   3696: aload_1
      //   3697: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   3700: ldc 161
      //   3702: aload_1
      //   3703: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   3706: lload 16
      //   3708: iload_3
      //   3709: i2l
      //   3710: iload_2
      //   3711: iconst_2
      //   3712: aload_1
      //   3713: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   3716: aconst_null
      //   3717: aload 34
      //   3719: invokeinterface 168 14 0
      //   3724: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   3727: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   3730: istore_2
      //   3731: iload_2
      //   3732: iconst_m1
      //   3733: if_icmpne +24 -> 3757
      //   3736: ldc 217
      //   3738: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3741: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   3744: ldc2_w 218
      //   3747: ldc2_w 374
      //   3750: lconst_1
      //   3751: iconst_0
      //   3752: invokeinterface 223 8 0
      //   3757: ldc 75
      //   3759: ldc_w 377
      //   3762: iconst_1
      //   3763: anewarray 4	java/lang/Object
      //   3766: dup
      //   3767: iconst_0
      //   3768: iload_2
      //   3769: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3772: aastore
      //   3773: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3776: goto -183 -> 3593
      //   3779: astore 21
      //   3781: ldc 75
      //   3783: aload 21
      //   3785: ldc_w 498
      //   3788: iconst_2
      //   3789: anewarray 4	java/lang/Object
      //   3792: dup
      //   3793: iconst_0
      //   3794: aload 32
      //   3796: aastore
      //   3797: dup
      //   3798: iconst_1
      //   3799: aload 33
      //   3801: aastore
      //   3802: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3805: goto -197 -> 3608
      //   3808: astore 21
      //   3810: ldc 75
      //   3812: aload 21
      //   3814: ldc_w 500
      //   3817: iconst_2
      //   3818: anewarray 4	java/lang/Object
      //   3821: dup
      //   3822: iconst_0
      //   3823: aload 32
      //   3825: aastore
      //   3826: dup
      //   3827: iconst_1
      //   3828: aload 33
      //   3830: aastore
      //   3831: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3834: goto -216 -> 3618
      //   3837: astore 21
      //   3839: ldc 75
      //   3841: aload 21
      //   3843: ldc_w 601
      //   3846: iconst_2
      //   3847: anewarray 4	java/lang/Object
      //   3850: dup
      //   3851: iconst_0
      //   3852: aload 32
      //   3854: aastore
      //   3855: dup
      //   3856: iconst_1
      //   3857: aload 33
      //   3859: aastore
      //   3860: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3863: goto -245 -> 3618
      //   3866: astore 21
      //   3868: ldc 75
      //   3870: aload 21
      //   3872: ldc_w 603
      //   3875: iconst_2
      //   3876: anewarray 4	java/lang/Object
      //   3879: dup
      //   3880: iconst_0
      //   3881: aload 32
      //   3883: aastore
      //   3884: dup
      //   3885: iconst_1
      //   3886: aload 33
      //   3888: aastore
      //   3889: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3892: goto -274 -> 3618
      //   3895: astore 20
      //   3897: ldc 75
      //   3899: aload 20
      //   3901: ldc_w 500
      //   3904: iconst_2
      //   3905: anewarray 4	java/lang/Object
      //   3908: dup
      //   3909: iconst_0
      //   3910: aload 32
      //   3912: aastore
      //   3913: dup
      //   3914: iconst_1
      //   3915: aload 33
      //   3917: aastore
      //   3918: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3921: goto -298 -> 3623
      //   3924: astore 20
      //   3926: ldc 75
      //   3928: aload 20
      //   3930: ldc_w 498
      //   3933: iconst_2
      //   3934: anewarray 4	java/lang/Object
      //   3937: dup
      //   3938: iconst_0
      //   3939: aload 32
      //   3941: aastore
      //   3942: dup
      //   3943: iconst_1
      //   3944: aload 33
      //   3946: aastore
      //   3947: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3950: goto -2872 -> 1078
      //   3953: astore 20
      //   3955: ldc 75
      //   3957: aload 20
      //   3959: ldc_w 500
      //   3962: iconst_2
      //   3963: anewarray 4	java/lang/Object
      //   3966: dup
      //   3967: iconst_0
      //   3968: aload 32
      //   3970: aastore
      //   3971: dup
      //   3972: iconst_1
      //   3973: aload 33
      //   3975: aastore
      //   3976: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3979: goto -2891 -> 1088
      //   3982: astore 20
      //   3984: ldc 75
      //   3986: aload 20
      //   3988: ldc_w 601
      //   3991: iconst_2
      //   3992: anewarray 4	java/lang/Object
      //   3995: dup
      //   3996: iconst_0
      //   3997: aload 32
      //   3999: aastore
      //   4000: dup
      //   4001: iconst_1
      //   4002: aload 33
      //   4004: aastore
      //   4005: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4008: goto -2920 -> 1088
      //   4011: astore 20
      //   4013: ldc 75
      //   4015: aload 20
      //   4017: ldc_w 603
      //   4020: iconst_2
      //   4021: anewarray 4	java/lang/Object
      //   4024: dup
      //   4025: iconst_0
      //   4026: aload 32
      //   4028: aastore
      //   4029: dup
      //   4030: iconst_1
      //   4031: aload 33
      //   4033: aastore
      //   4034: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4037: goto -2949 -> 1088
      //   4040: astore 20
      //   4042: ldc 75
      //   4044: aload 20
      //   4046: ldc_w 500
      //   4049: iconst_2
      //   4050: anewarray 4	java/lang/Object
      //   4053: dup
      //   4054: iconst_0
      //   4055: aload 32
      //   4057: aastore
      //   4058: dup
      //   4059: iconst_1
      //   4060: aload 33
      //   4062: aastore
      //   4063: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4066: goto -2968 -> 1098
      //   4069: astore 20
      //   4071: ldc 75
      //   4073: aload 20
      //   4075: ldc_w 498
      //   4078: iconst_2
      //   4079: anewarray 4	java/lang/Object
      //   4082: dup
      //   4083: iconst_0
      //   4084: aload 32
      //   4086: aastore
      //   4087: dup
      //   4088: iconst_1
      //   4089: aload 33
      //   4091: aastore
      //   4092: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4095: goto -2678 -> 1417
      //   4098: astore 20
      //   4100: ldc 75
      //   4102: aload 20
      //   4104: ldc_w 500
      //   4107: iconst_2
      //   4108: anewarray 4	java/lang/Object
      //   4111: dup
      //   4112: iconst_0
      //   4113: aload 32
      //   4115: aastore
      //   4116: dup
      //   4117: iconst_1
      //   4118: aload 33
      //   4120: aastore
      //   4121: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4124: goto -2697 -> 1427
      //   4127: astore 20
      //   4129: ldc 75
      //   4131: aload 20
      //   4133: ldc_w 601
      //   4136: iconst_2
      //   4137: anewarray 4	java/lang/Object
      //   4140: dup
      //   4141: iconst_0
      //   4142: aload 32
      //   4144: aastore
      //   4145: dup
      //   4146: iconst_1
      //   4147: aload 33
      //   4149: aastore
      //   4150: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4153: goto -2726 -> 1427
      //   4156: astore 20
      //   4158: ldc 75
      //   4160: aload 20
      //   4162: ldc_w 603
      //   4165: iconst_2
      //   4166: anewarray 4	java/lang/Object
      //   4169: dup
      //   4170: iconst_0
      //   4171: aload 32
      //   4173: aastore
      //   4174: dup
      //   4175: iconst_1
      //   4176: aload 33
      //   4178: aastore
      //   4179: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4182: goto -2755 -> 1427
      //   4185: astore 20
      //   4187: ldc 75
      //   4189: aload 20
      //   4191: ldc_w 500
      //   4194: iconst_2
      //   4195: anewarray 4	java/lang/Object
      //   4198: dup
      //   4199: iconst_0
      //   4200: aload 32
      //   4202: aastore
      //   4203: dup
      //   4204: iconst_1
      //   4205: aload 33
      //   4207: aastore
      //   4208: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4211: goto -2774 -> 1437
      //   4214: astore 20
      //   4216: ldc 75
      //   4218: aload 20
      //   4220: ldc_w 498
      //   4223: iconst_2
      //   4224: anewarray 4	java/lang/Object
      //   4227: dup
      //   4228: iconst_0
      //   4229: aload 32
      //   4231: aastore
      //   4232: dup
      //   4233: iconst_1
      //   4234: aload 33
      //   4236: aastore
      //   4237: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4240: goto -2271 -> 1969
      //   4243: astore 20
      //   4245: ldc 75
      //   4247: aload 20
      //   4249: ldc_w 500
      //   4252: iconst_2
      //   4253: anewarray 4	java/lang/Object
      //   4256: dup
      //   4257: iconst_0
      //   4258: aload 32
      //   4260: aastore
      //   4261: dup
      //   4262: iconst_1
      //   4263: aload 33
      //   4265: aastore
      //   4266: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4269: goto -2290 -> 1979
      //   4272: astore 20
      //   4274: ldc 75
      //   4276: aload 20
      //   4278: ldc_w 601
      //   4281: iconst_2
      //   4282: anewarray 4	java/lang/Object
      //   4285: dup
      //   4286: iconst_0
      //   4287: aload 32
      //   4289: aastore
      //   4290: dup
      //   4291: iconst_1
      //   4292: aload 33
      //   4294: aastore
      //   4295: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4298: goto -2319 -> 1979
      //   4301: astore 20
      //   4303: ldc 75
      //   4305: aload 20
      //   4307: ldc_w 603
      //   4310: iconst_2
      //   4311: anewarray 4	java/lang/Object
      //   4314: dup
      //   4315: iconst_0
      //   4316: aload 32
      //   4318: aastore
      //   4319: dup
      //   4320: iconst_1
      //   4321: aload 33
      //   4323: aastore
      //   4324: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4327: goto -2348 -> 1979
      //   4330: astore 20
      //   4332: ldc 75
      //   4334: aload 20
      //   4336: ldc_w 500
      //   4339: iconst_2
      //   4340: anewarray 4	java/lang/Object
      //   4343: dup
      //   4344: iconst_0
      //   4345: aload 32
      //   4347: aastore
      //   4348: dup
      //   4349: iconst_1
      //   4350: aload 33
      //   4352: aastore
      //   4353: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4356: goto -2367 -> 1989
      //   4359: astore 20
      //   4361: aconst_null
      //   4362: astore 27
      //   4364: aconst_null
      //   4365: astore 26
      //   4367: aconst_null
      //   4368: astore 22
      //   4370: lconst_0
      //   4371: lstore 16
      //   4373: iload 7
      //   4375: istore 5
      //   4377: aload 30
      //   4379: astore 23
      //   4381: iload 12
      //   4383: istore_2
      //   4384: iload_2
      //   4385: istore 4
      //   4387: aload 23
      //   4389: astore 25
      //   4391: aload 27
      //   4393: astore 24
      //   4395: aload 22
      //   4397: astore 21
      //   4399: iload 5
      //   4401: istore_3
      //   4402: lload 16
      //   4404: lstore 18
      //   4406: ldc 217
      //   4408: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4411: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   4414: ldc2_w 218
      //   4417: ldc2_w 604
      //   4420: lconst_1
      //   4421: iconst_0
      //   4422: invokeinterface 223 8 0
      //   4427: iload_2
      //   4428: istore 4
      //   4430: aload 23
      //   4432: astore 25
      //   4434: aload 27
      //   4436: astore 24
      //   4438: aload 22
      //   4440: astore 21
      //   4442: iload 5
      //   4444: istore_3
      //   4445: lload 16
      //   4447: lstore 18
      //   4449: ldc 75
      //   4451: aload 20
      //   4453: ldc_w 607
      //   4456: iconst_2
      //   4457: anewarray 4	java/lang/Object
      //   4460: dup
      //   4461: iconst_0
      //   4462: aload 32
      //   4464: aastore
      //   4465: dup
      //   4466: iconst_1
      //   4467: aload 33
      //   4469: aastore
      //   4470: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4473: iload_2
      //   4474: istore 4
      //   4476: aload 23
      //   4478: astore 25
      //   4480: aload 27
      //   4482: astore 24
      //   4484: aload 22
      //   4486: astore 21
      //   4488: iload 5
      //   4490: istore_3
      //   4491: lload 16
      //   4493: lstore 18
      //   4495: aload_0
      //   4496: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   4499: aload 35
      //   4501: iconst_m1
      //   4502: ldc_w 609
      //   4505: iload_2
      //   4506: aload_1
      //   4507: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   4510: aload 26
      //   4512: invokestatic 361	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   4515: ldc 141
      //   4517: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4520: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   4523: aload_0
      //   4524: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   4527: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   4530: invokeinterface 156 1 0
      //   4535: aload_1
      //   4536: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   4539: ldc 161
      //   4541: aload_1
      //   4542: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   4545: lload 16
      //   4547: iload 5
      //   4549: i2l
      //   4550: iload_2
      //   4551: iconst_2
      //   4552: aload_1
      //   4553: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   4556: aconst_null
      //   4557: aload 34
      //   4559: invokeinterface 168 14 0
      //   4564: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   4567: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   4570: istore_2
      //   4571: iload_2
      //   4572: iconst_m1
      //   4573: if_icmpne +24 -> 4597
      //   4576: ldc 217
      //   4578: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4581: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   4584: ldc2_w 218
      //   4587: ldc2_w 374
      //   4590: lconst_1
      //   4591: iconst_0
      //   4592: invokeinterface 223 8 0
      //   4597: ldc 75
      //   4599: ldc_w 377
      //   4602: iconst_1
      //   4603: anewarray 4	java/lang/Object
      //   4606: dup
      //   4607: iconst_0
      //   4608: iload_2
      //   4609: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   4612: aastore
      //   4613: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4616: aload_1
      //   4617: iconst_0
      //   4618: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   4621: aload 27
      //   4623: ifnull +8 -> 4631
      //   4626: aload 27
      //   4628: invokevirtual 387	java/io/InputStream:close	()V
      //   4631: aload 22
      //   4633: ifnull +8 -> 4641
      //   4636: aload 22
      //   4638: invokevirtual 387	java/io/InputStream:close	()V
      //   4641: aload 23
      //   4643: ifnull +8 -> 4651
      //   4646: aload 23
      //   4648: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   4651: aload_0
      //   4652: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   4655: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   4658: aload_1
      //   4659: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   4662: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   4665: pop
      //   4666: ldc 43
      //   4668: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   4671: return
      //   4672: astore 20
      //   4674: ldc 75
      //   4676: aload 20
      //   4678: ldc_w 498
      //   4681: iconst_2
      //   4682: anewarray 4	java/lang/Object
      //   4685: dup
      //   4686: iconst_0
      //   4687: aload 32
      //   4689: aastore
      //   4690: dup
      //   4691: iconst_1
      //   4692: aload 33
      //   4694: aastore
      //   4695: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4698: goto -67 -> 4631
      //   4701: astore 20
      //   4703: ldc 75
      //   4705: aload 20
      //   4707: ldc_w 500
      //   4710: iconst_2
      //   4711: anewarray 4	java/lang/Object
      //   4714: dup
      //   4715: iconst_0
      //   4716: aload 32
      //   4718: aastore
      //   4719: dup
      //   4720: iconst_1
      //   4721: aload 33
      //   4723: aastore
      //   4724: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4727: goto -86 -> 4641
      //   4730: astore 20
      //   4732: ldc 75
      //   4734: aload 20
      //   4736: ldc_w 601
      //   4739: iconst_2
      //   4740: anewarray 4	java/lang/Object
      //   4743: dup
      //   4744: iconst_0
      //   4745: aload 32
      //   4747: aastore
      //   4748: dup
      //   4749: iconst_1
      //   4750: aload 33
      //   4752: aastore
      //   4753: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4756: goto -115 -> 4641
      //   4759: astore 20
      //   4761: ldc 75
      //   4763: aload 20
      //   4765: ldc_w 603
      //   4768: iconst_2
      //   4769: anewarray 4	java/lang/Object
      //   4772: dup
      //   4773: iconst_0
      //   4774: aload 32
      //   4776: aastore
      //   4777: dup
      //   4778: iconst_1
      //   4779: aload 33
      //   4781: aastore
      //   4782: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4785: goto -144 -> 4641
      //   4788: astore 20
      //   4790: ldc 75
      //   4792: aload 20
      //   4794: ldc_w 500
      //   4797: iconst_2
      //   4798: anewarray 4	java/lang/Object
      //   4801: dup
      //   4802: iconst_0
      //   4803: aload 32
      //   4805: aastore
      //   4806: dup
      //   4807: iconst_1
      //   4808: aload 33
      //   4810: aastore
      //   4811: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4814: goto -163 -> 4651
      //   4817: astore 20
      //   4819: aconst_null
      //   4820: astore 27
      //   4822: aconst_null
      //   4823: astore 26
      //   4825: aconst_null
      //   4826: astore 22
      //   4828: lconst_0
      //   4829: lstore 16
      //   4831: iload 8
      //   4833: istore 5
      //   4835: aload 31
      //   4837: astore 23
      //   4839: iload 13
      //   4841: istore_2
      //   4842: iload_2
      //   4843: istore 4
      //   4845: aload 23
      //   4847: astore 25
      //   4849: aload 27
      //   4851: astore 24
      //   4853: aload 22
      //   4855: astore 21
      //   4857: iload 5
      //   4859: istore_3
      //   4860: lload 16
      //   4862: lstore 18
      //   4864: ldc 217
      //   4866: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4869: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   4872: ldc2_w 218
      //   4875: ldc2_w 610
      //   4878: lconst_1
      //   4879: iconst_0
      //   4880: invokeinterface 223 8 0
      //   4885: iload_2
      //   4886: istore 4
      //   4888: aload 23
      //   4890: astore 25
      //   4892: aload 27
      //   4894: astore 24
      //   4896: aload 22
      //   4898: astore 21
      //   4900: iload 5
      //   4902: istore_3
      //   4903: lload 16
      //   4905: lstore 18
      //   4907: ldc 75
      //   4909: aload 20
      //   4911: ldc_w 498
      //   4914: iconst_2
      //   4915: anewarray 4	java/lang/Object
      //   4918: dup
      //   4919: iconst_0
      //   4920: aload 32
      //   4922: aastore
      //   4923: dup
      //   4924: iconst_1
      //   4925: aload 33
      //   4927: aastore
      //   4928: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4931: iload_2
      //   4932: istore 4
      //   4934: aload 23
      //   4936: astore 25
      //   4938: aload 27
      //   4940: astore 24
      //   4942: aload 22
      //   4944: astore 21
      //   4946: iload 5
      //   4948: istore_3
      //   4949: lload 16
      //   4951: lstore 18
      //   4953: aload_0
      //   4954: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   4957: aload 35
      //   4959: iconst_m1
      //   4960: new 412	java/lang/StringBuilder
      //   4963: dup
      //   4964: invokespecial 413	java/lang/StringBuilder:<init>	()V
      //   4967: aload 20
      //   4969: invokevirtual 614	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   4972: invokevirtual 432	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   4975: invokevirtual 436	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   4978: iload_2
      //   4979: aload_1
      //   4980: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   4983: aload 26
      //   4985: invokestatic 361	com/tencent/mm/plugin/appbrand/s/g:a	(Lcom/tencent/mm/plugin/appbrand/s/g;Lcom/tencent/mm/plugin/appbrand/s/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   4988: ldc 141
      //   4990: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4993: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   4996: aload_0
      //   4997: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   5000: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   5003: invokeinterface 156 1 0
      //   5008: aload_1
      //   5009: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   5012: ldc 161
      //   5014: aload_1
      //   5015: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   5018: lload 16
      //   5020: iload 5
      //   5022: i2l
      //   5023: iload_2
      //   5024: iconst_2
      //   5025: aload_1
      //   5026: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   5029: aconst_null
      //   5030: aload 34
      //   5032: invokeinterface 168 14 0
      //   5037: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   5040: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   5043: istore_2
      //   5044: iload_2
      //   5045: iconst_m1
      //   5046: if_icmpne +24 -> 5070
      //   5049: ldc 217
      //   5051: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   5054: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   5057: ldc2_w 218
      //   5060: ldc2_w 374
      //   5063: lconst_1
      //   5064: iconst_0
      //   5065: invokeinterface 223 8 0
      //   5070: ldc 75
      //   5072: ldc_w 377
      //   5075: iconst_1
      //   5076: anewarray 4	java/lang/Object
      //   5079: dup
      //   5080: iconst_0
      //   5081: iload_2
      //   5082: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   5085: aastore
      //   5086: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5089: aload_1
      //   5090: iconst_0
      //   5091: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   5094: aload 27
      //   5096: ifnull +8 -> 5104
      //   5099: aload 27
      //   5101: invokevirtual 387	java/io/InputStream:close	()V
      //   5104: aload 22
      //   5106: ifnull +8 -> 5114
      //   5109: aload 22
      //   5111: invokevirtual 387	java/io/InputStream:close	()V
      //   5114: aload 23
      //   5116: ifnull +8 -> 5124
      //   5119: aload 23
      //   5121: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   5124: aload_0
      //   5125: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   5128: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   5131: aload_1
      //   5132: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   5135: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   5138: pop
      //   5139: ldc 43
      //   5141: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   5144: return
      //   5145: astore 20
      //   5147: ldc 75
      //   5149: aload 20
      //   5151: ldc_w 498
      //   5154: iconst_2
      //   5155: anewarray 4	java/lang/Object
      //   5158: dup
      //   5159: iconst_0
      //   5160: aload 32
      //   5162: aastore
      //   5163: dup
      //   5164: iconst_1
      //   5165: aload 33
      //   5167: aastore
      //   5168: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5171: goto -67 -> 5104
      //   5174: astore 20
      //   5176: ldc 75
      //   5178: aload 20
      //   5180: ldc_w 500
      //   5183: iconst_2
      //   5184: anewarray 4	java/lang/Object
      //   5187: dup
      //   5188: iconst_0
      //   5189: aload 32
      //   5191: aastore
      //   5192: dup
      //   5193: iconst_1
      //   5194: aload 33
      //   5196: aastore
      //   5197: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5200: goto -86 -> 5114
      //   5203: astore 20
      //   5205: ldc 75
      //   5207: aload 20
      //   5209: ldc_w 601
      //   5212: iconst_2
      //   5213: anewarray 4	java/lang/Object
      //   5216: dup
      //   5217: iconst_0
      //   5218: aload 32
      //   5220: aastore
      //   5221: dup
      //   5222: iconst_1
      //   5223: aload 33
      //   5225: aastore
      //   5226: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5229: goto -115 -> 5114
      //   5232: astore 20
      //   5234: ldc 75
      //   5236: aload 20
      //   5238: ldc_w 603
      //   5241: iconst_2
      //   5242: anewarray 4	java/lang/Object
      //   5245: dup
      //   5246: iconst_0
      //   5247: aload 32
      //   5249: aastore
      //   5250: dup
      //   5251: iconst_1
      //   5252: aload 33
      //   5254: aastore
      //   5255: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5258: goto -144 -> 5114
      //   5261: astore 20
      //   5263: ldc 75
      //   5265: aload 20
      //   5267: ldc_w 500
      //   5270: iconst_2
      //   5271: anewarray 4	java/lang/Object
      //   5274: dup
      //   5275: iconst_0
      //   5276: aload 32
      //   5278: aastore
      //   5279: dup
      //   5280: iconst_1
      //   5281: aload 33
      //   5283: aastore
      //   5284: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5287: goto -163 -> 5124
      //   5290: astore 20
      //   5292: aconst_null
      //   5293: astore 24
      //   5295: aconst_null
      //   5296: astore 22
      //   5298: lconst_0
      //   5299: lstore 16
      //   5301: iload 9
      //   5303: istore_3
      //   5304: aload 26
      //   5306: astore 23
      //   5308: iload 14
      //   5310: istore_2
      //   5311: ldc 141
      //   5313: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   5316: checkcast 141	com/tencent/mm/plugin/appbrand/s/o
      //   5319: aload_0
      //   5320: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   5323: getfield 151	com/tencent/mm/plugin/appbrand/s/g:okQ	Lcom/tencent/mm/plugin/appbrand/jsapi/e;
      //   5326: invokeinterface 156 1 0
      //   5331: aload_1
      //   5332: getfield 159	com/tencent/mm/plugin/appbrand/s/h:qjg	Ljava/lang/String;
      //   5335: ldc 161
      //   5337: aload_1
      //   5338: getfield 55	com/tencent/mm/plugin/appbrand/s/h:mUrl	Ljava/lang/String;
      //   5341: lload 16
      //   5343: iload_3
      //   5344: i2l
      //   5345: iload_2
      //   5346: iconst_2
      //   5347: aload_1
      //   5348: invokevirtual 165	com/tencent/mm/plugin/appbrand/s/h:cbQ	()I
      //   5351: aconst_null
      //   5352: aload 34
      //   5354: invokeinterface 168 14 0
      //   5359: invokestatic 367	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
      //   5362: invokestatic 373	com/tencent/mm/sdk/platformtools/NetStatusUtil:getNetType	(Landroid/content/Context;)I
      //   5365: istore_2
      //   5366: iload_2
      //   5367: iconst_m1
      //   5368: if_icmpne +24 -> 5392
      //   5371: ldc 217
      //   5373: invokestatic 147	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   5376: checkcast 217	com/tencent/mm/plugin/appbrand/w/a
      //   5379: ldc2_w 218
      //   5382: ldc2_w 374
      //   5385: lconst_1
      //   5386: iconst_0
      //   5387: invokeinterface 223 8 0
      //   5392: ldc 75
      //   5394: ldc_w 377
      //   5397: iconst_1
      //   5398: anewarray 4	java/lang/Object
      //   5401: dup
      //   5402: iconst_0
      //   5403: iload_2
      //   5404: invokestatic 382	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   5407: aastore
      //   5408: invokestatic 172	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5411: aload_1
      //   5412: iconst_0
      //   5413: putfield 185	com/tencent/mm/plugin/appbrand/s/h:isRunning	Z
      //   5416: aload 24
      //   5418: ifnull +8 -> 5426
      //   5421: aload 24
      //   5423: invokevirtual 387	java/io/InputStream:close	()V
      //   5426: aload 22
      //   5428: ifnull +8 -> 5436
      //   5431: aload 22
      //   5433: invokevirtual 387	java/io/InputStream:close	()V
      //   5436: aload 23
      //   5438: ifnull +8 -> 5446
      //   5441: aload 23
      //   5443: invokevirtual 390	java/io/DataOutputStream:close	()V
      //   5446: aload_0
      //   5447: getfield 17	com/tencent/mm/plugin/appbrand/s/g$b:qjq	Lcom/tencent/mm/plugin/appbrand/s/g;
      //   5450: getfield 393	com/tencent/mm/plugin/appbrand/s/g:qiB	Ljava/util/ArrayList;
      //   5453: aload_1
      //   5454: getfield 133	com/tencent/mm/plugin/appbrand/s/h:mvB	Ljava/lang/String;
      //   5457: invokevirtual 399	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   5460: pop
      //   5461: ldc 43
      //   5463: invokestatic 175	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   5466: aload 20
      //   5468: athrow
      //   5469: astore 21
      //   5471: ldc 75
      //   5473: aload 21
      //   5475: ldc_w 498
      //   5478: iconst_2
      //   5479: anewarray 4	java/lang/Object
      //   5482: dup
      //   5483: iconst_0
      //   5484: aload 32
      //   5486: aastore
      //   5487: dup
      //   5488: iconst_1
      //   5489: aload 33
      //   5491: aastore
      //   5492: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5495: goto -69 -> 5426
      //   5498: astore 21
      //   5500: ldc 75
      //   5502: aload 21
      //   5504: ldc_w 500
      //   5507: iconst_2
      //   5508: anewarray 4	java/lang/Object
      //   5511: dup
      //   5512: iconst_0
      //   5513: aload 32
      //   5515: aastore
      //   5516: dup
      //   5517: iconst_1
      //   5518: aload 33
      //   5520: aastore
      //   5521: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5524: goto -88 -> 5436
      //   5527: astore 21
      //   5529: ldc 75
      //   5531: aload 21
      //   5533: ldc_w 601
      //   5536: iconst_2
      //   5537: anewarray 4	java/lang/Object
      //   5540: dup
      //   5541: iconst_0
      //   5542: aload 32
      //   5544: aastore
      //   5545: dup
      //   5546: iconst_1
      //   5547: aload 33
      //   5549: aastore
      //   5550: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5553: goto -117 -> 5436
      //   5556: astore 21
      //   5558: ldc 75
      //   5560: aload 21
      //   5562: ldc_w 603
      //   5565: iconst_2
      //   5566: anewarray 4	java/lang/Object
      //   5569: dup
      //   5570: iconst_0
      //   5571: aload 32
      //   5573: aastore
      //   5574: dup
      //   5575: iconst_1
      //   5576: aload 33
      //   5578: aastore
      //   5579: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5582: goto -146 -> 5436
      //   5585: astore 21
      //   5587: ldc 75
      //   5589: aload 21
      //   5591: ldc_w 500
      //   5594: iconst_2
      //   5595: anewarray 4	java/lang/Object
      //   5598: dup
      //   5599: iconst_0
      //   5600: aload 32
      //   5602: aastore
      //   5603: dup
      //   5604: iconst_1
      //   5605: aload 33
      //   5607: aastore
      //   5608: invokestatic 181	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5611: goto -165 -> 5446
      //   5614: astore 20
      //   5616: aconst_null
      //   5617: astore 22
      //   5619: lconst_0
      //   5620: lstore 16
      //   5622: iload 14
      //   5624: istore_2
      //   5625: aload 26
      //   5627: astore 23
      //   5629: aload 21
      //   5631: astore 24
      //   5633: iload 9
      //   5635: istore_3
      //   5636: goto -325 -> 5311
      //   5639: astore 24
      //   5641: aconst_null
      //   5642: astore 22
      //   5644: aload 20
      //   5646: astore 23
      //   5648: lconst_0
      //   5649: lstore 16
      //   5651: aload 24
      //   5653: astore 20
      //   5655: iload 14
      //   5657: istore_2
      //   5658: aload 21
      //   5660: astore 24
      //   5662: iload 9
      //   5664: istore_3
      //   5665: goto -354 -> 5311
      //   5668: astore 24
      //   5670: aconst_null
      //   5671: astore 22
      //   5673: aload 20
      //   5675: astore 23
      //   5677: aload 24
      //   5679: astore 20
      //   5681: iload 14
      //   5683: istore_2
      //   5684: aload 21
      //   5686: astore 24
      //   5688: iload 9
      //   5690: istore_3
      //   5691: goto -380 -> 5311
      //   5694: astore 24
      //   5696: aconst_null
      //   5697: astore 22
      //   5699: aload 20
      //   5701: astore 23
      //   5703: aload 24
      //   5705: astore 20
      //   5707: iload 14
      //   5709: istore_2
      //   5710: aload 21
      //   5712: astore 24
      //   5714: iload 9
      //   5716: istore_3
      //   5717: goto -406 -> 5311
      //   5720: astore 24
      //   5722: aconst_null
      //   5723: astore 22
      //   5725: aload 20
      //   5727: astore 23
      //   5729: aload 24
      //   5731: astore 20
      //   5733: aload 21
      //   5735: astore 24
      //   5737: iload 9
      //   5739: istore_3
      //   5740: goto -429 -> 5311
      //   5743: astore 24
      //   5745: aload 20
      //   5747: astore 23
      //   5749: aload 24
      //   5751: astore 20
      //   5753: aload 21
      //   5755: astore 24
      //   5757: iload 9
      //   5759: istore_3
      //   5760: goto -449 -> 5311
      //   5763: astore 24
      //   5765: aload 20
      //   5767: astore 23
      //   5769: aload 24
      //   5771: astore 20
      //   5773: aload 21
      //   5775: astore 24
      //   5777: goto -466 -> 5311
      //   5780: astore 24
      //   5782: aload 20
      //   5784: astore 23
      //   5786: aload 24
      //   5788: astore 20
      //   5790: aload 21
      //   5792: astore 24
      //   5794: goto -483 -> 5311
      //   5797: astore 22
      //   5799: aload 20
      //   5801: astore 24
      //   5803: iload_2
      //   5804: istore 4
      //   5806: aload 22
      //   5808: astore 20
      //   5810: iload_3
      //   5811: istore_2
      //   5812: aload 21
      //   5814: astore 22
      //   5816: iload 4
      //   5818: istore_3
      //   5819: goto -508 -> 5311
      //   5822: astore 20
      //   5824: lload 18
      //   5826: lstore 16
      //   5828: iload 4
      //   5830: istore_2
      //   5831: aload 25
      //   5833: astore 23
      //   5835: aload 21
      //   5837: astore 22
      //   5839: goto -528 -> 5311
      //   5842: astore 20
      //   5844: aconst_null
      //   5845: astore 26
      //   5847: aconst_null
      //   5848: astore 22
      //   5850: lconst_0
      //   5851: lstore 16
      //   5853: iload 13
      //   5855: istore_2
      //   5856: aload 31
      //   5858: astore 23
      //   5860: aload 21
      //   5862: astore 27
      //   5864: iload 8
      //   5866: istore 5
      //   5868: goto -1026 -> 4842
      //   5871: astore 20
      //   5873: aconst_null
      //   5874: astore 22
      //   5876: lconst_0
      //   5877: lstore 16
      //   5879: iload 13
      //   5881: istore_2
      //   5882: aload 31
      //   5884: astore 23
      //   5886: aload 24
      //   5888: astore 26
      //   5890: aload 21
      //   5892: astore 27
      //   5894: iload 8
      //   5896: istore 5
      //   5898: goto -1056 -> 4842
      //   5901: astore 22
      //   5903: aconst_null
      //   5904: astore 25
      //   5906: aload 20
      //   5908: astore 23
      //   5910: lconst_0
      //   5911: lstore 16
      //   5913: aload 22
      //   5915: astore 20
      //   5917: iload 13
      //   5919: istore_2
      //   5920: aload 24
      //   5922: astore 26
      //   5924: aload 21
      //   5926: astore 27
      //   5928: aload 25
      //   5930: astore 22
      //   5932: iload 8
      //   5934: istore 5
      //   5936: goto -1094 -> 4842
      //   5939: astore 22
      //   5941: aconst_null
      //   5942: astore 25
      //   5944: aload 20
      //   5946: astore 23
      //   5948: aload 22
      //   5950: astore 20
      //   5952: iload 13
      //   5954: istore_2
      //   5955: aload 24
      //   5957: astore 26
      //   5959: aload 21
      //   5961: astore 27
      //   5963: aload 25
      //   5965: astore 22
      //   5967: iload 8
      //   5969: istore 5
      //   5971: goto -1129 -> 4842
      //   5974: astore 22
      //   5976: aconst_null
      //   5977: astore 25
      //   5979: aload 20
      //   5981: astore 23
      //   5983: aload 22
      //   5985: astore 20
      //   5987: iload 13
      //   5989: istore_2
      //   5990: aload 24
      //   5992: astore 26
      //   5994: aload 21
      //   5996: astore 27
      //   5998: aload 25
      //   6000: astore 22
      //   6002: iload 8
      //   6004: istore 5
      //   6006: goto -1164 -> 4842
      //   6009: astore 22
      //   6011: aconst_null
      //   6012: astore 25
      //   6014: aload 20
      //   6016: astore 23
      //   6018: aload 22
      //   6020: astore 20
      //   6022: aload 24
      //   6024: astore 26
      //   6026: aload 21
      //   6028: astore 27
      //   6030: aload 25
      //   6032: astore 22
      //   6034: iload 8
      //   6036: istore 5
      //   6038: goto -1196 -> 4842
      //   6041: astore 23
      //   6043: aload 20
      //   6045: astore 25
      //   6047: aload 23
      //   6049: astore 20
      //   6051: aload 25
      //   6053: astore 23
      //   6055: aload 24
      //   6057: astore 26
      //   6059: aload 21
      //   6061: astore 27
      //   6063: iload 8
      //   6065: istore 5
      //   6067: goto -1225 -> 4842
      //   6070: astore 23
      //   6072: aload 20
      //   6074: astore 25
      //   6076: aload 23
      //   6078: astore 20
      //   6080: aload 25
      //   6082: astore 23
      //   6084: aload 24
      //   6086: astore 26
      //   6088: aload 21
      //   6090: astore 27
      //   6092: iload_3
      //   6093: istore 5
      //   6095: goto -1253 -> 4842
      //   6098: astore 23
      //   6100: aload 20
      //   6102: astore 25
      //   6104: aload 23
      //   6106: astore 20
      //   6108: aload 25
      //   6110: astore 23
      //   6112: aload 24
      //   6114: astore 26
      //   6116: aload 21
      //   6118: astore 27
      //   6120: iload_3
      //   6121: istore 5
      //   6123: goto -1281 -> 4842
      //   6126: astore 20
      //   6128: aconst_null
      //   6129: astore 26
      //   6131: aconst_null
      //   6132: astore 22
      //   6134: lconst_0
      //   6135: lstore 16
      //   6137: iload 12
      //   6139: istore_2
      //   6140: aload 30
      //   6142: astore 23
      //   6144: aload 21
      //   6146: astore 27
      //   6148: iload 7
      //   6150: istore 5
      //   6152: goto -1768 -> 4384
      //   6155: astore 20
      //   6157: aconst_null
      //   6158: astore 22
      //   6160: lconst_0
      //   6161: lstore 16
      //   6163: iload 12
      //   6165: istore_2
      //   6166: aload 30
      //   6168: astore 23
      //   6170: aload 24
      //   6172: astore 26
      //   6174: aload 21
      //   6176: astore 27
      //   6178: iload 7
      //   6180: istore 5
      //   6182: goto -1798 -> 4384
      //   6185: astore 22
      //   6187: aconst_null
      //   6188: astore 25
      //   6190: aload 20
      //   6192: astore 23
      //   6194: lconst_0
      //   6195: lstore 16
      //   6197: aload 22
      //   6199: astore 20
      //   6201: iload 12
      //   6203: istore_2
      //   6204: aload 24
      //   6206: astore 26
      //   6208: aload 21
      //   6210: astore 27
      //   6212: aload 25
      //   6214: astore 22
      //   6216: iload 7
      //   6218: istore 5
      //   6220: goto -1836 -> 4384
      //   6223: astore 22
      //   6225: aconst_null
      //   6226: astore 25
      //   6228: aload 20
      //   6230: astore 23
      //   6232: aload 22
      //   6234: astore 20
      //   6236: iload 12
      //   6238: istore_2
      //   6239: aload 24
      //   6241: astore 26
      //   6243: aload 21
      //   6245: astore 27
      //   6247: aload 25
      //   6249: astore 22
      //   6251: iload 7
      //   6253: istore 5
      //   6255: goto -1871 -> 4384
      //   6258: astore 22
      //   6260: aconst_null
      //   6261: astore 25
      //   6263: aload 20
      //   6265: astore 23
      //   6267: aload 22
      //   6269: astore 20
      //   6271: iload 12
      //   6273: istore_2
      //   6274: aload 24
      //   6276: astore 26
      //   6278: aload 21
      //   6280: astore 27
      //   6282: aload 25
      //   6284: astore 22
      //   6286: iload 7
      //   6288: istore 5
      //   6290: goto -1906 -> 4384
      //   6293: astore 22
      //   6295: aconst_null
      //   6296: astore 25
      //   6298: aload 20
      //   6300: astore 23
      //   6302: aload 22
      //   6304: astore 20
      //   6306: aload 24
      //   6308: astore 26
      //   6310: aload 21
      //   6312: astore 27
      //   6314: aload 25
      //   6316: astore 22
      //   6318: iload 7
      //   6320: istore 5
      //   6322: goto -1938 -> 4384
      //   6325: astore 23
      //   6327: aload 20
      //   6329: astore 25
      //   6331: aload 23
      //   6333: astore 20
      //   6335: aload 25
      //   6337: astore 23
      //   6339: aload 24
      //   6341: astore 26
      //   6343: aload 21
      //   6345: astore 27
      //   6347: iload 7
      //   6349: istore 5
      //   6351: goto -1967 -> 4384
      //   6354: astore 23
      //   6356: aload 20
      //   6358: astore 25
      //   6360: aload 23
      //   6362: astore 20
      //   6364: aload 25
      //   6366: astore 23
      //   6368: aload 24
      //   6370: astore 26
      //   6372: aload 21
      //   6374: astore 27
      //   6376: iload_3
      //   6377: istore 5
      //   6379: goto -1995 -> 4384
      //   6382: astore 23
      //   6384: aload 20
      //   6386: astore 25
      //   6388: aload 23
      //   6390: astore 20
      //   6392: aload 25
      //   6394: astore 23
      //   6396: aload 24
      //   6398: astore 26
      //   6400: aload 21
      //   6402: astore 27
      //   6404: iload_3
      //   6405: istore 5
      //   6407: goto -2023 -> 4384
      //   6410: astore 20
      //   6412: aconst_null
      //   6413: astore 27
      //   6415: aconst_null
      //   6416: astore 26
      //   6418: aconst_null
      //   6419: astore 22
      //   6421: lconst_0
      //   6422: lstore 16
      //   6424: iload 11
      //   6426: istore_2
      //   6427: aload 29
      //   6429: astore 23
      //   6431: iload 6
      //   6433: istore 5
      //   6435: goto -4713 -> 1722
      //   6438: astore 20
      //   6440: aconst_null
      //   6441: astore 26
      //   6443: aconst_null
      //   6444: astore 22
      //   6446: lconst_0
      //   6447: lstore 16
      //   6449: iload 11
      //   6451: istore_2
      //   6452: aload 29
      //   6454: astore 23
      //   6456: aload 21
      //   6458: astore 27
      //   6460: iload 6
      //   6462: istore 5
      //   6464: goto -4742 -> 1722
      //   6467: astore 22
      //   6469: aconst_null
      //   6470: astore 25
      //   6472: aload 20
      //   6474: astore 23
      //   6476: lconst_0
      //   6477: lstore 16
      //   6479: aload 22
      //   6481: astore 20
      //   6483: iload 11
      //   6485: istore_2
      //   6486: aload 24
      //   6488: astore 26
      //   6490: aload 21
      //   6492: astore 27
      //   6494: aload 25
      //   6496: astore 22
      //   6498: iload 6
      //   6500: istore 5
      //   6502: goto -4780 -> 1722
      //   6505: astore 22
      //   6507: aconst_null
      //   6508: astore 25
      //   6510: aload 20
      //   6512: astore 23
      //   6514: aload 22
      //   6516: astore 20
      //   6518: iload 11
      //   6520: istore_2
      //   6521: aload 24
      //   6523: astore 26
      //   6525: aload 21
      //   6527: astore 27
      //   6529: aload 25
      //   6531: astore 22
      //   6533: iload 6
      //   6535: istore 5
      //   6537: goto -4815 -> 1722
      //   6540: astore 22
      //   6542: aconst_null
      //   6543: astore 25
      //   6545: aload 20
      //   6547: astore 23
      //   6549: aload 22
      //   6551: astore 20
      //   6553: iload 11
      //   6555: istore_2
      //   6556: aload 24
      //   6558: astore 26
      //   6560: aload 21
      //   6562: astore 27
      //   6564: aload 25
      //   6566: astore 22
      //   6568: iload 6
      //   6570: istore 5
      //   6572: goto -4850 -> 1722
      //   6575: astore 22
      //   6577: aconst_null
      //   6578: astore 25
      //   6580: aload 20
      //   6582: astore 23
      //   6584: aload 22
      //   6586: astore 20
      //   6588: aload 24
      //   6590: astore 26
      //   6592: aload 21
      //   6594: astore 27
      //   6596: aload 25
      //   6598: astore 22
      //   6600: iload 6
      //   6602: istore 5
      //   6604: goto -4882 -> 1722
      //   6607: astore 23
      //   6609: aload 20
      //   6611: astore 25
      //   6613: aload 23
      //   6615: astore 20
      //   6617: aload 25
      //   6619: astore 23
      //   6621: aload 24
      //   6623: astore 26
      //   6625: aload 21
      //   6627: astore 27
      //   6629: iload 6
      //   6631: istore 5
      //   6633: goto -4911 -> 1722
      //   6636: astore 23
      //   6638: aload 20
      //   6640: astore 25
      //   6642: aload 23
      //   6644: astore 20
      //   6646: aload 25
      //   6648: astore 23
      //   6650: aload 24
      //   6652: astore 26
      //   6654: aload 21
      //   6656: astore 27
      //   6658: iload_3
      //   6659: istore 5
      //   6661: goto -4939 -> 1722
      //   6664: astore 23
      //   6666: aload 20
      //   6668: astore 25
      //   6670: aload 23
      //   6672: astore 20
      //   6674: aload 25
      //   6676: astore 23
      //   6678: aload 24
      //   6680: astore 26
      //   6682: aload 21
      //   6684: astore 27
      //   6686: iload_3
      //   6687: istore 5
      //   6689: goto -4967 -> 1722
      //   6692: astore 20
      //   6694: aconst_null
      //   6695: astore 27
      //   6697: aconst_null
      //   6698: astore 26
      //   6700: aconst_null
      //   6701: astore 22
      //   6703: lconst_0
      //   6704: lstore 16
      //   6706: iload 10
      //   6708: istore_2
      //   6709: aload 28
      //   6711: astore 23
      //   6713: goto -5543 -> 1170
      //   6716: astore 20
      //   6718: aconst_null
      //   6719: astore 26
      //   6721: aconst_null
      //   6722: astore 22
      //   6724: lconst_0
      //   6725: lstore 16
      //   6727: iload 10
      //   6729: istore_2
      //   6730: aload 28
      //   6732: astore 23
      //   6734: aload 21
      //   6736: astore 27
      //   6738: goto -5568 -> 1170
      //   6741: astore 22
      //   6743: aconst_null
      //   6744: astore 25
      //   6746: aload 20
      //   6748: astore 23
      //   6750: lconst_0
      //   6751: lstore 16
      //   6753: aload 22
      //   6755: astore 20
      //   6757: iload 10
      //   6759: istore_2
      //   6760: aload 24
      //   6762: astore 26
      //   6764: aload 21
      //   6766: astore 27
      //   6768: aload 25
      //   6770: astore 22
      //   6772: goto -5602 -> 1170
      //   6775: astore 22
      //   6777: aconst_null
      //   6778: astore 25
      //   6780: aload 20
      //   6782: astore 23
      //   6784: aload 22
      //   6786: astore 20
      //   6788: iload 10
      //   6790: istore_2
      //   6791: aload 24
      //   6793: astore 26
      //   6795: aload 21
      //   6797: astore 27
      //   6799: aload 25
      //   6801: astore 22
      //   6803: goto -5633 -> 1170
      //   6806: astore 22
      //   6808: aconst_null
      //   6809: astore 25
      //   6811: aload 20
      //   6813: astore 23
      //   6815: aload 22
      //   6817: astore 20
      //   6819: iload 10
      //   6821: istore_2
      //   6822: aload 24
      //   6824: astore 26
      //   6826: aload 21
      //   6828: astore 27
      //   6830: aload 25
      //   6832: astore 22
      //   6834: goto -5664 -> 1170
      //   6837: astore 22
      //   6839: aconst_null
      //   6840: astore 25
      //   6842: aload 20
      //   6844: astore 23
      //   6846: aload 22
      //   6848: astore 20
      //   6850: aload 24
      //   6852: astore 26
      //   6854: aload 21
      //   6856: astore 27
      //   6858: aload 25
      //   6860: astore 22
      //   6862: goto -5692 -> 1170
      //   6865: astore 23
      //   6867: aload 20
      //   6869: astore 25
      //   6871: aload 23
      //   6873: astore 20
      //   6875: aload 25
      //   6877: astore 23
      //   6879: aload 24
      //   6881: astore 26
      //   6883: aload 21
      //   6885: astore 27
      //   6887: goto -5717 -> 1170
      //   6890: astore 23
      //   6892: aload 20
      //   6894: astore 25
      //   6896: aload 23
      //   6898: astore 20
      //   6900: aload 25
      //   6902: astore 23
      //   6904: aload 24
      //   6906: astore 26
      //   6908: aload 21
      //   6910: astore 27
      //   6912: iload_3
      //   6913: istore 5
      //   6915: goto -5745 -> 1170
      //   6918: astore 23
      //   6920: aload 20
      //   6922: astore 25
      //   6924: aload 23
      //   6926: astore 20
      //   6928: aload 25
      //   6930: astore 23
      //   6932: aload 24
      //   6934: astore 26
      //   6936: aload 21
      //   6938: astore 27
      //   6940: iload_3
      //   6941: istore 5
      //   6943: goto -5773 -> 1170
      //   6946: astore 22
      //   6948: aconst_null
      //   6949: astore 20
      //   6951: aconst_null
      //   6952: astore 24
      //   6954: aconst_null
      //   6955: astore 21
      //   6957: lconst_0
      //   6958: lstore 16
      //   6960: iconst_0
      //   6961: istore_2
      //   6962: iload 4
      //   6964: istore_3
      //   6965: aload 25
      //   6967: astore 23
      //   6969: goto -6069 -> 900
      //   6972: astore 22
      //   6974: aload 21
      //   6976: astore 20
      //   6978: aconst_null
      //   6979: astore 24
      //   6981: aconst_null
      //   6982: astore 21
      //   6984: lconst_0
      //   6985: lstore 16
      //   6987: iconst_0
      //   6988: istore_2
      //   6989: iload 4
      //   6991: istore_3
      //   6992: aload 25
      //   6994: astore 23
      //   6996: goto -6096 -> 900
      //   6999: astore 22
      //   7001: aconst_null
      //   7002: astore 25
      //   7004: aload 20
      //   7006: astore 23
      //   7008: lconst_0
      //   7009: lstore 16
      //   7011: iconst_0
      //   7012: istore_2
      //   7013: iload 4
      //   7015: istore_3
      //   7016: aload 21
      //   7018: astore 20
      //   7020: aload 25
      //   7022: astore 21
      //   7024: goto -6124 -> 900
      //   7027: astore 22
      //   7029: aconst_null
      //   7030: astore 25
      //   7032: aload 20
      //   7034: astore 23
      //   7036: iconst_0
      //   7037: istore_2
      //   7038: iload 4
      //   7040: istore_3
      //   7041: aload 21
      //   7043: astore 20
      //   7045: aload 25
      //   7047: astore 21
      //   7049: goto -6149 -> 900
      //   7052: astore 22
      //   7054: aconst_null
      //   7055: astore 25
      //   7057: aload 20
      //   7059: astore 23
      //   7061: iconst_0
      //   7062: istore_2
      //   7063: iload 4
      //   7065: istore_3
      //   7066: aload 21
      //   7068: astore 20
      //   7070: aload 25
      //   7072: astore 21
      //   7074: goto -6174 -> 900
      //   7077: astore 22
      //   7079: aconst_null
      //   7080: astore 25
      //   7082: aload 20
      //   7084: astore 23
      //   7086: iconst_0
      //   7087: istore 4
      //   7089: iload_2
      //   7090: istore_3
      //   7091: aload 21
      //   7093: astore 20
      //   7095: aload 25
      //   7097: astore 21
      //   7099: iload 4
      //   7101: istore_2
      //   7102: goto -6202 -> 900
      //   7105: astore 23
      //   7107: aload 22
      //   7109: astore 25
      //   7111: aload 20
      //   7113: astore 26
      //   7115: iload_3
      //   7116: istore 4
      //   7118: aload 23
      //   7120: astore 22
      //   7122: iload_2
      //   7123: istore_3
      //   7124: aload 21
      //   7126: astore 20
      //   7128: aload 25
      //   7130: astore 21
      //   7132: aload 26
      //   7134: astore 23
      //   7136: iload 4
      //   7138: istore_2
      //   7139: goto -6239 -> 900
      //   7142: astore 23
      //   7144: aload 22
      //   7146: astore 25
      //   7148: aload 20
      //   7150: astore 26
      //   7152: iload_3
      //   7153: istore 4
      //   7155: aload 23
      //   7157: astore 22
      //   7159: iload_2
      //   7160: istore_3
      //   7161: aload 21
      //   7163: astore 20
      //   7165: aload 25
      //   7167: astore 21
      //   7169: aload 26
      //   7171: astore 23
      //   7173: iload 4
      //   7175: istore_2
      //   7176: goto -6276 -> 900
      //   7179: ldc_w 616
      //   7182: astore 23
      //   7184: iconst_0
      //   7185: istore_3
      //   7186: goto -3697 -> 3489
      //   7189: goto -4868 -> 2321
      //   7192: goto -4972 -> 2220
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	7195	0	this	b
      //   0	7195	1	paramh	h
      //   892	6284	2	i	int
      //   899	6287	3	j	int
      //   99	7075	4	k	int
      //   81	6861	5	m	int
      //   69	6561	6	n	int
      //   72	6276	7	i1	int
      //   75	5989	8	i2	int
      //   78	5680	9	i3	int
      //   84	6736	10	i4	int
      //   87	6467	11	i5	int
      //   90	6182	12	i6	int
      //   93	5895	13	i7	int
      //   96	5612	14	i8	int
      //   2610	54	15	i9	int
      //   889	6121	16	l1	long
      //   1190	4635	18	l2	long
      //   21	1053	20	localObject1	Object
      //   1147	91	20	localFileNotFoundException1	java.io.FileNotFoundException
      //   1695	361	20	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
      //   2181	306	20	localObject2	Object
      //   2541	336	20	localIOException1	java.io.IOException
      //   2931	193	20	localIOException2	java.io.IOException
      //   3178	143	20	localIOException3	java.io.IOException
      //   3335	284	20	localObject3	Object
      //   3895	5	20	localIOException4	java.io.IOException
      //   3924	5	20	localException1	Exception
      //   3953	5	20	localIOException5	java.io.IOException
      //   3982	5	20	localArrayIndexOutOfBoundsException1	java.lang.ArrayIndexOutOfBoundsException
      //   4011	5	20	localThrowable1	java.lang.Throwable
      //   4040	5	20	localIOException6	java.io.IOException
      //   4069	5	20	localException2	Exception
      //   4098	5	20	localIOException7	java.io.IOException
      //   4127	5	20	localArrayIndexOutOfBoundsException2	java.lang.ArrayIndexOutOfBoundsException
      //   4156	5	20	localThrowable2	java.lang.Throwable
      //   4185	5	20	localIOException8	java.io.IOException
      //   4214	5	20	localException3	Exception
      //   4243	5	20	localIOException9	java.io.IOException
      //   4272	5	20	localArrayIndexOutOfBoundsException3	java.lang.ArrayIndexOutOfBoundsException
      //   4301	5	20	localThrowable3	java.lang.Throwable
      //   4330	5	20	localIOException10	java.io.IOException
      //   4359	93	20	localSocketTimeoutException1	java.net.SocketTimeoutException
      //   4672	5	20	localException4	Exception
      //   4701	5	20	localIOException11	java.io.IOException
      //   4730	5	20	localArrayIndexOutOfBoundsException4	java.lang.ArrayIndexOutOfBoundsException
      //   4759	5	20	localThrowable4	java.lang.Throwable
      //   4788	5	20	localIOException12	java.io.IOException
      //   4817	151	20	localException5	Exception
      //   5145	5	20	localException6	Exception
      //   5174	5	20	localIOException13	java.io.IOException
      //   5203	5	20	localArrayIndexOutOfBoundsException5	java.lang.ArrayIndexOutOfBoundsException
      //   5232	5	20	localThrowable5	java.lang.Throwable
      //   5261	5	20	localIOException14	java.io.IOException
      //   5290	177	20	localObject4	Object
      //   5614	31	20	localObject5	Object
      //   5653	156	20	localObject6	Object
      //   5822	1	20	localObject7	Object
      //   5842	1	20	localException7	Exception
      //   5871	36	20	localException8	Exception
      //   5915	192	20	localObject8	Object
      //   6126	1	20	localSocketTimeoutException2	java.net.SocketTimeoutException
      //   6155	36	20	localSocketTimeoutException3	java.net.SocketTimeoutException
      //   6199	192	20	localObject9	Object
      //   6410	1	20	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
      //   6438	35	20	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
      //   6481	192	20	localObject10	Object
      //   6692	1	20	localFileNotFoundException2	java.io.FileNotFoundException
      //   6716	31	20	localFileNotFoundException3	java.io.FileNotFoundException
      //   6755	409	20	localObject11	Object
      //   145	3	21	str1	String
      //   267	5	21	localMalformedURLException	java.net.MalformedURLException
      //   535	1947	21	localObject12	Object
      //   2512	360	21	localException9	Exception
      //   2902	217	21	localException10	Exception
      //   3149	185	21	localException11	Exception
      //   3339	265	21	localObject13	Object
      //   3779	5	21	localException12	Exception
      //   3808	5	21	localIOException15	java.io.IOException
      //   3837	5	21	localArrayIndexOutOfBoundsException6	java.lang.ArrayIndexOutOfBoundsException
      //   3866	5	21	localThrowable6	java.lang.Throwable
      //   4397	548	21	localInputStream1	InputStream
      //   5469	5	21	localException13	Exception
      //   5498	5	21	localIOException16	java.io.IOException
      //   5527	5	21	localArrayIndexOutOfBoundsException7	java.lang.ArrayIndexOutOfBoundsException
      //   5556	5	21	localThrowable7	java.lang.Throwable
      //   5585	1352	21	localIOException17	java.io.IOException
      //   6955	213	21	localObject14	Object
      //   38	13	22	str2	String
      //   879	43	22	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
      //   1150	2254	22	localObject15	Object
      //   3408	1	22	localException14	Exception
      //   3425	2299	22	localInputStream2	InputStream
      //   5797	10	22	localObject16	Object
      //   5814	61	22	localObject17	Object
      //   5901	13	22	localException15	Exception
      //   5930	1	22	localObject18	Object
      //   5939	10	22	localException16	Exception
      //   5965	1	22	localObject19	Object
      //   5974	10	22	localException17	Exception
      //   6000	1	22	localObject20	Object
      //   6009	10	22	localException18	Exception
      //   6032	127	22	localObject21	Object
      //   6185	13	22	localSocketTimeoutException4	java.net.SocketTimeoutException
      //   6214	1	22	localObject22	Object
      //   6223	10	22	localSocketTimeoutException5	java.net.SocketTimeoutException
      //   6249	1	22	localObject23	Object
      //   6258	10	22	localSocketTimeoutException6	java.net.SocketTimeoutException
      //   6284	1	22	localObject24	Object
      //   6293	10	22	localSocketTimeoutException7	java.net.SocketTimeoutException
      //   6316	129	22	localObject25	Object
      //   6467	13	22	localSSLHandshakeException4	javax.net.ssl.SSLHandshakeException
      //   6496	1	22	localObject26	Object
      //   6505	10	22	localSSLHandshakeException5	javax.net.ssl.SSLHandshakeException
      //   6531	1	22	localObject27	Object
      //   6540	10	22	localSSLHandshakeException6	javax.net.ssl.SSLHandshakeException
      //   6566	1	22	localObject28	Object
      //   6575	10	22	localSSLHandshakeException7	javax.net.ssl.SSLHandshakeException
      //   6598	125	22	localObject29	Object
      //   6741	13	22	localFileNotFoundException4	java.io.FileNotFoundException
      //   6770	1	22	localObject30	Object
      //   6775	10	22	localFileNotFoundException5	java.io.FileNotFoundException
      //   6801	1	22	localObject31	Object
      //   6806	10	22	localFileNotFoundException6	java.io.FileNotFoundException
      //   6832	1	22	localObject32	Object
      //   6837	10	22	localFileNotFoundException7	java.io.FileNotFoundException
      //   6860	1	22	localObject33	Object
      //   6946	1	22	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
      //   6972	1	22	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
      //   6999	1	22	localUnsupportedEncodingException4	java.io.UnsupportedEncodingException
      //   7027	1	22	localUnsupportedEncodingException5	java.io.UnsupportedEncodingException
      //   7052	1	22	localUnsupportedEncodingException6	java.io.UnsupportedEncodingException
      //   7077	31	22	localUnsupportedEncodingException7	java.io.UnsupportedEncodingException
      //   7120	38	22	localObject34	Object
      //   60	3225	23	localObject35	Object
      //   3314	14	23	localUnsupportedEncodingException8	java.io.UnsupportedEncodingException
      //   3343	1	23	localObject36	Object
      //   3361	52	23	localException19	Exception
      //   3445	2572	23	localObject37	Object
      //   6041	7	23	localException20	Exception
      //   6053	1	23	localObject38	Object
      //   6070	7	23	localException21	Exception
      //   6082	1	23	localObject39	Object
      //   6098	7	23	localException22	Exception
      //   6110	191	23	localObject40	Object
      //   6325	7	23	localSocketTimeoutException8	java.net.SocketTimeoutException
      //   6337	1	23	localObject41	Object
      //   6354	7	23	localSocketTimeoutException9	java.net.SocketTimeoutException
      //   6366	1	23	localObject42	Object
      //   6382	7	23	localSocketTimeoutException10	java.net.SocketTimeoutException
      //   6394	189	23	localObject43	Object
      //   6607	7	23	localSSLHandshakeException8	javax.net.ssl.SSLHandshakeException
      //   6619	1	23	localObject44	Object
      //   6636	7	23	localSSLHandshakeException9	javax.net.ssl.SSLHandshakeException
      //   6648	1	23	localObject45	Object
      //   6664	7	23	localSSLHandshakeException10	javax.net.ssl.SSLHandshakeException
      //   6676	169	23	localObject46	Object
      //   6865	7	23	localFileNotFoundException8	java.io.FileNotFoundException
      //   6877	1	23	localObject47	Object
      //   6890	7	23	localFileNotFoundException9	java.io.FileNotFoundException
      //   6902	1	23	localObject48	Object
      //   6918	7	23	localFileNotFoundException10	java.io.FileNotFoundException
      //   6930	155	23	localObject49	Object
      //   7105	14	23	localUnsupportedEncodingException9	java.io.UnsupportedEncodingException
      //   7134	1	23	localObject50	Object
      //   7142	14	23	localUnsupportedEncodingException10	java.io.UnsupportedEncodingException
      //   7171	12	23	localObject51	Object
      //   556	5076	24	localObject52	Object
      //   5639	13	24	localObject53	Object
      //   5660	1	24	localIOException18	java.io.IOException
      //   5668	10	24	localObject54	Object
      //   5686	1	24	localIOException19	java.io.IOException
      //   5694	10	24	localObject55	Object
      //   5712	1	24	localIOException20	java.io.IOException
      //   5720	10	24	localObject56	Object
      //   5735	1	24	localIOException21	java.io.IOException
      //   5743	7	24	localObject57	Object
      //   5755	1	24	localIOException22	java.io.IOException
      //   5763	7	24	localObject58	Object
      //   5775	1	24	localIOException23	java.io.IOException
      //   5780	7	24	localObject59	Object
      //   5792	1188	24	localObject60	Object
      //   320	6846	25	localObject61	Object
      //   317	6853	26	localObject62	Object
      //   546	6393	27	localObject63	Object
      //   305	6426	28	localObject64	Object
      //   308	6145	29	localObject65	Object
      //   311	5856	30	localObject66	Object
      //   314	5569	31	localObject67	Object
      //   9	5592	32	str3	String
      //   15	5591	33	str4	String
      //   32	5321	34	str5	String
      //   105	4853	35	locala	g.a
      //   528	1782	36	localq	com.tencent.mm.vfs.q
      //   498	1649	37	str6	String
      //   66	2118	38	localObject68	Object
      //   111	2060	39	localObject69	Object
      //   1534	13	40	localIterator	Iterator
      //   1556	84	41	str7	String
      //   1570	108	42	str8	String
      // Exception table:
      //   from	to	target	type
      //   131	147	267	java/net/MalformedURLException
      //   558	574	879	java/io/UnsupportedEncodingException
      //   574	617	879	java/io/UnsupportedEncodingException
      //   617	719	879	java/io/UnsupportedEncodingException
      //   724	755	879	java/io/UnsupportedEncodingException
      //   755	876	879	java/io/UnsupportedEncodingException
      //   1119	1144	879	java/io/UnsupportedEncodingException
      //   1458	1498	879	java/io/UnsupportedEncodingException
      //   1503	1536	879	java/io/UnsupportedEncodingException
      //   1536	1692	879	java/io/UnsupportedEncodingException
      //   2010	2170	879	java/io/UnsupportedEncodingException
      //   2170	2196	879	java/io/UnsupportedEncodingException
      //   2205	2210	879	java/io/UnsupportedEncodingException
      //   2215	2220	879	java/io/UnsupportedEncodingException
      //   2220	2293	879	java/io/UnsupportedEncodingException
      //   558	574	1147	java/io/FileNotFoundException
      //   574	617	1147	java/io/FileNotFoundException
      //   617	719	1147	java/io/FileNotFoundException
      //   724	755	1147	java/io/FileNotFoundException
      //   755	876	1147	java/io/FileNotFoundException
      //   1119	1144	1147	java/io/FileNotFoundException
      //   1458	1498	1147	java/io/FileNotFoundException
      //   1503	1536	1147	java/io/FileNotFoundException
      //   1536	1692	1147	java/io/FileNotFoundException
      //   2010	2170	1147	java/io/FileNotFoundException
      //   2170	2196	1147	java/io/FileNotFoundException
      //   2205	2210	1147	java/io/FileNotFoundException
      //   2215	2220	1147	java/io/FileNotFoundException
      //   2220	2293	1147	java/io/FileNotFoundException
      //   558	574	1695	javax/net/ssl/SSLHandshakeException
      //   574	617	1695	javax/net/ssl/SSLHandshakeException
      //   617	719	1695	javax/net/ssl/SSLHandshakeException
      //   724	755	1695	javax/net/ssl/SSLHandshakeException
      //   755	876	1695	javax/net/ssl/SSLHandshakeException
      //   1119	1144	1695	javax/net/ssl/SSLHandshakeException
      //   1458	1498	1695	javax/net/ssl/SSLHandshakeException
      //   1503	1536	1695	javax/net/ssl/SSLHandshakeException
      //   1536	1692	1695	javax/net/ssl/SSLHandshakeException
      //   2010	2170	1695	javax/net/ssl/SSLHandshakeException
      //   2170	2196	1695	javax/net/ssl/SSLHandshakeException
      //   2205	2210	1695	javax/net/ssl/SSLHandshakeException
      //   2215	2220	1695	javax/net/ssl/SSLHandshakeException
      //   2220	2293	1695	javax/net/ssl/SSLHandshakeException
      //   2481	2486	2512	java/lang/Exception
      //   2486	2491	2541	java/io/IOException
      //   2871	2876	2902	java/lang/Exception
      //   2876	2881	2931	java/io/IOException
      //   3118	3123	3149	java/lang/Exception
      //   3123	3128	3178	java/io/IOException
      //   3257	3284	3314	java/io/UnsupportedEncodingException
      //   3284	3291	3314	java/io/UnsupportedEncodingException
      //   3296	3311	3314	java/io/UnsupportedEncodingException
      //   3440	3460	3314	java/io/UnsupportedEncodingException
      //   3224	3252	3361	java/lang/Exception
      //   3351	3358	3361	java/lang/Exception
      //   3377	3405	3408	java/lang/Exception
      //   3430	3437	3408	java/lang/Exception
      //   3603	3608	3779	java/lang/Exception
      //   3613	3618	3808	java/io/IOException
      //   3613	3618	3837	java/lang/ArrayIndexOutOfBoundsException
      //   3613	3618	3866	java/lang/Throwable
      //   3618	3623	3895	java/io/IOException
      //   1073	1078	3924	java/lang/Exception
      //   1083	1088	3953	java/io/IOException
      //   1083	1088	3982	java/lang/ArrayIndexOutOfBoundsException
      //   1083	1088	4011	java/lang/Throwable
      //   1093	1098	4040	java/io/IOException
      //   1412	1417	4069	java/lang/Exception
      //   1422	1427	4098	java/io/IOException
      //   1422	1427	4127	java/lang/ArrayIndexOutOfBoundsException
      //   1422	1427	4156	java/lang/Throwable
      //   1432	1437	4185	java/io/IOException
      //   1964	1969	4214	java/lang/Exception
      //   1974	1979	4243	java/io/IOException
      //   1974	1979	4272	java/lang/ArrayIndexOutOfBoundsException
      //   1974	1979	4301	java/lang/Throwable
      //   1984	1989	4330	java/io/IOException
      //   500	537	4359	java/net/SocketTimeoutException
      //   4626	4631	4672	java/lang/Exception
      //   4636	4641	4701	java/io/IOException
      //   4636	4641	4730	java/lang/ArrayIndexOutOfBoundsException
      //   4636	4641	4759	java/lang/Throwable
      //   4646	4651	4788	java/io/IOException
      //   500	537	4817	java/lang/Exception
      //   5099	5104	5145	java/lang/Exception
      //   5109	5114	5174	java/io/IOException
      //   5109	5114	5203	java/lang/ArrayIndexOutOfBoundsException
      //   5109	5114	5232	java/lang/Throwable
      //   5119	5124	5261	java/io/IOException
      //   500	537	5290	finally
      //   5421	5426	5469	java/lang/Exception
      //   5431	5436	5498	java/io/IOException
      //   5431	5436	5527	java/lang/ArrayIndexOutOfBoundsException
      //   5431	5436	5556	java/lang/Throwable
      //   5441	5446	5585	java/io/IOException
      //   537	558	5614	finally
      //   558	574	5614	finally
      //   574	617	5614	finally
      //   617	719	5614	finally
      //   724	755	5614	finally
      //   755	876	5614	finally
      //   1119	1144	5614	finally
      //   1458	1498	5614	finally
      //   1503	1536	5614	finally
      //   1536	1692	5614	finally
      //   2010	2170	5614	finally
      //   2170	2196	5614	finally
      //   2205	2210	5614	finally
      //   2215	2220	5614	finally
      //   2220	2293	5614	finally
      //   2293	2316	5639	finally
      //   2321	2329	5668	finally
      //   2334	2372	5668	finally
      //   2570	2579	5668	finally
      //   2677	2695	5668	finally
      //   2593	2612	5694	finally
      //   2620	2633	5694	finally
      //   2636	2672	5694	finally
      //   2695	2707	5720	finally
      //   2714	2770	5720	finally
      //   2774	2814	5720	finally
      //   2960	3009	5720	finally
      //   3207	3224	5720	finally
      //   3224	3252	5720	finally
      //   3351	3358	5720	finally
      //   3363	3377	5720	finally
      //   3377	3405	5720	finally
      //   3410	3424	5720	finally
      //   3430	3437	5720	finally
      //   3257	3284	5743	finally
      //   3284	3291	5743	finally
      //   3296	3311	5743	finally
      //   3440	3460	5743	finally
      //   3460	3489	5763	finally
      //   3489	3537	5780	finally
      //   3644	3670	5780	finally
      //   900	963	5797	finally
      //   1192	1213	5822	finally
      //   1235	1259	5822	finally
      //   1281	1301	5822	finally
      //   1744	1765	5822	finally
      //   1787	1811	5822	finally
      //   1833	1853	5822	finally
      //   4406	4427	5822	finally
      //   4449	4473	5822	finally
      //   4495	4515	5822	finally
      //   4864	4885	5822	finally
      //   4907	4931	5822	finally
      //   4953	4988	5822	finally
      //   537	558	5842	java/lang/Exception
      //   558	574	5871	java/lang/Exception
      //   574	617	5871	java/lang/Exception
      //   617	719	5871	java/lang/Exception
      //   724	755	5871	java/lang/Exception
      //   755	876	5871	java/lang/Exception
      //   1119	1144	5871	java/lang/Exception
      //   1458	1498	5871	java/lang/Exception
      //   1503	1536	5871	java/lang/Exception
      //   1536	1692	5871	java/lang/Exception
      //   2010	2170	5871	java/lang/Exception
      //   2170	2196	5871	java/lang/Exception
      //   2205	2210	5871	java/lang/Exception
      //   2215	2220	5871	java/lang/Exception
      //   2220	2293	5871	java/lang/Exception
      //   2293	2316	5901	java/lang/Exception
      //   2321	2329	5939	java/lang/Exception
      //   2334	2372	5939	java/lang/Exception
      //   2570	2579	5939	java/lang/Exception
      //   2677	2695	5939	java/lang/Exception
      //   2593	2612	5974	java/lang/Exception
      //   2620	2633	5974	java/lang/Exception
      //   2636	2672	5974	java/lang/Exception
      //   2695	2707	6009	java/lang/Exception
      //   2714	2770	6009	java/lang/Exception
      //   2774	2814	6009	java/lang/Exception
      //   2960	3009	6009	java/lang/Exception
      //   3207	3224	6009	java/lang/Exception
      //   3363	3377	6009	java/lang/Exception
      //   3410	3424	6009	java/lang/Exception
      //   3257	3284	6041	java/lang/Exception
      //   3284	3291	6041	java/lang/Exception
      //   3296	3311	6041	java/lang/Exception
      //   3440	3460	6041	java/lang/Exception
      //   3460	3489	6070	java/lang/Exception
      //   3489	3537	6098	java/lang/Exception
      //   3644	3670	6098	java/lang/Exception
      //   537	558	6126	java/net/SocketTimeoutException
      //   558	574	6155	java/net/SocketTimeoutException
      //   574	617	6155	java/net/SocketTimeoutException
      //   617	719	6155	java/net/SocketTimeoutException
      //   724	755	6155	java/net/SocketTimeoutException
      //   755	876	6155	java/net/SocketTimeoutException
      //   1119	1144	6155	java/net/SocketTimeoutException
      //   1458	1498	6155	java/net/SocketTimeoutException
      //   1503	1536	6155	java/net/SocketTimeoutException
      //   1536	1692	6155	java/net/SocketTimeoutException
      //   2010	2170	6155	java/net/SocketTimeoutException
      //   2170	2196	6155	java/net/SocketTimeoutException
      //   2205	2210	6155	java/net/SocketTimeoutException
      //   2215	2220	6155	java/net/SocketTimeoutException
      //   2220	2293	6155	java/net/SocketTimeoutException
      //   2293	2316	6185	java/net/SocketTimeoutException
      //   2321	2329	6223	java/net/SocketTimeoutException
      //   2334	2372	6223	java/net/SocketTimeoutException
      //   2570	2579	6223	java/net/SocketTimeoutException
      //   2677	2695	6223	java/net/SocketTimeoutException
      //   2593	2612	6258	java/net/SocketTimeoutException
      //   2620	2633	6258	java/net/SocketTimeoutException
      //   2636	2672	6258	java/net/SocketTimeoutException
      //   2695	2707	6293	java/net/SocketTimeoutException
      //   2714	2770	6293	java/net/SocketTimeoutException
      //   2774	2814	6293	java/net/SocketTimeoutException
      //   2960	3009	6293	java/net/SocketTimeoutException
      //   3207	3224	6293	java/net/SocketTimeoutException
      //   3224	3252	6293	java/net/SocketTimeoutException
      //   3351	3358	6293	java/net/SocketTimeoutException
      //   3363	3377	6293	java/net/SocketTimeoutException
      //   3377	3405	6293	java/net/SocketTimeoutException
      //   3410	3424	6293	java/net/SocketTimeoutException
      //   3430	3437	6293	java/net/SocketTimeoutException
      //   3257	3284	6325	java/net/SocketTimeoutException
      //   3284	3291	6325	java/net/SocketTimeoutException
      //   3296	3311	6325	java/net/SocketTimeoutException
      //   3440	3460	6325	java/net/SocketTimeoutException
      //   3460	3489	6354	java/net/SocketTimeoutException
      //   3489	3537	6382	java/net/SocketTimeoutException
      //   3644	3670	6382	java/net/SocketTimeoutException
      //   500	537	6410	javax/net/ssl/SSLHandshakeException
      //   537	558	6438	javax/net/ssl/SSLHandshakeException
      //   2293	2316	6467	javax/net/ssl/SSLHandshakeException
      //   2321	2329	6505	javax/net/ssl/SSLHandshakeException
      //   2334	2372	6505	javax/net/ssl/SSLHandshakeException
      //   2570	2579	6505	javax/net/ssl/SSLHandshakeException
      //   2677	2695	6505	javax/net/ssl/SSLHandshakeException
      //   2593	2612	6540	javax/net/ssl/SSLHandshakeException
      //   2620	2633	6540	javax/net/ssl/SSLHandshakeException
      //   2636	2672	6540	javax/net/ssl/SSLHandshakeException
      //   2695	2707	6575	javax/net/ssl/SSLHandshakeException
      //   2714	2770	6575	javax/net/ssl/SSLHandshakeException
      //   2774	2814	6575	javax/net/ssl/SSLHandshakeException
      //   2960	3009	6575	javax/net/ssl/SSLHandshakeException
      //   3207	3224	6575	javax/net/ssl/SSLHandshakeException
      //   3224	3252	6575	javax/net/ssl/SSLHandshakeException
      //   3351	3358	6575	javax/net/ssl/SSLHandshakeException
      //   3363	3377	6575	javax/net/ssl/SSLHandshakeException
      //   3377	3405	6575	javax/net/ssl/SSLHandshakeException
      //   3410	3424	6575	javax/net/ssl/SSLHandshakeException
      //   3430	3437	6575	javax/net/ssl/SSLHandshakeException
      //   3257	3284	6607	javax/net/ssl/SSLHandshakeException
      //   3284	3291	6607	javax/net/ssl/SSLHandshakeException
      //   3296	3311	6607	javax/net/ssl/SSLHandshakeException
      //   3440	3460	6607	javax/net/ssl/SSLHandshakeException
      //   3460	3489	6636	javax/net/ssl/SSLHandshakeException
      //   3489	3537	6664	javax/net/ssl/SSLHandshakeException
      //   3644	3670	6664	javax/net/ssl/SSLHandshakeException
      //   500	537	6692	java/io/FileNotFoundException
      //   537	558	6716	java/io/FileNotFoundException
      //   2293	2316	6741	java/io/FileNotFoundException
      //   2321	2329	6775	java/io/FileNotFoundException
      //   2334	2372	6775	java/io/FileNotFoundException
      //   2570	2579	6775	java/io/FileNotFoundException
      //   2677	2695	6775	java/io/FileNotFoundException
      //   2593	2612	6806	java/io/FileNotFoundException
      //   2620	2633	6806	java/io/FileNotFoundException
      //   2636	2672	6806	java/io/FileNotFoundException
      //   2695	2707	6837	java/io/FileNotFoundException
      //   2714	2770	6837	java/io/FileNotFoundException
      //   2774	2814	6837	java/io/FileNotFoundException
      //   2960	3009	6837	java/io/FileNotFoundException
      //   3207	3224	6837	java/io/FileNotFoundException
      //   3224	3252	6837	java/io/FileNotFoundException
      //   3351	3358	6837	java/io/FileNotFoundException
      //   3363	3377	6837	java/io/FileNotFoundException
      //   3377	3405	6837	java/io/FileNotFoundException
      //   3410	3424	6837	java/io/FileNotFoundException
      //   3430	3437	6837	java/io/FileNotFoundException
      //   3257	3284	6865	java/io/FileNotFoundException
      //   3284	3291	6865	java/io/FileNotFoundException
      //   3296	3311	6865	java/io/FileNotFoundException
      //   3440	3460	6865	java/io/FileNotFoundException
      //   3460	3489	6890	java/io/FileNotFoundException
      //   3489	3537	6918	java/io/FileNotFoundException
      //   3644	3670	6918	java/io/FileNotFoundException
      //   500	537	6946	java/io/UnsupportedEncodingException
      //   537	558	6972	java/io/UnsupportedEncodingException
      //   2293	2316	6999	java/io/UnsupportedEncodingException
      //   2321	2329	7027	java/io/UnsupportedEncodingException
      //   2334	2372	7027	java/io/UnsupportedEncodingException
      //   2570	2579	7027	java/io/UnsupportedEncodingException
      //   2677	2695	7027	java/io/UnsupportedEncodingException
      //   2593	2612	7052	java/io/UnsupportedEncodingException
      //   2620	2633	7052	java/io/UnsupportedEncodingException
      //   2636	2672	7052	java/io/UnsupportedEncodingException
      //   2695	2707	7077	java/io/UnsupportedEncodingException
      //   2714	2770	7077	java/io/UnsupportedEncodingException
      //   2774	2814	7077	java/io/UnsupportedEncodingException
      //   2960	3009	7077	java/io/UnsupportedEncodingException
      //   3207	3224	7077	java/io/UnsupportedEncodingException
      //   3224	3252	7077	java/io/UnsupportedEncodingException
      //   3351	3358	7077	java/io/UnsupportedEncodingException
      //   3363	3377	7077	java/io/UnsupportedEncodingException
      //   3377	3405	7077	java/io/UnsupportedEncodingException
      //   3410	3424	7077	java/io/UnsupportedEncodingException
      //   3430	3437	7077	java/io/UnsupportedEncodingException
      //   3460	3489	7105	java/io/UnsupportedEncodingException
      //   3489	3537	7142	java/io/UnsupportedEncodingException
      //   3644	3670	7142	java/io/UnsupportedEncodingException
    }
    
    private static String du(String paramString1, String paramString2)
    {
      AppMethodBeat.i(144345);
      if (Util.isNullOrNil(paramString1))
      {
        AppMethodBeat.o(144345);
        return paramString2;
      }
      AppMethodBeat.o(144345);
      return paramString1;
    }
    
    public final void run()
    {
      AppMethodBeat.i(144344);
      b(this.qjp);
      AppMethodBeat.o(144344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.g
 * JD-Core Version:    0.7.0.1
 */