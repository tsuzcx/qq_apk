package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.aoi;
import com.tencent.mm.sdk.platformtools.y;

final class HoneyPaySelectCardTypeUI$a$2
  implements View.OnClickListener
{
  HoneyPaySelectCardTypeUI$a$2(HoneyPaySelectCardTypeUI.a parama, aoi paramaoi) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.HoneyPaySelectCardTypeUI", "card type clicked");
    if (HoneyPaySelectCardTypeUI.a(this.lmw.lmq) != null)
    {
      HoneyPaySelectCardTypeUI.a(this.lmw.lmq, HoneyPaySelectCardTypeUI.a(this.lmw.lmq));
      return;
    }
    HoneyPaySelectCardTypeUI.a(this.lmw.lmq, this.lmv.ilo);
    HoneyPaySelectCardTypeUI.b(this.lmw.lmq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPaySelectCardTypeUI.a.2
 * JD-Core Version:    0.7.0.1
 */