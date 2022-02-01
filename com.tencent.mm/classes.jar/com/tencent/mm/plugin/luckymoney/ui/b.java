package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KUserService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class b
  implements KUserService
{
  public void updateUserInfo(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(213354);
    Log.i("KindaUserInfoService", "updateUserInfo");
    am localam = t.fQI().fRN();
    localam.field_is_reg = paramITransmitKvData.getInt("is_reg");
    localam.field_true_name = Util.nullAs(paramITransmitKvData.getString("true_name"), "");
    if (paramITransmitKvData.getInt("icard_user_flag") == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localam.field_isDomesticUser = bool;
      localam.field_cre_name = Util.nullAs(paramITransmitKvData.getString("cre_name"), "");
      localam.field_cre_type = Util.getInt(paramITransmitKvData.getString("cre_type"), -1);
      localam.field_main_card_bind_serialno = Util.nullAs(paramITransmitKvData.getString("last_card_bind_serialno"), "");
      s.fOg();
      s.fOh().a(localam);
      AppMethodBeat.o(213354);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.b
 * JD-Core Version:    0.7.0.1
 */