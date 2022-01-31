package com.tencent.mm.plugin.facedetect.views;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.sdk.platformtools.y;

final class FaceDetectCameraView$c$3
  implements Camera.PreviewCallback
{
  FaceDetectCameraView$c$3(FaceDetectCameraView.c paramc) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    y.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
    d.aOf().av(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.3
 * JD-Core Version:    0.7.0.1
 */