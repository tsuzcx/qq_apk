package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$1
  implements MediaPlayer.OnPreparedListener
{
  d$1(d paramd) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(139908);
    this.bIw.mCurrentState = 2;
    this.bIw.xW();
    AppMethodBeat.o(139908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d.1
 * JD-Core Version:    0.7.0.1
 */