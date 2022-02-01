package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayCardDetailUI$4
  implements View.OnClickListener
{
  HoneyPayCardDetailUI$4(HoneyPayCardDetailUI paramHoneyPayCardDetailUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(64670);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    ad.d(this.uFY.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(this.uFY).url });
    if (!bt.isNullOrNil(HoneyPayCardDetailUI.b(this.uFY).url)) {
      e.o(this.uFY.getContext(), HoneyPayCardDetailUI.b(this.uFY).url, false);
    }
    a.a(this, "com/tencent/mm/plugin/honey_pay/ui/HoneyPayCardDetailUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI.4
 * JD-Core Version:    0.7.0.1
 */