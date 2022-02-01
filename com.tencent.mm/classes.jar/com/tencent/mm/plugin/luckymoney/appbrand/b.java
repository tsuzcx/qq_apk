package com.tencent.mm.plugin.luckymoney.appbrand;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;

public final class b
  implements a
{
  public final void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(174315);
    paramActivity.startActivityForResult(new Intent(paramActivity, WxaLuckyMoneyPrepareUI.class).putExtra("appId", paramString1).putExtra("defaultWishingWord", paramString2).putExtra("range", paramInt1), paramInt2);
    AppMethodBeat.o(174315);
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(174316);
    paramActivity.startActivityForResult(new Intent(paramActivity, WxaLuckyMoneyReceiveUI.class).putExtra("appId", paramString2).putExtra("sendId", paramString1), paramInt);
    AppMethodBeat.o(174316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.b
 * JD-Core Version:    0.7.0.1
 */