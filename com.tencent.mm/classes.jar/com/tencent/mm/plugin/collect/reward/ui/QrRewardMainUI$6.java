package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.collect.reward.b.a.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class QrRewardMainUI$6
  implements a.a
{
  QrRewardMainUI$6(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void L(String paramString, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.QrRewardMainUI", "callback ret: %s, %s, %s", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      ai.d(new QrRewardMainUI.6.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.6
 * JD-Core Version:    0.7.0.1
 */