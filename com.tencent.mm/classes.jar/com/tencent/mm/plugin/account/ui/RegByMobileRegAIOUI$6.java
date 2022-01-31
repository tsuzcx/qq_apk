package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;

final class RegByMobileRegAIOUI$6
  implements View.OnClickListener
{
  RegByMobileRegAIOUI$6(RegByMobileRegAIOUI paramRegByMobileRegAIOUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("country_name", RegByMobileRegAIOUI.j(this.fqF));
    paramView.putExtra("couttry_code", RegByMobileRegAIOUI.d(this.fqF));
    a.eUR.b(paramView, this.fqF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileRegAIOUI.6
 * JD-Core Version:    0.7.0.1
 */