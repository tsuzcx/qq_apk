package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2
  implements MediaPlayer.OnVideoSizeChangedListener
{
  d$2(d paramd) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139909);
    this.bIw.bM(paramInt1, paramInt2);
    AppMethodBeat.o(139909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d.2
 * JD-Core Version:    0.7.0.1
 */