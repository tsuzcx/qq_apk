package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class i$1
  implements View.OnClickListener
{
  i$1(i parami, MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    this.fod.fmY[0] = 1;
    paramView = new Intent();
    paramView.putExtra("from_switch_account", this.fod.fnH);
    paramView.setClass(this.fod, LoginUI.class);
    this.fod.startActivity(paramView);
    this.fod.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.i.1
 * JD-Core Version:    0.7.0.1
 */