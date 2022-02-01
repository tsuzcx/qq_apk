package com.tencent.mm.plugin.appbrand.jsapi.ag;

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
  a mIT;
  
  public c(a parama)
  {
    AppMethodBeat.i(215798);
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(215797);
        Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus lossTransient");
          c.this.mIT.bLU();
          AppMethodBeat.o(215797);
          return;
        }
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
        {
          Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus gain");
          c.this.mIT.bLT();
          AppMethodBeat.o(215797);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus loss, passive pause");
          c.this.mIT.bLV();
          if (c.this.audioManager != null) {
            c.this.audioManager.abandonAudioFocus(c.this.audioFocusChangeListener);
          }
        }
        AppMethodBeat.o(215797);
      }
    };
    this.audioManager = ((AudioManager)MMApplicationContext.getContext().getSystemService("audio"));
    this.mIT = parama;
    AppMethodBeat.o(215798);
  }
  
  public final void bLZ()
  {
    AppMethodBeat.i(215800);
    Log.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "abandonFocus");
    if (this.audioManager == null)
    {
      AppMethodBeat.o(215800);
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    AppMethodBeat.o(215800);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(215799);
    if (this.audioManager == null)
    {
      AppMethodBeat.o(215799);
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
      AppMethodBeat.o(215799);
      return true;
    }
    AppMethodBeat.o(215799);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c
 * JD-Core Version:    0.7.0.1
 */