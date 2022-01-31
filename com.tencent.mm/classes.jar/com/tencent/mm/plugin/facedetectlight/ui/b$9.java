package com.tencent.mm.plugin.facedetectlight.ui;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class b$9
  implements Camera.PreviewCallback
{
  b$9(b paramb, Camera.PreviewCallback paramPreviewCallback) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(770);
    al.d(new b.9.1(this));
    if (this.mjb != null) {
      this.mjb.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
    paramCamera.addCallbackBuffer(paramArrayOfByte);
    AppMethodBeat.o(770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.9
 * JD-Core Version:    0.7.0.1
 */