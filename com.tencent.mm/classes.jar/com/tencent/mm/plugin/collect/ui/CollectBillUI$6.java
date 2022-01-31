package com.tencent.mm.plugin.collect.ui;

import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class CollectBillUI$6
  implements MMSwitchBtn.a
{
  CollectBillUI$6(CollectBillUI paramCollectBillUI) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(41216);
    ab.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    CollectBillUI.j(this.kRi).setCheck(paramBoolean);
    CollectBillUI.k(this.kRi).setCheck(paramBoolean);
    if (paramBoolean)
    {
      CollectBillUI.a(this.kRi, CollectBillUI.l(this.kRi) | 0x8000);
      CollectBillUI.m(this.kRi).setImageResource(2131231156);
      CollectBillUI.n(this.kRi).setImageResource(2131231156);
      Toast.makeText(this.kRi.getContext(), 2131298456, 1).show();
      h.qsU.e(13944, new Object[] { Integer.valueOf(11) });
    }
    for (int i = 1;; i = 2)
    {
      g.RM();
      g.RL().Ru().set(147457, Long.valueOf(CollectBillUI.l(this.kRi)));
      beg localbeg = new beg();
      localbeg.qsl = i;
      ((j)g.E(j.class)).Yz().c(new j.a(209, localbeg));
      if (i != 1) {
        break;
      }
      a.bhw().bhz();
      AppMethodBeat.o(41216);
      return;
      CollectBillUI.a(this.kRi, CollectBillUI.l(this.kRi) & 0xFFFF7FFF);
      CollectBillUI.m(this.kRi).setImageResource(2131231155);
      CollectBillUI.n(this.kRi).setImageResource(2131231155);
      Toast.makeText(this.kRi.getContext(), 2131298446, 1).show();
      h.qsU.e(13944, new Object[] { Integer.valueOf(12) });
    }
    a.bhw().bhA();
    AppMethodBeat.o(41216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.6
 * JD-Core Version:    0.7.0.1
 */