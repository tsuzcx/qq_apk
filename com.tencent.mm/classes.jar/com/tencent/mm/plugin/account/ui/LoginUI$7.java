package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoginUI$7
  implements View.OnClickListener
{
  LoginUI$7(LoginUI paramLoginUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(152554);
    paramView = new Intent(this.gFf, MobileInputUI.class);
    int[] arrayOfInt = new int[5];
    arrayOfInt[0] = 2;
    paramView.putExtra("mobile_input_purpose", 1);
    paramView.putExtra("kv_report_login_method_data", arrayOfInt);
    paramView.putExtra("from_switch_account", LoginUI.f(this.gFf));
    this.gFf.startActivity(paramView);
    this.gFf.finish();
    AppMethodBeat.o(152554);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.7
 * JD-Core Version:    0.7.0.1
 */