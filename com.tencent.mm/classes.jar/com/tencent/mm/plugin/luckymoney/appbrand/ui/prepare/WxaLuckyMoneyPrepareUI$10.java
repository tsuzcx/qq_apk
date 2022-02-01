package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLuckyMoneyPrepareUI$10
  implements MenuItem.OnMenuItemClickListener
{
  WxaLuckyMoneyPrepareUI$10(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(64956);
    this.yQV.setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
    this.yQV.finish();
    AppMethodBeat.o(64956);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.10
 * JD-Core Version:    0.7.0.1
 */