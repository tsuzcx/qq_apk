package com.tencent.kinda.framework.sns_cross;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailUI;
import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI;
import com.tencent.mm.pluginsdk.wallet.PayInfo;

public class T2BUseCaseCallback
  implements ISnsUseCaseCallback
{
  private static final int REQ_DETAIL = 2;
  private SnsServiceBean mBean;
  
  public void call(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(18721);
    Object localObject1 = this.mBean.getContext();
    if ((localObject1 instanceof BankRemitMoneyInputUI))
    {
      Activity localActivity = (Activity)localObject1;
      if (paramITransmitKvData.getString("closeLoading").equals("1"))
      {
        ((BankRemitMoneyInputUI)localActivity).hideLoading();
        AppMethodBeat.o(18721);
        return;
      }
      int i = paramITransmitKvData.getInt("retcode");
      paramITransmitKvData = paramITransmitKvData.getString("transaction_id");
      if ((i == 1) && (this.mBean != null) && (this.mBean.getPayInfo() != null))
      {
        Object localObject2 = this.mBean.getPayInfo().iqp;
        if (localObject2 != null)
        {
          localObject2 = ((Bundle)localObject2).getString("key_transfer_bill_id");
          localObject1 = new Intent((Context)localObject1, BankRemitDetailUI.class);
          ((Intent)localObject1).putExtra("key_transfer_transaction_id", paramITransmitKvData);
          ((Intent)localObject1).putExtra("key_transfer_bill_id", (String)localObject2);
          ((Intent)localObject1).putExtra("key_enter_scene", 0);
          paramITransmitKvData = (BankRemitMoneyInputUI)localActivity;
          paramITransmitKvData.startActivityForResult((Intent)localObject1, 2);
          paramITransmitKvData.aDI(((Intent)localObject1).getStringExtra("key_transfer_transaction_id"));
          paramITransmitKvData.Cli = 1;
          paramITransmitKvData.doSceneProgress(new n(paramITransmitKvData.CkH, paramITransmitKvData.zfX, 1), false);
        }
      }
    }
    AppMethodBeat.o(18721);
  }
  
  public void setData(Context paramContext, PayInfo paramPayInfo)
  {
    AppMethodBeat.i(18720);
    this.mBean = new SnsServiceBean(paramContext, paramPayInfo);
    AppMethodBeat.o(18720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.sns_cross.T2BUseCaseCallback
 * JD-Core Version:    0.7.0.1
 */