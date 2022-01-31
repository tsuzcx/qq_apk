package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

final class CollectMainUI$14
  implements View.OnClickListener
{
  CollectMainUI$14(CollectMainUI paramCollectMainUI, List paramList) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142006);
    paramView = new d(this.kSz.getContext(), 1, false);
    paramView.sao = new CollectMainUI.14.1(this);
    paramView.sap = new CollectMainUI.14.2(this);
    paramView.crd();
    AppMethodBeat.o(142006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectMainUI.14
 * JD-Core Version:    0.7.0.1
 */