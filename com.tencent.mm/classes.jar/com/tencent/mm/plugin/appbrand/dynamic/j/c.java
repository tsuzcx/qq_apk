package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.f.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.k;
import com.tencent.mm.plugin.appbrand.u.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.m;
import java.io.InputStream;

public final class c
{
  private static final String[] fDn = ah.fDn;
  
  /* Error */
  private static m bp(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 20	com/tencent/mm/plugin/appbrand/appcache/ai
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 24	com/tencent/mm/plugin/appbrand/appcache/ai:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 28	com/tencent/mm/plugin/appbrand/appcache/ai:abX	()Z
    //   13: pop
    //   14: aload_3
    //   15: aload_1
    //   16: invokevirtual 32	com/tencent/mm/plugin/appbrand/appcache/ai:rb	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_1
    //   21: invokestatic 38	com/tencent/mm/pluginsdk/ui/tools/s:wK	(Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_3
    //   26: invokestatic 44	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   29: new 46	com/tencent/xweb/m
    //   32: dup
    //   33: aload_1
    //   34: ldc 48
    //   36: aload_2
    //   37: invokespecial 51	com/tencent/xweb/m:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   40: astore_1
    //   41: aload_1
    //   42: areturn
    //   43: astore_1
    //   44: aconst_null
    //   45: astore_2
    //   46: aconst_null
    //   47: astore_3
    //   48: ldc 53
    //   50: ldc 55
    //   52: iconst_2
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_0
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_1
    //   63: invokestatic 59	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   66: aastore
    //   67: invokestatic 65	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_3
    //   71: invokestatic 44	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   74: aload_2
    //   75: invokestatic 44	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_1
    //   81: aconst_null
    //   82: astore_2
    //   83: goto -35 -> 48
    //   86: astore_1
    //   87: goto -39 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramString1	String
    //   0	90	1	paramString2	String
    //   19	64	2	localInputStream	InputStream
    //   8	63	3	localai	com.tencent.mm.plugin.appbrand.appcache.ai
    // Exception table:
    //   from	to	target	type
    //   0	9	43	java/lang/Exception
    //   9	20	80	java/lang/Exception
    //   20	41	86	java/lang/Exception
  }
  
  public static String bq(String paramString1, String paramString2)
  {
    if (bk.bl(paramString2)) {
      return "";
    }
    m localm = br(paramString1, paramString2);
    if (localm != null) {
      try
      {
        y.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", new Object[] { Integer.valueOf(localm.mInputStream.available()), paramString2 });
        return d.convertStreamToString(localm.mInputStream);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", new Object[] { localException, paramString1, paramString2 });
        }
      }
    }
    y.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", new Object[] { paramString1, paramString2 });
    return "";
  }
  
  public static m br(String paramString1, String paramString2)
  {
    y.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", new Object[] { paramString1, paramString2 });
    if (bk.bl(paramString2)) {}
    Object localObject;
    label113:
    for (;;)
    {
      return null;
      if ((!s.n(paramString2, "about:blank")) && (!d.wD(paramString2)))
      {
        localObject = com.tencent.mm.plugin.appbrand.appcache.a.qR(paramString2);
        if (!com.tencent.mm.compatible.loader.a.a(fDn, localObject)) {
          break label173;
        }
        paramString2 = k.tb(paramString1);
        if (paramString2 != null) {}
        for (paramString2 = paramString2.afb();; paramString2 = null)
        {
          if (paramString2 == null) {
            break label113;
          }
          if (!paramString2.fEP) {
            break label115;
          }
          paramString1 = ah.openRead((String)localObject);
          if (paramString1 == null) {
            break;
          }
          return new m(s.wK((String)localObject), "UTF-8", paramString1);
        }
      }
    }
    label115:
    if (bk.bl(paramString2.fCl))
    {
      y.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] is Null Or Nil", new Object[] { paramString2.fCl });
      return null;
    }
    y.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s)", new Object[] { paramString1, localObject });
    return bp(paramString2.fCl, (String)localObject);
    label173:
    paramString2 = k.tb(paramString1);
    if (paramString2 != null)
    {
      paramString2 = paramString2.afa();
      if (paramString2 != null) {
        break label260;
      }
      y.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", new Object[] { paramString1 });
      paramString2 = null;
    }
    for (;;)
    {
      if (paramString2 == null)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("id", paramString1);
        ((Bundle)localObject).putInt("widgetState", 2102);
        f.a(i.aeX().sX(paramString1), (Parcelable)localObject, f.a.class, null);
      }
      return paramString2;
      paramString2 = null;
      break;
      label260:
      if (bk.bl(paramString2.fCl))
      {
        y.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] by appId %s", new Object[] { paramString2.fCl, paramString1 });
        paramString2 = null;
      }
      else
      {
        paramString2 = paramString2.fCl;
        if (bk.bl(paramString2))
        {
          y.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
          paramString2 = null;
        }
        else
        {
          y.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s)", new Object[] { paramString1, localObject });
          paramString2 = bp(paramString2, (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.j.c
 * JD-Core Version:    0.7.0.1
 */