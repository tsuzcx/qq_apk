package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.cmn;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public final class c
  implements a
{
  private String appId = null;
  int state = -1;
  String uhB = null;
  b uip = null;
  byte[] uiq;
  cbo uir;
  public RealnameGuideHelper uis;
  
  final void at(Intent paramIntent)
  {
    AppMethodBeat.i(65022);
    if (this.uip == null)
    {
      ac.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
      AppMethodBeat.o(65022);
      return;
    }
    this.uip.cYD();
    this.uip.f(0, paramIntent);
    AppMethodBeat.o(65022);
  }
  
  public final void cYG()
  {
    AppMethodBeat.i(65020);
    if (this.state != 0)
    {
      ac.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(65020);
      return;
    }
    if (this.uip == null)
    {
      ac.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
      AppMethodBeat.o(65020);
      return;
    }
    new com.tencent.mm.plugin.luckymoney.appbrand.a.b(this.appId, this.uhB, this.uiq).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(c.a<cbo> paramAnonymousa)
      {
        AppMethodBeat.i(182453);
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ac.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
          if (((cbo)paramAnonymousa.hvj).Fpw != 0)
          {
            ac.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[] { Integer.valueOf(((cbo)paramAnonymousa.hvj).Fpw), ((cbo)paramAnonymousa.hvj).FpH });
            localc = c.this;
            int i = ((cbo)paramAnonymousa.hvj).Fpw;
            switch (i)
            {
            default: 
              localc.at(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
            }
            for (;;)
            {
              AppMethodBeat.o(182453);
              return null;
              localc.at(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
              continue;
              localc.at(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
              continue;
              localc.at(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
            }
          }
          c localc = c.this;
          paramAnonymousa = (cbo)paramAnonymousa.hvj;
          if (localc.uip == null) {
            ac.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
          }
          for (;;)
          {
            AppMethodBeat.o(182453);
            return null;
            localc.uir = paramAnonymousa;
            localc.uip.cYI();
            if (localc.uir.EmH != null)
            {
              localc.uis = new RealnameGuideHelper();
              localc.uis.b(String.valueOf(localc.uir.EmH.DLr), localc.uir.EmH.unV, localc.uir.EmH.unW, localc.uir.EmH.unX, localc.uir.EmH.unY, 1003);
              paramAnonymousa = localc.uis;
              Bundle localBundle = new Bundle();
              localBundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
              localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
              if (!paramAnonymousa.b(localc.uip.cYC(), localBundle, new c.4(localc))) {
                localc.at(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
              }
            }
            else
            {
              localc.cYL();
            }
          }
        }
        ac.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
        c.this.at(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + paramAnonymousa.errType + ",errCode" + paramAnonymousa.errCode + "}}"));
        AppMethodBeat.o(182453);
        return null;
      }
    });
    AppMethodBeat.o(65020);
  }
  
  public final void cYH()
  {
    AppMethodBeat.i(65019);
    if (this.uip == null)
    {
      ac.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
      AppMethodBeat.o(65019);
      return;
    }
    cYL();
    AppMethodBeat.o(65019);
  }
  
  final void cYL()
  {
    AppMethodBeat.i(65021);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_sendid", this.uhB);
    localIntent.putExtra("key_appid", this.appId);
    Bundle localBundle;
    if (this.uir != null) {
      localBundle = new Bundle();
    }
    for (;;)
    {
      try
      {
        localBundle.putByteArray("key_data", this.uir.toByteArray());
        localIntent.putExtras(localBundle);
        localIntent.putExtra("key_from", "value_open");
        this.uip.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, localIntent, new d.a()
        {
          public final void g(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(65016);
            if (paramAnonymousInt == -1)
            {
              paramAnonymousIntent = c.this;
              if (paramAnonymousIntent.uip == null)
              {
                ac.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                AppMethodBeat.o(65016);
                return;
              }
              paramAnonymousIntent.uip.cYD();
              paramAnonymousIntent.uip.f(-1, new Intent());
              AppMethodBeat.o(65016);
              return;
            }
            c.this.at(paramAnonymousIntent);
            AppMethodBeat.o(65016);
          }
        });
        AppMethodBeat.o(65021);
        return;
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", localIOException, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
        at(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
        AppMethodBeat.o(65021);
        return;
      }
      localIOException.putExtra("key_from", "value_query");
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(65018);
    ac.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
    this.uip = null;
    this.uir = null;
    this.uis = null;
    AppMethodBeat.o(65018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c
 * JD-Core Version:    0.7.0.1
 */