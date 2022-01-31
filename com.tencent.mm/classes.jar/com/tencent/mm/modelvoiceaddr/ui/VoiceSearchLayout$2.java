package com.tencent.mm.modelvoiceaddr.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VoiceSearchLayout$2
  implements MediaPlayer.OnCompletionListener
{
  VoiceSearchLayout$2(VoiceSearchLayout paramVoiceSearchLayout) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(116765);
    paramMediaPlayer.release();
    AppMethodBeat.o(116765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.2
 * JD-Core Version:    0.7.0.1
 */