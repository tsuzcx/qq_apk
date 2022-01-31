package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.b.d;

final class CollectMainUI$20
  implements View.OnLongClickListener
{
  CollectMainUI$20(CollectMainUI paramCollectMainUI) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(41278);
    if (CollectMainUI.b(this.kSz) == 0)
    {
      paramView = new l(this.kSz.getContext());
      paramView.sao = new CollectMainUI.20.1(this);
      paramView.sap = new CollectMainUI.20.2(this);
      paramView.cwt();
    }
    for (;;)
    {
      AppMethodBeat.o(41278);
      return true;
      paramView = new d(this.kSz.getContext(), 1, false);
      paramView.sao = new CollectMainUI.20.3(this);
      paramView.sap = new CollectMainUI.20.4(this);
      paramView.crd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.20
 * JD-Core Version:    0.7.0.1
 */