package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.chy;

final class MallIndexOSUI$3
  implements View.OnClickListener
{
  MallIndexOSUI$3(MallIndexOSUI paramMallIndexOSUI, chy paramchy) {}
  
  public final void onClick(View paramView)
  {
    h.nFQ.f(13867, new Object[] { aa.a(this.lZZ.tWy), Integer.valueOf(this.lZX.lYn) });
    paramView = new Intent();
    paramView.putExtra("rawUrl", aa.a(this.lZZ.tWy));
    paramView.putExtra("geta8key_username", q.Gj());
    paramView.putExtra("pay_channel", 1);
    d.b(this.lZX, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.3
 * JD-Core Version:    0.7.0.1
 */