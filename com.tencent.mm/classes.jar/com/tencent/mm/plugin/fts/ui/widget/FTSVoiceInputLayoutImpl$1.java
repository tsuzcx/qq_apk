package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class FTSVoiceInputLayoutImpl$1
  implements View.OnLongClickListener
{
  FTSVoiceInputLayoutImpl$1(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final boolean onLongClick(View paramView)
  {
    y.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[] { Integer.valueOf(this.kFs.kFU) });
    FTSVoiceInputLayoutImpl.a(this.kFs, true);
    paramView = FTSVoiceInputLayoutImpl.a(this.kFs);
    y.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[] { Integer.valueOf(paramView.kFU) });
    paramView.kFU = 7;
    paramView.hsF.cancel();
    paramView.kFN = 0.0F;
    paramView.invalidateSelf();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.1
 * JD-Core Version:    0.7.0.1
 */