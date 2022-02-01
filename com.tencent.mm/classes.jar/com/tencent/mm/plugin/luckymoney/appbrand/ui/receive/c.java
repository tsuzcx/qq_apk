package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.d.a;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.protocal.protobuf.cgz;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public final class c
  implements a
{
  private String appId = null;
  int state = -1;
  String vwq = null;
  b vxc = null;
  byte[] vxd;
  cgz vxe;
  public RealnameGuideHelper vxf;
  
  final void az(Intent paramIntent)
  {
    AppMethodBeat.i(65022);
    if (this.vxc == null)
    {
      ae.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.fail ui == null");
      AppMethodBeat.o(65022);
      return;
    }
    this.vxc.dkO();
    this.vxc.f(0, paramIntent);
    AppMethodBeat.o(65022);
  }
  
  public final void dkR()
  {
    AppMethodBeat.i(65020);
    if (this.state != 0)
    {
      ae.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onOpenBtnClick return state = %d", new Object[] { Integer.valueOf(this.state) });
      AppMethodBeat.o(65020);
      return;
    }
    if (this.vxc == null)
    {
      ae.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "openLuckyMoney ui == null");
      AppMethodBeat.o(65020);
      return;
    }
    new com.tencent.mm.plugin.luckymoney.appbrand.a.b(this.appId, this.vwq, this.vxd).b(new com.tencent.mm.vending.c.a()
    {
      private Void a(a.a<cgz> paramAnonymousa)
      {
        AppMethodBeat.i(182453);
        if ((paramAnonymousa.errType == 0) && (paramAnonymousa.errCode == 0))
        {
          ae.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB success");
          if (((cgz)paramAnonymousa.hQv).HsH != 0)
          {
            ae.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB error wxahb_status = [%d] errorwording = [%s]", new Object[] { Integer.valueOf(((cgz)paramAnonymousa.hQv).HsH), ((cgz)paramAnonymousa.hQv).HsS });
            localc = c.this;
            int i = ((cgz)paramAnonymousa.hQv).HsH;
            switch (i)
            {
            default: 
              localc.az(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{unknow open retun errCode:" + i + "}"));
            }
            for (;;)
            {
              AppMethodBeat.o(182453);
              return null;
              localc.az(new Intent().putExtra("result_error_code", 20001).putExtra("result_error_msg", "fail:the red packet is expired"));
              continue;
              localc.az(new Intent().putExtra("result_error_code", 20002).putExtra("result_error_msg", "fail:the red packet has been received completly"));
              continue;
              localc.az(new Intent().putExtra("result_error_code", 20003).putExtra("result_error_msg", "fail:risk control"));
            }
          }
          c localc = c.this;
          paramAnonymousa = (cgz)paramAnonymousa.hQv;
          if (localc.vxc == null) {
            ae.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.CgiOpenWxaHB end. ui == null");
          }
          for (;;)
          {
            AppMethodBeat.o(182453);
            return null;
            localc.vxe = paramAnonymousa;
            localc.vxc.dkT();
            if (localc.vxe.Gmp != null)
            {
              localc.vxf = new RealnameGuideHelper();
              localc.vxf.b(String.valueOf(localc.vxe.Gmp.FIU), localc.vxe.Gmp.vCG, localc.vxe.Gmp.kCZ, localc.vxe.Gmp.kDa, localc.vxe.Gmp.vCH, 1003);
              paramAnonymousa = localc.vxf;
              Bundle localBundle = new Bundle();
              localBundle.putString("realname_verify_process_jump_activity", ".appbrand.ui.receive.WxaLuckyMoneyReceiveUI");
              localBundle.putString("realname_verify_process_jump_plugin", "luckymoney");
              if (!paramAnonymousa.b(localc.vxc.dkN(), localBundle, new c.4(localc))) {
                localc.az(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{launch realname fail}}"));
              }
            }
            else
            {
              localc.dkW();
            }
          }
        }
        ae.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "CgiOpenWxaHB failed [%d, %d, %s]", new Object[] { Integer.valueOf(paramAnonymousa.errType), Integer.valueOf(paramAnonymousa.errCode), paramAnonymousa.errMsg });
        c.this.az(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{service error open errType = " + paramAnonymousa.errType + ",errCode" + paramAnonymousa.errCode + "}}"));
        AppMethodBeat.o(182453);
        return null;
      }
    });
    AppMethodBeat.o(65020);
  }
  
  public final void dkS()
  {
    AppMethodBeat.i(65019);
    if (this.vxc == null)
    {
      ae.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDetailBtnClick ui == null");
      AppMethodBeat.o(65019);
      return;
    }
    dkW();
    AppMethodBeat.o(65019);
  }
  
  final void dkW()
  {
    AppMethodBeat.i(65021);
    Intent localIntent = new Intent();
    localIntent.putExtra("key_sendid", this.vwq);
    localIntent.putExtra("key_appid", this.appId);
    Bundle localBundle;
    if (this.vxe != null) {
      localBundle = new Bundle();
    }
    for (;;)
    {
      try
      {
        localBundle.putByteArray("key_data", this.vxe.toByteArray());
        localIntent.putExtras(localBundle);
        localIntent.putExtra("key_from", "value_open");
        this.vxc.a(com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.b.class, localIntent, new d.a()
        {
          public final void g(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(65016);
            if (paramAnonymousInt == -1)
            {
              paramAnonymousIntent = c.this;
              if (paramAnonymousIntent.vxc == null)
              {
                ae.e("MicroMsg.WxaReceiveLuckyMoneyLogic", "WxaGetLuckyMoneyLogic.succeed ui == null");
                AppMethodBeat.o(65016);
                return;
              }
              paramAnonymousIntent.vxc.dkO();
              paramAnonymousIntent.vxc.f(-1, new Intent());
              AppMethodBeat.o(65016);
              return;
            }
            c.this.az(paramAnonymousIntent);
            AppMethodBeat.o(65016);
          }
        });
        AppMethodBeat.o(65021);
        return;
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.WxaReceiveLuckyMoneyLogic", localIOException, "goLuckyMoneyDetailUI WxaDetailResponse putByteArray error", new Object[0]);
        az(new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{byte detail response fail}}"));
        AppMethodBeat.o(65021);
        return;
      }
      localIOException.putExtra("key_from", "value_query");
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(65018);
    ae.i("MicroMsg.WxaReceiveLuckyMoneyLogic", "onDestroy ");
    this.vxc = null;
    this.vxe = null;
    this.vxf = null;
    AppMethodBeat.o(65018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.c
 * JD-Core Version:    0.7.0.1
 */