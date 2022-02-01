package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.t.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr
{
  public static final String mvD;
  private static HashMap<String, String> mvE;
  static final Map<String, a> mvF;
  public static AppBrandVideoDownLoadMgr mvG;
  static com.tencent.mm.s.d mvH;
  
  static
  {
    AppMethodBeat.i(46861);
    mvE = new HashMap();
    mvF = new ConcurrentHashMap();
    mvG = null;
    mvH = null;
    if (mvG == null) {
      mvG = new AppBrandVideoDownLoadMgr();
    }
    String str = b.aKJ();
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    mvD = (String)localObject + "wagamefiles/";
    com.tencent.mm.s.d.a(com.tencent.mm.plugin.cdndownloader.h.a.cyi());
    localObject = new com.tencent.mm.s.d();
    mvH = (com.tencent.mm.s.d)localObject;
    ((com.tencent.mm.s.d)localObject).gRe = new c()
    {
      public final void onTaskFail(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46851);
        Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.mvG;
        AppBrandVideoDownLoadMgr.au(paramAnonymousString, false);
        if ((AppBrandVideoDownLoadMgr.apb() != null) && (AppBrandVideoDownLoadMgr.apb().get(paramAnonymousString) != null) && (((a)AppBrandVideoDownLoadMgr.apb().get(paramAnonymousString)).mvC != null))
        {
          ((a)AppBrandVideoDownLoadMgr.apb().get(paramAnonymousString)).mvC.bO(paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(46851);
          return;
        }
        Log.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail callback is null");
        AppMethodBeat.o(46851);
      }
      
      public final void onTaskSucc(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46850);
        Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", new Object[] { paramAnonymousString2, paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.mvG;
        AppBrandVideoDownLoadMgr.au(paramAnonymousString1, true);
        if ((AppBrandVideoDownLoadMgr.apb() != null) && (AppBrandVideoDownLoadMgr.apb().get(paramAnonymousString1) != null) && (((a)AppBrandVideoDownLoadMgr.apb().get(paramAnonymousString1)).mvC != null))
        {
          ((a)AppBrandVideoDownLoadMgr.apb().get(paramAnonymousString1)).mvC.dN(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(46850);
          return;
        }
        Log.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc callback is null");
        AppMethodBeat.o(46850);
      }
    };
    AppMethodBeat.o(46861);
  }
  
  private static String VQ(String paramString)
  {
    AppMethodBeat.i(46856);
    paramString = mvD + paramString + "/";
    AppMethodBeat.o(46856);
    return paramString;
  }
  
  private static String VR(String paramString)
  {
    AppMethodBeat.i(46857);
    paramString = VQ(paramString);
    FilePathGenerator.checkMkdir(paramString);
    try
    {
      s.bpa(paramString + ".nomedia");
      label38:
      AppMethodBeat.o(46857);
      return paramString;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  private static String aaR(String paramString)
  {
    AppMethodBeat.i(46855);
    synchronized (mvE)
    {
      if (mvE.containsKey(paramString))
      {
        paramString = (String)mvE.get(paramString);
        AppMethodBeat.o(46855);
        return paramString;
      }
      AppMethodBeat.o(46855);
      return null;
    }
  }
  
  private static String aaS(String paramString)
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
  
  static void at(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46854);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46854);
      return;
    }
    String str = aaS(paramString);
    synchronized (mvE)
    {
      if (mvE.containsKey(str)) {
        mvE.remove(str);
      }
      ??? = (a)mvF.get(paramString);
      if (??? == null) {
        break label131;
      }
      if ((((a)???).url.equalsIgnoreCase(paramString)) && (((a)???).mvz > 0L)) {
        ((a)???).mvA = Util.ticksToNow(((a)???).mvz);
      }
      if (paramBoolean)
      {
        ((a)???).mvB = t.a.elf;
        AppMethodBeat.o(46854);
        return;
      }
    }
    ((a)???).mvB = t.a.elg;
    label131:
    AppMethodBeat.o(46854);
  }
  
  @Keep
  String genAdFileExist(String paramString, a parama)
  {
    AppMethodBeat.i(46852);
    if ((Util.isNullOrNil(paramString)) || (Util.isNullOrNil(parama.url)))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    String str1 = aaS(parama.url);
    if (Util.isNullOrNil(str1))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", new Object[] { str1, parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    if (!Util.isNullOrNil(aaR(str1)))
    {
      AppMethodBeat.o(46852);
      return "downloading";
    }
    paramString = VQ(paramString) + str1 + ".gad";
    o localo = new o(paramString);
    String str2 = s.bhK(aa.z(localo.mUri));
    if ((localo.exists()) && ((str1.startsWith("unverify")) || ((str2 != null) && (str2.equalsIgnoreCase(str1)))))
    {
      parama.mvA = 0L;
      parama.mvB = t.a.elf;
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
    if ((Util.isNullOrNil(???)) || (Util.isNullOrNil(parama.url)))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    String str = aaS(parama.url);
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", new Object[] { str, parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    if (!Util.isNullOrNil(aaR(str)))
    {
      AppMethodBeat.o(46853);
      return null;
    }
    parama.mvz = Util.currentTicks();
    parama.mvB = t.a.ele;
    parama = VR(???) + str + ".gad";
    synchronized (mvE)
    {
      mvE.put(str, parama);
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
    //   9: invokestatic 177	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +20 -> 32
    //   15: ldc 159
    //   17: ldc_w 281
    //   20: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 279
    //   26: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: getstatic 39	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoDownLoadMgr:mvF	Ljava/util/Map;
    //   35: aload_1
    //   36: invokeinterface 185 2 0
    //   41: checkcast 187	com/tencent/mm/plugin/appbrand/jsapi/video/a
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +23 -> 69
    //   49: aload_2
    //   50: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:mvA	J
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
    //   74: invokestatic 284	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   103: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:mvA	J
    //   106: invokestatic 294	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: getfield 210	com/tencent/mm/plugin/appbrand/jsapi/video/a:mvB	Lcom/tencent/mm/g/b/a/t$a;
    //   116: aastore
    //   117: invokestatic 226	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: new 296	com/tencent/mm/g/b/a/t
    //   123: dup
    //   124: invokespecial 297	com/tencent/mm/g/b/a/t:<init>	()V
    //   127: astore_3
    //   128: aload_3
    //   129: aload_3
    //   130: ldc_w 299
    //   133: aload_1
    //   134: iconst_1
    //   135: invokevirtual 303	com/tencent/mm/g/b/a/t:x	(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   138: putfield 306	com/tencent/mm/g/b/a/t:ela	Ljava/lang/String;
    //   141: aload_3
    //   142: aload_2
    //   143: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:mvA	J
    //   146: putfield 309	com/tencent/mm/g/b/a/t:elb	J
    //   149: aload_3
    //   150: aload_2
    //   151: getfield 210	com/tencent/mm/plugin/appbrand/jsapi/video/a:mvB	Lcom/tencent/mm/g/b/a/t$a;
    //   154: putfield 312	com/tencent/mm/g/b/a/t:elc	Lcom/tencent/mm/g/b/a/t$a;
    //   157: aload_3
    //   158: invokevirtual 315	com/tencent/mm/g/b/a/t:bfK	()Z
    //   161: pop
    //   162: ldc_w 279
    //   165: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: goto -139 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	AppBrandVideoDownLoadMgr
    //   0	171	1	paramString	String
    //   44	107	2	locala	a
    //   127	31	3	localt	com.tencent.mm.g.b.a.t
    // Exception table:
    //   from	to	target	type
    //   2	29	86	finally
    //   32	45	86	finally
    //   49	69	86	finally
    //   69	83	86	finally
    //   91	168	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr
 * JD-Core Version:    0.7.0.1
 */