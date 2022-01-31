package com.tencent.mm.plugin.facedetectaction.ui;

import android.hardware.Camera;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.b;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.mm.plugin.facedetectlight.ui.a;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

final class FaceActionUI$1
  implements a.a
{
  FaceActionUI$1(FaceActionUI paramFaceActionUI) {}
  
  public final void a(YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, byte[] paramArrayOfByte)
  {
    Object localObject = d.jWf;
    Camera localCamera = FaceActionUI.b(this.jWU).mCamera;
    if (((d)localObject).jWg != null)
    {
      ((d)localObject).mStatus = 1;
      localObject = ((d)localObject).jWg;
      if (paramFaceStatus != null)
      {
        ((b)localObject).status = 2;
        YTPoseDetectInterface.poseDetect(paramFaceStatus.xys, ((b)localObject).jWb, paramArrayOfByte, localCamera, paramFaceStatus.pitch, paramFaceStatus.yaw, paramFaceStatus.roll, ((b)localObject).jWc);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.1
 * JD-Core Version:    0.7.0.1
 */