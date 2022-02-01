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
    AppMethodBeat.i(128208);
    paramView = new Intent(this.iSO, MobileInputUI.class);
    Object localObject = new int[5];
    localObject[0] = 2;
    paramView.putExtra("mobile_input_purpose", 1);
    paramView.putExtra("kv_report_login_method_data", (int[])localObject);
    paramView.putExtra("from_switch_account", LoginUI.f(this.iSO));
    localObject = this.iSO;
    paramView = new com.tencent.mm.hellhoundlib.b.a().ba(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.aeD(), "com/tencent/mm/plugin/account/ui/LoginUI$15", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    ((LoginUI)localObject).startActivity((Intent)paramView.lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/account/ui/LoginUI$15", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.iSO.finish();
    AppMethodBeat.o(128208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginUI.7
 * JD-Core Version:    0.7.0.1
 */