package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.eme;
import com.tencent.mm.protocal.protobuf.emu;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class c
  implements a
{
  String CAf = null;
  b KnX = null;
  byte[] KnY;
  dyx KnZ;
  public RealnameGuideHelper Koa;
  private String appId = null;
  int state = -1;
  
  final void aZ(Intent paramIntent)
  {
    AppMethodBeat.i(65022);
    if (this.KnX == null)
    {
      Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
      AppMethodBeat.o(65022);
      return;
    }
    this.KnX.fWu();
    this.KnX.i(0, paramIntent);
    AppMethodBeat.o(65022);
  }
  
  final void fWE()
  {
    AppMethodBeat.i(65021);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_sendid", this.CAf);
    localIntent.putExtra("key_appid", this.appId);
    Bundle localBundle;
    if (this.KnZ != null) {
      localBundle = new Bundle();
    }
    for (;;)
    {
      try
      {
        localBundle.putByteArray("key_data", this.KnZ.toByteArray());
        localIntent.putExtras(localBundle);
        localIntent.putExtra("key_from", "value_open");
        this.KnX.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, localIntent, new d.a()
        {
          public final void j(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(65016);
            if (paramAnonymousInt == -1)
            {
              paramAnonymousIntent = c.this;
              if (paramAnonymousIntent.KnX == null)
              {
                Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                AppMethodBeat.o(65016);
                return;
              }
              paramAnonymousIntent.KnX.fWu();
              paramAnonymousIntent.KnX.i(-1, new Intent());
              AppMethodBeat.o(65016);
              return;
            }
            c.this.aZ(paramAnonymousIntent);
            AppMethodBeat.o(65016);
          }
        });
        AppMethodBeat.o(65021);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", localIOException, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
        aZ(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
        AppMethodBeat.o(65021);
        return;
      }
      localIOException.putExtra("key_from", "value_query");
    }
  }
  
  public final void fWy()
  {
    AppMethodBeat.i(65020);
    if (this.state != 0)
    {
      Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(65020);
      return;
    }
    if (this.KnX == null)
    {
      Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
      AppMethodBeat.o(65020);
      return;
    }
    new com.tencent.mm.plugin.luckymoney.appbrand.a.b(this.appId, this.CAf, this.KnY).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(b.a<dyx> paramAnonymousa)
      {
        AppMethodBeat.i(182453);
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
          if (((dyx)paramAnonymousa.ott).abdD != 0)
          {
            Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[] { Integer.valueOf(((dyx)paramAnonymousa.ott).abdD), ((dyx)paramAnonymousa.ott).abdN });
            localc = c.this;
            int i = ((dyx)paramAnonymousa.ott).abdD;
            switch (i)
            {
            default: 
              localc.aZ(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
            }
            for (;;)
            {
              AppMethodBeat.o(182453);
              return null;
              localc.aZ(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
              continue;
              localc.aZ(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
              continue;
              localc.aZ(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
            }
          }
          c localc = c.this;
          paramAnonymousa = (dyx)paramAnonymousa.ott;
          if (localc.KnX == null) {
            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
          }
          for (;;)
          {
            AppMethodBeat.o(182453);
            return null;
            localc.KnZ = paramAnonymousa;
            localc.KnX.fWA();
            if (localc.KnZ.Zgn != null)
            {
              localc.Koa = new RealnameGuideHelper();
              localc.Koa.a(String.valueOf(localc.KnZ.Zgn.YAF), localc.KnZ.Zgn.KuO, localc.KnZ.Zgn.rGU, localc.KnZ.Zgn.right_button_wording, localc.KnZ.Zgn.KuP, 1003);
              paramAnonymousa = localc.Koa;
              Bundle localBundle = new Bundle();
              localBundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
              localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
              if (!paramAnonymousa.b(localc.KnX.fWt(), localBundle, new c.4(localc))) {
                localc.aZ(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
              }
            }
            else
            {
              localc.fWE();
            }
          }
        }
        Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
        c.this.aZ(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + paramAnonymousa.errType + ",errCode" + paramAnonymousa.errCode + "}}"));
        AppMethodBeat.o(182453);
        return null;
      }
    });
    AppMethodBeat.o(65020);
  }
  
  public final void fWz()
  {
    AppMethodBeat.i(65019);
    if (this.KnX == null)
    {
      Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
      AppMethodBeat.o(65019);
      return;
    }
    fWE();
    AppMethodBeat.o(65019);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(65018);
    Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
    this.KnX = null;
    this.KnZ = null;
    this.Koa = null;
    AppMethodBeat.o(65018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c
 * JD-Core Version:    0.7.0.1
 */