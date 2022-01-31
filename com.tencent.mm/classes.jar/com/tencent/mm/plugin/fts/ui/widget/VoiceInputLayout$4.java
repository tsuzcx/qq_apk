package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.b;
import com.tencent.mm.sdk.platformtools.ap.a;

final class VoiceInputLayout$4
  implements ap.a
{
  VoiceInputLayout$4(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(62213);
    if (VoiceInputLayout.b(this.ncq) == null)
    {
      AppMethodBeat.o(62213);
      return true;
    }
    int i = VoiceInputLayout.b(this.ncq).getMaxAmplitudeRate();
    if (this.ncq.currentState == 2) {
      this.ncq.wF(i);
    }
    AppMethodBeat.o(62213);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.4
 * JD-Core Version:    0.7.0.1
 */