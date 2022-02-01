package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/report/LiveVisitorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markVisitorGaussAnchorAvatarCost", "", "cost", "markVisitorLinkVideoPreviewHeight", "height", "", "markVisitorLinkVideoPreviewWidth", "width", "markVisitorLinkVideoRendererCostPerFrame", "markVisitorLinkVideoRendererFps", "fpsValue", "markVisitorLinkVideoRendererFpsHigh", "markVisitorLinkVideoRendererFpsLow", "markVisitorLinkVideoRendererFpsMiddle", "markVisitorMaxiViewCost", "markVisitorMiniViewCost", "markVisitorRenderAnchorCostPerFrame", "markVisitorRendererAnchorFps", "markVisitorRendererAnchorFpsHigh", "markVisitorRendererAnchorFpsLow", "markVisitorRendererAnchorFpsMiddle", "plugin-core_release"})
public final class c
{
  public static final c hEK;
  
  static
  {
    AppMethodBeat.i(196730);
    hEK = new c();
    AppMethodBeat.o(196730);
  }
  
  public static final void aEO()
  {
    AppMethodBeat.i(196715);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsLow");
    h.CyF.n(1383L, 0L, 1L);
    AppMethodBeat.o(196715);
  }
  
  public static final void aEP()
  {
    AppMethodBeat.i(196716);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsMiddle");
    h.CyF.n(1383L, 1L, 1L);
    AppMethodBeat.o(196716);
  }
  
  public static final void aEQ()
  {
    AppMethodBeat.i(196717);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsHigh");
    h.CyF.n(1383L, 2L, 1L);
    AppMethodBeat.o(196717);
  }
  
  public static final void aER()
  {
    AppMethodBeat.i(196727);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsLow");
    h.CyF.n(1383L, 30L, 1L);
    AppMethodBeat.o(196727);
  }
  
  public static final void aES()
  {
    AppMethodBeat.i(196728);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsMiddle");
    h.CyF.n(1383L, 31L, 1L);
    AppMethodBeat.o(196728);
  }
  
  public static final void aET()
  {
    AppMethodBeat.i(196729);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsHigh");
    h.CyF.n(1383L, 32L, 1L);
    AppMethodBeat.o(196729);
  }
  
  public static final void qF(int paramInt)
  {
    AppMethodBeat.i(196718);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFps value is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1383, 3, 4, paramInt, false);
    AppMethodBeat.o(196718);
  }
  
  public static final void qG(int paramInt)
  {
    AppMethodBeat.i(196721);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewWidth is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1383, 12, 13, paramInt, false);
    AppMethodBeat.o(196721);
  }
  
  public static final void qH(int paramInt)
  {
    AppMethodBeat.i(196722);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1383, 15, 16, paramInt, false);
    AppMethodBeat.o(196722);
  }
  
  public static final void qI(int paramInt)
  {
    AppMethodBeat.i(196723);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1383, 18, 19, paramInt, false);
    AppMethodBeat.o(196723);
  }
  
  public static final void qJ(int paramInt)
  {
    AppMethodBeat.i(196724);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorMiniViewCost is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1383, 21, 22, paramInt, false);
    AppMethodBeat.o(196724);
  }
  
  public static final void qK(int paramInt)
  {
    AppMethodBeat.i(196725);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererCostPerFrame is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1383, 24, 25, paramInt, false);
    AppMethodBeat.o(196725);
  }
  
  public static final void qL(int paramInt)
  {
    AppMethodBeat.i(196726);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFps is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1383, 27, 28, paramInt, false);
    AppMethodBeat.o(196726);
  }
  
  public static final void zw(long paramLong)
  {
    AppMethodBeat.i(196719);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRenderAnchorCostPerFrame is ".concat(String.valueOf(paramLong)));
    h.CyF.b(1383, 6, 7, (int)paramLong, false);
    AppMethodBeat.o(196719);
  }
  
  public static final void zx(long paramLong)
  {
    AppMethodBeat.i(196720);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorGaussAnchorAvatarCost is ".concat(String.valueOf(paramLong)));
    h.CyF.b(1383, 9, 10, (int)paramLong, false);
    AppMethodBeat.o(196720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.c.c
 * JD-Core Version:    0.7.0.1
 */