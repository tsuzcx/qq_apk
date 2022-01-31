package com.tencent.mm.plugin.collect.reward.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardMainUI$9
  implements View.OnClickListener
{
  QrRewardMainUI$9(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.QrRewardMainUI", "open click");
    QrRewardMainUI.a(this.iJi, true);
    h.nFQ.f(14721, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.9
 * JD-Core Version:    0.7.0.1
 */