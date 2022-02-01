package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public final class m
  implements h
{
  public final String QF(String paramString)
  {
    AppMethodBeat.i(46964);
    AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.lkC;
    a locala = new a();
    locala.url = paramString;
    locala.lky = null;
    paramString = localAppBrandVideoDownLoadMgr.genAdFileExist("gamead", locala);
    if (!bt.isNullOrNil(paramString))
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
  
  public final int a(String paramString, d paramd)
  {
    int i = -1;
    AppMethodBeat.i(46962);
    Object localObject = AppBrandVideoDownLoadMgr.lkC;
    if ((paramString == null) || (bt.isNullOrNil(paramString)))
    {
      ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
      AppMethodBeat.o(46962);
      return -1;
    }
    a locala = new a();
    locala.url = paramString;
    locala.lky = paramd;
    ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s, preLoadVideoStat = %s", new Object[] { paramString, locala.url });
    paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFileExist("gamead", locala);
    if (!bt.isNullOrNil(paramString)) {
      if (!paramString.equalsIgnoreCase("downloading"))
      {
        AppBrandVideoDownLoadMgr.lkB.put(locala.url, locala);
        AppBrandVideoDownLoadMgr.ar(locala.url, true);
        locala.lky.dw(locala.url, paramString);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(46962);
      return 0;
      AppMethodBeat.o(46962);
      return -2;
      paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFilePath("gamead", locala);
      if (bt.isNullOrNil(paramString)) {
        break;
      }
      paramd = AppBrandVideoDownLoadMgr.lkD;
      localObject = locala.url;
      if (com.tencent.mm.u.d.gft != null) {
        i = com.tencent.mm.u.d.gft.a((String)localObject, paramString, paramd);
      }
      ad.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", new Object[] { paramString, Integer.valueOf(i) });
      if (i != 0)
      {
        AppMethodBeat.o(46962);
        return -3;
      }
      AppBrandVideoDownLoadMgr.lkB.put(locala.url, locala);
    }
    AppMethodBeat.o(46962);
    return -4;
  }
  
  public final void report(String paramString)
  {
    AppMethodBeat.i(46963);
    AppBrandVideoDownLoadMgr.lkC.report(paramString);
    AppMethodBeat.o(46963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.m
 * JD-Core Version:    0.7.0.1
 */