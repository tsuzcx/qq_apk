package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aq;
import com.tencent.mm.g.a.gg;
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
    Object localObject1 = this.mBean.getContext();
    if (("1".equals(paramITransmitKvData.getString("closeLoading"))) && ((localObject1 instanceof WalletBaseUI)))
    {
      if ((localObject1 instanceof RemittanceF2fDynamicCodeUI))
      {
        ((RemittanceF2fDynamicCodeUI)localObject1).hideProgress();
        AppMethodBeat.o(18723);
        return;
      }
      ((WalletBaseUI)localObject1).hideLoading();
      AppMethodBeat.o(18723);
      return;
    }
    localObject1 = paramITransmitKvData.getString("transaction_id");
    int i = this.mBean.getPayScene();
    int j = paramITransmitKvData.getInt("retcode");
    long l = paramITransmitKvData.getLong("total_fee");
    int k = paramITransmitKvData.getInt("action");
    Object localObject2 = new gg();
    ((gg)localObject2).dgI.dac = paramITransmitKvData.getString("req_key");
    if (i == 31)
    {
      ((gg)localObject2).dgI.type = 0;
      if (i != 31) {
        break label349;
      }
      if ((j != 1) || (k != 1)) {
        break label326;
      }
      ((gg)localObject2).dgI.dae = 1;
    }
    for (;;)
    {
      ((gg)localObject2).dgI.dad = ((String)localObject1);
      ((gg)localObject2).dgI.isKinda = true;
      a.GpY.l((b)localObject2);
      localObject2 = new aq();
      ((aq)localObject2).dab.dac = paramITransmitKvData.getString("req_key");
      ((aq)localObject2).dab.dad = ((String)localObject1);
      ((aq)localObject2).dab.dae = j;
      ((aq)localObject2).dab.daf = (l / 100.0D);
      ((aq)localObject2).dab.isKinda = true;
      ((aq)localObject2).dab.dag = paramITransmitKvData.getInt("pay_fail_reason");
      a.GpY.l((b)localObject2);
      AppMethodBeat.o(18723);
      return;
      if ((i != 32) && (i != 33)) {
        break;
      }
      ((gg)localObject2).dgI.type = 1;
      break;
      label326:
      if ((j == 1) && (k == 2))
      {
        ((gg)localObject2).dgI.dae = 2;
        continue;
        label349:
        ((gg)localObject2).dgI.dae = j;
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