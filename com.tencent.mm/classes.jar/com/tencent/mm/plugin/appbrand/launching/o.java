package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.aa.b;
import com.tencent.mm.plugin.appbrand.config.aa.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class o
{
  final int enterScene;
  final int nGn;
  final QualitySession nYk;
  final WxaAttributes.WxaVersionInfo pSV;
  final AppBrandPrepareTask.PrepareParams pUv;
  final a pUw;
  
  o(AppBrandPrepareTask.PrepareParams paramPrepareParams, a parama)
  {
    AppMethodBeat.i(180300);
    this.pUv = paramPrepareParams;
    this.enterScene = paramPrepareParams.mRc;
    this.pSV = paramPrepareParams.pRY;
    this.nGn = this.pSV.appVersion;
    this.pUw = parama;
    this.nYk = paramPrepareParams.pSb;
    AppMethodBeat.o(180300);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.ad.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.o
 * JD-Core Version:    0.7.0.1
 */