package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.cro;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public final class c
  implements a
{
  private String appId = null;
  int state = -1;
  b vkX = null;
  byte[] vkY;
  cgf vkZ;
  String vkl = null;
  public RealnameGuideHelper vla;
  
  final void ay(Intent paramIntent)
  {
    AppMethodBeat.i(65022);
    if (this.vkX == null)
    {
      ad.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
      AppMethodBeat.o(65022);
      return;
    }
    this.vkX.dhP();
    this.vkX.f(0, paramIntent);
    AppMethodBeat.o(65022);
  }
  
  public final void dhS()
  {
    AppMethodBeat.i(65020);
    if (this.state != 0)
    {
      ad.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(65020);
      return;
    }
    if (this.vkX == null)
    {
      ad.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
      AppMethodBeat.o(65020);
      return;
    }
    new com.tencent.mm.plugin.luckymoney.appbrand.a.b(this.appId, this.vkl, this.vkY).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(a.a<cgf> paramAnonymousa)
      {
        AppMethodBeat.i(182453);
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ad.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
          if (((cgf)paramAnonymousa.hNC).GZg != 0)
          {
            ad.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[] { Integer.valueOf(((cgf)paramAnonymousa.hNC).GZg), ((cgf)paramAnonymousa.hNC).GZr });
            localc = c.this;
            int i = ((cgf)paramAnonymousa.hNC).GZg;
            switch (i)
            {
            default: 
              localc.ay(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
            }
            for (;;)
            {
              AppMethodBeat.o(182453);
              return null;
              localc.ay(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
              continue;
              localc.ay(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
              continue;
              localc.ay(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
            }
          }
          c localc = c.this;
          paramAnonymousa = (cgf)paramAnonymousa.hNC;
          if (localc.vkX == null) {
            ad.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
          }
          for (;;)
          {
            AppMethodBeat.o(182453);
            return null;
            localc.vkZ = paramAnonymousa;
            localc.vkX.dhU();
            if (localc.vkZ.FTQ != null)
            {
              localc.vla = new RealnameGuideHelper();
              localc.vla.b(String.valueOf(localc.vkZ.FTQ.Fqw), localc.vkZ.FTQ.vqB, localc.vkZ.FTQ.kzK, localc.vkZ.FTQ.kzL, localc.vkZ.FTQ.vqC, 1003);
              paramAnonymousa = localc.vla;
              Bundle localBundle = new Bundle();
              localBundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
              localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
              if (!paramAnonymousa.b(localc.vkX.dhO(), localBundle, new c.4(localc))) {
                localc.ay(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
              }
            }
            else
            {
              localc.dhX();
            }
          }
        }
        ad.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
        c.this.ay(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + paramAnonymousa.errType + ",errCode" + paramAnonymousa.errCode + "}}"));
        AppMethodBeat.o(182453);
        return null;
      }
    });
    AppMethodBeat.o(65020);
  }
  
  public final void dhT()
  {
    AppMethodBeat.i(65019);
    if (this.vkX == null)
    {
      ad.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
      AppMethodBeat.o(65019);
      return;
    }
    dhX();
    AppMethodBeat.o(65019);
  }
  
  final void dhX()
  {
    AppMethodBeat.i(65021);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_sendid", this.vkl);
    localIntent.putExtra("key_appid", this.appId);
    Bundle localBundle;
    if (this.vkZ != null) {
      localBundle = new Bundle();
    }
    for (;;)
    {
      try
      {
        localBundle.putByteArray("key_data", this.vkZ.toByteArray());
        localIntent.putExtras(localBundle);
        localIntent.putExtra("key_from", "value_open");
        this.vkX.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, localIntent, new d.a()
        {
          public final void g(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(65016);
            if (paramAnonymousInt == -1)
            {
              paramAnonymousIntent = c.this;
              if (paramAnonymousIntent.vkX == null)
              {
                ad.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                AppMethodBeat.o(65016);
                return;
              }
              paramAnonymousIntent.vkX.dhP();
              paramAnonymousIntent.vkX.f(-1, new Intent());
              AppMethodBeat.o(65016);
              return;
            }
            c.this.ay(paramAnonymousIntent);
            AppMethodBeat.o(65016);
          }
        });
        AppMethodBeat.o(65021);
        return;
      }
      catch (IOException localIOException)
      {
        ad.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", localIOException, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
        ay(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
        AppMethodBeat.o(65021);
        return;
      }
      localIOException.putExtra("key_from", "value_query");
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(65018);
    ad.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
    this.vkX = null;
    this.vkZ = null;
    this.vla = null;
    AppMethodBeat.o(65018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c
 * JD-Core Version:    0.7.0.1
 */