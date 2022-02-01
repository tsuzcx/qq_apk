package com.tencent.mm.plugin.luckymoney.appbrand;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI;

public final class b
  implements a
{
  public final void a(Activity paramActivity, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(174315);
    paramString1 = new Intent(paramActivity, WxaLuckyMoneyPrepareUI.class).putExtra("appId", paramString1).putExtra("defaultWishingWord", paramString2).putExtra("range", paramInt1);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt2, new com.tencent.mm.hellhoundlib.b.a()).cG(paramString1).aYi(), "com/tencent/mm/plugin/luckymoney/appbrand/IWxaLuckyMoneyImpl", "launchPrepareLuckyMoney", "(Landroid/app/Activity;Ljava/lang/String;ILjava/lang/String;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(174315);
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(174316);
    paramString1 = new Intent(paramActivity, WxaLuckyMoneyReceiveUI.class).putExtra("appId", paramString2).putExtra("sendId", paramString1);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramString1).aYi(), "com/tencent/mm/plugin/luckymoney/appbrand/IWxaLuckyMoneyImpl", "launchReceiveLuckyMoney", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(174316);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.b
 * JD-Core Version:    0.7.0.1
 */