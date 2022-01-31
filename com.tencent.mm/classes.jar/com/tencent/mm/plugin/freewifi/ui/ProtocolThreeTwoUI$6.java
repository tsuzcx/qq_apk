package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class ProtocolThreeTwoUI$6
  implements View.OnClickListener
{
  ProtocolThreeTwoUI$6(ProtocolThreeTwoUI paramProtocolThreeTwoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21178);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.mPc.mNz);
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.mPc.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(21178);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.ProtocolThreeTwoUI.6
 * JD-Core Version:    0.7.0.1
 */