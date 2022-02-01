package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.f;

final class LuckyMoneyPickEnvelopeUI$10
  implements View.OnClickListener
{
  LuckyMoneyPickEnvelopeUI$10(LuckyMoneyPickEnvelopeUI paramLuckyMoneyPickEnvelopeUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(163772);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    ae.d("MicroMsg.LuckyMoneyPickEnvelopeUI", "click exchange tv");
    paramView = Uri.parse(this.vLU).buildUpon();
    paramView.appendQueryParameter("sessionId", LuckyMoneyPickEnvelopeUI.e(this.vLP));
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramView.build().toString());
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("KRightBtn", true);
    f.b(this.vLP.getContext(), (Intent)localObject, 1);
    paramView = g.yxI;
    if (LuckyMoneyPickEnvelopeUI.i(this.vLP).booleanValue()) {}
    for (int i = 2;; i = 1)
    {
      paramView.f(18890, new Object[] { Integer.valueOf(3), Integer.valueOf(i), LuckyMoneyPickEnvelopeUI.e(this.vLP) });
      a.a(this, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPickEnvelopeUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(163772);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPickEnvelopeUI.10
 * JD-Core Version:    0.7.0.1
 */