package com.tencent.mm.plugin.facedetectaction.ui;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.facedetectaction.b.a.a;
import com.tencent.mm.plugin.facedetectaction.b.d;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

final class FaceActionUI$1
  implements a.a
{
  FaceActionUI$1(FaceActionUI paramFaceActionUI) {}
  
  public final void a(YTFaceTraceJNIInterface.FaceStatus paramFaceStatus, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(709);
    Object localObject = d.mqx;
    Camera localCamera = FaceActionUI.b(this.mrl).mrD.eqF;
    if (((d)localObject).mqy != null)
    {
      ((d)localObject).mStatus = 1;
      localObject = ((d)localObject).mqy;
      if (paramFaceStatus != null)
      {
        ((com.tencent.mm.plugin.facedetectaction.b.b)localObject).status = 2;
        YTPoseDetectInterface.poseDetect(paramFaceStatus.xys, ((com.tencent.mm.plugin.facedetectaction.b.b)localObject).mqt, paramArrayOfByte, localCamera, paramFaceStatus.pitch, paramFaceStatus.yaw, paramFaceStatus.roll, ((com.tencent.mm.plugin.facedetectaction.b.b)localObject).mqu);
      }
    }
    AppMethodBeat.o(709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI.1
 * JD-Core Version:    0.7.0.1
 */