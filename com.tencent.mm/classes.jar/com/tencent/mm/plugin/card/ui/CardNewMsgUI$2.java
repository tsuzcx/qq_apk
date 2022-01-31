package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.sdk.platformtools.y;

final class CardNewMsgUI$2
  implements AdapterView.OnItemClickListener
{
  CardNewMsgUI$2(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == CardNewMsgUI.a(this.iwh).getCount())
    {
      paramInt = 1;
      if (am.aAu().aAo() > 0) {
        am.aAu().aAp();
      }
      for (;;)
      {
        CardNewMsgUI.a(this.iwh).a(null, null);
        if (!CardNewMsgUI.b(this.iwh))
        {
          if (CardNewMsgUI.c(this.iwh).getParent() != null)
          {
            y.d("MicroMsg.CardNewMsgUI", "remove footer");
            CardNewMsgUI.d(this.iwh).removeFooterView(CardNewMsgUI.c(this.iwh));
          }
          if ((!CardNewMsgUI.a(this.iwh).aCc()) && (CardNewMsgUI.e(this.iwh).getParent() == null) && (paramInt > 0))
          {
            CardNewMsgUI.d(this.iwh).addFooterView(CardNewMsgUI.e(this.iwh));
            y.i("MicroMsg.CardNewMsgUI", "add mLoadingFooterView");
          }
        }
        CardNewMsgUI.f(this.iwh);
        CardNewMsgUI.c(this.iwh).setVisibility(8);
        return;
        paramInt = CardNewMsgUI.a(this.iwh).aCd();
      }
    }
    CardNewMsgUI.a(this.iwh, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.2
 * JD-Core Version:    0.7.0.1
 */