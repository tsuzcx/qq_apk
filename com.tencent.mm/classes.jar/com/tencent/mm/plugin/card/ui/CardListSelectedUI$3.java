package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

final class CardListSelectedUI$3
  implements AdapterView.OnItemClickListener
{
  CardListSelectedUI$3(CardListSelectedUI paramCardListSelectedUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramView.getAlpha() != 1.0F)
    {
      y.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
      return;
    }
    boolean bool;
    if (this.ivL.ivx)
    {
      bool = ((Boolean)this.ivL.ivy.get(Integer.valueOf(paramInt))).booleanValue();
      paramAdapterView = this.ivL.ivy;
      if (!bool)
      {
        bool = true;
        paramAdapterView.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
      }
    }
    for (;;)
    {
      CardListSelectedUI.c(this.ivL).notifyDataSetChanged();
      CardListSelectedUI.d(this.ivL);
      return;
      bool = false;
      break;
      int i = 0;
      while (i < this.ivL.dBw.size())
      {
        this.ivL.ivy.put(Integer.valueOf(i), Boolean.valueOf(false));
        i += 1;
      }
      this.ivL.ivy.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
      CardListSelectedUI.a(this.ivL, (a)this.ivL.dBw.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.3
 * JD-Core Version:    0.7.0.1
 */