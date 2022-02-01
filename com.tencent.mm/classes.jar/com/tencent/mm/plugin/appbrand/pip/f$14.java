package com.tencent.mm.plugin.appbrand.pip;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.n.i;
import com.tencent.mm.sdk.platformtools.ac;

final class f$14
  implements AudioManager.OnAudioFocusChangeListener
{
  f$14(f paramf) {}
  
  public final void onAudioFocusChange(int paramInt)
  {
    AppMethodBeat.i(210524);
    ac.d(this.lOd.cgL, "onAudioFocusChange, focusChange: ".concat(String.valueOf(paramInt)));
    if (this.lOd.lOc)
    {
      ac.i(this.lOd.cgL, "onAudioFocusChange, runtime paused");
      AppMethodBeat.o(210524);
      return;
    }
    if (this.lOd.lNQ == null)
    {
      ac.d(this.lOd.cgL, "onAudioFocusChange, null == mPipVideoSession");
      AppMethodBeat.o(210524);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(210524);
      return;
      this.lOd.lNQ.lMA.start();
      AppMethodBeat.o(210524);
      return;
      ac.d(this.lOd.cgL, "onAudioFocusChange, abandonAudioFocus");
      this.lOd.mAudioManager.abandonAudioFocus(this.lOd.msm);
      this.lOd.msl = false;
      this.lOd.lNQ.lMA.pause();
      this.lOd.lVR = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f.14
 * JD-Core Version:    0.7.0.1
 */