package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.widget.picker.b.b;
import java.util.ArrayList;

final class WxaLuckyMoneyPrepareUI$16
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$16(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, ArrayList paramArrayList) {}
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(64963);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    paramView = new com.tencent.mm.ui.widget.picker.b(this.EuT.getContext(), this.wrU);
    paramView.ayK(WxaLuckyMoneyPrepareUI.f(this.EuT));
    paramView.YrN = new b.b()
    {
      public final void onResult(boolean paramAnonymousBoolean, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(64962);
        paramView.hide();
        if (paramAnonymousBoolean) {
          WxaLuckyMoneyPrepareUI.h(WxaLuckyMoneyPrepareUI.16.this.EuT).setText((CharSequence)paramAnonymousObject1);
        }
        WxaLuckyMoneyPrepareUI.a(WxaLuckyMoneyPrepareUI.16.this.EuT, paramView.idp());
        AppMethodBeat.o(64962);
      }
    };
    paramView.show();
    a.a(this, "com/tencent/mm/plugin/luckymoney/appbrand/ui/prepare/WxaLuckyMoneyPrepareUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(64963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.16
 * JD-Core Version:    0.7.0.1
 */