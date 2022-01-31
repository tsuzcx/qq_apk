package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.c.bcf;
import com.tencent.mm.protocal.c.bjg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;

final class c$2
  implements a<Void, a.a<bcf>>
{
  c$2(c paramc) {}
  
  private Void d(a.a<bcf> parama)
  {
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
      c localc;
      if (((bcf)parama.ecw).txx != 0)
      {
        y.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[] { Integer.valueOf(((bcf)parama.ecw).txx), ((bcf)parama.ecw).txI });
        localc = this.lMX;
        int i = ((bcf)parama.ecw).txx;
        switch (i)
        {
        default: 
          localc.L(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
        }
      }
      Bundle localBundle;
      do
      {
        return null;
        localc.L(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
        return null;
        localc.L(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
        return null;
        localc.L(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
        return null;
        localc = this.lMX;
        parama = (bcf)parama.ecw;
        if (localc.lMT == null)
        {
          y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
          return null;
        }
        localc.lMV = parama;
        localc.lMT.bft();
        if (localc.lMV.sTP == null) {
          break;
        }
        localc.lMW = new RealnameGuideHelper();
        localc.lMW.a(String.valueOf(localc.lMV.sTP.ssk), localc.lMV.sTP.lRD, localc.lMV.sTP.lRE, localc.lMV.sTP.lRF, localc.lMV.sTP.lRG, 1003);
        parama = localc.lMW;
        localBundle = new Bundle();
        localBundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
        localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
      } while (parama.b(localc.lMT.bfn(), localBundle, new c.4(localc)));
      localc.L(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
      return null;
      localc.bfw();
      return null;
    }
    y.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.aox });
    this.lMX.L(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + parama.errType + ",errCode" + parama.errCode + "}}"));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.2
 * JD-Core Version:    0.7.0.1
 */