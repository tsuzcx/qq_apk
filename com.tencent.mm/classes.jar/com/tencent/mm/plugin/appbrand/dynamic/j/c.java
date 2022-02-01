package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.k;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.xweb.WebResourceResponse;
import java.io.InputStream;

public final class c
{
  private static final String[] kMx = ay.kMx;
  
  /* Error */
  private static WebResourceResponse dd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 19
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 27	com/tencent/mm/plugin/appbrand/appcache/WxaPkg
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 31	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 35	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:bvf	()Z
    //   18: pop
    //   19: aload_3
    //   20: aload_1
    //   21: invokevirtual 39	com/tencent/mm/plugin/appbrand/appcache/WxaPkg:UR	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: astore_2
    //   25: aload_1
    //   26: invokestatic 45	com/tencent/mm/sdk/system/MimeTypeUtil:getMimeTypeByFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_1
    //   30: aload_3
    //   31: invokestatic 51	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   34: new 53	com/tencent/xweb/WebResourceResponse
    //   37: dup
    //   38: aload_1
    //   39: ldc 55
    //   41: aload_2
    //   42: invokespecial 58	com/tencent/xweb/WebResourceResponse:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   45: astore_1
    //   46: ldc 19
    //   48: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   51: aload_1
    //   52: areturn
    //   53: astore_1
    //   54: aconst_null
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_3
    //   58: ldc 63
    //   60: ldc 65
    //   62: iconst_2
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_0
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload_1
    //   73: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   76: aastore
    //   77: invokestatic 75	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload_3
    //   81: invokestatic 51	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   84: aload_2
    //   85: invokestatic 51	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   88: ldc 19
    //   90: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_2
    //   98: goto -40 -> 58
    //   101: astore_1
    //   102: goto -44 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramString1	String
    //   0	105	1	paramString2	String
    //   24	74	2	localInputStream	InputStream
    //   13	68	3	localWxaPkg	com.tencent.mm.plugin.appbrand.appcache.WxaPkg
    // Exception table:
    //   from	to	target	type
    //   5	14	53	java/lang/Exception
    //   14	25	95	java/lang/Exception
    //   25	46	101	java/lang/Exception
  }
  
  private static WebResourceResponse de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121479);
    Object localObject = k.Ys(paramString1);
    if (localObject != null) {}
    for (localObject = ((WxaWidgetContext)localObject).bBO(); localObject == null; localObject = null)
    {
      Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", new Object[] { paramString1 });
      AppMethodBeat.o(121479);
      return null;
    }
    if (Util.isNullOrNil(((WxaPkgWrappingInfo)localObject).pkgPath))
    {
      Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", new Object[] { ((WxaPkgWrappingInfo)localObject).pkgPath, paramString1 });
      AppMethodBeat.o(121479);
      return null;
    }
    localObject = ((WxaPkgWrappingInfo)localObject).pkgPath;
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
      AppMethodBeat.o(121479);
      return null;
    }
    Log.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", new Object[] { paramString1, paramString2 });
    paramString1 = dd((String)localObject, paramString2);
    AppMethodBeat.o(121479);
    return paramString1;
  }
  
  private static WebResourceResponse df(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121480);
    Object localObject = k.Ys(paramString1);
    if (localObject != null) {}
    for (localObject = ((WxaWidgetContext)localObject).bBP(); localObject == null; localObject = null)
    {
      AppMethodBeat.o(121480);
      return null;
    }
    if (((WxaPkgWrappingInfo)localObject).kNY)
    {
      paramString1 = ay.openRead(paramString2);
      if (paramString1 != null)
      {
        paramString1 = new WebResourceResponse(MimeTypeUtil.getMimeTypeByFilePath(paramString2), "UTF-8", paramString1);
        AppMethodBeat.o(121480);
        return paramString1;
      }
      AppMethodBeat.o(121480);
      return null;
    }
    if (Util.isNullOrNil(((WxaPkgWrappingInfo)localObject).pkgPath))
    {
      Log.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", new Object[] { ((WxaPkgWrappingInfo)localObject).pkgPath });
      AppMethodBeat.o(121480);
      return null;
    }
    Log.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", new Object[] { paramString1, paramString2 });
    paramString1 = dd(((WxaPkgWrappingInfo)localObject).pkgPath, paramString2);
    AppMethodBeat.o(121480);
    return paramString1;
  }
  
  public static String dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121481);
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(121481);
      return "";
    }
    WebResourceResponse localWebResourceResponse = dh(paramString1, paramString2);
    if ((localWebResourceResponse != null) && (localWebResourceResponse.mInputStream != null)) {
      try
      {
        Log.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", new Object[] { Integer.valueOf(localWebResourceResponse.mInputStream.available()), paramString2 });
        paramString1 = d.convertStreamToString(localWebResourceResponse.mInputStream);
        AppMethodBeat.o(121481);
        return paramString1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", new Object[] { localException, paramString1, paramString2 });
        }
      }
    }
    Log.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(121481);
    return "";
  }
  
  public static WebResourceResponse dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121482);
    Log.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(121482);
      return null;
    }
    if (z.C(paramString2, "about:blank"))
    {
      AppMethodBeat.o(121482);
      return null;
    }
    if (!d.afC(paramString2))
    {
      paramString2 = n.We(paramString2);
      if (a.contains(kMx, paramString2))
      {
        paramString1 = df(paramString1, paramString2);
        AppMethodBeat.o(121482);
        return paramString1;
      }
      paramString2 = de(paramString1, paramString2);
      if (paramString2 == null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("id", paramString1);
        localBundle.putInt("widgetState", 2102);
        h.a(i.bBL().Yn(paramString1), localBundle, f.a.class, null);
      }
      AppMethodBeat.o(121482);
      return paramString2;
    }
    AppMethodBeat.o(121482);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.c
 * JD-Core Version:    0.7.0.1
 */