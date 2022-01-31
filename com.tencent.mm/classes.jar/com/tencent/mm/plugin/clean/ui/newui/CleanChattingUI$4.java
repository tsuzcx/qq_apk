package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

final class CleanChattingUI$4
  implements View.OnClickListener
{
  CleanChattingUI$4(CleanChattingUI paramCleanChattingUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18878);
    paramView = CleanChattingUI.b(this.kJl);
    if (paramView.jCr.size() == paramView.getCount()) {
      paramView.jCr.clear();
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      paramView.kJb.a(paramView.jCr);
      AppMethodBeat.o(18878);
      return;
      int i = 0;
      while (i < paramView.getCount())
      {
        paramView.jCr.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI.4
 * JD-Core Version:    0.7.0.1
 */