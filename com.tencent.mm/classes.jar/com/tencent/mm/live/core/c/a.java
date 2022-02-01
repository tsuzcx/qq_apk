package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/report/LiveAnchorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markAnchorMaxiViewCost", "", "cost", "", "markAnchorMiniViewCost", "markAnchorNetStatusBad", "markAnchorNetStatusDisable", "markAnchorNetStatusGood", "markAnchorNetStatusNormal", "markAnchorRendererFpsHigh", "markAnchorRendererFpsLow", "markAnchorRendererFpsMiddle", "markAnchorRendererFpsValue", "fpsValue", "markAnchorRendererPerFrameCost", "markAnchorRendererPreviewHeight", "height", "markAnchorRendererPreviewWidth", "width", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a mWC;
  
  static
  {
    AppMethodBeat.i(247598);
    mWC = new a();
    AppMethodBeat.o(247598);
  }
  
  public static final void bgI()
  {
    AppMethodBeat.i(247504);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsLow");
    h.OAn.p(1384L, 0L, 1L);
    AppMethodBeat.o(247504);
  }
  
  public static final void bgJ()
  {
    AppMethodBeat.i(247507);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsMiddle");
    h.OAn.p(1384L, 1L, 1L);
    AppMethodBeat.o(247507);
  }
  
  public static final void bgK()
  {
    AppMethodBeat.i(247511);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorRendererFpsHigh");
    h.OAn.p(1384L, 2L, 1L);
    AppMethodBeat.o(247511);
  }
  
  public static final void bgL()
  {
    AppMethodBeat.i(247518);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusGood");
    h.OAn.p(1384L, 3L, 1L);
    AppMethodBeat.o(247518);
  }
  
  public static final void bgM()
  {
    AppMethodBeat.i(247527);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusNormal");
    h.OAn.p(1384L, 4L, 1L);
    AppMethodBeat.o(247527);
  }
  
  public static final void bgN()
  {
    AppMethodBeat.i(247534);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusBad");
    h.OAn.p(1384L, 5L, 1L);
    AppMethodBeat.o(247534);
  }
  
  public static final void bgO()
  {
    AppMethodBeat.i(247541);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", "markAnchorNetStatusDisable");
    h.OAn.p(1384L, 6L, 1L);
    AppMethodBeat.o(247541);
  }
  
  public static final void tj(int paramInt)
  {
    AppMethodBeat.i(247554);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", s.X("markAnchorMaxiViewCost is ", Integer.valueOf(paramInt)));
    h.OAn.c(1384, 7, 8, paramInt, false);
    AppMethodBeat.o(247554);
  }
  
  public static final void tk(int paramInt)
  {
    AppMethodBeat.i(247561);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", s.X("markAnchorMiniViewCost is ", Integer.valueOf(paramInt)));
    h.OAn.c(1384, 10, 11, paramInt, false);
    AppMethodBeat.o(247561);
  }
  
  public static final void tl(int paramInt)
  {
    AppMethodBeat.i(247568);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", s.X("markAnchorRendererPerFrameCost is ", Integer.valueOf(paramInt)));
    h.OAn.c(1384, 13, 14, paramInt, false);
    AppMethodBeat.o(247568);
  }
  
  public static final void tm(int paramInt)
  {
    AppMethodBeat.i(247577);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", s.X("markAnchorRendererFpsValue is ", Integer.valueOf(paramInt)));
    h.OAn.c(1384, 16, 17, paramInt, false);
    AppMethodBeat.o(247577);
  }
  
  public static final void tn(int paramInt)
  {
    AppMethodBeat.i(247583);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", s.X("markAnchorRendererPreviewHeight is ", Integer.valueOf(paramInt)));
    h.OAn.c(1384, 19, 20, paramInt, false);
    AppMethodBeat.o(247583);
  }
  
  public static final void to(int paramInt)
  {
    AppMethodBeat.i(247590);
    Log.i("MicroMsg.LiveAnchorPerformanceIDKeyStat", s.X("markAnchorRendererPreviewHeight is ", Integer.valueOf(paramInt)));
    h.OAn.c(1384, 22, 23, paramInt, false);
    AppMethodBeat.o(247590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.c.a
 * JD-Core Version:    0.7.0.1
 */