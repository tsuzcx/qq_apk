package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MallIndexUI$8
  implements View.OnClickListener
{
  MallIndexUI$8(MallIndexUI paramMallIndexUI, com.tencent.mm.plugin.mall.a.d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43211);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.oAv.oxH);
    com.tencent.mm.bq.d.b(this.oAt, "webview", ".ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(43211);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.8
 * JD-Core Version:    0.7.0.1
 */