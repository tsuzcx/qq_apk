package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.az;
import com.tencent.mm.autogen.a.hf;
import com.tencent.mm.plugin.remittance.ui.RemittanceF2fDynamicCodeUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
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
    hf localhf = new hf();
    localhf.hHZ.hAT = paramITransmitKvData.getString("req_key");
    if (i == 31)
    {
      localhf.hHZ.type = 0;
      if (i != 31) {
        break label376;
      }
      if ((j != 1) || (k != 1)) {
        break label353;
      }
      localhf.hHZ.hAV = 1;
    }
    for (;;)
    {
      localhf.hHZ.hAU = str;
      localhf.hHZ.isKinda = true;
      localhf.hHZ.hIa = localObject.hashCode();
      localhf.publish();
      localObject = new az();
      ((az)localObject).hAS.hAT = paramITransmitKvData.getString("req_key");
      ((az)localObject).hAS.hAU = str;
      ((az)localObject).hAS.hAV = j;
      ((az)localObject).hAS.hAW = (l / 100.0D);
      ((az)localObject).hAS.isKinda = true;
      ((az)localObject).hAS.hAX = paramITransmitKvData.getInt("pay_fail_reason");
      ((az)localObject).hAS.hAY = paramITransmitKvData.getInt("pay_succ_action");
      ((az)localObject).publish();
      AppMethodBeat.o(18723);
      return;
      if ((i != 32) && (i != 33) && (i != 65)) {
        break;
      }
      localhf.hHZ.type = 1;
      break;
      label353:
      if ((j == 1) && (k == 2))
      {
        localhf.hHZ.hAV = 2;
        continue;
        label376:
        localhf.hHZ.hAV = j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.TransferNormalUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */