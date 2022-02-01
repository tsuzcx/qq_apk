package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.f.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.t.c;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr
{
  public static final String loX;
  private static HashMap<String, String> loY;
  static final Map<String, a> loZ;
  public static AppBrandVideoDownLoadMgr lpa;
  static com.tencent.mm.t.d lpb;
  
  static
  {
    AppMethodBeat.i(46861);
    loY = new HashMap();
    loZ = new ConcurrentHashMap();
    lpa = null;
    lpb = null;
    if (lpa == null) {
      lpa = new AppBrandVideoDownLoadMgr();
    }
    String str = b.asj();
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    loX = (String)localObject + "wagamefiles/";
    com.tencent.mm.t.d.a(com.tencent.mm.plugin.cdndownloader.h.a.car());
    localObject = new com.tencent.mm.t.d();
    lpb = (com.tencent.mm.t.d)localObject;
    ((com.tencent.mm.t.d)localObject).ghM = new c()
    {
      public final void onTaskFail(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46851);
        ae.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.lpa;
        AppBrandVideoDownLoadMgr.as(paramAnonymousString, false);
        if ((AppBrandVideoDownLoadMgr.abc() != null) && (AppBrandVideoDownLoadMgr.abc().get(paramAnonymousString) != null) && (((a)AppBrandVideoDownLoadMgr.abc().get(paramAnonymousString)).loW != null))
        {
          ((a)AppBrandVideoDownLoadMgr.abc().get(paramAnonymousString)).loW.bJ(paramAnonymousString, paramAnonymousInt);
          AppMethodBeat.o(46851);
          return;
        }
        ae.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail callback is null");
        AppMethodBeat.o(46851);
      }
      
      public final void onTaskSucc(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(46850);
        ae.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", new Object[] { paramAnonymousString2, paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.lpa;
        AppBrandVideoDownLoadMgr.as(paramAnonymousString1, true);
        if ((AppBrandVideoDownLoadMgr.abc() != null) && (AppBrandVideoDownLoadMgr.abc().get(paramAnonymousString1) != null) && (((a)AppBrandVideoDownLoadMgr.abc().get(paramAnonymousString1)).loW != null))
        {
          ((a)AppBrandVideoDownLoadMgr.abc().get(paramAnonymousString1)).loW.dy(paramAnonymousString1, paramAnonymousString2);
          AppMethodBeat.o(46850);
          return;
        }
        ae.e("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc callback is null");
        AppMethodBeat.o(46850);
      }
    };
    AppMethodBeat.o(46861);
  }
  
  private static String MH(String paramString)
  {
    AppMethodBeat.i(46856);
    paramString = loX + paramString + "/";
    AppMethodBeat.o(46856);
    return paramString;
  }
  
  private static String MI(String paramString)
  {
    AppMethodBeat.i(46857);
    paramString = MH(paramString);
    n.aMy(paramString);
    try
    {
      o.aZV(paramString + ".nomedia");
      label38:
      AppMethodBeat.o(46857);
      return paramString;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  private static String Rm(String paramString)
  {
    AppMethodBeat.i(46855);
    synchronized (loY)
    {
      if (loY.containsKey(paramString))
      {
        paramString = (String)loY.get(paramString);
        AppMethodBeat.o(46855);
        return paramString;
      }
      AppMethodBeat.o(46855);
      return null;
    }
  }
  
  private static String Rn(String paramString)
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
        ae.printErrStackTrace("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", localException, "leonlad:getUrlFileMd5 failed videoUrl:%s", new Object[] { paramString });
        paramString = localObject1;
        continue;
      }
      AppMethodBeat.o(46859);
      return paramString;
      localObject2 = "unverify" + aj.ej(paramString);
      paramString = (String)localObject2;
    }
  }
  
  static void ar(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(46854);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(46854);
      return;
    }
    String str = Rn(paramString);
    synchronized (loY)
    {
      if (loY.containsKey(str)) {
        loY.remove(str);
      }
      ??? = (a)loZ.get(paramString);
      if (??? == null) {
        break label131;
      }
      if ((((a)???).url.equalsIgnoreCase(paramString)) && (((a)???).loT > 0L)) {
        ((a)???).loU = bu.aO(((a)???).loT);
      }
      if (paramBoolean)
      {
        ((a)???).loV = f.a.dRw;
        AppMethodBeat.o(46854);
        return;
      }
    }
    ((a)???).loV = f.a.dRx;
    label131:
    AppMethodBeat.o(46854);
  }
  
  @Keep
  String genAdFileExist(String paramString, a parama)
  {
    AppMethodBeat.i(46852);
    if ((bu.isNullOrNil(paramString)) || (bu.isNullOrNil(parama.url)))
    {
      ae.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    String str1 = Rn(parama.url);
    if (bu.isNullOrNil(str1))
    {
      ae.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", new Object[] { str1, parama.url });
      AppMethodBeat.o(46852);
      return null;
    }
    if (!bu.isNullOrNil(Rm(str1)))
    {
      AppMethodBeat.o(46852);
      return "downloading";
    }
    paramString = MH(paramString) + str1 + ".gad";
    k localk = new k(paramString);
    String str2 = o.aRh(w.B(localk.mUri));
    if ((localk.exists()) && ((str1.startsWith("unverify")) || ((str2 != null) && (str2.equalsIgnoreCase(str1)))))
    {
      parama.loU = 0L;
      parama.loV = f.a.dRw;
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
    if ((bu.isNullOrNil(???)) || (bu.isNullOrNil(parama.url)))
    {
      ae.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    String str = Rn(parama.url);
    if (bu.isNullOrNil(str))
    {
      ae.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", new Object[] { str, parama.url });
      AppMethodBeat.o(46853);
      return null;
    }
    if (!bu.isNullOrNil(Rm(str)))
    {
      AppMethodBeat.o(46853);
      return null;
    }
    parama.loT = bu.HQ();
    parama.loV = f.a.dRv;
    parama = MI(???) + str + ".gad";
    synchronized (loY)
    {
      loY.put(str, parama);
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
    //   9: invokestatic 177	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +20 -> 32
    //   15: ldc 159
    //   17: ldc_w 281
    //   20: invokestatic 284	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 279
    //   26: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: getstatic 39	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoDownLoadMgr:loZ	Ljava/util/Map;
    //   35: aload_1
    //   36: invokeinterface 185 2 0
    //   41: checkcast 187	com/tencent/mm/plugin/appbrand/jsapi/video/a
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +23 -> 69
    //   49: aload_2
    //   50: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:loU	J
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
    //   74: invokestatic 284	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   103: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:loU	J
    //   106: invokestatic 294	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: getfield 210	com/tencent/mm/plugin/appbrand/jsapi/video/a:loV	Lcom/tencent/mm/g/b/a/f$a;
    //   116: aastore
    //   117: invokestatic 226	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   138: putfield 306	com/tencent/mm/g/b/a/f:dRr	Ljava/lang/String;
    //   141: aload_3
    //   142: aload_2
    //   143: getfield 201	com/tencent/mm/plugin/appbrand/jsapi/video/a:loU	J
    //   146: putfield 309	com/tencent/mm/g/b/a/f:dRs	J
    //   149: aload_3
    //   150: aload_2
    //   151: getfield 210	com/tencent/mm/plugin/appbrand/jsapi/video/a:loV	Lcom/tencent/mm/g/b/a/f$a;
    //   154: putfield 312	com/tencent/mm/g/b/a/f:dRt	Lcom/tencent/mm/g/b/a/f$a;
    //   157: aload_3
    //   158: invokevirtual 315	com/tencent/mm/g/b/a/f:aLH	()Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr
 * JD-Core Version:    0.7.0.1
 */