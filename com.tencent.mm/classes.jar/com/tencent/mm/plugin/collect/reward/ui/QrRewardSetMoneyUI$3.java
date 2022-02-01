package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

final class QrRewardSetMoneyUI$3
  implements a.a
{
  QrRewardSetMoneyUI$3(QrRewardSetMoneyUI paramQrRewardSetMoneyUI, g paramg) {}
  
  public final void g(n paramn)
  {
    AppMethodBeat.i(64012);
    ae.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(this.pkg.piv.dmy), this.pkg.piv.phe });
    if (!bu.isNullOrNil(this.pkg.piv.phe))
    {
      Toast.makeText(this.pkf, this.pkg.piv.phe, 1).show();
      AppMethodBeat.o(64012);
      return;
    }
    Toast.makeText(this.pkf, 2131762106, 1).show();
    AppMethodBeat.o(64012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.3
 * JD-Core Version:    0.7.0.1
 */