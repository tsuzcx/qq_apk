package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/core/report/LiveVisitorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markVisitorGaussAnchorAvatarCost", "", "cost", "markVisitorLinkVideoPreviewHeight", "height", "", "markVisitorLinkVideoPreviewWidth", "width", "markVisitorLinkVideoRendererCostPerFrame", "markVisitorLinkVideoRendererFps", "fpsValue", "markVisitorLinkVideoRendererFpsHigh", "markVisitorLinkVideoRendererFpsLow", "markVisitorLinkVideoRendererFpsMiddle", "markVisitorMaxiViewCost", "markVisitorMiniViewCost", "markVisitorRenderAnchorCostPerFrame", "markVisitorRendererAnchorFps", "markVisitorRendererAnchorFpsHigh", "markVisitorRendererAnchorFpsLow", "markVisitorRendererAnchorFpsMiddle", "plugin-core_release"})
public final class b
{
  public static final b qUu;
  
  static
  {
    AppMethodBeat.i(205832);
    qUu = new b();
    AppMethodBeat.o(205832);
  }
  
  public static final void Bc(long paramLong)
  {
    AppMethodBeat.i(205821);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRenderAnchorCostPerFrame is ".concat(String.valueOf(paramLong)));
    h.vKh.c(1383, 6, 7, (int)paramLong, false);
    AppMethodBeat.o(205821);
  }
  
  public static final void Bd(long paramLong)
  {
    AppMethodBeat.i(205822);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorGaussAnchorAvatarCost is ".concat(String.valueOf(paramLong)));
    h.vKh.c(1383, 9, 10, (int)paramLong, false);
    AppMethodBeat.o(205822);
  }
  
  public static final void Dd(int paramInt)
  {
    AppMethodBeat.i(205820);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFps value is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1383, 3, 4, paramInt, false);
    AppMethodBeat.o(205820);
  }
  
  public static final void Kg(int paramInt)
  {
    AppMethodBeat.i(205823);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewWidth is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1383, 12, 13, paramInt, false);
    AppMethodBeat.o(205823);
  }
  
  public static final void PJ(int paramInt)
  {
    AppMethodBeat.i(205824);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1383, 15, 16, paramInt, false);
    AppMethodBeat.o(205824);
  }
  
  public static final void UO(int paramInt)
  {
    AppMethodBeat.i(205825);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1383, 18, 19, paramInt, false);
    AppMethodBeat.o(205825);
  }
  
  public static final void WG(int paramInt)
  {
    AppMethodBeat.i(205826);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMiniViewCost is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1383, 21, 22, paramInt, false);
    AppMethodBeat.o(205826);
  }
  
  public static final void WH(int paramInt)
  {
    AppMethodBeat.i(205827);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererCostPerFrame is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1383, 24, 25, paramInt, false);
    AppMethodBeat.o(205827);
  }
  
  public static final void aap(int paramInt)
  {
    AppMethodBeat.i(205828);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFps is ".concat(String.valueOf(paramInt)));
    h.vKh.c(1383, 27, 28, paramInt, false);
    AppMethodBeat.o(205828);
  }
  
  public static final void dPs()
  {
    AppMethodBeat.i(205818);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsMiddle");
    h.vKh.m(1383L, 1L, 1L);
    AppMethodBeat.o(205818);
  }
  
  public static final void dQX()
  {
    AppMethodBeat.i(205819);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsHigh");
    h.vKh.m(1383L, 2L, 1L);
    AppMethodBeat.o(205819);
  }
  
  public static final void dQY()
  {
    AppMethodBeat.i(205829);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsLow");
    h.vKh.m(1383L, 30L, 1L);
    AppMethodBeat.o(205829);
  }
  
  public static final void dRa()
  {
    AppMethodBeat.i(205830);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsMiddle");
    h.vKh.m(1383L, 31L, 1L);
    AppMethodBeat.o(205830);
  }
  
  public static final void dRb()
  {
    AppMethodBeat.i(205831);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsHigh");
    h.vKh.m(1383L, 32L, 1L);
    AppMethodBeat.o(205831);
  }
  
  public static final void dqi()
  {
    AppMethodBeat.i(205817);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsLow");
    h.vKh.m(1383L, 0L, 1L);
    AppMethodBeat.o(205817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.c.b
 * JD-Core Version:    0.7.0.1
 */