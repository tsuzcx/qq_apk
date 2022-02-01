package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BindMContactStatusUI$1
  implements View.OnClickListener
{
  BindMContactStatusUI$1(BindMContactStatusUI paramBindMContactStatusUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109881);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    BindMContactStatusUI.a(this.mSq);
    a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactStatusUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactStatusUI.1
 * JD-Core Version:    0.7.0.1
 */