package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class FTSVoiceInputLayoutImpl$6
  implements Runnable
{
  FTSVoiceInputLayoutImpl$6(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final void run()
  {
    AppMethodBeat.i(62186);
    b localb = FTSVoiceInputLayoutImpl.b(this.ncg);
    ab.d("MicroMsg.FTSVoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(localb.currentState) });
    localb.currentState = 4;
    AppMethodBeat.o(62186);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.6
 * JD-Core Version:    0.7.0.1
 */