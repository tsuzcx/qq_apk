package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cvk;

final class MallIndexOSUI$4
  implements View.OnClickListener
{
  MallIndexOSUI$4(MallIndexOSUI paramMallIndexOSUI, cvk paramcvk) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43184);
    h.qsU.e(13867, new Object[] { aa.a(this.ozY.ydQ), Integer.valueOf(this.ozV.oxO) });
    paramView = new Intent();
    paramView.putExtra("rawUrl", aa.a(this.ozY.ydQ));
    paramView.putExtra("geta8key_username", r.Zn());
    paramView.putExtra("pay_channel", 1);
    d.b(this.ozV, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramView);
    AppMethodBeat.o(43184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.4
 * JD-Core Version:    0.7.0.1
 */