package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ig;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequester.UploadVideoResponse;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;

public final class b
{
  int gov;
  byte[] jQQ;
  TextView jVO;
  Rect jVQ;
  Rect jVR;
  int jVS;
  int jVT;
  YTFaceTraceInterface.FaceTraceingNotice jVW;
  int jXF;
  Point jXG;
  float jXH;
  float jXI;
  UploadVideoRequester.UploadVideoResponse jXJ;
  FaceReflectUI jXm;
  FaceReflectMask jXo;
  String jXr;
  String mAppId;
  Camera mCamera;
  Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  int mState = 0;
  
  static String a(YTAGFaceReflectResult paramYTAGFaceReflectResult)
  {
    if ((paramYTAGFaceReflectResult == null) || (paramYTAGFaceReflectResult.result != 0))
    {
      y.e("MicroMsg.FaceReflectLogic", "carson  face result is null or result code not 0");
      return null;
    }
    try
    {
      String str = o.aOG();
      ig localig = new ig();
      localig.sCb = com.tencent.mm.bv.b.bk(paramYTAGFaceReflectResult.sidedata);
      localig.sCc = com.tencent.mm.bv.b.bk(paramYTAGFaceReflectResult.data);
      o.f(localig.toByteArray(), str);
      return str;
    }
    catch (Exception paramYTAGFaceReflectResult)
    {
      y.printErrStackTrace("MicroMsg.FaceReflectLogic", paramYTAGFaceReflectResult, "", new Object[0]);
    }
    return null;
  }
  
  public final void onBackPressed()
  {
    if ((this.mState == 0) || (this.mState == 1)) {
      this.jXm.a(1, 90004, "user cancelled in processing", null);
    }
    do
    {
      return;
      if (this.mState == 2)
      {
        this.jXm.a(1, 90025, "user cancelled in intermediate page", null);
        return;
      }
    } while (this.mState != 3);
    this.jXm.a(1, 90006, "cancel with on stop", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b
 * JD-Core Version:    0.7.0.1
 */