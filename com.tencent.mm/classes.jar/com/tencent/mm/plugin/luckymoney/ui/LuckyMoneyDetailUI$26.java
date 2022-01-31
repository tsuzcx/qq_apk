package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;

final class LuckyMoneyDetailUI$26
  implements Runnable
{
  LuckyMoneyDetailUI$26(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(42676);
    if ((LuckyMoneyDetailUI.S(this.otz).getVisibility() == 8) && (LuckyMoneyDetailUI.T(this.otz).getVisibility() == 8) && (LuckyMoneyDetailUI.U(this.otz).getVisibility() == 8))
    {
      LuckyMoneyDetailUI.V(this.otz).removeFooterView(LuckyMoneyDetailUI.Q(this.otz));
      AppMethodBeat.o(42676);
      return;
    }
    int i = a.gx(this.otz.getContext());
    int j = i - am.hY(this.otz) - f.di(this.otz);
    int k = LuckyMoneyDetailUI.V(this.otz).getMeasuredHeight();
    int m = a.fromDPToPix(this.otz.getContext(), 29);
    int n = a.fromDPToPix(this.otz.getContext(), 16);
    if (k < j) {
      LuckyMoneyDetailUI.Q(this.otz).setPadding(0, m + (j - LuckyMoneyDetailUI.V(this.otz).getMeasuredHeight()), 0, n);
    }
    for (;;)
    {
      ab.d("MicroMsg.LuckyMoneyDetailUI", "winHeight:%s showHeight:%s recordHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      AppMethodBeat.o(42676);
      return;
      LuckyMoneyDetailUI.Q(this.otz).setPadding(0, m, 0, n);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.26
 * JD-Core Version:    0.7.0.1
 */