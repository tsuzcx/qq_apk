package com.tencent.mm.plugin.base.stub;

import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.protocal.protobuf.fqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.CountDownLatch;

final class f$2
  implements z.a
{
  f$2(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean, MatrixCursor paramMatrixCursor, CountDownLatch paramCountDownLatch) {}
  
  public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(22228);
    Log.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(this.vrZ) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      f.C(false, this.vrZ);
      AppMethodBeat.o(22228);
      return 0;
    }
    f.C(true, this.vrZ);
    paramString = ((fqi)c.c.b(paramc.otC)).abQf;
    paramc = Uri.parse(paramString);
    paramc.getQueryParameter("appid");
    paramp = paramc.getQueryParameter("userName");
    String str = paramc.getQueryParameter("path");
    long l = Util.safeParseLong(paramc.getQueryParameter("validTime"));
    f.a(this.vsa, this.vsb, this.ryL, this.vsc, this.val$type, paramString, l);
    if (this.vrZ != 1)
    {
      AppMethodBeat.o(22228);
      return 0;
    }
    ((com.tencent.mm.plugin.appbrand.launching.b.a.a)h.ax(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).eP(paramp, str);
    if (this.vsd) {
      f.a(paramp, str, this.vse, this.val$countDownLatch);
    }
    for (;;)
    {
      AppMethodBeat.o(22228);
      return 0;
      ((com.tencent.mm.plugin.appbrand.launching.b.a.a)h.ax(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).a(paramp, new androidx.a.a.c.a()
      {
        private static Void l(WxaAttributes paramAnonymousWxaAttributes)
        {
          AppMethodBeat.i(268997);
          if (paramAnonymousWxaAttributes != null) {}
          try
          {
            if (paramAnonymousWxaAttributes.cld().aqJ()) {
              ((g)h.ax(g.class)).c(ab.tTQ);
            }
            for (;;)
            {
              AppMethodBeat.o(268997);
              return null;
              if (!paramAnonymousWxaAttributes.cld().clj()) {
                break;
              }
              ((g)h.ax(g.class)).a(ab.tTQ);
            }
          }
          catch (Exception paramAnonymousWxaAttributes)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WXBizLogic", paramAnonymousWxaAttributes, "prefetchWxaAttrs-preloadEnv", new Object[0]);
              continue;
              ((g)h.ax(g.class)).b(ab.tTQ);
            }
          }
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.2
 * JD-Core Version:    0.7.0.1
 */