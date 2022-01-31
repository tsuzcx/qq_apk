package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;

public final class c
  implements o
{
  public final void AW(String paramString)
  {
    AppMethodBeat.i(132158);
    paramString = com.tencent.mm.plugin.appbrand.a.xN(paramString);
    if (paramString != null) {
      f.AW(bo.nullAsNil(paramString.cmF));
    }
    AppMethodBeat.o(132158);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(132157);
    Object localObject = com.tencent.mm.plugin.appbrand.a.xM(paramString1);
    if (localObject != null)
    {
      try
      {
        str = q.encode(paramString4, "utf-8");
        paramString4 = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          String str;
          int i;
          int j;
          ab.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report UnsupportedEncodingException");
        }
      }
      i = ((h)localObject).hiX.gXf;
      j = ((h)localObject).hiX.gXe + 1;
      str = e.cZ(ah.getContext());
      localObject = com.tencent.mm.plugin.appbrand.report.a.iFe;
      com.tencent.mm.plugin.appbrand.report.a.e(14510, new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), str, paramString2, paramString4, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (ab.getLogLevel() <= 1)
      {
        localObject = new StringBuilder("report kv_14510{");
        ((StringBuilder)localObject).append("appId='").append(paramString1).append('\'').append(", appVersion=").append(i).append(", appState=").append(j).append(", networkType='").append(str).append('\'').append(", functionName='").append(paramString2).append('\'').append(", url='").append(paramString4).append('\'').append(", method='").append(paramString3).append('\'').append(", sentsize=").append(paramLong1).append(", receivedsize=").append(paramLong2).append(", statusCode=").append(paramInt1).append(", result=").append(paramInt2).append(", costtime=").append(paramInt3).append('}');
        ab.d("MicroMsg.AppBrand.Report.kv_14510", ((StringBuilder)localObject).toString());
      }
      AppMethodBeat.o(132157);
      return;
    }
    ab.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", new Object[] { paramString1 });
    AppMethodBeat.o(132157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.c
 * JD-Core Version:    0.7.0.1
 */