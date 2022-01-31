package com.tencent.mm.plugin.facedetectlight.ui;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.al;

final class b$2
  implements Camera.PreviewCallback
{
  b$2(b paramb) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(760);
    b.A(this.mrQ).ac(new b.2.1(this, paramArrayOfByte, paramCamera));
    AppMethodBeat.o(760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.b.2
 * JD-Core Version:    0.7.0.1
 */