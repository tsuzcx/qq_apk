package com.tencent.mm.plugin.appbrand.appusage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.sdk.platformtools.ae;

final class i$1
  implements Runnable
{
  i$1(int paramInt, long paramLong1, long paramLong2, AppBrandRecommendStatObj paramAppBrandRecommendStatObj) {}
  
  public final void run()
  {
    AppMethodBeat.i(44685);
    if (this.jUG == 1)
    {
      IPCRunCgi.a(i.a(this.jUG, this.jUH, this.jUI, this.jUJ).aDS(), new IPCRunCgi.a()
      {
        public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
        {
          AppMethodBeat.i(44683);
          ae.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "CgiRTReportRecommdClick page click errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            ae.i("MicroMsg.Recommend.CgiRTReportRecommdClick", "report success");
            AppMethodBeat.o(44683);
            return;
          }
          ae.e("MicroMsg.Recommend.CgiRTReportRecommdClick", "report fail");
          AppMethodBeat.o(44683);
        }
      });
      AppMethodBeat.o(44685);
      return;
    }
    new i(this.jUG, this.jUH, this.jUI, this.jUJ) {}.aET();
    AppMethodBeat.o(44685);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.a.i.1
 * JD-Core Version:    0.7.0.1
 */