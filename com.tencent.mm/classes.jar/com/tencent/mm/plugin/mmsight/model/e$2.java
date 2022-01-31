package com.tencent.mm.plugin.mmsight.model;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$2
  implements Camera.AutoFocusCallback
{
  e$2(e parame) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(76469);
    ab.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", new Object[] { Boolean.valueOf(paramBoolean), e.f(this.oHp) });
    e.oHn = true;
    AppMethodBeat.o(76469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.e.2
 * JD-Core Version:    0.7.0.1
 */