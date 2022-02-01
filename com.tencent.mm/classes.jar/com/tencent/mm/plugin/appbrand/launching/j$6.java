package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

final class j$6
  extends ax
{
  j$6(j paramj, String paramString1, int paramInt1, String paramString2, int paramInt2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, b paramb)
  {
    super(paramString1, paramInt1, paramString2, paramInt2, paramWxaVersionInfo, paramBoolean, paramICommLibReader, paramQualitySession, paramb, false);
    AppMethodBeat.i(277515);
    iS(this.pTm.pSU);
    iR(this.pTm.bZy());
    AppMethodBeat.o(277515);
  }
  
  public final void bZz()
  {
    AppMethodBeat.i(47124);
    super.bZz();
    j.g(this.pTm);
    AppMethodBeat.o(47124);
  }
  
  public final void onDownloadProgress(int paramInt)
  {
    AppMethodBeat.i(47126);
    super.onDownloadProgress(paramInt);
    if (this.pTm.pSP != null) {
      this.pTm.pSP.onDownloadProgress(paramInt);
    }
    AppMethodBeat.o(47126);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j.6
 * JD-Core Version:    0.7.0.1
 */