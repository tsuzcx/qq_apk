package com.tencent.mm.plugin.appbrand.jsapi.ad;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class c
{
  AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  AudioManager audioManager;
  a lBv;
  
  public c(a parama)
  {
    AppMethodBeat.i(220584);
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(220583);
        ae.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          ae.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus lossTransient");
          c.this.lBv.bqm();
          AppMethodBeat.o(220583);
          return;
        }
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
        {
          ae.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus gain");
          c.this.lBv.bql();
          AppMethodBeat.o(220583);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          ae.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus loss, passive pause");
          c.this.lBv.bqn();
          if (c.this.audioManager != null) {
            c.this.audioManager.abandonAudioFocus(c.this.audioFocusChangeListener);
          }
        }
        AppMethodBeat.o(220583);
      }
    };
    this.audioManager = ((AudioManager)ak.getContext().getSystemService("audio"));
    this.lBv = parama;
    AppMethodBeat.o(220584);
  }
  
  public final void bqr()
  {
    AppMethodBeat.i(220586);
    ae.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "abandonFocus");
    if (this.audioManager == null)
    {
      AppMethodBeat.o(220586);
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    AppMethodBeat.o(220586);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(220585);
    if (this.audioManager == null)
    {
      AppMethodBeat.o(220585);
      return false;
    }
    int i = this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(220585);
      return true;
    }
    AppMethodBeat.o(220585);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.c
 * JD-Core Version:    0.7.0.1
 */