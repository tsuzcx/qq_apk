package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

final class j$7
  extends aw
{
  j$7(j paramj, String paramString1, int paramInt1, boolean paramBoolean, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt2, String paramString2, QualitySession paramQualitySession, b paramb)
  {
    super(paramString1, paramInt1, paramBoolean, paramWxaVersionInfo, paramInt2, paramString2, paramQualitySession, paramb);
  }
  
  final void bDO()
  {
    AppMethodBeat.i(282108);
    j.h(this.pTm);
    AppMethodBeat.o(282108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j.7
 * JD-Core Version:    0.7.0.1
 */