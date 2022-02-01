package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;

final class LoginUI$5
  implements View.OnClickListener
{
  LoginUI$5(LoginUI paramLoginUI, boolean[] paramArrayOfBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128206);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    if (this.jlX[0] != 0) {
      this.jlX[0] = false;
    }
    for (;;)
    {
      LoginUI.e(this.jlW);
      a.a(this, "com/tencent/mm/plugin/account/ui/LoginUI$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(128206);
      return;
      com.tencent.mm.plugin.normsg.a.b.wtJ.io("ce_login_id", "<LoginByID>");
      paramView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      com.tencent.mm.plugin.normsg.a.b.wtJ.a("ce_login_id", paramView);
      com.tencent.mm.plugin.normsg.a.b.wtJ.atu("ce_login_id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.5
 * JD-Core Version:    0.7.0.1
 */