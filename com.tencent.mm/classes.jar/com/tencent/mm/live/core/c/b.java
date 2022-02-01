package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/report/LiveVisitorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markVisitorGaussAnchorAvatarCost", "", "cost", "markVisitorLinkVideoPreviewHeight", "height", "", "markVisitorLinkVideoPreviewWidth", "width", "markVisitorLinkVideoRendererCostPerFrame", "markVisitorLinkVideoRendererFps", "fpsValue", "markVisitorLinkVideoRendererFpsHigh", "markVisitorLinkVideoRendererFpsLow", "markVisitorLinkVideoRendererFpsMiddle", "markVisitorMaxiViewCost", "markVisitorMiniViewCost", "markVisitorRenderAnchorCostPerFrame", "markVisitorRendererAnchorFps", "markVisitorRendererAnchorFpsHigh", "markVisitorRendererAnchorFpsLow", "markVisitorRendererAnchorFpsMiddle", "plugin-core_release"})
public final class b
{
  public static final b gOE;
  
  static
  {
    AppMethodBeat.i(197040);
    gOE = new b();
    AppMethodBeat.o(197040);
  }
  
  public static final void amS()
  {
    AppMethodBeat.i(197025);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsLow");
    g.yxI.n(1383L, 0L, 1L);
    AppMethodBeat.o(197025);
  }
  
  public static final void amT()
  {
    AppMethodBeat.i(197026);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsMiddle");
    g.yxI.n(1383L, 1L, 1L);
    AppMethodBeat.o(197026);
  }
  
  public static final void amU()
  {
    AppMethodBeat.i(197027);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsHigh");
    g.yxI.n(1383L, 2L, 1L);
    AppMethodBeat.o(197027);
  }
  
  public static final void amV()
  {
    AppMethodBeat.i(197037);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsLow");
    g.yxI.n(1383L, 30L, 1L);
    AppMethodBeat.o(197037);
  }
  
  public static final void amW()
  {
    AppMethodBeat.i(197038);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsMiddle");
    g.yxI.n(1383L, 31L, 1L);
    AppMethodBeat.o(197038);
  }
  
  public static final void amX()
  {
    AppMethodBeat.i(197039);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsHigh");
    g.yxI.n(1383L, 32L, 1L);
    AppMethodBeat.o(197039);
  }
  
  public static final void nn(int paramInt)
  {
    AppMethodBeat.i(197028);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFps value is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1383, 3, 4, paramInt, false);
    AppMethodBeat.o(197028);
  }
  
  public static final void no(int paramInt)
  {
    AppMethodBeat.i(197031);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewWidth is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1383, 12, 13, paramInt, false);
    AppMethodBeat.o(197031);
  }
  
  public static final void np(int paramInt)
  {
    AppMethodBeat.i(197032);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewHeight is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1383, 15, 16, paramInt, false);
    AppMethodBeat.o(197032);
  }
  
  public static final void nq(int paramInt)
  {
    AppMethodBeat.i(197033);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1383, 18, 19, paramInt, false);
    AppMethodBeat.o(197033);
  }
  
  public static final void nr(int paramInt)
  {
    AppMethodBeat.i(197034);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMiniViewCost is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1383, 21, 22, paramInt, false);
    AppMethodBeat.o(197034);
  }
  
  public static final void ns(int paramInt)
  {
    AppMethodBeat.i(197035);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererCostPerFrame is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1383, 24, 25, paramInt, false);
    AppMethodBeat.o(197035);
  }
  
  public static final void nt(int paramInt)
  {
    AppMethodBeat.i(197036);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFps is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1383, 27, 28, paramInt, false);
    AppMethodBeat.o(197036);
  }
  
  public static final void rs(long paramLong)
  {
    AppMethodBeat.i(197029);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRenderAnchorCostPerFrame is ".concat(String.valueOf(paramLong)));
    g.yxI.c(1383, 6, 7, (int)paramLong, false);
    AppMethodBeat.o(197029);
  }
  
  public static final void rt(long paramLong)
  {
    AppMethodBeat.i(197030);
    ae.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorGaussAnchorAvatarCost is ".concat(String.valueOf(paramLong)));
    g.yxI.c(1383, 9, 10, (int)paramLong, false);
    AppMethodBeat.o(197030);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.c.b
 * JD-Core Version:    0.7.0.1
 */