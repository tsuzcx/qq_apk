package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fts.ui.n.d;
import java.util.List;

final class FTSEditTextView$6
  implements View.OnClickListener
{
  FTSEditTextView$6(FTSEditTextView paramFTSEditTextView) {}
  
  public final void onClick(View paramView)
  {
    int i = -1;
    if (paramView.getId() == n.d.tag_1) {
      i = 0;
    }
    for (;;)
    {
      if ((FTSEditTextView.h(this.kEA) != null) && (i >= 0))
      {
        paramView = FTSEditTextView.h(this.kEA);
        FTSEditTextView.b(this.kEA).get(i);
        paramView.aWb();
      }
      return;
      if (paramView.getId() == n.d.tag_2) {
        i = 1;
      } else if (paramView.getId() == n.d.tag_3) {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSEditTextView.6
 * JD-Core Version:    0.7.0.1
 */