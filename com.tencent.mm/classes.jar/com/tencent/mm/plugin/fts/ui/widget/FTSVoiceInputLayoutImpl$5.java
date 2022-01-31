package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.sdk.platformtools.y;

final class FTSVoiceInputLayoutImpl$5
  implements Runnable
{
  FTSVoiceInputLayoutImpl$5(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final void run()
  {
    c localc = FTSVoiceInputLayoutImpl.a(this.kFs);
    boolean bool = this.kFt;
    y.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[] { Integer.valueOf(0), Boolean.valueOf(bool) });
    if (!bool) {
      localc.kFU = 3;
    }
    localc.kFQ = true;
    localc.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.5
 * JD-Core Version:    0.7.0.1
 */