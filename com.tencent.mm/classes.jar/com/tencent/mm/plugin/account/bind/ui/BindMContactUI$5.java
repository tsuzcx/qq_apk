package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;

final class BindMContactUI$5
  implements View.OnClickListener
{
  BindMContactUI$5(BindMContactUI paramBindMContactUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("country_name", BindMContactUI.h(this.fcb));
    paramView.putExtra("couttry_code", BindMContactUI.c(this.fcb));
    a.eUR.b(paramView, this.fcb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactUI.5
 * JD-Core Version:    0.7.0.1
 */