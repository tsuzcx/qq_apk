package com.tencent.mm.plugin.mmsight.model;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  implements Camera.AutoFocusCallback
{
  e$2(e parame) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    y.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[] { Boolean.valueOf(paramBoolean), e.g(this.mhf) });
    e.mhb = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.e.2
 * JD-Core Version:    0.7.0.1
 */