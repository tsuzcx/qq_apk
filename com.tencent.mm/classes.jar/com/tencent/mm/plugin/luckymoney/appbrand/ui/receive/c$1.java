package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.Intent;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.protocal.c.bjo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.c.a;

final class c$1
  implements a<Void, a.a<bjo>>
{
  c$1(c paramc) {}
  
  private Void d(a.a<bjo> parama)
  {
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed, wxahb_status = [%d],receive_status = [%d],sendId = [%s]", new Object[] { Integer.valueOf(((bjo)parama.ecw).txx), Integer.valueOf(((bjo)parama.ecw).lLk), this.lMX.lMg });
      if ((((bjo)parama.ecw).txx != 1) && (((bjo)parama.ecw).txw != null)) {
        this.lMX.lMU = ((bjo)parama.ecw).txw.toByteArray();
      }
      this.lMX.state = ((bjo)parama.ecw).txx;
      Object localObject = this.lMX;
      parama = (bjo)parama.ecw;
      if (((c)localObject).lMT == null)
      {
        y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB succeed but ui == null");
        return null;
      }
      int i;
      if ((parama.txG == 1) && (parama.lLl == 0)) {
        i = 1;
      }
      while (i != 0)
      {
        y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onLuckyMoneyReceived shouldSkipToDetailUI");
        ((c)localObject).bfw();
        return null;
        if (parama.lLk == 2) {
          i = 1;
        } else {
          i = 0;
        }
      }
      String str1;
      String str2;
      String str3;
      boolean bool1;
      boolean bool2;
      if (parama.txx == 1)
      {
        localObject = ((c)localObject).lMT;
        str1 = parama.txE;
        str2 = parama.txF;
        i = parama.txx;
        str3 = parama.txI;
        if (parama.txG == 1)
        {
          bool1 = true;
          if (parama.lLl != 1) {
            break label298;
          }
        }
        label298:
        for (bool2 = true;; bool2 = false)
        {
          ((b)localObject).a(str1, str2, i, str3, bool1, bool2);
          return null;
          bool1 = false;
          break;
        }
      }
      if (parama.txx == 0)
      {
        localObject = ((c)localObject).lMT;
        str1 = parama.txE;
        str2 = parama.txF;
        str3 = parama.ioU;
        String str4 = parama.lLm;
        if (parama.txG == 1)
        {
          bool1 = true;
          if (parama.lLl != 1) {
            break label388;
          }
        }
        label388:
        for (bool2 = true;; bool2 = false)
        {
          ((b)localObject).a(str1, str2, str3, str4, bool1, bool2);
          return null;
          bool1 = false;
          break;
        }
      }
      y.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "back.resp.wxahb_status is invalid.resp. wxahb_status = [%d] receive_status = [%d] hb_type = [%d]", new Object[] { Integer.valueOf(parama.txx), Integer.valueOf(parama.lLk), Integer.valueOf(parama.lLl) });
      return null;
    }
    y.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiReceiveWxaHB failed [%d, %d, %s]", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode), parama.aox });
    this.lMX.L(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error Receive errType = " + parama.errType + ",errCode" + parama.errCode + "}}"));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c.1
 * JD-Core Version:    0.7.0.1
 */