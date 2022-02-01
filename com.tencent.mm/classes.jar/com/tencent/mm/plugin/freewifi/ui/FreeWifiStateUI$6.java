package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiStateUI$6
  implements View.OnClickListener
{
  FreeWifiStateUI$6(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25135);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.tBF.tAD);
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.tBF.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiStateUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.6
 * JD-Core Version:    0.7.0.1
 */