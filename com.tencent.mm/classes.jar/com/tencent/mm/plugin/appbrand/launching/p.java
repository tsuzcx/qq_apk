package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.aa.b;
import com.tencent.mm.plugin.appbrand.config.aa.c;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class p
{
  final int enterScene;
  final int kMt;
  final QualitySession ldW;
  final WxaAttributes.WxaVersionInfo mSb;
  final AppBrandPrepareTask.PrepareParams mTv;
  final a mTw;
  
  p(AppBrandPrepareTask.PrepareParams paramPrepareParams, a parama)
  {
    AppMethodBeat.i(180300);
    this.mTv = paramPrepareParams;
    this.enterScene = paramPrepareParams.jZJ;
    this.mSb = paramPrepareParams.mRd;
    this.kMt = this.mSb.appVersion;
    this.mTw = parama;
    this.ldW = paramPrepareParams.mRg;
    AppMethodBeat.o(180300);
  }
  
  public static abstract interface a
  {
    public abstract void a(com.tencent.mm.plugin.appbrand.jsapi.ab.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.p
 * JD-Core Version:    0.7.0.1
 */