package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.l;

final class WelcomeActivity$1
  implements View.OnClickListener
{
  WelcomeActivity$1(WelcomeActivity paramWelcomeActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128794);
    paramView = new Intent();
    paramView.putExtra("not_auth_setting", true);
    paramView.putExtra("from_login_history", true);
    a.iyx.o(paramView, this.iYl);
    AppMethodBeat.o(128794);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeActivity.1
 * JD-Core Version:    0.7.0.1
 */