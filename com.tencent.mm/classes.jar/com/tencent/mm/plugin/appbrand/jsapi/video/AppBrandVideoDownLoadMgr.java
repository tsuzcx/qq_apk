package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.d.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.t.c;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr
{
  public static final String kNW;
  private static HashMap<String, String> kNX;
  static final Map<String, a> kNY;
  public static AppBrandVideoDownLoadMgr kNZ;
  static com.tencent.mm.t.d kOa;
  
  static
  {
    AppMethodBeat.i(46861);
    kNX = new HashMap();
    kNY = new ConcurrentHashMap();
    kNZ = null;
    kOa = null;
    if (kNZ == null) {
      kNZ = new AppBrandVideoDownLoadMgr();
    }
    String str = b.aph();
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    kNW = (String)localObject + "wagamefiles/";
    com.tencent.mm.t.d.a(com.tencent.mm.plugin.cdndownloader.h.a.bUx());
    localObject = new com.tencent.mm.t.d();
    kOa = (com.tencent.mm.t.d)localObject;
    ((com.tencent.mm.t.d)localObject).fLU = new c()
    {
      public final void onTaskFail(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46851);
        ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.kNZ;
        AppBrandVideoDownLoadMgr.ar(paramAnonymousString, false);
        if ((AppBrandVideoDownLoadMgr.Yr() != null) && (AppBrandVideoDownLoadMgr.Yr().get(paramAnonymousString) != null) && (((a)AppBrandVideoDownLoadMgr.Yr().get(paramAnonymousString)).kNV != null))
        {
          ((a)AppBrandVideoDownLoadMgr.Yr().get(paramAnonymousString)).kNV.bD(paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(46851);
          return;
        }
        ac.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail callback is null");
        AppMethodBeat.o(46851);
      }
      
      public final void onTaskSucc(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46850);
        ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", new Object[] { paramAnonymousString2, paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.kNZ;
        AppBrandVideoDownLoadMgr.ar(paramAnonymousString1, true);
        if ((AppBrandVideoDownLoadMgr.Yr() != null) && (AppBrandVideoDownLoadMgr.Yr().get(paramAnonymousString1) != null) && (((a)AppBrandVideoDownLoadMgr.Yr().get(paramAnonymousString1)).kNV != null))
        {
          ((a)AppBrandVideoDownLoadMgr.Yr().get(paramAnonymousString1)).kNV.du(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(46850);
          return;
        }
        ac.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc callback is null");
        AppMethodBeat.o(46850);
      }
    };
    AppMethodBeat.o(46861);
  }
  
  private static String IM(String paramString)
  {
    AppMethodBeat.i(46856);
    paramString = kNW + paramString + "/";
    AppMethodBeat.o(46856);
    return paramString;
  }
  
  private static String IN(String paramString)
  {
    AppMethodBeat.i(46857);
    paramString = IM(paramString);
    l.aFC(paramString);
    try
    {
      i.aSt(paramString + ".nomedia");
      label38:
      AppMethodBeat.o(46857);
      return paramString;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  private static String Ng(String paramString)
  {
    AppMethodBeat.i(46855);
    synchronized (kNX)
    {
      if (kNX.containsKey(paramString))
      {
        paramString = (String)kNX.get(paramString);
        AppMethodBeat.o(46855);
        return paramString;
      }
      AppMethodBeat.o(46855);
      return null;
    }
  }
  
  private static String Nh(String paramString)
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
        ac.printErrStackTrace("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", localException, "leonlad:getUrlFileMd5 failed videoUrl:%s", new Object[] { paramString });
        paramString = localObject1;
        continue;
      }
      AppMethodBeat.o(46859);
      return paramString;
      localObject2 = "unverify" + ah.dg(paramString);
      paramString = (String)localObject2;
    }
  }
  
  static void aq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46854);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46854);
      return;
    }
    String str = Nh(paramString);
    synchronized (kNX)
    {
      if (kNX.containsKey(str)) {
        kNX.remove(str);
      }
      ??? = (a)kNY.get(paramString);
      if (??? == null) {
        break label131;
      }
      if ((((a)???).url.equalsIgnoreCase(paramString)) && (((a)???).kNS > 0L)) {
        ((a)???).kNT = bs.aO(((a)???).kNS);
      }
      if (paramBoolean)
      {
        ((a)???).kNU = d.a.dDj;
        AppMethodBeat.o(46854);
        return;
      }
    }
    ((a)???).kNU = d.a.dDk;
    label131:
    AppMethodBeat.o(46854);
  }
  
  @Keep
  String genAdFileExist(String paramString, a parama)
  {
    AppMethodBeat.i(46852);
    if ((bs.isNullOrNil(paramString)) || (bs.isNullOrNil(parama.url)))
    {
      ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    String str1 = Nh(parama.url);
    if (bs.isNullOrNil(str1))
    {
      ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", new Object[] { str1, parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    if (!bs.isNullOrNil(Ng(str1)))
    {
      AppMethodBeat.o(46852);
      return "downloading";
    }
    paramString = IM(paramString) + str1 + ".gad";
    e locale = new e(paramString);
    String str2 = i.aKe(q.B(locale.mUri));
    if ((locale.exists()) && ((str1.startsWith("unverify")) || ((str2 != null) && (str2.equalsIgnoreCase(str1)))))
    {
      parama.kNT = 0L;
      parama.kNU = d.a.dDj;
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
    if ((bs.isNullOrNil(???)) || (bs.isNullOrNil(parama.url)))
    {
      ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    String str = Nh(parama.url);
    if (bs.isNullOrNil(str))
    {
      ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", new Object[] { str, parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    if (!bs.isNullOrNil(Ng(str)))
    {
      AppMethodBeat.o(46853);
      return null;
    }
    parama.kNS = bs.Gn();
    parama.kNU = d.a.dDi;
    parama = IN(???) + str + ".gad";
    synchronized (kNX)
    {
      kNX.put(str, parama);
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
    //   9: invokestatic 177	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +20 -> 32
    //   15: ldc 159
    //   17: ldc_w 281
    //   20: invokestatic 284	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 279
    //   26: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: getstatic 39	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoDownLoadMgr:kNY	Ljava/util/Map;
    //   35: aload_1
    //   36: invokeinterface 185 2 0
    //   41: checkcast 187	com/tencent/mm/plugin/appbrand/jsapi/video/a
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +23 -> 69
    //   49: aload_2
    //   50: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:kNT	J
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
    //   74: invokestatic 284	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   103: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:kNT	J
    //   106: invokestatic 294	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: getfield 210	com/tencent/mm/plugin/appbrand/jsapi/video/a:kNU	Lcom/tencent/mm/g/b/a/d$a;
    //   116: aastore
    //   117: invokestatic 226	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: new 296	com/tencent/mm/g/b/a/d
    //   123: dup
    //   124: invokespecial 297	com/tencent/mm/g/b/a/d:<init>	()V
    //   127: astore_3
    //   128: aload_3
    //   129: aload_3
    //   130: ldc_w 299
    //   133: aload_1
    //   134: iconst_1
    //   135: invokevirtual 303	com/tencent/mm/g/b/a/d:t	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   138: putfield 306	com/tencent/mm/g/b/a/d:dDe	Ljava/lang/String;
    //   141: aload_3
    //   142: aload_2
    //   143: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:kNT	J
    //   146: putfield 309	com/tencent/mm/g/b/a/d:dDf	J
    //   149: aload_3
    //   150: aload_2
    //   151: getfield 210	com/tencent/mm/plugin/appbrand/jsapi/video/a:kNU	Lcom/tencent/mm/g/b/a/d$a;
    //   154: putfield 312	com/tencent/mm/g/b/a/d:dDg	Lcom/tencent/mm/g/b/a/d$a;
    //   157: aload_3
    //   158: invokevirtual 315	com/tencent/mm/g/b/a/d:aHZ	()Z
    //   161: pop
    //   162: ldc_w 279
    //   165: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: goto -139 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	AppBrandVideoDownLoadMgr
    //   0	171	1	paramString	String
    //   44	107	2	locala	a
    //   127	31	3	locald	com.tencent.mm.g.b.a.d
    // Exception table:
    //   from	to	target	type
    //   2	29	86	finally
    //   32	45	86	finally
    //   49	69	86	finally
    //   69	83	86	finally
    //   91	168	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr
 * JD-Core Version:    0.7.0.1
 */