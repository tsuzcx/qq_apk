package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.l;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class CaptureDecoration$a
  implements Runnable
{
  CaptureDecoration$a(CaptureDecoration paramCaptureDecoration) {}
  
  public final void run()
  {
    AppMethodBeat.i(2988);
    CaptureDecoration.a(this.lyE).setImageDrawable(null);
    CaptureDecoration.b(this.lyE).setVisibility(8);
    AppMethodBeat.o(2988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration.a
 * JD-Core Version:    0.7.0.1
 */