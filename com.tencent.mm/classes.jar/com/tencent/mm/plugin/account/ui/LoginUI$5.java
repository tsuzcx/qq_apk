package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class LoginUI$5
  implements View.OnClickListener
{
  LoginUI$5(LoginUI paramLoginUI, boolean[] paramArrayOfBoolean) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(125030);
    if (this.gFg[0] != 0) {
      this.gFg[0] = false;
    }
    for (;;)
    {
      LoginUI.e(this.gFf);
      AppMethodBeat.o(125030);
      return;
      b.pgQ.fD("ce_login_id", "<LoginByID>");
      paramView = MotionEvent.obtain(0L, 0L, 1, 0.0F, 0.0F, 65535);
      b.pgQ.a("ce_login_id", paramView);
      b.pgQ.Wa("ce_login_id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.5
 * JD-Core Version:    0.7.0.1
 */