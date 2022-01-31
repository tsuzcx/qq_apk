package com.tencent.mm.plugin.choosemsgfile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.d.a;
import com.tencent.mm.ui.widget.b.e.a;

final class ChooseMsgFileUI$10
  implements View.OnClickListener
{
  ChooseMsgFileUI$10(ChooseMsgFileUI paramChooseMsgFileUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(54454);
    if (ChooseMsgFileUI.a(this.kGm).bgD())
    {
      paramView = new e.a(this.kGm);
      paramView.avu(this.kGm.getString(2131298355)).rI(true);
      paramView.c(new ChooseMsgFileUI.10.1(this)).show();
      AppMethodBeat.o(54454);
      return;
    }
    ChooseMsgFileUI.d(this.kGm);
    AppMethodBeat.o(54454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileUI.10
 * JD-Core Version:    0.7.0.1
 */