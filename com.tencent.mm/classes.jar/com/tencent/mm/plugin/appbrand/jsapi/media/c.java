package com.tencent.mm.plugin.appbrand.jsapi.media;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow;", "", "mComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "mSourceType", "", "mCapture", "mMediaType", "mShowRawButton", "", "maxDuration", "maxCount", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;IIIZII)V", "mMaxCount", "mMaxDuration", "goAlbumUI", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "goSightCaptureUI", "startChoose", "Companion", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c.a hQr;
  private final com.tencent.mm.plugin.appbrand.jsapi.c bDN;
  private final int hQm;
  private final int hQn;
  private final int hQo;
  private final int hQp;
  private final boolean hQq;
  private final int mMaxCount;
  
  static
  {
    AppMethodBeat.i(143805);
    hQr = new c.a((byte)0);
    AppMethodBeat.o(143805);
  }
  
  public c(com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    AppMethodBeat.i(143804);
    this.bDN = paramc;
    this.hQn = paramInt1;
    this.hQo = paramInt2;
    this.hQp = paramInt3;
    this.hQq = paramBoolean;
    this.hQm = Math.min(Math.max(paramInt4, 1), 60);
    this.mMaxCount = Math.min(Math.max(1, 1), 9);
    AppMethodBeat.o(143804);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.c
 * JD-Core Version:    0.7.0.1
 */