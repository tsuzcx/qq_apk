package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.dkk;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class c
  implements a
{
  private String appId = null;
  int state = -1;
  String yQE = null;
  b yRr = null;
  byte[] yRs;
  cxg yRt;
  public RealnameGuideHelper yRu;
  
  final void aG(Intent paramIntent)
  {
    AppMethodBeat.i(65022);
    if (this.yRr == null)
    {
      Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
      AppMethodBeat.o(65022);
      return;
    }
    this.yRr.eeG();
    this.yRr.f(0, paramIntent);
    AppMethodBeat.o(65022);
  }
  
  public final void eeJ()
  {
    AppMethodBeat.i(65020);
    if (this.state != 0)
    {
      Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(65020);
      return;
    }
    if (this.yRr == null)
    {
      Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
      AppMethodBeat.o(65020);
      return;
    }
    new com.tencent.mm.plugin.luckymoney.appbrand.a.b(this.appId, this.yQE, this.yRs).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(c.a<cxg> paramAnonymousa)
      {
        AppMethodBeat.i(182453);
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
          if (((cxg)paramAnonymousa.iLC).MBD != 0)
          {
            Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[] { Integer.valueOf(((cxg)paramAnonymousa.iLC).MBD), ((cxg)paramAnonymousa.iLC).MBO });
            localc = c.this;
            int i = ((cxg)paramAnonymousa.iLC).MBD;
            switch (i)
            {
            default: 
              localc.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
            }
            for (;;)
            {
              AppMethodBeat.o(182453);
              return null;
              localc.aG(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
              continue;
              localc.aG(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
              continue;
              localc.aG(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
            }
          }
          c localc = c.this;
          paramAnonymousa = (cxg)paramAnonymousa.iLC;
          if (localc.yRr == null) {
            Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
          }
          for (;;)
          {
            AppMethodBeat.o(182453);
            return null;
            localc.yRt = paramAnonymousa;
            localc.yRr.eeL();
            if (localc.yRt.LgT != null)
            {
              localc.yRu = new RealnameGuideHelper();
              localc.yRu.b(String.valueOf(localc.yRt.LgT.KCl), localc.yRt.LgT.yXJ, localc.yRt.LgT.lHA, localc.yRt.LgT.lHB, localc.yRt.LgT.yXK, 1003);
              paramAnonymousa = localc.yRu;
              Bundle localBundle = new Bundle();
              localBundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
              localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
              if (!paramAnonymousa.b(localc.yRr.eeF(), localBundle, new c.4(localc))) {
                localc.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
              }
            }
            else
            {
              localc.eeO();
            }
          }
        }
        Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
        c.this.aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + paramAnonymousa.errType + ",errCode" + paramAnonymousa.errCode + "}}"));
        AppMethodBeat.o(182453);
        return null;
      }
    });
    AppMethodBeat.o(65020);
  }
  
  public final void eeK()
  {
    AppMethodBeat.i(65019);
    if (this.yRr == null)
    {
      Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
      AppMethodBeat.o(65019);
      return;
    }
    eeO();
    AppMethodBeat.o(65019);
  }
  
  final void eeO()
  {
    AppMethodBeat.i(65021);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_sendid", this.yQE);
    localIntent.putExtra("key_appid", this.appId);
    Bundle localBundle;
    if (this.yRt != null) {
      localBundle = new Bundle();
    }
    for (;;)
    {
      try
      {
        localBundle.putByteArray("key_data", this.yRt.toByteArray());
        localIntent.putExtras(localBundle);
        localIntent.putExtra("key_from", "value_open");
        this.yRr.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, localIntent, new d.a()
        {
          public final void g(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(65016);
            if (paramAnonymousInt == -1)
            {
              paramAnonymousIntent = c.this;
              if (paramAnonymousIntent.yRr == null)
              {
                Log.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                AppMethodBeat.o(65016);
                return;
              }
              paramAnonymousIntent.yRr.eeG();
              paramAnonymousIntent.yRr.f(-1, new Intent());
              AppMethodBeat.o(65016);
              return;
            }
            c.this.aG(paramAnonymousIntent);
            AppMethodBeat.o(65016);
          }
        });
        AppMethodBeat.o(65021);
        return;
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", localIOException, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
        aG(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
        AppMethodBeat.o(65021);
        return;
      }
      localIOException.putExtra("key_from", "value_query");
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(65018);
    Log.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
    this.yRr = null;
    this.yRt = null;
    this.yRu = null;
    AppMethodBeat.o(65018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c
 * JD-Core Version:    0.7.0.1
 */