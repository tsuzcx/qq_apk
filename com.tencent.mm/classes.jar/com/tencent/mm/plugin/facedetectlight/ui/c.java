package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectForWXJNIInterface;
import com.tencent.mm.plugin.facedetectlight.Utils.YTAGFaceReflectResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.lw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  int kKx;
  public String mAppId;
  Context mContext;
  int mDesiredPreviewHeight;
  int mDesiredPreviewWidth;
  public int mState = 0;
  byte[] rsx;
  TextView rxq;
  Rect rxs;
  Rect rxt;
  UploadVideoRequesterV2.UploadVideoResponse rzA;
  v rza;
  FaceReflectMask rzd;
  String rzg;
  public com.tencent.mm.plugin.facedetectlight.ui.a.b rzm;
  int rzu;
  int rzv;
  int rzw;
  Point rzx;
  float rzy;
  float rzz;
  
  static String a(YTAGFaceReflectResult paramYTAGFaceReflectResult)
  {
    AppMethodBeat.i(104320);
    if ((paramYTAGFaceReflectResult == null) || (paramYTAGFaceReflectResult.result != 0))
    {
      ae.e("MicroMsg.FaceReflectLogic", "carson  face result is null or result code not 0");
      AppMethodBeat.o(104320);
      return null;
    }
    try
    {
      String str = p.cuS();
      lw locallw = new lw();
      locallw.FWW = com.tencent.mm.bw.b.cm(paramYTAGFaceReflectResult.sidedata);
      locallw.FWX = com.tencent.mm.bw.b.cm(paramYTAGFaceReflectResult.data);
      p.e(locallw.toByteArray(), str);
      AppMethodBeat.o(104320);
      return str;
    }
    catch (Exception paramYTAGFaceReflectResult)
    {
      ae.printErrStackTrace("MicroMsg.FaceReflectLogic", paramYTAGFaceReflectResult, "", new Object[0]);
      AppMethodBeat.o(104320);
    }
    return null;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(104321);
    if ((this.mState == 0) || (this.mState == 1))
    {
      this.rzm.aW(90004, "user cancelled in processing");
      AppMethodBeat.o(104321);
      return;
    }
    if (this.mState == 2)
    {
      this.rzm.aW(90025, "user cancelled in intermediate page");
      AppMethodBeat.o(104321);
      return;
    }
    if (this.mState == 3) {
      this.rzm.aW(90006, "cancel with on stop");
    }
    AppMethodBeat.o(104321);
  }
  
  public final void release()
  {
    AppMethodBeat.i(104322);
    try
    {
      ae.i("MicroMsg.FaceReflectLogic", "release ");
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
      ae.printErrStackTrace("MicroMsg.FaceReflectLogic", localException, "release error, e: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(104322);
    }
  }
  
  public static final class a
  {
    private static c rzF;
    
    static
    {
      AppMethodBeat.i(104319);
      rzF = new c((byte)0);
      AppMethodBeat.o(104319);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.c
 * JD-Core Version:    0.7.0.1
 */