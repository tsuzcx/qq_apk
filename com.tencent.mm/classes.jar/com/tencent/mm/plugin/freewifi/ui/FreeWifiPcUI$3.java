package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class FreeWifiPcUI$3
  implements View.OnClickListener
{
  FreeWifiPcUI$3(FreeWifiPcUI paramFreeWifiPcUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21065);
    paramView = new Intent();
    paramView.putExtra("rawUrl", FreeWifiPcUI.f(this.mOu));
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.mOu.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(21065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiPcUI.3
 * JD-Core Version:    0.7.0.1
 */