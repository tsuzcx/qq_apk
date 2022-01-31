package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.protocal.protobuf.qt;

final class QrRewardSetMoneyUI$4
  implements a.a
{
  QrRewardSetMoneyUI$4(QrRewardSetMoneyUI paramQrRewardSetMoneyUI, g paramg) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41152);
    QrRewardSetMoneyUI.a(this.kQu, this.kQv.kOL.qiN);
    QrRewardSetMoneyUI.b(this.kQu, this.kQv.kOL.desc);
    paramm = new Intent();
    paramm.putExtra("key_desc", this.kQv.kOL.desc);
    paramm.putExtra("key_photo_url", this.kQv.kOL.qiN);
    paramm.putExtra("key_photo_aeskey", this.kQv.kOL.wIw);
    paramm.putExtra("key_photo_width", this.kQv.kOL.wIB);
    paramm.putExtra("key_icon_width", this.kQv.kOL.wIx);
    paramm.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(this.kQu));
    this.kQu.setResult(-1, paramm);
    this.kQu.finish();
    AppMethodBeat.o(41152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.4
 * JD-Core Version:    0.7.0.1
 */