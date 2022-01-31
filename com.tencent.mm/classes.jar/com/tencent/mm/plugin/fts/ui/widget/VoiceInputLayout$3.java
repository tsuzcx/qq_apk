package com.tencent.mm.plugin.fts.ui.widget;

import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class VoiceInputLayout$3
  extends ak
{
  VoiceInputLayout$3(VoiceInputLayout paramVoiceInputLayout) {}
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(62212);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62212);
      return;
      this.ncq.bDH();
      AppMethodBeat.o(62212);
      return;
      paramMessage = paramMessage.getData();
      this.ncq.U(paramMessage.getInt("localCode"), paramMessage.getInt("errType"), paramMessage.getInt("errCode"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.VoiceInputLayout.3
 * JD-Core Version:    0.7.0.1
 */