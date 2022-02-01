package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;

final class LuckyMoneyPickEnvelopeUI$f
  extends LuckyMoneyPickEnvelopeUI.a
{
  public LuckyMoneyPickEnvelopeUI$f(final LuckyMoneyPickEnvelopeUI paramLuckyMoneyPickEnvelopeUI, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(284221);
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(284168);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$HistoryEnvelopeEntranceVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        h.OAn.b(22302, new Object[] { Integer.valueOf(3) });
        localObject = new Intent(LuckyMoneyPickEnvelopeUI.f.this.KGu.getContext(), WalletPayUPwdConfirmUI.class);
        paramAnonymousView = LuckyMoneyPickEnvelopeUI.f.this.KGu;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$HistoryEnvelopeEntranceVH$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$HistoryEnvelopeEntranceVH$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$HistoryEnvelopeEntranceVH$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(284168);
      }
    });
    AppMethodBeat.o(284221);
  }
  
  public final void a(LuckyMoneyPickEnvelopeUI.e parame) {}
  
  public final void yh(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.f
 * JD-Core Version:    0.7.0.1
 */