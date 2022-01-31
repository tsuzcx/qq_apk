package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.b.a.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.t.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr
{
  public static final String ice;
  private static HashMap<String, String> icf;
  static final Map<String, a> icg;
  public static AppBrandVideoDownLoadMgr ich;
  static d ici;
  
  static
  {
    AppMethodBeat.i(131532);
    icf = new HashMap();
    icg = new ConcurrentHashMap();
    ich = null;
    ici = null;
    if (ich == null) {
      ich = new AppBrandVideoDownLoadMgr();
    }
    String str = e.eQz;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    ice = (String)localObject + "wagamefiles/";
    d.a(com.tencent.mm.plugin.cdndownloader.h.a.bga());
    localObject = new d();
    ici = (d)localObject;
    ((d)localObject).euN = new com.tencent.mm.t.c()
    {
      public final void onTaskFail(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131522);
        ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.ich;
        AppBrandVideoDownLoadMgr.am(paramAnonymousString, false);
        ((a)AppBrandVideoDownLoadMgr.ajx().get(paramAnonymousString)).icd.bi(paramAnonymousString, paramAnonymousInt);
        AppMethodBeat.o(131522);
      }
      
      public final void onTaskSucc(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(131521);
        ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", new Object[] { paramAnonymousString2, paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.ich;
        AppBrandVideoDownLoadMgr.am(paramAnonymousString1, true);
        ((a)AppBrandVideoDownLoadMgr.ajx().get(paramAnonymousString1)).icd.cw(paramAnonymousString1, paramAnonymousString2);
        AppMethodBeat.o(131521);
      }
    };
    AppMethodBeat.o(131532);
  }
  
  private static String CQ(String paramString)
  {
    AppMethodBeat.i(131526);
    synchronized (icf)
    {
      if (icf.containsKey(paramString))
      {
        paramString = (String)icf.get(paramString);
        AppMethodBeat.o(131526);
        return paramString;
      }
      AppMethodBeat.o(131526);
      return null;
    }
  }
  
  private static String CR(String paramString)
  {
    AppMethodBeat.i(131527);
    paramString = ice + paramString + "/";
    AppMethodBeat.o(131527);
    return paramString;
  }
  
  private static String CS(String paramString)
  {
    AppMethodBeat.i(131530);
    Uri localUri = Uri.parse(paramString);
    if (localUri.getHost().equalsIgnoreCase("wxsnsdy.wxs.qq.com")) {}
    for (paramString = localUri.getQueryParameter("m");; paramString = "unverify" + ag.cE(paramString))
    {
      AppMethodBeat.o(131530);
      return paramString;
    }
  }
  
  static void al(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131525);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(131525);
      return;
    }
    String str = CS(paramString);
    synchronized (icf)
    {
      if (icf.containsKey(str)) {
        icf.remove(str);
      }
      ??? = (a)icg.get(paramString);
      if (??? == null) {
        break label131;
      }
      if ((((a)???).url.equalsIgnoreCase(paramString)) && (((a)???).startTimeStamp > 0L)) {
        ((a)???).icb = bo.av(((a)???).startTimeStamp);
      }
      if (paramBoolean)
      {
        ((a)???).icc = c.a.cOt;
        AppMethodBeat.o(131525);
        return;
      }
    }
    ((a)???).icc = c.a.cOu;
    label131:
    AppMethodBeat.o(131525);
  }
  
  private static String yY(String paramString)
  {
    AppMethodBeat.i(131528);
    paramString = CR(paramString);
    j.akQ(paramString);
    try
    {
      new File(paramString, ".nomedia").createNewFile();
      label29:
      AppMethodBeat.o(131528);
      return paramString;
    }
    catch (Exception localException)
    {
      break label29;
    }
  }
  
  @Keep
  String genAdFileExist(String paramString, a parama)
  {
    AppMethodBeat.i(131523);
    if ((bo.isNullOrNil(paramString)) || (bo.isNullOrNil(parama.url)))
    {
      ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(131523);
      return null;
    }
    String str1 = CS(parama.url);
    if (bo.isNullOrNil(str1))
    {
      ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", new Object[] { str1, parama.url });
      AppMethodBeat.o(131523);
      return null;
    }
    if (!bo.isNullOrNil(CQ(str1)))
    {
      AppMethodBeat.o(131523);
      return "downloading";
    }
    paramString = CR(paramString) + str1 + ".gad";
    File localFile = new File(paramString);
    String str2 = g.r(localFile);
    if ((localFile.exists()) && ((str1.startsWith("unverify")) || ((str2 != null) && (str2.equalsIgnoreCase(str1)))))
    {
      parama.icb = 0L;
      parama.icc = c.a.cOt;
      AppMethodBeat.o(131523);
      return paramString;
    }
    AppMethodBeat.o(131523);
    return null;
  }
  
  @Keep
  String genAdFilePath(String arg1, a parama)
  {
    AppMethodBeat.i(131524);
    if ((bo.isNullOrNil(???)) || (bo.isNullOrNil(parama.url)))
    {
      ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", new Object[] { parama.url });
      AppMethodBeat.o(131524);
      return null;
    }
    String str = CS(parama.url);
    if (bo.isNullOrNil(str))
    {
      ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", new Object[] { str, parama.url });
      AppMethodBeat.o(131524);
      return null;
    }
    if (!bo.isNullOrNil(CQ(str)))
    {
      AppMethodBeat.o(131524);
      return null;
    }
    parama.startTimeStamp = bo.yB();
    parama.icc = c.a.cOs;
    parama = yY(???) + str + ".gad";
    synchronized (icf)
    {
      icf.put(str, parama);
      AppMethodBeat.o(131524);
      return parama;
    }
  }
  
  /* Error */
  public final void report(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 267
    //   5: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokestatic 149	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   12: ifeq +20 -> 32
    //   15: ldc 217
    //   17: ldc_w 269
    //   20: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc_w 267
    //   26: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: getstatic 39	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoDownLoadMgr:icg	Ljava/util/Map;
    //   35: aload_1
    //   36: invokeinterface 157 2 0
    //   41: checkcast 159	com/tencent/mm/plugin/appbrand/jsapi/video/a
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +23 -> 69
    //   49: aload_2
    //   50: getfield 173	com/tencent/mm/plugin/appbrand/jsapi/video/a:icb	J
    //   53: lconst_0
    //   54: lcmp
    //   55: iflt +14 -> 69
    //   58: aload_1
    //   59: aload_2
    //   60: getfield 162	com/tencent/mm/plugin/appbrand/jsapi/video/a:url	Ljava/lang/String;
    //   63: invokevirtual 124	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   66: ifne +25 -> 91
    //   69: ldc 217
    //   71: ldc_w 273
    //   74: invokestatic 271	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: ldc_w 267
    //   80: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: goto -54 -> 29
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: ldc 217
    //   93: ldc_w 275
    //   96: iconst_2
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_2
    //   103: getfield 173	com/tencent/mm/plugin/appbrand/jsapi/video/a:icb	J
    //   106: invokestatic 281	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_2
    //   113: getfield 182	com/tencent/mm/plugin/appbrand/jsapi/video/a:icc	Lcom/tencent/mm/g/b/a/c$a;
    //   116: aastore
    //   117: invokestatic 224	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: new 283	com/tencent/mm/g/b/a/c
    //   123: dup
    //   124: invokespecial 284	com/tencent/mm/g/b/a/c:<init>	()V
    //   127: aload_1
    //   128: invokevirtual 288	com/tencent/mm/g/b/a/c:eP	(Ljava/lang/String;)Lcom/tencent/mm/g/b/a/c;
    //   131: astore_1
    //   132: aload_1
    //   133: aload_2
    //   134: getfield 173	com/tencent/mm/plugin/appbrand/jsapi/video/a:icb	J
    //   137: putfield 291	com/tencent/mm/g/b/a/c:cOp	J
    //   140: aload_1
    //   141: aload_2
    //   142: getfield 182	com/tencent/mm/plugin/appbrand/jsapi/video/a:icc	Lcom/tencent/mm/g/b/a/c$a;
    //   145: putfield 294	com/tencent/mm/g/b/a/c:cOq	Lcom/tencent/mm/g/b/a/c$a;
    //   148: aload_1
    //   149: invokevirtual 297	com/tencent/mm/g/b/a/c:ake	()Z
    //   152: pop
    //   153: ldc_w 267
    //   156: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: goto -130 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	AppBrandVideoDownLoadMgr
    //   0	162	1	paramString	String
    //   44	98	2	locala	a
    // Exception table:
    //   from	to	target	type
    //   2	29	86	finally
    //   32	45	86	finally
    //   49	69	86	finally
    //   69	83	86	finally
    //   91	159	86	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr
 * JD-Core Version:    0.7.0.1
 */