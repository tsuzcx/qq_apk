package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.gn;
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
    gn localgn = new gn();
    localgn.dKu.dDL = paramITransmitKvData.getString("req_key");
    if (i == 31)
    {
      localgn.dKu.type = 0;
      if (i != 31) {
        break label362;
      }
      if ((j != 1) || (k != 1)) {
        break label339;
      }
      localgn.dKu.dDN = 1;
    }
    for (;;)
    {
      localgn.dKu.dDM = str;
      localgn.dKu.isKinda = true;
      localgn.dKu.dKv = localObject.hashCode();
      EventCenter.instance.publish(localgn);
      localObject = new as();
      ((as)localObject).dDK.dDL = paramITransmitKvData.getString("req_key");
      ((as)localObject).dDK.dDM = str;
      ((as)localObject).dDK.dDN = j;
      ((as)localObject).dDK.dDO = (l / 100.0D);
      ((as)localObject).dDK.isKinda = true;
      ((as)localObject).dDK.dDP = paramITransmitKvData.getInt("pay_fail_reason");
      EventCenter.instance.publish((IEvent)localObject);
      AppMethodBeat.o(18723);
      return;
      if ((i != 32) && (i != 33)) {
        break;
      }
      localgn.dKu.type = 1;
      break;
      label339:
      if ((j == 1) && (k == 2))
      {
        localgn.dKu.dDN = 2;
        continue;
        label362:
        localgn.dKu.dDN = j;
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