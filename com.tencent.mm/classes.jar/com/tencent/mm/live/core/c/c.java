package com.tencent.mm.live.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/core/report/LiveVisitorPerformanceIDKeyStat;", "", "()V", "ID", "", "TAG", "", "markVisitorGaussAnchorAvatarCost", "", "cost", "markVisitorLinkVideoPreviewHeight", "height", "", "markVisitorLinkVideoPreviewWidth", "width", "markVisitorLinkVideoRendererCostPerFrame", "markVisitorLinkVideoRendererFps", "fpsValue", "markVisitorLinkVideoRendererFpsHigh", "markVisitorLinkVideoRendererFpsLow", "markVisitorLinkVideoRendererFpsMiddle", "markVisitorMaxiViewCost", "markVisitorMiniViewCost", "markVisitorRenderAnchorCostPerFrame", "markVisitorRendererAnchorFps", "markVisitorRendererAnchorFpsHigh", "markVisitorRendererAnchorFpsLow", "markVisitorRendererAnchorFpsMiddle", "plugin-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c mWG;
  
  static
  {
    AppMethodBeat.i(247620);
    mWG = new c();
    AppMethodBeat.o(247620);
  }
  
  public static final void bgP()
  {
    AppMethodBeat.i(247509);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsLow");
    h.OAn.p(1383L, 0L, 1L);
    AppMethodBeat.o(247509);
  }
  
  public static final void bgQ()
  {
    AppMethodBeat.i(247514);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsMiddle");
    h.OAn.p(1383L, 1L, 1L);
    AppMethodBeat.o(247514);
  }
  
  public static final void bgR()
  {
    AppMethodBeat.i(247520);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorRendererAnchorFpsHigh");
    h.OAn.p(1383L, 2L, 1L);
    AppMethodBeat.o(247520);
  }
  
  public static final void bgS()
  {
    AppMethodBeat.i(247602);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsLow");
    h.OAn.p(1383L, 30L, 1L);
    AppMethodBeat.o(247602);
  }
  
  public static final void bgT()
  {
    AppMethodBeat.i(247609);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsMiddle");
    h.OAn.p(1383L, 31L, 1L);
    AppMethodBeat.o(247609);
  }
  
  public static final void bgU()
  {
    AppMethodBeat.i(247615);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", "markVisitorLinkVideoRendererFpsHigh");
    h.OAn.p(1383L, 32L, 1L);
    AppMethodBeat.o(247615);
  }
  
  public static final void hJ(long paramLong)
  {
    AppMethodBeat.i(247538);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorRenderAnchorCostPerFrame is ", Long.valueOf(paramLong)));
    h.OAn.c(1383, 6, 7, (int)paramLong, false);
    AppMethodBeat.o(247538);
  }
  
  public static final void hK(long paramLong)
  {
    AppMethodBeat.i(247548);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorGaussAnchorAvatarCost is ", Long.valueOf(paramLong)));
    h.OAn.c(1383, 9, 10, (int)paramLong, false);
    AppMethodBeat.o(247548);
  }
  
  public static final void tp(int paramInt)
  {
    AppMethodBeat.i(247531);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorRendererAnchorFps value is ", Integer.valueOf(paramInt)));
    h.OAn.c(1383, 3, 4, paramInt, false);
    AppMethodBeat.o(247531);
  }
  
  public static final void tq(int paramInt)
  {
    AppMethodBeat.i(247558);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorLinkVideoPreviewWidth is ", Integer.valueOf(paramInt)));
    h.OAn.c(1383, 12, 13, paramInt, false);
    AppMethodBeat.o(247558);
  }
  
  public static final void tr(int paramInt)
  {
    AppMethodBeat.i(247567);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorLinkVideoPreviewHeight is ", Integer.valueOf(paramInt)));
    h.OAn.c(1383, 15, 16, paramInt, false);
    AppMethodBeat.o(247567);
  }
  
  public static final void ts(int paramInt)
  {
    AppMethodBeat.i(247575);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorMaxiViewCost is ", Integer.valueOf(paramInt)));
    h.OAn.c(1383, 18, 19, paramInt, false);
    AppMethodBeat.o(247575);
  }
  
  public static final void tt(int paramInt)
  {
    AppMethodBeat.i(247582);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorMiniViewCost is ", Integer.valueOf(paramInt)));
    h.OAn.c(1383, 21, 22, paramInt, false);
    AppMethodBeat.o(247582);
  }
  
  public static final void tu(int paramInt)
  {
    AppMethodBeat.i(247588);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorLinkVideoRendererCostPerFrame is ", Integer.valueOf(paramInt)));
    h.OAn.c(1383, 24, 25, paramInt, false);
    AppMethodBeat.o(247588);
  }
  
  public static final void tv(int paramInt)
  {
    AppMethodBeat.i(247596);
    Log.i("MicroMsg.LiveVisitorPerformanceIDKeyStat", s.X("markVisitorLinkVideoRendererFps is ", Integer.valueOf(paramInt)));
    h.OAn.c(1383, 27, 28, paramInt, false);
    AppMethodBeat.o(247596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.live.core.c.c
 * JD-Core Version:    0.7.0.1
 */