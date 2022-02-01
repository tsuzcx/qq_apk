package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/report/LiveVisitorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markVisitorGaussAnchorAvatarCost", "", "cost", "markVisitorLinkVideoPreviewHeight", "height", "", "markVisitorLinkVideoPreviewWidth", "width", "markVisitorLinkVideoRendererCostPerFrame", "markVisitorLinkVideoRendererFps", "fpsValue", "markVisitorLinkVideoRendererFpsHigh", "markVisitorLinkVideoRendererFpsLow", "markVisitorLinkVideoRendererFpsMiddle", "markVisitorMaxiViewCost", "markVisitorMiniViewCost", "markVisitorRenderAnchorCostPerFrame", "markVisitorRendererAnchorFps", "markVisitorRendererAnchorFpsHigh", "markVisitorRendererAnchorFpsLow", "markVisitorRendererAnchorFpsMiddle", "plugin-core_release"})
public final class c
{
  public static final c ksP;
  
  static
  {
    AppMethodBeat.i(199180);
    ksP = new c();
    AppMethodBeat.o(199180);
  }
  
  public static final void FD(long paramLong)
  {
    AppMethodBeat.i(199166);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRenderAnchorCostPerFrame is ".concat(String.valueOf(paramLong)));
    h.IzE.c(1383, 6, 7, (int)paramLong, false);
    AppMethodBeat.o(199166);
  }
  
  public static final void FE(long paramLong)
  {
    AppMethodBeat.i(199168);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorGaussAnchorAvatarCost is ".concat(String.valueOf(paramLong)));
    h.IzE.c(1383, 9, 10, (int)paramLong, false);
    AppMethodBeat.o(199168);
  }
  
  public static final void aNf()
  {
    AppMethodBeat.i(199159);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsLow");
    h.IzE.p(1383L, 0L, 1L);
    AppMethodBeat.o(199159);
  }
  
  public static final void aNg()
  {
    AppMethodBeat.i(199161);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsMiddle");
    h.IzE.p(1383L, 1L, 1L);
    AppMethodBeat.o(199161);
  }
  
  public static final void aNh()
  {
    AppMethodBeat.i(199162);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsHigh");
    h.IzE.p(1383L, 2L, 1L);
    AppMethodBeat.o(199162);
  }
  
  public static final void aNi()
  {
    AppMethodBeat.i(199177);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsLow");
    h.IzE.p(1383L, 30L, 1L);
    AppMethodBeat.o(199177);
  }
  
  public static final void aNj()
  {
    AppMethodBeat.i(199178);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsMiddle");
    h.IzE.p(1383L, 31L, 1L);
    AppMethodBeat.o(199178);
  }
  
  public static final void aNk()
  {
    AppMethodBeat.i(199179);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsHigh");
    h.IzE.p(1383L, 32L, 1L);
    AppMethodBeat.o(199179);
  }
  
  public static final void tA(int paramInt)
  {
    AppMethodBeat.i(199176);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFps is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1383, 27, 28, paramInt, false);
    AppMethodBeat.o(199176);
  }
  
  public static final void tu(int paramInt)
  {
    AppMethodBeat.i(199164);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFps value is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1383, 3, 4, paramInt, false);
    AppMethodBeat.o(199164);
  }
  
  public static final void tv(int paramInt)
  {
    AppMethodBeat.i(199170);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewWidth is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1383, 12, 13, paramInt, false);
    AppMethodBeat.o(199170);
  }
  
  public static final void tw(int paramInt)
  {
    AppMethodBeat.i(199172);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1383, 15, 16, paramInt, false);
    AppMethodBeat.o(199172);
  }
  
  public static final void tx(int paramInt)
  {
    AppMethodBeat.i(199173);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1383, 18, 19, paramInt, false);
    AppMethodBeat.o(199173);
  }
  
  public static final void ty(int paramInt)
  {
    AppMethodBeat.i(199174);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMiniViewCost is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1383, 21, 22, paramInt, false);
    AppMethodBeat.o(199174);
  }
  
  public static final void tz(int paramInt)
  {
    AppMethodBeat.i(199175);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererCostPerFrame is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1383, 24, 25, paramInt, false);
    AppMethodBeat.o(199175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.c.c
 * JD-Core Version:    0.7.0.1
 */