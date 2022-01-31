package com.tencent.mm.compatible.util;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$1
  implements AudioManager.OnAudioFocusChangeListener
{
  c$1(c paramc) {}
  
  public final void onAudioFocusChange(int paramInt)
  {
    AppMethodBeat.i(93064);
    if (this.esn.esl != null)
    {
      ab.d("MicroMsg.AudioFocusHelper", "jacks change: %d", new Object[] { Integer.valueOf(paramInt) });
      this.esn.esl.gz(paramInt);
    }
    AppMethodBeat.o(93064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.util.c.1
 * JD-Core Version:    0.7.0.1
 */