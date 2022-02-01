package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/core/report/LiveAnchorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorMaxiViewCost", "", "cost", "", "markAnchorMiniViewCost", "markAnchorNetStatusBad", "markAnchorNetStatusDisable", "markAnchorNetStatusGood", "markAnchorNetStatusNormal", "markAnchorRendererFpsHigh", "markAnchorRendererFpsLow", "markAnchorRendererFpsMiddle", "markAnchorRendererFpsValue", "fpsValue", "markAnchorRendererPerFrameCost", "markAnchorRendererPreviewHeight", "height", "markAnchorRendererPreviewWidth", "width", "plugin-core_release"})
public final class a
{
  public static final a hEG;
  
  static
  {
    AppMethodBeat.i(196712);
    hEG = new a();
    AppMethodBeat.o(196712);
  }
  
  public static final void aEH()
  {
    AppMethodBeat.i(196699);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsLow");
    h.CyF.n(1384L, 0L, 1L);
    AppMethodBeat.o(196699);
  }
  
  public static final void aEI()
  {
    AppMethodBeat.i(196700);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsMiddle");
    h.CyF.n(1384L, 1L, 1L);
    AppMethodBeat.o(196700);
  }
  
  public static final void aEJ()
  {
    AppMethodBeat.i(196701);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsHigh");
    h.CyF.n(1384L, 2L, 1L);
    AppMethodBeat.o(196701);
  }
  
  public static final void aEK()
  {
    AppMethodBeat.i(196702);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusGood");
    h.CyF.n(1384L, 3L, 1L);
    AppMethodBeat.o(196702);
  }
  
  public static final void aEL()
  {
    AppMethodBeat.i(196703);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusNormal");
    h.CyF.n(1384L, 4L, 1L);
    AppMethodBeat.o(196703);
  }
  
  public static final void aEM()
  {
    AppMethodBeat.i(196704);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusBad");
    h.CyF.n(1384L, 5L, 1L);
    AppMethodBeat.o(196704);
  }
  
  public static final void aEN()
  {
    AppMethodBeat.i(196705);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusDisable");
    h.CyF.n(1384L, 6L, 1L);
    AppMethodBeat.o(196705);
  }
  
  public static final void qA(int paramInt)
  {
    AppMethodBeat.i(196707);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMiniViewCost is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1384, 10, 11, paramInt, false);
    AppMethodBeat.o(196707);
  }
  
  public static final void qB(int paramInt)
  {
    AppMethodBeat.i(196708);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPerFrameCost is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1384, 13, 14, paramInt, false);
    AppMethodBeat.o(196708);
  }
  
  public static final void qC(int paramInt)
  {
    AppMethodBeat.i(196709);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsValue is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1384, 16, 17, paramInt, false);
    AppMethodBeat.o(196709);
  }
  
  public static final void qD(int paramInt)
  {
    AppMethodBeat.i(196710);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1384, 19, 20, paramInt, false);
    AppMethodBeat.o(196710);
  }
  
  public static final void qE(int paramInt)
  {
    AppMethodBeat.i(196711);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1384, 22, 23, paramInt, false);
    AppMethodBeat.o(196711);
  }
  
  public static final void qz(int paramInt)
  {
    AppMethodBeat.i(196706);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    h.CyF.b(1384, 7, 8, paramInt, false);
    AppMethodBeat.o(196706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.core.c.a
 * JD-Core Version:    0.7.0.1
 */