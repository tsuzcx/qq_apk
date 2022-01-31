package com.tencent.mm.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.y;

final class y$3
  implements MediaPlayer.OnCompletionListener
{
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.release();
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      y.printErrStackTrace("MiroMsg.NotificationUtil", paramMediaPlayer, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.platformtools.y.3
 * JD-Core Version:    0.7.0.1
 */