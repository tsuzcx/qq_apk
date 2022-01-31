package com.tencent.mm.plugin.fts.ui.widget;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class FTSVoiceInputLayoutImpl$2
  implements View.OnTouchListener
{
  FTSVoiceInputLayoutImpl$2(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      FTSVoiceInputLayoutImpl.a(this.kFs, false);
      FTSVoiceInputLayoutImpl.a(this.kFs, bk.UZ());
      y.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(this.kFs.kFU), Long.valueOf(FTSVoiceInputLayoutImpl.b(this.kFs)) });
      paramView = FTSVoiceInputLayoutImpl.a(this.kFs);
      y.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramView.kFU) });
      paramView.kFU = 6;
      paramView.hsF.cancel();
      paramView.kFN = 0.0F;
      paramView.invalidateSelf();
      this.kFs.y(false, false);
      FTSVoiceInputLayoutImpl.c(this.kFs);
      return false;
    }
    y.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(this.kFs.kFU), Boolean.valueOf(FTSVoiceInputLayoutImpl.d(this.kFs)) });
    if (FTSVoiceInputLayoutImpl.d(this.kFs))
    {
      this.kFs.y(true, false);
      FTSVoiceInputLayoutImpl.a(this.kFs, false);
      FTSVoiceInputLayoutImpl.a(this.kFs, 0L);
    }
    for (;;)
    {
      FTSVoiceInputLayoutImpl.e(this.kFs);
      return false;
      this.kFs.y(false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.2
 * JD-Core Version:    0.7.0.1
 */