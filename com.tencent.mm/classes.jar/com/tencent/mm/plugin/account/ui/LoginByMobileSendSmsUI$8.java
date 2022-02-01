package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class LoginByMobileSendSmsUI$8
  implements View.OnClickListener
{
  LoginByMobileSendSmsUI$8(LoginByMobileSendSmsUI paramLoginByMobileSendSmsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128064);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.SENDTO");
    ((Intent)localObject).setData(Uri.parse("smsto:" + LoginByMobileSendSmsUI.c(this.iRw)));
    ((Intent)localObject).putExtra("sms_body", LoginByMobileSendSmsUI.d(this.iRw));
    try
    {
      paramView = this.iRw;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.iRw.overridePendingTransition(2130772144, 2130772141);
      AppMethodBeat.o(128064);
      return;
    }
    catch (Exception paramView)
    {
      ac.e("MicroMsg.LoginByMobileSendSmsUI", paramView.getMessage());
      AppMethodBeat.o(128064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.8
 * JD-Core Version:    0.7.0.1
 */