package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.net.Uri;
import android.support.annotation.Keep;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.h.b.a.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.t.c;
import com.tencent.mm.t.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandVideoDownLoadMgr
{
  public static final String gDc;
  private static HashMap<String, String> gDd = new HashMap();
  static final Map<String, a> gDe = new ConcurrentHashMap();
  public static AppBrandVideoDownLoadMgr gDf = null;
  static d gDg = null;
  
  static
  {
    if (gDf == null) {
      gDf = new AppBrandVideoDownLoadMgr();
    }
    String str = e.bkH;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    gDc = (String)localObject + "wagamefiles/";
    d.a(com.tencent.mm.plugin.cdndownloader.h.a.aDD());
    localObject = new d();
    gDg = (d)localObject;
    ((d)localObject).dBm = new c()
    {
      public final void onTaskFail(String paramAnonymousString, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskFail err_code = %s, url = %s,is_resume = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.gDf;
        AppBrandVideoDownLoadMgr.ah(paramAnonymousString, false);
        ((a)AppBrandVideoDownLoadMgr.Qq().get(paramAnonymousString)).gDb.aS(paramAnonymousString, paramAnonymousInt);
      }
      
      public final void onTaskSucc(String paramAnonymousString1, String paramAnonymousString2, boolean paramAnonymousBoolean)
      {
        y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo onTaskSucc save_path = %s, url = %s, is_resume = %s", new Object[] { paramAnonymousString2, paramAnonymousString1, Boolean.valueOf(paramAnonymousBoolean) });
        AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.gDf;
        AppBrandVideoDownLoadMgr.ah(paramAnonymousString1, true);
        ((a)AppBrandVideoDownLoadMgr.Qq().get(paramAnonymousString1)).gDb.bN(paramAnonymousString1, paramAnonymousString2);
      }
    };
  }
  
  static void ag(String paramString, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return;
      String str = uG(paramString);
      synchronized (gDd)
      {
        if (gDd.containsKey(str)) {
          gDd.remove(str);
        }
        ??? = (a)gDe.get(paramString);
        if (??? != null)
        {
          if ((((a)???).url.equalsIgnoreCase(paramString)) && (((a)???).startTimeStamp > 0L)) {
            ((a)???).gCZ = bk.cp(((a)???).startTimeStamp);
          }
          if (paramBoolean)
          {
            ((a)???).gDa = c.a.cfM;
            return;
          }
        }
      }
    }
    ((a)???).gDa = c.a.cfN;
  }
  
  private static String getParentDir(String paramString)
  {
    paramString = getParentDirWithoutCheckExistence(paramString);
    h.Vu(paramString);
    try
    {
      new File(paramString, ".nomedia").createNewFile();
      return paramString;
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  private static String getParentDirWithoutCheckExistence(String paramString)
  {
    return gDc + paramString + "/";
  }
  
  private static String uF(String paramString)
  {
    synchronized (gDd)
    {
      if (gDd.containsKey(paramString))
      {
        paramString = (String)gDd.get(paramString);
        return paramString;
      }
      return null;
    }
  }
  
  private static String uG(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    if (localUri.getHost().equalsIgnoreCase("wxsnsdy.wxs.qq.com")) {
      return localUri.getQueryParameter("m");
    }
    return "unverify" + ad.bB(paramString);
  }
  
  @Keep
  String genAdFileExist(String paramString, a parama)
  {
    if ((bk.bl(paramString)) || (bk.bl(parama.url))) {
      y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error source or videoUrl = %s", new Object[] { parama.url });
    }
    String str1;
    File localFile;
    String str2;
    do
    {
      return null;
      str1 = uG(parama.url);
      if (bk.bl(str1))
      {
        y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFileExist error urlFileMd5 = %s or videoUrl = %s", new Object[] { str1, parama.url });
        return null;
      }
      if (!bk.bl(uF(str1))) {
        return "downloading";
      }
      paramString = getParentDirWithoutCheckExistence(paramString) + str1 + ".gad";
      localFile = new File(paramString);
      str2 = g.m(localFile);
    } while ((!localFile.exists()) || ((!str1.startsWith("unverify")) && ((str2 == null) || (!str2.equalsIgnoreCase(str1)))));
    parama.gCZ = 0L;
    parama.gDa = c.a.cfM;
    return paramString;
  }
  
  @Keep
  String genAdFilePath(String arg1, a parama)
  {
    if ((bk.bl(???)) || (bk.bl(parama.url))) {
      y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error source or videoUrl = %s", new Object[] { parama.url });
    }
    String str;
    do
    {
      return null;
      str = uG(parama.url);
      if (bk.bl(str))
      {
        y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genAdFilePath error urlFileMd5 = %s or videoUrl = %s", new Object[] { str, parama.url });
        return null;
      }
    } while (!bk.bl(uF(str)));
    parama.startTimeStamp = bk.UZ();
    parama.gDa = c.a.cfL;
    parama = getParentDir(???) + str + ".gad";
    synchronized (gDd)
    {
      gDd.put(str, parama);
      return parama;
    }
  }
  
  /* Error */
  public final void report(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 94	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   6: ifeq +13 -> 19
    //   9: ldc 200
    //   11: ldc 250
    //   13: invokestatic 252	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: getstatic 32	com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoDownLoadMgr:gDe	Ljava/util/Map;
    //   22: aload_1
    //   23: invokeinterface 111 2 0
    //   28: checkcast 113	com/tencent/mm/plugin/appbrand/jsapi/video/a
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +23 -> 56
    //   36: aload_2
    //   37: getfield 130	com/tencent/mm/plugin/appbrand/jsapi/video/a:gCZ	J
    //   40: lconst_0
    //   41: lcmp
    //   42: iflt +14 -> 56
    //   45: aload_1
    //   46: aload_2
    //   47: getfield 116	com/tencent/mm/plugin/appbrand/jsapi/video/a:url	Ljava/lang/String;
    //   50: invokevirtual 119	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   53: ifne +18 -> 71
    //   56: ldc 200
    //   58: ldc 254
    //   60: invokestatic 252	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: goto -47 -> 16
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: ldc 200
    //   73: ldc_w 256
    //   76: iconst_2
    //   77: anewarray 4	java/lang/Object
    //   80: dup
    //   81: iconst_0
    //   82: aload_2
    //   83: getfield 130	com/tencent/mm/plugin/appbrand/jsapi/video/a:gCZ	J
    //   86: invokestatic 262	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload_2
    //   93: getfield 139	com/tencent/mm/plugin/appbrand/jsapi/video/a:gDa	Lcom/tencent/mm/h/b/a/c$a;
    //   96: aastore
    //   97: invokestatic 208	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: new 264	com/tencent/mm/h/b/a/c
    //   103: dup
    //   104: invokespecial 265	com/tencent/mm/h/b/a/c:<init>	()V
    //   107: astore_3
    //   108: aload_3
    //   109: aload_1
    //   110: putfield 268	com/tencent/mm/h/b/a/c:cfH	Ljava/lang/String;
    //   113: aload_3
    //   114: aload_2
    //   115: getfield 130	com/tencent/mm/plugin/appbrand/jsapi/video/a:gCZ	J
    //   118: putfield 271	com/tencent/mm/h/b/a/c:cfI	J
    //   121: aload_3
    //   122: aload_2
    //   123: getfield 139	com/tencent/mm/plugin/appbrand/jsapi/video/a:gDa	Lcom/tencent/mm/h/b/a/c$a;
    //   126: putfield 274	com/tencent/mm/h/b/a/c:cfJ	Lcom/tencent/mm/h/b/a/c$a;
    //   129: aload_3
    //   130: invokevirtual 277	com/tencent/mm/h/b/a/c:QX	()Z
    //   133: pop
    //   134: goto -118 -> 16
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	AppBrandVideoDownLoadMgr
    //   0	137	1	paramString	String
    //   31	92	2	locala	a
    //   107	23	3	localc	com.tencent.mm.h.b.a.c
    // Exception table:
    //   from	to	target	type
    //   2	16	66	finally
    //   19	32	66	finally
    //   36	56	66	finally
    //   56	63	66	finally
    //   71	134	66	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoDownLoadMgr
 * JD-Core Version:    0.7.0.1
 */