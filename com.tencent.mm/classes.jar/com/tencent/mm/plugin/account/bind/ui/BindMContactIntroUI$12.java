package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BindMContactIntroUI$12
  implements View.OnClickListener
{
  BindMContactIntroUI$12(BindMContactIntroUI paramBindMContactIntroUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109854);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    BindMContactIntroUI.a(this.pOL);
    a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109854);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI.12
 * JD-Core Version:    0.7.0.1
 */