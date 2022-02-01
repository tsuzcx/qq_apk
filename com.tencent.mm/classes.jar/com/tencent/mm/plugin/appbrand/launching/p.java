package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.plugin.appbrand.config.w.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class p
{
  final int enterScene;
  final int iNo;
  final QualitySession jdu;
  final WxaAttributes.WxaVersionInfo kHo;
  final AppBrandPrepareTask.PrepareParams kIB;
  final a kIC;
  
  p(AppBrandPrepareTask.PrepareParams paramPrepareParams, a parama)
  {
    AppMethodBeat.i(180300);
    this.kIB = paramPrepareParams;
    this.enterScene = paramPrepareParams.ifv;
    this.kHo = paramPrepareParams.kGw;
    this.iNo = this.kHo.aAS;
    this.kIC = parama;
    this.jdu = paramPrepareParams.kGz;
    AppMethodBeat.o(180300);
  }
  
  public static abstract interface a
  {
    public abstract void b(com.tencent.mm.plugin.appbrand.jsapi.w.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.p
 * JD-Core Version:    0.7.0.1
 */