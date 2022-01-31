package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import com.tencent.mm.sdk.platformtools.y;

final class FTSVoiceInputLayoutImpl$4
  implements Runnable
{
  FTSVoiceInputLayoutImpl$4(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final void run()
  {
    c localc = FTSVoiceInputLayoutImpl.a(this.kFs);
    y.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[] { Integer.valueOf(localc.kFU) });
    localc.kFU = 5;
    localc.hsF.cancel();
    localc.kFN = 0.0F;
    localc.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.4
 * JD-Core Version:    0.7.0.1
 */