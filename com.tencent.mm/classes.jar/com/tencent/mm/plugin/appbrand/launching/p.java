package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.b.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.plugin.appbrand.config.x.b;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

final class p
{
  final int enterScene;
  final int jHt;
  final QualitySession jXD;
  final WxaAttributes.WxaVersionInfo lFN;
  final AppBrandPrepareTask.PrepareParams lHf;
  final a lHg;
  
  p(AppBrandPrepareTask.PrepareParams paramPrepareParams, a parama)
  {
    AppMethodBeat.i(180300);
    this.lHf = paramPrepareParams;
    this.enterScene = paramPrepareParams.iYN;
    this.lFN = paramPrepareParams.lEQ;
    this.jHt = this.lFN.aDD;
    this.lHg = parama;
    this.jXD = paramPrepareParams.lET;
    AppMethodBeat.o(180300);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.y.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.p
 * JD-Core Version:    0.7.0.1
 */