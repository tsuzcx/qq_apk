package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.HashSet;

final class CleanChattingUI$4
  implements View.OnClickListener
{
  CleanChattingUI$4(CleanChattingUI paramCleanChattingUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = CleanChattingUI.a(this.iDb);
    if (paramView.hIR.size() == paramView.getCount()) {
      paramView.hIR.clear();
    }
    for (;;)
    {
      paramView.notifyDataSetChanged();
      paramView.iCy.a(paramView.hIR);
      return;
      int i = 0;
      while (i < paramView.getCount())
      {
        paramView.hIR.add(Integer.valueOf(i));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanChattingUI.4
 * JD-Core Version:    0.7.0.1
 */