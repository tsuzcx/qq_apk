package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.sdk.platformtools.y;

final class c$3
  implements d.a
{
  c$3(c paramc) {}
  
  public final void c(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      paramIntent = this.lMX;
      if (paramIntent.lMT == null)
      {
        y.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
        return;
      }
      paramIntent.lMT.bfo();
      paramIntent.lMT.b(-1, new Intent());
      return;
    }
    this.lMX.L(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.3
 * JD-Core Version:    0.7.0.1
 */