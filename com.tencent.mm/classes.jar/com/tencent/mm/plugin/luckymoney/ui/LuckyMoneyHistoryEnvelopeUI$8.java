package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;

final class LuckyMoneyHistoryEnvelopeUI$8
  extends RefreshLoadMoreLayout.a
{
  LuckyMoneyHistoryEnvelopeUI$8(LuckyMoneyHistoryEnvelopeUI paramLuckyMoneyHistoryEnvelopeUI) {}
  
  public final void Ie(int paramInt)
  {
    AppMethodBeat.i(271525);
    b localb = new b();
    localb.sg(paramInt);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
    super.Ie(paramInt);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
    AppMethodBeat.o(271525);
  }
  
  public final void a(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(271523);
    b localb = new b();
    localb.bn(paramc);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
    if (!LuckyMoneyHistoryEnvelopeUI.b(this.EJm)) {
      LuckyMoneyHistoryEnvelopeUI.c(this.EJm).l(null);
    }
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
    AppMethodBeat.o(271523);
  }
  
  public final void cKQ()
  {
    AppMethodBeat.i(271522);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
    Log.d("MicroMsg.LuckyMoneyHistoryEnvelopeUI", "trigger load more");
    super.cKQ();
    this.EJm.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269149);
        LuckyMoneyHistoryEnvelopeUI.a(LuckyMoneyHistoryEnvelopeUI.8.this.EJm);
        AppMethodBeat.o(269149);
      }
    });
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
    AppMethodBeat.o(271522);
  }
  
  public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
  {
    AppMethodBeat.i(271526);
    b localb = new b();
    localb.bn(paramc);
    a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
    super.onRefreshEnd(paramc);
    a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyHistoryEnvelopeUI$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
    AppMethodBeat.o(271526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyHistoryEnvelopeUI.8
 * JD-Core Version:    0.7.0.1
 */