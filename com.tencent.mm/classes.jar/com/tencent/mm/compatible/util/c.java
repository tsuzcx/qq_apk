package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

@TargetApi(8)
public final class c
  implements b.b
{
  private Context context;
  b.a esl;
  private AudioManager.OnAudioFocusChangeListener esm;
  private AudioManager mAudioManager;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(93065);
    this.esm = new c.1(this);
    this.context = paramContext;
    AppMethodBeat.o(93065);
  }
  
  public final boolean Mh()
  {
    AppMethodBeat.i(93067);
    if ((this.mAudioManager == null) && (this.context != null)) {
      this.mAudioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.mAudioManager != null) {
      if (1 == this.mAudioManager.abandonAudioFocus(this.esm)) {
        bool = true;
      }
    }
    for (;;)
    {
      ab.b("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.esm.hashCode()) });
      AppMethodBeat.o(93067);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void a(b.a parama)
  {
    this.esl = parama;
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(93066);
    if ((this.mAudioManager == null) && (this.context != null)) {
      this.mAudioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.mAudioManager != null) {
      if (1 == this.mAudioManager.requestAudioFocus(this.esm, 3, 2)) {
        bool = true;
      }
    }
    for (;;)
    {
      ab.b("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.esm.hashCode()) });
      AppMethodBeat.o(93066);
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