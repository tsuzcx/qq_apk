package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMWizardActivity;

final class MobileFriendUI$7
  implements View.OnClickListener
{
  MobileFriendUI$7(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110151);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    MMWizardActivity.al(this.jco, new Intent(this.jco, BindMContactIntroUI.class));
    a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(110151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.7
 * JD-Core Version:    0.7.0.1
 */