package com.tencent.mm.plugin.luckymoney.appbrand;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;
import com.tencent.mm.ui.MMActivity;

public final class b
  implements a
{
  public final void a(MMActivity paramMMActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    paramMMActivity.startActivityForResult(new Intent(paramMMActivity, WxaLuckyMoneyPrepareUI.class).putExtra("appId", paramString1).putExtra("defaultWishingWord", paramString2).putExtra("range", paramInt1), paramInt2);
  }
  
  public final void a(MMActivity paramMMActivity, String paramString1, String paramString2, int paramInt)
  {
    paramMMActivity.startActivityForResult(new Intent(paramMMActivity, WxaLuckyMoneyReceiveUI.class).putExtra("appId", paramString2).putExtra("sendId", paramString1), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.b
 * JD-Core Version:    0.7.0.1
 */