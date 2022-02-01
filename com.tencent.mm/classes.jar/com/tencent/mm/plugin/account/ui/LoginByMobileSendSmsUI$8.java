package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;

final class LoginByMobileSendSmsUI$8
  implements View.OnClickListener
{
  LoginByMobileSendSmsUI$8(LoginByMobileSendSmsUI paramLoginByMobileSendSmsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128064);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.SENDTO");
    ((Intent)localObject).setData(Uri.parse("smsto:" + LoginByMobileSendSmsUI.c(this.jkE)));
    ((Intent)localObject).putExtra("sms_body", LoginByMobileSendSmsUI.d(this.jkE));
    try
    {
      paramView = this.jkE;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.jkE.overridePendingTransition(2130772144, 2130772141);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/LoginByMobileSendSmsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(128064);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ad.e("MicroMsg.LoginByMobileSendSmsUI", paramView.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.LoginByMobileSendSmsUI.8
 * JD-Core Version:    0.7.0.1
 */