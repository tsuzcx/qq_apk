package com.tencent.mm.plugin.appbrand.luggage.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;

public final class c
  implements com.tencent.mm.plugin.appbrand.t.n
{
  public final void YV(String paramString)
  {
    AppMethodBeat.i(47583);
    paramString = d.Ue(paramString);
    if (paramString != null) {
      f.YV(Util.nullAsNil(paramString.hzx));
    }
    AppMethodBeat.o(47583);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, String paramString5, String paramString6)
  {
    AppMethodBeat.i(47582);
    Object localObject = d.Ud(paramString1);
    if (localObject != null)
    {
      try
      {
        str = r.as(paramString4, "utf-8");
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
          Log.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report UnsupportedEncodingException");
        }
      }
      i = ((com.tencent.mm.plugin.appbrand.config.n)localObject).qYY.pkgVersion;
      j = ((com.tencent.mm.plugin.appbrand.config.n)localObject).qYY.qHO + 1;
      str = j.getNetworkType(MMApplicationContext.getContext());
      k = j.afN(paramString1);
      a.tMQ.b(14510, new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), str, paramString2, paramString4, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString5, paramString6, Integer.valueOf(k) });
      if (Log.getLogLevel() <= 1)
      {
        localObject = new StringBuilder("report kv_14510{");
        ((StringBuilder)localObject).append("appId='").append(paramString1).append('\'').append(", appVersion=").append(i).append(", appState=").append(j).append(", appType=").append(k).append(", networkType='").append(str).append('\'').append(", functionName='").append(paramString2).append('\'').append(", url='").append(paramString4).append('\'').append(", method='").append(paramString3).append('\'').append(", sentsize=").append(paramLong1).append(", receivedsize=").append(paramLong2).append(", statusCode=").append(paramInt1).append(", result=").append(paramInt2).append(", costtime=").append(paramInt3).append(", dstPath=").append(paramString5).append(", contentType=").append(paramString6).append('}');
        Log.d("MicroMsg.AppBrand.Report.kv_14510", ((StringBuilder)localObject).toString());
      }
      AppMethodBeat.o(47582);
      return;
    }
    Log.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", new Object[] { paramString1 });
    AppMethodBeat.o(47582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.c.c
 * JD-Core Version:    0.7.0.1
 */