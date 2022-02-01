package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.z.a;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.p.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr
{
  public static final String szi;
  private static HashMap<String, String> szj;
  static final Map<String, a> szk;
  public static AppBrandVideoDownLoadMgr szl;
  static d szm;
  
  static
  {
    AppMethodBeat.i(46861);
    szj = new HashMap();
    szk = new ConcurrentHashMap();
    szl = null;
    szm = null;
    if (szl == null) {
      szl = new AppBrandVideoDownLoadMgr();
    }
    String str = b.bmz();
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    szi = (String)localObject + "wagamefiles/";
    d.a(com.tencent.mm.plugin.cdndownloader.h.a.dqh());
    localObject = new d();
    szm = (d)localObject;
    ((d)localObject).mbk = new com.tencent.mm.p.c()
    {
      public final void f(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46850);
        Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", new Object[] { paramAnonymousString2, paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.szl;
        AppBrandVideoDownLoadMgr.aI(paramAnonymousString1, true);
        if ((AppBrandVideoDownLoadMgr.aCw() != null) && (AppBrandVideoDownLoadMgr.aCw().get(paramAnonymousString1) != null) && (((a)AppBrandVideoDownLoadMgr.aCw().get(paramAnonymousString1)).szh != null))
        {
          ((a)AppBrandVideoDownLoadMgr.aCw().get(paramAnonymousString1)).szh.er(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(46850);
          return;
        }
        Log.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc callback is null");
        AppMethodBeat.o(46850);
      }
      
      public final void onTaskFail(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46851);
        Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.szl;
        AppBrandVideoDownLoadMgr.aI(paramAnonymousString, false);
        if ((AppBrandVideoDownLoadMgr.aCw() != null) && (AppBrandVideoDownLoadMgr.aCw().get(paramAnonymousString) != null) && (((a)AppBrandVideoDownLoadMgr.aCw().get(paramAnonymousString)).szh != null))
        {
          ((a)AppBrandVideoDownLoadMgr.aCw().get(paramAnonymousString)).szh.cK(paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(46851);
          return;
        }
        Log.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail callback is null");
        AppMethodBeat.o(46851);
      }
    };
    AppMethodBeat.o(46861);
  }
  
  private static String Wc(String paramString)
  {
    AppMethodBeat.i(46856);
    paramString = szi + paramString + "/";
    AppMethodBeat.o(46856);
    return paramString;
  }
  
  private static String Wd(String paramString)
  {
    AppMethodBeat.i(46857);
    paramString = Wc(paramString);
    FilePathGenerator.checkMkdir(paramString);
    try
    {
      y.bEp(paramString + ".nomedia");
      label38:
      AppMethodBeat.o(46857);
      return paramString;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  static void aH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46854);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46854);
      return;
    }
    String str = abK(paramString);
    synchronized (szj)
    {
      if (szj.containsKey(str)) {
        szj.remove(str);
      }
      ??? = (a)szk.get(paramString);
      if (??? == null) {
        break label131;
      }
      if ((((a)???).url.equalsIgnoreCase(paramString)) && (((a)???).sze > 0L)) {
        ((a)???).szf = Util.ticksToNow(((a)???).sze);
      }
      if (paramBoolean)
      {
        ((a)???).szg = z.a.imJ;
        AppMethodBeat.o(46854);
        return;
      }
    }
    ((a)???).szg = z.a.imK;
    label131:
    AppMethodBeat.o(46854);
  }
  
  private static String abJ(String paramString)
  {
    AppMethodBeat.i(46855);
    synchronized (szj)
    {
      if (szj.containsKey(paramString))
      {
        paramString = (String)szj.get(paramString);
        AppMethodBeat.o(46855);
        return paramString;
      }
      AppMethodBeat.o(46855);
      return null;
    }
  }
  
  private static String abK(String paramString)
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
        Log.printErrStackTrace("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", localException, "leonlad:getUrlFileMd5 failed videoUrl:%s", new Object[] { paramString });
        paramString = localObject1;
        continue;
      }
      AppMethodBeat.o(46859);
      return paramString;
      localObject2 = "unverify" + MD5Util.getMD5String(paramString);
      paramString = (String)localObject2;
    }
  }
  
  String genAdFileExist(String paramString, a parama)
  {
    AppMethodBeat.i(46852);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(parama.url)))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    String str1 = abK(parama.url);
    if (Util.isNullOrNil(str1))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", new Object[] { str1, parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    if (!Util.isNullOrNil(abJ(str1)))
    {
      AppMethodBeat.o(46852);
      return "downloading";
    }
    paramString = Wc(paramString) + str1 + ".gad";
    u localu = new u(paramString);
    String str2 = y.bub(ah.v(localu.mUri));
    if ((localu.jKS()) && ((str1.startsWith("unverify")) || ((str2 != null) && (str2.equalsIgnoreCase(str1)))))
    {
      parama.szf = 0L;
      parama.szg = z.a.imJ;
      AppMethodBeat.o(46852);
      return paramString;
    }
    AppMethodBeat.o(46852);
    return null;
  }
  
  String genAdFilePath(String arg1, a parama)
  {
    AppMethodBeat.i(46853);
    if ((Util.isNullOrNil(???)) || (Util.isNullOrNil(parama.url)))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    String str = abK(parama.url);
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", new Object[] { str, parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    if (!Util.isNullOrNil(abJ(str)))
    {
      AppMethodBeat.o(46853);
      return null;
    }
    parama.sze = Util.currentTicks();
    parama.szg = z.a.imI;
    parama = Wd(???) + str + ".gad";
    synchronized (szj)
    {
      szj.put(str, parama);
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
    //   2: ldc_w 277
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 126	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +20 -> 32
    //   15: ldc 209
    //   17: ldc_w 279
    //   20: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 277
    //   26: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: getstatic 39	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoDownLoadMgr:szk	Ljava/util/Map;
    //   35: aload_1
    //   36: invokeinterface 142 2 0
    //   41: checkcast 144	com/tencent/mm/plugin/appbrand/jsapi/video/a
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +23 -> 69
    //   49: aload_2
    //   50: getfield 161	com/tencent/mm/plugin/appbrand/jsapi/video/a:szf	J
    //   53: lconst_0
    //   54: lcmp
    //   55: iflt +14 -> 69
    //   58: aload_1
    //   59: aload_2
    //   60: getfield 147	com/tencent/mm/plugin/appbrand/jsapi/video/a:url	Ljava/lang/String;
    //   63: invokevirtual 150	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   66: ifne +25 -> 91
    //   69: ldc 209
    //   71: ldc_w 284
    //   74: invokestatic 282	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: ldc_w 277
    //   80: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -54 -> 29
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: ldc 209
    //   93: ldc_w 286
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_2
    //   103: getfield 161	com/tencent/mm/plugin/appbrand/jsapi/video/a:szf	J
    //   106: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: getfield 170	com/tencent/mm/plugin/appbrand/jsapi/video/a:szg	Lcom/tencent/mm/autogen/mmdata/rpt/z$a;
    //   116: aastore
    //   117: invokestatic 225	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: new 294	com/tencent/mm/autogen/mmdata/rpt/z
    //   123: dup
    //   124: invokespecial 295	com/tencent/mm/autogen/mmdata/rpt/z:<init>	()V
    //   127: astore_3
    //   128: aload_3
    //   129: aload_3
    //   130: ldc_w 297
    //   133: aload_1
    //   134: iconst_1
    //   135: invokevirtual 301	com/tencent/mm/autogen/mmdata/rpt/z:F	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   138: putfield 304	com/tencent/mm/autogen/mmdata/rpt/z:imE	Ljava/lang/String;
    //   141: aload_3
    //   142: aload_2
    //   143: getfield 161	com/tencent/mm/plugin/appbrand/jsapi/video/a:szf	J
    //   146: putfield 307	com/tencent/mm/autogen/mmdata/rpt/z:imF	J
    //   149: aload_3
    //   150: aload_2
    //   151: getfield 170	com/tencent/mm/plugin/appbrand/jsapi/video/a:szg	Lcom/tencent/mm/autogen/mmdata/rpt/z$a;
    //   154: putfield 310	com/tencent/mm/autogen/mmdata/rpt/z:imG	Lcom/tencent/mm/autogen/mmdata/rpt/z$a;
    //   157: aload_3
    //   158: invokevirtual 313	com/tencent/mm/autogen/mmdata/rpt/z:bMH	()Z
    //   161: pop
    //   162: ldc_w 277
    //   165: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: goto -139 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	AppBrandVideoDownLoadMgr
    //   0	171	1	paramString	String
    //   44	107	2	locala	a
    //   127	31	3	localz	com.tencent.mm.autogen.mmdata.rpt.z
    // Exception table:
    //   from	to	target	type
    //   2	29	86	finally
    //   32	45	86	finally
    //   49	69	86	finally
    //   69	83	86	finally
    //   91	168	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr
 * JD-Core Version:    0.7.0.1
 */