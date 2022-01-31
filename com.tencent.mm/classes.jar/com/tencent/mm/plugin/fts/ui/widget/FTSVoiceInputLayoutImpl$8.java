package com.tencent.mm.plugin.fts.ui.widget;

import com.tencent.mm.sdk.platformtools.y;

final class FTSVoiceInputLayoutImpl$8
  implements Runnable
{
  FTSVoiceInputLayoutImpl$8(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl, int paramInt) {}
  
  public final void run()
  {
    boolean bool = true;
    c localc = FTSVoiceInputLayoutImpl.a(this.kFs);
    int i = this.kFu;
    y.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[] { Integer.valueOf(i) });
    if (i < 28) {}
    for (;;)
    {
      localc.kFQ = bool;
      localc.invalidateSelf();
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.8
 * JD-Core Version:    0.7.0.1
 */