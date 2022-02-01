package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WelcomeActivity$4
  implements View.OnClickListener
{
  WelcomeActivity$4(WelcomeActivity paramWelcomeActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128802);
    Object localObject = new Intent(this.iYl, MobileInputUI.class);
    ((Intent)localObject).putExtra("mobile_input_purpose", 1);
    paramView = this.iYl;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/account/ui/WelcomeActivity$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(128802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.4
 * JD-Core Version:    0.7.0.1
 */