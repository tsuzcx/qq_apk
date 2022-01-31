package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.sdk.platformtools.y;

final class g$1
  implements MediaPlayer.OnCompletionListener
{
  g$1(g paramg, g.b paramb) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    y.i("MicroMsg.F2fRcvVoiceListener", "start play money");
    if ((g.a(this.iHa) != null) && (g.b(this.iHa)) && (g.c(this.iHa) == null)) {
      g.a(this.iHa, g.a.a(this.iGZ.fileName, new g.1.1(this), new g.1.2(this)));
    }
    for (;;)
    {
      g.h(this.iHa);
      return;
      y.i("MicroMsg.F2fRcvVoiceListener", "has played");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.b.g.1
 * JD-Core Version:    0.7.0.1
 */