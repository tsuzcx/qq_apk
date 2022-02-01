package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.au;
import com.tencent.mm.f.a.gu;
import com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
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
    gu localgu = new gu();
    localgu.fDj.fwv = paramITransmitKvData.getString("req_key");
    if (i == 31)
    {
      localgu.fDj.type = 0;
      if (i != 31) {
        break label382;
      }
      if ((j != 1) || (k != 1)) {
        break label359;
      }
      localgu.fDj.fwx = 1;
    }
    for (;;)
    {
      localgu.fDj.fww = str;
      localgu.fDj.isKinda = true;
      localgu.fDj.fDk = localObject.hashCode();
      EventCenter.instance.publish(localgu);
      localObject = new au();
      ((au)localObject).fwu.fwv = paramITransmitKvData.getString("req_key");
      ((au)localObject).fwu.fww = str;
      ((au)localObject).fwu.fwx = j;
      ((au)localObject).fwu.fwy = (l / 100.0D);
      ((au)localObject).fwu.isKinda = true;
      ((au)localObject).fwu.fwz = paramITransmitKvData.getInt("pay_fail_reason");
      ((au)localObject).fwu.fwA = paramITransmitKvData.getInt("pay_succ_action");
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(18723);
      return;
      if ((i != 32) && (i != 33) && (i != 65)) {
        break;
      }
      localgu.fDj.type = 1;
      break;
      label359:
      if ((j == 1) && (k == 2))
      {
        localgu.fDj.fwx = 2;
        continue;
        label382:
        localgu.fDj.fwx = j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.TransferNormalUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */