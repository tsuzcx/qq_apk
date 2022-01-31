package com.tencent.mm.plugin.account.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.normsg.a.b;

final class LoginUI$6
  implements View.OnTouchListener
{
  LoginUI$6(LoginUI paramLoginUI, boolean[] paramArrayOfBoolean) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(152553);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152553);
      return false;
      this.gFg[0] = true;
      b.pgQ.fD("ce_login_id", "<LoginByID>");
      continue;
      b.pgQ.a("ce_login_id", paramMotionEvent);
      b.pgQ.Wa("ce_login_id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.6
 * JD-Core Version:    0.7.0.1
 */