package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.gf;
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
    Object localObject2 = new gf();
    ((gf)localObject2).djn.dcE = paramITransmitKvData.getString("req_key");
    if (i == 31)
    {
      ((gf)localObject2).djn.type = 0;
      if (i != 31) {
        break label349;
      }
      if ((j != 1) || (k != 1)) {
        break label326;
      }
      ((gf)localObject2).djn.dcG = 1;
    }
    for (;;)
    {
      ((gf)localObject2).djn.dcF = ((String)localObject1);
      ((gf)localObject2).djn.isKinda = true;
      a.ESL.l((b)localObject2);
      localObject2 = new ap();
      ((ap)localObject2).dcD.dcE = paramITransmitKvData.getString("req_key");
      ((ap)localObject2).dcD.dcF = ((String)localObject1);
      ((ap)localObject2).dcD.dcG = j;
      ((ap)localObject2).dcD.dcH = (l / 100.0D);
      ((ap)localObject2).dcD.isKinda = true;
      ((ap)localObject2).dcD.dcI = paramITransmitKvData.getInt("pay_fail_reason");
      a.ESL.l((b)localObject2);
      AppMethodBeat.o(18723);
      return;
      if ((i != 32) && (i != 33)) {
        break;
      }
      ((gf)localObject2).djn.type = 1;
      break;
      label326:
      if ((j == 1) && (k == 2))
      {
        ((gf)localObject2).djn.dcG = 2;
        continue;
        label349:
        ((gf)localObject2).djn.dcG = j;
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