package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class c
{
  AudioManager.OnAudioFocusChangeListener audioFocusChangeListener;
  AudioManager audioManager;
  a kZW;
  
  public c(a parama)
  {
    AppMethodBeat.i(210466);
    this.audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(210465);
        ac.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "focus change %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          ac.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus lossTransient");
          c.this.kZW.blU();
          AppMethodBeat.o(210465);
          return;
        }
        if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
        {
          ac.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus gain");
          c.this.kZW.blM();
          AppMethodBeat.o(210465);
          return;
        }
        if (paramAnonymousInt == -1)
        {
          ac.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "audio focus loss, passive pause");
          c.this.kZW.blQ();
          if (c.this.audioManager != null) {
            c.this.audioManager.abandonAudioFocus(c.this.audioFocusChangeListener);
          }
        }
        AppMethodBeat.o(210465);
      }
    };
    this.audioManager = ((AudioManager)ai.getContext().getSystemService("audio"));
    this.kZW = parama;
    AppMethodBeat.o(210466);
  }
  
  public final void bjF()
  {
    AppMethodBeat.i(210468);
    ac.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "abandonFocus");
    if (this.audioManager == null)
    {
      AppMethodBeat.o(210468);
      return;
    }
    this.audioManager.abandonAudioFocus(this.audioFocusChangeListener);
    AppMethodBeat.o(210468);
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(210467);
    if (this.audioManager == null)
    {
      AppMethodBeat.o(210467);
      return false;
    }
    int i = this.audioManager.requestAudioFocus(this.audioFocusChangeListener, 3, 2);
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AppBrand.BackgroundPlayAudioFocusHelper", "request audio focus %b", new Object[] { Boolean.valueOf(bool) });
      if (i != 1) {
        break;
      }
      AppMethodBeat.o(210467);
      return true;
    }
    AppMethodBeat.o(210467);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.c
 * JD-Core Version:    0.7.0.1
 */