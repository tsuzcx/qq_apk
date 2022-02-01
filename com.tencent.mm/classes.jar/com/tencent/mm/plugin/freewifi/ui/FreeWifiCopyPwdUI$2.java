package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiCopyPwdUI$2
  implements View.OnClickListener
{
  FreeWifiCopyPwdUI$2(FreeWifiCopyPwdUI paramFreeWifiCopyPwdUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24996);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new Intent("android.settings.WIFI_SETTINGS");
    this.tAi.startActivityForResult(paramView, FreeWifiCopyPwdUI.tAc);
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiCopyPwdUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(24996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiCopyPwdUI.2
 * JD-Core Version:    0.7.0.1
 */