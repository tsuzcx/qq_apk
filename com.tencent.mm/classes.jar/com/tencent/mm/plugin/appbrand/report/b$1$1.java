package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1$1
  implements com.tencent.mm.ipcinvoker.wx_extension.b.a
{
  b$1$1(b.1 param1) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(143515);
    ab.i("MicroMsg.AppBrandGameSamplingReportMgr", "hy: on get wxa game config resp: %d, %d, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb.fsW.fta != null))
    {
      paramString = (asx)paramb.fsW.fta;
      this.iFk.iFj.iFf = paramString.xie;
      this.iFk.iFj.iFg = paramString.xif;
    }
    if (this.iFk.iFi != null) {
      this.iFk.iFi.dd(paramInt1, paramInt2);
    }
    AppMethodBeat.o(143515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b.1.1
 * JD-Core Version:    0.7.0.1
 */