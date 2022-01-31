package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;

public final class c
{
  int hIs;
  String mAppId;
  Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  public int mState = 0;
  byte[] mlk;
  TextView mqg;
  Rect mqi;
  Rect mqj;
  int mqk;
  int mql;
  YTFaceTraceInterface.FaceTraceingNotice mqo;
  u mrD;
  FaceReflectMask mrG;
  String mrJ;
  public com.tencent.mm.plugin.facedetectlight.ui.a.b mrP;
  int mrW;
  Point mrX;
  float mrY;
  float mrZ;
  UploadVideoRequester.UploadVideoResponse msa;
  
  static String a(YTAGFaceReflectResult paramYTAGFaceReflectResult)
  {
    AppMethodBeat.i(800);
    if ((paramYTAGFaceReflectResult == null) || (paramYTAGFaceReflectResult.result != 0))
    {
      ab.e("MicroMsg.FaceReflectLogic", "carson  face result is null or result code not 0");
      AppMethodBeat.o(800);
      return null;
    }
    try
    {
      String str = p.buK();
      jy localjy = new jy();
      localjy.www = com.tencent.mm.bv.b.bL(paramYTAGFaceReflectResult.sidedata);
      localjy.wwx = com.tencent.mm.bv.b.bL(paramYTAGFaceReflectResult.data);
      p.d(localjy.toByteArray(), str);
      AppMethodBeat.o(800);
      return str;
    }
    catch (Exception paramYTAGFaceReflectResult)
    {
      ab.printErrStackTrace("MicroMsg.FaceReflectLogic", paramYTAGFaceReflectResult, "", new Object[0]);
      AppMethodBeat.o(800);
    }
    return null;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(801);
    if ((this.mState == 0) || (this.mState == 1))
    {
      this.mrP.aB(90004, "user cancelled in processing");
      AppMethodBeat.o(801);
      return;
    }
    if (this.mState == 2)
    {
      this.mrP.aB(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(801);
      return;
    }
    if (this.mState == 3) {
      this.mrP.aB(90006, "cancel with on stop");
    }
    AppMethodBeat.o(801);
  }
  
  public final void release()
  {
    AppMethodBeat.i(802);
    try
    {
      if ((this.mState == 0) || (this.mState == 1))
      {
        YTAGReflectLiveCheckInterface.cancel();
        AppMethodBeat.o(802);
        return;
      }
      YTAGReflectLiveCheckInterface.releaseModel();
      AppMethodBeat.o(802);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.FaceReflectLogic", localException, "release error, e: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(802);
    }
  }
  
  public static final class a
  {
    private static c mse;
    
    static
    {
      AppMethodBeat.i(799);
      mse = new c((byte)0);
      AppMethodBeat.o(799);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c
 * JD-Core Version:    0.7.0.1
 */