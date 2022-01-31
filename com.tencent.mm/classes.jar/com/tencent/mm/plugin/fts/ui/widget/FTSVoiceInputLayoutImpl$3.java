package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

final class FTSVoiceInputLayoutImpl$3
  implements View.OnClickListener
{
  FTSVoiceInputLayoutImpl$3(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final void onClick(View paramView)
  {
    if (FTSVoiceInputLayoutImpl.f(this.kFs) != null) {
      FTSVoiceInputLayoutImpl.f(this.kFs).onClose();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.3
 * JD-Core Version:    0.7.0.1
 */