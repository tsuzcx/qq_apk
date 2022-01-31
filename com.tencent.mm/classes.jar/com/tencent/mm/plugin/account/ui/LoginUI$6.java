package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class LoginUI$6
  implements View.OnClickListener
{
  LoginUI$6(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.fnM, MobileInputUI.class);
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = 2;
    paramView.putExtra("mobile_input_purpose", 1);
    paramView.putExtra("kv_report_login_method_data", arrayOfInt);
    paramView.putExtra("from_switch_account", LoginUI.g(this.fnM));
    this.fnM.startActivity(paramView);
    this.fnM.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.6
 * JD-Core Version:    0.7.0.1
 */