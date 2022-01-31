package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.sdk.platformtools.ab;

final class CardNewMsgUI$2
  implements AdapterView.OnItemClickListener
{
  CardNewMsgUI$2(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(88593);
    if (paramInt == CardNewMsgUI.a(this.kxl).getCount())
    {
      paramInt = 1;
      if (am.bcf().bbZ() > 0) {
        am.bcf().bca();
      }
      for (;;)
      {
        CardNewMsgUI.a(this.kxl).a(null, null);
        if (!CardNewMsgUI.b(this.kxl))
        {
          if (CardNewMsgUI.c(this.kxl).getParent() != null)
          {
            ab.d("MicroMsg.CardNewMsgUI", "remove footer");
            CardNewMsgUI.d(this.kxl).removeFooterView(CardNewMsgUI.c(this.kxl));
          }
          if ((!CardNewMsgUI.a(this.kxl).bem()) && (CardNewMsgUI.e(this.kxl).getParent() == null) && (paramInt > 0))
          {
            CardNewMsgUI.d(this.kxl).addFooterView(CardNewMsgUI.e(this.kxl));
            ab.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
          }
        }
        CardNewMsgUI.f(this.kxl);
        CardNewMsgUI.c(this.kxl).setVisibility(8);
        AppMethodBeat.o(88593);
        return;
        paramInt = CardNewMsgUI.a(this.kxl).ben();
      }
    }
    CardNewMsgUI.a(this.kxl, paramInt);
    AppMethodBeat.o(88593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.2
 * JD-Core Version:    0.7.0.1
 */