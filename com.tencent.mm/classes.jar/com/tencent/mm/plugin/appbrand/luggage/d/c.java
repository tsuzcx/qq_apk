package com.tencent.mm.plugin.appbrand.luggage.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.q.o;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.UnsupportedEncodingException;

public final class c
  implements o
{
  public final void GU(String paramString)
  {
    AppMethodBeat.i(47583);
    paramString = com.tencent.mm.plugin.appbrand.a.CT(paramString);
    if (paramString != null) {
      f.GU(bt.nullAsNil(paramString.dbt));
    }
    AppMethodBeat.o(47583);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(47582);
    Object localObject = com.tencent.mm.plugin.appbrand.a.CS(paramString1);
    if (localObject != null)
    {
      try
      {
        str = p.encode(paramString4, "utf-8");
        paramString4 = str;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          String str;
          int i;
          int j;
          int k;
          ad.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report UnsupportedEncodingException");
        }
      }
      i = ((k)localObject).jdS.pkgVersion;
      j = ((k)localObject).jdS.iOQ + 1;
      str = h.getNetworkType(aj.getContext());
      k = h.Mt(paramString1);
      localObject = com.tencent.mm.plugin.appbrand.report.a.loy;
      com.tencent.mm.plugin.appbrand.report.a.f(14510, new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), str, paramString2, paramString4, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString5, paramString6, Integer.valueOf(k) });
      if (ad.getLogLevel() <= 1)
      {
        localObject = new StringBuilder("report kv_14510{");
        ((StringBuilder)localObject).append("appId='").append(paramString1).append('\'').append(", appVersion=").append(i).append(", appState=").append(j).append(", appType=").append(k).append(", networkType='").append(str).append('\'').append(", functionName='").append(paramString2).append('\'').append(", url='").append(paramString4).append('\'').append(", method='").append(paramString3).append('\'').append(", sentsize=").append(paramLong1).append(", receivedsize=").append(paramLong2).append(", statusCode=").append(paramInt1).append(", result=").append(paramInt2).append(", costtime=").append(paramInt3).append(", dstPath=").append(paramString5).append(", contentType=").append(paramString6).append('}');
        ad.d("MicroMsg.AppBrand.Report.kv_14510", ((StringBuilder)localObject).toString());
      }
      AppMethodBeat.o(47582);
      return;
    }
    ad.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", new Object[] { paramString1 });
    AppMethodBeat.o(47582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.d.c
 * JD-Core Version:    0.7.0.1
 */