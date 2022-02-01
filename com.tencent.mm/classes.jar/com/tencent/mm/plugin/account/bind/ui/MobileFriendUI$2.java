package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMWizardActivity;

final class MobileFriendUI$2
  implements View.OnClickListener
{
  MobileFriendUI$2(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(110146);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    paramView = new Intent(this.kdk.getContext(), BindMContactIntroUI.class);
    paramView.putExtra("key_upload_scene", 6);
    MMWizardActivity.ay(this.kdk, paramView);
    a.a(this, "com/tencent/mm/plugin/account/bind/ui/MobileFriendUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(110146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.2
 * JD-Core Version:    0.7.0.1
 */