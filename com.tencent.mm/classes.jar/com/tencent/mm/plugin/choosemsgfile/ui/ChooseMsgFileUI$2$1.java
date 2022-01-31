package com.tencent.mm.plugin.choosemsgfile.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ChooseMsgFileUI$2$1
  implements Runnable
{
  ChooseMsgFileUI$2$1(ChooseMsgFileUI.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(54441);
    Animation localAnimation = AnimationUtils.loadAnimation(this.kGo.kGm.getContext(), 2131034182);
    ChooseMsgFileUI.h(this.kGo.kGm).startAnimation(localAnimation);
    ChooseMsgFileUI.h(this.kGo.kGm).setVisibility(8);
    AppMethodBeat.o(54441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.2.1
 * JD-Core Version:    0.7.0.1
 */