package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class BottleConversationUI$4
  implements MMSlideDelView.g
{
  BottleConversationUI$4(BottleConversationUI paramBottleConversationUI) {}
  
  public final void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18559);
    BottleConversationUI.c(this.jSo).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(18559);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.4
 * JD-Core Version:    0.7.0.1
 */