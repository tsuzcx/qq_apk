package com.tencent.mm.plugin.cast.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.l;
import org.xwalk.core.Log;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/cast/report/CastReportHelper;", "", "()V", "ID", "", "TAG", "", "doScreenCastPcKvReport", "", "bitrate", "", "videoHeight", "videoWidth", "videoFrameRate", "times", "batteryCost", "encodeStrategy", "renderStrategy", "firstFrameRenderCost", "firstFrameEncodeCost", "avgFrameRenderCost", "transportStatus", "markBatteryCost", "cost", "markClickPermissionCancelReport", "markClickStartScreenCastBtnReport", "markClickStartScreenCastRetry", "markEnterScreenCastReport", "markInitVideoEncoderFailed", "markRecordingCost", "markScreenCastDiffNetWork", "markScreenCastFailedCauseNotFinderUserReport", "markScreenCastFailedNetSceneCallbackFailedReport", "markScreenCastNetConnectSucc", "markScreenCastNetSceneCallbackSuccReport", "markScreenCastNetSdkConnectFailed", "markScreenCastNetSdkConnectTimeOut", "markStartScreenCastReport", "markVideoEncodeFirstFrameCost", "markVideoEncodeFrameCostAvg", "markVideoEncodingUseAsync", "markVideoEncodingUseSync", "markVideoRenderFirstFrameCost", "markVideoRenderFrameCostAvg", "markVideoRendererUseImageReader", "markVideoRendererUseOpenGL", "plugin-cast_release"})
public final class a
{
  public static final a tKa;
  
  static
  {
    AppMethodBeat.i(190039);
    tKa = new a();
    AppMethodBeat.o(190039);
  }
  
  public static void Im(int paramInt)
  {
    AppMethodBeat.i(190015);
    Log.i("MicroMsg.CastReportHelper", "markVideoRenderFrameCostAvg ".concat(String.valueOf(paramInt)));
    h.IzE.c(1634, 16, 17, paramInt, true);
    AppMethodBeat.o(190015);
  }
  
  public static void In(int paramInt)
  {
    AppMethodBeat.i(190017);
    Log.i("MicroMsg.CastReportHelper", "markVideoEncodeFrameCostAvg ".concat(String.valueOf(paramInt)));
    h.IzE.c(1634, 22, 23, paramInt, true);
    AppMethodBeat.o(190017);
  }
  
  public static void Io(int paramInt)
  {
    AppMethodBeat.i(190019);
    Log.i("MicroMsg.CastReportHelper", "markVideoRenderFirstFrameCost ".concat(String.valueOf(paramInt)));
    h.IzE.c(1634, 25, 26, paramInt, true);
    AppMethodBeat.o(190019);
  }
  
  public static void Ip(int paramInt)
  {
    AppMethodBeat.i(190020);
    Log.i("MicroMsg.CastReportHelper", "markBatteryCost ".concat(String.valueOf(paramInt)));
    h.IzE.c(1634, 28, 29, paramInt, true);
    AppMethodBeat.o(190020);
  }
  
