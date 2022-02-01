package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMWizardActivity;

final class BindQQUI$5
  implements View.OnClickListener
{
  BindQQUI$5(BindQQUI paramBindQQUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(109973);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/bind/ui/BindQQUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    MMWizardActivity.al(this.jdJ, new Intent(this.jdJ, VerifyQQUI.class));
    a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindQQUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(109973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindQQUI.5
 * JD-Core Version:    0.7.0.1
 */