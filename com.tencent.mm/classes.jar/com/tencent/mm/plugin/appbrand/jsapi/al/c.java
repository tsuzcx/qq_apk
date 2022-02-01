package com.tencent.mm.plugin.appbrand.jsapi.al;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
{
  AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  AudioManager audioManager;
  a sOD;
  
  public c(a parama)
  {
    AppMethodBeat.i(326983);
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(326988);
        Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus lossTransient");
          c.this.sOD.cyB();
          AppMethodBeat.o(326988);
          return;
        }
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
        {
          Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus gain");
          c.this.sOD.cyA();
          AppMethodBeat.o(326988);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus loss, passive pause");
          c.this.sOD.cyC();
          if (c.this.audioManager != null) {
            c.this.audioManager.abandonAudioFocus(c.this.audioFocusChangeListener);
          }
        }
        AppMethodBeat.o(326988);
      }
    };
    this.audioManager = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    this.sOD = parama;
    AppMethodBeat.o(326983);
  }
  
  public final void cyG()
  {
    AppMethodBeat.i(326995);
    Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "abandonFocus");
    if (this.audioManager == null)
    {
      AppMethodBeat.o(326995);
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    AppMethodBeat.o(326995);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(326989);
    if (this.audioManager == null)
    {
      AppMethodBeat.o(326989);
      return false;
    }
    int i = this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(326989);
      return true;
    }
    AppMethodBeat.o(326989);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c
 * JD-Core Version:    0.7.0.1
 */