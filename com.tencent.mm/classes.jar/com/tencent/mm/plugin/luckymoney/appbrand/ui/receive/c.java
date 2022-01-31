package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public final class c
  implements a
{
  private String appId = null;
  String ojA = null;
  b okm = null;
  byte[] okn;
  bji oko;
  public RealnameGuideHelper okp;
  int state = -1;
  
  final void ae(Intent paramIntent)
  {
    AppMethodBeat.i(42133);
    if (this.okm == null)
    {
      ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
      AppMethodBeat.o(42133);
      return;
    }
    this.okm.bMO();
    this.okm.e(0, paramIntent);
    AppMethodBeat.o(42133);
  }
  
  public final void bMR()
  {
    AppMethodBeat.i(42131);
    if (this.state != 0)
    {
      ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(42131);
      return;
    }
    if (this.okm == null)
    {
      ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
      AppMethodBeat.o(42131);
      return;
    }
    new com.tencent.mm.plugin.luckymoney.appbrand.a.b(this.appId, this.ojA, this.okn).b(new c.2(this));
    AppMethodBeat.o(42131);
  }
  
  public final void bMS()
  {
    AppMethodBeat.i(42130);
    if (this.okm == null)
    {
      ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
      AppMethodBeat.o(42130);
      return;
    }
    bMW();
    AppMethodBeat.o(42130);
  }
  
  final void bMW()
  {
    AppMethodBeat.i(42132);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_sendid", this.ojA);
    localIntent.putExtra("key_appid", this.appId);
    Bundle localBundle;
    if (this.oko != null) {
      localBundle = new Bundle();
    }
    for (;;)
    {
      try
      {
        localBundle.putByteArray("key_data", this.oko.toByteArray());
        localIntent.putExtras(localBundle);
        localIntent.putExtra("key_from", "value_open");
        this.okm.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, localIntent, new c.3(this));
        AppMethodBeat.o(42132);
        return;
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", localIOException, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
        ae(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
        AppMethodBeat.o(42132);
        return;
      }
      localIOException.putExtra("key_from", "value_query");
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(42129);
    ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
    this.okm = null;
    this.oko = null;
    this.okp = null;
    AppMethodBeat.o(42129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c
 * JD-Core Version:    0.7.0.1
 */