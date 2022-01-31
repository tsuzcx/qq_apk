package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.ui.base.h;

final class LoginIndepPass$13
  implements View.OnClickListener
{
  LoginIndepPass$13(LoginIndepPass paramLoginIndepPass) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(124981);
    h.a(this.gEE, this.gEE.getString(2131302462) + LoginIndepPass.c(this.gEE), this.gEE.getString(2131302463), new DialogInterface.OnClickListener()new LoginIndepPass.13.2
    {
      public final void onClick(final DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(124980);
        g.Rc().a(145, LoginIndepPass.13.this.gEE);
        paramAnonymousDialogInterface = new a(LoginIndepPass.d(LoginIndepPass.13.this.gEE), 16, "", 0, "");
        g.Rc().a(paramAnonymousDialogInterface, 0);
        LoginIndepPass localLoginIndepPass1 = LoginIndepPass.13.this.gEE;
        LoginIndepPass localLoginIndepPass2 = LoginIndepPass.13.this.gEE;
        LoginIndepPass.13.this.gEE.getString(2131297087);
        LoginIndepPass.a(localLoginIndepPass1, h.b(localLoginIndepPass2, LoginIndepPass.13.this.gEE.getString(2131296987), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(124979);
            g.Rc().a(paramAnonymousDialogInterface);
            g.Rc().b(701, LoginIndepPass.13.this.gEE);
            g.Rc().b(252, LoginIndepPass.13.this.gEE);
            AppMethodBeat.o(124979);
          }
        }));
        AppMethodBeat.o(124980);
      }
    }, new LoginIndepPass.13.2(this));
    AppMethodBeat.o(124981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginIndepPass.13
 * JD-Core Version:    0.7.0.1
 */