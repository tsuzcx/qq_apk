package com.tencent.mm.plugin.appbrand.q;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class g
{
  c joJ;
  SSLContext kUC;
  protected final ArrayList<String> kUD;
  private int kVo;
  private final ArrayList<h> kVp;
  final String kwo;
  
  public g(c paramc)
  {
    AppMethodBeat.i(144347);
    this.kVp = new ArrayList();
    this.kUD = new ArrayList();
    this.joJ = paramc;
    paramc = (a)paramc.ar(a.class);
    this.kVo = paramc.cfz;
    this.kwo = paramc.kUx;
    this.kUC = j.a(paramc);
    AppMethodBeat.o(144347);
  }
  
  private void a(String paramString, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(144353);
    pR(paramString);
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
        ad.printErrStackTrace("MicroMsg.AppBrandNetworkUpload", paramHttpURLConnection, "removeTask Exception: id %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(144353);
  }
  
  private void pR(String paramString)
  {
    AppMethodBeat.i(144349);
    if (paramString == null)
    {
      AppMethodBeat.o(144349);
      return;
    }
    synchronized (this.kVp)
    {
      Iterator localIterator = this.kVp.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.hLO)) {
          this.kVp.remove(localh);
        }
      }
      AppMethodBeat.o(144349);
      return;
    }
  }
  
  public final boolean KW(String paramString)
  {
    AppMethodBeat.i(144352);
    boolean bool = this.kUD.contains(paramString);
    AppMethodBeat.o(144352);
    return bool;
  }
  
  public final h Lc(String paramString)
  {
    AppMethodBeat.i(144350);
    if (paramString == null)
    {
      AppMethodBeat.o(144350);
      return null;
    }
    synchronized (this.kVp)
    {
      Iterator localIterator = this.kVp.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.hLO))
        {
          AppMethodBeat.o(144350);
          return localh;
        }
      }
      AppMethodBeat.o(144350);
      return null;
    }
  }
  
  public final void a(int paramInt, String paramString1, String arg3, JSONObject paramJSONObject, Map<String, String> paramMap, ArrayList<String> paramArrayList, a parama, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(144348);
    String str1 = j.Lh(paramJSONObject.optString("url"));
    String str2 = paramJSONObject.optString("name");
    paramJSONObject = j.Y(paramJSONObject);
    synchronized (this.kVp)
    {
      if (this.kVp.size() >= this.kVo)
      {
        parama.IL("tasked refused max connected");
        ad.i("MicroMsg.AppBrandNetworkUpload", "max connected mUploadTaskList.size():%d,mMaxUploadConcurrent:%d", new Object[] { Integer.valueOf(this.kVp.size()), Integer.valueOf(this.kVo) });
        AppMethodBeat.o(144348);
        return;
      }
      if (TextUtils.isEmpty(str2))
      {
        parama.IL("fileName error");
        ad.i("MicroMsg.AppBrandNetworkUpload", "fileName error");
        AppMethodBeat.o(144348);
        return;
      }
    }
    paramString1 = new h(???, str1, str2, paramString5, paramInt, paramString1, parama);
    paramString1.kVt = paramJSONObject;
    paramString1.hLP = paramMap;
    paramString1.kVe = paramArrayList;
    paramString1.isRunning = true;
    paramString1.hLO = paramString3;
    paramString1.kVj = paramString4;
    synchronized (this.kVp)
    {
      this.kVp.add(paramString1);
      b.c(new b(paramString1), "appbrand_upload_thread");
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
    this.kUD.add(paramh.hLO);
    paramh.isRunning = false;
    a(paramh.hLO, paramh.kVh);
    AppMethodBeat.o(144351);
  }
  
  public final void release()
  {
    AppMethodBeat.i(190830);
    synchronized (this.kVp)
    {
      Iterator localIterator = this.kVp.iterator();
      if (localIterator.hasNext()) {
        ((h)localIterator.next()).isRunning = false;
      }
    }
    this.kVp.clear();
    AppMethodBeat.o(190830);
  }
  
  public static abstract interface a
  {
    public abstract void C(JSONObject paramJSONObject);
    
    public abstract void IL(String paramString);
    
    public abstract void h(int paramInt, long paramLong1, long paramLong2);
    
    public abstract void i(int paramInt1, String paramString, int paramInt2);
  }
  
  public final class b
    implements Runnable
  {
    private h kVq;
    
    public b(h paramh)
    {
      this.kVq = paramh;
    }
    
    /* Error */
    private void b(h paramh)
    {
      // Byte code:
      //   0: ldc 41
      //   2: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   9: astore 33
      //   11: aload_1
      //   12: getfield 56	com/tencent/mm/plugin/appbrand/q/h:kVs	Ljava/lang/String;
      //   15: astore 34
      //   17: aload_1
      //   18: getfield 59	com/tencent/mm/plugin/appbrand/q/h:mName	Ljava/lang/String;
      //   21: astore 26
      //   23: aload_1
      //   24: getfield 62	com/tencent/mm/plugin/appbrand/q/h:mMimeType	Ljava/lang/String;
      //   27: ldc 64
      //   29: invokestatic 68	com/tencent/mm/plugin/appbrand/q/g$b:cI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   32: astore 35
      //   34: aload_1
      //   35: getfield 71	com/tencent/mm/plugin/appbrand/q/h:mFileName	Ljava/lang/String;
      //   38: astore 27
      //   40: ldc 73
      //   42: ldc 75
      //   44: iconst_1
      //   45: anewarray 4	java/lang/Object
      //   48: dup
      //   49: iconst_0
      //   50: aload 27
      //   52: aastore
      //   53: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   56: aload_1
      //   57: getfield 85	com/tencent/mm/plugin/appbrand/q/h:kVt	Ljava/util/Map;
      //   60: astore 28
      //   62: aload_1
      //   63: getfield 88	com/tencent/mm/plugin/appbrand/q/h:hLP	Ljava/util/Map;
      //   66: astore 37
      //   68: iconst_0
      //   69: istore 10
      //   71: iconst_0
      //   72: istore 11
      //   74: iconst_0
      //   75: istore 12
      //   77: iconst_0
      //   78: istore 13
      //   80: iconst_0
      //   81: istore 9
      //   83: iconst_0
      //   84: istore 15
      //   86: iconst_0
      //   87: istore 16
      //   89: iconst_0
      //   90: istore 17
      //   92: iconst_0
      //   93: istore 18
      //   95: iconst_0
      //   96: istore 19
      //   98: iconst_0
      //   99: istore 14
      //   101: lconst_0
      //   102: lstore 21
      //   104: aload_1
      //   105: getfield 92	com/tencent/mm/plugin/appbrand/q/h:kVu	Lcom/tencent/mm/plugin/appbrand/q/g$a;
      //   108: astore 36
      //   110: aload_1
      //   111: getfield 96	com/tencent/mm/plugin/appbrand/q/h:kVe	Ljava/util/ArrayList;
      //   114: astore 38
      //   116: aload 38
      //   118: ifnull +97 -> 215
      //   121: aload 38
      //   123: aload 33
      //   125: invokestatic 102	com/tencent/mm/plugin/appbrand/q/j:c	(Ljava/util/ArrayList;Ljava/lang/String;)Z
      //   128: ifne +87 -> 215
      //   131: aload_0
      //   132: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   135: aload 36
      //   137: ldc 104
      //   139: aload_1
      //   140: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   143: aconst_null
      //   144: invokestatic 111	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   147: ldc 113
      //   149: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   152: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   155: aload_0
      //   156: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   159: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   162: invokeinterface 129 1 0
      //   167: aload_1
      //   168: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   171: ldc 134
      //   173: aload_1
      //   174: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   177: lconst_0
      //   178: lconst_0
      //   179: iconst_0
      //   180: iconst_2
      //   181: aload_1
      //   182: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   185: aconst_null
      //   186: aload 35
      //   188: invokeinterface 141 14 0
      //   193: ldc 73
      //   195: ldc 143
      //   197: iconst_1
      //   198: anewarray 4	java/lang/Object
      //   201: dup
      //   202: iconst_0
      //   203: aload 33
      //   205: aastore
      //   206: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   209: ldc 41
      //   211: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   214: return
      //   215: aload_1
      //   216: getfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   219: ifne +78 -> 297
      //   222: aload_0
      //   223: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   226: aload 36
      //   228: ldc 154
      //   230: aload_1
      //   231: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   234: aconst_null
      //   235: invokestatic 111	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   238: ldc 113
      //   240: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   243: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   246: aload_0
      //   247: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   250: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   253: invokeinterface 129 1 0
      //   258: aload_1
      //   259: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   262: ldc 134
      //   264: aload_1
      //   265: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   268: lconst_0
      //   269: lconst_0
      //   270: iconst_0
      //   271: iconst_2
      //   272: aload_1
      //   273: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   276: aconst_null
      //   277: aload 35
      //   279: invokeinterface 141 14 0
      //   284: ldc 73
      //   286: ldc 156
      //   288: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   291: ldc 41
      //   293: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   296: return
      //   297: aload_1
      //   298: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   301: invokestatic 166	android/webkit/URLUtil:isHttpsUrl	(Ljava/lang/String;)Z
      //   304: ifne +81 -> 385
      //   307: aload_1
      //   308: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   311: invokestatic 169	android/webkit/URLUtil:isHttpUrl	(Ljava/lang/String;)Z
      //   314: ifne +71 -> 385
      //   317: aload_0
      //   318: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   321: aload 36
      //   323: ldc 171
      //   325: aload_1
      //   326: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   329: aconst_null
      //   330: invokestatic 111	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   333: ldc 113
      //   335: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   338: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   341: aload_0
      //   342: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   345: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   348: invokeinterface 129 1 0
      //   353: aload_1
      //   354: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   357: ldc 134
      //   359: aload_1
      //   360: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   363: lconst_0
      //   364: lconst_0
      //   365: iconst_0
      //   366: iconst_2
      //   367: aload_1
      //   368: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   371: aconst_null
      //   372: aload 35
      //   374: invokeinterface 141 14 0
      //   379: ldc 41
      //   381: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   384: return
      //   385: invokestatic 177	java/lang/System:currentTimeMillis	()J
      //   388: invokestatic 183	java/lang/Long:toString	(J)Ljava/lang/String;
      //   391: astore 32
      //   393: ldc 185
      //   395: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   398: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   401: ldc2_w 186
      //   404: lconst_0
      //   405: lconst_1
      //   406: iconst_0
      //   407: invokeinterface 191 8 0
      //   412: new 193	com/tencent/mm/vfs/e
      //   415: dup
      //   416: aload 34
      //   418: invokespecial 196	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
      //   421: astore 31
      //   423: aload 31
      //   425: invokestatic 202	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
      //   428: astore 25
      //   430: new 204	java/net/URL
      //   433: dup
      //   434: aload 33
      //   436: invokespecial 205	java/net/URL:<init>	(Ljava/lang/String;)V
      //   439: astore 30
      //   441: aload 30
      //   443: invokevirtual 209	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   446: checkcast 211	java/net/HttpURLConnection
      //   449: astore 29
      //   451: aload_1
      //   452: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   455: invokestatic 216	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   458: ifne +9 -> 467
      //   461: aload_1
      //   462: aload 29
      //   464: putfield 220	com/tencent/mm/plugin/appbrand/q/h:kVh	Ljava/net/HttpURLConnection;
      //   467: aload 29
      //   469: instanceof 222
      //   472: ifeq +38 -> 510
      //   475: aload_0
      //   476: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   479: getfield 226	com/tencent/mm/plugin/appbrand/q/g:kUC	Ljavax/net/ssl/SSLContext;
      //   482: ifnull +28 -> 510
      //   485: aload 29
      //   487: checkcast 222	javax/net/ssl/HttpsURLConnection
      //   490: aload_0
      //   491: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   494: getfield 226	com/tencent/mm/plugin/appbrand/q/g:kUC	Ljavax/net/ssl/SSLContext;
      //   497: invokevirtual 232	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
      //   500: invokevirtual 236	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
      //   503: aload 29
      //   505: aload 38
      //   507: invokestatic 239	com/tencent/mm/plugin/appbrand/q/j:a	(Ljava/net/HttpURLConnection;Ljava/util/ArrayList;)V
      //   510: aload 29
      //   512: iconst_1
      //   513: invokevirtual 243	java/net/HttpURLConnection:setDoInput	(Z)V
      //   516: aload 29
      //   518: iconst_1
      //   519: invokevirtual 246	java/net/HttpURLConnection:setDoOutput	(Z)V
      //   522: aload 29
      //   524: iconst_0
      //   525: invokevirtual 249	java/net/HttpURLConnection:setUseCaches	(Z)V
      //   528: aload 29
      //   530: aload_1
      //   531: getfield 253	com/tencent/mm/plugin/appbrand/q/h:mTimeout	I
      //   534: invokevirtual 256	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   537: aload 29
      //   539: aload_1
      //   540: getfield 253	com/tencent/mm/plugin/appbrand/q/h:mTimeout	I
      //   543: invokevirtual 259	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   546: aload 29
      //   548: ldc 134
      //   550: invokevirtual 262	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   553: aload 29
      //   555: ldc_w 264
      //   558: ldc_w 266
      //   561: invokevirtual 269	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   564: aload 29
      //   566: ldc_w 271
      //   569: ldc_w 273
      //   572: invokevirtual 269	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   575: ldc 73
      //   577: ldc_w 275
      //   580: iconst_2
      //   581: anewarray 4	java/lang/Object
      //   584: dup
      //   585: iconst_0
      //   586: aload 31
      //   588: invokevirtual 279	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
      //   591: invokestatic 285	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
      //   594: aastore
      //   595: dup
      //   596: iconst_1
      //   597: aload 31
      //   599: invokevirtual 288	com/tencent/mm/vfs/e:length	()J
      //   602: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   605: aastore
      //   606: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   609: aload 29
      //   611: iconst_0
      //   612: invokevirtual 295	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
      //   615: aload 37
      //   617: ifnull +727 -> 1344
      //   620: ldc 73
      //   622: ldc_w 297
      //   625: iconst_1
      //   626: anewarray 4	java/lang/Object
      //   629: dup
      //   630: iconst_0
      //   631: aload 33
      //   633: aastore
      //   634: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   637: aload 37
      //   639: invokeinterface 303 1 0
      //   644: invokeinterface 309 1 0
      //   649: astore 37
      //   651: aload 37
      //   653: invokeinterface 315 1 0
      //   658: ifeq +686 -> 1344
      //   661: aload 37
      //   663: invokeinterface 319 1 0
      //   668: checkcast 321	java/util/Map$Entry
      //   671: astore 38
      //   673: ldc 73
      //   675: ldc_w 323
      //   678: iconst_3
      //   679: anewarray 4	java/lang/Object
      //   682: dup
      //   683: iconst_0
      //   684: aload 33
      //   686: aastore
      //   687: dup
      //   688: iconst_1
      //   689: aload 38
      //   691: invokeinterface 326 1 0
      //   696: aastore
      //   697: dup
      //   698: iconst_2
      //   699: aload 38
      //   701: invokeinterface 329 1 0
      //   706: aastore
      //   707: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   710: aload 38
      //   712: invokeinterface 326 1 0
      //   717: checkcast 331	java/lang/String
      //   720: invokestatic 216	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   723: ifne -72 -> 651
      //   726: aload 38
      //   728: invokeinterface 329 1 0
      //   733: checkcast 331	java/lang/String
      //   736: invokestatic 216	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   739: ifne -88 -> 651
      //   742: aload 38
      //   744: invokeinterface 326 1 0
      //   749: checkcast 331	java/lang/String
      //   752: invokevirtual 334	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   755: ldc_w 336
      //   758: invokevirtual 340	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   761: ifeq +245 -> 1006
      //   764: ldc 73
      //   766: ldc_w 342
      //   769: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   772: goto -121 -> 651
      //   775: astore 28
      //   777: aconst_null
      //   778: astore 26
      //   780: aconst_null
      //   781: astore 27
      //   783: iconst_0
      //   784: istore_2
      //   785: iconst_0
      //   786: istore_3
      //   787: ldc 185
      //   789: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   792: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   795: ldc2_w 186
      //   798: lconst_1
      //   799: lconst_1
      //   800: iconst_0
      //   801: invokeinterface 191 8 0
      //   806: ldc 73
      //   808: aload 28
      //   810: ldc_w 344
      //   813: iconst_2
      //   814: anewarray 4	java/lang/Object
      //   817: dup
      //   818: iconst_0
      //   819: aload 33
      //   821: aastore
      //   822: dup
      //   823: iconst_1
      //   824: aload 34
      //   826: aastore
      //   827: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   830: aload_0
      //   831: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   834: aload 36
      //   836: iconst_m1
      //   837: ldc_w 350
      //   840: iload_2
      //   841: aload_1
      //   842: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   845: aload 29
      //   847: invokestatic 353	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   850: ldc 113
      //   852: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   855: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   858: aload_0
      //   859: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   862: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   865: invokeinterface 129 1 0
      //   870: aload_1
      //   871: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   874: ldc 134
      //   876: aload_1
      //   877: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   880: lload 21
      //   882: iload_3
      //   883: i2l
      //   884: iload_2
      //   885: iconst_2
      //   886: aload_1
      //   887: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   890: aconst_null
      //   891: aload 35
      //   893: invokeinterface 141 14 0
      //   898: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   901: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   904: istore_2
      //   905: iload_2
      //   906: iconst_m1
      //   907: if_icmpne +24 -> 931
      //   910: ldc 185
      //   912: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   915: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   918: ldc2_w 186
      //   921: ldc2_w 366
      //   924: lconst_1
      //   925: iconst_0
      //   926: invokeinterface 191 8 0
      //   931: ldc 73
      //   933: ldc_w 369
      //   936: iconst_1
      //   937: anewarray 4	java/lang/Object
      //   940: dup
      //   941: iconst_0
      //   942: iload_2
      //   943: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   946: aastore
      //   947: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   950: aload_1
      //   951: iconst_0
      //   952: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   955: aload 25
      //   957: ifnull +8 -> 965
      //   960: aload 25
      //   962: invokevirtual 379	java/io/InputStream:close	()V
      //   965: aload 26
      //   967: ifnull +8 -> 975
      //   970: aload 26
      //   972: invokevirtual 379	java/io/InputStream:close	()V
      //   975: aload 27
      //   977: ifnull +8 -> 985
      //   980: aload 27
      //   982: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   985: aload_0
      //   986: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   989: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   992: aload_1
      //   993: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   996: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   999: pop
      //   1000: ldc 41
      //   1002: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1005: return
      //   1006: aload 29
      //   1008: aload 38
      //   1010: invokeinterface 326 1 0
      //   1015: checkcast 331	java/lang/String
      //   1018: aload 38
      //   1020: invokeinterface 329 1 0
      //   1025: checkcast 331	java/lang/String
      //   1028: invokevirtual 269	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1031: goto -380 -> 651
      //   1034: astore 28
      //   1036: aconst_null
      //   1037: astore 26
      //   1039: aconst_null
      //   1040: astore 30
      //   1042: iconst_0
      //   1043: istore_2
      //   1044: iload 9
      //   1046: istore 5
      //   1048: aload 25
      //   1050: astore 32
      //   1052: aload 29
      //   1054: astore 31
      //   1056: iload_2
      //   1057: istore 4
      //   1059: aload 32
      //   1061: astore 29
      //   1063: aload 26
      //   1065: astore 27
      //   1067: aload 30
      //   1069: astore 25
      //   1071: iload 5
      //   1073: istore_3
      //   1074: lload 21
      //   1076: lstore 23
      //   1078: ldc 185
      //   1080: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1083: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   1086: ldc2_w 186
      //   1089: ldc2_w 392
      //   1092: lconst_1
      //   1093: iconst_0
      //   1094: invokeinterface 191 8 0
      //   1099: iload_2
      //   1100: istore 4
      //   1102: aload 32
      //   1104: astore 29
      //   1106: aload 26
      //   1108: astore 27
      //   1110: aload 30
      //   1112: astore 25
      //   1114: iload 5
      //   1116: istore_3
      //   1117: lload 21
      //   1119: lstore 23
      //   1121: ldc 73
      //   1123: aload 28
      //   1125: ldc_w 395
      //   1128: iconst_2
      //   1129: anewarray 4	java/lang/Object
      //   1132: dup
      //   1133: iconst_0
      //   1134: aload 33
      //   1136: aastore
      //   1137: dup
      //   1138: iconst_1
      //   1139: aload 34
      //   1141: aastore
      //   1142: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1145: iload_2
      //   1146: istore 4
      //   1148: aload 32
      //   1150: astore 29
      //   1152: aload 26
      //   1154: astore 27
      //   1156: aload 30
      //   1158: astore 25
      //   1160: iload 5
      //   1162: istore_3
      //   1163: lload 21
      //   1165: lstore 23
      //   1167: aload_0
      //   1168: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   1171: aload 36
      //   1173: iconst_m1
      //   1174: ldc_w 397
      //   1177: iload_2
      //   1178: aload_1
      //   1179: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   1182: aload 31
      //   1184: invokestatic 353	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   1187: ldc 113
      //   1189: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1192: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   1195: aload_0
      //   1196: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   1199: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   1202: invokeinterface 129 1 0
      //   1207: aload_1
      //   1208: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   1211: ldc 134
      //   1213: aload_1
      //   1214: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   1217: lload 21
      //   1219: iload 5
      //   1221: i2l
      //   1222: iload_2
      //   1223: iconst_2
      //   1224: aload_1
      //   1225: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   1228: aconst_null
      //   1229: aload 35
      //   1231: invokeinterface 141 14 0
      //   1236: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   1239: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   1242: istore_2
      //   1243: iload_2
      //   1244: iconst_m1
      //   1245: if_icmpne +24 -> 1269
      //   1248: ldc 185
      //   1250: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1253: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   1256: ldc2_w 186
      //   1259: ldc2_w 366
      //   1262: lconst_1
      //   1263: iconst_0
      //   1264: invokeinterface 191 8 0
      //   1269: ldc 73
      //   1271: ldc_w 369
      //   1274: iconst_1
      //   1275: anewarray 4	java/lang/Object
      //   1278: dup
      //   1279: iconst_0
      //   1280: iload_2
      //   1281: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1284: aastore
      //   1285: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1288: aload_1
      //   1289: iconst_0
      //   1290: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   1293: aload 32
      //   1295: ifnull +8 -> 1303
      //   1298: aload 32
      //   1300: invokevirtual 379	java/io/InputStream:close	()V
      //   1303: aload 26
      //   1305: ifnull +8 -> 1313
      //   1308: aload 26
      //   1310: invokevirtual 379	java/io/InputStream:close	()V
      //   1313: aload 30
      //   1315: ifnull +8 -> 1323
      //   1318: aload 30
      //   1320: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   1323: aload_0
      //   1324: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   1327: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   1330: aload_1
      //   1331: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   1334: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   1337: pop
      //   1338: ldc 41
      //   1340: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1343: return
      //   1344: aload 29
      //   1346: ldc_w 399
      //   1349: aload_0
      //   1350: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   1353: getfield 402	com/tencent/mm/plugin/appbrand/q/g:kwo	Ljava/lang/String;
      //   1356: invokevirtual 269	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1359: aload 31
      //   1361: invokevirtual 288	com/tencent/mm/vfs/e:length	()J
      //   1364: lstore 23
      //   1366: new 404	java/lang/StringBuilder
      //   1369: dup
      //   1370: invokespecial 405	java/lang/StringBuilder:<init>	()V
      //   1373: astore 38
      //   1375: new 404	java/lang/StringBuilder
      //   1378: dup
      //   1379: invokespecial 405	java/lang/StringBuilder:<init>	()V
      //   1382: astore 37
      //   1384: aload 28
      //   1386: ifnull +665 -> 2051
      //   1389: aload 29
      //   1391: ldc_w 407
      //   1394: ldc_w 409
      //   1397: aload 32
      //   1399: invokestatic 412	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   1402: invokevirtual 416	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1405: invokevirtual 269	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   1408: aload 28
      //   1410: invokeinterface 419 1 0
      //   1415: invokeinterface 309 1 0
      //   1420: astore 39
      //   1422: aload 39
      //   1424: invokeinterface 315 1 0
      //   1429: ifeq +462 -> 1891
      //   1432: aload 39
      //   1434: invokeinterface 319 1 0
      //   1439: checkcast 331	java/lang/String
      //   1442: astore 40
      //   1444: aload 28
      //   1446: aload 40
      //   1448: invokeinterface 423 2 0
      //   1453: checkcast 331	java/lang/String
      //   1456: astore 41
      //   1458: ldc 73
      //   1460: ldc_w 425
      //   1463: iconst_2
      //   1464: anewarray 4	java/lang/Object
      //   1467: dup
      //   1468: iconst_0
      //   1469: aload 40
      //   1471: aastore
      //   1472: dup
      //   1473: iconst_1
      //   1474: aload 41
      //   1476: aastore
      //   1477: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1480: aload 38
      //   1482: new 404	java/lang/StringBuilder
      //   1485: dup
      //   1486: invokespecial 405	java/lang/StringBuilder:<init>	()V
      //   1489: ldc_w 427
      //   1492: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1495: aload 32
      //   1497: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1500: ldc_w 433
      //   1503: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1506: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1509: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1512: pop
      //   1513: aload 38
      //   1515: new 404	java/lang/StringBuilder
      //   1518: dup
      //   1519: ldc_w 437
      //   1522: invokespecial 438	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1525: aload 40
      //   1527: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1530: ldc_w 440
      //   1533: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1536: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1539: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1542: pop
      //   1543: aload 38
      //   1545: ldc_w 433
      //   1548: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1551: pop
      //   1552: aload 38
      //   1554: ldc_w 433
      //   1557: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1560: pop
      //   1561: aload 38
      //   1563: aload 41
      //   1565: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1568: pop
      //   1569: aload 38
      //   1571: ldc_w 433
      //   1574: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1577: pop
      //   1578: goto -156 -> 1422
      //   1581: astore 28
      //   1583: aconst_null
      //   1584: astore 26
      //   1586: aconst_null
      //   1587: astore 30
      //   1589: iconst_0
      //   1590: istore_2
      //   1591: iload 10
      //   1593: istore 5
      //   1595: aload 25
      //   1597: astore 32
      //   1599: aload 29
      //   1601: astore 31
      //   1603: iload_2
      //   1604: istore 4
      //   1606: aload 32
      //   1608: astore 29
      //   1610: aload 26
      //   1612: astore 27
      //   1614: aload 30
      //   1616: astore 25
      //   1618: iload 5
      //   1620: istore_3
      //   1621: lload 21
      //   1623: lstore 23
      //   1625: ldc 185
      //   1627: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1630: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   1633: ldc2_w 186
      //   1636: ldc2_w 441
      //   1639: lconst_1
      //   1640: iconst_0
      //   1641: invokeinterface 191 8 0
      //   1646: iload_2
      //   1647: istore 4
      //   1649: aload 32
      //   1651: astore 29
      //   1653: aload 26
      //   1655: astore 27
      //   1657: aload 30
      //   1659: astore 25
      //   1661: iload 5
      //   1663: istore_3
      //   1664: lload 21
      //   1666: lstore 23
      //   1668: ldc 73
      //   1670: aload 28
      //   1672: ldc_w 444
      //   1675: iconst_2
      //   1676: anewarray 4	java/lang/Object
      //   1679: dup
      //   1680: iconst_0
      //   1681: aload 33
      //   1683: aastore
      //   1684: dup
      //   1685: iconst_1
      //   1686: aload 34
      //   1688: aastore
      //   1689: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1692: iload_2
      //   1693: istore 4
      //   1695: aload 32
      //   1697: astore 29
      //   1699: aload 26
      //   1701: astore 27
      //   1703: aload 30
      //   1705: astore 25
      //   1707: iload 5
      //   1709: istore_3
      //   1710: lload 21
      //   1712: lstore 23
      //   1714: aload_0
      //   1715: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   1718: aload 36
      //   1720: iconst_m1
      //   1721: ldc_w 446
      //   1724: iload_2
      //   1725: aload_1
      //   1726: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   1729: aload 31
      //   1731: invokestatic 353	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   1734: ldc 113
      //   1736: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1739: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   1742: aload_0
      //   1743: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   1746: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   1749: invokeinterface 129 1 0
      //   1754: aload_1
      //   1755: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   1758: ldc 134
      //   1760: aload_1
      //   1761: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   1764: lload 21
      //   1766: iload 5
      //   1768: i2l
      //   1769: iload_2
      //   1770: iconst_2
      //   1771: aload_1
      //   1772: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   1775: aconst_null
      //   1776: aload 35
      //   1778: invokeinterface 141 14 0
      //   1783: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   1786: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   1789: istore_2
      //   1790: iload_2
      //   1791: iconst_m1
      //   1792: if_icmpne +24 -> 1816
      //   1795: ldc 185
      //   1797: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   1800: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   1803: ldc2_w 186
      //   1806: ldc2_w 366
      //   1809: lconst_1
      //   1810: iconst_0
      //   1811: invokeinterface 191 8 0
      //   1816: ldc 73
      //   1818: ldc_w 369
      //   1821: iconst_1
      //   1822: anewarray 4	java/lang/Object
      //   1825: dup
      //   1826: iconst_0
      //   1827: iload_2
      //   1828: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1831: aastore
      //   1832: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1835: aload_1
      //   1836: iconst_0
      //   1837: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   1840: aload 32
      //   1842: ifnull +8 -> 1850
      //   1845: aload 32
      //   1847: invokevirtual 379	java/io/InputStream:close	()V
      //   1850: aload 26
      //   1852: ifnull +8 -> 1860
      //   1855: aload 26
      //   1857: invokevirtual 379	java/io/InputStream:close	()V
      //   1860: aload 30
      //   1862: ifnull +8 -> 1870
      //   1865: aload 30
      //   1867: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   1870: aload_0
      //   1871: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   1874: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   1877: aload_1
      //   1878: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   1881: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   1884: pop
      //   1885: ldc 41
      //   1887: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   1890: return
      //   1891: aload 38
      //   1893: new 404	java/lang/StringBuilder
      //   1896: dup
      //   1897: invokespecial 405	java/lang/StringBuilder:<init>	()V
      //   1900: ldc_w 427
      //   1903: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1906: aload 32
      //   1908: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1911: ldc_w 433
      //   1914: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1917: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1920: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1923: pop
      //   1924: aload 38
      //   1926: new 404	java/lang/StringBuilder
      //   1929: dup
      //   1930: ldc_w 437
      //   1933: invokespecial 438	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1936: aload 26
      //   1938: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1941: ldc_w 448
      //   1944: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1947: aload 27
      //   1949: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1952: ldc_w 440
      //   1955: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1958: ldc_w 433
      //   1961: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1964: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1967: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1970: pop
      //   1971: aload 38
      //   1973: ldc_w 450
      //   1976: aload 35
      //   1978: invokestatic 412	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   1981: invokevirtual 416	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1984: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1987: pop
      //   1988: aload 38
      //   1990: ldc_w 433
      //   1993: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1996: pop
      //   1997: aload 38
      //   1999: ldc_w 433
      //   2002: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2005: pop
      //   2006: aload 37
      //   2008: new 404	java/lang/StringBuilder
      //   2011: dup
      //   2012: invokespecial 405	java/lang/StringBuilder:<init>	()V
      //   2015: ldc_w 433
      //   2018: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2021: ldc_w 427
      //   2024: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2027: aload 32
      //   2029: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2032: ldc_w 427
      //   2035: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2038: ldc_w 433
      //   2041: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2044: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2047: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2050: pop
      //   2051: aload 38
      //   2053: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2056: ldc_w 452
      //   2059: invokevirtual 456	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   2062: astore 27
      //   2064: aload 37
      //   2066: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2069: ldc_w 452
      //   2072: invokevirtual 456	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   2075: astore 28
      //   2077: aload 27
      //   2079: astore 26
      //   2081: aload 27
      //   2083: ifnonnull +8 -> 2091
      //   2086: iconst_0
      //   2087: newarray byte
      //   2089: astore 26
      //   2091: aload 28
      //   2093: ifnonnull +4906 -> 6999
      //   2096: iconst_0
      //   2097: newarray byte
      //   2099: astore 28
      //   2101: lload 23
      //   2103: aload 26
      //   2105: arraylength
      //   2106: i2l
      //   2107: ladd
      //   2108: aload 28
      //   2110: arraylength
      //   2111: i2l
      //   2112: ladd
      //   2113: lstore 23
      //   2115: ldc 73
      //   2117: ldc_w 458
      //   2120: iconst_1
      //   2121: anewarray 4	java/lang/Object
      //   2124: dup
      //   2125: iconst_0
      //   2126: lload 23
      //   2128: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2131: aastore
      //   2132: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2135: aload 29
      //   2137: ldc_w 460
      //   2140: lload 23
      //   2142: invokestatic 462	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   2145: invokevirtual 269	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   2148: aload 36
      //   2150: aload 29
      //   2152: invokestatic 465	com/tencent/mm/plugin/appbrand/q/j:c	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
      //   2155: invokeinterface 471 2 0
      //   2160: new 381	java/io/DataOutputStream
      //   2163: dup
      //   2164: aload 29
      //   2166: invokevirtual 475	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
      //   2169: invokespecial 478	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   2172: astore 27
      //   2174: aload 27
      //   2176: aload 26
      //   2178: invokevirtual 482	java/io/DataOutputStream:write	([B)V
      //   2181: lload 23
      //   2183: invokestatic 486	com/tencent/mm/plugin/appbrand/q/j:nk	(J)I
      //   2186: newarray byte
      //   2188: astore 26
      //   2190: aload 31
      //   2192: invokevirtual 288	com/tencent/mm/vfs/e:length	()J
      //   2195: lstore 23
      //   2197: iconst_m1
      //   2198: istore_2
      //   2199: lconst_0
      //   2200: lstore 21
      //   2202: iload 14
      //   2204: istore_3
      //   2205: iload 15
      //   2207: istore 4
      //   2209: iload 16
      //   2211: istore 5
      //   2213: iload 17
      //   2215: istore 6
      //   2217: iload 18
      //   2219: istore 7
      //   2221: iload 19
      //   2223: istore 8
      //   2225: aload 25
      //   2227: aload 26
      //   2229: invokevirtual 490	java/io/InputStream:read	([B)I
      //   2232: istore 20
      //   2234: iload 20
      //   2236: iconst_m1
      //   2237: if_icmpeq +440 -> 2677
      //   2240: iload 14
      //   2242: istore_3
      //   2243: iload 15
      //   2245: istore 4
      //   2247: iload 16
      //   2249: istore 5
      //   2251: iload 17
      //   2253: istore 6
      //   2255: iload 18
      //   2257: istore 7
      //   2259: iload 19
      //   2261: istore 8
      //   2263: aload_1
      //   2264: getfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   2267: ifeq +410 -> 2677
      //   2270: iload 14
      //   2272: istore_3
      //   2273: iload 15
      //   2275: istore 4
      //   2277: iload 16
      //   2279: istore 5
      //   2281: iload 17
      //   2283: istore 6
      //   2285: iload 18
      //   2287: istore 7
      //   2289: iload 19
      //   2291: istore 8
      //   2293: aload_0
      //   2294: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   2297: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   2300: invokestatic 494	com/tencent/mm/plugin/appbrand/q/j:F	(Lcom/tencent/mm/plugin/appbrand/jsapi/c;)Z
      //   2303: ifeq +242 -> 2545
      //   2306: iload 14
      //   2308: istore_3
      //   2309: iload 15
      //   2311: istore 4
      //   2313: iload 16
      //   2315: istore 5
      //   2317: iload 17
      //   2319: istore 6
      //   2321: iload 18
      //   2323: istore 7
      //   2325: iload 19
      //   2327: istore 8
      //   2329: aload_0
      //   2330: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   2333: aload 36
      //   2335: ldc_w 496
      //   2338: aload_1
      //   2339: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   2342: aload 29
      //   2344: invokestatic 111	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;Ljava/lang/String;Ljava/lang/String;Ljava/net/HttpURLConnection;)V
      //   2347: ldc 113
      //   2349: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   2352: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   2355: aload_0
      //   2356: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   2359: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   2362: invokeinterface 129 1 0
      //   2367: aload_1
      //   2368: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   2371: ldc 134
      //   2373: aload_1
      //   2374: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   2377: lload 21
      //   2379: lconst_0
      //   2380: iconst_0
      //   2381: iconst_2
      //   2382: aload_1
      //   2383: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   2386: aconst_null
      //   2387: aload 35
      //   2389: invokeinterface 141 14 0
      //   2394: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   2397: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   2400: istore_2
      //   2401: iload_2
      //   2402: iconst_m1
      //   2403: if_icmpne +24 -> 2427
      //   2406: ldc 185
      //   2408: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   2411: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   2414: ldc2_w 186
      //   2417: ldc2_w 366
      //   2420: lconst_1
      //   2421: iconst_0
      //   2422: invokeinterface 191 8 0
      //   2427: ldc 73
      //   2429: ldc_w 369
      //   2432: iconst_1
      //   2433: anewarray 4	java/lang/Object
      //   2436: dup
      //   2437: iconst_0
      //   2438: iload_2
      //   2439: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2442: aastore
      //   2443: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2446: aload_1
      //   2447: iconst_0
      //   2448: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   2451: aload 25
      //   2453: ifnull +8 -> 2461
      //   2456: aload 25
      //   2458: invokevirtual 379	java/io/InputStream:close	()V
      //   2461: aload 27
      //   2463: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   2466: aload_0
      //   2467: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   2470: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   2473: aload_1
      //   2474: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   2477: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   2480: pop
      //   2481: ldc 41
      //   2483: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   2486: return
      //   2487: astore 25
      //   2489: ldc 73
      //   2491: aload 25
      //   2493: ldc_w 498
      //   2496: iconst_2
      //   2497: anewarray 4	java/lang/Object
      //   2500: dup
      //   2501: iconst_0
      //   2502: aload 33
      //   2504: aastore
      //   2505: dup
      //   2506: iconst_1
      //   2507: aload 34
      //   2509: aastore
      //   2510: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2513: goto -52 -> 2461
      //   2516: astore 25
      //   2518: ldc 73
      //   2520: aload 25
      //   2522: ldc_w 500
      //   2525: iconst_2
      //   2526: anewarray 4	java/lang/Object
      //   2529: dup
      //   2530: iconst_0
      //   2531: aload 33
      //   2533: aastore
      //   2534: dup
      //   2535: iconst_1
      //   2536: aload 34
      //   2538: aastore
      //   2539: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2542: goto -76 -> 2466
      //   2545: iload 14
      //   2547: istore_3
      //   2548: iload 15
      //   2550: istore 4
      //   2552: iload 16
      //   2554: istore 5
      //   2556: iload 17
      //   2558: istore 6
      //   2560: iload 18
      //   2562: istore 7
      //   2564: iload 19
      //   2566: istore 8
      //   2568: aload 27
      //   2570: aload 26
      //   2572: iconst_0
      //   2573: iload 20
      //   2575: invokevirtual 503	java/io/DataOutputStream:write	([BII)V
      //   2578: iload 20
      //   2580: i2l
      //   2581: lload 21
      //   2583: ladd
      //   2584: lstore 21
      //   2586: lload 23
      //   2588: lconst_0
      //   2589: lcmp
      //   2590: ifle +4406 -> 6996
      //   2593: aload_1
      //   2594: getfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   2597: ifeq +4399 -> 6996
      //   2600: ldc2_w 504
      //   2603: lload 21
      //   2605: lmul
      //   2606: lload 23
      //   2608: ldiv
      //   2609: l2i
      //   2610: istore 4
      //   2612: iload_2
      //   2613: istore_3
      //   2614: iload_2
      //   2615: iload 4
      //   2617: if_icmpeq +19 -> 2636
      //   2620: aload 36
      //   2622: iload 4
      //   2624: lload 21
      //   2626: lload 23
      //   2628: invokeinterface 509 6 0
      //   2633: iload 4
      //   2635: istore_3
      //   2636: ldc 73
      //   2638: ldc_w 511
      //   2641: iconst_3
      //   2642: anewarray 4	java/lang/Object
      //   2645: dup
      //   2646: iconst_0
      //   2647: lload 21
      //   2649: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2652: aastore
      //   2653: dup
      //   2654: iconst_1
      //   2655: lload 23
      //   2657: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   2660: aastore
      //   2661: dup
      //   2662: iconst_2
      //   2663: iload 4
      //   2665: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2668: aastore
      //   2669: invokestatic 81	com/tencent/mm/sdk/platformtools/ad:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2672: iload_3
      //   2673: istore_2
      //   2674: goto -472 -> 2202
      //   2677: iload 14
      //   2679: istore_3
      //   2680: iload 15
      //   2682: istore 4
      //   2684: iload 16
      //   2686: istore 5
      //   2688: iload 17
      //   2690: istore 6
      //   2692: iload 18
      //   2694: istore 7
      //   2696: iload 19
      //   2698: istore 8
      //   2700: aload 27
      //   2702: aload 28
      //   2704: invokevirtual 482	java/io/DataOutputStream:write	([B)V
      //   2707: iload 14
      //   2709: istore_3
      //   2710: iload 15
      //   2712: istore 4
      //   2714: iload 16
      //   2716: istore 5
      //   2718: iload 17
      //   2720: istore 6
      //   2722: iload 18
      //   2724: istore 7
      //   2726: iload 19
      //   2728: istore 8
      //   2730: aload 27
      //   2732: invokevirtual 514	java/io/DataOutputStream:flush	()V
      //   2735: iload 14
      //   2737: istore_3
      //   2738: iload 15
      //   2740: istore 4
      //   2742: iload 16
      //   2744: istore 5
      //   2746: iload 17
      //   2748: istore 6
      //   2750: iload 18
      //   2752: istore 7
      //   2754: iload 19
      //   2756: istore 8
      //   2758: aload 29
      //   2760: invokevirtual 517	java/net/HttpURLConnection:getResponseCode	()I
      //   2763: istore_2
      //   2764: iload_2
      //   2765: istore_3
      //   2766: iload_2
      //   2767: istore 4
      //   2769: iload_2
      //   2770: istore 5
      //   2772: iload_2
      //   2773: istore 6
      //   2775: iload_2
      //   2776: istore 7
      //   2778: iload_2
      //   2779: istore 8
      //   2781: aload 36
      //   2783: aload 29
      //   2785: invokestatic 519	com/tencent/mm/plugin/appbrand/q/j:b	(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;
      //   2788: invokeinterface 471 2 0
      //   2793: sipush 200
      //   2796: iload_2
      //   2797: if_icmpeq +687 -> 3484
      //   2800: iload_2
      //   2801: istore_3
      //   2802: iload_2
      //   2803: istore 4
      //   2805: iload_2
      //   2806: istore 5
      //   2808: iload_2
      //   2809: istore 6
      //   2811: iload_2
      //   2812: istore 7
      //   2814: iload_2
      //   2815: istore 8
      //   2817: ldc 73
      //   2819: ldc_w 521
      //   2822: iconst_3
      //   2823: anewarray 4	java/lang/Object
      //   2826: dup
      //   2827: iconst_0
      //   2828: iload_2
      //   2829: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2832: aastore
      //   2833: dup
      //   2834: iconst_1
      //   2835: aload 33
      //   2837: aastore
      //   2838: dup
      //   2839: iconst_2
      //   2840: aload 34
      //   2842: aastore
      //   2843: invokestatic 523	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2846: iload_2
      //   2847: istore_3
      //   2848: iload_2
      //   2849: istore 4
      //   2851: iload_2
      //   2852: istore 5
      //   2854: iload_2
      //   2855: istore 6
      //   2857: iload_2
      //   2858: istore 7
      //   2860: iload_2
      //   2861: istore 8
      //   2863: iload_2
      //   2864: invokestatic 527	com/tencent/mm/plugin/appbrand/q/j:na	(I)Z
      //   2867: ifeq +617 -> 3484
      //   2870: iload_2
      //   2871: istore_3
      //   2872: iload_2
      //   2873: istore 4
      //   2875: iload_2
      //   2876: istore 5
      //   2878: iload_2
      //   2879: istore 6
      //   2881: iload_2
      //   2882: istore 7
      //   2884: iload_2
      //   2885: istore 8
      //   2887: aload 29
      //   2889: invokestatic 530	com/tencent/mm/plugin/appbrand/q/j:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
      //   2892: astore 26
      //   2894: iload_2
      //   2895: istore_3
      //   2896: iload_2
      //   2897: istore 4
      //   2899: iload_2
      //   2900: istore 5
      //   2902: iload_2
      //   2903: istore 6
      //   2905: iload_2
      //   2906: istore 7
      //   2908: iload_2
      //   2909: istore 8
      //   2911: aload_1
      //   2912: getfield 533	com/tencent/mm/plugin/appbrand/q/h:kVf	I
      //   2915: istore 14
      //   2917: iload_2
      //   2918: istore_3
      //   2919: iload_2
      //   2920: istore 4
      //   2922: iload_2
      //   2923: istore 5
      //   2925: iload_2
      //   2926: istore 6
      //   2928: iload_2
      //   2929: istore 7
      //   2931: iload_2
      //   2932: istore 8
      //   2934: aload 26
      //   2936: invokestatic 538	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   2939: ifne +545 -> 3484
      //   2942: iload 14
      //   2944: ifgt +223 -> 3167
      //   2947: iload_2
      //   2948: istore_3
      //   2949: iload_2
      //   2950: istore 4
      //   2952: iload_2
      //   2953: istore 5
      //   2955: iload_2
      //   2956: istore 6
      //   2958: iload_2
      //   2959: istore 7
      //   2961: iload_2
      //   2962: istore 8
      //   2964: ldc 73
      //   2966: ldc_w 540
      //   2969: iconst_1
      //   2970: anewarray 4	java/lang/Object
      //   2973: dup
      //   2974: iconst_0
      //   2975: bipush 15
      //   2977: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   2980: aastore
      //   2981: invokestatic 543	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   2984: iload_2
      //   2985: istore_3
      //   2986: iload_2
      //   2987: istore 4
      //   2989: iload_2
      //   2990: istore 5
      //   2992: iload_2
      //   2993: istore 6
      //   2995: iload_2
      //   2996: istore 7
      //   2998: iload_2
      //   2999: istore 8
      //   3001: aload_0
      //   3002: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   3005: aload 36
      //   3007: iconst_0
      //   3008: ldc_w 545
      //   3011: iload_2
      //   3012: aload_1
      //   3013: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   3016: aload 29
      //   3018: invokestatic 353	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   3021: ldc 113
      //   3023: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3026: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   3029: aload_0
      //   3030: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   3033: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   3036: invokeinterface 129 1 0
      //   3041: aload_1
      //   3042: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   3045: ldc 134
      //   3047: aload_1
      //   3048: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   3051: lload 21
      //   3053: lconst_0
      //   3054: iload_2
      //   3055: iconst_1
      //   3056: aload_1
      //   3057: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   3060: aconst_null
      //   3061: aload 35
      //   3063: invokeinterface 141 14 0
      //   3068: aload_1
      //   3069: iconst_0
      //   3070: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   3073: aload 25
      //   3075: ifnull +8 -> 3083
      //   3078: aload 25
      //   3080: invokevirtual 379	java/io/InputStream:close	()V
      //   3083: aload 27
      //   3085: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   3088: aload_0
      //   3089: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   3092: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   3095: aload_1
      //   3096: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   3099: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   3102: pop
      //   3103: ldc 41
      //   3105: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   3108: return
      //   3109: astore 25
      //   3111: ldc 73
      //   3113: aload 25
      //   3115: ldc_w 498
      //   3118: iconst_2
      //   3119: anewarray 4	java/lang/Object
      //   3122: dup
      //   3123: iconst_0
      //   3124: aload 33
      //   3126: aastore
      //   3127: dup
      //   3128: iconst_1
      //   3129: aload 34
      //   3131: aastore
      //   3132: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3135: goto -52 -> 3083
      //   3138: astore 25
      //   3140: ldc 73
      //   3142: aload 25
      //   3144: ldc_w 500
      //   3147: iconst_2
      //   3148: anewarray 4	java/lang/Object
      //   3151: dup
      //   3152: iconst_0
      //   3153: aload 33
      //   3155: aastore
      //   3156: dup
      //   3157: iconst_1
      //   3158: aload 34
      //   3160: aastore
      //   3161: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3164: goto -76 -> 3088
      //   3167: iload_2
      //   3168: istore_3
      //   3169: iload_2
      //   3170: istore 4
      //   3172: iload_2
      //   3173: istore 5
      //   3175: iload_2
      //   3176: istore 6
      //   3178: iload_2
      //   3179: istore 7
      //   3181: iload_2
      //   3182: istore 8
      //   3184: ldc 73
      //   3186: ldc_w 547
      //   3189: iconst_3
      //   3190: anewarray 4	java/lang/Object
      //   3193: dup
      //   3194: iconst_0
      //   3195: iload 14
      //   3197: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3200: aastore
      //   3201: dup
      //   3202: iconst_1
      //   3203: aload_1
      //   3204: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   3207: aastore
      //   3208: dup
      //   3209: iconst_2
      //   3210: aload 26
      //   3212: aastore
      //   3213: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3216: iload_2
      //   3217: istore_3
      //   3218: iload_2
      //   3219: istore 4
      //   3221: iload_2
      //   3222: istore 5
      //   3224: iload_2
      //   3225: istore 6
      //   3227: iload_2
      //   3228: istore 7
      //   3230: iload_2
      //   3231: istore 8
      //   3233: aload_1
      //   3234: aload 26
      //   3236: putfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   3239: iload_2
      //   3240: istore_3
      //   3241: iload_2
      //   3242: istore 4
      //   3244: iload_2
      //   3245: istore 5
      //   3247: iload_2
      //   3248: istore 6
      //   3250: iload_2
      //   3251: istore 7
      //   3253: iload_2
      //   3254: istore 8
      //   3256: aload_1
      //   3257: iload 14
      //   3259: iconst_1
      //   3260: isub
      //   3261: putfield 533	com/tencent/mm/plugin/appbrand/q/h:kVf	I
      //   3264: iload_2
      //   3265: istore_3
      //   3266: iload_2
      //   3267: istore 4
      //   3269: iload_2
      //   3270: istore 5
      //   3272: iload_2
      //   3273: istore 6
      //   3275: iload_2
      //   3276: istore 7
      //   3278: iload_2
      //   3279: istore 8
      //   3281: aload_0
      //   3282: aload_1
      //   3283: invokespecial 549	com/tencent/mm/plugin/appbrand/q/g$b:b	(Lcom/tencent/mm/plugin/appbrand/q/h;)V
      //   3286: ldc 113
      //   3288: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3291: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   3294: aload_0
      //   3295: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   3298: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   3301: invokeinterface 129 1 0
      //   3306: aload_1
      //   3307: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   3310: ldc 134
      //   3312: aload_1
      //   3313: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   3316: lload 21
      //   3318: lconst_0
      //   3319: iload_2
      //   3320: iconst_2
      //   3321: aload_1
      //   3322: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   3325: aconst_null
      //   3326: aload 35
      //   3328: invokeinterface 141 14 0
      //   3333: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   3336: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   3339: istore_2
      //   3340: iload_2
      //   3341: iconst_m1
      //   3342: if_icmpne +24 -> 3366
      //   3345: ldc 185
      //   3347: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3350: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   3353: ldc2_w 186
      //   3356: ldc2_w 366
      //   3359: lconst_1
      //   3360: iconst_0
      //   3361: invokeinterface 191 8 0
      //   3366: ldc 73
      //   3368: ldc_w 369
      //   3371: iconst_1
      //   3372: anewarray 4	java/lang/Object
      //   3375: dup
      //   3376: iconst_0
      //   3377: iload_2
      //   3378: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3381: aastore
      //   3382: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3385: aload_1
      //   3386: iconst_0
      //   3387: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   3390: aload 25
      //   3392: ifnull +8 -> 3400
      //   3395: aload 25
      //   3397: invokevirtual 379	java/io/InputStream:close	()V
      //   3400: aload 27
      //   3402: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   3405: aload_0
      //   3406: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   3409: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   3412: aload_1
      //   3413: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   3416: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   3419: pop
      //   3420: ldc 41
      //   3422: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   3425: return
      //   3426: astore 25
      //   3428: ldc 73
      //   3430: aload 25
      //   3432: ldc_w 498
      //   3435: iconst_2
      //   3436: anewarray 4	java/lang/Object
      //   3439: dup
      //   3440: iconst_0
      //   3441: aload 33
      //   3443: aastore
      //   3444: dup
      //   3445: iconst_1
      //   3446: aload 34
      //   3448: aastore
      //   3449: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3452: goto -52 -> 3400
      //   3455: astore 25
      //   3457: ldc 73
      //   3459: aload 25
      //   3461: ldc_w 500
      //   3464: iconst_2
      //   3465: anewarray 4	java/lang/Object
      //   3468: dup
      //   3469: iconst_0
      //   3470: aload 33
      //   3472: aastore
      //   3473: dup
      //   3474: iconst_1
      //   3475: aload 34
      //   3477: aastore
      //   3478: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3481: goto -76 -> 3405
      //   3484: iload_2
      //   3485: istore_3
      //   3486: iload_2
      //   3487: istore 4
      //   3489: iload_2
      //   3490: istore 5
      //   3492: iload_2
      //   3493: istore 6
      //   3495: iload_2
      //   3496: istore 7
      //   3498: iload_2
      //   3499: istore 8
      //   3501: ldc 73
      //   3503: ldc_w 551
      //   3506: iconst_1
      //   3507: anewarray 4	java/lang/Object
      //   3510: dup
      //   3511: iconst_0
      //   3512: aload 33
      //   3514: aastore
      //   3515: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3518: iload_2
      //   3519: istore_3
      //   3520: iload_2
      //   3521: istore 5
      //   3523: iload_2
      //   3524: istore 6
      //   3526: iload_2
      //   3527: istore 7
      //   3529: iload_2
      //   3530: istore 8
      //   3532: ldc_w 273
      //   3535: aload 29
      //   3537: invokevirtual 554	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
      //   3540: invokevirtual 557	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   3543: ifeq +100 -> 3643
      //   3546: iload_2
      //   3547: istore_3
      //   3548: iload_2
      //   3549: istore 5
      //   3551: iload_2
      //   3552: istore 6
      //   3554: iload_2
      //   3555: istore 7
      //   3557: iload_2
      //   3558: istore 8
      //   3560: new 559	java/util/zip/GZIPInputStream
      //   3563: dup
      //   3564: aload 29
      //   3566: invokevirtual 563	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   3569: invokespecial 566	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   3572: astore 26
      //   3574: aload 26
      //   3576: ifnull +3410 -> 6986
      //   3579: new 568	java/io/BufferedReader
      //   3582: dup
      //   3583: new 570	java/io/InputStreamReader
      //   3586: dup
      //   3587: aload 26
      //   3589: invokespecial 571	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   3592: invokespecial 574	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   3595: astore 28
      //   3597: new 404	java/lang/StringBuilder
      //   3600: dup
      //   3601: invokespecial 405	java/lang/StringBuilder:<init>	()V
      //   3604: astore 31
      //   3606: aload 28
      //   3608: invokevirtual 577	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   3611: astore 32
      //   3613: aload 32
      //   3615: ifnull +207 -> 3822
      //   3618: aload_1
      //   3619: getfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   3622: ifeq +200 -> 3822
      //   3625: aload 31
      //   3627: aload 32
      //   3629: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   3632: pop
      //   3633: goto -27 -> 3606
      //   3636: astore 28
      //   3638: iconst_0
      //   3639: istore_3
      //   3640: goto -2853 -> 787
      //   3643: iload_2
      //   3644: istore_3
      //   3645: iload_2
      //   3646: istore 5
      //   3648: iload_2
      //   3649: istore 6
      //   3651: iload_2
      //   3652: istore 7
      //   3654: iload_2
      //   3655: istore 8
      //   3657: aload 29
      //   3659: invokevirtual 563	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   3662: astore 26
      //   3664: goto -90 -> 3574
      //   3667: astore 28
      //   3669: iload_2
      //   3670: istore_3
      //   3671: iload_2
      //   3672: istore 4
      //   3674: iload_2
      //   3675: istore 5
      //   3677: iload_2
      //   3678: istore 6
      //   3680: iload_2
      //   3681: istore 7
      //   3683: iload_2
      //   3684: istore 8
      //   3686: ldc 73
      //   3688: aload 28
      //   3690: ldc_w 579
      //   3693: iconst_0
      //   3694: anewarray 4	java/lang/Object
      //   3697: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3700: iload_2
      //   3701: istore_3
      //   3702: iload_2
      //   3703: istore 5
      //   3705: iload_2
      //   3706: istore 6
      //   3708: iload_2
      //   3709: istore 7
      //   3711: iload_2
      //   3712: istore 8
      //   3714: ldc_w 273
      //   3717: aload 29
      //   3719: invokevirtual 554	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
      //   3722: invokevirtual 557	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   3725: ifeq +73 -> 3798
      //   3728: iload_2
      //   3729: istore_3
      //   3730: iload_2
      //   3731: istore 5
      //   3733: iload_2
      //   3734: istore 6
      //   3736: iload_2
      //   3737: istore 7
      //   3739: iload_2
      //   3740: istore 8
      //   3742: new 559	java/util/zip/GZIPInputStream
      //   3745: dup
      //   3746: aload 29
      //   3748: invokevirtual 582	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
      //   3751: invokespecial 566	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
      //   3754: astore 26
      //   3756: goto -182 -> 3574
      //   3759: astore 26
      //   3761: iload_2
      //   3762: istore_3
      //   3763: iload_2
      //   3764: istore 4
      //   3766: iload_2
      //   3767: istore 5
      //   3769: iload_2
      //   3770: istore 6
      //   3772: iload_2
      //   3773: istore 7
      //   3775: iload_2
      //   3776: istore 8
      //   3778: ldc 73
      //   3780: aload 28
      //   3782: ldc_w 584
      //   3785: iconst_0
      //   3786: anewarray 4	java/lang/Object
      //   3789: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3792: aconst_null
      //   3793: astore 26
      //   3795: goto -221 -> 3574
      //   3798: iload_2
      //   3799: istore_3
      //   3800: iload_2
      //   3801: istore 5
      //   3803: iload_2
      //   3804: istore 6
      //   3806: iload_2
      //   3807: istore 7
      //   3809: iload_2
      //   3810: istore 8
      //   3812: aload 29
      //   3814: invokevirtual 582	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
      //   3817: astore 26
      //   3819: goto -245 -> 3574
      //   3822: aload 31
      //   3824: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   3827: astore 28
      //   3829: aload 28
      //   3831: ldc_w 452
      //   3834: invokestatic 590	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
      //   3837: invokevirtual 593	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
      //   3840: arraylength
      //   3841: istore_3
      //   3842: ldc 73
      //   3844: ldc_w 595
      //   3847: iconst_3
      //   3848: anewarray 4	java/lang/Object
      //   3851: dup
      //   3852: iconst_0
      //   3853: aload 30
      //   3855: aastore
      //   3856: dup
      //   3857: iconst_1
      //   3858: aload 28
      //   3860: aastore
      //   3861: dup
      //   3862: iconst_2
      //   3863: iload_2
      //   3864: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   3867: aastore
      //   3868: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3871: aload_1
      //   3872: getfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   3875: ifeq +151 -> 4026
      //   3878: aload_0
      //   3879: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   3882: aload 36
      //   3884: iconst_0
      //   3885: aload 28
      //   3887: iload_2
      //   3888: aload_1
      //   3889: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   3892: aload 29
      //   3894: invokestatic 353	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   3897: ldc 73
      //   3899: ldc_w 597
      //   3902: iconst_2
      //   3903: anewarray 4	java/lang/Object
      //   3906: dup
      //   3907: iconst_0
      //   3908: aload 33
      //   3910: aastore
      //   3911: dup
      //   3912: iconst_1
      //   3913: aload 34
      //   3915: aastore
      //   3916: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   3919: iconst_1
      //   3920: istore 4
      //   3922: iload 4
      //   3924: ifeq +134 -> 4058
      //   3927: ldc 113
      //   3929: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   3932: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   3935: aload_0
      //   3936: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   3939: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   3942: invokeinterface 129 1 0
      //   3947: aload_1
      //   3948: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   3951: ldc 134
      //   3953: aload_1
      //   3954: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   3957: lload 21
      //   3959: iload_3
      //   3960: i2l
      //   3961: iload_2
      //   3962: iconst_1
      //   3963: aload_1
      //   3964: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   3967: aconst_null
      //   3968: aload 35
      //   3970: invokeinterface 141 14 0
      //   3975: aload_1
      //   3976: iconst_0
      //   3977: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   3980: aload 25
      //   3982: ifnull +8 -> 3990
      //   3985: aload 25
      //   3987: invokevirtual 379	java/io/InputStream:close	()V
      //   3990: aload 26
      //   3992: ifnull +8 -> 4000
      //   3995: aload 26
      //   3997: invokevirtual 379	java/io/InputStream:close	()V
      //   4000: aload 27
      //   4002: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   4005: aload_0
      //   4006: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   4009: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   4012: aload_1
      //   4013: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   4016: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   4019: pop
      //   4020: ldc 41
      //   4022: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   4025: return
      //   4026: aload_0
      //   4027: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   4030: aload 36
      //   4032: iconst_m1
      //   4033: ldc 154
      //   4035: iload_2
      //   4036: aload_1
      //   4037: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   4040: aload 29
      //   4042: invokestatic 353	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   4045: ldc 73
      //   4047: ldc 156
      //   4049: invokestatic 160	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   4052: iconst_0
      //   4053: istore 4
      //   4055: goto -133 -> 3922
      //   4058: ldc 113
      //   4060: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4063: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   4066: aload_0
      //   4067: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   4070: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   4073: invokeinterface 129 1 0
      //   4078: aload_1
      //   4079: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   4082: ldc 134
      //   4084: aload_1
      //   4085: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   4088: lload 21
      //   4090: iload_3
      //   4091: i2l
      //   4092: iload_2
      //   4093: iconst_2
      //   4094: aload_1
      //   4095: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   4098: aconst_null
      //   4099: aload 35
      //   4101: invokeinterface 141 14 0
      //   4106: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   4109: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   4112: istore_2
      //   4113: iload_2
      //   4114: iconst_m1
      //   4115: if_icmpne +24 -> 4139
      //   4118: ldc 185
      //   4120: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4123: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   4126: ldc2_w 186
      //   4129: ldc2_w 366
      //   4132: lconst_1
      //   4133: iconst_0
      //   4134: invokeinterface 191 8 0
      //   4139: ldc 73
      //   4141: ldc_w 369
      //   4144: iconst_1
      //   4145: anewarray 4	java/lang/Object
      //   4148: dup
      //   4149: iconst_0
      //   4150: iload_2
      //   4151: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   4154: aastore
      //   4155: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4158: goto -183 -> 3975
      //   4161: astore 25
      //   4163: ldc 73
      //   4165: aload 25
      //   4167: ldc_w 498
      //   4170: iconst_2
      //   4171: anewarray 4	java/lang/Object
      //   4174: dup
      //   4175: iconst_0
      //   4176: aload 33
      //   4178: aastore
      //   4179: dup
      //   4180: iconst_1
      //   4181: aload 34
      //   4183: aastore
      //   4184: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4187: goto -197 -> 3990
      //   4190: astore 25
      //   4192: ldc 73
      //   4194: aload 25
      //   4196: ldc_w 500
      //   4199: iconst_2
      //   4200: anewarray 4	java/lang/Object
      //   4203: dup
      //   4204: iconst_0
      //   4205: aload 33
      //   4207: aastore
      //   4208: dup
      //   4209: iconst_1
      //   4210: aload 34
      //   4212: aastore
      //   4213: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4216: goto -216 -> 4000
      //   4219: astore 25
      //   4221: ldc 73
      //   4223: aload 25
      //   4225: ldc_w 599
      //   4228: iconst_2
      //   4229: anewarray 4	java/lang/Object
      //   4232: dup
      //   4233: iconst_0
      //   4234: aload 33
      //   4236: aastore
      //   4237: dup
      //   4238: iconst_1
      //   4239: aload 34
      //   4241: aastore
      //   4242: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4245: goto -245 -> 4000
      //   4248: astore 25
      //   4250: ldc 73
      //   4252: aload 25
      //   4254: ldc_w 601
      //   4257: iconst_2
      //   4258: anewarray 4	java/lang/Object
      //   4261: dup
      //   4262: iconst_0
      //   4263: aload 33
      //   4265: aastore
      //   4266: dup
      //   4267: iconst_1
      //   4268: aload 34
      //   4270: aastore
      //   4271: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4274: goto -274 -> 4000
      //   4277: astore 25
      //   4279: ldc 73
      //   4281: aload 25
      //   4283: ldc_w 500
      //   4286: iconst_2
      //   4287: anewarray 4	java/lang/Object
      //   4290: dup
      //   4291: iconst_0
      //   4292: aload 33
      //   4294: aastore
      //   4295: dup
      //   4296: iconst_1
      //   4297: aload 34
      //   4299: aastore
      //   4300: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4303: goto -298 -> 4005
      //   4306: astore 25
      //   4308: ldc 73
      //   4310: aload 25
      //   4312: ldc_w 498
      //   4315: iconst_2
      //   4316: anewarray 4	java/lang/Object
      //   4319: dup
      //   4320: iconst_0
      //   4321: aload 33
      //   4323: aastore
      //   4324: dup
      //   4325: iconst_1
      //   4326: aload 34
      //   4328: aastore
      //   4329: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4332: goto -3367 -> 965
      //   4335: astore 25
      //   4337: ldc 73
      //   4339: aload 25
      //   4341: ldc_w 500
      //   4344: iconst_2
      //   4345: anewarray 4	java/lang/Object
      //   4348: dup
      //   4349: iconst_0
      //   4350: aload 33
      //   4352: aastore
      //   4353: dup
      //   4354: iconst_1
      //   4355: aload 34
      //   4357: aastore
      //   4358: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4361: goto -3386 -> 975
      //   4364: astore 25
      //   4366: ldc 73
      //   4368: aload 25
      //   4370: ldc_w 599
      //   4373: iconst_2
      //   4374: anewarray 4	java/lang/Object
      //   4377: dup
      //   4378: iconst_0
      //   4379: aload 33
      //   4381: aastore
      //   4382: dup
      //   4383: iconst_1
      //   4384: aload 34
      //   4386: aastore
      //   4387: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4390: goto -3415 -> 975
      //   4393: astore 25
      //   4395: ldc 73
      //   4397: aload 25
      //   4399: ldc_w 601
      //   4402: iconst_2
      //   4403: anewarray 4	java/lang/Object
      //   4406: dup
      //   4407: iconst_0
      //   4408: aload 33
      //   4410: aastore
      //   4411: dup
      //   4412: iconst_1
      //   4413: aload 34
      //   4415: aastore
      //   4416: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4419: goto -3444 -> 975
      //   4422: astore 25
      //   4424: ldc 73
      //   4426: aload 25
      //   4428: ldc_w 500
      //   4431: iconst_2
      //   4432: anewarray 4	java/lang/Object
      //   4435: dup
      //   4436: iconst_0
      //   4437: aload 33
      //   4439: aastore
      //   4440: dup
      //   4441: iconst_1
      //   4442: aload 34
      //   4444: aastore
      //   4445: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4448: goto -3463 -> 985
      //   4451: astore 25
      //   4453: ldc 73
      //   4455: aload 25
      //   4457: ldc_w 498
      //   4460: iconst_2
      //   4461: anewarray 4	java/lang/Object
      //   4464: dup
      //   4465: iconst_0
      //   4466: aload 33
      //   4468: aastore
      //   4469: dup
      //   4470: iconst_1
      //   4471: aload 34
      //   4473: aastore
      //   4474: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4477: goto -3174 -> 1303
      //   4480: astore 25
      //   4482: ldc 73
      //   4484: aload 25
      //   4486: ldc_w 500
      //   4489: iconst_2
      //   4490: anewarray 4	java/lang/Object
      //   4493: dup
      //   4494: iconst_0
      //   4495: aload 33
      //   4497: aastore
      //   4498: dup
      //   4499: iconst_1
      //   4500: aload 34
      //   4502: aastore
      //   4503: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4506: goto -3193 -> 1313
      //   4509: astore 25
      //   4511: ldc 73
      //   4513: aload 25
      //   4515: ldc_w 599
      //   4518: iconst_2
      //   4519: anewarray 4	java/lang/Object
      //   4522: dup
      //   4523: iconst_0
      //   4524: aload 33
      //   4526: aastore
      //   4527: dup
      //   4528: iconst_1
      //   4529: aload 34
      //   4531: aastore
      //   4532: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4535: goto -3222 -> 1313
      //   4538: astore 25
      //   4540: ldc 73
      //   4542: aload 25
      //   4544: ldc_w 601
      //   4547: iconst_2
      //   4548: anewarray 4	java/lang/Object
      //   4551: dup
      //   4552: iconst_0
      //   4553: aload 33
      //   4555: aastore
      //   4556: dup
      //   4557: iconst_1
      //   4558: aload 34
      //   4560: aastore
      //   4561: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4564: goto -3251 -> 1313
      //   4567: astore 25
      //   4569: ldc 73
      //   4571: aload 25
      //   4573: ldc_w 500
      //   4576: iconst_2
      //   4577: anewarray 4	java/lang/Object
      //   4580: dup
      //   4581: iconst_0
      //   4582: aload 33
      //   4584: aastore
      //   4585: dup
      //   4586: iconst_1
      //   4587: aload 34
      //   4589: aastore
      //   4590: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4593: goto -3270 -> 1323
      //   4596: astore 25
      //   4598: ldc 73
      //   4600: aload 25
      //   4602: ldc_w 498
      //   4605: iconst_2
      //   4606: anewarray 4	java/lang/Object
      //   4609: dup
      //   4610: iconst_0
      //   4611: aload 33
      //   4613: aastore
      //   4614: dup
      //   4615: iconst_1
      //   4616: aload 34
      //   4618: aastore
      //   4619: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4622: goto -2772 -> 1850
      //   4625: astore 25
      //   4627: ldc 73
      //   4629: aload 25
      //   4631: ldc_w 500
      //   4634: iconst_2
      //   4635: anewarray 4	java/lang/Object
      //   4638: dup
      //   4639: iconst_0
      //   4640: aload 33
      //   4642: aastore
      //   4643: dup
      //   4644: iconst_1
      //   4645: aload 34
      //   4647: aastore
      //   4648: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4651: goto -2791 -> 1860
      //   4654: astore 25
      //   4656: ldc 73
      //   4658: aload 25
      //   4660: ldc_w 599
      //   4663: iconst_2
      //   4664: anewarray 4	java/lang/Object
      //   4667: dup
      //   4668: iconst_0
      //   4669: aload 33
      //   4671: aastore
      //   4672: dup
      //   4673: iconst_1
      //   4674: aload 34
      //   4676: aastore
      //   4677: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4680: goto -2820 -> 1860
      //   4683: astore 25
      //   4685: ldc 73
      //   4687: aload 25
      //   4689: ldc_w 601
      //   4692: iconst_2
      //   4693: anewarray 4	java/lang/Object
      //   4696: dup
      //   4697: iconst_0
      //   4698: aload 33
      //   4700: aastore
      //   4701: dup
      //   4702: iconst_1
      //   4703: aload 34
      //   4705: aastore
      //   4706: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4709: goto -2849 -> 1860
      //   4712: astore 25
      //   4714: ldc 73
      //   4716: aload 25
      //   4718: ldc_w 500
      //   4721: iconst_2
      //   4722: anewarray 4	java/lang/Object
      //   4725: dup
      //   4726: iconst_0
      //   4727: aload 33
      //   4729: aastore
      //   4730: dup
      //   4731: iconst_1
      //   4732: aload 34
      //   4734: aastore
      //   4735: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4738: goto -2868 -> 1870
      //   4741: astore 28
      //   4743: aconst_null
      //   4744: astore 32
      //   4746: aconst_null
      //   4747: astore 26
      //   4749: aconst_null
      //   4750: astore 30
      //   4752: aconst_null
      //   4753: astore 31
      //   4755: iconst_0
      //   4756: istore_2
      //   4757: iload 11
      //   4759: istore 5
      //   4761: iload_2
      //   4762: istore 4
      //   4764: aload 32
      //   4766: astore 29
      //   4768: aload 26
      //   4770: astore 27
      //   4772: aload 30
      //   4774: astore 25
      //   4776: iload 5
      //   4778: istore_3
      //   4779: lload 21
      //   4781: lstore 23
      //   4783: ldc 185
      //   4785: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4788: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   4791: ldc2_w 186
      //   4794: ldc2_w 602
      //   4797: lconst_1
      //   4798: iconst_0
      //   4799: invokeinterface 191 8 0
      //   4804: iload_2
      //   4805: istore 4
      //   4807: aload 32
      //   4809: astore 29
      //   4811: aload 26
      //   4813: astore 27
      //   4815: aload 30
      //   4817: astore 25
      //   4819: iload 5
      //   4821: istore_3
      //   4822: lload 21
      //   4824: lstore 23
      //   4826: ldc 73
      //   4828: aload 28
      //   4830: ldc_w 605
      //   4833: iconst_2
      //   4834: anewarray 4	java/lang/Object
      //   4837: dup
      //   4838: iconst_0
      //   4839: aload 33
      //   4841: aastore
      //   4842: dup
      //   4843: iconst_1
      //   4844: aload 34
      //   4846: aastore
      //   4847: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4850: iload_2
      //   4851: istore 4
      //   4853: aload 32
      //   4855: astore 29
      //   4857: aload 26
      //   4859: astore 27
      //   4861: aload 30
      //   4863: astore 25
      //   4865: iload 5
      //   4867: istore_3
      //   4868: lload 21
      //   4870: lstore 23
      //   4872: aload_0
      //   4873: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   4876: aload 36
      //   4878: iconst_m1
      //   4879: ldc_w 607
      //   4882: iload_2
      //   4883: aload_1
      //   4884: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   4887: aload 31
      //   4889: invokestatic 353	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   4892: ldc 113
      //   4894: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4897: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   4900: aload_0
      //   4901: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   4904: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   4907: invokeinterface 129 1 0
      //   4912: aload_1
      //   4913: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   4916: ldc 134
      //   4918: aload_1
      //   4919: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   4922: lload 21
      //   4924: iload 5
      //   4926: i2l
      //   4927: iload_2
      //   4928: iconst_2
      //   4929: aload_1
      //   4930: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   4933: aconst_null
      //   4934: aload 35
      //   4936: invokeinterface 141 14 0
      //   4941: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   4944: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   4947: istore_2
      //   4948: iload_2
      //   4949: iconst_m1
      //   4950: if_icmpne +24 -> 4974
      //   4953: ldc 185
      //   4955: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   4958: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   4961: ldc2_w 186
      //   4964: ldc2_w 366
      //   4967: lconst_1
      //   4968: iconst_0
      //   4969: invokeinterface 191 8 0
      //   4974: ldc 73
      //   4976: ldc_w 369
      //   4979: iconst_1
      //   4980: anewarray 4	java/lang/Object
      //   4983: dup
      //   4984: iconst_0
      //   4985: iload_2
      //   4986: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   4989: aastore
      //   4990: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   4993: aload_1
      //   4994: iconst_0
      //   4995: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   4998: aload 32
      //   5000: ifnull +8 -> 5008
      //   5003: aload 32
      //   5005: invokevirtual 379	java/io/InputStream:close	()V
      //   5008: aload 26
      //   5010: ifnull +8 -> 5018
      //   5013: aload 26
      //   5015: invokevirtual 379	java/io/InputStream:close	()V
      //   5018: aload 30
      //   5020: ifnull +8 -> 5028
      //   5023: aload 30
      //   5025: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   5028: aload_0
      //   5029: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   5032: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   5035: aload_1
      //   5036: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   5039: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   5042: pop
      //   5043: ldc 41
      //   5045: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   5048: return
      //   5049: astore 25
      //   5051: ldc 73
      //   5053: aload 25
      //   5055: ldc_w 498
      //   5058: iconst_2
      //   5059: anewarray 4	java/lang/Object
      //   5062: dup
      //   5063: iconst_0
      //   5064: aload 33
      //   5066: aastore
      //   5067: dup
      //   5068: iconst_1
      //   5069: aload 34
      //   5071: aastore
      //   5072: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5075: goto -67 -> 5008
      //   5078: astore 25
      //   5080: ldc 73
      //   5082: aload 25
      //   5084: ldc_w 500
      //   5087: iconst_2
      //   5088: anewarray 4	java/lang/Object
      //   5091: dup
      //   5092: iconst_0
      //   5093: aload 33
      //   5095: aastore
      //   5096: dup
      //   5097: iconst_1
      //   5098: aload 34
      //   5100: aastore
      //   5101: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5104: goto -86 -> 5018
      //   5107: astore 25
      //   5109: ldc 73
      //   5111: aload 25
      //   5113: ldc_w 599
      //   5116: iconst_2
      //   5117: anewarray 4	java/lang/Object
      //   5120: dup
      //   5121: iconst_0
      //   5122: aload 33
      //   5124: aastore
      //   5125: dup
      //   5126: iconst_1
      //   5127: aload 34
      //   5129: aastore
      //   5130: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5133: goto -115 -> 5018
      //   5136: astore 25
      //   5138: ldc 73
      //   5140: aload 25
      //   5142: ldc_w 601
      //   5145: iconst_2
      //   5146: anewarray 4	java/lang/Object
      //   5149: dup
      //   5150: iconst_0
      //   5151: aload 33
      //   5153: aastore
      //   5154: dup
      //   5155: iconst_1
      //   5156: aload 34
      //   5158: aastore
      //   5159: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5162: goto -144 -> 5018
      //   5165: astore 25
      //   5167: ldc 73
      //   5169: aload 25
      //   5171: ldc_w 500
      //   5174: iconst_2
      //   5175: anewarray 4	java/lang/Object
      //   5178: dup
      //   5179: iconst_0
      //   5180: aload 33
      //   5182: aastore
      //   5183: dup
      //   5184: iconst_1
      //   5185: aload 34
      //   5187: aastore
      //   5188: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5191: goto -163 -> 5028
      //   5194: astore 28
      //   5196: aconst_null
      //   5197: astore 32
      //   5199: aconst_null
      //   5200: astore 26
      //   5202: aconst_null
      //   5203: astore 30
      //   5205: aconst_null
      //   5206: astore 31
      //   5208: iconst_0
      //   5209: istore_2
      //   5210: iload 12
      //   5212: istore 5
      //   5214: iload_2
      //   5215: istore 4
      //   5217: aload 32
      //   5219: astore 29
      //   5221: aload 26
      //   5223: astore 27
      //   5225: aload 30
      //   5227: astore 25
      //   5229: iload 5
      //   5231: istore_3
      //   5232: lload 21
      //   5234: lstore 23
      //   5236: ldc 185
      //   5238: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   5241: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   5244: ldc2_w 186
      //   5247: ldc2_w 608
      //   5250: lconst_1
      //   5251: iconst_0
      //   5252: invokeinterface 191 8 0
      //   5257: iload_2
      //   5258: istore 4
      //   5260: aload 32
      //   5262: astore 29
      //   5264: aload 26
      //   5266: astore 27
      //   5268: aload 30
      //   5270: astore 25
      //   5272: iload 5
      //   5274: istore_3
      //   5275: lload 21
      //   5277: lstore 23
      //   5279: ldc 73
      //   5281: aload 28
      //   5283: ldc_w 498
      //   5286: iconst_2
      //   5287: anewarray 4	java/lang/Object
      //   5290: dup
      //   5291: iconst_0
      //   5292: aload 33
      //   5294: aastore
      //   5295: dup
      //   5296: iconst_1
      //   5297: aload 34
      //   5299: aastore
      //   5300: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5303: iload_2
      //   5304: istore 4
      //   5306: aload 32
      //   5308: astore 29
      //   5310: aload 26
      //   5312: astore 27
      //   5314: aload 30
      //   5316: astore 25
      //   5318: iload 5
      //   5320: istore_3
      //   5321: lload 21
      //   5323: lstore 23
      //   5325: aload_0
      //   5326: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   5329: aload 36
      //   5331: iconst_m1
      //   5332: new 404	java/lang/StringBuilder
      //   5335: dup
      //   5336: invokespecial 405	java/lang/StringBuilder:<init>	()V
      //   5339: aload 28
      //   5341: invokevirtual 612	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   5344: invokevirtual 431	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   5347: invokevirtual 435	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   5350: iload_2
      //   5351: aload_1
      //   5352: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   5355: aload 31
      //   5357: invokestatic 353	com/tencent/mm/plugin/appbrand/q/g:a	(Lcom/tencent/mm/plugin/appbrand/q/g;Lcom/tencent/mm/plugin/appbrand/q/g$a;ILjava/lang/String;ILjava/lang/String;Ljava/net/HttpURLConnection;)V
      //   5360: ldc 113
      //   5362: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   5365: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   5368: aload_0
      //   5369: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   5372: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   5375: invokeinterface 129 1 0
      //   5380: aload_1
      //   5381: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   5384: ldc 134
      //   5386: aload_1
      //   5387: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   5390: lload 21
      //   5392: iload 5
      //   5394: i2l
      //   5395: iload_2
      //   5396: iconst_2
      //   5397: aload_1
      //   5398: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   5401: aconst_null
      //   5402: aload 35
      //   5404: invokeinterface 141 14 0
      //   5409: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   5412: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   5415: istore_2
      //   5416: iload_2
      //   5417: iconst_m1
      //   5418: if_icmpne +24 -> 5442
      //   5421: ldc 185
      //   5423: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   5426: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   5429: ldc2_w 186
      //   5432: ldc2_w 366
      //   5435: lconst_1
      //   5436: iconst_0
      //   5437: invokeinterface 191 8 0
      //   5442: ldc 73
      //   5444: ldc_w 369
      //   5447: iconst_1
      //   5448: anewarray 4	java/lang/Object
      //   5451: dup
      //   5452: iconst_0
      //   5453: iload_2
      //   5454: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   5457: aastore
      //   5458: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5461: aload_1
      //   5462: iconst_0
      //   5463: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   5466: aload 32
      //   5468: ifnull +8 -> 5476
      //   5471: aload 32
      //   5473: invokevirtual 379	java/io/InputStream:close	()V
      //   5476: aload 26
      //   5478: ifnull +8 -> 5486
      //   5481: aload 26
      //   5483: invokevirtual 379	java/io/InputStream:close	()V
      //   5486: aload 30
      //   5488: ifnull +8 -> 5496
      //   5491: aload 30
      //   5493: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   5496: aload_0
      //   5497: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   5500: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   5503: aload_1
      //   5504: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   5507: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   5510: pop
      //   5511: ldc 41
      //   5513: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   5516: return
      //   5517: astore 25
      //   5519: ldc 73
      //   5521: aload 25
      //   5523: ldc_w 498
      //   5526: iconst_2
      //   5527: anewarray 4	java/lang/Object
      //   5530: dup
      //   5531: iconst_0
      //   5532: aload 33
      //   5534: aastore
      //   5535: dup
      //   5536: iconst_1
      //   5537: aload 34
      //   5539: aastore
      //   5540: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5543: goto -67 -> 5476
      //   5546: astore 25
      //   5548: ldc 73
      //   5550: aload 25
      //   5552: ldc_w 500
      //   5555: iconst_2
      //   5556: anewarray 4	java/lang/Object
      //   5559: dup
      //   5560: iconst_0
      //   5561: aload 33
      //   5563: aastore
      //   5564: dup
      //   5565: iconst_1
      //   5566: aload 34
      //   5568: aastore
      //   5569: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5572: goto -86 -> 5486
      //   5575: astore 25
      //   5577: ldc 73
      //   5579: aload 25
      //   5581: ldc_w 599
      //   5584: iconst_2
      //   5585: anewarray 4	java/lang/Object
      //   5588: dup
      //   5589: iconst_0
      //   5590: aload 33
      //   5592: aastore
      //   5593: dup
      //   5594: iconst_1
      //   5595: aload 34
      //   5597: aastore
      //   5598: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5601: goto -115 -> 5486
      //   5604: astore 25
      //   5606: ldc 73
      //   5608: aload 25
      //   5610: ldc_w 601
      //   5613: iconst_2
      //   5614: anewarray 4	java/lang/Object
      //   5617: dup
      //   5618: iconst_0
      //   5619: aload 33
      //   5621: aastore
      //   5622: dup
      //   5623: iconst_1
      //   5624: aload 34
      //   5626: aastore
      //   5627: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5630: goto -144 -> 5486
      //   5633: astore 25
      //   5635: ldc 73
      //   5637: aload 25
      //   5639: ldc_w 500
      //   5642: iconst_2
      //   5643: anewarray 4	java/lang/Object
      //   5646: dup
      //   5647: iconst_0
      //   5648: aload 33
      //   5650: aastore
      //   5651: dup
      //   5652: iconst_1
      //   5653: aload 34
      //   5655: aastore
      //   5656: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5659: goto -163 -> 5496
      //   5662: astore 28
      //   5664: aconst_null
      //   5665: astore 29
      //   5667: aconst_null
      //   5668: astore 26
      //   5670: aconst_null
      //   5671: astore 25
      //   5673: lconst_0
      //   5674: lstore 21
      //   5676: iconst_0
      //   5677: istore_2
      //   5678: iload 13
      //   5680: istore_3
      //   5681: ldc 113
      //   5683: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   5686: checkcast 113	com/tencent/mm/plugin/appbrand/q/o
      //   5689: aload_0
      //   5690: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   5693: getfield 123	com/tencent/mm/plugin/appbrand/q/g:joJ	Lcom/tencent/mm/plugin/appbrand/jsapi/c;
      //   5696: invokeinterface 129 1 0
      //   5701: aload_1
      //   5702: getfield 132	com/tencent/mm/plugin/appbrand/q/h:kVj	Ljava/lang/String;
      //   5705: ldc 134
      //   5707: aload_1
      //   5708: getfield 53	com/tencent/mm/plugin/appbrand/q/h:mUrl	Ljava/lang/String;
      //   5711: lload 21
      //   5713: iload_3
      //   5714: i2l
      //   5715: iload_2
      //   5716: iconst_2
      //   5717: aload_1
      //   5718: invokevirtual 138	com/tencent/mm/plugin/appbrand/q/h:bio	()I
      //   5721: aconst_null
      //   5722: aload 35
      //   5724: invokeinterface 141 14 0
      //   5729: invokestatic 359	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
      //   5732: invokestatic 365	com/tencent/mm/sdk/platformtools/ay:getNetType	(Landroid/content/Context;)I
      //   5735: istore_2
      //   5736: iload_2
      //   5737: iconst_m1
      //   5738: if_icmpne +24 -> 5762
      //   5741: ldc 185
      //   5743: invokestatic 119	com/tencent/luggage/a/e:L	(Ljava/lang/Class;)Lcom/tencent/luggage/a/d;
      //   5746: checkcast 185	com/tencent/mm/plugin/appbrand/u/a
      //   5749: ldc2_w 186
      //   5752: ldc2_w 366
      //   5755: lconst_1
      //   5756: iconst_0
      //   5757: invokeinterface 191 8 0
      //   5762: ldc 73
      //   5764: ldc_w 369
      //   5767: iconst_1
      //   5768: anewarray 4	java/lang/Object
      //   5771: dup
      //   5772: iconst_0
      //   5773: iload_2
      //   5774: invokestatic 374	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   5777: aastore
      //   5778: invokestatic 145	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5781: aload_1
      //   5782: iconst_0
      //   5783: putfield 152	com/tencent/mm/plugin/appbrand/q/h:isRunning	Z
      //   5786: aload 29
      //   5788: ifnull +8 -> 5796
      //   5791: aload 29
      //   5793: invokevirtual 379	java/io/InputStream:close	()V
      //   5796: aload 26
      //   5798: ifnull +8 -> 5806
      //   5801: aload 26
      //   5803: invokevirtual 379	java/io/InputStream:close	()V
      //   5806: aload 25
      //   5808: ifnull +8 -> 5816
      //   5811: aload 25
      //   5813: invokevirtual 382	java/io/DataOutputStream:close	()V
      //   5816: aload_0
      //   5817: getfield 17	com/tencent/mm/plugin/appbrand/q/g$b:kVr	Lcom/tencent/mm/plugin/appbrand/q/g;
      //   5820: getfield 385	com/tencent/mm/plugin/appbrand/q/g:kUD	Ljava/util/ArrayList;
      //   5823: aload_1
      //   5824: getfield 107	com/tencent/mm/plugin/appbrand/q/h:hLO	Ljava/lang/String;
      //   5827: invokevirtual 391	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
      //   5830: pop
      //   5831: ldc 41
      //   5833: invokestatic 148	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   5836: aload 28
      //   5838: athrow
      //   5839: astore 27
      //   5841: ldc 73
      //   5843: aload 27
      //   5845: ldc_w 498
      //   5848: iconst_2
      //   5849: anewarray 4	java/lang/Object
      //   5852: dup
      //   5853: iconst_0
      //   5854: aload 33
      //   5856: aastore
      //   5857: dup
      //   5858: iconst_1
      //   5859: aload 34
      //   5861: aastore
      //   5862: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5865: goto -69 -> 5796
      //   5868: astore 26
      //   5870: ldc 73
      //   5872: aload 26
      //   5874: ldc_w 500
      //   5877: iconst_2
      //   5878: anewarray 4	java/lang/Object
      //   5881: dup
      //   5882: iconst_0
      //   5883: aload 33
      //   5885: aastore
      //   5886: dup
      //   5887: iconst_1
      //   5888: aload 34
      //   5890: aastore
      //   5891: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5894: goto -88 -> 5806
      //   5897: astore 26
      //   5899: ldc 73
      //   5901: aload 26
      //   5903: ldc_w 599
      //   5906: iconst_2
      //   5907: anewarray 4	java/lang/Object
      //   5910: dup
      //   5911: iconst_0
      //   5912: aload 33
      //   5914: aastore
      //   5915: dup
      //   5916: iconst_1
      //   5917: aload 34
      //   5919: aastore
      //   5920: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5923: goto -117 -> 5806
      //   5926: astore 26
      //   5928: ldc 73
      //   5930: aload 26
      //   5932: ldc_w 601
      //   5935: iconst_2
      //   5936: anewarray 4	java/lang/Object
      //   5939: dup
      //   5940: iconst_0
      //   5941: aload 33
      //   5943: aastore
      //   5944: dup
      //   5945: iconst_1
      //   5946: aload 34
      //   5948: aastore
      //   5949: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5952: goto -146 -> 5806
      //   5955: astore 25
      //   5957: ldc 73
      //   5959: aload 25
      //   5961: ldc_w 500
      //   5964: iconst_2
      //   5965: anewarray 4	java/lang/Object
      //   5968: dup
      //   5969: iconst_0
      //   5970: aload 33
      //   5972: aastore
      //   5973: dup
      //   5974: iconst_1
      //   5975: aload 34
      //   5977: aastore
      //   5978: invokestatic 348	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   5981: goto -165 -> 5816
      //   5984: astore 28
      //   5986: aconst_null
      //   5987: astore 26
      //   5989: aconst_null
      //   5990: astore 27
      //   5992: lconst_0
      //   5993: lstore 21
      //   5995: iconst_0
      //   5996: istore_2
      //   5997: aload 25
      //   5999: astore 29
      //   6001: aload 27
      //   6003: astore 25
      //   6005: iload 13
      //   6007: istore_3
      //   6008: goto -327 -> 5681
      //   6011: astore 28
      //   6013: aconst_null
      //   6014: astore 26
      //   6016: lconst_0
      //   6017: lstore 21
      //   6019: iconst_0
      //   6020: istore_2
      //   6021: aload 25
      //   6023: astore 29
      //   6025: aload 27
      //   6027: astore 25
      //   6029: iload 13
      //   6031: istore_3
      //   6032: goto -351 -> 5681
      //   6035: astore 28
      //   6037: aconst_null
      //   6038: astore 26
      //   6040: iload_3
      //   6041: istore_2
      //   6042: aload 25
      //   6044: astore 29
      //   6046: aload 27
      //   6048: astore 25
      //   6050: iload 13
      //   6052: istore_3
      //   6053: goto -372 -> 5681
      //   6056: astore 28
      //   6058: aconst_null
      //   6059: astore 26
      //   6061: iconst_0
      //   6062: istore_2
      //   6063: aload 25
      //   6065: astore 29
      //   6067: aload 27
      //   6069: astore 25
      //   6071: iload 13
      //   6073: istore_3
      //   6074: goto -393 -> 5681
      //   6077: astore 28
      //   6079: aload 25
      //   6081: astore 29
      //   6083: aload 27
      //   6085: astore 25
      //   6087: iload 13
      //   6089: istore_3
      //   6090: goto -409 -> 5681
      //   6093: astore 28
      //   6095: aload 25
      //   6097: astore 29
      //   6099: aload 27
      //   6101: astore 25
      //   6103: goto -422 -> 5681
      //   6106: astore 28
      //   6108: aload 25
      //   6110: astore 29
      //   6112: aload 27
      //   6114: astore 25
      //   6116: goto -435 -> 5681
      //   6119: astore 28
      //   6121: aload 25
      //   6123: astore 29
      //   6125: aload 27
      //   6127: astore 25
      //   6129: goto -448 -> 5681
      //   6132: astore 28
      //   6134: lload 23
      //   6136: lstore 21
      //   6138: iload 4
      //   6140: istore_2
      //   6141: aload 27
      //   6143: astore 26
      //   6145: goto -464 -> 5681
      //   6148: astore 28
      //   6150: aconst_null
      //   6151: astore 26
      //   6153: aconst_null
      //   6154: astore 30
      //   6156: aconst_null
      //   6157: astore 31
      //   6159: iconst_0
      //   6160: istore_2
      //   6161: aload 25
      //   6163: astore 32
      //   6165: iload 12
      //   6167: istore 5
      //   6169: goto -955 -> 5214
      //   6172: astore 28
      //   6174: aconst_null
      //   6175: astore 26
      //   6177: aconst_null
      //   6178: astore 30
      //   6180: iconst_0
      //   6181: istore_2
      //   6182: aload 29
      //   6184: astore 31
      //   6186: aload 25
      //   6188: astore 32
      //   6190: iload 12
      //   6192: istore 5
      //   6194: goto -980 -> 5214
      //   6197: astore 28
      //   6199: aconst_null
      //   6200: astore 26
      //   6202: iconst_0
      //   6203: istore_2
      //   6204: aload 29
      //   6206: astore 31
      //   6208: aload 25
      //   6210: astore 32
      //   6212: aload 27
      //   6214: astore 30
      //   6216: iload 12
      //   6218: istore 5
      //   6220: goto -1006 -> 5214
      //   6223: astore 28
      //   6225: aconst_null
      //   6226: astore 26
      //   6228: iload 4
      //   6230: istore_2
      //   6231: aload 29
      //   6233: astore 31
      //   6235: aload 25
      //   6237: astore 32
      //   6239: aload 27
      //   6241: astore 30
      //   6243: iload 12
      //   6245: istore 5
      //   6247: goto -1033 -> 5214
      //   6250: astore 28
      //   6252: aconst_null
      //   6253: astore 26
      //   6255: iconst_0
      //   6256: istore_2
      //   6257: aload 29
      //   6259: astore 31
      //   6261: aload 25
      //   6263: astore 32
      //   6265: aload 27
      //   6267: astore 30
      //   6269: iload 12
      //   6271: istore 5
      //   6273: goto -1059 -> 5214
      //   6276: astore 28
      //   6278: aload 29
      //   6280: astore 31
      //   6282: aload 25
      //   6284: astore 32
      //   6286: aload 27
      //   6288: astore 30
      //   6290: iload 12
      //   6292: istore 5
      //   6294: goto -1080 -> 5214
      //   6297: astore 28
      //   6299: aload 29
      //   6301: astore 31
      //   6303: aload 25
      //   6305: astore 32
      //   6307: aload 27
      //   6309: astore 30
      //   6311: iload_3
      //   6312: istore 5
      //   6314: goto -1100 -> 5214
      //   6317: astore 28
      //   6319: aload 29
      //   6321: astore 31
      //   6323: aload 25
      //   6325: astore 32
      //   6327: aload 27
      //   6329: astore 30
      //   6331: iload_3
      //   6332: istore 5
      //   6334: goto -1120 -> 5214
      //   6337: astore 28
      //   6339: aconst_null
      //   6340: astore 26
      //   6342: aconst_null
      //   6343: astore 30
      //   6345: aconst_null
      //   6346: astore 31
      //   6348: iconst_0
      //   6349: istore_2
      //   6350: aload 25
      //   6352: astore 32
      //   6354: iload 11
      //   6356: istore 5
      //   6358: goto -1597 -> 4761
      //   6361: astore 28
      //   6363: aconst_null
      //   6364: astore 26
      //   6366: aconst_null
      //   6367: astore 30
      //   6369: iconst_0
      //   6370: istore_2
      //   6371: aload 29
      //   6373: astore 31
      //   6375: aload 25
      //   6377: astore 32
      //   6379: iload 11
      //   6381: istore 5
      //   6383: goto -1622 -> 4761
      //   6386: astore 28
      //   6388: aconst_null
      //   6389: astore 26
      //   6391: iconst_0
      //   6392: istore_2
      //   6393: aload 29
      //   6395: astore 31
      //   6397: aload 25
      //   6399: astore 32
      //   6401: aload 27
      //   6403: astore 30
      //   6405: iload 11
      //   6407: istore 5
      //   6409: goto -1648 -> 4761
      //   6412: astore 28
      //   6414: aconst_null
      //   6415: astore 26
      //   6417: iload 5
      //   6419: istore_2
      //   6420: aload 29
      //   6422: astore 31
      //   6424: aload 25
      //   6426: astore 32
      //   6428: aload 27
      //   6430: astore 30
      //   6432: iload 11
      //   6434: istore 5
      //   6436: goto -1675 -> 4761
      //   6439: astore 28
      //   6441: aconst_null
      //   6442: astore 26
      //   6444: iconst_0
      //   6445: istore_2
      //   6446: aload 29
      //   6448: astore 31
      //   6450: aload 25
      //   6452: astore 32
      //   6454: aload 27
      //   6456: astore 30
      //   6458: iload 11
      //   6460: istore 5
      //   6462: goto -1701 -> 4761
      //   6465: astore 28
      //   6467: aload 29
      //   6469: astore 31
      //   6471: aload 25
      //   6473: astore 32
      //   6475: aload 27
      //   6477: astore 30
      //   6479: iload 11
      //   6481: istore 5
      //   6483: goto -1722 -> 4761
      //   6486: astore 28
      //   6488: aload 29
      //   6490: astore 31
      //   6492: aload 25
      //   6494: astore 32
      //   6496: aload 27
      //   6498: astore 30
      //   6500: iload_3
      //   6501: istore 5
      //   6503: goto -1742 -> 4761
      //   6506: astore 28
      //   6508: aload 29
      //   6510: astore 31
      //   6512: aload 25
      //   6514: astore 32
      //   6516: aload 27
      //   6518: astore 30
      //   6520: iload_3
      //   6521: istore 5
      //   6523: goto -1762 -> 4761
      //   6526: astore 28
      //   6528: aconst_null
      //   6529: astore 32
      //   6531: aconst_null
      //   6532: astore 26
      //   6534: aconst_null
      //   6535: astore 30
      //   6537: aconst_null
      //   6538: astore 31
      //   6540: iconst_0
      //   6541: istore_2
      //   6542: iload 10
      //   6544: istore 5
      //   6546: goto -4943 -> 1603
      //   6549: astore 28
      //   6551: aconst_null
      //   6552: astore 26
      //   6554: aconst_null
      //   6555: astore 30
      //   6557: aconst_null
      //   6558: astore 31
      //   6560: iconst_0
      //   6561: istore_2
      //   6562: aload 25
      //   6564: astore 32
      //   6566: iload 10
      //   6568: istore 5
      //   6570: goto -4967 -> 1603
      //   6573: astore 28
      //   6575: aconst_null
      //   6576: astore 26
      //   6578: iconst_0
      //   6579: istore_2
      //   6580: aload 29
      //   6582: astore 31
      //   6584: aload 25
      //   6586: astore 32
      //   6588: aload 27
      //   6590: astore 30
      //   6592: iload 10
      //   6594: istore 5
      //   6596: goto -4993 -> 1603
      //   6599: astore 28
      //   6601: aconst_null
      //   6602: astore 26
      //   6604: iload 6
      //   6606: istore_2
      //   6607: aload 29
      //   6609: astore 31
      //   6611: aload 25
      //   6613: astore 32
      //   6615: aload 27
      //   6617: astore 30
      //   6619: iload 10
      //   6621: istore 5
      //   6623: goto -5020 -> 1603
      //   6626: astore 28
      //   6628: aconst_null
      //   6629: astore 26
      //   6631: iconst_0
      //   6632: istore_2
      //   6633: aload 29
      //   6635: astore 31
      //   6637: aload 25
      //   6639: astore 32
      //   6641: aload 27
      //   6643: astore 30
      //   6645: iload 10
      //   6647: istore 5
      //   6649: goto -5046 -> 1603
      //   6652: astore 28
      //   6654: aload 29
      //   6656: astore 31
      //   6658: aload 25
      //   6660: astore 32
      //   6662: aload 27
      //   6664: astore 30
      //   6666: iload 10
      //   6668: istore 5
      //   6670: goto -5067 -> 1603
      //   6673: astore 28
      //   6675: aload 29
      //   6677: astore 31
      //   6679: aload 25
      //   6681: astore 32
      //   6683: aload 27
      //   6685: astore 30
      //   6687: iload_3
      //   6688: istore 5
      //   6690: goto -5087 -> 1603
      //   6693: astore 28
      //   6695: aload 29
      //   6697: astore 31
      //   6699: aload 25
      //   6701: astore 32
      //   6703: aload 27
      //   6705: astore 30
      //   6707: iload_3
      //   6708: istore 5
      //   6710: goto -5107 -> 1603
      //   6713: astore 28
      //   6715: aconst_null
      //   6716: astore 32
      //   6718: aconst_null
      //   6719: astore 26
      //   6721: aconst_null
      //   6722: astore 30
      //   6724: aconst_null
      //   6725: astore 31
      //   6727: iconst_0
      //   6728: istore_2
      //   6729: iload 9
      //   6731: istore 5
      //   6733: goto -5677 -> 1056
      //   6736: astore 28
      //   6738: aconst_null
      //   6739: astore 26
      //   6741: aconst_null
      //   6742: astore 30
      //   6744: aconst_null
      //   6745: astore 31
      //   6747: iconst_0
      //   6748: istore_2
      //   6749: aload 25
      //   6751: astore 32
      //   6753: iload 9
      //   6755: istore 5
      //   6757: goto -5701 -> 1056
      //   6760: astore 28
      //   6762: aconst_null
      //   6763: astore 26
      //   6765: iconst_0
      //   6766: istore_2
      //   6767: aload 29
      //   6769: astore 31
      //   6771: aload 25
      //   6773: astore 32
      //   6775: aload 27
      //   6777: astore 30
      //   6779: iload 9
      //   6781: istore 5
      //   6783: goto -5727 -> 1056
      //   6786: astore 28
      //   6788: aconst_null
      //   6789: astore 26
      //   6791: iload 7
      //   6793: istore_2
      //   6794: aload 29
      //   6796: astore 31
      //   6798: aload 25
      //   6800: astore 32
      //   6802: aload 27
      //   6804: astore 30
      //   6806: iload 9
      //   6808: istore 5
      //   6810: goto -5754 -> 1056
      //   6813: astore 28
      //   6815: aconst_null
      //   6816: astore 26
      //   6818: iconst_0
      //   6819: istore_2
      //   6820: aload 29
      //   6822: astore 31
      //   6824: aload 25
      //   6826: astore 32
      //   6828: aload 27
      //   6830: astore 30
      //   6832: iload 9
      //   6834: istore 5
      //   6836: goto -5780 -> 1056
      //   6839: astore 28
      //   6841: aload 29
      //   6843: astore 31
      //   6845: aload 25
      //   6847: astore 32
      //   6849: aload 27
      //   6851: astore 30
      //   6853: iload 9
      //   6855: istore 5
      //   6857: goto -5801 -> 1056
      //   6860: astore 28
      //   6862: aload 29
      //   6864: astore 31
      //   6866: aload 25
      //   6868: astore 32
      //   6870: aload 27
      //   6872: astore 30
      //   6874: iload_3
      //   6875: istore 5
      //   6877: goto -5821 -> 1056
      //   6880: astore 28
      //   6882: aload 29
      //   6884: astore 31
      //   6886: aload 25
      //   6888: astore 32
      //   6890: aload 27
      //   6892: astore 30
      //   6894: iload_3
      //   6895: istore 5
      //   6897: goto -5841 -> 1056
      //   6900: astore 28
      //   6902: aconst_null
      //   6903: astore 25
      //   6905: aconst_null
      //   6906: astore 26
      //   6908: aconst_null
      //   6909: astore 27
      //   6911: aconst_null
      //   6912: astore 29
      //   6914: iconst_0
      //   6915: istore_2
      //   6916: iconst_0
      //   6917: istore_3
      //   6918: goto -6131 -> 787
      //   6921: astore 28
      //   6923: aconst_null
      //   6924: astore 26
      //   6926: aconst_null
      //   6927: astore 27
      //   6929: aconst_null
      //   6930: astore 29
      //   6932: iconst_0
      //   6933: istore_2
      //   6934: iconst_0
      //   6935: istore_3
      //   6936: goto -6149 -> 787
      //   6939: astore 28
      //   6941: aconst_null
      //   6942: astore 26
      //   6944: iconst_0
      //   6945: istore_2
      //   6946: iconst_0
      //   6947: istore_3
      //   6948: goto -6161 -> 787
      //   6951: astore 28
      //   6953: aconst_null
      //   6954: astore 26
      //   6956: iload 8
      //   6958: istore_2
      //   6959: iconst_0
      //   6960: istore_3
      //   6961: goto -6174 -> 787
      //   6964: astore 28
      //   6966: aconst_null
      //   6967: astore 26
      //   6969: iconst_0
      //   6970: istore_2
      //   6971: iconst_0
      //   6972: istore_3
      //   6973: goto -6186 -> 787
      //   6976: astore 28
      //   6978: goto -6191 -> 787
      //   6981: astore 28
      //   6983: goto -6196 -> 787
      //   6986: ldc_w 614
      //   6989: astore 28
      //   6991: iconst_0
      //   6992: istore_3
      //   6993: goto -3122 -> 3871
      //   6996: goto -4794 -> 2202
      //   6999: goto -4898 -> 2101
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	7002	0	this	b
      //   0	7002	1	paramh	h
      //   784	6187	2	i	int
      //   786	6207	3	j	int
      //   1057	5172	4	k	int
      //   1046	5850	5	m	int
      //   2215	4390	6	n	int
      //   2219	4573	7	i1	int
      //   2223	4734	8	i2	int
      //   81	6773	9	i3	int
      //   69	6598	10	i4	int
      //   72	6408	11	i5	int
      //   75	6216	12	i6	int
      //   78	6010	13	i7	int
      //   99	3162	14	i8	int
      //   84	2655	15	i9	int
      //   87	2656	16	i10	int
      //   90	2657	17	i11	int
      //   93	2658	18	i12	int
      //   96	2659	19	i13	int
      //   2232	347	20	i14	int
      //   102	6035	21	l1	long
      //   1076	5059	23	l2	long
      //   428	2029	25	localObject1	Object
      //   2487	5	25	localException1	Exception
      //   2516	563	25	localIOException1	java.io.IOException
      //   3109	5	25	localException2	Exception
      //   3138	258	25	localIOException2	java.io.IOException
      //   3426	5	25	localException3	Exception
      //   3455	531	25	localIOException3	java.io.IOException
      //   4161	5	25	localException4	Exception
      //   4190	5	25	localIOException4	java.io.IOException
      //   4219	5	25	localArrayIndexOutOfBoundsException1	java.lang.ArrayIndexOutOfBoundsException
      //   4248	5	25	localThrowable1	java.lang.Throwable
      //   4277	5	25	localIOException5	java.io.IOException
      //   4306	5	25	localException5	Exception
      //   4335	5	25	localIOException6	java.io.IOException
      //   4364	5	25	localArrayIndexOutOfBoundsException2	java.lang.ArrayIndexOutOfBoundsException
      //   4393	5	25	localThrowable2	java.lang.Throwable
      //   4422	5	25	localIOException7	java.io.IOException
      //   4451	5	25	localException6	Exception
      //   4480	5	25	localIOException8	java.io.IOException
      //   4509	5	25	localArrayIndexOutOfBoundsException3	java.lang.ArrayIndexOutOfBoundsException
      //   4538	5	25	localThrowable3	java.lang.Throwable
      //   4567	5	25	localIOException9	java.io.IOException
      //   4596	5	25	localException7	Exception
      //   4625	5	25	localIOException10	java.io.IOException
      //   4654	5	25	localArrayIndexOutOfBoundsException4	java.lang.ArrayIndexOutOfBoundsException
      //   4683	5	25	localThrowable4	java.lang.Throwable
      //   4712	5	25	localIOException11	java.io.IOException
      //   4774	90	25	localObject2	Object
      //   5049	5	25	localException8	Exception
      //   5078	5	25	localIOException12	java.io.IOException
      //   5107	5	25	localArrayIndexOutOfBoundsException5	java.lang.ArrayIndexOutOfBoundsException
      //   5136	5	25	localThrowable5	java.lang.Throwable
      //   5165	5	25	localIOException13	java.io.IOException
      //   5227	90	25	localObject3	Object
      //   5517	5	25	localException9	Exception
      //   5546	5	25	localIOException14	java.io.IOException
      //   5575	5	25	localArrayIndexOutOfBoundsException6	java.lang.ArrayIndexOutOfBoundsException
      //   5604	5	25	localThrowable6	java.lang.Throwable
      //   5633	5	25	localIOException15	java.io.IOException
      //   5671	141	25	localObject4	Object
      //   5955	43	25	localIOException16	java.io.IOException
      //   6003	901	25	localObject5	Object
      //   21	3734	26	localObject6	Object
      //   3759	1	26	localException10	Exception
      //   3793	2009	26	localInputStream	InputStream
      //   5868	5	26	localIOException17	java.io.IOException
      //   5897	5	26	localArrayIndexOutOfBoundsException7	java.lang.ArrayIndexOutOfBoundsException
      //   5926	5	26	localThrowable7	java.lang.Throwable
      //   5987	981	26	localObject7	Object
      //   38	5275	27	localObject8	Object
      //   5839	5	27	localException11	Exception
      //   5990	938	27	localObject9	Object
      //   60	1	28	localMap	Map
      //   775	34	28	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
      //   1034	411	28	localFileNotFoundException1	java.io.FileNotFoundException
      //   1581	90	28	localSSLHandshakeException1	javax.net.ssl.SSLHandshakeException
      //   2075	1532	28	localObject10	Object
      //   3636	1	28	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
      //   3667	114	28	localException12	Exception
      //   3827	59	28	str1	String
      //   4741	88	28	localSocketTimeoutException1	java.net.SocketTimeoutException
      //   5194	146	28	localException13	Exception
      //   5662	175	28	localObject11	Object
      //   5984	1	28	localObject12	Object
      //   6011	1	28	localObject13	Object
      //   6035	1	28	localObject14	Object
      //   6056	1	28	localObject15	Object
      //   6077	1	28	localObject16	Object
      //   6093	1	28	localObject17	Object
      //   6106	1	28	localObject18	Object
      //   6119	1	28	localObject19	Object
      //   6132	1	28	localObject20	Object
      //   6148	1	28	localException14	Exception
      //   6172	1	28	localException15	Exception
      //   6197	1	28	localException16	Exception
      //   6223	1	28	localException17	Exception
      //   6250	1	28	localException18	Exception
      //   6276	1	28	localException19	Exception
      //   6297	1	28	localException20	Exception
      //   6317	1	28	localException21	Exception
      //   6337	1	28	localSocketTimeoutException2	java.net.SocketTimeoutException
      //   6361	1	28	localSocketTimeoutException3	java.net.SocketTimeoutException
      //   6386	1	28	localSocketTimeoutException4	java.net.SocketTimeoutException
      //   6412	1	28	localSocketTimeoutException5	java.net.SocketTimeoutException
      //   6439	1	28	localSocketTimeoutException6	java.net.SocketTimeoutException
      //   6465	1	28	localSocketTimeoutException7	java.net.SocketTimeoutException
      //   6486	1	28	localSocketTimeoutException8	java.net.SocketTimeoutException
      //   6506	1	28	localSocketTimeoutException9	java.net.SocketTimeoutException
      //   6526	1	28	localSSLHandshakeException2	javax.net.ssl.SSLHandshakeException
      //   6549	1	28	localSSLHandshakeException3	javax.net.ssl.SSLHandshakeException
      //   6573	1	28	localSSLHandshakeException4	javax.net.ssl.SSLHandshakeException
      //   6599	1	28	localSSLHandshakeException5	javax.net.ssl.SSLHandshakeException
      //   6626	1	28	localSSLHandshakeException6	javax.net.ssl.SSLHandshakeException
      //   6652	1	28	localSSLHandshakeException7	javax.net.ssl.SSLHandshakeException
      //   6673	1	28	localSSLHandshakeException8	javax.net.ssl.SSLHandshakeException
      //   6693	1	28	localSSLHandshakeException9	javax.net.ssl.SSLHandshakeException
      //   6713	1	28	localFileNotFoundException2	java.io.FileNotFoundException
      //   6736	1	28	localFileNotFoundException3	java.io.FileNotFoundException
      //   6760	1	28	localFileNotFoundException4	java.io.FileNotFoundException
      //   6786	1	28	localFileNotFoundException5	java.io.FileNotFoundException
      //   6813	1	28	localFileNotFoundException6	java.io.FileNotFoundException
      //   6839	1	28	localFileNotFoundException7	java.io.FileNotFoundException
      //   6860	1	28	localFileNotFoundException8	java.io.FileNotFoundException
      //   6880	1	28	localFileNotFoundException9	java.io.FileNotFoundException
      //   6900	1	28	localUnsupportedEncodingException3	java.io.UnsupportedEncodingException
      //   6921	1	28	localUnsupportedEncodingException4	java.io.UnsupportedEncodingException
      //   6939	1	28	localUnsupportedEncodingException5	java.io.UnsupportedEncodingException
      //   6951	1	28	localUnsupportedEncodingException6	java.io.UnsupportedEncodingException
      //   6964	1	28	localUnsupportedEncodingException7	java.io.UnsupportedEncodingException
      //   6976	1	28	localUnsupportedEncodingException8	java.io.UnsupportedEncodingException
      //   6981	1	28	localUnsupportedEncodingException9	java.io.UnsupportedEncodingException
      //   6989	1	28	str2	String
      //   449	6482	29	localObject21	Object
      //   439	6454	30	localObject22	Object
      //   421	6464	31	localObject23	Object
      //   391	6498	32	localObject24	Object
      //   9	5962	33	str3	String
      //   15	5961	34	str4	String
      //   32	5691	35	str5	String
      //   108	5222	36	locala	g.a
      //   66	1999	37	localObject25	Object
      //   114	1938	38	localObject26	Object
      //   1420	13	39	localIterator	Iterator
      //   1442	84	40	str6	String
      //   1456	108	41	str7	String
      // Exception table:
      //   from	to	target	type
      //   451	467	775	java/io/UnsupportedEncodingException
      //   467	510	775	java/io/UnsupportedEncodingException
      //   510	615	775	java/io/UnsupportedEncodingException
      //   620	651	775	java/io/UnsupportedEncodingException
      //   651	772	775	java/io/UnsupportedEncodingException
      //   1006	1031	775	java/io/UnsupportedEncodingException
      //   1344	1384	775	java/io/UnsupportedEncodingException
      //   1389	1422	775	java/io/UnsupportedEncodingException
      //   1422	1578	775	java/io/UnsupportedEncodingException
      //   1891	2051	775	java/io/UnsupportedEncodingException
      //   2051	2077	775	java/io/UnsupportedEncodingException
      //   2086	2091	775	java/io/UnsupportedEncodingException
      //   2096	2101	775	java/io/UnsupportedEncodingException
      //   2101	2174	775	java/io/UnsupportedEncodingException
      //   451	467	1034	java/io/FileNotFoundException
      //   467	510	1034	java/io/FileNotFoundException
      //   510	615	1034	java/io/FileNotFoundException
      //   620	651	1034	java/io/FileNotFoundException
      //   651	772	1034	java/io/FileNotFoundException
      //   1006	1031	1034	java/io/FileNotFoundException
      //   1344	1384	1034	java/io/FileNotFoundException
      //   1389	1422	1034	java/io/FileNotFoundException
      //   1422	1578	1034	java/io/FileNotFoundException
      //   1891	2051	1034	java/io/FileNotFoundException
      //   2051	2077	1034	java/io/FileNotFoundException
      //   2086	2091	1034	java/io/FileNotFoundException
      //   2096	2101	1034	java/io/FileNotFoundException
      //   2101	2174	1034	java/io/FileNotFoundException
      //   451	467	1581	javax/net/ssl/SSLHandshakeException
      //   467	510	1581	javax/net/ssl/SSLHandshakeException
      //   510	615	1581	javax/net/ssl/SSLHandshakeException
      //   620	651	1581	javax/net/ssl/SSLHandshakeException
      //   651	772	1581	javax/net/ssl/SSLHandshakeException
      //   1006	1031	1581	javax/net/ssl/SSLHandshakeException
      //   1344	1384	1581	javax/net/ssl/SSLHandshakeException
      //   1389	1422	1581	javax/net/ssl/SSLHandshakeException
      //   1422	1578	1581	javax/net/ssl/SSLHandshakeException
      //   1891	2051	1581	javax/net/ssl/SSLHandshakeException
      //   2051	2077	1581	javax/net/ssl/SSLHandshakeException
      //   2086	2091	1581	javax/net/ssl/SSLHandshakeException
      //   2096	2101	1581	javax/net/ssl/SSLHandshakeException
      //   2101	2174	1581	javax/net/ssl/SSLHandshakeException
      //   2456	2461	2487	java/lang/Exception
      //   2461	2466	2516	java/io/IOException
      //   3078	3083	3109	java/lang/Exception
      //   3083	3088	3138	java/io/IOException
      //   3395	3400	3426	java/lang/Exception
      //   3400	3405	3455	java/io/IOException
      //   3579	3606	3636	java/io/UnsupportedEncodingException
      //   3606	3613	3636	java/io/UnsupportedEncodingException
      //   3618	3633	3636	java/io/UnsupportedEncodingException
      //   3822	3842	3636	java/io/UnsupportedEncodingException
      //   3532	3546	3667	java/lang/Exception
      //   3560	3574	3667	java/lang/Exception
      //   3657	3664	3667	java/lang/Exception
      //   3714	3728	3759	java/lang/Exception
      //   3742	3756	3759	java/lang/Exception
      //   3812	3819	3759	java/lang/Exception
      //   3985	3990	4161	java/lang/Exception
      //   3995	4000	4190	java/io/IOException
      //   3995	4000	4219	java/lang/ArrayIndexOutOfBoundsException
      //   3995	4000	4248	java/lang/Throwable
      //   4000	4005	4277	java/io/IOException
      //   960	965	4306	java/lang/Exception
      //   970	975	4335	java/io/IOException
      //   970	975	4364	java/lang/ArrayIndexOutOfBoundsException
      //   970	975	4393	java/lang/Throwable
      //   980	985	4422	java/io/IOException
      //   1298	1303	4451	java/lang/Exception
      //   1308	1313	4480	java/io/IOException
      //   1308	1313	4509	java/lang/ArrayIndexOutOfBoundsException
      //   1308	1313	4538	java/lang/Throwable
      //   1318	1323	4567	java/io/IOException
      //   1845	1850	4596	java/lang/Exception
      //   1855	1860	4625	java/io/IOException
      //   1855	1860	4654	java/lang/ArrayIndexOutOfBoundsException
      //   1855	1860	4683	java/lang/Throwable
      //   1865	1870	4712	java/io/IOException
      //   393	430	4741	java/net/SocketTimeoutException
      //   5003	5008	5049	java/lang/Exception
      //   5013	5018	5078	java/io/IOException
      //   5013	5018	5107	java/lang/ArrayIndexOutOfBoundsException
      //   5013	5018	5136	java/lang/Throwable
      //   5023	5028	5165	java/io/IOException
      //   393	430	5194	java/lang/Exception
      //   5471	5476	5517	java/lang/Exception
      //   5481	5486	5546	java/io/IOException
      //   5481	5486	5575	java/lang/ArrayIndexOutOfBoundsException
      //   5481	5486	5604	java/lang/Throwable
      //   5491	5496	5633	java/io/IOException
      //   393	430	5662	finally
      //   5791	5796	5839	java/lang/Exception
      //   5801	5806	5868	java/io/IOException
      //   5801	5806	5897	java/lang/ArrayIndexOutOfBoundsException
      //   5801	5806	5926	java/lang/Throwable
      //   5811	5816	5955	java/io/IOException
      //   430	451	5984	finally
      //   451	467	5984	finally
      //   467	510	5984	finally
      //   510	615	5984	finally
      //   620	651	5984	finally
      //   651	772	5984	finally
      //   1006	1031	5984	finally
      //   1344	1384	5984	finally
      //   1389	1422	5984	finally
      //   1422	1578	5984	finally
      //   1891	2051	5984	finally
      //   2051	2077	5984	finally
      //   2086	2091	5984	finally
      //   2096	2101	5984	finally
      //   2101	2174	5984	finally
      //   2174	2197	6011	finally
      //   2225	2234	6035	finally
      //   2263	2270	6035	finally
      //   2293	2306	6035	finally
      //   2329	2347	6035	finally
      //   2568	2578	6035	finally
      //   2700	2707	6035	finally
      //   2730	2735	6035	finally
      //   2758	2764	6035	finally
      //   2781	2793	6035	finally
      //   2817	2846	6035	finally
      //   2863	2870	6035	finally
      //   2887	2894	6035	finally
      //   2911	2917	6035	finally
      //   2934	2942	6035	finally
      //   2964	2984	6035	finally
      //   3001	3021	6035	finally
      //   3184	3216	6035	finally
      //   3233	3239	6035	finally
      //   3256	3264	6035	finally
      //   3281	3286	6035	finally
      //   3501	3518	6035	finally
      //   3532	3546	6035	finally
      //   3560	3574	6035	finally
      //   3657	3664	6035	finally
      //   3686	3700	6035	finally
      //   3714	3728	6035	finally
      //   3742	3756	6035	finally
      //   3778	3792	6035	finally
      //   3812	3819	6035	finally
      //   2593	2612	6056	finally
      //   2620	2633	6056	finally
      //   2636	2672	6056	finally
      //   3579	3606	6077	finally
      //   3606	3613	6077	finally
      //   3618	3633	6077	finally
      //   3822	3842	6077	finally
      //   3842	3871	6093	finally
      //   3871	3919	6106	finally
      //   4026	4052	6106	finally
      //   787	850	6119	finally
      //   1078	1099	6132	finally
      //   1121	1145	6132	finally
      //   1167	1187	6132	finally
      //   1625	1646	6132	finally
      //   1668	1692	6132	finally
      //   1714	1734	6132	finally
      //   4783	4804	6132	finally
      //   4826	4850	6132	finally
      //   4872	4892	6132	finally
      //   5236	5257	6132	finally
      //   5279	5303	6132	finally
      //   5325	5360	6132	finally
      //   430	451	6148	java/lang/Exception
      //   451	467	6172	java/lang/Exception
      //   467	510	6172	java/lang/Exception
      //   510	615	6172	java/lang/Exception
      //   620	651	6172	java/lang/Exception
      //   651	772	6172	java/lang/Exception
      //   1006	1031	6172	java/lang/Exception
      //   1344	1384	6172	java/lang/Exception
      //   1389	1422	6172	java/lang/Exception
      //   1422	1578	6172	java/lang/Exception
      //   1891	2051	6172	java/lang/Exception
      //   2051	2077	6172	java/lang/Exception
      //   2086	2091	6172	java/lang/Exception
      //   2096	2101	6172	java/lang/Exception
      //   2101	2174	6172	java/lang/Exception
      //   2174	2197	6197	java/lang/Exception
      //   2225	2234	6223	java/lang/Exception
      //   2263	2270	6223	java/lang/Exception
      //   2293	2306	6223	java/lang/Exception
      //   2329	2347	6223	java/lang/Exception
      //   2568	2578	6223	java/lang/Exception
      //   2700	2707	6223	java/lang/Exception
      //   2730	2735	6223	java/lang/Exception
      //   2758	2764	6223	java/lang/Exception
      //   2781	2793	6223	java/lang/Exception
      //   2817	2846	6223	java/lang/Exception
      //   2863	2870	6223	java/lang/Exception
      //   2887	2894	6223	java/lang/Exception
      //   2911	2917	6223	java/lang/Exception
      //   2934	2942	6223	java/lang/Exception
      //   2964	2984	6223	java/lang/Exception
      //   3001	3021	6223	java/lang/Exception
      //   3184	3216	6223	java/lang/Exception
      //   3233	3239	6223	java/lang/Exception
      //   3256	3264	6223	java/lang/Exception
      //   3281	3286	6223	java/lang/Exception
      //   3501	3518	6223	java/lang/Exception
      //   3686	3700	6223	java/lang/Exception
      //   3778	3792	6223	java/lang/Exception
      //   2593	2612	6250	java/lang/Exception
      //   2620	2633	6250	java/lang/Exception
      //   2636	2672	6250	java/lang/Exception
      //   3579	3606	6276	java/lang/Exception
      //   3606	3613	6276	java/lang/Exception
      //   3618	3633	6276	java/lang/Exception
      //   3822	3842	6276	java/lang/Exception
      //   3842	3871	6297	java/lang/Exception
      //   3871	3919	6317	java/lang/Exception
      //   4026	4052	6317	java/lang/Exception
      //   430	451	6337	java/net/SocketTimeoutException
      //   451	467	6361	java/net/SocketTimeoutException
      //   467	510	6361	java/net/SocketTimeoutException
      //   510	615	6361	java/net/SocketTimeoutException
      //   620	651	6361	java/net/SocketTimeoutException
      //   651	772	6361	java/net/SocketTimeoutException
      //   1006	1031	6361	java/net/SocketTimeoutException
      //   1344	1384	6361	java/net/SocketTimeoutException
      //   1389	1422	6361	java/net/SocketTimeoutException
      //   1422	1578	6361	java/net/SocketTimeoutException
      //   1891	2051	6361	java/net/SocketTimeoutException
      //   2051	2077	6361	java/net/SocketTimeoutException
      //   2086	2091	6361	java/net/SocketTimeoutException
      //   2096	2101	6361	java/net/SocketTimeoutException
      //   2101	2174	6361	java/net/SocketTimeoutException
      //   2174	2197	6386	java/net/SocketTimeoutException
      //   2225	2234	6412	java/net/SocketTimeoutException
      //   2263	2270	6412	java/net/SocketTimeoutException
      //   2293	2306	6412	java/net/SocketTimeoutException
      //   2329	2347	6412	java/net/SocketTimeoutException
      //   2568	2578	6412	java/net/SocketTimeoutException
      //   2700	2707	6412	java/net/SocketTimeoutException
      //   2730	2735	6412	java/net/SocketTimeoutException
      //   2758	2764	6412	java/net/SocketTimeoutException
      //   2781	2793	6412	java/net/SocketTimeoutException
      //   2817	2846	6412	java/net/SocketTimeoutException
      //   2863	2870	6412	java/net/SocketTimeoutException
      //   2887	2894	6412	java/net/SocketTimeoutException
      //   2911	2917	6412	java/net/SocketTimeoutException
      //   2934	2942	6412	java/net/SocketTimeoutException
      //   2964	2984	6412	java/net/SocketTimeoutException
      //   3001	3021	6412	java/net/SocketTimeoutException
      //   3184	3216	6412	java/net/SocketTimeoutException
      //   3233	3239	6412	java/net/SocketTimeoutException
      //   3256	3264	6412	java/net/SocketTimeoutException
      //   3281	3286	6412	java/net/SocketTimeoutException
      //   3501	3518	6412	java/net/SocketTimeoutException
      //   3532	3546	6412	java/net/SocketTimeoutException
      //   3560	3574	6412	java/net/SocketTimeoutException
      //   3657	3664	6412	java/net/SocketTimeoutException
      //   3686	3700	6412	java/net/SocketTimeoutException
      //   3714	3728	6412	java/net/SocketTimeoutException
      //   3742	3756	6412	java/net/SocketTimeoutException
      //   3778	3792	6412	java/net/SocketTimeoutException
      //   3812	3819	6412	java/net/SocketTimeoutException
      //   2593	2612	6439	java/net/SocketTimeoutException
      //   2620	2633	6439	java/net/SocketTimeoutException
      //   2636	2672	6439	java/net/SocketTimeoutException
      //   3579	3606	6465	java/net/SocketTimeoutException
      //   3606	3613	6465	java/net/SocketTimeoutException
      //   3618	3633	6465	java/net/SocketTimeoutException
      //   3822	3842	6465	java/net/SocketTimeoutException
      //   3842	3871	6486	java/net/SocketTimeoutException
      //   3871	3919	6506	java/net/SocketTimeoutException
      //   4026	4052	6506	java/net/SocketTimeoutException
      //   393	430	6526	javax/net/ssl/SSLHandshakeException
      //   430	451	6549	javax/net/ssl/SSLHandshakeException
      //   2174	2197	6573	javax/net/ssl/SSLHandshakeException
      //   2225	2234	6599	javax/net/ssl/SSLHandshakeException
      //   2263	2270	6599	javax/net/ssl/SSLHandshakeException
      //   2293	2306	6599	javax/net/ssl/SSLHandshakeException
      //   2329	2347	6599	javax/net/ssl/SSLHandshakeException
      //   2568	2578	6599	javax/net/ssl/SSLHandshakeException
      //   2700	2707	6599	javax/net/ssl/SSLHandshakeException
      //   2730	2735	6599	javax/net/ssl/SSLHandshakeException
      //   2758	2764	6599	javax/net/ssl/SSLHandshakeException
      //   2781	2793	6599	javax/net/ssl/SSLHandshakeException
      //   2817	2846	6599	javax/net/ssl/SSLHandshakeException
      //   2863	2870	6599	javax/net/ssl/SSLHandshakeException
      //   2887	2894	6599	javax/net/ssl/SSLHandshakeException
      //   2911	2917	6599	javax/net/ssl/SSLHandshakeException
      //   2934	2942	6599	javax/net/ssl/SSLHandshakeException
      //   2964	2984	6599	javax/net/ssl/SSLHandshakeException
      //   3001	3021	6599	javax/net/ssl/SSLHandshakeException
      //   3184	3216	6599	javax/net/ssl/SSLHandshakeException
      //   3233	3239	6599	javax/net/ssl/SSLHandshakeException
      //   3256	3264	6599	javax/net/ssl/SSLHandshakeException
      //   3281	3286	6599	javax/net/ssl/SSLHandshakeException
      //   3501	3518	6599	javax/net/ssl/SSLHandshakeException
      //   3532	3546	6599	javax/net/ssl/SSLHandshakeException
      //   3560	3574	6599	javax/net/ssl/SSLHandshakeException
      //   3657	3664	6599	javax/net/ssl/SSLHandshakeException
      //   3686	3700	6599	javax/net/ssl/SSLHandshakeException
      //   3714	3728	6599	javax/net/ssl/SSLHandshakeException
      //   3742	3756	6599	javax/net/ssl/SSLHandshakeException
      //   3778	3792	6599	javax/net/ssl/SSLHandshakeException
      //   3812	3819	6599	javax/net/ssl/SSLHandshakeException
      //   2593	2612	6626	javax/net/ssl/SSLHandshakeException
      //   2620	2633	6626	javax/net/ssl/SSLHandshakeException
      //   2636	2672	6626	javax/net/ssl/SSLHandshakeException
      //   3579	3606	6652	javax/net/ssl/SSLHandshakeException
      //   3606	3613	6652	javax/net/ssl/SSLHandshakeException
      //   3618	3633	6652	javax/net/ssl/SSLHandshakeException
      //   3822	3842	6652	javax/net/ssl/SSLHandshakeException
      //   3842	3871	6673	javax/net/ssl/SSLHandshakeException
      //   3871	3919	6693	javax/net/ssl/SSLHandshakeException
      //   4026	4052	6693	javax/net/ssl/SSLHandshakeException
      //   393	430	6713	java/io/FileNotFoundException
      //   430	451	6736	java/io/FileNotFoundException
      //   2174	2197	6760	java/io/FileNotFoundException
      //   2225	2234	6786	java/io/FileNotFoundException
      //   2263	2270	6786	java/io/FileNotFoundException
      //   2293	2306	6786	java/io/FileNotFoundException
      //   2329	2347	6786	java/io/FileNotFoundException
      //   2568	2578	6786	java/io/FileNotFoundException
      //   2700	2707	6786	java/io/FileNotFoundException
      //   2730	2735	6786	java/io/FileNotFoundException
      //   2758	2764	6786	java/io/FileNotFoundException
      //   2781	2793	6786	java/io/FileNotFoundException
      //   2817	2846	6786	java/io/FileNotFoundException
      //   2863	2870	6786	java/io/FileNotFoundException
      //   2887	2894	6786	java/io/FileNotFoundException
      //   2911	2917	6786	java/io/FileNotFoundException
      //   2934	2942	6786	java/io/FileNotFoundException
      //   2964	2984	6786	java/io/FileNotFoundException
      //   3001	3021	6786	java/io/FileNotFoundException
      //   3184	3216	6786	java/io/FileNotFoundException
      //   3233	3239	6786	java/io/FileNotFoundException
      //   3256	3264	6786	java/io/FileNotFoundException
      //   3281	3286	6786	java/io/FileNotFoundException
      //   3501	3518	6786	java/io/FileNotFoundException
      //   3532	3546	6786	java/io/FileNotFoundException
      //   3560	3574	6786	java/io/FileNotFoundException
      //   3657	3664	6786	java/io/FileNotFoundException
      //   3686	3700	6786	java/io/FileNotFoundException
      //   3714	3728	6786	java/io/FileNotFoundException
      //   3742	3756	6786	java/io/FileNotFoundException
      //   3778	3792	6786	java/io/FileNotFoundException
      //   3812	3819	6786	java/io/FileNotFoundException
      //   2593	2612	6813	java/io/FileNotFoundException
      //   2620	2633	6813	java/io/FileNotFoundException
      //   2636	2672	6813	java/io/FileNotFoundException
      //   3579	3606	6839	java/io/FileNotFoundException
      //   3606	3613	6839	java/io/FileNotFoundException
      //   3618	3633	6839	java/io/FileNotFoundException
      //   3822	3842	6839	java/io/FileNotFoundException
      //   3842	3871	6860	java/io/FileNotFoundException
      //   3871	3919	6880	java/io/FileNotFoundException
      //   4026	4052	6880	java/io/FileNotFoundException
      //   393	430	6900	java/io/UnsupportedEncodingException
      //   430	451	6921	java/io/UnsupportedEncodingException
      //   2174	2197	6939	java/io/UnsupportedEncodingException
      //   2225	2234	6951	java/io/UnsupportedEncodingException
      //   2263	2270	6951	java/io/UnsupportedEncodingException
      //   2293	2306	6951	java/io/UnsupportedEncodingException
      //   2329	2347	6951	java/io/UnsupportedEncodingException
      //   2568	2578	6951	java/io/UnsupportedEncodingException
      //   2700	2707	6951	java/io/UnsupportedEncodingException
      //   2730	2735	6951	java/io/UnsupportedEncodingException
      //   2758	2764	6951	java/io/UnsupportedEncodingException
      //   2781	2793	6951	java/io/UnsupportedEncodingException
      //   2817	2846	6951	java/io/UnsupportedEncodingException
      //   2863	2870	6951	java/io/UnsupportedEncodingException
      //   2887	2894	6951	java/io/UnsupportedEncodingException
      //   2911	2917	6951	java/io/UnsupportedEncodingException
      //   2934	2942	6951	java/io/UnsupportedEncodingException
      //   2964	2984	6951	java/io/UnsupportedEncodingException
      //   3001	3021	6951	java/io/UnsupportedEncodingException
      //   3184	3216	6951	java/io/UnsupportedEncodingException
      //   3233	3239	6951	java/io/UnsupportedEncodingException
      //   3256	3264	6951	java/io/UnsupportedEncodingException
      //   3281	3286	6951	java/io/UnsupportedEncodingException
      //   3501	3518	6951	java/io/UnsupportedEncodingException
      //   3532	3546	6951	java/io/UnsupportedEncodingException
      //   3560	3574	6951	java/io/UnsupportedEncodingException
      //   3657	3664	6951	java/io/UnsupportedEncodingException
      //   3686	3700	6951	java/io/UnsupportedEncodingException
      //   3714	3728	6951	java/io/UnsupportedEncodingException
      //   3742	3756	6951	java/io/UnsupportedEncodingException
      //   3778	3792	6951	java/io/UnsupportedEncodingException
      //   3812	3819	6951	java/io/UnsupportedEncodingException
      //   2593	2612	6964	java/io/UnsupportedEncodingException
      //   2620	2633	6964	java/io/UnsupportedEncodingException
      //   2636	2672	6964	java/io/UnsupportedEncodingException
      //   3842	3871	6976	java/io/UnsupportedEncodingException
      //   3871	3919	6981	java/io/UnsupportedEncodingException
      //   4026	4052	6981	java/io/UnsupportedEncodingException
    }
    
    private static String cI(String paramString1, String paramString2)
    {
      AppMethodBeat.i(144345);
      if (bt.isNullOrNil(paramString1))
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
      b(this.kVq);
      AppMethodBeat.o(144344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.g
 * JD-Core Version:    0.7.0.1
 */