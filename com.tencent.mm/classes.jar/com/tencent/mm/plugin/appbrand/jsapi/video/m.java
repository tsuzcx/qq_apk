package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class m
  implements h
{
  public final int a(String paramString, d paramd)
  {
    int i = -1;
    AppMethodBeat.i(46962);
    Object localObject = AppBrandVideoDownLoadMgr.mvG;
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
      AppMethodBeat.o(46962);
      return -1;
    }
    a locala = new a();
    locala.url = paramString;
    locala.mvC = paramd;
    Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s, preLoadVideoStat = %s", new Object[] { paramString, locala.url });
    paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFileExist("gamead", locala);
    if (!Util.isNullOrNil(paramString)) {
      if (!paramString.equalsIgnoreCase("downloading"))
      {
        AppBrandVideoDownLoadMgr.mvF.put(locala.url, locala);
        AppBrandVideoDownLoadMgr.at(locala.url, true);
        locala.mvC.dN(locala.url, paramString);
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
      paramd = AppBrandVideoDownLoadMgr.mvH;
      localObject = locala.url;
      if (com.tencent.mm.s.d.gRd != null) {
        i = com.tencent.mm.s.d.gRd.a((String)localObject, paramString, paramd);
      }
      Log.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", new Object[] { paramString, Integer.valueOf(i) });
      if (i != 0)
      {
        AppMethodBeat.o(46962);
        return -3;
      }
      AppBrandVideoDownLoadMgr.mvF.put(locala.url, locala);
    }
    AppMethodBeat.o(46962);
    return -4;
  }
  
  public final String aaT(String paramString)
  {
    AppMethodBeat.i(46964);
    AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.mvG;
    a locala = new a();
    locala.url = paramString;
    locala.mvC = null;
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
    AppBrandVideoDownLoadMgr.mvG.report(paramString);
    AppMethodBeat.o(46963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.m
 * JD-Core Version:    0.7.0.1
 */