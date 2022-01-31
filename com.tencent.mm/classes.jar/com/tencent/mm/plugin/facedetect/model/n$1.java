package com.tencent.mm.plugin.facedetect.model;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$1
  implements Camera.PreviewCallback
{
  n$1(n paramn, Camera.PreviewCallback paramPreviewCallback) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(252);
    if (this.mjb != null) {
      this.mjb.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    paramCamera.addCallbackBuffer(paramArrayOfByte);
    AppMethodBeat.o(252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.model.n.1
 * JD-Core Version:    0.7.0.1
 */