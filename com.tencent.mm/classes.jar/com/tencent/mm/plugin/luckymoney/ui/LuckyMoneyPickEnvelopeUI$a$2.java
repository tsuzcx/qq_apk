package com.tencent.mm.plugin.luckymoney.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

final class LuckyMoneyPickEnvelopeUI$a$2
  implements View.OnLongClickListener
{
  LuckyMoneyPickEnvelopeUI$a$2(LuckyMoneyPickEnvelopeUI.a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(42917);
    if (LuckyMoneyPickEnvelopeUI.o(this.ovY.ovW))
    {
      LuckyMoneyPickEnvelopeUI.f(this.ovY.ovW);
      int i = LuckyMoneyEnvelopeTouchRecyclerView.bq(paramView);
      LuckyMoneyPickEnvelopeUI.d(this.ovY.ovW);
      Object localObject = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(LuckyMoneyPickEnvelopeUI.c(this.ovY.ovW));
      ab.i("MicroMsg.LuckyMoneyPickEnvelopeUI", "delete pos: %s", new Object[] { Integer.valueOf(i) });
      if ((i >= 0) && (i < LuckyMoneyPickEnvelopeUI.b(this.ovY.ovW).size()) && (paramView == localObject))
      {
        paramView = (LuckyMoneyPickEnvelopeUI.b)LuckyMoneyPickEnvelopeUI.b(this.ovY.ovW).get(i);
        if ((paramView != null) && (paramView.opR != null))
        {
          localObject = new d(this.ovY.ovW.getContext(), 1, true);
          TextView localTextView = new TextView(this.ovY.ovW.getContext());
          localTextView.setPadding(0, 0, 0, com.tencent.mm.cb.a.fromDPToPix(this.ovY.ovW.getContext(), 9));
          localTextView.setMinHeight(com.tencent.mm.cb.a.ao(this.ovY.ovW.getContext(), 2131427511));
          localTextView.setTextSize(14.0F);
          localTextView.setTextColor(this.ovY.ovW.getResources().getColor(2131690159));
          localTextView.setText(2131301285);
          localTextView.setGravity(81);
          ((d)localObject).G(localTextView, true);
          ((d)localObject).sao = new LuckyMoneyPickEnvelopeUI.a.2.1(this);
          ((d)localObject).sap = new LuckyMoneyPickEnvelopeUI.a.2.2(this, paramView);
          ((d)localObject).crd();
        }
      }
    }
    AppMethodBeat.o(42917);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.a.2
 * JD-Core Version:    0.7.0.1
 */