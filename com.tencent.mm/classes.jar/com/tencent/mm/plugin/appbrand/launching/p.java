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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class p
{
  final int enterScene;
  final QualitySession jDH;
  final int jnw;
  final WxaAttributes.WxaVersionInfo liI;
  final AppBrandPrepareTask.PrepareParams ljX;
  final a ljY;
  
  p(AppBrandPrepareTask.PrepareParams paramPrepareParams, a parama)
  {
    AppMethodBeat.i(180300);
    this.ljX = paramPrepareParams;
    this.enterScene = paramPrepareParams.iFE;
    this.liI = paramPrepareParams.lhP;
    this.jnw = this.liI.aBM;
    this.ljY = parama;
    this.jDH = paramPrepareParams.lhS;
    AppMethodBeat.o(180300);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.v.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.p
 * JD-Core Version:    0.7.0.1
 */