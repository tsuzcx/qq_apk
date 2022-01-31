package com.tencent.mm.plugin.fts.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.widget.d;

final class FTSBaseVoiceSearchUI$1
  implements View.OnTouchListener
{
  FTSBaseVoiceSearchUI$1(FTSBaseVoiceSearchUI paramFTSBaseVoiceSearchUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(61782);
    this.mWU.mWR.clearFocus();
    this.mWU.hideVKB();
    AppMethodBeat.o(61782);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBaseVoiceSearchUI.1
 * JD-Core Version:    0.7.0.1
 */