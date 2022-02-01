package com.tencent.mm.plugin.mmsight.model;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class f$2
  implements Camera.AutoFocusCallback
{
  f$2(f paramf) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(89362);
    ae.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[] { Boolean.valueOf(paramBoolean), f.f(this.wac) });
    f.waa = true;
    AppMethodBeat.o(89362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.f.2
 * JD-Core Version:    0.7.0.1
 */