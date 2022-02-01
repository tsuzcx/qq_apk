package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.d;

final class WelcomeActivity$9
  implements View.OnClickListener
{
  WelcomeActivity$9(WelcomeActivity paramWelcomeActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128806);
    if (d.DIf)
    {
      WelcomeActivity.c(this.iYl);
      AppMethodBeat.o(128806);
      return;
    }
    Object localObject = new Intent(this.iYl, RegByMobileRegAIOUI.class);
    paramView = this.iYl;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/account/ui/WelcomeActivity$7", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(128806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.9
 * JD-Core Version:    0.7.0.1
 */