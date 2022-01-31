package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.protocal.c.nr;

final class QrRewardSetMoneyUI$4
  implements a.a
{
  QrRewardSetMoneyUI$4(QrRewardSetMoneyUI paramQrRewardSetMoneyUI, g paramg) {}
  
  public final void i(m paramm)
  {
    QrRewardSetMoneyUI.a(this.iJO, this.iJP.iIg.nxM);
    QrRewardSetMoneyUI.b(this.iJO, this.iJP.iIg.desc);
    paramm = new Intent();
    paramm.putExtra("key_desc", this.iJP.iIg.desc);
    paramm.putExtra("key_photo_url", this.iJP.iIg.nxM);
    paramm.putExtra("key_photo_aeskey", this.iJP.iIg.sKG);
    paramm.putExtra("key_photo_width", this.iJP.iIg.sKL);
    paramm.putExtra("key_icon_width", this.iJP.iIg.sKH);
    paramm.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(this.iJO));
    this.iJO.setResult(-1, paramm);
    this.iJO.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.4
 * JD-Core Version:    0.7.0.1
 */