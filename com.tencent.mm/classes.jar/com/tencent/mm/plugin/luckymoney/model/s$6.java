package com.tencent.mm.plugin.luckymoney.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class s$6
  implements ai.a
{
  public s$6(boolean paramBoolean, String paramString) {}
  
  public final int a(d paramd, m paramm)
  {
    AppMethodBeat.i(163575);
    ckc localckc = s.i(paramd);
    String str = MMApplicationContext.getContext().getString(a.i.lucky_money_default_wish);
    if (this.EAg) {}
    for (str = String.format("{\"retcode\":0,\"retmsg\":\"ok\",\"sendId\":\"1000039401201911277000281247819\",\"wishing\":\"%s\",\"isSender\":0,\"receiveStatus\":0,\"hbStatus\":2,\"statusMess\":\"给你发了一个红包\",\"hbType\":0,\"watermark\":\"\",\"scenePicSwitch\":1,\"preStrainFlag\":1,\"agree_duty\":{\"title\":\"\",\"service_protocol_wording\":\"\",\"service_protocol_url\":\"\",\"button_wording\":\"\",\"delay_expired_time\":0,\"agreed_flag\":1},\"sendUserName\":\"1@fackuser\",\"timingIdentifier\":\"BC1985F636763728826336B3251529F4\",\"showYearExpression\":1,\"expression_md5\":\"%s\",\"expression_type\":\"2\",\"showRecNormalExpression\":1}", new Object[] { str, this.EAh });; str = String.format("{\"retcode\":0,\"retmsg\":\"ok\",\"sendId\":\"1000039401201911277000281247819\",\"wishing\":\"%s\",\"isSender\":0,\"receiveStatus\":0,\"hbStatus\":2,\"statusMess\":\"给你发了一个红包\",\"hbType\":0,\"watermark\":\"\",\"scenePicSwitch\":1,\"preStrainFlag\":1,\"agree_duty\":{\"title\":\"\",\"service_protocol_wording\":\"\",\"service_protocol_url\":\"\",\"button_wording\":\"\",\"delay_expired_time\":0,\"agreed_flag\":1},\"sendUserName\":\"1@fackuser\",\"timingIdentifier\":\"BC1985F636763728826336B3251529F4\",\"showYearExpression\":1,\"expression_md5\":\"\",\"showRecNormalExpression\":1}", new Object[] { str }))
    {
      eae localeae = new eae();
      localeae.dc(str.getBytes());
      localckc.TrG = localeae;
      paramm.onGYNetEnd(0, 0, 0, "", paramd, null);
      AppMethodBeat.o(163575);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.s.6
 * JD-Core Version:    0.7.0.1
 */