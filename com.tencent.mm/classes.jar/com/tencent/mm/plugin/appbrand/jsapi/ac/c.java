package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  AudioManager audioManager;
  a lwX;
  
  public c(a parama)
  {
    AppMethodBeat.i(186892);
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(186891);
        ad.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          ad.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus lossTransient");
          c.this.lwX.bpC();
          AppMethodBeat.o(186891);
          return;
        }
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
        {
          ad.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus gain");
          c.this.lwX.bpB();
          AppMethodBeat.o(186891);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          ad.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus loss, passive pause");
          c.this.lwX.bpD();
          if (c.this.audioManager != null) {
            c.this.audioManager.abandonAudioFocus(c.this.audioFocusChangeListener);
          }
        }
        AppMethodBeat.o(186891);
      }
    };
    this.audioManager = ((AudioManager)aj.getContext().getSystemService("audio"));
    this.lwX = parama;
    AppMethodBeat.o(186892);
  }
  
  public final void bpH()
  {
    AppMethodBeat.i(186894);
    ad.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "abandonFocus");
    if (this.audioManager == null)
    {
      AppMethodBeat.o(186894);
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    AppMethodBeat.o(186894);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(186893);
    if (this.audioManager == null)
    {
      AppMethodBeat.o(186893);
      return false;
    }
    int i = this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(186893);
      return true;
    }
    AppMethodBeat.o(186893);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c
 * JD-Core Version:    0.7.0.1
 */