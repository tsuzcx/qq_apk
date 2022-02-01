package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class FreeWifiActivateStateUI$6
  implements View.OnClickListener
{
  FreeWifiActivateStateUI$6(FreeWifiActivateStateUI paramFreeWifiActivateStateUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(24974);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
    paramView = this.tzT.getString(2131759630);
    localObject = new Intent();
    ((Intent)localObject).putExtra("rawUrl", paramView);
    ((Intent)localObject).putExtra("showShare", false);
    ((Intent)localObject).putExtra("show_bottom", false);
    d.b(this.tzT.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
    a.a(this, "com/tencent/mm/plugin/freewifi/ui/FreeWifiActivateStateUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(24974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.6
 * JD-Core Version:    0.7.0.1
 */