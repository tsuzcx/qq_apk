package com.tencent.mm.compatible.util;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements AudioManager.OnAudioFocusChangeListener
{
  c$1(c paramc) {}
  
  public final void onAudioFocusChange(int paramInt)
  {
    if (this.dzz.dzx != null)
    {
      y.d("MicroMsg.AudioFocusHelper", "jacks change: %d", new Object[] { Integer.valueOf(paramInt) });
      this.dzz.dzx.ex(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.util.c.1
 * JD-Core Version:    0.7.0.1
 */