package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class FreeWifiFrontPageUI$6
  implements View.OnClickListener
{
  FreeWifiFrontPageUI$6(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20964);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.mND.mNz);
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.mND.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(20964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.6
 * JD-Core Version:    0.7.0.1
 */