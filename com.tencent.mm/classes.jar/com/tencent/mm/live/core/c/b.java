package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/core/report/LiveVisitorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markVisitorGaussAnchorAvatarCost", "", "cost", "markVisitorLinkVideoPreviewHeight", "height", "", "markVisitorLinkVideoPreviewWidth", "width", "markVisitorLinkVideoRendererCostPerFrame", "markVisitorLinkVideoRendererFps", "fpsValue", "markVisitorLinkVideoRendererFpsHigh", "markVisitorLinkVideoRendererFpsLow", "markVisitorLinkVideoRendererFpsMiddle", "markVisitorMaxiViewCost", "markVisitorMiniViewCost", "markVisitorRenderAnchorCostPerFrame", "markVisitorRendererAnchorFps", "markVisitorRendererAnchorFpsHigh", "markVisitorRendererAnchorFpsLow", "markVisitorRendererAnchorFpsMiddle", "plugin-core_release"})
public final class b
{
  public static final b gLV;
  
  static
  {
    AppMethodBeat.i(217028);
    gLV = new b();
    AppMethodBeat.o(217028);
  }
  
  public static final void amD()
  {
    AppMethodBeat.i(217013);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsLow");
    g.yhR.n(1383L, 0L, 1L);
    AppMethodBeat.o(217013);
  }
  
  public static final void amE()
  {
    AppMethodBeat.i(217014);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsMiddle");
    g.yhR.n(1383L, 1L, 1L);
    AppMethodBeat.o(217014);
  }
  
  public static final void amF()
  {
    AppMethodBeat.i(217015);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsHigh");
    g.yhR.n(1383L, 2L, 1L);
    AppMethodBeat.o(217015);
  }
  
  public static final void amG()
  {
    AppMethodBeat.i(217025);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsLow");
    g.yhR.n(1383L, 30L, 1L);
    AppMethodBeat.o(217025);
  }
  
  public static final void amH()
  {
    AppMethodBeat.i(217026);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsMiddle");
    g.yhR.n(1383L, 31L, 1L);
    AppMethodBeat.o(217026);
  }
  
  public static final void amI()
  {
    AppMethodBeat.i(217027);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsHigh");
    g.yhR.n(1383L, 32L, 1L);
    AppMethodBeat.o(217027);
  }
  
  public static final void nk(int paramInt)
  {
    AppMethodBeat.i(217016);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFps value is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1383, 3, 4, paramInt, false);
    AppMethodBeat.o(217016);
  }
  
  public static final void nl(int paramInt)
  {
    AppMethodBeat.i(217019);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewWidth is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1383, 12, 13, paramInt, false);
    AppMethodBeat.o(217019);
  }
  
  public static final void nm(int paramInt)
  {
    AppMethodBeat.i(217020);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewHeight is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1383, 15, 16, paramInt, false);
    AppMethodBeat.o(217020);
  }
  
  public static final void nn(int paramInt)
  {
    AppMethodBeat.i(217021);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1383, 18, 19, paramInt, false);
    AppMethodBeat.o(217021);
  }
  
  public static final void no(int paramInt)
  {
    AppMethodBeat.i(217022);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMiniViewCost is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1383, 21, 22, paramInt, false);
    AppMethodBeat.o(217022);
  }
  
  public static final void np(int paramInt)
  {
    AppMethodBeat.i(217023);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererCostPerFrame is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1383, 24, 25, paramInt, false);
    AppMethodBeat.o(217023);
  }
  
  public static final void nq(int paramInt)
  {
    AppMethodBeat.i(217024);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFps is ".concat(String.valueOf(paramInt)));
    g.yhR.c(1383, 27, 28, paramInt, false);
    AppMethodBeat.o(217024);
  }
  
  public static final void rf(long paramLong)
  {
    AppMethodBeat.i(217017);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRenderAnchorCostPerFrame is ".concat(String.valueOf(paramLong)));
    g.yhR.c(1383, 6, 7, (int)paramLong, false);
    AppMethodBeat.o(217017);
  }
  
  public static final void rg(long paramLong)
  {
    AppMethodBeat.i(217018);
    ad.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorGaussAnchorAvatarCost is ".concat(String.valueOf(paramLong)));
    g.yhR.c(1383, 9, 10, (int)paramLong, false);
    AppMethodBeat.o(217018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.c.b
 * JD-Core Version:    0.7.0.1
 */