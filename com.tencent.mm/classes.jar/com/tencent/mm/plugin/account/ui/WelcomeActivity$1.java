package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.m;

final class WelcomeActivity$1
  implements View.OnClickListener
{
  WelcomeActivity$1(WelcomeActivity paramWelcomeActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128794);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/WelcomeActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new Intent();
    paramView.putExtra("not_auth_setting", true);
    paramView.putExtra("from_login_history", true);
    com.tencent.mm.plugin.account.a.a.iRG.o(paramView, this.jru);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/WelcomeActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(128794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.1
 * JD-Core Version:    0.7.0.1
 */