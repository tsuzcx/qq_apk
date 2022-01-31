package com.tencent.mm.plugin.facedetectaction.b;

import android.content.res.Resources;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface.FaceTraceingNotice;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface.PoseDetectResult;

public final class a$1
  implements YTFaceTraceInterface.FaceTraceingNotice
{
  public a$1(a parama) {}
  
  public final void onTracing(int paramInt, YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, Rect paramRect, byte[] paramArrayOfByte, Camera paramCamera)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      y.i("MicroMsg.FaceActionLogic", "Face mState：init");
      YTPoseDetectInterface.start(ae.getContext(), this.jVY.mCamera, this.jVY.gov, new YTPoseDetectInterface.PoseDetectResult()
      {
        public final void onFailed(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
        {
          y.i("MicroMsg.FaceActionLogic", "YTPoseDetectInterface start failed：[%s],[%s]", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        }
        
        public final void onSuccess()
        {
          y.i("MicroMsg.FaceActionLogic", "YTPoseDetectInterface start success");
        }
      });
      return;
    case 2: 
      y.i("MicroMsg.FaceActionLogic", "Face mState：stop detect");
      return;
    }
    y.i("MicroMsg.FaceActionLogic", "Face mState：detecting");
    paramCamera = this.jVY;
    y.i("MicroMsg.FaceActionLogic", "setFaceRect（）");
    paramCamera.jVS = paramCamera.jVN.getResources().getDisplayMetrics().widthPixels;
    paramCamera.jVT = paramCamera.jVN.getResources().getDisplayMetrics().heightPixels;
    paramCamera.jVR.left = ((int)(paramCamera.jVS * 0.15D));
    paramCamera.jVR.right = ((int)(paramCamera.jVS * 0.85D));
    paramCamera.jVR.top = ((int)(paramCamera.jVT * 0.2D));
    paramCamera.jVR.bottom = ((int)(paramCamera.jVT * 0.65D));
    paramCamera = this.jVY;
    y.i("MicroMsg.FaceActionLogic", "setFaceLiveRect（）");
    y.i("MicroMsg.FaceActionLogic", "faceInPreviewFrame is" + paramRect);
    if (paramRect != null)
    {
      paramInt = paramCamera.jVS;
      int i = paramCamera.jVT;
      int j = paramCamera.mDesiredPreviewWidth;
      int k = paramCamera.mDesiredPreviewHeight;
      paramCamera.jVU = (paramInt / k);
      paramCamera.jVV = (i / j);
      paramCamera.jVQ.left = ((int)(paramRect.left * paramCamera.jVU));
      paramCamera.jVQ.right = ((int)(paramRect.right * paramCamera.jVU));
      paramCamera.jVQ.top = ((int)(paramRect.top * paramCamera.jVV));
      paramCamera.jVQ.bottom = ((int)(paramRect.bottom * paramCamera.jVV));
      y.i("MicroMsg.FaceActionLogic", "mUiWidth：" + paramCamera.jVS);
      y.i("MicroMsg.FaceActionLogic", "mUiHeight：" + paramCamera.jVT);
      y.i("MicroMsg.FaceActionLogic", "previewWidth：" + j);
      y.i("MicroMsg.FaceActionLogic", "previewHeight：" + k);
      y.i("MicroMsg.FaceActionLogic", "faceInPreviewFrame.right：" + paramRect.right);
      y.i("MicroMsg.FaceActionLogic", "mWidthRatio：" + paramCamera.jVU);
    }
    paramRect = this.jVY;
    paramCamera = this.jVY.jVR;
    Rect localRect = this.jVY.jVQ;
    y.i("MicroMsg.FaceActionLogic", "getFacePreviewAdvise（）");
    if (paramFaceStatus == null)
    {
      y.i("MicroMsg.FaceActionLogic", "status == null");
      paramRect.jVO.setText(a.i.face_preview_not_in_rect);
      return;
    }
    boolean bool = paramCamera.contains(localRect);
    float f = (localRect.right - localRect.left) * (localRect.bottom - localRect.top) / ((paramCamera.right - paramCamera.left) * (paramCamera.bottom - paramCamera.top));
    y.i("MicroMsg.FaceActionLogic", "faceInScreen left is ：" + localRect.left);
    y.i("MicroMsg.FaceActionLogic", "faceInScreen right is ：" + localRect.right);
    y.i("MicroMsg.FaceActionLogic", "faceInScreen top is ：" + localRect.top);
    y.i("MicroMsg.FaceActionLogic", "faceInScreen bottom is ：" + localRect.bottom);
    y.i("MicroMsg.FaceActionLogic", "checkRect left is ：" + paramCamera.left);
    y.i("MicroMsg.FaceActionLogic", "checkRect right is ：" + paramCamera.right);
    y.i("MicroMsg.FaceActionLogic", "checkRect top is ：" + paramCamera.top);
    y.i("MicroMsg.FaceActionLogic", "checkRect bottom is ：" + paramCamera.bottom);
    y.i("MicroMsg.FaceActionLogic", "faceProportion ：" + f);
    y.i("MicroMsg.FaceActionLogic", "isInRect？ ：" + bool);
    y.i("MicroMsg.FaceActionLogic", "status" + paramFaceStatus);
    if (f < 0.3D)
    {
      y.i("MicroMsg.FaceActionLogic", "Detecting result：too far");
      paramRect.jVO.setText(a.i.face_preview_too_far);
      return;
    }
    if (f > 0.75D)
    {
      y.i("MicroMsg.FaceActionLogic", "Detecting result：too close");
      paramRect.jVO.setText(a.i.face_preview_too_close);
      return;
    }
    if (!bool)
    {
      y.i("MicroMsg.FaceActionLogic", "Detecting result：out of rect");
      paramRect.jVO.setText(a.i.face_preview_not_in_rect);
      return;
    }
    y.i("MicroMsg.FaceActionLogic", "Detecting result：normal");
    y.i("MicroMsg.FaceActionLogic", "action：%s,mActionHint:%s", new Object[] { Integer.valueOf(paramRect.jVL), paramRect.jVM });
    if (paramRect.jVM != null) {
      paramRect.jVO.setText(paramRect.jVM);
    }
    for (;;)
    {
      paramRect.jVP.a(paramFaceStatus, paramArrayOfByte);
      return;
      switch (paramRect.jVL)
      {
      default: 
        break;
      case 0: 
        paramRect.jVO.setText(a.i.face_action_shake);
        break;
      case 1: 
        paramRect.jVO.setText(a.i.face_action_blink);
        break;
      case 2: 
        paramRect.jVO.setText(a.i.face_action_open);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.b.a.1
 * JD-Core Version:    0.7.0.1
 */