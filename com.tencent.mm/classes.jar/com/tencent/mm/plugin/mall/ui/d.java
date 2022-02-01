package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
{
  public static int f(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(199046);
    if (paramMallFunction != null)
    {
      c.eGT().aEC(paramMallFunction.jDb);
      com.tencent.mm.plugin.wallet_core.model.mall.d.eGX().aEC(paramMallFunction.jDb);
      if (paramMallFunction.Dbp != null)
      {
        c.eGT();
        c.i(paramMallFunction);
      }
      if ("wxpay://bizmall/mobile_recharge".equals(paramMallFunction.dNL))
      {
        AppMethodBeat.o(199046);
        return 0;
      }
      if ("wxpay://bizmall/weixin_hongbao".equals(paramMallFunction.dNL))
      {
        AppMethodBeat.o(199046);
        return 4;
      }
      if ("wxpay://bizmall/weixin_scan_qrcode".equals(paramMallFunction.dNL))
      {
        AppMethodBeat.o(199046);
        return 8;
      }
      if ("wxpay://bizmall/weixin_transfer".equals(paramMallFunction.dNL))
      {
        AppMethodBeat.o(199046);
        return 5;
      }
      if ("wxpay://bizmall/weixin_offline_pay".equals(paramMallFunction.dNL))
      {
        AppMethodBeat.o(199046);
        return 6;
      }
      if ("wxpay://bizmall/old_mobile_recharge".equals(paramMallFunction.dNL))
      {
        AppMethodBeat.o(199046);
        return 7;
      }
      if (!bt.isNullOrNil(paramMallFunction.usV))
      {
        AppMethodBeat.o(199046);
        return 1;
      }
      if ("wxpay://bizmall/f2f_hongbao".equals(paramMallFunction.dNL))
      {
        AppMethodBeat.o(199046);
        return 9;
      }
      ad.w("MicroMsg.MallIndexUIHelper", "doSelectFunction no jump");
      AppMethodBeat.o(199046);
      return 2;
    }
    AppMethodBeat.o(199046);
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.d
 * JD-Core Version:    0.7.0.1
 */