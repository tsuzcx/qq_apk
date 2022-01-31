package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.LinkedList;

final class CardListSelectedUI$3
  implements AdapterView.OnItemClickListener
{
  CardListSelectedUI$3(CardListSelectedUI paramCardListSelectedUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 0;
    AppMethodBeat.i(88557);
    if (paramView.getAlpha() != 1.0F)
    {
      ab.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
      AppMethodBeat.o(88557);
      return;
    }
    boolean bool;
    if (this.kwP.kwB)
    {
      bool = ((Boolean)this.kwP.kwC.get(Integer.valueOf(paramInt))).booleanValue();
      paramAdapterView = this.kwP.kwC;
      if (!bool)
      {
        bool = true;
        paramAdapterView.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
      }
    }
    for (;;)
    {
      CardListSelectedUI.c(this.kwP).notifyDataSetChanged();
      CardListSelectedUI.d(this.kwP);
      AppMethodBeat.o(88557);
      return;
      bool = false;
      break;
      while (i < this.kwP.eyN.size())
      {
        this.kwP.kwC.put(Integer.valueOf(i), Boolean.FALSE);
        i += 1;
      }
      this.kwP.kwC.put(Integer.valueOf(paramInt), Boolean.TRUE);
      CardListSelectedUI.a(this.kwP, (a)this.kwP.eyN.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.3
 * JD-Core Version:    0.7.0.1
 */