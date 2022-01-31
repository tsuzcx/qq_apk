package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(8)
public final class c
  implements b.b
{
  private Context context;
  private AudioManager dzw;
  b.a dzx;
  private AudioManager.OnAudioFocusChangeListener dzy = new c.1(this);
  
  public c(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void a(b.a parama)
  {
    this.dzx = parama;
  }
  
  public final boolean requestFocus()
  {
    if ((this.dzw == null) && (this.context != null)) {
      this.dzw = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.dzw != null) {
      if (1 == this.dzw.requestAudioFocus(this.dzy, 3, 2)) {
        bool = true;
      }
    }
    for (;;)
    {
      y.l("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.dzy.hashCode()) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final boolean zE()
  {
    if ((this.dzw == null) && (this.context != null)) {
      this.dzw = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.dzw != null) {
      if (1 == this.dzw.abandonAudioFocus(this.dzy)) {
        bool = true;
      }
    }
    for (;;)
    {
      y.l("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.dzy.hashCode()) });
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.util.c
 * JD-Core Version:    0.7.0.1
 */