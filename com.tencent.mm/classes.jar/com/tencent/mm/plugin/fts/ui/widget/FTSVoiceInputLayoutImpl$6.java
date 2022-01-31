package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.sdk.platformtools.y;

final class FTSVoiceInputLayoutImpl$6
  implements Runnable
{
  FTSVoiceInputLayoutImpl$6(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final void run()
  {
    c localc = FTSVoiceInputLayoutImpl.a(this.kFs);
    y.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[] { Integer.valueOf(localc.kFU) });
    localc.kFU = 4;
    localc.hsF.cancel();
    localc.kFN = 0.0F;
    localc.hsF.setInterpolator(new AccelerateDecelerateInterpolator());
    localc.hsF.setDuration(1000L);
    localc.hsF.setRepeatCount(-1);
    localc.hsF.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.6
 * JD-Core Version:    0.7.0.1
 */