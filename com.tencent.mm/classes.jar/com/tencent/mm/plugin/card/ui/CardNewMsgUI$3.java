package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardNewMsgUI$3
  implements AdapterView.OnItemLongClickListener
{
  CardNewMsgUI$3(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(88594);
    CardNewMsgUI.b(this.kxl, paramInt);
    AppMethodBeat.o(88594);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.3
 * JD-Core Version:    0.7.0.1
 */