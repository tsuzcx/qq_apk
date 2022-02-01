package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/core/report/LiveAnchorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorMaxiViewCost", "", "cost", "", "markAnchorMiniViewCost", "markAnchorNetStatusBad", "markAnchorNetStatusDisable", "markAnchorNetStatusGood", "markAnchorNetStatusNormal", "markAnchorRendererFpsHigh", "markAnchorRendererFpsLow", "markAnchorRendererFpsMiddle", "markAnchorRendererFpsValue", "fpsValue", "markAnchorRendererPerFrameCost", "markAnchorRendererPreviewHeight", "height", "markAnchorRendererPreviewWidth", "width", "plugin-core_release"})
public final class a
{
  public static final a gsm;
  
  static
  {
    AppMethodBeat.i(209354);
    gsm = new a();
    AppMethodBeat.o(209354);
  }
  
  public static final void ajK()
  {
    AppMethodBeat.i(209341);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsLow");
    h.wUl.n(1384L, 0L, 1L);
    AppMethodBeat.o(209341);
  }
  
  public static final void ajL()
  {
    AppMethodBeat.i(209342);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsMiddle");
    h.wUl.n(1384L, 1L, 1L);
    AppMethodBeat.o(209342);
  }
  
  public static final void ajM()
  {
    AppMethodBeat.i(209343);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsHigh");
    h.wUl.n(1384L, 2L, 1L);
    AppMethodBeat.o(209343);
  }
  
  public static final void ajN()
  {
    AppMethodBeat.i(209344);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusGood");
    h.wUl.n(1384L, 3L, 1L);
    AppMethodBeat.o(209344);
  }
  
  public static final void ajO()
  {
    AppMethodBeat.i(209345);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusNormal");
    h.wUl.n(1384L, 4L, 1L);
    AppMethodBeat.o(209345);
  }
  
  public static final void ajP()
  {
    AppMethodBeat.i(209346);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusBad");
    h.wUl.n(1384L, 5L, 1L);
    AppMethodBeat.o(209346);
  }
  
  public static final void ajQ()
  {
    AppMethodBeat.i(209347);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusDisable");
    h.wUl.n(1384L, 6L, 1L);
    AppMethodBeat.o(209347);
  }
  
  public static final void mF(int paramInt)
  {
    AppMethodBeat.i(209348);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1384, 7, 8, paramInt, false);
    AppMethodBeat.o(209348);
  }
  
  public static final void mG(int paramInt)
  {
    AppMethodBeat.i(209349);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMiniViewCost is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1384, 10, 11, paramInt, false);
    AppMethodBeat.o(209349);
  }
  
  public static final void mH(int paramInt)
  {
    AppMethodBeat.i(209350);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPerFrameCost is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1384, 13, 14, paramInt, false);
    AppMethodBeat.o(209350);
  }
  
  public static final void mI(int paramInt)
  {
    AppMethodBeat.i(209351);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsValue is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1384, 16, 17, paramInt, false);
    AppMethodBeat.o(209351);
  }
  
  public static final void mJ(int paramInt)
  {
    AppMethodBeat.i(209352);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1384, 19, 20, paramInt, false);
    AppMethodBeat.o(209352);
  }
  
  public static final void mK(int paramInt)
  {
    AppMethodBeat.i(209353);
    ac.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    h.wUl.c(1384, 22, 23, paramInt, false);
    AppMethodBeat.o(209353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.live.core.c.a
 * JD-Core Version:    0.7.0.1
 */