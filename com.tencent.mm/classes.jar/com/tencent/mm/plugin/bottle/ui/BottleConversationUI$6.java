package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;

final class BottleConversationUI$6
  implements AdapterView.OnItemLongClickListener
{
  BottleConversationUI$6(BottleConversationUI paramBottleConversationUI, l paraml) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(18561);
    if (paramInt < BottleConversationUI.c(this.jSo).getHeaderViewsCount())
    {
      ab.w("MicroMsg.Bottle.BottleConversationUI", "on header view long click, ignore");
      AppMethodBeat.o(18561);
      return true;
    }
    this.jSq.a(paramView, paramInt, paramLong, this.jSo, BottleConversationUI.d(this.jSo));
    AppMethodBeat.o(18561);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.6
 * JD-Core Version:    0.7.0.1
 */