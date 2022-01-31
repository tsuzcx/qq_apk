package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class QrRewardMainUI$4
  implements n.c
{
  QrRewardMainUI$4(QrRewardMainUI paramQrRewardMainUI) {}
  
  public final void a(l paraml)
  {
    String str2 = this.iJi.getString(a.i.qr_reward_menu_avatar);
    if (QrRewardMainUI.k(this.iJi))
    {
      str1 = this.iJi.getString(a.i.qr_reward_select_menu);
      paraml.a(1, str2, str1);
      str2 = this.iJi.getString(a.i.qr_reward_menu_wording);
      if (QrRewardMainUI.k(this.iJi)) {
        break label87;
      }
    }
    label87:
    for (String str1 = this.iJi.getString(a.i.qr_reward_select_menu);; str1 = "")
    {
      paraml.a(2, str2, str1);
      return;
      str1 = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.4
 * JD-Core Version:    0.7.0.1
 */