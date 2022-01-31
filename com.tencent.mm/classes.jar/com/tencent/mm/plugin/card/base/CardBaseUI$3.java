package com.tencent.mm.plugin.card.base;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CardBaseUI$3
  implements AdapterView.OnItemLongClickListener
{
  CardBaseUI$3(CardBaseUI paramCardBaseUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(87619);
    if (paramInt == 0)
    {
      ab.i("MicroMsg.CardBaseUI", "onItemLongClick pos is 0");
      AppMethodBeat.o(87619);
      return true;
    }
    int i = paramInt;
    if (paramInt > 0) {
      i = paramInt - 1;
    }
    if (i >= this.kkO.kkG.getCount())
    {
      AppMethodBeat.o(87619);
      return true;
    }
    paramAdapterView = this.kkO.kkM.sU(i);
    this.kkO.a(paramAdapterView);
    AppMethodBeat.o(87619);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.base.CardBaseUI.3
 * JD-Core Version:    0.7.0.1
 */