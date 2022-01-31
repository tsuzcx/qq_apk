package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.ui.base.h;

final class LoginIndepPass$13
  implements View.OnClickListener
{
  LoginIndepPass$13(LoginIndepPass paramLoginIndepPass) {}
  
  public final void onClick(View paramView)
  {
    h.a(this.fnl, this.fnl.getString(q.j.regbymobile_reg_verify_mobile_msg) + LoginIndepPass.c(this.fnl), this.fnl.getString(q.j.regbymobile_reg_verify_mobile_title), new DialogInterface.OnClickListener()new LoginIndepPass.13.2
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        g.Dk().a(145, LoginIndepPass.13.this.fnl);
        paramAnonymousDialogInterface = new a(LoginIndepPass.d(LoginIndepPass.13.this.fnl), 16, "", 0, "");
        g.Dk().a(paramAnonymousDialogInterface, 0);
        LoginIndepPass localLoginIndepPass1 = LoginIndepPass.13.this.fnl;
        LoginIndepPass localLoginIndepPass2 = LoginIndepPass.13.this.fnl;
        LoginIndepPass.13.this.fnl.getString(q.j.app_tip);
        LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.13.this.fnl.getString(q.j.app_loading), true, new LoginIndepPass.13.1.1(this, paramAnonymousDialogInterface)));
      }
    }, new LoginIndepPass.13.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.13
 * JD-Core Version:    0.7.0.1
 */