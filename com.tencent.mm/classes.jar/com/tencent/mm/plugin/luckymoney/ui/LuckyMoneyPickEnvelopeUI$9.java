package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.scaledLayout.a;
import com.tencent.mm.plugin.luckymoney.scaledLayout.c;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyPickEnvelopeUI$9
  extends RecyclerView.m
{
  LuckyMoneyPickEnvelopeUI$9(LuckyMoneyPickEnvelopeUI paramLuckyMoneyPickEnvelopeUI) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42910);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    paramInt1 = LuckyMoneyPickEnvelopeUI.c(this.ovW).iv();
    ab.v("MicroMsg.LuckyMoneyPickEnvelopeUI", "scroll last vispos: %s", new Object[] { Integer.valueOf(paramInt1) });
    if ((!LuckyMoneyPickEnvelopeUI.g(this.ovW)) && (LuckyMoneyPickEnvelopeUI.h(this.ovW) == 1) && (paramInt1 == LuckyMoneyPickEnvelopeUI.i(this.ovW).getItemCount() - 1))
    {
      ab.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "trigger load more: %s", new Object[] { Integer.valueOf(paramInt1) });
      LuckyMoneyPickEnvelopeUI.j(this.ovW);
    }
    AppMethodBeat.o(42910);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(42909);
    super.c(paramRecyclerView, paramInt);
    if (paramInt == 0)
    {
      LuckyMoneyPickEnvelopeUI.d(this.ovW);
      paramRecyclerView = a.h(LuckyMoneyPickEnvelopeUI.c(this.ovW));
      LuckyMoneyPickEnvelopeUI.f(this.ovW);
      paramInt = LuckyMoneyEnvelopeTouchRecyclerView.bq(paramRecyclerView);
      LuckyMoneyPickEnvelopeUI.a(this.ovW, paramInt);
    }
    AppMethodBeat.o(42909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.9
 * JD-Core Version:    0.7.0.1
 */