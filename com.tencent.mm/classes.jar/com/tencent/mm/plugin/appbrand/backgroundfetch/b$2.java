package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.cmn;
import com.tencent.mm.protocal.c.cmo;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class b$2
  implements b.a
{
  b$2(i parami, cmn paramcmn, int paramInt) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.ecF.ecN != null) && ((paramb.ecF.ecN instanceof cmo)))
    {
      paramString = (cmo)paramb.ecF.ecN;
      if ((paramString.tZq != null) && (!paramString.tZq.isEmpty()))
      {
        y.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "batchFetchDataInternal, batch fetch data success");
        this.fKI.e(paramString.tZq, this.fKJ.tZp);
        return;
      }
      y.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "batchFetchDataInternal, batch fetch data fail:data is null");
      this.fKI.onFail(this.bns);
      return;
    }
    y.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler.javayhu", "batchFetchDataInternal, batch fetch data fail:request fail");
    this.fKI.onFail(this.bns);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.backgroundfetch.b.2
 * JD-Core Version:    0.7.0.1
 */