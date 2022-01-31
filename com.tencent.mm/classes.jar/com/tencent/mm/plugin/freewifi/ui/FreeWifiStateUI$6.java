package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class FreeWifiStateUI$6
  implements View.OnClickListener
{
  FreeWifiStateUI$6(FreeWifiStateUI paramFreeWifiStateUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21076);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.mOB.mNz);
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.mOB.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(21076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.6
 * JD-Core Version:    0.7.0.1
 */