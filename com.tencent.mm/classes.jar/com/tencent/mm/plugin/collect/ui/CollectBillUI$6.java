package com.tencent.mm.plugin.collect.ui;

import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;

final class CollectBillUI$6
  implements MMSwitchBtn.a
{
  CollectBillUI$6(CollectBillUI paramCollectBillUI) {}
  
  public final void cr(boolean paramBoolean)
  {
    y.i("MicroMsg.CollectBillUI", "update switch: %B", new Object[] { Boolean.valueOf(paramBoolean) });
    CollectBillUI.j(this.iKD).setCheck(paramBoolean);
    CollectBillUI.k(this.iKD).setCheck(paramBoolean);
    if (paramBoolean)
    {
      CollectBillUI.a(this.iKD, CollectBillUI.l(this.iKD) | 0x8000);
      CollectBillUI.m(this.iKD).setImageResource(a.h.collect_sound_on);
      CollectBillUI.n(this.iKD).setImageResource(a.h.collect_sound_on);
      Toast.makeText(this.iKD.mController.uMN, a.i.collect_main_open_ring_tone_tips, 1).show();
      com.tencent.mm.plugin.report.service.h.nFQ.f(13944, new Object[] { Integer.valueOf(11) });
    }
    for (int i = 1;; i = 2)
    {
      g.DQ();
      g.DP().Dz().o(147457, Long.valueOf(CollectBillUI.l(this.iKD)));
      axo localaxo = new axo();
      localaxo.nFj = i;
      ((j)g.r(j.class)).Fv().b(new i.a(209, localaxo));
      if (i != 1) {
        break;
      }
      a.aEp().aEs();
      return;
      CollectBillUI.a(this.iKD, CollectBillUI.l(this.iKD) & 0xFFFF7FFF);
      CollectBillUI.m(this.iKD).setImageResource(a.h.collect_sound_off);
      CollectBillUI.n(this.iKD).setImageResource(a.h.collect_sound_off);
      Toast.makeText(this.iKD.mController.uMN, a.i.collect_main_close_ring_tone_tips, 1).show();
      com.tencent.mm.plugin.report.service.h.nFQ.f(13944, new Object[] { Integer.valueOf(12) });
    }
    a.aEp().aEt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillUI.6
 * JD-Core Version:    0.7.0.1
 */