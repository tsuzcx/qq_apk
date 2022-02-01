package com.tencent.mm.plugin.facedetectaction.model;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.flash.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.youtu.ytcommon.tools.YTFaceUtils;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytfacetrack.YTFaceTrack.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectOnFrame;

public final class a
{
  public Context mContext;
  public int mDesiredPreviewHeight;
  public int mDesiredPreviewWidth;
  public int zS;
  public int zZA;
  public int zZB;
  YTPoseDetectInterface.PoseDetectOnFrame zZC;
  public boolean zZD = false;
  public int zZv;
  public String zZw;
  public TextView zZx;
  public Rect zZy;
  public Rect zZz;
  
  public final void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Object localObject = null;
    AppMethodBeat.i(262610);
    if ((this.zZD) && (YTFaceTrack.IsInstanceExist()))
    {
      int i = YTCameraSetting.getRotate(this.mContext, this.zS, 1);
      if (PluginFace.isEnabled()) {
        localObject = YTFaceTrack.getInstance().DoDetectionProcessYUV(paramArrayOfByte, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, i, null);
      }
      if (localObject != null)
      {
        b.aDB("faceRecognized");
        localObject = localObject[0];
        if (YTPoseDetectInterface.isDetecting())
        {
          if (localObject == null)
          {
            Log.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
            this.zZx.setText(a.i.face_preview_not_in_rect);
            AppMethodBeat.o(262610);
            return;
          }
          YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject).pointsVis);
          if (this.zZC != null) {
            YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject).xys, ((YTFaceTrack.FaceStatus)localObject).pointsVis, this.zZv, paramArrayOfByte, paramCamera, ((YTFaceTrack.FaceStatus)localObject).pitch, ((YTFaceTrack.FaceStatus)localObject).yaw, ((YTFaceTrack.FaceStatus)localObject).roll, this.zZC, 0);
          }
        }
        AppMethodBeat.o(262610);
        return;
      }
      Log.i("MicroMsg.FaceActionLogic", "No face");
    }
    AppMethodBeat.o(262610);
  }
  
  public static abstract interface a {}
  
  public static final class b
  {
    private static a zZF;
    
    static
    {
      AppMethodBeat.i(104203);
      zZF = new a((byte)0);
      AppMethodBeat.o(104203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.model.a
 * JD-Core Version:    0.7.0.1
 */