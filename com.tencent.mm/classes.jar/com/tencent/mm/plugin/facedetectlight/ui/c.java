package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.e.a.b;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.jni.model.ReflectLiveReq;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBackType;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2;
import com.tencent.youtu.ytagreflectlivecheck.requester.UploadVideoRequesterV2.UploadVideoResponse;
import com.tencent.youtu.ytcommon.tools.YTFaceUtils;
import com.tencent.youtu.ytcommon.tools.wejson.WeJson;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  int jLH;
  public String mAppId;
  Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  public int mState = 0;
  byte[] pRV;
  TextView pWP;
  Rect pWR;
  Rect pWS;
  int pYA;
  int pYB;
  Point pYC;
  float pYD;
  float pYE;
  UploadVideoRequesterV2.UploadVideoResponse pYF;
  v pYf;
  FaceReflectMask pYi;
  String pYl;
  public com.tencent.mm.plugin.facedetectlight.ui.a.b pYr;
  int pYz;
  
  static String a(YTAGFaceReflectResult paramYTAGFaceReflectResult)
  {
    AppMethodBeat.i(104320);
    if ((paramYTAGFaceReflectResult == null) || (paramYTAGFaceReflectResult.result != 0))
    {
      ad.e("MicroMsg.FaceReflectLogic", "carson  face result is null or result code not 0");
      AppMethodBeat.o(104320);
      return null;
    }
    try
    {
      String str = p.cgf();
      lg locallg = new lg();
      locallg.CGF = com.tencent.mm.bx.b.cd(paramYTAGFaceReflectResult.sidedata);
      locallg.CGG = com.tencent.mm.bx.b.cd(paramYTAGFaceReflectResult.data);
      p.e(locallg.toByteArray(), str);
      AppMethodBeat.o(104320);
      return str;
    }
    catch (Exception paramYTAGFaceReflectResult)
    {
      ad.printErrStackTrace("MicroMsg.FaceReflectLogic", paramYTAGFaceReflectResult, "", new Object[0]);
      AppMethodBeat.o(104320);
    }
    return null;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(104321);
    if ((this.mState == 0) || (this.mState == 1))
    {
      this.pYr.aR(90004, "user cancelled in processing");
      AppMethodBeat.o(104321);
      return;
    }
    if (this.mState == 2)
    {
      this.pYr.aR(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(104321);
      return;
    }
    if (this.mState == 3) {
      this.pYr.aR(90006, "cancel with on stop");
    }
    AppMethodBeat.o(104321);
  }
  
  public final void release()
  {
    AppMethodBeat.i(104322);
    try
    {
      ad.i("MicroMsg.FaceReflectLogic", "release ");
      if ((this.mState == 0) || (this.mState == 1)) {
        YTAGReflectLiveCheckInterface.cancel();
      }
      this.mState = 4;
      YTAGReflectLiveCheckInterface.releaseModel();
      if ((PluginFace.isEnabled()) && (YTFaceTrack.getInstance() != null)) {
        YTFaceTrack.GlobalRelease();
      }
      AppMethodBeat.o(104322);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.FaceReflectLogic", localException, "release error, e: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(104322);
    }
  }
  
  public static final class a
  {
    private static c pYK;
    
    static
    {
      AppMethodBeat.i(104319);
      pYK = new c((byte)0);
      AppMethodBeat.o(104319);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c
 * JD-Core Version:    0.7.0.1
 */