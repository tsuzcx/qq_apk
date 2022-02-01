package com.tencent.mm.plugin.luckymoney.ui;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;

final class LuckyMoneyHistoryEnvelopeUI$9
  extends GridLayoutManager.b
{
  LuckyMoneyHistoryEnvelopeUI$9(LuckyMoneyHistoryEnvelopeUI paramLuckyMoneyHistoryEnvelopeUI, GridLayoutManager paramGridLayoutManager) {}
  
  public final int cx(int paramInt)
  {
    AppMethodBeat.i(271471);
    if (LuckyMoneyHistoryEnvelopeUI.d(this.EJm).getItemViewType(paramInt) == 2)
    {
      paramInt = this.EJr.ahF;
      AppMethodBeat.o(271471);
      return paramInt;
    }
    AppMethodBeat.o(271471);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.9
 * JD-Core Version:    0.7.0.1
 */