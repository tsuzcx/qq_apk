package com.tencent.mm.plugin.appbrand.widget.music;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.SeekBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MusicSeekBar$2
  implements ValueAnimator.AnimatorUpdateListener
{
  MusicSeekBar$2(MusicSeekBar paramMusicSeekBar) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(141883);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.jrS.jrP;
    paramValueAnimator.jrV = f;
    paramValueAnimator.invalidateSelf();
    MusicSeekBar.b(this.jrS).setThumb(this.jrS.jrP);
    AppMethodBeat.o(141883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar.2
 * JD-Core Version:    0.7.0.1
 */