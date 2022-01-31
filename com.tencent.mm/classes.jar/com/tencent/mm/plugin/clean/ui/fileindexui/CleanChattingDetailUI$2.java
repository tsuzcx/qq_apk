package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.HashSet;

final class CleanChattingDetailUI$2
  implements View.OnClickListener
{
  CleanChattingDetailUI$2(CleanChattingDetailUI paramCleanChattingDetailUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = CleanChattingDetailUI.a(this.iCT);
    if (paramView.hIR.size() == paramView.hgv.size()) {
      paramView.hIR.clear();
    }
    for (;;)
    {
      paramView.aEf();
      CleanChattingDetailUI.a(this.iCT).notifyDataSetChanged();
      return;
      int i = 0;
      while (i < paramView.hgv.size())
      {
        paramView.hIR.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingDetailUI.2
 * JD-Core Version:    0.7.0.1
 */