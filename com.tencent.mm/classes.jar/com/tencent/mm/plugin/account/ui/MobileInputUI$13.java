package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.pluginsdk.m;

final class MobileInputUI$13
  implements View.OnClickListener
{
  MobileInputUI$13(MobileInputUI paramMobileInputUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("country_name", this.foH.esg);
    paramView.putExtra("couttry_code", this.foH.countryCode);
    paramView.putExtra("iso_code", this.foH.fml);
    a.eUR.b(paramView, this.foH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileInputUI.13
 * JD-Core Version:    0.7.0.1
 */