package com.tencent.mm.plugin.facedetectlight.ui;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetectaction.b.a.b;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface;
import com.tencent.youtu.ytfacetrace.YTFaceTraceInterface;

final class b$2$1
  implements Runnable
{
  b$2$1(b.2 param2, byte[] paramArrayOfByte, Camera paramCamera) {}
  
  public final void run()
  {
    AppMethodBeat.i(759);
    if (this.mrR.mrQ.mrE)
    {
      if (b.e(this.mrR.mrQ) == 1)
      {
        c.a.bvQ();
        arrayOfByte = this.val$data;
        localCamera = this.val$camera;
        if (YTFaceTraceInterface.isTracing()) {
          YTFaceTraceInterface.onPreviewFrame(arrayOfByte, localCamera);
        }
        if (YTAGReflectLiveCheckInterface.getProcessState() == 2) {
          YTAGReflectLiveCheckInterface.onPreviewFrame(arrayOfByte, localCamera);
        }
        d.bui().aT(arrayOfByte);
        AppMethodBeat.o(759);
        return;
      }
      a.b.bvF();
      byte[] arrayOfByte = this.val$data;
      Camera localCamera = this.val$camera;
      if (YTFaceTraceInterface.isTracing())
      {
        YTFaceTraceInterface.onPreviewFrame(arrayOfByte, localCamera);
        AppMethodBeat.o(759);
        return;
      }
      if (YTAGReflectLiveCheckInterface.getProcessState() == 2) {
        YTAGReflectLiveCheckInterface.onPreviewFrame(arrayOfByte, localCamera);
      }
    }
    AppMethodBeat.o(759);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.2.1
 * JD-Core Version:    0.7.0.1
 */