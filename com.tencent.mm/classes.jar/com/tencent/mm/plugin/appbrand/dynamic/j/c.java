package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.s;
import java.io.InputStream;

public final class c
{
  private static final String[] gVC = an.gVC;
  
  /* Error */
  private static s bR(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 10997
    //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 26	com/tencent/mm/plugin/appbrand/appcache/ao
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 30	com/tencent/mm/plugin/appbrand/appcache/ao:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: invokevirtual 34	com/tencent/mm/plugin/appbrand/appcache/ao:avO	()Z
    //   19: pop
    //   20: aload_3
    //   21: aload_1
    //   22: invokevirtual 38	com/tencent/mm/plugin/appbrand/appcache/ao:yw	(Ljava/lang/String;)Ljava/io/InputStream;
    //   25: astore_2
    //   26: aload_1
    //   27: invokestatic 44	com/tencent/mm/sdk/f/c:amX	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_1
    //   31: aload_3
    //   32: invokestatic 50	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   35: new 52	com/tencent/xweb/s
    //   38: dup
    //   39: aload_1
    //   40: ldc 54
    //   42: aload_2
    //   43: invokespecial 57	com/tencent/xweb/s:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   46: astore_1
    //   47: sipush 10997
    //   50: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_3
    //   60: ldc 62
    //   62: ldc 64
    //   64: iconst_2
    //   65: anewarray 4	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: aload_0
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload_1
    //   75: invokestatic 68	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   78: aastore
    //   79: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload_3
    //   83: invokestatic 50	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   86: aload_2
    //   87: invokestatic 50	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   90: sipush 10997
    //   93: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_2
    //   101: goto -41 -> 60
    //   104: astore_1
    //   105: goto -45 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramString1	String
    //   0	108	1	paramString2	String
    //   25	76	2	localInputStream	InputStream
    //   14	69	3	localao	com.tencent.mm.plugin.appbrand.appcache.ao
    // Exception table:
    //   from	to	target	type
    //   6	15	55	java/lang/Exception
    //   15	26	98	java/lang/Exception
    //   26	47	104	java/lang/Exception
  }
  
  private static s bS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10998);
    Object localObject = com.tencent.mm.plugin.appbrand.dynamic.k.Bd(paramString1);
    if (localObject != null) {}
    for (localObject = ((WxaWidgetContext)localObject).azE(); localObject == null; localObject = null)
    {
      ab.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", new Object[] { paramString1 });
      AppMethodBeat.o(10998);
      return null;
    }
    if (bo.isNullOrNil(((WxaPkgWrappingInfo)localObject).gUy))
    {
      ab.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", new Object[] { ((WxaPkgWrappingInfo)localObject).gUy, paramString1 });
      AppMethodBeat.o(10998);
      return null;
    }
    localObject = ((WxaPkgWrappingInfo)localObject).gUy;
    if (bo.isNullOrNil((String)localObject))
    {
      ab.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
      AppMethodBeat.o(10998);
      return null;
    }
    ab.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", new Object[] { paramString1, paramString2 });
    paramString1 = bR((String)localObject, paramString2);
    AppMethodBeat.o(10998);
    return paramString1;
  }
  
  private static s bT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(10999);
    Object localObject = com.tencent.mm.plugin.appbrand.dynamic.k.Bd(paramString1);
    if (localObject != null) {}
    for (localObject = ((WxaWidgetContext)localObject).azF(); localObject == null; localObject = null)
    {
      AppMethodBeat.o(10999);
      return null;
    }
    if (((WxaPkgWrappingInfo)localObject).gXh)
    {
      paramString1 = an.openRead(paramString2);
      if (paramString1 != null)
      {
        paramString1 = new s(com.tencent.mm.sdk.f.c.amX(paramString2), "UTF-8", paramString1);
        AppMethodBeat.o(10999);
        return paramString1;
      }
      AppMethodBeat.o(10999);
      return null;
    }
    if (bo.isNullOrNil(((WxaPkgWrappingInfo)localObject).gUy))
    {
      ab.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", new Object[] { ((WxaPkgWrappingInfo)localObject).gUy });
      AppMethodBeat.o(10999);
      return null;
    }
    ab.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", new Object[] { paramString1, paramString2 });
    paramString1 = bR(((WxaPkgWrappingInfo)localObject).gUy, paramString2);
    AppMethodBeat.o(10999);
    return paramString1;
  }
  
  public static String bU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11000);
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(11000);
      return "";
    }
    s locals = bV(paramString1, paramString2);
    if ((locals != null) && (locals.mInputStream != null)) {
      try
      {
        ab.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", new Object[] { Integer.valueOf(locals.mInputStream.available()), paramString2 });
        paramString1 = d.convertStreamToString(locals.mInputStream);
        AppMethodBeat.o(11000);
        return paramString1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", new Object[] { localException, paramString1, paramString2 });
        }
      }
    }
    ab.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(11000);
    return "";
  }
  
  public static s bV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(11001);
    ab.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", new Object[] { paramString1, paramString2 });
    if (bo.isNullOrNil(paramString2))
    {
      AppMethodBeat.o(11001);
      return null;
    }
    if (u.x(paramString2, "about:blank"))
    {
      AppMethodBeat.o(11001);
      return null;
    }
    if (!d.Fl(paramString2))
    {
      paramString2 = com.tencent.mm.plugin.appbrand.appstorage.k.zl(paramString2);
      if (a.contains(gVC, paramString2))
      {
        paramString1 = bT(paramString1, paramString2);
        AppMethodBeat.o(11001);
        return paramString1;
      }
      paramString2 = bS(paramString1, paramString2);
      if (paramString2 == null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("id", paramString1);
        localBundle.putInt("widgetState", 2102);
        f.a(i.azB().AY(paramString1), localBundle, f.a.class, null);
      }
      AppMethodBeat.o(11001);
      return paramString2;
    }
    AppMethodBeat.o(11001);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.c
 * JD-Core Version:    0.7.0.1
 */