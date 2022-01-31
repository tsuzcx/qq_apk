package com.tencent.mm.plugin.card.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CardBaseUI$2
  implements AdapterView.OnItemClickListener
{
  CardBaseUI$2(CardBaseUI paramCardBaseUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(87618);
    if (paramInt == 0)
    {
      ab.i("MicroMsg.CardBaseUI", "onItemClick pos is 0, onListHeaderItemClick()");
      AppMethodBeat.o(87618);
      return;
    }
    int i = paramInt;
    if (paramInt > 0) {
      i = paramInt - 1;
    }
    if (i >= this.kkO.kkG.getCount())
    {
      AppMethodBeat.o(87618);
      return;
    }
    paramAdapterView = this.kkO.kkM.sU(i);
    this.kkO.b(paramAdapterView, i);
    AppMethodBeat.o(87618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.2
 * JD-Core Version:    0.7.0.1
 */