package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;

final class WelcomeSelectView$1
  implements View.OnClickListener
{
  WelcomeSelectView$1(WelcomeSelectView paramWelcomeSelectView) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("not_auth_setting", true);
    paramView.putExtra("from_login_history", true);
    a.eUR.p(paramView, this.fta.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.WelcomeSelectView.1
 * JD-Core Version:    0.7.0.1
 */