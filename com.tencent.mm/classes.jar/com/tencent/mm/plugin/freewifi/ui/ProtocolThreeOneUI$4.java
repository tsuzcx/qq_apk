package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class ProtocolThreeOneUI$4
  implements View.OnClickListener
{
  ProtocolThreeOneUI$4(ProtocolThreeOneUI paramProtocolThreeOneUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21124);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.mOW.mNz);
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.mOW.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(21124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeOneUI.4
 * JD-Core Version:    0.7.0.1
 */