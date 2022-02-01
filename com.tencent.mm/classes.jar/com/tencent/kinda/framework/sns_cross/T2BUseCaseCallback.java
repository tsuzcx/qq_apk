package com.tencent.kinda.framework.sns_cross;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    Object localObject = this.mBean.getContext();
    if ((localObject instanceof BankRemitMoneyInputUI))
    {
      Activity localActivity = (Activity)localObject;
      if (paramITransmitKvData.getString("closeLoading").equals("1"))
      {
        ((BankRemitMoneyInputUI)localActivity).hideLoading();
        AppMethodBeat.o(18721);
        return;
      }
      if ((paramITransmitKvData.getInt("retcode") == 1) && (this.mBean != null) && (this.mBean.getPayInfo() != null))
      {
        paramITransmitKvData = this.mBean.getPayInfo().hbR;
        if (paramITransmitKvData != null)
        {
          paramITransmitKvData = paramITransmitKvData.getString("key_transfer_bill_id");
          localObject = new Intent((Context)localObject, BankRemitDetailUI.class);
          ((Intent)localObject).putExtra("key_transfer_bill_id", paramITransmitKvData);
          ((Intent)localObject).putExtra("key_enter_scene", 0);
          localActivity.startActivityForResult((Intent)localObject, 2);
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