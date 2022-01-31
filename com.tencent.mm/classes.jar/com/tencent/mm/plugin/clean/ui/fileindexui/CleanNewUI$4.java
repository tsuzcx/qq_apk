package com.tencent.mm.plugin.clean.ui.fileindexui;

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
    AppMethodBeat.i(18815);
    ab.i("MicroMsg.CleanNewUI", "qq mgr btn click");
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(714L, 3L, 1L, false);
    if (!CleanNewUI.b(this.kIY))
    {
      if (CleanNewUI.c(this.kIY))
      {
        com.tencent.mm.ui.base.h.d(this.kIY, this.kIY.getString(2131298379, new Object[] { bo.nV(CleanNewUI.d(this.kIY)) }), "", this.kIY.getString(2131296907), this.kIY.getString(2131296888), new CleanNewUI.4.1(this), null);
        AppMethodBeat.o(18815);
        return;
      }
      paramView = new Intent();
      paramView.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
      paramView.putExtra("show_bottom", false);
      paramView.putExtra("showShare", false);
      d.b(this.kIY.getContext(), "webview", ".ui.tools.WebViewUI", paramView);
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(714L, 5L, 1L, false);
    }
    AppMethodBeat.o(18815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI.4
 * JD-Core Version:    0.7.0.1
 */