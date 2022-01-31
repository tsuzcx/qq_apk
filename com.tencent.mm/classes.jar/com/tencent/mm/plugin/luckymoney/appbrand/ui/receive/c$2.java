package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;

final class c$2
  implements a<Void, a.a<bji>>
{
  c$2(c paramc) {}
  
  private Void d(a.a<bji> parama)
  {
    AppMethodBeat.i(42125);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
      if (((bji)parama.fsN).xxD != 0)
      {
        ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[] { Integer.valueOf(((bji)parama.fsN).xxD), ((bji)parama.fsN).xxO });
        localc = this.okq;
        int i = ((bji)parama.fsN).xxD;
        switch (i)
        {
        default: 
          localc.ae(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
        }
        for (;;)
        {
          AppMethodBeat.o(42125);
          return null;
          localc.ae(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
          continue;
          localc.ae(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
          continue;
          localc.ae(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
        }
      }
      c localc = this.okq;
      parama = (bji)parama.fsN;
      if (localc.okm == null) {
        ab.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
      }
      for (;;)
      {
        AppMethodBeat.o(42125);
        return null;
        localc.oko = parama;
        localc.okm.bMT();
        if (localc.oko.wIk != null)
        {
          localc.okp = new RealnameGuideHelper();
          localc.okp.a(String.valueOf(localc.oko.wIk.wkQ), localc.oko.wIk.opB, localc.oko.wIk.opC, localc.oko.wIk.opD, localc.oko.wIk.opE, 1003);
          parama = localc.okp;
          Bundle localBundle = new Bundle();
          localBundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
          localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
          if (!parama.b(localc.okm.bMN(), localBundle, new c.4(localc))) {
            localc.ae(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
          }
        }
        else
        {
          localc.bMW();
        }
      }
    }
    ab.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.errMsg });
    this.okq.ae(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + parama.errType + ",errCode" + parama.errCode + "}}"));
    AppMethodBeat.o(42125);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.2
 * JD-Core Version:    0.7.0.1
 */