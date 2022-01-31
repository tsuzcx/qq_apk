package com.tencent.mm.plugin.choosemsgfile.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.d.a;
import com.tencent.mm.ui.widget.b.e.a;

final class ChooseMsgFileListUI$3
  implements View.OnClickListener
{
  ChooseMsgFileListUI$3(ChooseMsgFileListUI paramChooseMsgFileListUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(54414);
    if (ChooseMsgFileListUI.a(this.kFZ).bgD())
    {
      paramView = new e.a(this.kFZ);
      paramView.avu(this.kFZ.getString(2131298355)).rI(true);
      paramView.c(new ChooseMsgFileListUI.3.1(this)).show();
      AppMethodBeat.o(54414);
      return;
    }
    ChooseMsgFileListUI.b(this.kFZ);
    AppMethodBeat.o(54414);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.ui.ChooseMsgFileListUI.3
 * JD-Core Version:    0.7.0.1
 */