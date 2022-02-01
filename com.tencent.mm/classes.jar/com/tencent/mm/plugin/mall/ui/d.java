package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d
{
  public static int f(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(213560);
    if (paramMallFunction != null)
    {
      c.fSg().aVv(paramMallFunction.kHR);
      com.tencent.mm.plugin.wallet_core.model.mall.d.fSk().aVv(paramMallFunction.kHR);
      if (paramMallFunction.Icf != null)
      {
        c.fSg();
        c.i(paramMallFunction);
      }
      if ("wxpay://bizmall/mobile_recharge".equals(paramMallFunction.egX))
      {
        AppMethodBeat.o(213560);
        return 0;
      }
      if ("wxpay://bizmall/weixin_hongbao".equals(paramMallFunction.egX))
      {
        AppMethodBeat.o(213560);
        return 4;
      }
      if ("wxpay://bizmall/weixin_scan_qrcode".equals(paramMallFunction.egX))
      {
        AppMethodBeat.o(213560);
        return 8;
      }
      if ("wxpay://bizmall/weixin_transfer".equals(paramMallFunction.egX))
      {
        AppMethodBeat.o(213560);
        return 5;
      }
      if ("wxpay://bizmall/weixin_offline_pay".equals(paramMallFunction.egX))
      {
        AppMethodBeat.o(213560);
        return 6;
      }
      if ("wxpay://bizmall/old_mobile_recharge".equals(paramMallFunction.egX))
      {
        AppMethodBeat.o(213560);
        return 7;
      }
      if (!Util.isNullOrNil(paramMallFunction.h5Url))
      {
        AppMethodBeat.o(213560);
        return 1;
      }
      if ("wxpay://bizmall/f2f_hongbao".equals(paramMallFunction.egX))
      {
        AppMethodBeat.o(213560);
        return 9;
      }
      Log.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
      AppMethodBeat.o(213560);
      return 2;
    }
    AppMethodBeat.o(213560);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.d
 * JD-Core Version:    0.7.0.1
 */