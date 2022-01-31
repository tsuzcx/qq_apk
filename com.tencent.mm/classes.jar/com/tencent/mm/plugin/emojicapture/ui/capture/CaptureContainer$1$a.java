package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onProgressFinish"})
final class CaptureContainer$1$a
  implements MMSightCircularProgressBar.a
{
  CaptureContainer$1$a(CaptureContainer.1 param1) {}
  
  public final void boZ()
  {
    AppMethodBeat.i(2945);
    ab.i(CaptureContainer.e(this.lyq.lyp), "onLongPress");
    CaptureContainer.a(this.lyq.lyp, this.lyq.lyp.c((b)new CaptureContainer.1.a.1(this)));
    AppMethodBeat.o(2945);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.1.a
 * JD-Core Version:    0.7.0.1
 */