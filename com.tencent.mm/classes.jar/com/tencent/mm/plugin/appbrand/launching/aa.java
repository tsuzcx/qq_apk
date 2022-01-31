package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.an;
import com.tencent.mm.plugin.appbrand.appcache.ar;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;

final class aa
  extends w<t>
{
  final String appId;
  final int caB;
  final int cau;
  final int fJy;
  final QualitySession fPC;
  final String fPq;
  final AppBrandLaunchReferrer fPr;
  final int gJU;
  final String gJV;
  final int glj;
  
  aa(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, String paramString3, int paramInt4, QualitySession paramQualitySession)
  {
    this.appId = paramString1;
    this.fJy = paramInt1;
    this.caB = paramInt2;
    this.gJU = paramInt3;
    this.fPq = paramString2;
    this.fPr = paramAppBrandLaunchReferrer;
    this.gJV = paramString3;
    paramString1 = e.abb().a(paramString1, paramInt1, new String[] { "version" });
    if (paramString1 == null)
    {
      paramInt1 = i;
      this.cau = paramInt1;
      if (paramInt4 < 0) {
        break label102;
      }
    }
    for (;;)
    {
      this.glj = paramInt4;
      this.fPC = paramQualitySession;
      return;
      paramInt1 = paramString1.field_version;
      break;
      label102:
      paramInt4 = ac.abM();
    }
  }
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aa
 * JD-Core Version:    0.7.0.1
 */