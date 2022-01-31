package com.tencent.mm.plugin.appbrand.j.c;

import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.dynamic.f;
import com.tencent.mm.plugin.appbrand.o.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;

public final class c
  implements n
{
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = a.qo(paramString1);
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
          y.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report UnsupportedEncodingException");
        }
      }
      i = ((i)localObject).fPS.fEN;
      j = ((i)localObject).aej() + 1;
      str = com.tencent.mm.plugin.appbrand.report.c.cv(ae.getContext());
      h.nFQ.f(14510, new Object[] { paramString1, Integer.valueOf(i), Integer.valueOf(j), str, paramString2, paramString4, paramString3, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      localObject = new StringBuilder("report kv_14510{");
      ((StringBuilder)localObject).append("appId='").append(paramString1).append('\'').append(", appVersion=").append(i).append(", appState=").append(j).append(", networkType='").append(str).append('\'').append(", functionName='").append(paramString2).append('\'').append(", url='").append(paramString4).append('\'').append(", method='").append(paramString3).append('\'').append(", sentsize=").append(paramLong1).append(", receivedsize=").append(paramLong2).append(", statusCode=").append(paramInt1).append(", result=").append(paramInt2).append(", costtime=").append(paramInt3).append('}');
      y.d("MicroMsg.AppBrand.Report.kv_14510", ((StringBuilder)localObject).toString());
      return;
    }
    y.w("MicroMsg.AppBrand.Report.kv_14510", "kv_14510 report config is null. %s", new Object[] { paramString1 });
  }
  
  public final void sV(String paramString)
  {
    paramString = a.qp(paramString);
    if (paramString != null) {
      f.sV(bk.pm(paramString.bFv));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.c.c
 * JD-Core Version:    0.7.0.1
 */