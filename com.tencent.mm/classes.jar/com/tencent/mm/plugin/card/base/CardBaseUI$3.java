package com.tencent.mm.plugin.card.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.y;

final class CardBaseUI$3
  implements AdapterView.OnItemLongClickListener
{
  CardBaseUI$3(CardBaseUI paramCardBaseUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      y.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
    }
    int i;
    do
    {
      return true;
      i = paramInt;
      if (paramInt > 0) {
        i = paramInt - 1;
      }
    } while (i >= this.ijO.ijG.getCount());
    paramAdapterView = this.ijO.ijM.oK(i);
    this.ijO.a(paramAdapterView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.3
 * JD-Core Version:    0.7.0.1
 */