package com.tencent.mm.plugin.fts.ui.widget;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class VoiceInputLayout$1
  extends ak
{
  VoiceInputLayout$1(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(62207);
    if (paramMessage.what != 0)
    {
      if (paramMessage.what == 1) {
        ab.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(this.ncq.currentState) });
      }
    }
    else
    {
      ab.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(this.ncq.currentState) });
      if (this.ncq.currentState == 3) {
        break label91;
      }
      AppMethodBeat.o(62207);
      return;
    }
    AppMethodBeat.o(62207);
    return;
    label91:
    VoiceInputLayout.a(this.ncq).removeMessages(0);
    VoiceInputLayout.a(this.ncq).removeMessages(1);
    if (VoiceInputLayout.b(this.ncq) != null) {
      VoiceInputLayout.b(this.ncq).cancel(true);
    }
    this.ncq.reset(true);
    AppMethodBeat.o(62207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.1
 * JD-Core Version:    0.7.0.1
 */