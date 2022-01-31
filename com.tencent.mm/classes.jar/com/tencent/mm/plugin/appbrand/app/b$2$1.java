package com.tencent.mm.plugin.appbrand.app;

import android.net.Uri;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$2$1
  implements w.a
{
  b$2$1(b.2 param2, j paramj, com.tencent.mm.vending.g.b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(154320);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.w("MicroMsg.AppBrandMixExportLogicService", "processGetNickName errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(154320);
      return 0;
    }
    paramInt1 = this.gSt.ajn();
    paramString = this.gSt.ajl();
    ab.i("MicroMsg.AppBrandMixExportLogicService", "processGetNickName actionCode:%d", new Object[] { Integer.valueOf(paramInt1) });
    switch (paramInt1)
    {
    default: 
      paramString = null;
      paramb = null;
    }
    for (;;)
    {
      this.bDR.C(new Object[] { new Pair(paramb, paramString) });
      AppMethodBeat.o(154320);
      return 0;
      if (bo.isNullOrNil(paramString)) {
        break;
      }
      paramString = Uri.parse(paramString);
      paramb = paramString.getQueryParameter("nickname");
      paramString = paramString.getQueryParameter("headimgurl");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.b.2.1
 * JD-Core Version:    0.7.0.1
 */