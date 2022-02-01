package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

@TargetApi(8)
public final class c
  implements b.b
{
  private Context context;
  b.a jvy;
  private AudioManager.OnAudioFocusChangeListener jvz;
  private AudioManager mAudioManager;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(155870);
    this.jvz = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(155869);
        if (c.this.jvy != null)
        {
          Log.d("MicroMsg.AudioFocusHelper", "jacks change: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          c.this.jvy.kp(paramAnonymousInt);
        }
        AppMethodBeat.o(155869);
      }
    };
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = MMApplicationContext.getContext();
    }
    this.context = localContext;
    AppMethodBeat.o(155870);
  }
  
  public final void a(b.a parama)
  {
    this.jvy = parama;
  }
  
  public final boolean avy()
  {
    AppMethodBeat.i(155871);
    if ((this.mAudioManager == null) && (this.context != null)) {
      this.mAudioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.mAudioManager != null) {
      if (1 == this.mAudioManager.requestAudioFocus(this.jvz, 3, 2)) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jvz.hashCode()) });
      AppMethodBeat.o(155871);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final boolean avz()
  {
    AppMethodBeat.i(155872);
    if ((this.mAudioManager == null) && (this.context != null)) {
      this.mAudioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.mAudioManager != null) {
      if (1 == this.mAudioManager.abandonAudioFocus(this.jvz)) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.jvz.hashCode()) });
      AppMethodBeat.o(155872);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final void b(b.a parama)
  {
    if (this.jvy == parama) {
      this.jvy = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.util.c
 * JD-Core Version:    0.7.0.1
 */