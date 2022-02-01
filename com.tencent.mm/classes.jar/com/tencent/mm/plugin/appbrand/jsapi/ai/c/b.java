package com.tencent.mm.plugin.appbrand.jsapi.ai.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.bl;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
  private static final String lyR;
  private static ConcurrentMap<String, Boolean> pKA;
  private static Map<String, List<a>> pKB;
  
  static
  {
    AppMethodBeat.i(139476);
    pKA = new ConcurrentHashMap();
    pKB = new HashMap();
    String str2 = com.tencent.mm.loader.j.b.aSL();
    String str1 = str2;
    if (!str2.endsWith("/")) {
      str1 = str2 + "/";
    }
    str1 = str1 + "wxacache/";
    lyR = str1;
    FilePathGenerator.checkMkdir(str1);
    AppMethodBeat.o(139476);
  }
  
  private static AppBrandRuntime K(e parame)
  {
    AppMethodBeat.i(225235);
    if (parame == null)
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, component is null");
      AppMethodBeat.o(225235);
      return null;
    }
    if (!(parame instanceof j))
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, can not get runtime from component");
      AppMethodBeat.o(225235);
      return null;
    }
    parame = ((j)parame).getRuntime();
    if (parame == null) {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "getRuntime, runtime is null");
    }
    AppMethodBeat.o(225235);
    return parame;
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(139469);
    if (parama != null) {
      parama.dR(null);
    }
    AppMethodBeat.o(139469);
  }
  
  public static void a(e parame, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(139468);
    a(parame, paramString1, false, paramString2, parama);
    AppMethodBeat.o(139468);
  }
  
  public static void a(e parame, String paramString1, boolean paramBoolean, String paramString2, a parama)
  {
    AppMethodBeat.i(225164);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(225164);
      return;
    }
    if (parama == null)
    {
      AppMethodBeat.o(225164);
      return;
    }
    if (paramString1.startsWith("wxfile://"))
    {
      if (!b(parame, paramString1, paramBoolean, paramString2, parama))
      {
        a(parama);
        AppMethodBeat.o(225164);
      }
    }
    else
    {
      if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
      {
        d(parame, paramString1, paramBoolean, paramString2, parama);
        AppMethodBeat.o(225164);
        return;
      }
      if (!c(parame, paramString1, paramBoolean, paramString2, parama)) {
        a(parama);
      }
    }
    AppMethodBeat.o(225164);
  }
  
  private static String ajH(String paramString)
  {
    AppMethodBeat.i(225224);
    String str = null;
    if (!Util.isNullOrNil(paramString)) {
      str = g.getMessageDigest(paramString.getBytes());
    }
    AppMethodBeat.o(225224);
    return str;
  }
  
  /* Error */
  private static boolean b(e parame, String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: ldc 156
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:pKJ	Lcom/tencent/mm/plugin/appbrand/jsapi/ai/c/f;
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: invokestatic 166	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:k	(Lcom/tencent/mm/plugin/appbrand/jsapi/e;Ljava/lang/String;)Lcom/tencent/mm/vfs/q;
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
    //   70: invokestatic 185	com/tencent/mm/plugin/appbrand/jsapi/ai/c/b:d	(Ljava/lang/String;Ljava/io/InputStream;)Z
    //   73: ifne +26 -> 99
    //   76: aload 5
    //   78: astore 4
    //   80: ldc 84
    //   82: ldc 187
    //   84: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload 5
    //   89: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   92: ldc 156
    //   94: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iconst_0
    //   98: ireturn
    //   99: aload 5
    //   101: astore 4
    //   103: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:pKJ	Lcom/tencent/mm/plugin/appbrand/jsapi/ai/c/f;
    //   106: astore_2
    //   107: aload 5
    //   109: astore_2
    //   110: aload 5
    //   112: astore 4
    //   114: aload 6
    //   116: invokestatic 191	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:E	(Lcom/tencent/mm/vfs/q;)Z
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
    //   163: new 193	java/util/zip/ZipInputStream
    //   166: dup
    //   167: aload_1
    //   168: invokespecial 196	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   171: astore_0
    //   172: aload_0
    //   173: astore 4
    //   175: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:pKJ	Lcom/tencent/mm/plugin/appbrand/jsapi/ai/c/f;
    //   178: astore_1
    //   179: aload_0
    //   180: astore 4
    //   182: aload_0
    //   183: checkcast 193	java/util/zip/ZipInputStream
    //   186: aload 6
    //   188: invokestatic 199	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:a	(Ljava/util/zip/ZipInputStream;Lcom/tencent/mm/vfs/q;)Lcom/tencent/mm/vfs/q;
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
    //   210: ifnull +28 -> 238
    //   213: aload_2
    //   214: astore 4
    //   216: aload_3
    //   217: aload 6
    //   219: invokevirtual 204	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   222: invokeinterface 107 2 0
    //   227: aload_2
    //   228: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   231: ldc 156
    //   233: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: iconst_1
    //   237: ireturn
    //   238: aload_2
    //   239: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   242: ldc 156
    //   244: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   247: iconst_0
    //   248: ireturn
    //   249: astore_0
    //   250: aload 4
    //   252: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   255: ldc 156
    //   257: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload_0
    //   261: athrow
    //   262: astore_0
    //   263: aload_1
    //   264: astore 4
    //   266: goto -16 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	parame	e
    //   0	269	1	paramString1	String
    //   0	269	2	paramString2	String
    //   0	269	3	parama	a
    //   8	257	4	localObject	Object
    //   44	88	5	localInputStream	InputStream
    //   15	203	6	localq	q
    // Exception table:
    //   from	to	target	type
    //   32	46	249	finally
    //   67	76	249	finally
    //   80	87	249	finally
    //   103	107	249	finally
    //   114	122	249	finally
    //   126	131	249	finally
    //   135	148	249	finally
    //   175	179	249	finally
    //   182	192	249	finally
    //   216	227	249	finally
    //   163	172	262	finally
  }
  
  private static boolean b(e parame, String paramString1, boolean paramBoolean, String paramString2, a parama)
  {
    AppMethodBeat.i(225169);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, url:%s", new Object[] { paramString1 });
    if (parame == null)
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, component is null");
      AppMethodBeat.o(225169);
      return false;
    }
    if (paramBoolean)
    {
      paramBoolean = b(parame, paramString1, paramString2, parama);
      AppMethodBeat.o(225169);
      return paramBoolean;
    }
    paramBoolean = c(parame, paramString1, paramString2, parama);
    AppMethodBeat.o(225169);
    return paramBoolean;
  }
  
  private static q c(e parame, String paramString1, String paramString2)
  {
    AppMethodBeat.i(225202);
    Object localObject = f.pKJ;
    localObject = f.k(parame, paramString1);
    if (localObject == null)
    {
      AppMethodBeat.o(225202);
      return null;
    }
    for (;;)
    {
      try
      {
        String str = lyR + ajH(new StringBuilder().append(parame.getAppId()).append("_").append(paramString1).toString());
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath: ".concat(String.valueOf(str)));
        parame = new q(str);
        if (parame.ifE())
        {
          if (ei(paramString2, str))
          {
            i = 0;
            if (i != 0)
            {
              c(paramString1, parame);
              if (!ei(paramString2, str))
              {
                Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath is invalid 2");
                parame.cFq();
                AppMethodBeat.o(225202);
                return null;
              }
            }
          }
          else
          {
            Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "downloadAndUnzipInner, cachedZipPath is invalid 1");
            parame.cFq();
            break label259;
          }
          paramString2 = f.pKJ;
          if (!f.E((q)localObject))
          {
            parame = new ZipInputStream(u.al(parame));
            paramString2 = f.pKJ;
            if (f.a(parame, (q)localObject) == null)
            {
              Util.qualityClose(parame);
              AppMethodBeat.o(225202);
              return null;
            }
          }
        }
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.AppBrandLiveFileLoadHelper", parame, "download file url %s ", new Object[] { paramString1 });
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "download done");
        AppMethodBeat.o(225202);
        return localObject;
      }
      label259:
      int i = 1;
    }
  }
  
  /* Error */
  private static void c(String paramString, q paramq)
  {
    // Byte code:
    //   0: ldc_w 271
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 273	java/net/URL
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 274	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 278	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   17: checkcast 280	java/net/HttpURLConnection
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 284	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   25: astore 4
    //   27: aload_1
    //   28: invokestatic 288	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   31: astore 5
    //   33: new 290	java/io/BufferedInputStream
    //   36: dup
    //   37: aload 4
    //   39: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: astore 4
    //   44: sipush 16384
    //   47: newarray byte
    //   49: astore 6
    //   51: aload 4
    //   53: aload 6
    //   55: iconst_0
    //   56: sipush 16384
    //   59: invokevirtual 297	java/io/InputStream:read	([BII)I
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_m1
    //   65: if_icmpeq +68 -> 133
    //   68: aload 5
    //   70: aload 6
    //   72: iconst_0
    //   73: iload_2
    //   74: invokevirtual 303	java/io/OutputStream:write	([BII)V
    //   77: goto -26 -> 51
    //   80: astore 6
    //   82: aload_1
    //   83: invokevirtual 254	com/tencent/mm/vfs/q:cFq	()Z
    //   86: pop
    //   87: ldc 84
    //   89: aload 6
    //   91: ldc_w 264
    //   94: iconst_1
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_0
    //   101: aastore
    //   102: invokestatic 268	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: aload_3
    //   106: invokevirtual 284	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   109: invokevirtual 306	java/io/InputStream:close	()V
    //   112: aload 5
    //   114: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   117: aload 4
    //   119: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   122: aload_3
    //   123: invokevirtual 309	java/net/HttpURLConnection:disconnect	()V
    //   126: ldc_w 271
    //   129: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: return
    //   133: aload 5
    //   135: invokevirtual 312	java/io/OutputStream:flush	()V
    //   138: aload_3
    //   139: invokevirtual 284	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   142: invokevirtual 306	java/io/InputStream:close	()V
    //   145: aload 5
    //   147: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   150: aload 4
    //   152: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   155: aload_3
    //   156: invokevirtual 309	java/net/HttpURLConnection:disconnect	()V
    //   159: ldc_w 271
    //   162: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: return
    //   166: astore_0
    //   167: ldc 84
    //   169: aload_0
    //   170: invokevirtual 315	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: goto -31 -> 145
    //   179: astore_0
    //   180: ldc 84
    //   182: aload_0
    //   183: invokevirtual 315	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   186: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: goto -77 -> 112
    //   192: astore_0
    //   193: aconst_null
    //   194: astore_3
    //   195: aconst_null
    //   196: astore 5
    //   198: aconst_null
    //   199: astore 4
    //   201: aload_3
    //   202: invokevirtual 284	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   205: invokevirtual 306	java/io/InputStream:close	()V
    //   208: aload 5
    //   210: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   213: aload 4
    //   215: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   218: aload_3
    //   219: invokevirtual 309	java/net/HttpURLConnection:disconnect	()V
    //   222: ldc_w 271
    //   225: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: aload_0
    //   229: athrow
    //   230: astore_1
    //   231: ldc 84
    //   233: aload_1
    //   234: invokevirtual 315	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   237: invokestatic 318	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	300	1	paramq	q
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
  
  private static boolean c(e parame, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(225181);
    parame = parame.getFileSystem().adL(paramString1);
    if (parame == null)
    {
      AppMethodBeat.o(225181);
      return false;
    }
    if (parame.ifE())
    {
      parame = parame.bOF();
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleWxfile, localPath:%s", new Object[] { parame });
      if ((ei(paramString2, parame)) && (parama != null))
      {
        parama.dR(parame);
        AppMethodBeat.o(225181);
        return true;
      }
    }
    AppMethodBeat.o(225181);
    return false;
  }
  
  private static boolean c(e parame, String paramString1, boolean paramBoolean, String paramString2, a parama)
  {
    AppMethodBeat.i(225184);
    if (paramBoolean)
    {
      paramBoolean = d(parame, paramString1, paramString2, parama);
      AppMethodBeat.o(225184);
      return paramBoolean;
    }
    paramBoolean = e(parame, paramString1, paramString2, parama);
    AppMethodBeat.o(225184);
    return paramBoolean;
  }
  
  private static void d(final e parame, final String paramString1, boolean paramBoolean, final String paramString2, final a parama)
  {
    AppMethodBeat.i(225198);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handleNetworkFile, url:%s", new Object[] { paramString1 });
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139465);
        if (!b.pKB.containsKey(this.val$url)) {
          b.pKB.put(this.val$url, new ArrayList());
        }
        ((List)b.pKB.get(this.val$url)).add(parama);
        AppMethodBeat.o(139465);
      }
    });
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139466);
        if (this.pKD)
        {
          b.d(parame, paramString1, paramString2);
          AppMethodBeat.o(139466);
          return;
        }
        b.ej(paramString1, paramString2);
        AppMethodBeat.o(139466);
      }
    }, "AppBrandLiveFileLoadHelperThread");
    AppMethodBeat.o(225198);
  }
  
  /* Error */
  private static boolean d(e parame, String paramString1, String paramString2, a parama)
  {
    // Byte code:
    //   0: ldc_w 383
    //   3: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 84
    //   8: ldc_w 385
    //   11: iconst_1
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:pKJ	Lcom/tencent/mm/plugin/appbrand/jsapi/ai/c/f;
    //   25: astore 4
    //   27: aload_0
    //   28: aload_1
    //   29: invokestatic 166	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:k	(Lcom/tencent/mm/plugin/appbrand/jsapi/e;Ljava/lang/String;)Lcom/tencent/mm/vfs/q;
    //   32: astore 6
    //   34: aload 6
    //   36: ifnonnull +11 -> 47
    //   39: ldc_w 383
    //   42: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_0
    //   46: ireturn
    //   47: aload_0
    //   48: invokestatic 387	com/tencent/mm/plugin/appbrand/jsapi/ai/c/b:K	(Lcom/tencent/mm/plugin/appbrand/jsapi/e;)Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnonnull +19 -> 74
    //   58: ldc 84
    //   60: ldc_w 389
    //   63: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc_w 383
    //   69: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: iconst_0
    //   73: ireturn
    //   74: aload 7
    //   76: aload_1
    //   77: invokestatic 395	com/tencent/mm/plugin/appbrand/appcache/bl:f	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Ljava/io/InputStream;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnull +18 -> 102
    //   87: aload 5
    //   89: astore 4
    //   91: aload 5
    //   93: astore_0
    //   94: aload 5
    //   96: invokevirtual 399	java/io/InputStream:available	()I
    //   99: ifgt +36 -> 135
    //   102: aload 5
    //   104: astore 4
    //   106: aload 5
    //   108: astore_0
    //   109: ldc 84
    //   111: ldc_w 401
    //   114: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 5
    //   119: ifnull +8 -> 127
    //   122: aload 5
    //   124: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   127: ldc_w 383
    //   130: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload 5
    //   137: astore 4
    //   139: aload 5
    //   141: astore_0
    //   142: aload_2
    //   143: aload 5
    //   145: invokestatic 185	com/tencent/mm/plugin/appbrand/jsapi/ai/c/b:d	(Ljava/lang/String;Ljava/io/InputStream;)Z
    //   148: ifne +36 -> 184
    //   151: aload 5
    //   153: astore 4
    //   155: aload 5
    //   157: astore_0
    //   158: ldc 84
    //   160: ldc_w 403
    //   163: invokestatic 91	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: aload 5
    //   168: ifnull +8 -> 176
    //   171: aload 5
    //   173: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   176: ldc_w 383
    //   179: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iconst_0
    //   183: ireturn
    //   184: aload 5
    //   186: astore 4
    //   188: aload 5
    //   190: astore_0
    //   191: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:pKJ	Lcom/tencent/mm/plugin/appbrand/jsapi/ai/c/f;
    //   194: astore_2
    //   195: aload 5
    //   197: astore_2
    //   198: aload 5
    //   200: astore 4
    //   202: aload 5
    //   204: astore_0
    //   205: aload 6
    //   207: invokestatic 191	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:E	(Lcom/tencent/mm/vfs/q;)Z
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
    //   235: invokestatic 395	com/tencent/mm/plugin/appbrand/appcache/bl:f	(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;Ljava/lang/String;)Ljava/io/InputStream;
    //   238: astore_2
    //   239: new 193	java/util/zip/ZipInputStream
    //   242: dup
    //   243: aload_2
    //   244: invokespecial 196	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   247: astore_1
    //   248: aload_1
    //   249: astore 4
    //   251: aload_1
    //   252: astore_0
    //   253: getstatic 162	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:pKJ	Lcom/tencent/mm/plugin/appbrand/jsapi/ai/c/f;
    //   256: astore_2
    //   257: aload_1
    //   258: astore 4
    //   260: aload_1
    //   261: astore_0
    //   262: aload_1
    //   263: checkcast 193	java/util/zip/ZipInputStream
    //   266: aload 6
    //   268: invokestatic 199	com/tencent/mm/plugin/appbrand/jsapi/ai/c/f:a	(Ljava/util/zip/ZipInputStream;Lcom/tencent/mm/vfs/q;)Lcom/tencent/mm/vfs/q;
    //   271: astore 5
    //   273: aload_1
    //   274: astore_2
    //   275: aload 5
    //   277: ifnonnull +15 -> 292
    //   280: aload_1
    //   281: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   284: ldc_w 383
    //   287: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   290: iconst_0
    //   291: ireturn
    //   292: aload_3
    //   293: ifnull +35 -> 328
    //   296: aload_2
    //   297: astore 4
    //   299: aload_2
    //   300: astore_0
    //   301: aload_3
    //   302: aload 6
    //   304: invokevirtual 204	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   307: invokeinterface 107 2 0
    //   312: aload_2
    //   313: ifnull +7 -> 320
    //   316: aload_2
    //   317: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   320: ldc_w 383
    //   323: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   326: iconst_1
    //   327: ireturn
    //   328: aload_2
    //   329: ifnull +7 -> 336
    //   332: aload_2
    //   333: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   336: ldc_w 383
    //   339: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   342: iconst_0
    //   343: ireturn
    //   344: astore_1
    //   345: aload 4
    //   347: astore_0
    //   348: ldc 84
    //   350: ldc_w 405
    //   353: aload_1
    //   354: invokestatic 233	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   357: invokevirtual 236	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   360: invokestatic 408	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload 4
    //   365: ifnull +8 -> 373
    //   368: aload 4
    //   370: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   373: ldc_w 383
    //   376: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   379: iconst_0
    //   380: ireturn
    //   381: astore_2
    //   382: aload_0
    //   383: astore_1
    //   384: aload_2
    //   385: astore_0
    //   386: aload_1
    //   387: ifnull +7 -> 394
    //   390: aload_1
    //   391: invokestatic 182	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   394: ldc_w 383
    //   397: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: aload_0
    //   401: athrow
    //   402: astore_0
    //   403: aload_2
    //   404: astore_1
    //   405: goto -19 -> 386
    //   408: astore_1
    //   409: aload_2
    //   410: astore 4
    //   412: goto -67 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	415	0	parame	e
    //   0	415	1	paramString1	String
    //   0	415	2	paramString2	String
    //   0	415	3	parama	a
    //   25	386	4	localObject1	Object
    //   80	196	5	localObject2	Object
    //   32	271	6	localq	q
    //   51	182	7	localAppBrandRuntime	AppBrandRuntime
    // Exception table:
    //   from	to	target	type
    //   94	102	344	java/lang/Exception
    //   109	117	344	java/lang/Exception
    //   142	151	344	java/lang/Exception
    //   158	166	344	java/lang/Exception
    //   191	195	344	java/lang/Exception
    //   205	213	344	java/lang/Exception
    //   220	225	344	java/lang/Exception
    //   232	239	344	java/lang/Exception
    //   253	257	344	java/lang/Exception
    //   262	273	344	java/lang/Exception
    //   301	312	344	java/lang/Exception
    //   94	102	381	finally
    //   109	117	381	finally
    //   142	151	381	finally
    //   158	166	381	finally
    //   191	195	381	finally
    //   205	213	381	finally
    //   220	225	381	finally
    //   232	239	381	finally
    //   253	257	381	finally
    //   262	273	381	finally
    //   301	312	381	finally
    //   348	363	381	finally
    //   239	248	402	finally
    //   239	248	408	java/lang/Exception
  }
  
  private static boolean d(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(225232);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid target nil, no check");
      AppMethodBeat.o(225232);
      return true;
    }
    paramInputStream = g.b(paramInputStream, 4096);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "isMd5Valid file:%s target:%s", new Object[] { paramInputStream, paramString });
    boolean bool = paramString.equals(paramInputStream);
    AppMethodBeat.o(225232);
    return bool;
  }
  
  private static boolean e(e parame, String paramString1, String paramString2, a parama)
  {
    AppMethodBeat.i(139470);
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url:%s", new Object[] { paramString1 });
    AppBrandRuntime localAppBrandRuntime = K(parame);
    if (localAppBrandRuntime == null)
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, runtime is null");
      AppMethodBeat.o(139470);
      return false;
    }
    paramString1 = o.adR(paramString1);
    if (Util.isNullOrNil(paramString1))
    {
      Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, url is empty");
      AppMethodBeat.o(139470);
      return false;
    }
    parame = ajH(paramString1);
    String str = String.format("%s%s", new Object[] { lyR, parame });
    Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, localPath:%s", new Object[] { str });
    if (!new q(str).ifE())
    {
      parame = bl.f(localAppBrandRuntime, paramString1);
      if (parame == null) {}
    }
    try
    {
      if (parame.available() <= 0)
      {
        Log.i("MicroMsg.AppBrandLiveFileLoadHelper", "handlePackageImage, stream is illegal");
        return false;
      }
      if (!d(paramString2, parame))
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
            if (parame != null) {
              Util.qualityClose(parame);
            }
            if (parama != null)
            {
              parama.dR(str);
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
      if (parame != null) {
        Util.qualityClose(parame);
      }
      AppMethodBeat.o(139470);
    }
    return false;
  }
  
  private static void eh(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(139471);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139467);
        b.ek(this.val$url, paramString2);
        AppMethodBeat.o(139467);
      }
    });
    AppMethodBeat.o(139471);
  }
  
  private static boolean ei(String paramString1, String paramString2)
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
  
  public static abstract interface a
  {
    public abstract void dR(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.b
 * JD-Core Version:    0.7.0.1
 */