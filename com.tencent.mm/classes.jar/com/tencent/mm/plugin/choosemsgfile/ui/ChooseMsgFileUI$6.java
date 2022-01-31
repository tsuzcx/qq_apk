package com.tencent.mm.plugin.choosemsgfile.ui;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.d.a;

final class ChooseMsgFileUI$6
  implements View.OnClickListener
{
  ChooseMsgFileUI$6(ChooseMsgFileUI paramChooseMsgFileUI) {}
  
  @SuppressLint({"ResourceType"})
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(54449);
    paramView = ChooseMsgFileUI.a(this.kGm);
    if (!paramView.kFQ) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.kFQ = bool;
      if (!ChooseMsgFileUI.a(this.kGm).kFQ) {
        break;
      }
      ChooseMsgFileUI.b(this.kGm).setImageResource(2131231906);
      AppMethodBeat.o(54449);
      return;
    }
    ChooseMsgFileUI.b(this.kGm).setImageResource(2131231905);
    AppMethodBeat.o(54449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.6
 * JD-Core Version:    0.7.0.1
 */