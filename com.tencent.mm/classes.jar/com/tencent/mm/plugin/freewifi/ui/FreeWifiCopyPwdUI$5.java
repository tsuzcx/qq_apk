package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiCopyPwdUI$5
  implements View.OnClickListener
{
  FreeWifiCopyPwdUI$5(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24999);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = new Intent();
    ((Intent)localObject).putExtra("free_wifi_show_detail_error", 1);
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg", this.wRk.getString(2131760933));
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg_detail1", this.wRl);
    ((Intent)localObject).setClass(this.wRk, FreeWifiErrorUI.class);
    paramView = this.wRk;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(24999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.5
 * JD-Core Version:    0.7.0.1
 */