package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FTSVoiceInputLayoutImpl$8
  implements Runnable
{
  FTSVoiceInputLayoutImpl$8(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(62188);
    b localb = FTSVoiceInputLayoutImpl.b(this.ncg);
    int i = this.nci;
    ab.d("MicroMsg.FTSVoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(i) });
    localb.nbH = b.wD(i);
    localb.invalidateSelf();
    localb.nbJ = i;
    AppMethodBeat.o(62188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.8
 * JD-Core Version:    0.7.0.1
 */