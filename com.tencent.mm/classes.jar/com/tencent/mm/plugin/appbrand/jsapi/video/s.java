package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public final class s
  implements l
{
  public final String Ni(String paramString)
  {
    AppMethodBeat.i(46964);
    AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.kNZ;
    a locala = new a();
    locala.url = paramString;
    locala.kNV = null;
    paramString = localAppBrandVideoDownLoadMgr.genAdFileExist("gamead", locala);
    if (!bs.isNullOrNil(paramString))
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
    Object localObject = AppBrandVideoDownLoadMgr.kNZ;
    if ((paramString == null) || (bs.isNullOrNil(paramString)))
    {
      ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
      AppMethodBeat.o(46962);
      return -1;
    }
    a locala = new a();
    locala.url = paramString;
    locala.kNV = paramd;
    ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s, preLoadVideoStat = %s", new Object[] { paramString, locala.url });
    paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFileExist("gamead", locala);
    if (!bs.isNullOrNil(paramString)) {
      if (!paramString.equalsIgnoreCase("downloading"))
      {
        AppBrandVideoDownLoadMgr.kNY.put(locala.url, locala);
        AppBrandVideoDownLoadMgr.aq(locala.url, true);
        locala.kNV.du(locala.url, paramString);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(46962);
      return 0;
      AppMethodBeat.o(46962);
      return -2;
      paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFilePath("gamead", locala);
      if (bs.isNullOrNil(paramString)) {
        break;
      }
      paramd = AppBrandVideoDownLoadMgr.kOa;
      localObject = locala.url;
      if (com.tencent.mm.t.d.fLT != null) {
        i = com.tencent.mm.t.d.fLT.a((String)localObject, paramString, paramd);
      }
      ac.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", new Object[] { paramString, Integer.valueOf(i) });
      if (i != 0)
      {
        AppMethodBeat.o(46962);
        return -3;
      }
      AppBrandVideoDownLoadMgr.kNY.put(locala.url, locala);
    }
    AppMethodBeat.o(46962);
    return -4;
  }
  
  public final void report(String paramString)
  {
    AppMethodBeat.i(46963);
    AppBrandVideoDownLoadMgr.kNZ.report(paramString);
    AppMethodBeat.o(46963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.s
 * JD-Core Version:    0.7.0.1
 */