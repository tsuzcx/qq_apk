package com.tencent.mm.plugin.facedetectaction.b;

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
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;

public final class a
{
  public Context mContext;
  public int mDesiredPreviewHeight;
  public int mDesiredPreviewWidth;
  public int oLx;
  public int wDk;
  public String wDl;
  public TextView wDm;
  public Rect wDn;
  public Rect wDo;
  public int wDp;
  public int wDq;
  YTPoseDetectInterface.PoseDetectOnFrame wDr;
  public boolean wDs = false;
  
  public final void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Object localObject = null;
    AppMethodBeat.i(192342);
    if ((this.wDs) && (YTFaceTrack.IsInstanceExist()))
    {
      int i = YTCameraSetting.getRotate(this.mContext, this.oLx, 1);
      if (PluginFace.isEnabled()) {
        localObject = YTFaceTrack.getInstance().DoDetectionProcessYUV(paramArrayOfByte, this.mDesiredPreviewWidth, this.mDesiredPreviewHeight, i, null);
      }
      if (localObject != null)
      {
        b.aHj("faceRecognized");
        localObject = localObject[0];
        if (YTPoseDetectInterface.isDetecting())
        {
          if (localObject == null)
          {
            Log.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
            this.wDm.setText(a.i.face_preview_not_in_rect);
            AppMethodBeat.o(192342);
            return;
          }
          YTFaceUtils.shelterJudge(((YTFaceTrack.FaceStatus)localObject).pointsVis);
          if (this.wDr != null) {
            YTPoseDetectInterface.poseDetect(((YTFaceTrack.FaceStatus)localObject).xys, ((YTFaceTrack.FaceStatus)localObject).pointsVis, this.wDk, paramArrayOfByte, paramCamera, ((YTFaceTrack.FaceStatus)localObject).pitch, ((YTFaceTrack.FaceStatus)localObject).yaw, ((YTFaceTrack.FaceStatus)localObject).roll, this.wDr, 0);
          }
        }
        AppMethodBeat.o(192342);
        return;
      }
      Log.i("MicroMsg.FaceActionLogic", "No face");
    }
    AppMethodBeat.o(192342);
  }
  
  public static abstract interface a {}
  
  public static final class b
  {
    private static a wDu;
    
    static
    {
      AppMethodBeat.i(104203);
      wDu = new a((byte)0);
      AppMethodBeat.o(104203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.a
 * JD-Core Version:    0.7.0.1
 */