package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/report/LiveVisitorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markVisitorGaussAnchorAvatarCost", "", "cost", "markVisitorLinkVideoPreviewHeight", "height", "", "markVisitorLinkVideoPreviewWidth", "width", "markVisitorLinkVideoRendererCostPerFrame", "markVisitorLinkVideoRendererFps", "fpsValue", "markVisitorLinkVideoRendererFpsHigh", "markVisitorLinkVideoRendererFpsLow", "markVisitorLinkVideoRendererFpsMiddle", "markVisitorMaxiViewCost", "markVisitorMiniViewCost", "markVisitorRenderAnchorCostPerFrame", "markVisitorRendererAnchorFps", "markVisitorRendererAnchorFpsHigh", "markVisitorRendererAnchorFpsLow", "markVisitorRendererAnchorFpsMiddle", "plugin-core_release"})
public final class b
{
  public static final b gsn;
  
  static
  {
    AppMethodBeat.i(209370);
    gsn = new b();
    AppMethodBeat.o(209370);
  }
  
  public static final void ajR()
  {
    AppMethodBeat.i(209355);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsLow");
    h.wUl.n(1383L, 0L, 1L);
    AppMethodBeat.o(209355);
  }
  
  public static final void ajS()
  {
    AppMethodBeat.i(209356);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsMiddle");
    h.wUl.n(1383L, 1L, 1L);
    AppMethodBeat.o(209356);
  }
  
  public static final void ajT()
  {
    AppMethodBeat.i(209357);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsHigh");
    h.wUl.n(1383L, 2L, 1L);
    AppMethodBeat.o(209357);
  }
  
  public static final void ajU()
  {
    AppMethodBeat.i(209367);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsLow");
    h.wUl.n(1383L, 30L, 1L);
    AppMethodBeat.o(209367);
  }
  
  public static final void ajV()
  {
    AppMethodBeat.i(209368);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsMiddle");
    h.wUl.n(1383L, 31L, 1L);
    AppMethodBeat.o(209368);
  }
  
  public static final void ajW()
  {
    AppMethodBeat.i(209369);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsHigh");
    h.wUl.n(1383L, 32L, 1L);
    AppMethodBeat.o(209369);
  }
  
  public static final void mL(int paramInt)
  {
    AppMethodBeat.i(209358);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFps value is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1383, 3, 4, paramInt, false);
    AppMethodBeat.o(209358);
  }
  
  public static final void mM(int paramInt)
  {
    AppMethodBeat.i(209361);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewWidth is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1383, 12, 13, paramInt, false);
    AppMethodBeat.o(209361);
  }
  
  public static final void mN(int paramInt)
  {
    AppMethodBeat.i(209362);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1383, 15, 16, paramInt, false);
    AppMethodBeat.o(209362);
  }
  
  public static final void mO(int paramInt)
  {
    AppMethodBeat.i(209363);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1383, 18, 19, paramInt, false);
    AppMethodBeat.o(209363);
  }
  
  public static final void mP(int paramInt)
  {
    AppMethodBeat.i(209364);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMiniViewCost is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1383, 21, 22, paramInt, false);
    AppMethodBeat.o(209364);
  }
  
  public static final void mQ(int paramInt)
  {
    AppMethodBeat.i(209365);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererCostPerFrame is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1383, 24, 25, paramInt, false);
    AppMethodBeat.o(209365);
  }
  
  public static final void mR(int paramInt)
  {
    AppMethodBeat.i(209366);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFps is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1383, 27, 28, paramInt, false);
    AppMethodBeat.o(209366);
  }
  
  public static final void pe(long paramLong)
  {
    AppMethodBeat.i(209359);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRenderAnchorCostPerFrame is ".concat(String.valueOf(paramLong)));
    h.wUl.c(1383, 6, 7, (int)paramLong, false);
    AppMethodBeat.o(209359);
  }
  
  public static final void pf(long paramLong)
  {
    AppMethodBeat.i(209360);
    ac.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorGaussAnchorAvatarCost is ".concat(String.valueOf(paramLong)));
    h.wUl.c(1383, 9, 10, (int)paramLong, false);
    AppMethodBeat.o(209360);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.c.b
 * JD-Core Version:    0.7.0.1
 */