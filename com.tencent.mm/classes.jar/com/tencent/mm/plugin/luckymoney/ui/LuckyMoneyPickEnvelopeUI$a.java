package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class LuckyMoneyPickEnvelopeUI$a
  extends RecyclerView.a<LuckyMoneyPickEnvelopeUI.c>
{
  private LuckyMoneyPickEnvelopeUI$a(LuckyMoneyPickEnvelopeUI paramLuckyMoneyPickEnvelopeUI) {}
  
  public final int getItemCount()
  {
    AppMethodBeat.i(42918);
    int i = LuckyMoneyPickEnvelopeUI.b(this.ovW).size();
    AppMethodBeat.o(42918);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    AppMethodBeat.i(42919);
    long l = ((LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(this.ovW).get(paramInt)).hashCode();
    AppMethodBeat.o(42919);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a
 * JD-Core Version:    0.7.0.1
 */