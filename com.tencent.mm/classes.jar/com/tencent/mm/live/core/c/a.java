package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/report/LiveAnchorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorMaxiViewCost", "", "cost", "", "markAnchorMiniViewCost", "markAnchorNetStatusBad", "markAnchorNetStatusDisable", "markAnchorNetStatusGood", "markAnchorNetStatusNormal", "markAnchorRendererFpsHigh", "markAnchorRendererFpsLow", "markAnchorRendererFpsMiddle", "markAnchorRendererFpsValue", "fpsValue", "markAnchorRendererPerFrameCost", "markAnchorRendererPreviewHeight", "height", "markAnchorRendererPreviewWidth", "width", "plugin-core_release"})
public final class a
{
  public static final a gLU;
  
  static
  {
    AppMethodBeat.i(217012);
    gLU = new a();
    AppMethodBeat.o(217012);
  }
  
  public static final void amA()
  {
    AppMethodBeat.i(217003);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusNormal");
    g.yhR.n(1384L, 4L, 1L);
    AppMethodBeat.o(217003);
  }
  
  public static final void amB()
  {
    AppMethodBeat.i(217004);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusBad");
    g.yhR.n(1384L, 5L, 1L);
    AppMethodBeat.o(217004);
  }
  
  public static final void amC()
  {
    AppMethodBeat.i(217005);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusDisable");
    g.yhR.n(1384L, 6L, 1L);
    AppMethodBeat.o(217005);
  }
  
  public static final void amw()
  {
    AppMethodBeat.i(216999);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsLow");
    g.yhR.n(1384L, 0L, 1L);
    AppMethodBeat.o(216999);
  }
  
  public static final void amx()
  {
    AppMethodBeat.i(217000);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsMiddle");
    g.yhR.n(1384L, 1L, 1L);
    AppMethodBeat.o(217000);
  }
  
  public static final void amy()
  {
    AppMethodBeat.i(217001);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsHigh");
    g.yhR.n(1384L, 2L, 1L);
    AppMethodBeat.o(217001);
  }
  
  public static final void amz()
  {
    AppMethodBeat.i(217002);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusGood");
    g.yhR.n(1384L, 3L, 1L);
    AppMethodBeat.o(217002);
  }
  
  public static final void ne(int paramInt)
  {
    AppMethodBeat.i(217006);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1384, 7, 8, paramInt, false);
    AppMethodBeat.o(217006);
  }
  
  public static final void nf(int paramInt)
  {
    AppMethodBeat.i(217007);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMiniViewCost is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1384, 10, 11, paramInt, false);
    AppMethodBeat.o(217007);
  }
  
  public static final void ng(int paramInt)
  {
    AppMethodBeat.i(217008);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPerFrameCost is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1384, 13, 14, paramInt, false);
    AppMethodBeat.o(217008);
  }
  
  public static final void nh(int paramInt)
  {
    AppMethodBeat.i(217009);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsValue is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1384, 16, 17, paramInt, false);
    AppMethodBeat.o(217009);
  }
  
  public static final void ni(int paramInt)
  {
    AppMethodBeat.i(217010);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1384, 19, 20, paramInt, false);
    AppMethodBeat.o(217010);
  }
  
  public static final void nj(int paramInt)
  {
    AppMethodBeat.i(217011);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1384, 22, 23, paramInt, false);
    AppMethodBeat.o(217011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.c.a
 * JD-Core Version:    0.7.0.1
 */