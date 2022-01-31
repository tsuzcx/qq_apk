package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$3
  implements MediaPlayer.OnCompletionListener
{
  d$3(d paramd) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(139910);
    this.bIw.mCurrentState = 6;
    this.bIw.xX();
    AppMethodBeat.o(139910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d.3
 * JD-Core Version:    0.7.0.1
 */