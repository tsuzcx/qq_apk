package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.storage.b;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.config.ag.b;
import com.tencent.mm.plugin.appbrand.config.ag.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class p
{
  final int enterScene;
  final int qGg;
  final QualitySession qYm;
  final WxaAttributes.WxaVersionInfo sXV;
  final AppBrandPrepareTask.PrepareParams sZp;
  final a sZq;
  
  p(AppBrandPrepareTask.PrepareParams paramPrepareParams, a parama)
  {
    AppMethodBeat.i(180300);
    this.sZp = paramPrepareParams;
    this.enterScene = paramPrepareParams.pNJ;
    this.sXV = paramPrepareParams.sXa;
    this.qGg = this.sXV.appVersion;
    this.sZq = parama;
    this.qYm = paramPrepareParams.sXd;
    AppMethodBeat.o(180300);
  }
  
  public static abstract interface a
  {
    public abstract void b(c paramc, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.p
 * JD-Core Version:    0.7.0.1
 */