package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FTSVoiceInputLayoutImpl$5
  implements Runnable
{
  FTSVoiceInputLayoutImpl$5(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final void run()
  {
    AppMethodBeat.i(62185);
    b localb = FTSVoiceInputLayoutImpl.b(this.ncg);
    boolean bool = this.nch;
    ab.d("MicroMsg.FTSVoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(bool) });
    if (!bool) {
      localb.currentState = 3;
    }
    localb.nbH = b.wD(0);
    localb.invalidateSelf();
    localb.nbJ = 0;
    AppMethodBeat.o(62185);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.5
 * JD-Core Version:    0.7.0.1
 */