package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

public final class i
{
  private static void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(131350);
    long l = bo.aoy();
    String str1 = at.gX(ah.getContext());
    String str2 = at.gY(ah.getContext());
    paramString1 = paramString3 + "," + paramString2 + "," + paramString1 + "," + l + "," + paramLong + "," + paramInt + "," + aDS() + "," + str1 + "," + str2 + ",,";
    ab.v("MicroMsg.MiniProgramNavigatorAdReportHelper", "closeType:%d stayTime:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    AdReportCgiHelper.a(16004, paramString1, null);
    AppMethodBeat.o(131350);
  }
  
  public static void a(String paramString1, String paramString2, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(131348);
    if (paramAppBrandStatObject == null)
    {
      AppMethodBeat.o(131348);
      return;
    }
    String str = paramAppBrandStatObject.hST;
    if (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(131348);
      return;
    }
    e.a(paramString1, new i.1(paramString1, paramString2, str, System.currentTimeMillis(), paramAppBrandStatObject));
    AppMethodBeat.o(131348);
  }
  
  private static int aDS()
  {
    AppMethodBeat.i(131351);
    switch (at.getNetType(ah.getContext()))
    {
    case 9: 
    default: 
      AppMethodBeat.o(131351);
      return 6;
    case -1: 
      AppMethodBeat.o(131351);
      return 255;
    case 0: 
      AppMethodBeat.o(131351);
      return 1;
    case 3: 
    case 4: 
      AppMethodBeat.o(131351);
      return 4;
    case 2: 
    case 5: 
    case 7: 
      AppMethodBeat.o(131351);
      return 2;
    case 1: 
    case 6: 
    case 8: 
      AppMethodBeat.o(131351);
      return 3;
    }
    AppMethodBeat.o(131351);
    return 5;
  }
  
  public static void b(String paramString1, String paramString2, AppBrandStatObject paramAppBrandStatObject)
  {
    AppMethodBeat.i(131349);
    if (paramAppBrandStatObject == null)
    {
      AppMethodBeat.o(131349);
      return;
    }
    if (bo.isNullOrNil(paramAppBrandStatObject.hST))
    {
      AppMethodBeat.o(131349);
      return;
    }
    a(4, paramString1, paramString2, paramAppBrandStatObject.hST, 0L);
    AppMethodBeat.o(131349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i
 * JD-Core Version:    0.7.0.1
 */