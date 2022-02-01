package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/report/LiveAnchorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorMaxiViewCost", "", "cost", "", "markAnchorMiniViewCost", "markAnchorNetStatusBad", "markAnchorNetStatusDisable", "markAnchorNetStatusGood", "markAnchorNetStatusNormal", "markAnchorRendererFpsHigh", "markAnchorRendererFpsLow", "markAnchorRendererFpsMiddle", "markAnchorRendererFpsValue", "fpsValue", "markAnchorRendererPerFrameCost", "markAnchorRendererPreviewHeight", "height", "markAnchorRendererPreviewWidth", "width", "plugin-core_release"})
public final class a
{
  public static final a qUt;
  
  static
  {
    AppMethodBeat.i(205816);
    qUt = new a();
    AppMethodBeat.o(205816);
  }
  
  public static final void CH(int paramInt)
  {
    AppMethodBeat.i(205810);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1384, 7, 8, paramInt, false);
    AppMethodBeat.o(205810);
  }
  
  public static final void CP(int paramInt)
  {
    AppMethodBeat.i(205811);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMiniViewCost is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1384, 10, 11, paramInt, false);
    AppMethodBeat.o(205811);
  }
  
  public static final void CT(int paramInt)
  {
    AppMethodBeat.i(205812);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPerFrameCost is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1384, 13, 14, paramInt, false);
    AppMethodBeat.o(205812);
  }
  
  public static final void CU(int paramInt)
  {
    AppMethodBeat.i(205813);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsValue is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1384, 16, 17, paramInt, false);
    AppMethodBeat.o(205813);
  }
  
  public static final void Db(int paramInt)
  {
    AppMethodBeat.i(205814);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1384, 19, 20, paramInt, false);
    AppMethodBeat.o(205814);
  }
  
  public static final void Dc(int paramInt)
  {
    AppMethodBeat.i(205815);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1384, 22, 23, paramInt, false);
    AppMethodBeat.o(205815);
  }
  
  public static final void cAj()
  {
    AppMethodBeat.i(205803);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsLow");
    h.vKh.m(1384L, 0L, 1L);
    AppMethodBeat.o(205803);
  }
  
  public static final void cQE()
  {
    AppMethodBeat.i(205804);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsMiddle");
    h.vKh.m(1384L, 1L, 1L);
    AppMethodBeat.o(205804);
  }
  
  public static final void cTL()
  {
    AppMethodBeat.i(205805);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsHigh");
    h.vKh.m(1384L, 2L, 1L);
    AppMethodBeat.o(205805);
  }
  
  public static final void deF()
  {
    AppMethodBeat.i(205806);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusGood");
    h.vKh.m(1384L, 3L, 1L);
    AppMethodBeat.o(205806);
  }
  
  public static final void dhn()
  {
    AppMethodBeat.i(205807);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusNormal");
    h.vKh.m(1384L, 4L, 1L);
    AppMethodBeat.o(205807);
  }
  
  public static final void dic()
  {
    AppMethodBeat.i(205808);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusBad");
    h.vKh.m(1384L, 5L, 1L);
    AppMethodBeat.o(205808);
  }
  
  public static final void dnA()
  {
    AppMethodBeat.i(205809);
    ad.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusDisable");
    h.vKh.m(1384L, 6L, 1L);
    AppMethodBeat.o(205809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.c.a
 * JD-Core Version:    0.7.0.1
 */