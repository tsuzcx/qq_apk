package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class m
  implements d
{
  public final int a(String paramString, b paramb)
  {
    int i = -1;
    Object localObject = AppBrandVideoDownLoadMgr.gDf;
    if ((paramString == null) || (bk.bl(paramString)))
    {
      y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
      return -1;
    }
    a locala = new a();
    locala.url = paramString;
    locala.gDb = paramb;
    y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s", new Object[] { paramString });
    paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFileExist("gamead", locala);
    if (!bk.bl(paramString)) {
      if (!paramString.equalsIgnoreCase("downloading"))
      {
        AppBrandVideoDownLoadMgr.gDe.put(locala.url, locala);
        AppBrandVideoDownLoadMgr.ag(locala.url, true);
        locala.gDb.bN(locala.url, paramString);
      }
    }
    for (;;)
    {
      return 0;
      return -2;
      paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFilePath("gamead", locala);
      if (bk.bl(paramString)) {
        break;
      }
      paramb = AppBrandVideoDownLoadMgr.gDg;
      localObject = locala.url;
      if (com.tencent.mm.t.d.dBl != null) {
        i = com.tencent.mm.t.d.dBl.a((String)localObject, paramString, paramb);
      }
      y.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", new Object[] { paramString, Integer.valueOf(i) });
      if (i != 0) {
        return -3;
      }
      AppBrandVideoDownLoadMgr.gDe.put(locala.url, locala);
    }
    return -4;
  }
  
  public final void report(String paramString)
  {
    AppBrandVideoDownLoadMgr.gDf.report(paramString);
  }
  
  public final String uH(String paramString)
  {
    AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.gDf;
    a locala = new a();
    locala.url = paramString;
    locala.gDb = null;
    paramString = localAppBrandVideoDownLoadMgr.genAdFileExist("gamead", locala);
    if (!bk.bl(paramString))
    {
      if (!paramString.equalsIgnoreCase("downloading")) {
        return paramString;
      }
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.m
 * JD-Core Version:    0.7.0.1
 */