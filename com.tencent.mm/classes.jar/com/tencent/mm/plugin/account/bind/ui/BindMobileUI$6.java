package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;

final class BindMobileUI$6
  implements View.OnClickListener
{
  BindMobileUI$6(BindMobileUI paramBindMobileUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("country_name", BindMobileUI.h(this.fcH));
    paramView.putExtra("couttry_code", BindMobileUI.e(this.fcH));
    a.eUR.b(paramView, this.fcH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMobileUI.6
 * JD-Core Version:    0.7.0.1
 */