package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$7
  implements MediaPlayer.OnBufferingUpdateListener
{
  d$7(d paramd) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(139914);
    this.bIw.fE(paramInt);
    AppMethodBeat.o(139914);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d.7
 * JD-Core Version:    0.7.0.1
 */