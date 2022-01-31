package com.tencent.mm.plugin.facedetectlight.ui;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.ui.base.MMTextureView;

final class a$9
  implements Camera.PreviewCallback
{
  a$9(a parama, Camera.PreviewCallback paramPreviewCallback) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    a.y(this.jXz).setAlpha(1.0F);
    if (this.jOL != null) {
      this.jOL.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    paramCamera.addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.9
 * JD-Core Version:    0.7.0.1
 */