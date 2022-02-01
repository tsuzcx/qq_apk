package com.tencent.mm.plugin.collect.reward.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.protocal.protobuf.vn;

final class QrRewardSetMoneyUI$4
  implements a.a
{
  QrRewardSetMoneyUI$4(QrRewardSetMoneyUI paramQrRewardSetMoneyUI, g paramg) {}
  
  public final void g(n paramn)
  {
    AppMethodBeat.i(64013);
    QrRewardSetMoneyUI.a(this.pkf, this.pkg.piv.ynq);
    QrRewardSetMoneyUI.b(this.pkf, this.pkg.piv.desc);
    paramn = new Intent();
    paramn.putExtra("key_desc", this.pkg.piv.desc);
    paramn.putExtra("key_photo_url", this.pkg.piv.ynq);
    paramn.putExtra("key_photo_aeskey", this.pkg.piv.GmH);
    paramn.putExtra("key_photo_width", this.pkg.piv.GmM);
    paramn.putExtra("key_icon_width", this.pkg.piv.GmI);
    paramn.putExtra("key_return_from_first", QrRewardSetMoneyUI.c(this.pkf));
    this.pkf.setResult(-1, paramn);
    this.pkf.finish();
    AppMethodBeat.o(64013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.4
 * JD-Core Version:    0.7.0.1
 */