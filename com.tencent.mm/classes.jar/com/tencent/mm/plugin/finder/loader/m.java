package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.e;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader;", "Lcom/tencent/mm/loader/common/IDataFetcher;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "()V", "loadDataImp", "", "item", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "Companion", "DefaultHttpClientFactory", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends com.tencent.mm.loader.c.b<r>
{
  public static final m.a ExB;
  
  static
  {
    AppMethodBeat.i(166323);
    ExB = new m.a((byte)0);
    AppMethodBeat.o(166323);
  }
  
  /* Error */
  public final void a(com.tencent.mm.loader.g.a.a<r> parama, com.tencent.mm.loader.e.g paramg, com.tencent.mm.loader.c.b.b paramb)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 75
    //   8: invokestatic 81	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_2
    //   12: ldc 82
    //   14: invokestatic 81	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_3
    //   18: ldc 83
    //   20: invokestatic 81	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 89	com/tencent/mm/loader/g/a/a:bmg	()Ljava/lang/Object;
    //   27: checkcast 91	com/tencent/mm/plugin/finder/loader/r
    //   30: astore_2
    //   31: aload_2
    //   32: invokeinterface 95 1 0
    //   37: getstatic 101	com/tencent/mm/plugin/finder/storage/v:FKY	Lcom/tencent/mm/plugin/finder/storage/v;
    //   40: if_acmpne +95 -> 135
    //   43: aload_2
    //   44: invokeinterface 105 1 0
    //   49: astore_1
    //   50: ldc 107
    //   52: new 109	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 111
    //   58: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: aload_2
    //   62: invokeinterface 95 1 0
    //   67: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: ldc 120
    //   72: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_2
    //   76: invokeinterface 126 1 0
    //   81: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 128
    //   86: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_2
    //   90: invokeinterface 105 1 0
    //   95: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: getstatic 140	com/tencent/mm/plugin/finder/loader/m$b:ExC	Lcom/tencent/mm/plugin/finder/loader/m$b;
    //   107: astore_2
    //   108: aload_1
    //   109: invokestatic 144	com/tencent/mm/plugin/finder/loader/m$b:GI	(Ljava/lang/String;)Lcom/tencent/mm/loader/g/b;
    //   112: astore_1
    //   113: aload_1
    //   114: ifnonnull +31 -> 145
    //   117: aconst_null
    //   118: astore_1
    //   119: aload_1
    //   120: ifnonnull +9 -> 129
    //   123: aload_3
    //   124: invokeinterface 149 1 0
    //   129: ldc 74
    //   131: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: return
    //   135: aload_2
    //   136: invokeinterface 126 1 0
    //   141: astore_1
    //   142: goto -92 -> 50
    //   145: aload_3
    //   146: aload_1
    //   147: checkcast 151	com/tencent/mm/loader/g/f
    //   150: invokeinterface 154 2 0
    //   155: getstatic 160	kotlin/ah:aiuX	Lkotlin/ah;
    //   158: astore_1
    //   159: goto -40 -> 119
    //   162: astore_1
    //   163: ldc 107
    //   165: ldc 162
    //   167: iconst_1
    //   168: anewarray 164	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: aload_1
    //   174: checkcast 166	java/lang/Throwable
    //   177: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   180: aastore
    //   181: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_3
    //   185: invokeinterface 149 1 0
    //   190: ldc 74
    //   192: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: return
    //   196: astore_1
    //   197: ldc 107
    //   199: ldc 162
    //   201: iconst_1
    //   202: anewarray 164	java/lang/Object
    //   205: dup
    //   206: iconst_0
    //   207: aload_1
    //   208: checkcast 166	java/lang/Throwable
    //   211: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   214: aastore
    //   215: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: goto -34 -> 184
    //   221: astore_1
    //   222: ldc 107
    //   224: ldc 162
    //   226: iconst_1
    //   227: anewarray 164	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload_1
    //   233: checkcast 166	java/lang/Throwable
    //   236: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   239: aastore
    //   240: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: goto -59 -> 184
    //   246: astore_1
    //   247: ldc 107
    //   249: ldc 162
    //   251: iconst_1
    //   252: anewarray 164	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_1
    //   258: checkcast 166	java/lang/Throwable
    //   261: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   264: aastore
    //   265: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: goto -84 -> 184
    //   271: astore_1
    //   272: ldc 107
    //   274: ldc 162
    //   276: iconst_1
    //   277: anewarray 164	java/lang/Object
    //   280: dup
    //   281: iconst_0
    //   282: aload_1
    //   283: checkcast 166	java/lang/Throwable
    //   286: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   289: aastore
    //   290: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: goto -109 -> 184
    //   296: astore_1
    //   297: ldc 107
    //   299: ldc 162
    //   301: iconst_1
    //   302: anewarray 164	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: aload_1
    //   308: checkcast 166	java/lang/Throwable
    //   311: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   314: aastore
    //   315: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: goto -134 -> 184
    //   321: astore_1
    //   322: ldc 107
    //   324: ldc 162
    //   326: iconst_1
    //   327: anewarray 164	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload_1
    //   333: checkcast 166	java/lang/Throwable
    //   336: invokestatic 172	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   339: aastore
    //   340: invokestatic 176	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: goto -159 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	m
    //   0	346	1	parama	com.tencent.mm.loader.g.a.a<r>
    //   0	346	2	paramg	com.tencent.mm.loader.e.g
    //   0	346	3	paramb	com.tencent.mm.loader.c.b.b
    // Exception table:
    //   from	to	target	type
    //   23	50	162	java/lang/InterruptedException
    //   50	113	162	java/lang/InterruptedException
    //   123	129	162	java/lang/InterruptedException
    //   129	134	162	java/lang/InterruptedException
    //   135	142	162	java/lang/InterruptedException
    //   145	159	162	java/lang/InterruptedException
    //   23	50	196	java/net/UnknownHostException
    //   50	113	196	java/net/UnknownHostException
    //   123	129	196	java/net/UnknownHostException
    //   129	134	196	java/net/UnknownHostException
    //   135	142	196	java/net/UnknownHostException
    //   145	159	196	java/net/UnknownHostException
    //   23	50	221	javax/net/ssl/SSLHandshakeException
    //   50	113	221	javax/net/ssl/SSLHandshakeException
    //   123	129	221	javax/net/ssl/SSLHandshakeException
    //   129	134	221	javax/net/ssl/SSLHandshakeException
    //   135	142	221	javax/net/ssl/SSLHandshakeException
    //   145	159	221	javax/net/ssl/SSLHandshakeException
    //   23	50	246	java/net/SocketException
    //   50	113	246	java/net/SocketException
    //   123	129	246	java/net/SocketException
    //   129	134	246	java/net/SocketException
    //   135	142	246	java/net/SocketException
    //   145	159	246	java/net/SocketException
    //   23	50	271	java/net/SocketTimeoutException
    //   50	113	271	java/net/SocketTimeoutException
    //   123	129	271	java/net/SocketTimeoutException
    //   129	134	271	java/net/SocketTimeoutException
    //   135	142	271	java/net/SocketTimeoutException
    //   145	159	271	java/net/SocketTimeoutException
    //   23	50	296	java/io/IOException
    //   50	113	296	java/io/IOException
    //   123	129	296	java/io/IOException
    //   129	134	296	java/io/IOException
    //   135	142	296	java/io/IOException
    //   145	159	296	java/io/IOException
    //   23	50	321	java/lang/Exception
    //   50	113	321	java/lang/Exception
    //   123	129	321	java/lang/Exception
    //   129	134	321	java/lang/Exception
    //   135	142	321	java/lang/Exception
    //   145	159	321	java/lang/Exception
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderImageDownloader$DefaultHttpClientFactory;", "", "()V", "httpURLConnectionGet", "Lcom/tencent/mm/loader/model/HttpResponse;", "url", "", "openConnection", "Ljava/net/HttpURLConnection;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b ExC;
    
    static
    {
      AppMethodBeat.i(166321);
      ExC = new b();
      AppMethodBeat.o(166321);
    }
    
    public static com.tencent.mm.loader.g.b GI(String paramString)
    {
      AppMethodBeat.i(331801);
      s.u(paramString, "url");
      paramString = ayK(paramString);
      int i = paramString.getResponseCode();
      Object localObject1;
      int j;
      if (i >= 300)
      {
        paramString.disconnect();
        if ((i == 300) || (i == 301) || (i == 302) || (i == 303)) {
          try
          {
            localObject1 = paramString.getHeaderField("location");
            if (localObject1 == null)
            {
              localObject1 = null;
              if (localObject1 != null) {
                break label225;
              }
              j = i;
            }
          }
          catch (Exception paramString) {}
        }
      }
      try
      {
        AppMethodBeat.o(331801);
        return null;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label225:
          i = j;
        }
      }
      if (((CharSequence)localObject1).length() == 0) {
        j = 1;
      }
      label267:
      label273:
      label296:
      label299:
      for (;;)
      {
        paramString = ayK((String)localObject1);
        j = paramString.getResponseCode();
        i = j;
        if (i >= 300)
        {
          j = i;
          paramString.disconnect();
          j = i;
          Log.w("Finder.ImageDownloader", "reDirector error [httpURLConnectionGet " + i + '!');
          j = i;
          AppMethodBeat.o(331801);
          return null;
        }
        j = i;
        localObject1 = ah.aiuX;
        break;
        localObject1 = aw.Gjk;
        aw.a(paramString, "reDirector error [httpURLConnectionGet " + i + ']');
        AppMethodBeat.o(331801);
        return null;
        Log.w("Finder.ImageDownloader", "dz[httpURLConnectionGet 300]");
        AppMethodBeat.o(331801);
        return null;
        Object localObject2 = paramString.getInputStream();
        localObject1 = paramString.getContentType();
        localObject2 = e.B((InputStream)localObject2);
        paramString.disconnect();
        paramString = com.tencent.mm.loader.g.b.d((byte[])localObject2, (String)localObject1);
        AppMethodBeat.o(331801);
        return paramString;
        if (j == 0)
        {
          j = 1;
          if (j == 0) {
            break label296;
          }
        }
        for (;;)
        {
          if (localObject1 != null) {
            break label299;
          }
          localObject1 = null;
          break;
          j = 0;
          break label267;
          j = 0;
          break label273;
          localObject1 = null;
        }
      }
    }
    
    private static HttpURLConnection ayK(String paramString)
    {
      AppMethodBeat.i(166320);
      s.u(paramString, "url");
      Log.i("Finder.ImageDownloader", s.X("[openConnection] url:", paramString));
      paramString = new URL(paramString).openConnection();
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        AppMethodBeat.o(166320);
        throw paramString;
      }
      paramString = (HttpURLConnection)paramString;
      paramString.setConnectTimeout(15000);
      paramString.setReadTimeout(20000);
      AppMethodBeat.o(166320);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.m
 * JD-Core Version:    0.7.0.1
 */