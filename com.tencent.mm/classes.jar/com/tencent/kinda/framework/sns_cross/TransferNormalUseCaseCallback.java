package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.gk;
import com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class TransferNormalUseCaseCallback
  implements ISnsUseCaseCallback
{
  private SnsServiceBean mBean;
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18723);
    Object localObject = this.mBean.getContext();
    if (("1".equals(paramITransmitKvData.getString("closeLoading"))) && ((localObject instanceof WalletBaseUI)))
    {
      if ((localObject instanceof RemittanceF2fDynamicCodeUI))
      {
        ((RemittanceF2fDynamicCodeUI)localObject).hideProgress();
        AppMethodBeat.o(18723);
        return;
      }
      ((WalletBaseUI)localObject).hideLoading();
      AppMethodBeat.o(18723);
      return;
    }
    String str = paramITransmitKvData.getString("transaction_id");
    int i = this.mBean.getPayScene();
    int j = paramITransmitKvData.getInt("retcode");
    long l = paramITransmitKvData.getLong("total_fee");
    int k = paramITransmitKvData.getInt("action");
    gk localgk = new gk();
    localgk.dtk.dmw = paramITransmitKvData.getString("req_key");
    if (i == 31)
    {
      localgk.dtk.type = 0;
      if (i != 31) {
        break label362;
      }
      if ((j != 1) || (k != 1)) {
        break label339;
      }
      localgk.dtk.dmy = 1;
    }
    for (;;)
    {
      localgk.dtk.dmx = str;
      localgk.dtk.isKinda = true;
      localgk.dtk.dtl = localObject.hashCode();
      a.IvT.l(localgk);
      localObject = new aq();
      ((aq)localObject).dmv.dmw = paramITransmitKvData.getString("req_key");
      ((aq)localObject).dmv.dmx = str;
      ((aq)localObject).dmv.dmy = j;
      ((aq)localObject).dmv.dmz = (l / 100.0D);
      ((aq)localObject).dmv.isKinda = true;
      ((aq)localObject).dmv.dmA = paramITransmitKvData.getInt("pay_fail_reason");
      a.IvT.l((b)localObject);
      AppMethodBeat.o(18723);
      return;
      if ((i != 32) && (i != 33)) {
        break;
      }
      localgk.dtk.type = 1;
      break;
      label339:
      if ((j == 1) && (k == 2))
      {
        localgk.dtk.dmy = 2;
        continue;
        label362:
        localgk.dtk.dmy = j;
      }
    }
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(18722);
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
    AppMethodBeat.o(18722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.TransferNormalUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */