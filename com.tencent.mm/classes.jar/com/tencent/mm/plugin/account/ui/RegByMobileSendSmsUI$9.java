package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class RegByMobileSendSmsUI$9
  implements View.OnClickListener
{
  RegByMobileSendSmsUI$9(RegByMobileSendSmsUI paramRegByMobileSendSmsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128570);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.SENDTO");
    ((Intent)localObject).setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.b(this.jsj)));
    ((Intent)localObject).putExtra("sms_body", RegByMobileSendSmsUI.c(this.jsj));
    try
    {
      paramView = this.jsj;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.jsj.overridePendingTransition(2130772144, 2130772141);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(128570);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        ae.e("MicroMsg.RegByMobileSendSmsUI", paramView.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.9
 * JD-Core Version:    0.7.0.1
 */