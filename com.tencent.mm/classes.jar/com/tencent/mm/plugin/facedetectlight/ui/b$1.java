package com.tencent.mm.plugin.facedetectlight.ui;

import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.e.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;

final class b$1
  implements YTFaceTraceInterface.FaceTraceingNotice
{
  b$1(b paramb) {}
  
  public final void onTracing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera)
  {
    y.i("MicroMsg.FaceReflectLogic", "facePreviewState：" + paramFaceStatus);
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      y.i("MicroMsg.FaceReflectLogic", "Face mState：init");
      return;
    case 2: 
      y.i("MicroMsg.FaceReflectLogic", "Face mState：stop detect");
      return;
    }
    y.i("MicroMsg.FaceReflectLogic", "Face mState：detecting");
    paramArrayOfByte = this.jXK;
    y.i("MicroMsg.FaceReflectLogic", "setFaceRect（）");
    paramArrayOfByte.jVS = paramArrayOfByte.jXm.getResources().getDisplayMetrics().widthPixels;
    paramArrayOfByte.jVT = paramArrayOfByte.jXm.getResources().getDisplayMetrics().heightPixels;
    paramArrayOfByte.jVR.left = ((int)(paramArrayOfByte.jVS * 0.15D));
    paramArrayOfByte.jVR.right = ((int)(paramArrayOfByte.jVS * 0.85D));
    paramArrayOfByte.jVR.top = ((int)(paramArrayOfByte.jVT * 0.2D));
    paramArrayOfByte.jVR.bottom = ((int)(paramArrayOfByte.jVT * 0.65D));
    paramArrayOfByte = this.jXK;
    y.i("MicroMsg.FaceReflectLogic", "setFaceLiveRect（）");
    y.i("MicroMsg.FaceReflectLogic", "faceInPreviewFrame is" + paramRect);
    if (paramRect != null)
    {
      paramInt = paramArrayOfByte.jVS;
      int i = paramArrayOfByte.jVT;
      int j = paramArrayOfByte.mDesiredPreviewWidth;
      int k = paramArrayOfByte.mDesiredPreviewHeight;
      paramArrayOfByte.jXH = (paramInt / k);
      paramArrayOfByte.jXI = (i / j);
      paramArrayOfByte.jVQ.left = ((int)(paramRect.left * paramArrayOfByte.jXH));
      paramArrayOfByte.jVQ.right = ((int)(paramRect.right * paramArrayOfByte.jXH));
      paramArrayOfByte.jVQ.top = ((int)(paramRect.top * paramArrayOfByte.jXI));
      paramArrayOfByte.jVQ.bottom = ((int)(paramRect.bottom * paramArrayOfByte.jXI));
      y.i("MicroMsg.FaceReflectLogic", "mUiWidth：" + paramArrayOfByte.jVS);
      y.i("MicroMsg.FaceReflectLogic", "mUiHeight：" + paramArrayOfByte.jVT);
      y.i("MicroMsg.FaceReflectLogic", "previewWidth：" + j);
      y.i("MicroMsg.FaceReflectLogic", "previewHeight：" + k);
      y.i("MicroMsg.FaceReflectLogic", "faceInPreviewFrame.right：" + paramRect.right);
      y.i("MicroMsg.FaceReflectLogic", "mReflectWidthRatio：" + paramArrayOfByte.jXH);
    }
    paramRect = this.jXK;
    paramArrayOfByte = this.jXK.jVR;
    paramCamera = this.jXK.jVQ;
    y.i("MicroMsg.FaceReflectLogic", "getFacePreviewAdvise（）");
    if (paramFaceStatus == null)
    {
      y.i("MicroMsg.FaceReflectLogic", "status == null");
      paramRect.jVO.setText(a.i.face_preview_not_in_rect);
    }
    for (;;)
    {
      y.i("MicroMsg.FaceReflectLogic", "Face end");
      return;
      boolean bool = paramArrayOfByte.contains(paramCamera);
      float f = (paramCamera.right - paramCamera.left) * (paramCamera.bottom - paramCamera.top) / ((paramArrayOfByte.right - paramArrayOfByte.left) * (paramArrayOfByte.bottom - paramArrayOfByte.top));
      y.i("MicroMsg.FaceReflectLogic", "faceInScreen left is ：" + paramCamera.left);
      y.i("MicroMsg.FaceReflectLogic", "faceInScreen right is ：" + paramCamera.right);
      y.i("MicroMsg.FaceReflectLogic", "faceInScreen top is ：" + paramCamera.top);
      y.i("MicroMsg.FaceReflectLogic", "faceInScreen bottom is ：" + paramCamera.bottom);
      y.i("MicroMsg.FaceReflectLogic", "checkRect left is ：" + paramArrayOfByte.left);
      y.i("MicroMsg.FaceReflectLogic", "checkRect right is ：" + paramArrayOfByte.right);
      y.i("MicroMsg.FaceReflectLogic", "checkRect top is ：" + paramArrayOfByte.top);
      y.i("MicroMsg.FaceReflectLogic", "checkRect bottom is ：" + paramArrayOfByte.bottom);
      y.i("MicroMsg.FaceReflectLogic", "faceProportion ：" + f);
      y.i("MicroMsg.FaceReflectLogic", "isInRect？ ：" + bool);
      y.i("MicroMsg.FaceReflectLogic", "status" + paramFaceStatus);
      if (f < 0.3D)
      {
        y.i("MicroMsg.FaceReflectLogic", "Detecting result：too far");
        paramRect.jVO.setText(a.i.face_preview_too_far);
      }
      else if (f > 0.75D)
      {
        y.i("MicroMsg.FaceReflectLogic", "Detecting result：too close");
        paramRect.jVO.setText(a.i.face_preview_too_close);
      }
      else if (!bool)
      {
        y.i("MicroMsg.FaceReflectLogic", "Detecting result：out of rect");
        paramRect.jVO.setText(a.i.face_preview_not_in_rect);
      }
      else if ((Math.abs(paramFaceStatus.pitch) > 15.0F) || (Math.abs(paramFaceStatus.yaw) > 15.0F) || (Math.abs(paramFaceStatus.roll) > 15.0F))
      {
        y.i("MicroMsg.FaceReflectLogic", "Detecting result：INCORRECT_POSTURE");
        paramRect.jVO.setText(a.i.face_preview_posture_incorrect);
      }
      else
      {
        y.i("MicroMsg.FaceReflectLogic", "Detecting result：normal");
        paramRect.jVO.setText(a.i.face_preview_posture_correct);
        YTFaceTraceInterface.stop();
        y.i("MicroMsg.FaceReflectLogic", "YTFacePreviewInterface.stop()");
        if (a.aPj().jST) {
          a.aPj().uq();
        }
        ai.l(new b.2(paramRect), 2000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.1
 * JD-Core Version:    0.7.0.1
 */