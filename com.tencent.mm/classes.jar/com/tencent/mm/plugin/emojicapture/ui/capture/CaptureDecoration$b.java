package com.tencent.mm.plugin.emojicapture.ui.capture;

import a.l;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class CaptureDecoration$b
  implements Runnable
{
  CaptureDecoration$b(CaptureDecoration paramCaptureDecoration) {}
  
  public final void run()
  {
    AppMethodBeat.i(2989);
    CaptureDecoration localCaptureDecoration = this.lyE;
    localCaptureDecoration.lyx.animate().cancel();
    localCaptureDecoration.lyx.animate().alpha(0.0F).withEndAction((Runnable)new CaptureDecoration.a(localCaptureDecoration));
    AppMethodBeat.o(2989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.capture.CaptureDecoration.b
 * JD-Core Version:    0.7.0.1
 */