  public static void Iq(int paramInt)
  {
    AppMethodBeat.i(190024);
    Log.i("MicroMsg.CastReportHelper", "markRecordingCost ".concat(String.valueOf(paramInt)));
    h.IzE.c(1634, 31, 32, paramInt, true);
    AppMethodBeat.o(190024);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(190033);
    Log.i("MicroMsg.CastReportHelper", "doScreenCastPcKvReport is bitrate: " + paramInt1 + ",videoHeight : " + paramInt2 + ",videoWidth : " + paramInt3 + ",videoFrameRate: " + paramInt4 + ",times: " + paramInt5 + ",batteryCost : " + paramInt6 + ",encodeStrategy : " + paramInt7 + ",renderStrategy : " + paramInt8 + ",firstFrameRenderCost: " + paramInt9 + ",firstFrameEncodeCost: " + paramInt10 + ",avgFrameRenderCost: " + paramInt11 + ' ');
    h.IzE.a(22393, true, true, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), Integer.valueOf(paramInt10), Integer.valueOf(paramInt11), Integer.valueOf(paramInt12) });
    AppMethodBeat.o(190033);
  }
  
  public static void cLD()
  {
    AppMethodBeat.i(189965);
    Log.i("MicroMsg.CastReportHelper", "markEnterScreenCastReport");
    h.IzE.p(1634L, 0L, 1L);
    AppMethodBeat.o(189965);
  }
  
  public static void cLE()
  {
    AppMethodBeat.i(189969);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastFailedCauseNotFinderUserReport");
    h.IzE.p(1634L, 1L, 1L);
    AppMethodBeat.o(189969);
  }
  
  public static void cLF()
  {
    AppMethodBeat.i(189973);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastFailedNetSceneCallbackFailedReport");
    h.IzE.p(1634L, 2L, 1L);
    AppMethodBeat.o(189973);
  }
  
  public static void cLG()
  {
    AppMethodBeat.i(189976);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastNetSceneCallbackSuccReport");
    h.IzE.p(1634L, 3L, 1L);
    AppMethodBeat.o(189976);
  }
  
  public static void cLH()
  {
    AppMethodBeat.i(189979);
    Log.i("MicroMsg.CastReportHelper", "markClickStartScreenCastBtnReport");
    h.IzE.p(1634L, 4L, 1L);
    AppMethodBeat.o(189979);
  }
  
  public static void cLI()
  {
    AppMethodBeat.i(189983);
    Log.i("MicroMsg.CastReportHelper", "markClickStartScreenCastRetry");
    h.IzE.p(1634L, 5L, 1L);
    AppMethodBeat.o(189983);
  }
  
  public static void cLJ()
  {
    AppMethodBeat.i(189986);
    Log.i("MicroMsg.CastReportHelper", "markClickPermissionCancelReport");
    h.IzE.p(1634L, 6L, 1L);
    AppMethodBeat.o(189986);
  }
  
  public static void cLK()
  {
    AppMethodBeat.i(189988);
    Log.i("MicroMsg.CastReportHelper", "markStartScreenCastReport");
    h.IzE.p(1634L, 7L, 1L);
    AppMethodBeat.o(189988);
  }
  
  public static void cLL()
  {
    AppMethodBeat.i(189990);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastDiffNetWork");
    h.IzE.p(1634L, 8L, 1L);
    AppMethodBeat.o(189990);
  }
  
  public static void cLM()
  {
    AppMethodBeat.i(189992);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastNetSdkConnectFailed");
    h.IzE.p(1634L, 9L, 1L);
    AppMethodBeat.o(189992);
  }
  
  public static void cLN()
  {
    AppMethodBeat.i(189998);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastNetSdkConnectTimeOut");
    h.IzE.p(1634L, 10L, 1L);
    AppMethodBeat.o(189998);
  }
  
  public static void cLO()
  {
    AppMethodBeat.i(190001);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastNetConnectSucc");
    h.IzE.p(1634L, 11L, 1L);
    AppMethodBeat.o(190001);
  }
  
  public static void cLP()
  {
    AppMethodBeat.i(190004);
    Log.i("MicroMsg.CastReportHelper", "markVideoEncodingUseSync");
    h.IzE.p(1634L, 12L, 1L);
    AppMethodBeat.o(190004);
  }
  
  public static void cLQ()
  {
    AppMethodBeat.i(190008);
    Log.i("MicroMsg.CastReportHelper", "markVideoEncodingUseAsync");
    h.IzE.p(1634L, 13L, 1L);
    AppMethodBeat.o(190008);
  }
  
  public static void cLR()
  {
    AppMethodBeat.i(190011);
    Log.i("MicroMsg.CastReportHelper", "markVideoRendererUseOpenGL");
    h.IzE.p(1634L, 14L, 1L);
    AppMethodBeat.o(190011);
  }
  
  public static void cLS()
  {
    AppMethodBeat.i(190012);
    Log.i("MicroMsg.CastReportHelper", "markVideoRendererUseImageReader");
    h.IzE.p(1634L, 15L, 1L);
    AppMethodBeat.o(190012);
  }
  
  public static void cLT()
  {
    AppMethodBeat.i(190026);
    Log.i("MicroMsg.CastReportHelper", "markInitVideoEncoderFailed");
    h.IzE.p(1634L, 34L, 1L);
    AppMethodBeat.o(190026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.g.a
 * JD-Core Version:    0.7.0.1
 */