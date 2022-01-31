package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class FTSEditTextView$6
  implements View.OnClickListener
{
  FTSEditTextView$6(FTSEditTextView paramFTSEditTextView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(62110);
    int i = -1;
    if (paramView.getId() == 2131824346) {
      i = 0;
    }
    for (;;)
    {
      if ((FTSEditTextView.h(this.naY) != null) && (i >= 0))
      {
        paramView = FTSEditTextView.h(this.naY);
        FTSEditTextView.b(this.naY).get(i);
        paramView.bCE();
      }
      AppMethodBeat.o(62110);
      return;
      if (paramView.getId() == 2131824347) {
        i = 1;
      } else if (paramView.getId() == 2131824348) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.6
 * JD-Core Version:    0.7.0.1
 */