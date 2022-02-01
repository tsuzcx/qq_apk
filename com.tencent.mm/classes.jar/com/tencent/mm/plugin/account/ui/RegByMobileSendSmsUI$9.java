package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

final class RegByMobileSendSmsUI$9
  implements View.OnClickListener
{
  RegByMobileSendSmsUI$9(RegByMobileSendSmsUI paramRegByMobileSendSmsUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(128570);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("android.intent.action.SENDTO");
    ((Intent)localObject).setData(Uri.parse("smsto:" + RegByMobileSendSmsUI.b(this.iWh)));
    ((Intent)localObject).putExtra("sms_body", RegByMobileSendSmsUI.c(this.iWh));
    try
    {
      paramView = this.iWh;
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/account/ui/RegByMobileSendSmsUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.iWh.overridePendingTransition(2130772144, 2130772141);
      AppMethodBeat.o(128570);
      return;
    }
    catch (Exception paramView)
    {
      ac.e("MicroMsg.RegByMobileSendSmsUI", paramView.getMessage());
      AppMethodBeat.o(128570);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegByMobileSendSmsUI.9
 * JD-Core Version:    0.7.0.1
 */