package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;

final class BottleConversationUI$7
  implements AdapterView.OnItemLongClickListener
{
  BottleConversationUI$7(BottleConversationUI paramBottleConversationUI, j paramj) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < BottleConversationUI.c(this.hZr).getHeaderViewsCount())
    {
      y.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
      return true;
    }
    this.hZt.a(paramView, paramInt, paramLong, this.hZr, BottleConversationUI.d(this.hZr));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.7
 * JD-Core Version:    0.7.0.1
 */