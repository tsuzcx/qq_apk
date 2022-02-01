package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiFrontPageUI$6
  implements View.OnClickListener
{
  FreeWifiFrontPageUI$6(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25023);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.tpQ.tpM);
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.tpQ.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiFrontPageUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(25023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.6
 * JD-Core Version:    0.7.0.1
 */