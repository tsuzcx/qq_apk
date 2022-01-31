package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.c;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/emojicapture/ui/capture/CaptureContainer$3", "Lcom/tencent/mm/plugin/mmsight/ui/MMSightRecordButton$LongPressScrollCallback;", "onScrollDown", "", "factor", "", "onScrollUp", "plugin-emojicapture_release"})
public final class CaptureContainer$3
  implements MMSightRecordButton.c
{
  public final void uR(int paramInt)
  {
    AppMethodBeat.i(2951);
    CaptureContainer.c(this.lyp).a(true, true, paramInt);
    AppMethodBeat.o(2951);
  }
  
  public final void uS(int paramInt)
  {
    AppMethodBeat.i(2952);
    CaptureContainer.c(this.lyp).a(false, true, paramInt);
    AppMethodBeat.o(2952);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureContainer.3
 * JD-Core Version:    0.7.0.1
 */