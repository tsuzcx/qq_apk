package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.t.d;
import java.util.Map;

public final class n
  implements e
{
  public final String CT(String paramString)
  {
    AppMethodBeat.i(131630);
    AppBrandVideoDownLoadMgr localAppBrandVideoDownLoadMgr = AppBrandVideoDownLoadMgr.ich;
    a locala = new a();
    locala.url = paramString;
    locala.icd = null;
    paramString = localAppBrandVideoDownLoadMgr.genAdFileExist("gamead", locala);
    if (!bo.isNullOrNil(paramString))
    {
      if (!paramString.equalsIgnoreCase("downloading"))
      {
        AppMethodBeat.o(131630);
        return paramString;
      }
      AppMethodBeat.o(131630);
      return null;
    }
    AppMethodBeat.o(131630);
    return null;
  }
  
  public final int a(String paramString, c paramc)
  {
    int i = -1;
    AppMethodBeat.i(131628);
    Object localObject = AppBrandVideoDownLoadMgr.ich;
    if ((paramString == null) || (bo.isNullOrNil(paramString)))
    {
      ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad illegal url or preLoadCallback");
      AppMethodBeat.o(131628);
      return -1;
    }
    a locala = new a();
    locala.url = paramString;
    locala.icd = paramc;
    ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad genPreLoad  videoUrl = %s", new Object[] { paramString });
    paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFileExist("gamead", locala);
    if (!bo.isNullOrNil(paramString)) {
      if (!paramString.equalsIgnoreCase("downloading"))
      {
        AppBrandVideoDownLoadMgr.icg.put(locala.url, locala);
        AppBrandVideoDownLoadMgr.al(locala.url, true);
        locala.icd.cw(locala.url, paramString);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(131628);
      return 0;
      AppMethodBeat.o(131628);
      return -2;
      paramString = ((AppBrandVideoDownLoadMgr)localObject).genAdFilePath("gamead", locala);
      if (bo.isNullOrNil(paramString)) {
        break;
      }
      paramc = AppBrandVideoDownLoadMgr.ici;
      localObject = locala.url;
      if (d.euM != null) {
        i = d.euM.a((String)localObject, paramString, paramc);
      }
      ab.i("MicroMsg.AppBrand.AppBrandVideoDownLoadMgr", "leonlad downloadVideo path=%s, ret=%d", new Object[] { paramString, Integer.valueOf(i) });
      if (i != 0)
      {
        AppMethodBeat.o(131628);
        return -3;
      }
      AppBrandVideoDownLoadMgr.icg.put(locala.url, locala);
    }
    AppMethodBeat.o(131628);
    return -4;
  }
  
  public final void report(String paramString)
  {
    AppMethodBeat.i(131629);
    AppBrandVideoDownLoadMgr.ich.report(paramString);
    AppMethodBeat.o(131629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.n
 * JD-Core Version:    0.7.0.1
 */