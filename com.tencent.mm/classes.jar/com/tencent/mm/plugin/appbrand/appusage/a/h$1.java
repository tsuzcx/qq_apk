package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.sdk.platformtools.Log;

final class h$1
  implements Runnable
{
  h$1(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj) {}
  
  public final void run()
  {
    AppMethodBeat.i(44685);
    if (this.qRy == 1)
    {
      IPCRunCgi.a(h.c(this.qRy, this.qRz, this.qRA, this.qRB).bEF(), new IPCRunCgi.a()
      {
        public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, c paramAnonymousc)
        {
          AppMethodBeat.i(44683);
          Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick page click errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            Log.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
            AppMethodBeat.o(44683);
            return;
          }
          Log.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
          AppMethodBeat.o(44683);
        }
      });
      AppMethodBeat.o(44685);
      return;
    }
    new h(this.qRy, this.qRz, this.qRA, this.qRB) {}.bFJ();
    AppMethodBeat.o(44685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.h.1
 * JD-Core Version:    0.7.0.1
 */