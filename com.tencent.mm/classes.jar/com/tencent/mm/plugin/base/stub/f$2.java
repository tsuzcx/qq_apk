package com.tencent.mm.plugin.base.stub;

import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.protocal.protobuf.ekq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.CountDownLatch;

final class f$2
  implements aa.a
{
  f$2(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, boolean paramBoolean, MatrixCursor paramMatrixCursor, CountDownLatch paramCountDownLatch) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    AppMethodBeat.i(22228);
    Log.i("MicroMsg.WXBizLogic", "doMiniProgramTranslateLink, %d, %d, %s, cgiType=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(this.pee) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      f.z(false, this.pee);
      AppMethodBeat.o(22228);
      return 0;
    }
    f.z(true, this.pee);
    paramString = ((ekq)paramd.iLL.iLR).NjQ;
    paramd = Uri.parse(paramString);
    paramd.getQueryParameter("appid");
    paramq = paramd.getQueryParameter("userName");
    String str = paramd.getQueryParameter("path");
    long l = Util.safeParseLong(paramd.getQueryParameter("validTime"));
    f.a(this.pef, this.peg, this.cQM, this.peh, this.val$type, paramString, l);
    if (this.pee != 1)
    {
      AppMethodBeat.o(22228);
      return 0;
    }
    ((com.tencent.mm.plugin.appbrand.launching.b.a.a)g.af(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).ek(paramq, str);
    if (this.pei) {
      f.a(paramq, str, this.pej, this.val$countDownLatch);
    }
    for (;;)
    {
      AppMethodBeat.o(22228);
      return 0;
      ((com.tencent.mm.plugin.appbrand.launching.b.a.a)g.af(com.tencent.mm.plugin.appbrand.launching.b.a.a.class)).a(paramq, new android.arch.a.c.a()
      {
        private static Void l(WxaAttributes paramAnonymousWxaAttributes)
        {
          AppMethodBeat.i(231610);
          if (paramAnonymousWxaAttributes != null) {}
          try
          {
            if (paramAnonymousWxaAttributes.bAn().NA()) {
              ((com.tencent.mm.plugin.appbrand.service.f)g.af(com.tencent.mm.plugin.appbrand.service.f.class)).c(z.nMH);
            }
            for (;;)
            {
              AppMethodBeat.o(231610);
              return null;
              if (!paramAnonymousWxaAttributes.bAn().bAt()) {
                break;
              }
              ((com.tencent.mm.plugin.appbrand.service.f)g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.nMH);
            }
          }
          catch (Exception paramAnonymousWxaAttributes)
          {
            for (;;)
            {
              Log.printErrStackTrace("MicroMsg.WXBizLogic", paramAnonymousWxaAttributes, "prefetchWxaAttrs-preloadEnv", new Object[0]);
              continue;
              ((com.tencent.mm.plugin.appbrand.service.f)g.af(com.tencent.mm.plugin.appbrand.service.f.class)).b(z.nMH);
            }
          }
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.f.2
 * JD-Core Version:    0.7.0.1
 */