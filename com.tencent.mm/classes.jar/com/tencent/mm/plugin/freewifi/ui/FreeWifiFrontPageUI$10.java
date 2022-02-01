package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiFrontPageUI$10
  implements View.OnClickListener
{
  FreeWifiFrontPageUI$10(FreeWifiFrontPageUI paramFreeWifiFrontPageUI, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25027);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    localObject = new Intent();
    ((Intent)localObject).putExtra("free_wifi_show_detail_error", 1);
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg", this.wRI.getString(2131760933));
    ((Intent)localObject).putExtra("free_wifi_error_ui_error_msg_detail1", this.wRl);
    ((Intent)localObject).setClass(this.wRI, FreeWifiErrorUI.class);
    paramView = this.wRI;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$8", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25027);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.10
 * JD-Core Version:    0.7.0.1
 */