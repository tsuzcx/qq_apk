package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/report/LiveAnchorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorMaxiViewCost", "", "cost", "", "markAnchorMiniViewCost", "markAnchorNetStatusBad", "markAnchorNetStatusDisable", "markAnchorNetStatusGood", "markAnchorNetStatusNormal", "markAnchorRendererFpsHigh", "markAnchorRendererFpsLow", "markAnchorRendererFpsMiddle", "markAnchorRendererFpsValue", "fpsValue", "markAnchorRendererPerFrameCost", "markAnchorRendererPreviewHeight", "height", "markAnchorRendererPreviewWidth", "width", "plugin-core_release"})
public final class a
{
  public static final a ksL;
  
  static
  {
    AppMethodBeat.i(200342);
    ksL = new a();
    AppMethodBeat.o(200342);
  }
  
  public static final void aMY()
  {
    AppMethodBeat.i(200314);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsLow");
    h.IzE.p(1384L, 0L, 1L);
    AppMethodBeat.o(200314);
  }
  
  public static final void aMZ()
  {
    AppMethodBeat.i(200316);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsMiddle");
    h.IzE.p(1384L, 1L, 1L);
    AppMethodBeat.o(200316);
  }
  
  public static final void aNa()
  {
    AppMethodBeat.i(200318);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsHigh");
    h.IzE.p(1384L, 2L, 1L);
    AppMethodBeat.o(200318);
  }
  
  public static final void aNb()
  {
    AppMethodBeat.i(200323);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusGood");
    h.IzE.p(1384L, 3L, 1L);
    AppMethodBeat.o(200323);
  }
  
  public static final void aNc()
  {
    AppMethodBeat.i(200326);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusNormal");
    h.IzE.p(1384L, 4L, 1L);
    AppMethodBeat.o(200326);
  }
  
  public static final void aNd()
  {
    AppMethodBeat.i(200328);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusBad");
    h.IzE.p(1384L, 5L, 1L);
    AppMethodBeat.o(200328);
  }
  
  public static final void aNe()
  {
    AppMethodBeat.i(200329);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusDisable");
    h.IzE.p(1384L, 6L, 1L);
    AppMethodBeat.o(200329);
  }
  
  public static final void to(int paramInt)
  {
    AppMethodBeat.i(200330);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1384, 7, 8, paramInt, false);
    AppMethodBeat.o(200330);
  }
  
  public static final void tp(int paramInt)
  {
    AppMethodBeat.i(200332);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMiniViewCost is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1384, 10, 11, paramInt, false);
    AppMethodBeat.o(200332);
  }
  
  public static final void tq(int paramInt)
  {
    AppMethodBeat.i(200334);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPerFrameCost is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1384, 13, 14, paramInt, false);
    AppMethodBeat.o(200334);
  }
  
  public static final void tr(int paramInt)
  {
    AppMethodBeat.i(200335);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsValue is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1384, 16, 17, paramInt, false);
    AppMethodBeat.o(200335);
  }
  
  public static final void ts(int paramInt)
  {
    AppMethodBeat.i(200337);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1384, 19, 20, paramInt, false);
    AppMethodBeat.o(200337);
  }
  
  public static final void tt(int paramInt)
  {
    AppMethodBeat.i(200338);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.IzE.c(1384, 22, 23, paramInt, false);
    AppMethodBeat.o(200338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.c.a
 * JD-Core Version:    0.7.0.1
 */