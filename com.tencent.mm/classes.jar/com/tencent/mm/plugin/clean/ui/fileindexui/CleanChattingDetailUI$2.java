package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;

final class CleanChattingDetailUI$2
  implements View.OnClickListener
{
  CleanChattingDetailUI$2(CleanChattingDetailUI paramCleanChattingDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18767);
    paramView = CleanChattingDetailUI.a(this.kIa);
    if (paramView.jCr.size() == paramView.iRT.size()) {
      paramView.jCr.clear();
    }
    for (;;)
    {
      paramView.bhg();
      CleanChattingDetailUI.a(this.kIa).notifyDataSetChanged();
      AppMethodBeat.o(18767);
      return;
      int i = 0;
      while (i < paramView.iRT.size())
      {
        paramView.jCr.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.2
 * JD-Core Version:    0.7.0.1
 */