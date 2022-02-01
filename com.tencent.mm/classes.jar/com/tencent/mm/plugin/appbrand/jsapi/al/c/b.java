package com.tencent.mm.plugin.appbrand.jsapi.al.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.zip.ZipInputStream;

public final class b
{
  private static final String oqs;
  private static ConcurrentMap<String, Boolean> sPt;
  private static Map<String, List<a>> sPu;
  
  static
  {
    AppMethodBeat.i(139476);
    sPt = new ConcurrentHashMap();
    sPu = new HashMap();
    String str2 = com.tencent.mm.loader.i.b.bmz();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    oqs = str1;
    FilePathGenerator.checkMkdir(str1);
    AppMethodBeat.o(139476);
  }
  
  private static AppBrandRuntime M(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
  {
    AppMethodBeat.i(327156);
    if (paramf == null)
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, component is null");
      AppMethodBeat.o(327156);
      return null;
    }
    if (!(paramf instanceof k))
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, can not get runtime from component");
      AppMethodBeat.o(327156);
      return null;
    }
    paramf = ((k)paramf).getRuntime();
    if (paramf == null) {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, runtime is null");
    }
    AppMethodBeat.o(327156);
    return paramf;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(139469);
    if (parama != null) {
      parama.onLoad(null);
    }
    AppMethodBeat.o(139469);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(139468);
    a(paramf, paramString1, false, paramString2, parama);
    AppMethodBeat.o(139468);
  }
  
  public static void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, boolean paramBoolean, String paramString2, a parama)
  {
    AppMethodBeat.i(327100);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(327100);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(327100);
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      if (!b(paramf, paramString1, paramBoolean, paramString2, parama))
      {
        a(parama);
        AppMethodBeat.o(327100);
      }
    }
    else
    {
      if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
      {
        d(paramf, paramString1, paramBoolean, paramString2, parama);
        AppMethodBeat.o(327100);
        return;
      }
      if (!c(paramf, paramString1, paramBoolean, paramString2, parama)) {
        a(parama);
      }
    }
    AppMethodBeat.o(327100);
  }
  
  private static String acH(String paramString)
  {
    AppMethodBeat.i(327148);
    String str = null;
    if (!Util.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(327148);
    return str;
  }
  
  /* Error */
  private static boolean b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:sPB	Lcom/tencent/mm/plugin/appbrand/jsapi/al/c/f;
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: invokestatic 166	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:j	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Ljava/lang/String;)Lcom/tencent/mm/vfs/u;
    //   15: astore 6
    //   17: aload 6
    //   19: ifnonnull +10 -> 29
    //   22: ldc 156
    //   24: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: iconst_0
    //   28: ireturn
    //   29: aconst_null
    //   30: astore 4
    //   32: aload_0
    //   33: invokeinterface 172 1 0
    //   38: aload_1
    //   39: invokeinterface 178 2 0
    //   44: astore 5
    //   46: aload 5
    //   48: ifnonnull +15 -> 63
    //   51: aload 5
    //   53: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   56: ldc 156
    //   58: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iconst_0
    //   62: ireturn
    //   63: aload 5
    //   65: astore 4
    //   67: aload_2
    //   68: aload 5
    //   70: invokestatic 186	com/tencent/mm/plugin/appbrand/jsapi/al/c/b:f	(Ljava/lang/String;Ljava/io/InputStream;)Z
    //   73: ifne +26 -> 99
    //   76: aload 5
    //   78: astore 4
    //   80: ldc 84
    //   82: ldc 188
    //   84: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 5
    //   89: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   92: ldc 156
    //   94: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iconst_0
    //   98: ireturn
    //   99: aload 5
    //   101: astore 4
    //   103: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:sPB	Lcom/tencent/mm/plugin/appbrand/jsapi/al/c/f;
    //   106: astore_2
    //   107: aload 5
    //   109: astore_2
    //   110: aload 5
    //   112: astore 4
    //   114: aload 6
    //   116: invokestatic 192	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:E	(Lcom/tencent/mm/vfs/u;)Z
    //   119: ifne +90 -> 209
    //   122: aload 5
    //   124: astore 4
    //   126: aload 5
    //   128: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   131: aload 5
    //   133: astore 4
    //   135: aload_0
    //   136: invokeinterface 172 1 0
    //   141: aload_1
    //   142: invokeinterface 178 2 0
    //   147: astore_1
    //   148: aload_1
    //   149: ifnonnull +14 -> 163
    //   152: aload_1
    //   153: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   156: ldc 156
    //   158: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: iconst_0
    //   162: ireturn
    //   163: new 194	java/util/zip/ZipInputStream
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 197	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   171: astore_0
    //   172: aload_0
    //   173: astore 4
    //   175: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:sPB	Lcom/tencent/mm/plugin/appbrand/jsapi/al/c/f;
    //   178: astore_1
    //   179: aload_0
    //   180: astore 4
    //   182: aload_0
    //   183: checkcast 194	java/util/zip/ZipInputStream
    //   186: aload 6
    //   188: invokestatic 200	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:a	(Ljava/util/zip/ZipInputStream;Lcom/tencent/mm/vfs/u;)Lcom/tencent/mm/vfs/u;
    //   191: astore_1
    //   192: aload_0
    //   193: astore_2
    //   194: aload_1
    //   195: ifnonnull +14 -> 209
    //   198: aload_0
    //   199: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   202: ldc 156
    //   204: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: iconst_0
    //   208: ireturn
    //   209: aload_3
    //   210: ifnull +31 -> 241
    //   213: aload_2
    //   214: astore 4
    //   216: aload_3
    //   217: aload 6
    //   219: invokevirtual 206	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   222: invokestatic 212	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   225: invokeinterface 107 2 0
    //   230: aload_2
    //   231: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   234: ldc 156
    //   236: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: iconst_1
    //   240: ireturn
    //   241: aload_2
    //   242: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   245: ldc 156
    //   247: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   250: iconst_0
    //   251: ireturn
    //   252: astore_0
    //   253: aload 4
    //   255: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   258: ldc 156
    //   260: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_0
    //   264: athrow
    //   265: astore_0
    //   266: aload_1
    //   267: astore 4
    //   269: goto -16 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramf	com.tencent.mm.plugin.appbrand.jsapi.f
    //   0	272	1	paramString1	String
    //   0	272	2	paramString2	String
    //   0	272	3	parama	a
    //   8	260	4	localObject	Object
    //   44	88	5	localInputStream	InputStream
    //   15	203	6	localu	u
    // Exception table:
    //   from	to	target	type
    //   32	46	252	finally
    //   67	76	252	finally
    //   80	87	252	finally
    //   103	107	252	finally
    //   114	122	252	finally
    //   126	131	252	finally
    //   135	148	252	finally
    //   175	179	252	finally
    //   182	192	252	finally
    //   216	230	252	finally
    //   163	172	265	finally
  }
  
  private static boolean b(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, boolean paramBoolean, String paramString2, a parama)
  {
    AppMethodBeat.i(327112);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, url:%s", new Object[] { paramString1 });
    if (paramf == null)
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, component is null");
      AppMethodBeat.o(327112);
      return false;
    }
    if (paramBoolean)
    {
      paramBoolean = b(paramf, paramString1, paramString2, parama);
      AppMethodBeat.o(327112);
      return paramBoolean;
    }
    paramBoolean = c(paramf, paramString1, paramString2, parama);
    AppMethodBeat.o(327112);
    return paramBoolean;
  }
  
  private static u c(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(327138);
    Object localObject = f.sPB;
    localObject = f.j(paramf, paramString1);
    if (localObject == null)
    {
      AppMethodBeat.o(327138);
      return null;
    }
    for (;;)
    {
      try
      {
        String str = oqs + acH(new StringBuilder().append(paramf.getAppId()).append("_").append(paramString1).toString());
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath: ".concat(String.valueOf(str)));
        paramf = new u(str);
        if (paramf.jKS())
        {
          if (eB(paramString2, str))
          {
            i = 0;
            if (i != 0)
            {
              c(paramString1, paramf);
              if (!eB(paramString2, str))
              {
                Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath is invalid 2");
                paramf.diJ();
                AppMethodBeat.o(327138);
                return null;
              }
            }
          }
          else
          {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath is invalid 1");
            paramf.diJ();
            break label260;
          }
          paramString2 = f.sPB;
          if (!f.E((u)localObject))
          {
            paramf = new ZipInputStream(y.ao(paramf));
            paramString2 = f.sPB;
            if (f.a(paramf, (u)localObject) == null)
            {
              Util.qualityClose(paramf);
              AppMethodBeat.o(327138);
              return null;
            }
          }
        }
      }
      catch (Exception paramf)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandLiveFileLoadHelper", paramf, "download file url %s ", new Object[] { paramString1 });
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "download done");
        AppMethodBeat.o(327138);
        return localObject;
      }
      label260:
      int i = 1;
    }
  }
  
  /* Error */
  private static void c(String paramString, u paramu)
  {
    // Byte code:
    //   0: ldc_w 279
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 281	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 282	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 286	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 288	java/net/HttpURLConnection
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 292	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: astore 4
    //   27: aload_1
    //   28: invokestatic 296	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   31: astore 5
    //   33: new 298	java/io/BufferedInputStream
    //   36: dup
    //   37: aload 4
    //   39: invokespecial 299	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore 4
    //   44: sipush 16384
    //   47: newarray byte
    //   49: astore 6
    //   51: aload 4
    //   53: aload 6
    //   55: iconst_0
    //   56: sipush 16384
    //   59: invokevirtual 305	java/io/InputStream:read	([BII)I
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_m1
    //   65: if_icmpeq +68 -> 133
    //   68: aload 5
    //   70: aload 6
    //   72: iconst_0
    //   73: iload_2
    //   74: invokevirtual 311	java/io/OutputStream:write	([BII)V
    //   77: goto -26 -> 51
    //   80: astore 6
    //   82: aload_1
    //   83: invokevirtual 262	com/tencent/mm/vfs/u:diJ	()Z
    //   86: pop
    //   87: ldc 84
    //   89: aload 6
    //   91: ldc_w 272
    //   94: iconst_1
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_0
    //   101: aastore
    //   102: invokestatic 276	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: aload_3
    //   106: invokevirtual 292	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   109: invokevirtual 314	java/io/InputStream:close	()V
    //   112: aload 5
    //   114: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   117: aload 4
    //   119: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   122: aload_3
    //   123: invokevirtual 317	java/net/HttpURLConnection:disconnect	()V
    //   126: ldc_w 279
    //   129: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: return
    //   133: aload 5
    //   135: invokevirtual 320	java/io/OutputStream:flush	()V
    //   138: aload_3
    //   139: invokevirtual 292	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   142: invokevirtual 314	java/io/InputStream:close	()V
    //   145: aload 5
    //   147: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   150: aload 4
    //   152: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   155: aload_3
    //   156: invokevirtual 317	java/net/HttpURLConnection:disconnect	()V
    //   159: ldc_w 279
    //   162: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: astore_0
    //   167: ldc 84
    //   169: aload_0
    //   170: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: invokestatic 326	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: goto -31 -> 145
    //   179: astore_0
    //   180: ldc 84
    //   182: aload_0
    //   183: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: invokestatic 326	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -77 -> 112
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_3
    //   195: aconst_null
    //   196: astore 5
    //   198: aconst_null
    //   199: astore 4
    //   201: aload_3
    //   202: invokevirtual 292	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   205: invokevirtual 314	java/io/InputStream:close	()V
    //   208: aload 5
    //   210: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   213: aload 4
    //   215: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   218: aload_3
    //   219: invokevirtual 317	java/net/HttpURLConnection:disconnect	()V
    //   222: ldc_w 279
    //   225: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_0
    //   229: athrow
    //   230: astore_1
    //   231: ldc 84
    //   233: aload_1
    //   234: invokevirtual 323	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   237: invokestatic 326	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: goto -32 -> 208
    //   243: astore_0
    //   244: aconst_null
    //   245: astore 5
    //   247: aconst_null
    //   248: astore 4
    //   250: goto -49 -> 201
    //   253: astore_0
    //   254: aconst_null
    //   255: astore 4
    //   257: goto -56 -> 201
    //   260: astore_0
    //   261: goto -60 -> 201
    //   264: astore_0
    //   265: goto -64 -> 201
    //   268: astore 6
    //   270: aconst_null
    //   271: astore_3
    //   272: aconst_null
    //   273: astore 5
    //   275: aconst_null
    //   276: astore 4
    //   278: goto -196 -> 82
    //   281: astore 6
    //   283: aconst_null
    //   284: astore 5
    //   286: aconst_null
    //   287: astore 4
    //   289: goto -207 -> 82
    //   292: astore 6
    //   294: aconst_null
    //   295: astore 4
    //   297: goto -215 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramString	String
    //   0	300	1	paramu	u
    //   62	12	2	i	int
    //   20	252	3	localHttpURLConnection	java.net.HttpURLConnection
    //   25	271	4	localObject	Object
    //   31	254	5	localOutputStream	java.io.OutputStream
    //   49	22	6	arrayOfByte	byte[]
    //   80	10	6	localException1	Exception
    //   268	1	6	localException2	Exception
    //   281	1	6	localException3	Exception
    //   292	1	6	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   44	51	80	java/lang/Exception
    //   51	63	80	java/lang/Exception
    //   68	77	80	java/lang/Exception
    //   133	138	80	java/lang/Exception
    //   138	145	166	java/lang/Exception
    //   105	112	179	java/lang/Exception
    //   6	21	192	finally
    //   201	208	230	java/lang/Exception
    //   21	33	243	finally
    //   33	44	253	finally
    //   44	51	260	finally
    //   51	63	260	finally
    //   68	77	260	finally
    //   133	138	260	finally
    //   82	105	264	finally
    //   6	21	268	java/lang/Exception
    //   21	33	281	java/lang/Exception
    //   33	44	292	java/lang/Exception
  }
  
  private static boolean c(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(327124);
    paramf = paramf.getFileSystem().Wm(paramString1);
    if (paramf == null)
    {
      AppMethodBeat.o(327124);
      return false;
    }
    if (paramf.jKS())
    {
      paramf = ah.v(paramf.jKT());
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, localPath:%s", new Object[] { paramf });
      if ((eB(paramString2, paramf)) && (parama != null))
      {
        parama.onLoad(paramf);
        AppMethodBeat.o(327124);
        return true;
      }
    }
    AppMethodBeat.o(327124);
    return false;
  }
  
  private static boolean c(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, boolean paramBoolean, String paramString2, a parama)
  {
    AppMethodBeat.i(327126);
    if (paramBoolean)
    {
      paramBoolean = d(paramf, paramString1, paramString2, parama);
      AppMethodBeat.o(327126);
      return paramBoolean;
    }
    paramBoolean = e(paramf, paramString1, paramString2, parama);
    AppMethodBeat.o(327126);
    return paramBoolean;
  }
  
  private static void d(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final String paramString1, boolean paramBoolean, final String paramString2, final a parama)
  {
    AppMethodBeat.i(327136);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, url:%s", new Object[] { paramString1 });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139465);
        if (!b.aYC().containsKey(b.this)) {
          b.aYC().put(b.this, new ArrayList());
        }
        ((List)b.aYC().get(b.this)).add(parama);
        AppMethodBeat.o(139465);
      }
    });
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139466);
        if (this.sPw)
        {
          b.d(paramf, paramString1, paramString2);
          AppMethodBeat.o(139466);
          return;
        }
        b.eC(paramString1, paramString2);
        AppMethodBeat.o(139466);
      }
    }, "AppBrandLiveFileLoadHelperThread");
    AppMethodBeat.o(327136);
  }
  
  /* Error */
  private static boolean d(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: ldc_w 391
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 84
    //   8: ldc_w 393
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: invokestatic 218	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:sPB	Lcom/tencent/mm/plugin/appbrand/jsapi/al/c/f;
    //   25: astore 4
    //   27: aload_0
    //   28: aload_1
    //   29: invokestatic 166	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:j	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;Ljava/lang/String;)Lcom/tencent/mm/vfs/u;
    //   32: astore 6
    //   34: aload 6
    //   36: ifnonnull +11 -> 47
    //   39: ldc_w 391
    //   42: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: invokestatic 395	com/tencent/mm/plugin/appbrand/jsapi/al/c/b:M	(Lcom/tencent/mm/plugin/appbrand/jsapi/f;)Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnonnull +19 -> 74
    //   58: ldc 84
    //   60: ldc_w 397
    //   63: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 391
    //   69: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_0
    //   73: ireturn
    //   74: aload 7
    //   76: aload_1
    //   77: invokestatic 402	com/tencent/mm/plugin/appbrand/appcache/bl:f	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Ljava/io/InputStream;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnull +18 -> 102
    //   87: aload 5
    //   89: astore 4
    //   91: aload 5
    //   93: astore_0
    //   94: aload 5
    //   96: invokevirtual 406	java/io/InputStream:available	()I
    //   99: ifgt +36 -> 135
    //   102: aload 5
    //   104: astore 4
    //   106: aload 5
    //   108: astore_0
    //   109: ldc 84
    //   111: ldc_w 408
    //   114: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 5
    //   119: ifnull +8 -> 127
    //   122: aload 5
    //   124: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   127: ldc_w 391
    //   130: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 5
    //   137: astore 4
    //   139: aload 5
    //   141: astore_0
    //   142: aload_2
    //   143: aload 5
    //   145: invokestatic 186	com/tencent/mm/plugin/appbrand/jsapi/al/c/b:f	(Ljava/lang/String;Ljava/io/InputStream;)Z
    //   148: ifne +36 -> 184
    //   151: aload 5
    //   153: astore 4
    //   155: aload 5
    //   157: astore_0
    //   158: ldc 84
    //   160: ldc_w 410
    //   163: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload 5
    //   168: ifnull +8 -> 176
    //   171: aload 5
    //   173: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   176: ldc_w 391
    //   179: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iconst_0
    //   183: ireturn
    //   184: aload 5
    //   186: astore 4
    //   188: aload 5
    //   190: astore_0
    //   191: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:sPB	Lcom/tencent/mm/plugin/appbrand/jsapi/al/c/f;
    //   194: astore_2
    //   195: aload 5
    //   197: astore_2
    //   198: aload 5
    //   200: astore 4
    //   202: aload 5
    //   204: astore_0
    //   205: aload 6
    //   207: invokestatic 192	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:E	(Lcom/tencent/mm/vfs/u;)Z
    //   210: ifne +82 -> 292
    //   213: aload 5
    //   215: astore 4
    //   217: aload 5
    //   219: astore_0
    //   220: aload 5
    //   222: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   225: aload 5
    //   227: astore 4
    //   229: aload 5
    //   231: astore_0
    //   232: aload 7
    //   234: aload_1
    //   235: invokestatic 402	com/tencent/mm/plugin/appbrand/appcache/bl:f	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Ljava/io/InputStream;
    //   238: astore_2
    //   239: new 194	java/util/zip/ZipInputStream
    //   242: dup
    //   243: aload_2
    //   244: invokespecial 197	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   247: astore_1
    //   248: aload_1
    //   249: astore 4
    //   251: aload_1
    //   252: astore_0
    //   253: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:sPB	Lcom/tencent/mm/plugin/appbrand/jsapi/al/c/f;
    //   256: astore_2
    //   257: aload_1
    //   258: astore 4
    //   260: aload_1
    //   261: astore_0
    //   262: aload_1
    //   263: checkcast 194	java/util/zip/ZipInputStream
    //   266: aload 6
    //   268: invokestatic 200	com/tencent/mm/plugin/appbrand/jsapi/al/c/f:a	(Ljava/util/zip/ZipInputStream;Lcom/tencent/mm/vfs/u;)Lcom/tencent/mm/vfs/u;
    //   271: astore 5
    //   273: aload_1
    //   274: astore_2
    //   275: aload 5
    //   277: ifnonnull +15 -> 292
    //   280: aload_1
    //   281: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   284: ldc_w 391
    //   287: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: iconst_0
    //   291: ireturn
    //   292: aload_3
    //   293: ifnull +38 -> 331
    //   296: aload_2
    //   297: astore 4
    //   299: aload_2
    //   300: astore_0
    //   301: aload_3
    //   302: aload 6
    //   304: invokevirtual 206	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   307: invokestatic 212	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   310: invokeinterface 107 2 0
    //   315: aload_2
    //   316: ifnull +7 -> 323
    //   319: aload_2
    //   320: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   323: ldc_w 391
    //   326: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: iconst_1
    //   330: ireturn
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   339: ldc_w 391
    //   342: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: iconst_0
    //   346: ireturn
    //   347: astore_1
    //   348: aload 4
    //   350: astore_0
    //   351: ldc 84
    //   353: ldc_w 412
    //   356: aload_1
    //   357: invokestatic 241	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   360: invokevirtual 244	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   363: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: aload 4
    //   368: ifnull +8 -> 376
    //   371: aload 4
    //   373: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   376: ldc_w 391
    //   379: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   382: iconst_0
    //   383: ireturn
    //   384: astore_2
    //   385: aload_0
    //   386: astore_1
    //   387: aload_2
    //   388: astore_0
    //   389: aload_1
    //   390: ifnull +7 -> 397
    //   393: aload_1
    //   394: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   397: ldc_w 391
    //   400: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   403: aload_0
    //   404: athrow
    //   405: astore_0
    //   406: aload_2
    //   407: astore_1
    //   408: goto -19 -> 389
    //   411: astore_1
    //   412: aload_2
    //   413: astore 4
    //   415: goto -67 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramf	com.tencent.mm.plugin.appbrand.jsapi.f
    //   0	418	1	paramString1	String
    //   0	418	2	paramString2	String
    //   0	418	3	parama	a
    //   25	389	4	localObject1	Object
    //   80	196	5	localObject2	Object
    //   32	271	6	localu	u
    //   51	182	7	localAppBrandRuntime	AppBrandRuntime
    // Exception table:
    //   from	to	target	type
    //   94	102	347	java/lang/Exception
    //   109	117	347	java/lang/Exception
    //   142	151	347	java/lang/Exception
    //   158	166	347	java/lang/Exception
    //   191	195	347	java/lang/Exception
    //   205	213	347	java/lang/Exception
    //   220	225	347	java/lang/Exception
    //   232	239	347	java/lang/Exception
    //   253	257	347	java/lang/Exception
    //   262	273	347	java/lang/Exception
    //   301	315	347	java/lang/Exception
    //   94	102	384	finally
    //   109	117	384	finally
    //   142	151	384	finally
    //   158	166	384	finally
    //   191	195	384	finally
    //   205	213	384	finally
    //   220	225	384	finally
    //   232	239	384	finally
    //   253	257	384	finally
    //   262	273	384	finally
    //   301	315	384	finally
    //   351	366	384	finally
    //   239	248	405	finally
    //   239	248	411	java/lang/Exception
  }
  
  private static boolean e(com.tencent.mm.plugin.appbrand.jsapi.f paramf, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(139470);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url:%s", new Object[] { paramString1 });
    AppBrandRuntime localAppBrandRuntime = M(paramf);
    if (localAppBrandRuntime == null)
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, runtime is null");
      AppMethodBeat.o(139470);
      return false;
    }
    paramString1 = t.Ws(paramString1);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url is empty");
      AppMethodBeat.o(139470);
      return false;
    }
    paramf = acH(paramString1);
    String str = String.format("%s%s", new Object[] { oqs, paramf });
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, localPath:%s", new Object[] { str });
    if (!new u(str).jKS())
    {
      paramf = bl.f(localAppBrandRuntime, paramString1);
      if (paramf == null) {}
    }
    try
    {
      if (paramf.available() <= 0)
      {
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, stream is illegal");
        return false;
      }
      if (!f(paramString2, paramf))
      {
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, md5 is invalid");
        return false;
      }
      paramString1 = aa.l(localAppBrandRuntime, paramString1);
      if (paramString1 != null)
      {
        boolean bool = paramString1.isRecycled();
        if (!bool) {
          try
          {
            BitmapUtil.saveBitmapToImage(paramString1, 100, Bitmap.CompressFormat.PNG, str, true);
            if ((paramString1 != null) && (!paramString1.isRecycled()))
            {
              Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramString1 });
              paramString1.recycle();
            }
            if (paramf != null) {
              Util.qualityClose(paramf);
            }
            if (parama != null)
            {
              parama.onLoad(str);
              AppMethodBeat.o(139470);
              return true;
            }
          }
          catch (IOException paramString2)
          {
            Log.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail to compress bitmap to file", new Object[] { paramString2 });
            if ((paramString1 != null) && (!paramString1.isRecycled()))
            {
              Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramString1 });
              paramString1.recycle();
            }
            return false;
          }
          finally
          {
            if ((paramString1 != null) && (!paramString1.isRecycled()))
            {
              Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "bitmap recycle %s", new Object[] { paramString1 });
              paramString1.recycle();
            }
            AppMethodBeat.o(139470);
          }
        }
      }
      AppMethodBeat.o(139470);
    }
    catch (Exception paramString1)
    {
      Log.w("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, fail since ".concat(String.valueOf(paramString1)));
      return false;
      Log.e("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, no bitmap in the given url");
      return false;
    }
    finally
    {
      if (paramf != null) {
        Util.qualityClose(paramf);
      }
      AppMethodBeat.o(139470);
    }
    return false;
  }
  
  private static void eA(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(139471);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139467);
        b.eD(b.this, paramString2);
        AppMethodBeat.o(139467);
      }
    });
    AppMethodBeat.o(139471);
  }
  
  private static boolean eB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(139473);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
      AppMethodBeat.o(139473);
      return true;
    }
    paramString2 = g.getMD5(paramString2);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", new Object[] { paramString2, paramString1 });
    boolean bool = paramString1.equals(paramString2);
    AppMethodBeat.o(139473);
    return bool;
  }
  
  private static boolean f(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(327153);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
      AppMethodBeat.o(327153);
      return true;
    }
    paramInputStream = g.e(paramInputStream, 4096);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", new Object[] { paramInputStream, paramString });
    boolean bool = paramString.equals(paramInputStream);
    AppMethodBeat.o(327153);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void onLoad(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.b
 * JD-Core Version:    0.7.0.1
 */