package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.d;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "onSimpleTap"})
final class CaptureContainer$2
  implements MMSightRecordButton.d
{
  CaptureContainer$2(CaptureContainer paramCaptureContainer) {}
  
  public final void bpa()
  {
    AppMethodBeat.i(2950);
    ab.i(CaptureContainer.e(this.lyp), "simpleTapCallback");
    CaptureContainer.a(this.lyp, false);
    AppMethodBeat.o(2950);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.2
 * JD-Core Version:    0.7.0.1
 */