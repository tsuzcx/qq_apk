package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.at;
import com.tencent.mm.plugin.appbrand.appcache.ay;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

class ak
  extends ag<ab>
{
  final String appId;
  final int bDc;
  final int cJb;
  final int cxS;
  final int hEZ;
  final int hcr;
  final QualitySession hiI;
  final String hiw;
  final AppBrandLaunchReferrer hiz;
  final String ikK;
  
  ak(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, int paramInt4, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(131985);
    this.appId = paramString1;
    this.hcr = paramInt1;
    this.cJb = paramInt2;
    this.cxS = paramInt3;
    this.hiw = paramString2;
    this.hiz = paramAppBrandLaunchReferrer;
    this.ikK = paramString3;
    paramString1 = g.auM().a(paramString1, paramInt1, new String[] { "version" });
    if (paramString1 == null)
    {
      paramInt1 = i;
      this.bDc = paramInt1;
      if (paramInt4 < 0) {
        break label112;
      }
    }
    for (;;)
    {
      this.hEZ = paramInt4;
      this.hiI = paramQualitySession;
      AppMethodBeat.o(131985);
      return;
      paramInt1 = paramString1.field_version;
      break;
      label112:
      paramInt4 = ai.avE();
    }
  }
  
  void aub() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ak
 * JD-Core Version:    0.7.0.1
 */