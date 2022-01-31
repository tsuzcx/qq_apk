package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public final class c
  implements a
{
  private String appId = null;
  b lMT = null;
  byte[] lMU;
  bcf lMV;
  public RealnameGuideHelper lMW;
  String lMg = null;
  int state = -1;
  
  final void L(Intent paramIntent)
  {
    if (this.lMT == null)
    {
      y.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
      return;
    }
    this.lMT.bfo();
    this.lMT.b(0, paramIntent);
  }
  
  public final void bfr()
  {
    if (this.state != 0)
    {
      y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", new Object[] { Integer.valueOf(this.state) });
      return;
    }
    if (this.lMT == null)
    {
      y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
      return;
    }
    new com.tencent.mm.plugin.luckymoney.appbrand.a.b(this.appId, this.lMg, this.lMU).b(new c.2(this));
  }
  
  public final void bfs()
  {
    if (this.lMT == null)
    {
      y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
      return;
    }
    bfw();
  }
  
  final void bfw()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_sendid", this.lMg);
    localIntent.putExtra("key_appid", this.appId);
    Bundle localBundle;
    if (this.lMV != null) {
      localBundle = new Bundle();
    }
    for (;;)
    {
      try
      {
        localBundle.putByteArray("key_data", this.lMV.toByteArray());
        localIntent.putExtras(localBundle);
        localIntent.putExtra("key_from", "value_open");
        this.lMT.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, localIntent, new c.3(this));
        return;
      }
      catch (IOException localIOException)
      {
        y.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", localIOException, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
        L(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
        return;
      }
      localIOException.putExtra("key_from", "value_query");
    }
  }
  
  public final void onDestroy()
  {
    y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
    this.lMT = null;
    this.lMV = null;
    this.lMW = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c
 * JD-Core Version:    0.7.0.1
 */