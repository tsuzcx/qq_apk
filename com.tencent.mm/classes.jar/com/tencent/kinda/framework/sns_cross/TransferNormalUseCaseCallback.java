package com.tencent.kinda.framework.sns_cross;

import android.content.Context;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.fy;
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
    AppMethodBeat.i(144611);
    Object localObject1 = this.mBean.getContext();
    if (("1".equals(paramITransmitKvData.getString("closeLoading"))) && ((localObject1 instanceof WalletBaseUI)))
    {
      if ((localObject1 instanceof RemittanceF2fDynamicCodeUI))
      {
        ((RemittanceF2fDynamicCodeUI)localObject1).hideProgress();
        AppMethodBeat.o(144611);
        return;
      }
      ((WalletBaseUI)localObject1).hideLoading();
      AppMethodBeat.o(144611);
      return;
    }
    localObject1 = paramITransmitKvData.getString("transaction_id");
    int i = this.mBean.getPayScene();
    int j = paramITransmitKvData.getInt("retcode");
    long l = paramITransmitKvData.getLong("total_fee");
    int k = paramITransmitKvData.getInt("action");
    Object localObject2 = new fy();
    ((fy)localObject2).cuq.cnI = paramITransmitKvData.getString("req_key");
    if (i == 31)
    {
      ((fy)localObject2).cuq.type = 0;
      if (i != 31) {
        break label331;
      }
      if ((j != 1) || (k != 1)) {
        break label308;
      }
      ((fy)localObject2).cuq.cnK = 1;
    }
    for (;;)
    {
      ((fy)localObject2).cuq.cnJ = ((String)localObject1);
      ((fy)localObject2).cuq.isKinda = true;
      a.ymk.l((b)localObject2);
      localObject2 = new al();
      ((al)localObject2).cnH.cnI = paramITransmitKvData.getString("req_key");
      ((al)localObject2).cnH.cnJ = ((String)localObject1);
      ((al)localObject2).cnH.cnK = j;
      ((al)localObject2).cnH.cnL = (l / 100.0D);
      ((al)localObject2).cnH.isKinda = true;
      a.ymk.l((b)localObject2);
      AppMethodBeat.o(144611);
      return;
      if ((i != 32) && (i != 33)) {
        break;
      }
      ((fy)localObject2).cuq.type = 1;
      break;
      label308:
      if ((j == 1) && (k == 2))
      {
        ((fy)localObject2).cuq.cnK = 2;
        continue;
        label331:
        ((fy)localObject2).cuq.cnK = j;
      }
    }
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(144610);
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
    AppMethodBeat.o(144610);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.TransferNormalUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */