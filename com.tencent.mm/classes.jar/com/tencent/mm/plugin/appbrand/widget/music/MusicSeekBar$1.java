package com.tencent.mm.plugin.appbrand.widget.music;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MusicSeekBar$1
  implements SeekBar.OnSeekBarChangeListener
{
  MusicSeekBar$1(MusicSeekBar paramMusicSeekBar) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.jrS.jrO = true;
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    AppMethodBeat.i(141882);
    this.jrS.jrO = false;
    if (MusicSeekBar.a(this.jrS) != null) {
      MusicSeekBar.a(this.jrS).qH(paramSeekBar.getProgress());
    }
    AppMethodBeat.o(141882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.1
 * JD-Core Version:    0.7.0.1
 */