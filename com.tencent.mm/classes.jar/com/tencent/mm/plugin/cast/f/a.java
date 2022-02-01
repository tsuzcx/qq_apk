package com.tencent.mm.plugin.cast.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xwalk.core.Log;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/cast/report/CastReportHelper;", "", "()V", "ID", "", "TAG", "", "doScreenCastPcKvReport", "", "bitrate", "", "videoHeight", "videoWidth", "videoFrameRate", "times", "batteryCost", "encodeStrategy", "renderStrategy", "firstFrameRenderCost", "firstFrameEncodeCost", "avgFrameRenderCost", "transportStatus", "markBatteryCost", "cost", "markClickPermissionCancelReport", "markClickStartScreenCastBtnReport", "markClickStartScreenCastRetry", "markEnterScreenCastReport", "markInitVideoEncoderFailed", "markRecordingCost", "markScreenCastDiffNetWork", "markScreenCastFailedCauseNotFinderUserReport", "markScreenCastFailedNetSceneCallbackFailedReport", "markScreenCastNetConnectSucc", "markScreenCastNetSceneCallbackSuccReport", "markScreenCastNetSdkConnectFailed", "markScreenCastNetSdkConnectTimeOut", "markStartScreenCastReport", "markVideoEncodeFirstFrameCost", "markVideoEncodeFrameCostAvg", "markVideoEncodingUseAsync", "markVideoEncodingUseSync", "markVideoRenderFirstFrameCost", "markVideoRenderFrameCostAvg", "markVideoRendererUseImageReader", "markVideoRendererUseOpenGL", "plugin-cast_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a wNt;
  
  static
  {
    AppMethodBeat.i(274189);
    wNt = new a();
    AppMethodBeat.o(274189);
  }
  
  public static void IP(int paramInt)
  {
    AppMethodBeat.i(274146);
    Log.i("MicroMsg.CastReportHelper", s.X("markVideoRenderFrameCostAvg ", Integer.valueOf(paramInt)));
    h.OAn.c(1634, 16, 17, paramInt, true);
    AppMethodBeat.o(274146);
  }
  
  public static void IQ(int paramInt)
  {
    AppMethodBeat.i(274150);
    Log.i("MicroMsg.CastReportHelper", s.X("markVideoEncodeFrameCostAvg ", Integer.valueOf(paramInt)));
    h.OAn.c(1634, 22, 23, paramInt, true);
    AppMethodBeat.o(274150);
  }
  
  public static void IR(int paramInt)
  {
    AppMethodBeat.i(274157);
    Log.i("MicroMsg.CastReportHelper", s.X("markVideoRenderFirstFrameCost ", Integer.valueOf(paramInt)));
    h.OAn.c(1634, 25, 26, paramInt, true);
    AppMethodBeat.o(274157);
  }
  
  public static void IS(int paramInt)
  {
    AppMethodBeat.i(274160);
    Log.i("MicroMsg.CastReportHelper", s.X("markBatteryCost ", Integer.valueOf(paramInt)));
    h.OAn.c(1634, 28, 29, paramInt, true);
    AppMethodBeat.o(274160);
  }
  
  public static void IT(int paramInt)
  {
    AppMethodBeat.i(274165);
    Log.i("MicroMsg.CastReportHelper", s.X("markRecordingCost ", Integer.valueOf(paramInt)));
    h.OAn.c(1634, 31, 32, paramInt, true);
    AppMethodBeat.o(274165);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(274182);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doScreenCastPcKvReport is bitrate: ").append(paramInt1).append(",videoHeight : ").append(paramInt2).append(",videoWidth : ").append(paramInt3).append(",videoFrameRate: ").append(paramInt4).append(",times: ").append(paramInt5).append(",batteryCost : ").append(paramInt6).append(",encodeStrategy : ").append(paramInt7).append(",renderStrategy : ").append(paramInt8).append(",firstFrameRenderCost: ").append(paramInt9).append(",firstFrameEncodeCost: ").append(paramInt10).append(",avgFrameRenderCost: ").append(paramInt11).append(' ');
    Log.i("MicroMsg.CastReportHelper", localStringBuilder.toString());
    h.OAn.a(22393, true, true, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), Integer.valueOf(paramInt10), Integer.valueOf(paramInt11), Integer.valueOf(paramInt12) });
    AppMethodBeat.o(274182);
  }
  
  public static void dpj()
  {
    AppMethodBeat.i(274062);
    Log.i("MicroMsg.CastReportHelper", "markEnterScreenCastReport");
    h.OAn.p(1634L, 0L, 1L);
    AppMethodBeat.o(274062);
  }
  
  public static void dpk()
  {
    AppMethodBeat.i(274065);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastFailedCauseNotFinderUserReport");
    h.OAn.p(1634L, 1L, 1L);
    AppMethodBeat.o(274065);
  }
  
  public static void dpl()
  {
    AppMethodBeat.i(274069);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastFailedNetSceneCallbackFailedReport");
    h.OAn.p(1634L, 2L, 1L);
    AppMethodBeat.o(274069);
  }
  
  public static void dpm()
  {
    AppMethodBeat.i(274075);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastNetSceneCallbackSuccReport");
    h.OAn.p(1634L, 3L, 1L);
    AppMethodBeat.o(274075);
  }
  
  public static void dpn()
  {
    AppMethodBeat.i(274082);
    Log.i("MicroMsg.CastReportHelper", "markClickStartScreenCastBtnReport");
    h.OAn.p(1634L, 4L, 1L);
    AppMethodBeat.o(274082);
  }
  
  public static void dpo()
  {
    AppMethodBeat.i(274087);
    Log.i("MicroMsg.CastReportHelper", "markClickStartScreenCastRetry");
    h.OAn.p(1634L, 5L, 1L);
    AppMethodBeat.o(274087);
  }
  
  public static void dpp()
  {
    AppMethodBeat.i(274094);
    Log.i("MicroMsg.CastReportHelper", "markClickPermissionCancelReport");
    h.OAn.p(1634L, 6L, 1L);
    AppMethodBeat.o(274094);
  }
  
  public static void dpq()
  {
    AppMethodBeat.i(274099);
    Log.i("MicroMsg.CastReportHelper", "markStartScreenCastReport");
    h.OAn.p(1634L, 7L, 1L);
    AppMethodBeat.o(274099);
  }
  
  public static void dpr()
  {
    AppMethodBeat.i(274102);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastDiffNetWork");
    h.OAn.p(1634L, 8L, 1L);
    AppMethodBeat.o(274102);
  }
  
  public static void dps()
  {
    AppMethodBeat.i(274106);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastNetSdkConnectFailed");
    h.OAn.p(1634L, 9L, 1L);
    AppMethodBeat.o(274106);
  }
  
  public static void dpt()
  {
    AppMethodBeat.i(274109);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastNetSdkConnectTimeOut");
    h.OAn.p(1634L, 10L, 1L);
    AppMethodBeat.o(274109);
  }
  
  public static void dpu()
  {
    AppMethodBeat.i(274114);
    Log.i("MicroMsg.CastReportHelper", "markScreenCastNetConnectSucc");
    h.OAn.p(1634L, 11L, 1L);
    AppMethodBeat.o(274114);
  }
  
  public static void dpv()
  {
    AppMethodBeat.i(274121);
    Log.i("MicroMsg.CastReportHelper", "markVideoEncodingUseSync");
    h.OAn.p(1634L, 12L, 1L);
    AppMethodBeat.o(274121);
  }
  
  public static void dpw()
  {
    AppMethodBeat.i(274127);
    Log.i("MicroMsg.CastReportHelper", "markVideoEncodingUseAsync");
    h.OAn.p(1634L, 13L, 1L);
    AppMethodBeat.o(274127);
  }
  
  public static void dpx()
  {
    AppMethodBeat.i(274130);
    Log.i("MicroMsg.CastReportHelper", "markVideoRendererUseOpenGL");
    h.OAn.p(1634L, 14L, 1L);
    AppMethodBeat.o(274130);
  }
  
  public static void dpy()
  {
    AppMethodBeat.i(274136);
    Log.i("MicroMsg.CastReportHelper", "markVideoRendererUseImageReader");
    h.OAn.p(1634L, 15L, 1L);
    AppMethodBeat.o(274136);
  }
  
  public static void dpz()
  {
    AppMethodBeat.i(274171);
    Log.i("MicroMsg.CastReportHelper", "markInitVideoEncoderFailed");
    h.OAn.p(1634L, 34L, 1L);
    AppMethodBeat.o(274171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cast.f.a
 * JD-Core Version:    0.7.0.1
 */