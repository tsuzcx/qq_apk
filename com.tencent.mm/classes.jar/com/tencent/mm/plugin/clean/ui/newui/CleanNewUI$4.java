package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class CleanNewUI$4
  implements View.OnClickListener
{
  CleanNewUI$4(CleanNewUI paramCleanNewUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(18915);
    ab.i("MicroMsg.CleanNewUI", "qq mgr btn click");
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 5L, 1L, false);
    if (!CleanNewUI.a(this.kJs))
    {
      if (CleanNewUI.b(this.kJs))
      {
        com.tencent.mm.ui.base.h.d(this.kJs, this.kJs.getString(2131298379, new Object[] { bo.nV(CleanNewUI.c(this.kJs)) }), "", this.kJs.getString(2131296907), this.kJs.getString(2131296888), new CleanNewUI.4.1(this), null);
        AppMethodBeat.o(18915);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
      paramView.putExtra("show_bottom", false);
      paramView.putExtra("showShare", false);
      d.b(this.kJs.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
    }
    AppMethodBeat.o(18915);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanNewUI.4
 * JD-Core Version:    0.7.0.1
 */