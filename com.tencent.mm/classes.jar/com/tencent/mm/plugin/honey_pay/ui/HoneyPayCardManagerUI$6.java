package com.tencent.mm.plugin.honey_pay.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

final class HoneyPayCardManagerUI$6
  implements n.d
{
  HoneyPayCardManagerUI$6(HoneyPayCardManagerUI paramHoneyPayCardManagerUI, List paramList) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(41798);
    HoneyPayCardManagerUI.a(this.nIw, (Bankcard)this.nIy.get(paramInt));
    ab.i(this.nIw.TAG, "select bankcard: %s, %s", new Object[] { HoneyPayCardManagerUI.h(this.nIw).field_bindSerial, HoneyPayCardManagerUI.h(this.nIw).field_bankcardTypeName });
    HoneyPayCardManagerUI.b(this.nIw, HoneyPayCardManagerUI.c(this.nIw));
    paramMenuItem = new bme();
    paramMenuItem.xAA = HoneyPayCardManagerUI.h(this.nIw).field_desc;
    paramMenuItem.poq = HoneyPayCardManagerUI.h(this.nIw).field_bankcardType;
    paramMenuItem.xAC = HoneyPayCardManagerUI.h(this.nIw).field_bindSerial;
    paramMenuItem.xAD = HoneyPayCardManagerUI.h(this.nIw).field_bankcardTail;
    HoneyPayCardManagerUI.a(this.nIw, paramMenuItem);
    HoneyPayCardManagerUI.d(this.nIw);
    HoneyPayCardManagerUI.i(this.nIw);
    AppMethodBeat.o(41798);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI.6
 * JD-Core Version:    0.7.0.1
 */