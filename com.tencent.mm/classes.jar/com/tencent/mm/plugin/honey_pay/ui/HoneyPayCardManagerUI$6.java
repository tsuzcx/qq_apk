package com.tencent.mm.plugin.honey_pay.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class HoneyPayCardManagerUI$6
  implements n.d
{
  HoneyPayCardManagerUI$6(HoneyPayCardManagerUI paramHoneyPayCardManagerUI, List paramList) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    HoneyPayCardManagerUI.a(this.lla, (Bankcard)this.llc.get(paramInt));
    y.i(this.lla.TAG, "select bankcard: %s, %s", new Object[] { HoneyPayCardManagerUI.g(this.lla).field_bindSerial, HoneyPayCardManagerUI.g(this.lla).field_bankcardTypeName });
    HoneyPayCardManagerUI.b(this.lla, HoneyPayCardManagerUI.c(this.lla));
    paramMenuItem = new bek();
    paramMenuItem.tzs = HoneyPayCardManagerUI.g(this.lla).field_desc;
    paramMenuItem.mOb = HoneyPayCardManagerUI.g(this.lla).field_bankcardType;
    paramMenuItem.tzu = HoneyPayCardManagerUI.g(this.lla).field_bindSerial;
    paramMenuItem.tzv = HoneyPayCardManagerUI.g(this.lla).field_bankcardTail;
    HoneyPayCardManagerUI.a(this.lla, paramMenuItem);
    HoneyPayCardManagerUI.d(this.lla);
    HoneyPayCardManagerUI.h(this.lla);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.6
 * JD-Core Version:    0.7.0.1
 */