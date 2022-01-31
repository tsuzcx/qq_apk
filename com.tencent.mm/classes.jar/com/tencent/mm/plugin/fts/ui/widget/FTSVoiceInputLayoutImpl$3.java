package com.tencent.mm.plugin.fts.ui.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

final class FTSVoiceInputLayoutImpl$3
  implements View.OnTouchListener
{
  FTSVoiceInputLayoutImpl$3(FTSVoiceInputLayoutImpl paramFTSVoiceInputLayoutImpl) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(62183);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(62183);
      return false;
      if (!at.isConnected(this.ncg.getContext()))
      {
        FTSVoiceInputLayoutImpl.b(this.ncg, true);
        this.ncg.nck.wE(12);
      }
      else
      {
        FTSVoiceInputLayoutImpl.b(this.ncg, false);
        FTSVoiceInputLayoutImpl.a(this.ncg, false);
        FTSVoiceInputLayoutImpl.a(this.ncg, bo.yB());
        ((FTSVoiceInputLayoutImpl.a)this.ncg.nck).bDs();
        ab.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[] { Integer.valueOf(this.ncg.currentState), Long.valueOf(FTSVoiceInputLayoutImpl.c(this.ncg)) });
        paramView = FTSVoiceInputLayoutImpl.b(this.ncg);
        ab.d("MicroMsg.FTSVoiceInputDrawable", "readyPressState %s", new Object[] { Integer.valueOf(paramView.currentState) });
        paramView.currentState = 6;
        paramView.invalidateSelf();
        this.ncg.B(false, false);
        FTSVoiceInputLayoutImpl.d(this.ncg);
        continue;
        if (!FTSVoiceInputLayoutImpl.e(this.ncg)) {
          break;
        }
        FTSVoiceInputLayoutImpl.b(this.ncg, false);
      }
    }
    ab.d("MicroMsg.FTSVoiceInputLayoutImpl", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[] { Integer.valueOf(this.ncg.currentState), Boolean.valueOf(FTSVoiceInputLayoutImpl.f(this.ncg)) });
    if (FTSVoiceInputLayoutImpl.f(this.ncg))
    {
      this.ncg.B(true, false);
      FTSVoiceInputLayoutImpl.a(this.ncg, false);
      FTSVoiceInputLayoutImpl.a(this.ncg, 0L);
    }
    for (;;)
    {
      FTSVoiceInputLayoutImpl.g(this.ncg);
      ((FTSVoiceInputLayoutImpl.a)this.ncg.nck).bDr();
      break;
      this.ncg.B(false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSVoiceInputLayoutImpl.3
 * JD-Core Version:    0.7.0.1
 */