package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.p.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class l
  implements g
{
  public final int a(String paramString, c paramc)
  {
    int i = -1;
    AppMethodBeat.i(46962);
    Object localObject = AppBrandVideoDownLoadMgr.szl;
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
      AppMethodBeat.o(46962);
      return -1;
    }
    a locala = new a();
    locala.url = paramString;
    locala.szh = paramc;
    Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s, preLoadVideoStat = %s", new Object[] { paramString, locala.url });
    paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFileExist("gamead", locala);
    if (!Util.isNullOrNil(paramString)) {
      if (!paramString.equalsIgnoreCase("downloading"))
      {
        AppBrandVideoDownLoadMgr.szk.put(locala.url, locala);
        AppBrandVideoDownLoadMgr.aH(locala.url, true);
        locala.szh.er(locala.url, paramString);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(46962);
      return 0;
      AppMethodBeat.o(46962);
      return -2;
      paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFilePath("gamead", locala);
      if (Util.isNullOrNil(paramString)) {
        break;
      }
      paramc = AppBrandVideoDownLoadMgr.szm;
      localObject = locala.url;
      if (d.mbj != null) {
        i = d.mbj.a((String)localObject, paramString, paramc);
      }
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", new Object[] { paramString, Integer.valueOf(i) });
      if (i != 0)
      {
        AppMethodBeat.o(46962);
        return -3;
      }
      AppBrandVideoDownLoadMgr.szk.put(locala.url, locala);
    }
    AppMethodBeat.o(46962);
    return -4;
  }
  
  public final String abM(String paramString)
  {
    AppMethodBeat.i(46964);
    AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.szl;
    a locala = new a();
    locala.url = paramString;
    locala.szh = null;
    paramString = localAppBrandVideoDownLoadMgr.genAdFileExist("gamead", locala);
    if (!Util.isNullOrNil(paramString))
    {
      if (!paramString.equalsIgnoreCase("downloading"))
      {
        AppMethodBeat.o(46964);
        return paramString;
      }
      AppMethodBeat.o(46964);
      return null;
    }
    AppMethodBeat.o(46964);
    return null;
  }
  
  public final void report(String paramString)
  {
    AppMethodBeat.i(46963);
    AppBrandVideoDownLoadMgr.szl.report(paramString);
    AppMethodBeat.o(46963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.l
 * JD-Core Version:    0.7.0.1
 */