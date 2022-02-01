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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class p
{
  final int enterScene;
  final int jKu;
  final QualitySession kaS;
  final WxaAttributes.WxaVersionInfo lKm;
  final AppBrandPrepareTask.PrepareParams lLF;
  final a lLG;
  
  p(AppBrandPrepareTask.PrepareParams paramPrepareParams, a parama)
  {
    AppMethodBeat.i(180300);
    this.lLF = paramPrepareParams;
    this.enterScene = paramPrepareParams.jbG;
    this.lKm = paramPrepareParams.lJp;
    this.jKu = this.lKm.aDD;
    this.lLG = parama;
    this.kaS = paramPrepareParams.lJs;
    AppMethodBeat.o(180300);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.z.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.p
 * JD-Core Version:    0.7.0.1
 */