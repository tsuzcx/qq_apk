package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayCardDetailUI$4
  implements View.OnClickListener
{
  HoneyPayCardDetailUI$4(HoneyPayCardDetailUI paramHoneyPayCardDetailUI) {}
  
  public final void onClick(View paramView)
  {
    y.d(this.lky.TAG, "click oper btn: %s", new Object[] { HoneyPayCardDetailUI.b(this.lky).url });
    if (!bk.bl(HoneyPayCardDetailUI.b(this.lky).url)) {
      e.l(this.lky.mController.uMN, HoneyPayCardDetailUI.b(this.lky).url, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardDetailUI.4
 * JD-Core Version:    0.7.0.1
 */