package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
{
  public static int f(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(189881);
    if (paramMallFunction != null)
    {
      c.eKB().aFW(paramMallFunction.jFZ);
      com.tencent.mm.plugin.wallet_core.model.mall.d.eKF().aFW(paramMallFunction.jFZ);
      if (paramMallFunction.DsT != null)
      {
        c.eKB();
        c.i(paramMallFunction);
      }
      if ("wxpay://bizmall/mobile_recharge".equals(paramMallFunction.dPb))
      {
        AppMethodBeat.o(189881);
        return 0;
      }
      if ("wxpay://bizmall/weixin_hongbao".equals(paramMallFunction.dPb))
      {
        AppMethodBeat.o(189881);
        return 4;
      }
      if ("wxpay://bizmall/weixin_scan_qrcode".equals(paramMallFunction.dPb))
      {
        AppMethodBeat.o(189881);
        return 8;
      }
      if ("wxpay://bizmall/weixin_transfer".equals(paramMallFunction.dPb))
      {
        AppMethodBeat.o(189881);
        return 5;
      }
      if ("wxpay://bizmall/weixin_offline_pay".equals(paramMallFunction.dPb))
      {
        AppMethodBeat.o(189881);
        return 6;
      }
      if ("wxpay://bizmall/old_mobile_recharge".equals(paramMallFunction.dPb))
      {
        AppMethodBeat.o(189881);
        return 7;
      }
      if (!bu.isNullOrNil(paramMallFunction.uEo))
      {
        AppMethodBeat.o(189881);
        return 1;
      }
      if ("wxpay://bizmall/f2f_hongbao".equals(paramMallFunction.dPb))
      {
        AppMethodBeat.o(189881);
        return 9;
      }
      ae.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
      AppMethodBeat.o(189881);
      return 2;
    }
    AppMethodBeat.o(189881);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.d
 * JD-Core Version:    0.7.0.1
 */