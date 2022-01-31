package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class FreeWifiActivateAuthStateUI$1
  implements View.OnClickListener
{
  FreeWifiActivateAuthStateUI$1(FreeWifiActivateAuthStateUI paramFreeWifiActivateAuthStateUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20889);
    paramView = this.mMn.getString(2131300158);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramView);
    localIntent.putExtra("showShare", false);
    localIntent.putExtra("show_bottom", false);
    d.b(this.mMn, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(20889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateAuthStateUI.1
 * JD-Core Version:    0.7.0.1
 */