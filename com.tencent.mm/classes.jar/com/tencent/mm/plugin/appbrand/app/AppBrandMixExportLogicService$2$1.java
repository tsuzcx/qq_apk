package com.tencent.mm.plugin.appbrand.app;

import android.net.Uri;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.x.a;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class AppBrandMixExportLogicService$2$1
  implements x.a
{
  AppBrandMixExportLogicService$2$1(AppBrandMixExportLogicService.2 param2, k paramk, com.tencent.mm.vending.g.b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb, n paramn)
  {
    AppMethodBeat.i(44090);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.w("MicroMsg.AppBrandMixExportLogicService", "processGetNickName errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(44090);
      return 0;
    }
    paramInt1 = this.iJr.aAs();
    paramString = this.iJr.aAq();
    ad.i("MicroMsg.AppBrandMixExportLogicService", "processGetNickName actionCode:%d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    default: 
      paramString = null;
      paramb = null;
    }
    for (;;)
    {
      this.cgd.D(new Object[] { new Pair(paramb, paramString) });
      AppMethodBeat.o(44090);
      return 0;
      if (bt.isNullOrNil(paramString)) {
        break;
      }
      paramString = Uri.parse(paramString);
      paramb = paramString.getQueryParameter("nickname");
      paramString = paramString.getQueryParameter("headimgurl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService.2.1
 * JD-Core Version:    0.7.0.1
 */