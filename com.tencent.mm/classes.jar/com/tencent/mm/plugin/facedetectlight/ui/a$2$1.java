package com.tencent.mm.plugin.facedetectlight.ui;

import android.hardware.Camera;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetectaction.b.a.b;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;

final class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2, byte[] paramArrayOfByte, Camera paramCamera) {}
  
  public final void run()
  {
    byte[] arrayOfByte;
    Camera localCamera;
    if (this.jXA.jXz.jXl)
    {
      if (a.e(this.jXA.jXz) != 1) {
        break label72;
      }
      b.a.aPE();
      arrayOfByte = this.val$data;
      localCamera = this.val$camera;
      if (YTFaceTraceInterface.isTracing()) {
        YTFaceTraceInterface.onPreviewFrame(arrayOfByte, localCamera);
      }
      if (YTAGReflectLiveCheckInterface.getProcessState() == 2) {
        YTAGReflectLiveCheckInterface.onPreviewFrame(arrayOfByte, localCamera);
      }
      d.aOf().av(arrayOfByte);
    }
    label72:
    do
    {
      return;
      a.b.aPw();
      arrayOfByte = this.val$data;
      localCamera = this.val$camera;
      if (YTFaceTraceInterface.isTracing())
      {
        YTFaceTraceInterface.onPreviewFrame(arrayOfByte, localCamera);
        return;
      }
    } while (YTAGReflectLiveCheckInterface.getProcessState() != 2);
    YTAGReflectLiveCheckInterface.onPreviewFrame(arrayOfByte, localCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.2.1
 * JD-Core Version:    0.7.0.1
 */