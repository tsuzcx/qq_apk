package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;

final class FreeWifiFrontPageUI$6
  implements View.OnClickListener
{
  FreeWifiFrontPageUI$6(FreeWifiFrontPageUI paramFreeWifiFrontPageUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(25023);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.sto.stk);
    paramView.putExtra("showShare", false);
    paramView.putExtra("show_bottom", false);
    d.b(this.sto.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(25023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.6
 * JD-Core Version:    0.7.0.1
 */