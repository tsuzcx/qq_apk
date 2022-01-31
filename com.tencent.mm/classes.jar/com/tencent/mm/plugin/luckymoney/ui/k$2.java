package com.tencent.mm.plugin.luckymoney.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.y;

final class k$2
  implements MediaPlayer.OnCompletionListener
{
  k$2(String paramString) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer == null) {}
    for (int i = -1;; i = paramMediaPlayer.hashCode())
    {
      y.i("MicroMsg.LuckySoundUtil", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.dlh });
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.k.2
 * JD-Core Version:    0.7.0.1
 */