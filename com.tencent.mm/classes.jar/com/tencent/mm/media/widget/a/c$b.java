package com.tencent.mm.media.widget.a;

import a.l;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "success", "", "camera", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "onAutoFocus"})
final class c$b
  implements Camera.AutoFocusCallback
{
  c$b(c paramc) {}
  
  public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(13189);
    ab.v(c.a(this.fao), "auto focus callback success ".concat(String.valueOf(paramBoolean)));
    this.fao.fag = true;
    AppMethodBeat.o(13189);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.c.b
 * JD-Core Version:    0.7.0.1
 */