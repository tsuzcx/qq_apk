package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.mall.a.a;

final class MallIndexUI$7
  implements View.OnClickListener
{
  MallIndexUI$7(MallIndexUI paramMallIndexUI, a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.maA.lYg);
    d.b(this.mau, "webview", ".ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.7
 * JD-Core Version:    0.7.0.1
 */