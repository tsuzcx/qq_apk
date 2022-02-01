package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class FreeWifiCopyPwdUI$5
  implements View.OnClickListener
{
  FreeWifiCopyPwdUI$5(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24999);
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("free_wifi_show_detail_error", 1);
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg", this.ssP.getString(2131759612));
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg_detail1", this.ssQ);
    ((Intent)localObject).setClass(this.ssP, FreeWifiErrorUI.class);
    paramView = this.ssP;
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(24999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.5
 * JD-Core Version:    0.7.0.1
 */