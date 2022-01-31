package com.tencent.mm.plugin.facedetect.model;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

final class m$1
  implements Camera.PreviewCallback
{
  m$1(m paramm, Camera.PreviewCallback paramPreviewCallback) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (this.jOL != null) {
      this.jOL.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    paramCamera.addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.m.1
 * JD-Core Version:    0.7.0.1
 */