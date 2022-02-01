package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

final class j$8
  extends ay
{
  j$8(j paramj, String paramString1, int paramInt, boolean paramBoolean, String paramString2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, QualitySession paramQualitySession)
  {
    super(paramString1, paramInt, paramBoolean, paramString2, paramWxaVersionInfo, paramQualitySession);
  }
  
  final void bDP()
  {
    AppMethodBeat.i(264155);
    j.i(this.pTm);
    AppMethodBeat.o(264155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j.8
 * JD-Core Version:    0.7.0.1
 */