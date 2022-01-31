package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CleanNewUI$4
  implements View.OnClickListener
{
  CleanNewUI$4(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.CleanNewUI", "qq mgr btn click");
    com.tencent.mm.plugin.report.service.h.nFQ.a(714L, 3L, 1L, false);
    if (!CleanNewUI.b(this.iDR))
    {
      if (CleanNewUI.c(this.iDR)) {
        com.tencent.mm.ui.base.h.a(this.iDR, this.iDR.getString(R.l.clean_download_qqmgr_tips, new Object[] { bk.ht(CleanNewUI.d(this.iDR)) }), "", this.iDR.getString(R.l.app_download), this.iDR.getString(R.l.app_cancel), new CleanNewUI.4.1(this), null);
      }
    }
    else {
      return;
    }
    paramView = new Intent();
    paramView.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
    paramView.putExtra("show_bottom", false);
    paramView.putExtra("showShare", false);
    d.b(this.iDR.mController.uMN, "webview", ".ui.tools.WebViewUI", paramView);
    com.tencent.mm.plugin.report.service.h.nFQ.a(714L, 5L, 1L, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.4
 * JD-Core Version:    0.7.0.1
 */