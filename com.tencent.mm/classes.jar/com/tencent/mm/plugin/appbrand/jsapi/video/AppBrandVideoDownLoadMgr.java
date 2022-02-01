package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.f.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import com.tencent.mm.u.c;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr
{
  private static HashMap<String, String> lkA;
  static final Map<String, a> lkB;
  public static AppBrandVideoDownLoadMgr lkC;
  static com.tencent.mm.u.d lkD;
  public static final String lkz;
  
  static
  {
    AppMethodBeat.i(46861);
    lkA = new HashMap();
    lkB = new ConcurrentHashMap();
    lkC = null;
    lkD = null;
    if (lkC == null) {
      lkC = new AppBrandVideoDownLoadMgr();
    }
    String str = b.arU();
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    lkz = (String)localObject + "wagamefiles/";
    com.tencent.mm.u.d.a(com.tencent.mm.plugin.cdndownloader.h.a.bZc());
    localObject = new com.tencent.mm.u.d();
    lkD = (com.tencent.mm.u.d)localObject;
    ((com.tencent.mm.u.d)localObject).gfu = new c()
    {
      public final void onTaskFail(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46851);
        ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.lkC;
        AppBrandVideoDownLoadMgr.as(paramAnonymousString, false);
        if ((AppBrandVideoDownLoadMgr.aaT() != null) && (AppBrandVideoDownLoadMgr.aaT().get(paramAnonymousString) != null) && (((a)AppBrandVideoDownLoadMgr.aaT().get(paramAnonymousString)).lky != null))
        {
          ((a)AppBrandVideoDownLoadMgr.aaT().get(paramAnonymousString)).lky.bG(paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(46851);
          return;
        }
        ad.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail callback is null");
        AppMethodBeat.o(46851);
      }
      
      public final void onTaskSucc(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46850);
        ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", new Object[] { paramAnonymousString2, paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.lkC;
        AppBrandVideoDownLoadMgr.as(paramAnonymousString1, true);
        if ((AppBrandVideoDownLoadMgr.aaT() != null) && (AppBrandVideoDownLoadMgr.aaT().get(paramAnonymousString1) != null) && (((a)AppBrandVideoDownLoadMgr.aaT().get(paramAnonymousString1)).lky != null))
        {
          ((a)AppBrandVideoDownLoadMgr.aaT().get(paramAnonymousString1)).lky.dw(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(46850);
          return;
        }
        ad.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc callback is null");
        AppMethodBeat.o(46850);
      }
    };
    AppMethodBeat.o(46861);
  }
  
  private static String Md(String paramString)
  {
    AppMethodBeat.i(46856);
    paramString = lkz + paramString + "/";
    AppMethodBeat.o(46856);
    return paramString;
  }
  
  private static String Me(String paramString)
  {
    AppMethodBeat.i(46857);
    paramString = Md(paramString);
    m.aLc(paramString);
    try
    {
      i.aYs(paramString + ".nomedia");
      label38:
      AppMethodBeat.o(46857);
      return paramString;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  private static String QD(String paramString)
  {
    AppMethodBeat.i(46855);
    synchronized (lkA)
    {
      if (lkA.containsKey(paramString))
      {
        paramString = (String)lkA.get(paramString);
        AppMethodBeat.o(46855);
        return paramString;
      }
      AppMethodBeat.o(46855);
      return null;
    }
  }
  
  private static String QE(String paramString)
  {
    AppMethodBeat.i(46859);
    localObject1 = null;
    for (;;)
    {
      try
      {
        localObject2 = Uri.parse(paramString);
        if (!((Uri)localObject2).getHost().equalsIgnoreCase("wxsnsdy.wxs.qq.com")) {
          continue;
        }
        localObject2 = ((Uri)localObject2).getQueryParameter("m");
        paramString = (String)localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        ad.printErrStackTrace("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", localException, "leonlad:getUrlFileMd5 failed videoUrl:%s", new Object[] { paramString });
        paramString = localObject1;
        continue;
      }
      AppMethodBeat.o(46859);
      return paramString;
      localObject2 = "unverify" + ai.ee(paramString);
      paramString = (String)localObject2;
    }
  }
  
  static void ar(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46854);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46854);
      return;
    }
    String str = QE(paramString);
    synchronized (lkA)
    {
      if (lkA.containsKey(str)) {
        lkA.remove(str);
      }
      ??? = (a)lkB.get(paramString);
      if (??? == null) {
        break label131;
      }
      if ((((a)???).url.equalsIgnoreCase(paramString)) && (((a)???).lkv > 0L)) {
        ((a)???).lkw = bt.aO(((a)???).lkv);
      }
      if (paramBoolean)
      {
        ((a)???).lkx = f.a.dQg;
        AppMethodBeat.o(46854);
        return;
      }
    }
    ((a)???).lkx = f.a.dQh;
    label131:
    AppMethodBeat.o(46854);
  }
  
  @Keep
  String genAdFileExist(String paramString, a parama)
  {
    AppMethodBeat.i(46852);
    if ((bt.isNullOrNil(paramString)) || (bt.isNullOrNil(parama.url)))
    {
      ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    String str1 = QE(parama.url);
    if (bt.isNullOrNil(str1))
    {
      ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", new Object[] { str1, parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    if (!bt.isNullOrNil(QD(str1)))
    {
      AppMethodBeat.o(46852);
      return "downloading";
    }
    paramString = Md(paramString) + str1 + ".gad";
    e locale = new e(paramString);
    String str2 = i.aPK(q.B(locale.mUri));
    if ((locale.exists()) && ((str1.startsWith("unverify")) || ((str2 != null) && (str2.equalsIgnoreCase(str1)))))
    {
      parama.lkw = 0L;
      parama.lkx = f.a.dQg;
      AppMethodBeat.o(46852);
      return paramString;
    }
    AppMethodBeat.o(46852);
    return null;
  }
  
  @Keep
  String genAdFilePath(String arg1, a parama)
  {
    AppMethodBeat.i(46853);
    if ((bt.isNullOrNil(???)) || (bt.isNullOrNil(parama.url)))
    {
      ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    String str = QE(parama.url);
    if (bt.isNullOrNil(str))
    {
      ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", new Object[] { str, parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    if (!bt.isNullOrNil(QD(str)))
    {
      AppMethodBeat.o(46853);
      return null;
    }
    parama.lkv = bt.HI();
    parama.lkx = f.a.dQf;
    parama = Me(???) + str + ".gad";
    synchronized (lkA)
    {
      lkA.put(str, parama);
      AppMethodBeat.o(46853);
      return parama;
    }
  }
  
  /* Error */
  public final void report(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 279
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 177	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +20 -> 32
    //   15: ldc 159
    //   17: ldc_w 281
    //   20: invokestatic 284	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 279
    //   26: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: getstatic 39	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoDownLoadMgr:lkB	Ljava/util/Map;
    //   35: aload_1
    //   36: invokeinterface 185 2 0
    //   41: checkcast 187	com/tencent/mm/plugin/appbrand/jsapi/video/a
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +23 -> 69
    //   49: aload_2
    //   50: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:lkw	J
    //   53: lconst_0
    //   54: lcmp
    //   55: iflt +14 -> 69
    //   58: aload_1
    //   59: aload_2
    //   60: getfield 190	com/tencent/mm/plugin/appbrand/jsapi/video/a:url	Ljava/lang/String;
    //   63: invokevirtual 142	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   66: ifne +25 -> 91
    //   69: ldc 159
    //   71: ldc_w 286
    //   74: invokestatic 284	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: ldc_w 279
    //   80: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -54 -> 29
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: ldc 159
    //   93: ldc_w 288
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_2
    //   103: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:lkw	J
    //   106: invokestatic 294	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: getfield 210	com/tencent/mm/plugin/appbrand/jsapi/video/a:lkx	Lcom/tencent/mm/g/b/a/f$a;
    //   116: aastore
    //   117: invokestatic 226	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: new 296	com/tencent/mm/g/b/a/f
    //   123: dup
    //   124: invokespecial 297	com/tencent/mm/g/b/a/f:<init>	()V
    //   127: astore_3
    //   128: aload_3
    //   129: aload_3
    //   130: ldc_w 299
    //   133: aload_1
    //   134: iconst_1
    //   135: invokevirtual 303	com/tencent/mm/g/b/a/f:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   138: putfield 306	com/tencent/mm/g/b/a/f:dQb	Ljava/lang/String;
    //   141: aload_3
    //   142: aload_2
    //   143: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:lkw	J
    //   146: putfield 309	com/tencent/mm/g/b/a/f:dQc	J
    //   149: aload_3
    //   150: aload_2
    //   151: getfield 210	com/tencent/mm/plugin/appbrand/jsapi/video/a:lkx	Lcom/tencent/mm/g/b/a/f$a;
    //   154: putfield 312	com/tencent/mm/g/b/a/f:dQd	Lcom/tencent/mm/g/b/a/f$a;
    //   157: aload_3
    //   158: invokevirtual 315	com/tencent/mm/g/b/a/f:aLk	()Z
    //   161: pop
    //   162: ldc_w 279
    //   165: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: goto -139 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	AppBrandVideoDownLoadMgr
    //   0	171	1	paramString	String
    //   44	107	2	locala	a
    //   127	31	3	localf	com.tencent.mm.g.b.a.f
    // Exception table:
    //   from	to	target	type
    //   2	29	86	finally
    //   32	45	86	finally
    //   49	69	86	finally
    //   69	83	86	finally
    //   91	168	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr
 * JD-Core Version:    0.7.0.1
 */