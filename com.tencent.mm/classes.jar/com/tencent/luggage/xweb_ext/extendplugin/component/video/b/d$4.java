package com.tencent.luggage.xweb_ext.extendplugin.component.video.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$4
  implements MediaPlayer.OnInfoListener
{
  d$4(d paramd) {}
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139911);
    boolean bool = this.bIw.bO(paramInt1, paramInt2);
    AppMethodBeat.o(139911);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d.4
 * JD-Core Version:    0.7.0.1
 */