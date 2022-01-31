package com.tencent.mm.plugin.card.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.y;

final class CardBaseUI$2
  implements AdapterView.OnItemClickListener
{
  CardBaseUI$2(CardBaseUI paramCardBaseUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0)
    {
      y.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
      this.ijO.ayU();
    }
    int i;
    do
    {
      return;
      i = paramInt;
      if (paramInt > 0) {
        i = paramInt - 1;
      }
    } while (i >= this.ijO.ijG.getCount());
    paramAdapterView = this.ijO.ijM.oK(i);
    this.ijO.b(paramAdapterView, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.2
 * JD-Core Version:    0.7.0.1
 */