package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.s.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.y;

final class f
{
  final QualitySession fPC;
  final int fPF;
  final WxaAttributes gKm;
  final f.a gKn;
  
  f(String paramString, int paramInt, f.a parama, QualitySession paramQualitySession)
  {
    this.fPF = paramInt;
    this.gKm = e.aaT().d(paramString, new String[0]);
    this.gKn = parama;
    this.fPC = paramQualitySession;
    if (this.gKm == null) {
      y.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", " <init> get NULL record by username %s", new Object[] { paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f
 * JD-Core Version:    0.7.0.1
 */