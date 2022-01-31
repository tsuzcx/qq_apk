package com.tencent.mm.plugin.honey_pay.ui;

import android.content.Context;
import com.tencent.mm.plugin.wallet_core.ui.m.a;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPaySelectCardTypeUI$a$1
  implements m.a
{
  HoneyPaySelectCardTypeUI$a$1(HoneyPaySelectCardTypeUI.a parama, aoi paramaoi, Context paramContext) {}
  
  public final void aEP()
  {
    y.i("MicroMsg.HoneyPaySelectCardTypeUI", "click oper text");
    if (!bk.bl(this.lmv.teh.url)) {
      e.l(this.val$context, this.lmv.teh.url, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a.1
 * JD-Core Version:    0.7.0.1
 */