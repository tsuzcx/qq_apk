package com.tencent.mm.plugin.facedetectlight.ui;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import com.tencent.mm.sdk.platformtools.ai;

final class a$2
  implements Camera.PreviewCallback
{
  a$2(a parama) {}
  
  public final void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    a.z(this.jXz).O(new a.2.1(this, paramArrayOfByte, paramCamera));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a.2
 * JD-Core Version:    0.7.0.1
 */