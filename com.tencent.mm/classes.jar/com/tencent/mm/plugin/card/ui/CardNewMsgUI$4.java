package com.tencent.mm.plugin.card.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.h;

final class CardNewMsgUI$4
  implements AbsListView.OnScrollListener
{
  CardNewMsgUI$4(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(88595);
    if (!CardNewMsgUI.b(this.kxl))
    {
      AppMethodBeat.o(88595);
      return;
    }
    if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
    {
      if (am.bcf().bbZ() > 0) {
        am.bcf().bca();
      }
      for (;;)
      {
        CardNewMsgUI.a(this.kxl).a(null, null);
        AppMethodBeat.o(88595);
        return;
        CardNewMsgUI.a(this.kxl).ben();
      }
    }
    AppMethodBeat.o(88595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.4
 * JD-Core Version:    0.7.0.1
 */