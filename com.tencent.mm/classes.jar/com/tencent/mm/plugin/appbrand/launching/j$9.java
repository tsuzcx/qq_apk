package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

final class j$9
  extends az
{
  j$9(j paramj, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, ICommLibReader paramICommLibReader, QualitySession paramQualitySession, String paramString4, AppBrandLaunchFromNotifyReferrer paramAppBrandLaunchFromNotifyReferrer, String paramString5, b paramb, int paramInt4)
  {
    super(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramAppBrandLaunchReferrer, paramString3, paramICommLibReader, paramQualitySession, paramString4, paramAppBrandLaunchFromNotifyReferrer, paramString5, paramb, paramInt4);
  }
  
  final void bDN()
  {
    AppMethodBeat.i(281515);
    j.j(this.pTm);
    AppMethodBeat.o(281515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.j.9
 * JD-Core Version:    0.7.0.1
 */