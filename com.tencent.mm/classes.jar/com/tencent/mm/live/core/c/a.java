package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/core/report/LiveAnchorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorMaxiViewCost", "", "cost", "", "markAnchorMiniViewCost", "markAnchorNetStatusBad", "markAnchorNetStatusDisable", "markAnchorNetStatusGood", "markAnchorNetStatusNormal", "markAnchorRendererFpsHigh", "markAnchorRendererFpsLow", "markAnchorRendererFpsMiddle", "markAnchorRendererFpsValue", "fpsValue", "markAnchorRendererPerFrameCost", "markAnchorRendererPreviewHeight", "height", "markAnchorRendererPreviewWidth", "width", "plugin-core_release"})
public final class a
{
  public static final a gOD;
  
  static
  {
    AppMethodBeat.i(197024);
    gOD = new a();
    AppMethodBeat.o(197024);
  }
  
  public static final void amL()
  {
    AppMethodBeat.i(197011);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsLow");
    g.yxI.n(1384L, 0L, 1L);
    AppMethodBeat.o(197011);
  }
  
  public static final void amM()
  {
    AppMethodBeat.i(197012);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsMiddle");
    g.yxI.n(1384L, 1L, 1L);
    AppMethodBeat.o(197012);
  }
  
  public static final void amN()
  {
    AppMethodBeat.i(197013);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsHigh");
    g.yxI.n(1384L, 2L, 1L);
    AppMethodBeat.o(197013);
  }
  
  public static final void amO()
  {
    AppMethodBeat.i(197014);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusGood");
    g.yxI.n(1384L, 3L, 1L);
    AppMethodBeat.o(197014);
  }
  
  public static final void amP()
  {
    AppMethodBeat.i(197015);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusNormal");
    g.yxI.n(1384L, 4L, 1L);
    AppMethodBeat.o(197015);
  }
  
  public static final void amQ()
  {
    AppMethodBeat.i(197016);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusBad");
    g.yxI.n(1384L, 5L, 1L);
    AppMethodBeat.o(197016);
  }
  
  public static final void amR()
  {
    AppMethodBeat.i(197017);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusDisable");
    g.yxI.n(1384L, 6L, 1L);
    AppMethodBeat.o(197017);
  }
  
  public static final void nh(int paramInt)
  {
    AppMethodBeat.i(197018);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMaxiViewCost is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1384, 7, 8, paramInt, false);
    AppMethodBeat.o(197018);
  }
  
  public static final void ni(int paramInt)
  {
    AppMethodBeat.i(197019);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorMiniViewCost is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1384, 10, 11, paramInt, false);
    AppMethodBeat.o(197019);
  }
  
  public static final void nj(int paramInt)
  {
    AppMethodBeat.i(197020);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPerFrameCost is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1384, 13, 14, paramInt, false);
    AppMethodBeat.o(197020);
  }
  
  public static final void nk(int paramInt)
  {
    AppMethodBeat.i(197021);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsValue is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1384, 16, 17, paramInt, false);
    AppMethodBeat.o(197021);
  }
  
  public static final void nl(int paramInt)
  {
    AppMethodBeat.i(197022);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1384, 19, 20, paramInt, false);
    AppMethodBeat.o(197022);
  }
  
  public static final void nm(int paramInt)
  {
    AppMethodBeat.i(197023);
    ae.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererPreviewHeight is ".concat(String.valueOf(paramInt)));
    g.yxI.c(1384, 22, 23, paramInt, false);
    AppMethodBeat.o(197023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.core.c.a
 * JD-Core Version:    0.7.0.1
 */